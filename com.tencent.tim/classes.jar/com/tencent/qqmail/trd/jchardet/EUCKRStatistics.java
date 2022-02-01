package com.tencent.qqmail.trd.jchardet;

public class EUCKRStatistics
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
  
  public EUCKRStatistics()
  {
    mFirstByteFreq = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.000412F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.057502F, 0.033182F, 0.002267F, 0.016076F, 0.014633F, 0.032976F, 0.004122F, 0.011336F, 0.058533F, 0.024526F, 0.025969F, 0.054411F, 0.01958F, 0.063273F, 0.113974F, 0.029885F, 0.150041F, 0.059151F, 0.002679F, 0.009893F, 0.014839F, 0.026381F, 0.015045F, 0.069456F, 0.08986F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    mFirstByteStdDev = 0.025593F;
    mFirstByteMean = 0.010638F;
    mFirstByteWeight = 0.647437F;
    mSecondByteFreq = new float[] { 0.016694F, 0.0F, 0.012778F, 0.030091F, 0.002679F, 0.006595F, 0.001855F, 0.000824F, 0.005977F, 0.00474F, 0.003092F, 0.000824F, 0.01958F, 0.037304F, 0.008244F, 0.014633F, 0.001031F, 0.0F, 0.003298F, 0.002061F, 0.006183F, 0.005977F, 0.000824F, 0.021847F, 0.014839F, 0.052968F, 0.017312F, 0.007626F, 0.000412F, 0.000824F, 0.011129F, 0.0F, 0.000412F, 0.001649F, 0.005977F, 0.065746F, 0.020198F, 0.021434F, 0.014633F, 0.004122F, 0.001649F, 0.000824F, 0.000824F, 0.051937F, 0.01958F, 0.023289F, 0.026381F, 0.040396F, 0.009068F, 0.001443F, 0.00371F, 0.00742F, 0.001443F, 0.01319F, 0.002885F, 0.000412F, 0.003298F, 0.025969F, 0.000412F, 0.000412F, 0.006183F, 0.003298F, 0.066983F, 0.002679F, 0.002267F, 0.011129F, 0.000412F, 0.010099F, 0.015251F, 0.007626F, 0.043899F, 0.00371F, 0.002679F, 0.001443F, 0.010923F, 0.002885F, 0.009068F, 0.019992F, 0.000412F, 0.00845F, 0.005153F, 0.0F, 0.010099F, 0.0F, 0.001649F, 0.01216F, 0.011542F, 0.006595F, 0.001855F, 0.010923F, 0.000412F, 0.023702F, 0.00371F, 0.001855F };
    mSecondByteStdDev = 0.013937F;
    mSecondByteMean = 0.010638F;
    mSecondByteWeight = 0.352563F;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.EUCKRStatistics
 * JD-Core Version:    0.7.0.1
 */