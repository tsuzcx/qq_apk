package com.tencent.qqmail.trd.jchardet;

public class nsUCS2LEVerifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsUCS2LEVerifier()
  {
    cclass = new int[32];
    cclass[0] = 0;
    cclass[1] = 2097408;
    cclass[2] = 0;
    cclass[3] = 12288;
    cclass[4] = 0;
    cclass[5] = 3355440;
    cclass[6] = 0;
    cclass[7] = 0;
    cclass[8] = 0;
    cclass[9] = 0;
    cclass[10] = 0;
    cclass[11] = 0;
    cclass[12] = 0;
    cclass[13] = 0;
    cclass[14] = 0;
    cclass[15] = 0;
    cclass[16] = 0;
    cclass[17] = 0;
    cclass[18] = 0;
    cclass[19] = 0;
    cclass[20] = 0;
    cclass[21] = 0;
    cclass[22] = 0;
    cclass[23] = 0;
    cclass[24] = 0;
    cclass[25] = 0;
    cclass[26] = 0;
    cclass[27] = 0;
    cclass[28] = 0;
    cclass[29] = 0;
    cclass[30] = 0;
    cclass[31] = 1409286144;
    states = new int[7];
    states[0] = 288647014;
    states[1] = 572657937;
    states[2] = 303387938;
    states[3] = 1712657749;
    states[4] = 357927015;
    states[5] = 1427182933;
    states[6] = 1381717;
    charset = "UTF-16LE";
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
    return true;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsUCS2LEVerifier
 * JD-Core Version:    0.7.0.1
 */