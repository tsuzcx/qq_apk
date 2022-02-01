package com.tencent.biz.webviewplugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class Hole
  extends View
{
  private Paint aJ;
  public int radius;
  public int x;
  public int y;
  
  public Hole(Context paramContext)
  {
    super(paramContext);
  }
  
  public Hole(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aJ = new Paint();
    this.aJ.setColor(-16777216);
    this.aJ.setAntiAlias(true);
    this.aJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  public Hole(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawARGB(221, 0, 0, 0);
    paramCanvas.drawCircle(this.x, this.y, this.radius, this.aJ);
  }
  
  public void setHole(int paramInt1, int paramInt2, int paramInt3)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.radius = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Hole
 * JD-Core Version:    0.7.0.1
 */