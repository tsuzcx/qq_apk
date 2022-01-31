package com.tencent.av.config;

public class ConfigProtocol$VideoEngineNeedInfoTLV
  extends ConfigProtocol.TLVBase
{
  private byte jdField_a_of_type_Byte;
  private short jdField_a_of_type_Short;
  private byte jdField_b_of_type_Byte;
  private short jdField_b_of_type_Short;
  private short c;
  private short d;
  private short e;
  private short f;
  private short g;
  
  public ConfigProtocol$VideoEngineNeedInfoTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)6, (short)14);
    this.jdField_a_of_type_Short = paramShort;
    this.jdField_b_of_type_Short = 0;
    this.jdField_a_of_type_Byte = 0;
    this.jdField_b_of_type_Byte = 0;
    this.c = 0;
    this.e = 0;
    this.d = 0;
    this.f = 0;
  }
  
  public byte a()
  {
    return this.jdField_a_of_type_Byte;
  }
  
  public short a()
  {
    return this.jdField_b_of_type_Short;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    if ((this.jdField_a_of_type_Short != c()) || (paramByteBuffer.b() < this.jdField_a_of_type_Short)) {
      return false;
    }
    this.jdField_b_of_type_Short = paramByteBuffer.a();
    this.c = paramByteBuffer.a();
    this.jdField_a_of_type_Byte = paramByteBuffer.a();
    this.jdField_b_of_type_Byte = paramByteBuffer.a();
    this.d = paramByteBuffer.a();
    this.e = paramByteBuffer.a();
    this.f = paramByteBuffer.a();
    this.g = paramByteBuffer.a();
    return true;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public byte b()
  {
    return this.jdField_b_of_type_Byte;
  }
  
  public short d()
  {
    return this.c;
  }
  
  public short e()
  {
    return this.d;
  }
  
  public short f()
  {
    return this.e;
  }
  
  public short g()
  {
    return this.g;
  }
  
  public short h()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.VideoEngineNeedInfoTLV
 * JD-Core Version:    0.7.0.1
 */