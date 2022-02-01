package com.tencent.map.sdk.a;

public final class pa
{
  public static int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | 0xFF00 & paramArrayOfByte[1] << 8 | 0xFF0000 & paramArrayOfByte[2] << 16 | 0xFF000000 & paramArrayOfByte[3] << 24;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString).trim();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)paramInt, (byte)(paramInt >> 8), (byte)(paramInt >> 16), (byte)(paramInt >> 24) };
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = paramString.getBytes("UTF-16LE");
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return new byte[0];
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-16LE").trim();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pa
 * JD-Core Version:    0.7.0.1
 */