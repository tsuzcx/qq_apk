package com.tencent.token;

public final class ap
{
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i];
      int j = (k & 0xF0) >>> 4;
      k &= 0xF;
      char c1;
      if (j > 9)
      {
        c1 = (char)(j - 10 + 65);
        label62:
        if (k <= 9) {
          break label126;
        }
      }
      label126:
      for (char c2 = (char)(k - 10 + 65);; c2 = (char)(k + 48))
      {
        localStringBuffer.append(String.valueOf(c1) + String.valueOf(c2));
        i += 1;
        break;
        c1 = (char)(j + 48);
        break label62;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        return b(paramArrayOfByte, paramInt1, i);
      }
      i += 1;
    }
    return "";
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
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
  
  /* Error */
  private static String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
    //   40: invokestatic 67	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   43: new 69	java/io/ByteArrayInputStream
    //   46: dup
    //   47: aload 7
    //   49: invokespecial 72	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: astore_0
    //   53: new 74	java/io/DataInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 77	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 80	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: astore 4
    //   72: aload_3
    //   73: invokevirtual 83	java/io/DataInputStream:close	()V
    //   76: aload_0
    //   77: invokevirtual 84	java/io/ByteArrayInputStream:close	()V
    //   80: aload 4
    //   82: areturn
    //   83: astore_0
    //   84: aconst_null
    //   85: astore 5
    //   87: aload_3
    //   88: astore_0
    //   89: aload 5
    //   91: astore_3
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 83	java/io/DataInputStream:close	()V
    //   100: aload_0
    //   101: ifnull -21 -> 80
    //   104: aload_0
    //   105: invokevirtual 84	java/io/ByteArrayInputStream:close	()V
    //   108: ldc 44
    //   110: areturn
    //   111: astore_0
    //   112: ldc 44
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_0
    //   118: aload 6
    //   120: astore_3
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 83	java/io/DataInputStream:close	()V
    //   129: aload_0
    //   130: ifnull -50 -> 80
    //   133: aload_0
    //   134: invokevirtual 84	java/io/ByteArrayInputStream:close	()V
    //   137: ldc 44
    //   139: areturn
    //   140: astore_0
    //   141: ldc 44
    //   143: areturn
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_0
    //   147: aload 5
    //   149: astore 4
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 83	java/io/DataInputStream:close	()V
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 84	java/io/ByteArrayInputStream:close	()V
    //   169: aload_3
    //   170: athrow
    //   171: astore_3
    //   172: goto -96 -> 76
    //   175: astore_0
    //   176: aload 4
    //   178: areturn
    //   179: astore_3
    //   180: goto -80 -> 100
    //   183: astore_3
    //   184: goto -55 -> 129
    //   187: astore 4
    //   189: goto -28 -> 161
    //   192: astore_0
    //   193: goto -24 -> 169
    //   196: astore_3
    //   197: aload 5
    //   199: astore 4
    //   201: goto -50 -> 151
    //   204: astore 5
    //   206: aload_3
    //   207: astore 4
    //   209: aload 5
    //   211: astore_3
    //   212: goto -61 -> 151
    //   215: astore_3
    //   216: aload 6
    //   218: astore_3
    //   219: goto -98 -> 121
    //   222: astore 5
    //   224: goto -103 -> 121
    //   227: astore_3
    //   228: aconst_null
    //   229: astore_3
    //   230: goto -138 -> 92
    //   233: astore 5
    //   235: goto -143 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramArrayOfByte	byte[]
    //   0	238	1	paramInt1	int
    //   0	238	2	paramInt2	int
    //   7	119	3	localObject1	Object
    //   144	26	3	localObject2	Object
    //   171	1	3	localIOException1	java.io.IOException
    //   179	1	3	localIOException2	java.io.IOException
    //   183	1	3	localIOException3	java.io.IOException
    //   196	11	3	localObject3	Object
    //   211	1	3	localObject4	Object
    //   215	1	3	localException1	java.lang.Exception
    //   218	1	3	localObject5	Object
    //   227	1	3	localIOException4	java.io.IOException
    //   229	1	3	localObject6	Object
    //   10	167	4	str1	String
    //   187	1	4	localIOException5	java.io.IOException
    //   199	9	4	localObject7	Object
    //   4	194	5	str2	String
    //   204	6	5	localObject8	Object
    //   222	1	5	localException2	java.lang.Exception
    //   233	1	5	localIOException6	java.io.IOException
    //   1	216	6	localObject9	Object
    //   17	31	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	19	83	java/io/IOException
    //   34	53	83	java/io/IOException
    //   104	108	111	java/io/IOException
    //   12	19	115	java/lang/Exception
    //   34	53	115	java/lang/Exception
    //   133	137	140	java/io/IOException
    //   12	19	144	finally
    //   34	53	144	finally
    //   72	76	171	java/io/IOException
    //   76	80	175	java/io/IOException
    //   96	100	179	java/io/IOException
    //   125	129	183	java/io/IOException
    //   156	161	187	java/io/IOException
    //   165	169	192	java/io/IOException
    //   53	62	196	finally
    //   62	68	204	finally
    //   53	62	215	java/lang/Exception
    //   62	68	222	java/lang/Exception
    //   53	62	227	java/io/IOException
    //   62	68	233	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ap
 * JD-Core Version:    0.7.0.1
 */