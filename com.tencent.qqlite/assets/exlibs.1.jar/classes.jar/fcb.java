import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageDownCallback;

public class fcb
  implements ImageDownCallback
{
  public fcb(ImageLoader paramImageLoader, ImageLoader.ImageLoadListener paramImageLoadListener, String paramString) {}
  
  public void a(String paramString1, String arg2, String paramString3)
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString3);
    LogUtility.c("ImageLoader", "-->imgDownloaded path = " + ??? + " localUrl = " + paramString3);
    paramString3 = AuthorityUtil.a(CommonDataAdapter.a().a(), localBitmap, 50, 50);
    synchronized (ImageLoader.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramString3);
      this.jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader$ImageLoadListener.a(this.jdField_a_of_type_JavaLangString, paramString3);
      return;
    }
  }
  
  /* Error */
  public void b(String paramString1, String arg2, String paramString3)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 33	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   9: ldc 91
    //   11: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 42
    //   20: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_3
    //   24: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 52	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: invokestatic 96	com/tencent/open/appcommon/Common:a	()Z
    //   36: ifne +148 -> 184
    //   39: new 98	java/net/URL
    //   42: dup
    //   43: aload_0
    //   44: getfield 18	fcb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   47: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   53: checkcast 107	java/net/HttpURLConnection
    //   56: astore_2
    //   57: aload_2
    //   58: sipush 5000
    //   61: invokevirtual 111	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   64: aload_2
    //   65: ldc 113
    //   67: invokevirtual 116	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   70: aload_2
    //   71: invokevirtual 120	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   74: astore_3
    //   75: aload_3
    //   76: astore_2
    //   77: aload_3
    //   78: invokestatic 124	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   81: astore 4
    //   83: aload_3
    //   84: ifnull +7 -> 91
    //   87: aload_3
    //   88: invokevirtual 129	java/io/InputStream:close	()V
    //   91: aload 4
    //   93: astore_2
    //   94: iconst_0
    //   95: ifeq +11 -> 106
    //   98: new 131	java/lang/NullPointerException
    //   101: dup
    //   102: invokespecial 132	java/lang/NullPointerException:<init>	()V
    //   105: athrow
    //   106: ldc 31
    //   108: new 33	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   115: ldc 134
    //   117: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_2
    //   121: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 52	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_2
    //   131: ifnull +53 -> 184
    //   134: invokestatic 57	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   137: invokevirtual 60	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   140: aload_2
    //   141: bipush 50
    //   143: bipush 50
    //   145: invokestatic 65	com/tencent/open/agent/util/AuthorityUtil:a	(Landroid/content/Context;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   148: astore_3
    //   149: getstatic 70	com/tencent/open/agent/datamodel/ImageLoader:jdField_a_of_type_ArrayOfByte	[B
    //   152: astore_2
    //   153: aload_2
    //   154: monitorenter
    //   155: aload_0
    //   156: getfield 14	fcb:jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader	Lcom/tencent/open/agent/datamodel/ImageLoader;
    //   159: getfield 73	com/tencent/open/agent/datamodel/ImageLoader:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   162: aload_1
    //   163: aload_3
    //   164: invokevirtual 79	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   167: pop
    //   168: aload_2
    //   169: monitorexit
    //   170: aload_0
    //   171: getfield 16	fcb:jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader$ImageLoadListener	Lcom/tencent/open/agent/datamodel/ImageLoader$ImageLoadListener;
    //   174: aload_0
    //   175: getfield 18	fcb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   178: aload_3
    //   179: invokeinterface 84 3 0
    //   184: return
    //   185: astore_2
    //   186: aload_2
    //   187: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   190: goto -99 -> 91
    //   193: astore_2
    //   194: aload_2
    //   195: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   198: aload 4
    //   200: astore_2
    //   201: goto -95 -> 106
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_3
    //   208: aload_3
    //   209: astore_2
    //   210: aload 4
    //   212: invokevirtual 141	java/net/MalformedURLException:printStackTrace	()V
    //   215: aload_3
    //   216: ifnull +7 -> 223
    //   219: aload_3
    //   220: invokevirtual 129	java/io/InputStream:close	()V
    //   223: iconst_0
    //   224: ifeq +138 -> 362
    //   227: new 131	java/lang/NullPointerException
    //   230: dup
    //   231: invokespecial 132	java/lang/NullPointerException:<init>	()V
    //   234: athrow
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   240: goto -17 -> 223
    //   243: astore_2
    //   244: aload_2
    //   245: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   248: aconst_null
    //   249: astore_2
    //   250: goto -144 -> 106
    //   253: astore 4
    //   255: aconst_null
    //   256: astore_3
    //   257: aload_3
    //   258: astore_2
    //   259: aload 4
    //   261: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   264: aload_3
    //   265: ifnull +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 129	java/io/InputStream:close	()V
    //   272: iconst_0
    //   273: ifeq +89 -> 362
    //   276: new 131	java/lang/NullPointerException
    //   279: dup
    //   280: invokespecial 132	java/lang/NullPointerException:<init>	()V
    //   283: athrow
    //   284: astore_2
    //   285: aload_2
    //   286: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   289: goto -17 -> 272
    //   292: astore_2
    //   293: aload_2
    //   294: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -193 -> 106
    //   302: astore_1
    //   303: aconst_null
    //   304: astore_2
    //   305: aload_2
    //   306: ifnull +7 -> 313
    //   309: aload_2
    //   310: invokevirtual 129	java/io/InputStream:close	()V
    //   313: iconst_0
    //   314: ifeq +11 -> 325
    //   317: new 131	java/lang/NullPointerException
    //   320: dup
    //   321: invokespecial 132	java/lang/NullPointerException:<init>	()V
    //   324: athrow
    //   325: aload_1
    //   326: athrow
    //   327: astore_2
    //   328: aload_2
    //   329: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   332: goto -19 -> 313
    //   335: astore_2
    //   336: aload_2
    //   337: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   340: goto -15 -> 325
    //   343: astore_1
    //   344: aload_2
    //   345: monitorexit
    //   346: aload_1
    //   347: athrow
    //   348: astore_1
    //   349: goto -44 -> 305
    //   352: astore 4
    //   354: goto -97 -> 257
    //   357: astore 4
    //   359: goto -151 -> 208
    //   362: aconst_null
    //   363: astore_2
    //   364: goto -258 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	fcb
    //   0	367	1	paramString1	String
    //   0	367	3	paramString3	String
    //   81	118	4	localBitmap	Bitmap
    //   204	7	4	localMalformedURLException1	java.net.MalformedURLException
    //   253	7	4	localIOException1	java.io.IOException
    //   352	1	4	localIOException2	java.io.IOException
    //   357	1	4	localMalformedURLException2	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   87	91	185	java/io/IOException
    //   98	106	193	java/io/IOException
    //   39	75	204	java/net/MalformedURLException
    //   219	223	235	java/io/IOException
    //   227	235	243	java/io/IOException
    //   39	75	253	java/io/IOException
    //   268	272	284	java/io/IOException
    //   276	284	292	java/io/IOException
    //   39	75	302	finally
    //   309	313	327	java/io/IOException
    //   317	325	335	java/io/IOException
    //   155	170	343	finally
    //   344	346	343	finally
    //   77	83	348	finally
    //   210	215	348	finally
    //   259	264	348	finally
    //   77	83	352	java/io/IOException
    //   77	83	357	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fcb
 * JD-Core Version:    0.7.0.1
 */