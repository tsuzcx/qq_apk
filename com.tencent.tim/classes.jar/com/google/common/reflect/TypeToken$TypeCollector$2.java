package com.google.common.reflect;

import java.util.Arrays;
import javax.annotation.Nullable;

final class TypeToken$TypeCollector$2
  extends TypeToken.TypeCollector<Class<?>>
{
  TypeToken$TypeCollector$2()
  {
    super(null);
  }
  
  Iterable<? extends Class<?>> getInterfaces(Class<?> paramClass)
  {
    return Arrays.asList(paramClass.getInterfaces());
  }
  
  Class<?> getRawType(Class<?> paramClass)
  {
    return paramClass;
  }
  
  @Nullable
  Class<?> getSuperclass(Class<?> paramClass)
  {
    return paramClass.getSuperclass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeToken.TypeCollector.2
 * JD-Core Version:    0.7.0.1
 */