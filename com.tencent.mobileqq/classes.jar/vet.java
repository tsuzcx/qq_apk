import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class vet
  implements Handler.Callback, TextureView.SurfaceTextureListener, View.OnTouchListener, Thread.UncaughtExceptionHandler
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final TextureView jdField_a_of_type_AndroidViewTextureView;
  private final List<vex> jdField_a_of_type_JavaUtilList = new LinkedList();
  private final Queue<vev> jdField_a_of_type_JavaUtilQueue = new LinkedBlockingDeque();
  private final vem jdField_a_of_type_Vem;
  private ven jdField_a_of_type_Ven;
  private final veo jdField_a_of_type_Veo;
  private final ves jdField_a_of_type_Ves;
  private final veu jdField_a_of_type_Veu;
  private final vfa jdField_a_of_type_Vfa;
  private final vhh jdField_a_of_type_Vhh;
  private volatile boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private volatile boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private volatile boolean jdField_c_of_type_Boolean;
  private boolean d;
  private volatile boolean e;
  
  public vet(Context paramContext, TextureView paramTextureView, int paramInt)
  {
    vel localvel = vel.a(paramContext, 1, paramInt);
    this.jdField_a_of_type_AndroidViewTextureView = paramTextureView;
    this.jdField_a_of_type_AndroidViewTextureView.setSurfaceTextureListener(this);
    this.jdField_a_of_type_Vfa = new vfa();
    this.jdField_a_of_type_Vhh = new vhh(paramContext);
    this.jdField_a_of_type_Veu = new veu();
    this.jdField_a_of_type_Veo = new veo(this.jdField_a_of_type_Vfa, localvel, this.jdField_a_of_type_Veu);
    this.jdField_a_of_type_Vem = vem.a(paramContext, this.jdField_a_of_type_Vhh, localvel, this.jdField_a_of_type_Veu, 1);
    this.jdField_a_of_type_Ves = new ves(paramContext, this.jdField_a_of_type_Vfa, paramInt);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  private void a(Message paramMessage)
  {
    this.jdField_a_of_type_Boolean = false;
    this.d = true;
    if (paramMessage.obj != null)
    {
      this.jdField_b_of_type_Long = ((Long)paramMessage.obj).longValue();
      return;
    }
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void b(Message paramMessage)
  {
    if (paramMessage.obj != null)
    {
      this.jdField_b_of_type_Long = ((Long)paramMessage.obj).longValue();
      this.d = true;
      g();
    }
  }
  
  private void c(Message paramMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 128	vet:d	Z
    //   4: ifeq +15 -> 19
    //   7: aload_0
    //   8: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   11: invokevirtual 154	vem:e	()V
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 128	vet:d	Z
    //   19: aload_0
    //   20: getfield 85	vet:jdField_a_of_type_Veo	Lveo;
    //   23: invokevirtual 156	veo:a	()V
    //   26: aload_0
    //   27: getfield 85	vet:jdField_a_of_type_Veo	Lveo;
    //   30: invokevirtual 159	veo:a	()Ljava/util/List;
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 55	vet:jdField_a_of_type_AndroidViewTextureView	Landroid/view/TextureView;
    //   38: invokevirtual 163	android/view/TextureView:lockCanvas	()Landroid/graphics/Canvas;
    //   41: astore_2
    //   42: aload_2
    //   43: invokestatic 168	argo:a	(Landroid/graphics/Canvas;)V
    //   46: aload_2
    //   47: ifnull +114 -> 161
    //   50: aload_0
    //   51: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   54: aload_2
    //   55: invokevirtual 169	vem:a	(Landroid/graphics/Canvas;)V
    //   58: aload_3
    //   59: invokeinterface 175 1 0
    //   64: astore_3
    //   65: aload_3
    //   66: invokeinterface 181 1 0
    //   71: ifeq +178 -> 249
    //   74: aload_3
    //   75: invokeinterface 185 1 0
    //   80: checkcast 187	vex
    //   83: astore 4
    //   85: aload_3
    //   86: invokeinterface 190 1 0
    //   91: aload 4
    //   93: invokevirtual 192	vex:c	()Z
    //   96: ifeq +66 -> 162
    //   99: aload 4
    //   101: aload_0
    //   102: invokevirtual 194	vet:c	()J
    //   105: ldc2_w 195
    //   108: ladd
    //   109: invokevirtual 199	vex:a	(J)V
    //   112: goto -21 -> 91
    //   115: astore_3
    //   116: ldc 201
    //   118: iconst_1
    //   119: new 203	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   126: ldc 206
    //   128: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_3
    //   132: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   135: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_0
    //   145: getfield 222	vet:jdField_c_of_type_Boolean	Z
    //   148: istore_1
    //   149: iload_1
    //   150: ifeq +11 -> 161
    //   153: aload_0
    //   154: getfield 55	vet:jdField_a_of_type_AndroidViewTextureView	Landroid/view/TextureView;
    //   157: aload_2
    //   158: invokevirtual 225	android/view/TextureView:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   161: return
    //   162: aload 4
    //   164: invokevirtual 228	vex:a	()I
    //   167: tableswitch	default:+195 -> 362, 1:+17->184
    //   185: iconst_1
    //   186: invokevirtual 230	vex:a	()Z
    //   189: ifne +15 -> 204
    //   192: aload 4
    //   194: aload_0
    //   195: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   198: invokevirtual 233	vem:a	()Lcom/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuDrawer;
    //   201: invokevirtual 236	vex:b	(Lcom/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuDrawer;)V
    //   204: aload_0
    //   205: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   208: aload 4
    //   210: invokevirtual 239	vem:a	(Lvex;)V
    //   213: goto -148 -> 65
    //   216: astore_3
    //   217: aload_0
    //   218: getfield 222	vet:jdField_c_of_type_Boolean	Z
    //   221: istore_1
    //   222: iload_1
    //   223: ifeq +11 -> 234
    //   226: aload_0
    //   227: getfield 55	vet:jdField_a_of_type_AndroidViewTextureView	Landroid/view/TextureView;
    //   230: aload_2
    //   231: invokevirtual 225	android/view/TextureView:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   234: aload_3
    //   235: athrow
    //   236: astore_2
    //   237: ldc 201
    //   239: iconst_1
    //   240: aload_2
    //   241: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   244: aload_2
    //   245: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: return
    //   249: aload_0
    //   250: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   253: invokevirtual 244	vem:b	()V
    //   256: aload_0
    //   257: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   260: invokevirtual 246	vem:c	()V
    //   263: aload_0
    //   264: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   267: invokevirtual 248	vem:d	()V
    //   270: aload_0
    //   271: getfield 48	vet:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   274: aload_0
    //   275: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   278: invokevirtual 249	vem:a	()Ljava/util/List;
    //   281: invokeinterface 253 2 0
    //   286: pop
    //   287: aload_0
    //   288: getfield 92	vet:jdField_a_of_type_Vem	Lvem;
    //   291: invokevirtual 255	vem:f	()V
    //   294: aload_0
    //   295: getfield 48	vet:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   298: invokeinterface 258 1 0
    //   303: aload_0
    //   304: getfield 222	vet:jdField_c_of_type_Boolean	Z
    //   307: istore_1
    //   308: iload_1
    //   309: ifeq -148 -> 161
    //   312: aload_0
    //   313: getfield 55	vet:jdField_a_of_type_AndroidViewTextureView	Landroid/view/TextureView;
    //   316: aload_2
    //   317: invokevirtual 225	android/view/TextureView:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   320: return
    //   321: astore_2
    //   322: ldc 201
    //   324: iconst_1
    //   325: aload_2
    //   326: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   329: aload_2
    //   330: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   333: return
    //   334: astore_2
    //   335: ldc 201
    //   337: iconst_1
    //   338: aload_2
    //   339: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   342: aload_2
    //   343: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   346: return
    //   347: astore_2
    //   348: ldc 201
    //   350: iconst_1
    //   351: aload_2
    //   352: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   355: aload_2
    //   356: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   359: goto -125 -> 234
    //   362: goto -297 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	vet
    //   148	161	1	bool	boolean
    //   41	190	2	localCanvas	android.graphics.Canvas
    //   236	81	2	localThrowable1	Throwable
    //   321	9	2	localThrowable2	Throwable
    //   334	9	2	localThrowable3	Throwable
    //   347	9	2	localThrowable4	Throwable
    //   33	53	3	localObject1	Object
    //   115	17	3	localThrowable5	Throwable
    //   216	19	3	localObject2	Object
    //   83	126	4	localvex	vex
    // Exception table:
    //   from	to	target	type
    //   50	65	115	java/lang/Throwable
    //   65	91	115	java/lang/Throwable
    //   91	112	115	java/lang/Throwable
    //   162	184	115	java/lang/Throwable
    //   184	204	115	java/lang/Throwable
    //   204	213	115	java/lang/Throwable
    //   249	303	115	java/lang/Throwable
    //   50	65	216	finally
    //   65	91	216	finally
    //   91	112	216	finally
    //   116	144	216	finally
    //   162	184	216	finally
    //   184	204	216	finally
    //   204	213	216	finally
    //   249	303	216	finally
    //   34	46	236	java/lang/Throwable
    //   144	149	236	java/lang/Throwable
    //   217	222	236	java/lang/Throwable
    //   234	236	236	java/lang/Throwable
    //   303	308	236	java/lang/Throwable
    //   322	333	236	java/lang/Throwable
    //   335	346	236	java/lang/Throwable
    //   348	359	236	java/lang/Throwable
    //   312	320	321	java/lang/Throwable
    //   153	161	334	java/lang/Throwable
    //   226	234	347	java/lang/Throwable
  }
  
  private void g()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = (a() - this.jdField_b_of_type_Long);
    h();
  }
  
  private void h()
  {
    if (b()) {
      a(4);
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
  }
  
  private void j()
  {
    i();
    this.jdField_c_of_type_Long = b();
    if ((a()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Vfa.a(this.jdField_c_of_type_Long);
      f();
      a(4, 8L);
      return;
    }
    a(4, 100L);
  }
  
  private void k()
  {
    i();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Vfa.a();
  }
  
  private void l()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Veo.b();
    this.jdField_a_of_type_Vhh.a();
  }
  
  private void m()
  {
    this.jdField_a_of_type_Vem.a();
  }
  
  private void n() {}
  
  private void o()
  {
    this.jdField_a_of_type_Vem.e();
    this.jdField_a_of_type_Veo.b();
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Ven != null) {
      while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        vev localvev = (vev)this.jdField_a_of_type_JavaUtilQueue.poll();
        vex localvex = this.jdField_a_of_type_Vem.a(localvev);
        this.jdField_a_of_type_Ven.a(localvex, localvev);
      }
    }
  }
  
  public long a()
  {
    return System.currentTimeMillis();
  }
  
  public veo a()
  {
    return this.jdField_a_of_type_Veo;
  }
  
  public ves a()
  {
    return this.jdField_a_of_type_Ves;
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    c(localMessage);
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = Long.valueOf(paramLong);
    c(localMessage);
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    paramPoint = new vev(b(), paramPoint, paramInt);
    this.jdField_a_of_type_JavaUtilQueue.add(paramPoint);
    paramPoint = Message.obtain();
    paramPoint.what = 10;
    c(paramPoint);
  }
  
  public void a(ven paramven)
  {
    this.jdField_a_of_type_Ven = paramven;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isPrepared - mIsSurfaceCreated:").append(this.jdField_c_of_type_Boolean).append(",!mIsQuited:");
      if (this.jdField_a_of_type_Boolean) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("PhotoDanmakuManager", 1, bool + ",mIsPlaying:" + this.jdField_b_of_type_Boolean + ",mDanmakuTextureView.isHardwareAccelerated()" + this.jdField_a_of_type_AndroidViewTextureView.isHardwareAccelerated());
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public long b()
  {
    return a() - this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    c(localMessage);
  }
  
  public boolean b()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Vfa.a();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    c(localMessage);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    c(localMessage);
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    c(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a(paramMessage);
      g();
      continue;
      j();
      continue;
      k();
      continue;
      b(paramMessage);
      continue;
      l();
      continue;
      m();
      continue;
      n();
      continue;
      o();
      continue;
      p();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = this.jdField_a_of_type_AndroidViewTextureView.lockCanvas();
    if (paramSurfaceTexture != null) {
      argo.a(paramSurfaceTexture);
    }
    this.jdField_a_of_type_AndroidViewTextureView.unlockCanvasAndPost(paramSurfaceTexture);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_c_of_type_Boolean = false;
    i();
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    h();
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.e)
    {
      QLog.e("PhotoDanmakuManager", 4, new Object[] { "onClick", paramMotionEvent });
      int i = paramMotionEvent.getAction();
      paramView = new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i & 0xFF) == 0) {
        a(paramView, this.jdField_a_of_type_Int);
      }
    }
    paramView = new vev(b(), new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()), 10);
    return this.jdField_a_of_type_Vem.a(paramView) != null;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    QLog.e("PhotoDanmakuManager", 1, "photoDanmaku crash thread:" + paramThread, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vet
 * JD-Core Version:    0.7.0.1
 */