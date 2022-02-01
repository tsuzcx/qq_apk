package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;
import atau.a;

public class ArcBackGroundTextView
  extends TextView
{
  private Paint as = new Paint();
  private int avq;
  private int avr;
  private float hG;
  private float hH;
  private Path mPath;
  
  public ArcBackGroundTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ArcBackGroundTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ArcBackGroundTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.as.setColor(1711276032);
    this.as.setStyle(Paint.Style.FILL);
    this.mPath = new Path();
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, atau.a.pE, 0, 0);
    this.hG = paramContext.getDimension(1, 0.0F);
    this.hH = paramContext.getDimension(0, 0.0F);
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.mPath, this.as);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.avq = Math.round(this.hH);
    this.avr = ((int)Math.round(Math.sqrt(Math.pow(this.hG, 2.0D) - Math.pow(this.hG - this.avq, 2.0D)) * 2.0D));
    setMeasuredDimension(this.avr, this.avq);
    if (getId() == 2131376607) {}
    for (paramInt1 = 0;; paramInt1 = 5) {
      for (float f1 = 0.0F; f1 < this.avr; f1 = (float)(f1 + 0.2D))
      {
        float f2 = (float)(Math.sqrt(Math.pow(this.hG, 2.0D) - Math.pow(f1 - this.avr / 2, 2.0D)) - this.avq);
        this.mPath.lineTo(f1, f2 + paramInt1);
      }
    }
    this.mPath.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.ArcBackGroundTextView
 * JD-Core Version:    0.7.0.1
 */