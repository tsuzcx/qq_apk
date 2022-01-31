package com.tencent.mm.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public final class MD5
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
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 27	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: iload_1
    //   28: i2l
    //   29: lstore_2
    //   30: lload_2
    //   31: aload_0
    //   32: invokevirtual 34	java/io/File:length	()J
    //   35: lcmp
    //   36: ifgt +30 -> 66
    //   39: iload_1
    //   40: i2l
    //   41: lstore_2
    //   42: aload 4
    //   44: lload_2
    //   45: l2i
    //   46: invokestatic 37	com/tencent/mm/algorithm/MD5:getMD5	(Ljava/io/FileInputStream;I)Ljava/lang/String;
    //   49: astore_0
    //   50: aload 4
    //   52: invokevirtual 40	java/io/FileInputStream:close	()V
    //   55: aload 4
    //   57: invokevirtual 40	java/io/FileInputStream:close	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore 4
    //   64: aload_0
    //   65: areturn
    //   66: aload_0
    //   67: invokevirtual 34	java/io/File:length	()J
    //   70: lstore_2
    //   71: goto -29 -> 42
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 40	java/io/FileInputStream:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: astore 4
    //   91: aload 4
    //   93: ifnull +8 -> 101
    //   96: aload 4
    //   98: invokevirtual 40	java/io/FileInputStream:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: astore_0
    //   104: goto -19 -> 85
    //   107: astore 4
    //   109: goto -8 -> 101
    //   112: astore_0
    //   113: goto -22 -> 91
    //   116: astore_0
    //   117: aload 4
    //   119: astore_0
    //   120: goto -43 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramFile	File
    //   0	123	1	paramInt	int
    //   29	42	2	l	long
    //   25	31	4	localFileInputStream	FileInputStream
    //   62	1	4	localIOException1	java.io.IOException
    //   89	8	4	localObject	Object
    //   107	11	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   55	60	62	java/io/IOException
    //   17	27	74	java/lang/Exception
    //   17	27	87	finally
    //   81	85	103	java/io/IOException
    //   96	101	107	java/io/IOException
    //   30	39	112	finally
    //   42	55	112	finally
    //   66	71	112	finally
    //   30	39	116	java/lang/Exception
    //   42	55	116	java/lang/Exception
    //   66	71	116	java/lang/Exception
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
    //   16: ifgt +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 27	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: ldc 12
    //   33: iload_1
    //   34: iload_2
    //   35: invokestatic 44	com/tencent/mm/algorithm/MD5:getMD5	(Ljava/io/FileInputStream;III)Ljava/lang/String;
    //   38: astore_3
    //   39: aload_0
    //   40: invokevirtual 40	java/io/FileInputStream:close	()V
    //   43: aload_0
    //   44: invokevirtual 40	java/io/FileInputStream:close	()V
    //   47: aload_3
    //   48: areturn
    //   49: astore_0
    //   50: aload_3
    //   51: areturn
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 40	java/io/FileInputStream:close	()V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_3
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_0
    //   69: ifnull +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 40	java/io/FileInputStream:close	()V
    //   76: aload_3
    //   77: athrow
    //   78: astore_0
    //   79: goto -16 -> 63
    //   82: astore_0
    //   83: goto -7 -> 76
    //   86: astore_3
    //   87: goto -19 -> 68
    //   90: astore_3
    //   91: goto -36 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramFile	File
    //   0	94	1	paramInt1	int
    //   0	94	2	paramInt2	int
    //   38	13	3	str	String
    //   65	12	3	localObject1	Object
    //   86	1	3	localObject2	Object
    //   90	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/io/IOException
    //   21	30	52	java/lang/Exception
    //   21	30	65	finally
    //   59	63	78	java/io/IOException
    //   72	76	82	java/io/IOException
    //   30	43	86	finally
    //   30	43	90	java/lang/Exception
  }
  
  public static final String getMD5(FileInputStream paramFileInputStream, int paramInt)
  {
    int i = 0;
    if ((paramFileInputStream == null) || (paramInt <= 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt];
      for (;;)
      {
        paramInt = paramFileInputStream.read(arrayOfByte);
        if (paramInt == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, paramInt);
      }
      paramFileInputStream = localMessageDigest.digest();
      paramInt = i;
      while (paramInt < paramFileInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramFileInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      paramFileInputStream = localStringBuilder.toString();
      return paramFileInputStream;
    }
    catch (Exception paramFileInputStream) {}
    return null;
  }
  
  public static final String getMD5(FileInputStream paramFileInputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    if ((paramFileInputStream == null) || (paramInt1 <= 0) || (paramInt2 < 0) || (paramInt3 <= 0)) {}
    for (;;)
    {
      return null;
      long l = paramInt2;
      try
      {
        if (paramFileInputStream.skip(l) >= paramInt2)
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          StringBuilder localStringBuilder = new StringBuilder(32);
          byte[] arrayOfByte = new byte[paramInt1];
          paramInt1 = 0;
          for (;;)
          {
            paramInt2 = paramFileInputStream.read(arrayOfByte);
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
          paramFileInputStream = localMessageDigest.digest();
          paramInt1 = i;
          while (paramInt1 < paramFileInputStream.length)
          {
            localStringBuilder.append(Integer.toString((paramFileInputStream[paramInt1] & 0xFF) + 256, 16).substring(1));
            paramInt1 += 1;
          }
          paramFileInputStream = localStringBuilder.toString();
          return paramFileInputStream;
        }
      }
      catch (Exception paramFileInputStream) {}
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.MD5
 * JD-Core Version:    0.7.0.1
 */