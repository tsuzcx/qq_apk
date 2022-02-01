package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RoundCornerRelativeLayout
  extends RelativeLayout
{
  private Path mPath;
  private float mRadius;
  private RectF mRectF;
  
  public RoundCornerRelativeLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPath = new Path();
    this.mRectF = new RectF();
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    this.mPath.reset();
    this.mRectF.set(0.0F, 0.0F, getWidth(), getHeight());
    this.mPath.addRoundRect(this.mRectF, this.mRadius, this.mRadius, Path.Direction.CW);
    paramCanvas.clipPath(this.mPath);
    super.dispatchDraw(paramCanvas);
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.RoundCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */