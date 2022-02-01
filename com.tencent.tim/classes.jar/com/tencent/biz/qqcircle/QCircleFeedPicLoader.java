package com.tencent.biz.qqcircle;

import ahbj;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.widget.ImageView;
import aoll;
import aolm;
import aomi;
import aqfe;
import aqhq;
import aqiw;
import aroi;
import arwo;
import arwt;
import arwv;
import arxm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import oug;
import ouh;
import oui;
import ouj;
import ouk;
import oul;

public class QCircleFeedPicLoader
{
  private static int CACHE_TIME = 259200000;
  public static int STATE_CANCEL;
  public static int STATE_PREPARE;
  public static int STATE_SUCCESS;
  public static String TAG = "QCircleFeedPicLoader";
  private static QCircleFeedPicLoader a;
  private static final String arA = oug.arv + "feed_pic/";
  public static int bgh;
  public static int bgi;
  public static int bgj;
  public static int bgk;
  public static int bgl;
  private ConcurrentHashMap<String, PicDownLoadTask> bG;
  private ConcurrentHashMap<String, PicDeCodeTask> bH;
  private final byte[] bv = new byte[1];
  private HashMap<String, String> eS;
  private ThreadPoolExecutor k;
  private ThreadPoolExecutor l;
  private MQLruCache<String, Object> sImageCache;
  
  static
  {
    STATE_PREPARE = 1;
    bgh = 2;
    bgi = 3;
    STATE_CANCEL = 4;
    bgj = 5;
    STATE_SUCCESS = 6;
    bgk = 7;
    bgl = 8;
  }
  
  private QCircleFeedPicLoader()
  {
    if (this.sImageCache == null) {
      this.sImageCache = BaseApplicationImpl.sImageCache;
    }
    int i = Runtime.getRuntime().availableProcessors();
    if (this.k == null) {
      this.k = new ThreadPoolExecutor(i * 2 + 1, i * 2 + 1, 120L, TimeUnit.SECONDS, new PriorityBlockingQueue(200, new ouh(this)), Executors.defaultThreadFactory(), new oui(this));
    }
    if (this.l == null) {
      this.l = new ThreadPoolExecutor(i + 1, i * 2 + 1, 120L, TimeUnit.SECONDS, new PriorityBlockingQueue(200, new ouj(this)), Executors.defaultThreadFactory(), new ouk(this));
    }
    if (this.bG == null) {
      this.bG = new ConcurrentHashMap();
    }
    if (this.bH == null) {
      this.bH = new ConcurrentHashMap();
    }
    if (this.eS == null) {
      this.eS = new HashMap();
    }
    aqhq.UD(arA + ".nomedia");
  }
  
