package com.tencent.token;

public class dg
{
  public static String a(byte paramByte)
  {
    int i = (paramByte & 0xF0) >>> 4;
    paramByte &= 0xF;
    char c1;
    if (i > 9)
    {
      c1 = (char)(i - 10 + 65);
      if (paramByte <= 9) {
        break label77;
      }
    }
    label77:
    for (char c2 = (char)(paramByte - 10 + 65);; c2 = (char)(paramByte + 48))
    {
      return String.valueOf(c1) + String.valueOf(c2);
      c1 = (char)(i + 48);
      break;
    }
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
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: ldc 44
    //   10: astore 4
    //   12: iload_2
    //   13: iconst_2
    //   14: iadd
    //   15: newarray byte
    //   17: astore 7
    //   19: aload 7
    //   21: iconst_0
    //   22: iload_2
    //   23: bipush 8
    //   25: ishr
    //   26: i2b
    //   27: bastore
    //   28: aload 7
    //   30: iconst_1
    //   31: iload_2
    //   32: i2b
    //   33: bastore
    //   34: aload_0
    //   35: iload_1
    //   36: aload 7
    //   38: iconst_2
    //   39: iload_2
    //   40: invokestatic 50	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   43: new 52	java/io/ByteArrayInputStream
    //   46: dup
    //   47: aload 7
    //   49: invokespecial 55	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: astore_0
    //   53: new 57	java/io/DataInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 60	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 63	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: astore 4
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 66	java/io/DataInputStream:close	()V
    //   80: aload 4
    //   82: astore_3
    //   83: aload_0
    //   84: ifnull +10 -> 94
    //   87: aload_0
    //   88: invokevirtual 67	java/io/ByteArrayInputStream:close	()V
    //   91: aload 4
    //   93: astore_3
    //   94: aload_3
    //   95: areturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore 5
    //   100: aload_3
    //   101: astore_0
    //   102: aload 5
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 66	java/io/DataInputStream:close	()V
    //   113: aload 4
    //   115: astore_3
    //   116: aload_0
    //   117: ifnull -23 -> 94
    //   120: aload_0
    //   121: invokevirtual 67	java/io/ByteArrayInputStream:close	()V
    //   124: ldc 44
    //   126: areturn
    //   127: astore_0
    //   128: ldc 44
    //   130: areturn
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_0
    //   134: aload 6
    //   136: astore_3
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 66	java/io/DataInputStream:close	()V
    //   145: aload 4
    //   147: astore_3
    //   148: aload_0
    //   149: ifnull -55 -> 94
    //   152: aload_0
    //   153: invokevirtual 67	java/io/ByteArrayInputStream:close	()V
    //   156: ldc 44
    //   158: areturn
    //   159: astore_0
    //   160: ldc 44
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_0
    //   166: aload 5
    //   168: astore 4
    //   170: aload 4
    //   172: ifnull +8 -> 180
    //   175: aload 4
    //   177: invokevirtual 66	java/io/DataInputStream:close	()V
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 67	java/io/ByteArrayInputStream:close	()V
    //   188: aload_3
    //   189: athrow
    //   190: astore_3
    //   191: goto -111 -> 80
    //   194: astore_0
    //   195: aload 4
    //   197: areturn
    //   198: astore_3
    //   199: goto -86 -> 113
    //   202: astore_3
    //   203: goto -58 -> 145
    //   206: astore 4
    //   208: goto -28 -> 180
    //   211: astore_0
    //   212: goto -24 -> 188
    //   215: astore_3
    //   216: aload 5
    //   218: astore 4
    //   220: goto -50 -> 170
    //   223: astore 5
    //   225: aload_3
    //   226: astore 4
    //   228: aload 5
    //   230: astore_3
    //   231: goto -61 -> 170
    //   234: astore_3
    //   235: aload 6
    //   237: astore_3
    //   238: goto -101 -> 137
    //   241: astore 5
    //   243: goto -106 -> 137
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_3
    //   249: goto -144 -> 105
    //   252: astore 5
    //   254: goto -149 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramArrayOfByte	byte[]
    //   0	257	1	paramInt1	int
    //   0	257	2	paramInt2	int
    //   7	141	3	localObject1	Object
    //   163	26	3	localObject2	Object
    //   190	1	3	localIOException1	java.io.IOException
    //   198	1	3	localIOException2	java.io.IOException
    //   202	1	3	localIOException3	java.io.IOException
    //   215	11	3	localObject3	Object
    //   230	1	3	localObject4	Object
    //   234	1	3	localException1	java.lang.Exception
    //   237	1	3	localObject5	Object
    //   246	1	3	localIOException4	java.io.IOException
    //   248	1	3	localObject6	Object
    //   10	186	4	str1	String
    //   206	1	4	localIOException5	java.io.IOException
    //   218	9	4	localObject7	Object
    //   4	213	5	str2	String
    //   223	6	5	localObject8	Object
    //   241	1	5	localException2	java.lang.Exception
    //   252	1	5	localIOException6	java.io.IOException
    //   1	235	6	localObject9	Object
    //   17	31	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	19	96	java/io/IOException
    //   34	53	96	java/io/IOException
    //   120	124	127	java/io/IOException
    //   12	19	131	java/lang/Exception
    //   34	53	131	java/lang/Exception
    //   152	156	159	java/io/IOException
    //   12	19	163	finally
    //   34	53	163	finally
    //   76	80	190	java/io/IOException
    //   87	91	194	java/io/IOException
    //   109	113	198	java/io/IOException
    //   141	145	202	java/io/IOException
    //   175	180	206	java/io/IOException
    //   184	188	211	java/io/IOException
    //   53	62	215	finally
    //   62	68	223	finally
    //   53	62	234	java/lang/Exception
    //   62	68	241	java/lang/Exception
    //   53	62	246	java/io/IOException
    //   62	68	252	java/io/IOException
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
    if ((i % 2 != 0) || (i == 0)) {
      return null;
    }
    int k = i / 2;
    paramString = new byte[k];
    localObject = ((String)localObject).toCharArray();
    i = 0;
    if (i < k)
    {
      int j = localObject[(i * 2)];
      int m = localObject[(i * 2 + 1)];
      if ((j >= 48) && (j <= 57))
      {
        j = (j - 48 << 4) + 0;
        label83:
        if ((m < 48) || (m > 57)) {
          break label146;
        }
        j += m - 48;
      }
      for (;;)
      {
        paramString[i] = ((byte)j);
        i += 1;
        break;
        if ((j >= 65) && (j <= 70))
        {
          j = (j - 65 + 10 << 4) + 0;
          break label83;
        }
        return null;
        label146:
        if ((m < 65) || (m > 70)) {
          break label174;
        }
        j += m - 65 + 10;
      }
      label174:
      return null;
    }
    return paramString;
  }
  
  public static long b(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramInt2)
      {
        if (paramArrayOfByte[(paramInt1 + i)] == 0) {
          j = 1;
        }
      }
      else
      {
        if ((j == 0) || (i <= 0)) {
          break;
        }
        return a(paramArrayOfByte, paramInt1, i);
      }
      i += 1;
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
 * Qualified Name:     com.tencent.token.dg
 * JD-Core Version:    0.7.0.1
 */