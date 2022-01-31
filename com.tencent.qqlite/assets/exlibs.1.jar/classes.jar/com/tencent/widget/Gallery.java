package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;
import fhm;
import fig;
import fih;
import fii;
import fij;
import fik;

public class Gallery
  extends AbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static final int A = 0;
  private static final int B = 1;
  private static final int C = 2;
  private static int I = 20;
  public static float a = 0.0F;
  public static final int a = 2131296388;
  private static RectF jdField_a_of_type_AndroidGraphicsRectF;
  private static final String jdField_a_of_type_JavaLangString = "Gallery";
  public static final int b = 2131296385;
  private static Rect jdField_b_of_type_AndroidGraphicsRect;
  public static final int c = 2131296386;
  private static final boolean jdField_d_of_type_Boolean = false;
  private static final float jdField_j_of_type_Float = 1.5F;
  public static final int j = 2131296389;
  public static final int k = 2131296390;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  private static final int p;
  private static final int q;
  private static final int r = 0;
  private static final int jdField_s_of_type_Int = 250;
  private static final int z = -1;
  private int D = -1;
  private int E;
  private int F;
  private int G;
  private int H;
  double jdField_a_of_type_Double = 0.0D;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this);
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  public View a;
  private AdapterView.AdapterContextMenuInfo jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo;
  Gallery.OnItemRotateListener jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener;
  public Gallery.OnScollListener a;
  private ScaleGestureDetector jdField_a_of_type_ComTencentWidgetScaleGestureDetector;
  private fii jdField_a_of_type_Fii = new fii(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new fig(this);
  float jdField_b_of_type_Float = 0.0F;
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  boolean jdField_c_of_type_Boolean = true;
  float jdField_d_of_type_Float;
  float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean;
  float jdField_f_of_type_Float;
  private boolean jdField_f_of_type_Boolean = true;
  private float jdField_g_of_type_Float;
  public long g;
  private boolean jdField_g_of_type_Boolean = true;
  private float jdField_h_of_type_Float = 1.0F;
  long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  private float jdField_i_of_type_Float = jdField_a_of_type_Float;
  private boolean jdField_i_of_type_Boolean;
  private boolean jdField_j_of_type_Boolean;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int = 0;
  private boolean jdField_t_of_type_Boolean = false;
  private int jdField_u_of_type_Int = 400;
  private boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int;
  private boolean jdField_v_of_type_Boolean = true;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean = false;
  private int x;
  private int y;
  
  static
  {
    jdField_p_of_type_Int = a("Gallery_spacing");
    jdField_q_of_type_Int = a("Gallery_animationDuration");
    jdField_b_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    jdField_a_of_type_Float = 2.0F;
  }
  
  public Gallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Gallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842864);
  }
  
  public Gallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.s = false;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(true);
    this.jdField_a_of_type_AndroidViewGestureDetector.setOnDoubleTapListener(this);
    this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
    paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, a("Gallery"), paramInt, 0));
    paramInt = paramAttributeSet.a(jdField_q_of_type_Int, -1);
    if (paramInt > 0) {
      setAnimationDuration(paramInt);
    }
    setSpacing(paramAttributeSet.d(jdField_p_of_type_Int, 0));
    paramAttributeSet.a();
    if (!VersionUtils.e()) {
      setStaticTransformationsEnabled(true);
    }
    this.y = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.jdField_g_of_type_Float = TypedValue.applyDimension(1, 2400.0F, paramContext.getResources().getDisplayMetrics());
    setFadingEdgeLength(0);
  }
  
  private double a(float paramFloat1, float paramFloat2)
  {
    double d2 = Math.atan(paramFloat2 / paramFloat1);
    double d1;
    if (paramFloat1 < 0.0F) {
      d1 = d2 + 3.141592653589793D;
    }
    do
    {
      return d1;
      d1 = d2;
    } while (d2 >= 0.0D);
    return d2 + 6.283185307179586D;
  }
  
  private int a()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  private int a(boolean paramBoolean, int paramInt1, int paramInt2, Point paramPoint)
  {
    if (paramBoolean) {}
    View localView2;
    for (int i1 = this.aA - 1;; i1 = 0)
    {
      localView2 = getChildAt(i1 - this.ao);
      if ((localView2 != null) || (this.D == 1) || (((!paramBoolean) || (!this.m)) && ((paramBoolean) || (!this.l)))) {
        break label158;
      }
      if ((this.D != 0) && (Math.abs(paramInt1) <= Math.abs(paramInt2))) {
        break;
      }
      paramPoint.x = paramInt1;
      paramPoint.y = 0;
      this.D = 0;
      return this.D;
    }
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    if (jdField_b_of_type_AndroidGraphicsRect.height() < this.F)
    {
      paramPoint.x = 0;
      paramPoint.y = 0;
      return this.D;
    }
    this.m = false;
    this.l = false;
    label158:
    if (this.D != 0) {
      this.D = 1;
    }
    View localView1;
    if ((!paramBoolean) || (this.m))
    {
      localView1 = localView2;
      if (!paramBoolean)
      {
        localView1 = localView2;
        if (this.l) {}
      }
    }
    else
    {
      localView1 = this.jdField_a_of_type_AndroidViewView;
    }
    a(localView1, jdField_b_of_type_AndroidGraphicsRect);
    int i2;
    if (paramBoolean)
    {
      i2 = this.E - this.jdField_a_of_type_AndroidGraphicsRect.right - jdField_b_of_type_AndroidGraphicsRect.right;
      if (i2 > 0) {
        i1 = paramInt1 / 4;
      }
    }
    for (;;)
    {
      if (paramInt2 < 0)
      {
        paramInt1 = 1;
        label257:
        if (jdField_b_of_type_AndroidGraphicsRect.height() >= this.F) {
          break label380;
        }
        paramInt1 = 0;
        label272:
        if (i1 <= this.E) {
          break label491;
        }
        paramInt2 = this.E;
      }
      for (;;)
      {
        paramPoint.x = paramInt2;
        paramPoint.y = paramInt1;
        return this.D;
        i1 = paramInt1;
        if (paramInt1 >= i2) {
          break;
        }
        i1 = (paramInt1 - i2) / 4 + i2;
        break;
        i1 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
        if (i1 < 0)
        {
          i1 = paramInt1 / 4;
          break;
        }
        if (paramInt1 <= i1) {
          break label516;
        }
        i1 = (paramInt1 - i1) / 4 + i1;
        break;
        paramInt1 = 0;
        break label257;
        label380:
        if (paramInt1 != 0)
        {
          i2 = this.F - this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_AndroidGraphicsRect.bottom;
          if (i2 > 0)
          {
            paramInt1 = paramInt2 / 4;
            break label272;
          }
          paramInt1 = paramInt2;
          if (i1 >= i2) {
            break label272;
          }
          paramInt1 = (paramInt2 - i2) / 6 + i2;
          break label272;
        }
        i2 = this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.top;
        if (i2 < 0)
        {
          paramInt1 = paramInt2 / 4;
          break label272;
        }
        paramInt1 = paramInt2;
        if (i1 <= i2) {
          break label272;
        }
        paramInt1 = (paramInt2 - i2) / 6 + i2;
        break label272;
        label491:
        if (i1 < -this.E) {
          paramInt2 = -this.E;
        } else {
          paramInt2 = i1;
        }
      }
      label516:
      i1 = paramInt1;
    }
  }
  
  @TargetApi(11)
  private Matrix a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if (VersionUtils.e()) {
      return paramView.getMatrix();
    }
    return fik.a(a(paramView));
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    int i2 = getMeasuredWidth();
    int i1 = getMeasuredHeight();
    switch (paramInt3 & 0x70)
    {
    default: 
      i1 = 0;
      switch (paramInt3 & 0x7)
      {
      case 4: 
      default: 
        paramInt3 = (i2 - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right - paramInt1) / 2;
        if (paramBoolean)
        {
          paramInt3 = paramInt4 + paramInt3;
          paramInt4 = paramInt3 + paramInt1;
          paramInt1 = paramInt3;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      localRect.left = paramInt1;
      localRect.top = i1;
      localRect.right = paramInt4;
      localRect.bottom = (i1 + paramInt2);
      return localRect;
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      break;
      int i3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      int i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      int i5 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i1 = (i1 - i3 - i4 - paramInt2) / 2 + i5;
      break;
      i1 = i1 - this.jdField_a_of_type_AndroidGraphicsRect.bottom - paramInt2;
      break;
      if (paramBoolean)
      {
        paramInt3 = paramInt4;
        paramInt4 += paramInt1;
        paramInt1 = paramInt3;
      }
      else
      {
        paramInt1 = paramInt4 - paramInt1;
        continue;
        paramInt1 = paramInt4 - paramInt1 - paramInt3;
        paramInt4 -= paramInt3;
      }
    }
  }
  
  @TargetApi(11)
  private Rect a(View paramView, Rect paramRect)
  {
    if (paramView == null)
    {
      paramView = new Rect();
      return paramView;
    }
    jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    if (VersionUtils.e()) {}
    for (Matrix localMatrix = paramView.getMatrix();; localMatrix = fik.a(a(paramView)))
    {
      localMatrix.mapRect(jdField_a_of_type_AndroidGraphicsRectF);
      jdField_a_of_type_AndroidGraphicsRectF.offset(paramView.getLeft(), paramView.getTop());
      jdField_a_of_type_AndroidGraphicsRectF.round(paramRect);
      paramView = paramRect;
      if (paramRect.width() >= this.E) {
        break;
      }
      int i1 = (this.E - paramRect.width()) / 2;
      int i2 = this.E;
      int i3 = paramRect.width();
      paramRect.set(paramRect.left - i1, paramRect.top, i2 - i3 - i1 + paramRect.right, paramRect.bottom);
      return paramRect;
    }
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    Object localObject;
    if (!this.jdField_q_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_Fhm.a(paramInt1);
      if (localObject != null)
      {
        paramInt1 = ((View)localObject).getLeft();
        this.jdField_w_of_type_Int = Math.max(this.jdField_w_of_type_Int, ((View)localObject).getMeasuredWidth() + paramInt1);
        this.jdField_v_of_type_Int = Math.min(this.jdField_v_of_type_Int, paramInt1);
        a((View)localObject, paramInt2, paramInt3, paramBoolean, true);
      }
    }
    View localView;
    do
    {
      return localObject;
      localView = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(paramInt1, null, this);
      a(paramInt1, this, paramBoolean, false);
      a(localView, paramInt2, paramInt3, paramBoolean, false);
      localObject = localView;
    } while (paramView == null);
    a(paramView, localView);
    return localView;
  }
  
  private fij a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    fij localfij = new fij(null);
    int i3 = 0;
    if (paramView.getTag(2131296389) != null) {
      i3 = ((Integer)paramView.getTag(2131296389)).intValue();
    }
    localfij.jdField_a_of_type_Int = i3;
    if (paramView.getTag(2131296386) != null)
    {
      localfij.jdField_a_of_type_Float = ((Float)paramView.getTag(2131296386)).floatValue();
      localfij.b = 17;
      return localfij;
    }
    int i2;
    int i1;
    if (i3 != 1)
    {
      i2 = paramInt1;
      i1 = paramInt2;
      if (i3 != 3) {}
    }
    else
    {
      i1 = paramInt1;
      i2 = paramInt2;
    }
    paramInt1 = i1 * paramInt3 / i2;
    if (i2 >= paramInt3) {
      if (paramInt4 >= paramInt1)
      {
        localfij.jdField_a_of_type_Float = (paramInt3 / i2);
        localfij.b = 17;
      }
    }
    for (;;)
    {
      return localfij;
      if (paramInt4 * 1.5F >= paramInt1)
      {
        localfij.jdField_a_of_type_Float = (paramInt4 / i1);
        localfij.b = 17;
      }
      else
      {
        localfij.jdField_a_of_type_Float = (paramInt3 / i2);
        localfij.b = 48;
        continue;
        if (i1 < paramInt4)
        {
          if (paramInt4 >= paramInt1)
          {
            if (i2 * 1.5F >= paramInt3)
            {
              localfij.b = 17;
              localfij.jdField_a_of_type_Float = (paramInt3 / i2);
            }
            else
            {
              localfij.jdField_a_of_type_Float = 1.0F;
              localfij.b = 17;
            }
          }
          else if (i1 * 1.5F >= paramInt4)
          {
            localfij.b = 17;
            localfij.jdField_a_of_type_Float = (paramInt4 / i1);
          }
          else
          {
            localfij.jdField_a_of_type_Float = 1.0F;
            localfij.b = 17;
          }
        }
        else
        {
          localfij.jdField_a_of_type_Float = 1.0F;
          localfij.b = 48;
        }
      }
    }
  }
  
  private fik a(View paramView)
  {
    fik localfik2 = (fik)paramView.getTag(2131296388);
    fik localfik1 = localfik2;
    if (localfik2 == null)
    {
      localfik1 = new fik();
      paramView.setTag(2131296388, localfik1);
    }
    if (localfik1.jdField_a_of_type_Boolean) {
      a(localfik1);
    }
    return localfik1;
  }
  
  private void a(float paramFloat)
  {
    int i1 = getChildCount();
    if ((i1 == 0) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    View localView;
    float f1;
    Object localObject;
    do
    {
      return;
      localView = getChildAt(0);
      if (i1 != 1) {
        break;
      }
      f1 = b(this.jdField_a_of_type_AndroidViewView);
      localObject = this.jdField_a_of_type_AndroidViewView.getTag(2131296385);
    } while ((localObject == null) || (!(localObject instanceof Float)));
    if (this.jdField_a_of_type_AndroidViewView.getTag(2131296389) != null) {}
    for (i1 = ((Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131296389)).intValue();; i1 = 0)
    {
      float f2 = ((Float)localObject).floatValue();
      float f3 = c(this.jdField_a_of_type_AndroidViewView);
      int i2 = b((int)f3, i1);
      float f5 = c((int)f3, i2);
      float f6 = i2 * 90;
      int i3 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
      int i4 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
      int i5 = getMeasuredWidth();
      int i6 = getMeasuredHeight();
      if (paramFloat == 0.0F) {
        if (i2 != i1)
        {
          this.jdField_a_of_type_AndroidViewView.setTag(2131296389, Integer.valueOf(i2));
          localObject = a(i3, i4, i5, i6, this.jdField_a_of_type_AndroidViewView);
          f2 = ((fij)localObject).jdField_a_of_type_Float;
          this.jdField_a_of_type_AndroidViewView.setTag(2131296385, Float.valueOf(((fij)localObject).jdField_a_of_type_Float));
          paramFloat = f2;
          if (this.jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener != null)
          {
            this.jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener.a(this.jdField_a_of_type_AndroidViewView, p(), i2);
            paramFloat = f2;
          }
        }
      }
      for (;;)
      {
        i2 = 0;
        i1 = 0;
        if ((f1 != paramFloat) || (f6 != f5))
        {
          a(this.jdField_a_of_type_AndroidViewView, paramFloat);
          b(this.jdField_a_of_type_AndroidViewView, f6);
          a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
          a(this.jdField_a_of_type_AndroidViewView, f1);
          b(this.jdField_a_of_type_AndroidViewView, f5);
          label340:
          if (jdField_b_of_type_AndroidGraphicsRect.right >= this.E + this.jdField_a_of_type_AndroidGraphicsRect.left) {
            break label537;
          }
          i2 = this.E + this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.right;
          label382:
          if (jdField_b_of_type_AndroidGraphicsRect.height() >= this.F) {
            break label572;
          }
          i1 = this.jdField_a_of_type_AndroidGraphicsRect.top + (this.F - jdField_b_of_type_AndroidGraphicsRect.height()) / 2 - jdField_b_of_type_AndroidGraphicsRect.top;
        }
        for (;;)
        {
          if ((f1 == paramFloat) && (f6 == f5)) {
            break label652;
          }
          this.jdField_a_of_type_Fii.a(i2, i1, f1, paramFloat, f5, f6);
          return;
          f3 = Math.min(f2, this.jdField_h_of_type_Float);
          float f4 = Math.max(f2, this.jdField_i_of_type_Float);
          if (Math.abs(f1 - f2) < 1.E-005D)
          {
            paramFloat = f2;
            break;
          }
          paramFloat = f3;
          if (f1 < f3) {
            break;
          }
          if (f1 > f4)
          {
            paramFloat = f4;
            break;
          }
          paramFloat = f1;
          break;
          a(localView, jdField_b_of_type_AndroidGraphicsRect);
          break label340;
          label537:
          if (jdField_b_of_type_AndroidGraphicsRect.left <= this.jdField_a_of_type_AndroidGraphicsRect.left) {
            break label382;
          }
          i2 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
          break label382;
          label572:
          if (jdField_b_of_type_AndroidGraphicsRect.top > this.jdField_a_of_type_AndroidGraphicsRect.top) {
            i1 = this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.top;
          } else if (jdField_b_of_type_AndroidGraphicsRect.bottom < this.F + this.jdField_a_of_type_AndroidGraphicsRect.top) {
            i1 = this.F + this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.bottom;
          }
        }
        label652:
        this.jdField_a_of_type_Fii.a(i2, i1);
        return;
        if (jdField_b_of_type_AndroidGraphicsRect.right + this.jdField_t_of_type_Int / 2 > this.jdField_a_of_type_AndroidGraphicsRect.left + this.E / 2)
        {
          a(localView, jdField_b_of_type_AndroidGraphicsRect);
          i1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
          i2 = this.E;
          i3 = jdField_b_of_type_AndroidGraphicsRect.right;
          this.jdField_a_of_type_Fii.a(i1 + i2 - i3, 0);
          return;
        }
        a(localView, jdField_b_of_type_AndroidGraphicsRect);
        i1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
        i2 = jdField_b_of_type_AndroidGraphicsRect.right;
        i3 = this.jdField_t_of_type_Int;
        this.jdField_a_of_type_Fii.a(i1 - i2 - i3, 0);
        return;
      }
    }
  }
  
  @TargetApi(11)
  private void a(float paramFloat1, float paramFloat2)
  {
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    float f1 = this.jdField_a_of_type_AndroidViewView.getLeft();
    float f2 = this.jdField_a_of_type_AndroidViewView.getTop();
    a(this.jdField_a_of_type_AndroidViewView).invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramFloat1 - f1);
    arrayOfFloat[1] = (paramFloat2 - f2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(arrayOfFloat);
    int i1 = jdField_b_of_type_AndroidGraphicsRect.width() / 2;
    int i2 = jdField_b_of_type_AndroidGraphicsRect.left;
    int i3 = jdField_b_of_type_AndroidGraphicsRect.height() / 2;
    int i4 = jdField_b_of_type_AndroidGraphicsRect.top;
    a(this.jdField_a_of_type_AndroidViewView, arrayOfFloat[0], arrayOfFloat[1]);
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    int i5 = jdField_b_of_type_AndroidGraphicsRect.width() / 2;
    int i6 = jdField_b_of_type_AndroidGraphicsRect.left;
    int i7 = jdField_b_of_type_AndroidGraphicsRect.height() / 2;
    int i8 = jdField_b_of_type_AndroidGraphicsRect.top;
    a(this.jdField_a_of_type_AndroidViewView, i1 + i2 - (i5 + i6), i3 + i4 - (i7 + i8));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    if ((i2 == 0) || (i1 == 0)) {}
    fij localfij;
    do
    {
      return;
      localfij = a(i1, i2, paramInt1, paramInt2, paramView);
    } while (localfij == null);
    a(paramView, localfij.b, paramInt3, paramBoolean);
    if (localfij.jdField_a_of_type_Float != 0.0F)
    {
      a(paramView, 0.0F, 0.0F);
      a(paramView, localfij.jdField_a_of_type_Float);
      b(paramView, localfij.jdField_a_of_type_Int * 90);
      a(paramView, jdField_b_of_type_AndroidGraphicsRect);
      Rect localRect = a(jdField_b_of_type_AndroidGraphicsRect.width(), jdField_b_of_type_AndroidGraphicsRect.height(), localfij.b, paramInt3, paramBoolean);
      a(paramView, localRect.left - jdField_b_of_type_AndroidGraphicsRect.left, localRect.top - jdField_b_of_type_AndroidGraphicsRect.top);
    }
    paramView.setTag(2131296385, Float.valueOf(localfij.jdField_a_of_type_Float));
    paramView.setTag(2131296389, Integer.valueOf(localfij.jdField_a_of_type_Int));
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  @TargetApi(11)
  private void a(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        if (!VersionUtils.e()) {
          break;
        }
        paramView.setScaleX(paramFloat);
        paramView.setScaleY(paramFloat);
      } while (isHardwareAccelerated());
      invalidate();
      return;
      paramView = a(paramView);
    } while (paramView.jdField_d_of_type_Float == paramFloat);
    paramView.jdField_d_of_type_Float = paramFloat;
    paramView.jdField_e_of_type_Float = paramFloat;
    paramView.jdField_a_of_type_Boolean = true;
    invalidate();
  }
  
  @TargetApi(11)
  private void a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    fik localfik;
    do
    {
      return;
      if (VersionUtils.e())
      {
        paramView.setPivotX(paramFloat1);
        paramView.setPivotY(paramFloat2);
        return;
      }
      localfik = a(paramView);
    } while ((localfik.jdField_f_of_type_Float == paramFloat1) && (localfik.jdField_g_of_type_Float == paramFloat2));
    localfik.jdField_f_of_type_Float = paramFloat1;
    localfik.jdField_g_of_type_Float = paramFloat2;
    localfik.jdField_a_of_type_Boolean = true;
    paramView.invalidate();
  }
  
  @TargetApi(11)
  private void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (VersionUtils.e())
    {
      paramView.setPivotX(paramFloat1);
      paramView.setPivotY(paramFloat2);
      paramView.setScaleX(paramFloat3);
      paramView.setScaleY(paramFloat3);
      if (!isHardwareAccelerated()) {
        invalidate();
      }
    }
    fik localfik;
    do
    {
      return;
      localfik = a(paramView);
    } while (localfik.jdField_d_of_type_Float == paramFloat3);
    localfik.jdField_f_of_type_Float = paramFloat1;
    localfik.jdField_g_of_type_Float = paramFloat2;
    localfik.jdField_d_of_type_Float = paramFloat3;
    localfik.jdField_e_of_type_Float = paramFloat3;
    localfik.jdField_a_of_type_Boolean = true;
    paramView.invalidate();
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    if (VersionUtils.e())
    {
      paramView.setTranslationX(paramView.getTranslationX() + paramInt1);
      paramView.setTranslationY(paramView.getTranslationY() + paramInt2);
      return;
    }
    fik localfik = a(paramView);
    localfik.jdField_b_of_type_Float += paramInt1;
    localfik.jdField_c_of_type_Float += paramInt2;
    localfik.jdField_a_of_type_Boolean = true;
    paramView.invalidate();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Rect localRect = a(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), paramInt1, paramInt2, paramBoolean);
    paramView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    label18:
    int i1;
    label37:
    Gallery.LayoutParams localLayoutParams;
    if (paramInt1 == 0)
    {
      bool = true;
      if (bool == paramView.isSelected()) {
        break label131;
      }
      paramInt1 = 1;
      if ((paramBoolean2) && (paramInt1 == 0) && (!paramView.isLayoutRequested())) {
        break label136;
      }
      i1 = 1;
      localLayoutParams = (Gallery.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label148;
      }
      localLayoutParams = (Gallery.LayoutParams)generateDefaultLayoutParams();
    }
    label131:
    label136:
    label148:
    for (;;)
    {
      if (paramBoolean1) {}
      for (int i2 = -1;; i2 = 0)
      {
        addViewInLayout(paramView, i2, localLayoutParams, true);
        if (paramInt1 != 0) {
          paramView.setSelected(bool);
        }
        if (i1 != 0)
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          a(this.E, this.F, paramInt2, paramBoolean1, paramView);
        }
        return;
        bool = false;
        break;
        paramInt1 = 0;
        break label18;
        i1 = 0;
        break label37;
      }
    }
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2)
  {
    if (paramView1 != paramView2)
    {
      if (VersionUtils.e()) {
        a(paramView2, paramView1.getPivotX(), paramView1.getPivotY(), paramView1.getScaleX());
      }
    }
    else {
      return;
    }
    paramView2.setTag(2131296388, (fik)paramView1.getTag(2131296388));
  }
  
  private void a(fik paramfik)
  {
    if (paramfik == null) {}
    while (!paramfik.jdField_a_of_type_Boolean) {
      return;
    }
    fik.a(paramfik).reset();
    fik.a(paramfik).setTranslate(paramfik.jdField_b_of_type_Float, paramfik.jdField_c_of_type_Float);
    fik.a(paramfik).preRotate(paramfik.jdField_a_of_type_Float, paramfik.jdField_f_of_type_Float, paramfik.jdField_g_of_type_Float);
    fik.a(paramfik).preScale(paramfik.jdField_d_of_type_Float, paramfik.jdField_e_of_type_Float, paramfik.jdField_f_of_type_Float, paramfik.jdField_g_of_type_Float);
    paramfik.jdField_a_of_type_Boolean = false;
    fik.a(paramfik, fik.a(paramfik).isIdentity());
  }
  
  private void a(boolean paramBoolean)
  {
    int i3 = 0;
    int i2 = 0;
    int i7 = getChildCount();
    int i6 = this.ao;
    int i4;
    int i5;
    View localView;
    if (paramBoolean)
    {
      i8 = getPaddingLeft();
      i1 = 0;
      i4 = 0;
      i3 = i2;
      i2 = i4;
      for (;;)
      {
        i4 = i2;
        i5 = i3;
        if (i1 < i7)
        {
          localView = getChildAt(i1);
          if (a(localView, jdField_b_of_type_AndroidGraphicsRect).right > i8)
          {
            i5 = i3;
            i4 = i2;
          }
        }
        else
        {
          detachViewsFromParent(i5, i4);
          if (paramBoolean) {
            this.ao = (i4 + this.ao);
          }
          return;
        }
        i2 += 1;
        this.jdField_a_of_type_Fhm.a(i6 + i1, localView);
        a(i6 + i1, localView, this, paramBoolean);
        a(i6 + i1 + 1, this, paramBoolean, true);
        i3 = i1;
        i1 += 1;
      }
    }
    int i8 = getWidth();
    int i9 = getPaddingRight();
    int i1 = i7 - 1;
    i2 = 0;
    for (;;)
    {
      i4 = i2;
      i5 = i3;
      if (i1 < 0) {
        break;
      }
      localView = getChildAt(i1);
      i4 = i2;
      i5 = i3;
      if (a(localView, jdField_b_of_type_AndroidGraphicsRect).left < i8 - i9) {
        break;
      }
      this.jdField_a_of_type_Fhm.a(i6 + i1, localView);
      a(i6 + i1, localView, this, paramBoolean);
      a(i6 + i1 - 1, this, paramBoolean, true);
      i2 += 1;
      i3 = i1;
      i1 -= 1;
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    View localView = getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = a();
      int i1 = d(localView);
      this.jdField_a_of_type_Fii.a(paramInt - i1, 0);
      bool = true;
    }
    return bool;
  }
  
  @TargetApi(11)
  private float[] a(View paramView)
  {
    float f2;
    if (VersionUtils.e()) {
      f2 = paramView.getTranslationX();
    }
    for (float f1 = paramView.getTranslationY();; f1 = paramView.jdField_c_of_type_Float)
    {
      return new float[] { f2, f1 };
      paramView = a(paramView);
      f2 = paramView.jdField_b_of_type_Float;
    }
  }
  
  @TargetApi(11)
  private float b(View paramView)
  {
    if (VersionUtils.e()) {
      return paramView.getScaleX();
    }
    return a(paramView).jdField_d_of_type_Float;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = (-paramInt1 + 360) / 360 * 360 + paramInt1;
    }
    for (;;)
    {
      int i1 = paramInt1;
      if (paramInt1 > 360) {
        i1 = paramInt1 % 360;
      }
      paramInt1 = I;
      if ((paramInt2 == 1) || (paramInt2 == 3)) {
        paramInt1 = 90 - I;
      }
      paramInt2 = 180 - paramInt1;
      int i2 = paramInt1 + 180;
      int i3 = 360 - paramInt1;
      if (((i1 >= 0) && (i1 < paramInt1)) || (i1 >= i3)) {
        return 0;
      }
      if ((i1 >= paramInt1) && (i1 < paramInt2)) {
        return 1;
      }
      if ((i1 >= paramInt2) && (i1 < i2)) {
        return 2;
      }
      if ((i1 >= i2) && (i1 < i3)) {
        return 3;
      }
      return 0;
    }
  }
  
  @TargetApi(11)
  private void b(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (VersionUtils.e())
      {
        paramView.setRotation(paramFloat);
        return;
      }
      paramView = a(paramView);
    } while (paramView.jdField_a_of_type_Float == paramFloat);
    paramView.jdField_a_of_type_Float = paramFloat;
    paramView.jdField_a_of_type_Boolean = true;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    View localView;
    Rect localRect;
    do
    {
      int i1;
      int i2;
      do
      {
        return;
        localView = this.jdField_a_of_type_AndroidViewView;
        i1 = getMeasuredWidth();
        i2 = getMeasuredHeight();
      } while ((i1 == 0) || (i2 == 0));
      localObject = new Rect(0, 0, i1, i2);
      localRect = new Rect();
      a(localView, localRect);
    } while (!localRect.intersect((Rect)localObject));
    localRect.offset(-localView.getLeft(), -localView.getTop());
    a(localView).invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    Object localObject = new RectF(localRect);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect((RectF)localObject);
    ((RectF)localObject).round(localRect);
    jdField_b_of_type_AndroidGraphicsRect.set(0, 0, localView.getWidth(), localView.getHeight());
    localRect.intersect(jdField_b_of_type_AndroidGraphicsRect);
    float f1 = b(localView);
    a(this.az, localView, jdField_b_of_type_AndroidGraphicsRect, localRect, paramBoolean, f1);
  }
  
  private boolean b(View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener.a(this, this.jdField_b_of_type_AndroidViewView, paramInt, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  @TargetApi(11)
  private float[] b(View paramView)
  {
    float f2;
    if (VersionUtils.e()) {
      f2 = paramView.getPivotX();
    }
    for (float f1 = paramView.getPivotY();; f1 = a(paramView).jdField_g_of_type_Float)
    {
      return new float[] { f2, f1 };
      f2 = a(paramView).jdField_f_of_type_Float;
    }
  }
  
  @TargetApi(11)
  private float c(View paramView)
  {
    if (VersionUtils.e()) {
      return paramView.getRotation();
    }
    return a(paramView).jdField_a_of_type_Float;
  }
  
  private static int c(int paramInt1, int paramInt2)
  {
    if (paramInt1 < -45) {
      paramInt1 = (-paramInt1 + 360) / 360 * 360 + paramInt1;
    }
    label86:
    for (;;)
    {
      int i1 = paramInt1 - paramInt2 * 90;
      if (i1 > 180) {
        paramInt2 = paramInt1 - 360;
      }
      do
      {
        return paramInt2;
        if (paramInt1 < 275) {
          break label86;
        }
        paramInt1 -= (paramInt1 + 360) / 360 * 360;
        break;
        paramInt2 = paramInt1;
      } while (i1 >= -180);
      return paramInt1 + 360;
    }
  }
  
  private static int d(View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private boolean e()
  {
    if (!VersionUtils.e()) {}
    int i1;
    int i2;
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      i1 = getMeasuredWidth();
      i2 = getMeasuredHeight();
    } while (this.jdField_a_of_type_AndroidViewView.getWidth() * this.jdField_a_of_type_AndroidViewView.getHeight() < i1 * i2 << 2);
    return true;
  }
  
  private void g()
  {
    a(0.0F);
  }
  
  private void h()
  {
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = false;
      super.f_();
    }
    invalidate();
  }
  
  private void i()
  {
    int i1;
    if (this.G > 0)
    {
      i1 = getChildCount() - 1;
      this.G = a(getChildAt(i1), jdField_b_of_type_AndroidGraphicsRect).left;
      i1 += this.ao;
      this.H = 0;
    }
    for (;;)
    {
      if (i1 != this.az)
      {
        e(i1);
        f(i1);
        x();
      }
      return;
      if (this.G < 0)
      {
        i1 = this.ao;
        this.G = a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect).left;
        this.H = 0;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  private void j()
  {
    if (getChildCount() >= 2) {}
    for (;;)
    {
      return;
      int i3 = this.jdField_t_of_type_Int;
      int i4 = getPaddingLeft();
      int i5 = this.E;
      View localView = getChildAt(0);
      int i1;
      int i2;
      if (localView != null)
      {
        i1 = this.ao - 1;
        i2 = a(localView, jdField_b_of_type_AndroidGraphicsRect).left - i3;
      }
      while ((i2 > i4) && (i1 >= 0))
      {
        a(i1, i1 - this.az, i2, false, null);
        if (this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener != null) {
          this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener.a(i1);
        }
        this.ao = i1;
        i2 -= i5 + i3;
        i1 -= 1;
        continue;
        i2 = getRight() - getLeft() - getPaddingRight();
        this.jdField_e_of_type_Boolean = true;
        i1 = 0;
      }
    }
  }
  
  private void k()
  {
    int i1 = getChildCount();
    if (i1 >= 2) {}
    for (;;)
    {
      return;
      int i3 = this.jdField_t_of_type_Int;
      int i4 = getRight();
      int i5 = getLeft();
      int i6 = getPaddingRight();
      int i7 = this.E;
      int i8 = this.aA;
      View localView = getChildAt(i1 - 1);
      int i2;
      if (localView != null)
      {
        i1 = this.ao + i1;
        i2 = a(localView, jdField_b_of_type_AndroidGraphicsRect).right + i3;
      }
      while ((i2 < i4 - i5 - i6) && (i1 < i8))
      {
        a(i1, i1 - this.az, i2, true, null);
        if (this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener != null) {
          this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener.a(i1);
        }
        i2 += i7 + i3;
        i1 += 1;
        continue;
        i1 = this.aA - 1;
        this.ao = i1;
        i2 = getPaddingLeft();
        this.jdField_e_of_type_Boolean = true;
      }
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void n()
  {
    this.D = -1;
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(true);
  }
  
  private void o()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).setPressed(false);
      i1 -= 1;
    }
    setPressed(false);
  }
  
  private void r()
  {
    View localView1 = this.jdField_a_of_type_AndroidViewView;
    View localView2 = getChildAt(this.az - this.ao);
    this.jdField_a_of_type_AndroidViewView = localView2;
    if (localView2 == null) {}
    do
    {
      return;
      localView2.setSelected(true);
      localView2.setFocusable(true);
      if (hasFocus()) {
        localView2.requestFocus();
      }
    } while ((localView1 == null) || (localView1 == localView2));
    localView1.setSelected(false);
    localView1.setFocusable(false);
  }
  
  protected float a(View paramView)
  {
    return this.jdField_i_of_type_Float;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        a(localView, jdField_b_of_type_AndroidGraphicsRect);
        if (jdField_b_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2)) {
          return i1 + this.ao;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public Gallery.OnItemRotateListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener;
  }
  
  public Gallery.OnScollListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = 1;
    if ((getChildCount() == 0) || ((paramInt1 == 0) && (paramInt2 == 0))) {
      return;
    }
    boolean bool;
    if (paramInt1 < 0)
    {
      bool = true;
      if (!paramBoolean) {
        break label84;
      }
      a(bool, paramInt1, paramInt2, this.jdField_a_of_type_AndroidGraphicsPoint);
    }
    for (;;)
    {
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        a(getChildAt(paramInt1), this.jdField_a_of_type_AndroidGraphicsPoint.x, 0);
        paramInt1 -= 1;
      }
      bool = false;
      break;
      label84:
      this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
      this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
    }
    this.G += this.jdField_a_of_type_AndroidGraphicsPoint.x;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.D != 0))
    {
      a(this.jdField_a_of_type_AndroidViewView, 0, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.H += this.jdField_a_of_type_AndroidGraphicsPoint.y;
    }
    a(bool);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
        paramInt1 = i1;
      }
    }
    for (;;)
    {
      if ((bool) && (this.m)) {
        k();
      }
      for (;;)
      {
        this.jdField_a_of_type_Fhm.a();
        if (paramInt1 != 0) {
          i();
        }
        onScrollChanged(0, 0, 0, 0);
        invalidate();
        return;
        paramInt1 = 0;
        break;
        if ((!bool) && (this.l)) {
          j();
        }
      }
      paramInt1 = 0;
    }
  }
  
  public void a(int paramInt, View paramView, Rect paramRect1, Rect paramRect2, boolean paramBoolean, float paramFloat) {}
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  protected void a(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      float f1 = 1.0F;
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) != null) {
        f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
      }
      if (b(this.jdField_a_of_type_AndroidViewView) <= f1) {
        break label88;
      }
      if (!e()) {
        break label72;
      }
      b(true);
    }
    for (;;)
    {
      n();
      this.jdField_c_of_type_Boolean = true;
      return;
      label72:
      b(this.az, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      label88:
      b(false);
    }
  }
  
  @TargetApi(11)
  public boolean a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.D == 0)) {}
    Drawable localDrawable;
    do
    {
      return false;
      if ((VersionUtils.e()) || (!(this.jdField_a_of_type_AndroidViewView instanceof ImageView))) {
        break;
      }
      localDrawable = ((ImageView)this.jdField_a_of_type_AndroidViewView).getDrawable();
    } while (((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable)));
    this.jdField_a_of_type_Double = a(paramScaleGestureDetector.d(), paramScaleGestureDetector.e());
    this.jdField_b_of_type_Float = c(this.jdField_a_of_type_AndroidViewView);
    float f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
    if (b(this.jdField_a_of_type_AndroidViewView) <= f1 + 1.0E-005F) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      f1 = paramScaleGestureDetector.a();
      float f2 = paramScaleGestureDetector.b();
      this.l = false;
      this.m = false;
      a(f1, f2);
      this.jdField_c_of_type_Float = f1;
      this.jdField_d_of_type_Float = f2;
      this.jdField_e_of_type_Float = paramScaleGestureDetector.c();
      this.jdField_f_of_type_Float = b(this.jdField_a_of_type_AndroidViewView);
      this.k = true;
      if (e()) {
        b(false);
      }
      return true;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.l = false;
    this.m = false;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag(2131296385);
    if ((localObject == null) || (!(localObject instanceof Float))) {
      return false;
    }
    float f1 = ((Float)localObject).floatValue();
    float f2 = b(this.jdField_a_of_type_AndroidViewView);
    if ((f2 < f1) || ((Math.abs(f2 - f1) < 1.E-005D) && (!paramBoolean))) {
      return false;
    }
    a(f1 * this.jdField_h_of_type_Float);
    return true;
  }
  
  protected void b(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.jdField_q_of_type_Boolean) {
      p();
    }
    if (this.aA == 0)
    {
      b();
      return;
    }
    paramInt = getChildCount();
    int i1 = this.az - this.ao;
    if ((i1 >= 0) && (i1 < paramInt)) {}
    for (View localView = getChildAt(i1);; localView = null)
    {
      if (this.ay >= 0)
      {
        paramInt = this.ay;
        paramInt = this.az;
      }
      if (this.ay >= 0) {
        e(this.ay);
      }
      c();
      detachAllViewsFromParent();
      if (this.jdField_u_of_type_Boolean)
      {
        this.jdField_a_of_type_Fhm.a();
        this.H = 0;
        this.G = 0;
        localView = null;
      }
      this.jdField_w_of_type_Int = 0;
      this.jdField_v_of_type_Int = 0;
      this.ao = this.az;
      if ((a().hasStableIds()) && (localView != null) && (this.jdField_d_of_type_Long == this.jdField_f_of_type_Long))
      {
        paramInt = 1;
        i1 = this.az;
        int i2 = this.G;
        if (paramInt != 0) {
          localObject = localView;
        }
        a(i1, 0, i2, true, localObject);
        if (this.G >= 0) {
          break label275;
        }
        k();
      }
      for (;;)
      {
        if (this.jdField_e_of_type_Boolean)
        {
          this.G = 0;
          this.H = 0;
        }
        this.jdField_a_of_type_Fhm.a();
        invalidate();
        x();
        this.jdField_q_of_type_Boolean = false;
        this.o = false;
        f(this.az);
        r();
        return;
        paramInt = 0;
        break;
        label275:
        j();
      }
    }
  }
  
  boolean b()
  {
    return false;
  }
  
  @TargetApi(11)
  public boolean b(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.D == 0)) {
      return false;
    }
    float f1 = paramScaleGestureDetector.a();
    float f2 = paramScaleGestureDetector.b();
    float f3 = this.jdField_c_of_type_Float;
    float f4 = this.jdField_d_of_type_Float;
    this.jdField_c_of_type_Float = f1;
    this.jdField_d_of_type_Float = f2;
    a(this.jdField_a_of_type_AndroidViewView, (int)(f1 - f3), (int)(f2 - f4));
    a(f1, f2);
    f2 = paramScaleGestureDetector.c() / this.jdField_e_of_type_Float;
    f1 = f2 * this.jdField_f_of_type_Float;
    f3 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
    if (f1 < this.jdField_h_of_type_Float * f3 * 0.6F) {
      f1 = f3 * this.jdField_h_of_type_Float * 0.6F;
    }
    label278:
    label367:
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidViewView, f1 * paramScaleGestureDetector.i());
      Boolean localBoolean = (Boolean)this.jdField_a_of_type_AndroidViewView.getTag(2131296390);
      if ((this.jdField_w_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (localBoolean != null) && (localBoolean.booleanValue()))
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label278;
        }
        f2 = (float)((a(paramScaleGestureDetector.d(), paramScaleGestureDetector.e()) - this.jdField_a_of_type_Double) / 3.141592653589793D * 180.0D);
        f1 = f2;
        if (f2 > 180.0F) {
          f1 = f2 - 360.0F;
        }
        b(this.jdField_a_of_type_AndroidViewView, f1 + this.jdField_b_of_type_Float);
      }
      for (;;)
      {
        return true;
        if (f1 <= this.jdField_i_of_type_Float * 1.5F) {
          break label367;
        }
        f1 = this.jdField_i_of_type_Float * 1.5F;
        break;
        if (f2 <= 0.95F)
        {
          this.jdField_b_of_type_Boolean = true;
          f2 = (float)((a(paramScaleGestureDetector.d(), paramScaleGestureDetector.e()) - this.jdField_a_of_type_Double) / 3.141592653589793D * 180.0D);
          f1 = f2;
          if (f2 > 180.0F) {
            f1 = f2 - 360.0F;
          }
          b(this.jdField_a_of_type_AndroidViewView, f1 + this.jdField_b_of_type_Float);
        }
        else if (f2 >= 1.05F)
        {
          this.jdField_c_of_type_Boolean = false;
        }
      }
    }
  }
  
  boolean c()
  {
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof Gallery.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return 1;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return this.az;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return this.aA;
  }
  
  void d()
  {
    float f2;
    float f3;
    float f1;
    if (this.s)
    {
      this.l = false;
      this.m = false;
      f2 = 1.0F;
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) != null) {
        f2 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
      }
      f3 = b(this.jdField_a_of_type_AndroidViewView);
      if (Math.abs(f3 - f2) < 1.E-005D) {
        if (f2 == this.jdField_h_of_type_Float)
        {
          f1 = this.jdField_i_of_type_Float;
          if (f3 >= f1) {
            break label226;
          }
          if (!e()) {
            b(this.az, this.jdField_a_of_type_AndroidViewView, this);
          }
          label118:
          a(f1);
        }
      }
    }
    for (;;)
    {
      this.s = false;
      o();
      return;
      if (f2 < this.jdField_h_of_type_Float)
      {
        f1 = this.jdField_h_of_type_Float;
        break;
      }
      if (f2 < this.jdField_i_of_type_Float)
      {
        f1 = this.jdField_i_of_type_Float;
        break;
      }
      f1 = this.jdField_h_of_type_Float;
      break;
      if (f3 == this.jdField_h_of_type_Float)
      {
        f1 = f2;
        if (f2 > this.jdField_h_of_type_Float) {
          break;
        }
        f1 = this.jdField_i_of_type_Float;
        break;
      }
      f1 = f2;
      if (f3 != this.jdField_i_of_type_Float) {
        break;
      }
      f1 = Math.min(f2, this.jdField_h_of_type_Float);
      break;
      label226:
      if (!e()) {
        break label118;
      }
      b(false);
      break label118;
      if (fii.a(this.jdField_a_of_type_Fii).a())
      {
        g();
        if (this.D == 0) {
          this.D = 2;
        }
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_w_of_type_Boolean;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this, null, null);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  public void e()
  {
    this.G = 0;
  }
  
  void e(int paramInt)
  {
    super.e(paramInt);
    r();
  }
  
  void f()
  {
    d();
  }
  
  public void f_()
  {
    if (!this.jdField_h_of_type_Boolean) {
      super.f_();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new Gallery.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new Gallery.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new Gallery.LayoutParams(paramLayoutParams);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = this.az - this.ao;
    if (i1 < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return i1;
      }
    } while (paramInt2 < i1);
    return paramInt2 + 1;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramView = (fik)paramView.getTag(2131296388);
    if (paramView != null)
    {
      a(paramView);
      paramTransformation.getMatrix().set(fik.a(paramView));
      return true;
    }
    return false;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.s = true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(f1, f2);
    }
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.D == 2) {
      this.D = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Fii.a(false);
      this.x = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.x >= 0)
      {
        this.jdField_b_of_type_AndroidViewView = getChildAt(this.x - this.ao);
        this.jdField_b_of_type_AndroidViewView.setPressed(true);
      }
      this.j = true;
      a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
      if (jdField_b_of_type_AndroidGraphicsRect.width() != this.E) {
        break;
      }
      this.m = true;
      this.l = true;
      return true;
      n();
    }
    if (jdField_b_of_type_AndroidGraphicsRect.left == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.l = bool1;
      bool1 = bool2;
      if (jdField_b_of_type_AndroidGraphicsRect.right == this.E) {
        bool1 = true;
      }
      this.m = bool1;
      return true;
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.jdField_h_of_type_Boolean) {
        this.jdField_h_of_type_Boolean = true;
      }
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    paramFloat1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
    paramFloat2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
    int i1;
    int i2;
    label154:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    float f1;
    if (getChildCount() <= 1)
    {
      a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
      i1 = this.E + this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.right;
      i2 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
      if ((jdField_b_of_type_AndroidGraphicsRect.height() < this.F) && (jdField_b_of_type_AndroidGraphicsRect.width() <= this.E))
      {
        g();
        if (this.D != 0) {
          break label677;
        }
        this.D = 2;
        return true;
      }
      if (jdField_b_of_type_AndroidGraphicsRect.height() < this.F)
      {
        i3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        i4 = (this.F - jdField_b_of_type_AndroidGraphicsRect.bottom + jdField_b_of_type_AndroidGraphicsRect.top) / 2;
        i5 = jdField_b_of_type_AndroidGraphicsRect.top;
        i6 = this.F;
        i7 = (this.F - jdField_b_of_type_AndroidGraphicsRect.bottom + jdField_b_of_type_AndroidGraphicsRect.top) / 2;
        i8 = jdField_b_of_type_AndroidGraphicsRect.bottom;
        f1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
        if (f1 <= this.jdField_g_of_type_Float) {
          break label690;
        }
        paramFloat1 = this.jdField_g_of_type_Float * paramFloat1 / f1;
        paramFloat2 = 0.0F;
      }
    }
    label677:
    label690:
    for (;;)
    {
      this.jdField_a_of_type_Fii.a((int)paramFloat1, (int)paramFloat2, i1, i2, i3 + i4 - i5, i6 - i7 - i8);
      break;
      i3 = this.F;
      i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i5 = jdField_b_of_type_AndroidGraphicsRect.bottom;
      i6 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i7 = jdField_b_of_type_AndroidGraphicsRect.top;
      f1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      if (f1 > this.jdField_g_of_type_Float)
      {
        paramFloat1 = this.jdField_g_of_type_Float * paramFloat1 / f1;
        paramFloat2 = paramFloat2 * this.jdField_g_of_type_Float / f1;
      }
      for (;;)
      {
        this.jdField_a_of_type_Fii.a((int)paramFloat1, (int)paramFloat2, i1, i2, i3 + i4 - i5, i6 - i7);
        break;
        if (paramFloat1 < 0.0F)
        {
          i1 = a(getChildAt(1), jdField_b_of_type_AndroidGraphicsRect).left;
          a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect);
          if (i1 == 0) {
            break label154;
          }
          if (this.jdField_a_of_type_Fii.a(i1, (int)paramFloat1) <= this.jdField_a_of_type_AndroidGraphicsRect.left)
          {
            this.jdField_a_of_type_Fii.a((int)paramFloat1, 0, this.jdField_a_of_type_AndroidGraphicsRect.left - i1, 2147483647, 0, 0);
            break;
          }
          if (paramFloat1 < -this.y)
          {
            this.jdField_a_of_type_Fii.a(this.jdField_a_of_type_AndroidGraphicsRect.left - i1, 0);
            break;
          }
          g();
          break;
        }
        i1 = this.E + this.jdField_a_of_type_AndroidGraphicsRect.left;
        i2 = a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect).right;
        if (i2 == i1) {
          break label154;
        }
        if (this.jdField_a_of_type_Fii.a(i2, (int)paramFloat1) >= i1)
        {
          this.jdField_a_of_type_Fii.a((int)paramFloat1, 0, -2147483648, i1 - i2, 0, 0);
          break;
        }
        if (paramFloat1 > this.y)
        {
          this.jdField_a_of_type_Fii.a(i1 - i2, 0);
          break;
        }
        g();
        break;
        if (this.D != 1) {
          break label154;
        }
        return true;
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.requestFocus(paramInt);
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_v_of_type_Boolean;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      do
      {
        do
        {
          return bool;
        } while (!b());
        playSoundEffect(1);
        return true;
      } while (!c());
      playSoundEffect(3);
      return true;
      this.jdField_i_of_type_Boolean = true;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.jdField_i_of_type_Boolean) && (this.aA > 0))
    {
      a(this.jdField_a_of_type_AndroidViewView);
      postDelayed(new fih(this), ViewConfiguration.getPressedStateDuration());
      a(getChildAt(this.az - this.ao), this.az, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.az));
    }
    this.jdField_i_of_type_Boolean = false;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.E = (getRight() - getLeft() - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right);
    this.F = (getBottom() - getTop() - this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    this.jdField_p_of_type_Boolean = true;
    b(0, false);
    this.jdField_p_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_t_of_type_Boolean) {
      return;
    }
    long l1 = a(this.az);
    b(this.jdField_b_of_type_AndroidViewView, this.az, l1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    if ((i1 == 1073741824) && (i2 == 1073741824))
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.jdField_f_of_type_Boolean) {
      if (this.j)
      {
        if (!this.jdField_h_of_type_Boolean) {
          this.jdField_h_of_type_Boolean = true;
        }
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 250L);
      }
    }
    for (;;)
    {
      a((int)paramFloat1 * -1, (int)paramFloat2 * -1, true);
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.D == 1))
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        paramFloat1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
        paramFloat2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
        if ((Math.abs(paramFloat1) < 1500.0F) && (Math.abs(paramFloat2) < 1500.0F) && (e())) {
          b(true);
        }
      }
      this.j = false;
      return true;
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_h_of_type_Boolean = false;
      }
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      a(this.jdField_b_of_type_AndroidViewView, this.az, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.az));
      return true;
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_u_of_type_Boolean = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aA == 0) {
      return false;
    }
    l();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    boolean bool;
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.jdField_t_of_type_Boolean = true;
      bool = this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector.a(paramMotionEvent);
    }
    for (;;)
    {
      int i1 = paramMotionEvent.getAction();
      if (i1 == 1)
      {
        d();
        m();
        this.k = false;
      }
      for (;;)
      {
        if ((i1 & 0xFF) == 2) {
          this.jdField_g_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        }
        return bool;
        if (this.k) {
          break label129;
        }
        this.jdField_t_of_type_Boolean = false;
        bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
        break;
        if (i1 == 3)
        {
          f();
          m();
          this.k = false;
        }
      }
      label129:
      bool = false;
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(paramSpinnerAdapter);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.jdField_u_of_type_Int = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setInterceptTouchEventReturn(boolean paramBoolean)
  {
    this.jdField_v_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.jdField_i_of_type_Float = paramFloat;
  }
  
  public void setOnItemRotateListener(Gallery.OnItemRotateListener paramOnItemRotateListener)
  {
    this.jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener = paramOnItemRotateListener;
  }
  
  public void setOnScollListener(Gallery.OnScollListener paramOnScollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener = paramOnScollListener;
  }
  
  public void setRotateEnable(boolean paramBoolean)
  {
    this.jdField_w_of_type_Boolean = paramBoolean;
  }
  
  public void setSpacing(int paramInt)
  {
    this.jdField_t_of_type_Int = paramInt;
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.az >= 0)) {
      return b(getChildAt(this.az - this.ao), this.az, this.jdField_d_of_type_Long);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i1 = c(paramView);
    if (i1 < 0) {
      return false;
    }
    return b(paramView, i1, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(i1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.Gallery
 * JD-Core Version:    0.7.0.1
 */