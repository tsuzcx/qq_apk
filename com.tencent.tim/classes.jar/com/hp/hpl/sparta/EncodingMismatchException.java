package com.hp.hpl.sparta;

public class EncodingMismatchException
  extends ParseException
{
  private String declaredEncoding_;
  
  EncodingMismatchException(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, 0, paramString2.charAt(paramString2.length() - 1), paramString2, "encoding '" + paramString2 + "' declared instead of of " + paramString3 + " as expected");
    this.declaredEncoding_ = paramString2;
  }
  
  String getDeclaredEncoding()
  {
    return this.declaredEncoding_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.EncodingMismatchException
 * JD-Core Version:    0.7.0.1
 */