package com.tencent.mobileqq.shortvideo.dancemachine;

import java.nio.FloatBuffer;

public class Color4f
{
  public static final Color4f BLACK = new Color4f(0.0F, 0.0F, 0.0F, 1.0F);
  public static final Color4f WHITE = new Color4f(1.0F, 1.0F, 1.0F, 1.0F);
  private float a;
  private float b;
  private float g;
  private float r;
  
  public Color4f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r = paramFloat1;
    this.g = paramFloat2;
    this.b = paramFloat3;
    this.a = paramFloat4;
  }
  
  public float getAlpha()
  {
    return this.a;
  }
  
  public float getBlue()
  {
    return this.b;
  }
  
  public float getGreen()
  {
    return this.g;
  }
  
  public float[] getPremultipliedRGBComponents()
  {
    return new float[] { this.r * this.a, this.g * this.a, this.b * this.a, this.a };
  }
  
  public float getRed()
  {
    return this.r;
  }
  
  public void putValue(FloatBuffer paramFloatBuffer)
  {
    paramFloatBuffer.put(this.r);
    paramFloatBuffer.put(this.g);
    paramFloatBuffer.put(this.b);
    paramFloatBuffer.put(this.a);
  }
  
  public void setValue(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r = paramFloat1;
    this.g = paramFloat2;
    this.b = paramFloat3;
    this.a = paramFloat4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.Color4f
 * JD-Core Version:    0.7.0.1
 */