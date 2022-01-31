package com.tencent.av.config;

import java.io.UnsupportedEncodingException;

public class ConfigProtocol$EngineVersionTLV
  extends ConfigProtocol.TLVBase
{
  private String jdField_a_of_type_JavaLangString;
  
  public ConfigProtocol$EngineVersionTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)4, paramShort);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    short s = (short)paramString.length();
    try
    {
      int i = this.jdField_a_of_type_JavaLangString.getBytes("GBK").length;
      s = (short)i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    c(s);
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public byte[] a()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.a(this.jdField_a_of_type_JavaLangString);
    return localByteBuffer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.EngineVersionTLV
 * JD-Core Version:    0.7.0.1
 */