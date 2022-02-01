package com.google.common.reflect;

 enum TypeToken$TypeFilter$2
{
  TypeToken$TypeFilter$2()
  {
    super(str, i, null);
  }
  
  public boolean apply(TypeToken<?> paramTypeToken)
  {
    return paramTypeToken.getRawType().isInterface();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeToken.TypeFilter.2
 * JD-Core Version:    0.7.0.1
 */