package dov.com.tencent.biz.qqstory.takevideo.interact;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import atau.a;
import aype;
import java.math.BigDecimal;
import ram;

public class RateWidgetRatingBar
  extends LinearLayout
{
  private a a;
  private int aGF;
  private boolean ada;
  private Drawable cj;
  private Drawable ck;
  private Drawable cs;
  private boolean isEmpty = true;
  private float iu;
  private float iv;
  private float iw;
  private float ix;
  private int rating;
  private int y = 1;
  
  public RateWidgetRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rC);
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
      this.rating = paramAttributeSet.getInteger(1, 0);
      this.ada = paramAttributeSet.getBoolean(0, true);
      paramAttributeSet.recycle();
      while (i < this.aGF)
      {
        paramAttributeSet = a(paramContext, this.isEmpty);
        paramAttributeSet.setOnClickListener(new aype(this));
        addView(paramAttributeSet);
        i += 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ram.e("RateWidgetRatingBar", "RateWidgetRatingBar load drawable failed : %s", localOutOfMemoryError);
      }
      setStar(this.rating);
    }
  }
  
  private ImageView a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ImageView(paramContext);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(Math.round(this.iu), Math.round(this.iv));
    localMarginLayoutParams.rightMargin = Math.round(this.ix);
    paramContext.setLayoutParams(localMarginLayoutParams);
    paramContext.setPadding(0, 0, Math.round(this.iw), 0);
    if (paramBoolean)
    {
      paramContext.setImageDrawable(this.cj);
      return paramContext;
    }
    paramContext.setImageDrawable(this.ck);
    return paramContext;
  }
  
  public void setOnRatingChangeListener(a parama)
  {
    this.a = parama;
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
  
  public void setRating(int paramInt)
  {
    this.rating = paramInt;
    setStar(paramInt);
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
  
  public static abstract interface a
  {
    public abstract void aj(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar
 * JD-Core Version:    0.7.0.1
 */