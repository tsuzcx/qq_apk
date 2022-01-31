package com.tencent.av.config;

public class ConfigProtocol$ClientHardWareInfoTLV
  extends ConfigProtocol.TLVBase
{
  private int jdField_a_of_type_Int;
  private short jdField_a_of_type_Short;
  private short b;
  private short c;
  
  public ConfigProtocol$ClientHardWareInfoTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)6, (short)10);
  }
  
  public void a(short paramShort1, short paramShort2, int paramInt, short paramShort3)
  {
    this.jdField_a_of_type_Short = paramShort1;
    this.b = paramShort2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramShort3;
    c((short)10);
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public byte[] a()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.a(this.jdField_a_of_type_Short);
    localByteBuffer.a(this.b);
    localByteBuffer.a(this.jdField_a_of_type_Int);
    localByteBuffer.a(this.c);
    return localByteBuffer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.ClientHardWareInfoTLV
 * JD-Core Version:    0.7.0.1
 */