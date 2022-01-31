package com.tencent.smtt.sdk.stat;

import java.lang.reflect.Array;

public class DesUtils
{
  private static final int[] E;
  public static final int FLAG_DECRYPT = 0;
  public static final int FLAG_ENCRYPT = 1;
  private static final int[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };
  private static final int[] IP_1 = { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 };
  public static final byte[] KEY = { -25, -101, -115, 1, 47, 7, -27, -59, 18, -128, 123, 79, -44, 37, 46, 115 };
  private static final int[] LeftMove;
  public static final byte[] MAC_KEY = { 37, -110, 60, 127, 42, -27, -17, -110 };
  public static final byte[] MTT_KEY = { -122, -8, -23, -84, -125, 113, 84, 99 };
  private static final int[] P;
  private static final int[] PC_1 = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4 };
  private static final int[] PC_2 = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };
  public static final byte[] QQMARKET_KEY = "AL!#$AC9Ahg@KLJ1".getBytes();
  public static final byte[] REPORT_KEY_TEA;
  private static final int[][][] S_Box;
  
  static
  {
    E = new int[] { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 };
    P = new int[] { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 };
    int[] arrayOfInt2 = { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 };
    int[] arrayOfInt3 = { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 };
    int[] arrayOfInt5 = { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 };
    int[] arrayOfInt1 = { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 };
    int[] arrayOfInt8 = { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 };
    int[] arrayOfInt9 = { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 };
    int[] arrayOfInt10 = { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 };
    int[] arrayOfInt11 = { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 };
    int[] arrayOfInt6 = { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 };
    int[] arrayOfInt7 = { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 };
    int[] arrayOfInt4 = { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 };
    S_Box = new int[][][] { { { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 }, { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 }, arrayOfInt2, arrayOfInt3 }, { { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 }, { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 }, { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 }, { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } }, { { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 }, { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 }, { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 }, { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } }, { { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 }, arrayOfInt5, { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 }, { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } }, { { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 }, arrayOfInt1, { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 }, { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } }, { arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11 }, { arrayOfInt6, arrayOfInt7, { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 }, { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } }, { { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 }, { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 }, { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 }, arrayOfInt4 } };
    LeftMove = new int[] { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };
    REPORT_KEY_TEA = new byte[] { 98, -24, 57, -84, -115, 117, 55, 121 };
  }
  
  private static byte[] ByteDataFormat(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = 8 - i % 8;
    int k = i + j;
    byte[] arrayOfByte = new byte[k];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    while (i < k)
    {
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] DesEncrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null)) {
      return paramArrayOfByte2;
    }
    try
    {
      paramArrayOfByte1 = KeyDataFormat(paramArrayOfByte1);
      byte[] arrayOfByte2 = ByteDataFormat(paramArrayOfByte2);
      int i = arrayOfByte2.length;
      int j = i / 8;
      byte[] arrayOfByte1 = new byte[i];
      i = 0;
      while (i < j)
      {
        byte[] arrayOfByte3 = new byte[8];
        byte[] arrayOfByte4 = new byte[8];
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte3, 0, 8);
        System.arraycopy(arrayOfByte2, i * 8, arrayOfByte4, 0, 8);
        System.arraycopy(UnitDes(arrayOfByte3, arrayOfByte4, paramInt), 0, arrayOfByte1, i * 8, 8);
        i += 1;
      }
      paramArrayOfByte1 = arrayOfByte1;
      int k;
      if (paramInt == 0)
      {
        arrayOfByte2 = new byte[paramArrayOfByte2.length];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
        k = arrayOfByte2[(arrayOfByte2.length - 1)];
        paramArrayOfByte1 = arrayOfByte1;
        if (k > 0)
        {
          paramArrayOfByte1 = arrayOfByte1;
          if (k <= 8)
          {
            j = 1;
            paramInt = 0;
          }
        }
      }
      for (;;)
      {
        i = j;
        if (paramInt < k)
        {
          if (k != arrayOfByte2[(arrayOfByte2.length - 1 - paramInt)]) {
            i = 0;
          }
        }
        else
        {
          paramArrayOfByte1 = arrayOfByte1;
          if (i != 0)
          {
            paramArrayOfByte1 = new byte[arrayOfByte2.length - k];
            System.arraycopy(arrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length);
          }
          return paramArrayOfByte1;
        }
        paramInt += 1;
      }
      return paramArrayOfByte2;
    }
    catch (Exception paramArrayOfByte1) {}
  }
  
  private static byte[] Encrypt(int[] paramArrayOfInt, int paramInt, int[][] paramArrayOfInt1)
  {
    byte[] arrayOfByte = new byte[8];
    int[] arrayOfInt1 = new int[64];
    int[] arrayOfInt2 = new int[64];
    int i = 0;
    while (i < 64)
    {
      arrayOfInt1[i] = paramArrayOfInt[(IP[i] - 1)];
      i += 1;
    }
    if (paramInt == 1)
    {
      i = 0;
      while (i < 16)
      {
        LoopF(arrayOfInt1, i, paramInt, paramArrayOfInt1);
        i += 1;
      }
    }
    if (paramInt == 0)
    {
      i = 15;
      while (i > -1)
      {
        LoopF(arrayOfInt1, i, paramInt, paramArrayOfInt1);
        i -= 1;
      }
    }
    paramInt = 0;
    while (paramInt < 64)
    {
      arrayOfInt2[paramInt] = arrayOfInt1[(IP_1[paramInt] - 1)];
      paramInt += 1;
    }
    GetEncryptResultOfByteArray(arrayOfInt2, arrayOfByte);
    return arrayOfByte;
  }
  
  private static void GetEncryptResultOfByteArray(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < 8)
    {
      int j = 0;
      while (j < 8)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] + (paramArrayOfInt[((i << 3) + j)] << 7 - j)));
        j += 1;
      }
      i += 1;
    }
  }
  
  private static byte[] KeyDataFormat(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = 0;
      i += 1;
    }
    if (paramArrayOfByte.length > 8)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  private static void KeyInitialize(int[] paramArrayOfInt, int[][] paramArrayOfInt1)
  {
    int[] arrayOfInt = new int[56];
    int i = 0;
    while (i < 56)
    {
      arrayOfInt[i] = paramArrayOfInt[(PC_1[i] - 1)];
      i += 1;
    }
    i = 0;
    while (i < 16)
    {
      LeftBitMove(arrayOfInt, LeftMove[i]);
      int j = 0;
      while (j < 48)
      {
        paramArrayOfInt1[i][j] = arrayOfInt[(PC_2[j] - 1)];
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void LeftBitMove(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt1 = new int[28];
    int[] arrayOfInt2 = new int[28];
    int[] arrayOfInt3 = new int[28];
    int[] arrayOfInt4 = new int[28];
    int i = 0;
    while (i < 28)
    {
      arrayOfInt1[i] = paramArrayOfInt[i];
      arrayOfInt2[i] = paramArrayOfInt[(i + 28)];
      i += 1;
    }
    if (paramInt == 1)
    {
      paramInt = 0;
      while (paramInt < 27)
      {
        arrayOfInt3[paramInt] = arrayOfInt1[(paramInt + 1)];
        arrayOfInt4[paramInt] = arrayOfInt2[(paramInt + 1)];
        paramInt += 1;
      }
      arrayOfInt3[27] = arrayOfInt1[0];
      arrayOfInt4[27] = arrayOfInt2[0];
    }
    for (;;)
    {
      paramInt = 0;
      while (paramInt < 28)
      {
        paramArrayOfInt[paramInt] = arrayOfInt3[paramInt];
        paramArrayOfInt[(paramInt + 28)] = arrayOfInt4[paramInt];
        paramInt += 1;
      }
      if (paramInt == 2)
      {
        paramInt = 0;
        while (paramInt < 26)
        {
          arrayOfInt3[paramInt] = arrayOfInt1[(paramInt + 2)];
          arrayOfInt4[paramInt] = arrayOfInt2[(paramInt + 2)];
          paramInt += 1;
        }
        arrayOfInt3[26] = arrayOfInt1[0];
        arrayOfInt4[26] = arrayOfInt2[0];
        arrayOfInt3[27] = arrayOfInt1[1];
        arrayOfInt4[27] = arrayOfInt2[1];
      }
    }
  }
  
  private static void LoopF(int[] paramArrayOfInt, int paramInt1, int paramInt2, int[][] paramArrayOfInt1)
  {
    int[] arrayOfInt1 = new int[32];
    int[] arrayOfInt2 = new int[32];
    int[] arrayOfInt3 = new int[32];
    int[] arrayOfInt4 = new int[32];
    int[] arrayOfInt5 = new int[48];
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 8, 6 });
    int[] arrayOfInt6 = new int[8];
    int[] arrayOfInt7 = new int[32];
    int[] arrayOfInt8 = new int[32];
    int i = 0;
    while (i < 32)
    {
      arrayOfInt1[i] = paramArrayOfInt[i];
      arrayOfInt2[i] = paramArrayOfInt[(i + 32)];
      i += 1;
    }
    i = 0;
    while (i < 48)
    {
      arrayOfInt5[i] = arrayOfInt2[(E[i] - 1)];
      arrayOfInt5[i] += paramArrayOfInt1[paramInt1][i];
      if (arrayOfInt5[i] == 2) {
        arrayOfInt5[i] = 0;
      }
      i += 1;
    }
    i = 0;
    while (i < 8)
    {
      int j = 0;
      while (j < 6)
      {
        arrayOfInt[i][j] = arrayOfInt5[(i * 6 + j)];
        j += 1;
      }
      arrayOfInt6[i] = S_Box[i][((arrayOfInt[i][0] << 1) + arrayOfInt[i][5])][((arrayOfInt[i][1] << 3) + (arrayOfInt[i][2] << 2) + (arrayOfInt[i][3] << 1) + arrayOfInt[i][4])];
      j = 0;
      while (j < 4)
      {
        arrayOfInt7[(i * 4 + 3 - j)] = (arrayOfInt6[i] % 2);
        arrayOfInt6[i] /= 2;
        j += 1;
      }
      i += 1;
    }
    i = 0;
    if (i < 32)
    {
      arrayOfInt8[i] = arrayOfInt7[(P[i] - 1)];
      arrayOfInt3[i] = arrayOfInt2[i];
      arrayOfInt1[i] += arrayOfInt8[i];
      if (arrayOfInt4[i] == 2) {
        arrayOfInt4[i] = 0;
      }
      if (((paramInt2 == 0) && (paramInt1 == 0)) || ((paramInt2 == 1) && (paramInt1 == 15)))
      {
        paramArrayOfInt[i] = arrayOfInt4[i];
        paramArrayOfInt[(i + 32)] = arrayOfInt3[i];
      }
      for (;;)
      {
        i += 1;
        break;
        paramArrayOfInt[i] = arrayOfInt3[i];
        paramArrayOfInt[(i + 32)] = arrayOfInt4[i];
      }
    }
  }
  
  private static int[] ReadDataToBirnaryIntArray(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfInt[i] = paramArrayOfByte[i];
      if (arrayOfInt[i] < 0)
      {
        arrayOfInt[i] += 256;
        arrayOfInt[i] %= 256;
      }
      i += 1;
    }
    paramArrayOfByte = new int[64];
    i = 0;
    while (i < 8)
    {
      int j = 0;
      while (j < 8)
      {
        paramArrayOfByte[(i * 8 + 7 - j)] = (arrayOfInt[i] % 2);
        arrayOfInt[i] /= 2;
        j += 1;
      }
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  private static byte[] UnitDes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte1.length != 8) || (paramArrayOfByte2.length != 8) || ((paramInt != 1) && (paramInt != 0))) {
      throw new RuntimeException("Data Format Error !");
    }
    Object localObject = new int[64];
    localObject = new int[64];
    localObject = new byte[8];
    localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 16, 48 });
    paramArrayOfByte1 = ReadDataToBirnaryIntArray(paramArrayOfByte1);
    paramArrayOfByte2 = ReadDataToBirnaryIntArray(paramArrayOfByte2);
    KeyInitialize(paramArrayOfByte1, (int[][])localObject);
    return Encrypt(paramArrayOfByte2, paramInt, (int[][])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.DesUtils
 * JD-Core Version:    0.7.0.1
 */