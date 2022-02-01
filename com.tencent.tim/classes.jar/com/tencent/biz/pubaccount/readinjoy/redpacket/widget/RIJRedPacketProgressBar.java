package com.tencent.biz.pubaccount.readinjoy.redpacket.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import aqcx;
import com.tencent.common.app.BaseApplicationImpl;

public class RIJRedPacketProgressBar
  extends View
{
  private static final float STROKE_WIDTH = j(2.0F);
  private static final float jy = j(27.0F);
  private static final float jz = j(27.0F);
  private RectF F = new RectF();
  private Paint aC = new Paint();
  private Paint aD = new Paint();
  private Paint af = new Paint();
  private float progress;
  
  public RIJRedPacketProgressBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RIJRedPacketProgressBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    setBackgroundColor(0);
    this.aC.setAntiAlias(true);
    this.aC.setColor(Color.parseColor("#FFFFCC00"));
    this.aC.setStrokeWidth(STROKE_WIDTH);
    this.aC.setStyle(Paint.Style.STROKE);
    this.aC.setStrokeCap(Paint.Cap.ROUND);
    this.af.setStyle(Paint.Style.FILL);
    this.af.setAntiAlias(true);
    this.af.setColor(Color.parseColor("#FFFF570F"));
    this.F.left = (STROKE_WIDTH / 2.0F);
    this.F.top = (STROKE_WIDTH / 2.0F);
    this.F.right = (jy - STROKE_WIDTH / 2.0F);
    this.F.bottom = (jz - STROKE_WIDTH / 2.0F);
    this.aD.setAntiAlias(true);
    invalidate();
    requestLayout();
  }
  
  private static int j(float paramFloat)
  {
    return aqcx.dip2px(BaseApplicationImpl.getContext(), paramFloat);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.F, -90.0F, this.progress / 100.0F * 360.0F, false, this.aC);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension((int)jy, (int)jz);
  }
  
  public void setProgress(float paramFloat)
  {
    this.progress = paramFloat;
    invalidate();
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressBar
 * JD-Core Version:    0.7.0.1
 */