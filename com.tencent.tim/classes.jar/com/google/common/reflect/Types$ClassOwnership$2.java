package com.google.common.reflect;

import javax.annotation.Nullable;

 enum Types$ClassOwnership$2
{
  Types$ClassOwnership$2()
  {
    super(str, i, null);
  }
  
  @Nullable
  Class<?> getOwnerType(Class<?> paramClass)
  {
    if (paramClass.isLocalClass()) {
      return null;
    }
    return paramClass.getEnclosingClass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Types.ClassOwnership.2
 * JD-Core Version:    0.7.0.1
 */