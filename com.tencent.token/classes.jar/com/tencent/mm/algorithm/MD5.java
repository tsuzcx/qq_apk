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
    //   1: ifnull +99 -> 100
    //   4: iload_1
    //   5: ifle +95 -> 100
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
    //   36: ifgt +6 -> 42
    //   39: goto +8 -> 47
    //   42: aload_0
    //   43: invokevirtual 34	java/io/File:length	()J
    //   46: lstore_2
    //   47: aload 4
    //   49: lload_2
    //   50: l2i
    //   51: invokestatic 37	com/tencent/mm/algorithm/MD5:getMD5	(Ljava/io/FileInputStream;I)Ljava/lang/String;
    //   54: astore_0
    //   55: aload 4
    //   57: invokevirtual 40	java/io/FileInputStream:close	()V
    //   60: aload 4
    //   62: invokevirtual 40	java/io/FileInputStream:close	()V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: goto +7 -> 75
    //   71: astore_0
    //   72: aconst_null
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +8 -> 85
    //   80: aload 4
    //   82: invokevirtual 40	java/io/FileInputStream:close	()V
    //   85: aload_0
    //   86: athrow
    //   87: aconst_null
    //   88: astore 4
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 40	java/io/FileInputStream:close	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: goto -16 -> 87
    //   106: astore_0
    //   107: goto -17 -> 90
    //   110: astore 4
    //   112: aload_0
    //   113: areturn
    //   114: astore 4
    //   116: goto -31 -> 85
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramFile	File
    //   0	122	1	paramInt	int
    //   29	21	2	l	long
    //   25	71	4	localFileInputStream	FileInputStream
    //   110	1	4	localIOException1	java.io.IOException
    //   114	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   30	39	67	finally
    //   42	47	67	finally
    //   47	60	67	finally
    //   17	27	71	finally
    //   17	27	102	java/lang/Exception
    //   30	39	106	java/lang/Exception
    //   42	47	106	java/lang/Exception
    //   47	60	106	java/lang/Exception
    //   60	65	110	java/io/IOException
    //   80	85	114	java/io/IOException
    //   95	100	119	java/io/IOException
  }
  
  /* Error */
  public static String getMD5(File paramFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnull +79 -> 82
    //   6: aload_0
    //   7: invokevirtual 25	java/io/File:exists	()Z
    //   10: ifeq +72 -> 82
    //   13: iload_1
    //   14: iflt +68 -> 82
    //   17: iload_2
    //   18: ifgt +5 -> 23
    //   21: aconst_null
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
    //   37: invokestatic 44	com/tencent/mm/algorithm/MD5:getMD5	(Ljava/io/FileInputStream;III)Ljava/lang/String;
    //   40: astore_3
    //   41: aload_0
    //   42: invokevirtual 40	java/io/FileInputStream:close	()V
    //   45: aload_0
    //   46: invokevirtual 40	java/io/FileInputStream:close	()V
    //   49: aload_3
    //   50: areturn
    //   51: astore 4
    //   53: aload_0
    //   54: astore_3
    //   55: aload 4
    //   57: astore_0
    //   58: goto +4 -> 62
    //   61: astore_0
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 40	java/io/FileInputStream:close	()V
    //   70: aload_0
    //   71: athrow
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_0
    //   75: ifnull +7 -> 82
    //   78: aload_0
    //   79: invokevirtual 40	java/io/FileInputStream:close	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: goto -13 -> 72
    //   88: astore_3
    //   89: goto -15 -> 74
    //   92: astore_0
    //   93: aload_3
    //   94: areturn
    //   95: astore_3
    //   96: goto -26 -> 70
    //   99: astore_0
    //   100: aconst_null
    //   101: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   0	102	1	paramInt1	int
    //   0	102	2	paramInt2	int
    //   1	66	3	localObject1	Object
    //   88	6	3	localException	Exception
    //   95	1	3	localIOException	java.io.IOException
    //   51	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	45	51	finally
    //   23	32	61	finally
    //   23	32	84	java/lang/Exception
    //   32	45	88	java/lang/Exception
    //   45	49	92	java/io/IOException
    //   66	70	95	java/io/IOException
    //   78	82	99	java/io/IOException
  }
  
  public static final String getMD5(FileInputStream paramFileInputStream, int paramInt)
  {
    if (paramFileInputStream != null) {
      if (paramInt <= 0) {
        return null;
      }
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt];
      for (;;)
      {
        int i = paramFileInputStream.read(arrayOfByte);
        paramInt = 0;
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFileInputStream = localMessageDigest.digest();
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
    return null;
  }
  
  public static final String getMD5(FileInputStream paramFileInputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    long l;
    if ((paramFileInputStream != null) && (paramInt1 > 0) && (paramInt2 >= 0))
    {
      if (paramInt3 <= 0) {
        return null;
      }
      l = paramInt2;
    }
    try
    {
      if (paramFileInputStream.skip(l) < l) {
        return null;
      }
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt1];
      paramInt2 = 0;
      paramInt1 = 0;
      for (;;)
      {
        int j = paramFileInputStream.read(arrayOfByte);
        if ((j == -1) || (paramInt1 >= paramInt3)) {
          break;
        }
        int i = paramInt1 + j;
        if (i <= paramInt3)
        {
          localMessageDigest.update(arrayOfByte, 0, j);
          paramInt1 = i;
        }
        else
        {
          localMessageDigest.update(arrayOfByte, 0, paramInt3 - paramInt1);
          paramInt1 = paramInt3;
        }
      }
      paramFileInputStream = localMessageDigest.digest();
      paramInt1 = paramInt2;
      while (paramInt1 < paramFileInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramFileInputStream[paramInt1] & 0xFF) + 256, 16).substring(1));
        paramInt1 += 1;
      }
      paramFileInputStream = localStringBuilder.toString();
      return paramFileInputStream;
    }
    catch (Exception paramFileInputStream) {}
    return null;
    return null;
  }
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      return getMD5(paramString, 102400);
    }
    return null;
  }
  
  public static String getMD5(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      return getMD5(paramString, paramInt1, paramInt2);
    }
    return null;
  }
  
  public static final String getMessageDigest(byte[] paramArrayOfByte)
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
      int k;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        continue;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      return null;
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
    catch (Exception paramArrayOfByte)
    {
      label18:
      break label18;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.MD5
 * JD-Core Version:    0.7.0.1
 */