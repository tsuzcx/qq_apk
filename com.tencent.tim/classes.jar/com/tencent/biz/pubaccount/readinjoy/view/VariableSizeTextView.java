package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqgz;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import njl;

public class VariableSizeTextView
  extends RelativeLayout
{
  public static final String TAG = "Q.readinjoy.atlas." + VariableSizeTextView.class.getSimpleName();
  private float B = 0.0F;
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$a;
  private boolean arL;
  protected boolean asE;
  private boolean asF;
  float currentY;
  private float ej;
  protected float kw;
  float kx;
  private float ky;
  private float kz = 0.0F;
  float lastY;
  public float mContentHeight;
  private TextView mDescriptionView;
  float startY;
  
  public VariableSizeTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VariableSizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClickable(true);
    setFocusable(true);
    this.mDescriptionView = new TextView(getContext());
    this.mDescriptionView.setTextColor(Color.parseColor("#E8E8E8"));
    this.mDescriptionView.setTextSize(1, 16.0F);
    this.mDescriptionView.setIncludeFontPadding(false);
    this.mDescriptionView.setLineSpacing(aqcx.dip2px(paramContext, 3.0F), 1.0F);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(10);
    addView(this.mDescriptionView, paramContext);
  }
  
  public void aYp()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.B = this.mDescriptionView.getLineSpacingMultiplier();
      this.kz = this.mDescriptionView.getLineSpacingExtra();
    }
    while ((this.B != 0.0F) || (this.kz != 0.0F)) {
      return;
    }
    try
    {
      Field localField = TextView.class.getDeclaredField("mSpacingMult");
      localField.setAccessible(true);
      this.B = localField.getFloat(this);
      localField = TextView.class.getDeclaredField("mSpacingAdd");
      localField.setAccessible(true);
      this.kz = localField.getFloat(this);
      return;
    }
    catch (Exception localException)
    {
      this.B = 1.0F;
      this.kz = 3.0F;
    }
  }
  
  public int dC(int paramInt)
  {
    int j = 1;
    int i = paramInt;
    paramInt = j;
    while (i / 10 != 0)
    {
      i /= 10;
      paramInt += 1;
    }
    return paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool = true;
    super.onDraw(paramCanvas);
    aYp();
    int i = getMeasuredWidth();
    if (i == 0) {
      i = (int)aqgz.getWidth();
    }
    for (;;)
    {
      paramCanvas = new StaticLayout(this.mDescriptionView.getText(), this.mDescriptionView.getPaint(), i - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.B, this.kz, true);
      float f = paramCanvas.getHeight() + getPaddingTop() + getPaddingBottom();
      i = paramCanvas.getLineCount();
      if (f != this.mContentHeight)
      {
        this.mContentHeight = f;
        resetHeight();
      }
      if (i > 5) {}
      for (;;)
      {
        this.asE = bool;
        return;
        bool = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onTouchEvent()  action=" + i);
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (i == 0)
    {
      this.ky = paramMotionEvent.getRawX();
      this.ej = paramMotionEvent.getRawY();
      this.arL = false;
      this.asF = false;
      this.startY = paramMotionEvent.getRawY();
      this.currentY = this.startY;
      this.kx = localLayoutParams.height;
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    float f1;
    int j;
    label472:
    do
    {
      do
      {
        do
        {
          return true;
          if (i != 1) {
            break;
          }
          this.currentY = paramMotionEvent.getRawY();
          i = localLayoutParams.height;
          if ((i != this.mContentHeight) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$a != null)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$a.aYq();
          }
        } while (i <= this.mContentHeight);
        paramMotionEvent = ValueAnimator.ofFloat(new float[] { i, this.mContentHeight });
        paramMotionEvent.setDuration(300L);
        paramMotionEvent.setInterpolator(new DecelerateInterpolator());
        paramMotionEvent.addUpdateListener(new njl(this, localLayoutParams));
        setFocusable(false);
        setClickable(false);
        paramMotionEvent.start();
        return true;
      } while (i != 2);
      f1 = paramMotionEvent.getRawX() - this.ky;
      float f2 = paramMotionEvent.getRawY() - this.ej;
      if ((Math.max(Math.abs(f1), Math.abs(f2)) > this.jdField_a_of_type_AndroidViewViewConfiguration.getScaledTouchSlop()) && (!this.arL) && (!this.asF) && ((f1 != 0.0F) || (f2 != 0.0F)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onTouchEvent()  action=" + i + " distanceX=" + f1 + " distanceY=" + f2);
        }
        if (Math.abs(f1) >= Math.abs(f2)) {
          this.arL = true;
        }
      }
      else
      {
        if (!this.asF) {
          break;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        this.lastY = this.currentY;
        this.currentY = paramMotionEvent.getRawY();
        f1 = this.lastY - this.currentY;
        j = localLayoutParams.height;
        i = (int)(j + f1);
        if (i <= this.mContentHeight) {
          continue;
        }
        if (!this.asE) {
          break label543;
        }
        if (f1 >= 0.0F) {
          break label537;
        }
        i = -1;
      }
      for (i = (int)(j + i * Math.pow(Math.abs(f1), 0.7D));; i = (int)(this.mContentHeight + 0.5F))
      {
        localLayoutParams.height = i;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$a != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$a.onSizeChange(j, i);
        }
        setLayoutParams(localLayoutParams);
        return true;
        this.asF = true;
        break;
        i = 1;
        break label472;
      }
    } while (((j >= this.kw) || (f1 <= 0.0F)) && (i < this.kw));
    label537:
    label543:
    localLayoutParams.height = i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$a.onSizeChange(j, i);
    }
    setLayoutParams(localLayoutParams);
    return true;
    getParent().requestDisallowInterceptTouchEvent(false);
    return true;
  }
  
  public void resetHeight()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (this.mContentHeight == 0.0F) {}
    for (localLayoutParams.height = ((int)(this.kw + 0.5F));; localLayoutParams.height = Math.min((int)(this.kw + 0.5F), (int)(this.mContentHeight + 0.5F)))
    {
      setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void setOnSizeChangedListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$a = parama;
  }
  
  public void setText(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    Object localObject = paramInt1 + 1 + "/" + paramInt2;
    paramInt1 = dC(paramInt1 + 1);
    paramInt2 = dC(paramInt2);
    localObject = new SpannableStringBuilder((CharSequence)localObject);
    ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(aqcx.dip2px(getContext(), 17.0F)), 0, paramInt1, 33);
    ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(aqcx.dip2px(getContext(), 12.0F)), paramInt1, paramInt2 + paramInt1 + 1, 33);
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#E8E8E8")), paramInt1, paramInt2 + paramInt1 + 1, 33);
    ((SpannableStringBuilder)localObject).append("  ");
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ((SpannableStringBuilder)localObject).append(paramCharSequence);
    }
    this.mDescriptionView.setText((CharSequence)localObject);
  }
  
  public void setText(String paramString)
  {
    this.mDescriptionView.setText(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void aYq();
    
    public abstract void onSizeChange(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView
 * JD-Core Version:    0.7.0.1
 */