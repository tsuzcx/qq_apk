package com.tencent.android.tpush.common;

public class d
{
  /* Error */
  public static Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_1
    //   3: astore_2
    //   4: aload_0
    //   5: ifnull +12 -> 17
    //   8: aload_0
    //   9: invokevirtual 14	java/lang/String:length	()I
    //   12: ifne +7 -> 19
    //   15: aload_1
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 16	java/io/ByteArrayInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokestatic 20	com/tencent/android/tpush/common/d:b	(Ljava/lang/String;)[B
    //   27: invokespecial 24	java/io/ByteArrayInputStream:<init>	([B)V
    //   30: astore_1
    //   31: new 26	java/io/ObjectInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 29	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore 4
    //   41: aload 4
    //   43: astore_0
    //   44: aload_1
    //   45: astore_3
    //   46: aload 4
    //   48: invokevirtual 33	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   51: astore_2
    //   52: aload_2
    //   53: astore_0
    //   54: aload 4
    //   56: ifnull +8 -> 64
    //   59: aload 4
    //   61: invokevirtual 37	java/io/ObjectInputStream:close	()V
    //   64: aload_0
    //   65: astore_2
    //   66: aload_1
    //   67: ifnull -50 -> 17
    //   70: aload_1
    //   71: invokevirtual 38	java/io/ByteArrayInputStream:close	()V
    //   74: aload_0
    //   75: areturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: athrow
    //   85: astore 4
    //   87: aload_3
    //   88: astore_1
    //   89: aload_0
    //   90: astore_2
    //   91: aload 4
    //   93: astore_0
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 37	java/io/ObjectInputStream:close	()V
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 38	java/io/ByteArrayInputStream:close	()V
    //   110: aload_0
    //   111: athrow
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_2
    //   117: goto -23 -> 94
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_2
    //   123: goto -29 -> 94
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_0
    //   129: goto -48 -> 81
    //   132: astore_2
    //   133: aload 4
    //   135: astore_0
    //   136: goto -55 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   1	114	1	localObject1	Object
    //   3	63	2	localObject2	Object
    //   76	8	2	localThrowable1	java.lang.Throwable
    //   90	33	2	str	String
    //   126	1	2	localThrowable2	java.lang.Throwable
    //   132	1	2	localThrowable3	java.lang.Throwable
    //   45	43	3	localObject3	Object
    //   39	21	4	localObjectInputStream	java.io.ObjectInputStream
    //   85	49	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   19	31	76	java/lang/Throwable
    //   46	52	85	finally
    //   83	85	85	finally
    //   19	31	112	finally
    //   31	41	120	finally
    //   31	41	126	java/lang/Throwable
    //   46	52	132	java/lang/Throwable
  }
  
  /* Error */
  public static String a(java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +8 -> 11
    //   6: ldc 42
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: new 44	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 46	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore_2
    //   19: new 48	java/io/ObjectOutputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 51	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_1
    //   28: aload_1
    //   29: aload_0
    //   30: invokevirtual 55	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   33: aload_2
    //   34: invokevirtual 59	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   37: invokestatic 62	com/tencent/android/tpush/common/d:a	([B)Ljava/lang/String;
    //   40: astore_0
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 63	java/io/ObjectOutputStream:close	()V
    //   49: aload_0
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull -43 -> 9
    //   55: aload_2
    //   56: invokevirtual 64	java/io/ByteArrayOutputStream:close	()V
    //   59: aload_0
    //   60: areturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_2
    //   65: athrow
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: aload_0
    //   70: astore_1
    //   71: aload_3
    //   72: astore_0
    //   73: aload_1
    //   74: ifnull +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 63	java/io/ObjectOutputStream:close	()V
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 64	java/io/ByteArrayOutputStream:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_2
    //   96: goto -23 -> 73
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_1
    //   102: goto -29 -> 73
    //   105: astore_0
    //   106: goto -33 -> 73
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: astore_2
    //   116: goto -52 -> 64
    //   119: astore_0
    //   120: aload_2
    //   121: astore_3
    //   122: aload_0
    //   123: astore_2
    //   124: aload_1
    //   125: astore_0
    //   126: aload_3
    //   127: astore_1
    //   128: goto -64 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramSerializable	java.io.Serializable
    //   1	127	1	localObject1	Object
    //   18	38	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   61	4	2	localThrowable1	java.lang.Throwable
    //   68	56	2	localObject2	Object
    //   66	6	3	localObject3	Object
    //   109	6	3	localThrowable2	java.lang.Throwable
    //   121	6	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	19	61	java/lang/Throwable
    //   64	66	66	finally
    //   11	19	91	finally
    //   19	28	99	finally
    //   28	41	105	finally
    //   19	28	109	java/lang/Throwable
    //   28	41	119	java/lang/Throwable
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append((char)((paramArrayOfByte[i] >> 4 & 0xF) + 97));
      localStringBuffer.append((char)((paramArrayOfByte[i] & 0xF) + 97));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] b(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      int k = i / 2;
      if (k < arrayOfByte.length)
      {
        arrayOfByte[k] = ((byte)(j - 97 << 4));
        arrayOfByte[k] = ((byte)(paramString.charAt(i + 1) - 'a' + arrayOfByte[k]));
      }
      i += 2;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.d
 * JD-Core Version:    0.7.0.1
 */