import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;

class awng
  implements Downloader.DownloadListener
{
  awng(awnf paramawnf) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = awnf.a(this.this$0, paramString, true).iterator();
    while (paramString.hasNext())
    {
      paramDownloadResult = (awnh)paramString.next();
      awni localawni = (awni)paramDownloadResult.jj.get();
      if (localawni != null) {
        localawni.onFailed(paramDownloadResult.mUrl, paramDownloadResult.mResType, paramDownloadResult.fileName);
      }
      paramDownloadResult.recycle();
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  /* Error */
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 84	awnf:st	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 87	awnf:access$1000	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 12	awng:this$0	Lawnf;
    //   13: aload_1
    //   14: iconst_1
    //   15: invokestatic 26	awnf:a	(Lawnf;Ljava/lang/String;Z)Ljava/util/Collection;
    //   18: invokeinterface 32 1 0
    //   23: astore 5
    //   25: aload 5
    //   27: invokeinterface 38 1 0
    //   32: ifeq +325 -> 357
    //   35: aload 5
    //   37: invokeinterface 42 1 0
    //   42: checkcast 44	awnh
    //   45: astore 6
    //   47: aload 6
    //   49: getfield 48	awnh:jj	Ljava/lang/ref/WeakReference;
    //   52: invokevirtual 53	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   55: checkcast 55	awni
    //   58: astore 4
    //   60: aload 4
    //   62: ifnull +190 -> 252
    //   65: aload 6
    //   67: getfield 63	awnh:mResType	I
    //   70: sipush 999
    //   73: if_icmpne +26 -> 99
    //   76: aload 4
    //   78: aload 6
    //   80: getfield 59	awnh:mUrl	Ljava/lang/String;
    //   83: aload 6
    //   85: getfield 63	awnh:mResType	I
    //   88: aload_3
    //   89: invokestatic 90	awnf:su	(Ljava/lang/String;)Ljava/lang/String;
    //   92: aconst_null
    //   93: invokevirtual 94	awni:onDownloaded	(Ljava/lang/String;ILjava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   96: goto -71 -> 25
    //   99: aload 6
    //   101: getfield 59	awnh:mUrl	Ljava/lang/String;
    //   104: aload 6
    //   106: getfield 66	awnh:fileName	Ljava/lang/String;
    //   109: invokestatic 98	awnf:m	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   112: astore 7
    //   114: aload 7
    //   116: invokestatic 102	awnf:access$600	(Ljava/io/File;)Z
    //   119: ifeq +210 -> 329
    //   122: aload_0
    //   123: monitorenter
    //   124: aload_0
    //   125: getfield 12	awng:this$0	Lawnf;
    //   128: invokestatic 105	awnf:a	(Lawnf;)Landroid/support/v4/util/LruCache;
    //   131: aload 6
    //   133: getfield 108	awnh:mUrlKey	Ljava/lang/String;
    //   136: invokevirtual 113	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 115	android/graphics/Bitmap
    //   142: astore_1
    //   143: aload_1
    //   144: astore_2
    //   145: aload_1
    //   146: ifnonnull +13 -> 159
    //   149: aload 7
    //   151: invokevirtual 121	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   154: aconst_null
    //   155: invokestatic 127	awmy:decodeFileWithBuffer	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore_2
    //   159: aload_2
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: ifnull +137 -> 301
    //   167: aload_0
    //   168: getfield 12	awng:this$0	Lawnf;
    //   171: invokestatic 105	awnf:a	(Lawnf;)Landroid/support/v4/util/LruCache;
    //   174: aload 6
    //   176: getfield 108	awnh:mUrlKey	Ljava/lang/String;
    //   179: aload_1
    //   180: invokevirtual 131	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload 4
    //   186: ifnull +66 -> 252
    //   189: aload 4
    //   191: monitorenter
    //   192: aload 4
    //   194: aload 4
    //   196: getfield 134	awni:mCount	I
    //   199: iconst_1
    //   200: isub
    //   201: putfield 134	awni:mCount	I
    //   204: aload 4
    //   206: monitorexit
    //   207: aload_1
    //   208: sipush 320
    //   211: invokevirtual 138	android/graphics/Bitmap:setDensity	(I)V
    //   214: new 140	android/graphics/drawable/BitmapDrawable
    //   217: dup
    //   218: aload_1
    //   219: invokespecial 143	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   222: astore_1
    //   223: aload_1
    //   224: invokestatic 149	aqnm:getDensityDpi	()F
    //   227: f2i
    //   228: invokevirtual 152	android/graphics/drawable/BitmapDrawable:setTargetDensity	(I)V
    //   231: aload 4
    //   233: aload 6
    //   235: getfield 59	awnh:mUrl	Ljava/lang/String;
    //   238: aload 6
    //   240: getfield 63	awnh:mResType	I
    //   243: aload 6
    //   245: getfield 66	awnh:fileName	Ljava/lang/String;
    //   248: aload_1
    //   249: invokevirtual 94	awni:onDownloaded	(Ljava/lang/String;ILjava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   252: aload 6
    //   254: invokevirtual 73	awnh:recycle	()V
    //   257: goto -232 -> 25
    //   260: astore_2
    //   261: aconst_null
    //   262: astore_1
    //   263: ldc 154
    //   265: aload_2
    //   266: invokevirtual 157	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   269: invokestatic 163	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: goto -111 -> 161
    //   275: astore_1
    //   276: aload_0
    //   277: monitorexit
    //   278: aload_1
    //   279: athrow
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: ldc 154
    //   285: aload_2
    //   286: invokevirtual 164	java/lang/Exception:toString	()Ljava/lang/String;
    //   289: invokestatic 163	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: goto -131 -> 161
    //   295: astore_1
    //   296: aload 4
    //   298: monitorexit
    //   299: aload_1
    //   300: athrow
    //   301: aload 4
    //   303: ifnull -51 -> 252
    //   306: aload 4
    //   308: aload 6
    //   310: getfield 59	awnh:mUrl	Ljava/lang/String;
    //   313: aload 6
    //   315: getfield 63	awnh:mResType	I
    //   318: aload 6
    //   320: getfield 66	awnh:fileName	Ljava/lang/String;
    //   323: invokevirtual 70	awni:onFailed	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: goto -74 -> 252
    //   329: aload 4
    //   331: ifnull -79 -> 252
    //   334: aload 4
    //   336: aload 6
    //   338: getfield 59	awnh:mUrl	Ljava/lang/String;
    //   341: aload 6
    //   343: getfield 63	awnh:mResType	I
    //   346: aload 6
    //   348: getfield 66	awnh:fileName	Ljava/lang/String;
    //   351: invokevirtual 70	awni:onFailed	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: goto -102 -> 252
    //   357: return
    //   358: astore_2
    //   359: goto -76 -> 283
    //   362: astore_2
    //   363: goto -100 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	awng
    //   0	366	1	paramString	String
    //   0	366	2	paramDownloadResult	DownloadResult
    //   4	85	3	str	String
    //   58	277	4	localawni	awni
    //   23	13	5	localIterator	Iterator
    //   45	302	6	localawnh	awnh
    //   112	38	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   124	143	260	java/lang/OutOfMemoryError
    //   124	143	275	finally
    //   149	159	275	finally
    //   161	163	275	finally
    //   263	272	275	finally
    //   276	278	275	finally
    //   283	292	275	finally
    //   124	143	280	java/lang/Exception
    //   192	207	295	finally
    //   296	299	295	finally
    //   149	159	358	java/lang/Exception
    //   149	159	362	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awng
 * JD-Core Version:    0.7.0.1
 */