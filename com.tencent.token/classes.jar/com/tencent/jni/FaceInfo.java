package com.tencent.jni;

public class FaceInfo
{
  byte[] mFaceData;
  boolean mIsBright = true;
  float mQualityScore;
  
  public byte[] faceData()
  {
    return this.mFaceData;
  }
  
  public boolean isBright()
  {
    return this.mIsBright;
  }
  
  public float qualityScore()
  {
    return this.mQualityScore;
  }
  
  public void setFaceData(byte[] paramArrayOfByte)
  {
    this.mFaceData = paramArrayOfByte;
  }
  
  public void setIsBright(boolean paramBoolean)
  {
    this.mIsBright = paramBoolean;
  }
  
  public void setQualityScore(float paramFloat)
  {
    this.mQualityScore = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.jni.FaceInfo
 * JD-Core Version:    0.7.0.1
 */