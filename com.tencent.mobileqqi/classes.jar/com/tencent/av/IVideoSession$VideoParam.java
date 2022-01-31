package com.tencent.av;

import com.tencent.mobileqq.utils.httputils.PkgTools;

public class IVideoSession$VideoParam
{
  private static short jdField_a_of_type_Short = 28;
  int jdField_a_of_type_Int;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_a_of_type_Int = paramInt7;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[jdField_a_of_type_Short];
    PkgTools.a(arrayOfByte, 0, this.jdField_a_of_type_Int);
    PkgTools.a(arrayOfByte, 4, this.b);
    PkgTools.a(arrayOfByte, 8, this.c);
    PkgTools.a(arrayOfByte, 12, this.d);
    PkgTools.a(arrayOfByte, 16, this.e);
    PkgTools.a(arrayOfByte, 20, this.f);
    PkgTools.a(arrayOfByte, 24, this.g);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.IVideoSession.VideoParam
 * JD-Core Version:    0.7.0.1
 */