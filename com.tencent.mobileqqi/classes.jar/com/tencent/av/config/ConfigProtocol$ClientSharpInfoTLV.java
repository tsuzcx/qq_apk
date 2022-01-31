package com.tencent.av.config;

public class ConfigProtocol$ClientSharpInfoTLV
  extends ConfigProtocol.TLVBase
{
  private int jdField_a_of_type_Int = 0;
  
  public ConfigProtocol$ClientSharpInfoTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)9, (short)4);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    return false;
  }
  
  public byte[] a()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.a(this.jdField_a_of_type_Int);
    return localByteBuffer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.ClientSharpInfoTLV
 * JD-Core Version:    0.7.0.1
 */