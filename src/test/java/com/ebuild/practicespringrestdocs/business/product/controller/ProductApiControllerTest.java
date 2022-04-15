package com.ebuild.practicespringrestdocs.business.product.controller;

import static com.ebuild.practicespringrestdocs.business.product.controller.DocumentFormatGenerator.getDateTimeFormat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ebuild.practicespringrestdocs.business.product.controller.dto.ProductDto;
import com.ebuild.practicespringrestdocs.business.product.entity.ProductCategoryCode;
import com.ebuild.practicespringrestdocs.business.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@WebMvcTest(ProductApiController.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com")
public class ProductApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    void create() throws Exception {
        // given
        ProductDto.Res response = ProductDto.Res.builder()
            .id(1L)
            .categoryCode(ProductCategoryCode.BOOK)
            .amount(12000L)
            .name("상품 1")
            .saleStartAt(LocalDateTime.of(2022, 4, 20, 00, 00))
            .build();

        given(productService.create(any(ProductDto.Req.class)))
            .willReturn(response);

        // when
        ProductDto.Req req = ProductDto.Req.builder()
            .name("상품 1")
            .amount(12000L)
            .categoryCode("BOOK")
            .saleStartAt(LocalDateTime.of(2022, 4, 20, 00, 00))
            .build();

        ResultActions result = this.mockMvc.perform(
        post("/api/v1/products/")
            .content(objectMapper.writeValueAsString(req))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        );

        // then
        result.andExpect(status().isCreated())
            .andDo(
                document("product/create",
                    ApiDocumentUtils.getDocumentRequest(),
                    ApiDocumentUtils.getDocumentResponse(),
                    requestFields(
                        fieldWithPath("name").type(JsonFieldType.STRING).description("상품명"),
                        fieldWithPath("amount").type(JsonFieldType.NUMBER).description("가격"),
                        fieldWithPath("categoryCode").type(JsonFieldType.STRING).description("상품카테고리"),
                        fieldWithPath("saleStartAt").type(JsonFieldType.STRING).attributes(getDateTimeFormat()).description("판매시작일시").optional()
                    ),
                    responseFields(
                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("상품ID"),
                        fieldWithPath("name").type(JsonFieldType.STRING).description("상품명"),
                        fieldWithPath("amount").type(JsonFieldType.NUMBER).description("가격"),
                        fieldWithPath("categoryCode").type(JsonFieldType.STRING).description("상품카테고리"),
                        fieldWithPath("saleStartAt").type(JsonFieldType.STRING).description("판매시작일시")
                    )
                )
            );
    }

    @Test
    void test(){
        // given

        // when

        // then

    }
}
