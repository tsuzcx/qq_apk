package com.google.common.reflect;

import javax.annotation.Nullable;

 enum Types$ClassOwnership$1
{
  Types$ClassOwnership$1()
  {
    super(str, i, null);
  }
  
  @Nullable
  Class<?> getOwnerType(Class<?> paramClass)
  {
    return paramClass.getEnclosingClass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Types.ClassOwnership.1
 * JD-Core Version:    0.7.0.1
 */