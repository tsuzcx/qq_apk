package com.tencent.qqmail.trd.jchardet;

public class nsBIG5Verifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsBIG5Verifier()
  {
    cclass = new int[32];
    cclass[0] = 286331153;
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
    cclass[16] = 1145324612;
    cclass[17] = 1145324612;
    cclass[18] = 1145324612;
    cclass[19] = 1145324612;
    cclass[20] = 858993460;
    cclass[21] = 858993459;
    cclass[22] = 858993459;
    cclass[23] = 858993459;
    cclass[24] = 858993459;
    cclass[25] = 858993459;
    cclass[26] = 858993459;
    cclass[27] = 858993459;
    cclass[28] = 858993459;
    cclass[29] = 858993459;
    cclass[30] = 858993459;
    cclass[31] = 53687091;
    states = new int[3];
    states[0] = 286339073;
    states[1] = 304226833;
    states[2] = 1;
    charset = "Big5";
    stFactor = 5;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsBIG5Verifier
 * JD-Core Version:    0.7.0.1
 */