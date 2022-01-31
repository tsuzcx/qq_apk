package com.tencent.av.config;

public class ConfigProtocol$ConnForbidTypeTLV
  extends ConfigProtocol.TLVBase
{
  private short jdField_a_of_type_Short = 0;
  
  public ConfigProtocol$ConnForbidTypeTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)5, (short)2);
  }
  
  public short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer == null) || (paramByteBuffer.b() < 2)) {
      return false;
    }
    this.jdField_a_of_type_Short = paramByteBuffer.a();
    return true;
  }
  
  public byte[] a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.ConnForbidTypeTLV
 * JD-Core Version:    0.7.0.1
 */