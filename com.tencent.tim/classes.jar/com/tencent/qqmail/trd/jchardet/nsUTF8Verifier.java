package com.tencent.qqmail.trd.jchardet;

public class nsUTF8Verifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsUTF8Verifier()
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
    cclass[8] = 286331153;
    cclass[9] = 286331153;
    cclass[10] = 286331153;
    cclass[11] = 286331153;
    cclass[12] = 286331153;
    cclass[13] = 286331153;
    cclass[14] = 286331153;
    cclass[15] = 286331153;
    cclass[16] = 858989090;
    cclass[17] = 1145324612;
    cclass[18] = 1145324612;
    cclass[19] = 1145324612;
    cclass[20] = 1431655765;
    cclass[21] = 1431655765;
    cclass[22] = 1431655765;
    cclass[23] = 1431655765;
    cclass[24] = 1717986816;
    cclass[25] = 1717986918;
    cclass[26] = 1717986918;
    cclass[27] = 1717986918;
    cclass[28] = -2004318073;
    cclass[29] = -2003269496;
    cclass[30] = -1145324614;
    cclass[31] = 16702940;
    states = new int[26];
    states[0] = -1408167679;
    states[1] = 878082233;
    states[2] = 286331153;
    states[3] = 286331153;
    states[4] = 572662306;
    states[5] = 572662306;
    states[6] = 290805009;
    states[7] = 286331153;
    states[8] = 290803985;
    states[9] = 286331153;
    states[10] = 293041937;
    states[11] = 286331153;
    states[12] = 293015825;
    states[13] = 286331153;
    states[14] = 295278865;
    states[15] = 286331153;
    states[16] = 294719761;
    states[17] = 286331153;
    states[18] = 298634257;
    states[19] = 286331153;
    states[20] = 297865489;
    states[21] = 286331153;
    states[22] = 287099921;
    states[23] = 286331153;
    states[24] = 285212689;
    states[25] = 286331153;
    charset = "UTF-8";
    stFactor = 16;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsUTF8Verifier
 * JD-Core Version:    0.7.0.1
 */