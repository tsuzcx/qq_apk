import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQBlur.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(19)
public class arhv
{
  private static HandlerThread ad;
  public static int ehN = 0;
  private static Field y;
  private float BR = 1.0F;
  private float BS = 1.0F;
  private float BT;
  private float BU;
  private List<View> Jr = new ArrayList();
  private arhv.a jdField_a_of_type_Arhv$a;
  private arhv.b jdField_a_of_type_Arhv$b;
  private long avF;
  private long avG;
  private long avH;
  private long avI;
  private long avJ;
  private long avK;
  private long avL;
  private long avM;
  private long avN;
  private long avO;
  private long avP;
  private RectF bn = new RectF();
  private Handler cb;
  private boolean dbh;
  private boolean dbi;
  private int ehL = 6;
  private int ehM = 0;
  private int ehO = 2;
  private View fP;
  private volatile Bitmap gN;
  private Drawable gl = new ColorDrawable(Color.parseColor("#DAFAFAFC"));
  private Context mContext;
  private volatile View mK;
  private Paint mPaint;
  private volatile boolean mPaused = true;
  private float mScaleFactor = 8.0F;
  private String mTag;
  private Canvas s;
  
  static
  {
    ad = ThreadManagerV2.newFreeHandlerThread("QQBlur", -8);
    ad.start();
  }
  
