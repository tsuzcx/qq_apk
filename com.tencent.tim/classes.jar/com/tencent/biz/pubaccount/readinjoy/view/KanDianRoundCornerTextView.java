package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.PaintDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class KanDianRoundCornerTextView
  extends TextView
{
  private int aXR;
  private String alg = "#000000";
  private float mAlpha = 0.4F;
  
  public KanDianRoundCornerTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KanDianRoundCornerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KanDianRoundCornerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.aXR = paramInt;
    PaintDrawable localPaintDrawable = new PaintDrawable();
    localPaintDrawable.setCornerRadius(this.aXR);
    localPaintDrawable.setColorFilter(Color.parseColor(this.alg), PorterDuff.Mode.SRC_ATOP);
    localPaintDrawable.setAlpha((int)(255.0F * this.mAlpha));
    setBackgroundDrawable(localPaintDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView
 * JD-Core Version:    0.7.0.1
 */