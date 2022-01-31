package tmsdk.common.d.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.d.a.b.e;
import tmsdk.common.e.k;

public class b
{
  private static String a = "HttpNetwork";
  private final int b = 5;
  private final int c = 3;
  private String d = "POST";
  private boolean e = false;
  private HttpURLConnection f;
  private d g;
  private String h;
  private int i = 0;
  private e j;
  private volatile String k = null;
  
  public b(Context paramContext, boolean paramBoolean, e parame)
  {
    this.j = parame;
    this.g = new d(paramContext, paramBoolean, parame);
  }
  
  private void a(int paramInt)
  {
    if ((-70000 == paramInt) || (-130000 == paramInt) || (-170000 == paramInt)) {
      this.g.d();
    }
  }
  
  private byte[] a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[2048];
    localBufferedInputStream = new BufferedInputStream(paramInputStream);
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      for (;;)
      {
        int m = paramInputStream.read(arrayOfByte);
        if (m == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, m);
      }
      try
      {
        localBufferedInputStream.close();
        localByteArrayOutputStream.close();
        throw paramInputStream;
        paramInputStream = localByteArrayOutputStream.toByteArray();
        try
        {
          localBufferedInputStream.close();
          localByteArrayOutputStream.close();
          return paramInputStream;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return paramInputStream;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
    catch (IOException paramInputStream)
    {
      paramInputStream = paramInputStream;
      throw new tmsdk.common.b.a(-56, "get Bytes from inputStream when read buffer: " + paramInputStream.getMessage());
    }
    finally {}
  }
  
  /* Error */
  private int b(byte[] paramArrayOfByte, AtomicReference paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   4: ifnonnull +7 -> 11
    //   7: sipush -10000
    //   10: ireturn
    //   11: ldc 134
    //   13: aload_0
    //   14: getfield 40	tmsdk/common/d/a/a/b:d	Ljava/lang/String;
    //   17: invokevirtual 140	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   20: ifeq +207 -> 227
    //   23: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   26: lstore_3
    //   27: aload_0
    //   28: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   31: invokevirtual 152	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   34: astore 5
    //   36: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   39: lload_3
    //   40: lsub
    //   41: lstore_3
    //   42: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   45: astore 6
    //   47: new 87	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   54: ldc 154
    //   56: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload_3
    //   60: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: pop
    //   67: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   70: astore 6
    //   72: new 87	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   79: ldc 154
    //   81: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: lload_3
    //   85: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: pop
    //   92: aload_0
    //   93: getfield 48	tmsdk/common/d/a/a/b:j	Ltmsdk/common/d/a/b/e;
    //   96: astore 6
    //   98: aload 5
    //   100: aload_1
    //   101: invokevirtual 162	java/io/OutputStream:write	([B)V
    //   104: aload 5
    //   106: invokevirtual 165	java/io/OutputStream:flush	()V
    //   109: aload 5
    //   111: invokevirtual 166	java/io/OutputStream:close	()V
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   119: invokevirtual 170	java/net/HttpURLConnection:getResponseCode	()I
    //   122: invokespecial 173	tmsdk/common/d/a/a/b:b	(I)Z
    //   125: ifeq +134 -> 259
    //   128: aload_0
    //   129: aload_0
    //   130: invokespecial 175	tmsdk/common/d/a/a/b:i	()Ljava/lang/String;
    //   133: putfield 177	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 44	tmsdk/common/d/a/a/b:i	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 44	tmsdk/common/d/a/a/b:i	I
    //   146: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   149: astore_1
    //   150: new 87	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   157: ldc 179
    //   159: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 177	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   166: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc 181
    //   171: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: getfield 44	tmsdk/common/d/a/a/b:i	I
    //   178: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: pop
    //   185: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   188: astore_1
    //   189: new 87	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   196: ldc 179
    //   198: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 177	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   205: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 181
    //   210: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 44	tmsdk/common/d/a/a/b:i	I
    //   217: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: pop
    //   224: ldc 185
    //   226: ireturn
    //   227: aload_0
    //   228: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   231: ldc 187
    //   233: new 87	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   240: ldc 189
    //   242: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_1
    //   246: arraylength
    //   247: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: goto -233 -> 23
    //   259: aload_0
    //   260: invokespecial 195	tmsdk/common/d/a/a/b:h	()V
    //   263: aload_0
    //   264: invokespecial 197	tmsdk/common/d/a/a/b:e	()V
    //   267: aload_0
    //   268: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   271: invokevirtual 201	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   274: astore_1
    //   275: aload_1
    //   276: ifnull +58 -> 334
    //   279: aload_1
    //   280: invokevirtual 202	java/lang/Object:toString	()Ljava/lang/String;
    //   283: astore_1
    //   284: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   287: astore 5
    //   289: new 87	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   296: ldc 204
    //   298: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_1
    //   302: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: pop
    //   309: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   312: astore 5
    //   314: new 87	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   321: ldc 204
    //   323: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: pop
    //   334: aload_0
    //   335: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   338: ldc 206
    //   340: invokevirtual 210	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   343: astore_1
    //   344: aload_1
    //   345: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifeq +14 -> 362
    //   351: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   354: astore_1
    //   355: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   358: astore_1
    //   359: ldc 58
    //   361: ireturn
    //   362: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   365: astore 5
    //   367: new 87	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   374: ldc 218
    //   376: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_1
    //   380: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: pop
    //   387: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   390: astore 5
    //   392: new 87	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   399: ldc 218
    //   401: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_1
    //   405: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: pop
    //   412: aload_1
    //   413: ldc 220
    //   415: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   418: ifne +14 -> 432
    //   421: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   424: astore_1
    //   425: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   428: astore_1
    //   429: ldc 58
    //   431: ireturn
    //   432: aload_2
    //   433: aload_0
    //   434: aload_0
    //   435: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   438: invokevirtual 228	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   441: invokespecial 230	tmsdk/common/d/a/a/b:a	(Ljava/io/InputStream;)[B
    //   444: invokevirtual 236	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   447: iconst_0
    //   448: ireturn
    //   449: astore_1
    //   450: aload_1
    //   451: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   454: ldc 237
    //   456: ireturn
    //   457: astore_1
    //   458: aload_1
    //   459: invokevirtual 238	java/net/UnknownHostException:printStackTrace	()V
    //   462: ldc 56
    //   464: ireturn
    //   465: astore_1
    //   466: aload_1
    //   467: invokevirtual 239	java/lang/IllegalAccessError:printStackTrace	()V
    //   470: ldc 240
    //   472: ireturn
    //   473: astore_1
    //   474: aload_1
    //   475: invokevirtual 241	java/lang/IllegalStateException:printStackTrace	()V
    //   478: ldc 242
    //   480: ireturn
    //   481: astore_1
    //   482: aload_1
    //   483: invokevirtual 243	java/net/ProtocolException:printStackTrace	()V
    //   486: ldc 244
    //   488: ireturn
    //   489: astore_1
    //   490: aload_1
    //   491: invokevirtual 245	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   494: ldc 246
    //   496: ireturn
    //   497: astore_1
    //   498: aload_0
    //   499: invokespecial 249	tmsdk/common/d/a/a/b:d	()Z
    //   502: ifeq +6 -> 508
    //   505: ldc 250
    //   507: ireturn
    //   508: aload_1
    //   509: invokevirtual 251	java/net/SocketException:printStackTrace	()V
    //   512: ldc 252
    //   514: ireturn
    //   515: astore_1
    //   516: aload_1
    //   517: invokevirtual 253	java/net/SocketTimeoutException:printStackTrace	()V
    //   520: ldc 57
    //   522: ireturn
    //   523: astore_1
    //   524: aload_1
    //   525: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   528: ldc 255
    //   530: ireturn
    //   531: astore_1
    //   532: aload_1
    //   533: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   536: ldc_w 256
    //   539: ireturn
    //   540: astore_1
    //   541: aload_1
    //   542: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	543	0	this	b
    //   0	543	1	paramArrayOfByte	byte[]
    //   0	543	2	paramAtomicReference	AtomicReference
    //   26	59	3	l	long
    //   34	357	5	localObject1	Object
    //   45	52	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   267	275	449	java/lang/Exception
    //   279	334	449	java/lang/Exception
    //   334	359	449	java/lang/Exception
    //   362	429	449	java/lang/Exception
    //   432	447	449	java/lang/Exception
    //   23	224	457	java/net/UnknownHostException
    //   259	267	457	java/net/UnknownHostException
    //   267	275	457	java/net/UnknownHostException
    //   279	334	457	java/net/UnknownHostException
    //   334	359	457	java/net/UnknownHostException
    //   362	429	457	java/net/UnknownHostException
    //   432	447	457	java/net/UnknownHostException
    //   450	454	457	java/net/UnknownHostException
    //   23	224	465	java/lang/IllegalAccessError
    //   259	267	465	java/lang/IllegalAccessError
    //   267	275	465	java/lang/IllegalAccessError
    //   279	334	465	java/lang/IllegalAccessError
    //   334	359	465	java/lang/IllegalAccessError
    //   362	429	465	java/lang/IllegalAccessError
    //   432	447	465	java/lang/IllegalAccessError
    //   450	454	465	java/lang/IllegalAccessError
    //   23	224	473	java/lang/IllegalStateException
    //   259	267	473	java/lang/IllegalStateException
    //   267	275	473	java/lang/IllegalStateException
    //   279	334	473	java/lang/IllegalStateException
    //   334	359	473	java/lang/IllegalStateException
    //   362	429	473	java/lang/IllegalStateException
    //   432	447	473	java/lang/IllegalStateException
    //   450	454	473	java/lang/IllegalStateException
    //   23	224	481	java/net/ProtocolException
    //   259	267	481	java/net/ProtocolException
    //   267	275	481	java/net/ProtocolException
    //   279	334	481	java/net/ProtocolException
    //   334	359	481	java/net/ProtocolException
    //   362	429	481	java/net/ProtocolException
    //   432	447	481	java/net/ProtocolException
    //   450	454	481	java/net/ProtocolException
    //   23	224	489	org/apache/http/client/ClientProtocolException
    //   259	267	489	org/apache/http/client/ClientProtocolException
    //   267	275	489	org/apache/http/client/ClientProtocolException
    //   279	334	489	org/apache/http/client/ClientProtocolException
    //   334	359	489	org/apache/http/client/ClientProtocolException
    //   362	429	489	org/apache/http/client/ClientProtocolException
    //   432	447	489	org/apache/http/client/ClientProtocolException
    //   450	454	489	org/apache/http/client/ClientProtocolException
    //   23	224	497	java/net/SocketException
    //   259	267	497	java/net/SocketException
    //   267	275	497	java/net/SocketException
    //   279	334	497	java/net/SocketException
    //   334	359	497	java/net/SocketException
    //   362	429	497	java/net/SocketException
    //   432	447	497	java/net/SocketException
    //   450	454	497	java/net/SocketException
    //   23	224	515	java/net/SocketTimeoutException
    //   259	267	515	java/net/SocketTimeoutException
    //   267	275	515	java/net/SocketTimeoutException
    //   279	334	515	java/net/SocketTimeoutException
    //   334	359	515	java/net/SocketTimeoutException
    //   362	429	515	java/net/SocketTimeoutException
    //   432	447	515	java/net/SocketTimeoutException
    //   450	454	515	java/net/SocketTimeoutException
    //   23	224	523	java/io/IOException
    //   259	267	523	java/io/IOException
    //   267	275	523	java/io/IOException
    //   279	334	523	java/io/IOException
    //   334	359	523	java/io/IOException
    //   362	429	523	java/io/IOException
    //   432	447	523	java/io/IOException
    //   450	454	523	java/io/IOException
    //   23	224	531	java/lang/Exception
    //   259	267	531	java/lang/Exception
    //   450	454	531	java/lang/Exception
    //   23	224	540	finally
    //   259	267	540	finally
    //   267	275	540	finally
    //   279	334	540	finally
    //   334	359	540	finally
    //   362	429	540	finally
    //   432	447	540	finally
    //   450	454	540	finally
    //   458	462	540	finally
    //   466	470	540	finally
    //   474	478	540	finally
    //   482	486	540	finally
    //   490	494	540	finally
    //   498	505	540	finally
    //   508	512	540	finally
    //   516	520	540	finally
    //   524	528	540	finally
    //   532	536	540	finally
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt >= 301) && (paramInt <= 305);
  }
  
