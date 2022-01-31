package com.tencent.av.config;

public class ConfigProtocol$LocalLogUploadTLV
  extends ConfigProtocol.TLVBase
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public ConfigProtocol$LocalLogUploadTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)2, paramShort);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangString.length() < "2012/03/05/08,2012/03/05/20".length()) {
      return false;
    }
    this.b = this.jdField_a_of_type_JavaLangString.substring(0, 13);
    this.c = this.jdField_a_of_type_JavaLangString.substring(14, 13);
    return true;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer == null) || (paramByteBuffer.b() < c())) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramByteBuffer.a(c());
    return true;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public String b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.LocalLogUploadTLV
 * JD-Core Version:    0.7.0.1
 */