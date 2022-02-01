import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class aduk
{
  protected HashSet<String> aZ = new HashSet();
  private byte bg = 3;
  protected Handler by = new adun(this, ThreadManager.getSubThreadLooper());
  protected int cnW;
  public Bitmap du;
  protected Context mContext;
  protected float mDensity = 1.0F;
  protected Handler mUIHandler = new adum(this, Looper.getMainLooper());
  protected LruCache<String, Bitmap> p = new LruCache(60);
  protected LruCache<String, String> q = new LruCache(120);
  protected ArrayList<String> uL = new ArrayList();
  private BroadcastReceiver w = new adul(this);
  final List<aduk.a> yr = Collections.synchronizedList(new ArrayList());
  
  public aduk(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
    this.cnW = paramInt;
    try
    {
      this.du = aqhu.G();
      return;
    }
    catch (OutOfMemoryError paramContext) {}
  }
  
  protected Bitmap B(Bitmap paramBitmap)
  {
    float f2 = this.mDensity;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < 50 * f2) {
        f1 = i / 50;
      }
    }
    i = (int)(50 * f1);
    int j = (int)(f1 * 50);
    return aqhu.b(paramBitmap, i, i, j);
  }
  
  public void LB(int paramInt)
  {
    this.cnW = paramInt;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    try
    {
      localObject = (Bitmap)this.p.get(paramString);
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("NonMainAppHeadLoader", 2, "getFaceBitmap, hit cache:" + paramString);
          return localObject;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppHeadLoader", 2, "getFaceBitmap, not in cache:" + paramString);
        }
        if (!TextUtils.isEmpty((CharSequence)this.q.get(paramString)))
        {
          localObject = new ArrayList(1);
          Message localMessage = Message.obtain();
          ((ArrayList)localObject).add(paramString);
          localMessage.obj = localObject;
          localMessage.what = 1001;
          this.by.sendMessage(localMessage);
        }
        else if ((paramBoolean) && (!this.uL.contains(paramString)))
        {
          this.uL.add(paramString);
          this.mUIHandler.removeMessages(1000);
          this.mUIHandler.sendEmptyMessageDelayed(1000, 50L);
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.e("NonMainAppHeadLoader", 2, "getFaceBitmap, exception:" + paramString.toString());
        return paramBitmap;
        return localObject;
      }
    }
    return paramBitmap;
  }
  
  public void a(aduk.a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.yr)
    {
      if (!this.yr.contains(parama)) {
        this.yr.add(parama);
      }
      return;
    }
  }
  
  public void b(aduk.a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.yr)
    {
      this.yr.remove(parama);
      return;
    }
  }
  
  protected void dX(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "sendQQHeadRequest, reqSize:" + this.aZ.size() + " cacheSize:" + this.p.size() + " " + this.q.size());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!this.aZ.contains(str)) {
        localArrayList.add(str);
      }
    }
    paramArrayList = new Intent("com.tencent.qqhead.getheadreq");
    paramArrayList.setPackage(this.mContext.getPackageName());
    paramArrayList.putExtra("faceType", this.cnW);
    paramArrayList.putStringArrayListExtra("uinList", localArrayList);
    this.mContext.sendBroadcast(paramArrayList, "com.tencent.tim.qqhead.permission.getheadresp");
    this.aZ.addAll(localArrayList);
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 162
    //   8: iconst_2
    //   9: ldc_w 313
    //   12: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 106	aduk:mContext	Landroid/content/Context;
    //   19: aload_0
    //   20: getfield 79	aduk:w	Landroid/content/BroadcastReceiver;
    //   23: invokevirtual 317	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   26: aload_0
    //   27: getfield 70	aduk:yr	Ljava/util/List;
    //   30: astore_1
    //   31: aload_1
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 70	aduk:yr	Ljava/util/List;
    //   37: invokeinterface 320 1 0
    //   42: aload_1
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 57	aduk:aZ	Ljava/util/HashSet;
    //   48: invokevirtual 321	java/util/HashSet:clear	()V
    //   51: aload_0
    //   52: getfield 92	aduk:mUIHandler	Landroid/os/Handler;
    //   55: aconst_null
    //   56: invokevirtual 325	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 102	aduk:by	Landroid/os/Handler;
    //   63: aconst_null
    //   64: invokevirtual 325	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   67: aload_0
    //   68: getfield 52	aduk:q	Landroid/support/v4/util/LruCache;
    //   71: invokevirtual 328	android/support/v4/util/LruCache:evictAll	()V
    //   74: aload_0
    //   75: getfield 50	aduk:p	Landroid/support/v4/util/LruCache;
    //   78: invokevirtual 328	android/support/v4/util/LruCache:evictAll	()V
    //   81: return
    //   82: astore_1
    //   83: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq -60 -> 26
    //   89: ldc 162
    //   91: iconst_2
    //   92: new 164	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 330
    //   102: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 331	java/lang/Throwable:toString	()Ljava/lang/String;
    //   109: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: goto -92 -> 26
    //   121: astore_2
    //   122: aload_1
    //   123: monitorexit
    //   124: aload_2
    //   125: athrow
    //   126: astore_1
    //   127: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq -49 -> 81
    //   133: ldc 162
    //   135: iconst_2
    //   136: new 164	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 330
    //   146: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 228	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	aduk
    //   82	41	1	localThrowable	Throwable
    //   126	24	1	localException	Exception
    //   121	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	26	82	java/lang/Throwable
    //   33	44	121	finally
    //   122	124	121	finally
    //   26	33	126	java/lang/Exception
    //   44	81	126	java/lang/Exception
    //   124	126	126	java/lang/Exception
  }
  
  public Bitmap getFaceBitmap(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, this.du);
  }
  
  public void init()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    try
    {
      this.mContext.registerReceiver(this.w, localIntentFilter, "com.tencent.tim.qqhead.permission.getheadresp", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("NonMainAppHeadLoader", 1, "init register receiver fail!");
    }
  }
  
  public void j(byte paramByte)
  {
    this.bg = paramByte;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString1, String paramString2, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aduk
 * JD-Core Version:    0.7.0.1
 */