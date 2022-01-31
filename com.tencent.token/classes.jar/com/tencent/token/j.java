package com.tencent.token;

public final class j
  extends i
{
  private byte[] a = null;
  private byte[] b = null;
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return paramArrayOfByte;
      }
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ 0xFF));
      i += 1;
    }
  }
  
  /* Error */
  public final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 24	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 25	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore_3
    //   11: new 27	java/io/DataOutputStream
    //   14: dup
    //   15: aload_3
    //   16: invokespecial 30	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore 6
    //   21: aload_1
    //   22: ifnull +87 -> 109
    //   25: aload 6
    //   27: astore 5
    //   29: aload_3
    //   30: astore 4
    //   32: aload 6
    //   34: aload_1
    //   35: arraylength
    //   36: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   39: aload 6
    //   41: astore 5
    //   43: aload_3
    //   44: astore 4
    //   46: aload 6
    //   48: aload_1
    //   49: invokevirtual 38	java/io/DataOutputStream:write	([B)V
    //   52: aload_2
    //   53: ifnull +116 -> 169
    //   56: aload 6
    //   58: astore 5
    //   60: aload_3
    //   61: astore 4
    //   63: aload 6
    //   65: aload_2
    //   66: arraylength
    //   67: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   70: aload 6
    //   72: astore 5
    //   74: aload_3
    //   75: astore 4
    //   77: aload 6
    //   79: aload_2
    //   80: invokevirtual 38	java/io/DataOutputStream:write	([B)V
    //   83: aload 6
    //   85: astore 5
    //   87: aload_3
    //   88: astore 4
    //   90: aload_3
    //   91: invokevirtual 42	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: invokestatic 44	com/tencent/token/j:a	([B)[B
    //   97: astore_1
    //   98: aload 6
    //   100: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   103: aload_3
    //   104: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   107: aload_1
    //   108: areturn
    //   109: aload 6
    //   111: astore 5
    //   113: aload_3
    //   114: astore 4
    //   116: aload 6
    //   118: iconst_0
    //   119: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   122: goto -70 -> 52
    //   125: astore_2
    //   126: aload 6
    //   128: astore_1
    //   129: aload_1
    //   130: astore 5
    //   132: aload_3
    //   133: astore 4
    //   135: aload_0
    //   136: aload_2
    //   137: invokevirtual 51	com/tencent/token/j:a	(Ljava/lang/Exception;)V
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   148: aload 7
    //   150: astore_1
    //   151: aload_3
    //   152: ifnull -45 -> 107
    //   155: aload_3
    //   156: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   159: aconst_null
    //   160: areturn
    //   161: astore_1
    //   162: aload_0
    //   163: aload_1
    //   164: invokevirtual 51	com/tencent/token/j:a	(Ljava/lang/Exception;)V
    //   167: aconst_null
    //   168: areturn
    //   169: aload 6
    //   171: astore 5
    //   173: aload_3
    //   174: astore 4
    //   176: aload 6
    //   178: iconst_0
    //   179: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   182: goto -99 -> 83
    //   185: astore_2
    //   186: aload 6
    //   188: astore_1
    //   189: aload_1
    //   190: astore 5
    //   192: aload_3
    //   193: astore 4
    //   195: aload_0
    //   196: aload_2
    //   197: invokevirtual 54	com/tencent/token/j:a	(Ljava/lang/Throwable;)V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   208: aload 7
    //   210: astore_1
    //   211: aload_3
    //   212: ifnull -105 -> 107
    //   215: aload_3
    //   216: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_1
    //   222: aload_0
    //   223: aload_1
    //   224: invokevirtual 51	com/tencent/token/j:a	(Ljava/lang/Exception;)V
    //   227: aconst_null
    //   228: areturn
    //   229: astore_1
    //   230: aload_0
    //   231: aload_1
    //   232: invokevirtual 54	com/tencent/token/j:a	(Ljava/lang/Throwable;)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aload_0
    //   239: aload_1
    //   240: invokevirtual 54	com/tencent/token/j:a	(Ljava/lang/Throwable;)V
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: aconst_null
    //   247: astore 5
    //   249: aconst_null
    //   250: astore_3
    //   251: aload 5
    //   253: ifnull +8 -> 261
    //   256: aload 5
    //   258: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   261: aload_3
    //   262: ifnull +7 -> 269
    //   265: aload_3
    //   266: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   269: aload_1
    //   270: athrow
    //   271: astore_2
    //   272: aload_0
    //   273: aload_2
    //   274: invokevirtual 51	com/tencent/token/j:a	(Ljava/lang/Exception;)V
    //   277: goto -8 -> 269
    //   280: astore_2
    //   281: aload_0
    //   282: aload_2
    //   283: invokevirtual 54	com/tencent/token/j:a	(Ljava/lang/Throwable;)V
    //   286: goto -17 -> 269
    //   289: astore_2
    //   290: aload_0
    //   291: aload_2
    //   292: invokevirtual 51	com/tencent/token/j:a	(Ljava/lang/Exception;)V
    //   295: aload_1
    //   296: areturn
    //   297: astore_2
    //   298: aload_0
    //   299: aload_2
    //   300: invokevirtual 54	com/tencent/token/j:a	(Ljava/lang/Throwable;)V
    //   303: aload_1
    //   304: areturn
    //   305: astore_1
    //   306: aconst_null
    //   307: astore 5
    //   309: goto -58 -> 251
    //   312: astore_1
    //   313: aload 4
    //   315: astore_3
    //   316: goto -65 -> 251
    //   319: astore_2
    //   320: aconst_null
    //   321: astore_1
    //   322: aconst_null
    //   323: astore_3
    //   324: goto -135 -> 189
    //   327: astore_2
    //   328: aconst_null
    //   329: astore_1
    //   330: goto -141 -> 189
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_1
    //   336: aconst_null
    //   337: astore_3
    //   338: goto -209 -> 129
    //   341: astore_2
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -215 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	j
    //   0	347	1	paramArrayOfByte1	byte[]
    //   0	347	2	paramArrayOfByte2	byte[]
    //   10	328	3	localObject1	java.lang.Object
    //   30	284	4	localObject2	java.lang.Object
    //   27	281	5	localObject3	java.lang.Object
    //   19	168	6	localDataOutputStream	java.io.DataOutputStream
    //   1	208	7	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   32	39	125	java/lang/Exception
    //   46	52	125	java/lang/Exception
    //   63	70	125	java/lang/Exception
    //   77	83	125	java/lang/Exception
    //   90	98	125	java/lang/Exception
    //   116	122	125	java/lang/Exception
    //   176	182	125	java/lang/Exception
    //   144	148	161	java/lang/Exception
    //   155	159	161	java/lang/Exception
    //   32	39	185	java/lang/Throwable
    //   46	52	185	java/lang/Throwable
    //   63	70	185	java/lang/Throwable
    //   77	83	185	java/lang/Throwable
    //   90	98	185	java/lang/Throwable
    //   116	122	185	java/lang/Throwable
    //   176	182	185	java/lang/Throwable
    //   204	208	221	java/lang/Exception
    //   215	219	221	java/lang/Exception
    //   144	148	229	java/lang/Throwable
    //   155	159	229	java/lang/Throwable
    //   204	208	237	java/lang/Throwable
    //   215	219	237	java/lang/Throwable
    //   3	11	245	finally
    //   256	261	271	java/lang/Exception
    //   265	269	271	java/lang/Exception
    //   256	261	280	java/lang/Throwable
    //   265	269	280	java/lang/Throwable
    //   98	107	289	java/lang/Exception
    //   98	107	297	java/lang/Throwable
    //   11	21	305	finally
    //   32	39	312	finally
    //   46	52	312	finally
    //   63	70	312	finally
    //   77	83	312	finally
    //   90	98	312	finally
    //   116	122	312	finally
    //   135	140	312	finally
    //   176	182	312	finally
    //   195	200	312	finally
    //   3	11	319	java/lang/Throwable
    //   11	21	327	java/lang/Throwable
    //   3	11	333	java/lang/Exception
    //   11	21	341	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.j
 * JD-Core Version:    0.7.0.1
 */