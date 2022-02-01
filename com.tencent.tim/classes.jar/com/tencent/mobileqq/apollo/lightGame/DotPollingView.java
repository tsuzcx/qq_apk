package com.tencent.mobileqq.apollo.lightGame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import jll;

public class DotPollingView
  extends View
{
  private Paint D = new Paint();
  private final String TAG = "DotPollingView";
  private int aXw;
  private Paint bo = new Paint();
  private int cpU = 3;
  private int cpV;
  private int cpW;
  private int cpX;
  private int cpY;
  int cpZ = 0;
  private int mColor;
  private Context mContext;
  private float sx;
  float sy = this.cpV;
  
  public DotPollingView(Context paramContext)
  {
    this(paramContext, null);
    this.mContext = paramContext;
    init();
  }
  
  public DotPollingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.mContext = paramContext;
    init();
  }
  
  public DotPollingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    this.mColor = -16777216;
    this.aXw = -16777216;
    this.cpV = ((int)jll.dp2px(this.mContext, 2.5F));
    this.cpW = ((int)jll.dp2px(this.mContext, 4.5F));
    this.cpX = ((int)jll.dp2px(this.mContext, 10.0F));
    this.cpU = 3;
    this.sx = 0.3F;
    this.bo.setColor(this.aXw);
    this.bo.setAntiAlias(true);
    this.bo.setStyle(Paint.Style.FILL);
    this.D.setColor(this.mColor);
    this.D.setAntiAlias(true);
    this.D.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.sy += this.sx;
    if (this.sy >= this.cpW)
    {
      i = this.cpZ + 1;
      this.cpZ = i;
      this.cpY = (i % 3);
      this.sy = this.cpV;
    }
    this.D.setAlpha(76);
    int i = (int)(76.5D + 178.5D * ((this.sy - this.cpV) / (this.cpW - this.cpV)));
    this.bo.setAlpha(i);
    i = getWidth() / 2;
    int j = (this.cpU * this.cpV * 2 + (this.cpU - 1) * this.cpX) / 2;
    j = this.cpV + (i - j);
    int k = getHeight() / 2;
    i = 0;
    if (i < this.cpU)
    {
      if (this.cpY == i) {
        paramCanvas.drawCircle(this.cpY * (this.cpV * 2 + this.cpX) + j, k, this.sy, this.bo);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle((this.cpV * 2 + this.cpX) * i + j, k, this.cpV, this.D);
      }
    }
    invalidate();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      paramInt1 = i;
      if (k != 1073741824) {
        break label102;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      int j = this.cpU * this.cpV * 2 + (this.cpU - 1) * this.cpX + (this.cpW - this.cpV) * 2;
      paramInt1 = j;
      if (m != -2147483648) {
        break;
      }
      paramInt1 = Math.min(j, i);
      break;
      label102:
      i = this.cpW * 2;
      if (k == -2147483648) {
        paramInt2 = Math.min(i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
    this.D.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.DotPollingView
 * JD-Core Version:    0.7.0.1
 */