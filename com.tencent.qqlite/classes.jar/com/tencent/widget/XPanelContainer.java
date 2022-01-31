package com.tencent.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.VersionUtils;
import fjc;
import fjd;

public class XPanelContainer
  extends FrameLayout
  implements Runnable
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 150L;
  private static final String jdField_a_of_type_JavaLangString = XPanelContainer.class.getSimpleName();
  private static boolean jdField_a_of_type_Boolean = VersionUtils.e();
  public static final int b = 1;
  private static final long jdField_c_of_type_Long = 1L;
  private static final int e = -1;
  private static final int l = 0;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  private View jdField_a_of_type_AndroidViewView;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback;
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = 0;
  
  public XPanelContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XPanelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = ((int)(196.0F * paramContext.getResources().getDisplayMetrics().density));
  }
  
  @TargetApi(11)
  private void b()
  {
    if ((jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
    {
      if (this.jdField_b_of_type_Boolean) {
        if (this.k >= this.jdField_c_of_type_Int)
        {
          this.k = 0;
          this.jdField_b_of_type_Boolean = false;
        }
      }
      while ((!this.jdField_c_of_type_Boolean) || (this.k > 0)) {
        return;
      }
      this.k = 0;
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() >= this.jdField_b_of_type_Long + 0L)
    {
      this.k = 0;
      return;
    }
    float f1 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_b_of_type_Long) / 0.0F;
    this.k = ((int)(this.jdField_c_of_type_Int - AnimateUtils.a(f1) * this.jdField_c_of_type_Int));
  }
  
  private void c(int paramInt)
  {
    if (paramInt != this.jdField_d_of_type_Int)
    {
      int m = this.jdField_d_of_type_Int;
      this.jdField_d_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback != null) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(m, this.jdField_d_of_type_Int);
      }
      URLDrawable.resume();
      if ((this.jdField_b_of_type_AndroidViewView != null) && (paramInt <= 1))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView = null;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.f = -1;
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    c(0);
    requestLayout();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidViewView.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0);
    }
    do
    {
      for (;;)
      {
        return;
        if (paramInt <= 1) {
          break label350;
        }
        if (paramInt == 2)
        {
          com.tencent.mobileqq.emoticonview.EmoticonMainPanel.jdField_b_of_type_Long = System.currentTimeMillis();
          StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
        }
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        Object localObject = localView;
        if (localView == null) {}
        try
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt);
          if (localObject != null)
          {
            addView((View)localObject);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
            if (localObject != this.jdField_b_of_type_AndroidViewView)
            {
              if (this.jdField_b_of_type_AndroidViewView != null) {
                this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              }
              ((View)localObject).setVisibility(0);
              this.jdField_b_of_type_AndroidViewView = ((View)localObject);
            }
            if (this.jdField_d_of_type_Int == 0)
            {
              if (this.k > 0) {
                continue;
              }
              this.f = paramInt;
              URLDrawable.pause();
              this.jdField_d_of_type_Boolean = paramBoolean;
              if ((jdField_a_of_type_Boolean) && (paramBoolean))
              {
                this.jdField_b_of_type_Boolean = true;
                paramInt = getHeight();
                localObject = ValueAnimator.ofInt(new int[] { paramInt, paramInt - this.jdField_c_of_type_Int });
                ((ValueAnimator)localObject).setDuration(150L);
                ((ValueAnimator)localObject).addUpdateListener(new fjc(this, paramInt));
                ((ValueAnimator)localObject).start();
                return;
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject = localView;
            if (QLog.isColorLevel())
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "onCreatePanel, exception: " + localException.getMessage());
              localObject = localView;
            }
          }
          this.k = this.jdField_c_of_type_Int;
          this.jdField_b_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
          requestLayout();
          return;
        }
      }
      if (this.jdField_d_of_type_Int == 1)
      {
        this.f = paramInt;
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
    } while (this.jdField_d_of_type_Int == paramInt);
    c(paramInt);
    return;
    label350:
    throw new IllegalArgumentException("wrong argument..must be SOFT_INPUT,EXTERNAL_EMOTICON,EXTERNAL_INPUT");
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  @TargetApi(11)
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_d_of_type_Int > 0)
    {
      bool1 = true;
      if (this.jdField_d_of_type_Int != 1) {
        break label49;
      }
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    for (;;)
    {
      label40:
      bool2 = bool1;
      label49:
      do
      {
        return bool2;
        bool1 = false;
        break;
        if (this.jdField_d_of_type_Int <= 1) {
          break label40;
        }
      } while (this.k > 0);
      this.f = 0;
      this.k = this.jdField_c_of_type_Int;
      this.jdField_b_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        int m = getHeight();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { m - this.jdField_c_of_type_Int, m });
        localValueAnimator.setDuration(150L);
        localValueAnimator.addUpdateListener(new fjd(this, m));
        localValueAnimator.start();
      }
      else
      {
        requestLayout();
      }
    }
  }
  
  public void b(int paramInt)
  {
    int m = 0;
    while (m < getChildCount())
    {
      getChildAt(m).offsetTopAndBottom(paramInt);
      m += 1;
    }
    invalidate();
  }
  
  @TargetApi(13)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (VersionUtils.f()) {
      if ((paramConfiguration.orientation != this.h) && ((this.i != paramConfiguration.screenWidthDp) || (this.j != paramConfiguration.screenHeightDp)))
      {
        this.h = -1;
        this.j = -1;
        this.j = -1;
        this.g = -1;
        a();
      }
    }
    while (paramConfiguration.orientation == this.h) {
      return;
    }
    this.h = -1;
    this.g = -1;
    a();
  }
  
  @TargetApi(13)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = paramInt4 - paramInt2;
    int n = this.jdField_d_of_type_Int;
    Object localObject;
    label76:
    label109:
    int i1;
    if ((this.g < 0) && (paramBoolean) && (m > 0))
    {
      localObject = getResources().getConfiguration();
      this.h = ((Configuration)localObject).orientation;
      if (VersionUtils.f())
      {
        this.i = ((Configuration)localObject).screenWidthDp;
        this.j = ((Configuration)localObject).screenHeightDp;
      }
      this.g = m;
      break label221;
      break label221;
      if ((this.g <= m) || (this.g - m <= 0.2F * this.g)) {
        break label240;
      }
      m = 1;
      paramInt3 = paramInt3 - paramInt1 - this.mPaddingRight;
      i1 = this.mPaddingLeft;
      paramInt2 = paramInt4 - paramInt2 - this.mPaddingBottom;
      paramInt4 = this.mPaddingTop;
      localObject = getChildAt(0);
      if ((m == 0) || (this.jdField_d_of_type_Int == 1)) {
        break label246;
      }
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
      ((View)localObject).layout(i1, paramInt4, paramInt3, paramInt2);
      label200:
      if ((!paramBoolean) || (m == 0)) {
        break label782;
      }
      paramInt1 = 1;
      this.f = -1;
    }
    for (;;)
    {
      c(paramInt1);
      label221:
      return;
      if (m <= this.g) {
        break label76;
      }
      this.g = m;
      break label76;
      label240:
      m = 0;
      break label109;
      label246:
      if ((this.f > 1) && ((m == 0) || (paramBoolean)))
      {
        if ((m != 0) && (paramBoolean))
        {
          requestLayout();
          return;
        }
        b();
        if ((jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
          if (this.jdField_b_of_type_Boolean) {
            paramInt1 = this.k;
          }
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824));
          this.jdField_b_of_type_AndroidViewView.layout(i1, paramInt2 - paramInt1, paramInt3, paramInt2 - paramInt1 + this.jdField_c_of_type_Int);
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - paramInt1, 1073741824));
          ((View)localObject).layout(i1, paramInt4, paramInt3, paramInt2 - paramInt1);
          if ((this.jdField_b_of_type_Boolean) || (this.k != 0)) {
            break;
          }
          c(this.f);
          this.f = -1;
          return;
          paramInt1 = this.jdField_c_of_type_Int;
          continue;
          if (!this.jdField_d_of_type_Boolean) {
            this.jdField_d_of_type_Boolean = true;
          }
          paramInt1 = this.jdField_c_of_type_Int - this.k;
        }
        if (jdField_a_of_type_Boolean) {
          break;
        }
        postDelayed(this, 1L);
        return;
      }
      if ((this.f == 0) && (this.jdField_d_of_type_Int > 1))
      {
        b();
        this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(i1, paramInt2 - this.k, paramInt3, paramInt2 - this.k + this.jdField_c_of_type_Int);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - this.k, 1073741824));
        ((View)localObject).layout(i1, paramInt4, paramInt3, paramInt2 - this.k);
        if (this.k == 0)
        {
          c(this.f);
          this.f = -1;
          return;
        }
        if (jdField_a_of_type_Boolean) {
          break;
        }
        postDelayed(this, 1L);
        return;
      }
      if ((this.jdField_d_of_type_Int > 1) && (m == 0))
      {
        this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(i1, paramInt2 - this.jdField_c_of_type_Int, paramInt3, paramInt2);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - this.jdField_c_of_type_Int, 1073741824));
        ((View)localObject).layout(i1, paramInt4, paramInt3, paramInt2 - this.jdField_c_of_type_Int);
        break label200;
      }
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
      ((View)localObject).layout(i1, paramInt4, paramInt3, paramInt2);
      break label200;
      label782:
      if ((this.f == 0) || ((paramBoolean) && (m == 0)))
      {
        paramInt1 = 0;
        this.f = -1;
      }
      else
      {
        paramInt1 = n;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void run()
  {
    requestLayout();
  }
  
  public void setOnPanelChangeListener(XPanelContainer.PanelCallback paramPanelCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = paramPanelCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer
 * JD-Core Version:    0.7.0.1
 */