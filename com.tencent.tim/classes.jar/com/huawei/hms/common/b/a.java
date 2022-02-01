package com.huawei.hms.common.b;

import android.util.Base64;

public final class a
{
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return Base64.encodeToString(paramArrayOfByte, 10);
    }
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    if (paramString != null) {
      arrayOfByte = Base64.decode(paramString, 10);
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.b.a
 * JD-Core Version:    0.7.0.1
 */