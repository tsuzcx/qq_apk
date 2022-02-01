package com.tencent.qqmail.trd.jchardet;

public class GB2312Statistics
  extends nsEUCStatistics
{
  static float[] mFirstByteFreq;
  static float mFirstByteMean;
  static float mFirstByteStdDev;
  static float mFirstByteWeight;
  static float[] mSecondByteFreq;
  static float mSecondByteMean;
  static float mSecondByteStdDev;
  static float mSecondByteWeight;
  
  public GB2312Statistics()
  {
    mFirstByteFreq = new float[] { 0.011628F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.011628F, 0.012403F, 0.009302F, 0.003876F, 0.017829F, 0.037209F, 0.008527F, 0.010078F, 0.01938F, 0.054264F, 0.010078F, 0.041085F, 0.02093F, 0.018605F, 0.010078F, 0.013178F, 0.016279F, 0.006202F, 0.009302F, 0.017054F, 0.011628F, 0.008527F, 0.004651F, 0.006202F, 0.017829F, 0.024806F, 0.020155F, 0.013953F, 0.032558F, 0.035659F, 0.068217F, 0.010853F, 0.036434F, 0.117054F, 0.027907F, 0.100775F, 0.010078F, 0.017829F, 0.062016F, 0.012403F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.00155F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    mFirstByteStdDev = 0.020081F;
    mFirstByteMean = 0.010638F;
    mFirstByteWeight = 0.586533F;
    mSecondByteFreq = new float[] { 0.006202F, 0.031008F, 0.005426F, 0.003101F, 0.00155F, 0.003101F, 0.082171F, 0.014729F, 0.006977F, 0.00155F, 0.013953F, 0.0F, 0.013953F, 0.010078F, 0.008527F, 0.006977F, 0.004651F, 0.003101F, 0.003101F, 0.003101F, 0.008527F, 0.003101F, 0.005426F, 0.005426F, 0.005426F, 0.003101F, 0.00155F, 0.006202F, 0.014729F, 0.010853F, 0.0F, 0.011628F, 0.0F, 0.031783F, 0.013953F, 0.030233F, 0.039535F, 0.008527F, 0.015504F, 0.0F, 0.003101F, 0.008527F, 0.016279F, 0.005426F, 0.00155F, 0.013953F, 0.013953F, 0.044961F, 0.003101F, 0.004651F, 0.006977F, 0.00155F, 0.005426F, 0.012403F, 0.00155F, 0.015504F, 0.0F, 0.006202F, 0.00155F, 0.0F, 0.007752F, 0.006977F, 0.00155F, 0.009302F, 0.011628F, 0.004651F, 0.010853F, 0.012403F, 0.017829F, 0.005426F, 0.024806F, 0.0F, 0.006202F, 0.0F, 0.082171F, 0.015504F, 0.004651F, 0.0F, 0.006977F, 0.004651F, 0.0F, 0.008527F, 0.012403F, 0.004651F, 0.003876F, 0.003101F, 0.022481F, 0.024031F, 0.00155F, 0.047287F, 0.009302F, 0.00155F, 0.005426F, 0.017054F };
    mSecondByteStdDev = 0.014156F;
    mSecondByteMean = 0.010638F;
    mSecondByteWeight = 0.413467F;
  }
  
  public float[] mFirstByteFreq()
  {
    return mFirstByteFreq;
  }
  
  public float mFirstByteMean()
  {
    return mFirstByteMean;
  }
  
  public float mFirstByteStdDev()
  {
    return mFirstByteStdDev;
  }
  
  public float mFirstByteWeight()
  {
    return mFirstByteWeight;
  }
  
  public float[] mSecondByteFreq()
  {
    return mSecondByteFreq;
  }
  
  public float mSecondByteMean()
  {
    return mSecondByteMean;
  }
  
  public float mSecondByteStdDev()
  {
    return mSecondByteStdDev;
  }
  
  public float mSecondByteWeight()
  {
    return mSecondByteWeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.GB2312Statistics
 * JD-Core Version:    0.7.0.1
 */