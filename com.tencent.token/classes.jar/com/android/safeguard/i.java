package com.android.safeguard;

public class i
  extends h
{
  private byte[] a = null;
  private byte[] b = null;
  
  private byte[] a(byte[] paramArrayOfByte)
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
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
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
    //   22: ifnull +101 -> 123
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
    //   53: ifnull +130 -> 183
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
    //   90: aload_0
    //   91: aload_3
    //   92: invokevirtual 42	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   95: invokespecial 44	com/android/safeguard/i:a	([B)[B
    //   98: astore_1
    //   99: aload 6
    //   101: ifnull +8 -> 109
    //   104: aload 6
    //   106: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   109: aload_1
    //   110: astore_2
    //   111: aload_3
    //   112: ifnull +9 -> 121
    //   115: aload_3
    //   116: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   119: aload_1
    //   120: astore_2
    //   121: aload_2
    //   122: areturn
    //   123: aload 6
    //   125: astore 5
    //   127: aload_3
    //   128: astore 4
    //   130: aload 6
    //   132: iconst_0
    //   133: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   136: goto -84 -> 52
    //   139: astore_2
    //   140: aload 6
    //   142: astore_1
    //   143: aload_1
    //   144: astore 5
    //   146: aload_3
    //   147: astore 4
    //   149: aload_0
    //   150: aload_2
    //   151: invokevirtual 51	com/android/safeguard/i:a	(Ljava/lang/Exception;)V
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   162: aload 7
    //   164: astore_2
    //   165: aload_3
    //   166: ifnull -45 -> 121
    //   169: aload_3
    //   170: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_1
    //   176: aload_0
    //   177: aload_1
    //   178: invokevirtual 51	com/android/safeguard/i:a	(Ljava/lang/Exception;)V
    //   181: aconst_null
    //   182: areturn
    //   183: aload 6
    //   185: astore 5
    //   187: aload_3
    //   188: astore 4
    //   190: aload 6
    //   192: iconst_0
    //   193: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   196: goto -113 -> 83
    //   199: astore_2
    //   200: aload 6
    //   202: astore_1
    //   203: aload_1
    //   204: astore 5
    //   206: aload_3
    //   207: astore 4
    //   209: aload_0
    //   210: aload_2
    //   211: invokevirtual 54	com/android/safeguard/i:a	(Ljava/lang/Throwable;)V
    //   214: aload_1
    //   215: ifnull +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   222: aload 7
    //   224: astore_2
    //   225: aload_3
    //   226: ifnull -105 -> 121
    //   229: aload_3
    //   230: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_1
    //   236: aload_0
    //   237: aload_1
    //   238: invokevirtual 51	com/android/safeguard/i:a	(Ljava/lang/Exception;)V
    //   241: aconst_null
    //   242: areturn
    //   243: astore_1
    //   244: aload_0
    //   245: aload_1
    //   246: invokevirtual 54	com/android/safeguard/i:a	(Ljava/lang/Throwable;)V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_1
    //   252: aload_0
    //   253: aload_1
    //   254: invokevirtual 54	com/android/safeguard/i:a	(Ljava/lang/Throwable;)V
    //   257: aconst_null
    //   258: areturn
    //   259: astore_1
    //   260: aconst_null
    //   261: astore 5
    //   263: aconst_null
    //   264: astore_3
    //   265: aload 5
    //   267: ifnull +8 -> 275
    //   270: aload 5
    //   272: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   275: aload_3
    //   276: ifnull +7 -> 283
    //   279: aload_3
    //   280: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   283: aload_1
    //   284: athrow
    //   285: astore_2
    //   286: aload_0
    //   287: aload_2
    //   288: invokevirtual 51	com/android/safeguard/i:a	(Ljava/lang/Exception;)V
    //   291: goto -8 -> 283
    //   294: astore_2
    //   295: aload_0
    //   296: aload_2
    //   297: invokevirtual 54	com/android/safeguard/i:a	(Ljava/lang/Throwable;)V
    //   300: goto -17 -> 283
    //   303: astore_2
    //   304: aload_0
    //   305: aload_2
    //   306: invokevirtual 51	com/android/safeguard/i:a	(Ljava/lang/Exception;)V
    //   309: aload_1
    //   310: areturn
    //   311: astore_2
    //   312: aload_0
    //   313: aload_2
    //   314: invokevirtual 54	com/android/safeguard/i:a	(Ljava/lang/Throwable;)V
    //   317: aload_1
    //   318: areturn
    //   319: astore_1
    //   320: aconst_null
    //   321: astore 5
    //   323: goto -58 -> 265
    //   326: astore_1
    //   327: aload 4
    //   329: astore_3
    //   330: goto -65 -> 265
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_1
    //   336: aconst_null
    //   337: astore_3
    //   338: goto -135 -> 203
    //   341: astore_2
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -141 -> 203
    //   347: astore_2
    //   348: aconst_null
    //   349: astore_1
    //   350: aconst_null
    //   351: astore_3
    //   352: goto -209 -> 143
    //   355: astore_2
    //   356: aconst_null
    //   357: astore_1
    //   358: goto -215 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	i
    //   0	361	1	paramArrayOfByte1	byte[]
    //   0	361	2	paramArrayOfByte2	byte[]
    //   10	342	3	localObject1	java.lang.Object
    //   30	298	4	localObject2	java.lang.Object
    //   27	295	5	localObject3	java.lang.Object
    //   19	182	6	localDataOutputStream	java.io.DataOutputStream
    //   1	222	7	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   32	39	139	java/lang/Exception
    //   46	52	139	java/lang/Exception
    //   63	70	139	java/lang/Exception
    //   77	83	139	java/lang/Exception
    //   90	99	139	java/lang/Exception
    //   130	136	139	java/lang/Exception
    //   190	196	139	java/lang/Exception
    //   158	162	175	java/lang/Exception
    //   169	173	175	java/lang/Exception
    //   32	39	199	java/lang/Throwable
    //   46	52	199	java/lang/Throwable
    //   63	70	199	java/lang/Throwable
    //   77	83	199	java/lang/Throwable
    //   90	99	199	java/lang/Throwable
    //   130	136	199	java/lang/Throwable
    //   190	196	199	java/lang/Throwable
    //   218	222	235	java/lang/Exception
    //   229	233	235	java/lang/Exception
    //   158	162	243	java/lang/Throwable
    //   169	173	243	java/lang/Throwable
    //   218	222	251	java/lang/Throwable
    //   229	233	251	java/lang/Throwable
    //   3	11	259	finally
    //   270	275	285	java/lang/Exception
    //   279	283	285	java/lang/Exception
    //   270	275	294	java/lang/Throwable
    //   279	283	294	java/lang/Throwable
    //   104	109	303	java/lang/Exception
    //   115	119	303	java/lang/Exception
    //   104	109	311	java/lang/Throwable
    //   115	119	311	java/lang/Throwable
    //   11	21	319	finally
    //   32	39	326	finally
    //   46	52	326	finally
    //   63	70	326	finally
    //   77	83	326	finally
    //   90	99	326	finally
    //   130	136	326	finally
    //   149	154	326	finally
    //   190	196	326	finally
    //   209	214	326	finally
    //   3	11	333	java/lang/Throwable
    //   11	21	341	java/lang/Throwable
    //   3	11	347	java/lang/Exception
    //   11	21	355	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.i
 * JD-Core Version:    0.7.0.1
 */