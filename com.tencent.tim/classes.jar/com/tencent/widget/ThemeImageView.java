package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import auvj;
import auvj.a;

public class ThemeImageView
  extends ImageView
  implements auvj.a
{
  public auvj a;
  
  public ThemeImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ThemeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ThemeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public void L(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void init()
  {
    setSupportMaskView(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.a(paramCanvas, this);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setMaskShape(int paramInt)
  {
    if (this.a != null) {
      this.a.setMaskShape(paramInt);
    }
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null) {
        this.a = new auvj();
      }
      this.a.setSupportMaskView(true);
    }
    while (this.a == null) {
      return;
    }
    this.a.setSupportMaskView(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ThemeImageView
 * JD-Core Version:    0.7.0.1
 */