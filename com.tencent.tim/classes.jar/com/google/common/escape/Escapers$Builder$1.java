package com.google.common.escape;

import java.util.Map;

class Escapers$Builder$1
  extends ArrayBasedCharEscaper
{
  private final char[] replacementChars;
  
  Escapers$Builder$1(Escapers.Builder paramBuilder, Map paramMap, char paramChar1, char paramChar2)
  {
    super(paramMap, paramChar1, paramChar2);
    if (Escapers.Builder.access$100(this.this$0) != null) {}
    for (paramBuilder = Escapers.Builder.access$100(this.this$0).toCharArray();; paramBuilder = null)
    {
      this.replacementChars = paramBuilder;
      return;
    }
  }
  
  protected char[] escapeUnsafe(char paramChar)
  {
    return this.replacementChars;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.Escapers.Builder.1
 * JD-Core Version:    0.7.0.1
 */