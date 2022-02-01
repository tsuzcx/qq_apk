package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import aqnm;

public class MultiCardMaskView
  extends View
{
  private boolean cpa = true;
  private Path mPath;
  private float mRadius = aqnm.dpToPx(12.0F);
  private RectF mRectF;
  
  public MultiCardMaskView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MultiCardMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    init();
  }
  
  private void init()
  {
    setWillNotDraw(false);
    this.mPath = new Path();
    this.mRectF = new RectF();
    if ((Build.VERSION.SDK_INT <= 18) || (isInBlackList())) {
      setLayerType(1, null);
    }
  }
  
  private boolean isInBlackList()
  {
    return (Build.VERSION.SDK_INT == 24) && ("Xiaomi".equals(Build.MANUFACTURER)) && ("MIX".equals(Build.MODEL));
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.cpa)
    {
      this.mPath.reset();
      this.mRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      this.mPath.addRoundRect(this.mRectF, this.mRadius, this.mRadius, Path.Direction.CW);
      paramCanvas.clipPath(this.mPath);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardMaskView
 * JD-Core Version:    0.7.0.1
 */