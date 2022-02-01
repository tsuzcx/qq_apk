package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.util.VersionUtils;

public class HighLightMaskView
  extends View
{
  PorterDuffXfermode e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  Paint mPaint = new Paint();
  Path mPath;
  
  public HighLightMaskView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HighLightMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void init()
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    this.mPath.reset();
    if (VersionUtils.isHoneycomb()) {
      setLayerType(1, null);
    }
    this.mPaint.setColor(0);
    this.mPaint.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(-1728053248);
    this.mPaint.setXfermode(this.e);
    paramCanvas.drawPath(this.mPath, this.mPaint);
    this.mPaint.setXfermode(null);
  }
  
  public void setCircleSrc(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    init();
    this.mPath.addCircle(paramFloat1, paramFloat2, paramFloat3, Path.Direction.CW);
  }
  
  public void setRoundSrc(RectF paramRectF, float[] paramArrayOfFloat)
  {
    init();
    this.mPath.addRoundRect(paramRectF, paramArrayOfFloat, Path.Direction.CW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.HighLightMaskView
 * JD-Core Version:    0.7.0.1
 */