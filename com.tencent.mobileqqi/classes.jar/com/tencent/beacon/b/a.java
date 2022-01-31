package com.tencent.beacon.b;

import android.content.Context;
import com.tencent.beacon.a.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;

public class a
{
  private static a f;
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  private a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    e.a(paramContext);
    this.b = e.b(paramContext);
    e.a(paramContext);
    this.c = e.e(paramContext);
    e.a(paramContext);
    this.d = e.c(paramContext);
    e.a(paramContext);
    this.e = e.d(paramContext);
    try
    {
      paramContext = com.tencent.beacon.a.a.b(paramContext, "QIMEI_DENGTA", "");
      if ((paramContext != null) && (!"".equals(paramContext))) {
        this.a = paramContext;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  /* Error */
  public static long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: iload_1
    //   5: ifgt +7 -> 12
    //   8: ldc2_w 80
    //   11: lreturn
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 6
    //   18: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   21: lstore_2
    //   22: new 89	java/net/InetSocketAddress
    //   25: dup
    //   26: aload_0
    //   27: iload_1
    //   28: invokespecial 92	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   31: astore 7
    //   33: new 94	java/net/Socket
    //   36: dup
    //   37: invokespecial 95	java/net/Socket:<init>	()V
    //   40: astore 5
    //   42: aload 5
    //   44: aload 7
    //   46: sipush 30000
    //   49: invokevirtual 99	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   52: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   55: lload_2
    //   56: lsub
    //   57: lstore_2
    //   58: new 37	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 101
    //   64: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: lload_2
    //   68: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: iconst_0
    //   75: anewarray 4	java/lang/Object
    //   78: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload 5
    //   83: invokevirtual 115	java/net/Socket:close	()V
    //   86: lload_2
    //   87: lreturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   93: aload_0
    //   94: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: lload_2
    //   105: lreturn
    //   106: astore 4
    //   108: aload 6
    //   110: astore 5
    //   112: aload 4
    //   114: astore 6
    //   116: aload 5
    //   118: astore 4
    //   120: aload 6
    //   122: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload 5
    //   134: astore 4
    //   136: new 37	java/lang/StringBuilder
    //   139: dup
    //   140: ldc 126
    //   142: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: aload_0
    //   146: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 128
    //   151: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: iload_1
    //   155: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 133	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 5
    //   170: ifnull +8 -> 178
    //   173: aload 5
    //   175: invokevirtual 115	java/net/Socket:close	()V
    //   178: ldc2_w 80
    //   181: lreturn
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   187: aload_0
    //   188: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   191: iconst_0
    //   192: anewarray 4	java/lang/Object
    //   195: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: ldc2_w 80
    //   201: lreturn
    //   202: astore_0
    //   203: aload 4
    //   205: ifnull +8 -> 213
    //   208: aload 4
    //   210: invokevirtual 115	java/net/Socket:close	()V
    //   213: aload_0
    //   214: athrow
    //   215: astore 4
    //   217: aload 4
    //   219: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   222: aload 4
    //   224: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   227: iconst_0
    //   228: anewarray 4	java/lang/Object
    //   231: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: goto -21 -> 213
    //   237: astore_0
    //   238: aload 5
    //   240: astore 4
    //   242: goto -39 -> 203
    //   245: astore 6
    //   247: goto -131 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramString	String
    //   0	250	1	paramInt	int
    //   21	84	2	l	long
    //   13	1	4	localObject1	Object
    //   106	7	4	localThrowable1	Throwable
    //   118	91	4	localObject2	Object
    //   215	8	4	localIOException	java.io.IOException
    //   240	1	4	localObject3	Object
    //   40	199	5	localObject4	Object
    //   16	105	6	localThrowable2	Throwable
    //   245	1	6	localThrowable3	Throwable
    //   31	14	7	localInetSocketAddress	java.net.InetSocketAddress
    // Exception table:
    //   from	to	target	type
    //   81	86	88	java/io/IOException
    //   33	42	106	java/lang/Throwable
    //   173	178	182	java/io/IOException
    //   33	42	202	finally
    //   120	132	202	finally
    //   136	168	202	finally
    //   208	213	215	java/io/IOException
    //   42	81	237	finally
    //   42	81	245	java/lang/Throwable
  }
  
  /* Error */
  public static b a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: ldc 25
    //   10: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +7 -> 20
    //   16: aconst_null
    //   17: astore_0
    //   18: aload_0
    //   19: areturn
    //   20: new 9	com/tencent/beacon/b/a$b
    //   23: dup
    //   24: invokespecial 135	com/tencent/beacon/b/a$b:<init>	()V
    //   27: astore 11
    //   29: new 137	java/net/URL
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 138	java/net/URL:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 141	java/net/URL:getHost	()Ljava/lang/String;
    //   42: astore 5
    //   44: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   47: lstore_3
    //   48: aload 5
    //   50: invokestatic 147	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   53: astore 7
    //   55: aload 11
    //   57: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   60: lload_3
    //   61: lsub
    //   62: putfield 150	com/tencent/beacon/b/a$b:a	J
    //   65: new 37	java/lang/StringBuilder
    //   68: dup
    //   69: ldc 152
    //   71: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload 11
    //   76: getfield 150	com/tencent/beacon/b/a$b:a	J
    //   79: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: new 154	java/lang/StringBuffer
    //   95: dup
    //   96: invokespecial 155	java/lang/StringBuffer:<init>	()V
    //   99: astore 8
    //   101: aload 7
    //   103: invokevirtual 159	java/net/InetAddress:getAddress	()[B
    //   106: astore 9
    //   108: iconst_0
    //   109: istore_1
    //   110: iload_1
    //   111: aload 9
    //   113: arraylength
    //   114: if_icmpge +52 -> 166
    //   117: new 37	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 161
    //   123: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: astore 10
    //   128: aload 9
    //   130: iload_1
    //   131: baload
    //   132: ifge +903 -> 1035
    //   135: aload 9
    //   137: iload_1
    //   138: baload
    //   139: sipush 256
    //   142: iadd
    //   143: istore_2
    //   144: aload 8
    //   146: aload 10
    //   148: iload_2
    //   149: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: iload_1
    //   160: iconst_1
    //   161: iadd
    //   162: istore_1
    //   163: goto -53 -> 110
    //   166: aload 11
    //   168: aload 8
    //   170: iconst_1
    //   171: invokevirtual 168	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   174: putfield 170	com/tencent/beacon/b/a$b:f	Ljava/lang/String;
    //   177: aload 8
    //   179: iconst_0
    //   180: invokevirtual 174	java/lang/StringBuffer:setLength	(I)V
    //   183: aload_0
    //   184: invokevirtual 178	java/net/URL:getPort	()I
    //   187: istore_1
    //   188: iload_1
    //   189: iflt +566 -> 755
    //   192: new 89	java/net/InetSocketAddress
    //   195: dup
    //   196: aload 7
    //   198: iload_1
    //   199: invokespecial 181	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
    //   202: astore 8
    //   204: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   207: lstore_3
    //   208: new 94	java/net/Socket
    //   211: dup
    //   212: invokespecial 95	java/net/Socket:<init>	()V
    //   215: astore 7
    //   217: aload 7
    //   219: aload 8
    //   221: sipush 30000
    //   224: invokevirtual 99	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   227: aload 11
    //   229: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   232: lload_3
    //   233: lsub
    //   234: putfield 183	com/tencent/beacon/b/a$b:b	J
    //   237: new 37	java/lang/StringBuilder
    //   240: dup
    //   241: ldc 185
    //   243: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload 11
    //   248: getfield 183	com/tencent/beacon/b/a$b:b	J
    //   251: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: new 37	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   271: aload_0
    //   272: invokevirtual 188	java/net/URL:getPath	()Ljava/lang/String;
    //   275: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: astore 8
    //   280: aload_0
    //   281: invokevirtual 191	java/net/URL:getQuery	()Ljava/lang/String;
    //   284: ifnull +477 -> 761
    //   287: new 37	java/lang/StringBuilder
    //   290: dup
    //   291: ldc 193
    //   293: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   296: aload_0
    //   297: invokevirtual 191	java/net/URL:getQuery	()Ljava/lang/String;
    //   300: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_0
    //   307: aload 8
    //   309: aload_0
    //   310: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore_0
    //   317: new 37	java/lang/StringBuilder
    //   320: dup
    //   321: ldc 195
    //   323: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   326: aload_0
    //   327: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc 197
    //   332: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 5
    //   337: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc 199
    //   342: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: astore 12
    //   350: aload 7
    //   352: invokevirtual 203	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   355: astore 5
    //   357: aload 7
    //   359: invokevirtual 207	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   362: astore_0
    //   363: aload_0
    //   364: astore 10
    //   366: aload 5
    //   368: astore 9
    //   370: aload 7
    //   372: astore 8
    //   374: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   377: lstore_3
    //   378: aload_0
    //   379: astore 10
    //   381: aload 5
    //   383: astore 9
    //   385: aload 7
    //   387: astore 8
    //   389: aload 5
    //   391: aload 12
    //   393: ldc 209
    //   395: invokevirtual 213	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   398: invokevirtual 219	java/io/OutputStream:write	([B)V
    //   401: aload_0
    //   402: astore 10
    //   404: aload 5
    //   406: astore 9
    //   408: aload 7
    //   410: astore 8
    //   412: aload 5
    //   414: invokevirtual 222	java/io/OutputStream:flush	()V
    //   417: aload_0
    //   418: astore 10
    //   420: aload 5
    //   422: astore 9
    //   424: aload 7
    //   426: astore 8
    //   428: aload 11
    //   430: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   433: lload_3
    //   434: lsub
    //   435: putfield 224	com/tencent/beacon/b/a$b:c	J
    //   438: aload_0
    //   439: astore 10
    //   441: aload 5
    //   443: astore 9
    //   445: aload 7
    //   447: astore 8
    //   449: new 37	java/lang/StringBuilder
    //   452: dup
    //   453: ldc 226
    //   455: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload 11
    //   460: getfield 224	com/tencent/beacon/b/a$b:c	J
    //   463: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   466: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: iconst_0
    //   470: anewarray 4	java/lang/Object
    //   473: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: aload_0
    //   477: astore 10
    //   479: aload 5
    //   481: astore 9
    //   483: aload 7
    //   485: astore 8
    //   487: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   490: lstore_3
    //   491: aload_0
    //   492: astore 10
    //   494: aload 5
    //   496: astore 9
    //   498: aload 7
    //   500: astore 8
    //   502: aload_0
    //   503: invokevirtual 231	java/io/InputStream:read	()I
    //   506: pop
    //   507: aload_0
    //   508: astore 10
    //   510: aload 5
    //   512: astore 9
    //   514: aload 7
    //   516: astore 8
    //   518: aload 11
    //   520: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   523: lload_3
    //   524: lsub
    //   525: putfield 233	com/tencent/beacon/b/a$b:d	J
    //   528: aload_0
    //   529: astore 10
    //   531: aload 5
    //   533: astore 9
    //   535: aload 7
    //   537: astore 8
    //   539: new 37	java/lang/StringBuilder
    //   542: dup
    //   543: ldc 235
    //   545: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   548: aload 11
    //   550: getfield 233	com/tencent/beacon/b/a$b:d	J
    //   553: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   556: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: iconst_0
    //   560: anewarray 4	java/lang/Object
    //   563: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: aload_0
    //   567: astore 10
    //   569: aload 5
    //   571: astore 9
    //   573: aload 7
    //   575: astore 8
    //   577: sipush 500
    //   580: newarray byte
    //   582: astore 6
    //   584: aload_0
    //   585: astore 10
    //   587: aload 5
    //   589: astore 9
    //   591: aload 7
    //   593: astore 8
    //   595: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   598: lstore_3
    //   599: aload_0
    //   600: astore 10
    //   602: aload 5
    //   604: astore 9
    //   606: aload 7
    //   608: astore 8
    //   610: aload_0
    //   611: aload 6
    //   613: invokevirtual 238	java/io/InputStream:read	([B)I
    //   616: istore_1
    //   617: aload_0
    //   618: astore 10
    //   620: aload 5
    //   622: astore 9
    //   624: aload 7
    //   626: astore 8
    //   628: aload 11
    //   630: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   633: lload_3
    //   634: lsub
    //   635: putfield 240	com/tencent/beacon/b/a$b:e	J
    //   638: aload_0
    //   639: astore 10
    //   641: aload 5
    //   643: astore 9
    //   645: aload 7
    //   647: astore 8
    //   649: new 37	java/lang/StringBuilder
    //   652: dup
    //   653: ldc 242
    //   655: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   658: aload 11
    //   660: getfield 240	com/tencent/beacon/b/a$b:e	J
    //   663: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   666: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: iconst_0
    //   670: anewarray 4	java/lang/Object
    //   673: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   676: aload_0
    //   677: astore 10
    //   679: aload 5
    //   681: astore 9
    //   683: aload 7
    //   685: astore 8
    //   687: new 37	java/lang/StringBuilder
    //   690: dup
    //   691: ldc 244
    //   693: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   696: iload_1
    //   697: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   700: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: iconst_0
    //   704: anewarray 4	java/lang/Object
    //   707: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   710: aload 5
    //   712: ifnull +8 -> 720
    //   715: aload 5
    //   717: invokevirtual 245	java/io/OutputStream:close	()V
    //   720: aload_0
    //   721: ifnull +7 -> 728
    //   724: aload_0
    //   725: invokevirtual 246	java/io/InputStream:close	()V
    //   728: aload 7
    //   730: invokevirtual 115	java/net/Socket:close	()V
    //   733: aload 11
    //   735: areturn
    //   736: astore_0
    //   737: aload_0
    //   738: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   741: aload_0
    //   742: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   745: iconst_0
    //   746: anewarray 4	java/lang/Object
    //   749: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   752: aload 11
    //   754: areturn
    //   755: bipush 80
    //   757: istore_1
    //   758: goto -566 -> 192
    //   761: ldc 25
    //   763: astore_0
    //   764: goto -457 -> 307
    //   767: astore 5
    //   769: aload 5
    //   771: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   774: goto -54 -> 720
    //   777: astore_0
    //   778: aload_0
    //   779: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   782: goto -54 -> 728
    //   785: astore 6
    //   787: aconst_null
    //   788: astore 5
    //   790: aconst_null
    //   791: astore 7
    //   793: aconst_null
    //   794: astore_0
    //   795: aload_0
    //   796: astore 10
    //   798: aload 5
    //   800: astore 9
    //   802: aload 7
    //   804: astore 8
    //   806: aload 6
    //   808: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   811: aload_0
    //   812: astore 10
    //   814: aload 5
    //   816: astore 9
    //   818: aload 7
    //   820: astore 8
    //   822: aload 6
    //   824: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   827: iconst_0
    //   828: anewarray 4	java/lang/Object
    //   831: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   834: aload 5
    //   836: ifnull +8 -> 844
    //   839: aload 5
    //   841: invokevirtual 245	java/io/OutputStream:close	()V
    //   844: aload_0
    //   845: ifnull +7 -> 852
    //   848: aload_0
    //   849: invokevirtual 246	java/io/InputStream:close	()V
    //   852: aload 11
    //   854: astore_0
    //   855: aload 7
    //   857: ifnull -839 -> 18
    //   860: aload 7
    //   862: invokevirtual 115	java/net/Socket:close	()V
    //   865: aload 11
    //   867: areturn
    //   868: astore_0
    //   869: aload_0
    //   870: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   873: aload_0
    //   874: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   877: iconst_0
    //   878: anewarray 4	java/lang/Object
    //   881: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   884: aload 11
    //   886: areturn
    //   887: astore 5
    //   889: aload 5
    //   891: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   894: goto -50 -> 844
    //   897: astore_0
    //   898: aload_0
    //   899: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   902: goto -50 -> 852
    //   905: astore_0
    //   906: aconst_null
    //   907: astore 5
    //   909: aconst_null
    //   910: astore 7
    //   912: aload 5
    //   914: ifnull +8 -> 922
    //   917: aload 5
    //   919: invokevirtual 245	java/io/OutputStream:close	()V
    //   922: aload 6
    //   924: ifnull +8 -> 932
    //   927: aload 6
    //   929: invokevirtual 246	java/io/InputStream:close	()V
    //   932: aload 7
    //   934: ifnull +8 -> 942
    //   937: aload 7
    //   939: invokevirtual 115	java/net/Socket:close	()V
    //   942: aload_0
    //   943: athrow
    //   944: astore 5
    //   946: aload 5
    //   948: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   951: goto -29 -> 922
    //   954: astore 5
    //   956: aload 5
    //   958: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   961: goto -29 -> 932
    //   964: astore 5
    //   966: aload 5
    //   968: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   971: aload 5
    //   973: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   976: iconst_0
    //   977: anewarray 4	java/lang/Object
    //   980: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   983: goto -41 -> 942
    //   986: astore_0
    //   987: aconst_null
    //   988: astore 5
    //   990: goto -78 -> 912
    //   993: astore_0
    //   994: goto -82 -> 912
    //   997: astore_0
    //   998: aload 10
    //   1000: astore 6
    //   1002: aload 9
    //   1004: astore 5
    //   1006: aload 8
    //   1008: astore 7
    //   1010: goto -98 -> 912
    //   1013: astore 6
    //   1015: aconst_null
    //   1016: astore 5
    //   1018: aconst_null
    //   1019: astore_0
    //   1020: goto -225 -> 795
    //   1023: astore 6
    //   1025: aconst_null
    //   1026: astore_0
    //   1027: goto -232 -> 795
    //   1030: astore 6
    //   1032: goto -237 -> 795
    //   1035: aload 9
    //   1037: iload_1
    //   1038: baload
    //   1039: istore_2
    //   1040: goto -896 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1043	0	paramString	String
    //   109	929	1	i	int
    //   143	897	2	j	int
    //   47	587	3	l	long
    //   42	674	5	localObject1	Object
    //   767	3	5	localIOException1	java.io.IOException
    //   788	52	5	localObject2	Object
    //   887	3	5	localIOException2	java.io.IOException
    //   907	11	5	localObject3	Object
    //   944	3	5	localIOException3	java.io.IOException
    //   954	3	5	localIOException4	java.io.IOException
    //   964	8	5	localIOException5	java.io.IOException
    //   988	29	5	localObject4	Object
    //   1	611	6	arrayOfByte	byte[]
    //   785	143	6	localThrowable1	Throwable
    //   1000	1	6	localObject5	Object
    //   1013	1	6	localThrowable2	Throwable
    //   1023	1	6	localThrowable3	Throwable
    //   1030	1	6	localThrowable4	Throwable
    //   53	956	7	localObject6	Object
    //   99	908	8	localObject7	Object
    //   106	930	9	localObject8	Object
    //   126	873	10	localObject9	Object
    //   27	858	11	localb	b
    //   348	44	12	str	String
    // Exception table:
    //   from	to	target	type
    //   728	733	736	java/io/IOException
    //   715	720	767	java/io/IOException
    //   724	728	777	java/io/IOException
    //   29	108	785	java/lang/Throwable
    //   110	128	785	java/lang/Throwable
    //   144	159	785	java/lang/Throwable
    //   166	188	785	java/lang/Throwable
    //   192	217	785	java/lang/Throwable
    //   860	865	868	java/io/IOException
    //   839	844	887	java/io/IOException
    //   848	852	897	java/io/IOException
    //   29	108	905	finally
    //   110	128	905	finally
    //   144	159	905	finally
    //   166	188	905	finally
    //   192	217	905	finally
    //   917	922	944	java/io/IOException
    //   927	932	954	java/io/IOException
    //   937	942	964	java/io/IOException
    //   217	307	986	finally
    //   307	357	986	finally
    //   357	363	993	finally
    //   374	378	997	finally
    //   389	401	997	finally
    //   412	417	997	finally
    //   428	438	997	finally
    //   449	476	997	finally
    //   487	491	997	finally
    //   502	507	997	finally
    //   518	528	997	finally
    //   539	566	997	finally
    //   577	584	997	finally
    //   595	599	997	finally
    //   610	617	997	finally
    //   628	638	997	finally
    //   649	676	997	finally
    //   687	710	997	finally
    //   806	811	997	finally
    //   822	834	997	finally
    //   217	307	1013	java/lang/Throwable
    //   307	357	1013	java/lang/Throwable
    //   357	363	1023	java/lang/Throwable
    //   374	378	1030	java/lang/Throwable
    //   389	401	1030	java/lang/Throwable
    //   412	417	1030	java/lang/Throwable
    //   428	438	1030	java/lang/Throwable
    //   449	476	1030	java/lang/Throwable
    //   487	491	1030	java/lang/Throwable
    //   502	507	1030	java/lang/Throwable
    //   518	528	1030	java/lang/Throwable
    //   539	566	1030	java/lang/Throwable
    //   577	584	1030	java/lang/Throwable
    //   595	599	1030	java/lang/Throwable
    //   610	617	1030	java/lang/Throwable
    //   628	638	1030	java/lang/Throwable
    //   649	676	1030	java/lang/Throwable
    //   687	710	1030	java/lang/Throwable
  }
  
