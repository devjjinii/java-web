package com.jin.web.config;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestConfig {

    // login check (save, delete)
    boolean loginCheck() default false;
}
