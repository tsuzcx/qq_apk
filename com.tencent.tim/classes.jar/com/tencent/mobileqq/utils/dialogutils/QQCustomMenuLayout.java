package com.tencent.mobileqq.utils.dialogutils;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQCustomMenuLayout
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView EY;
  private ImageView EZ;
  private ImageView Fa;
  private ImageView Fb;
  private boolean cUL;
  private boolean cUM;
  private int endPosition;
  private float mDensity;
  private int mItemPadding;
  private TextPaint mTextPaint;
  private int screenWidth;
  private int startPosition;
  
  public QQCustomMenuLayout(Context paramContext)
  {
    super(paramContext);
    Object localObject = paramContext.getResources();
    this.screenWidth = ((Resources)localObject).getDisplayMetrics().widthPixels;
    this.mDensity = ((Resources)localObject).getDisplayMetrics().density;
    this.screenWidth -= (int)(this.mDensity * 10.0F);
    int i = 12;
    if (this.mDensity >= 2.0F) {
      i = 20;
    }
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    this.mTextPaint.setTextSize(TypedValue.applyDimension(2, 15.0F, ((Resources)localObject).getDisplayMetrics()));
    this.EY = new ImageView(paramContext);
    this.EY.setVisibility(8);
    this.EY.setImageResource(2130839088);
    this.EY.setContentDescription(acfp.m(2131711616));
    this.EY.setBackgroundDrawable(null);
    this.EY.setOnClickListener(this);
    this.EY.setPadding((int)(i * this.mDensity), (int)(this.mDensity * 10.0F), (int)(i * this.mDensity), (int)(this.mDensity * 10.0F));
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.EY.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.EY, 0);
    this.Fa = new ImageView(paramContext);
    this.Fa.setBackgroundResource(2130839072);
    if (!AppSetting.enableTalkBack) {
      this.Fa.setContentDescription("leftIcon");
    }
    this.Fa.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.Fa.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.Fa, 1);
    this.Fb = new ImageView(paramContext);
    this.Fb.setBackgroundResource(2130839072);
    if (!AppSetting.enableTalkBack) {
      this.Fb.setContentDescription("rightIcon");
    }
    this.Fb.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.Fb.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.Fb, 2);
    this.EZ = new ImageView(paramContext);
    this.EZ.setVisibility(8);
    this.EZ.setImageResource(2130839093);
    this.EZ.setContentDescription(acfp.m(2131711602));
    this.EZ.setBackgroundDrawable(null);
    this.EZ.setOnClickListener(this);
    this.EZ.setPadding((int)(i * this.mDensity), (int)(this.mDensity * 10.0F), (int)(i * this.mDensity), (int)(this.mDensity * 10.0F));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.EZ.setLayoutParams(paramContext);
    addView(this.EZ, 3);
  }
  
  private int Mi()
  {
    int m = getChildCount();
    onMeasure(0, 0);
    int j = 0;
    int i = 0;
    View localView;
    int k;
    if (j < m)
    {
      localView = getChildAt(j);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label212;
      }
      if ((localView instanceof TextView))
      {
        k = (int)Layout.getDesiredWidth(((TextView)localView).getText(), this.mTextPaint);
        if (QLog.isDevelopLevel()) {
          QLog.d("QQCustomMenuLayout", 4, "child  TextView text " + ((TextView)localView).getText() + " measureWidth = " + k + " padding = " + localView.getPaddingLeft());
        }
        i = i + k + this.mItemPadding;
        label138:
        i = i + localView.getPaddingLeft() + localView.getPaddingRight();
      }
    }
    label212:
    for (;;)
    {
      j += 1;
      break;
      int n = localView.getMeasuredWidth();
      k = i + n;
      i = k;
      if (!QLog.isDevelopLevel()) {
        break label138;
      }
      QLog.d("QQCustomMenuLayout", 4, "child  nonTextView measureWidth = " + n);
      i = k;
      break label138;
      return i;
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView, getChildCount() - 2);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    addView(paramView, localLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public void eex()
  {
    if (getChildCount() > 3)
    {
      this.startPosition = 2;
      this.endPosition = (getChildCount() - 3);
      eey();
    }
  }
  
  public void eey()
  {
    int i = -1;
    for (;;)
    {
      int j = Mi();
      if (QLog.isDevelopLevel()) {
        QLog.d("QQCustomMenuLayout", 4, "totalWidth = " + j + " startPosition = " + this.startPosition + " endPosition = " + this.endPosition);
      }
      if (j <= this.screenWidth)
      {
        label70:
        if (this.startPosition <= 3) {
          break label566;
        }
        if ((this.EY != null) && (this.EY.getVisibility() != 0)) {
          this.EY.setVisibility(0);
        }
        label103:
        if (this.endPosition >= getChildCount() - 4) {
          break label597;
        }
        if ((this.EZ != null) && (this.EZ.getVisibility() != 0)) {
          this.EZ.setVisibility(0);
        }
      }
      for (;;)
      {
        if ((this.Fa != null) && (this.EY != null) && (this.Fa.getVisibility() != this.EY.getVisibility())) {
          this.Fa.setVisibility(this.EY.getVisibility());
        }
        if ((this.Fb != null) && (this.EZ != null) && (this.Fb.getVisibility() != this.EZ.getVisibility())) {
          this.Fb.setVisibility(this.EZ.getVisibility());
        }
        return;
        if (i == j) {
          break label70;
        }
        setMinimumWidth(this.screenWidth);
        if (this.cUL)
        {
          this.endPosition -= 2;
          label262:
          if (this.endPosition < 0) {
            this.endPosition = 0;
          }
          if (this.startPosition > this.endPosition) {
            this.startPosition = this.endPosition;
          }
          km(this.startPosition, this.endPosition);
          if (this.startPosition <= 3) {
            break label504;
          }
          if ((this.EY != null) && (this.EY.getVisibility() != 0)) {
            this.EY.setVisibility(0);
          }
          label338:
          if (this.endPosition >= getChildCount() - 4) {
            break label535;
          }
          if ((this.EZ != null) && (this.EZ.getVisibility() != 0)) {
            this.EZ.setVisibility(0);
          }
        }
        for (;;)
        {
          if ((this.Fa != null) && (this.EY != null) && (this.Fa.getVisibility() != this.EY.getVisibility())) {
            this.Fa.setVisibility(this.EY.getVisibility());
          }
          if ((this.Fb == null) || (this.EZ == null) || (this.Fb.getVisibility() == this.EZ.getVisibility())) {
            break label628;
          }
          this.Fb.setVisibility(this.EZ.getVisibility());
          i = j;
          break;
          if (this.cUM)
          {
            this.startPosition += 2;
            break label262;
          }
          this.endPosition -= 2;
          break label262;
          label504:
          if ((this.EY == null) || (this.EY.getVisibility() == 8)) {
            break label338;
          }
          this.EY.setVisibility(8);
          break label338;
          label535:
          if ((this.EZ != null) && (this.EZ.getVisibility() != 8)) {
            this.EZ.setVisibility(8);
          }
        }
        label566:
        if ((this.EY == null) || (this.EY.getVisibility() == 8)) {
          break label103;
        }
        this.EY.setVisibility(8);
        break label103;
        label597:
        if ((this.EZ != null) && (this.EZ.getVisibility() != 8)) {
          this.EZ.setVisibility(8);
        }
      }
      label628:
      i = j;
    }
  }
  
  public void km(int paramInt1, int paramInt2)
  {
    int i = 2;
    if (i < getChildCount() - 2)
    {
      if ((i < paramInt1) || (i > paramInt2)) {
        getChildAt(i).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        getChildAt(i).setVisibility(0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.EY) {
      if (this.startPosition > 3)
      {
        this.cUL = false;
        this.cUM = true;
        this.endPosition = (this.startPosition - 2);
        this.startPosition = 2;
        if (this.startPosition > this.endPosition) {
          this.startPosition = this.endPosition;
        }
        km(this.startPosition, this.endPosition);
        this.EZ.setVisibility(0);
        this.Fb.setVisibility(0);
        this.EY.setVisibility(8);
        this.Fa.setVisibility(8);
        eey();
        this.cUM = false;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.startPosition < getChildCount() - 4)
      {
        this.cUM = false;
        this.cUL = true;
        this.startPosition = (this.endPosition + 2);
        this.endPosition = (getChildCount() - 3);
        if (this.startPosition > this.endPosition) {
          this.startPosition = this.endPosition;
        }
        km(this.startPosition, this.endPosition);
        this.EY.setVisibility(0);
        this.Fa.setVisibility(0);
        this.EZ.setVisibility(8);
        this.Fb.setVisibility(8);
        eey();
        this.cUL = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuLayout
 * JD-Core Version:    0.7.0.1
 */