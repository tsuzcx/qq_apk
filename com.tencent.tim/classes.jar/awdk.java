import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MultiHashMap;
import cooperation.qzone.util.ResDownloadManger.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class awdk
{
  private static awdk jdField_a_of_type_Awdk;
  private static String cPp;
  private static String cPq;
  private static String[] jb = { "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_yellow_icon_v1.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_themeAlbum.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_loading_bg.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_res.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_plus_publish_video_anim_guide_resource.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_first_page_loading_bg.zip", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/qzone_skin_feed_dropmenu_default.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_ads_res.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_list_slide_out_video_capture_anim.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_photo_category_empty_bgs.zip", "https://d3g.qq.com/sngapp/app/update/20181210212921_4631/qzone_recent_photo_calendar.zip", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/qzone_skin_feed_dropmenu_night_mode.zip" };
  private final MultiHashMap<String, awdm> jdField_a_of_type_CooperationQzoneUtilMultiHashMap = new MultiHashMap();
  private Downloader.DownloadListener b = new awdl(this);
  private Context context = BaseApplicationImpl.getContext();
  private avrq d;
  private LruCache<String, Bitmap> f;
  
  private awdk()
  {
    cPp = sb("qzonereszip");
    cPq = sb("qzoneres");
    this.f = new LruCache((int)(MemoryManager.eS() / 8L));
  }
  
  public static int PY()
  {
    if (ThemeUtil.isNowThemeIsNightForQzone()) {
      return 13;
    }
    return 8;
  }
  
  public static awdk a()
  {
    if (jdField_a_of_type_Awdk == null) {}
    try
    {
      jdField_a_of_type_Awdk = new awdk();
      return jdField_a_of_type_Awdk;
    }
    finally {}
  }
  
  private awdm a(String paramString1, int paramInt, String paramString2, awdk.a parama)
  {
    awdm localawdm = awdm.a(paramInt, paramString2);
    localawdm.mUrl = paramString1;
    localawdm.jj = new WeakReference(parama);
    localawdm.type = paramInt;
    localawdm.fileName = paramString2;
    return localawdm;
  }
  
  private void a(awdm paramawdm)
  {
    if (URLUtil.isNetworkUrl(paramawdm.mUrl))
    {
      String str = aX(paramawdm.mUrl);
      b().download(paramawdm.mUrl, str, true, this.b);
    }
  }
  
  private boolean a(String paramString, awdm paramawdm)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap)
      {
        int i = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.sizeOf(paramString);
        this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(paramString, paramawdm);
        if (i == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private static String aX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
    return cPp + paramString;
  }
  
  private static void aaF(String paramString)
  {
    String str = cPq + paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4);
    createAndClearFile(new File(str));
    jqp.unZipFolder(paramString, str);
  }
  
  /* Error */
  private avrq b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 247	awdk:d	Lavrq;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 247	awdk:d	Lavrq;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 249	avrq:a	()Lavrq;
    //   22: putfield 247	awdk:d	Lavrq;
    //   25: aload_0
    //   26: getfield 247	awdk:d	Lavrq;
    //   29: astore_1
    //   30: goto -16 -> 14
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	awdk
    //   13	17	1	localavrq	avrq
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
    //   18	30	33	finally
  }
  
  private static File b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return new File(cPq + paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.length() - 4) + File.separator + paramString2 + ".png");
  }
  
  private Collection<awdm> collectPendingRequest(String paramString, boolean paramBoolean)
  {
    return collectPendingRequest(paramString, paramBoolean, null);
  }
  
  private Collection<awdm> collectPendingRequest(String paramString, boolean paramBoolean, Collection<awdm> paramCollection)
  {
    MultiHashMap localMultiHashMap = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap;
    if (paramBoolean) {}
    try
    {
      for (paramString = (HashSet)this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.remove(paramString); paramCollection != null; paramString = (HashSet)this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.get(paramString))
      {
        paramCollection.clear();
        if (paramString != null) {
          paramCollection.addAll(paramString);
        }
        return paramCollection;
      }
      return paramString;
    }
    finally {}
  }
  
  private static void createAndClearFile(File paramFile)
  {
    if (!paramFile.exists()) {
      paramFile.mkdir();
    }
    for (;;)
    {
      return;
      if (!paramFile.isDirectory()) {
        break;
      }
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          if (!localObject.isDirectory()) {
            localObject.delete();
          }
          i += 1;
        }
      }
    }
    paramFile.mkdir();
  }
  
  /* Error */
  public static Bitmap decodeFileWithBuffer(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 305	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 306	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: new 308	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_2
    //   18: sipush 8192
    //   21: invokespecial 311	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 317	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_2
    //   33: ifnull +9 -> 42
    //   36: aload_2
    //   37: invokevirtual 322	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: astore_0
    //   42: aload_0
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +16 -> 68
    //   55: aload_2
    //   56: astore_0
    //   57: ldc_w 329
    //   60: iconst_2
    //   61: ldc_w 331
    //   64: aload_1
    //   65: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload_3
    //   69: astore_0
    //   70: aload_2
    //   71: ifnull -29 -> 42
    //   74: aload_2
    //   75: invokevirtual 322	java/io/InputStream:close	()V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_0
    //   81: aconst_null
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +16 -> 107
    //   94: aload_2
    //   95: astore_0
    //   96: ldc_w 329
    //   99: iconst_2
    //   100: ldc_w 331
    //   103: aload_1
    //   104: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_3
    //   108: astore_0
    //   109: aload_2
    //   110: ifnull -68 -> 42
    //   113: aload_2
    //   114: invokevirtual 322	java/io/InputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 322	java/io/InputStream:close	()V
    //   133: aload_1
    //   134: athrow
    //   135: astore_0
    //   136: aload_1
    //   137: areturn
    //   138: astore_0
    //   139: goto -6 -> 133
    //   142: astore_1
    //   143: goto -18 -> 125
    //   146: astore_1
    //   147: goto -61 -> 86
    //   150: astore_1
    //   151: goto -104 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   0	154	1	paramOptions	BitmapFactory.Options
    //   10	104	2	localFileInputStream	java.io.FileInputStream
    //   1	107	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	44	java/lang/OutOfMemoryError
    //   74	78	80	java/io/IOException
    //   2	11	83	java/lang/Exception
    //   113	117	119	java/io/IOException
    //   2	11	122	finally
    //   36	40	135	java/io/IOException
    //   129	133	138	java/io/IOException
    //   13	30	142	finally
    //   49	55	142	finally
    //   57	68	142	finally
    //   88	94	142	finally
    //   96	107	142	finally
    //   13	30	146	java/lang/Exception
    //   13	30	150	java/lang/OutOfMemoryError
  }
  
  public static void eA(int paramInt, String paramString)
  {
    jb[paramInt] = paramString;
  }
  
  private static boolean isFileValid(File paramFile)
  {
    return (paramFile != null) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  private static String sb(String paramString)
  {
    String str2 = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath();
    String str1 = paramString;
    if (!paramString.startsWith(File.separator)) {
      str1 = File.separator + paramString;
    }
    paramString = str1;
    if (!str1.endsWith(File.separator)) {
      paramString = str1 + File.separator;
    }
    paramString = new File(str2 + paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    str1 = paramString.getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith(File.separator)) {
      paramString = str1 + File.separator;
    }
    return paramString;
  }
  
  /* Error */
  public Bitmap a(int paramInt, String paramString, awdk.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +6 -> 13
    //   10: aload 5
    //   12: areturn
    //   13: aload_0
    //   14: getfield 109	awdk:f	Landroid/support/v4/util/LruCache;
    //   17: new 215	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   24: iload_1
    //   25: invokevirtual 368	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc_w 370
    //   31: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 371	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 373	android/graphics/Bitmap
    //   47: astore 4
    //   49: aload 4
    //   51: astore 5
    //   53: aload 4
    //   55: ifnonnull -45 -> 10
    //   58: getstatic 58	awdk:jb	[Ljava/lang/String;
    //   61: iload_1
    //   62: aaload
    //   63: astore 7
    //   65: aload 7
    //   67: aload_2
    //   68: invokestatic 345	awdk:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   71: astore 8
    //   73: aload 8
    //   75: invokestatic 114	awdk:isFileValid	(Ljava/io/File;)Z
    //   78: ifeq +187 -> 265
    //   81: aload_0
    //   82: monitorenter
    //   83: aload 4
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 109	awdk:f	Landroid/support/v4/util/LruCache;
    //   91: new 215	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   98: iload_1
    //   99: invokevirtual 368	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc_w 370
    //   105: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 371	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 373	android/graphics/Bitmap
    //   121: astore 6
    //   123: aload 6
    //   125: ifnull +13 -> 138
    //   128: aload_0
    //   129: monitorexit
    //   130: aload 6
    //   132: areturn
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    //   138: aload 6
    //   140: astore 5
    //   142: aload 6
    //   144: astore 4
    //   146: ldc_w 329
    //   149: iconst_1
    //   150: ldc_w 375
    //   153: invokestatic 379	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload 6
    //   158: astore 5
    //   160: aload 6
    //   162: astore 4
    //   164: aload 8
    //   166: invokevirtual 354	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   169: aconst_null
    //   170: invokestatic 381	awdk:decodeFileWithBuffer	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   173: astore 6
    //   175: aload 6
    //   177: astore 4
    //   179: aload_0
    //   180: monitorexit
    //   181: aload 4
    //   183: astore 6
    //   185: aload 4
    //   187: ifnull +92 -> 279
    //   190: aload_0
    //   191: getfield 109	awdk:f	Landroid/support/v4/util/LruCache;
    //   194: new 215	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   201: iload_1
    //   202: invokevirtual 368	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: ldc_w 370
    //   208: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_2
    //   212: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: aload 4
    //   220: invokevirtual 385	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   223: pop
    //   224: aload 4
    //   226: areturn
    //   227: astore 4
    //   229: ldc_w 387
    //   232: iconst_1
    //   233: aload 4
    //   235: invokevirtual 388	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   238: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload 5
    //   243: astore 4
    //   245: goto -66 -> 179
    //   248: astore 5
    //   250: ldc_w 387
    //   253: iconst_1
    //   254: aload 5
    //   256: invokevirtual 391	java/lang/Exception:toString	()Ljava/lang/String;
    //   259: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -83 -> 179
    //   265: ldc_w 329
    //   268: iconst_1
    //   269: ldc_w 393
    //   272: invokestatic 379	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload 4
    //   277: astore 6
    //   279: aload_0
    //   280: aload 7
    //   282: iload_1
    //   283: aload_2
    //   284: aload_3
    //   285: invokespecial 131	awdk:a	(Ljava/lang/String;ILjava/lang/String;Lawdk$a;)Lawdm;
    //   288: astore_2
    //   289: aload 6
    //   291: astore 5
    //   293: aload_0
    //   294: aload 7
    //   296: aload_2
    //   297: invokespecial 186	awdk:a	(Ljava/lang/String;Lawdm;)Z
    //   300: ifeq -290 -> 10
    //   303: aload_0
    //   304: aload_2
    //   305: invokespecial 164	awdk:a	(Lawdm;)V
    //   308: aload 6
    //   310: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	awdk
    //   0	311	1	paramInt	int
    //   0	311	2	paramString	String
    //   0	311	3	parama	awdk.a
    //   47	178	4	localObject1	Object
    //   227	7	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   243	33	4	localObject2	Object
    //   1	241	5	localObject3	Object
    //   248	7	5	localException	java.lang.Exception
    //   291	1	5	localObject4	Object
    //   121	188	6	localObject5	Object
    //   63	232	7	str	String
    //   71	94	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   87	123	133	finally
    //   128	130	133	finally
    //   134	136	133	finally
    //   146	156	133	finally
    //   164	175	133	finally
    //   179	181	133	finally
    //   229	241	133	finally
    //   250	262	133	finally
    //   87	123	227	java/lang/OutOfMemoryError
    //   146	156	227	java/lang/OutOfMemoryError
    //   164	175	227	java/lang/OutOfMemoryError
    //   87	123	248	java/lang/Exception
    //   146	156	248	java/lang/Exception
    //   164	175	248	java/lang/Exception
  }
  
  public Bitmap a(int paramInt, String paramString, awdk.a parama, BitmapFactory.Options paramOptions)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.f.get(paramInt + " " + paramString);
      localObject = localBitmap;
    } while (localBitmap != null);
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new ResDownloadManger.1(this, paramInt, paramString, parama, paramOptions));
    return localBitmap;
  }
  
  public Drawable a(int paramInt, String paramString, awdk.a parama)
  {
    paramString = a(paramInt, paramString, parama);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)aqnm.getDensityDpi());
      return paramString;
    }
    return null;
  }
  
  public Drawable a(int paramInt, String paramString, awdk.a parama, BitmapFactory.Options paramOptions)
  {
    paramString = a(paramInt, paramString, parama, paramOptions);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)aqnm.getDensityDpi());
      return paramString;
    }
    return null;
  }
  
  public Drawable b(int paramInt, String paramString, awdk.a parama)
  {
    Object localObject = null;
    paramString = a(paramInt, paramString, parama, null);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)aqnm.getDensityDpi());
    }
    do
    {
      return paramString;
      paramString = localObject;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebanew", 4, "qzonepouwindow:下载资源失败");
    return null;
  }
  
  public void q(int paramInt, ArrayList<String> paramArrayList)
  {
    if ((this.f != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        this.f.remove(paramInt + " " + str);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString, Bitmap paramBitmap);
    
    public abstract void onFailed(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdk
 * JD-Core Version:    0.7.0.1
 */