  private boolean d()
  {
    localObject = tmsdk.common.e.f.a();
    if (b.a.c == localObject) {}
    for (int m = 1; m == 0; m = 0) {
      return false;
    }
    localObject = null;
    try
    {
      String str1 = k.a(new c(this));
      localObject = str1;
    }
    catch (tmsdk.common.b.b localb)
    {
      for (;;)
      {
        String str2 = a;
        new StringBuilder().append("checkWifiApprovement() WifiApproveException e: ").append(localb.toString()).toString();
        str2 = a;
        new StringBuilder().append("checkWifiApprovement() WifiApproveException e: ").append(localb.toString()).toString();
      }
      this.k = ((String)localObject);
      localObject = a;
      new StringBuilder().append("checkWifiApprovement() mWifiApprovementUrl: ").append(this.k).toString();
      localObject = a;
      new StringBuilder().append("checkWifiApprovement() mWifiApprovementUrl: ").append(this.k).toString();
    }
    return !TextUtils.isEmpty((CharSequence)localObject);
  }
  
  private void e()
  {
    this.k = null;
  }
  
  private boolean f()
  {
    return this.e;
  }
  
  private void g()
  {
    if (this.i >= 3) {
      h();
    }
  }
  
  private void h()
  {
    this.h = null;
    this.i = 0;
  }
  
