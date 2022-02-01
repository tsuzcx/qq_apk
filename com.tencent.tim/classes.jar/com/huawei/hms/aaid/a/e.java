package com.huawei.hms.aaid.a;

import android.content.Context;

public abstract class e
{
  private static String a()
  {
    return "2A57086C86EF54970C1E6EB37BFC72B1";
  }
  
  public static byte[] a(Context paramContext)
  {
    byte[] arrayOfByte1 = b.a(paramContext.getString(2131697508));
    paramContext = b.a(paramContext.getString(2131697507));
    byte[] arrayOfByte2 = b.a(a());
    return a(a(a(arrayOfByte1, paramContext), arrayOfByte2));
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      arrayOfByte = new byte[0];
      return arrayOfByte;
    }
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] >> 2));
      i += 1;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    Object localObject;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2.length == 0))
    {
      localObject = new byte[0];
      return localObject;
    }
    int j = paramArrayOfByte1.length;
    if (j != paramArrayOfByte2.length) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[j];
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= j) {
        break;
      }
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.a.e
 * JD-Core Version:    0.7.0.1
 */