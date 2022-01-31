package com.tencent.av.config;

public abstract class ConfigProtocol$TLVBase
{
  private short a;
  private short jdField_b_of_type_Short;
  
  public ConfigProtocol$TLVBase(ConfigProtocol paramConfigProtocol, short paramShort1, short paramShort2)
  {
    this.a = paramShort1;
    this.jdField_b_of_type_Short = paramShort2;
  }
  
  public abstract boolean a(ByteBuffer paramByteBuffer);
  
  public abstract byte[] a();
  
  public short b()
  {
    return this.a;
  }
  
  public void b(short paramShort)
  {
    this.a = paramShort;
  }
  
  public short c()
  {
    return this.jdField_b_of_type_Short;
  }
  
  public void c(short paramShort)
  {
    this.jdField_b_of_type_Short = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.TLVBase
 * JD-Core Version:    0.7.0.1
 */