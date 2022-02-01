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
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: new 24	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 25	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: new 27	java/io/DataOutputStream
    //   17: dup
    //   18: aload_3
    //   19: invokespecial 30	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 6
    //   24: aload_1
    //   25: ifnull +33 -> 58
    //   28: aload_3
    //   29: astore 4
    //   31: aload 6
    //   33: astore 5
    //   35: aload 6
    //   37: aload_1
    //   38: arraylength
    //   39: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   42: aload_3
    //   43: astore 4
    //   45: aload 6
    //   47: astore 5
    //   49: aload 6
    //   51: aload_1
    //   52: invokevirtual 38	java/io/DataOutputStream:write	([B)V
    //   55: goto +16 -> 71
    //   58: aload_3
    //   59: astore 4
    //   61: aload 6
    //   63: astore 5
    //   65: aload 6
    //   67: iconst_0
    //   68: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   71: aload_2
    //   72: ifnull +33 -> 105
    //   75: aload_3
    //   76: astore 4
    //   78: aload 6
    //   80: astore 5
    //   82: aload 6
    //   84: aload_2
    //   85: arraylength
    //   86: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   89: aload_3
    //   90: astore 4
    //   92: aload 6
    //   94: astore 5
    //   96: aload 6
    //   98: aload_2
    //   99: invokevirtual 38	java/io/DataOutputStream:write	([B)V
    //   102: goto +16 -> 118
    //   105: aload_3
    //   106: astore 4
    //   108: aload 6
    //   110: astore 5
    //   112: aload 6
    //   114: iconst_0
    //   115: invokevirtual 34	java/io/DataOutputStream:writeInt	(I)V
    //   118: aload_3
    //   119: astore 4
    //   121: aload 6
    //   123: astore 5
    //   125: aload_0
    //   126: aload_3
    //   127: invokevirtual 42	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   130: invokespecial 44	com/android/safeguard/i:a	([B)[B
    //   133: astore_1
    //   134: aload_1
    //   135: astore_2
    //   136: aload_1
    //   137: astore 4
    //   139: aload 6
    //   141: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   144: aload_1
    //   145: astore_2
    //   146: aload_1
    //   147: astore 4
    //   149: aload_3
    //   150: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   153: aload_1
    //   154: areturn
    //   155: astore_1
    //   156: aload_0
    //   157: aload_1
    //   158: invokevirtual 51	com/android/safeguard/i:a	(Ljava/lang/Throwable;)V
    //   161: aload_2
    //   162: areturn
    //   163: astore_1
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 54	com/android/safeguard/i:a	(Ljava/lang/Exception;)V
    //   169: aload 4
    //   171: areturn
    //   172: astore_2
    //   173: aload 6
    //   175: astore_1
    //   176: goto +43 -> 219
    //   179: astore_2
    //   180: aload 6
    //   182: astore_1
    //   183: goto +84 -> 267
    //   186: astore_1
    //   187: aconst_null
    //   188: astore 5
    //   190: goto +124 -> 314
    //   193: astore_2
    //   194: aconst_null
    //   195: astore_1
    //   196: goto +23 -> 219
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_1
    //   202: goto +65 -> 267
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_3
    //   208: aload_3
    //   209: astore 5
    //   211: goto +103 -> 314
    //   214: astore_2
    //   215: aconst_null
    //   216: astore_3
    //   217: aload_3
    //   218: astore_1
    //   219: aload_3
    //   220: astore 4
    //   222: aload_1
    //   223: astore 5
    //   225: aload_0
    //   226: aload_2
    //   227: invokevirtual 51	com/android/safeguard/i:a	(Ljava/lang/Throwable;)V
    //   230: aload_1
    //   231: ifnull +14 -> 245
    //   234: aload 7
    //   236: astore_2
    //   237: aload 8
    //   239: astore 4
    //   241: aload_1
    //   242: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   245: aload_3
    //   246: ifnull +62 -> 308
    //   249: aload 7
    //   251: astore_2
    //   252: aload 8
    //   254: astore 4
    //   256: aload_3
    //   257: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   260: aconst_null
    //   261: areturn
    //   262: astore_2
    //   263: aconst_null
    //   264: astore_3
    //   265: aload_3
    //   266: astore_1
    //   267: aload_3
    //   268: astore 4
    //   270: aload_1
    //   271: astore 5
    //   273: aload_0
    //   274: aload_2
    //   275: invokevirtual 54	com/android/safeguard/i:a	(Ljava/lang/Exception;)V
    //   278: aload_1
    //   279: ifnull +14 -> 293
    //   282: aload 7
    //   284: astore_2
    //   285: aload 8
    //   287: astore 4
    //   289: aload_1
    //   290: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   293: aload_3
    //   294: ifnull +14 -> 308
    //   297: aload 7
    //   299: astore_2
    //   300: aload 8
    //   302: astore 4
    //   304: aload_3
    //   305: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   308: aconst_null
    //   309: areturn
    //   310: astore_1
    //   311: aload 4
    //   313: astore_3
    //   314: aload 5
    //   316: ifnull +11 -> 327
    //   319: aload 5
    //   321: invokevirtual 47	java/io/DataOutputStream:close	()V
    //   324: goto +3 -> 327
    //   327: aload_3
    //   328: ifnull +23 -> 351
    //   331: aload_3
    //   332: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   335: goto +16 -> 351
    //   338: aload_0
    //   339: aload_2
    //   340: invokevirtual 51	com/android/safeguard/i:a	(Ljava/lang/Throwable;)V
    //   343: goto +8 -> 351
    //   346: aload_0
    //   347: aload_2
    //   348: invokevirtual 54	com/android/safeguard/i:a	(Ljava/lang/Exception;)V
    //   351: aload_1
    //   352: athrow
    //   353: astore_2
    //   354: goto -16 -> 338
    //   357: astore_2
    //   358: goto -12 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	i
    //   0	361	1	paramArrayOfByte1	byte[]
    //   0	361	2	paramArrayOfByte2	byte[]
    //   13	319	3	localObject1	java.lang.Object
    //   29	283	4	localObject2	java.lang.Object
    //   33	287	5	localObject3	java.lang.Object
    //   22	159	6	localDataOutputStream	java.io.DataOutputStream
    //   4	294	7	localObject4	java.lang.Object
    //   1	300	8	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   139	144	155	java/lang/Throwable
    //   149	153	155	java/lang/Throwable
    //   241	245	155	java/lang/Throwable
    //   256	260	155	java/lang/Throwable
    //   289	293	155	java/lang/Throwable
    //   304	308	155	java/lang/Throwable
    //   139	144	163	java/lang/Exception
    //   149	153	163	java/lang/Exception
    //   241	245	163	java/lang/Exception
    //   256	260	163	java/lang/Exception
    //   289	293	163	java/lang/Exception
    //   304	308	163	java/lang/Exception
    //   35	42	172	java/lang/Throwable
    //   49	55	172	java/lang/Throwable
    //   65	71	172	java/lang/Throwable
    //   82	89	172	java/lang/Throwable
    //   96	102	172	java/lang/Throwable
    //   112	118	172	java/lang/Throwable
    //   125	134	172	java/lang/Throwable
    //   35	42	179	java/lang/Exception
    //   49	55	179	java/lang/Exception
    //   65	71	179	java/lang/Exception
    //   82	89	179	java/lang/Exception
    //   96	102	179	java/lang/Exception
    //   112	118	179	java/lang/Exception
    //   125	134	179	java/lang/Exception
    //   14	24	186	finally
    //   14	24	193	java/lang/Throwable
    //   14	24	199	java/lang/Exception
    //   6	14	205	finally
    //   6	14	214	java/lang/Throwable
    //   6	14	262	java/lang/Exception
    //   35	42	310	finally
    //   49	55	310	finally
    //   65	71	310	finally
    //   82	89	310	finally
    //   96	102	310	finally
    //   112	118	310	finally
    //   125	134	310	finally
    //   225	230	310	finally
    //   273	278	310	finally
    //   319	324	353	java/lang/Throwable
    //   331	335	353	java/lang/Throwable
    //   319	324	357	java/lang/Exception
    //   331	335	357	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.i
 * JD-Core Version:    0.7.0.1
 */