package com.huawei.updatesdk.a.b.b;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.d;
import com.huawei.updatesdk.service.c.g;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class b
  extends AsyncTask<Void, Void, Void>
{
  private HttpURLConnection a;
  private boolean b = false;
  private a c;
  private Handler d = new a(null);
  
  public b(a parama)
  {
    this.c = parama;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a locala = new a();
    locala.a(paramInt1);
    locala.b(paramInt2);
    if (this.d == null) {
      return;
    }
    this.d.sendMessage(this.d.obtainMessage(paramInt3, locala));
  }
  
  /* Error */
  private void a(a parama, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 59	com/huawei/updatesdk/a/b/b/a:c	()Ljava/lang/String;
    //   8: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: new 67	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   22: aload_2
    //   23: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 74
    //   28: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 4
    //   36: new 79	java/io/File
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: new 84	java/io/FileOutputStream
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_0
    //   58: aload_1
    //   59: aload_3
    //   60: aload 4
    //   62: invokespecial 90	com/huawei/updatesdk/a/b/b/b:a	(Lcom/huawei/updatesdk/a/b/b/a;Ljava/io/OutputStream;Ljava/lang/String;)Z
    //   65: ifne +19 -> 84
    //   68: aload_3
    //   69: astore_2
    //   70: new 79	java/io/File
    //   73: dup
    //   74: invokestatic 92	com/huawei/updatesdk/a/b/b/b:d	()Ljava/lang/String;
    //   77: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokestatic 97	com/huawei/updatesdk/a/a/c/d:a	(Ljava/io/File;)Z
    //   83: pop
    //   84: aload_3
    //   85: ifnull -71 -> 14
    //   88: aload_3
    //   89: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   92: return
    //   93: astore_1
    //   94: ldc 102
    //   96: ldc 104
    //   98: invokestatic 109	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: return
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_3
    //   105: aload_3
    //   106: astore_2
    //   107: ldc 102
    //   109: new 67	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   116: ldc 111
    //   118: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 112	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   125: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 109	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_3
    //   135: ifnull -121 -> 14
    //   138: aload_3
    //   139: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   142: return
    //   143: astore_1
    //   144: ldc 102
    //   146: ldc 104
    //   148: invokestatic 109	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: return
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_3
    //   155: aload_3
    //   156: astore_2
    //   157: ldc 102
    //   159: new 67	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   166: ldc 114
    //   168: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 115	java/lang/Exception:toString	()Ljava/lang/String;
    //   175: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 109	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_3
    //   185: ifnull -171 -> 14
    //   188: aload_3
    //   189: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   192: return
    //   193: astore_1
    //   194: ldc 102
    //   196: ldc 104
    //   198: invokestatic 109	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: return
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_2
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   213: aload_1
    //   214: athrow
    //   215: astore_2
    //   216: ldc 102
    //   218: ldc 104
    //   220: invokestatic 109	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: goto -10 -> 213
    //   226: astore_1
    //   227: goto -22 -> 205
    //   230: astore_1
    //   231: goto -76 -> 155
    //   234: astore_1
    //   235: goto -130 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	b
    //   0	238	1	parama	a
    //   0	238	2	paramString	String
    //   54	135	3	localFileOutputStream	java.io.FileOutputStream
    //   34	27	4	str	String
    // Exception table:
    //   from	to	target	type
    //   88	92	93	java/io/IOException
    //   46	55	102	java/io/FileNotFoundException
    //   138	142	143	java/io/IOException
    //   46	55	152	java/lang/Exception
    //   188	192	193	java/io/IOException
    //   46	55	202	finally
    //   209	213	215	java/io/IOException
    //   57	68	226	finally
    //   70	84	226	finally
    //   107	134	226	finally
    //   157	184	226	finally
    //   57	68	230	java/lang/Exception
    //   70	84	230	java/lang/Exception
    //   57	68	234	java/io/FileNotFoundException
    //   70	84	234	java/io/FileNotFoundException
  }
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      if (paramOutputStream == null) {}
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        try
        {
          paramOutputStream.close();
          return;
        }
        catch (IOException paramInputStream)
        {
          com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + paramInputStream.toString());
        }
        paramInputStream = paramInputStream;
        com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + paramInputStream.toString());
      }
    }
  }
  
  /* Error */
  private boolean a(a parama, OutputStream paramOutputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: aconst_null
    //   4: astore 16
    //   6: iconst_0
    //   7: istore 7
    //   9: iconst_0
    //   10: istore 8
    //   12: iconst_0
    //   13: istore 6
    //   15: iconst_0
    //   16: istore 5
    //   18: iconst_0
    //   19: istore 9
    //   21: aload_0
    //   22: invokestatic 130	com/huawei/updatesdk/a/b/b/c:a	()Lcom/huawei/updatesdk/a/b/b/c;
    //   25: aload_1
    //   26: invokevirtual 59	com/huawei/updatesdk/a/b/b/a:c	()Ljava/lang/String;
    //   29: invokevirtual 133	com/huawei/updatesdk/a/b/b/c:a	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   32: putfield 135	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   35: aload_0
    //   36: getfield 135	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   39: astore 17
    //   41: aload 17
    //   43: ifnonnull +49 -> 92
    //   46: aload_0
    //   47: getfield 22	com/huawei/updatesdk/a/b/b/b:b	Z
    //   50: ifeq +32 -> 82
    //   53: aload_0
    //   54: iconst_0
    //   55: iconst_m1
    //   56: iconst_3
    //   57: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   60: aload_0
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokespecial 139	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   66: invokestatic 144	com/huawei/updatesdk/service/d/a/c:a	()Ljava/util/List;
    //   69: aload_0
    //   70: invokeinterface 150 2 0
    //   75: pop
    //   76: aload_0
    //   77: invokespecial 153	com/huawei/updatesdk/a/b/b/b:e	()V
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: iconst_0
    //   84: iconst_m1
    //   85: iconst_5
    //   86: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   89: goto -29 -> 60
    //   92: aload_0
    //   93: getfield 135	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   96: invokevirtual 158	java/net/HttpURLConnection:connect	()V
    //   99: aload_0
    //   100: getfield 135	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   103: invokevirtual 162	java/net/HttpURLConnection:getResponseCode	()I
    //   106: istore 4
    //   108: sipush 200
    //   111: iload 4
    //   113: if_icmpeq +57 -> 170
    //   116: sipush 206
    //   119: iload 4
    //   121: if_icmpeq +49 -> 170
    //   124: aload_0
    //   125: getfield 22	com/huawei/updatesdk/a/b/b/b:b	Z
    //   128: ifeq +32 -> 160
    //   131: aload_0
    //   132: iconst_0
    //   133: iconst_m1
    //   134: iconst_3
    //   135: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   138: aload_0
    //   139: aconst_null
    //   140: aconst_null
    //   141: invokespecial 139	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   144: invokestatic 144	com/huawei/updatesdk/service/d/a/c:a	()Ljava/util/List;
    //   147: aload_0
    //   148: invokeinterface 150 2 0
    //   153: pop
    //   154: aload_0
    //   155: invokespecial 153	com/huawei/updatesdk/a/b/b/b:e	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: aload_0
    //   161: iconst_0
    //   162: iconst_m1
    //   163: iconst_5
    //   164: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   167: goto -29 -> 138
    //   170: aload_1
    //   171: invokevirtual 164	com/huawei/updatesdk/a/b/b/a:b	()I
    //   174: istore 4
    //   176: new 166	java/io/BufferedInputStream
    //   179: dup
    //   180: aload_0
    //   181: getfield 135	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   184: invokevirtual 170	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   187: sipush 8192
    //   190: invokespecial 173	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   193: astore 15
    //   195: new 175	java/io/BufferedOutputStream
    //   198: dup
    //   199: aload_2
    //   200: sipush 8192
    //   203: invokespecial 178	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   206: astore 16
    //   208: lconst_0
    //   209: lstore 11
    //   211: iload 7
    //   213: istore 6
    //   215: sipush 8192
    //   218: newarray byte
    //   220: astore_2
    //   221: iload 5
    //   223: istore 6
    //   225: aload 15
    //   227: aload_2
    //   228: invokevirtual 182	java/io/BufferedInputStream:read	([B)I
    //   231: istore 7
    //   233: iload 7
    //   235: iconst_m1
    //   236: if_icmpeq +209 -> 445
    //   239: iload 5
    //   241: istore 6
    //   243: aload 16
    //   245: aload_2
    //   246: iconst_0
    //   247: iload 7
    //   249: invokevirtual 186	java/io/BufferedOutputStream:write	([BII)V
    //   252: iload 5
    //   254: iload 7
    //   256: iadd
    //   257: istore 7
    //   259: iload 7
    //   261: istore 5
    //   263: iload 7
    //   265: istore 6
    //   267: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   270: lload 11
    //   272: lsub
    //   273: invokestatic 198	java/lang/Math:abs	(J)J
    //   276: ldc2_w 199
    //   279: lcmp
    //   280: ifle -59 -> 221
    //   283: iload 7
    //   285: istore 6
    //   287: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   290: lstore 13
    //   292: iload 7
    //   294: istore 5
    //   296: lload 13
    //   298: lstore 11
    //   300: iload 7
    //   302: iload 4
    //   304: if_icmpeq -83 -> 221
    //   307: iload 7
    //   309: istore 6
    //   311: aload_0
    //   312: iload 7
    //   314: iload 4
    //   316: iconst_2
    //   317: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   320: iload 7
    //   322: istore 5
    //   324: lload 13
    //   326: lstore 11
    //   328: goto -107 -> 221
    //   331: astore_3
    //   332: aload 15
    //   334: astore_2
    //   335: aload 16
    //   337: astore_1
    //   338: iload 6
    //   340: istore 5
    //   342: aload_0
    //   343: aload_2
    //   344: aload_1
    //   345: invokespecial 139	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   348: aconst_null
    //   349: astore_2
    //   350: aconst_null
    //   351: astore 15
    //   353: aload_3
    //   354: athrow
    //   355: astore_3
    //   356: aconst_null
    //   357: astore_1
    //   358: iconst_0
    //   359: istore 9
    //   361: aconst_null
    //   362: astore_2
    //   363: iload 5
    //   365: istore 6
    //   367: iload 4
    //   369: istore 5
    //   371: iload 6
    //   373: istore 4
    //   375: ldc 102
    //   377: new 67	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   384: ldc 124
    //   386: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_3
    //   390: invokevirtual 115	java/lang/Exception:toString	()Ljava/lang/String;
    //   393: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 109	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: iload 9
    //   404: ifne +19 -> 423
    //   407: aload_0
    //   408: getfield 22	com/huawei/updatesdk/a/b/b/b:b	Z
    //   411: ifeq +166 -> 577
    //   414: aload_0
    //   415: iload 4
    //   417: iload 5
    //   419: iconst_3
    //   420: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   423: aload_0
    //   424: aload_2
    //   425: aload_1
    //   426: invokespecial 139	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   429: invokestatic 144	com/huawei/updatesdk/service/d/a/c:a	()Ljava/util/List;
    //   432: aload_0
    //   433: invokeinterface 150 2 0
    //   438: pop
    //   439: aload_0
    //   440: invokespecial 153	com/huawei/updatesdk/a/b/b/b:e	()V
    //   443: iconst_0
    //   444: ireturn
    //   445: aload_0
    //   446: aload 15
    //   448: aload 16
    //   450: invokespecial 139	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   453: aconst_null
    //   454: astore 15
    //   456: iload 5
    //   458: iload 4
    //   460: if_icmpne +99 -> 559
    //   463: iload 4
    //   465: ifle +94 -> 559
    //   468: aload_1
    //   469: invokevirtual 201	com/huawei/updatesdk/a/b/b/a:d	()Ljava/lang/String;
    //   472: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +84 -> 559
    //   478: aload_1
    //   479: invokevirtual 201	com/huawei/updatesdk/a/b/b/a:d	()Ljava/lang/String;
    //   482: aload_3
    //   483: ldc 203
    //   485: invokestatic 206	com/huawei/updatesdk/a/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   488: invokevirtual 212	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   491: istore 10
    //   493: iload 10
    //   495: ifeq +64 -> 559
    //   498: iconst_1
    //   499: istore 9
    //   501: iload 9
    //   503: ifeq +12 -> 515
    //   506: aload_0
    //   507: iload 5
    //   509: iload 4
    //   511: iconst_4
    //   512: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   515: iload 9
    //   517: ifne +19 -> 536
    //   520: aload_0
    //   521: getfield 22	com/huawei/updatesdk/a/b/b/b:b	Z
    //   524: ifeq +41 -> 565
    //   527: aload_0
    //   528: iload 5
    //   530: iload 4
    //   532: iconst_3
    //   533: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   536: aload_0
    //   537: aconst_null
    //   538: aconst_null
    //   539: invokespecial 139	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   542: invokestatic 144	com/huawei/updatesdk/service/d/a/c:a	()Ljava/util/List;
    //   545: aload_0
    //   546: invokeinterface 150 2 0
    //   551: pop
    //   552: aload_0
    //   553: invokespecial 153	com/huawei/updatesdk/a/b/b/b:e	()V
    //   556: iload 9
    //   558: ireturn
    //   559: iconst_0
    //   560: istore 9
    //   562: goto -61 -> 501
    //   565: aload_0
    //   566: iload 5
    //   568: iload 4
    //   570: iconst_5
    //   571: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   574: goto -38 -> 536
    //   577: aload_0
    //   578: iload 4
    //   580: iload 5
    //   582: iconst_5
    //   583: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   586: goto -163 -> 423
    //   589: astore_1
    //   590: iconst_m1
    //   591: istore 4
    //   593: aload 16
    //   595: astore_3
    //   596: aload 15
    //   598: astore_2
    //   599: iload 6
    //   601: istore 5
    //   603: iload 9
    //   605: ifne +19 -> 624
    //   608: aload_0
    //   609: getfield 22	com/huawei/updatesdk/a/b/b/b:b	Z
    //   612: ifeq +34 -> 646
    //   615: aload_0
    //   616: iload 5
    //   618: iload 4
    //   620: iconst_3
    //   621: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   624: aload_0
    //   625: aload_2
    //   626: aload_3
    //   627: invokespecial 139	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   630: invokestatic 144	com/huawei/updatesdk/service/d/a/c:a	()Ljava/util/List;
    //   633: aload_0
    //   634: invokeinterface 150 2 0
    //   639: pop
    //   640: aload_0
    //   641: invokespecial 153	com/huawei/updatesdk/a/b/b/b:e	()V
    //   644: aload_1
    //   645: athrow
    //   646: aload_0
    //   647: iload 5
    //   649: iload 4
    //   651: iconst_5
    //   652: invokespecial 137	com/huawei/updatesdk/a/b/b/b:a	(III)V
    //   655: goto -31 -> 624
    //   658: astore_1
    //   659: aload 16
    //   661: astore_3
    //   662: aload 15
    //   664: astore_2
    //   665: goto -62 -> 603
    //   668: astore 15
    //   670: aload_1
    //   671: astore_3
    //   672: aload 15
    //   674: astore_1
    //   675: goto -72 -> 603
    //   678: astore_1
    //   679: aload 15
    //   681: astore_3
    //   682: goto -79 -> 603
    //   685: astore_1
    //   686: aconst_null
    //   687: astore_2
    //   688: aload 15
    //   690: astore_3
    //   691: goto -88 -> 603
    //   694: astore_1
    //   695: aconst_null
    //   696: astore_2
    //   697: aload 15
    //   699: astore_3
    //   700: goto -97 -> 603
    //   703: astore 15
    //   705: iload 5
    //   707: istore 6
    //   709: aload_1
    //   710: astore_3
    //   711: aload 15
    //   713: astore_1
    //   714: iload 4
    //   716: istore 5
    //   718: iload 6
    //   720: istore 4
    //   722: goto -119 -> 603
    //   725: astore_3
    //   726: aconst_null
    //   727: astore_2
    //   728: iconst_0
    //   729: istore 4
    //   731: iconst_0
    //   732: istore 9
    //   734: iconst_m1
    //   735: istore 5
    //   737: aconst_null
    //   738: astore_1
    //   739: goto -364 -> 375
    //   742: astore_3
    //   743: iload 4
    //   745: istore 6
    //   747: iconst_0
    //   748: istore 9
    //   750: aload 15
    //   752: astore_2
    //   753: aload 16
    //   755: astore_1
    //   756: iload 5
    //   758: istore 4
    //   760: iload 6
    //   762: istore 5
    //   764: goto -389 -> 375
    //   767: astore_3
    //   768: iconst_0
    //   769: istore 9
    //   771: iload 4
    //   773: istore 6
    //   775: iload 5
    //   777: istore 4
    //   779: iload 6
    //   781: istore 5
    //   783: goto -408 -> 375
    //   786: astore_3
    //   787: iconst_0
    //   788: istore 9
    //   790: aconst_null
    //   791: astore_2
    //   792: aconst_null
    //   793: astore_1
    //   794: iload 4
    //   796: istore 6
    //   798: iload 5
    //   800: istore 4
    //   802: iload 6
    //   804: istore 5
    //   806: goto -431 -> 375
    //   809: astore_3
    //   810: aconst_null
    //   811: astore_2
    //   812: aconst_null
    //   813: astore_1
    //   814: iload 4
    //   816: istore 6
    //   818: iload 5
    //   820: istore 4
    //   822: iload 6
    //   824: istore 5
    //   826: goto -451 -> 375
    //   829: astore_3
    //   830: aconst_null
    //   831: astore_2
    //   832: aconst_null
    //   833: astore_1
    //   834: iload 8
    //   836: istore 5
    //   838: goto -496 -> 342
    //   841: astore_3
    //   842: aconst_null
    //   843: astore_1
    //   844: aload 15
    //   846: astore_2
    //   847: iload 8
    //   849: istore 5
    //   851: goto -509 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	854	0	this	b
    //   0	854	1	parama	a
    //   0	854	2	paramOutputStream	OutputStream
    //   0	854	3	paramString	String
    //   106	715	4	i	int
    //   16	834	5	j	int
    //   13	810	6	k	int
    //   7	314	7	m	int
    //   10	838	8	n	int
    //   19	770	9	bool1	boolean
    //   491	3	10	bool2	boolean
    //   209	118	11	l1	long
    //   290	35	13	l2	long
    //   1	662	15	localBufferedInputStream	java.io.BufferedInputStream
    //   668	30	15	localObject1	Object
    //   703	142	15	localObject2	Object
    //   4	750	16	localBufferedOutputStream	java.io.BufferedOutputStream
    //   39	3	17	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   215	221	331	finally
    //   225	233	331	finally
    //   243	252	331	finally
    //   267	283	331	finally
    //   287	292	331	finally
    //   311	320	331	finally
    //   353	355	355	java/lang/Exception
    //   21	41	589	finally
    //   92	108	589	finally
    //   170	176	589	finally
    //   445	453	658	finally
    //   342	348	668	finally
    //   353	355	678	finally
    //   468	493	685	finally
    //   506	515	694	finally
    //   375	402	703	finally
    //   21	41	725	java/lang/Exception
    //   92	108	725	java/lang/Exception
    //   170	176	725	java/lang/Exception
    //   445	453	742	java/lang/Exception
    //   342	348	767	java/lang/Exception
    //   468	493	786	java/lang/Exception
    //   506	515	809	java/lang/Exception
    //   176	195	829	finally
    //   195	208	841	finally
  }
  
  private static String d()
  {
    Object localObject = com.huawei.updatesdk.a.b.a.a.a().c();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "";
    }
    File localFile;
    do
    {
      String str;
      do
      {
        return localObject;
        str = (String)localObject + "/updatesdk";
        localFile = new File(str);
        localObject = str;
      } while (localFile.exists());
      localObject = str;
    } while (localFile.mkdirs());
    return "";
  }
  
  private void e()
  {
    if (this.a != null) {
      this.a.disconnect();
    }
  }
  
  protected Void a(Void... paramVarArgs)
  {
    com.huawei.updatesdk.service.d.a.c.a(this);
    a(this.c, d());
    return null;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.disconnect();
      this.b = true;
    }
    d.a(new File(d()));
  }
  
  public void b()
  {
    this.d = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  static class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!(paramMessage.obj instanceof a)) {
        return;
      }
      Object localObject = (a)paramMessage.obj;
      Intent localIntent = new Intent();
      com.huawei.updatesdk.a.b.c.b localb = com.huawei.updatesdk.a.b.c.b.a(localIntent);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 2: 
        localIntent.putExtra("download_apk_size", ((a)localObject).b());
        localIntent.putExtra("download_apk_already", ((a)localObject).a());
        com.huawei.updatesdk.service.b.c.a().b(localb);
        return;
      case 4: 
        g.a(b.c() + "/appmarket.apk", "com.huawei.appmarket");
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("download_status_param", paramMessage.what);
      localIntent.putExtras((Bundle)localObject);
      com.huawei.updatesdk.service.b.c.a().a(localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */