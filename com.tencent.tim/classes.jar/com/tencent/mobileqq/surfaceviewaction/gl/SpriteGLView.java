package com.tencent.mobileqq.surfaceviewaction.gl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import anxu;
import anxz;
import anyr;
import anyt;
import anyt.a;
import anyu;
import anzc;
import aqcx;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SpriteGLView
  extends FrameLayout
  implements anxz<anyt>
{
  private final List<anxu> GN = Collections.synchronizedList(new ArrayList());
  private List<Runnable> GO = new ArrayList();
  public View HA;
  private a a;
  private List<Runnable> aU = new LinkedList();
  private final LinkedList<Integer> ac = new LinkedList();
  public boolean cKI;
  public boolean cKJ;
  public volatile boolean cKK;
  private final Object eZ = new Object();
  private final Object fa = new Object();
  private long mStartTime;
  private int mViewMode = 0;
  public int program;
  
  public SpriteGLView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SpriteGLView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mViewMode = paramInt;
    init();
  }
  
  public SpriteGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sj, 0, 0);
    try
    {
      this.mViewMode = paramContext.getInt(0, 0);
      paramContext.recycle();
      init();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void init()
  {
    Object localObject;
    if (this.mViewMode == 0)
    {
      localObject = new GLSurfaceView(getContext());
      this.HA = ((View)localObject);
      addView((View)localObject, -1, -1);
      ((GLSurfaceView)localObject).setEGLContextClientVersion(2);
      ((GLSurfaceView)localObject).getHolder().setFormat(-3);
      ((GLSurfaceView)localObject).setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      ((GLSurfaceView)localObject).setRenderer(new b(null));
      ((GLSurfaceView)localObject).setZOrderOnTop(true);
    }
    for (;;)
    {
      setFocusableInTouchMode(true);
      return;
      localObject = a(getContext());
      this.HA = ((View)localObject);
      addView((View)localObject, -1, -1);
      ((GLTextureView)localObject).setRenderer(new b(null));
    }
  }
  
  public int Kz()
  {
    if (this.a != null) {
      return this.a.getCurrentTime();
    }
    return (int)(System.currentTimeMillis() - this.mStartTime);
  }
  
  public void VD(int paramInt)
  {
    synchronized (this.ac)
    {
      this.ac.add(Integer.valueOf(paramInt));
      return;
    }
  }
  
  protected GLTextureView a(Context paramContext)
  {
    return new GLTextureView(paramContext);
  }
  
  public void a(int paramInt, anyt paramanyt)
  {
    synchronized (this.GN)
    {
      if (!this.GN.contains(paramanyt)) {
        this.GN.add(paramInt, paramanyt);
      }
      return;
    }
  }
  
  public void a(GLTextureView.a parama)
  {
    if ((this.HA instanceof GLTextureView)) {
      ((GLTextureView)this.HA).a(parama);
    }
  }
  
  public void ak(Runnable paramRunnable)
  {
    synchronized (this.fa)
    {
      this.GO.add(paramRunnable);
      return;
    }
  }
  
  public void al(Runnable paramRunnable)
  {
    synchronized (this.eZ)
    {
      this.aU.add(paramRunnable);
      return;
    }
  }
  
  public void b(anyt paramanyt)
  {
    synchronized (this.GN)
    {
      if (!this.GN.contains(paramanyt)) {
        this.GN.add(paramanyt);
      }
      return;
    }
  }
  
  public void b(anyu paramanyu)
  {
    b(paramanyu);
  }
  
  public void b(GLTextureView.a parama)
  {
    if ((this.HA instanceof GLTextureView)) {
      ((GLTextureView)this.HA).b(parama);
    }
  }
  
  public void c(anyt paramanyt)
  {
    if (paramanyt.azn()) {
      paramanyt.release();
    }
    this.GN.remove(paramanyt);
  }
  
  public void dTS()
  {
    Iterator localIterator = this.GN.iterator();
    while (localIterator.hasNext()) {
      ((anyt)localIterator.next()).dTS();
    }
  }
  
  public void dTT()
  {
    synchronized (this.fa)
    {
      this.GO.clear();
      return;
    }
  }
  
  public void dTU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "stopDraw");
    }
    SpriteGLView.1 local1 = new SpriteGLView.1(this);
    if ((this.HA instanceof GLSurfaceView))
    {
      ((GLSurfaceView)this.HA).onPause();
      ((GLSurfaceView)this.HA).queueEvent(local1);
    }
    while (!(this.HA instanceof GLTextureView)) {
      return;
    }
    ((GLTextureView)this.HA).queueEvent(local1);
  }
  
  public void dTV()
  {
    synchronized (this.ac)
    {
      int[] arrayOfInt = new int[this.ac.size()];
      int i = 0;
      while (!this.ac.isEmpty())
      {
        arrayOfInt[i] = ((Integer)this.ac.remove(0)).intValue();
        i += 1;
      }
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      return;
    }
  }
  
  public void deleteTexture(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.ac)
      {
        if (i < this.ac.size())
        {
          if (paramInt != ((Integer)this.ac.get(i)).intValue()) {
            break label78;
          }
          if (i > 0)
          {
            this.ac.remove(i);
            GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
          }
          return;
        }
      }
      i = -1;
      continue;
      label78:
      i += 1;
    }
  }
  
  public List<anxu> getNodeList()
  {
    return this.GN;
  }
  
  public boolean isEmpty()
  {
    return this.GN.isEmpty();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object[] arrayOfObject = this.GN.toArray();
    int i = arrayOfObject.length - 1;
    while (i >= 0)
    {
      if (((arrayOfObject[i] instanceof anyt.a)) && (((anyt.a)arrayOfObject[i]).a(paramMotionEvent, getWidth(), getHeight()))) {
        return true;
      }
      i -= 1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "pause");
    }
    Object[] arrayOfObject = this.GN.toArray();
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((localObject instanceof anyt)) {
        ((anyt)localObject).pause();
      }
      i += 1;
    }
  }
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "resume");
    }
    Object[] arrayOfObject = this.GN.toArray();
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((localObject instanceof anyt)) {
        ((anyt)localObject).resume();
      }
      i += 1;
    }
  }
  
  public void setFps(int paramInt)
  {
    if ((this.HA instanceof GLTextureView)) {
      ((GLTextureView)this.HA).setFps(paramInt);
    }
  }
  
  public void setRetainBitmap(boolean paramBoolean)
  {
    this.cKK = paramBoolean;
  }
  
  public void setVideoTimeGetter(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract int getCurrentTime();
  }
  
  class b
    implements GLSurfaceView.Renderer
  {
    private anyr a;
    private int dNA;
    private int dNx;
    private int dNy;
    private int dNz;
    private final float[] dv = new float[16];
    private int frameCount;
    private long mLastTime;
    private final float[] mMVPMatrix = new float[16];
    private int mPositionHandle;
    private final float[] mProjectionMatrix = new float[16];
    
    private b() {}
    
    /* Error */
    @SuppressLint({"DefaultLocale"})
    public void onDrawFrame(GL10 paramGL10)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   4: invokestatic 51	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/lang/Object;
      //   7: astore_1
      //   8: aload_1
      //   9: monitorenter
      //   10: iconst_0
      //   11: istore_2
      //   12: iload_2
      //   13: aload_0
      //   14: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   17: invokestatic 54	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
      //   20: invokeinterface 60 1 0
      //   25: if_icmpge +31 -> 56
      //   28: aload_0
      //   29: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   32: invokestatic 54	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
      //   35: iload_2
      //   36: invokeinterface 64 2 0
      //   41: checkcast 66	java/lang/Runnable
      //   44: invokeinterface 69 1 0
      //   49: iload_2
      //   50: iconst_1
      //   51: iadd
      //   52: istore_2
      //   53: goto -41 -> 12
      //   56: aload_0
      //   57: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   60: invokestatic 54	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
      //   63: invokeinterface 72 1 0
      //   68: aload_1
      //   69: monitorexit
      //   70: aload_0
      //   71: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   74: invokestatic 74	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/lang/Object;
      //   77: astore_1
      //   78: aload_1
      //   79: monitorenter
      //   80: iconst_0
      //   81: istore_2
      //   82: iload_2
      //   83: aload_0
      //   84: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   87: invokestatic 77	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
      //   90: invokeinterface 60 1 0
      //   95: if_icmpge +38 -> 133
      //   98: aload_0
      //   99: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   102: invokestatic 77	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
      //   105: iload_2
      //   106: invokeinterface 64 2 0
      //   111: checkcast 66	java/lang/Runnable
      //   114: invokeinterface 69 1 0
      //   119: iload_2
      //   120: iconst_1
      //   121: iadd
      //   122: istore_2
      //   123: goto -41 -> 82
      //   126: astore 4
      //   128: aload_1
      //   129: monitorexit
      //   130: aload 4
      //   132: athrow
      //   133: aload_1
      //   134: monitorexit
      //   135: sipush 16640
      //   138: invokestatic 83	android/opengl/GLES20:glClear	(I)V
      //   141: aload_0
      //   142: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   145: invokestatic 85	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
      //   148: invokeinterface 89 1 0
      //   153: astore_1
      //   154: aload_1
      //   155: arraylength
      //   156: istore_3
      //   157: iconst_0
      //   158: istore_2
      //   159: iload_2
      //   160: iload_3
      //   161: if_icmpge +99 -> 260
      //   164: aload_1
      //   165: iload_2
      //   166: aaload
      //   167: astore 4
      //   169: aload 4
      //   171: instanceof 91
      //   174: ifeq +72 -> 246
      //   177: sipush 3042
      //   180: invokestatic 94	android/opengl/GLES20:glEnable	(I)V
      //   183: iconst_1
      //   184: sipush 771
      //   187: invokestatic 98	android/opengl/GLES20:glBlendFunc	(II)V
      //   190: aload_0
      //   191: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   194: getfield 101	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:program	I
      //   197: invokestatic 104	android/opengl/GLES20:glUseProgram	(I)V
      //   200: aload 4
      //   202: checkcast 91	anyt
      //   205: aload_0
      //   206: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   209: invokevirtual 107	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getWidth	()I
      //   212: aload_0
      //   213: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   216: invokevirtual 110	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getHeight	()I
      //   219: aload_0
      //   220: getfield 112	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:mPositionHandle	I
      //   223: aload_0
      //   224: getfield 114	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:dNy	I
      //   227: aload_0
      //   228: getfield 116	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:dNx	I
      //   231: aload_0
      //   232: getfield 118	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:dNz	I
      //   235: aload_0
      //   236: getfield 120	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:dNA	I
      //   239: aload_0
      //   240: getfield 39	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:mMVPMatrix	[F
      //   243: invokevirtual 123	anyt:c	(IIIIIII[F)V
      //   246: iload_2
      //   247: iconst_1
      //   248: iadd
      //   249: istore_2
      //   250: goto -91 -> 159
      //   253: astore 4
      //   255: aload_1
      //   256: monitorexit
      //   257: aload 4
      //   259: athrow
      //   260: aload_0
      //   261: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   264: getfield 127	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:cKI	Z
      //   267: ifeq +137 -> 404
      //   270: aload_0
      //   271: aload_0
      //   272: getfield 129	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:frameCount	I
      //   275: iconst_1
      //   276: iadd
      //   277: putfield 129	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:frameCount	I
      //   280: aload_0
      //   281: getfield 129	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:frameCount	I
      //   284: iconst_5
      //   285: if_icmplt +64 -> 349
      //   288: invokestatic 135	java/lang/System:currentTimeMillis	()J
      //   291: aload_0
      //   292: getfield 137	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:mLastTime	J
      //   295: lsub
      //   296: l2i
      //   297: istore_2
      //   298: ldc 139
      //   300: iconst_1
      //   301: anewarray 4	java/lang/Object
      //   304: dup
      //   305: iconst_0
      //   306: aload_0
      //   307: getfield 129	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:frameCount	I
      //   310: i2f
      //   311: ldc 140
      //   313: fmul
      //   314: iload_2
      //   315: i2f
      //   316: fdiv
      //   317: invokestatic 146	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   320: aastore
      //   321: invokestatic 152	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   324: astore_1
      //   325: aload_0
      //   326: invokestatic 135	java/lang/System:currentTimeMillis	()J
      //   329: putfield 137	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:mLastTime	J
      //   332: aload_0
      //   333: iconst_0
      //   334: putfield 129	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:frameCount	I
      //   337: aload_0
      //   338: getfield 154	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:a	Lanyr;
      //   341: aload_0
      //   342: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   345: aload_1
      //   346: invokevirtual 159	anyr:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;Ljava/lang/String;)V
      //   349: aload_0
      //   350: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   353: getfield 101	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:program	I
      //   356: invokestatic 104	android/opengl/GLES20:glUseProgram	(I)V
      //   359: aload_0
      //   360: getfield 154	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:a	Lanyr;
      //   363: aload_0
      //   364: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   367: invokevirtual 107	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getWidth	()I
      //   370: aload_0
      //   371: getfield 30	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
      //   374: invokevirtual 110	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getHeight	()I
      //   377: aload_0
      //   378: getfield 112	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:mPositionHandle	I
      //   381: aload_0
      //   382: getfield 114	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:dNy	I
      //   385: aload_0
      //   386: getfield 116	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:dNx	I
      //   389: aload_0
      //   390: getfield 118	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:dNz	I
      //   393: aload_0
      //   394: getfield 120	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:dNA	I
      //   397: aload_0
      //   398: getfield 39	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView$b:mMVPMatrix	[F
      //   401: invokevirtual 160	anyr:c	(IIIIIII[F)V
      //   404: invokestatic 163	android/opengl/GLES20:glFlush	()V
      //   407: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	408	0	this	b
      //   0	408	1	paramGL10	GL10
      //   11	304	2	i	int
      //   156	6	3	j	int
      //   126	5	4	localObject1	Object
      //   167	34	4	localObject2	Object
      //   253	5	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   12	49	126	finally
      //   56	70	126	finally
      //   128	130	126	finally
      //   82	119	253	finally
      //   133	135	253	finally
      //   255	257	253	finally
    }
    
    public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      float f = paramInt1 / paramInt2;
      Matrix.frustumM(this.mProjectionMatrix, 0, -f, f, -1.0F, 1.0F, 3.0F, 7.0F);
      Matrix.setLookAtM(this.dv, 0, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
      Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjectionMatrix, 0, this.dv, 0);
      this.a.x = (aqcx.dip2px(SpriteGLView.this.getContext(), 50.0F) - paramInt1 / 2);
      this.a.y = (aqcx.dip2px(SpriteGLView.this.getContext(), 10.0F) - paramInt2 / 2);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      SpriteGLView.this.dTS();
    }
    
    public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      try
      {
        SpriteGLView.this.program = anzc.loadProgram(anzc.D(SpriteGLView.this.getContext(), "troop" + File.separator + "shaders" + File.separator + "VertexShader.glsl"), anzc.D(SpriteGLView.this.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShader.glsl"));
        GLES20.glUseProgram(SpriteGLView.this.program);
        this.mPositionHandle = GLES20.glGetAttribLocation(SpriteGLView.this.program, "vPosition");
        this.dNy = GLES20.glGetAttribLocation(SpriteGLView.this.program, "a_texCoord");
        this.dNx = GLES20.glGetUniformLocation(SpriteGLView.this.program, "uMVPMatrix");
        this.dNz = GLES20.glGetUniformLocation(SpriteGLView.this.program, "s_texture");
        this.dNA = GLES20.glGetUniformLocation(SpriteGLView.this.program, "v_alpha");
        QLog.i("SpriteGLView", 1, "program = " + SpriteGLView.this.program + ",mPositionHandle =" + this.mPositionHandle + ",mTexCoordHandle =" + this.dNy + ",mMatrixHandle= " + this.dNx + ",mTexSamplerHandle =" + this.dNz + ",mAlphaHandle = " + this.dNA);
        this.a = new anyr(SpriteGLView.this, SpriteGLView.this.getContext(), "fps:", -1, 40);
        SpriteGLView.a(SpriteGLView.this, System.currentTimeMillis());
        return;
      }
      catch (Exception paramGL10)
      {
        for (;;)
        {
          QLog.e("SpriteGLView", 2, QLog.getStackTraceString(paramGL10));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView
 * JD-Core Version:    0.7.0.1
 */