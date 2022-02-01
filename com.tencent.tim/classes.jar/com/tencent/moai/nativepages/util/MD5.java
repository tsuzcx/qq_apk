package com.tencent.moai.nativepages.util;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public class MD5
{
  public static String getMD5(File paramFile)
  {
    return getMD5(paramFile, 102400);
  }
  
  /* Error */
  public static String getMD5(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: iload_1
    //   5: ifle +10 -> 15
    //   8: aload_0
    //   9: invokevirtual 25	java/io/File:exists	()Z
    //   12: ifne +7 -> 19
    //   15: aconst_null
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    //   19: new 27	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore 4
    //   29: iload_1
    //   30: i2l
    //   31: lstore_2
    //   32: lload_2
    //   33: aload_0
    //   34: invokevirtual 34	java/io/File:length	()J
    //   37: lcmp
    //   38: ifgt +40 -> 78
    //   41: iload_1
    //   42: i2l
    //   43: lstore_2
    //   44: aload 4
    //   46: lload_2
    //   47: l2i
    //   48: invokestatic 37	com/tencent/moai/nativepages/util/MD5:getMD5	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   51: astore 5
    //   53: aload 4
    //   55: invokevirtual 40	java/io/FileInputStream:close	()V
    //   58: aload 5
    //   60: astore_0
    //   61: aload 4
    //   63: ifnull -46 -> 17
    //   66: aload 4
    //   68: invokevirtual 40	java/io/FileInputStream:close	()V
    //   71: aload 5
    //   73: areturn
    //   74: astore_0
    //   75: aload 5
    //   77: areturn
    //   78: aload_0
    //   79: invokevirtual 34	java/io/File:length	()J
    //   82: lstore_2
    //   83: goto -39 -> 44
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +7 -> 97
    //   93: aload_0
    //   94: invokevirtual 40	java/io/FileInputStream:close	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +8 -> 113
    //   108: aload 4
    //   110: invokevirtual 40	java/io/FileInputStream:close	()V
    //   113: aload_0
    //   114: athrow
    //   115: astore_0
    //   116: goto -19 -> 97
    //   119: astore 4
    //   121: goto -8 -> 113
    //   124: astore_0
    //   125: goto -22 -> 103
    //   128: astore_0
    //   129: aload 4
    //   131: astore_0
    //   132: goto -43 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramFile	File
    //   0	135	1	paramInt	int
    //   31	52	2	l	long
    //   27	82	4	localFileInputStream	java.io.FileInputStream
    //   119	11	4	localIOException	java.io.IOException
    //   51	25	5	str	String
    // Exception table:
    //   from	to	target	type
    //   66	71	74	java/io/IOException
    //   19	29	86	java/lang/Exception
    //   19	29	99	finally
    //   93	97	115	java/io/IOException
    //   108	113	119	java/io/IOException
    //   32	41	124	finally
    //   44	58	124	finally
    //   78	83	124	finally
    //   32	41	128	java/lang/Exception
    //   44	58	128	java/lang/Exception
    //   78	83	128	java/lang/Exception
  }
  
  /* Error */
  public static String getMD5(File paramFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +18 -> 19
    //   4: aload_0
    //   5: invokevirtual 25	java/io/File:exists	()Z
    //   8: ifeq +11 -> 19
    //   11: iload_1
    //   12: iflt +7 -> 19
    //   15: iload_2
    //   16: ifgt +7 -> 23
    //   19: aconst_null
    //   20: astore_3
    //   21: aload_3
    //   22: areturn
    //   23: new 27	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: aload_0
    //   33: ldc 12
    //   35: iload_1
    //   36: iload_2
    //   37: invokestatic 44	com/tencent/moai/nativepages/util/MD5:getMD5	(Ljava/io/InputStream;III)Ljava/lang/String;
    //   40: astore 4
    //   42: aload_0
    //   43: invokevirtual 40	java/io/FileInputStream:close	()V
    //   46: aload 4
    //   48: astore_3
    //   49: aload_0
    //   50: ifnull -29 -> 21
    //   53: aload_0
    //   54: invokevirtual 40	java/io/FileInputStream:close	()V
    //   57: aload 4
    //   59: areturn
    //   60: astore_0
    //   61: aload 4
    //   63: areturn
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 40	java/io/FileInputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_3
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 40	java/io/FileInputStream:close	()V
    //   88: aload_3
    //   89: athrow
    //   90: astore_0
    //   91: goto -16 -> 75
    //   94: astore_0
    //   95: goto -7 -> 88
    //   98: astore_3
    //   99: goto -19 -> 80
    //   102: astore_3
    //   103: goto -36 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramFile	File
    //   0	106	1	paramInt1	int
    //   0	106	2	paramInt2	int
    //   20	29	3	localObject1	Object
    //   77	12	3	localObject2	Object
    //   98	1	3	localObject3	Object
    //   102	1	3	localException	Exception
    //   40	22	4	str	String
    // Exception table:
    //   from	to	target	type
    //   53	57	60	java/io/IOException
    //   23	32	64	java/lang/Exception
    //   23	32	77	finally
    //   71	75	90	java/io/IOException
    //   84	88	94	java/io/IOException
    //   32	46	98	finally
    //   32	46	102	java/lang/Exception
  }
  
  public static final String getMD5(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    if ((paramInputStream == null) || (paramInt <= 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt];
      for (;;)
      {
        paramInt = paramInputStream.read(arrayOfByte);
        if (paramInt == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, paramInt);
      }
      paramInputStream = localMessageDigest.digest();
      paramInt = i;
      while (paramInt < paramInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
  }
  
  public static final String getMD5(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    return getMD5ExtendBytes(paramInputStream, paramInt1, paramInt2, paramInt3, null);
  }
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return getMD5(paramString, 102400);
  }
  
  public static String getMD5(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return getMD5(paramString, paramInt1, paramInt2);
  }
  
  /* Error */
  public static String getMD5ExtendBytes(File paramFile, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +18 -> 19
    //   4: aload_0
    //   5: invokevirtual 25	java/io/File:exists	()Z
    //   8: ifeq +11 -> 19
    //   11: iload_1
    //   12: iflt +7 -> 19
    //   15: iload_2
    //   16: ifgt +7 -> 23
    //   19: aconst_null
    //   20: astore_3
    //   21: aload_3
    //   22: areturn
    //   23: new 27	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: aload_0
    //   33: ldc 12
    //   35: iload_1
    //   36: iload_2
    //   37: aload_3
    //   38: invokestatic 94	com/tencent/moai/nativepages/util/MD5:getMD5ExtendBytes	(Ljava/io/InputStream;III[B)Ljava/lang/String;
    //   41: astore 4
    //   43: aload_0
    //   44: invokevirtual 40	java/io/FileInputStream:close	()V
    //   47: aload 4
    //   49: astore_3
    //   50: aload_0
    //   51: ifnull -30 -> 21
    //   54: aload_0
    //   55: invokevirtual 40	java/io/FileInputStream:close	()V
    //   58: aload 4
    //   60: areturn
    //   61: astore_0
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_0
    //   69: ifnull +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 40	java/io/FileInputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_3
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 40	java/io/FileInputStream:close	()V
    //   89: aload_3
    //   90: athrow
    //   91: astore_0
    //   92: goto -16 -> 76
    //   95: astore_0
    //   96: goto -7 -> 89
    //   99: astore_3
    //   100: goto -19 -> 81
    //   103: astore_3
    //   104: goto -36 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile	File
    //   0	107	1	paramInt1	int
    //   0	107	2	paramInt2	int
    //   0	107	3	paramArrayOfByte	byte[]
    //   41	22	4	str	String
    // Exception table:
    //   from	to	target	type
    //   54	58	61	java/io/IOException
    //   23	32	65	java/lang/Exception
    //   23	32	78	finally
    //   72	76	91	java/io/IOException
    //   85	89	95	java/io/IOException
    //   32	47	99	finally
    //   32	47	103	java/lang/Exception
  }
  
  public static final String getMD5ExtendBytes(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramInputStream == null) || (paramInt1 <= 0) || (paramInt2 < 0) || (paramInt3 <= 0)) {}
    for (;;)
    {
      return null;
      long l = paramInt2;
      try
      {
        if (paramInputStream.skip(l) >= paramInt2)
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          StringBuilder localStringBuilder = new StringBuilder(32);
          byte[] arrayOfByte = new byte[paramInt1];
          paramInt1 = 0;
          for (;;)
          {
            paramInt2 = paramInputStream.read(arrayOfByte);
            if ((paramInt2 == -1) || (paramInt1 >= paramInt3)) {
              break;
            }
            if (paramInt1 + paramInt2 <= paramInt3)
            {
              localMessageDigest.update(arrayOfByte, 0, paramInt2);
              paramInt1 += paramInt2;
            }
            else
            {
              localMessageDigest.update(arrayOfByte, 0, paramInt3 - paramInt1);
              paramInt1 = paramInt3;
            }
          }
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
            localMessageDigest.update(paramArrayOfByte);
          }
          paramInputStream = localMessageDigest.digest();
          paramInt1 = i;
          while (paramInt1 < paramInputStream.length)
          {
            localStringBuilder.append(Integer.toString((paramInputStream[paramInt1] & 0xFF) + 256, 16).substring(1));
            paramInt1 += 1;
          }
          paramInputStream = localStringBuilder.toString();
          return paramInputStream;
        }
      }
      catch (Exception paramInputStream) {}
    }
    return null;
  }
  
  public static final String getMessageDigest(byte[] paramArrayOfByte)
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
      int k;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < k)
      {
        int m = paramArrayOfByte[i];
        int n = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        j = n + 1;
        localObject[n] = arrayOfChar[(m & 0xF)];
        i += 1;
      }
    }
  }
  
  public static final byte[] getRawDigest(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.MD5
 * JD-Core Version:    0.7.0.1
 */