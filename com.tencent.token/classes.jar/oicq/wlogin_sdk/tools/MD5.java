package oicq.wlogin_sdk.tools;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5
{
  static final byte[] PADDING = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  static final int S11 = 7;
  static final int S12 = 12;
  static final int S13 = 17;
  static final int S14 = 22;
  static final int S21 = 5;
  static final int S22 = 9;
  static final int S23 = 14;
  static final int S24 = 20;
  static final int S31 = 4;
  static final int S32 = 11;
  static final int S33 = 16;
  static final int S34 = 23;
  static final int S41 = 6;
  static final int S42 = 10;
  static final int S43 = 15;
  static final int S44 = 21;
  private byte[] buffer = new byte[64];
  private long[] count = new long[2];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  private long[] state = new long[4];
  
  public MD5()
  {
    md5Init();
  }
  
  private void Decode(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfLong[j] = (b2iu(paramArrayOfByte[i]) | b2iu(paramArrayOfByte[(i + 1)]) << 8 | b2iu(paramArrayOfByte[(i + 2)]) << 16 | b2iu(paramArrayOfByte[(i + 3)]) << 24);
      j += 1;
      i += 4;
    }
  }
  
  private void Encode(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfLong[j] & 0xFF));
      paramArrayOfByte[(i + 1)] = ((byte)(int)(paramArrayOfLong[j] >>> 8 & 0xFF));
      paramArrayOfByte[(i + 2)] = ((byte)(int)(paramArrayOfLong[j] >>> 16 & 0xFF));
      paramArrayOfByte[(i + 3)] = ((byte)(int)(0xFF & paramArrayOfLong[j] >>> 24));
      j += 1;
      i += 4;
    }
  }
  
  private long F(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 ^ 0xFFFFFFFF) & paramLong3 | paramLong2 & paramLong1;
  }
  
  private long FF(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(F(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long G(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | paramLong2 & (paramLong3 ^ 0xFFFFFFFF);
  }
  
  private long GG(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(G(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long H(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long HH(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(H(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long I(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 | paramLong3 ^ 0xFFFFFFFF) ^ paramLong2;
  }
  
  private long II(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(I(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static long b2iu(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte & 0xFF;
    }
    return i;
  }
  
  public static String byteHEX(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static String getFileMD5(File paramFile)
  {
    if (paramFile == null) {
      return "";
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int i;
      int j;
      try
      {
        localObject1 = new FileInputStream(paramFile);
        localObject2 = new byte[8192];
        paramFile = new char[16];
        paramFile[0] = 48;
        paramFile[1] = 49;
        paramFile[2] = 50;
        paramFile[3] = 51;
        paramFile[4] = 52;
        paramFile[5] = 53;
        paramFile[6] = 54;
        paramFile[7] = 55;
        paramFile[8] = 56;
        paramFile[9] = 57;
        paramFile[10] = 97;
        paramFile[11] = 98;
        paramFile[12] = 99;
        paramFile[13] = 100;
        paramFile[14] = 101;
        paramFile[15] = 102;
        paramFile;
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          i = localObject2.length;
          j = 0;
          i = ((FileInputStream)localObject1).read((byte[])localObject2, 0, i);
          if (i != -1)
          {
            localMessageDigest.update((byte[])localObject2, 0, i);
            continue;
          }
          ((FileInputStream)localObject1).close();
          localObject1 = localMessageDigest.digest();
          localObject2 = new char[32];
          i = 0;
        }
        catch (Exception paramFile)
        {
          paramFile.printStackTrace();
          return null;
        }
        paramFile = new String((char[])localObject2);
        return paramFile;
      }
      catch (Exception paramFile)
      {
        util.printException(paramFile, "");
        return "";
      }
      while (j < 16)
      {
        int k = localObject1[j];
        int m = i + 1;
        localObject2[i] = paramFile[(k >>> 4 & 0xF)];
        i = m + 1;
        localObject2[m] = paramFile[(k & 0xF)];
        j += 1;
      }
    }
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < 16)
      {
        int k = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(k >>> 4 & 0xF)];
        j = m + 1;
        localObject[m] = arrayOfChar[(k & 0xF)];
        i += 1;
      }
    }
  }
  
  private void md5Final()
  {
    byte[] arrayOfByte = new byte[8];
    Encode(arrayOfByte, this.count, 8);
    int i = (int)(this.count[0] >>> 3) & 0x3F;
    if (i < 56) {
      i = 56 - i;
    } else {
      i = 120 - i;
    }
    md5Update(PADDING, i);
    md5Update(arrayOfByte, 8);
    Encode(this.digest, this.state, 16);
  }
  
  private void md5Init()
  {
    long[] arrayOfLong = this.count;
    arrayOfLong[0] = 0L;
    arrayOfLong[1] = 0L;
    arrayOfLong = this.state;
    arrayOfLong[0] = 1732584193L;
    arrayOfLong[1] = 4023233417L;
    arrayOfLong[2] = 2562383102L;
    arrayOfLong[3] = 271733878L;
  }
  
  private void md5Memcpy(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfByte1[(paramInt1 + i)] = paramArrayOfByte2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private void md5Transform(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = this.state;
    long l2 = arrayOfLong[0];
    long l1 = arrayOfLong[1];
    long l4 = arrayOfLong[2];
    long l3 = arrayOfLong[3];
    arrayOfLong = new long[16];
    Decode(arrayOfLong, paramArrayOfByte, 64);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[1], 12L, 3905402710L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[3], 22L, 3250441966L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[5], 12L, 1200080426L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[7], 22L, 4249261313L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[9], 12L, 2336552879L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[11], 22L, 2304563134L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[13], 12L, 4254626195L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[15], 22L, 1236535329L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[6], 9L, 3225465664L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[0], 20L, 3921069994L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[10], 9L, 38016083L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[4], 20L, 3889429448L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[14], 9L, 3275163606L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[8], 20L, 1163531501L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[2], 9L, 4243563512L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[12], 20L, 2368359562L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[8], 11L, 2272392833L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[14], 23L, 4259657740L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[4], 11L, 1272893353L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[10], 23L, 3200236656L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[0], 11L, 3936430074L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[6], 23L, 76029189L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[12], 11L, 3873151461L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[2], 23L, 3299628645L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[7], 10L, 1126891415L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[5], 21L, 4237533241L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[3], 10L, 2399980690L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[1], 21L, 2240044497L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[15], 10L, 4264355552L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[13], 21L, 1309151649L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[11], 10L, 3174756917L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.state;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte[1] += l1;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte[3] += l3;
  }
  
  private void md5Update(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    long[] arrayOfLong = this.count;
    int j = (int)(arrayOfLong[0] >>> 3) & 0x3F;
    long l2 = arrayOfLong[0];
    long l1 = paramInt << 3;
    l2 += l1;
    arrayOfLong[0] = l2;
    if (l2 < l1) {
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.count;
    arrayOfLong[1] += (paramInt >>> 29);
    int i = 64 - j;
    if (paramInt >= i)
    {
      md5Memcpy(this.buffer, paramArrayOfByte, j, 0, i);
      md5Transform(this.buffer);
      while (i + 63 < paramInt)
      {
        md5Memcpy(arrayOfByte, paramArrayOfByte, 0, i, 64);
        md5Transform(arrayOfByte);
        i += 64;
      }
      j = 0;
    }
    else
    {
      i = 0;
    }
    md5Memcpy(this.buffer, paramArrayOfByte, j, i, paramInt - i);
  }
  
  private boolean md5Update(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[64];
    Object localObject = this.count;
    int j = (int)(localObject[0] >>> 3) & 0x3F;
    long l2 = localObject[0];
    long l1 = paramLong << 3;
    l2 += l1;
    localObject[0] = l2;
    if (l2 < l1) {
      localObject[1] += 1L;
    }
    localObject = this.count;
    localObject[1] += (paramLong >>> 29);
    int i = 64 - j;
    if (paramLong >= i)
    {
      localObject = new byte[i];
      try
      {
        paramInputStream.read((byte[])localObject, 0, i);
        md5Memcpy(this.buffer, (byte[])localObject, j, 0, i);
        md5Transform(this.buffer);
        while (i + 63 < paramLong) {
          try
          {
            paramInputStream.read(arrayOfByte);
            md5Transform(arrayOfByte);
            i += 64;
          }
          catch (Exception paramInputStream)
          {
            paramInputStream.printStackTrace();
            return false;
          }
        }
        j = 0;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return false;
      }
    }
    else
    {
      i = 0;
    }
    arrayOfByte = new byte[(int)(paramLong - i)];
    try
    {
      paramInputStream.read(arrayOfByte);
      md5Memcpy(this.buffer, arrayOfByte, j, 0, arrayOfByte.length);
      return true;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return false;
  }
  
  public static String toMD5(String paramString)
  {
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      byte[] arrayOfByte;
      label13:
      int i;
      break label13;
    }
    paramString = paramString.getBytes();
    arrayOfByte = new MD5().getMD5(paramString);
    paramString = "";
    i = 0;
    while (i < 16)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(byteHEX(arrayOfByte[i]));
      paramString = localStringBuilder.toString();
      i += 1;
    }
    return paramString;
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new MD5().getMD5(paramArrayOfByte);
    paramArrayOfByte = "";
    int i = 0;
    while (i < 16)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append(byteHEX(arrayOfByte[i]));
      paramArrayOfByte = localStringBuilder.toString();
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  public static byte[] toMD5Byte(InputStream paramInputStream, long paramLong)
  {
    return new MD5().getMD5(paramInputStream, paramLong);
  }
  
  public static byte[] toMD5Byte(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label13:
      break label13;
    }
    paramString = paramString.getBytes();
    return new MD5().getMD5(paramString);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte)
  {
    return new MD5().getMD5(paramArrayOfByte);
  }
  
  public byte[] getMD5(InputStream paramInputStream, long paramLong)
  {
    md5Init();
    if (!md5Update(paramInputStream, paramLong)) {
      return new byte[16];
    }
    md5Final();
    return this.digest;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte)
  {
    md5Init();
    md5Update(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    md5Final();
    return this.digest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.MD5
 * JD-Core Version:    0.7.0.1
 */