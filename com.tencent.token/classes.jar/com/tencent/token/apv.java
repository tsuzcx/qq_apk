package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class apv
{
  public static <T extends JceStruct> T a(byte[] paramArrayOfByte, T paramT)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramT.recyle();
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("UTF-8");
      paramT.readFrom(paramArrayOfByte);
      return paramT;
    }
    catch (Exception paramArrayOfByte)
    {
      new StringBuilder("getJceStruct exception: ").append(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("UTF-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apv
 * JD-Core Version:    0.7.0.1
 */