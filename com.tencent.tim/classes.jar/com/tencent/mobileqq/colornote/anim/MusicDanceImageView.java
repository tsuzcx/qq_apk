package com.tencent.mobileqq.colornote.anim;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class MusicDanceImageView
  extends ImageView
{
  private boolean bSQ = true;
  
  public MusicDanceImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MusicDanceImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MusicDanceImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.bSQ) {
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.bSQ) {
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.bSQ)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, -2147483648), View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setShouldDraw(boolean paramBoolean)
  {
    this.bSQ = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      setShouldDraw(true);
    }
    while ((paramInt != 8) && (paramInt != 4)) {
      return;
    }
    setShouldDraw(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.MusicDanceImageView
 * JD-Core Version:    0.7.0.1
 */