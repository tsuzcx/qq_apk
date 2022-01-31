package com.tencent.av.config;

import android.util.Log;

public class ConfigProtocol$SharpInfoTLV
  extends ConfigProtocol.TLVBase
{
  private byte jdField_a_of_type_Byte;
  private short jdField_a_of_type_Short;
  private byte jdField_b_of_type_Byte;
  private short jdField_b_of_type_Short;
  private byte c;
  private byte d;
  private byte e;
  private byte f;
  
  public ConfigProtocol$SharpInfoTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)10, (short)16);
    this.jdField_b_of_type_Short = paramShort;
    this.jdField_a_of_type_Byte = 0;
    this.jdField_b_of_type_Byte = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.jdField_a_of_type_Short = 0;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    if ((this.jdField_b_of_type_Short != c()) || (paramByteBuffer.b() < this.jdField_b_of_type_Short)) {
      return false;
    }
    this.jdField_a_of_type_Byte = paramByteBuffer.a();
    this.jdField_b_of_type_Byte = paramByteBuffer.a();
    this.c = paramByteBuffer.a();
    this.d = paramByteBuffer.a();
    this.e = paramByteBuffer.a();
    this.f = paramByteBuffer.a();
    this.jdField_a_of_type_Short = paramByteBuffer.a();
    paramByteBuffer.a();
    paramByteBuffer.a();
    Log.d("sevenzhu", "SharpInfo " + this.jdField_a_of_type_Byte + " " + this.jdField_b_of_type_Byte + " " + this.c + " " + this.d + " " + this.e + " " + this.f + " " + this.jdField_a_of_type_Short);
    return true;
  }
  
  public byte[] a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.SharpInfoTLV
 * JD-Core Version:    0.7.0.1
 */