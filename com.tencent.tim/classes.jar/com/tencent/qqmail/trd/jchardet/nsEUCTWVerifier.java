package com.tencent.qqmail.trd.jchardet;

public class nsEUCTWVerifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsEUCTWVerifier()
  {
    cclass = new int[32];
    cclass[0] = 572662306;
    cclass[1] = 2236962;
    cclass[2] = 572662306;
    cclass[3] = 572654114;
    cclass[4] = 572662306;
    cclass[5] = 572662306;
    cclass[6] = 572662306;
    cclass[7] = 572662306;
    cclass[8] = 572662306;
    cclass[9] = 572662306;
    cclass[10] = 572662306;
    cclass[11] = 572662306;
    cclass[12] = 572662306;
    cclass[13] = 572662306;
    cclass[14] = 572662306;
    cclass[15] = 572662306;
    cclass[16] = 0;
    cclass[17] = 100663296;
    cclass[18] = 0;
    cclass[19] = 0;
    cclass[20] = 1145324592;
    cclass[21] = 286331221;
    cclass[22] = 286331153;
    cclass[23] = 286331153;
    cclass[24] = 858985233;
    cclass[25] = 858993459;
    cclass[26] = 858993459;
    cclass[27] = 858993459;
    cclass[28] = 858993459;
    cclass[29] = 858993459;
    cclass[30] = 858993459;
    cclass[31] = 53687091;
    states = new int[6];
    states[0] = 338898961;
    states[1] = 571543825;
    states[2] = 269623842;
    states[3] = 286330880;
    states[4] = 1052949;
    states[5] = 16;
    charset = "x-euc-tw";
    stFactor = 7;
  }
  
  public int[] cclass()
  {
    return cclass;
  }
  
  public String charset()
  {
    return charset;
  }
  
  public boolean isUCS2()
  {
    return false;
  }
  
  public int stFactor()
  {
    return stFactor;
  }
  
  public int[] states()
  {
    return states;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsEUCTWVerifier
 * JD-Core Version:    0.7.0.1
 */