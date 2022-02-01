package com.tencent.tar.jni;

import advf;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import atap;
import atap.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.Random;

public class ScanFeatureFilterView
  extends SurfaceView
  implements Handler.Callback, SurfaceHolder.Callback
{
  int JO = 0;
  private int STATE_DEFAULT = -1;
  private int STATE_DESTROY = 2;
  private atap jdField_a_of_type_Atap;
  a[][] jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a = (a[][])null;
  private HandlerThread ah;
  private volatile boolean bkn;
  private Paint cR = new Paint();
  private Handler dV;
  private Rect da = new Rect();
  int eoA = -1;
  private int eoB = 300;
  private int eoC;
  private int eoD;
  private final int eoE;
  private int eoz = 1;
  private Bitmap gS;
  int mCenterX = 0;
  int mCenterY = 0;
  private boolean mHasSurface;
  private boolean mInited;
  int mOffsetX = 0;
  int mOffsetY = 0;
  private long mPlayTime;
  private long mStartTime = 600L;
  private int mState = this.STATE_DEFAULT;
  private SurfaceHolder mSurfaceHolder;
  int mViewHeight = 0;
  
  public ScanFeatureFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initPaint();
    this.eoE = dip2px(getContext(), 10.0F);
    this.gS = BitmapFactory.decodeResource(paramContext.getResources(), 2130846149);
    setZOrderOnTop(true);
    this.mSurfaceHolder = getHolder();
    this.mSurfaceHolder.setFormat(-2);
    this.mSurfaceHolder.addCallback(this);
  }
  
  private float a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return (float)Math.sin((float)((paramInt1 + paramInt2 * paramFloat1) * 3.141592653589793D) * paramFloat2);
  }
  
  private void acE()
  {
    if ((!this.bkn) && (this.dV != null) && (getVisibility() == 0))
    {
      if (this.dV != null) {
        this.dV.removeMessages(100);
      }
      if (this.dV != null) {
        this.dV.sendEmptyMessageDelayed(100, 30L);
      }
    }
  }
  
  public static long currentAnimationTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  /* Error */
  private void esQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 201	com/tencent/tar/jni/ScanFeatureFilterView:acE	()V
    //   4: aload_0
    //   5: getfield 157	com/tencent/tar/jni/ScanFeatureFilterView:bkn	Z
    //   8: ifne +26 -> 34
    //   11: aload_0
    //   12: getfield 203	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_Atap	Latap;
    //   15: ifnull +19 -> 34
    //   18: aload_0
    //   19: invokevirtual 163	com/tencent/tar/jni/ScanFeatureFilterView:getVisibility	()I
    //   22: bipush 8
    //   24: if_icmpeq +10 -> 34
    //   27: aload_0
    //   28: getfield 205	com/tencent/tar/jni/ScanFeatureFilterView:mHasSurface	Z
    //   31: ifne +4 -> 35
    //   34: return
    //   35: aconst_null
    //   36: astore 4
    //   38: aconst_null
    //   39: astore 5
    //   41: aconst_null
    //   42: astore_3
    //   43: aload 4
    //   45: astore_2
    //   46: aload 5
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 134	com/tencent/tar/jni/ScanFeatureFilterView:mSurfaceHolder	Landroid/view/SurfaceHolder;
    //   53: astore 6
    //   55: aload 4
    //   57: astore_2
    //   58: aload 5
    //   60: astore_1
    //   61: aload 6
    //   63: monitorenter
    //   64: aload_3
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 134	com/tencent/tar/jni/ScanFeatureFilterView:mSurfaceHolder	Landroid/view/SurfaceHolder;
    //   70: invokeinterface 209 1 0
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +29 -> 106
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 203	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_Atap	Latap;
    //   86: ifnull +20 -> 106
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: iconst_0
    //   93: getstatic 215	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   96: invokevirtual 221	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_0
    //   102: aload_2
    //   103: invokevirtual 225	com/tencent/tar/jni/ScanFeatureFilterView:bM	(Landroid/graphics/Canvas;)V
    //   106: aload_2
    //   107: astore_1
    //   108: aload 6
    //   110: monitorexit
    //   111: aload_2
    //   112: ifnull -78 -> 34
    //   115: aload_0
    //   116: getfield 134	com/tencent/tar/jni/ScanFeatureFilterView:mSurfaceHolder	Landroid/view/SurfaceHolder;
    //   119: aload_2
    //   120: invokeinterface 228 2 0
    //   125: return
    //   126: astore_1
    //   127: ldc 230
    //   129: iconst_2
    //   130: new 232	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   137: ldc 235
    //   139: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 243	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: return
    //   156: astore_3
    //   157: aload 6
    //   159: monitorexit
    //   160: aload_1
    //   161: astore_2
    //   162: aload_3
    //   163: athrow
    //   164: astore_3
    //   165: aload_2
    //   166: astore_1
    //   167: ldc 230
    //   169: iconst_2
    //   170: new 232	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   177: ldc 254
    //   179: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_3
    //   183: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload_2
    //   196: ifnull -162 -> 34
    //   199: aload_0
    //   200: getfield 134	com/tencent/tar/jni/ScanFeatureFilterView:mSurfaceHolder	Landroid/view/SurfaceHolder;
    //   203: aload_2
    //   204: invokeinterface 228 2 0
    //   209: return
    //   210: astore_1
    //   211: ldc 230
    //   213: iconst_2
    //   214: new 232	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   221: ldc 235
    //   223: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_1
    //   227: invokevirtual 243	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: return
    //   240: astore_2
    //   241: aload_1
    //   242: ifnull +13 -> 255
    //   245: aload_0
    //   246: getfield 134	com/tencent/tar/jni/ScanFeatureFilterView:mSurfaceHolder	Landroid/view/SurfaceHolder;
    //   249: aload_1
    //   250: invokeinterface 228 2 0
    //   255: aload_2
    //   256: athrow
    //   257: astore_1
    //   258: ldc 230
    //   260: iconst_2
    //   261: new 232	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   268: ldc 235
    //   270: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_1
    //   274: invokevirtual 243	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   277: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: goto -31 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	ScanFeatureFilterView
    //   48	60	1	localObject1	Object
    //   126	35	1	localThrowable1	Throwable
    //   166	1	1	localObject2	Object
    //   210	40	1	localThrowable2	Throwable
    //   257	17	1	localThrowable3	Throwable
    //   45	159	2	localObject3	Object
    //   240	16	2	localObject4	Object
    //   42	23	3	localObject5	Object
    //   156	7	3	localObject6	Object
    //   164	19	3	localException	Exception
    //   36	20	4	localObject7	Object
    //   39	20	5	localObject8	Object
    //   53	105	6	localSurfaceHolder	SurfaceHolder
    // Exception table:
    //   from	to	target	type
    //   115	125	126	java/lang/Throwable
    //   66	76	156	finally
    //   82	89	156	finally
    //   91	99	156	finally
    //   101	106	156	finally
    //   108	111	156	finally
    //   157	160	156	finally
    //   49	55	164	java/lang/Exception
    //   61	64	164	java/lang/Exception
    //   162	164	164	java/lang/Exception
    //   199	209	210	java/lang/Throwable
    //   49	55	240	finally
    //   61	64	240	finally
    //   162	164	240	finally
    //   167	195	240	finally
    //   245	255	257	java/lang/Throwable
  }
  
  public static int kW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 255;
    case 0: 
      return 63;
    case 1: 
      return 127;
    case 2: 
      return 191;
    }
    return 229;
  }
  
  public static int kX(int paramInt)
  {
    return advf.random.nextInt(paramInt);
  }
  
  public static float z(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 1.0F;
    case 0: 
      return 0.3F;
    case 1: 
      return 0.5F;
    }
    return 0.8F;
  }
  
  protected void bM(Canvas paramCanvas)
  {
    if ((!this.bkn) && (this.mState == this.eoz) && (this.jdField_a_of_type_Atap != null) && (!this.jdField_a_of_type_Atap.dgX) && (this.jdField_a_of_type_Atap.a != null))
    {
      int j;
      Object localObject;
      if (!this.mInited)
      {
        i = 0;
        while (i < this.eoC)
        {
          j = 0;
          while (j < this.eoD)
          {
            if (this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[i][j] == null) {
              this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[i][j] = new a();
            }
            k = kX(4);
            this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[i][j].alpha = kW(k);
            this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[i][j].scale = z(k);
            j += 1;
          }
          i += 1;
        }
        localObject = this.jdField_a_of_type_Atap.a;
        this.mStartTime = currentAnimationTimeMillis();
        i = 0;
        while (i < ((atap.a)localObject).Ob())
        {
          k = ((atap.a)localObject).get(i, 0);
          j = ((atap.a)localObject).get(i, 1);
          if ((k > this.eoE) && (j > this.eoE))
          {
            k /= this.eoE;
            j /= this.eoE;
            if ((k < this.eoD) && (j < this.eoC))
            {
              a locala = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[j][k];
              locala.isValid = true;
              locala.delayTime = (kX(10) * 50);
              locala.axS = (this.mStartTime + locala.delayTime);
              locala.x = (k * this.eoE);
              locala.y = (this.eoE * j);
            }
          }
          i += 1;
        }
        this.mInited = true;
      }
      int i = 0;
      this.mPlayTime = (currentAnimationTimeMillis() - this.mStartTime);
      int k = 0;
      int m;
      while (k < this.eoC)
      {
        m = 0;
        if (m < this.eoD)
        {
          localObject = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[k][m];
          j = i;
          if (localObject != null) {
            if (((a)localObject).isValid) {}
          }
          for (;;)
          {
            m += 1;
            break;
            if (this.mPlayTime < ((a)localObject).delayTime)
            {
              i += 1;
            }
            else
            {
              float f3 = a(0, 1, ((a)localObject).b(this.eoB, this.mPlayTime - ((a)localObject).delayTime), 1.0F);
              float f2 = 255.0F * f3;
              float f1 = f2;
              if (f2 > 255.0F) {
                f1 = 255.0F;
              }
              f2 = f3;
              if (f3 > 1.0F) {
                f2 = 1.0F;
              }
              ((a)localObject).alpha = f1;
              ((a)localObject).scale = f2;
              if (((a)localObject).dgY)
              {
                ((a)localObject).reset();
              }
              else
              {
                i += 1;
                this.cR.setAlpha((int)f1);
                j = i;
                if (this.gS != null)
                {
                  j = i;
                  if (!this.gS.isRecycled())
                  {
                    int i2 = this.eoE * m;
                    j = this.eoE * k;
                    localObject = this.da;
                    int n = (int)(i2 - this.gS.getWidth() * f2 / 2.0F);
                    int i1 = (int)(j - this.gS.getHeight() * f2 / 2.0F);
                    i2 = (int)(i2 + this.gS.getWidth() * f2 / 2.0F);
                    f1 = j;
                    ((Rect)localObject).set(n, i1, i2, (int)(f2 * this.gS.getHeight() / 2.0F + f1));
                    paramCanvas.drawBitmap(this.gS, null, this.da, this.cR);
                    j = i;
                  }
                }
                i = j;
              }
            }
          }
        }
        k += 1;
      }
      if (i <= 16)
      {
        i = 0;
        while (i < this.eoC)
        {
          j = 0;
          while (j < this.eoD)
          {
            if (this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[i][j] == null) {
              this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[i][j] = new a();
            }
            this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[i][j].reset();
            j += 1;
          }
          i += 1;
        }
        this.mStartTime = currentAnimationTimeMillis();
        paramCanvas = this.jdField_a_of_type_Atap.a;
        i = 0;
        while (i < paramCanvas.Ob())
        {
          j = paramCanvas.get(i, 0);
          k = paramCanvas.get(i, 1);
          if ((j > this.eoE) && (k > this.eoE))
          {
            j /= this.eoE;
            k /= this.eoE;
            if ((j < this.eoD) && (k < this.eoC))
            {
              localObject = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a[k][j];
              m = kX(4);
              ((a)localObject).alpha = kW(m);
              ((a)localObject).scale = z(m);
              ((a)localObject).delayTime = (kX(10) * 50);
              ((a)localObject).axS = (this.mStartTime + ((a)localObject).delayTime);
              ((a)localObject).x = (j * this.eoE);
              ((a)localObject).y = (this.eoE * k);
              ((a)localObject).isValid = true;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      try
      {
        esQ();
      }
      catch (Throwable paramMessage) {}
    }
  }
  
  protected void initPaint()
  {
    this.cR.setColor(this.eoA);
    this.cR.setStyle(Paint.Style.FILL);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d("ScanFeatureFilterView", 2, "onSizeChanged ");
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.JO = getMeasuredWidth();
    this.mViewHeight = getMeasuredHeight();
    this.eoD = (this.JO / this.eoE);
    this.eoC = (this.mViewHeight / this.eoE);
    this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$a = ((a[][])Array.newInstance(a.class, new int[] { this.eoC, this.eoD }));
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("ScanFeatureFilterView", 2, "create ");
    this.mHasSurface = true;
    this.ah = new HandlerThread("FeaturePointDetecto_thread");
    this.ah.start();
    this.dV = new Handler(this.ah.getLooper(), this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("ScanFeatureFilterView", 2, "surfaceDestroyed ");
    try
    {
      this.mHasSurface = false;
      this.dV.removeCallbacksAndMessages(null);
      this.ah.quit();
      this.ah = null;
      this.dV = null;
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      QLog.e("ScanFeatureFilterView", 2, "surfaceDestroyed error = " + paramSurfaceHolder.getMessage());
    }
  }
  
  public static final class a
  {
    public float alpha;
    public long axS;
    public long delayTime;
    public boolean dgY;
    public boolean isValid;
    public float scale;
    public int x;
    public int y;
    
    public float b(int paramInt, long paramLong)
    {
      if (paramLong < this.delayTime) {
        return 0.0F;
      }
      if (paramLong - this.delayTime > paramInt) {
        this.dgY = true;
      }
      return (float)(paramLong - this.delayTime) / paramInt % 1.0F;
    }
    
    public void reset()
    {
      this.axS = ScanFeatureFilterView.currentAnimationTimeMillis();
      this.dgY = false;
      this.isValid = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tar.jni.ScanFeatureFilterView
 * JD-Core Version:    0.7.0.1
 */