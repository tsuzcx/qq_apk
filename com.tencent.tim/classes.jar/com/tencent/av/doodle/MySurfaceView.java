package com.tencent.av.doodle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.qphone.base.util.QLog;

public abstract class MySurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private MySurfaceViewThread a;
  public long mCurTime;
  
  public MySurfaceView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MySurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MySurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    paramContext = getHolder();
    paramContext.addCallback(this);
    setZOrderOnTop(true);
    paramContext.setFormat(-3);
  }
  
  protected abstract void Q(Canvas paramCanvas);
  
  protected abstract void ch(long paramLong);
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      it(false);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected abstract void is(boolean paramBoolean);
  
  protected void it(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if ((this.a != null) && (MySurfaceViewThread.a(this.a)))
    {
      bool = true;
      if (bool != paramBoolean)
      {
        Throwable localThrowable = new Throwable("打印调用栈");
        StringBuilder localStringBuilder = new StringBuilder().append("setRunning, running[").append(paramBoolean).append("], mThread[");
        if (this.a == null) {
          break label177;
        }
        bool = true;
        label69:
        localStringBuilder = localStringBuilder.append(bool).append("], mThread.mRunning[");
        if ((this.a == null) || (!MySurfaceViewThread.a(this.a))) {
          break label182;
        }
        bool = true;
        label101:
        QLog.w("MySurfaceView", 1, bool + "]", localThrowable);
      }
      if (!paramBoolean) {
        break label187;
      }
      if ((this.a == null) || (!MySurfaceViewThread.a(this.a)))
      {
        this.a = new MySurfaceViewThread();
        this.a.it(true);
        this.a.start();
      }
    }
    label177:
    label182:
    label187:
    while ((this.a == null) || (!MySurfaceViewThread.a(this.a)))
    {
      return;
      bool = false;
      break;
      bool = false;
      break label69;
      bool = false;
      break label101;
    }
    this.a.it(false);
    if (this.a != Thread.currentThread()) {}
    for (;;)
    {
      if (i != 0) {}
      try
      {
        this.a.join();
        i = 0;
      }
      catch (InterruptedException localInterruptedException) {}
      this.a = null;
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MySurfaceView", 2, "WL_DEBUG onWindowFocusChanged hasWindowFocus = " + paramBoolean);
    }
    if (!paramBoolean) {
      it(false);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mCurTime = SystemClock.elapsedRealtime();
    paramSurfaceHolder = getContext();
    boolean bool = hasWindowFocus();
    if (QLog.isColorLevel()) {
      QLog.d("MySurfaceView", 2, "WL_DEBUG surfaceCreated context = " + paramSurfaceHolder.getClass().getName() + ", hasWindowFocus = " + bool);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = getContext();
    if (QLog.isColorLevel()) {
      QLog.d("MySurfaceView", 2, "WL_DEBUG surfaceDestroyed context = " + paramSurfaceHolder.getClass().getName());
    }
    if (!(paramSurfaceHolder instanceof Activity)) {
      it(false);
    }
  }
  
  public boolean ud()
  {
    boolean bool = false;
    if (this.a != null) {
      bool = MySurfaceViewThread.a(this.a);
    }
    return bool;
  }
  
  class MySurfaceViewThread
    extends Thread
  {
    private boolean SD = true;
    private boolean mRunning;
    private SurfaceHolder mSurfaceHolder = MySurfaceView.this.getHolder();
    
    public MySurfaceViewThread() {}
    
    public void it(boolean paramBoolean)
    {
      this.mRunning = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d("MySurfaceView", 2, "WL_DEBUG MySurfaceViewThread.setRunning running = " + paramBoolean);
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 18	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
      //   4: iconst_1
      //   5: invokevirtual 70	com/tencent/av/doodle/MySurfaceView:is	(Z)V
      //   8: aload_0
      //   9: getfield 34	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:mRunning	Z
      //   12: ifeq +313 -> 325
      //   15: aload_0
      //   16: getfield 29	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:mSurfaceHolder	Landroid/view/SurfaceHolder;
      //   19: aconst_null
      //   20: invokeinterface 76 2 0
      //   25: astore 6
      //   27: aload 6
      //   29: astore 5
      //   31: aload_0
      //   32: getfield 29	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:mSurfaceHolder	Landroid/view/SurfaceHolder;
      //   35: astore 7
      //   37: aload 6
      //   39: astore 5
      //   41: aload 7
      //   43: monitorenter
      //   44: aload_0
      //   45: getfield 23	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:SD	Z
      //   48: ifeq +33 -> 81
      //   51: invokestatic 82	android/os/SystemClock:elapsedRealtime	()J
      //   54: lstore_1
      //   55: aload_0
      //   56: getfield 18	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
      //   59: getfield 86	com/tencent/av/doodle/MySurfaceView:mCurTime	J
      //   62: lstore_3
      //   63: aload_0
      //   64: getfield 18	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
      //   67: lload_1
      //   68: putfield 86	com/tencent/av/doodle/MySurfaceView:mCurTime	J
      //   71: aload_0
      //   72: getfield 18	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
      //   75: lload_1
      //   76: lload_3
      //   77: lsub
      //   78: invokevirtual 90	com/tencent/av/doodle/MySurfaceView:ch	(J)V
      //   81: aload 6
      //   83: ifnull +12 -> 95
      //   86: aload_0
      //   87: getfield 18	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
      //   90: aload 6
      //   92: invokevirtual 94	com/tencent/av/doodle/MySurfaceView:Q	(Landroid/graphics/Canvas;)V
      //   95: aload 7
      //   97: monitorexit
      //   98: aload 6
      //   100: ifnull -92 -> 8
      //   103: aload_0
      //   104: getfield 29	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:mSurfaceHolder	Landroid/view/SurfaceHolder;
      //   107: aload 6
      //   109: invokeinterface 97 2 0
      //   114: goto -106 -> 8
      //   117: astore 5
      //   119: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   122: ifeq -114 -> 8
      //   125: ldc 44
      //   127: iconst_2
      //   128: new 46	java/lang/StringBuilder
      //   131: dup
      //   132: invokespecial 47	java/lang/StringBuilder:<init>	()V
      //   135: ldc 99
      //   137: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: aload 5
      //   142: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   145: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   148: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   151: goto -143 -> 8
      //   154: astore 8
      //   156: aload 7
      //   158: monitorexit
      //   159: aload 6
      //   161: astore 5
      //   163: aload 8
      //   165: athrow
      //   166: astore 7
      //   168: aload 6
      //   170: astore 5
      //   172: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   175: ifeq +33 -> 208
      //   178: aload 6
      //   180: astore 5
      //   182: ldc 44
      //   184: iconst_2
      //   185: new 46	java/lang/StringBuilder
      //   188: dup
      //   189: invokespecial 47	java/lang/StringBuilder:<init>	()V
      //   192: ldc 99
      //   194: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   197: aload 7
      //   199: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   202: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   205: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   208: aload 6
      //   210: ifnull -202 -> 8
      //   213: aload_0
      //   214: getfield 29	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:mSurfaceHolder	Landroid/view/SurfaceHolder;
      //   217: aload 6
      //   219: invokeinterface 97 2 0
      //   224: goto -216 -> 8
      //   227: astore 5
      //   229: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   232: ifeq -224 -> 8
      //   235: ldc 44
      //   237: iconst_2
      //   238: new 46	java/lang/StringBuilder
      //   241: dup
      //   242: invokespecial 47	java/lang/StringBuilder:<init>	()V
      //   245: ldc 99
      //   247: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   250: aload 5
      //   252: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   255: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   258: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   261: goto -253 -> 8
      //   264: astore 6
      //   266: aconst_null
      //   267: astore 5
      //   269: aload 5
      //   271: ifnull +14 -> 285
      //   274: aload_0
      //   275: getfield 29	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:mSurfaceHolder	Landroid/view/SurfaceHolder;
      //   278: aload 5
      //   280: invokeinterface 97 2 0
      //   285: aload 6
      //   287: athrow
      //   288: astore 5
      //   290: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   293: ifeq -8 -> 285
      //   296: ldc 44
      //   298: iconst_2
      //   299: new 46	java/lang/StringBuilder
      //   302: dup
      //   303: invokespecial 47	java/lang/StringBuilder:<init>	()V
      //   306: ldc 99
      //   308: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   311: aload 5
      //   313: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   316: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   319: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   322: goto -37 -> 285
      //   325: aload_0
      //   326: getfield 18	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
      //   329: iconst_0
      //   330: invokevirtual 70	com/tencent/av/doodle/MySurfaceView:is	(Z)V
      //   333: return
      //   334: astore 6
      //   336: goto -67 -> 269
      //   339: astore 7
      //   341: aconst_null
      //   342: astore 6
      //   344: goto -176 -> 168
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	347	0	this	MySurfaceViewThread
      //   54	22	1	l1	long
      //   62	15	3	l2	long
      //   29	11	5	localCanvas1	Canvas
      //   117	24	5	localException1	java.lang.Exception
      //   161	20	5	localCanvas2	Canvas
      //   227	24	5	localException2	java.lang.Exception
      //   267	12	5	localCanvas3	Canvas
      //   288	24	5	localException3	java.lang.Exception
      //   25	193	6	localCanvas4	Canvas
      //   264	22	6	localObject1	Object
      //   334	1	6	localObject2	Object
      //   342	1	6	localObject3	Object
      //   35	122	7	localSurfaceHolder	SurfaceHolder
      //   166	32	7	localException4	java.lang.Exception
      //   339	1	7	localException5	java.lang.Exception
      //   154	10	8	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   103	114	117	java/lang/Exception
      //   44	81	154	finally
      //   86	95	154	finally
      //   95	98	154	finally
      //   156	159	154	finally
      //   31	37	166	java/lang/Exception
      //   41	44	166	java/lang/Exception
      //   163	166	166	java/lang/Exception
      //   213	224	227	java/lang/Exception
      //   15	27	264	finally
      //   274	285	288	java/lang/Exception
      //   31	37	334	finally
      //   41	44	334	finally
      //   163	166	334	finally
      //   172	178	334	finally
      //   182	208	334	finally
      //   15	27	339	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.doodle.MySurfaceView
 * JD-Core Version:    0.7.0.1
 */