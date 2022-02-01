package com.tencent.qapmsdk.impl.instrumentation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD})
public @interface QAPMWrapReturn
{
  String className();
  
  String methodDesc();
  
  String methodName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMWrapReturn
 * JD-Core Version:    0.7.0.1
 */