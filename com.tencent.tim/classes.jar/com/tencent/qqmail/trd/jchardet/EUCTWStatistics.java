package com.tencent.qqmail.trd.jchardet;

public class EUCTWStatistics
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
  
  public EUCTWStatistics()
  {
    mFirstByteFreq = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.119286F, 0.052233F, 0.044126F, 0.052494F, 0.045906F, 0.019038F, 0.032465F, 0.026252F, 0.025502F, 0.015963F, 0.052493F, 0.019256F, 0.015137F, 0.031782F, 0.01737F, 0.018494F, 0.015575F, 0.016621F, 0.007444F, 0.011642F, 0.013916F, 0.019159F, 0.016445F, 0.007851F, 0.011079F, 0.022842F, 0.015513F, 0.010033F, 0.00995F, 0.010347F, 0.013103F, 0.015371F, 0.012502F, 0.007436F, 0.018253F, 0.014134F, 0.008907F, 0.005411F, 0.00957F, 0.013598F, 0.006092F, 0.007409F, 0.008432F, 0.005816F, 0.009349F, 0.005472F, 0.00717F, 0.00742F, 0.003681F, 0.007523F, 0.00461F, 0.006154F, 0.003348F, 0.005074F, 0.005922F, 0.005254F, 0.004682F, 0.002093F, 0.0F };
    mFirstByteStdDev = 0.016681F;
    mFirstByteMean = 0.010638F;
    mFirstByteWeight = 0.715599F;
    mSecondByteFreq = new float[] { 0.028933F, 0.011371F, 0.011053F, 0.007232F, 0.010192F, 0.004093F, 0.015043F, 0.011752F, 0.022387F, 0.00841F, 0.012448F, 0.007473F, 0.003594F, 0.007139F, 0.018912F, 0.006083F, 0.003302F, 0.010215F, 0.008791F, 0.024236F, 0.014107F, 0.014108F, 0.010303F, 0.009728F, 0.007877F, 0.009719F, 0.007952F, 0.021028F, 0.005764F, 0.009341F, 0.006591F, 0.012517F, 0.005921F, 0.008982F, 0.008771F, 0.012802F, 0.005926F, 0.008342F, 0.003086F, 0.006843F, 0.007576F, 0.004734F, 0.016404F, 0.008803F, 0.008071F, 0.005349F, 0.008566F, 0.01084F, 0.015401F, 0.031904F, 0.00867F, 0.011479F, 0.010936F, 0.007617F, 0.008995F, 0.008114F, 0.008658F, 0.005934F, 0.010452F, 0.009142F, 0.004519F, 0.008339F, 0.007476F, 0.007027F, 0.006025F, 0.021804F, 0.024248F, 0.015895F, 0.003768F, 0.010171F, 0.010007F, 0.010178F, 0.008316F, 0.006832F, 0.006364F, 0.009141F, 0.009148F, 0.012081F, 0.011914F, 0.004464F, 0.014257F, 0.006907F, 0.011292F, 0.018622F, 0.008149F, 0.004636F, 0.006612F, 0.013478F, 0.012614F, 0.005186F, 0.048285F, 0.006816F, 0.006743F, 0.008671F };
    mSecondByteStdDev = 0.00663F;
    mSecondByteMean = 0.010638F;
    mSecondByteWeight = 0.284401F;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.EUCTWStatistics
 * JD-Core Version:    0.7.0.1
 */