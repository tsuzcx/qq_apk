package com.tencent.av.config;

import java.util.ArrayList;

public class ConfigProtocol$S2CConfigInfoProtocol
{
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private short jdField_a_of_type_Short = 0;
  private short b = 0;
  private short c = 0;
  
  public ConfigProtocol$S2CConfigInfoProtocol(ConfigProtocol paramConfigProtocol) {}
  
  public ConfigProtocol.TLVBase a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (ConfigProtocol.TLVBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public void a(ConfigProtocol.TLVBase paramTLVBase) {}
  
  public void a(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer == null) || (paramByteBuffer.b() < 39)) {}
    int i;
    label59:
    short s2;
    ConfigProtocol.TLVBase localTLVBase;
    do
    {
      return false;
      this.jdField_a_of_type_JavaLangString = paramByteBuffer.a(33);
      this.jdField_a_of_type_Short = paramByteBuffer.a();
      this.b = paramByteBuffer.a();
      this.c = paramByteBuffer.a();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      i = 0;
      if (paramByteBuffer.b() <= 0) {
        break label131;
      }
      short s1 = paramByteBuffer.a();
      s2 = paramByteBuffer.a();
      localTLVBase = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol.a(s1, s2);
      if (localTLVBase != null) {
        break;
      }
    } while (!paramByteBuffer.a(s2));
    for (;;)
    {
      i += 1;
      break label59;
      if (!localTLVBase.a(paramByteBuffer)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localTLVBase);
    }
    label131:
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.b = ((short)this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    return true;
  }
  
  public short b()
  {
    return this.b;
  }
  
  public void b(short paramShort)
  {
    this.b = paramShort;
  }
  
  public boolean b(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public short c()
  {
    return this.c;
  }
  
  public void c(short paramShort)
  {
    this.c = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.S2CConfigInfoProtocol
 * JD-Core Version:    0.7.0.1
 */