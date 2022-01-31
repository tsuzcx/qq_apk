package com.tencent.mobileqq.mqsafeedit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  private byte[] buffer = new byte[64];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  
  static {}
  
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
  
  public static byte[] getFileMd5(String paramString)
  {
    arrayOfByte2 = (byte[])null;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      File localFile = new File(paramString);
      arrayOfByte1 = arrayOfByte2;
      if (localFile.exists()) {
        arrayOfByte1 = getPartfileMd5(paramString, localFile.length());
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        byte[] arrayOfByte1 = arrayOfByte2;
      }
    }
    return arrayOfByte1;
  }
  
  /* Error */
  public static byte[] getPartfileMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +16 -> 17
    //   4: aload_0
    //   5: invokevirtual 58	java/lang/String:length	()I
    //   8: ifeq +9 -> 17
    //   11: lload_1
    //   12: lconst_0
    //   13: lcmp
    //   14: ifge +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aconst_null
    //   20: checkcast 54	[B
    //   23: astore 9
    //   25: aconst_null
    //   26: astore 7
    //   28: aconst_null
    //   29: astore 10
    //   31: new 81	java/io/FileInputStream
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   39: astore 8
    //   41: new 60	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 67	java/io/File:exists	()Z
    //   54: ifeq +50 -> 104
    //   57: aload_0
    //   58: invokevirtual 70	java/io/File:length	()J
    //   61: lstore 5
    //   63: lload_1
    //   64: lconst_0
    //   65: lcmp
    //   66: ifeq +157 -> 223
    //   69: lload_1
    //   70: lstore_3
    //   71: lload 5
    //   73: lload_1
    //   74: lcmp
    //   75: ifge +6 -> 81
    //   78: goto +145 -> 223
    //   81: aload 8
    //   83: lload_3
    //   84: invokestatic 86	com/tencent/mobileqq/mqsafeedit/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   87: astore_0
    //   88: aload 8
    //   90: ifnull +107 -> 197
    //   93: aload 8
    //   95: invokevirtual 89	java/io/FileInputStream:close	()V
    //   98: aload_0
    //   99: astore 7
    //   101: aload 7
    //   103: areturn
    //   104: aload 8
    //   106: ifnull -89 -> 17
    //   109: aload 8
    //   111: invokevirtual 89	java/io/FileInputStream:close	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore 8
    //   125: aload 10
    //   127: astore_0
    //   128: aload_0
    //   129: astore 7
    //   131: aload 8
    //   133: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   136: aload 9
    //   138: astore 7
    //   140: aload_0
    //   141: ifnull -40 -> 101
    //   144: aload_0
    //   145: invokevirtual 89	java/io/FileInputStream:close	()V
    //   148: aload 9
    //   150: astore 7
    //   152: goto -51 -> 101
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   160: aload 9
    //   162: astore 7
    //   164: goto -63 -> 101
    //   167: astore_0
    //   168: aload 7
    //   170: ifnull +8 -> 178
    //   173: aload 7
    //   175: invokevirtual 89	java/io/FileInputStream:close	()V
    //   178: aload_0
    //   179: athrow
    //   180: astore 7
    //   182: aload 7
    //   184: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   187: goto -9 -> 178
    //   190: astore 7
    //   192: aload 7
    //   194: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   197: aload_0
    //   198: astore 7
    //   200: goto -99 -> 101
    //   203: astore_0
    //   204: aload 8
    //   206: astore 7
    //   208: goto -40 -> 168
    //   211: astore 7
    //   213: aload 8
    //   215: astore_0
    //   216: aload 7
    //   218: astore 8
    //   220: goto -92 -> 128
    //   223: lload 5
    //   225: lstore_3
    //   226: goto -145 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramString	String
    //   0	229	1	paramLong	long
    //   70	156	3	l1	long
    //   61	163	5	l2	long
    //   26	148	7	localObject1	Object
    //   180	3	7	localIOException1	IOException
    //   190	3	7	localIOException2	IOException
    //   198	9	7	localObject2	Object
    //   211	6	7	localException1	Exception
    //   39	71	8	localFileInputStream	java.io.FileInputStream
    //   123	91	8	localException2	Exception
    //   218	1	8	localException3	Exception
    //   23	138	9	arrayOfByte	byte[]
    //   29	97	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   109	114	116	java/io/IOException
    //   31	41	123	java/lang/Exception
    //   144	148	155	java/io/IOException
    //   31	41	167	finally
    //   131	136	167	finally
    //   173	178	180	java/io/IOException
    //   93	98	190	java/io/IOException
    //   41	63	203	finally
    //   81	88	203	finally
    //   41	63	211	java/lang/Exception
    //   81	88	211	java/lang/Exception
  }
  
  public static byte[] sysGetBufferMd5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static byte[] sysGetStremMd5(InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +9 -> 10
    //   4: lload_1
    //   5: lconst_0
    //   6: lcmp
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: ldc 96
    //   14: invokestatic 102	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore 6
    //   19: ldc 112
    //   21: newarray byte
    //   23: astore 7
    //   25: aload 7
    //   27: arraylength
    //   28: istore_3
    //   29: lconst_0
    //   30: lstore 4
    //   32: lload 4
    //   34: lload_1
    //   35: lcmp
    //   36: iflt +13 -> 49
    //   39: aload_0
    //   40: invokevirtual 115	java/io/InputStream:close	()V
    //   43: aload 6
    //   45: invokevirtual 109	java/security/MessageDigest:digest	()[B
    //   48: areturn
    //   49: aload 7
    //   51: arraylength
    //   52: i2l
    //   53: lload 4
    //   55: ladd
    //   56: lload_1
    //   57: lcmp
    //   58: ifle +9 -> 67
    //   61: lload_1
    //   62: lload 4
    //   64: lsub
    //   65: l2i
    //   66: istore_3
    //   67: aload_0
    //   68: aload 7
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 119	java/io/InputStream:read	([BII)I
    //   75: istore_3
    //   76: iload_3
    //   77: iflt -67 -> 10
    //   80: aload 6
    //   82: aload 7
    //   84: iconst_0
    //   85: iload_3
    //   86: invokevirtual 106	java/security/MessageDigest:update	([BII)V
    //   89: lload 4
    //   91: iload_3
    //   92: i2l
    //   93: ladd
    //   94: lstore 4
    //   96: goto -64 -> 32
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 110	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: goto -71 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramInputStream	InputStream
    //   0	117	1	paramLong	long
    //   28	64	3	i	int
    //   30	65	4	l	long
    //   17	64	6	localMessageDigest	MessageDigest
    //   23	60	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	29	99	java/security/NoSuchAlgorithmException
    //   39	43	99	java/security/NoSuchAlgorithmException
    //   43	49	99	java/security/NoSuchAlgorithmException
    //   49	61	99	java/security/NoSuchAlgorithmException
    //   67	76	99	java/security/NoSuchAlgorithmException
    //   80	89	99	java/security/NoSuchAlgorithmException
    //   12	29	106	java/io/IOException
    //   39	43	106	java/io/IOException
    //   43	49	106	java/io/IOException
    //   49	61	106	java/io/IOException
    //   67	76	106	java/io/IOException
    //   80	89	106	java/io/IOException
    //   39	43	113	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    Object localObject = (byte[])null;
    if (paramString == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      try
      {
        localObject = paramString.getBytes("ISO8859_1");
        paramString = (String)localObject;
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
      arrayOfByte = new MD5().getMD5(paramString, 0, paramString.length);
      localObject = "";
      paramString = (String)localObject;
    } while (arrayOfByte == null);
    i = 0;
    for (;;)
    {
      paramString = (String)localObject;
      if (i >= 16) {
        break;
      }
      localObject = localObject + byteHEX(arrayOfByte[i]);
      i += 1;
    }
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      localObject = null;
      return localObject;
    }
    byte[] arrayOfByte = new MD5().getMD5(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = "";
    int i = 0;
    for (;;)
    {
      localObject = paramArrayOfByte;
      if (i >= 16) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte + byteHEX(arrayOfByte[i]);
      i += 1;
    }
  }
  
  public static byte[] toMD5Byte(InputStream paramInputStream, long paramLong)
  {
    return new MD5().getMD5(paramInputStream, paramLong);
  }
  
  public static byte[] toMD5Byte(String paramString)
  {
    byte[] arrayOfByte = (byte[])null;
    if (paramString == null) {
      return null;
    }
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
    return new MD5().getMD5(paramString, 0, paramString.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte)
  {
    return toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new MD5().getMD5(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  native byte[] getBufferMd5(byte[] paramArrayOfByte);
  
  public byte[] getMD5(InputStream paramInputStream, long paramLong)
  {
    if ((paramInputStream == null) || (paramLong < 0L)) {}
    long l1;
    do
    {
      for (;;)
      {
        return null;
        try
        {
          long l2 = paramInputStream.available();
          if (paramLong != 0L)
          {
            l1 = paramLong;
            if (l2 != 0L)
            {
              l1 = paramLong;
              if (paramInputStream.available() >= paramLong) {}
            }
          }
          else
          {
            int i = paramInputStream.available();
            l1 = i;
          }
          if (l1 != 0L)
          {
            byte[] arrayOfByte1 = (byte[])null;
            arrayOfByte1 = sysGetStremMd5(paramInputStream, l1);
            if (arrayOfByte1 == null) {
              break label120;
            }
            this.digest = arrayOfByte1;
            return this.digest;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    } while (paramInputStream == null);
    try
    {
      paramInputStream.close();
      return null;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    try
    {
      label120:
      byte[] arrayOfByte2 = getStremMd5(paramInputStream, l1);
      localObject = arrayOfByte2;
      paramInputStream.close();
      localObject = arrayOfByte2;
    }
    catch (Exception paramInputStream)
    {
      for (;;)
      {
        Object localObject;
        paramInputStream.printStackTrace();
      }
    }
    if (localObject != null)
    {
      this.digest = localObject;
      return this.digest;
    }
    return this.digest;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt1 < 0)) {
      return null;
    }
    byte[] arrayOfByte = (byte[])null;
    arrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
    if (arrayOfByte != null)
    {
      this.digest = arrayOfByte;
      return this.digest;
    }
    try
    {
      paramArrayOfByte = getBufferMd5(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        this.digest = paramArrayOfByte;
        return this.digest;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = arrayOfByte;
      }
    }
    return this.digest;
  }
  
  native byte[] getStremMd5(InputStream paramInputStream, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.MD5
 * JD-Core Version:    0.7.0.1
 */