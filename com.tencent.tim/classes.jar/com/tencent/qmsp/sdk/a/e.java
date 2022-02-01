package com.tencent.qmsp.sdk.a;

import com.tencent.qmsp.sdk.f.k;

public class e
{
  public static byte[][] a;
  
  static
  {
    byte[] arrayOfByte1 = { 54, 115 };
    byte[] arrayOfByte2 = { 36, 102 };
    byte[] arrayOfByte3 = { 49, 121 };
    byte[] arrayOfByte4 = { 53, 126 };
    a = new byte[][] { arrayOfByte1, { 36, 121 }, { 33, 121 }, { 48, 121 }, { 39, 102 }, { 42, 102 }, arrayOfByte2, { 54, 102 }, arrayOfByte3, { 53, 118 }, { 40, 116 }, { 48, 116 }, arrayOfByte4, { 53, 99, -67 }, { 53, 99, -74 }, { 55, 120 }, { 55, 114 }, { 49, 104, -89 }, { 33, 100 }, { 33, 102 }, { 38, 121 }, { 49, 96 } };
  }
  
  public static String a(int paramInt)
  {
    return k.a(a[paramInt]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */