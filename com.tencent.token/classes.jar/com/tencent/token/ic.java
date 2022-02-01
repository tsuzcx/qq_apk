package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionBarContainer;

public class ic
  extends Drawable
{
  final ActionBarContainer a;
  
  public ic(ActionBarContainer paramActionBarContainer)
  {
    this.a = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a.d)
    {
      if (this.a.c != null) {
        this.a.c.draw(paramCanvas);
      }
    }
    else
    {
      if (this.a.a != null) {
        this.a.a.draw(paramCanvas);
      }
      if ((this.a.b != null) && (this.a.e)) {
        this.a.b.draw(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ic
 * JD-Core Version:    0.7.0.1
 */