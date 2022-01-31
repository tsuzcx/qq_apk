package com.qzone.utils;

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
      $assertionsDisabled = bool;
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
    Decoder localDecoder = new Decoder(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localDecoder.process(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localDecoder.op == localDecoder.output.length) {
      return localDecoder.output;
    }
    paramArrayOfByte = new byte[localDecoder.op];
    System.arraycopy(localDecoder.output, 0, paramArrayOfByte, 0, localDecoder.op);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Encoder localEncoder = new Encoder(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localEncoder.do_padding)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localEncoder.do_newline)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localEncoder.do_cr) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localEncoder.output = new byte[i];
      localEncoder.process(paramArrayOfByte, paramInt1, paramInt2, true);
      if (($assertionsDisabled) || (localEncoder.op == i)) {
        break label192;
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
    label192:
    return localEncoder.output;
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
  
  static abstract class Coder
  {
    public int op;
    public byte[] output;
    
    public abstract int maxOutputSize(int paramInt);
    
    public abstract boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  static class Decoder
    extends Base64.Coder
  {
    private static final int[] DECODE;
    private static final int[] DECODE_WEBSAFE;
    private static final int EQUALS = -2;
    private static final int SKIP = -1;
    private final int[] alphabet;
    private int state;
    private int value;
    
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
      DECODE = arrayOfInt;
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
      DECODE_WEBSAFE = arrayOfInt;
    }
    
    public Decoder(int paramInt, byte[] paramArrayOfByte)
    {
      this.output = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = DECODE;; paramArrayOfByte = DECODE_WEBSAFE)
      {
        this.alphabet = paramArrayOfByte;
        this.state = 0;
        this.value = 0;
        return;
      }
    }
    
    public int maxOutputSize(int paramInt)
    {
      return paramInt * 3 / 4 + 10;
    }
    
    public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.state == 6) {
        return false;
      }
      int j = paramInt1;
      int i1 = paramInt2 + paramInt1;
      paramInt2 = this.state;
      int i = this.value;
      int k = 0;
      byte[] arrayOfByte = this.output;
      int[] arrayOfInt = this.alphabet;
      paramInt1 = j;
      j = k;
      if (paramInt1 >= i1)
      {
        paramInt1 = i;
        i = j;
        if (!paramBoolean)
        {
          this.state = paramInt2;
          this.value = paramInt1;
          this.op = i;
          return true;
        }
      }
      else
      {
        k = j;
        int n = paramInt1;
        int m = i;
        if (paramInt2 == 0)
        {
          k = i;
          i = paramInt1;
          for (;;)
          {
            paramInt1 = k;
            if (i + 4 <= i1)
            {
              paramInt1 = arrayOfInt[(paramArrayOfByte[i] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(i + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(i + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(i + 3)] & 0xFF)];
              if (paramInt1 >= 0) {}
            }
            else
            {
              k = j;
              n = i;
              m = paramInt1;
              if (i < i1) {
                break label263;
              }
              i = j;
              break;
            }
            arrayOfByte[(j + 2)] = ((byte)paramInt1);
            arrayOfByte[(j + 1)] = ((byte)(paramInt1 >> 8));
            arrayOfByte[j] = ((byte)(paramInt1 >> 16));
            j += 3;
            i += 4;
            k = paramInt1;
          }
        }
        label263:
        paramInt1 = n + 1;
        i = arrayOfInt[(paramArrayOfByte[n] & 0xFF)];
        switch (paramInt2)
        {
        }
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
                    if (i >= 0)
                    {
                      paramInt2 += 1;
                      j = k;
                      break;
                    }
                  } while (i == -1);
                  this.state = 6;
                  return false;
                  if (i >= 0)
                  {
                    i = m << 6 | i;
                    paramInt2 += 1;
                    j = k;
                    break;
                  }
                } while (i == -1);
                this.state = 6;
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
              this.state = 6;
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
            this.state = 6;
            return false;
            if (i == -2)
            {
              paramInt2 += 1;
              j = k;
              i = m;
              break;
            }
          } while (i == -1);
          this.state = 6;
          return false;
        } while (i == -1);
        this.state = 6;
        return false;
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
          this.state = paramInt2;
          this.op = paramInt1;
          return true;
          paramInt1 = i;
          continue;
          this.state = 6;
          return false;
          j = i + 1;
          arrayOfByte[i] = ((byte)(paramInt1 >> 4));
          paramInt1 = j;
          continue;
          j = i + 1;
          arrayOfByte[i] = ((byte)(paramInt1 >> 10));
          arrayOfByte[j] = ((byte)(paramInt1 >> 2));
          paramInt1 = j + 1;
        }
      }
      this.state = 6;
      return false;
    }
  }
  
  static class Encoder
    extends Base64.Coder
  {
    private static final byte[] ENCODE;
    private static final byte[] ENCODE_WEBSAFE;
    public static final int LINE_GROUPS = 19;
    private final byte[] alphabet;
    private int count;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte[] tail;
    int tailLen;
    
    static
    {
      if (!Base64.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        ENCODE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        ENCODE_WEBSAFE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public Encoder(int paramInt, byte[] paramArrayOfByte)
    {
      this.output = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.do_padding = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        label33:
        this.do_newline = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        label47:
        this.do_cr = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        paramArrayOfByte = ENCODE;
        label63:
        this.alphabet = paramArrayOfByte;
        this.tail = new byte[2];
        this.tailLen = 0;
        if (!this.do_newline) {
          break label118;
        }
      }
      label101:
      label106:
      label111:
      label118:
      for (paramInt = 19;; paramInt = -1)
      {
        this.count = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label33;
        bool1 = false;
        break label47;
        paramArrayOfByte = ENCODE_WEBSAFE;
        break label63;
      }
    }
    
    public int maxOutputSize(int paramInt)
    {
      return paramInt * 8 / 5 + 10;
    }
    
    public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte1 = this.alphabet;
      byte[] arrayOfByte2 = this.output;
      int k = 0;
      int n = this.count;
      int i = paramInt1;
      int i1 = paramInt2 + paramInt1;
      paramInt2 = -1;
      paramInt1 = i;
      int j = paramInt2;
      int m;
      switch (this.tailLen)
      {
      default: 
        j = paramInt2;
        paramInt1 = i;
      case 0: 
        paramInt2 = n;
        i = k;
        k = paramInt1;
        if (j != -1)
        {
          i = 0 + 1;
          arrayOfByte2[0] = arrayOfByte1[(j >> 18 & 0x3F)];
          paramInt2 = i + 1;
          arrayOfByte2[i] = arrayOfByte1[(j >> 12 & 0x3F)];
          i = paramInt2 + 1;
          arrayOfByte2[paramInt2] = arrayOfByte1[(j >> 6 & 0x3F)];
          m = i + 1;
          arrayOfByte2[i] = arrayOfByte1[(j & 0x3F)];
          j = n - 1;
          paramInt2 = j;
          i = m;
          k = paramInt1;
          if (j == 0)
          {
            paramInt2 = m;
            if (this.do_cr)
            {
              arrayOfByte2[m] = 13;
              paramInt2 = m + 1;
            }
            i = paramInt2 + 1;
            arrayOfByte2[paramInt2] = 10;
            j = 19;
            paramInt2 = paramInt1;
            paramInt1 = i;
            i = j;
          }
        }
        break;
      }
      for (;;)
      {
        label237:
        if (paramInt2 + 3 > i1)
        {
          if (!paramBoolean) {
            break label1118;
          }
          if (paramInt2 - this.tailLen != i1 - 1) {
            break label773;
          }
          j = 0;
          if (this.tailLen <= 0) {
            break label757;
          }
          k = this.tail[0];
          j = 0 + 1;
        }
        for (;;)
        {
          k = (k & 0xFF) << 4;
          this.tailLen -= j;
          j = paramInt1 + 1;
          arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 6 & 0x3F)];
          paramInt1 = j + 1;
          arrayOfByte2[j] = arrayOfByte1[(k & 0x3F)];
          j = paramInt1;
          if (this.do_padding)
          {
            k = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 61;
            j = k + 1;
            arrayOfByte2[k] = 61;
          }
          paramInt1 = j;
          k = paramInt2;
          if (this.do_newline)
          {
            paramInt1 = j;
            if (this.do_cr)
            {
              arrayOfByte2[j] = 13;
              paramInt1 = j + 1;
            }
            arrayOfByte2[paramInt1] = 10;
            paramInt1 += 1;
            k = paramInt2;
          }
          if (($assertionsDisabled) || (this.tailLen == 0)) {
            break label1093;
          }
          throw new AssertionError();
          paramInt1 = i;
          j = paramInt2;
          if (i + 2 > i1) {
            break;
          }
          paramInt2 = this.tail[0];
          j = i + 1;
          i = paramArrayOfByte[i];
          paramInt1 = j + 1;
          j = (paramInt2 & 0xFF) << 16 | (i & 0xFF) << 8 | paramArrayOfByte[j] & 0xFF;
          this.tailLen = 0;
          break;
          paramInt1 = i;
          j = paramInt2;
          if (i + 1 > i1) {
            break;
          }
          j = (this.tail[0] & 0xFF) << 16 | (this.tail[1] & 0xFF) << 8 | paramArrayOfByte[i] & 0xFF;
          this.tailLen = 0;
          paramInt1 = i + 1;
          break;
          j = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
          arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 18 & 0x3F)];
          arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(j >> 12 & 0x3F)];
          arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(j >> 6 & 0x3F)];
          arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(j & 0x3F)];
          j = paramInt2 + 3;
          paramInt1 += 4;
          m = i - 1;
          paramInt2 = m;
          i = paramInt1;
          k = j;
          if (m != 0) {
            break label1243;
          }
          paramInt2 = paramInt1;
          if (this.do_cr)
          {
            arrayOfByte2[paramInt1] = 13;
            paramInt2 = paramInt1 + 1;
          }
          paramInt1 = paramInt2 + 1;
          arrayOfByte2[paramInt2] = 10;
          i = 19;
          paramInt2 = j;
          break label237;
          label757:
          m = paramInt2 + 1;
          k = paramArrayOfByte[paramInt2];
          paramInt2 = m;
        }
        label773:
        if (paramInt2 - this.tailLen == i1 - 2)
        {
          k = 0;
          if (this.tailLen > 1)
          {
            k = this.tail[0];
            m = 0 + 1;
            j = paramInt2;
            paramInt2 = m;
            label816:
            if (this.tailLen <= 0) {
              break label1010;
            }
            m = this.tail[paramInt2];
            paramInt2 += 1;
          }
          for (;;)
          {
            k = (k & 0xFF) << 10 | (m & 0xFF) << 2;
            this.tailLen -= paramInt2;
            paramInt2 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 12 & 0x3F)];
            m = paramInt2 + 1;
            arrayOfByte2[paramInt2] = arrayOfByte1[(k >> 6 & 0x3F)];
            paramInt1 = m + 1;
            arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
            paramInt2 = paramInt1;
            if (this.do_padding)
            {
              arrayOfByte2[paramInt1] = 61;
              paramInt2 = paramInt1 + 1;
            }
            paramInt1 = paramInt2;
            k = j;
            if (!this.do_newline) {
              break;
            }
            paramInt1 = paramInt2;
            if (this.do_cr)
            {
              arrayOfByte2[paramInt2] = 13;
              paramInt1 = paramInt2 + 1;
            }
            arrayOfByte2[paramInt1] = 10;
            paramInt1 += 1;
            k = j;
            break;
            j = paramInt2 + 1;
            m = paramArrayOfByte[paramInt2];
            paramInt2 = k;
            k = m;
            break label816;
            label1010:
            m = paramArrayOfByte[j];
            j += 1;
          }
        }
        j = paramInt1;
        if (this.do_newline)
        {
          j = paramInt1;
          if (paramInt1 > 0)
          {
            j = paramInt1;
            if (i != 19)
            {
              if (!this.do_cr) {
                break label1240;
              }
              j = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 13;
              paramInt1 = j;
            }
          }
        }
        label1093:
        label1240:
        for (;;)
        {
          j = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          paramInt1 = j;
          k = paramInt2;
          break;
          paramInt2 = paramInt1;
          if (!$assertionsDisabled)
          {
            paramInt2 = paramInt1;
            if (k != i1)
            {
              throw new AssertionError();
              label1118:
              if (paramInt2 != i1 - 1) {
                break label1169;
              }
              arrayOfByte1 = this.tail;
              j = this.tailLen;
              this.tailLen = (j + 1);
              arrayOfByte1[j] = paramArrayOfByte[paramInt2];
            }
          }
          for (paramInt2 = paramInt1;; paramInt2 = paramInt1)
          {
            this.op = paramInt2;
            this.count = i;
            return true;
            if (paramInt2 == i1 - 2)
            {
              arrayOfByte1 = this.tail;
              j = this.tailLen;
              this.tailLen = (j + 1);
              arrayOfByte1[j] = paramArrayOfByte[paramInt2];
              arrayOfByte1 = this.tail;
              j = this.tailLen;
              this.tailLen = (j + 1);
              arrayOfByte1[j] = paramArrayOfByte[(paramInt2 + 1)];
            }
          }
        }
        label1169:
        label1243:
        paramInt1 = i;
        i = paramInt2;
        paramInt2 = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.Base64
 * JD-Core Version:    0.7.0.1
 */