  public static QCircleFeedPicLoader a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QCircleFeedPicLoader();
      }
      return a;
    }
    finally {}
  }
  
  private void a(b paramb, Bitmap paramBitmap)
  {
    if ((paramb != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label55;
      }
      if (paramb.isValid())
      {
        paramb.j().setImageDrawable(null);
        paramb.j().setImageDrawable(new BitmapDrawable(paramBitmap));
      }
    }
    return;
    label55:
    ThreadManager.getUIHandler().post(new QCircleFeedPicLoader.6(this, paramb, paramBitmap));
  }
  
  private void a(b paramb, Drawable paramDrawable)
  {
    if ((paramb != null) && (paramDrawable != null))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label41;
      }
      if (paramb.isValid())
      {
        paramb.j().setImageDrawable(null);
        paramb.j().setImageDrawable(paramDrawable);
      }
    }
    return;
    label41:
    ThreadManager.getUIHandler().post(new QCircleFeedPicLoader.7(this, paramb, paramDrawable));
  }
  
  private void a(@NotNull b paramb, c paramc)
  {
    String str = a(paramb);
    if ((paramb.Hz()) && (this.bG.containsKey(str))) {
      return;
    }
    cancel(str);
    b.b(paramb, Long.valueOf(System.currentTimeMillis()));
    paramb = new PicDownLoadTask(paramb);
    paramb.a(paramc);
    this.bG.put(str, paramb);
    this.k.execute(paramb);
  }
  
  private void b(@NotNull b paramb, c paramc)
  {
    String str = a(paramb);
    if ((paramb.Hz()) && (this.bH.containsKey(str))) {
      return;
    }
    cancel(str);
    b.c(paramb, Long.valueOf(System.currentTimeMillis()));
    paramb = new PicDeCodeTask(paramb);
    paramb.a(paramc);
    this.bH.put(str, paramb);
    this.l.execute(paramb);
  }
  
  private void bhF()
  {
    long l1 = System.currentTimeMillis();
    String str = aqfe.get(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time");
    if (!TextUtils.isEmpty(str))
    {
      if (l1 - Long.valueOf(str).longValue() >= CACHE_TIME)
      {
        aqhq.cn(arA);
        aqfe.J(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time", String.valueOf(l1));
      }
      return;
    }
    aqfe.J(BaseApplicationImpl.getApplication(), "qcircle_pic_cache_time", String.valueOf(l1));
  }
  
  private Object j(String paramString)
  {
    synchronized (this.bv)
    {
      paramString = this.sImageCache.get(paramString);
      return paramString;
    }
  }
  
  private void l(String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    synchronized (this.bv)
    {
      this.sImageCache.put(paramString, paramBitmap);
      this.bH.remove(paramString);
      return;
    }
  }
  
  public String a(b paramb)
  {
    if (!TextUtils.isEmpty(paramb.getUrl()))
    {
      StringBuilder localStringBuilder = new StringBuilder(arwv.encodeHexStr(fF(paramb.getUrl())));
      localStringBuilder.append("#").append(b.b(paramb)).append("_").append(b.a(paramb));
      paramb.b(localStringBuilder.toString());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String a(@NotNull b paramb, c paramc)
  {
    String str = a(paramb);
    Object localObject = j(str);
    if ((localObject instanceof Bitmap))
    {
      long l1 = System.currentTimeMillis();
      a(paramb, (Bitmap)localObject);
      if (paramc != null) {
        paramc.a(STATE_SUCCESS, paramb);
      }
      QLog.d(TAG, 1, b.c(paramb) + ",return in cache:  " + paramb.Hz() + "  costTime:" + (System.currentTimeMillis() - l1));
      return str;
    }
    b.a(paramb, Long.valueOf(System.currentTimeMillis()));
    this.l.execute(new QCircleFeedPicLoader.5(this, paramb, paramc));
    return str;
  }
  
  public String b(b paramb)
  {
    if (aqhq.rq(paramb.getUrl()))
    {
      str = paramb.getUrl();
      paramb.c(str);
      return str;
    }
    String str = arA + arwv.encodeHexStr(fF(paramb.getUrl())) + ".suf";
    paramb.c(str);
    return str;
  }
  
  public void cancel(@NotNull String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      if (this.bG.containsKey(paramString))
      {
        localObject = (PicDownLoadTask)this.bG.get(paramString);
        this.bG.remove(paramString);
        this.k.getQueue().remove(localObject);
        ((PicDownLoadTask)localObject).cancel();
      }
      if (this.bH.containsKey(paramString))
      {
        localObject = (PicDeCodeTask)this.bH.get(paramString);
        this.l.getQueue().remove(localObject);
        this.bH.remove(paramString);
        ((PicDeCodeTask)localObject).cancel();
      }
    }
  }
  
  public void destroy()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleFeedPicLoader.8(this));
  }
  
  public String fF(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.eS.containsKey(paramString)) {
        return (String)this.eS.get(paramString);
      }
      i = paramString.indexOf("://");
      if (i == -1) {
        break label167;
      }
    }
    label167:
    for (Object localObject2 = paramString.substring(i + 3);; localObject2 = paramString)
    {
      i = ((String)localObject2).indexOf("/");
      Object localObject1 = localObject2;
      if (i != -1) {
        localObject1 = ((String)localObject2).substring(i);
      }
      i = ((String)localObject1).lastIndexOf("#");
      localObject2 = localObject1;
      if (i != -1) {
        localObject2 = ((String)localObject1).substring(0, i);
      }
      i = ((String)localObject2).indexOf("tm=");
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
      i = ((String)localObject1).indexOf("ek=1");
      localObject2 = localObject1;
      if (i != -1) {
        localObject2 = ((String)localObject1).substring(0, i);
      }
      this.eS.put(paramString, localObject2);
      return localObject2;
      return "";
    }
  }
  
  public class PicDeCodeTask
    extends QCircleFeedPicLoader.PicDownLoadTask
  {
    public PicDeCodeTask(QCircleFeedPicLoader.b paramb)
    {
      super(paramb);
      this.mStatus = QCircleFeedPicLoader.bgj;
    }
    
    private Bitmap b(String paramString, BitmapFactory.Options paramOptions)
    {
      localObject = null;
      try
      {
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramString, paramOptions);
        paramOptions = localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          System.gc();
          localOutOfMemoryError.printStackTrace();
          try
          {
            paramOptions.inSampleSize *= 2;
            paramOptions = SafeBitmapFactory.decodeFile(paramString, paramOptions);
          }
          catch (OutOfMemoryError paramOptions)
          {
            System.gc();
            localOutOfMemoryError.printStackTrace();
            paramOptions = localObject;
          }
        }
      }
      if ((paramOptions == null) && (paramString.contains(QCircleFeedPicLoader.ek())))
      {
        ahbj.deleteFile(paramString);
        QLog.d(QCircleFeedPicLoader.TAG, 1, "decode bitmap failed");
      }
      return paramOptions;
    }
    
    private int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
    {
      int i = 1;
      int k = 1;
      int j = k;
      if (paramInt1 > 0)
      {
        if (paramInt2 > 0) {
          break label25;
        }
        j = k;
      }
      label25:
      int n;
      do
      {
        return j;
        n = paramOptions.outHeight;
        m = paramOptions.outWidth;
        if (n > paramInt2) {
          break;
        }
        j = k;
      } while (m <= paramInt1);
      k = (int)(n / 1.4F);
      int m = (int)(m / 1.4F);
      for (;;)
      {
        if (k / i <= paramInt2)
        {
          j = i;
          if (m / i <= paramInt1) {
            break;
          }
        }
        i *= 2;
      }
    }
    
    public void cancel()
    {
      super.cancel();
    }
    
    public void run()
    {
      if (this.mStatus == QCircleFeedPicLoader.STATE_CANCEL) {}
      Object localObject;
      for (;;)
      {
        return;
        long l = System.currentTimeMillis();
        QLog.d(QCircleFeedPicLoader.TAG, 4, QCircleFeedPicLoader.b.c(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b) + ", decode start cost in queue: " + (l - QCircleFeedPicLoader.b.b(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b).longValue()));
        if (this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c != null) {
          this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c.a(QCircleFeedPicLoader.bgj, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
        }
        localObject = QCircleFeedPicLoader.b.d(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        Bitmap localBitmap;
        if ((this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.rX() > 0) && (this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.rW() > 0))
        {
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile((String)localObject, localOptions);
          localOptions.inSampleSize = calculateInSampleSize(localOptions, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.rX(), this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.rW());
          int i = localOptions.outWidth;
          int j = localOptions.outHeight;
          localOptions.inJustDecodeBounds = false;
          localBitmap = b((String)localObject, localOptions);
          localObject = localBitmap;
          if (localBitmap != null)
          {
            QLog.d(QCircleFeedPicLoader.TAG, 1, QCircleFeedPicLoader.b.c(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b) + ", decode cost : " + (System.currentTimeMillis() - l) + " ,sampleSize:" + localOptions.inSampleSize + " origin:" + i + " " + j + "  request:" + this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.rX() + "  " + this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.rW() + " result:" + localBitmap.getWidth() + "  " + localBitmap.getHeight());
            localObject = localBitmap;
          }
        }
        while (this.mStatus != QCircleFeedPicLoader.STATE_CANCEL)
        {
          QCircleFeedPicLoader.a(QCircleFeedPicLoader.this, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.getCacheKey(), (Bitmap)localObject);
          if (localObject != null) {
            break label477;
          }
          if (this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c != null) {
            this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c.a(QCircleFeedPicLoader.bgl, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
          }
          QCircleFeedPicLoader.a(QCircleFeedPicLoader.this, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.ar());
          return;
          localOptions.inSampleSize = 1;
          localOptions.inJustDecodeBounds = false;
          localBitmap = b((String)localObject, localOptions);
          localObject = localBitmap;
          if (localBitmap != null)
          {
            QLog.d(QCircleFeedPicLoader.TAG, 1, QCircleFeedPicLoader.b.c(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b) + ",decode origin cost: " + (System.currentTimeMillis() - l));
            localObject = localBitmap;
          }
        }
      }
      label477:
      if (this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c != null) {
        this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c.a(QCircleFeedPicLoader.STATE_SUCCESS, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
      }
      QCircleFeedPicLoader.a(QCircleFeedPicLoader.this, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b, (Bitmap)localObject);
    }
  }
  
  public class PicDownLoadTask
    implements Runnable
  {
    public QCircleFeedPicLoader.b b;
    public QCircleFeedPicLoader.c b;
    protected volatile int mStatus;
    
    public PicDownLoadTask(@NotNull QCircleFeedPicLoader.b paramb)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b = paramb;
      this.mStatus = QCircleFeedPicLoader.STATE_PREPARE;
    }
    
    private void bhG()
    {
      aoll localaoll = new aoll();
      localaoll.f = new oul(this);
      localaoll.bZ = this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.getUrl();
      localaoll.mHttpMethod = 0;
      localaoll.atY = QCircleFeedPicLoader.b.d(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)localAppRuntime).getNetEngine(0).a(localaoll);
      }
    }
    
    public QCircleFeedPicLoader.b a()
    {
      return this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b;
    }
    
    public void a(QCircleFeedPicLoader.c paramc)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c = paramc;
    }
    
    public void cancel()
    {
      if (this.mStatus != QCircleFeedPicLoader.STATE_SUCCESS)
      {
        this.mStatus = QCircleFeedPicLoader.STATE_CANCEL;
        if (this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c != null) {
          this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c.a(QCircleFeedPicLoader.STATE_CANCEL, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
        }
      }
    }
    
    public void run()
    {
      if (this.mStatus == QCircleFeedPicLoader.STATE_CANCEL) {}
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
        QLog.d(QCircleFeedPicLoader.TAG, 1, QCircleFeedPicLoader.b.c(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b) + ", download start cost in queue: " + (l - QCircleFeedPicLoader.b.a(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b).longValue()));
        if (this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b != null)
        {
          this.mStatus = QCircleFeedPicLoader.bgh;
          if (this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c != null) {
            this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c.a(this.mStatus, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
          }
        }
        arxm localarxm = new arxm();
        localarxm.cCQ = this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.getLocalPath();
        localarxm.awL = 0L;
        localarxm.key = this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.getCacheKey();
        localarxm.url = this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.getUrl();
        if (!QCircleFeedPicLoader.a.a(localarxm)) {
          break;
        }
        QCircleFeedPicLoader.a(QCircleFeedPicLoader.this).remove(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.getCacheKey());
        if (this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c != null) {
          this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c.a(QCircleFeedPicLoader.bgi, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b);
        }
        QLog.d(QCircleFeedPicLoader.TAG, 1, QCircleFeedPicLoader.b.c(this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b) + ", download by ImageDownLoader success cost: " + (System.currentTimeMillis() - l));
      } while (!this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b.Hy());
      QCircleFeedPicLoader.a(QCircleFeedPicLoader.this, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$b, this.jdField_b_of_type_ComTencentBizQqcircleQCircleFeedPicLoader$c);
      return;
      bhG();
      QLog.d(QCircleFeedPicLoader.TAG, 1, "download failed use httpEngine cost: " + (System.currentTimeMillis() - l));
    }
  }
  
  public static class a
  {
    protected static String LOG_TAG = "ImageDownloader";
    protected static int bgm = 2048;
    protected static int bgn = 2097152;
    
    protected static long a(HttpURLConnection paramHttpURLConnection)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Cache-Control");
      if (paramHttpURLConnection == null) {
        return 0L;
      }
      paramHttpURLConnection = TextUtils.split(paramHttpURLConnection, ",");
      int i = 0;
      if (i < paramHttpURLConnection.length) {
        if (!paramHttpURLConnection[i].contains("max-age")) {}
      }
      for (long l = Long.parseLong(paramHttpURLConnection[i].trim().replace("max-age=", ""));; l = 0L)
      {
        return l;
        i += 1;
        break;
      }
    }
    
    protected static HttpURLConnection a(arxm paramarxm)
    {
      for (;;)
      {
        try
        {
          localObject1 = MsfSdkUtils.insertMtype("yingyongbao", paramarxm.url);
          if (arwo.cq(aroi.a().getContext()))
          {
            i = "http://".length();
            localObject3 = arwo.bF(aroi.a().getContext());
            String str = arwo.bG(aroi.a().getContext());
            j = ((String)localObject1).indexOf('/', i);
            if (j < 0)
            {
              localObject2 = ((String)localObject1).substring(i);
              localObject1 = "";
              arwt.d(LOG_TAG, "https://" + (String)localObject3 + ":" + str + (String)localObject1);
              localObject3 = (HttpURLConnection)new URL("https://" + (String)localObject3 + ":" + str + (String)localObject1).openConnection();
              localObject1 = localObject3;
            }
          }
        }
        catch (Exception paramarxm)
        {
          int j;
          Object localObject2;
          localObject3 = null;
          arwt.e(LOG_TAG, "--getHttpConnection-- Exception!!!", paramarxm);
          b((HttpURLConnection)localObject3);
          return null;
        }
        try
        {
          ((HttpURLConnection)localObject3).setRequestProperty("X-Online-Host", (String)localObject2);
          localObject1 = localObject3;
          localObject3 = localObject1;
        }
        catch (Exception paramarxm)
        {
          localObject3 = localObject1;
          continue;
        }
        try
        {
          ((HttpURLConnection)localObject1).setRequestMethod("GET");
          localObject3 = localObject1;
          ((HttpURLConnection)localObject1).setDoInput(true);
          localObject3 = localObject1;
          ((HttpURLConnection)localObject1).setAllowUserInteraction(true);
          localObject3 = localObject1;
          ((HttpURLConnection)localObject1).setConnectTimeout(60000);
          localObject3 = localObject1;
          ((HttpURLConnection)localObject1).setReadTimeout(120000);
          localObject3 = localObject1;
          if (paramarxm.awL > 0L)
          {
            localObject3 = localObject1;
            localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            localObject3 = localObject1;
            ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
            localObject3 = localObject1;
            ((HttpURLConnection)localObject1).setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject2).format(new Date(paramarxm.awL)));
          }
          localObject3 = localObject1;
          i = ((HttpURLConnection)localObject1).getResponseCode();
          localObject3 = localObject1;
          arwt.d(LOG_TAG, "--getHttpConnection-- reponseCode=" + i);
          if ((i == 302) || (i == 301))
          {
            localObject3 = localObject1;
            paramarxm = ((HttpURLConnection)localObject1).getHeaderField("Location");
            localObject3 = localObject1;
            arwt.d(LOG_TAG, "--getHttpConnection-- loc=" + paramarxm);
            localObject3 = localObject1;
            b((HttpURLConnection)localObject1);
            paramarxm = null;
            localObject1 = paramarxm;
            arwt.d(LOG_TAG, "--getHttpConnection-- uc=" + paramarxm);
            return paramarxm;
            localObject2 = ((String)localObject1).substring(i, j);
            localObject1 = ((String)localObject1).substring(j);
            continue;
            localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
            continue;
          }
          if ((i != 200) && (i != 206)) {
            continue;
          }
          localObject3 = localObject1;
          localObject2 = ((HttpURLConnection)localObject1).getContentType();
          if (localObject2 != null) {
            continue;
          }
          localObject2 = "";
          localObject3 = localObject1;
          if (((String)localObject2).indexOf("text/vnd.wap.wml") != -1) {
            break label743;
          }
          localObject3 = localObject1;
          if (((String)localObject2).indexOf("application/vnd.wap.wmlc") != -1) {
            break label743;
          }
          localObject3 = localObject1;
          if (((String)localObject2).indexOf("text") == -1) {
            break label748;
          }
        }
        catch (Exception paramarxm)
        {
          continue;
          i = 1;
          continue;
          i = 0;
          continue;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject3 = localObject1;
          b((HttpURLConnection)localObject1);
          localObject2 = null;
        }
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          paramarxm.awK = (a((HttpURLConnection)localObject2) * 1000L);
          localObject3 = localObject2;
          if (paramarxm.awK == 0L)
          {
            localObject3 = localObject2;
            paramarxm.awK = 86400000L;
          }
        }
        localObject3 = localObject2;
        paramarxm.updatetime = System.currentTimeMillis();
        paramarxm = (arxm)localObject2;
        continue;
        localObject3 = localObject1;
        localObject2 = ((String)localObject2).toLowerCase();
        continue;
        if (i == 304)
        {
          localObject3 = localObject1;
          arwt.d(LOG_TAG, "--getimg-- " + paramarxm.url + " not modified");
          localObject3 = localObject1;
          paramarxm.awK = (a((HttpURLConnection)localObject1) * 1000L);
          localObject3 = localObject1;
          paramarxm.updatetime = System.currentTimeMillis();
          localObject3 = localObject1;
          b((HttpURLConnection)localObject1);
          paramarxm = null;
        }
        else
        {
          localObject3 = localObject1;
          b((HttpURLConnection)localObject1);
          paramarxm = null;
        }
      }
    }
    
    /* Error */
    public static boolean a(arxm paramarxm)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 12
      //   3: aconst_null
      //   4: astore 11
      //   6: iconst_0
      //   7: istore 4
      //   9: aload_0
      //   10: invokestatic 286	com/tencent/biz/qqcircle/QCircleFeedPicLoader$a:a	(Larxm;)Ljava/net/HttpURLConnection;
      //   13: astore 7
      //   15: aload 7
      //   17: ifnonnull +88 -> 105
      //   20: getstatic 18	com/tencent/biz/qqcircle/QCircleFeedPicLoader$a:LOG_TAG	Ljava/lang/String;
      //   23: new 121	java/lang/StringBuilder
      //   26: dup
      //   27: invokespecial 124	java/lang/StringBuilder:<init>	()V
      //   30: ldc_w 288
      //   33: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   36: aload_0
      //   37: getfield 77	arxm:url	Ljava/lang/String;
      //   40: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: ldc_w 290
      //   46: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   52: invokestatic 141	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   55: iconst_0
      //   56: ifeq +11 -> 67
      //   59: new 292	java/lang/NullPointerException
      //   62: dup
      //   63: invokespecial 293	java/lang/NullPointerException:<init>	()V
      //   66: athrow
      //   67: iconst_0
      //   68: ifeq +11 -> 79
      //   71: new 292	java/lang/NullPointerException
      //   74: dup
      //   75: invokespecial 293	java/lang/NullPointerException:<init>	()V
      //   78: athrow
      //   79: iload 4
      //   81: istore_3
      //   82: aload 7
      //   84: ifnull +11 -> 95
      //   87: aload 7
      //   89: invokevirtual 296	java/net/HttpURLConnection:disconnect	()V
      //   92: iload 4
      //   94: istore_3
      //   95: iload_3
      //   96: ireturn
      //   97: astore_0
      //   98: aload_0
      //   99: invokevirtual 299	java/lang/Exception:printStackTrace	()V
      //   102: goto -23 -> 79
      //   105: aload 7
      //   107: invokevirtual 302	java/net/HttpURLConnection:getContentLength	()I
      //   110: i2l
      //   111: lstore 5
      //   113: invokestatic 307	arug:ib	()J
      //   116: lload 5
      //   118: lcmp
      //   119: ifge +85 -> 204
      //   122: getstatic 18	com/tencent/biz/qqcircle/QCircleFeedPicLoader$a:LOG_TAG	Ljava/lang/String;
      //   125: new 121	java/lang/StringBuilder
      //   128: dup
      //   129: invokespecial 124	java/lang/StringBuilder:<init>	()V
      //   132: ldc_w 288
      //   135: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   138: aload_0
      //   139: getfield 77	arxm:url	Ljava/lang/String;
      //   142: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   145: ldc_w 309
      //   148: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   151: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   154: invokestatic 141	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   157: iconst_0
      //   158: ifeq +11 -> 169
      //   161: new 292	java/lang/NullPointerException
      //   164: dup
      //   165: invokespecial 293	java/lang/NullPointerException:<init>	()V
      //   168: athrow
      //   169: iconst_0
      //   170: ifeq +11 -> 181
      //   173: new 292	java/lang/NullPointerException
      //   176: dup
      //   177: invokespecial 293	java/lang/NullPointerException:<init>	()V
      //   180: athrow
      //   181: iload 4
      //   183: istore_3
      //   184: aload 7
      //   186: ifnull -91 -> 95
      //   189: aload 7
      //   191: invokevirtual 296	java/net/HttpURLConnection:disconnect	()V
      //   194: iconst_0
      //   195: ireturn
      //   196: astore_0
      //   197: aload_0
      //   198: invokevirtual 299	java/lang/Exception:printStackTrace	()V
      //   201: goto -20 -> 181
      //   204: aload 7
      //   206: invokevirtual 313	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   209: astore 8
      //   211: lconst_0
      //   212: lstore 5
      //   214: getstatic 20	com/tencent/biz/qqcircle/QCircleFeedPicLoader$a:bgm	I
      //   217: newarray byte
      //   219: astore 9
      //   221: new 315	java/io/ByteArrayOutputStream
      //   224: dup
      //   225: invokespecial 316	java/io/ByteArrayOutputStream:<init>	()V
      //   228: astore 13
      //   230: aload 8
      //   232: aload 9
      //   234: iconst_0
      //   235: getstatic 20	com/tencent/biz/qqcircle/QCircleFeedPicLoader$a:bgm	I
      //   238: invokevirtual 322	java/io/InputStream:read	([BII)I
      //   241: istore_2
      //   242: iload_2
      //   243: ifle +79 -> 322
      //   246: getstatic 23	com/tencent/biz/qqcircle/QCircleFeedPicLoader$a:bgn	I
      //   249: istore_1
      //   250: lload 5
      //   252: iload_1
      //   253: i2l
      //   254: lcmp
      //   255: iflt +48 -> 303
      //   258: iconst_0
      //   259: ifeq +11 -> 270
      //   262: new 292	java/lang/NullPointerException
      //   265: dup
      //   266: invokespecial 293	java/lang/NullPointerException:<init>	()V
      //   269: athrow
      //   270: aload 8
      //   272: ifnull +8 -> 280
      //   275: aload 8
      //   277: invokevirtual 325	java/io/InputStream:close	()V
      //   280: iload 4
      //   282: istore_3
      //   283: aload 7
      //   285: ifnull -190 -> 95
      //   288: aload 7
      //   290: invokevirtual 296	java/net/HttpURLConnection:disconnect	()V
      //   293: iconst_0
      //   294: ireturn
      //   295: astore_0
      //   296: aload_0
      //   297: invokevirtual 299	java/lang/Exception:printStackTrace	()V
      //   300: goto -20 -> 280
      //   303: aload 13
      //   305: aload 9
      //   307: iconst_0
      //   308: iload_2
      //   309: invokevirtual 329	java/io/ByteArrayOutputStream:write	([BII)V
      //   312: lload 5
      //   314: iload_2
      //   315: i2l
      //   316: ladd
      //   317: lstore 5
      //   319: goto -89 -> 230
      //   322: aload_0
      //   323: getfield 332	arxm:cCQ	Ljava/lang/String;
      //   326: astore 14
      //   328: new 334	java/io/File
      //   331: dup
      //   332: new 121	java/lang/StringBuilder
      //   335: dup
      //   336: invokespecial 124	java/lang/StringBuilder:<init>	()V
      //   339: aload 14
      //   341: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   344: ldc_w 336
      //   347: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   350: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   353: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;)V
      //   356: astore 10
      //   358: aload 10
      //   360: invokevirtual 340	java/io/File:getParent	()Ljava/lang/String;
      //   363: ifnull +23 -> 386
      //   366: aload 10
      //   368: invokevirtual 344	java/io/File:getParentFile	()Ljava/io/File;
      //   371: invokevirtual 348	java/io/File:exists	()Z
      //   374: ifne +12 -> 386
      //   377: aload 10
      //   379: invokevirtual 344	java/io/File:getParentFile	()Ljava/io/File;
      //   382: invokevirtual 351	java/io/File:mkdirs	()Z
      //   385: pop
      //   386: aload 10
      //   388: invokevirtual 348	java/io/File:exists	()Z
      //   391: ifeq +9 -> 400
      //   394: aload 10
      //   396: invokevirtual 354	java/io/File:delete	()Z
      //   399: pop
      //   400: aload 10
      //   402: invokevirtual 357	java/io/File:createNewFile	()Z
      //   405: pop
      //   406: new 359	java/io/FileOutputStream
      //   409: dup
      //   410: new 121	java/lang/StringBuilder
      //   413: dup
      //   414: invokespecial 124	java/lang/StringBuilder:<init>	()V
      //   417: aload 14
      //   419: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   422: ldc_w 336
      //   425: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   428: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   431: invokespecial 360	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   434: astore 9
      //   436: aload 9
      //   438: aload 13
      //   440: invokevirtual 364	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   443: invokevirtual 367	java/io/FileOutputStream:write	([B)V
      //   446: aload 9
      //   448: invokevirtual 370	java/io/FileOutputStream:flush	()V
      //   451: new 334	java/io/File
      //   454: dup
      //   455: aload 14
      //   457: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;)V
      //   460: astore 12
      //   462: aload 12
      //   464: invokevirtual 348	java/io/File:exists	()Z
      //   467: ifeq +9 -> 476
      //   470: aload 12
      //   472: invokevirtual 354	java/io/File:delete	()Z
      //   475: pop
      //   476: aload 10
      //   478: aload 12
      //   480: invokevirtual 374	java/io/File:renameTo	(Ljava/io/File;)Z
      //   483: pop
      //   484: ldc_w 376
      //   487: aload_0
      //   488: getfield 379	arxm:key	Ljava/lang/String;
      //   491: invokestatic 141	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   494: aload_0
      //   495: aload 7
      //   497: invokevirtual 382	java/net/HttpURLConnection:getLastModified	()J
      //   500: putfield 180	arxm:awL	J
      //   503: iconst_1
      //   504: istore_3
      //   505: aload 9
      //   507: ifnull +8 -> 515
      //   510: aload 9
      //   512: invokevirtual 383	java/io/FileOutputStream:close	()V
      //   515: aload 8
      //   517: ifnull +8 -> 525
      //   520: aload 8
      //   522: invokevirtual 325	java/io/InputStream:close	()V
      //   525: aload 7
      //   527: ifnull -432 -> 95
      //   530: aload 7
      //   532: invokevirtual 296	java/net/HttpURLConnection:disconnect	()V
      //   535: iconst_1
      //   536: ireturn
      //   537: astore_0
      //   538: aload_0
      //   539: invokevirtual 299	java/lang/Exception:printStackTrace	()V
      //   542: goto -17 -> 525
      //   545: astore 9
      //   547: aconst_null
      //   548: astore 10
      //   550: aconst_null
      //   551: astore_0
      //   552: aconst_null
      //   553: astore 7
      //   555: aconst_null
      //   556: astore 8
      //   558: getstatic 18	com/tencent/biz/qqcircle/QCircleFeedPicLoader$a:LOG_TAG	Ljava/lang/String;
      //   561: ldc_w 385
      //   564: aload 9
      //   566: invokestatic 283	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   569: aload 10
      //   571: ifnull +17 -> 588
      //   574: aload 10
      //   576: invokevirtual 348	java/io/File:exists	()Z
      //   579: ifeq +9 -> 588
      //   582: aload 10
      //   584: invokevirtual 354	java/io/File:delete	()Z
      //   587: pop
      //   588: aload 11
      //   590: ifnull +17 -> 607
      //   593: aload 11
      //   595: invokevirtual 348	java/io/File:exists	()Z
      //   598: ifeq +9 -> 607
      //   601: aload 11
      //   603: invokevirtual 354	java/io/File:delete	()Z
      //   606: pop
      //   607: aload_0
      //   608: ifnull +7 -> 615
      //   611: aload_0
      //   612: invokevirtual 383	java/io/FileOutputStream:close	()V
      //   615: aload 7
      //   617: ifnull +8 -> 625
      //   620: aload 7
      //   622: invokevirtual 325	java/io/InputStream:close	()V
      //   625: iload 4
      //   627: istore_3
      //   628: aload 8
      //   630: ifnull -535 -> 95
      //   633: aload 8
      //   635: invokevirtual 296	java/net/HttpURLConnection:disconnect	()V
      //   638: iconst_0
      //   639: ireturn
      //   640: astore_0
      //   641: aload_0
      //   642: invokevirtual 299	java/lang/Exception:printStackTrace	()V
      //   645: goto -20 -> 625
      //   648: astore_0
      //   649: aconst_null
      //   650: astore 8
      //   652: aconst_null
      //   653: astore 7
      //   655: aload 12
      //   657: astore 9
      //   659: aload 9
      //   661: ifnull +8 -> 669
      //   664: aload 9
      //   666: invokevirtual 383	java/io/FileOutputStream:close	()V
      //   669: aload 8
      //   671: ifnull +8 -> 679
      //   674: aload 8
      //   676: invokevirtual 325	java/io/InputStream:close	()V
      //   679: aload 7
      //   681: ifnull +8 -> 689
      //   684: aload 7
      //   686: invokevirtual 296	java/net/HttpURLConnection:disconnect	()V
      //   689: aload_0
      //   690: athrow
      //   691: astore 8
      //   693: aload 8
      //   695: invokevirtual 299	java/lang/Exception:printStackTrace	()V
      //   698: goto -19 -> 679
      //   701: astore_0
      //   702: aconst_null
      //   703: astore 8
      //   705: aload 12
      //   707: astore 9
      //   709: goto -50 -> 659
      //   712: astore_0
      //   713: aload 12
      //   715: astore 9
      //   717: goto -58 -> 659
      //   720: astore_0
      //   721: goto -62 -> 659
      //   724: astore 11
      //   726: aload_0
      //   727: astore 9
      //   729: aload 8
      //   731: astore 10
      //   733: aload 11
      //   735: astore_0
      //   736: aload 7
      //   738: astore 8
      //   740: aload 10
      //   742: astore 7
      //   744: goto -85 -> 659
      //   747: astore 9
      //   749: aconst_null
      //   750: astore 10
      //   752: aconst_null
      //   753: astore_0
      //   754: aconst_null
      //   755: astore 12
      //   757: aload 7
      //   759: astore 8
      //   761: aload 12
      //   763: astore 7
      //   765: goto -207 -> 558
      //   768: astore 9
      //   770: aconst_null
      //   771: astore 10
      //   773: aconst_null
      //   774: astore_0
      //   775: aload 8
      //   777: astore 12
      //   779: aload 7
      //   781: astore 8
      //   783: aload 12
      //   785: astore 7
      //   787: goto -229 -> 558
      //   790: astore 9
      //   792: aload 8
      //   794: astore 12
      //   796: aconst_null
      //   797: astore_0
      //   798: aload 7
      //   800: astore 8
      //   802: aload 12
      //   804: astore 7
      //   806: goto -248 -> 558
      //   809: astore 13
      //   811: aload 9
      //   813: astore_0
      //   814: aload 7
      //   816: astore 12
      //   818: aload 13
      //   820: astore 9
      //   822: aload 8
      //   824: astore 7
      //   826: aload 12
      //   828: astore 8
      //   830: goto -272 -> 558
      //   833: astore 13
      //   835: aload 12
      //   837: astore 11
      //   839: aload 9
      //   841: astore_0
      //   842: aload 7
      //   844: astore 12
      //   846: aload 13
      //   848: astore 9
      //   850: aload 8
      //   852: astore 7
      //   854: aload 12
      //   856: astore 8
      //   858: goto -300 -> 558
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	861	0	paramarxm	arxm
      //   249	4	1	i	int
      //   241	74	2	j	int
      //   81	547	3	bool1	boolean
      //   7	619	4	bool2	boolean
      //   111	207	5	l	long
      //   13	840	7	localObject1	Object
      //   209	466	8	localInputStream	java.io.InputStream
      //   691	3	8	localException1	Exception
      //   703	154	8	localObject2	Object
      //   219	292	9	localObject3	Object
      //   545	20	9	localException2	Exception
      //   657	71	9	localObject4	Object
      //   747	1	9	localException3	Exception
      //   768	1	9	localException4	Exception
      //   790	22	9	localException5	Exception
      //   820	29	9	localObject5	Object
      //   356	416	10	localObject6	Object
      //   4	598	11	localObject7	Object
      //   724	10	11	localObject8	Object
      //   837	1	11	localObject9	Object
      //   1	854	12	localObject10	Object
      //   228	211	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      //   809	10	13	localException6	Exception
      //   833	14	13	localException7	Exception
      //   326	130	14	str	String
      // Exception table:
      //   from	to	target	type
      //   59	67	97	java/lang/Exception
      //   71	79	97	java/lang/Exception
      //   161	169	196	java/lang/Exception
      //   173	181	196	java/lang/Exception
      //   262	270	295	java/lang/Exception
      //   275	280	295	java/lang/Exception
      //   510	515	537	java/lang/Exception
      //   520	525	537	java/lang/Exception
      //   9	15	545	java/lang/Exception
      //   611	615	640	java/lang/Exception
      //   620	625	640	java/lang/Exception
      //   9	15	648	finally
      //   664	669	691	java/lang/Exception
      //   674	679	691	java/lang/Exception
      //   20	55	701	finally
      //   105	157	701	finally
      //   204	211	701	finally
      //   214	230	712	finally
      //   230	242	712	finally
      //   246	250	712	finally
      //   303	312	712	finally
      //   322	358	712	finally
      //   358	386	712	finally
      //   386	400	712	finally
      //   400	436	712	finally
      //   436	462	720	finally
      //   462	476	720	finally
      //   476	503	720	finally
      //   558	569	724	finally
      //   574	588	724	finally
      //   593	607	724	finally
      //   20	55	747	java/lang/Exception
      //   105	157	747	java/lang/Exception
      //   204	211	747	java/lang/Exception
      //   214	230	768	java/lang/Exception
      //   230	242	768	java/lang/Exception
      //   246	250	768	java/lang/Exception
      //   303	312	768	java/lang/Exception
      //   322	358	768	java/lang/Exception
      //   358	386	790	java/lang/Exception
      //   386	400	790	java/lang/Exception
      //   400	436	790	java/lang/Exception
      //   436	462	809	java/lang/Exception
      //   462	476	833	java/lang/Exception
      //   476	503	833	java/lang/Exception
    }
    
    protected static void b(HttpURLConnection paramHttpURLConnection)
    {
      if (paramHttpURLConnection != null) {}
      try
      {
        paramHttpURLConnection.disconnect();
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        arwt.e("", "", paramHttpURLConnection);
      }
    }
  }
  
  public static class b
  {
    public static int PRIORITY_DEFAULT;
    public static int bgo = 1;
    private Long H;
    private Long I;
    private Long J;
    private boolean ayB;
    private boolean ayC = true;
    private String dQ;
    private ImageView lG;
    private Drawable mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844853);
    private Drawable mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130847483);
    private int mPriority = PRIORITY_DEFAULT;
    private int mRequestHeight;
    private int mRequestWidth;
    private String mUrl;
    private String uP;
    
    public boolean Hy()
    {
      return this.ayC;
    }
    
    public boolean Hz()
    {
      return this.ayB;
    }
    
    public b a(int paramInt)
    {
      this.mRequestHeight = paramInt;
      return this;
    }
    
    public b a(Drawable paramDrawable)
    {
      this.mLoadingDrawable = paramDrawable;
      return this;
    }
    
    public b a(ImageView paramImageView)
    {
      this.lG = paramImageView;
      if (!TextUtils.isEmpty(this.mUrl)) {
        paramImageView.setTag(2131374559, this.mUrl);
      }
      return this;
    }
    
    public b a(String paramString)
    {
      this.mUrl = paramString;
      if (this.lG != null) {
        this.lG.setTag(2131374559, this.mUrl);
      }
      return this;
    }
    
    public b a(boolean paramBoolean)
    {
      this.ayC = paramBoolean;
      return this;
    }
    
    public Drawable am()
    {
      return this.mLoadingDrawable;
    }
    
    public Drawable ar()
    {
      return this.mFailedDrawable;
    }
    
    public b b(int paramInt)
    {
      this.mRequestWidth = paramInt;
      return this;
    }
    
    public b b(String paramString)
    {
      this.uP = paramString;
      return this;
    }
    
    public b b(boolean paramBoolean)
    {
      this.ayB = paramBoolean;
      return this;
    }
    
    public b c(int paramInt)
    {
      this.mPriority = paramInt;
      return this;
    }
    
    public b c(String paramString)
    {
      this.dQ = paramString;
      return this;
    }
    
    public String getCacheKey()
    {
      return this.uP;
    }
    
    public String getLocalPath()
    {
      return this.dQ;
    }
    
    public int getPriority()
    {
      return this.mPriority;
    }
    
    public String getUrl()
    {
      return this.mUrl;
    }
    
    public boolean isValid()
    {
      if ((this.lG != null) && ((this.lG.getTag(2131374559) instanceof String))) {
        return this.lG.getTag(2131374559).equals(this.mUrl);
      }
      return false;
    }
    
    public ImageView j()
    {
      return this.lG;
    }
    
    public int rW()
    {
      return this.mRequestHeight;
    }
    
    public int rX()
    {
      return this.mRequestWidth;
    }
  }
  
  public static class c
  {
    public void a(int paramInt, QCircleFeedPicLoader.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleFeedPicLoader
 * JD-Core Version:    0.7.0.1
 */