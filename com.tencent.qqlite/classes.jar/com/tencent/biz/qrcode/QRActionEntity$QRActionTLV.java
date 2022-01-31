package com.tencent.biz.qrcode;

import com.tencent.biz.qrcode.util.QRUtils;

public class QRActionEntity$QRActionTLV
{
  int jdField_a_of_type_Int = 0;
  short jdField_a_of_type_Short = 0;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  
  public QRActionEntity$QRActionTLV() {}
  
  public QRActionEntity$QRActionTLV(int paramInt, short paramShort, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfByte.length + 4;
  }
  
  public long a()
  {
    return QRUtils.a(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public String a()
  {
    return new String(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public String toString()
  {
    return String.format("{t: %s, l: %s, v: %s}", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Short.valueOf(this.jdField_a_of_type_Short), this.jdField_a_of_type_ArrayOfByte });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.QRActionEntity.QRActionTLV
 * JD-Core Version:    0.7.0.1
 */