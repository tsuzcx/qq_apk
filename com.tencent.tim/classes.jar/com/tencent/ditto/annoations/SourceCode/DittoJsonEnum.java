package com.tencent.ditto.annoations.SourceCode;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DittoJsonEnum
{
  String[] value() default {};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.annoations.SourceCode.DittoJsonEnum
 * JD-Core Version:    0.7.0.1
 */