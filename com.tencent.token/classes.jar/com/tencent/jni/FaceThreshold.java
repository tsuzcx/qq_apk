package com.tencent.jni;

public class FaceThreshold
{
  float mFaceDisparity = 2.0F;
  float mRegisterLightHigh = 1.0F;
  float mRegisterLightLow = 0.2F;
  float mValidateLightHigh = 1.0F;
  float mValidateLightLow = 0.1F;
  
  public float faceDisparity()
  {
    return this.mFaceDisparity;
  }
  
  public float registerLightHigh()
  {
    return this.mRegisterLightHigh;
  }
  
  public float registerLightLow()
  {
    return this.mRegisterLightLow;
  }
  
  public void setFaceDisparity(float paramFloat)
  {
    this.mFaceDisparity = paramFloat;
  }
  
  public void setRegisterLightHigh(float paramFloat)
  {
    this.mRegisterLightHigh = paramFloat;
  }
  
  public void setRegisterLightLow(float paramFloat)
  {
    this.mRegisterLightLow = paramFloat;
  }
  
  public void setValidateLightHigh(float paramFloat)
  {
    this.mValidateLightHigh = paramFloat;
  }
  
  public void setValidateLightLow(float paramFloat)
  {
    this.mValidateLightLow = paramFloat;
  }
  
  public float validateLightHigh()
  {
    return this.mValidateLightHigh;
  }
  
  public float validateLightLow()
  {
    return this.mValidateLightLow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.jni.FaceThreshold
 * JD-Core Version:    0.7.0.1
 */