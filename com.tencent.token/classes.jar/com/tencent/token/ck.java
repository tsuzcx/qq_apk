package com.tencent.token;

public class ck
{
  public static String a(byte paramByte)
  {
    int i = (paramByte & 0xF0) >>> 4;
    paramByte &= 0xF;
    char c1;
    if (i > 9) {
      c1 = (char)(i - 10 + 65);
    } else {
      c1 = (char)(i + 48);
    }
    char c2;
    if (paramByte > 9) {
      c2 = (char)(paramByte - 10 + 65);
    } else {
      c2 = (char)(paramByte + 48);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(c1));
    localStringBuilder.append(String.valueOf(c2));
    return localStringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(a(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 44
    //   2: astore 4
    //   4: aconst_null
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 5
    //   13: iload_2
    //   14: iconst_2
    //   15: iadd
    //   16: newarray byte
    //   18: astore_3
    //   19: aload_3
    //   20: iconst_0
    //   21: iload_2
    //   22: bipush 8
    //   24: ishr
    //   25: i2b
    //   26: bastore
    //   27: aload_3
    //   28: iconst_1
    //   29: iload_2
    //   30: i2b
    //   31: bastore
    //   32: aload_0
    //   33: iload_1
    //   34: aload_3
    //   35: iconst_2
    //   36: iload_2
    //   37: invokestatic 50	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   40: new 52	java/io/ByteArrayInputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 55	java/io/ByteArrayInputStream:<init>	([B)V
    //   48: astore_0
    //   49: new 57	java/io/DataInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 60	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 63	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   62: astore 5
    //   64: aload_3
    //   65: invokevirtual 66	java/io/DataInputStream:close	()V
    //   68: aload 5
    //   70: astore_3
    //   71: aload_0
    //   72: invokevirtual 67	java/io/ByteArrayInputStream:close	()V
    //   75: aload_3
    //   76: areturn
    //   77: astore 5
    //   79: aload_3
    //   80: astore 4
    //   82: aload_0
    //   83: astore_3
    //   84: aload 5
    //   86: astore_0
    //   87: goto +42 -> 129
    //   90: goto +67 -> 157
    //   93: goto +90 -> 183
    //   96: astore 6
    //   98: aload 5
    //   100: astore 4
    //   102: aload_0
    //   103: astore_3
    //   104: aload 6
    //   106: astore_0
    //   107: goto +22 -> 129
    //   110: aload 6
    //   112: astore_3
    //   113: goto +44 -> 157
    //   116: aload 7
    //   118: astore_3
    //   119: goto +64 -> 183
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_3
    //   125: aload 5
    //   127: astore 4
    //   129: aload 4
    //   131: ifnull +11 -> 142
    //   134: aload 4
    //   136: invokevirtual 66	java/io/DataInputStream:close	()V
    //   139: goto +3 -> 142
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 67	java/io/ByteArrayInputStream:close	()V
    //   150: aload_0
    //   151: athrow
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 6
    //   156: astore_3
    //   157: aload_3
    //   158: ifnull +10 -> 168
    //   161: aload_3
    //   162: invokevirtual 66	java/io/DataInputStream:close	()V
    //   165: goto +3 -> 168
    //   168: aload_0
    //   169: ifnull +35 -> 204
    //   172: aload 4
    //   174: astore_3
    //   175: goto -104 -> 71
    //   178: aconst_null
    //   179: astore_0
    //   180: aload 7
    //   182: astore_3
    //   183: aload_3
    //   184: ifnull +10 -> 194
    //   187: aload_3
    //   188: invokevirtual 66	java/io/DataInputStream:close	()V
    //   191: goto +3 -> 194
    //   194: aload_0
    //   195: ifnull +9 -> 204
    //   198: aload 4
    //   200: astore_3
    //   201: goto -130 -> 71
    //   204: ldc 44
    //   206: areturn
    //   207: astore_0
    //   208: goto -30 -> 178
    //   211: astore_0
    //   212: goto -60 -> 152
    //   215: astore_3
    //   216: goto -100 -> 116
    //   219: astore_3
    //   220: goto -110 -> 110
    //   223: astore 5
    //   225: goto -132 -> 93
    //   228: astore 5
    //   230: goto -140 -> 90
    //   233: astore_3
    //   234: aload 5
    //   236: astore_3
    //   237: goto -166 -> 71
    //   240: astore_0
    //   241: aload_3
    //   242: areturn
    //   243: astore 4
    //   245: goto -103 -> 142
    //   248: astore_3
    //   249: goto -99 -> 150
    //   252: astore_3
    //   253: goto -85 -> 168
    //   256: astore_3
    //   257: goto -63 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramArrayOfByte	byte[]
    //   0	260	1	paramInt1	int
    //   0	260	2	paramInt2	int
    //   18	183	3	localObject1	Object
    //   215	1	3	localIOException1	java.io.IOException
    //   219	1	3	localException1	java.lang.Exception
    //   233	1	3	localIOException2	java.io.IOException
    //   236	6	3	localException2	java.lang.Exception
    //   248	1	3	localIOException3	java.io.IOException
    //   252	1	3	localIOException4	java.io.IOException
    //   256	1	3	localIOException5	java.io.IOException
    //   2	197	4	localObject2	Object
    //   243	1	4	localIOException6	java.io.IOException
    //   11	58	5	str	String
    //   77	49	5	localObject3	Object
    //   223	1	5	localIOException7	java.io.IOException
    //   228	7	5	localException3	java.lang.Exception
    //   5	1	6	localObject4	Object
    //   96	59	6	localObject5	Object
    //   8	173	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   58	64	77	finally
    //   49	58	96	finally
    //   13	19	122	finally
    //   32	49	122	finally
    //   13	19	207	java/io/IOException
    //   32	49	207	java/io/IOException
    //   13	19	211	java/lang/Exception
    //   32	49	211	java/lang/Exception
    //   49	58	215	java/io/IOException
    //   49	58	219	java/lang/Exception
    //   58	64	223	java/io/IOException
    //   58	64	228	java/lang/Exception
    //   64	68	233	java/io/IOException
    //   71	75	240	java/io/IOException
    //   134	139	243	java/io/IOException
    //   146	150	248	java/io/IOException
    //   161	165	252	java/io/IOException
    //   187	191	256	java/io/IOException
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(((paramArrayOfByte[paramInt] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 0));
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)paramShort);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    a(paramArrayOfByte1, paramInt1, paramArrayOfByte2, 0, paramInt2);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  public static byte[] a(String paramString)
  {
    int i = paramString.length();
    Object localObject = paramString.toUpperCase();
    if (i % 2 == 0)
    {
      if (i == 0) {
        return null;
      }
      int k = i / 2;
      paramString = new byte[k];
      localObject = ((String)localObject).toCharArray();
      i = 0;
      while (i < k)
      {
        int m = i * 2;
        int j = localObject[m];
        m = localObject[(m + 1)];
        if ((j >= 48) && (j <= 57))
        {
          j = (j - 48 << 4) + 0;
        }
        else
        {
          if ((j < 65) || (j > 70)) {
            break label177;
          }
          j = (j - 65 + 10 << 4) + 0;
        }
        if ((m >= 48) && (m <= 57))
        {
          j += m - 48;
        }
        else
        {
          if ((m < 65) || (m > 70)) {
            break label175;
          }
          j += m - 65 + 10;
        }
        paramString[i] = ((byte)j);
        i += 1;
        continue;
        label175:
        return null;
        label177:
        return null;
      }
      return paramString;
    }
    return null;
  }
  
  public static long b(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramInt2) {
        break;
      }
      if (paramArrayOfByte[(paramInt1 + i)] == 0)
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if ((j != 0) && (i > 0)) {
      return a(paramArrayOfByte, paramInt1, i);
    }
    return "";
  }
  
  public static void b(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 56));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 48));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 40));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 32));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)paramLong);
  }
  
  public static void b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    a(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt1, paramInt2);
  }
  
  public static long c(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 4)] & 0xFF) << 56) + ((paramArrayOfByte[(paramInt + 5)] & 0xFF) << 48) + ((paramArrayOfByte[(paramInt + 6)] & 0xFF) << 40) + ((paramArrayOfByte[(paramInt + 7)] & 0xFF) << 32) + ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + (paramArrayOfByte[(paramInt + 3)] & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ck
 * JD-Core Version:    0.7.0.1
 */