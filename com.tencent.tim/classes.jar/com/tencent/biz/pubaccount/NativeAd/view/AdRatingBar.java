package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import atau.a;
import java.math.BigDecimal;

public class AdRatingBar
  extends LinearLayout
{
  private int aGF;
  private boolean ada;
  private Drawable cj;
  private Drawable ck;
  private Drawable cs;
  private boolean isEmpty = true;
  private float it;
  private float iu;
  private float iv;
  private float iw;
  private float ix;
  private int y = 1;
  
  public AdRatingBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public AdRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private ImageView a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = new ImageView(paramContext);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(Math.round(this.iu), Math.round(this.iv));
    if (!paramBoolean2) {
      localMarginLayoutParams.rightMargin = Math.round(this.ix);
    }
    paramContext.setLayoutParams(localMarginLayoutParams);
    paramContext.setPadding(0, 0, Math.round(this.iw), 0);
    if (paramBoolean1)
    {
      paramContext.setImageDrawable(this.cj);
      return paramContext;
    }
    paramContext.setImageDrawable(this.ck);
    return paramContext;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    setOrientation(0);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pC);
    try
    {
      this.cs = paramAttributeSet.getDrawable(7);
      this.cj = paramAttributeSet.getDrawable(4);
      this.ck = paramAttributeSet.getDrawable(6);
      this.iu = paramAttributeSet.getDimension(12, 60.0F);
      this.iv = paramAttributeSet.getDimension(8, 120.0F);
      this.iw = paramAttributeSet.getDimension(10, 0.0F);
      this.ix = paramAttributeSet.getDimension(9, 0.0F);
      this.aGF = paramAttributeSet.getInteger(13, 5);
      this.it = paramAttributeSet.getFloat(1, 0.0F);
      this.ada = paramAttributeSet.getBoolean(0, true);
      paramAttributeSet.recycle();
      int i = 0;
      for (;;)
      {
        if (i >= this.aGF) {
          break label185;
        }
        if (i != this.aGF - 1) {
          break;
        }
        bool = true;
        addView(a(paramContext, this.isEmpty, bool));
        i += 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        continue;
        boolean bool = false;
      }
      label185:
      setStar(this.it);
    }
  }
  
  public void setRatable(boolean paramBoolean)
  {
    this.ada = paramBoolean;
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setClickable(paramBoolean);
      i += 1;
    }
  }
  
  public void setRating(float paramFloat)
  {
    this.it = paramFloat;
    setStar(paramFloat);
  }
  
  public void setStar(float paramFloat)
  {
    int j = (int)paramFloat;
    float f = new BigDecimal(Float.toString(paramFloat)).subtract(new BigDecimal(Integer.toString(j))).floatValue();
    if (j > this.aGF)
    {
      paramFloat = this.aGF;
      if (paramFloat >= 0.0F) {
        break label95;
      }
      paramFloat = 0.0F;
    }
    label95:
    for (;;)
    {
      i = 0;
      while (i < paramFloat)
      {
        ((ImageView)getChildAt(i)).setImageDrawable(this.ck);
        i += 1;
      }
      paramFloat = j;
      break;
    }
    if (f > 0.0F)
    {
      ((ImageView)getChildAt(j)).setImageDrawable(this.cs);
      i = this.aGF - 1;
      while (i >= 1.0F + paramFloat)
      {
        ((ImageView)getChildAt(i)).setImageDrawable(this.cj);
        i -= 1;
      }
    }
    int i = this.aGF - 1;
    while (i >= paramFloat)
    {
      ((ImageView)getChildAt(i)).setImageDrawable(this.cj);
      i -= 1;
    }
  }
  
  public void setStarNum(int paramInt)
  {
    this.aGF = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.AdRatingBar
 * JD-Core Version:    0.7.0.1
 */