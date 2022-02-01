package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class asu
{
  public static JceStruct a(byte[] paramArrayOfByte, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    paramJceStruct.recyle();
    paramJceStruct.readFrom(b(paramArrayOfByte));
    return paramJceStruct;
  }
  
  public static ba a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramArrayOfByte, new ba());
    if (paramArrayOfByte == null) {
      return null;
    }
    return (ba)paramArrayOfByte;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("UTF-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  private static JceInputStream b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("UTF-8");
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asu
 * JD-Core Version:    0.7.0.1
 */