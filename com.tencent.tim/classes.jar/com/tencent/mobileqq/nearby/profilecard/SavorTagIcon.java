package com.tencent.mobileqq.nearby.profilecard;

import acfp;
import akho;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalLabelLayout;
import java.util.ArrayList;
import java.util.List;

public class SavorTagIcon
  extends HorizontalLabelLayout
  implements View.OnClickListener
{
  private static final String[] fC = { "#C6DAF7", "#FFCCC5", "#D9CAF7", "#B6ECD1" };
  List<InterestTagInfo> DQ;
  int WA;
  int WB;
  int ZY;
  akho a;
  int bqi;
  boolean cso = true;
  int mCornerRadius;
  float mDensity;
  int mTagType;
  String mTitle;
  int mTitleMarginBottom;
  TextView mTitleView;
  int wq;
  
  public SavorTagIcon(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public SavorTagIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SavorTagIcon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  public void a(String paramString, int paramInt, List<InterestTagInfo> paramList, akho paramakho)
  {
    this.a = paramakho;
    this.mTagType = paramInt;
    this.mTitle = paramString;
    paramString = fC[0];
    switch (this.mTagType)
    {
    }
    try
    {
      for (;;)
      {
        this.wq = Color.parseColor(paramString);
        bJ(paramList);
        return;
        paramString = fC[0];
        continue;
        paramString = fC[1];
        continue;
        paramString = fC[2];
        continue;
        paramString = fC[3];
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public boolean arQ()
  {
    Rect localRect = new Rect();
    int j = getChildCount();
    int i = 0;
    while ((i < j - 1) && (j > 1))
    {
      View localView = getChildAt(i + 1);
      if ((localView.getGlobalVisibleRect(localRect)) && (localRect.bottom - localRect.top >= 0.5D * localView.getMeasuredHeight())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void bJ(List<InterestTagInfo> paramList)
  {
    int j = 1;
    int i;
    if (this.DQ.size() > 0)
    {
      i = 1;
      this.DQ.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.DQ.addAll(paramList);
      }
      if (this.DQ.size() <= 0) {
        break label120;
      }
    }
    for (;;)
    {
      if (i != j)
      {
        dBs();
        setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        paramList = this.mTitleView.getLayoutParams();
        if ((paramList instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)paramList).bottomMargin = this.mTitleMarginBottom;
        }
      }
      refreshView();
      return;
      i = 0;
      break;
      label120:
      j = 0;
    }
  }
  
  protected void dBs()
  {
    if ((this.DQ == null) || (this.DQ.size() == 0))
    {
      this.bqi = ((int)(this.mDensity * 12.0F));
      this.mTitleMarginBottom = 0;
      return;
    }
    this.bqi = ((int)(this.mDensity * 12.0F));
    this.mTitleMarginBottom = ((int)(this.mDensity * 12.0F));
  }
  
  protected void initView()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SavorTagIcon", 4, "initView");
    }
    removeAllViews();
    this.mDensity = getResources().getDisplayMetrics().density;
    if (this.mDensity < 0.01F) {
      this.mDensity = 1.0F;
    }
    this.ZY = ((int)(this.mDensity * 12.0F));
    this.bqi = ((int)(this.mDensity * 12.0F));
    this.WB = ((int)(this.mDensity * 12.0F));
    this.WA = ((int)(this.mDensity * 12.0F));
    dBs();
    setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
    this.mTagType = 0;
    this.mTitle = "";
    this.DQ = new ArrayList(2);
    this.mCornerRadius = getResources().getDimensionPixelSize(2131299325);
    this.mTitleView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561493, null));
    FrameLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = this.ZY;
    localLayoutParams.bottomMargin = this.bqi;
    addView(this.mTitleView, localLayoutParams);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (Object localObject = null;; localObject = paramView.getTag())
    {
      if (((localObject instanceof InterestTagInfo)) && (this.a != null)) {
        this.a.a(paramView, this.mTagType, (InterestTagInfo)localObject);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).setInterceptTouchFlag(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void refreshView()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SavorTagIcon", 4, "refreshView");
    }
    int j = this.DQ.size();
    int i = getChildCount() - 1;
    Object localObject1;
    if (i > j) {
      while (i > j)
      {
        localObject1 = getChildAt(i);
        ((View)localObject1).setOnClickListener(null);
        removeView((View)localObject1);
        i -= 1;
      }
    }
    Object localObject2;
    if (i < j) {
      while (i < j)
      {
        localObject1 = LayoutInflater.from(getContext()).inflate(2131561489, null);
        localObject2 = generateDefaultLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).width = -2;
        ((ViewGroup.MarginLayoutParams)localObject2).height = -2;
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = this.WB;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = this.WA;
        addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        i += 1;
      }
    }
    if (j > 0)
    {
      localObject1 = new StringBuilder(this.mTitle);
      ((StringBuilder)localObject1).append('(').append(j).append(')');
      this.mTitleView.setText(((StringBuilder)localObject1).toString());
      int k = this.DQ.size();
      i = 0;
      label205:
      if (i >= k) {
        return;
      }
      localObject1 = getChildAt(i + 1);
      if (localObject1 != null) {
        break label282;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("SavorTagIcon", 4, "refreshView child is null, index = " + String.valueOf(i + 1));
      }
    }
    for (;;)
    {
      i += 1;
      break label205;
      this.mTitleView.setText(this.mTitle);
      break;
      label282:
      localObject2 = (InterestTagInfo)this.DQ.get(i);
      if (localObject2 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("SavorTagIcon", 4, "refreshView item is null, index = " + String.valueOf(i));
        }
      }
      else
      {
        String str = ((InterestTagInfo)localObject2).tagName;
        j = this.wq;
        try
        {
          j = Color.parseColor(((InterestTagInfo)localObject2).tagBgColor);
          localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(j);
          localGradientDrawable.setCornerRadius(this.mCornerRadius);
        }
        catch (Exception localException1)
        {
          try
          {
            GradientDrawable localGradientDrawable;
            j = Color.parseColor(((InterestTagInfo)localObject2).tagTextColor);
            TextView localTextView = (TextView)((View)localObject1).findViewById(2131381048);
            if (localTextView != null)
            {
              localTextView.setText(str);
              localTextView.setTextColor(j);
            }
            ((View)localObject1).setBackgroundDrawable(localGradientDrawable);
            ((View)localObject1).setTag(localObject2);
            if (this.a != null)
            {
              ((View)localObject1).setOnClickListener(this);
              continue;
              localException1 = localException1;
              if (QLog.isDevelopLevel()) {
                localException1.printStackTrace();
              }
              j = this.wq;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isDevelopLevel()) {
                localException2.printStackTrace();
              }
              j = -1;
            }
          }
        }
      }
    }
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean == this.cso) {
      return;
    }
    this.cso = paramBoolean;
    if (this.cso)
    {
      this.mTitleView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839512, 0);
      return;
    }
    this.mTitleView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.mTitleView.setTextColor(paramInt);
  }
  
  public String xC()
  {
    if ((this.DQ == null) || (this.mTitle == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131713991));
    localStringBuilder.append(this.mTitle).append(this.DQ.size()).append("个");
    int i = 0;
    while (i < this.DQ.size())
    {
      localStringBuilder.append(",");
      localStringBuilder.append(((InterestTagInfo)this.DQ.get(i)).tagName);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorTagIcon
 * JD-Core Version:    0.7.0.1
 */