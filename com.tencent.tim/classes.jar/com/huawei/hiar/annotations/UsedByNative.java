package com.huawei.hiar.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.CONSTRUCTOR})
public @interface UsedByNative
{
  String value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hiar.annotations.UsedByNative
 * JD-Core Version:    0.7.0.1
 */