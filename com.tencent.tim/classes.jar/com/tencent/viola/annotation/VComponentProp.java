package com.tencent.viola.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface VComponentProp
{
  public static final String NOT_INIT = "NOTINIT";
  
  boolean initToHostView() default false;
  
  String name();
  
  String nativeReturnMethod() default "NOTINIT";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.annotation.VComponentProp
 * JD-Core Version:    0.7.0.1
 */