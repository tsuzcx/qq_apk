import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MultiHashMap;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.util.ZipResDownloadManager.1;
import cooperation.vip.vipcomponent.util.ZipResDownloadManager.2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class awnf
{
  public static final ArrayList<String> Fw = new ArrayList();
  private static awnf jdField_a_of_type_Awnf;
  private static String cPp;
  private static String cPq;
  private final MultiHashMap<String, awnh> jdField_a_of_type_CooperationQzoneUtilMultiHashMap = new MultiHashMap();
  private Downloader.DownloadListener b = new awng(this);
  private Context context = BaseApplicationImpl.getContext();
  private avrq d;
  private LruCache<String, Bitmap> f;
  
  static
  {
    Fw.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_yellow_icon_v6.zip");
    Fw.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip");
    Fw.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip");
  }
  
  public awnf()
  {
    cPp = sb("qzonereszip");
    cPq = sb("qzoneres");
    this.f = new LruCache((int)(MemoryManager.eS() / 8L));
  }
  
  private static boolean M(File paramFile)
  {
    return (paramFile != null) && (paramFile.isDirectory());
  }
  
  public static awnf a()
  {
    if (jdField_a_of_type_Awnf == null) {}
    try
    {
      if (jdField_a_of_type_Awnf == null) {
        jdField_a_of_type_Awnf = new awnf();
      }
      return jdField_a_of_type_Awnf;
    }
    finally {}
  }
  
  private awnh a(String paramString1, int paramInt, String paramString2, awni paramawni)
  {
    return awnh.a(paramString1, paramInt, paramString2, new WeakReference(paramawni));
  }
  
  private void a(awnh paramawnh)
  {
    if (URLUtil.isNetworkUrl(paramawnh.mUrl))
    {
      String str = aX(paramawnh.mUrl);
      b().download(paramawnh.mUrl, str, true, this.b);
    }
  }
  
  private boolean a(String paramString, awnh paramawnh)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap)
      {
        int i = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.sizeOf(paramString);
        this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(paramString, paramawnh);
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
    if ((TextUtils.isEmpty(paramString)) || (!paramString.endsWith("zip"))) {
      return paramString;
    }
    if (Fw.contains(paramString)) {}
    for (paramString = awmy.sr(paramString) + ".zip";; paramString = awmy.cC(paramString) + ".zip") {
      return cPp + paramString;
    }
  }
  
  private static void aaF(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(ss(paramString));
      createAndClearFile(localFile);
      awcf.d(new File(paramString), localFile);
    }
  }
  
  /* Error */
  private avrq b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 224	awnf:d	Lavrq;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 224	awnf:d	Lavrq;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 226	avrq:a	()Lavrq;
    //   22: putfield 224	awnf:d	Lavrq;
    //   25: aload_0
    //   26: getfield 224	awnf:d	Lavrq;
    //   29: astore_1
    //   30: goto -16 -> 14
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	awnf
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
    if (Fw.contains(paramString1)) {}
    for (paramString1 = cPq + awmy.sr(paramString1) + File.separator + paramString2 + ".png";; paramString1 = cPq + awmy.cC(paramString1) + File.separator + paramString2 + ".png") {
      return new File(paramString1);
    }
  }
  
  private Collection<awnh> collectPendingRequest(String paramString, boolean paramBoolean)
  {
    return collectPendingRequest(paramString, paramBoolean, null);
  }
  
  private Collection<awnh> collectPendingRequest(String paramString, boolean paramBoolean, Collection<awnh> paramCollection)
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
  
  private static File getDir(String paramString)
  {
    if (Fw.contains(paramString)) {}
    for (paramString = cPq + awmy.sr(paramString);; paramString = cPq + awmy.cC(paramString)) {
      return new File(paramString);
    }
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
  
  private static String ss(String paramString)
  {
    return cPq + paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4);
  }
  
  /* Error */
  public Bitmap a(String paramString1, int paramInt, String paramString2, awni paramawni)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +6 -> 13
    //   10: aload 7
    //   12: areturn
    //   13: aload_0
    //   14: getfield 91	awnf:f	Landroid/support/v4/util/LruCache;
    //   17: new 180	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   24: aload_1
    //   25: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 320
    //   31: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_3
    //   35: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 321	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 323	android/graphics/Bitmap
    //   47: astore 5
    //   49: aload 5
    //   51: astore 7
    //   53: aload 5
    //   55: ifnonnull -45 -> 10
    //   58: aload_1
    //   59: aload_3
    //   60: invokestatic 280	awnf:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   63: astore 8
    //   65: aload 5
    //   67: astore 6
    //   69: aload 8
    //   71: invokestatic 222	awnf:isFileValid	(Ljava/io/File;)Z
    //   74: ifeq +167 -> 241
    //   77: aload_0
    //   78: monitorenter
    //   79: aload 5
    //   81: astore 6
    //   83: aload_0
    //   84: getfield 91	awnf:f	Landroid/support/v4/util/LruCache;
    //   87: new 180	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   94: aload_1
    //   95: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 320
    //   101: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokevirtual 321	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 323	android/graphics/Bitmap
    //   117: astore 7
    //   119: aload 7
    //   121: ifnull +13 -> 134
    //   124: aload_0
    //   125: monitorexit
    //   126: aload 7
    //   128: areturn
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: aload 7
    //   136: astore 6
    //   138: aload 7
    //   140: astore 5
    //   142: aload 8
    //   144: invokevirtual 292	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   147: aconst_null
    //   148: invokestatic 327	awmy:decodeFileWithBuffer	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   151: astore 7
    //   153: aload 7
    //   155: astore 5
    //   157: aload_0
    //   158: monitorexit
    //   159: aload 5
    //   161: astore 6
    //   163: aload 5
    //   165: ifnull +76 -> 241
    //   168: aload_0
    //   169: getfield 91	awnf:f	Landroid/support/v4/util/LruCache;
    //   172: new 180	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   179: aload_1
    //   180: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 320
    //   186: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_3
    //   190: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aload 5
    //   198: invokevirtual 331	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload 5
    //   204: areturn
    //   205: astore 5
    //   207: ldc_w 333
    //   210: aload 5
    //   212: invokevirtual 334	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   215: invokestatic 340	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload 6
    //   220: astore 5
    //   222: goto -65 -> 157
    //   225: astore 6
    //   227: ldc_w 333
    //   230: aload 6
    //   232: invokevirtual 341	java/lang/Exception:toString	()Ljava/lang/String;
    //   235: invokestatic 340	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -81 -> 157
    //   241: aload_0
    //   242: aload_1
    //   243: iload_2
    //   244: aload_3
    //   245: aload 4
    //   247: invokespecial 111	awnf:a	(Ljava/lang/String;ILjava/lang/String;Lawni;)Lawnh;
    //   250: astore_3
    //   251: aload 6
    //   253: astore 7
    //   255: aload_0
    //   256: aload_1
    //   257: aload_3
    //   258: invokespecial 155	awnf:a	(Ljava/lang/String;Lawnh;)Z
    //   261: ifeq -251 -> 10
    //   264: aload_0
    //   265: aload_3
    //   266: invokespecial 130	awnf:a	(Lawnh;)V
    //   269: aload 6
    //   271: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	awnf
    //   0	272	1	paramString1	String
    //   0	272	2	paramInt	int
    //   0	272	3	paramString2	String
    //   0	272	4	paramawni	awni
    //   47	156	5	localObject1	Object
    //   205	6	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   220	1	5	localObject2	Object
    //   67	152	6	localObject3	Object
    //   225	45	6	localException	Exception
    //   1	253	7	localObject4	Object
    //   63	80	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	119	129	finally
    //   124	126	129	finally
    //   130	132	129	finally
    //   142	153	129	finally
    //   157	159	129	finally
    //   207	218	129	finally
    //   227	238	129	finally
    //   83	119	205	java/lang/OutOfMemoryError
    //   142	153	205	java/lang/OutOfMemoryError
    //   83	119	225	java/lang/Exception
    //   142	153	225	java/lang/Exception
  }
  
  public Drawable a(String paramString1, int paramInt, String paramString2, awni paramawni)
  {
    return a(paramString1, paramInt, paramString2, false, paramawni);
  }
  
  public Drawable a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, awni paramawni)
  {
    if ((paramBoolean) && (!Fw.contains(paramString1))) {
      Fw.add(paramString1);
    }
    paramString1 = b(paramString1, paramInt, paramString2, paramawni);
    if (paramString1 != null)
    {
      paramString1.setDensity(320);
      paramString1 = new BitmapDrawable(paramString1);
      paramString1.setTargetDensity((int)aqnm.getDensityDpi());
      return paramString1;
    }
    if (paramawni != null) {
      try
      {
        paramawni.mCount += 1;
      }
      finally {}
    }
    return null;
  }
  
  public String a(String paramString, awni paramawni)
  {
    String str = ss(aX(paramString));
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.listFiles().length != 0)) {
      return str;
    }
    paramawni = a(paramString, 999, str, paramawni);
    if (a(paramString, paramawni)) {
      a(paramawni);
    }
    return null;
  }
  
  public Bitmap b(String paramString1, int paramInt, String paramString2, awni paramawni)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString2)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.f.get(paramString1 + " " + paramString2);
      localObject = localBitmap;
    } while (localBitmap != null);
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(new ZipResDownloadManager.2(this, paramString1, paramString2, paramawni, paramInt), 400L);
    return localBitmap;
  }
  
  public void preDownloadZipImage(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {
      return;
    }
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new ZipResDownloadManager.1(this, paramString));
  }
  
  public boolean uc(String paramString)
  {
    if (Fw.contains(paramString)) {
      paramString = cPq + awmy.sr(paramString) + File.separator;
    }
    try
    {
      for (;;)
      {
        paramString = new File(paramString);
        if ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()) || (paramString.list() == null)) {
          break;
        }
        int i = paramString.list().length;
        if (i <= 0) {
          break;
        }
        return true;
        paramString = cPq + awmy.cC(paramString) + File.separator;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QZLog.w("test", " file exception " + paramString.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnf
 * JD-Core Version:    0.7.0.1
 */