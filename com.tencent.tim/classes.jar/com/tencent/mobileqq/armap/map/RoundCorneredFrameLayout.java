package com.tencent.mobileqq.armap.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import atau.a;
import wja;

public class RoundCorneredFrameLayout
  extends FrameLayout
{
  public int radius = 6;
  
  @TargetApi(11)
  public RoundCorneredFrameLayout(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
  }
  
  @TargetApi(11)
  public RoundCorneredFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.radius = wja.dp2px(a(paramContext, paramAttributeSet), paramContext.getResources());
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
  }
  
  int a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.tb);
    int i = paramContext.getInt(0, 6);
    paramContext.recycle();
    return i;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    Path localPath = new Path();
    localPath.moveTo(0.0F, this.radius);
    localPath.arcTo(new RectF(0.0F, 0.0F, this.radius * 2, this.radius * 2), -180.0F, 90.0F);
    localPath.lineTo(i - this.radius, 0.0F);
    localPath.arcTo(new RectF(i - this.radius * 2, 0.0F, i, this.radius * 2), -90.0F, 90.0F);
    localPath.lineTo(i, j - this.radius);
    localPath.arcTo(new RectF(i - this.radius * 2, j - this.radius * 2, i, j), 0.0F, 90.0F);
    localPath.lineTo(this.radius, j);
    localPath.arcTo(new RectF(0.0F, j - this.radius * 2, this.radius * 2, j), 90.0F, 90.0F);
    localPath.lineTo(0.0F, this.radius);
    localPath.close();
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout
 * JD-Core Version:    0.7.0.1
 */