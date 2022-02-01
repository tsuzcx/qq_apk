package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.f.k;

public class m
{
  private static final byte[] a = { 96, 110, -109, 82, 109, 2, 36, -77, 108, 59, -80, 10, 112, 122, 56, -67 };
  
  public String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  /* Error */
  public boolean a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 5
    //   3: aload_3
    //   4: ifnonnull +12 -> 16
    //   7: aload_0
    //   8: getstatic 10	com/tencent/qmsp/sdk/c/m:a	[B
    //   11: invokevirtual 23	com/tencent/qmsp/sdk/c/m:a	([B)Ljava/lang/String;
    //   14: astore 5
    //   16: new 25	com/tencent/qmsp/sdk/f/b
    //   19: dup
    //   20: invokespecial 26	com/tencent/qmsp/sdk/f/b:<init>	()V
    //   23: aload_2
    //   24: aload 5
    //   26: invokevirtual 32	java/lang/String:getBytes	()[B
    //   29: invokevirtual 35	com/tencent/qmsp/sdk/f/b:a	([B[B)[B
    //   32: astore_2
    //   33: aload_2
    //   34: ifnonnull +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: new 37	java/io/DataOutputStream
    //   42: dup
    //   43: new 39	java/io/FileOutputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 42	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   51: invokespecial 45	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_1
    //   55: aload_1
    //   56: ldc 46
    //   58: invokevirtual 50	java/io/DataOutputStream:writeInt	(I)V
    //   61: aload_1
    //   62: iload 4
    //   64: invokevirtual 50	java/io/DataOutputStream:writeInt	(I)V
    //   67: aload_1
    //   68: iconst_1
    //   69: invokevirtual 50	java/io/DataOutputStream:writeInt	(I)V
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 54	java/io/DataOutputStream:write	([B)V
    //   77: aload_1
    //   78: invokevirtual 57	java/io/DataOutputStream:close	()V
    //   81: iconst_1
    //   82: ireturn
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   88: goto -7 -> 81
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   96: aload_1
    //   97: ifnull +51 -> 148
    //   100: aload_1
    //   101: invokevirtual 57	java/io/DataOutputStream:close	()V
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 57	java/io/DataOutputStream:close	()V
    //   124: aload_2
    //   125: athrow
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: goto -37 -> 92
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   137: goto -13 -> 124
    //   140: astore_2
    //   141: goto -25 -> 116
    //   144: astore_2
    //   145: goto -29 -> 116
    //   148: iconst_0
    //   149: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	m
    //   0	150	1	paramString1	String
    //   0	150	2	paramArrayOfByte	byte[]
    //   0	150	3	paramString2	String
    //   0	150	4	paramInt	int
    //   1	24	5	str	String
    // Exception table:
    //   from	to	target	type
    //   77	81	83	java/io/IOException
    //   55	77	91	java/io/IOException
    //   100	104	106	java/io/IOException
    //   7	16	113	finally
    //   16	33	113	finally
    //   39	55	113	finally
    //   7	16	126	java/io/IOException
    //   16	33	126	java/io/IOException
    //   39	55	126	java/io/IOException
    //   120	124	132	java/io/IOException
    //   55	77	140	finally
    //   92	96	144	finally
  }
  
