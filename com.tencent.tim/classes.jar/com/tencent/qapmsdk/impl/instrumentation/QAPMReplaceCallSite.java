package com.tencent.qapmsdk.impl.instrumentation;

import java.lang.annotation.Annotation;

public @interface QAPMReplaceCallSite
{
  boolean isStatic() default false;
  
  String scope() default "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMReplaceCallSite
 * JD-Core Version:    0.7.0.1
 */