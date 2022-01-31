package com.tencent.av.config;

public class ConfigProtocol$ClientOSTypeTLV
  extends ConfigProtocol.TLVBase
{
  private short jdField_a_of_type_Short;
  
  public ConfigProtocol$ClientOSTypeTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)2, (short)2);
    a((short)0);
  }
  
  public void a(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public byte[] a()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.a(this.jdField_a_of_type_Short);
    return localByteBuffer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.ClientOSTypeTLV
 * JD-Core Version:    0.7.0.1
 */