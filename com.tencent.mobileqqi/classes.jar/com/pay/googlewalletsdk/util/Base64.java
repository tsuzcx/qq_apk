package com.pay.googlewalletsdk.util;

public class Base64
{
  private static final byte[] ALPHABET;
  private static final byte[] DECODABET;
  public static final boolean DECODE = false;
  public static final boolean ENCODE = true;
  private static final byte EQUALS_SIGN = 61;
  private static final byte EQUALS_SIGN_ENC = -1;
  private static final byte NEW_LINE = 10;
  private static final byte[] WEBSAFE_ALPHABET;
  private static final byte[] WEBSAFE_DECODABET;
  private static final byte WHITE_SPACE_ENC = -5;
  
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      WEBSAFE_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      byte[] arrayOfByte = new byte[''];
      arrayOfByte[0] = -9;
      arrayOfByte[1] = -9;
      arrayOfByte[2] = -9;
      arrayOfByte[3] = -9;
      arrayOfByte[4] = -9;
      arrayOfByte[5] = -9;
      arrayOfByte[6] = -9;
      arrayOfByte[7] = -9;
      arrayOfByte[8] = -9;
      arrayOfByte[9] = -5;
      arrayOfByte[10] = -5;
      arrayOfByte[11] = -9;
      arrayOfByte[12] = -9;
      arrayOfByte[13] = -5;
      arrayOfByte[14] = -9;
      arrayOfByte[15] = -9;
      arrayOfByte[16] = -9;
      arrayOfByte[17] = -9;
      arrayOfByte[18] = -9;
      arrayOfByte[19] = -9;
      arrayOfByte[20] = -9;
      arrayOfByte[21] = -9;
      arrayOfByte[22] = -9;
      arrayOfByte[23] = -9;
      arrayOfByte[24] = -9;
      arrayOfByte[25] = -9;
      arrayOfByte[26] = -9;
      arrayOfByte[27] = -9;
      arrayOfByte[28] = -9;
      arrayOfByte[29] = -9;
      arrayOfByte[30] = -9;
      arrayOfByte[31] = -9;
      arrayOfByte[32] = -5;
      arrayOfByte[33] = -9;
      arrayOfByte[34] = -9;
      arrayOfByte[35] = -9;
      arrayOfByte[36] = -9;
      arrayOfByte[37] = -9;
      arrayOfByte[38] = -9;
      arrayOfByte[39] = -9;
      arrayOfByte[40] = -9;
      arrayOfByte[41] = -9;
      arrayOfByte[42] = -9;
      arrayOfByte[43] = 62;
      arrayOfByte[44] = -9;
      arrayOfByte[45] = -9;
      arrayOfByte[46] = -9;
      arrayOfByte[47] = 63;
      arrayOfByte[48] = 52;
      arrayOfByte[49] = 53;
      arrayOfByte[50] = 54;
      arrayOfByte[51] = 55;
      arrayOfByte[52] = 56;
      arrayOfByte[53] = 57;
      arrayOfByte[54] = 58;
      arrayOfByte[55] = 59;
      arrayOfByte[56] = 60;
      arrayOfByte[57] = 61;
      arrayOfByte[58] = -9;
      arrayOfByte[59] = -9;
      arrayOfByte[60] = -9;
      arrayOfByte[61] = -1;
      arrayOfByte[62] = -9;
      arrayOfByte[63] = -9;
      arrayOfByte[64] = -9;
      arrayOfByte[66] = 1;
      arrayOfByte[67] = 2;
      arrayOfByte[68] = 3;
      arrayOfByte[69] = 4;
      arrayOfByte[70] = 5;
      arrayOfByte[71] = 6;
      arrayOfByte[72] = 7;
      arrayOfByte[73] = 8;
      arrayOfByte[74] = 9;
      arrayOfByte[75] = 10;
      arrayOfByte[76] = 11;
      arrayOfByte[77] = 12;
      arrayOfByte[78] = 13;
      arrayOfByte[79] = 14;
      arrayOfByte[80] = 15;
      arrayOfByte[81] = 16;
      arrayOfByte[82] = 17;
      arrayOfByte[83] = 18;
      arrayOfByte[84] = 19;
      arrayOfByte[85] = 20;
      arrayOfByte[86] = 21;
      arrayOfByte[87] = 22;
      arrayOfByte[88] = 23;
      arrayOfByte[89] = 24;
      arrayOfByte[90] = 25;
      arrayOfByte[91] = -9;
      arrayOfByte[92] = -9;
      arrayOfByte[93] = -9;
      arrayOfByte[94] = -9;
      arrayOfByte[95] = -9;
      arrayOfByte[96] = -9;
      arrayOfByte[97] = 26;
      arrayOfByte[98] = 27;
      arrayOfByte[99] = 28;
      arrayOfByte[100] = 29;
      arrayOfByte[101] = 30;
      arrayOfByte[102] = 31;
      arrayOfByte[103] = 32;
      arrayOfByte[104] = 33;
      arrayOfByte[105] = 34;
      arrayOfByte[106] = 35;
      arrayOfByte[107] = 36;
      arrayOfByte[108] = 37;
      arrayOfByte[109] = 38;
      arrayOfByte[110] = 39;
      arrayOfByte[111] = 40;
      arrayOfByte[112] = 41;
      arrayOfByte[113] = 42;
      arrayOfByte[114] = 43;
      arrayOfByte[115] = 44;
      arrayOfByte[116] = 45;
      arrayOfByte[117] = 46;
      arrayOfByte[118] = 47;
      arrayOfByte[119] = 48;
      arrayOfByte[120] = 49;
      arrayOfByte[121] = 50;
      arrayOfByte[122] = 51;
      arrayOfByte[123] = -9;
      arrayOfByte[124] = -9;
      arrayOfByte[125] = -9;
      arrayOfByte[126] = -9;
      arrayOfByte[127] = -9;
      DECODABET = arrayOfByte;
      arrayOfByte = new byte[''];
      arrayOfByte[0] = -9;
      arrayOfByte[1] = -9;
      arrayOfByte[2] = -9;
      arrayOfByte[3] = -9;
      arrayOfByte[4] = -9;
      arrayOfByte[5] = -9;
      arrayOfByte[6] = -9;
      arrayOfByte[7] = -9;
      arrayOfByte[8] = -9;
      arrayOfByte[9] = -5;
      arrayOfByte[10] = -5;
      arrayOfByte[11] = -9;
      arrayOfByte[12] = -9;
      arrayOfByte[13] = -5;
      arrayOfByte[14] = -9;
      arrayOfByte[15] = -9;
      arrayOfByte[16] = -9;
      arrayOfByte[17] = -9;
      arrayOfByte[18] = -9;
      arrayOfByte[19] = -9;
      arrayOfByte[20] = -9;
      arrayOfByte[21] = -9;
      arrayOfByte[22] = -9;
      arrayOfByte[23] = -9;
      arrayOfByte[24] = -9;
      arrayOfByte[25] = -9;
      arrayOfByte[26] = -9;
      arrayOfByte[27] = -9;
      arrayOfByte[28] = -9;
      arrayOfByte[29] = -9;
      arrayOfByte[30] = -9;
      arrayOfByte[31] = -9;
      arrayOfByte[32] = -5;
      arrayOfByte[33] = -9;
      arrayOfByte[34] = -9;
      arrayOfByte[35] = -9;
      arrayOfByte[36] = -9;
      arrayOfByte[37] = -9;
      arrayOfByte[38] = -9;
      arrayOfByte[39] = -9;
      arrayOfByte[40] = -9;
      arrayOfByte[41] = -9;
      arrayOfByte[42] = -9;
      arrayOfByte[43] = -9;
      arrayOfByte[44] = -9;
      arrayOfByte[45] = 62;
      arrayOfByte[46] = -9;
      arrayOfByte[47] = -9;
      arrayOfByte[48] = 52;
      arrayOfByte[49] = 53;
      arrayOfByte[50] = 54;
      arrayOfByte[51] = 55;
      arrayOfByte[52] = 56;
      arrayOfByte[53] = 57;
      arrayOfByte[54] = 58;
      arrayOfByte[55] = 59;
      arrayOfByte[56] = 60;
      arrayOfByte[57] = 61;
      arrayOfByte[58] = -9;
      arrayOfByte[59] = -9;
      arrayOfByte[60] = -9;
      arrayOfByte[61] = -1;
      arrayOfByte[62] = -9;
      arrayOfByte[63] = -9;
      arrayOfByte[64] = -9;
      arrayOfByte[66] = 1;
      arrayOfByte[67] = 2;
      arrayOfByte[68] = 3;
      arrayOfByte[69] = 4;
      arrayOfByte[70] = 5;
      arrayOfByte[71] = 6;
      arrayOfByte[72] = 7;
      arrayOfByte[73] = 8;
      arrayOfByte[74] = 9;
      arrayOfByte[75] = 10;
      arrayOfByte[76] = 11;
      arrayOfByte[77] = 12;
      arrayOfByte[78] = 13;
      arrayOfByte[79] = 14;
      arrayOfByte[80] = 15;
      arrayOfByte[81] = 16;
      arrayOfByte[82] = 17;
      arrayOfByte[83] = 18;
      arrayOfByte[84] = 19;
      arrayOfByte[85] = 20;
      arrayOfByte[86] = 21;
      arrayOfByte[87] = 22;
      arrayOfByte[88] = 23;
      arrayOfByte[89] = 24;
      arrayOfByte[90] = 25;
      arrayOfByte[91] = -9;
      arrayOfByte[92] = -9;
      arrayOfByte[93] = -9;
      arrayOfByte[94] = -9;
      arrayOfByte[95] = 63;
      arrayOfByte[96] = -9;
      arrayOfByte[97] = 26;
      arrayOfByte[98] = 27;
      arrayOfByte[99] = 28;
      arrayOfByte[100] = 29;
      arrayOfByte[101] = 30;
      arrayOfByte[102] = 31;
      arrayOfByte[103] = 32;
      arrayOfByte[104] = 33;
      arrayOfByte[105] = 34;
      arrayOfByte[106] = 35;
      arrayOfByte[107] = 36;
      arrayOfByte[108] = 37;
      arrayOfByte[109] = 38;
      arrayOfByte[110] = 39;
      arrayOfByte[111] = 40;
      arrayOfByte[112] = 41;
      arrayOfByte[113] = 42;
      arrayOfByte[114] = 43;
      arrayOfByte[115] = 44;
      arrayOfByte[116] = 45;
      arrayOfByte[117] = 46;
      arrayOfByte[118] = 47;
      arrayOfByte[119] = 48;
      arrayOfByte[120] = 49;
      arrayOfByte[121] = 50;
      arrayOfByte[122] = 51;
      arrayOfByte[123] = -9;
      arrayOfByte[124] = -9;
      arrayOfByte[125] = -9;
      arrayOfByte[126] = -9;
      arrayOfByte[127] = -9;
      WEBSAFE_DECODABET = arrayOfByte;
      return;
    }
  }
  
  public static byte[] decode(String paramString)
    throws Base64DecoderException
  {
    paramString = paramString.getBytes();
    return decode(paramString, 0, paramString.length);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
    throws Base64DecoderException
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws Base64DecoderException
  {
    return decode(paramArrayOfByte, paramInt1, paramInt2, DECODABET);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
    throws Base64DecoderException
  {
    byte[] arrayOfByte1 = new byte[paramInt2 * 3 / 4 + 2];
    int k = 0;
    byte[] arrayOfByte2 = new byte[4];
    int m = 0;
    int j = 0;
    if (m >= paramInt2) {}
    int n;
    for (;;)
    {
      if (j != 0) {
        if (j == 1)
        {
          throw new Base64DecoderException("single trailing character at offset " + (paramInt2 - 1));
          int i = (byte)(paramArrayOfByte1[(m + paramInt1)] & 0x7F);
          n = paramArrayOfByte2[i];
          if (n >= -5)
          {
            if (n < -1) {
              break label377;
            }
            if (i == 61)
            {
              n = paramInt2 - m;
              paramInt1 = (byte)(paramArrayOfByte1[(paramInt2 - 1 + paramInt1)] & 0x7F);
              if ((j == 0) || (j == 1)) {
                throw new Base64DecoderException("invalid padding byte '=' at byte offset " + m);
              }
              if (((j == 3) && (n > 2)) || ((j == 4) && (n > 1))) {
                throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + m);
              }
              if ((paramInt1 == 61) || (paramInt1 == 10)) {
                continue;
              }
              throw new Base64DecoderException("encoded value has invalid trailing byte");
            }
            int i1 = j + 1;
            arrayOfByte2[j] = i;
            j = i1;
            n = k;
            if (i1 == 4)
            {
              n = k + decode4to3(arrayOfByte2, 0, arrayOfByte1, k, paramArrayOfByte2);
              j = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      m += 1;
      k = n;
      break;
      throw new Base64DecoderException("Bad Base64 input character at " + m + ": " + paramArrayOfByte1[(m + paramInt1)] + "(decimal)");
      arrayOfByte2[j] = 61;
      k += decode4to3(arrayOfByte2, 0, arrayOfByte1, k, paramArrayOfByte2);
      for (;;)
      {
        paramArrayOfByte1 = new byte[k];
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte1, 0, k);
        return paramArrayOfByte1;
      }
      label377:
      n = k;
    }
  }
  
  private static int decode4to3(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)((paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      paramInt1 = paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 2)]] << 24 >>> 18;
      paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
      return 2;
    }
    paramInt1 = paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 2)]] << 24 >>> 18 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 3)]] << 24 >>> 24;
    paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)paramInt1);
    return 3;
  }
  
  public static byte[] decodeWebSafe(String paramString)
    throws Base64DecoderException
  {
    paramString = paramString.getBytes();
    return decodeWebSafe(paramString, 0, paramString.length);
  }
  
  public static byte[] decodeWebSafe(byte[] paramArrayOfByte)
    throws Base64DecoderException
  {
    return decodeWebSafe(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] decodeWebSafe(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws Base64DecoderException
  {
    return decode(paramArrayOfByte, paramInt1, paramInt2, WEBSAFE_DECODABET);
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, ALPHABET, true);
  }
  
  public static String encode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    paramArrayOfByte1 = encode(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, 2147483647);
    paramInt1 = paramArrayOfByte1.length;
    for (;;)
    {
      if ((paramBoolean) || (paramInt1 <= 0)) {}
      while (paramArrayOfByte1[(paramInt1 - 1)] != 61) {
        return new String(paramArrayOfByte1, 0, paramInt1);
      }
      paramInt1 -= 1;
    }
  }
  
  public static byte[] encode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = (paramInt2 + 2) / 3 * 4;
    byte[] arrayOfByte = new byte[i / paramInt3 + i];
    int k = 0;
    i = 0;
    int j = 0;
    for (;;)
    {
      if (k >= paramInt2 - 2)
      {
        m = i;
        if (k < paramInt2)
        {
          encode3to4(paramArrayOfByte1, k + paramInt1, paramInt2 - k, arrayOfByte, i, paramArrayOfByte2);
          paramInt1 = i;
          if (j + 4 == paramInt3)
          {
            arrayOfByte[(i + 4)] = 10;
            paramInt1 = i + 1;
          }
          m = paramInt1 + 4;
        }
        if (($assertionsDisabled) || (m == arrayOfByte.length)) {
          break;
        }
        throw new AssertionError();
      }
      int m = paramArrayOfByte1[(k + paramInt1)] << 24 >>> 8 | paramArrayOfByte1[(k + 1 + paramInt1)] << 24 >>> 16 | paramArrayOfByte1[(k + 2 + paramInt1)] << 24 >>> 24;
      arrayOfByte[i] = paramArrayOfByte2[(m >>> 18)];
      arrayOfByte[(i + 1)] = paramArrayOfByte2[(m >>> 12 & 0x3F)];
      arrayOfByte[(i + 2)] = paramArrayOfByte2[(m >>> 6 & 0x3F)];
      arrayOfByte[(i + 3)] = paramArrayOfByte2[(m & 0x3F)];
      int n = j + 4;
      m = i;
      j = n;
      if (n == paramInt3)
      {
        arrayOfByte[(i + 4)] = 10;
        m = i + 1;
        j = 0;
      }
      k += 3;
      i = m + 4;
    }
    return arrayOfByte;
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, byte[] paramArrayOfByte3)
  {
    int k = 0;
    int i;
    if (paramInt2 > 0)
    {
      i = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label18:
      if (paramInt2 <= 1) {
        break label100;
      }
    }
    label100:
    for (int j = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; j = 0)
    {
      if (paramInt2 > 2) {
        k = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = j | i | k;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        i = 0;
        break label18;
      }
    }
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = paramArrayOfByte3[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = paramArrayOfByte3[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = paramArrayOfByte3[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  public static String encodeWebSafe(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, WEBSAFE_ALPHABET, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.util.Base64
 * JD-Core Version:    0.7.0.1
 */