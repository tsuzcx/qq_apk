package com.tencent.qqmail.trd.jchardet;

public class Big5Statistics
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
  
  public Big5Statistics()
  {
    mFirstByteFreq = new float[] { 0.0F, 0.0F, 0.0F, 0.114427F, 0.061058F, 0.075598F, 0.048386F, 0.063966F, 0.027094F, 0.095787F, 0.029525F, 0.031331F, 0.036915F, 0.021805F, 0.019349F, 0.037496F, 0.018068F, 0.01276F, 0.030053F, 0.017339F, 0.016731F, 0.019501F, 0.01124F, 0.032973F, 0.016658F, 0.015872F, 0.021458F, 0.012378F, 0.017003F, 0.020802F, 0.012454F, 0.009239F, 0.012829F, 0.007922F, 0.010079F, 0.009815F, 0.010104F, 0.0F, 0.0F, 0.0F, 5.3E-005F, 3.5E-005F, 0.000105F, 3.1E-005F, 8.8E-005F, 2.7E-005F, 2.7E-005F, 2.6E-005F, 3.5E-005F, 2.4E-005F, 3.4E-005F, 0.000375F, 2.5E-005F, 2.8E-005F, 2.0E-005F, 2.4E-005F, 2.8E-005F, 3.1E-005F, 5.9E-005F, 4.0E-005F, 3.0E-005F, 7.9E-005F, 3.7E-005F, 4.0E-005F, 2.3E-005F, 3.0E-005F, 2.7E-005F, 6.4E-005F, 2.0E-005F, 2.7E-005F, 2.5E-005F, 7.4E-005F, 1.9E-005F, 2.3E-005F, 2.1E-005F, 1.8E-005F, 1.7E-005F, 3.5E-005F, 2.1E-005F, 1.9E-005F, 2.5E-005F, 1.7E-005F, 3.7E-005F, 1.8E-005F, 1.8E-005F, 1.9E-005F, 2.2E-005F, 3.3E-005F, 3.2E-005F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    mFirstByteStdDev = 0.020606F;
    mFirstByteMean = 0.010638F;
    mFirstByteWeight = 0.675261F;
    mSecondByteFreq = new float[] { 0.020256F, 0.003293F, 0.045811F, 0.01665F, 0.007066F, 0.004146F, 0.009229F, 0.007333F, 0.003296F, 0.005239F, 0.008282F, 0.003791F, 0.006116F, 0.003536F, 0.004024F, 0.016654F, 0.009334F, 0.005429F, 0.033392F, 0.006121F, 0.008983F, 0.002801F, 0.004221F, 0.010357F, 0.014695F, 0.077937F, 0.006314F, 0.00402F, 0.007331F, 0.00715F, 0.005341F, 0.009195F, 0.00535F, 0.005698F, 0.004472F, 0.007242F, 0.004039F, 0.011154F, 0.016184F, 0.004741F, 0.012814F, 0.007679F, 0.008045F, 0.016631F, 0.009451F, 0.016487F, 0.007287F, 0.012688F, 0.017421F, 0.013205F, 0.03148F, 0.003404F, 0.009149F, 0.008921F, 0.007514F, 0.008683F, 0.008203F, 0.031403F, 0.011733F, 0.015617F, 0.015306F, 0.004004F, 0.010899F, 0.009961F, 0.008388F, 0.01092F, 0.003925F, 0.008585F, 0.009108F, 0.015546F, 0.004659F, 0.006934F, 0.007023F, 0.020252F, 0.005387F, 0.024704F, 0.006963F, 0.002625F, 0.009512F, 0.002971F, 0.008233F, 0.01F, 0.011973F, 0.010553F, 0.005945F, 0.006349F, 0.009401F, 0.008577F, 0.008186F, 0.008159F, 0.005033F, 0.008714F, 0.010614F, 0.006554F };
    mSecondByteStdDev = 0.009909F;
    mSecondByteMean = 0.010638F;
    mSecondByteWeight = 0.324739F;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.Big5Statistics
 * JD-Core Version:    0.7.0.1
 */