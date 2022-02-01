package com.tencent.map.core.functions.animation;

import javax.microedition.khronos.opengles.GL10;

public class GLAnimScale
  extends GLAnim
{
  protected float mXScaleEnd;
  protected float mXScaleStart;
  protected float mYScaleEnd;
  protected float mYScaleStart;
  
  public GLAnimScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong)
  {
    super(paramLong);
    this.mXScaleStart = paramFloat1;
    this.mXScaleEnd = paramFloat2;
    this.mYScaleStart = paramFloat3;
    this.mYScaleEnd = paramFloat4;
  }
  
  protected void performDraw(GL10 paramGL10, long paramLong)
  {
    float f4 = this.mXScaleEnd;
    float f5 = this.mXScaleStart;
    float f1 = this.mYScaleEnd;
    float f2 = this.mYScaleStart;
    float f3 = this.mXScaleStart;
    f4 = (f4 - f5) * (float)paramLong / (float)this.duration;
    f5 = this.mYScaleStart;
    paramGL10.glScalef(f4 + f3, (f1 - f2) * (float)paramLong / (float)this.duration + f5, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimScale
 * JD-Core Version:    0.7.0.1
 */