package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import aqgz;
import aqnm;
import aqqx;
import arjl;
import atau.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class TabDragAnimationView
  extends View
{
  private static final int eis = aqnm.dpToPx(2.0F);
  float BY = 0.0F;
  float BZ = 0.0F;
  private float Ca;
  public URLDrawable P;
  private String TAG = "TabDragAnimationView@" + Integer.toHexString(hashCode());
  private GestureDetector.OnDoubleTapListener jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener;
  private a jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$a;
  private final b jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b;
  private final c jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$c;
  private final d jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$d;
  ValueAnimator aQ;
  ValueAnimator aa;
  private View.OnLongClickListener b;
  private int buz;
  private Rect cW = new Rect();
  private Paint cv = new Paint(1);
  private boolean dbG;
  protected boolean dbH = true;
  private boolean dbI;
  private boolean dbJ;
  private final boolean dbK;
  private boolean dbL = true;
  int eiA;
  private int eit;
  private int eiu;
  private int eiv = -1;
  private int eiw;
  int eix = 1;
  private int eiy = -1;
  int eiz;
  private Bitmap gP;
  private Drawable gr;
  private Drawable gs;
  private Drawable gt;
  private Drawable gu;
  private Drawable gv;
  public boolean isThemeIsAnimate;
  public boolean mAnimating;
  private boolean mDebug;
  private int mFrameIndex = 10000;
  private GestureDetector mGestureDetector;
  protected int mGravity;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  float mLastTouchX = 0.0F;
  float mLastTouchY = 0.0F;
  protected int mRealHeight;
  protected int mRealWidth;
  private Canvas t = new Canvas();
  
  public TabDragAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sr, paramInt, 0);
    try
    {
      this.mGravity = paramAttributeSet.getInt(0, 0);
      this.eit = paramAttributeSet.getDimensionPixelSize(2, 0);
      this.eiu = paramAttributeSet.getDimensionPixelSize(1, 0);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "load xml attr, expected logo width=" + this.eit + ", expected logo height=" + this.eiu);
      }
      paramAttributeSet.recycle();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$d = new d(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$c = new c(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b = new b(this);
      this.isThemeIsAnimate = ThemeUtil.isNowThemeIsAnimate();
      if ((Build.MODEL.contains("vivo")) || (Build.MANUFACTURER.contains("vivo"))) {
        bool = true;
      }
      this.dbK = bool;
      this.mGestureDetector = new GestureDetector(paramContext, new arjl(this), this.mHandler);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private boolean aGG()
  {
    return this.gv != null;
  }
  
  private void kB(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
    paramInt1 = i;
    if (i > this.eit) {
      paramInt1 = this.eit;
    }
    this.mRealWidth = paramInt1;
    if (paramInt2 > this.eiu)
    {
      paramInt1 = this.eiu;
      this.mRealHeight = paramInt1;
      if (this.eiv == -1) {
        break label163;
      }
      paramInt1 = this.eiv;
      label78:
      if (this.eiv == -1) {
        break label174;
      }
    }
    label163:
    label174:
    for (paramInt2 = this.eiv;; paramInt2 = this.mRealHeight / 10)
    {
      this.eiw = ((int)Math.sqrt(Math.pow(paramInt1, 2.0D) + Math.pow(paramInt2, 2.0D)));
      double d = Math.pow(paramInt1 + this.mRealWidth / 2, 2.0D);
      this.buz = ((int)Math.sqrt(Math.pow(this.mRealHeight / 2 + paramInt2, 2.0D) + d));
      return;
      paramInt1 = paramInt2;
      break;
      paramInt1 = this.mRealWidth / 10;
      break label78;
    }
  }
  
  public void Wx(String paramString)
  {
    this.TAG += paramString;
  }
  
  Drawable be()
  {
    if (this.isThemeIsAnimate)
    {
      if (this.P != null) {
        return this.P;
      }
      String str1 = ThemeUtil.getAnimatePathByTag(this.eiz);
      Drawable localDrawable = this.gt;
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_width", this.mRealWidth);
      localBundle.putInt("key_height", this.mRealHeight);
      localBundle.putInt("key_loop", 1);
      int i = this.eiA;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      String str2 = "- tab-" + this.eiz;
      String str3 = "- tab-" + this.eiz;
      this.P = aqqx.a(localAppRuntime, str1, str2, localDrawable, new int[] { i }, str3, localBundle);
      if (this.P != null)
      {
        this.P.setCallback(this);
        return this.P;
      }
    }
    if (this.P != null)
    {
      this.P.setCallback(null);
      this.P = null;
    }
    return this.gt;
  }
  
  /* Error */
  public void d(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: new 369	java/io/FileOutputStream
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 371	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_2
    //   11: aload_1
    //   12: getstatic 377	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   15: bipush 90
    //   17: aload_3
    //   18: invokevirtual 383	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   21: pop
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   30: return
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 389	java/io/IOException:printStackTrace	()V
    //   36: return
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload 4
    //   45: invokevirtual 390	java/lang/Exception:printStackTrace	()V
    //   48: aload_1
    //   49: ifnull -19 -> 30
    //   52: aload_1
    //   53: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 389	java/io/IOException:printStackTrace	()V
    //   62: return
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull +7 -> 74
    //   70: aload_2
    //   71: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_2
    //   77: aload_2
    //   78: invokevirtual 389	java/io/IOException:printStackTrace	()V
    //   81: goto -7 -> 74
    //   84: astore_1
    //   85: goto -19 -> 66
    //   88: astore 4
    //   90: aload_3
    //   91: astore_1
    //   92: goto -51 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	TabDragAnimationView
    //   0	95	1	paramBitmap	Bitmap
    //   0	95	2	paramString	String
    //   8	83	3	localFileOutputStream	java.io.FileOutputStream
    //   37	7	4	localException1	java.lang.Exception
    //   88	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   26	30	31	java/io/IOException
    //   0	9	37	java/lang/Exception
    //   52	56	57	java/io/IOException
    //   0	9	63	finally
    //   70	74	76	java/io/IOException
    //   11	22	84	finally
    //   43	48	84	finally
    //   11	22	88	java/lang/Exception
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.mDebug)
    {
      if (this.gP == null) {
        this.gP = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      }
      this.gP.eraseColor(-1);
      this.t.setBitmap(this.gP);
      super.draw(this.t);
      Object localObject = Environment.getExternalStorageDirectory() + "/aaaa/";
      new File((String)localObject).mkdirs();
      paramCanvas = this.gP;
      localObject = new StringBuilder().append((String)localObject);
      int i = this.mFrameIndex;
      this.mFrameIndex = (i + 1);
      d(paramCanvas, i + ".png");
    }
  }
  
  public void ejf()
  {
    if (this.dbH)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$d.reset();
      ejh();
      this.aQ.start();
      return;
    }
    stop();
  }
  
  void ejg()
  {
    if (this.aa != null)
    {
      this.aa.cancel();
      this.aa.removeUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b);
    }
    this.eix = 1;
    this.aa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    this.aa.setDuration(200L);
    this.aa.setInterpolator(new LinearInterpolator());
    this.aa.addUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b);
    this.aa.start();
  }
  
  void ejh()
  {
    if (this.aQ != null)
    {
      this.aQ.cancel();
      this.aQ.removeUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$d);
    }
    this.aQ = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.aQ.setDuration(300L);
    this.aQ.setInterpolator(new DecelerateInterpolator());
    this.aQ.addUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$d);
  }
  
  public void f(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.dbH)
    {
      this.mAnimating = true;
      this.eix = 8;
      this.BY = paramFloat1;
      this.BZ = paramFloat2;
      this.dbI = paramBoolean;
      invalidate();
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = getPaddingLeft();
    int k = getRight() - getLeft() - getPaddingRight();
    int j = getPaddingTop();
    int i = getBottom() - getTop() - getPaddingBottom();
    int i1;
    Drawable localDrawable2;
    switch (this.mGravity)
    {
    default: 
      i1 = (k + m) / 2;
      n = (i + j) / 2;
      m = i1 - this.mRealWidth / 2;
      k = i1 + this.mRealWidth / 2;
      j = n - this.mRealHeight / 2;
      i = this.mRealHeight / 2 + n;
      this.cv.setStyle(Paint.Style.STROKE);
      this.cv.setStrokeWidth(1.0F);
      if ((this.eix != 1) || (this.mAnimating)) {
        break label659;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.bSb) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.dbM)) && (this.dbG))
      {
        localDrawable2 = this.gu;
        label208:
        if (((!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.bSb) && (this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.dbM)) || (!this.dbG)) {
          break label650;
        }
      }
      break;
    }
    Drawable localDrawable3;
    label650:
    for (Drawable localDrawable1 = be();; localDrawable1 = this.gr)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.mScale != 1.0F) {
        paramCanvas.scale(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.mScale, this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.mScale, i1, n);
      }
      if (localDrawable1 != null)
      {
        localDrawable1.setBounds(m, j, k, i);
        if (!aGG()) {
          localDrawable1.draw(paramCanvas);
        }
        this.cv.setColor(-65536);
        this.cW.set(localDrawable1.getBounds());
      }
      localDrawable3 = localDrawable1;
      if (localDrawable2 != null)
      {
        localDrawable3 = localDrawable1;
        if (this.dbH)
        {
          localDrawable2.setBounds(m, j, k, i);
          if (!aGG()) {
            localDrawable2.draw(paramCanvas);
          }
          this.cv.setColor(-16776961);
          localDrawable3 = localDrawable1;
        }
      }
      if ((aGG()) && (localDrawable3 != null))
      {
        this.gv.setBounds(localDrawable3.getBounds());
        this.gv.draw(paramCanvas);
      }
      return;
      i1 = (m + k) / 2;
      n = j + this.mRealHeight / 2;
      m = i1 - this.mRealWidth / 2;
      k = i1 + this.mRealWidth / 2;
      i = this.mRealHeight + j;
      break;
      i1 = (m + k) / 2;
      n = i - this.mRealHeight / 2;
      m = i1 - this.mRealWidth / 2;
      k = i1 + this.mRealWidth / 2;
      j = i - this.mRealHeight;
      break;
      i1 = m + this.mRealWidth / 2;
      n = (i + j) / 2;
      k = m + this.mRealWidth;
      j = n - this.mRealHeight / 2;
      i = this.mRealHeight / 2 + n;
      break;
      i1 = k - this.mRealWidth / 2;
      n = (i + j) / 2;
      m = k - this.mRealWidth / 2;
      j = n - this.mRealHeight / 2;
      i = this.mRealHeight / 2 + n;
      break;
      localDrawable2 = this.gs;
      break label208;
    }
    label659:
    label672:
    label685:
    double d2;
    double d1;
    label777:
    label789:
    int i3;
    label810:
    label818:
    int i4;
    int i5;
    label846:
    int i2;
    if (this.dbG)
    {
      localDrawable2 = this.gu;
      if (!this.dbG) {
        break label1019;
      }
      localDrawable1 = be();
      if ((int)Math.sqrt(Math.pow(this.mRealWidth / 2 + Math.abs(this.BY), 2.0D) + Math.pow(this.mRealHeight / 2 + Math.abs(this.BZ), 2.0D)) <= this.buz) {
        break label1131;
      }
      if ((this.BY != 0.0F) && (this.BZ != 0.0F)) {
        break label1057;
      }
      if (this.BY == 0.0F) {
        break label1028;
      }
      d2 = this.eiw;
      d1 = 0.0D;
      if (this.BY <= 0.0F) {
        break label1119;
      }
      n = 1;
      i3 = (int)(d2 * n);
      if (this.BZ <= 0.0F) {
        break label1125;
      }
      n = 1;
      n = (int)(d1 * n);
      i4 = i3 * 2;
      i5 = n * 2;
      if (localDrawable1 != null)
      {
        if (!this.dbI) {
          break label1148;
        }
        i1 = m;
        if (!this.dbI) {
          break label1158;
        }
        i2 = j;
        label857:
        if (!this.dbI) {
          break label1168;
        }
        i3 = k;
        label868:
        if (!this.dbI) {
          break label1178;
        }
      }
    }
    label1028:
    label1158:
    label1168:
    label1178:
    for (int n = i;; n = i - n)
    {
      localDrawable1.setBounds(i1, i2, i3, n);
      if (!aGG()) {
        localDrawable1.draw(paramCanvas);
      }
      this.cv.setColor(-65536);
      this.cW.set(localDrawable1.getBounds());
      if ((localDrawable2 != null) && (this.dbH))
      {
        paramCanvas.save();
        localDrawable2.setBounds(m - i4, j - i5, k - i4, i - i5);
        if (!aGG())
        {
          if (!this.dbG) {}
          localDrawable2.draw(paramCanvas);
        }
        this.cv.setColor(-16776961);
        paramCanvas.restore();
      }
      localDrawable3 = localDrawable1;
      break;
      localDrawable2 = this.gs;
      break label672;
      label1019:
      localDrawable1 = this.gr;
      break label685;
      if (this.BZ != 0.0F)
      {
        d2 = 0.0D;
        d1 = this.eiw;
        break label777;
      }
      d2 = 0.0D;
      d1 = 0.0D;
      break label777;
      label1057:
      d1 = Math.pow(this.BZ, 2.0D) / Math.pow(this.BY, 2.0D);
      d2 = this.eiw * (1.0D / Math.sqrt(1.0D + d1));
      double d3 = this.eiw;
      d1 = Math.sqrt(d1 / (1.0D + d1)) * d3;
      break label777;
      label1119:
      n = -1;
      break label789;
      label1125:
      n = -1;
      break label810;
      label1131:
      i3 = (int)this.BY;
      n = (int)this.BZ;
      break label818;
      label1148:
      i1 = m - i3;
      break label846;
      i2 = j - n;
      break label857;
      i3 = k - i3;
      break label868;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = this.eit;
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = this.eiu;
    paramInt1 = resolveSizeAndState(m + n + i1, paramInt1, 0);
    paramInt2 = resolveSizeAndState(i + j + k, paramInt2, 0);
    View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    kB(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener != null) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    if ((this.gv != null) && ((this.gv instanceof Animatable)) && (!((Animatable)this.gv).isRunning())) {
      setClickAnimationDrawable(null);
    }
    int i = getPaddingLeft();
    int i1 = getRight();
    int i2 = getLeft();
    int i3 = getPaddingRight();
    int j = getPaddingTop();
    int k = getBottom();
    int m = getTop();
    int n = getPaddingBottom();
    i = (i + (i1 - i2 - i3)) / 2;
    i2 = (j + (k - m - n)) / 2;
    j = (int)Math.sqrt(Math.pow(this.mRealWidth / 2.0D, 2.0D) + Math.pow(this.mRealHeight / 2.0D, 2.0D));
    k = getWidth();
    m = getHeight();
    n = paramMotionEvent.getActionMasked();
    float f1;
    float f2;
    double d;
    switch (n)
    {
    default: 
      return false;
    case 3: 
      if (this.dbK)
      {
        i1 = (int)(aqgz.hL() - aqnm.dip2px(14.0F));
        if (this.Ca > i1)
        {
          this.mLastTouchX = 0.0F;
          this.mLastTouchY = 0.0F;
          this.Ca = 0.0F;
          this.eiy = -1;
          this.dbJ = false;
          if (this.mAnimating) {
            ejf();
          }
          return false;
        }
      }
    case 1: 
      this.eiy = -1;
      this.dbJ = false;
      if (this.mAnimating) {
        ejf();
      }
      i1 = (int)Math.sqrt(Math.pow(this.mLastTouchX - i, 2.0D) + Math.pow(this.mLastTouchY - i2, 2.0D)) + eis;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      d = Math.pow(f1 - i, 2.0D);
      i2 = (int)Math.sqrt(Math.pow(f2 - i2, 2.0D) + d);
      if (((i1 >= j) || (i2 <= j)) && (f1 > 0.0F) && (f1 < k) && (f2 > 0.0F) && (f2 < m)) {}
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$a != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$a.bRI();
        }
        if ((this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener == null) && (getParent() != null) && (i != 0))
        {
          ((ViewGroup)getParent()).performClick();
          if (QLog.isColorLevel())
          {
            float f3 = paramMotionEvent.getRawX();
            float f4 = paramMotionEvent.getRawY();
            QLog.d(this.TAG, 2, "TabDragView perform click, action=" + n + ", ux=" + f1 + ", uy=" + f2 + ", urx=" + f3 + ", ury=" + f4 + ", w=" + k + ", vh=" + m + ", radius=" + i1 + ", innerRadius=" + j + ", upRidus=" + i2);
          }
        }
        return true;
      }
    case 0: 
      this.mLastTouchX = paramMotionEvent.getX();
      this.mLastTouchY = paramMotionEvent.getY();
      this.Ca = paramMotionEvent.getRawY();
      this.eiy = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
      d = Math.pow(this.mLastTouchX - i, 2.0D);
      if ((int)Math.sqrt(Math.pow(this.mLastTouchY - i2, 2.0D) + d) <= j)
      {
        if (!this.dbG) {
          break label746;
        }
        stop();
      }
      for (;;)
      {
        return true;
        label746:
        if (this.dbL) {
          ejg();
        }
      }
    }
    if (this.dbH)
    {
      j = paramMotionEvent.findPointerIndex(this.eiy);
      if (j == -1)
      {
        this.dbJ = false;
        return false;
      }
      f1 = paramMotionEvent.getX(j);
      f2 = paramMotionEvent.getY(j);
      d = Math.pow(f1 - i, 2.0D);
      if (((int)Math.sqrt(Math.pow(f2 - i2, 2.0D) + d) <= this.buz) && ((f1 != this.mLastTouchX) || (f2 != this.mLastTouchY)))
      {
        f1 = this.mLastTouchX;
        f1 = this.mLastTouchY;
        this.dbJ = true;
      }
      for (;;)
      {
        if (this.dbJ) {}
        return this.dbJ;
        if (this.dbJ)
        {
          f1 = this.mLastTouchX;
          f1 = this.mLastTouchY;
        }
      }
    }
    return false;
  }
  
  public void setAnimEnable(boolean paramBoolean)
  {
    this.dbH = paramBoolean;
    invalidate();
  }
  
  public void setBgDrawable(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setBgDrawable() called with: bgId = [" + paramInt + "]");
    }
    if (paramInt != -1)
    {
      this.gr = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setBgPressedDrawable(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setBgPressedDrawable() called with: bgPressId = [" + paramInt + "]");
    }
    if (paramInt != -1)
    {
      this.gt = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setClickAnimationDrawable(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setClickAnimationDrawable() called with: drawable = [" + paramDrawable + "]");
    }
    Drawable localDrawable = this.gv;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.gv = paramDrawable;
    if (this.gv != null) {
      this.gv.setCallback(this);
    }
    invalidate();
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.mDebug = paramBoolean;
  }
  
  public void setEmotionDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Resources localResources = getResources();
    this.eiz = paramInt5;
    this.eiA = paramInt6;
    if (paramInt1 != -1) {
      this.gs = localResources.getDrawable(paramInt1);
    }
    if (paramInt2 != -1) {
      this.gr = localResources.getDrawable(paramInt2);
    }
    if (paramInt3 != -1) {
      this.gu = localResources.getDrawable(paramInt3);
    }
    if (paramInt4 != -1) {
      this.gt = localResources.getDrawable(paramInt4);
    }
  }
  
  public void setEmotionDrawable(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    this.gs = paramDrawable1;
    this.gr = paramDrawable2;
    this.gu = paramDrawable3;
    this.gt = paramDrawable4;
  }
  
  public void setEnableClickScaleAnimation(boolean paramBoolean)
  {
    this.dbL = paramBoolean;
  }
  
  public void setExpectedLogoMoveDistance(int paramInt)
  {
    this.eiv = paramInt;
    if (paramInt != -1) {
      this.eiw = ((int)Math.sqrt(Math.pow(this.eiv, 2.0D) * 2.0D));
    }
  }
  
  public void setFaceDrawable(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setFaceDrawable() called with: faceId = [" + paramInt + "]");
    }
    if (paramInt != -1) {}
    for (this.gs = getResources().getDrawable(paramInt);; this.gs = null)
    {
      invalidate();
      return;
    }
  }
  
  public void setFacePressedDrawable(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setFacePressedDrawable() called with: facePressId = [" + paramInt + "]");
    }
    if (paramInt != -1) {}
    for (this.gu = getResources().getDrawable(paramInt);; this.gu = null)
    {
      invalidate();
      return;
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 3) || (paramInt == 4) || (paramInt == 1) || (paramInt == 2))
    {
      this.mGravity = paramInt;
      invalidate();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.TAG, 2, "unsupported gravity=" + paramInt);
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    Drawable localDrawable;
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.bSb) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$b.dbM)) && (this.dbG))
    {
      localDrawable = this.gt;
      if (paramInt2 < 0) {
        break label113;
      }
      this.eiu = paramInt2;
      label41:
      if (paramInt1 < 0) {
        break label128;
      }
      this.eit = paramInt1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setIconSize, mExpectedLogoWidth=" + this.eit + ", mExpectedLogoHeight=" + this.eiu);
      }
      requestLayout();
      return;
      localDrawable = this.gr;
      break;
      label113:
      if (localDrawable == null) {
        break label41;
      }
      this.eiu = localDrawable.getIntrinsicHeight();
      break label41;
      label128:
      if (localDrawable != null) {
        this.eit = localDrawable.getIntrinsicWidth();
      }
    }
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener = paramOnDoubleTapListener;
  }
  
  public void setOnDragListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$a = parama;
  }
  
  public void setOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    super.setOnLongClickListener(paramOnLongClickListener);
    this.b = paramOnLongClickListener;
  }
  
  public void setPressChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setPressChanged() called with: enable = [" + paramBoolean + "]");
    }
    this.dbG = paramBoolean;
    if ((this.P != null) && (this.P == be()))
    {
      Drawable localDrawable = this.P.getCurrDrawable();
      if ((localDrawable instanceof ApngDrawable)) {
        ((ApngDrawable)localDrawable).repaly();
      }
    }
    invalidate();
  }
  
  public void stop()
  {
    this.BY = 0.0F;
    this.BZ = 0.0F;
    this.mAnimating = false;
    invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void bRI();
  }
  
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    boolean bSb = false;
    private final TabDragAnimationView c;
    boolean dbM = false;
    float mScale = 1.0F;
    
    b(TabDragAnimationView paramTabDragAnimationView)
    {
      this.c = paramTabDragAnimationView;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      if (f - this.mScale > 0.0F) {
        this.bSb = true;
      }
      if ((this.bSb) && (f > 0.8F)) {
        this.dbM = false;
      }
      this.mScale = f;
      this.c.stop();
      if (QLog.isColorLevel()) {
        QLog.d(TabDragAnimationView.class.getSimpleName(), 2, "do mScale animation, percent=" + this.mScale + ",reversed=" + this.bSb + ",doAnim=" + this.dbM);
      }
    }
  }
  
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    private final TabDragAnimationView c;
    
    c(TabDragAnimationView paramTabDragAnimationView)
    {
      this.c = paramTabDragAnimationView;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      this.c.f(f, 0.0F, true);
    }
  }
  
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float Cb;
    private float Cc;
    private float Cd;
    private float Ce;
    float Cf = 0.0F;
    float Cg = 0.0F;
    private final TabDragAnimationView c;
    
    d(TabDragAnimationView paramTabDragAnimationView)
    {
      this.c = paramTabDragAnimationView;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      if ((f2 < 0.1F) && (this.Cf == 0.0F) && (this.Cg == 0.0F))
      {
        this.c.eix = 1;
        this.c.stop();
        paramValueAnimator.cancel();
        paramValueAnimator.removeUpdateListener(this);
        this.c.aQ = null;
        return;
      }
      float f1;
      if (f2 < 0.1F)
      {
        f1 = this.Cd;
        if (f2 >= 0.1F) {
          break label126;
        }
      }
      label126:
      for (f2 = this.Ce;; f2 = this.Ce * (1.0F - f2))
      {
        this.c.f(this.Cb - f1, this.Cc - f2, false);
        return;
        f1 = this.Cd * (1.0F - f2);
        break;
      }
    }
    
    void reset()
    {
      this.Cb = this.c.BY;
      this.Cc = this.c.BZ;
      this.Cd = (this.Cb - this.Cf);
      this.Ce = (this.Cc - this.Cg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */