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
  private ck d;
  private int e;
  private boolean f;
  private int g = 20;
  private int h;
  private int i;
  private int j;
  private boolean k;
  private int l;
  private Handler m = new cj(this);
  
  public RecordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.setAntiAlias(true);
    this.h = paramContext.getResources().getColor(2131493009);
    this.i = paramContext.getResources().getColor(2131493010);
    this.j = paramContext.getResources().getColor(2131493011);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a)
    {
      this.b.setColor(this.h);
      paramCanvas.drawRect(0.0F, getTop(), this.c, getTop() + getHeight(), this.b);
      if (!this.k) {
        break label109;
      }
      this.b.setColor(this.i);
    }
    for (;;)
    {
      paramCanvas.drawRect(this.c, getTop(), this.c + this.g, getTop() + getHeight(), this.b);
      return;
      label109:
      this.b.setColor(this.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.RecordTextView
 * JD-Core Version:    0.7.0.1
 */