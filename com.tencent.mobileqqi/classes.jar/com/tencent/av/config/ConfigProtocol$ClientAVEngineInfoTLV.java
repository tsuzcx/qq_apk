package com.tencent.av.config;

public class ConfigProtocol$ClientAVEngineInfoTLV
  extends ConfigProtocol.TLVBase
{
  private byte jdField_a_of_type_Byte;
  private short jdField_a_of_type_Short;
  private byte jdField_b_of_type_Byte;
  private short jdField_b_of_type_Short;
  
  public ConfigProtocol$ClientAVEngineInfoTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)7, (short)6);
  }
  
  void a(byte paramByte1, byte paramByte2, short paramShort1, short paramShort2)
  {
    this.jdField_a_of_type_Byte = paramByte1;
    this.jdField_b_of_type_Byte = paramByte2;
    this.jdField_a_of_type_Short = paramShort1;
    this.jdField_b_of_type_Short = paramShort2;
    c((short)6);
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public byte[] a()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.a(this.jdField_a_of_type_Byte);
    localByteBuffer.a(this.jdField_b_of_type_Byte);
    localByteBuffer.a(this.jdField_a_of_type_Short);
    localByteBuffer.a(this.jdField_b_of_type_Short);
    return localByteBuffer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.ClientAVEngineInfoTLV
 * JD-Core Version:    0.7.0.1
 */