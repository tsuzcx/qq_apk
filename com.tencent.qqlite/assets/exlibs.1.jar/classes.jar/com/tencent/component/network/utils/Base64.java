package com.tencent.component.network.utils;

import java.io.UnsupportedEncodingException;

public class Base64
{
  public static final int CRLF = 4;
  public static final int DEFAULT = 0;
  public static final int NO_CLOSE = 16;
  public static final int NO_PADDING = 1;
  public static final int NO_WRAP = 2;
  public static final int URL_SAFE = 8;
  
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static byte[] decode(String paramString, int paramInt)
  {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localb.a(paramArrayOfByte, paramInt1, paramInt2)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localb.b == localb.a.length) {
      return localb.a;
    }
    paramArrayOfByte = new byte[localb.b];
    System.arraycopy(localb.a, 0, paramArrayOfByte, 0, localb.b);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3);
    int i = paramInt2 / 3 << 2;
    int j;
    if (localc.c)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localc.d)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localc.e) {
            break label182;
          }
        }
      }
    }
    label182:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localc.a = new byte[i];
      localc.a(paramArrayOfByte, paramInt1, paramInt2);
      if ((a) || (localc.b == i)) {
        break label188;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label188:
    return localc.a;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt1, paramInt2, paramInt3), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  static abstract class a
  {
    public byte[] a;
    public int b;
  }
  
  static final class b
    extends Base64.a
  {
    private static final int[] c;
    private static final int[] d;
    private int e;
    private final int[] f;
    
    static
    {
      int[] arrayOfInt = new int[256];
      arrayOfInt[0] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[4] = -1;
      arrayOfInt[5] = -1;
      arrayOfInt[6] = -1;
      arrayOfInt[7] = -1;
      arrayOfInt[8] = -1;
      arrayOfInt[9] = -1;
      arrayOfInt[10] = -1;
      arrayOfInt[11] = -1;
      arrayOfInt[12] = -1;
      arrayOfInt[13] = -1;
      arrayOfInt[14] = -1;
      arrayOfInt[15] = -1;
      arrayOfInt[16] = -1;
      arrayOfInt[17] = -1;
      arrayOfInt[18] = -1;
      arrayOfInt[19] = -1;
      arrayOfInt[20] = -1;
      arrayOfInt[21] = -1;
      arrayOfInt[22] = -1;
      arrayOfInt[23] = -1;
      arrayOfInt[24] = -1;
      arrayOfInt[25] = -1;
      arrayOfInt[26] = -1;
      arrayOfInt[27] = -1;
      arrayOfInt[28] = -1;
      arrayOfInt[29] = -1;
      arrayOfInt[30] = -1;
      arrayOfInt[31] = -1;
      arrayOfInt[32] = -1;
      arrayOfInt[33] = -1;
      arrayOfInt[34] = -1;
      arrayOfInt[35] = -1;
      arrayOfInt[36] = -1;
      arrayOfInt[37] = -1;
      arrayOfInt[38] = -1;
      arrayOfInt[39] = -1;
      arrayOfInt[40] = -1;
      arrayOfInt[41] = -1;
      arrayOfInt[42] = -1;
      arrayOfInt[43] = 62;
      arrayOfInt[44] = -1;
      arrayOfInt[45] = -1;
      arrayOfInt[46] = -1;
      arrayOfInt[47] = 63;
      arrayOfInt[48] = 52;
      arrayOfInt[49] = 53;
      arrayOfInt[50] = 54;
      arrayOfInt[51] = 55;
      arrayOfInt[52] = 56;
      arrayOfInt[53] = 57;
      arrayOfInt[54] = 58;
      arrayOfInt[55] = 59;
      arrayOfInt[56] = 60;
      arrayOfInt[57] = 61;
      arrayOfInt[58] = -1;
      arrayOfInt[59] = -1;
      arrayOfInt[60] = -1;
      arrayOfInt[61] = -2;
      arrayOfInt[62] = -1;
      arrayOfInt[63] = -1;
      arrayOfInt[64] = -1;
      arrayOfInt[66] = 1;
      arrayOfInt[67] = 2;
      arrayOfInt[68] = 3;
      arrayOfInt[69] = 4;
      arrayOfInt[70] = 5;
      arrayOfInt[71] = 6;
      arrayOfInt[72] = 7;
      arrayOfInt[73] = 8;
      arrayOfInt[74] = 9;
      arrayOfInt[75] = 10;
      arrayOfInt[76] = 11;
      arrayOfInt[77] = 12;
      arrayOfInt[78] = 13;
      arrayOfInt[79] = 14;
      arrayOfInt[80] = 15;
      arrayOfInt[81] = 16;
      arrayOfInt[82] = 17;
      arrayOfInt[83] = 18;
      arrayOfInt[84] = 19;
      arrayOfInt[85] = 20;
      arrayOfInt[86] = 21;
      arrayOfInt[87] = 22;
      arrayOfInt[88] = 23;
      arrayOfInt[89] = 24;
      arrayOfInt[90] = 25;
      arrayOfInt[91] = -1;
      arrayOfInt[92] = -1;
      arrayOfInt[93] = -1;
      arrayOfInt[94] = -1;
      arrayOfInt[95] = -1;
      arrayOfInt[96] = -1;
      arrayOfInt[97] = 26;
      arrayOfInt[98] = 27;
      arrayOfInt[99] = 28;
      arrayOfInt[100] = 29;
      arrayOfInt[101] = 30;
      arrayOfInt[102] = 31;
      arrayOfInt[103] = 32;
      arrayOfInt[104] = 33;
      arrayOfInt[105] = 34;
      arrayOfInt[106] = 35;
      arrayOfInt[107] = 36;
      arrayOfInt[108] = 37;
      arrayOfInt[109] = 38;
      arrayOfInt[110] = 39;
      arrayOfInt[111] = 40;
      arrayOfInt[112] = 41;
      arrayOfInt[113] = 42;
      arrayOfInt[114] = 43;
      arrayOfInt[115] = 44;
      arrayOfInt[116] = 45;
      arrayOfInt[117] = 46;
      arrayOfInt[118] = 47;
      arrayOfInt[119] = 48;
      arrayOfInt[120] = 49;
      arrayOfInt[121] = 50;
      arrayOfInt[122] = 51;
      arrayOfInt[123] = -1;
      arrayOfInt[124] = -1;
      arrayOfInt[125] = -1;
      arrayOfInt[126] = -1;
      arrayOfInt[127] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[' '] = -1;
      arrayOfInt['¡'] = -1;
      arrayOfInt['¢'] = -1;
      arrayOfInt['£'] = -1;
      arrayOfInt['¤'] = -1;
      arrayOfInt['¥'] = -1;
      arrayOfInt['¦'] = -1;
      arrayOfInt['§'] = -1;
      arrayOfInt['¨'] = -1;
      arrayOfInt['©'] = -1;
      arrayOfInt['ª'] = -1;
      arrayOfInt['«'] = -1;
      arrayOfInt['¬'] = -1;
      arrayOfInt['­'] = -1;
      arrayOfInt['®'] = -1;
      arrayOfInt['¯'] = -1;
      arrayOfInt['°'] = -1;
      arrayOfInt['±'] = -1;
      arrayOfInt['²'] = -1;
      arrayOfInt['³'] = -1;
      arrayOfInt['´'] = -1;
      arrayOfInt['µ'] = -1;
      arrayOfInt['¶'] = -1;
      arrayOfInt['·'] = -1;
      arrayOfInt['¸'] = -1;
      arrayOfInt['¹'] = -1;
      arrayOfInt['º'] = -1;
      arrayOfInt['»'] = -1;
      arrayOfInt['¼'] = -1;
      arrayOfInt['½'] = -1;
      arrayOfInt['¾'] = -1;
      arrayOfInt['¿'] = -1;
      arrayOfInt['À'] = -1;
      arrayOfInt['Á'] = -1;
      arrayOfInt['Â'] = -1;
      arrayOfInt['Ã'] = -1;
      arrayOfInt['Ä'] = -1;
      arrayOfInt['Å'] = -1;
      arrayOfInt['Æ'] = -1;
      arrayOfInt['Ç'] = -1;
      arrayOfInt['È'] = -1;
      arrayOfInt['É'] = -1;
      arrayOfInt['Ê'] = -1;
      arrayOfInt['Ë'] = -1;
      arrayOfInt['Ì'] = -1;
      arrayOfInt['Í'] = -1;
      arrayOfInt['Î'] = -1;
      arrayOfInt['Ï'] = -1;
      arrayOfInt['Ð'] = -1;
      arrayOfInt['Ñ'] = -1;
      arrayOfInt['Ò'] = -1;
      arrayOfInt['Ó'] = -1;
      arrayOfInt['Ô'] = -1;
      arrayOfInt['Õ'] = -1;
      arrayOfInt['Ö'] = -1;
      arrayOfInt['×'] = -1;
      arrayOfInt['Ø'] = -1;
      arrayOfInt['Ù'] = -1;
      arrayOfInt['Ú'] = -1;
      arrayOfInt['Û'] = -1;
      arrayOfInt['Ü'] = -1;
      arrayOfInt['Ý'] = -1;
      arrayOfInt['Þ'] = -1;
      arrayOfInt['ß'] = -1;
      arrayOfInt['à'] = -1;
      arrayOfInt['á'] = -1;
      arrayOfInt['â'] = -1;
      arrayOfInt['ã'] = -1;
      arrayOfInt['ä'] = -1;
      arrayOfInt['å'] = -1;
      arrayOfInt['æ'] = -1;
      arrayOfInt['ç'] = -1;
      arrayOfInt['è'] = -1;
      arrayOfInt['é'] = -1;
      arrayOfInt['ê'] = -1;
      arrayOfInt['ë'] = -1;
      arrayOfInt['ì'] = -1;
      arrayOfInt['í'] = -1;
      arrayOfInt['î'] = -1;
      arrayOfInt['ï'] = -1;
      arrayOfInt['ð'] = -1;
      arrayOfInt['ñ'] = -1;
      arrayOfInt['ò'] = -1;
      arrayOfInt['ó'] = -1;
      arrayOfInt['ô'] = -1;
      arrayOfInt['õ'] = -1;
      arrayOfInt['ö'] = -1;
      arrayOfInt['÷'] = -1;
      arrayOfInt['ø'] = -1;
      arrayOfInt['ù'] = -1;
      arrayOfInt['ú'] = -1;
      arrayOfInt['û'] = -1;
      arrayOfInt['ü'] = -1;
      arrayOfInt['ý'] = -1;
      arrayOfInt['þ'] = -1;
      arrayOfInt['ÿ'] = -1;
      c = arrayOfInt;
      arrayOfInt = new int[256];
      arrayOfInt[0] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[4] = -1;
      arrayOfInt[5] = -1;
      arrayOfInt[6] = -1;
      arrayOfInt[7] = -1;
      arrayOfInt[8] = -1;
      arrayOfInt[9] = -1;
      arrayOfInt[10] = -1;
      arrayOfInt[11] = -1;
      arrayOfInt[12] = -1;
      arrayOfInt[13] = -1;
      arrayOfInt[14] = -1;
      arrayOfInt[15] = -1;
      arrayOfInt[16] = -1;
      arrayOfInt[17] = -1;
      arrayOfInt[18] = -1;
      arrayOfInt[19] = -1;
      arrayOfInt[20] = -1;
      arrayOfInt[21] = -1;
      arrayOfInt[22] = -1;
      arrayOfInt[23] = -1;
      arrayOfInt[24] = -1;
      arrayOfInt[25] = -1;
      arrayOfInt[26] = -1;
      arrayOfInt[27] = -1;
      arrayOfInt[28] = -1;
      arrayOfInt[29] = -1;
      arrayOfInt[30] = -1;
      arrayOfInt[31] = -1;
      arrayOfInt[32] = -1;
      arrayOfInt[33] = -1;
      arrayOfInt[34] = -1;
      arrayOfInt[35] = -1;
      arrayOfInt[36] = -1;
      arrayOfInt[37] = -1;
      arrayOfInt[38] = -1;
      arrayOfInt[39] = -1;
      arrayOfInt[40] = -1;
      arrayOfInt[41] = -1;
      arrayOfInt[42] = -1;
      arrayOfInt[43] = -1;
      arrayOfInt[44] = -1;
      arrayOfInt[45] = 62;
      arrayOfInt[46] = -1;
      arrayOfInt[47] = -1;
      arrayOfInt[48] = 52;
      arrayOfInt[49] = 53;
      arrayOfInt[50] = 54;
      arrayOfInt[51] = 55;
      arrayOfInt[52] = 56;
      arrayOfInt[53] = 57;
      arrayOfInt[54] = 58;
      arrayOfInt[55] = 59;
      arrayOfInt[56] = 60;
      arrayOfInt[57] = 61;
      arrayOfInt[58] = -1;
      arrayOfInt[59] = -1;
      arrayOfInt[60] = -1;
      arrayOfInt[61] = -2;
      arrayOfInt[62] = -1;
      arrayOfInt[63] = -1;
      arrayOfInt[64] = -1;
      arrayOfInt[66] = 1;
      arrayOfInt[67] = 2;
      arrayOfInt[68] = 3;
      arrayOfInt[69] = 4;
      arrayOfInt[70] = 5;
      arrayOfInt[71] = 6;
      arrayOfInt[72] = 7;
      arrayOfInt[73] = 8;
      arrayOfInt[74] = 9;
      arrayOfInt[75] = 10;
      arrayOfInt[76] = 11;
      arrayOfInt[77] = 12;
      arrayOfInt[78] = 13;
      arrayOfInt[79] = 14;
      arrayOfInt[80] = 15;
      arrayOfInt[81] = 16;
      arrayOfInt[82] = 17;
      arrayOfInt[83] = 18;
      arrayOfInt[84] = 19;
      arrayOfInt[85] = 20;
      arrayOfInt[86] = 21;
      arrayOfInt[87] = 22;
      arrayOfInt[88] = 23;
      arrayOfInt[89] = 24;
      arrayOfInt[90] = 25;
      arrayOfInt[91] = -1;
      arrayOfInt[92] = -1;
      arrayOfInt[93] = -1;
      arrayOfInt[94] = -1;
      arrayOfInt[95] = 63;
      arrayOfInt[96] = -1;
      arrayOfInt[97] = 26;
      arrayOfInt[98] = 27;
      arrayOfInt[99] = 28;
      arrayOfInt[100] = 29;
      arrayOfInt[101] = 30;
      arrayOfInt[102] = 31;
      arrayOfInt[103] = 32;
      arrayOfInt[104] = 33;
      arrayOfInt[105] = 34;
      arrayOfInt[106] = 35;
      arrayOfInt[107] = 36;
      arrayOfInt[108] = 37;
      arrayOfInt[109] = 38;
      arrayOfInt[110] = 39;
      arrayOfInt[111] = 40;
      arrayOfInt[112] = 41;
      arrayOfInt[113] = 42;
      arrayOfInt[114] = 43;
      arrayOfInt[115] = 44;
      arrayOfInt[116] = 45;
      arrayOfInt[117] = 46;
      arrayOfInt[118] = 47;
      arrayOfInt[119] = 48;
      arrayOfInt[120] = 49;
      arrayOfInt[121] = 50;
      arrayOfInt[122] = 51;
      arrayOfInt[123] = -1;
      arrayOfInt[124] = -1;
      arrayOfInt[125] = -1;
      arrayOfInt[126] = -1;
      arrayOfInt[127] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[' '] = -1;
      arrayOfInt['¡'] = -1;
      arrayOfInt['¢'] = -1;
      arrayOfInt['£'] = -1;
      arrayOfInt['¤'] = -1;
      arrayOfInt['¥'] = -1;
      arrayOfInt['¦'] = -1;
      arrayOfInt['§'] = -1;
      arrayOfInt['¨'] = -1;
      arrayOfInt['©'] = -1;
      arrayOfInt['ª'] = -1;
      arrayOfInt['«'] = -1;
      arrayOfInt['¬'] = -1;
      arrayOfInt['­'] = -1;
      arrayOfInt['®'] = -1;
      arrayOfInt['¯'] = -1;
      arrayOfInt['°'] = -1;
      arrayOfInt['±'] = -1;
      arrayOfInt['²'] = -1;
      arrayOfInt['³'] = -1;
      arrayOfInt['´'] = -1;
      arrayOfInt['µ'] = -1;
      arrayOfInt['¶'] = -1;
      arrayOfInt['·'] = -1;
      arrayOfInt['¸'] = -1;
      arrayOfInt['¹'] = -1;
      arrayOfInt['º'] = -1;
      arrayOfInt['»'] = -1;
      arrayOfInt['¼'] = -1;
      arrayOfInt['½'] = -1;
      arrayOfInt['¾'] = -1;
      arrayOfInt['¿'] = -1;
      arrayOfInt['À'] = -1;
      arrayOfInt['Á'] = -1;
      arrayOfInt['Â'] = -1;
      arrayOfInt['Ã'] = -1;
      arrayOfInt['Ä'] = -1;
      arrayOfInt['Å'] = -1;
      arrayOfInt['Æ'] = -1;
      arrayOfInt['Ç'] = -1;
      arrayOfInt['È'] = -1;
      arrayOfInt['É'] = -1;
      arrayOfInt['Ê'] = -1;
      arrayOfInt['Ë'] = -1;
      arrayOfInt['Ì'] = -1;
      arrayOfInt['Í'] = -1;
      arrayOfInt['Î'] = -1;
      arrayOfInt['Ï'] = -1;
      arrayOfInt['Ð'] = -1;
      arrayOfInt['Ñ'] = -1;
      arrayOfInt['Ò'] = -1;
      arrayOfInt['Ó'] = -1;
      arrayOfInt['Ô'] = -1;
      arrayOfInt['Õ'] = -1;
      arrayOfInt['Ö'] = -1;
      arrayOfInt['×'] = -1;
      arrayOfInt['Ø'] = -1;
      arrayOfInt['Ù'] = -1;
      arrayOfInt['Ú'] = -1;
      arrayOfInt['Û'] = -1;
      arrayOfInt['Ü'] = -1;
      arrayOfInt['Ý'] = -1;
      arrayOfInt['Þ'] = -1;
      arrayOfInt['ß'] = -1;
      arrayOfInt['à'] = -1;
      arrayOfInt['á'] = -1;
      arrayOfInt['â'] = -1;
      arrayOfInt['ã'] = -1;
      arrayOfInt['ä'] = -1;
      arrayOfInt['å'] = -1;
      arrayOfInt['æ'] = -1;
      arrayOfInt['ç'] = -1;
      arrayOfInt['è'] = -1;
      arrayOfInt['é'] = -1;
      arrayOfInt['ê'] = -1;
      arrayOfInt['ë'] = -1;
      arrayOfInt['ì'] = -1;
      arrayOfInt['í'] = -1;
      arrayOfInt['î'] = -1;
      arrayOfInt['ï'] = -1;
      arrayOfInt['ð'] = -1;
      arrayOfInt['ñ'] = -1;
      arrayOfInt['ò'] = -1;
      arrayOfInt['ó'] = -1;
      arrayOfInt['ô'] = -1;
      arrayOfInt['õ'] = -1;
      arrayOfInt['ö'] = -1;
      arrayOfInt['÷'] = -1;
      arrayOfInt['ø'] = -1;
      arrayOfInt['ù'] = -1;
      arrayOfInt['ú'] = -1;
      arrayOfInt['û'] = -1;
      arrayOfInt['ü'] = -1;
      arrayOfInt['ý'] = -1;
      arrayOfInt['þ'] = -1;
      arrayOfInt['ÿ'] = -1;
      d = arrayOfInt;
    }
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = c;; paramArrayOfByte = d)
      {
        this.f = paramArrayOfByte;
        this.e = 0;
        return;
      }
    }
    
    public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.e == 6) {
        return false;
      }
      int i1 = paramInt2 + paramInt1;
      paramInt2 = this.e;
      int i = 0;
      int j = 0;
      byte[] arrayOfByte = this.a;
      int[] arrayOfInt = this.f;
      int m;
      if (paramInt1 >= i1)
      {
        m = i;
        i = j;
        label53:
        paramInt1 = i;
      }
      switch (paramInt2)
      {
      default: 
        paramInt1 = i;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.e = paramInt2;
          this.b = paramInt1;
          return true;
          int k = j;
          m = i;
          int n = paramInt1;
          if (paramInt2 == 0)
          {
            k = paramInt1;
            paramInt1 = i;
            label128:
            if (k + 4 <= i1)
            {
              paramInt1 = arrayOfInt[(paramArrayOfByte[k] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(k + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(k + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(k + 3)] & 0xFF)];
              if (paramInt1 >= 0) {
                break label299;
              }
            }
            i = j;
            m = paramInt1;
            if (k >= i1) {
              break label53;
            }
            n = k;
            m = paramInt1;
            k = j;
          }
          paramInt1 = n + 1;
          i = arrayOfInt[(paramArrayOfByte[n] & 0xFF)];
          switch (paramInt2)
          {
          }
          label299:
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      j = k;
                      i = m;
                      break;
                      arrayOfByte[(j + 2)] = ((byte)paramInt1);
                      arrayOfByte[(j + 1)] = ((byte)(paramInt1 >> 8));
                      arrayOfByte[j] = ((byte)(paramInt1 >> 16));
                      j += 3;
                      k += 4;
                      break label128;
                      if (i >= 0)
                      {
                        paramInt2 += 1;
                        j = k;
                        break;
                      }
                    } while (i == -1);
                    this.e = 6;
                    return false;
                    if (i >= 0)
                    {
                      i = m << 6 | i;
                      paramInt2 += 1;
                      j = k;
                      break;
                    }
                  } while (i == -1);
                  this.e = 6;
                  return false;
                  if (i >= 0)
                  {
                    i = m << 6 | i;
                    paramInt2 += 1;
                    j = k;
                    break;
                  }
                  if (i == -2)
                  {
                    arrayOfByte[k] = ((byte)(m >> 4));
                    paramInt2 = 4;
                    j = k + 1;
                    i = m;
                    break;
                  }
                } while (i == -1);
                this.e = 6;
                return false;
                if (i >= 0)
                {
                  i = m << 6 | i;
                  arrayOfByte[(k + 2)] = ((byte)i);
                  arrayOfByte[(k + 1)] = ((byte)(i >> 8));
                  arrayOfByte[k] = ((byte)(i >> 16));
                  j = k + 3;
                  paramInt2 = 0;
                  break;
                }
                if (i == -2)
                {
                  arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                  arrayOfByte[k] = ((byte)(m >> 10));
                  j = k + 2;
                  paramInt2 = 5;
                  i = m;
                  break;
                }
              } while (i == -1);
              this.e = 6;
              return false;
              if (i == -2)
              {
                paramInt2 += 1;
                j = k;
                i = m;
                break;
              }
            } while (i == -1);
            this.e = 6;
            return false;
          } while (i == -1);
          this.e = 6;
          return false;
          this.e = 6;
          return false;
          arrayOfByte[i] = ((byte)(m >> 4));
          paramInt1 = i + 1;
          continue;
          j = i + 1;
          arrayOfByte[i] = ((byte)(m >> 10));
          paramInt1 = j + 1;
          arrayOfByte[j] = ((byte)(m >> 2));
        }
      }
      this.e = 6;
      return false;
    }
  }
  
  static final class c
    extends Base64.a
  {
    private static final byte[] f;
    private static final byte[] g;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    private final byte[] h;
    private int i;
    private int j;
    private final byte[] k;
    
    static
    {
      if (!Base64.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        l = bool;
        f = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        g = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public c(int paramInt)
    {
      this.a = null;
      boolean bool1;
      label32:
      label45:
      byte[] arrayOfByte;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.c = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        this.d = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        this.e = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        arrayOfByte = f;
        label62:
        this.k = arrayOfByte;
        this.h = new byte[2];
        this.i = 0;
        if (!this.d) {
          break label119;
        }
      }
      label101:
      label106:
      label111:
      label119:
      for (paramInt = 19;; paramInt = -1)
      {
        this.j = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label32;
        bool1 = false;
        break label45;
        arrayOfByte = g;
        break label62;
      }
    }
    
    public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte1 = this.k;
      byte[] arrayOfByte2 = this.a;
      int n = 0;
      int i1 = this.j;
      int i4 = paramInt2 + paramInt1;
      int m;
      switch (this.i)
      {
      default: 
        m = paramInt1;
        paramInt1 = -1;
        label61:
        if (paramInt1 != -1)
        {
          arrayOfByte2[0] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
          arrayOfByte2[1] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
          arrayOfByte2[2] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
          paramInt2 = 4;
          arrayOfByte2[3] = arrayOfByte1[(paramInt1 & 0x3F)];
          paramInt1 = i1 - 1;
          if (paramInt1 == 0)
          {
            paramInt1 = paramInt2;
            if (this.e)
            {
              paramInt1 = 5;
              arrayOfByte2[4] = 13;
            }
            n = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 10;
            paramInt2 = 19;
            paramInt1 = n;
          }
        }
        break;
      }
      for (;;)
      {
        label210:
        int i2;
        if (m + 3 > i4)
        {
          if (m - this.i != i4 - 1) {
            break label699;
          }
          n = 0;
          if (this.i <= 0) {
            break label684;
          }
          paramArrayOfByte = this.h;
          n = 1;
          i1 = paramArrayOfByte[0];
          i1 = (i1 & 0xFF) << 4;
          this.i -= n;
          i2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 6 & 0x3F)];
          n = i2 + 1;
          arrayOfByte2[i2] = arrayOfByte1[(i1 & 0x3F)];
          paramInt1 = n;
          if (this.c)
          {
            i1 = n + 1;
            arrayOfByte2[n] = 61;
            paramInt1 = i1 + 1;
            arrayOfByte2[i1] = 61;
          }
          n = paramInt1;
          i1 = m;
          if (!this.d) {
            break label1106;
          }
          n = paramInt1;
          if (this.e)
          {
            arrayOfByte2[paramInt1] = 13;
            n = paramInt1 + 1;
          }
          paramInt1 = n + 1;
          arrayOfByte2[n] = 10;
          n = paramInt1;
          i1 = m;
          if ((l) || (this.i == 0)) {
            break label1069;
          }
          throw new AssertionError();
          paramInt2 = -1;
          m = paramInt1;
          paramInt1 = paramInt2;
          break label61;
          if (paramInt1 + 2 > i4) {
            break;
          }
          paramInt2 = this.h[0];
          m = paramInt1 + 1;
          paramInt1 = paramArrayOfByte[paramInt1];
          i2 = paramArrayOfByte[m];
          this.i = 0;
          m += 1;
          paramInt1 = (paramInt2 & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | i2 & 0xFF;
          break label61;
          if (paramInt1 + 1 > i4) {
            break;
          }
          paramInt2 = this.h[0];
          i2 = this.h[1];
          m = paramInt1 + 1;
          paramInt1 = paramArrayOfByte[paramInt1];
          this.i = 0;
          paramInt1 = (paramInt2 & 0xFF) << 16 | (i2 & 0xFF) << 8 | paramInt1 & 0xFF;
          break label61;
        }
        n = (paramArrayOfByte[m] & 0xFF) << 16 | (paramArrayOfByte[(m + 1)] & 0xFF) << 8 | paramArrayOfByte[(m + 2)] & 0xFF;
        arrayOfByte2[paramInt1] = arrayOfByte1[(n >> 18 & 0x3F)];
        arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(n >> 12 & 0x3F)];
        arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(n >> 6 & 0x3F)];
        arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(n & 0x3F)];
        m += 3;
        paramInt1 += 4;
        paramInt2 -= 1;
        label777:
        if (paramInt2 == 0)
        {
          if (this.e)
          {
            paramInt2 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 13;
            paramInt1 = paramInt2;
          }
          label684:
          label1069:
          for (;;)
          {
            paramInt2 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 10;
            n = 19;
            paramInt1 = paramInt2;
            paramInt2 = n;
            break;
            i1 = paramArrayOfByte[m];
            m += 1;
            break label210;
            label699:
            label747:
            int i3;
            if (m - this.i == i4 - 2)
            {
              n = 0;
              if (this.i > 1)
              {
                byte[] arrayOfByte3 = this.h;
                i2 = 1;
                i1 = arrayOfByte3[0];
                n = m;
                m = i2;
                if (this.i <= 0) {
                  break label969;
                }
                i2 = this.h[m];
                i3 = m + 1;
                m = n;
                n = i3;
                i1 = (i2 & 0xFF) << 2 | (i1 & 0xFF) << 10;
                this.i -= n;
                n = paramInt1 + 1;
                arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 12 & 0x3F)];
                i2 = n + 1;
                arrayOfByte2[n] = arrayOfByte1[(i1 >> 6 & 0x3F)];
                paramInt1 = i2 + 1;
                arrayOfByte2[i2] = arrayOfByte1[(i1 & 0x3F)];
                if (!this.c) {
                  break label1109;
                }
                n = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 61;
                paramInt1 = n;
              }
            }
            label969:
            label1106:
            label1109:
            for (;;)
            {
              n = paramInt1;
              i1 = m;
              if (this.d)
              {
                n = paramInt1;
                if (this.e)
                {
                  arrayOfByte2[paramInt1] = 13;
                  n = paramInt1 + 1;
                }
                paramInt1 = n + 1;
                arrayOfByte2[n] = 10;
                i1 = m;
                n = paramInt1;
                break;
                i1 = paramArrayOfByte[m];
                i2 = m + 1;
                m = n;
                n = i2;
                break label747;
                i2 = paramArrayOfByte[n];
                i3 = n + 1;
                n = m;
                m = i3;
                break label777;
                i1 = m;
                n = paramInt1;
                if (!this.d) {
                  break;
                }
                i1 = m;
                n = paramInt1;
                if (paramInt1 <= 0) {
                  break;
                }
                i1 = m;
                n = paramInt1;
                if (paramInt2 == 19) {
                  break;
                }
                if (this.e)
                {
                  n = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 13;
                  paramInt1 = n;
                }
                for (;;)
                {
                  n = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 10;
                  i1 = m;
                  break;
                  if ((!l) && (i1 != i4)) {
                    throw new AssertionError();
                  }
                  this.b = n;
                  this.j = paramInt2;
                  return true;
                }
              }
              break;
            }
          }
        }
        continue;
        paramInt2 = paramInt1;
        paramInt1 = 4;
        continue;
        paramInt2 = i1;
        paramInt1 = n;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.Base64
 * JD-Core Version:    0.7.0.1
 */