package com.tool.annotion;

import java.lang.annotation.*;

/**
 * @author: impactCn
 * @createTime: 2020-12-22
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE,ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.ANNOTATION_TYPE})
public @interface NotNull {
}
