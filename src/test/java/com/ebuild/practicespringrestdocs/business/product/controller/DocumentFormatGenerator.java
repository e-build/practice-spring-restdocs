package com.ebuild.practicespringrestdocs.business.product.controller;

import static org.springframework.restdocs.snippet.Attributes.key;

import org.springframework.restdocs.snippet.Attributes;

public interface DocumentFormatGenerator {

    static Attributes.Attribute getDateFormat() {
        return key("format").value("yyyy-MM-dd");
    }

    static Attributes.Attribute getDateTimeFormat() {
        return key("format").value("yyyy-MM-dd HH:mm:ss");
    }

}
