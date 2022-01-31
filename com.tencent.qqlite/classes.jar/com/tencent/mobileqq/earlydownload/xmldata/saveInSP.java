package com.tencent.mobileqq.earlydownload.xmldata;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface saveInSP
{
  boolean a() default false;
  
  boolean b() default false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.saveInSP
 * JD-Core Version:    0.7.0.1
 */