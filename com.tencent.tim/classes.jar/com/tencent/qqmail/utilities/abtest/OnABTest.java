package com.tencent.qqmail.utilities.abtest;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
@interface OnABTest
{
  boolean defaultOn() default false;
  
  Policy policy() default Policy.HALF;
  
  String task();
  
  public static enum Policy
  {
    HALF;
    
    private Policy() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.abtest.OnABTest
 * JD-Core Version:    0.7.0.1
 */