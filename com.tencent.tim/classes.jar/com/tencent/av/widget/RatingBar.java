package com.tencent.av.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import atau.a;
import jmb;

public class RatingBar
  extends LinearLayout
{
  private a a;
  private Object aA;
  private int aBu;
  private Drawable cj;
  private Drawable ck;
  private float ie;
  private boolean mClickable = true;
  private int starCount;
  
  public RatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rC);
    this.ie = ((TypedArray)localObject).getDimension(11, 20.0F);
    this.starCount = ((TypedArray)localObject).getInteger(2, 5);
    this.cj = ((TypedArray)localObject).getDrawable(3);
    this.ck = ((TypedArray)localObject).getDrawable(5);
    ((TypedArray)localObject).recycle();
    while (i < this.starCount)
    {
      localObject = a(paramContext, paramAttributeSet);
      ((ImageView)localObject).setOnClickListener(new jmb(this));
      addView((View)localObject);
      i += 1;
    }
  }
  
  private ImageView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.ie), Math.round(this.ie)));
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setImageDrawable(this.cj);
    paramContext.setMaxWidth(10);
    paramContext.setMaxHeight(10);
    return paramContext;
  }
  
  public void setBindObject(Object paramObject)
  {
    this.aA = paramObject;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public void setOnRatingListener(a parama)
  {
    this.a = parama;
  }
  
  public void setStar(int paramInt, boolean paramBoolean)
  {
    if (paramInt > this.starCount) {
      paramInt = this.starCount;
    }
    int i;
    for (;;)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      paramInt = 0;
      while (paramInt < i)
      {
        ((ImageView)getChildAt(paramInt)).setImageDrawable(this.ck);
        if (paramBoolean)
        {
          ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 0.0F, 1.0F, 1.0F);
          getChildAt(paramInt).startAnimation(localScaleAnimation);
        }
        paramInt += 1;
      }
    }
    paramInt = this.starCount - 1;
    while (paramInt >= i)
    {
      ((ImageView)getChildAt(paramInt)).setImageDrawable(this.cj);
      paramInt -= 1;
    }
  }
  
  public void setStarCount(int paramInt)
  {
    this.starCount = paramInt;
  }
  
  public void setStarEmptyDrawable(Drawable paramDrawable)
  {
    this.cj = paramDrawable;
  }
  
  public void setStarFillDrawable(Drawable paramDrawable)
  {
    this.ck = paramDrawable;
  }
  
  public void setStarImageSize(float paramFloat)
  {
    this.ie = paramFloat;
  }
  
  public static abstract interface a
  {
    public abstract void c(Object paramObject, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.RatingBar
 * JD-Core Version:    0.7.0.1
 */