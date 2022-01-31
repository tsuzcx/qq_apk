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
      paramArrayOfByte[(i + 3)] = ((byte)(int)(paramArrayOfLong[j] >>> 24 & 0xFF));
      j += 1;
      i += 4;
    }
  }
  
  private long F(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong2 | (0xFFFFFFFF ^ paramLong1) & paramLong3;
  }
  
  private long FF(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = F(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long G(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | (0xFFFFFFFF ^ paramLong3) & paramLong2;
  }
  
  private long GG(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = G(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long H(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long HH(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = H(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long I(long paramLong1, long paramLong2, long paramLong3)
  {
    return (0xFFFFFFFF ^ paramLong3 | paramLong1) ^ paramLong2;
  }
  
  private long II(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = I(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static long b2iu(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
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
    int i = 0;
    Object localObject1 = new FileInputStream(paramFile);
    Object localObject2 = new byte[1024];
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
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        j = ((FileInputStream)localObject1).read((byte[])localObject2, 0, 1024);
        if (j == -1) {
          break;
        }
        localMessageDigest.update((byte[])localObject2, 0, j);
      }
      ((FileInputStream)localObject1).close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    localObject1 = localMessageDigest.digest();
    localObject2 = new char[32];
    int j = 0;
    for (;;)
    {
      paramFile = new String((char[])localObject2);
      return paramFile;
      while (i < 16)
      {
        int k = localObject1[i];
        int m = j + 1;
        localObject2[j] = paramFile[(k >>> 4 & 0xF)];
        j = m + 1;
        localObject2[m] = paramFile[(k & 0xF)];
        i += 1;
      }
    }
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar = new char[16];
    char[] tmp10_8 = arrayOfChar;
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
    tmp64_58[10] = 97;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 98;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 99;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 100;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 101;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 102;
    tmp94_88;
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new char[32];
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
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      md5Update(PADDING, i);
      md5Update(arrayOfByte, 8);
      Encode(this.digest, this.state, 16);
      return;
    }
  }
  
  private void md5Init()
  {
    this.count[0] = 0L;
    this.count[1] = 0L;
    this.state[0] = 1732584193L;
    this.state[1] = 4023233417L;
    this.state[2] = 2562383102L;
    this.state[3] = 271733878L;
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
    long l2 = this.state[0];
    long l1 = this.state[1];
    long l4 = this.state[2];
    long l3 = this.state[3];
    long[] arrayOfLong = new long[16];
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
    paramArrayOfByte = this.state;
    paramArrayOfByte[1] = (l1 + paramArrayOfByte[1]);
    paramArrayOfByte = this.state;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte = this.state;
    paramArrayOfByte[3] += l3;
  }
  
  private void md5Update(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[64];
    int k = (int)(this.count[0] >>> 3) & 0x3F;
    long[] arrayOfLong = this.count;
    long l = arrayOfLong[0] + (paramInt << 3);
    arrayOfLong[0] = l;
    if (l < paramInt << 3)
    {
      arrayOfLong = this.count;
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.count;
    arrayOfLong[1] += (paramInt >>> 29);
    int m = 64 - k;
    int i = k;
    if (paramInt >= m)
    {
      md5Memcpy(this.buffer, paramArrayOfByte, k, 0, m);
      md5Transform(this.buffer);
      i = m;
      while (i + 63 < paramInt)
      {
        md5Memcpy(arrayOfByte, paramArrayOfByte, 0, i, 64);
        md5Transform(arrayOfByte);
        i += 64;
      }
      k = 0;
      j = i;
      i = k;
    }
    md5Memcpy(this.buffer, paramArrayOfByte, i, j, paramInt - j);
  }
  
  private boolean md5Update(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[64];
    int j = (int)(this.count[0] >>> 3) & 0x3F;
    Object localObject = this.count;
    long l = localObject[0] + (paramLong << 3);
    localObject[0] = l;
    if (l < paramLong << 3)
    {
      localObject = this.count;
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
      }
      catch (Exception paramInputStream)
      {
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
        paramInputStream = paramInputStream;
        paramInputStream.printStackTrace();
        return false;
      }
      if (i + 63 < paramLong) {}
      j = 0;
    }
    for (;;)
    {
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
      i = 0;
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
      for (;;)
      {
        byte[] arrayOfByte;
        int i;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new MD5().getMD5(paramString);
    paramString = "";
    i = 0;
    while (i < 16)
    {
      paramString = paramString + byteHEX(arrayOfByte[i]);
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
      paramArrayOfByte = paramArrayOfByte + byteHEX(arrayOfByte[i]);
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
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.MD5
 * JD-Core Version:    0.7.0.1
 */