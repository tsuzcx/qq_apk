package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import auvj;
import auvj.a;

public class LabelTextView
  extends TextView
  implements auvj.a
{
  private boolean Mp;
  protected auvj a;
  private int cVw = 2147483647;
  private boolean cbT;
  
  public LabelTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void aiL()
  {
    this.a = new auvj();
    this.a.setSupportMaskView(true);
    this.a.setMaskShape(auvj.euM);
  }
  
  private void init()
  {
    setMaxLines(1);
    setGravity(17);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
    aiL();
  }
  
  public void L(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.Mp) && (this.a != null))
    {
      this.a.a(paramCanvas, this);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.cbT)
    {
      if (getMeasuredWidth() >= this.cVw) {
        break label38;
      }
      if (getVisibility() == 0) {
        setVisibility(8);
      }
    }
    label38:
    while (getVisibility() == 0) {
      return;
    }
    setVisibility(0);
  }
  
  public void setMinWidthCheck(int paramInt)
  {
    this.cVw = paramInt;
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.cbT = bool;
      return;
    }
  }
  
  public void setParam(int paramInt1, int paramInt2, float paramFloat)
  {
    setTextColor(paramInt2);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt1);
    localGradientDrawable.setCornerRadius(paramFloat);
    setBackgroundDrawable(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.LabelTextView
 * JD-Core Version:    0.7.0.1
 */