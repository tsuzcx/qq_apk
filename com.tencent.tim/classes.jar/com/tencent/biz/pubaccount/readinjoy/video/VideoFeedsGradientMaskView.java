package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import atau.a;

public class VideoFeedsGradientMaskView
  extends View
{
  LinearGradient g;
  private int mAlpha = 1;
  private int mMode;
  private Paint mPaint = new Paint();
  
  public VideoFeedsGradientMaskView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsGradientMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGradientMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.sG);
    this.mMode = paramContext.getInt(0, 0);
    paramContext.recycle();
    this.mAlpha = ((int)(getAlpha() * 255.0F));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    switch (this.mMode)
    {
    }
    for (;;)
    {
      if (this.g != null)
      {
        this.mPaint.setAlpha(this.mAlpha);
        this.mPaint.setShader(this.g);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.mPaint);
      }
      return;
      if (this.g == null)
      {
        float f = getHeight();
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 1118482, -1508830958, -1508830958 }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
        continue;
        if (this.g == null)
        {
          f = getHeight();
          localTileMode = Shader.TileMode.CLAMP;
          this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -1508830958, -1508830958, 1118482 }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
          continue;
          if (this.g == null)
          {
            this.mAlpha = 255;
            f = getHeight();
            localTileMode = Shader.TileMode.CLAMP;
            this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -872415232, 1711276032, 0 }, new float[] { 0.0F, 0.4F, 1.0F }, localTileMode);
            continue;
            this.mAlpha = 255;
            f = getHeight();
            localTileMode = Shader.TileMode.CLAMP;
            this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, 1711276032, -872415232 }, new float[] { 0.0F, 0.6F, 1.0F }, localTileMode);
            continue;
            if (this.g == null)
            {
              this.mAlpha = 255;
              f = getHeight();
              localTileMode = Shader.TileMode.CLAMP;
              this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -1728053248, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
              continue;
              if (this.g == null)
              {
                this.mAlpha = 255;
                f = getWidth();
                localTileMode = Shader.TileMode.CLAMP;
                this.g = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { -1728053248, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
                continue;
                if (this.g == null)
                {
                  this.mAlpha = 255;
                  f = getWidth();
                  localTileMode = Shader.TileMode.CLAMP;
                  this.g = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { 0, -1728053248 }, new float[] { 0.0F, 1.0F }, localTileMode);
                  continue;
                  if (this.g == null)
                  {
                    this.mAlpha = 255;
                    f = getHeight();
                    localTileMode = Shader.TileMode.CLAMP;
                    this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, 855638016 }, new float[] { 0.0F, 1.0F }, localTileMode);
                    continue;
                    if (this.g == null)
                    {
                      this.mAlpha = 255;
                      f = getHeight();
                      localTileMode = Shader.TileMode.CLAMP;
                      this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 1711276032, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
                      continue;
                      if (this.g == null)
                      {
                        f = getHeight();
                        localTileMode = Shader.TileMode.CLAMP;
                        this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, -16777216 }, new float[] { 0.0F, 1.0F }, localTileMode);
                        continue;
                        if (this.g == null) {
                          this.g = new LinearGradient(0.0F, 0.0F, getWidth(), 0.0F, 0, -16777216, Shader.TileMode.CLAMP);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setMaskAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView
 * JD-Core Version:    0.7.0.1
 */