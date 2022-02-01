package com.tencent.mobileqq.danmaku.core;

import aewr;
import aewt;
import aewv;
import aeww;
import aewx;
import aewz;
import aexa;
import aexb;
import aexc;
import aexd;
import aexe;
import aexj;
import aexy;
import aeya;
import aeye;
import aeye.a;
import aeyf;
import aeyj;
import aeyk;
import aeyp;
import aeyr;
import aeyt;
import aeyu;
import aeyv;
import aeyw;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class DanmakuManager
  implements aeye.a, View.OnTouchListener
{
  private static final DecimalFormat h = new DecimalFormat("00.00");
  private static final DecimalFormat i = new DecimalFormat("00");
  private HandlerThread M;
  private long VC;
  private long WV;
  private long WW;
  private long WX;
  private long WY;
  private final aewv jdField_a_of_type_Aewv;
  private final aeww jdField_a_of_type_Aeww;
  private final aewz jdField_a_of_type_Aewz;
  private final aexc jdField_a_of_type_Aexc;
  private aexj jdField_a_of_type_Aexj;
  private final aeye jdField_a_of_type_Aeye;
  private final aeyk jdField_a_of_type_Aeyk;
  private final aeyp jdField_a_of_type_Aeyp;
  private a jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$a = new a(this, null);
  private volatile b jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$b;
  private final aewx b;
  private String bCu;
  private boolean bWQ;
  private volatile boolean bWR = true;
  private int cPA;
  private int cPz;
  private long mBaseTime;
  private int mDrawCount;
  private Handler mDrawHandler;
  private volatile boolean mIsPlaying;
  private volatile boolean mIsQuited;
  private volatile boolean mIsSurfaceCreated;
  private long mPausedTime;
  private final List<aexe> mToDeleteDanmakus = new LinkedList();
  private final Queue<aeyr> mTouchPoints = new LinkedBlockingDeque();
  
  public DanmakuManager(View paramView, aexj paramaexj)
  {
    this.jdField_a_of_type_Aexj = paramaexj;
    this.jdField_a_of_type_Aeye = aeya.a(paramView);
    if (this.jdField_a_of_type_Aeye != null)
    {
      this.jdField_a_of_type_Aeye.a(this);
      this.jdField_a_of_type_Aeye.setOnTouchListener(this);
    }
    this.jdField_a_of_type_Aeyp = new aeyp();
    this.jdField_a_of_type_Aeyk = new aeyk();
    this.jdField_a_of_type_Aeww = new aeww();
    this.jdField_a_of_type_Aexc = new aexc(paramaexj);
    paramView = new DanmakuComparator();
    this.b = new aewx(this.jdField_a_of_type_Aeyp, paramView);
    this.jdField_a_of_type_Aewv = aewv.a(paramaexj, this.jdField_a_of_type_Aeww, paramView, this.jdField_a_of_type_Aeyp, this.jdField_a_of_type_Aeyk);
    this.jdField_a_of_type_Aewz = new aewz(paramaexj);
  }
  
  private boolean a(aeyj paramaeyj)
  {
    return (aiv()) && (paramaeyj.cPF != -1);
  }
  
  private void aR(Canvas paramCanvas)
  {
    StringBuilder localStringBuilder;
    long l1;
    if (this.jdField_a_of_type_Aexj.isDebug())
    {
      long l2 = getCurrentTime();
      long l3 = l2 - this.WV;
      this.mDrawCount += 1;
      this.cPA = ((int)(this.cPA + l3));
      if (l3 > 16L)
      {
        this.cPz += 1;
        if (aeyw.LOG_LEVEL >= 5) {
          aeyw.w("DanmakuManager", "a draw block:" + l3);
        }
      }
      localObject = this.b.a();
      if (this.mDrawCount % 60 == 1)
      {
        localStringBuilder = new StringBuilder().append(aeyw.LOG_LEVEL).append(",t:").append(aeyu.bo(getCurrentTime())).append(",f:");
        if (this.jdField_a_of_type_Aeyk.be() != 0L) {
          break label472;
        }
        l1 = 1L;
        localStringBuilder = localStringBuilder.append(1000L / l1).append(",ds:").append(this.jdField_a_of_type_Aewv.CE()).append(",ts:").append(this.b.CI()).append(",mt:").append(i.format(this.WW - this.WV)).append(",lt:").append(i.format(this.VC - this.WW)).append(",dt:").append(i.format(l2 - this.VC)).append(",tt:").append(i.format(l3)).append(",jp:").append(h.format(this.cPz * 100.0F / this.mDrawCount)).append("%,at:").append(h.format(this.cPA / this.mDrawCount)).append(",fd:");
        if (localObject != null) {
          break label483;
        }
      }
    }
    label472:
    label483:
    for (Object localObject = "null";; localObject = aeyu.bo(((aexe)localObject).getTime()))
    {
      this.bCu = ((String)localObject + ",cs:" + h.format(this.jdField_a_of_type_Aeww.CF() / 1024.0F / 1024.0F) + ",uc:" + h.format(this.jdField_a_of_type_Aeww.CG() * 100.0F / this.jdField_a_of_type_Aeww.CH()));
      if (this.bCu != null) {
        aeyv.a(paramCanvas, this.bCu);
      }
      return;
      l1 = this.jdField_a_of_type_Aeyk.be();
      break;
    }
  }
  
  private void acg()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Canvas localCanvas = this.jdField_a_of_type_Aeye.lockCanvas();
      StringBuilder localStringBuilder;
      Object localObject4;
      if (localCanvas != null)
      {
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        aeyv.clearCanvas(localCanvas);
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        localStringBuilder = new StringBuilder().append("clearDrawing lockCanvas ");
        if (localCanvas != null) {
          break label154;
        }
        localObject4 = "null";
      }
      for (;;)
      {
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        aeyw.i("surface_lock", localObject4);
        if (localCanvas != null) {}
        try
        {
          this.jdField_a_of_type_Aeye.unlockCanvasAndPost(localCanvas);
          aeyw.i("surface_lock", "clearDrawing unlockCanvas " + localCanvas.hashCode());
          aewr.a().a().getHandler().post(new DanmakuManager.2(this));
          return;
          label154:
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          int j = localCanvas.hashCode();
          localObject4 = Integer.valueOf(j);
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (localCanvas != null) {
              aeyw.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localCanvas.hashCode(), localThrowable1);
            }
          }
        }
      }
      try
      {
        this.jdField_a_of_type_Aeye.unlockCanvasAndPost(localThrowable2);
        aeyw.i("surface_lock", "clearDrawing unlockCanvas " + localThrowable2.hashCode());
        aewr.a().a().getHandler().post(new DanmakuManager.2(this));
        throw localObject2;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          if (localThrowable2 != null) {
            aeyw.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable2.hashCode(), localThrowable4);
          }
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      if (localThrowable1 != null)
      {
        localObject3 = localThrowable1;
        aeyw.e("surface_lock", "clearDrawing lockCanvas exception: " + localThrowable1.hashCode(), localThrowable3);
      }
      if (localThrowable1 != null) {}
      try
      {
        this.jdField_a_of_type_Aeye.unlockCanvasAndPost(localThrowable1);
        aeyw.i("surface_lock", "clearDrawing unlockCanvas " + localThrowable1.hashCode());
        aewr.a().a().getHandler().post(new DanmakuManager.2(this));
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (localThrowable1 != null) {
            aeyw.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable1.hashCode(), localThrowable2);
          }
        }
      }
    }
    finally
    {
      if (localThrowable2 == null) {}
    }
  }
  
  private boolean ait()
  {
    return (this.M != null) && (this.M.isAlive());
  }
  
  private boolean aiu()
  {
    return this.jdField_a_of_type_Aeye instanceof aeyf;
  }
  
  private boolean aiw()
  {
    if (aiu()) {
      if ((!ait()) || (this.mDrawHandler == null)) {}
    }
    while (this.mDrawHandler != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private void cXB()
  {
    if (this.M != null)
    {
      if (aeyu.aiE()) {
        this.M.quitSafely();
      }
    }
    else {
      return;
    }
    this.M.quit();
  }
  
  private void cXF()
  {
    if (aiu())
    {
      if (!ait()) {}
      try
      {
        this.M = new HandlerThread("DanmakuDrawThreadPriority_" + this.jdField_a_of_type_Aexj.CN(), this.jdField_a_of_type_Aexj.CN());
        this.M.setUncaughtExceptionHandler(new aeyt());
        this.M.start();
        this.mDrawHandler = new Handler(this.M.getLooper(), this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$a);
        return;
      }
      catch (Throwable localThrowable)
      {
        aeyw.e("DanmakuManager", new Object[] { localThrowable });
        return;
      }
    }
    this.mDrawHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$a);
  }
  
  private void cXH()
  {
    updateTime();
    if (this.bWQ)
    {
      this.jdField_a_of_type_Aewv.acg();
      this.bWQ = false;
    }
    try
    {
      if (aeyw.LOG_LEVEL >= 4) {
        this.WV = getCurrentTime();
      }
      cXI();
      if (aeyw.LOG_LEVEL >= 4) {
        this.WW = getCurrentTime();
      }
      layout();
      if (aeyw.LOG_LEVEL >= 4) {
        this.VC = getCurrentTime();
      }
      draw();
      cXJ();
      return;
    }
    catch (Throwable localThrowable)
    {
      aeyw.e("DanmakuManager", localThrowable.toString(), localThrowable);
    }
  }
  
  private void cXI()
  {
    Object localObject = this.b.getDrawingDanmakuList();
    if (aeyw.LOG_LEVEL >= 4)
    {
      int j = ((List)localObject).size();
      if (j > 0) {
        aeyw.d("DanmakuManager", new Object[] { "new danmaku to draw:", Integer.valueOf(j) });
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aexe localaexe = (aexe)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      if (localaexe.isTimeOut(this.jdField_a_of_type_Aeyp.get()))
      {
        if (aeyw.LOG_LEVEL >= 4) {
          aeyw.i("DanmakuManager", new Object[] { "before measure ", localaexe, " is out side" });
        }
        this.mToDeleteDanmakus.add(localaexe);
      }
      else
      {
        if ((aeyw.LOG_LEVEL >= 4) && (localaexe.aiz())) {
          aeyw.d("DanmakuManager", "must show danmaku upload to Windown :" + localaexe);
        }
        aeyw.i("DanmakuManager", "upload, danmaku = " + localaexe);
        localaexe.ja(this.jdField_a_of_type_Aeyk.getTime());
        this.jdField_a_of_type_Aewv.a(localaexe);
      }
    }
  }
  
  private void cXJ()
  {
    this.mToDeleteDanmakus.addAll(this.jdField_a_of_type_Aewv.ev());
    this.jdField_a_of_type_Aewv.ach();
    Iterator localIterator = this.mToDeleteDanmakus.iterator();
    while (localIterator.hasNext())
    {
      aexe localaexe = (aexe)localIterator.next();
      Bitmap localBitmap = localaexe.getDrawCache();
      if (localBitmap != null)
      {
        localaexe.setDrawCache(null);
        localaexe.clearDrawCacheCanvas();
        this.jdField_a_of_type_Aeww.f(localBitmap);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$b.jK(this.mToDeleteDanmakus);
    }
    jK(this.mToDeleteDanmakus);
    this.mToDeleteDanmakus.clear();
  }
  
  private void cXK()
  {
    if (this.jdField_a_of_type_Aexj != null)
    {
      Object localObject = this.jdField_a_of_type_Aexj.ew();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((aexy)((Iterator)localObject).next()).destroy();
        }
      }
    }
  }
  
  private void cXO()
  {
    aeyw.i("surface_lock", "handleClearDrawingCache");
    removeUpdateMessage();
    try
    {
      if (!this.mIsSurfaceCreated) {
        return;
      }
      acg();
      return;
    }
    finally {}
  }
  
  private void cXP()
  {
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  /* Error */
  private void draw()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 107	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aeye	Laeye;
    //   8: invokeinterface 326 1 0
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +48 -> 65
    //   20: aload 4
    //   22: astore_2
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokestatic 329	aeyv:clearCanvas	(Landroid/graphics/Canvas;)V
    //   31: aload 4
    //   33: astore_2
    //   34: aload 4
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 153	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aewv	Laewv;
    //   41: aload 4
    //   43: aload_0
    //   44: getfield 121	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aeyp	Laeyp;
    //   47: invokevirtual 510	aeyp:get	()J
    //   50: invokevirtual 599	aewv:c	(Landroid/graphics/Canvas;J)V
    //   53: aload 4
    //   55: astore_2
    //   56: aload 4
    //   58: astore_3
    //   59: aload_0
    //   60: aload 4
    //   62: invokespecial 601	com/tencent/mobileqq/danmaku/core/DanmakuManager:aR	(Landroid/graphics/Canvas;)V
    //   65: aload 4
    //   67: ifnull +298 -> 365
    //   70: aload_0
    //   71: monitorenter
    //   72: aload_0
    //   73: getfield 590	com/tencent/mobileqq/danmaku/core/DanmakuManager:mIsSurfaceCreated	Z
    //   76: ifeq +17 -> 93
    //   79: aload_0
    //   80: getfield 107	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aeye	Laeye;
    //   83: aload 4
    //   85: invokeinterface 341 2 0
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: aload_0
    //   94: getfield 107	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aeye	Laeye;
    //   97: invokeinterface 604 1 0
    //   102: goto -12 -> 90
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: ldc_w 333
    //   114: new 216	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 606
    //   124: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 4
    //   129: invokevirtual 346	java/lang/Object:hashCode	()I
    //   132: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aload_2
    //   139: invokestatic 382	aeyw:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   142: return
    //   143: astore 5
    //   145: aload_2
    //   146: astore_3
    //   147: new 216	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 608
    //   157: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: astore 6
    //   162: aload_2
    //   163: ifnonnull +91 -> 254
    //   166: ldc_w 293
    //   169: astore 4
    //   171: aload_2
    //   172: astore_3
    //   173: ldc_w 333
    //   176: aload 6
    //   178: aload 4
    //   180: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: aload 5
    //   188: invokestatic 382	aeyw:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_2
    //   192: ifnull +173 -> 365
    //   195: aload_0
    //   196: monitorenter
    //   197: aload_0
    //   198: getfield 590	com/tencent/mobileqq/danmaku/core/DanmakuManager:mIsSurfaceCreated	Z
    //   201: ifeq +69 -> 270
    //   204: aload_0
    //   205: getfield 107	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aeye	Laeye;
    //   208: aload_2
    //   209: invokeinterface 341 2 0
    //   214: aload_0
    //   215: monitorexit
    //   216: return
    //   217: astore_3
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_3
    //   221: athrow
    //   222: astore_3
    //   223: ldc_w 333
    //   226: new 216	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 606
    //   236: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 346	java/lang/Object:hashCode	()I
    //   243: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: aload_3
    //   250: invokestatic 382	aeyw:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: return
    //   254: aload_2
    //   255: astore_3
    //   256: aload_2
    //   257: invokevirtual 346	java/lang/Object:hashCode	()I
    //   260: istore_1
    //   261: iload_1
    //   262: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: astore 4
    //   267: goto -96 -> 171
    //   270: aload_0
    //   271: getfield 107	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aeye	Laeye;
    //   274: invokeinterface 604 1 0
    //   279: goto -65 -> 214
    //   282: astore_2
    //   283: aload_3
    //   284: ifnull +24 -> 308
    //   287: aload_0
    //   288: monitorenter
    //   289: aload_0
    //   290: getfield 590	com/tencent/mobileqq/danmaku/core/DanmakuManager:mIsSurfaceCreated	Z
    //   293: ifeq +17 -> 310
    //   296: aload_0
    //   297: getfield 107	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aeye	Laeye;
    //   300: aload_3
    //   301: invokeinterface 341 2 0
    //   306: aload_0
    //   307: monitorexit
    //   308: aload_2
    //   309: athrow
    //   310: aload_0
    //   311: getfield 107	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aeye	Laeye;
    //   314: invokeinterface 604 1 0
    //   319: goto -13 -> 306
    //   322: astore 4
    //   324: aload_0
    //   325: monitorexit
    //   326: aload 4
    //   328: athrow
    //   329: astore 4
    //   331: ldc_w 333
    //   334: new 216	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 606
    //   344: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_3
    //   348: invokevirtual 346	java/lang/Object:hashCode	()I
    //   351: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload 4
    //   359: invokestatic 382	aeyw:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   362: goto -54 -> 308
    //   365: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	DanmakuManager
    //   260	2	1	j	int
    //   3	53	2	localObject1	Object
    //   105	4	2	localObject2	Object
    //   110	147	2	localThrowable1	Throwable
    //   282	27	2	localObject3	Object
    //   1	172	3	localObject4	Object
    //   217	4	3	localObject5	Object
    //   222	28	3	localThrowable2	Throwable
    //   255	93	3	localObject6	Object
    //   13	253	4	localObject7	Object
    //   322	5	4	localObject8	Object
    //   329	29	4	localThrowable3	Throwable
    //   143	44	5	localThrowable4	Throwable
    //   160	17	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   72	90	105	finally
    //   90	92	105	finally
    //   93	102	105	finally
    //   106	108	105	finally
    //   70	72	110	java/lang/Throwable
    //   108	110	110	java/lang/Throwable
    //   4	15	143	java/lang/Throwable
    //   26	31	143	java/lang/Throwable
    //   37	53	143	java/lang/Throwable
    //   59	65	143	java/lang/Throwable
    //   197	214	217	finally
    //   214	216	217	finally
    //   218	220	217	finally
    //   270	279	217	finally
    //   195	197	222	java/lang/Throwable
    //   220	222	222	java/lang/Throwable
    //   4	15	282	finally
    //   26	31	282	finally
    //   37	53	282	finally
    //   59	65	282	finally
    //   147	162	282	finally
    //   173	191	282	finally
    //   256	261	282	finally
    //   289	306	322	finally
    //   306	308	322	finally
    //   310	319	322	finally
    //   324	326	322	finally
    //   287	289	329	java/lang/Throwable
    //   326	329	329	java/lang/Throwable
  }
  
  private void handelUpdate()
  {
    aeyw.v("DanmakuManager", "handelUpdate()");
    removeUpdateMessage();
    if (isPrepared())
    {
      long l = getCurrentTime();
      cXH();
      sendMessageDelayed(4, l + 16L - getCurrentTime());
    }
  }
  
  private void handleClear()
  {
    aeyw.i("DanmakuManager", "handleClear()");
    this.jdField_a_of_type_Aewv.acg();
    this.jdField_a_of_type_Aexj.clear();
    this.b.clear();
  }
  
  private void handleClick()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$b != null) {
      while (!this.mTouchPoints.isEmpty())
      {
        aeyr localaeyr = (aeyr)this.mTouchPoints.poll();
        aexe localaexe = this.jdField_a_of_type_Aewv.a(localaeyr);
        if (aeyw.LOG_LEVEL >= 4) {
          aeyw.v("DanmakuManager", new Object[] { "handleClick:", localaeyr, ",currentTime:", Long.valueOf(getCurrentTime()) });
        }
        aewr.a().a().getHandler().post(new DanmakuManager.1(this, localaexe, localaeyr));
      }
    }
    aeyw.v("DanmakuManager", "message click");
  }
  
  private void handleConfigChanged()
  {
    aeyw.i("DanmakuManager", "handleConfigChanged()");
    this.jdField_a_of_type_Aewv.Bi();
    this.b.cXC();
    aeyw.i("DanmakuManager", "message config changed");
  }
  
  private void handlePause()
  {
    aeyw.i("DanmakuManager", "handlePause()");
    removeUpdateMessage();
    this.mIsPlaying = false;
    if (this.jdField_a_of_type_Aexj.isLive()) {}
    for (long l = this.jdField_a_of_type_Aeyp.get();; l = this.jdField_a_of_type_Aeyk.getTime())
    {
      this.mPausedTime = l;
      if (aeyw.LOG_LEVEL >= 5) {
        aeyw.v("DanmakuManager", new Object[] { "message pause:mPausedTime:", Long.valueOf(this.mPausedTime) });
      }
      return;
    }
  }
  
  private void handleQuit()
  {
    aeyw.i("DanmakuManager", "handleQuit()");
    this.mIsQuited = true;
    this.jdField_a_of_type_Aexj.clear();
    this.b.clear();
    this.jdField_a_of_type_Aeww.clear();
    aeyw.i("DanmakuManager", "message quit");
  }
  
  private void handleRelease()
  {
    aeyw.i("DanmakuManager", "handleRelease()");
    cXB();
    this.jdField_a_of_type_Aexc.cXQ();
    this.jdField_a_of_type_Aeww.cXB();
    cXK();
  }
  
  private void handleResume()
  {
    aeyw.i("DanmakuManager", "handleResume()");
    if (!this.mIsPlaying)
    {
      long l = getCurrentTime();
      this.mBaseTime = (l - this.mPausedTime);
      if (aeyw.LOG_LEVEL >= 5) {
        aeyw.d("DanmakuManager", "handleResume, mBaseTime = " + this.mBaseTime + ", currentTime = " + l + ", mPauseTime = " + this.mPausedTime);
      }
      this.jdField_a_of_type_Aeyk.cYd();
    }
    this.mIsPlaying = true;
    this.bCu = null;
    resumeUpdateMessage();
    if (aeyw.LOG_LEVEL >= 5) {
      aeyw.d("DanmakuManager", new Object[] { "message resume:mPausedTime:", Long.valueOf(this.mPausedTime), ",mBaseTime:", Long.valueOf(this.mBaseTime) });
    }
  }
  
  private void handleSeek(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleSeek() msg.obj is null = ");
    if (paramMessage.obj == null) {}
    for (boolean bool = true;; bool = false)
    {
      aeyw.i("DanmakuManager", bool);
      if (paramMessage.obj != null)
      {
        this.mPausedTime = ((Long)paramMessage.obj).longValue();
        this.bWQ = true;
        handleResume();
      }
      if (aeyw.LOG_LEVEL >= 5) {
        aeyw.v("DanmakuManager", new Object[] { "message seek:startTime:", Long.valueOf(this.mPausedTime) });
      }
      return;
    }
  }
  
  private void handleStart(Message paramMessage)
  {
    this.mIsQuited = false;
    this.bWQ = true;
    if (paramMessage.obj != null) {}
    for (this.mPausedTime = ((Long)paramMessage.obj).longValue();; this.mPausedTime = 0L)
    {
      this.mDrawCount = 0;
      this.cPz = 0;
      this.cPA = 0;
      this.jdField_a_of_type_Aeyk.cYd();
      this.jdField_a_of_type_Aeyk.resetTime();
      if (aeyw.LOG_LEVEL >= 3) {
        aeyw.i("DanmakuManager", new Object[] { "message start:startTime:", Long.valueOf(this.mPausedTime) });
      }
      return;
    }
  }
  
  private void jK(List<aexe> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aexe localaexe = (aexe)paramList.next();
      this.jdField_a_of_type_Aexj.a(localaexe).l(localaexe);
      this.jdField_a_of_type_Aewz.g(localaexe);
    }
  }
  
  private void layout()
  {
    this.jdField_a_of_type_Aewv.layout();
  }
  
  private void removeUpdateMessage()
  {
    aeyw.v("DanmakuManager", "removeUpdateMessage()");
    if (this.mDrawHandler != null) {
      this.mDrawHandler.removeMessages(4);
    }
  }
  
  private void resumeUpdateMessage()
  {
    aeyw.v("DanmakuManager", "resumeUpdateMessage()");
    if (isPlaying()) {
      sendEmptyMessage(4);
    }
  }
  
  private void sendEmptyMessage(int paramInt)
  {
    if (aiw())
    {
      this.mDrawHandler.removeMessages(paramInt);
      this.mDrawHandler.sendEmptyMessage(paramInt);
    }
  }
  
  private void sendMessage(Message paramMessage)
  {
    if (aiw()) {
      this.mDrawHandler.sendMessage(paramMessage);
    }
  }
  
  private void sendMessageDelayed(int paramInt, long paramLong)
  {
    if (aiw())
    {
      this.mDrawHandler.removeMessages(paramInt);
      this.mDrawHandler.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void updateTime()
  {
    this.jdField_a_of_type_Aeyp.set(fs());
    this.jdField_a_of_type_Aeyk.en();
    if (aeyw.LOG_LEVEL >= 5) {
      aeyw.v("DanmakuManager", new Object[] { "updateFrame:currentTime:", Long.valueOf(this.jdField_a_of_type_Aeyk.getTime()), ",lastInterval:", Long.valueOf(this.jdField_a_of_type_Aeyk.be()) });
    }
  }
  
  public aexe a(int paramInt, Object paramObject)
  {
    return this.jdField_a_of_type_Aewz.a(paramInt, paramObject);
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$b = paramb;
  }
  
  public void addClickPoint(Point paramPoint, int paramInt)
  {
    paramPoint.y = ((int)(paramPoint.y - this.jdField_a_of_type_Aeye.aZ()));
    paramPoint = new aeyr(this.jdField_a_of_type_Aeyk.getTime(), paramPoint, paramInt);
    if (aeyw.LOG_LEVEL >= 4) {
      aeyw.v("DanmakuManager", new Object[] { "addClickPoint:", paramPoint });
    }
    this.mTouchPoints.add(paramPoint);
    paramPoint = Message.obtain();
    paramPoint.what = 10;
    sendMessage(paramPoint);
  }
  
  public void addLastAll(List<aexe> paramList)
  {
    this.jdField_a_of_type_Aexc.a(paramList, new aexb(this));
  }
  
  public boolean agC()
  {
    if ((this.jdField_a_of_type_Aewv instanceof aexd)) {
      return (((aexd)this.jdField_a_of_type_Aewv).aix()) || ((this.b != null) && (this.b.agC()));
    }
    return false;
  }
  
  public boolean aiv()
  {
    for (;;)
    {
      try
      {
        if ((this.mIsSurfaceCreated) && (!this.mIsQuited) && (aiw()))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void cXG()
  {
    aeyw.i("DanmakuManager", "clearDrawingCache()");
    Message localMessage = Message.obtain();
    localMessage.what = 11;
    sendMessage(localMessage);
  }
  
  public void cXL()
  {
    aeyw.i("surface_lock", "surfaceCreated");
  }
  
  public void cXM()
  {
    aeyw.i("surface_lock", "surfaceChanged");
    try
    {
      this.mIsSurfaceCreated = true;
      resumeUpdateMessage();
      return;
    }
    finally {}
  }
  
  public void cXN()
  {
    try
    {
      this.mIsSurfaceCreated = false;
      aeyw.i("surface_lock", "surfaceDestroyed");
      return;
    }
    finally {}
  }
  
  public void clear()
  {
    aeyw.v("DanmakuManager", "clear");
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    sendMessage(localMessage);
    cXP();
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$a = null;
    if (this.mDrawHandler != null)
    {
      this.mDrawHandler.removeCallbacksAndMessages(null);
      this.mDrawHandler = null;
    }
    if (this.jdField_a_of_type_Aeye != null) {
      this.jdField_a_of_type_Aeye.destroy();
    }
  }
  
  public void e(aexe paramaexe)
  {
    paramaexe.setTime(this.jdField_a_of_type_Aeyp.get());
    this.jdField_a_of_type_Aexc.a(paramaexe, new aexa(this));
  }
  
  public long fs()
  {
    if (this.jdField_a_of_type_Aexj.isLive()) {
      return getCurrentTime() - this.mBaseTime;
    }
    long l = getCurrentTime();
    if (l - this.WX >= 200L)
    {
      this.WX = l;
      l = this.jdField_a_of_type_Aexj.getPlayTime();
      this.WY = l;
      return l;
    }
    return l + this.WY - this.WX;
  }
  
  public long getCurrentTime()
  {
    return SystemClock.uptimeMillis();
  }
  
  public boolean isPlaying()
  {
    return (!this.mIsQuited) && (this.mIsPlaying);
  }
  
  public boolean isPrepared()
  {
    for (;;)
    {
      try
      {
        if ((this.mIsSurfaceCreated) && (!this.mIsQuited) && (this.mIsPlaying))
        {
          bool = true;
          aeyw.v("DanmakuManager", "isPrepared() = " + bool + ", mIsSurfaceCreated = " + this.mIsSurfaceCreated + ", mIsQuited = " + this.mIsQuited + ", mIsPlaying = " + this.mIsPlaying);
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void notifyConfigChanged()
  {
    aeyw.v("DanmakuManager", "notifyConfigChanged()");
    cXF();
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    sendMessage(localMessage);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.bWR)
    {
      if (aeyw.LOG_LEVEL >= 4) {
        aeyw.v("DanmakuManager", new Object[] { "onClick:", paramMotionEvent });
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0) {
        addClickPoint(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()), 0);
      }
    }
    return false;
  }
  
  public void pause()
  {
    aeyw.i("DanmakuManager", "pause()");
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    sendMessage(localMessage);
  }
  
  public void quit()
  {
    aeyw.v("DanmakuManager", "quit(); mIsQuited = true");
    this.mIsQuited = true;
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    sendMessage(localMessage);
  }
  
  public void release()
  {
    aeyw.v("DanmakuManager", "release() mIsQuited = " + this.mIsQuited);
    if (!this.mIsQuited) {
      quit();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    sendMessage(localMessage);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$b = null;
  }
  
  public void resume()
  {
    aeyw.v("DanmakuManager", "resume()");
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    sendMessage(localMessage);
  }
  
  public void seek(long paramLong)
  {
    aeyw.v("DanmakuManager", "seek(): postime = " + paramLong);
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    localMessage.obj = Long.valueOf(paramLong);
    sendMessage(localMessage);
  }
  
  public void start()
  {
    start(0L);
  }
  
  public void start(long paramLong)
  {
    aeyw.v("DanmakuManager", "start() time = " + paramLong);
    cXF();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = Long.valueOf(paramLong);
    sendMessage(localMessage);
  }
  
  public static final class DanmakuComparator
    implements Serializable, Comparator<aexe>
  {
    public int compare(aexe paramaexe1, aexe paramaexe2)
    {
      return aeyu.compare(paramaexe1, paramaexe2);
    }
  }
  
  static class a
    implements Handler.Callback
  {
    private WeakReference<DanmakuManager> gE;
    
    private a(DanmakuManager paramDanmakuManager)
    {
      this.gE = new WeakReference(paramDanmakuManager);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      DanmakuManager localDanmakuManager = (DanmakuManager)this.gE.get();
      if (localDanmakuManager == null) {
        return false;
      }
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 1: 
        DanmakuManager.a(localDanmakuManager, paramMessage);
        DanmakuManager.a(localDanmakuManager);
        return false;
      case 2: 
        DanmakuManager.a(localDanmakuManager);
        return false;
      case 4: 
        DanmakuManager.b(localDanmakuManager);
        return false;
      case 3: 
        DanmakuManager.c(localDanmakuManager);
        return false;
      case 5: 
        DanmakuManager.b(localDanmakuManager, paramMessage);
        return false;
      case 6: 
        DanmakuManager.d(localDanmakuManager);
        return false;
      case 7: 
        DanmakuManager.e(localDanmakuManager);
        return false;
      case 8: 
        DanmakuManager.f(localDanmakuManager);
        return false;
      case 9: 
        DanmakuManager.g(localDanmakuManager);
        return false;
      case 10: 
        DanmakuManager.h(localDanmakuManager);
        return false;
      }
      DanmakuManager.i(localDanmakuManager);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void Hp(boolean paramBoolean);
    
    public abstract void a(aexe paramaexe, aeyr paramaeyr, aeyj paramaeyj);
    
    public abstract void cWD();
    
    public abstract void jK(List<aexe> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager
 * JD-Core Version:    0.7.0.1
 */