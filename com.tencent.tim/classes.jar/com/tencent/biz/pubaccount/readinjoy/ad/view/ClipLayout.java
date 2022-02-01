package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ClipLayout
  extends RelativeLayout
{
  private boolean agD = true;
  private Path o;
  
  public ClipLayout(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public ClipLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  private void aER()
  {
    this.o = new Path();
    RectF localRectF = new RectF(new Rect(0, 0, getWidth(), getHeight()));
    this.o.addRect(localRectF, Path.Direction.CCW);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.agD)
    {
      if (this.o == null) {
        aER();
      }
      paramCanvas.clipPath(this.o, Region.Op.REPLACE);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setNeedClip(boolean paramBoolean)
  {
    this.agD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ClipLayout
 * JD-Core Version:    0.7.0.1
 */