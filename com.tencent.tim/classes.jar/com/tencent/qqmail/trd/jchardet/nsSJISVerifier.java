package com.tencent.qqmail.trd.jchardet;

public class nsSJISVerifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsSJISVerifier()
  {
    cclass = new int[32];
    cclass[0] = 286331152;
    cclass[1] = 1118481;
    cclass[2] = 286331153;
    cclass[3] = 286327057;
    cclass[4] = 286331153;
    cclass[5] = 286331153;
    cclass[6] = 286331153;
    cclass[7] = 286331153;
    cclass[8] = 572662306;
    cclass[9] = 572662306;
    cclass[10] = 572662306;
    cclass[11] = 572662306;
    cclass[12] = 572662306;
    cclass[13] = 572662306;
    cclass[14] = 572662306;
    cclass[15] = 304226850;
    cclass[16] = 858993459;
    cclass[17] = 858993459;
    cclass[18] = 858993459;
    cclass[19] = 858993459;
    cclass[20] = 572662308;
    cclass[21] = 572662306;
    cclass[22] = 572662306;
    cclass[23] = 572662306;
    cclass[24] = 572662306;
    cclass[25] = 572662306;
    cclass[26] = 572662306;
    cclass[27] = 572662306;
    cclass[28] = 858993459;
    cclass[29] = 1145393971;
    cclass[30] = 1145324612;
    cclass[31] = 279620;
    states = new int[3];
    states[0] = 286339073;
    states[1] = 572657937;
    states[2] = 4386;
    charset = "Shift_JIS";
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsSJISVerifier
 * JD-Core Version:    0.7.0.1
 */