  /* Error */
  public static b a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: ldc 25
    //   7: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 9	com/tencent/beacon/b/a$b
    //   18: dup
    //   19: invokespecial 135	com/tencent/beacon/b/a$b:<init>	()V
    //   22: astore 28
    //   24: aconst_null
    //   25: astore 26
    //   27: aconst_null
    //   28: astore 25
    //   30: aconst_null
    //   31: astore 22
    //   33: aconst_null
    //   34: astore 21
    //   36: aconst_null
    //   37: astore 24
    //   39: aconst_null
    //   40: astore 23
    //   42: aload 23
    //   44: astore 19
    //   46: aload 21
    //   48: astore 17
    //   50: aload 25
    //   52: astore 15
    //   54: aload 24
    //   56: astore 18
    //   58: aload 22
    //   60: astore 16
    //   62: aload 26
    //   64: astore 14
    //   66: new 137	java/net/URL
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 138	java/net/URL:<init>	(Ljava/lang/String;)V
    //   74: astore 29
    //   76: aconst_null
    //   77: astore 27
    //   79: aload 23
    //   81: astore 19
    //   83: aload 21
    //   85: astore 17
    //   87: aload 25
    //   89: astore 15
    //   91: aload 24
    //   93: astore 18
    //   95: aload 22
    //   97: astore 16
    //   99: aload 26
    //   101: astore 14
    //   103: invokestatic 253	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   106: astore 20
    //   108: aload 23
    //   110: astore 19
    //   112: aload 21
    //   114: astore 17
    //   116: aload 25
    //   118: astore 15
    //   120: aload 24
    //   122: astore 18
    //   124: aload 22
    //   126: astore 16
    //   128: aload 26
    //   130: astore 14
    //   132: invokestatic 256	android/net/Proxy:getDefaultPort	()I
    //   135: istore_3
    //   136: aload 20
    //   138: ifnull +44 -> 182
    //   141: aload 23
    //   143: astore 19
    //   145: aload 21
    //   147: astore 17
    //   149: aload 25
    //   151: astore 15
    //   153: aload 24
    //   155: astore 18
    //   157: aload 22
    //   159: astore 16
    //   161: aload 26
    //   163: astore 14
    //   165: aload 20
    //   167: invokevirtual 259	java/lang/String:trim	()Ljava/lang/String;
    //   170: invokevirtual 262	java/lang/String:length	()I
    //   173: ifeq +9 -> 182
    //   176: iload_3
    //   177: istore_2
    //   178: iload_3
    //   179: ifgt +1553 -> 1732
    //   182: aload 23
    //   184: astore 19
    //   186: aload 21
    //   188: astore 17
    //   190: aload 25
    //   192: astore 15
    //   194: aload 24
    //   196: astore 18
    //   198: aload 22
    //   200: astore 16
    //   202: aload 26
    //   204: astore 14
    //   206: ldc_w 264
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_1
    //   217: ifnull +1768 -> 1985
    //   220: aload 23
    //   222: astore 19
    //   224: aload 21
    //   226: astore 17
    //   228: aload 25
    //   230: astore 15
    //   232: aload 24
    //   234: astore 18
    //   236: aload 22
    //   238: astore 16
    //   240: aload 26
    //   242: astore 14
    //   244: aload_1
    //   245: invokevirtual 259	java/lang/String:trim	()Ljava/lang/String;
    //   248: invokevirtual 262	java/lang/String:length	()I
    //   251: ifgt +836 -> 1087
    //   254: goto +1731 -> 1985
    //   257: aload_0
    //   258: ifnonnull +1632 -> 1890
    //   261: aload 23
    //   263: astore 19
    //   265: aload 21
    //   267: astore 17
    //   269: aload 25
    //   271: astore 15
    //   273: aload 24
    //   275: astore 18
    //   277: aload 22
    //   279: astore 16
    //   281: aload 26
    //   283: astore 14
    //   285: aload 29
    //   287: invokevirtual 268	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   290: checkcast 270	java/net/HttpURLConnection
    //   293: astore_0
    //   294: aload 23
    //   296: astore 19
    //   298: aload 21
    //   300: astore 17
    //   302: aload_0
    //   303: astore 15
    //   305: aload 24
    //   307: astore 18
    //   309: aload 22
    //   311: astore 16
    //   313: aload_0
    //   314: astore 14
    //   316: aload_0
    //   317: iconst_1
    //   318: invokevirtual 274	java/net/HttpURLConnection:setDoInput	(Z)V
    //   321: aload 23
    //   323: astore 19
    //   325: aload 21
    //   327: astore 17
    //   329: aload_0
    //   330: astore 15
    //   332: aload 24
    //   334: astore 18
    //   336: aload 22
    //   338: astore 16
    //   340: aload_0
    //   341: astore 14
    //   343: aload_0
    //   344: iconst_1
    //   345: invokevirtual 277	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   348: aload 23
    //   350: astore 19
    //   352: aload 21
    //   354: astore 17
    //   356: aload_0
    //   357: astore 15
    //   359: aload 24
    //   361: astore 18
    //   363: aload 22
    //   365: astore 16
    //   367: aload_0
    //   368: astore 14
    //   370: aload_0
    //   371: sipush 30000
    //   374: invokevirtual 280	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   377: aload 23
    //   379: astore 19
    //   381: aload 21
    //   383: astore 17
    //   385: aload_0
    //   386: astore 15
    //   388: aload 24
    //   390: astore 18
    //   392: aload 22
    //   394: astore 16
    //   396: aload_0
    //   397: astore 14
    //   399: aload_0
    //   400: sipush 30000
    //   403: invokevirtual 283	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   406: aload 23
    //   408: astore 19
    //   410: aload 21
    //   412: astore 17
    //   414: aload_0
    //   415: astore 15
    //   417: aload 24
    //   419: astore 18
    //   421: aload 22
    //   423: astore 16
    //   425: aload_0
    //   426: astore 14
    //   428: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   431: lstore 4
    //   433: aload 23
    //   435: astore 19
    //   437: aload 21
    //   439: astore 17
    //   441: aload_0
    //   442: astore 15
    //   444: aload 24
    //   446: astore 18
    //   448: aload 22
    //   450: astore 16
    //   452: aload_0
    //   453: astore 14
    //   455: aload_0
    //   456: invokevirtual 285	java/net/HttpURLConnection:connect	()V
    //   459: aload 23
    //   461: astore 19
    //   463: aload 21
    //   465: astore 17
    //   467: aload_0
    //   468: astore 15
    //   470: aload 24
    //   472: astore 18
    //   474: aload 22
    //   476: astore 16
    //   478: aload_0
    //   479: astore 14
    //   481: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   484: lstore 6
    //   486: aload 23
    //   488: astore 19
    //   490: aload 21
    //   492: astore 17
    //   494: aload_0
    //   495: astore 15
    //   497: aload 24
    //   499: astore 18
    //   501: aload 22
    //   503: astore 16
    //   505: aload_0
    //   506: astore 14
    //   508: aload_0
    //   509: invokevirtual 286	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   512: astore_1
    //   513: aload_1
    //   514: astore 19
    //   516: aload 21
    //   518: astore 17
    //   520: aload_0
    //   521: astore 15
    //   523: aload_1
    //   524: astore 18
    //   526: aload 22
    //   528: astore 16
    //   530: aload_0
    //   531: astore 14
    //   533: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   536: lstore 8
    //   538: aload_1
    //   539: astore 19
    //   541: aload 21
    //   543: astore 17
    //   545: aload_0
    //   546: astore 15
    //   548: aload_1
    //   549: astore 18
    //   551: aload 22
    //   553: astore 16
    //   555: aload_0
    //   556: astore 14
    //   558: aload_0
    //   559: invokevirtual 287	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   562: astore 20
    //   564: aload_1
    //   565: astore 19
    //   567: aload 20
    //   569: astore 17
    //   571: aload_0
    //   572: astore 15
    //   574: aload_1
    //   575: astore 18
    //   577: aload 20
    //   579: astore 16
    //   581: aload_0
    //   582: astore 14
    //   584: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   587: lstore 10
    //   589: aload_1
    //   590: astore 19
    //   592: aload 20
    //   594: astore 17
    //   596: aload_0
    //   597: astore 15
    //   599: aload_1
    //   600: astore 18
    //   602: aload 20
    //   604: astore 16
    //   606: aload_0
    //   607: astore 14
    //   609: aload 20
    //   611: invokevirtual 231	java/io/InputStream:read	()I
    //   614: iconst_m1
    //   615: if_icmpne -26 -> 589
    //   618: aload_1
    //   619: astore 19
    //   621: aload 20
    //   623: astore 17
    //   625: aload_0
    //   626: astore 15
    //   628: aload_1
    //   629: astore 18
    //   631: aload 20
    //   633: astore 16
    //   635: aload_0
    //   636: astore 14
    //   638: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   641: lstore 12
    //   643: aload_1
    //   644: astore 19
    //   646: aload 20
    //   648: astore 17
    //   650: aload_0
    //   651: astore 15
    //   653: aload_1
    //   654: astore 18
    //   656: aload 20
    //   658: astore 16
    //   660: aload_0
    //   661: astore 14
    //   663: aload 28
    //   665: ldc2_w 80
    //   668: putfield 150	com/tencent/beacon/b/a$b:a	J
    //   671: aload_1
    //   672: astore 19
    //   674: aload 20
    //   676: astore 17
    //   678: aload_0
    //   679: astore 15
    //   681: aload_1
    //   682: astore 18
    //   684: aload 20
    //   686: astore 16
    //   688: aload_0
    //   689: astore 14
    //   691: aload 28
    //   693: ldc 25
    //   695: putfield 170	com/tencent/beacon/b/a$b:f	Ljava/lang/String;
    //   698: aload_1
    //   699: astore 19
    //   701: aload 20
    //   703: astore 17
    //   705: aload_0
    //   706: astore 15
    //   708: aload_1
    //   709: astore 18
    //   711: aload 20
    //   713: astore 16
    //   715: aload_0
    //   716: astore 14
    //   718: aload 28
    //   720: lload 6
    //   722: lload 4
    //   724: lsub
    //   725: putfield 183	com/tencent/beacon/b/a$b:b	J
    //   728: aload_1
    //   729: astore 19
    //   731: aload 20
    //   733: astore 17
    //   735: aload_0
    //   736: astore 15
    //   738: aload_1
    //   739: astore 18
    //   741: aload 20
    //   743: astore 16
    //   745: aload_0
    //   746: astore 14
    //   748: aload 28
    //   750: lload 8
    //   752: lload 6
    //   754: lsub
    //   755: putfield 224	com/tencent/beacon/b/a$b:c	J
    //   758: aload_1
    //   759: astore 19
    //   761: aload 20
    //   763: astore 17
    //   765: aload_0
    //   766: astore 15
    //   768: aload_1
    //   769: astore 18
    //   771: aload 20
    //   773: astore 16
    //   775: aload_0
    //   776: astore 14
    //   778: aload 28
    //   780: lload 10
    //   782: lload 8
    //   784: lsub
    //   785: putfield 233	com/tencent/beacon/b/a$b:d	J
    //   788: aload_1
    //   789: astore 19
    //   791: aload 20
    //   793: astore 17
    //   795: aload_0
    //   796: astore 15
    //   798: aload_1
    //   799: astore 18
    //   801: aload 20
    //   803: astore 16
    //   805: aload_0
    //   806: astore 14
    //   808: aload 28
    //   810: lload 12
    //   812: lload 10
    //   814: lsub
    //   815: putfield 240	com/tencent/beacon/b/a$b:e	J
    //   818: aload_1
    //   819: astore 19
    //   821: aload 20
    //   823: astore 17
    //   825: aload_0
    //   826: astore 15
    //   828: aload_1
    //   829: astore 18
    //   831: aload 20
    //   833: astore 16
    //   835: aload_0
    //   836: astore 14
    //   838: new 37	java/lang/StringBuilder
    //   841: dup
    //   842: ldc_w 289
    //   845: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   848: aload 28
    //   850: getfield 150	com/tencent/beacon/b/a$b:a	J
    //   853: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   856: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: iconst_0
    //   860: anewarray 4	java/lang/Object
    //   863: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   866: aload_1
    //   867: astore 19
    //   869: aload 20
    //   871: astore 17
    //   873: aload_0
    //   874: astore 15
    //   876: aload_1
    //   877: astore 18
    //   879: aload 20
    //   881: astore 16
    //   883: aload_0
    //   884: astore 14
    //   886: new 37	java/lang/StringBuilder
    //   889: dup
    //   890: ldc_w 291
    //   893: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   896: aload 28
    //   898: getfield 183	com/tencent/beacon/b/a$b:b	J
    //   901: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   904: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: iconst_0
    //   908: anewarray 4	java/lang/Object
    //   911: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   914: aload_1
    //   915: astore 19
    //   917: aload 20
    //   919: astore 17
    //   921: aload_0
    //   922: astore 15
    //   924: aload_1
    //   925: astore 18
    //   927: aload 20
    //   929: astore 16
    //   931: aload_0
    //   932: astore 14
    //   934: new 37	java/lang/StringBuilder
    //   937: dup
    //   938: ldc_w 293
    //   941: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   944: aload 28
    //   946: getfield 224	com/tencent/beacon/b/a$b:c	J
    //   949: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   952: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: iconst_0
    //   956: anewarray 4	java/lang/Object
    //   959: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   962: aload_1
    //   963: astore 19
    //   965: aload 20
    //   967: astore 17
    //   969: aload_0
    //   970: astore 15
    //   972: aload_1
    //   973: astore 18
    //   975: aload 20
    //   977: astore 16
    //   979: aload_0
    //   980: astore 14
    //   982: new 37	java/lang/StringBuilder
    //   985: dup
    //   986: ldc_w 295
    //   989: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   992: aload 28
    //   994: getfield 233	com/tencent/beacon/b/a$b:d	J
    //   997: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1000: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1003: iconst_0
    //   1004: anewarray 4	java/lang/Object
    //   1007: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1010: aload_1
    //   1011: astore 19
    //   1013: aload 20
    //   1015: astore 17
    //   1017: aload_0
    //   1018: astore 15
    //   1020: aload_1
    //   1021: astore 18
    //   1023: aload 20
    //   1025: astore 16
    //   1027: aload_0
    //   1028: astore 14
    //   1030: new 37	java/lang/StringBuilder
    //   1033: dup
    //   1034: ldc_w 297
    //   1037: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1040: aload 28
    //   1042: getfield 240	com/tencent/beacon/b/a$b:e	J
    //   1045: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: iconst_0
    //   1052: anewarray 4	java/lang/Object
    //   1055: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1058: aload_1
    //   1059: ifnull +7 -> 1066
    //   1062: aload_1
    //   1063: invokevirtual 245	java/io/OutputStream:close	()V
    //   1066: aload 20
    //   1068: ifnull +8 -> 1076
    //   1071: aload 20
    //   1073: invokevirtual 246	java/io/InputStream:close	()V
    //   1076: aload_0
    //   1077: ifnull +7 -> 1084
    //   1080: aload_0
    //   1081: invokevirtual 300	java/net/HttpURLConnection:disconnect	()V
    //   1084: aload 28
    //   1086: areturn
    //   1087: aload 23
    //   1089: astore 19
    //   1091: aload 21
    //   1093: astore 17
    //   1095: aload 25
    //   1097: astore 15
    //   1099: aload 24
    //   1101: astore 18
    //   1103: aload 22
    //   1105: astore 16
    //   1107: aload 26
    //   1109: astore 14
    //   1111: new 6	com/tencent/beacon/b/a$a
    //   1114: dup
    //   1115: invokespecial 301	com/tencent/beacon/b/a$a:<init>	()V
    //   1118: astore 20
    //   1120: aload 23
    //   1122: astore 19
    //   1124: aload 21
    //   1126: astore 17
    //   1128: aload 25
    //   1130: astore 15
    //   1132: aload 24
    //   1134: astore 18
    //   1136: aload 22
    //   1138: astore 16
    //   1140: aload 26
    //   1142: astore 14
    //   1144: aload_1
    //   1145: invokevirtual 304	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1148: astore 30
    //   1150: aload 23
    //   1152: astore 19
    //   1154: aload 21
    //   1156: astore 17
    //   1158: aload 25
    //   1160: astore 15
    //   1162: aload 24
    //   1164: astore 18
    //   1166: aload 22
    //   1168: astore 16
    //   1170: aload 26
    //   1172: astore 14
    //   1174: aload 30
    //   1176: ldc_w 306
    //   1179: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1182: ifeq +179 -> 1361
    //   1185: aload 23
    //   1187: astore 19
    //   1189: aload 21
    //   1191: astore 17
    //   1193: aload 25
    //   1195: astore 15
    //   1197: aload 24
    //   1199: astore 18
    //   1201: aload 22
    //   1203: astore 16
    //   1205: aload 26
    //   1207: astore 14
    //   1209: ldc_w 312
    //   1212: iconst_0
    //   1213: anewarray 4	java/lang/Object
    //   1216: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1219: aload 23
    //   1221: astore 19
    //   1223: aload 21
    //   1225: astore 17
    //   1227: aload 25
    //   1229: astore 15
    //   1231: aload 24
    //   1233: astore 18
    //   1235: aload 22
    //   1237: astore 16
    //   1239: aload 26
    //   1241: astore 14
    //   1243: aload 20
    //   1245: ldc_w 314
    //   1248: putfield 315	com/tencent/beacon/b/a$a:a	Ljava/lang/String;
    //   1251: aload 23
    //   1253: astore 19
    //   1255: aload 21
    //   1257: astore 17
    //   1259: aload 25
    //   1261: astore 15
    //   1263: aload 24
    //   1265: astore 18
    //   1267: aload 22
    //   1269: astore 16
    //   1271: aload 26
    //   1273: astore 14
    //   1275: aload 20
    //   1277: bipush 80
    //   1279: putfield 318	com/tencent/beacon/b/a$a:b	I
    //   1282: aload 20
    //   1284: astore_0
    //   1285: goto +702 -> 1987
    //   1288: astore_0
    //   1289: aload 19
    //   1291: astore 18
    //   1293: aload 17
    //   1295: astore 16
    //   1297: aload 15
    //   1299: astore 14
    //   1301: aload_0
    //   1302: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   1305: aload 19
    //   1307: astore 18
    //   1309: aload 17
    //   1311: astore 16
    //   1313: aload 15
    //   1315: astore 14
    //   1317: aload_0
    //   1318: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1321: iconst_0
    //   1322: anewarray 4	java/lang/Object
    //   1325: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1328: aload 19
    //   1330: ifnull +8 -> 1338
    //   1333: aload 19
    //   1335: invokevirtual 245	java/io/OutputStream:close	()V
    //   1338: aload 17
    //   1340: ifnull +8 -> 1348
    //   1343: aload 17
    //   1345: invokevirtual 246	java/io/InputStream:close	()V
    //   1348: aload 15
    //   1350: ifnull -266 -> 1084
    //   1353: aload 15
    //   1355: invokevirtual 300	java/net/HttpURLConnection:disconnect	()V
    //   1358: goto -274 -> 1084
    //   1361: aload 23
    //   1363: astore 19
    //   1365: aload 21
    //   1367: astore 17
    //   1369: aload 25
    //   1371: astore 15
    //   1373: aload 24
    //   1375: astore 18
    //   1377: aload 22
    //   1379: astore 16
    //   1381: aload 26
    //   1383: astore 14
    //   1385: aload 30
    //   1387: ldc_w 320
    //   1390: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1393: ifeq +139 -> 1532
    //   1396: aload 23
    //   1398: astore 19
    //   1400: aload 21
    //   1402: astore 17
    //   1404: aload 25
    //   1406: astore 15
    //   1408: aload 24
    //   1410: astore 18
    //   1412: aload 22
    //   1414: astore 16
    //   1416: aload 26
    //   1418: astore 14
    //   1420: ldc_w 322
    //   1423: iconst_0
    //   1424: anewarray 4	java/lang/Object
    //   1427: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1430: aload 23
    //   1432: astore 19
    //   1434: aload 21
    //   1436: astore 17
    //   1438: aload 25
    //   1440: astore 15
    //   1442: aload 24
    //   1444: astore 18
    //   1446: aload 22
    //   1448: astore 16
    //   1450: aload 26
    //   1452: astore 14
    //   1454: aload 20
    //   1456: ldc_w 324
    //   1459: putfield 315	com/tencent/beacon/b/a$a:a	Ljava/lang/String;
    //   1462: aload 23
    //   1464: astore 19
    //   1466: aload 21
    //   1468: astore 17
    //   1470: aload 25
    //   1472: astore 15
    //   1474: aload 24
    //   1476: astore 18
    //   1478: aload 22
    //   1480: astore 16
    //   1482: aload 26
    //   1484: astore 14
    //   1486: aload 20
    //   1488: bipush 80
    //   1490: putfield 318	com/tencent/beacon/b/a$a:b	I
    //   1493: aload 20
    //   1495: astore_0
    //   1496: goto +491 -> 1987
    //   1499: astore_0
    //   1500: aload 18
    //   1502: ifnull +8 -> 1510
    //   1505: aload 18
    //   1507: invokevirtual 245	java/io/OutputStream:close	()V
    //   1510: aload 16
    //   1512: ifnull +8 -> 1520
    //   1515: aload 16
    //   1517: invokevirtual 246	java/io/InputStream:close	()V
    //   1520: aload 14
    //   1522: ifnull +8 -> 1530
    //   1525: aload 14
    //   1527: invokevirtual 300	java/net/HttpURLConnection:disconnect	()V
    //   1530: aload_0
    //   1531: athrow
    //   1532: aload 23
    //   1534: astore 19
    //   1536: aload 21
    //   1538: astore 17
    //   1540: aload 25
    //   1542: astore 15
    //   1544: aload 24
    //   1546: astore 18
    //   1548: aload 22
    //   1550: astore 16
    //   1552: aload 26
    //   1554: astore 14
    //   1556: aload 20
    //   1558: astore_0
    //   1559: aload 30
    //   1561: ldc_w 326
    //   1564: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1567: ifeq +420 -> 1987
    //   1570: aload 23
    //   1572: astore 19
    //   1574: aload 21
    //   1576: astore 17
    //   1578: aload 25
    //   1580: astore 15
    //   1582: aload 24
    //   1584: astore 18
    //   1586: aload 22
    //   1588: astore 16
    //   1590: aload 26
    //   1592: astore 14
    //   1594: ldc_w 328
    //   1597: iconst_0
    //   1598: anewarray 4	java/lang/Object
    //   1601: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1604: aload 23
    //   1606: astore 19
    //   1608: aload 21
    //   1610: astore 17
    //   1612: aload 25
    //   1614: astore 15
    //   1616: aload 24
    //   1618: astore 18
    //   1620: aload 22
    //   1622: astore 16
    //   1624: aload 26
    //   1626: astore 14
    //   1628: aload 20
    //   1630: ldc_w 324
    //   1633: putfield 315	com/tencent/beacon/b/a$a:a	Ljava/lang/String;
    //   1636: aload 23
    //   1638: astore 19
    //   1640: aload 21
    //   1642: astore 17
    //   1644: aload 25
    //   1646: astore 15
    //   1648: aload 24
    //   1650: astore 18
    //   1652: aload 22
    //   1654: astore 16
    //   1656: aload 26
    //   1658: astore 14
    //   1660: aload 20
    //   1662: bipush 80
    //   1664: putfield 318	com/tencent/beacon/b/a$a:b	I
    //   1667: aload 20
    //   1669: astore_0
    //   1670: goto +317 -> 1987
    //   1673: aload 23
    //   1675: astore 19
    //   1677: aload 21
    //   1679: astore 17
    //   1681: aload 25
    //   1683: astore 15
    //   1685: aload 24
    //   1687: astore 18
    //   1689: aload 22
    //   1691: astore 16
    //   1693: aload 26
    //   1695: astore 14
    //   1697: aload_0
    //   1698: getfield 315	com/tencent/beacon/b/a$a:a	Ljava/lang/String;
    //   1701: astore 20
    //   1703: aload 23
    //   1705: astore 19
    //   1707: aload 21
    //   1709: astore 17
    //   1711: aload 25
    //   1713: astore 15
    //   1715: aload 24
    //   1717: astore 18
    //   1719: aload 22
    //   1721: astore 16
    //   1723: aload 26
    //   1725: astore 14
    //   1727: aload_0
    //   1728: getfield 318	com/tencent/beacon/b/a$a:b	I
    //   1731: istore_2
    //   1732: aload 27
    //   1734: astore_0
    //   1735: aload 20
    //   1737: ifnull -1480 -> 257
    //   1740: aload 27
    //   1742: astore_0
    //   1743: aload 23
    //   1745: astore 19
    //   1747: aload 21
    //   1749: astore 17
    //   1751: aload 25
    //   1753: astore 15
    //   1755: aload 24
    //   1757: astore 18
    //   1759: aload 22
    //   1761: astore 16
    //   1763: aload 26
    //   1765: astore 14
    //   1767: aload 20
    //   1769: invokevirtual 259	java/lang/String:trim	()Ljava/lang/String;
    //   1772: invokevirtual 262	java/lang/String:length	()I
    //   1775: ifle -1518 -> 257
    //   1778: aload 23
    //   1780: astore 19
    //   1782: aload 21
    //   1784: astore 17
    //   1786: aload 25
    //   1788: astore 15
    //   1790: aload 24
    //   1792: astore 18
    //   1794: aload 22
    //   1796: astore 16
    //   1798: aload 26
    //   1800: astore 14
    //   1802: new 89	java/net/InetSocketAddress
    //   1805: dup
    //   1806: aload 20
    //   1808: iload_2
    //   1809: invokespecial 92	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   1812: astore_0
    //   1813: aload 23
    //   1815: astore 19
    //   1817: aload 21
    //   1819: astore 17
    //   1821: aload 25
    //   1823: astore 15
    //   1825: aload 24
    //   1827: astore 18
    //   1829: aload 22
    //   1831: astore 16
    //   1833: aload 26
    //   1835: astore 14
    //   1837: new 37	java/lang/StringBuilder
    //   1840: dup
    //   1841: ldc_w 330
    //   1844: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1847: aload_1
    //   1848: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: ldc_w 332
    //   1854: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: aload 20
    //   1859: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: ldc 128
    //   1864: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1867: iload_2
    //   1868: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1871: ldc_w 334
    //   1874: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1877: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1880: iconst_0
    //   1881: anewarray 4	java/lang/Object
    //   1884: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1887: goto -1630 -> 257
    //   1890: aload 23
    //   1892: astore 19
    //   1894: aload 21
    //   1896: astore 17
    //   1898: aload 25
    //   1900: astore 15
    //   1902: aload 24
    //   1904: astore 18
    //   1906: aload 22
    //   1908: astore 16
    //   1910: aload 26
    //   1912: astore 14
    //   1914: aload 29
    //   1916: new 336	java/net/Proxy
    //   1919: dup
    //   1920: getstatic 342	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   1923: aload_0
    //   1924: invokespecial 345	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   1927: invokevirtual 348	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1930: checkcast 270	java/net/HttpURLConnection
    //   1933: astore_0
    //   1934: goto -1640 -> 294
    //   1937: astore_1
    //   1938: aload_1
    //   1939: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   1942: goto -876 -> 1066
    //   1945: astore_1
    //   1946: aload_1
    //   1947: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   1950: goto -874 -> 1076
    //   1953: astore_0
    //   1954: aload_0
    //   1955: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   1958: goto -620 -> 1338
    //   1961: astore_0
    //   1962: aload_0
    //   1963: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   1966: goto -618 -> 1348
    //   1969: astore_1
    //   1970: aload_1
    //   1971: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   1974: goto -464 -> 1510
    //   1977: astore_1
    //   1978: aload_1
    //   1979: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   1982: goto -462 -> 1520
    //   1985: aconst_null
    //   1986: astore_0
    //   1987: aload_0
    //   1988: ifnonnull -315 -> 1673
    //   1991: aconst_null
    //   1992: astore_0
    //   1993: goto -1736 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1996	0	paramString1	String
    //   0	1996	1	paramString2	String
    //   177	1691	2	i	int
    //   135	44	3	j	int
    //   431	292	4	l1	long
    //   484	269	6	l2	long
    //   536	247	8	l3	long
    //   587	226	10	l4	long
    //   641	170	12	l5	long
    //   64	1849	14	localObject1	Object
    //   52	1849	15	localObject2	Object
    //   60	1849	16	localObject3	Object
    //   48	1849	17	localObject4	Object
    //   56	1849	18	localObject5	Object
    //   44	1849	19	localObject6	Object
    //   106	1752	20	localObject7	Object
    //   34	1861	21	localObject8	Object
    //   31	1876	22	localObject9	Object
    //   40	1851	23	localObject10	Object
    //   37	1866	24	localObject11	Object
    //   28	1871	25	localObject12	Object
    //   25	1886	26	localObject13	Object
    //   77	1664	27	localObject14	Object
    //   22	1063	28	localb	b
    //   74	1841	29	localURL	java.net.URL
    //   1148	412	30	str	String
    // Exception table:
    //   from	to	target	type
    //   66	76	1288	java/lang/Throwable
    //   103	108	1288	java/lang/Throwable
    //   132	136	1288	java/lang/Throwable
    //   165	176	1288	java/lang/Throwable
    //   206	216	1288	java/lang/Throwable
    //   244	254	1288	java/lang/Throwable
    //   285	294	1288	java/lang/Throwable
    //   316	321	1288	java/lang/Throwable
    //   343	348	1288	java/lang/Throwable
    //   370	377	1288	java/lang/Throwable
    //   399	406	1288	java/lang/Throwable
    //   428	433	1288	java/lang/Throwable
    //   455	459	1288	java/lang/Throwable
    //   481	486	1288	java/lang/Throwable
    //   508	513	1288	java/lang/Throwable
    //   533	538	1288	java/lang/Throwable
    //   558	564	1288	java/lang/Throwable
    //   584	589	1288	java/lang/Throwable
    //   609	618	1288	java/lang/Throwable
    //   638	643	1288	java/lang/Throwable
    //   663	671	1288	java/lang/Throwable
    //   691	698	1288	java/lang/Throwable
    //   718	728	1288	java/lang/Throwable
    //   748	758	1288	java/lang/Throwable
    //   778	788	1288	java/lang/Throwable
    //   808	818	1288	java/lang/Throwable
    //   838	866	1288	java/lang/Throwable
    //   886	914	1288	java/lang/Throwable
    //   934	962	1288	java/lang/Throwable
    //   982	1010	1288	java/lang/Throwable
    //   1030	1058	1288	java/lang/Throwable
    //   1111	1120	1288	java/lang/Throwable
    //   1144	1150	1288	java/lang/Throwable
    //   1174	1185	1288	java/lang/Throwable
    //   1209	1219	1288	java/lang/Throwable
    //   1243	1251	1288	java/lang/Throwable
    //   1275	1282	1288	java/lang/Throwable
    //   1385	1396	1288	java/lang/Throwable
    //   1420	1430	1288	java/lang/Throwable
    //   1454	1462	1288	java/lang/Throwable
    //   1486	1493	1288	java/lang/Throwable
    //   1559	1570	1288	java/lang/Throwable
    //   1594	1604	1288	java/lang/Throwable
    //   1628	1636	1288	java/lang/Throwable
    //   1660	1667	1288	java/lang/Throwable
    //   1697	1703	1288	java/lang/Throwable
    //   1727	1732	1288	java/lang/Throwable
    //   1767	1778	1288	java/lang/Throwable
    //   1802	1813	1288	java/lang/Throwable
    //   1837	1887	1288	java/lang/Throwable
    //   1914	1934	1288	java/lang/Throwable
    //   66	76	1499	finally
    //   103	108	1499	finally
    //   132	136	1499	finally
    //   165	176	1499	finally
    //   206	216	1499	finally
    //   244	254	1499	finally
    //   285	294	1499	finally
    //   316	321	1499	finally
    //   343	348	1499	finally
    //   370	377	1499	finally
    //   399	406	1499	finally
    //   428	433	1499	finally
    //   455	459	1499	finally
    //   481	486	1499	finally
    //   508	513	1499	finally
    //   533	538	1499	finally
    //   558	564	1499	finally
    //   584	589	1499	finally
    //   609	618	1499	finally
    //   638	643	1499	finally
    //   663	671	1499	finally
    //   691	698	1499	finally
    //   718	728	1499	finally
    //   748	758	1499	finally
    //   778	788	1499	finally
    //   808	818	1499	finally
    //   838	866	1499	finally
    //   886	914	1499	finally
    //   934	962	1499	finally
    //   982	1010	1499	finally
    //   1030	1058	1499	finally
    //   1111	1120	1499	finally
    //   1144	1150	1499	finally
    //   1174	1185	1499	finally
    //   1209	1219	1499	finally
    //   1243	1251	1499	finally
    //   1275	1282	1499	finally
    //   1301	1305	1499	finally
    //   1317	1328	1499	finally
    //   1385	1396	1499	finally
    //   1420	1430	1499	finally
    //   1454	1462	1499	finally
    //   1486	1493	1499	finally
    //   1559	1570	1499	finally
    //   1594	1604	1499	finally
    //   1628	1636	1499	finally
    //   1660	1667	1499	finally
    //   1697	1703	1499	finally
    //   1727	1732	1499	finally
    //   1767	1778	1499	finally
    //   1802	1813	1499	finally
    //   1837	1887	1499	finally
    //   1914	1934	1499	finally
    //   1062	1066	1937	java/io/IOException
    //   1071	1076	1945	java/io/IOException
    //   1333	1338	1953	java/io/IOException
    //   1343	1348	1961	java/io/IOException
    //   1505	1510	1969	java/io/IOException
    //   1515	1520	1977	java/io/IOException
  }
  
  /* Error */
  public static b a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: ifnull +38 -> 42
    //   7: aload_0
    //   8: ldc 25
    //   10: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +29 -> 42
    //   16: aload_1
    //   17: ifnull +25 -> 42
    //   20: aload_1
    //   21: ldc 25
    //   23: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +16 -> 42
    //   29: aload_2
    //   30: ifnull +12 -> 42
    //   33: aload_2
    //   34: ldc 25
    //   36: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +7 -> 46
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: areturn
    //   46: new 9	com/tencent/beacon/b/a$b
    //   49: dup
    //   50: invokespecial 135	com/tencent/beacon/b/a$b:<init>	()V
    //   53: astore 11
    //   55: new 37	java/lang/StringBuilder
    //   58: dup
    //   59: ldc_w 351
    //   62: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_2
    //   77: new 137	java/net/URL
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 138	java/net/URL:<init>	(Ljava/lang/String;)V
    //   85: astore 9
    //   87: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   90: lstore 5
    //   92: aload_1
    //   93: invokestatic 147	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   96: astore_2
    //   97: aload 11
    //   99: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   102: lload 5
    //   104: lsub
    //   105: putfield 150	com/tencent/beacon/b/a$b:a	J
    //   108: new 37	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 152
    //   114: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload 11
    //   119: getfield 150	com/tencent/beacon/b/a$b:a	J
    //   122: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: new 154	java/lang/StringBuffer
    //   138: dup
    //   139: invokespecial 155	java/lang/StringBuffer:<init>	()V
    //   142: astore 7
    //   144: aload_2
    //   145: invokevirtual 159	java/net/InetAddress:getAddress	()[B
    //   148: astore_2
    //   149: iconst_0
    //   150: istore_3
    //   151: iload_3
    //   152: aload_2
    //   153: arraylength
    //   154: if_icmpge +165 -> 319
    //   157: new 37	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 161
    //   163: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: astore 10
    //   168: aload_2
    //   169: iload_3
    //   170: baload
    //   171: ifge +140 -> 311
    //   174: aload_2
    //   175: iload_3
    //   176: baload
    //   177: sipush 256
    //   180: iadd
    //   181: istore 4
    //   183: aload 7
    //   185: aload 10
    //   187: iload 4
    //   189: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   198: pop
    //   199: iload_3
    //   200: iconst_1
    //   201: iadd
    //   202: istore_3
    //   203: goto -52 -> 151
    //   206: aload 11
    //   208: ldc2_w 80
    //   211: putfield 150	com/tencent/beacon/b/a$b:a	J
    //   214: goto -106 -> 108
    //   217: astore_2
    //   218: aconst_null
    //   219: astore_1
    //   220: aconst_null
    //   221: astore 7
    //   223: aconst_null
    //   224: astore_0
    //   225: aload_0
    //   226: astore 10
    //   228: aload_1
    //   229: astore 9
    //   231: aload 7
    //   233: astore 8
    //   235: aload_2
    //   236: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   239: aload_0
    //   240: astore 10
    //   242: aload_1
    //   243: astore 9
    //   245: aload 7
    //   247: astore 8
    //   249: aload_2
    //   250: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 245	java/io/OutputStream:close	()V
    //   268: aload_0
    //   269: ifnull +7 -> 276
    //   272: aload_0
    //   273: invokevirtual 246	java/io/InputStream:close	()V
    //   276: aload 11
    //   278: astore_0
    //   279: aload 7
    //   281: ifnull -237 -> 44
    //   284: aload 7
    //   286: invokevirtual 115	java/net/Socket:close	()V
    //   289: aload 11
    //   291: areturn
    //   292: astore_0
    //   293: aload_0
    //   294: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   297: aload_0
    //   298: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: aload 11
    //   310: areturn
    //   311: aload_2
    //   312: iload_3
    //   313: baload
    //   314: istore 4
    //   316: goto -133 -> 183
    //   319: aload 11
    //   321: aload 7
    //   323: iconst_1
    //   324: invokevirtual 168	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   327: putfield 170	com/tencent/beacon/b/a$b:f	Ljava/lang/String;
    //   330: aload 7
    //   332: iconst_0
    //   333: invokevirtual 174	java/lang/StringBuffer:setLength	(I)V
    //   336: aload_0
    //   337: ldc 128
    //   339: invokevirtual 355	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   342: astore_0
    //   343: new 89	java/net/InetSocketAddress
    //   346: dup
    //   347: aload_0
    //   348: iconst_0
    //   349: aaload
    //   350: aload_0
    //   351: iconst_1
    //   352: aaload
    //   353: invokestatic 361	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   356: invokespecial 92	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   359: astore_0
    //   360: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   363: lstore 5
    //   365: new 94	java/net/Socket
    //   368: dup
    //   369: invokespecial 95	java/net/Socket:<init>	()V
    //   372: astore 7
    //   374: aload 7
    //   376: aload_0
    //   377: sipush 30000
    //   380: invokevirtual 99	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   383: aload 11
    //   385: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   388: lload 5
    //   390: lsub
    //   391: putfield 183	com/tencent/beacon/b/a$b:b	J
    //   394: new 37	java/lang/StringBuilder
    //   397: dup
    //   398: ldc 185
    //   400: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: aload 11
    //   405: getfield 183	com/tencent/beacon/b/a$b:b	J
    //   408: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   411: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: iconst_0
    //   415: anewarray 4	java/lang/Object
    //   418: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: new 37	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   428: aload 9
    //   430: invokevirtual 188	java/net/URL:getPath	()Ljava/lang/String;
    //   433: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: astore_2
    //   437: aload 9
    //   439: invokevirtual 191	java/net/URL:getQuery	()Ljava/lang/String;
    //   442: ifnull +443 -> 885
    //   445: new 37	java/lang/StringBuilder
    //   448: dup
    //   449: ldc 193
    //   451: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   454: aload 9
    //   456: invokevirtual 191	java/net/URL:getQuery	()Ljava/lang/String;
    //   459: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: astore_0
    //   466: aload_2
    //   467: aload_0
    //   468: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: astore_0
    //   475: new 37	java/lang/StringBuilder
    //   478: dup
    //   479: ldc 195
    //   481: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   484: aload_0
    //   485: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: ldc 197
    //   490: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload_1
    //   494: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: ldc 199
    //   499: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: astore_2
    //   506: ldc_w 363
    //   509: new 37	java/lang/StringBuilder
    //   512: dup
    //   513: ldc_w 365
    //   516: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload_2
    //   520: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 371	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   529: pop
    //   530: aload 7
    //   532: invokevirtual 203	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   535: astore_1
    //   536: aload 7
    //   538: invokevirtual 207	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   541: astore_0
    //   542: aload_0
    //   543: astore 10
    //   545: aload_1
    //   546: astore 9
    //   548: aload 7
    //   550: astore 8
    //   552: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   555: lstore 5
    //   557: aload_0
    //   558: astore 10
    //   560: aload_1
    //   561: astore 9
    //   563: aload 7
    //   565: astore 8
    //   567: aload_1
    //   568: aload_2
    //   569: ldc 209
    //   571: invokevirtual 213	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   574: invokevirtual 219	java/io/OutputStream:write	([B)V
    //   577: aload_0
    //   578: astore 10
    //   580: aload_1
    //   581: astore 9
    //   583: aload 7
    //   585: astore 8
    //   587: aload_1
    //   588: invokevirtual 222	java/io/OutputStream:flush	()V
    //   591: aload_0
    //   592: astore 10
    //   594: aload_1
    //   595: astore 9
    //   597: aload 7
    //   599: astore 8
    //   601: aload 11
    //   603: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   606: lload 5
    //   608: lsub
    //   609: putfield 224	com/tencent/beacon/b/a$b:c	J
    //   612: aload_0
    //   613: astore 10
    //   615: aload_1
    //   616: astore 9
    //   618: aload 7
    //   620: astore 8
    //   622: new 37	java/lang/StringBuilder
    //   625: dup
    //   626: ldc 226
    //   628: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   631: aload 11
    //   633: getfield 224	com/tencent/beacon/b/a$b:c	J
    //   636: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   639: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: iconst_0
    //   643: anewarray 4	java/lang/Object
    //   646: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   649: aload_0
    //   650: astore 10
    //   652: aload_1
    //   653: astore 9
    //   655: aload 7
    //   657: astore 8
    //   659: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   662: lstore 5
    //   664: aload_0
    //   665: astore 10
    //   667: aload_1
    //   668: astore 9
    //   670: aload 7
    //   672: astore 8
    //   674: aload_0
    //   675: invokevirtual 231	java/io/InputStream:read	()I
    //   678: pop
    //   679: aload_0
    //   680: astore 10
    //   682: aload_1
    //   683: astore 9
    //   685: aload 7
    //   687: astore 8
    //   689: aload 11
    //   691: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   694: lload 5
    //   696: lsub
    //   697: putfield 233	com/tencent/beacon/b/a$b:d	J
    //   700: aload_0
    //   701: astore 10
    //   703: aload_1
    //   704: astore 9
    //   706: aload 7
    //   708: astore 8
    //   710: new 37	java/lang/StringBuilder
    //   713: dup
    //   714: ldc 235
    //   716: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   719: aload 11
    //   721: getfield 233	com/tencent/beacon/b/a$b:d	J
    //   724: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   727: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: iconst_0
    //   731: anewarray 4	java/lang/Object
    //   734: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   737: aload_0
    //   738: astore 10
    //   740: aload_1
    //   741: astore 9
    //   743: aload 7
    //   745: astore 8
    //   747: sipush 500
    //   750: newarray byte
    //   752: astore_2
    //   753: aload_0
    //   754: astore 10
    //   756: aload_1
    //   757: astore 9
    //   759: aload 7
    //   761: astore 8
    //   763: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   766: lstore 5
    //   768: aload_0
    //   769: astore 10
    //   771: aload_1
    //   772: astore 9
    //   774: aload 7
    //   776: astore 8
    //   778: aload_0
    //   779: aload_2
    //   780: invokevirtual 238	java/io/InputStream:read	([B)I
    //   783: pop
    //   784: aload_0
    //   785: astore 10
    //   787: aload_1
    //   788: astore 9
    //   790: aload 7
    //   792: astore 8
    //   794: aload 11
    //   796: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   799: lload 5
    //   801: lsub
    //   802: putfield 240	com/tencent/beacon/b/a$b:e	J
    //   805: aload_0
    //   806: astore 10
    //   808: aload_1
    //   809: astore 9
    //   811: aload 7
    //   813: astore 8
    //   815: new 37	java/lang/StringBuilder
    //   818: dup
    //   819: ldc 242
    //   821: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   824: aload 11
    //   826: getfield 240	com/tencent/beacon/b/a$b:e	J
    //   829: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   832: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   835: iconst_0
    //   836: anewarray 4	java/lang/Object
    //   839: invokestatic 112	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   842: aload_1
    //   843: ifnull +7 -> 850
    //   846: aload_1
    //   847: invokevirtual 245	java/io/OutputStream:close	()V
    //   850: aload_0
    //   851: ifnull +7 -> 858
    //   854: aload_0
    //   855: invokevirtual 246	java/io/InputStream:close	()V
    //   858: aload 7
    //   860: invokevirtual 115	java/net/Socket:close	()V
    //   863: aload 11
    //   865: areturn
    //   866: astore_0
    //   867: aload_0
    //   868: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   871: aload_0
    //   872: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   875: iconst_0
    //   876: anewarray 4	java/lang/Object
    //   879: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   882: aload 11
    //   884: areturn
    //   885: ldc 25
    //   887: astore_0
    //   888: goto -422 -> 466
    //   891: astore_1
    //   892: aload_1
    //   893: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   896: goto -46 -> 850
    //   899: astore_0
    //   900: aload_0
    //   901: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   904: goto -46 -> 858
    //   907: astore_1
    //   908: aload_1
    //   909: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   912: goto -644 -> 268
    //   915: astore_0
    //   916: aload_0
    //   917: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   920: goto -644 -> 276
    //   923: astore_0
    //   924: aconst_null
    //   925: astore_1
    //   926: aconst_null
    //   927: astore 7
    //   929: aload 8
    //   931: astore_2
    //   932: aload_1
    //   933: ifnull +7 -> 940
    //   936: aload_1
    //   937: invokevirtual 245	java/io/OutputStream:close	()V
    //   940: aload_2
    //   941: ifnull +7 -> 948
    //   944: aload_2
    //   945: invokevirtual 246	java/io/InputStream:close	()V
    //   948: aload 7
    //   950: ifnull +8 -> 958
    //   953: aload 7
    //   955: invokevirtual 115	java/net/Socket:close	()V
    //   958: aload_0
    //   959: athrow
    //   960: astore_1
    //   961: aload_1
    //   962: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   965: goto -25 -> 940
    //   968: astore_1
    //   969: aload_1
    //   970: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   973: goto -25 -> 948
    //   976: astore_1
    //   977: aload_1
    //   978: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   981: aload_1
    //   982: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
    //   985: iconst_0
    //   986: anewarray 4	java/lang/Object
    //   989: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   992: goto -34 -> 958
    //   995: astore_0
    //   996: aconst_null
    //   997: astore_1
    //   998: aload 8
    //   1000: astore_2
    //   1001: goto -69 -> 932
    //   1004: astore_0
    //   1005: aload 8
    //   1007: astore_2
    //   1008: goto -76 -> 932
    //   1011: astore_0
    //   1012: aload 10
    //   1014: astore_2
    //   1015: aload 9
    //   1017: astore_1
    //   1018: aload 8
    //   1020: astore 7
    //   1022: goto -90 -> 932
    //   1025: astore_2
    //   1026: aconst_null
    //   1027: astore_1
    //   1028: aconst_null
    //   1029: astore_0
    //   1030: goto -805 -> 225
    //   1033: astore_2
    //   1034: aconst_null
    //   1035: astore_0
    //   1036: goto -811 -> 225
    //   1039: astore_2
    //   1040: goto -815 -> 225
    //   1043: astore 7
    //   1045: goto -839 -> 206
    //   1048: astore_2
    //   1049: aconst_null
    //   1050: astore_2
    //   1051: goto -845 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1054	0	paramString1	String
    //   0	1054	1	paramString2	String
    //   0	1054	2	paramString3	String
    //   150	163	3	i	int
    //   181	134	4	j	int
    //   90	710	5	l	long
    //   142	879	7	localObject1	Object
    //   1043	1	7	localException	Exception
    //   1	1018	8	localObject2	Object
    //   85	931	9	localObject3	Object
    //   166	847	10	localObject4	Object
    //   53	830	11	localb	b
    // Exception table:
    //   from	to	target	type
    //   77	92	217	java/lang/Throwable
    //   92	97	217	java/lang/Throwable
    //   97	108	217	java/lang/Throwable
    //   108	149	217	java/lang/Throwable
    //   151	168	217	java/lang/Throwable
    //   183	199	217	java/lang/Throwable
    //   206	214	217	java/lang/Throwable
    //   319	374	217	java/lang/Throwable
    //   284	289	292	java/io/IOException
    //   858	863	866	java/io/IOException
    //   846	850	891	java/io/IOException
    //   854	858	899	java/io/IOException
    //   264	268	907	java/io/IOException
    //   272	276	915	java/io/IOException
    //   77	92	923	finally
    //   92	97	923	finally
    //   97	108	923	finally
    //   108	149	923	finally
    //   151	168	923	finally
    //   183	199	923	finally
    //   206	214	923	finally
    //   319	374	923	finally
    //   936	940	960	java/io/IOException
    //   944	948	968	java/io/IOException
    //   953	958	976	java/io/IOException
    //   374	466	995	finally
    //   466	536	995	finally
    //   536	542	1004	finally
    //   235	239	1011	finally
    //   249	260	1011	finally
    //   552	557	1011	finally
    //   567	577	1011	finally
    //   587	591	1011	finally
    //   601	612	1011	finally
    //   622	649	1011	finally
    //   659	664	1011	finally
    //   674	679	1011	finally
    //   689	700	1011	finally
    //   710	737	1011	finally
    //   747	753	1011	finally
    //   763	768	1011	finally
    //   778	784	1011	finally
    //   794	805	1011	finally
    //   815	842	1011	finally
    //   374	466	1025	java/lang/Throwable
    //   466	536	1025	java/lang/Throwable
    //   536	542	1033	java/lang/Throwable
    //   552	557	1039	java/lang/Throwable
    //   567	577	1039	java/lang/Throwable
    //   587	591	1039	java/lang/Throwable
    //   601	612	1039	java/lang/Throwable
    //   622	649	1039	java/lang/Throwable
    //   659	664	1039	java/lang/Throwable
    //   674	679	1039	java/lang/Throwable
    //   689	700	1039	java/lang/Throwable
    //   710	737	1039	java/lang/Throwable
    //   747	753	1039	java/lang/Throwable
    //   763	768	1039	java/lang/Throwable
    //   778	784	1039	java/lang/Throwable
    //   794	805	1039	java/lang/Throwable
    //   815	842	1039	java/lang/Throwable
    //   97	108	1043	java/lang/Exception
    //   92	97	1048	java/lang/Exception
  }
  
  public static a a(Context paramContext)
  {
    if (f == null) {
      f = new a(paramContext);
    }
    return f;
  }
  
  /* Error */
  public static com.tencent.beacon.c.a.b a(int paramInt1, com.tencent.beacon.a.d paramd, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 379
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 133	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_1
    //   11: ifnonnull +15 -> 26
    //   14: ldc_w 381
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 383	com/tencent/beacon/c/a/b
    //   29: dup
    //   30: invokespecial 384	com/tencent/beacon/c/a/b:<init>	()V
    //   33: astore 5
    //   35: aload_1
    //   36: monitorenter
    //   37: aload 5
    //   39: aload_1
    //   40: invokevirtual 388	com/tencent/beacon/a/d:a	()Ljava/lang/String;
    //   43: putfield 391	com/tencent/beacon/c/a/b:j	Ljava/lang/String;
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 393	com/tencent/beacon/a/d:b	()Ljava/lang/String;
    //   52: putfield 396	com/tencent/beacon/c/a/b:k	Ljava/lang/String;
    //   55: aload 5
    //   57: aload_1
    //   58: invokevirtual 399	com/tencent/beacon/a/d:c	()B
    //   61: putfield 402	com/tencent/beacon/c/a/b:a	B
    //   64: aload 5
    //   66: aload_1
    //   67: invokevirtual 404	com/tencent/beacon/a/d:j	()Ljava/lang/String;
    //   70: putfield 405	com/tencent/beacon/c/a/b:b	Ljava/lang/String;
    //   73: aload 5
    //   75: aload_1
    //   76: invokevirtual 407	com/tencent/beacon/a/d:d	()Ljava/lang/String;
    //   79: putfield 408	com/tencent/beacon/c/a/b:c	Ljava/lang/String;
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 410	com/tencent/beacon/a/d:e	()Ljava/lang/String;
    //   88: putfield 411	com/tencent/beacon/c/a/b:d	Ljava/lang/String;
    //   91: aload 5
    //   93: aload_1
    //   94: invokevirtual 413	com/tencent/beacon/a/d:f	()Ljava/lang/String;
    //   97: putfield 414	com/tencent/beacon/c/a/b:e	Ljava/lang/String;
    //   100: aload 5
    //   102: ldc 25
    //   104: putfield 417	com/tencent/beacon/c/a/b:l	Ljava/lang/String;
    //   107: iload_0
    //   108: bipush 100
    //   110: if_icmpne +328 -> 438
    //   113: new 419	java/util/HashMap
    //   116: dup
    //   117: invokespecial 420	java/util/HashMap:<init>	()V
    //   120: astore 6
    //   122: aload 6
    //   124: ldc_w 422
    //   127: new 37	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   134: invokestatic 427	com/tencent/beacon/event/UserAction:getUserID	()Ljava/lang/String;
    //   137: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokeinterface 433 3 0
    //   148: pop
    //   149: aload 6
    //   151: ldc_w 435
    //   154: new 37	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   161: aload_1
    //   162: invokevirtual 437	com/tencent/beacon/a/d:i	()Ljava/lang/String;
    //   165: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokeinterface 433 3 0
    //   176: pop
    //   177: aload_1
    //   178: invokevirtual 440	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   181: invokestatic 445	com/tencent/beacon/event/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/event/c;
    //   184: astore 7
    //   186: aload 6
    //   188: ldc_w 447
    //   191: new 37	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   198: aload 7
    //   200: invokevirtual 448	com/tencent/beacon/event/c:b	()Ljava/lang/String;
    //   203: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokeinterface 433 3 0
    //   214: pop
    //   215: aload 6
    //   217: ldc_w 450
    //   220: new 37	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   227: aload 7
    //   229: invokevirtual 451	com/tencent/beacon/event/c:a	()Ljava/lang/String;
    //   232: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokeinterface 433 3 0
    //   243: pop
    //   244: aload 6
    //   246: ldc_w 453
    //   249: new 37	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   256: aload 7
    //   258: invokevirtual 455	com/tencent/beacon/event/c:c	()Ljava/lang/String;
    //   261: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokeinterface 433 3 0
    //   272: pop
    //   273: new 37	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   280: astore 8
    //   282: aload_1
    //   283: invokevirtual 440	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   286: astore 9
    //   288: getstatic 374	com/tencent/beacon/b/a:f	Lcom/tencent/beacon/b/a;
    //   291: ifnonnull +15 -> 306
    //   294: new 2	com/tencent/beacon/b/a
    //   297: dup
    //   298: aload 9
    //   300: invokespecial 376	com/tencent/beacon/b/a:<init>	(Landroid/content/Context;)V
    //   303: putstatic 374	com/tencent/beacon/b/a:f	Lcom/tencent/beacon/b/a;
    //   306: aload 6
    //   308: ldc_w 457
    //   311: aload 8
    //   313: getstatic 374	com/tencent/beacon/b/a:f	Lcom/tencent/beacon/b/a;
    //   316: invokevirtual 458	com/tencent/beacon/b/a:a	()Ljava/lang/String;
    //   319: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokeinterface 433 3 0
    //   330: pop
    //   331: aload 6
    //   333: ldc_w 460
    //   336: new 37	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   343: aload 7
    //   345: invokevirtual 461	com/tencent/beacon/event/c:d	()Ljava/lang/String;
    //   348: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokeinterface 433 3 0
    //   359: pop
    //   360: aload_1
    //   361: invokevirtual 440	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   364: invokestatic 43	com/tencent/beacon/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/e;
    //   367: pop
    //   368: aload 6
    //   370: ldc_w 463
    //   373: aload_1
    //   374: invokevirtual 440	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   377: invokestatic 465	com/tencent/beacon/a/e:j	(Landroid/content/Context;)Ljava/lang/String;
    //   380: invokeinterface 433 3 0
    //   385: pop
    //   386: aload_1
    //   387: invokevirtual 440	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   390: invokestatic 469	com/tencent/beacon/a/a:g	(Landroid/content/Context;)Z
    //   393: ifeq +89 -> 482
    //   396: aload 6
    //   398: ldc_w 471
    //   401: ldc_w 473
    //   404: invokeinterface 433 3 0
    //   409: pop
    //   410: aload 6
    //   412: ldc_w 475
    //   415: aload_1
    //   416: invokevirtual 440	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   419: invokestatic 478	com/tencent/beacon/a/a:h	(Landroid/content/Context;)Ljava/lang/String;
    //   422: invokeinterface 433 3 0
    //   427: pop
    //   428: aload 5
    //   430: aload 6
    //   432: invokestatic 481	com/tencent/beacon/a/e:a	(Ljava/util/Map;)Ljava/lang/String;
    //   435: putfield 417	com/tencent/beacon/c/a/b:l	Ljava/lang/String;
    //   438: aload_1
    //   439: monitorexit
    //   440: aload 5
    //   442: iload_0
    //   443: putfield 483	com/tencent/beacon/c/a/b:f	I
    //   446: aload 5
    //   448: iload 4
    //   450: i2b
    //   451: putfield 485	com/tencent/beacon/c/a/b:h	B
    //   454: aload 5
    //   456: iload_3
    //   457: i2b
    //   458: putfield 487	com/tencent/beacon/c/a/b:i	B
    //   461: aload_2
    //   462: astore_1
    //   463: aload_2
    //   464: ifnonnull +9 -> 473
    //   467: ldc 25
    //   469: invokevirtual 489	java/lang/String:getBytes	()[B
    //   472: astore_1
    //   473: aload 5
    //   475: aload_1
    //   476: putfield 492	com/tencent/beacon/c/a/b:g	[B
    //   479: aload 5
    //   481: areturn
    //   482: aload 6
    //   484: ldc_w 471
    //   487: ldc_w 493
    //   490: invokeinterface 433 3 0
    //   495: pop
    //   496: goto -86 -> 410
    //   499: astore_2
    //   500: aload_1
    //   501: monitorexit
    //   502: aload_2
    //   503: athrow
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   509: aconst_null
    //   510: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	paramInt1	int
    //   0	511	1	paramd	com.tencent.beacon.a.d
    //   0	511	2	paramArrayOfByte	byte[]
    //   0	511	3	paramInt2	int
    //   0	511	4	paramInt3	int
    //   33	447	5	localb	com.tencent.beacon.c.a.b
    //   120	363	6	localHashMap	java.util.HashMap
    //   184	160	7	localc	com.tencent.beacon.event.c
    //   280	32	8	localStringBuilder	StringBuilder
    //   286	13	9	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   37	107	499	finally
    //   113	306	499	finally
    //   306	410	499	finally
    //   410	438	499	finally
    //   438	440	499	finally
    //   482	496	499	finally
    //   26	37	504	java/lang/Throwable
    //   440	461	504	java/lang/Throwable
    //   467	473	504	java/lang/Throwable
    //   473	479	504	java/lang/Throwable
    //   500	504	504	java/lang/Throwable
  }
  
  /* Error */
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 496
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 133	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +8 -> 19
    //   14: aload_0
    //   15: arraylength
    //   16: ifge +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 498	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 500	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: astore_3
    //   30: new 502	java/io/ObjectInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 505	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 509	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 510	java/io/ObjectInputStream:close	()V
    //   50: aload_3
    //   51: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: areturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   61: aload_2
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 510	java/io/ObjectInputStream:close	()V
    //   101: aload_3
    //   102: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   119: goto -18 -> 101
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 510	java/io/ObjectInputStream:close	()V
    //   133: aload_3
    //   134: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   137: aload_1
    //   138: athrow
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   144: goto -11 -> 133
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   152: goto -15 -> 137
    //   155: astore_1
    //   156: goto -31 -> 125
    //   159: astore_2
    //   160: goto -86 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramArrayOfByte	byte[]
    //   38	60	1	localObjectInputStream	java.io.ObjectInputStream
    //   122	16	1	localObject1	Object
    //   155	1	1	localObject2	Object
    //   45	17	2	localObject3	Object
    //   71	12	2	localThrowable1	Throwable
    //   159	1	2	localThrowable2	Throwable
    //   29	105	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   50	54	56	java/io/IOException
    //   46	50	63	java/io/IOException
    //   30	39	71	java/lang/Throwable
    //   101	105	107	java/io/IOException
    //   97	101	114	java/io/IOException
    //   30	39	122	finally
    //   129	133	139	java/io/IOException
    //   133	137	147	java/io/IOException
    //   41	46	155	finally
    //   76	80	155	finally
    //   82	93	155	finally
    //   41	46	159	java/lang/Throwable
  }
  
  public static HashSet<String> a(ArrayList<String> paramArrayList)
  {
    int i = paramArrayList.size();
    if ((paramArrayList != null) && (i > 0))
    {
      HashSet localHashSet = new HashSet(i);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localHashSet.add((String)paramArrayList.next());
      }
      return localHashSet;
    }
    return null;
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 542
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 133	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +13 -> 24
    //   14: ldc_w 544
    //   17: aload_0
    //   18: invokevirtual 549	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   21: ifne +15 -> 36
    //   24: ldc_w 551
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 553	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 555	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 556	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 4
    //   45: new 558	java/io/ObjectOutputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 561	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 565	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 566	java/io/ObjectOutputStream:flush	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: invokevirtual 569	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 570	java/io/ObjectOutputStream:close	()V
    //   80: aload 4
    //   82: invokevirtual 571	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   92: aload_0
    //   93: areturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   99: goto -19 -> 80
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_1
    //   107: aload_3
    //   108: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   111: aload_0
    //   112: astore_1
    //   113: aload_3
    //   114: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 123	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 570	java/io/ObjectOutputStream:close	()V
    //   132: aload 4
    //   134: invokevirtual 571	java/io/ByteArrayOutputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   151: goto -19 -> 132
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 570	java/io/ObjectOutputStream:close	()V
    //   165: aload 4
    //   167: invokevirtual 571	java/io/ByteArrayOutputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   177: goto -12 -> 165
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   185: goto -15 -> 170
    //   188: astore_0
    //   189: goto -32 -> 157
    //   192: astore_3
    //   193: aload_2
    //   194: astore_0
    //   195: goto -90 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramObject	Object
    //   56	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   94	2	1	localIOException2	java.io.IOException
    //   106	56	1	localObject	Object
    //   172	2	1	localIOException3	java.io.IOException
    //   180	2	1	localIOException4	java.io.IOException
    //   54	140	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   102	12	3	localThrowable1	Throwable
    //   192	1	3	localThrowable2	Throwable
    //   43	123	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	85	87	java/io/IOException
    //   76	80	94	java/io/IOException
    //   45	55	102	java/lang/Throwable
    //   132	137	139	java/io/IOException
    //   128	132	146	java/io/IOException
    //   45	55	154	finally
    //   161	165	172	java/io/IOException
    //   165	170	180	java/io/IOException
    //   57	62	188	finally
    //   64	68	188	finally
    //   70	76	188	finally
    //   107	111	188	finally
    //   113	124	188	finally
    //   57	62	192	java/lang/Throwable
    //   64	68	192	java/lang/Throwable
    //   70	76	192	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = e.a(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d("err zp : %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(a(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    try
    {
      paramArrayOfByte = e.b(paramInt, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static Long[] a(LinkedHashMap<Long, Long> paramLinkedHashMap, long paramLong)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.size() <= 0) || (paramLong <= 0L)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramLinkedHashMap.keySet().iterator();
    long l1 = 0L;
    if ((localIterator.hasNext()) && (l1 < paramLong))
    {
      long l2 = ((Long)localIterator.next()).longValue();
      long l3 = ((Long)paramLinkedHashMap.get(Long.valueOf(l2))).longValue();
      if (l1 + l3 > paramLong) {
        break label140;
      }
      localArrayList.add(Long.valueOf(l2));
      l1 += l3;
    }
    label140:
    for (;;)
    {
      break;
      if (localArrayList.size() > 0) {
        return (Long[])localArrayList.toArray(new Long[1]);
      }
      return null;
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = e.b(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = b(b(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    try
    {
      paramArrayOfByte = e.a(paramInt, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static long f()
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
      long l = localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  public static String g()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  static final class a
  {
    public String a = "";
    public int b = -1;
  }
  
  public static final class b
  {
    public long a = -1L;
    public long b = -1L;
    public long c = -1L;
    public long d = -1L;
    public long e = -1L;
    public String f = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.b.a
 * JD-Core Version:    0.7.0.1
 */