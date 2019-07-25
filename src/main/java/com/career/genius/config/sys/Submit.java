package com.career.genius.config.sys;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Submit {

    String prefix() default "prefix:";
}
