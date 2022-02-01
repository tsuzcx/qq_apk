package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class ParseRequest
{
  final int radix;
  final String rawValue;
  
  private ParseRequest(String paramString, int paramInt)
  {
    this.rawValue = paramString;
    this.radix = paramInt;
  }
  
  static ParseRequest fromString(String paramString)
  {
    int i = 16;
    if (paramString.length() == 0) {
      throw new NumberFormatException("empty string");
    }
    int j = paramString.charAt(0);
    if ((paramString.startsWith("0x")) || (paramString.startsWith("0X"))) {
      paramString = paramString.substring(2);
    }
    for (;;)
    {
      return new ParseRequest(paramString, i);
      if (j == 35)
      {
        paramString = paramString.substring(1);
      }
      else if ((j == 48) && (paramString.length() > 1))
      {
        paramString = paramString.substring(1);
        i = 8;
      }
      else
      {
        i = 10;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.ParseRequest
 * JD-Core Version:    0.7.0.1
 */