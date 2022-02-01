package com.google.common.reflect;

import javax.annotation.Nullable;

final class TypeToken$TypeCollector$1
  extends TypeToken.TypeCollector<TypeToken<?>>
{
  TypeToken$TypeCollector$1()
  {
    super(null);
  }
  
  Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> paramTypeToken)
  {
    return paramTypeToken.getGenericInterfaces();
  }
  
  Class<?> getRawType(TypeToken<?> paramTypeToken)
  {
    return paramTypeToken.getRawType();
  }
  
  @Nullable
  TypeToken<?> getSuperclass(TypeToken<?> paramTypeToken)
  {
    return paramTypeToken.getGenericSuperclass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeToken.TypeCollector.1
 * JD-Core Version:    0.7.0.1
 */