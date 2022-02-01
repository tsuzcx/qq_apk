package com.tencent.qmsp.sdk.d;

import android.util.Base64;
import com.tencent.qmsp.sdk.f.k;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class e
{
  private static final byte[] a = { 8, 89, -108, 70, 3, 26, 39, -38, 6, 67, -94, 103, 29, 18, 117, -82, 1, 65, -106, 98, 15, 10, 66, -36, 4, 36, -108, 110, 15, 31, 84, -33, 44, 65, -104, 98, 41, 10, 83, -48, 63, 32, -108, 73, 5, 42, 66, -52, 43, 96, -67, 83, 13, 51, 34, -18, 52, 73, -65, 118, 10, 54, 92, -12, 116, 105, -71, 105, 13, 21, 124, -10, 3, 114, -87, 97, 43, 15, 118, -54, 35, 63, -93, 101, 0, 48, 66, -55, 17, 33, -22, 108, 11, 99, 81, -54, 43, 36, -21, 99, 120, 104, 66, -46, 6, 88, -126, 85, 27, 61, 33, -86, 52, 105, -76, 99, 8, 14, 86, -19, 18, 37, -8, 18, 126, 12, 83, -88, 22, 113, -80, 98, 40, 63, 109, -16, 48, 118, -68, 72, 45, 24, 86, -25, 35, 88, -28, 106, 123, 33, 114, -45, 117, 81, -94, 111, 3, 60, 120, -86, 110, 123, -28, 105, 101, 52, 94, -19, 31, 97, -67, 104, 3, 41, 117, -84, 51, 82, -65, 86, 6, 57, 60, -86, 124, 115, -89, 23, 30, 11, 60, -39, 52, 67, -125, 66, 36, 41, 60, -7, 20, 69, -80, 111, 120, 41, 89, -10, 47, 103, -102, 100, 15, 10, 86, -33 };
  private static final byte[] b = { 8, 84, -26, 87, 39, 47, 127, -49, 22, 81 };
  private static final byte[] c = { 23, 67, -110 };
  
  public static b a(DataInputStream paramDataInputStream)
  {
    b localb = new b(null);
    try
    {
      localb.a = paramDataInputStream.readInt();
      localb.b = paramDataInputStream.readInt();
      localb.c = paramDataInputStream.readInt();
      if ((localb.c > 0) && (localb.c <= 256))
      {
        localb.d = new byte[localb.c];
        paramDataInputStream.read(localb.d);
        return localb;
      }
    }
    catch (IOException paramDataInputStream)
    {
      paramDataInputStream.printStackTrace();
      return null;
    }
    return null;
  }
  
  private static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = k.a(a);
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance(k.a(c)).generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static boolean a(DataInputStream paramDataInputStream, int paramInt, byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    for (;;)
    {
      int i;
      try
      {
        localSignature = Signature.getInstance(k.a(b));
        localSignature.initVerify(paramPublicKey);
        paramPublicKey = new byte[8192];
        if (paramInt < 8192)
        {
          i = paramDataInputStream.read(paramPublicKey, 0, paramInt);
          break label83;
          return localSignature.verify(paramArrayOfByte);
        }
        else
        {
          i = paramDataInputStream.read(paramPublicKey);
        }
      }
      catch (Exception paramDataInputStream)
      {
        Signature localSignature;
        paramDataInputStream.printStackTrace();
        return false;
      }
      localSignature.update(paramPublicKey, 0, i);
      paramInt -= i;
      continue;
      label83:
      if (i != 0) {
        if (i != -1) {}
      }
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = Signature.getInstance(k.a(b));
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 110	java/io/File:exists	()Z
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 28	java/io/DataInputStream
    //   15: dup
    //   16: new 112	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 118	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 121	java/io/DataInputStream:available	()I
    //   32: istore_2
    //   33: iload_2
    //   34: bipush 8
    //   36: if_icmplt +9 -> 45
    //   39: iload_2
    //   40: ldc 122
    //   42: if_icmple +16 -> 58
    //   45: aload_0
    //   46: invokevirtual 125	java/io/DataInputStream:close	()V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: invokevirtual 32	java/io/DataInputStream:readInt	()I
    //   62: istore_3
    //   63: iload_3
    //   64: ldc 126
    //   66: if_icmpeq +16 -> 82
    //   69: aload_0
    //   70: invokevirtual 125	java/io/DataInputStream:close	()V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   80: aconst_null
    //   81: areturn
    //   82: aload_0
    //   83: invokevirtual 32	java/io/DataInputStream:readInt	()I
    //   86: istore_3
    //   87: iload_3
    //   88: ifle +20 -> 108
    //   91: iload_3
    //   92: sipush 256
    //   95: if_icmpgt +13 -> 108
    //   98: iload_2
    //   99: bipush 8
    //   101: isub
    //   102: istore_2
    //   103: iload_3
    //   104: iload_2
    //   105: if_icmplt +16 -> 121
    //   108: aload_0
    //   109: invokevirtual 125	java/io/DataInputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: aload_1
    //   122: invokestatic 128	com/tencent/qmsp/sdk/d/e:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   125: astore_1
    //   126: aload_1
    //   127: ifnonnull +16 -> 143
    //   130: aload_0
    //   131: invokevirtual 125	java/io/DataInputStream:close	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   141: aconst_null
    //   142: areturn
    //   143: iload_3
    //   144: newarray byte
    //   146: astore 6
    //   148: iload_2
    //   149: iload_3
    //   150: isub
    //   151: newarray byte
    //   153: astore 5
    //   155: aload_0
    //   156: aload 6
    //   158: invokevirtual 46	java/io/DataInputStream:read	([B)I
    //   161: pop
    //   162: aload_0
    //   163: aload 5
    //   165: invokevirtual 46	java/io/DataInputStream:read	([B)I
    //   168: pop
    //   169: aload 5
    //   171: aload 6
    //   173: aload_1
    //   174: invokestatic 130	com/tencent/qmsp/sdk/d/e:a	([B[BLjava/security/PublicKey;)Z
    //   177: istore 4
    //   179: aload_0
    //   180: astore_1
    //   181: iload 4
    //   183: ifeq +29 -> 212
    //   186: aload_0
    //   187: invokevirtual 125	java/io/DataInputStream:close	()V
    //   190: aload 5
    //   192: areturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   198: goto -8 -> 190
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   206: aload_0
    //   207: ifnull -197 -> 10
    //   210: aload_0
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 125	java/io/DataInputStream:close	()V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_0
    //   228: goto -26 -> 202
    //   231: astore_1
    //   232: aload_0
    //   233: astore 5
    //   235: aload_1
    //   236: astore_0
    //   237: aload 5
    //   239: ifnull +8 -> 247
    //   242: aload 5
    //   244: invokevirtual 125	java/io/DataInputStream:close	()V
    //   247: aload_0
    //   248: athrow
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   254: goto -7 -> 247
    //   257: astore_1
    //   258: goto -26 -> 232
    //   261: astore_0
    //   262: goto -25 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramFile	java.io.File
    //   0	265	1	paramString	String
    //   32	119	2	i	int
    //   62	89	3	j	int
    //   177	5	4	bool	boolean
    //   1	242	5	localObject	Object
    //   146	26	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   45	49	51	java/io/IOException
    //   69	73	75	java/io/IOException
    //   108	112	114	java/io/IOException
    //   130	134	136	java/io/IOException
    //   186	190	193	java/io/IOException
    //   28	33	201	java/io/IOException
    //   58	63	201	java/io/IOException
    //   82	87	201	java/io/IOException
    //   121	126	201	java/io/IOException
    //   143	179	201	java/io/IOException
    //   212	216	218	java/io/IOException
    //   12	28	225	java/io/IOException
    //   28	33	231	finally
    //   58	63	231	finally
    //   82	87	231	finally
    //   121	126	231	finally
    //   143	179	231	finally
    //   242	247	249	java/io/IOException
    //   202	206	257	finally
    //   12	28	261	finally
  }
  
  /* Error */
  public static boolean b(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 110	java/io/File:exists	()Z
    //   7: ifne +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: new 28	java/io/DataInputStream
    //   15: dup
    //   16: new 112	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 118	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 121	java/io/DataInputStream:available	()I
    //   34: istore_2
    //   35: iload_2
    //   36: sipush 140
    //   39: if_icmpgt +17 -> 56
    //   42: aload 5
    //   44: invokevirtual 125	java/io/DataInputStream:close	()V
    //   47: iconst_0
    //   48: ireturn
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   54: iconst_0
    //   55: ireturn
    //   56: iload_2
    //   57: sipush 140
    //   60: isub
    //   61: istore_2
    //   62: aload 5
    //   64: iload_2
    //   65: invokevirtual 135	java/io/DataInputStream:skipBytes	(I)I
    //   68: pop
    //   69: aload 5
    //   71: invokestatic 137	com/tencent/qmsp/sdk/d/e:a	(Ljava/io/DataInputStream;)Lcom/tencent/qmsp/sdk/d/e$b;
    //   74: astore 7
    //   76: aload 7
    //   78: ifnonnull +17 -> 95
    //   81: aload 5
    //   83: invokevirtual 125	java/io/DataInputStream:close	()V
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 7
    //   97: getfield 35	com/tencent/qmsp/sdk/d/e$b:a	I
    //   100: istore_3
    //   101: iload_3
    //   102: ldc 126
    //   104: if_icmpeq +17 -> 121
    //   107: aload 5
    //   109: invokevirtual 125	java/io/DataInputStream:close	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   119: iconst_0
    //   120: ireturn
    //   121: aload 7
    //   123: getfield 37	com/tencent/qmsp/sdk/d/e$b:b	I
    //   126: ifle +15 -> 141
    //   129: aload 7
    //   131: getfield 37	com/tencent/qmsp/sdk/d/e$b:b	I
    //   134: istore_3
    //   135: iload_3
    //   136: ldc 122
    //   138: if_icmple +17 -> 155
    //   141: aload 5
    //   143: invokevirtual 125	java/io/DataInputStream:close	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: aload 7
    //   157: getfield 37	com/tencent/qmsp/sdk/d/e$b:b	I
    //   160: istore_3
    //   161: iload_2
    //   162: iload_3
    //   163: if_icmpeq +17 -> 180
    //   166: aload 5
    //   168: invokevirtual 125	java/io/DataInputStream:close	()V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   178: iconst_0
    //   179: ireturn
    //   180: aload_1
    //   181: invokestatic 128	com/tencent/qmsp/sdk/d/e:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   184: astore_1
    //   185: aload_1
    //   186: ifnonnull +17 -> 203
    //   189: aload 5
    //   191: invokevirtual 125	java/io/DataInputStream:close	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: new 28	java/io/DataInputStream
    //   206: dup
    //   207: new 112	java/io/FileInputStream
    //   210: dup
    //   211: aload_0
    //   212: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   215: invokespecial 118	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   218: astore_0
    //   219: aload_0
    //   220: aload 7
    //   222: getfield 37	com/tencent/qmsp/sdk/d/e$b:b	I
    //   225: aload 7
    //   227: getfield 42	com/tencent/qmsp/sdk/d/e$b:d	[B
    //   230: aload_1
    //   231: invokestatic 139	com/tencent/qmsp/sdk/d/e:a	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   234: istore 4
    //   236: aload 5
    //   238: invokevirtual 125	java/io/DataInputStream:close	()V
    //   241: aload_0
    //   242: invokevirtual 125	java/io/DataInputStream:close	()V
    //   245: iload 4
    //   247: ireturn
    //   248: astore_0
    //   249: aload_0
    //   250: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   253: iload 4
    //   255: ireturn
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   261: goto -20 -> 241
    //   264: astore 6
    //   266: aload 5
    //   268: astore_1
    //   269: aload 6
    //   271: astore 5
    //   273: aload 5
    //   275: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   278: aload_1
    //   279: ifnull +7 -> 286
    //   282: aload_1
    //   283: invokevirtual 125	java/io/DataInputStream:close	()V
    //   286: aload_0
    //   287: ifnull -277 -> 10
    //   290: aload_0
    //   291: invokevirtual 125	java/io/DataInputStream:close	()V
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   301: iconst_0
    //   302: ireturn
    //   303: astore 6
    //   305: aload 5
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_0
    //   310: aload 6
    //   312: astore 5
    //   314: goto -41 -> 273
    //   317: astore_0
    //   318: aconst_null
    //   319: astore 5
    //   321: aload 6
    //   323: astore_1
    //   324: aload 5
    //   326: ifnull +8 -> 334
    //   329: aload 5
    //   331: invokevirtual 125	java/io/DataInputStream:close	()V
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 125	java/io/DataInputStream:close	()V
    //   342: aload_0
    //   343: athrow
    //   344: astore 5
    //   346: aconst_null
    //   347: astore_0
    //   348: aconst_null
    //   349: astore_1
    //   350: goto -77 -> 273
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   358: goto -72 -> 286
    //   361: astore 6
    //   363: aload 5
    //   365: astore_1
    //   366: aload 6
    //   368: astore 5
    //   370: aload_0
    //   371: astore 6
    //   373: aload 5
    //   375: astore_0
    //   376: aload_1
    //   377: astore 5
    //   379: aload 6
    //   381: astore_1
    //   382: goto -58 -> 324
    //   385: astore 5
    //   387: aload 5
    //   389: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   392: goto -58 -> 334
    //   395: astore_1
    //   396: aload_1
    //   397: invokevirtual 49	java/io/IOException:printStackTrace	()V
    //   400: goto -58 -> 342
    //   403: astore 5
    //   405: goto -35 -> 370
    //   408: astore_0
    //   409: aload 6
    //   411: astore_1
    //   412: goto -88 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	paramFile	java.io.File
    //   0	415	1	paramString	String
    //   34	130	2	i	int
    //   100	64	3	j	int
    //   234	20	4	bool	boolean
    //   27	303	5	localObject1	Object
    //   344	20	5	localIOException1	IOException
    //   368	10	5	localObject2	Object
    //   385	3	5	localIOException2	IOException
    //   403	1	5	localObject3	Object
    //   1	1	6	localObject4	Object
    //   264	6	6	localIOException3	IOException
    //   303	19	6	localIOException4	IOException
    //   361	6	6	localObject5	Object
    //   371	39	6	localFile	java.io.File
    //   74	152	7	localb	b
    // Exception table:
    //   from	to	target	type
    //   42	47	49	java/io/IOException
    //   81	86	88	java/io/IOException
    //   107	112	114	java/io/IOException
    //   141	146	148	java/io/IOException
    //   166	171	173	java/io/IOException
    //   189	194	196	java/io/IOException
    //   241	245	248	java/io/IOException
    //   236	241	256	java/io/IOException
    //   219	236	264	java/io/IOException
    //   290	294	296	java/io/IOException
    //   29	35	303	java/io/IOException
    //   62	76	303	java/io/IOException
    //   95	101	303	java/io/IOException
    //   121	135	303	java/io/IOException
    //   155	161	303	java/io/IOException
    //   180	185	303	java/io/IOException
    //   203	219	303	java/io/IOException
    //   12	29	317	finally
    //   12	29	344	java/io/IOException
    //   282	286	353	java/io/IOException
    //   219	236	361	finally
    //   329	334	385	java/io/IOException
    //   338	342	395	java/io/IOException
    //   273	278	403	finally
    //   29	35	408	finally
    //   62	76	408	finally
    //   95	101	408	finally
    //   121	135	408	finally
    //   155	161	408	finally
    //   180	185	408	finally
    //   203	219	408	finally
  }
  
  static class b
  {
    public int a;
    public int b;
    public int c;
    public byte[] d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.d.e
 * JD-Core Version:    0.7.0.1
 */