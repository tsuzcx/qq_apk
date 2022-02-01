package com.tencent.qqmail.trd.jchardet;

public class nsISO2022KRVerifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsISO2022KRVerifier()
  {
    cclass = new int[32];
    cclass[0] = 2;
    cclass[1] = 0;
    cclass[2] = 0;
    cclass[3] = 4096;
    cclass[4] = 196608;
    cclass[5] = 64;
    cclass[6] = 0;
    cclass[7] = 0;
    cclass[8] = 20480;
    cclass[9] = 0;
    cclass[10] = 0;
    cclass[11] = 0;
    cclass[12] = 0;
    cclass[13] = 0;
    cclass[14] = 0;
    cclass[15] = 0;
    cclass[16] = 572662306;
    cclass[17] = 572662306;
    cclass[18] = 572662306;
    cclass[19] = 572662306;
    cclass[20] = 572662306;
    cclass[21] = 572662306;
    cclass[22] = 572662306;
    cclass[23] = 572662306;
    cclass[24] = 572662306;
    cclass[25] = 572662306;
    cclass[26] = 572662306;
    cclass[27] = 572662306;
    cclass[28] = 572662306;
    cclass[29] = 572662306;
    cclass[30] = 572662306;
    cclass[31] = 572662306;
    states = new int[5];
    states[0] = 285212976;
    states[1] = 572657937;
    states[2] = 289476898;
    states[3] = 286593297;
    states[4] = 8465;
    charset = "ISO-2022-KR";
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsISO2022KRVerifier
 * JD-Core Version:    0.7.0.1
 */