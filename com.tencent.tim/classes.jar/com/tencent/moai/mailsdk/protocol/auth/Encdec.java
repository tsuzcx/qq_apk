package com.tencent.moai.mailsdk.protocol.auth;

import java.io.IOException;
import java.util.Date;

public class Encdec
{
  public static final long MILLISECONDS_BETWEEN_1970_AND_1601 = 11644473600000L;
  public static final long SEC_BETWEEEN_1904_AND_1970 = 2082844800L;
  public static final int TIME_1601_NANOS_64BE = 6;
  public static final int TIME_1601_NANOS_64LE = 5;
  public static final int TIME_1904_SEC_32BE = 3;
  public static final int TIME_1904_SEC_32LE = 4;
  public static final int TIME_1970_MILLIS_64BE = 7;
  public static final int TIME_1970_MILLIS_64LE = 8;
  public static final int TIME_1970_SEC_32BE = 1;
  public static final int TIME_1970_SEC_32LE = 2;
  
  public static double dec_doublebe(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(dec_uint64be(paramArrayOfByte, paramInt));
  }
  
  public static double dec_doublele(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(dec_uint64le(paramArrayOfByte, paramInt));
  }
  
  public static float dec_floatbe(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(dec_uint32be(paramArrayOfByte, paramInt));
  }
  
  public static float dec_floatle(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(dec_uint32le(paramArrayOfByte, paramInt));
  }
  
