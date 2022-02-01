import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageDownCallback;

public class hjx
  implements ImageDownCallback
{
  public hjx(ImageLoader paramImageLoader, ImageLoader.ImageLoadListener paramImageLoadListener, String paramString) {}
  
  public void a(String paramString1, String arg2, String paramString3)
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString3);
    LogUtility.c(ImageLoader.jdField_a_of_type_JavaLangString, "-->imgDownloaded path = " + ??? + " localUrl = " + paramString3);
    paramString3 = ImageUtil.a(localBitmap, 50, 50);
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
    //   0: getstatic 32	com/tencent/open/agent/datamodel/ImageLoader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: new 34	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   10: ldc 82
    //   12: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_2
    //   16: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 43
    //   21: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_3
    //   25: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 53	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: invokestatic 87	com/tencent/open/appcommon/Common:a	()Z
    //   37: ifne +143 -> 180
    //   40: new 89	java/net/URL
    //   43: dup
    //   44: aload_0
    //   45: getfield 18	hjx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokespecial 92	java/net/URL:<init>	(Ljava/lang/String;)V
    //   51: invokevirtual 96	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   54: checkcast 98	java/net/HttpURLConnection
    //   57: astore_2
    //   58: aload_2
    //   59: sipush 5000
    //   62: invokevirtual 102	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   65: aload_2
    //   66: ldc 104
    //   68: invokevirtual 107	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   71: aload_2
    //   72: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   75: astore_3
    //   76: aload_3
    //   77: astore_2
    //   78: aload_3
    //   79: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   82: astore 4
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 120	java/io/InputStream:close	()V
    //   92: aload 4
    //   94: astore_2
    //   95: iconst_0
    //   96: ifeq +11 -> 107
    //   99: new 122	java/lang/NullPointerException
    //   102: dup
    //   103: invokespecial 123	java/lang/NullPointerException:<init>	()V
    //   106: athrow
    //   107: getstatic 32	com/tencent/open/agent/datamodel/ImageLoader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: new 34	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   117: ldc 125
    //   119: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_2
    //   123: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 53	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_2
    //   133: ifnull +47 -> 180
    //   136: aload_2
    //   137: bipush 50
    //   139: bipush 50
    //   141: invokestatic 58	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   144: astore_3
    //   145: getstatic 61	com/tencent/open/agent/datamodel/ImageLoader:jdField_a_of_type_ArrayOfByte	[B
    //   148: astore_2
    //   149: aload_2
    //   150: monitorenter
    //   151: aload_0
    //   152: getfield 14	hjx:jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader	Lcom/tencent/open/agent/datamodel/ImageLoader;
    //   155: getfield 64	com/tencent/open/agent/datamodel/ImageLoader:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   158: aload_1
    //   159: aload_3
    //   160: invokevirtual 70	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload_2
    //   165: monitorexit
    //   166: aload_0
    //   167: getfield 16	hjx:jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader$ImageLoadListener	Lcom/tencent/open/agent/datamodel/ImageLoader$ImageLoadListener;
    //   170: aload_0
    //   171: getfield 18	hjx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   174: aload_3
    //   175: invokeinterface 75 3 0
    //   180: return
    //   181: astore_2
    //   182: aload_2
    //   183: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   186: goto -94 -> 92
    //   189: astore_2
    //   190: aload_2
    //   191: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   194: aload 4
    //   196: astore_2
    //   197: goto -90 -> 107
    //   200: astore 4
    //   202: aconst_null
    //   203: astore_3
    //   204: aload_3
    //   205: astore_2
    //   206: aload 4
    //   208: invokevirtual 132	java/net/MalformedURLException:printStackTrace	()V
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 120	java/io/InputStream:close	()V
    //   219: iconst_0
    //   220: ifeq +138 -> 358
    //   223: new 122	java/lang/NullPointerException
    //   226: dup
    //   227: invokespecial 123	java/lang/NullPointerException:<init>	()V
    //   230: athrow
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   236: goto -17 -> 219
    //   239: astore_2
    //   240: aload_2
    //   241: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   244: aconst_null
    //   245: astore_2
    //   246: goto -139 -> 107
    //   249: astore 4
    //   251: aconst_null
    //   252: astore_3
    //   253: aload_3
    //   254: astore_2
    //   255: aload 4
    //   257: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 120	java/io/InputStream:close	()V
    //   268: iconst_0
    //   269: ifeq +89 -> 358
    //   272: new 122	java/lang/NullPointerException
    //   275: dup
    //   276: invokespecial 123	java/lang/NullPointerException:<init>	()V
    //   279: athrow
    //   280: astore_2
    //   281: aload_2
    //   282: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   285: goto -17 -> 268
    //   288: astore_2
    //   289: aload_2
    //   290: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   293: aconst_null
    //   294: astore_2
    //   295: goto -188 -> 107
    //   298: astore_1
    //   299: aconst_null
    //   300: astore_2
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 120	java/io/InputStream:close	()V
    //   309: iconst_0
    //   310: ifeq +11 -> 321
    //   313: new 122	java/lang/NullPointerException
    //   316: dup
    //   317: invokespecial 123	java/lang/NullPointerException:<init>	()V
    //   320: athrow
    //   321: aload_1
    //   322: athrow
    //   323: astore_2
    //   324: aload_2
    //   325: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   328: goto -19 -> 309
    //   331: astore_2
    //   332: aload_2
    //   333: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   336: goto -15 -> 321
    //   339: astore_1
    //   340: aload_2
    //   341: monitorexit
    //   342: aload_1
    //   343: athrow
    //   344: astore_1
    //   345: goto -44 -> 301
    //   348: astore 4
    //   350: goto -97 -> 253
    //   353: astore 4
    //   355: goto -151 -> 204
    //   358: aconst_null
    //   359: astore_2
    //   360: goto -253 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	hjx
    //   0	363	1	paramString1	String
    //   0	363	3	paramString3	String
    //   82	113	4	localBitmap	Bitmap
    //   200	7	4	localMalformedURLException1	java.net.MalformedURLException
    //   249	7	4	localIOException1	java.io.IOException
    //   348	1	4	localIOException2	java.io.IOException
    //   353	1	4	localMalformedURLException2	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   88	92	181	java/io/IOException
    //   99	107	189	java/io/IOException
    //   40	76	200	java/net/MalformedURLException
    //   215	219	231	java/io/IOException
    //   223	231	239	java/io/IOException
    //   40	76	249	java/io/IOException
    //   264	268	280	java/io/IOException
    //   272	280	288	java/io/IOException
    //   40	76	298	finally
    //   305	309	323	java/io/IOException
    //   313	321	331	java/io/IOException
    //   151	166	339	finally
    //   340	342	339	finally
    //   78	84	344	finally
    //   206	211	344	finally
    //   255	260	344	finally
    //   78	84	348	java/io/IOException
    //   78	84	353	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hjx
 * JD-Core Version:    0.7.0.1
 */