  private String i()
  {
    String str1 = a;
    str1 = a;
    try
    {
      str1 = this.f.getHeaderField("Location");
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a;
      new StringBuilder().append("getRedirectUrl() e: ").append(localException.toString()).toString();
      str2 = a;
      new StringBuilder().append("getRedirectUrl() e: ").append(localException.toString()).toString();
    }
    return null;
  }
  
  public int a(byte[] paramArrayOfByte, AtomicReference paramAtomicReference)
  {
    int m;
    if (paramArrayOfByte == null)
    {
      m = -10;
      return m;
    }
    for (;;)
    {
      int n;
      try
      {
        if (tmsdk.common.c.a.f.a())
        {
          m = -7;
          break;
        }
        localObject = a;
        new StringBuilder().append("sendData() data.length: ").append(paramArrayOfByte.length).toString();
        localObject = a;
        new StringBuilder().append("sendData() data.length: ").append(paramArrayOfByte.length).toString();
        n = 0;
        m = -1;
        if (n >= 5) {
          break label387;
        }
        boolean bool = f();
        localObject = a;
        new StringBuilder().append("sendData() hasStart: ").append(bool).toString();
        localObject = a;
        new StringBuilder().append("sendData() hasStart: ").append(bool).toString();
        localObject = new AtomicReference();
        if ((!bool) && (!a((AtomicReference)localObject))) {
          break label390;
        }
        m = b(paramArrayOfByte, paramAtomicReference);
        if (m == 0)
        {
          paramArrayOfByte = a;
          paramArrayOfByte = a;
          b();
          this.g.a((String)((AtomicReference)localObject).get());
          break;
        }
      }
      finally {}
      if (-160000 == m)
      {
        paramArrayOfByte = a;
        paramArrayOfByte = a;
        b();
        break;
      }
      Object localObject = a;
      new StringBuilder().append("sendData() ret: ").append(m).toString();
      localObject = a;
      new StringBuilder().append("sendData() ret: ").append(m).toString();
      b();
      a(m);
      if (4 != n)
      {
        try
        {
          Thread.sleep(3000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          String str = a;
          new StringBuilder().append("sendData() InterruptedException e: ").append(localInterruptedException.toString()).toString();
          str = a;
          new StringBuilder().append("sendData() InterruptedException e: ").append(localInterruptedException.toString()).toString();
        }
      }
      else
      {
        break label390;
        label387:
        break;
      }
      label390:
      n += 1;
    }
  }
  
  public d a()
  {
    return this.g;
  }
  
  /* Error */
  public boolean a(AtomicReference paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   5: astore 5
    //   7: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   10: astore 5
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 42	tmsdk/common/d/a/a/b:e	Z
    //   17: aload_0
    //   18: invokespecial 344	tmsdk/common/d/a/a/b:g	()V
    //   21: aload_0
    //   22: getfield 177	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   25: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +129 -> 157
    //   31: aload_0
    //   32: getfield 54	tmsdk/common/d/a/a/b:g	Ltmsdk/common/d/a/a/d;
    //   35: invokevirtual 346	tmsdk/common/d/a/a/d:c	()Ljava/lang/String;
    //   38: astore 6
    //   40: aload 6
    //   42: astore 5
    //   44: aload_1
    //   45: ifnull +13 -> 58
    //   48: aload_1
    //   49: aload 6
    //   51: invokevirtual 236	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   54: aload 6
    //   56: astore 5
    //   58: invokestatic 263	tmsdk/common/e/f:a	()Lb/a;
    //   61: astore_1
    //   62: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   65: astore 6
    //   67: new 87	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 348
    //   77: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload 5
    //   82: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 350
    //   88: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: pop
    //   99: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   102: astore 6
    //   104: new 87	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 348
    //   114: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 5
    //   119: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 350
    //   125: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: pop
    //   136: getstatic 355	b/a:a	Lb/a;
    //   139: aload_1
    //   140: if_acmpne +26 -> 166
    //   143: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   146: astore_1
    //   147: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   150: astore_1
    //   151: iconst_0
    //   152: istore_2
    //   153: aload_0
    //   154: monitorexit
    //   155: iload_2
    //   156: ireturn
    //   157: aload_0
    //   158: getfield 177	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   161: astore 5
    //   163: goto -105 -> 58
    //   166: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   169: lstore_3
    //   170: new 357	java/net/URL
    //   173: dup
    //   174: aload 5
    //   176: invokespecial 359	java/net/URL:<init>	(Ljava/lang/String;)V
    //   179: astore 5
    //   181: getstatic 361	b/a:d	Lb/a;
    //   184: aload_1
    //   185: if_acmpne +244 -> 429
    //   188: aload_0
    //   189: aload 5
    //   191: new 363	java/net/Proxy
    //   194: dup
    //   195: getstatic 369	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   198: invokestatic 370	tmsdk/common/e/f:c	()Ljava/lang/String;
    //   201: invokestatic 372	tmsdk/common/e/f:d	()I
    //   204: invokestatic 378	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   207: invokespecial 381	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   210: invokevirtual 385	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   213: checkcast 148	java/net/HttpURLConnection
    //   216: putfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   219: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   222: lload_3
    //   223: lsub
    //   224: lstore_3
    //   225: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   228: astore_1
    //   229: new 87	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 387
    //   239: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: lload_3
    //   243: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   246: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: pop
    //   250: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   253: astore_1
    //   254: new 87	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 387
    //   264: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: lload_3
    //   268: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   271: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: pop
    //   275: invokestatic 391	tmsdk/common/e/i:a	()I
    //   278: bipush 8
    //   280: if_icmpge +13 -> 293
    //   283: ldc_w 393
    //   286: ldc_w 395
    //   289: invokestatic 399	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   292: pop
    //   293: aload_0
    //   294: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   297: iconst_0
    //   298: invokevirtual 403	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   301: aload_0
    //   302: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   305: ldc_w 405
    //   308: ldc_w 407
    //   311: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_0
    //   315: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   318: ldc_w 409
    //   321: ldc_w 407
    //   324: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload_0
    //   328: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   331: iconst_0
    //   332: invokevirtual 412	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   335: ldc 134
    //   337: aload_0
    //   338: getfield 40	tmsdk/common/d/a/a/b:d	Ljava/lang/String;
    //   341: invokevirtual 140	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   344: ifeq +130 -> 474
    //   347: aload_0
    //   348: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   351: ldc 134
    //   353: invokevirtual 415	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   356: iconst_1
    //   357: istore_2
    //   358: goto -205 -> 153
    //   361: astore_1
    //   362: aload_1
    //   363: invokevirtual 416	java/net/MalformedURLException:printStackTrace	()V
    //   366: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   369: astore 5
    //   371: new 87	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 418
    //   381: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: invokevirtual 419	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   388: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: pop
    //   395: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   398: astore 5
    //   400: new 87	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 418
    //   410: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_1
    //   414: invokevirtual 419	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   417: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: pop
    //   424: iconst_0
    //   425: istore_2
    //   426: goto -273 -> 153
    //   429: aload_0
    //   430: aload 5
    //   432: invokevirtual 422	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   435: checkcast 148	java/net/HttpURLConnection
    //   438: putfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   441: aload_0
    //   442: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   445: sipush 30000
    //   448: invokevirtual 425	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   451: aload_0
    //   452: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   455: sipush 30000
    //   458: invokevirtual 428	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   461: goto -242 -> 219
    //   464: astore_1
    //   465: aload_1
    //   466: invokevirtual 238	java/net/UnknownHostException:printStackTrace	()V
    //   469: iconst_0
    //   470: istore_2
    //   471: goto -318 -> 153
    //   474: aload_0
    //   475: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   478: ldc 38
    //   480: invokevirtual 415	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   483: aload_0
    //   484: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   487: iconst_1
    //   488: invokevirtual 431	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   491: aload_0
    //   492: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   495: iconst_1
    //   496: invokevirtual 434	java/net/HttpURLConnection:setDoInput	(Z)V
    //   499: aload_0
    //   500: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   503: ldc_w 436
    //   506: ldc_w 438
    //   509: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_0
    //   513: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   516: ldc_w 440
    //   519: ldc_w 442
    //   522: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_0
    //   526: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   529: ldc_w 444
    //   532: ldc_w 446
    //   535: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: goto -182 -> 356
    //   541: astore_1
    //   542: aload_1
    //   543: invokevirtual 447	java/lang/IllegalArgumentException:printStackTrace	()V
    //   546: iconst_0
    //   547: istore_2
    //   548: goto -395 -> 153
    //   551: astore_1
    //   552: aload_1
    //   553: invokevirtual 448	java/lang/SecurityException:printStackTrace	()V
    //   556: iconst_0
    //   557: istore_2
    //   558: goto -405 -> 153
    //   561: astore_1
    //   562: aload_1
    //   563: invokevirtual 449	java/lang/UnsupportedOperationException:printStackTrace	()V
    //   566: iconst_0
    //   567: istore_2
    //   568: goto -415 -> 153
    //   571: astore_1
    //   572: aload_1
    //   573: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   576: iconst_0
    //   577: istore_2
    //   578: goto -425 -> 153
    //   581: astore_1
    //   582: aload_0
    //   583: monitorexit
    //   584: aload_1
    //   585: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	b
    //   0	586	1	paramAtomicReference	AtomicReference
    //   152	426	2	bool	boolean
    //   169	99	3	l	long
    //   5	426	5	localObject	Object
    //   38	65	6	str	String
    // Exception table:
    //   from	to	target	type
    //   170	181	361	java/net/MalformedURLException
    //   181	219	464	java/net/UnknownHostException
    //   219	293	464	java/net/UnknownHostException
    //   293	356	464	java/net/UnknownHostException
    //   429	461	464	java/net/UnknownHostException
    //   474	538	464	java/net/UnknownHostException
    //   181	219	541	java/lang/IllegalArgumentException
    //   219	293	541	java/lang/IllegalArgumentException
    //   293	356	541	java/lang/IllegalArgumentException
    //   429	461	541	java/lang/IllegalArgumentException
    //   474	538	541	java/lang/IllegalArgumentException
    //   181	219	551	java/lang/SecurityException
    //   219	293	551	java/lang/SecurityException
    //   293	356	551	java/lang/SecurityException
    //   429	461	551	java/lang/SecurityException
    //   474	538	551	java/lang/SecurityException
    //   181	219	561	java/lang/UnsupportedOperationException
    //   219	293	561	java/lang/UnsupportedOperationException
    //   293	356	561	java/lang/UnsupportedOperationException
    //   429	461	561	java/lang/UnsupportedOperationException
    //   474	538	561	java/lang/UnsupportedOperationException
    //   181	219	571	java/io/IOException
    //   219	293	571	java/io/IOException
    //   293	356	571	java/io/IOException
    //   429	461	571	java/io/IOException
    //   474	538	571	java/io/IOException
    //   2	40	581	finally
    //   48	54	581	finally
    //   58	151	581	finally
    //   157	163	581	finally
    //   166	170	581	finally
    //   170	181	581	finally
    //   181	219	581	finally
    //   219	293	581	finally
    //   293	356	581	finally
    //   362	424	581	finally
    //   429	461	581	finally
    //   465	469	581	finally
    //   474	538	581	finally
    //   542	546	581	finally
    //   552	556	581	finally
    //   562	566	581	finally
    //   572	576	581	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 27	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   7: astore_2
    //   8: aload_0
    //   9: iconst_0
    //   10: putfield 42	tmsdk/common/d/a/a/b:e	Z
    //   13: aload_0
    //   14: iconst_0
    //   15: putfield 42	tmsdk/common/d/a/a/b:e	Z
    //   18: aload_0
    //   19: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +7 -> 31
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: aload_0
    //   32: getfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   35: invokevirtual 452	java/net/HttpURLConnection:disconnect	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 132	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   43: iconst_1
    //   44: istore_1
    //   45: goto -18 -> 27
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	b
    //   1	44	1	bool	boolean
    //   7	17	2	localObject1	Object
    //   48	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	23	48	finally
    //   31	43	48	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */