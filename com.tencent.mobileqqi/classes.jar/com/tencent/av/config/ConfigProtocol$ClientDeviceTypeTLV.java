package com.tencent.av.config;

public class ConfigProtocol$ClientDeviceTypeTLV
  extends ConfigProtocol.TLVBase
{
  private short jdField_a_of_type_Short = 0;
  
  public ConfigProtocol$ClientDeviceTypeTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)1, (short)2);
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
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.ClientDeviceTypeTLV
 * JD-Core Version:    0.7.0.1
 */