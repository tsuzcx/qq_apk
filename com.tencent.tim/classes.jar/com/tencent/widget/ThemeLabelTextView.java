package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import auvj;
import auvj.a;

public class ThemeLabelTextView
  extends TextView
  implements auvj.a
{
  auvj a;
  
  public ThemeLabelTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ThemeLabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ThemeLabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public void L(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.a(paramCanvas, this);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void init()
  {
    setSupportMaskView(false);
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
      setMaskShape(auvj.euM);
    }
    while (this.a == null) {
      return;
    }
    this.a.setSupportMaskView(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ThemeLabelTextView
 * JD-Core Version:    0.7.0.1
 */