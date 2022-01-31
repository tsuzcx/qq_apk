package com.tencent.av.config;

import android.util.Log;

public class ConfigProtocol$AVSwitchTypeTLV
  extends ConfigProtocol.TLVBase
{
  private byte jdField_a_of_type_Byte = 1;
  private byte b = 0;
  
  public ConfigProtocol$AVSwitchTypeTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)11, (short)1);
  }
  
  public byte a()
  {
    return this.jdField_a_of_type_Byte;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer != null) && (paramByteBuffer.b() > 0))
    {
      int i = paramByteBuffer.a();
      if (i >= 0)
      {
        this.jdField_a_of_type_Byte = ((byte)(i & 0x1));
        this.b = ((byte)(i >> 1 & 0x1));
        Log.d("simonchwang", "m_bIsAuidoEnable:" + this.jdField_a_of_type_Byte + "m_bIsOpenMaxEnable:" + this.b);
        return true;
      }
    }
    return false;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public byte b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.AVSwitchTypeTLV
 * JD-Core Version:    0.7.0.1
 */