package com.tencent.mobileqq.data;

import java.io.UnsupportedEncodingException;

public class MusicShare
{
  public String xml = "";
  
  public byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte = this.xml.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MusicShare
 * JD-Core Version:    0.7.0.1
 */