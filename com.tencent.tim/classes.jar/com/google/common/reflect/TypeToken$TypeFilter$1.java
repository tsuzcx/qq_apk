package com.google.common.reflect;

import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

 enum TypeToken$TypeFilter$1
{
  TypeToken$TypeFilter$1()
  {
    super(str, i, null);
  }
  
  public boolean apply(TypeToken<?> paramTypeToken)
  {
    return (!(TypeToken.access$400(paramTypeToken) instanceof TypeVariable)) && (!(TypeToken.access$400(paramTypeToken) instanceof WildcardType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeToken.TypeFilter.1
 * JD-Core Version:    0.7.0.1
 */