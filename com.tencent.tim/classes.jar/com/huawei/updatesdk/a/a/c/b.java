package com.huawei.updatesdk.a.a.c;

import java.io.UnsupportedEncodingException;

public class b
{
  private byte[] a = null;
  private int b = 1024;
  private int c = 0;
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 70;
    tmp94_88;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return String.valueOf(arrayOfChar2);
  }
  
  public String a()
  {
    if (this.c <= 0) {
      return null;
    }
    try
    {
      String str = new String(this.a, 0, this.c, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (this.a.length - this.c >= paramInt) {
      System.arraycopy(paramArrayOfByte, 0, this.a, this.c, paramInt);
    }
    for (;;)
    {
      this.c += paramInt;
      return;
      byte[] arrayOfByte = new byte[this.a.length + paramInt << 1];
      System.arraycopy(this.a, 0, arrayOfByte, 0, this.c);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.c, paramInt);
      this.a = arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.b
 * JD-Core Version:    0.7.0.1
 */