  public static Date dec_time(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("Unsupported time encoding");
    case 1: 
      return new Date(dec_uint32be(paramArrayOfByte, paramInt1) * 1000L);
    case 2: 
      return new Date(dec_uint32le(paramArrayOfByte, paramInt1) * 1000L);
    case 3: 
      return new Date(((dec_uint32be(paramArrayOfByte, paramInt1) & 0xFFFFFFFF) - 2082844800L) * 1000L);
    case 4: 
      return new Date(((dec_uint32le(paramArrayOfByte, paramInt1) & 0xFFFFFFFF) - 2082844800L) * 1000L);
    case 5: 
      return new Date(dec_uint64le(paramArrayOfByte, paramInt1) / 10000L - 11644473600000L);
    case 6: 
      return new Date(dec_uint64be(paramArrayOfByte, paramInt1) / 10000L - 11644473600000L);
    case 7: 
      return new Date(dec_uint64be(paramArrayOfByte, paramInt1));
    }
    return new Date(dec_uint64le(paramArrayOfByte, paramInt1));
  }
  
  public static String dec_ucs2le(byte[] paramArrayOfByte, int paramInt1, int paramInt2, char[] paramArrayOfChar)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      if (paramInt1 + 1 < paramInt2)
      {
        paramArrayOfChar[i] = ((char)dec_uint16le(paramArrayOfByte, paramInt1));
        if (paramArrayOfChar[i] != 0) {}
      }
      else
      {
        return new String(paramArrayOfChar, 0, i);
      }
      i += 1;
      paramInt1 += 2;
    }
  }
  
  public static short dec_uint16be(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)((paramArrayOfByte[paramInt] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF);
  }
  
  public static short dec_uint16le(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8);
  }
  
  public static int dec_uint32be(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  public static int dec_uint32le(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  public static long dec_uint64be(byte[] paramArrayOfByte, int paramInt)
  {
    return (dec_uint32be(paramArrayOfByte, paramInt) & 0xFFFFFFFF) << 32 | dec_uint32be(paramArrayOfByte, paramInt + 4) & 0xFFFFFFFF;
  }
  
  public static long dec_uint64le(byte[] paramArrayOfByte, int paramInt)
  {
    return (dec_uint32le(paramArrayOfByte, paramInt + 4) & 0xFFFFFFFF) << 32 | dec_uint32le(paramArrayOfByte, paramInt) & 0xFFFFFFFF;
  }
  
  public static String dec_utf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    char[] arrayOfChar = new char[paramInt2 - paramInt1];
    int i = 0;
    if (paramInt1 < paramInt2)
    {
      int j = paramInt1 + 1;
      paramInt1 = paramArrayOfByte[paramInt1] & 0xFF;
      if (paramInt1 != 0)
      {
        if (paramInt1 < 128)
        {
          arrayOfChar[i] = ((char)paramInt1);
          paramInt1 = j;
        }
        label137:
        label147:
        do
        {
          for (;;)
          {
            i += 1;
            break;
            if ((paramInt1 & 0xE0) != 192) {
              break label147;
            }
            if (paramInt2 - j < 2) {
              break label303;
            }
            arrayOfChar[i] = ((char)((paramInt1 & 0x1F) << 6));
            paramInt1 = paramArrayOfByte[j] & 0xFF;
            arrayOfChar[i] = ((char)(arrayOfChar[i] | paramInt1 & 0x3F));
            if (((paramInt1 & 0xC0) != 128) || (arrayOfChar[i] < '')) {
              break label137;
            }
            paramInt1 = j + 1;
          }
          throw new IOException("Invalid UTF-8 sequence");
          if ((paramInt1 & 0xF0) != 224) {
            throw new IOException("Unsupported UTF-8 sequence");
          }
          if (paramInt2 - j < 3) {
            break label303;
          }
          arrayOfChar[i] = ((char)((paramInt1 & 0xF) << 12));
          int k = j + 1;
          paramInt1 = paramArrayOfByte[j] & 0xFF;
          if ((paramInt1 & 0xC0) != 128) {
            throw new IOException("Invalid UTF-8 sequence");
          }
          arrayOfChar[i] = ((char)((paramInt1 & 0x3F) << 6 | arrayOfChar[i]));
          paramInt1 = k + 1;
          j = paramArrayOfByte[k] & 0xFF;
          arrayOfChar[i] = ((char)(arrayOfChar[i] | j & 0x3F));
        } while (((j & 0xC0) == 128) && (arrayOfChar[i] >= 'ࠀ'));
        throw new IOException("Invalid UTF-8 sequence");
      }
    }
    label303:
    return new String(arrayOfChar, 0, i);
  }
  
  public static int enc_doublebe(double paramDouble, byte[] paramArrayOfByte, int paramInt)
  {
    return enc_uint64be(Double.doubleToLongBits(paramDouble), paramArrayOfByte, paramInt);
  }
  
  public static int enc_doublele(double paramDouble, byte[] paramArrayOfByte, int paramInt)
  {
    return enc_uint64le(Double.doubleToLongBits(paramDouble), paramArrayOfByte, paramInt);
  }
  
  public static int enc_floatbe(float paramFloat, byte[] paramArrayOfByte, int paramInt)
  {
    return enc_uint32be(Float.floatToIntBits(paramFloat), paramArrayOfByte, paramInt);
  }
  
  public static int enc_floatle(float paramFloat, byte[] paramArrayOfByte, int paramInt)
  {
    return enc_uint32le(Float.floatToIntBits(paramFloat), paramArrayOfByte, paramInt);
  }
  
  public static int enc_time(Date paramDate, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("Unsupported time encoding");
    case 1: 
      return enc_uint32be((int)(paramDate.getTime() / 1000L), paramArrayOfByte, paramInt1);
    case 2: 
      return enc_uint32le((int)(paramDate.getTime() / 1000L), paramArrayOfByte, paramInt1);
    case 3: 
      return enc_uint32be((int)(paramDate.getTime() / 1000L + 2082844800L & 0xFFFFFFFF), paramArrayOfByte, paramInt1);
    case 4: 
      return enc_uint32le((int)(paramDate.getTime() / 1000L + 2082844800L & 0xFFFFFFFF), paramArrayOfByte, paramInt1);
    case 5: 
      return enc_uint64le((paramDate.getTime() + 11644473600000L) * 10000L, paramArrayOfByte, paramInt1);
    case 6: 
      return enc_uint64be((paramDate.getTime() + 11644473600000L) * 10000L, paramArrayOfByte, paramInt1);
    case 7: 
      return enc_uint64be(paramDate.getTime(), paramArrayOfByte, paramInt1);
    }
    return enc_uint64le(paramDate.getTime(), paramArrayOfByte, paramInt1);
  }
  
  public static int enc_uint16be(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort & 0xFF));
    return 2;
  }
  
  public static int enc_uint16le(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(paramShort & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort >> 8 & 0xFF));
    return 2;
  }
  
  public static int enc_uint32be(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 & 0xFF));
    return 4;
  }
  
  public static int enc_uint32le(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 24 & 0xFF));
    return 4;
  }
  
  public static int enc_uint64be(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    enc_uint32be((int)(paramLong & 0xFFFFFFFF), paramArrayOfByte, paramInt + 4);
    enc_uint32be((int)(paramLong >> 32 & 0xFFFFFFFF), paramArrayOfByte, paramInt);
    return 8;
  }
  
  public static int enc_uint64le(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    enc_uint32le((int)(paramLong & 0xFFFFFFFF), paramArrayOfByte, paramInt);
    enc_uint32le((int)(paramLong >> 32 & 0xFFFFFFFF), paramArrayOfByte, paramInt + 4);
    return 8;
  }
  
  public static int enc_utf8(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int m = paramString.length();
    int j = 0;
    int i = paramInt1;
    int n;
    int k;
    if ((i < paramInt2) && (j < m))
    {
      n = paramString.charAt(j);
      if ((n >= 1) && (n <= 127))
      {
        k = i + 1;
        paramArrayOfByte[i] = ((byte)n);
        i = k;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (n > 2047) {
        if (paramInt2 - i >= 3) {}
      }
      while (paramInt2 - i < 2)
      {
        return i - paramInt1;
        k = i + 1;
        paramArrayOfByte[i] = ((byte)(n >> 12 & 0xF | 0xE0));
        int i1 = k + 1;
        paramArrayOfByte[k] = ((byte)(n >> 6 & 0x3F | 0x80));
        i = i1 + 1;
        paramArrayOfByte[i1] = ((byte)(n >> 0 & 0x3F | 0x80));
        break;
      }
      k = i + 1;
      paramArrayOfByte[i] = ((byte)(n >> 6 & 0x1F | 0xC0));
      i = k + 1;
      paramArrayOfByte[k] = ((byte)(n >> 0 & 0x3F | 0x80));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.auth.Encdec
 * JD-Core Version:    0.7.0.1
 */