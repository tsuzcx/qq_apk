package com.tencent.mobileqq.multicard;

import ajki;
import ajkj;
import ajkk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import aqnm;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.FitSystemWindowsRelativeLayout.a;
import com.tencent.widget.FitSystemWindowsRelativeLayout.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MultiCardRootLayout
  extends FitSystemWindowsRelativeLayout
{
  private static final ArrayList<String> xJ = new ArrayList();
  private FitSystemWindowsRelativeLayout.a jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$a;
  private FitSystemWindowsRelativeLayout.b jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$b;
  private boolean cpa = true;
  private boolean cpb = true;
  private boolean cpc;
  private Paint mBackgroundPaint;
  private GestureDetector mGestureDetector;
  private WeakReference<a> mListenerRef;
  private Path mPath;
  private float mRadius = aqnm.dpToPx(18.0F);
  private RectF mRectF;
  private Paint mRectPaint;
  
  static
  {
    xJ.add("HUAWEI;VKY-AL00");
    xJ.add("Meizu;m3 note");
    xJ.add("samsung;SM-C7000");
    xJ.add("HUAWEI;JMM-AL00");
  }
  
  public MultiCardRootLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MultiCardRootLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    init();
  }
  
  private void c(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mRectPaint != null) && (paramCanvas != null)) {
      paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, this.mRectPaint);
    }
  }
  
  private void drawBackground(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    for (;;)
    {
      return;
      if (this.mBackgroundPaint == null)
      {
        this.mBackgroundPaint = new Paint();
        this.mBackgroundPaint.setColor(getResources().getColor(2131167350));
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
      }
      if (this.mRectPaint == null)
      {
        this.mRectPaint = new Paint();
        this.mRectPaint.setColor(getResources().getColor(2131167351));
        this.mRectPaint.setStyle(Paint.Style.FILL);
      }
      if (this.cpa)
      {
        this.mPath.reset();
        this.mRectF.set(0.0F, 0.0F, getWidth(), getHeight());
        this.mPath.addRoundRect(this.mRectF, this.mRadius, this.mRadius, Path.Direction.CW);
        paramCanvas.clipPath(this.mPath);
      }
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.mBackgroundPaint);
      int j = (int)(0.203704F * getHeight());
      int k = (int)(0.1034483F * getWidth());
      int i = 0;
      while (i < 5)
      {
        h(paramCanvas, k, j);
        j += (int)(0.139918F * getHeight());
        i += 1;
      }
    }
  }
  
  private void h(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i = (int)(getWidth() * 0.6275862F);
    int j = (int)(getWidth() * 0.796552F);
    int k = (int)(getHeight() * 0.02880658F);
    int m = (int)(getHeight() * 0.02469136F);
    int n = (int)(getHeight() * 0.02469136F);
    c(paramCanvas, paramInt1, paramInt2, i, k);
    c(paramCanvas, paramInt1, paramInt2 + n + k, j, m);
  }
  
  private void init()
  {
    setWillNotDraw(false);
    if ((Build.VERSION.SDK_INT <= 18) || (isInBlackList())) {
      setLayerType(1, null);
    }
    this.mPath = new Path();
    this.mRectF = new RectF();
    if (this.mGestureDetector == null) {
      this.mGestureDetector = new GestureDetector(getContext(), new ajki(this), new Handler(Looper.getMainLooper()));
    }
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$a = new ajkj(this);
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$b = new ajkk(this);
    Ma(true);
  }
  
  private boolean isInBlackList()
  {
    if ((Build.VERSION.SDK_INT == 24) && ("Xiaomi".equals(Build.MANUFACTURER)) && ("MIX".equals(Build.MODEL))) {}
    String str;
    do
    {
      do
      {
        return true;
      } while (((Build.VERSION.SDK_INT == 24) && ("HUAWEI".equals(Build.MANUFACTURER)) && ("BND-AL10".equals(Build.MODEL))) || ((Build.VERSION.SDK_INT == 24) && ("HUAWEI".equals(Build.MANUFACTURER)) && ("HUAWEI CAZ-AL10".equals(Build.MODEL))) || ((Build.VERSION.SDK_INT == 24) && ("Meizu".equals(Build.MANUFACTURER)) && ("M5 Note".equals(Build.MODEL))));
      str = Build.MANUFACTURER + ";" + Build.MODEL;
    } while (xJ.contains(str));
    return false;
  }
  
  public void Ma(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setOnInterceptTouchEventListener(this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$b);
      super.setDispatchTouchEventListener(this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$a);
      return;
    }
    super.setOnInterceptTouchEventListener(null);
    super.setDispatchTouchEventListener(null);
  }
  
  public void Mg(boolean paramBoolean)
  {
    this.cpb = paramBoolean;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (this.cpa)
    {
      this.mPath.reset();
      this.mRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      this.mPath.addRoundRect(this.mRectF, this.mRadius, this.mRadius, Path.Direction.CW);
      paramCanvas.clipPath(this.mPath);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.cpb) {
      drawBackground(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setListener(a parama)
  {
    if (parama == null)
    {
      this.mListenerRef = null;
      return;
    }
    this.mListenerRef = new WeakReference(parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(MultiCardRootLayout paramMultiCardRootLayout);
    
    public abstract boolean al(MotionEvent paramMotionEvent);
    
    public abstract boolean kt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRootLayout
 * JD-Core Version:    0.7.0.1
 */