package com.google.common.escape;

import com.google.common.base.Preconditions;

final class Escapers$1
  extends CharEscaper
{
  public String escape(String paramString)
  {
    return (String)Preconditions.checkNotNull(paramString);
  }
  
  protected char[] escape(char paramChar)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.Escapers.1
 * JD-Core Version:    0.7.0.1
 */