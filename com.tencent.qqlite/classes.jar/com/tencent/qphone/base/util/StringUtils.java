package com.tencent.qphone.base.util;

public class StringUtils
{
  public static String getIpAddrFromInt(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append(String.valueOf(paramInt >>> 24));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf((0xFFFFFF & paramInt) >>> 16));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf((0xFFFF & paramInt) >>> 8));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf(paramInt & 0xFF));
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.StringUtils
 * JD-Core Version:    0.7.0.1
 */