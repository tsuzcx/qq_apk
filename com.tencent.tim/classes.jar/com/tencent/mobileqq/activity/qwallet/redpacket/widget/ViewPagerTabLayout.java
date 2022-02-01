package com.tencent.mobileqq.activity.qwallet.redpacket.widget;

import aafm;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atau.a;
import com.tencent.qphone.base.util.QLog;

public class ViewPagerTabLayout
  extends HorizontalScrollView
  implements ViewPager.OnPageChangeListener
{
  private a a;
  private Rect br = new Rect();
  private Rect bs = new Rect();
  private boolean bvp;
  private boolean bvq = true;
  private int cgm;
  private int cgn;
  private int cgo;
  private int cgp = 1;
  private int cgq;
  private GradientDrawable f = new GradientDrawable();
  private LinearLayout hV;
  private Context mContext;
  private int mCurrentTab;
  private int mIndicatorColor;
  private float mIndicatorHeight;
  private float mIndicatorMarginBottom;
  private float mIndicatorWidth;
  private float mTextSize;
  private ViewPager mViewPager;
  private float rf;
  private float rg;
  private float rh;
  private float ri;
  private float rj;
  private float rk;
  private float rl;
  
  public ViewPagerTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, String paramString, View paramView)
  {
    TextView localTextView = (TextView)paramView.getTag();
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    paramView.setOnClickListener(new aafm(this));
    if (this.bvp) {}
    for (paramString = new LinearLayout.LayoutParams(0, -1, 1.0F);; paramString = new LinearLayout.LayoutParams(-2, -1))
    {
      if (this.rh > 0.0F) {
        paramString = new LinearLayout.LayoutParams((int)this.rh, -1);
      }
      this.hV.addView(paramView, paramInt, paramString);
      return;
    }
  }
  
  private void cnp()
  {
    int i = 0;
    if (i < this.cgm)
    {
      TextView localTextView = (TextView)this.hV.getChildAt(i).getTag();
      int j;
      if (localTextView != null)
      {
        if (i != this.mCurrentTab) {
          break label95;
        }
        j = this.cgn;
        label42:
        localTextView.setTextColor(j);
        localTextView.setTextSize(0, this.mTextSize);
        localTextView.setPadding((int)this.rg, 0, (int)this.rg, 0);
        if (this.cgp != 2) {
          break label103;
        }
        localTextView.getPaint().setFakeBoldText(true);
      }
      for (;;)
      {
        i += 1;
        break;
        label95:
        j = this.cgo;
        break label42;
        label103:
        if (this.cgp == 0) {
          localTextView.getPaint().setFakeBoldText(false);
        }
      }
    }
  }
  
  private void ctW()
  {
    if (this.cgm <= 0) {}
    int i;
    do
    {
      return;
      int k = (int)(this.rf * this.hV.getChildAt(this.mCurrentTab).getWidth());
      int j = this.hV.getChildAt(this.mCurrentTab).getLeft() + k;
      if (this.mCurrentTab <= 0)
      {
        i = j;
        if (k <= 0) {}
      }
      else
      {
        i = getWidth() / 2;
        k = getPaddingLeft();
        ctX();
        i = j - (i - k) + (this.bs.right - this.bs.left) / 2;
      }
    } while (i == this.cgq);
    this.cgq = i;
    scrollTo(i, 0);
  }
  
  private void ctX()
  {
    View localView1 = this.hV.getChildAt(this.mCurrentTab);
    float f4 = localView1.getLeft();
    float f3 = localView1.getRight();
    float f2 = f3;
    float f1 = f4;
    View localView2;
    if (this.mCurrentTab < this.cgm - 1)
    {
      localView2 = this.hV.getChildAt(this.mCurrentTab + 1);
      f1 = localView2.getLeft();
      f2 = localView2.getRight();
      f1 = f4 + (f1 - f4) * this.rf;
      f2 = f3 + (f2 - f3) * this.rf;
    }
    this.br.left = ((int)f1);
    this.br.right = ((int)f2);
    this.bs.left = ((int)f1);
    this.bs.right = ((int)f2);
    if (this.mIndicatorWidth < 0.0F) {
      return;
    }
    f2 = localView1.getLeft() + (localView1.getWidth() - this.mIndicatorWidth) / 2.0F;
    f1 = f2;
    if (this.mCurrentTab < this.cgm - 1)
    {
      localView2 = this.hV.getChildAt(this.mCurrentTab + 1);
      f1 = this.rf;
      int i = localView1.getWidth() / 2;
      f1 = f2 + (localView2.getWidth() / 2 + i) * f1;
    }
    this.br.left = ((int)f1);
    this.br.right = ((int)(this.br.left + this.mIndicatorWidth));
  }
  
  private void f(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sL);
    this.mIndicatorColor = paramContext.getColor(0, Color.parseColor("#ffffff"));
    this.mIndicatorHeight = paramContext.getDimension(2, -1.0F);
    this.mIndicatorWidth = paramContext.getDimension(3, -1.0F);
    this.ri = paramContext.getDimension(1, -1.0F);
    this.mTextSize = paramContext.getDimension(8, sp2px(16.0F));
    this.cgn = paramContext.getColor(6, Color.parseColor("#FF2051"));
    this.cgo = paramContext.getColor(7, Color.parseColor("#F5F6FA"));
    this.rh = paramContext.getDimension(5, dp2px(-1.0F));
    if ((this.bvp) || (this.rh > 0.0F)) {}
    for (float f1 = dp2px(0.0F);; f1 = dp2px(15.0F))
    {
      this.rg = paramContext.getDimension(4, f1);
      paramContext.recycle();
      return;
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mContext = paramContext;
    setFillViewport(true);
    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);
    this.hV = new LinearLayout(paramContext);
    addView(this.hV);
    f(paramContext, paramAttributeSet);
  }
  
  public void FQ(int paramInt)
  {
    int i = 0;
    if (i < this.cgm)
    {
      Object localObject = this.hV.getChildAt(i);
      boolean bool;
      if (i == paramInt)
      {
        bool = true;
        label28:
        localObject = (TextView)((View)localObject).getTag();
        if (localObject != null) {
          if (!bool) {
            break label90;
          }
        }
      }
      label90:
      for (int j = this.cgn;; j = this.cgo)
      {
        ((TextView)localObject).setTextColor(j);
        if (this.cgp == 1) {
          ((TextView)localObject).getPaint().setFakeBoldText(bool);
        }
        i += 1;
        break;
        bool = false;
        break label28;
      }
    }
  }
  
  protected int dp2px(float paramFloat)
  {
    return (int)(this.mContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public int getCurrentTab()
  {
    return this.mCurrentTab;
  }
  
  public void notifyDataSetChanged()
  {
    this.hV.removeAllViews();
    this.cgm = this.mViewPager.getAdapter().getCount();
    int i = 0;
    while (i < this.cgm)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setClipChildren(false);
      localRelativeLayout.setClipToPadding(false);
      TextView localTextView = new TextView(getContext());
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      localObject = this.mViewPager.getAdapter().getPageTitle(i);
      localRelativeLayout.setTag(localTextView);
      if (localObject != null) {
        a(i, ((CharSequence)localObject).toString(), localRelativeLayout);
      }
      i += 1;
    }
    cnp();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.cgm <= 0)) {}
    int j;
    do
    {
      return;
      int i = getHeight();
      j = getPaddingLeft();
      ctX();
      if (this.mIndicatorHeight < 0.0F) {
        this.mIndicatorHeight = (i - this.rk - this.mIndicatorMarginBottom);
      }
    } while (this.mIndicatorHeight <= 0.0F);
    if ((this.ri < 0.0F) || (this.ri > this.mIndicatorHeight / 2.0F)) {
      this.ri = (this.mIndicatorHeight / 2.0F);
    }
    this.f.setColor(this.mIndicatorColor);
    this.f.setBounds((int)this.rj + j + this.br.left, (int)this.rk, (int)(j + this.br.right - this.rl), (int)(this.rk + this.mIndicatorHeight));
    this.f.setCornerRadius(this.ri);
    this.f.draw(paramCanvas);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.mCurrentTab = paramInt1;
    this.rf = paramFloat;
    ctW();
    invalidate();
    if (QLog.isColorLevel()) {
      QLog.i("ViewPagerTabLayout", 2, "onPageScrolled:" + paramInt1 + " positionOffset:" + paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    FQ(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("ViewPagerTabLayout", 2, "onPageSelected:" + paramInt);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Parcelable localParcelable = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.mCurrentTab = paramParcelable.getInt("currentTab");
      paramParcelable = paramParcelable.getParcelable("currentState");
      localParcelable = paramParcelable;
      if (this.mCurrentTab != 0)
      {
        localParcelable = paramParcelable;
        if (this.hV.getChildCount() > 0)
        {
          FQ(this.mCurrentTab);
          ctW();
          localParcelable = paramParcelable;
        }
      }
    }
    super.onRestoreInstanceState(localParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("currentState", super.onSaveInstanceState());
    localBundle.putInt("currentTab", this.mCurrentTab);
    return localBundle;
  }
  
  public void setBoldStyle(int paramInt)
  {
    this.cgp = paramInt;
  }
  
  public void setCurrentTab(int paramInt)
  {
    this.mCurrentTab = paramInt;
    this.mViewPager.setCurrentItem(paramInt);
  }
  
  public void setCurrentTab(int paramInt, boolean paramBoolean)
  {
    this.mCurrentTab = paramInt;
    this.mViewPager.setCurrentItem(paramInt, paramBoolean);
    if (!paramBoolean) {
      onPageScrolled(paramInt, 0.0F, 0);
    }
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.mIndicatorColor = paramInt;
    invalidate();
  }
  
  public void setOnTabSelectListener(a parama)
  {
    this.a = parama;
  }
  
  public void setScrollOnTabClick(boolean paramBoolean)
  {
    this.bvq = paramBoolean;
  }
  
  public void setTextsize(float paramFloat)
  {
    this.mTextSize = sp2px(paramFloat);
    cnp();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if ((paramViewPager == null) || (paramViewPager.getAdapter() == null)) {
      throw new IllegalStateException("ViewPager or it's adapter can not be null");
    }
    this.mViewPager = paramViewPager;
    this.mViewPager.setOnPageChangeListener(this);
    notifyDataSetChanged();
  }
  
  protected int sp2px(float paramFloat)
  {
    return (int)(this.mContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public static abstract interface a
  {
    public abstract void FR(int paramInt);
    
    public abstract void FS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout
 * JD-Core Version:    0.7.0.1
 */