package com.hp.hpl.sparta;

public class DOMException
  extends Exception
{
  public static final short DOMSTRING_SIZE_ERR = 2;
  public static final short HIERARCHY_REQUEST_ERR = 3;
  public static final short NOT_FOUND_ERR = 8;
  public short code;
  
  public DOMException(short paramShort, String paramString)
  {
    super(paramString);
    this.code = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.DOMException
 * JD-Core Version:    0.7.0.1
 */