  /* Error */
  public byte[] a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 63	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 68	java/io/File:exists	()Z
    //   16: ifne +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 70	java/io/DataInputStream
    //   24: dup
    //   25: new 72	java/io/FileInputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 75	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 78	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 82	java/io/DataInputStream:available	()I
    //   41: istore 4
    //   43: iload 4
    //   45: bipush 12
    //   47: if_icmple +10 -> 57
    //   50: iload 4
    //   52: ldc 83
    //   54: if_icmple +16 -> 70
    //   57: aload_1
    //   58: invokevirtual 84	java/io/DataInputStream:close	()V
    //   61: aconst_null
    //   62: areturn
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_1
    //   71: invokevirtual 87	java/io/DataInputStream:readInt	()I
    //   74: istore 5
    //   76: iload 5
    //   78: ldc 46
    //   80: if_icmpeq +16 -> 96
    //   83: aload_1
    //   84: invokevirtual 84	java/io/DataInputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_1
    //   97: invokevirtual 87	java/io/DataInputStream:readInt	()I
    //   100: istore 5
    //   102: iload 5
    //   104: ifle +9 -> 113
    //   107: iload 5
    //   109: iload_3
    //   110: if_icmple +16 -> 126
    //   113: aload_1
    //   114: invokevirtual 84	java/io/DataInputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: aload_1
    //   127: invokevirtual 87	java/io/DataInputStream:readInt	()I
    //   130: istore_3
    //   131: iload_3
    //   132: iconst_1
    //   133: if_icmpeq +16 -> 149
    //   136: aload_1
    //   137: invokevirtual 84	java/io/DataInputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   147: aconst_null
    //   148: areturn
    //   149: iload 4
    //   151: bipush 12
    //   153: isub
    //   154: newarray byte
    //   156: astore 7
    //   158: aload 7
    //   160: arraylength
    //   161: istore_3
    //   162: aload_1
    //   163: aload 7
    //   165: invokevirtual 91	java/io/DataInputStream:read	([B)I
    //   168: istore 4
    //   170: iload_3
    //   171: iload 4
    //   173: if_icmpeq +16 -> 189
    //   176: aload_1
    //   177: invokevirtual 84	java/io/DataInputStream:close	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   187: aconst_null
    //   188: areturn
    //   189: aload_2
    //   190: astore 6
    //   192: aload_2
    //   193: ifnonnull +12 -> 205
    //   196: aload_0
    //   197: getstatic 10	com/tencent/qmsp/sdk/c/m:a	[B
    //   200: invokevirtual 23	com/tencent/qmsp/sdk/c/m:a	([B)Ljava/lang/String;
    //   203: astore 6
    //   205: new 25	com/tencent/qmsp/sdk/f/b
    //   208: dup
    //   209: invokespecial 26	com/tencent/qmsp/sdk/f/b:<init>	()V
    //   212: aload 7
    //   214: iconst_0
    //   215: aload 7
    //   217: arraylength
    //   218: aload 6
    //   220: invokevirtual 32	java/lang/String:getBytes	()[B
    //   223: invokevirtual 94	com/tencent/qmsp/sdk/f/b:a	([BII[B)[B
    //   226: astore_2
    //   227: aload_2
    //   228: ifnonnull +16 -> 244
    //   231: aload_1
    //   232: invokevirtual 84	java/io/DataInputStream:close	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   242: aconst_null
    //   243: areturn
    //   244: aload_1
    //   245: invokevirtual 84	java/io/DataInputStream:close	()V
    //   248: aload_2
    //   249: areturn
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   255: goto -7 -> 248
    //   258: astore_2
    //   259: aload_2
    //   260: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   263: aload_1
    //   264: ifnull -245 -> 19
    //   267: aload_1
    //   268: invokevirtual 84	java/io/DataInputStream:close	()V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: goto -24 -> 259
    //   286: astore_2
    //   287: aload_1
    //   288: astore 6
    //   290: aload_2
    //   291: astore_1
    //   292: aload 6
    //   294: ifnull +8 -> 302
    //   297: aload 6
    //   299: invokevirtual 84	java/io/DataInputStream:close	()V
    //   302: aload_1
    //   303: athrow
    //   304: astore_2
    //   305: aload_2
    //   306: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   309: goto -7 -> 302
    //   312: astore_2
    //   313: goto -26 -> 287
    //   316: astore_1
    //   317: goto -25 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	m
    //   0	320	1	paramString1	String
    //   0	320	2	paramString2	String
    //   0	320	3	paramInt	int
    //   41	133	4	i	int
    //   74	37	5	j	int
    //   1	297	6	str	String
    //   156	60	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   57	61	63	java/io/IOException
    //   83	87	89	java/io/IOException
    //   113	117	119	java/io/IOException
    //   136	140	142	java/io/IOException
    //   176	180	182	java/io/IOException
    //   231	235	237	java/io/IOException
    //   244	248	250	java/io/IOException
    //   37	43	258	java/io/IOException
    //   70	76	258	java/io/IOException
    //   96	102	258	java/io/IOException
    //   126	131	258	java/io/IOException
    //   149	170	258	java/io/IOException
    //   196	205	258	java/io/IOException
    //   205	227	258	java/io/IOException
    //   267	271	273	java/io/IOException
    //   21	37	280	java/io/IOException
    //   37	43	286	finally
    //   70	76	286	finally
    //   96	102	286	finally
    //   126	131	286	finally
    //   149	170	286	finally
    //   196	205	286	finally
    //   205	227	286	finally
    //   297	302	304	java/io/IOException
    //   259	263	312	finally
    //   21	37	316	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.m
 * JD-Core Version:    0.7.0.1
 */