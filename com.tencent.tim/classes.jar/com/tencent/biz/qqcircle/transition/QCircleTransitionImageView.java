package com.tencent.biz.qqcircle.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.annotation.Nullable;

public class QCircleTransitionImageView
  extends ImageView
{
  private Matrix A = new Matrix();
  private PointF jdField_O_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_O_of_type_AndroidGraphicsRectF = new RectF();
  private PointF jdField_P_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_P_of_type_AndroidGraphicsRectF = new RectF();
  private PointF jdField_Q_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_Q_of_type_AndroidGraphicsRectF = new RectF();
  private RectF R;
  private Transform jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform = new Transform();
  private c jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$c;
  private g jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$g;
  private boolean azs;
  private boolean azt;
  private boolean azu;
  private boolean azv;
  private int bhA;
  private int bhB;
  private int bhy;
  private int bhz = 500;
  private boolean isInit;
  private float lM;
  private float lN;
  private boolean mAdjustViewBounds;
  private Matrix mBaseMatrix = new Matrix();
  private float mScale = 1.0F;
  private ImageView.ScaleType mScaleType;
  private Matrix mTmpMatrix = new Matrix();
  private Matrix z = new Matrix();
  private long zM;
  
  public QCircleTransitionImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QCircleTransitionImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QCircleTransitionImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private static int a(Drawable paramDrawable)
  {
    int j = paramDrawable.getIntrinsicWidth();
    int i = j;
    if (j <= 0) {
      i = paramDrawable.getMinimumWidth();
    }
    j = i;
    if (i <= 0) {
      j = paramDrawable.getBounds().width();
    }
    return j;
  }
  
  private static void a(View paramView, int[] paramArrayOfInt)
  {
    paramArrayOfInt[0] += paramView.getLeft();
    paramArrayOfInt[1] += paramView.getTop();
    for (paramView = paramView.getParent(); (paramView instanceof View); paramView = paramView.getParent())
    {
      paramView = (View)paramView;
      if (paramView.getId() == 16908290) {
        return;
      }
      paramArrayOfInt[0] -= paramView.getScrollX();
      paramArrayOfInt[1] -= paramView.getScrollY();
      paramArrayOfInt[0] += paramView.getLeft();
      paramArrayOfInt[1] += paramView.getTop();
    }
    paramArrayOfInt[0] = ((int)(paramArrayOfInt[0] + 0.5F));
    paramArrayOfInt[1] = ((int)(paramArrayOfInt[1] + 0.5F));
  }
  
  private static int b(Drawable paramDrawable)
  {
    int j = paramDrawable.getIntrinsicHeight();
    int i = j;
    if (j <= 0) {
      i = paramDrawable.getMinimumHeight();
    }
    j = i;
    if (i <= 0) {
      j = paramDrawable.getBounds().height();
    }
    return j;
  }
  
  private void bjR()
  {
    float f2 = 1.0F;
    if (!this.azs) {}
    while (!this.azt) {
      return;
    }
    this.mBaseMatrix.reset();
    this.z.reset();
    Drawable localDrawable = getDrawable();
    int i = getWidth();
    int j = getHeight();
    int k = a(localDrawable);
    int m = b(localDrawable);
    this.jdField_P_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, k, m);
    int n = (i - k) / 2;
    int i1 = (j - m) / 2;
    if (k > i) {}
    for (float f1 = i / k;; f1 = 1.0F)
    {
      if (m > j) {
        f2 = j / m;
      }
      if (f1 < f2)
      {
        this.mBaseMatrix.reset();
        this.mBaseMatrix.postTranslate(n, i1);
        this.mBaseMatrix.postScale(f1, f1, this.jdField_O_of_type_AndroidGraphicsPointF.x, this.jdField_O_of_type_AndroidGraphicsPointF.y);
        this.mBaseMatrix.mapRect(this.jdField_P_of_type_AndroidGraphicsRectF);
        this.lM = (this.jdField_P_of_type_AndroidGraphicsRectF.width() / 2.0F);
        this.lN = (this.jdField_P_of_type_AndroidGraphicsRectF.height() / 2.0F);
        this.jdField_P_of_type_AndroidGraphicsPointF.set(this.jdField_O_of_type_AndroidGraphicsPointF);
        this.jdField_Q_of_type_AndroidGraphicsPointF.set(this.jdField_P_of_type_AndroidGraphicsPointF);
        bka();
        switch (pdn.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.isInit = true;
        if ((this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$c != null) && (System.currentTimeMillis() - this.zM < this.bhz)) {
          a(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$c, this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$g);
        }
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$c = null;
        return;
        f1 = f2;
        break;
        bjS();
        continue;
        bjT();
        continue;
        bjU();
        continue;
        bjV();
        continue;
        bjW();
        continue;
        bjX();
        continue;
        bjY();
      }
    }
  }
  
  private void bjS()
  {
    if (!this.azs) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (!this.azt);
      Drawable localDrawable = getDrawable();
      i = a(localDrawable);
      j = b(localDrawable);
    } while ((i <= this.jdField_O_of_type_AndroidGraphicsRectF.width()) && (j <= this.jdField_O_of_type_AndroidGraphicsRectF.height()));
    float f1 = i / this.jdField_Q_of_type_AndroidGraphicsRectF.width();
    float f2 = j / this.jdField_Q_of_type_AndroidGraphicsRectF.height();
    if (f1 > f2) {}
    for (;;)
    {
      this.mScale = f1;
      this.z.postScale(this.mScale, this.mScale, this.jdField_O_of_type_AndroidGraphicsPointF.x, this.jdField_O_of_type_AndroidGraphicsPointF.y);
      bka();
      bjZ();
      return;
      f1 = f2;
    }
  }
  
  private void bjT()
  {
    float f1;
    float f2;
    if ((this.jdField_Q_of_type_AndroidGraphicsRectF.width() < this.jdField_O_of_type_AndroidGraphicsRectF.width()) || (this.jdField_Q_of_type_AndroidGraphicsRectF.height() < this.jdField_O_of_type_AndroidGraphicsRectF.height()))
    {
      f1 = this.jdField_O_of_type_AndroidGraphicsRectF.width() / this.jdField_Q_of_type_AndroidGraphicsRectF.width();
      f2 = this.jdField_O_of_type_AndroidGraphicsRectF.height() / this.jdField_Q_of_type_AndroidGraphicsRectF.height();
      if (f1 <= f2) {
        break label118;
      }
    }
    for (;;)
    {
      this.mScale = f1;
      this.z.postScale(this.mScale, this.mScale, this.jdField_O_of_type_AndroidGraphicsPointF.x, this.jdField_O_of_type_AndroidGraphicsPointF.y);
      bka();
      bjZ();
      return;
      label118:
      f1 = f2;
    }
  }
  
  private void bjU()
  {
    float f1;
    float f2;
    if ((this.jdField_Q_of_type_AndroidGraphicsRectF.width() > this.jdField_O_of_type_AndroidGraphicsRectF.width()) || (this.jdField_Q_of_type_AndroidGraphicsRectF.height() > this.jdField_O_of_type_AndroidGraphicsRectF.height()))
    {
      f1 = this.jdField_O_of_type_AndroidGraphicsRectF.width() / this.jdField_Q_of_type_AndroidGraphicsRectF.width();
      f2 = this.jdField_O_of_type_AndroidGraphicsRectF.height() / this.jdField_Q_of_type_AndroidGraphicsRectF.height();
      if (f1 >= f2) {
        break label118;
      }
    }
    for (;;)
    {
      this.mScale = f1;
      this.z.postScale(this.mScale, this.mScale, this.jdField_O_of_type_AndroidGraphicsPointF.x, this.jdField_O_of_type_AndroidGraphicsPointF.y);
      bka();
      bjZ();
      return;
      label118:
      f1 = f2;
    }
  }
  
  private void bjV()
  {
    if (this.jdField_Q_of_type_AndroidGraphicsRectF.width() < this.jdField_O_of_type_AndroidGraphicsRectF.width())
    {
      this.mScale = (this.jdField_O_of_type_AndroidGraphicsRectF.width() / this.jdField_Q_of_type_AndroidGraphicsRectF.width());
      this.z.postScale(this.mScale, this.mScale, this.jdField_O_of_type_AndroidGraphicsPointF.x, this.jdField_O_of_type_AndroidGraphicsPointF.y);
      bka();
      bjZ();
    }
  }
  
  private void bjW()
  {
    bjV();
    float f = -this.jdField_Q_of_type_AndroidGraphicsRectF.top;
    this.z.postTranslate(0.0F, f);
    bka();
    bjZ();
    this.bhB = ((int)(f + this.bhB));
  }
  
  private void bjX()
  {
    bjV();
    float f = this.jdField_O_of_type_AndroidGraphicsRectF.bottom - this.jdField_Q_of_type_AndroidGraphicsRectF.bottom;
    this.bhB = ((int)(this.bhB + f));
    this.z.postTranslate(0.0F, f);
    bka();
    bjZ();
  }
  
  private void bjY()
  {
    float f1 = this.jdField_O_of_type_AndroidGraphicsRectF.width() / this.jdField_Q_of_type_AndroidGraphicsRectF.width();
    float f2 = this.jdField_O_of_type_AndroidGraphicsRectF.height() / this.jdField_Q_of_type_AndroidGraphicsRectF.height();
    this.z.postScale(f1, f2, this.jdField_O_of_type_AndroidGraphicsPointF.x, this.jdField_O_of_type_AndroidGraphicsPointF.y);
    bka();
    bjZ();
  }
  
  private void bjZ()
  {
    Drawable localDrawable = getDrawable();
    int i = a(localDrawable);
    int j = b(localDrawable);
    this.jdField_P_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
    this.mBaseMatrix.set(this.A);
    this.mBaseMatrix.mapRect(this.jdField_P_of_type_AndroidGraphicsRectF);
    this.lM = (this.jdField_P_of_type_AndroidGraphicsRectF.width() / 2.0F);
    this.lN = (this.jdField_P_of_type_AndroidGraphicsRectF.height() / 2.0F);
    this.mScale = 1.0F;
    this.bhA = 0;
    this.bhB = 0;
    this.z.reset();
  }
  
  private void bka()
  {
    boolean bool2 = true;
    this.A.set(this.mBaseMatrix);
    this.A.postConcat(this.z);
    setImageMatrix(this.A);
    this.z.mapRect(this.jdField_Q_of_type_AndroidGraphicsRectF, this.jdField_P_of_type_AndroidGraphicsRectF);
    if (this.jdField_Q_of_type_AndroidGraphicsRectF.width() > this.jdField_O_of_type_AndroidGraphicsRectF.width())
    {
      bool1 = true;
      this.azu = bool1;
      if (this.jdField_Q_of_type_AndroidGraphicsRectF.height() <= this.jdField_O_of_type_AndroidGraphicsRectF.height()) {
        break label105;
      }
    }
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.azv = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private boolean f(Drawable paramDrawable)
  {
    return ((paramDrawable.getIntrinsicHeight() > 0) && (paramDrawable.getIntrinsicWidth() > 0)) || ((paramDrawable.getMinimumWidth() > 0) && (paramDrawable.getMinimumHeight() > 0)) || ((paramDrawable.getBounds().width() > 0) && (paramDrawable.getBounds().height() > 0));
  }
  
  private void init()
  {
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.mScaleType == null) {
      this.mScaleType = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.bhy = 340;
  }
  
  private void reset()
  {
    this.z.reset();
    bka();
    this.mScale = 1.0F;
    this.bhA = 0;
    this.bhB = 0;
  }
  
  public c a()
  {
    RectF localRectF = new RectF();
    int[] arrayOfInt = new int[2];
    a(this, arrayOfInt);
    localRectF.set(arrayOfInt[0] + this.jdField_Q_of_type_AndroidGraphicsRectF.left, arrayOfInt[1] + this.jdField_Q_of_type_AndroidGraphicsRectF.top, arrayOfInt[0] + this.jdField_Q_of_type_AndroidGraphicsRectF.right, arrayOfInt[1] + this.jdField_Q_of_type_AndroidGraphicsRectF.bottom);
    return new c(localRectF, this.jdField_Q_of_type_AndroidGraphicsRectF, this.jdField_O_of_type_AndroidGraphicsRectF, this.jdField_P_of_type_AndroidGraphicsRectF, this.jdField_O_of_type_AndroidGraphicsPointF, this.mScale, this.mScaleType);
  }
  
  public void a(c paramc, g paramg)
  {
    if (this.isInit)
    {
      reset();
      c localc = a();
      float f1 = paramc.jdField_Q_of_type_AndroidGraphicsRectF.width() / localc.jdField_Q_of_type_AndroidGraphicsRectF.width();
      float f2 = paramc.jdField_Q_of_type_AndroidGraphicsRectF.height() / localc.jdField_Q_of_type_AndroidGraphicsRectF.height();
      if (f1 < f2)
      {
        f2 = paramc.mRect.left + paramc.mRect.width() / 2.0F;
        float f3 = paramc.mRect.top + paramc.mRect.height() / 2.0F;
        float f4 = localc.mRect.left + localc.mRect.width() / 2.0F;
        float f5 = localc.mRect.top;
        f5 = localc.mRect.height() / 2.0F + f5;
        this.z.reset();
        this.z.postTranslate(f2 - f4, f3 - f5);
        this.z.postScale(f1, f1, f2, f3);
        bka();
        this.jdField_P_of_type_AndroidGraphicsPointF.set(f2, f3);
        this.jdField_Q_of_type_AndroidGraphicsPointF.set(f2, f3);
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.r(0, 0, (int)-(f2 - f4), (int)-(f3 - f5));
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.D(f1, 1.0F);
        if ((paramc.jdField_O_of_type_AndroidGraphicsRectF.width() < paramc.jdField_Q_of_type_AndroidGraphicsRectF.width()) || (paramc.jdField_O_of_type_AndroidGraphicsRectF.height() < paramc.jdField_Q_of_type_AndroidGraphicsRectF.height()))
        {
          f2 = paramc.jdField_O_of_type_AndroidGraphicsRectF.width() / paramc.jdField_Q_of_type_AndroidGraphicsRectF.width();
          f3 = paramc.jdField_O_of_type_AndroidGraphicsRectF.height() / paramc.jdField_Q_of_type_AndroidGraphicsRectF.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramc.mScaleType != ImageView.ScaleType.FIT_START) {
            break label461;
          }
          paramc = new f();
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(f1, f2, 1.0F - f1, 1.0F - f2, this.bhy / 3, paramc);
        this.mTmpMatrix.setScale(f1, f2, (this.jdField_Q_of_type_AndroidGraphicsRectF.left + this.jdField_Q_of_type_AndroidGraphicsRectF.right) / 2.0F, paramc.au());
        this.mTmpMatrix.mapRect(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.S, this.jdField_Q_of_type_AndroidGraphicsRectF);
        this.R = this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.S;
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$g = paramg;
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.start();
        return;
        f1 = f2;
        break;
        label461:
        if (paramc.mScaleType == ImageView.ScaleType.FIT_END) {
          paramc = new b();
        } else {
          paramc = new e();
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$c = paramc;
    this.zM = System.currentTimeMillis();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.R != null)
    {
      paramCanvas.clipRect(this.R);
      this.R = null;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.azs)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    Object localObject = getDrawable();
    int j = a((Drawable)localObject);
    int i = b((Drawable)localObject);
    int m = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new ViewGroup.LayoutParams(-2, -2);
    }
    label126:
    float f1;
    float f2;
    if (((ViewGroup.LayoutParams)localObject).width == -1)
    {
      paramInt1 = m;
      if (i1 == 0) {
        paramInt1 = j;
      }
      if (((ViewGroup.LayoutParams)localObject).height != -1) {
        break label257;
      }
      paramInt2 = k;
      if (n == 0) {
        paramInt2 = i;
      }
      k = paramInt1;
      m = paramInt2;
      if (this.mAdjustViewBounds)
      {
        k = paramInt1;
        m = paramInt2;
        if (j / i != paramInt1 / paramInt2)
        {
          f1 = paramInt2 / i;
          f2 = paramInt1 / j;
          if (f1 >= f2) {
            break label298;
          }
          label183:
          if (((ViewGroup.LayoutParams)localObject).width != -1) {
            break label304;
          }
          label192:
          if (((ViewGroup.LayoutParams)localObject).height != -1) {
            break label314;
          }
          m = paramInt2;
        }
      }
    }
    for (k = paramInt1;; k = paramInt1)
    {
      setMeasuredDimension(k, m);
      return;
      paramInt1 = m;
      if (i1 == 1073741824) {
        break;
      }
      if (i1 == -2147483648)
      {
        paramInt1 = m;
        if (j > m) {
          break;
        }
        paramInt1 = j;
        break;
      }
      paramInt1 = j;
      break;
      label257:
      paramInt2 = k;
      if (n == 1073741824) {
        break label126;
      }
      if (n == -2147483648)
      {
        paramInt2 = k;
        if (i > k) {
          break label126;
        }
        paramInt2 = i;
        break label126;
      }
      paramInt2 = i;
      break label126;
      label298:
      f1 = f2;
      break label183;
      label304:
      paramInt1 = (int)(j * f1);
      break label192;
      label314:
      m = (int)(i * f1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_O_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_O_of_type_AndroidGraphicsPointF.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.azt)
    {
      this.azt = true;
      bjR();
    }
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    super.setAdjustViewBounds(paramBoolean);
    this.mAdjustViewBounds = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null) {
      this.azs = false;
    }
    while (!f(paramDrawable)) {
      return;
    }
    if (!this.azs) {
      this.azs = true;
    }
    bjR();
  }
  
  public void setImageResource(int paramInt)
  {
    Object localObject = null;
    try
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      localObject = localDrawable;
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    setImageDrawable(localObject);
  }
  
  public void setImageURI(@Nullable Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = getDrawable();
    if (paramUri == null) {
      this.azs = false;
    }
    while (!f(paramUri)) {
      return;
    }
    if (!this.azs) {
      this.azs = true;
    }
    bjR();
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.setInterpolator(paramInterpolator);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX) {}
    do
    {
      do
      {
        return;
      } while (paramScaleType == this.mScaleType);
      this.mScaleType = paramScaleType;
    } while (!this.isInit);
    bjR();
  }
  
  class Transform
    implements Runnable
  {
    RectF S = new RectF();
    OverScroller jdField_a_of_type_AndroidWidgetOverScroller;
    QCircleTransitionImageView.d jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$d = new QCircleTransitionImageView.d(QCircleTransitionImageView.this, null);
    boolean azw;
    QCircleTransitionImageView.a b;
    int bhC;
    int bhD;
    Scroller e;
    Scroller f;
    
    Transform()
    {
      this$1 = QCircleTransitionImageView.this.getContext();
      this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(QCircleTransitionImageView.this, this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$d);
      this.e = new Scroller(QCircleTransitionImageView.this, this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$d);
      this.f = new Scroller(QCircleTransitionImageView.this, this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$d);
    }
    
    private void bkb()
    {
      QCircleTransitionImageView.b(QCircleTransitionImageView.this).reset();
      QCircleTransitionImageView.b(QCircleTransitionImageView.this).postTranslate(-QCircleTransitionImageView.d(QCircleTransitionImageView.this).left, -QCircleTransitionImageView.d(QCircleTransitionImageView.this).top);
      QCircleTransitionImageView.b(QCircleTransitionImageView.this).postTranslate(QCircleTransitionImageView.a(QCircleTransitionImageView.this).x, QCircleTransitionImageView.a(QCircleTransitionImageView.this).y);
      QCircleTransitionImageView.b(QCircleTransitionImageView.this).postTranslate(-QCircleTransitionImageView.a(QCircleTransitionImageView.this), -QCircleTransitionImageView.b(QCircleTransitionImageView.this));
      QCircleTransitionImageView.b(QCircleTransitionImageView.this).postScale(QCircleTransitionImageView.c(QCircleTransitionImageView.this), QCircleTransitionImageView.c(QCircleTransitionImageView.this), QCircleTransitionImageView.b(QCircleTransitionImageView.this).x, QCircleTransitionImageView.b(QCircleTransitionImageView.this).y);
      QCircleTransitionImageView.b(QCircleTransitionImageView.this).postTranslate(QCircleTransitionImageView.b(QCircleTransitionImageView.this), QCircleTransitionImageView.c(QCircleTransitionImageView.this));
      QCircleTransitionImageView.a(QCircleTransitionImageView.this);
    }
    
    private void bkc()
    {
      if (this.azw) {
        QCircleTransitionImageView.this.post(this);
      }
    }
    
    void D(float paramFloat1, float paramFloat2)
    {
      this.e.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, QCircleTransitionImageView.a(QCircleTransitionImageView.this));
    }
    
    void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, QCircleTransitionImageView.a parama)
    {
      this.f.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.b = parama;
    }
    
    void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.bhC = 0;
      this.bhD = 0;
      this.jdField_a_of_type_AndroidWidgetOverScroller.startScroll(0, 0, paramInt3, paramInt4, QCircleTransitionImageView.a(QCircleTransitionImageView.this));
    }
    
    public void run()
    {
      int j = 1;
      int k = 0;
      if (this.e.computeScrollOffset()) {
        QCircleTransitionImageView.a(QCircleTransitionImageView.this, this.e.getCurrX() / 10000.0F);
      }
      for (int i = 0;; i = 1)
      {
        if (this.jdField_a_of_type_AndroidWidgetOverScroller.computeScrollOffset())
        {
          i = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrX();
          int m = this.bhC;
          int n = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY();
          int i1 = this.bhD;
          QCircleTransitionImageView.a(QCircleTransitionImageView.this, i - m + QCircleTransitionImageView.b(QCircleTransitionImageView.this));
          QCircleTransitionImageView.b(QCircleTransitionImageView.this, n - i1 + QCircleTransitionImageView.c(QCircleTransitionImageView.this));
          this.bhC = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrX();
          this.bhD = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY();
          i = 0;
        }
        if ((this.f.computeScrollOffset()) || (QCircleTransitionImageView.a(QCircleTransitionImageView.this) != null))
        {
          float f1 = this.f.getCurrX() / 10000.0F;
          float f2 = this.f.getCurrY() / 10000.0F;
          QCircleTransitionImageView.a(QCircleTransitionImageView.this).setScale(f1, f2, (QCircleTransitionImageView.b(QCircleTransitionImageView.this).left + QCircleTransitionImageView.b(QCircleTransitionImageView.this).right) / 2.0F, this.b.au());
          QCircleTransitionImageView.a(QCircleTransitionImageView.this).mapRect(this.S, QCircleTransitionImageView.b(QCircleTransitionImageView.this));
          if (f1 == 1.0F)
          {
            this.S.left = QCircleTransitionImageView.c(QCircleTransitionImageView.this).left;
            this.S.right = QCircleTransitionImageView.c(QCircleTransitionImageView.this).right;
          }
          if (f2 == 1.0F)
          {
            this.S.top = QCircleTransitionImageView.c(QCircleTransitionImageView.this).top;
            this.S.bottom = QCircleTransitionImageView.c(QCircleTransitionImageView.this).bottom;
          }
          QCircleTransitionImageView.a(QCircleTransitionImageView.this, this.S);
        }
        if (i == 0)
        {
          bkb();
          bkc();
          return;
        }
        this.azw = false;
        i = k;
        if (QCircleTransitionImageView.a(QCircleTransitionImageView.this))
        {
          if (QCircleTransitionImageView.b(QCircleTransitionImageView.this).left > 0.0F)
          {
            QCircleTransitionImageView.a(QCircleTransitionImageView.this, (int)(QCircleTransitionImageView.b(QCircleTransitionImageView.this) - QCircleTransitionImageView.b(QCircleTransitionImageView.this).left));
            label417:
            i = 1;
          }
        }
        else
        {
          if (!QCircleTransitionImageView.b(QCircleTransitionImageView.this)) {
            break label658;
          }
          if (QCircleTransitionImageView.b(QCircleTransitionImageView.this).top <= 0.0F) {
            break label587;
          }
          QCircleTransitionImageView.b(QCircleTransitionImageView.this, (int)(QCircleTransitionImageView.c(QCircleTransitionImageView.this) - QCircleTransitionImageView.b(QCircleTransitionImageView.this).top));
          i = j;
        }
        label658:
        for (;;)
        {
          if (i != 0) {
            bkb();
          }
          QCircleTransitionImageView.this.invalidate();
          if (QCircleTransitionImageView.a(QCircleTransitionImageView.this) == null) {
            break;
          }
          QCircleTransitionImageView.a(QCircleTransitionImageView.this).bjQ();
          QCircleTransitionImageView.a(QCircleTransitionImageView.this, null);
          return;
          if (QCircleTransitionImageView.b(QCircleTransitionImageView.this).right >= QCircleTransitionImageView.c(QCircleTransitionImageView.this).width()) {
            break label417;
          }
          QCircleTransitionImageView.a(QCircleTransitionImageView.this, QCircleTransitionImageView.b(QCircleTransitionImageView.this) - (int)(QCircleTransitionImageView.c(QCircleTransitionImageView.this).width() - QCircleTransitionImageView.b(QCircleTransitionImageView.this).right));
          break label417;
          label587:
          i = j;
          if (QCircleTransitionImageView.b(QCircleTransitionImageView.this).bottom < QCircleTransitionImageView.c(QCircleTransitionImageView.this).height())
          {
            QCircleTransitionImageView.b(QCircleTransitionImageView.this, QCircleTransitionImageView.c(QCircleTransitionImageView.this) - (int)(QCircleTransitionImageView.c(QCircleTransitionImageView.this).height() - QCircleTransitionImageView.b(QCircleTransitionImageView.this).bottom));
            i = j;
          }
        }
      }
    }
    
    public void setInterpolator(Interpolator paramInterpolator)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$d.a(paramInterpolator);
    }
    
    void start()
    {
      this.azw = true;
      bkc();
    }
  }
  
  public static abstract interface a
  {
    public abstract float au();
  }
  
  public class b
    implements QCircleTransitionImageView.a
  {
    public b() {}
    
    public float au()
    {
      return QCircleTransitionImageView.b(QCircleTransitionImageView.this).bottom;
    }
  }
  
  public static class c
  {
    PointF jdField_O_of_type_AndroidGraphicsPointF = new PointF();
    RectF jdField_O_of_type_AndroidGraphicsRectF = new RectF();
    RectF P = new RectF();
    RectF Q = new RectF();
    RectF mRect = new RectF();
    float mScale;
    ImageView.ScaleType mScaleType;
    
    public c(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, RectF paramRectF4, PointF paramPointF, float paramFloat, ImageView.ScaleType paramScaleType)
    {
      this.mRect.set(paramRectF1);
      this.Q.set(paramRectF2);
      this.jdField_O_of_type_AndroidGraphicsRectF.set(paramRectF3);
      this.mScale = paramFloat;
      this.mScaleType = paramScaleType;
      this.P.set(paramRectF4);
      this.jdField_O_of_type_AndroidGraphicsPointF.set(paramPointF);
    }
  }
  
  class d
    implements Interpolator
  {
    private Interpolator e = new DecelerateInterpolator();
    
    private d() {}
    
    public void a(Interpolator paramInterpolator)
    {
      this.e = paramInterpolator;
    }
    
    public float getInterpolation(float paramFloat)
    {
      float f = paramFloat;
      if (this.e != null) {
        f = this.e.getInterpolation(paramFloat);
      }
      return f;
    }
  }
  
  public class e
    implements QCircleTransitionImageView.a
  {
    public e() {}
    
    public float au()
    {
      return (QCircleTransitionImageView.b(QCircleTransitionImageView.this).top + QCircleTransitionImageView.b(QCircleTransitionImageView.this).bottom) / 2.0F;
    }
  }
  
  public class f
    implements QCircleTransitionImageView.a
  {
    public f() {}
    
    public float au()
    {
      return QCircleTransitionImageView.b(QCircleTransitionImageView.this).top;
    }
  }
  
  public static abstract interface g
  {
    public abstract void bjQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionImageView
 * JD-Core Version:    0.7.0.1
 */