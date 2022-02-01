package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import rpq;

public class VideoCoverImgBorder
  extends ImageView
{
  private RectF V = new RectF();
  private RectF W = new RectF();
  private final int bmb = rpq.dip2px(getContext(), 1.0F);
  private final int bmc = rpq.dip2px(getContext(), 2.0F);
  private int bmd = this.bmc;
  private int bme;
  private int bmf;
  private int borderColor = -1;
  private int borderWidth = this.bmc;
  private Path mPath;
  
  public VideoCoverImgBorder(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    setState(2);
  }
  
  public VideoCoverImgBorder(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    setState(2);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    this.mPath.reset();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    this.V.left = (this.bme + this.borderWidth);
    this.V.top = (this.bmf + this.borderWidth);
    this.V.right = (getWidth() - this.borderWidth - this.bme);
    this.V.bottom = (getHeight() - this.borderWidth - this.bmf);
    this.mPath.addRoundRect(this.V, this.bmd, this.bmd, Path.Direction.CCW);
    paramCanvas.clipPath(this.mPath);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
    this.mPath.reset();
    this.W.left = this.bme;
    this.W.top = this.bmf;
    this.W.right = (getWidth() - this.bme);
    this.W.bottom = (getHeight() - this.bmf);
    this.mPath.addRoundRect(this.V, this.bmd, this.bmd, Path.Direction.CCW);
    this.mPath.addRoundRect(this.W, this.bmd + this.borderWidth, this.bmd + this.borderWidth, Path.Direction.CCW);
    this.mPath.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.mPath);
    paramCanvas.drawColor(this.borderColor);
    paramCanvas.restoreToCount(i);
  }
  
  public void setState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.bme = this.bmb;
      this.bmf = this.bmb;
      this.borderWidth = this.bmb;
      this.borderColor = -570319;
      return;
    case 1: 
      this.bme = 0;
      this.bmf = 0;
      this.borderWidth = this.bmc;
      this.borderColor = -15550475;
      return;
    }
    this.bme = this.bmb;
    this.bmf = this.bmb;
    this.borderWidth = this.bmb;
    this.borderColor = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverImgBorder
 * JD-Core Version:    0.7.0.1
 */