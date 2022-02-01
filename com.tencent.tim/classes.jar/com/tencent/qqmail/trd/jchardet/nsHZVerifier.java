package com.tencent.qqmail.trd.jchardet;

public class nsHZVerifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsHZVerifier()
  {
    cclass = new int[32];
    cclass[0] = 1;
    cclass[1] = 0;
    cclass[2] = 0;
    cclass[3] = 4096;
    cclass[4] = 0;
    cclass[5] = 0;
    cclass[6] = 0;
    cclass[7] = 0;
    cclass[8] = 0;
    cclass[9] = 0;
    cclass[10] = 0;
    cclass[11] = 0;
    cclass[12] = 0;
    cclass[13] = 0;
    cclass[14] = 0;
    cclass[15] = 38813696;
    cclass[16] = 286331153;
    cclass[17] = 286331153;
    cclass[18] = 286331153;
    cclass[19] = 286331153;
    cclass[20] = 286331153;
    cclass[21] = 286331153;
    cclass[22] = 286331153;
    cclass[23] = 286331153;
    cclass[24] = 286331153;
    cclass[25] = 286331153;
    cclass[26] = 286331153;
    cclass[27] = 286331153;
    cclass[28] = 286331153;
    cclass[29] = 286331153;
    cclass[30] = 286331153;
    cclass[31] = 286331153;
    states = new int[6];
    states[0] = 285213456;
    states[1] = 572657937;
    states[2] = 335548706;
    states[3] = 341120533;
    states[4] = 336872468;
    states[5] = 36;
    charset = "HZ-GB-2312";
    stFactor = 6;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsHZVerifier
 * JD-Core Version:    0.7.0.1
 */