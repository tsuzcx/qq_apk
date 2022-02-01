package com.tencent.qqmail.trd.jchardet;

public class EUCJPStatistics
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
  
  public EUCJPStatistics()
  {
    mFirstByteFreq = new float[] { 0.364808F, 0.0F, 0.0F, 0.145325F, 0.304891F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.001835F, 0.010771F, 0.006462F, 0.001157F, 0.002114F, 0.003231F, 0.001356F, 0.00742F, 0.004189F, 0.003231F, 0.003032F, 0.03319F, 0.006303F, 0.006064F, 0.009973F, 0.002354F, 0.00367F, 0.009135F, 0.001675F, 0.002792F, 0.002194F, 0.01472F, 0.011928F, 0.000878F, 0.013124F, 0.001077F, 0.009295F, 0.003471F, 0.002872F, 0.002433F, 0.000957F, 0.001636F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 8.0E-005F, 0.000279F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 8.0E-005F, 0.0F };
    mFirstByteStdDev = 0.050407F;
    mFirstByteMean = 0.010638F;
    mFirstByteWeight = 0.640871F;
    mSecondByteFreq = new float[] { 0.002473F, 0.039134F, 0.152745F, 0.009694F, 0.000359F, 0.02218F, 0.000758F, 0.004308F, 0.00016F, 0.002513F, 0.003072F, 0.001316F, 0.00383F, 0.001037F, 0.00359F, 0.000957F, 0.00016F, 0.000239F, 0.006462F, 0.001596F, 0.031554F, 0.001316F, 0.002194F, 0.016555F, 0.003271F, 0.000678F, 0.000598F, 0.206438F, 0.000718F, 0.001077F, 0.00371F, 0.001356F, 0.001356F, 0.000439F, 0.004388F, 0.005704F, 0.000878F, 0.010172F, 0.007061F, 0.01468F, 0.000638F, 0.02573F, 0.002792F, 0.000718F, 0.001795F, 0.091551F, 0.000758F, 0.003909F, 0.000558F, 0.031195F, 0.007061F, 0.001316F, 0.022579F, 0.006981F, 0.00726F, 0.001117F, 0.000239F, 0.012127F, 0.000878F, 0.00379F, 0.001077F, 0.000758F, 0.002114F, 0.002234F, 0.000678F, 0.002992F, 0.003311F, 0.023416F, 0.001237F, 0.002753F, 0.005146F, 0.002194F, 0.007021F, 0.008497F, 0.013763F, 0.011768F, 0.006303F, 0.001915F, 0.000638F, 0.008776F, 0.000918F, 0.003431F, 0.057603F, 0.000439F, 0.000439F, 0.000758F, 0.002872F, 0.001675F, 0.01105F, 0.0F, 0.000279F, 0.012127F, 0.000718F, 0.00738F };
    mSecondByteStdDev = 0.028247F;
    mSecondByteMean = 0.010638F;
    mSecondByteWeight = 0.359129F;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.EUCJPStatistics
 * JD-Core Version:    0.7.0.1
 */