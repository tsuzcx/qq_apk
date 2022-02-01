package com.tencent.mobileqq.triton.touch;

import com.tencent.mobileqq.triton.jni.TTNativeCall;

public class Touch
{
  @TTNativeCall
  public int identifier;
  @TTNativeCall
  public float screenX;
  @TTNativeCall
  public float screenY;
  
  public Touch(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.identifier = paramInt;
    this.screenX = paramFloat1;
    this.screenY = paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.screenX = paramFloat1;
    this.screenY = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.touch.Touch
 * JD-Core Version:    0.7.0.1
 */