  private void b(View paramView, List<View> paramList)
  {
    if (paramView == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (paramView.getVisibility() == 0)
      {
        paramList.add(paramView);
        setViewVisibility(paramView, 4);
        if (!(paramView instanceof ViewGroup)) {
          break;
        }
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          b(paramView.getChildAt(i), paramList);
          i += 1;
        }
      }
    }
  }
  
  private CharSequence e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "StackBlur.Java";
    case 1: 
      return "StackBlur.Native";
    case 2: 
      return "StackBlur.RS";
    }
    return "GaussBlur.RS";
  }
  
  private void eiC()
  {
    long l1 = SystemClock.elapsedRealtime();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.fP != null) && (this.mK != null) && (this.mK.getWidth() > 0) && (this.mK.getHeight() > 0))
    {
      int i = h(this.mK.getWidth(), this.mScaleFactor);
      int j = h(this.mK.getHeight(), this.mScaleFactor);
      int k = kA(i);
      int m = kA(j);
      this.BS = (j / m);
      this.BR = (i / k);
      float f1 = this.mScaleFactor * this.BR;
      float f2 = this.mScaleFactor * this.BS;
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        if (localBitmap == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QQBlur", 1, "prepareBlurBitmap: ", localException);
          localObject1 = null;
        }
        this.avL = ((Bitmap)localObject1).getWidth();
        this.avM = ((Bitmap)localObject1).getHeight();
        if (Build.VERSION.SDK_INT < 19) {
          break label482;
        }
      }
      this.avN = ((Bitmap)localObject1).getAllocationByteCount();
      ((Bitmap)localObject1).eraseColor(this.ehM);
      this.s.setBitmap((Bitmap)localObject1);
      localObject2 = new int[2];
      this.mK.getLocationInWindow((int[])localObject2);
      localObject3 = new int[2];
      this.fP.getLocationInWindow((int[])localObject3);
      this.s.save();
      this.s.translate(-(localObject2[0] - localObject3[0]) / f1, -(localObject2[1] - localObject3[1]) / f2);
      this.s.scale(1.0F / f1, 1.0F / f2);
      localObject2 = new StackBlurManager((Bitmap)localObject1);
      ((StackBlurManager)localObject2).setDbg(false);
      ((StackBlurManager)localObject2).setExecutorThreads(((StackBlurManager)localObject2).getExecutorThreads());
      localObject3 = new Bundle();
      if (this.jdField_a_of_type_Arhv$b != null) {
        this.jdField_a_of_type_Arhv$b.bn((Bundle)localObject3);
      }
      this.dbi = true;
      if ((Build.VERSION.SDK_INT <= 27) || (this.mK.getContext().getApplicationInfo().targetSdkVersion <= 27)) {
        break label495;
      }
      this.fP.draw(this.s);
    }
    for (;;)
    {
      this.s.restore();
      eiF();
      this.dbi = false;
      if (this.jdField_a_of_type_Arhv$b != null) {
        this.jdField_a_of_type_Arhv$b.bo((Bundle)localObject3);
      }
      localObject1 = new QQBlur.1(this, (StackBlurManager)localObject2);
      this.cb.post((Runnable)localObject1);
      long l2 = SystemClock.elapsedRealtime();
      this.avF += 1L;
      this.avG = (l2 - l1 + this.avG);
      return;
      label482:
      this.avN = ((Bitmap)localObject1).getByteCount();
      break;
      label495:
      Rect localRect = this.s.getClipBounds();
      localRect.inset(-((Bitmap)localObject1).getWidth(), -((Bitmap)localObject1).getHeight());
      if (this.s.clipRect(localRect, Region.Op.REPLACE)) {
        this.fP.draw(this.s);
      } else {
        QLog.e("QQBlur", 1, "prepareBlurBitmap: canvas clip rect empty. Cannot draw!!!");
      }
    }
  }
  
  private void eiD()
  {
    if ((this.mContext != null) && (this.fP != null) && (this.mK == null)) {}
  }
  
  private void eiF()
  {
    Iterator localIterator = this.Jr.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null) {
        setViewVisibility(localView, 0);
      }
    }
  }
  
  private static int h(float paramFloat1, float paramFloat2)
  {
    return (int)Math.ceil(paramFloat1 / paramFloat2);
  }
  
  public static int kA(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private void kz(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onPolicyChange() called with: from = [" + paramInt1 + "], to = [" + paramInt2 + "]");
    }
    this.avF = 0L;
    this.avG = 0L;
    this.avJ = 0L;
    this.avK = 0L;
  }
  
  private void setViewVisibility(View paramView, int paramInt)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      if (y == null)
      {
        y = View.class.getDeclaredField("mViewFlags");
        y.setAccessible(true);
      }
      int i = y.getInt(paramView);
      y.setInt(paramView, i & 0xFFFFFFF3 | paramInt & 0xC);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        long l2;
        QLog.e("QQBlur", 1, "setViewInvisible: ", paramView);
      }
    }
    l2 = SystemClock.uptimeMillis();
    if (this.avO >= 100000L)
    {
      this.avO = 0L;
      this.avP = 0L;
    }
    this.avO += 1L;
    this.avP = (l2 - l1 + this.avP);
    if (this.avO % 2000L == 0L) {}
  }
  
  public String CU()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("方案=").append(e(ehN)).append(",");
    localStringBuilder.append("缩放倍数=").append(this.mScaleFactor).append(",");
    localStringBuilder.append("模糊半径=").append(this.ehL).append(",");
    localStringBuilder.append("尺寸=" + this.avL + "x" + this.avM).append(",");
    localStringBuilder.append("空间=" + this.avN / 1000L + "KB").append(",");
    localStringBuilder.append("并发数=" + this.ehO).append(",");
    localStringBuilder.append("主线程采样=[" + String.format("%.2f", new Object[] { Float.valueOf((float)this.avG / (float)this.avF) }) + "]ms").append(",");
    localStringBuilder.append("后台线程处理=[" + String.format("%.2f", new Object[] { Float.valueOf((float)this.avK / (float)this.avJ) }) + "]ms");
    return localStringBuilder.toString();
  }
  
  public void YH(int paramInt)
  {
    this.ehL = paramInt;
  }
  
  public void YI(int paramInt)
  {
    ehN = paramInt;
  }
  
  public void YJ(int paramInt)
  {
    this.ehM = paramInt;
  }
  
  public arhv a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onCreate() called");
    }
    if (this.dbh) {}
    this.mContext = this.mK.getContext();
    this.s = new Canvas();
    this.cb = new Handler(ad.getLooper());
    this.dbh = true;
    eiD();
    return this;
  }
  
  public arhv a(View paramView)
  {
    this.fP = paramView;
    return this;
  }
  
  public arhv a(arhv.b paramb)
  {
    this.jdField_a_of_type_Arhv$b = paramb;
    return this;
  }
  
  public void a(View paramView, Canvas paramCanvas)
  {
    long l1 = SystemClock.elapsedRealtime();
    Bitmap localBitmap = this.gN;
    if (localBitmap != null)
    {
      paramCanvas.save();
      paramCanvas.scale(paramView.getWidth() * 1.0F / localBitmap.getWidth(), paramView.getHeight() * 1.0F / localBitmap.getHeight());
      if (this.mPaint == null) {
        this.mPaint = new Paint(1);
      }
      this.mPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      this.bn.set(0.0F, 0.0F, localBitmap.getWidth(), localBitmap.getHeight());
      paramCanvas.drawRoundRect(this.bn, this.BT, this.BU, this.mPaint);
      if (this.gl != null)
      {
        this.gl.setBounds(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        this.gl.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      this.avH += 1L;
      this.avI = (l2 - l1 + this.avI);
      return;
      QLog.e("QQBlur", 1, "onDrawBlur: blured bitmap is null " + Integer.toHexString(System.identityHashCode(paramView)));
    }
  }
  
  public boolean aGB()
  {
    return this.dbi;
  }
  
  public void ae(Drawable paramDrawable)
  {
    this.gl = paramDrawable;
  }
  
  public arhv b(View paramView)
  {
    this.mK = paramView;
    return this;
  }
  
  public void bg(float paramFloat)
  {
    this.mScaleFactor = paramFloat;
  }
  
  public void eiE()
  {
    this.Jr.clear();
    b(this.fP.getRootView(), this.Jr);
  }
  
  public boolean isCreated()
  {
    return this.dbh;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onDestroy() called");
    }
    if (this.dbh)
    {
      this.dbh = false;
      this.cb.removeCallbacksAndMessages(null);
      this.cb = null;
      this.fP = null;
      this.mK = null;
      this.s.setBitmap(null);
      this.s = null;
      this.mPaint = null;
      this.jdField_a_of_type_Arhv$b = null;
      this.mContext = null;
    }
  }
  
  public void onPause()
  {
    this.mPaused = true;
    QLog.i("QQBlur." + this.mTag, 2, CU());
  }
  
  public boolean onPreDraw()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Arhv$a != null) {
      bool = this.jdField_a_of_type_Arhv$a.isDirty();
    }
    for (;;)
    {
      View localView = this.mK;
      if ((!this.mPaused) && (bool) && (localView != null) && (localView.isShown()))
      {
        eiC();
        localView.invalidate();
      }
      return true;
      if (this.fP != null) {
        bool = this.fP.isDirty();
      }
    }
  }
  
  public void onResume()
  {
    this.mPaused = false;
  }
  
  public void setDebugTag(String paramString)
  {
    this.mTag = paramString;
  }
  
  public void setDirtyListener(arhv.a parama)
  {
    this.jdField_a_of_type_Arhv$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean isDirty();
  }
  
  public static abstract interface b
  {
    public abstract void bn(Bundle paramBundle);
    
    public abstract void bo(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhv
 * JD-Core Version:    0.7.0.1
 */