package com.tencent.qqmail.trd.jchardet;

public class nsEUCJPVerifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsEUCJPVerifier()
  {
    cclass = new int[32];
    cclass[0] = 1145324612;
    cclass[1] = 1430537284;
    cclass[2] = 1145324612;
    cclass[3] = 1145328708;
    cclass[4] = 1145324612;
    cclass[5] = 1145324612;
    cclass[6] = 1145324612;
    cclass[7] = 1145324612;
    cclass[8] = 1145324612;
    cclass[9] = 1145324612;
    cclass[10] = 1145324612;
    cclass[11] = 1145324612;
    cclass[12] = 1145324612;
    cclass[13] = 1145324612;
    cclass[14] = 1145324612;
    cclass[15] = 1145324612;
    cclass[16] = 1431655765;
    cclass[17] = 827675989;
    cclass[18] = 1431655765;
    cclass[19] = 1431655765;
    cclass[20] = 572662309;
    cclass[21] = 572662306;
    cclass[22] = 572662306;
    cclass[23] = 572662306;
    cclass[24] = 572662306;
    cclass[25] = 572662306;
    cclass[26] = 572662306;
    cclass[27] = 572662306;
    cclass[28] = 0;
    cclass[29] = 0;
    cclass[30] = 0;
    cclass[31] = 1342177280;
    states = new int[5];
    states[0] = 286282563;
    states[1] = 572657937;
    states[2] = 286265378;
    states[3] = 319885329;
    states[4] = 4371;
    charset = "EUC-JP";
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsEUCJPVerifier
 * JD-Core Version:    0.7.0.1
 */