package com.tencent.jni;

public class LiveThreshold
{
  double mBlinkScore = 0.15D;
  double mDownAngle = this.mUpAngle;
  double mLeftAngle = this.mUpAngle;
  double mMouthOpenScore = 1.0D;
  double mNodAngle = 20.0D;
  double mRightAngle = this.mUpAngle;
  double mShakeAngle = 20.0D;
  double mUpAngle = 21.0D;
  
  public double LeftAngle()
  {
    return this.mLeftAngle;
  }
  
  public double blinkScore()
  {
    return this.mBlinkScore;
  }
  
  public double downAngle()
  {
    return this.mDownAngle;
  }
  
  public double mouthOpenScore()
  {
    return this.mMouthOpenScore;
  }
  
  public double nodAngle()
  {
    return this.mNodAngle;
  }
  
  public double rightAngle()
  {
    return this.mRightAngle;
  }
  
  public void setBlinkScore(double paramDouble)
  {
    this.mBlinkScore = paramDouble;
  }
  
  public void setDownAngle(double paramDouble)
  {
    this.mDownAngle = paramDouble;
  }
  
  public void setLeftAngle(double paramDouble)
  {
    this.mLeftAngle = paramDouble;
  }
  
  public void setMouthOpenScore(double paramDouble)
  {
    this.mMouthOpenScore = paramDouble;
  }
  
  public void setNodAngle(double paramDouble)
  {
    this.mNodAngle = paramDouble;
  }
  
  public void setRightAngle(double paramDouble)
  {
    this.mRightAngle = paramDouble;
  }
  
  public void setShakeAngle(double paramDouble)
  {
    this.mShakeAngle = paramDouble;
  }
  
  public void setUpAngle(double paramDouble)
  {
    this.mUpAngle = paramDouble;
  }
  
  public double shakeAngle()
  {
    return this.mShakeAngle;
  }
  
  public double upAngle()
  {
    return this.mUpAngle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.jni.LiveThreshold
 * JD-Core Version:    0.7.0.1
 */