import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;

class artq
  implements arxk
{
  artq(artp paramartp, artp.a parama, String paramString) {}
  
  public void bp(String paramString1, String arg2, String paramString3)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString3);
      arwt.d("ImageLoader", "-->imgDownloaded path = " + ??? + " localUrl = " + paramString3);
      localBitmap = artw.a(aroi.a().getContext(), localBitmap, 50, 50);
      synchronized (artp.hm)
      {
        this.b.mLruCache.put(paramString1, localBitmap);
        this.a.a(this.val$url, localBitmap, paramString3);
        return;
      }
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  /* Error */
  public void bq(String paramString1, String arg2, String paramString3)
  {
    // Byte code:
    //   0: ldc 36
    //   2: new 38	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   9: ldc 102
    //   11: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 47
    //   20: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_3
    //   24: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 57	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: invokestatic 108	arug:cC	()Z
    //   36: ifne +157 -> 193
    //   39: new 110	java/net/URL
    //   42: dup
    //   43: aload_0
    //   44: getfield 20	artq:val$url	Ljava/lang/String;
    //   47: invokespecial 113	java/net/URL:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 117	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   53: checkcast 119	java/net/HttpURLConnection
    //   56: astore_2
    //   57: aload_2
    //   58: sipush 5000
    //   61: invokevirtual 123	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   64: aload_2
    //   65: ldc 125
    //   67: invokevirtual 128	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   70: aload_2
    //   71: invokevirtual 132	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   74: astore 4
    //   76: aload 4
    //   78: astore_2
    //   79: aload 4
    //   81: invokestatic 136	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   84: astore 5
    //   86: aload 4
    //   88: ifnull +8 -> 96
    //   91: aload 4
    //   93: invokevirtual 141	java/io/InputStream:close	()V
    //   96: aload 5
    //   98: astore_2
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 143	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 144	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: ldc 36
    //   113: new 38	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   120: ldc 146
    //   122: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 57	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_2
    //   136: ifnull +57 -> 193
    //   139: invokestatic 62	aroi:a	()Laroi;
    //   142: invokevirtual 66	aroi:getContext	()Landroid/content/Context;
    //   145: aload_2
    //   146: bipush 50
    //   148: bipush 50
    //   150: invokestatic 71	artw:a	(Landroid/content/Context;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   153: astore 4
    //   155: getstatic 77	artp:hm	[B
    //   158: astore_2
    //   159: aload_2
    //   160: monitorenter
    //   161: aload_0
    //   162: getfield 16	artq:b	Lartp;
    //   165: getfield 81	artp:mLruCache	Landroid/support/v4/util/LruCache;
    //   168: aload_1
    //   169: aload 4
    //   171: invokevirtual 87	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload_2
    //   176: monitorexit
    //   177: aload_0
    //   178: getfield 18	artq:a	Lartp$a;
    //   181: aload_0
    //   182: getfield 20	artq:val$url	Ljava/lang/String;
    //   185: aload 4
    //   187: aload_3
    //   188: invokeinterface 92 4 0
    //   193: return
    //   194: astore_2
    //   195: aload_2
    //   196: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   199: goto -103 -> 96
    //   202: astore_2
    //   203: aload_2
    //   204: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   207: aload 5
    //   209: astore_2
    //   210: goto -99 -> 111
    //   213: astore 5
    //   215: aconst_null
    //   216: astore 4
    //   218: aload 4
    //   220: astore_2
    //   221: aload 5
    //   223: invokevirtual 151	java/net/MalformedURLException:printStackTrace	()V
    //   226: aload 4
    //   228: ifnull +8 -> 236
    //   231: aload 4
    //   233: invokevirtual 141	java/io/InputStream:close	()V
    //   236: iconst_0
    //   237: ifeq +142 -> 379
    //   240: new 143	java/lang/NullPointerException
    //   243: dup
    //   244: invokespecial 144	java/lang/NullPointerException:<init>	()V
    //   247: athrow
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   253: goto -17 -> 236
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   261: aconst_null
    //   262: astore_2
    //   263: goto -152 -> 111
    //   266: astore 5
    //   268: aconst_null
    //   269: astore 4
    //   271: aload 4
    //   273: astore_2
    //   274: aload 5
    //   276: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   279: aload 4
    //   281: ifnull +8 -> 289
    //   284: aload 4
    //   286: invokevirtual 141	java/io/InputStream:close	()V
    //   289: iconst_0
    //   290: ifeq +89 -> 379
    //   293: new 143	java/lang/NullPointerException
    //   296: dup
    //   297: invokespecial 144	java/lang/NullPointerException:<init>	()V
    //   300: athrow
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   306: goto -17 -> 289
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   314: aconst_null
    //   315: astore_2
    //   316: goto -205 -> 111
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_2
    //   322: aload_2
    //   323: ifnull +7 -> 330
    //   326: aload_2
    //   327: invokevirtual 141	java/io/InputStream:close	()V
    //   330: iconst_0
    //   331: ifeq +11 -> 342
    //   334: new 143	java/lang/NullPointerException
    //   337: dup
    //   338: invokespecial 144	java/lang/NullPointerException:<init>	()V
    //   341: athrow
    //   342: aload_1
    //   343: athrow
    //   344: astore_2
    //   345: aload_2
    //   346: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   349: goto -19 -> 330
    //   352: astore_2
    //   353: aload_2
    //   354: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   357: goto -15 -> 342
    //   360: astore_1
    //   361: aload_2
    //   362: monitorexit
    //   363: aload_1
    //   364: athrow
    //   365: astore_1
    //   366: goto -44 -> 322
    //   369: astore 5
    //   371: goto -100 -> 271
    //   374: astore 5
    //   376: goto -158 -> 218
    //   379: aconst_null
    //   380: astore_2
    //   381: goto -270 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	artq
    //   0	384	1	paramString1	String
    //   0	384	3	paramString3	String
    //   74	211	4	localObject	Object
    //   84	124	5	localBitmap	Bitmap
    //   213	9	5	localMalformedURLException1	java.net.MalformedURLException
    //   266	9	5	localIOException1	java.io.IOException
    //   369	1	5	localIOException2	java.io.IOException
    //   374	1	5	localMalformedURLException2	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   91	96	194	java/io/IOException
    //   103	111	202	java/io/IOException
    //   39	76	213	java/net/MalformedURLException
    //   231	236	248	java/io/IOException
    //   240	248	256	java/io/IOException
    //   39	76	266	java/io/IOException
    //   284	289	301	java/io/IOException
    //   293	301	309	java/io/IOException
    //   39	76	319	finally
    //   326	330	344	java/io/IOException
    //   334	342	352	java/io/IOException
    //   161	177	360	finally
    //   361	363	360	finally
    //   79	86	365	finally
    //   221	226	365	finally
    //   274	279	365	finally
    //   79	86	369	java/io/IOException
    //   79	86	374	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artq
 * JD-Core Version:    0.7.0.1
 */