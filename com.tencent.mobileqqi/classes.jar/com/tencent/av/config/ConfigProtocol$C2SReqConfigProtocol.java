package com.tencent.av.config;

import java.util.ArrayList;

public class ConfigProtocol$C2SReqConfigProtocol
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private short jdField_a_of_type_Short = 1;
  private short b = 0;
  private short c = 0;
  
  public ConfigProtocol$C2SReqConfigProtocol(ConfigProtocol paramConfigProtocol) {}
  
  public ByteBuffer a()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.a(this.jdField_a_of_type_Short);
    localByteBuffer.a(this.b);
    localByteBuffer.a(this.c);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localByteBuffer.a(((ConfigProtocol.TLVBase)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b());
      localByteBuffer.a(((ConfigProtocol.TLVBase)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c());
      localByteBuffer.a(((ConfigProtocol.TLVBase)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
      i += 1;
    }
    return localByteBuffer;
  }
  
  public ConfigProtocol.TLVBase a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (ConfigProtocol.TLVBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public void a(ConfigProtocol.TLVBase paramTLVBase)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTLVBase);
    this.c = ((short)(this.c + 4));
    this.c = ((short)(this.c + paramTLVBase.c()));
    this.b = ((short)(this.b + 1));
  }
  
  public void a(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    this.jdField_a_of_type_Short = paramByteBuffer.a();
    this.b = paramByteBuffer.a();
    this.c = paramByteBuffer.a();
    return this.c == paramByteBuffer.b();
  }
  
  public short b()
  {
    return this.b;
  }
  
  public void b(short paramShort)
  {
    this.b = paramShort;
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
 * Qualified Name:     com.tencent.av.config.ConfigProtocol.C2SReqConfigProtocol
 * JD-Core Version:    0.7.0.1
 */