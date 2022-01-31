package com.tencent.av.config;

import java.util.ArrayList;

public class ConfigProtocol$RelaySvrUDPCheckTLV
  extends ConfigProtocol.TLVBase
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ConfigProtocol$RelaySvrUDPCheckTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)3, paramShort);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public ConfigProtocol.stNetAddress a(int paramInt)
  {
    if ((paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (paramInt < 0)) {
      return null;
    }
    return (ConfigProtocol.stNetAddress)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    int i = 0;
    if (paramByteBuffer == null) {}
    int k;
    int j;
    do
    {
      do
      {
        return false;
        k = c();
      } while (k < 2);
      j = paramByteBuffer.a();
    } while (j != (k - 2) / 6);
    while (i < j)
    {
      k = paramByteBuffer.a();
      short s = paramByteBuffer.a();
      ConfigProtocol.stNetAddress localstNetAddress = new ConfigProtocol.stNetAddress(this.jdField_a_of_type_ComTencentAvConfigConfigProtocol);
      localstNetAddress.jdField_a_of_type_Int = k;
      localstNetAddress.jdField_a_of_type_Short = s;
      this.jdField_a_of_type_JavaUtilArrayList.add(localstNetAddress);
      i += 1;
    }
    return true;
  }
  
  public byte[] a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.RelaySvrUDPCheckTLV
 * JD-Core Version:    0.7.0.1
 */