package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class RecordTextView
  extends TextView
{
  private boolean a;
  private Paint b = new Paint();
  private int c;
  private ct d;
  private boolean e;
  private int f = 20;
  private int g;
  private int h;
  private int i;
  private boolean j;
  private int k;
  private Handler l = new cs(this);
  
  public RecordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.setAntiAlias(true);
    this.g = paramContext.getResources().getColor(2131165317);
    this.h = paramContext.getResources().getColor(2131165318);
    this.i = paramContext.getResources().getColor(2131165319);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a)
    {
      this.b.setColor(this.g);
      paramCanvas.drawRect(0.0F, getTop(), this.c, getTop() + getHeight(), this.b);
      if (!this.j) {
        break label109;
      }
      this.b.setColor(this.h);
    }
    for (;;)
    {
      paramCanvas.drawRect(this.c, getTop(), this.c + this.f, getTop() + getHeight(), this.b);
      return;
      label109:
      this.b.setColor(this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.RecordTextView
 * JD-Core Version:    0.7.0.1
 */