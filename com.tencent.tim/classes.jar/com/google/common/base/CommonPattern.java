package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract class CommonPattern
{
  public abstract boolean equals(Object paramObject);
  
  abstract int flags();
  
  public abstract int hashCode();
  
  abstract CommonMatcher matcher(CharSequence paramCharSequence);
  
  abstract String pattern();
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.CommonPattern
 * JD-Core Version:    0.7.0.1
 */