package com.tencent.av.config;

public class ConfigProtocol$WriteLocalLogTLV
  extends ConfigProtocol.TLVBase
{
  private short jdField_a_of_type_Short = 0;
  
  public ConfigProtocol$WriteLocalLogTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)1, (short)2);
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
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.WriteLocalLogTLV
 * JD-Core Version:    0.7.0.1
 */