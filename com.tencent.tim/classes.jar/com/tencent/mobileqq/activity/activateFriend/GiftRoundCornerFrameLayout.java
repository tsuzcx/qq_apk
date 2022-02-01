package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import aqnm;

public class GiftRoundCornerFrameLayout
  extends FrameLayout
{
  private Path mPath;
  private float mRadius = aqnm.dpToPx(4.0F);
  private RectF mRectF;
  
  public GiftRoundCornerFrameLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GiftRoundCornerFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public GiftRoundCornerFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.GiftRoundCornerFrameLayout
 * JD-Core Version:    0.7.0.1
 */