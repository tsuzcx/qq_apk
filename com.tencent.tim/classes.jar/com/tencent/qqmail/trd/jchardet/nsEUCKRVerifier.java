package com.tencent.qqmail.trd.jchardet;

public class nsEUCKRVerifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsEUCKRVerifier()
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
    cclass[16] = 0;
    cclass[17] = 0;
    cclass[18] = 0;
    cclass[19] = 0;
    cclass[20] = 572662304;
    cclass[21] = 858923554;
    cclass[22] = 572662306;
    cclass[23] = 572662306;
    cclass[24] = 572662306;
    cclass[25] = 572662322;
    cclass[26] = 572662306;
    cclass[27] = 572662306;
    cclass[28] = 572662306;
    cclass[29] = 572662306;
    cclass[30] = 572662306;
    cclass[31] = 35791394;
    states = new int[2];
    states[0] = 286331649;
    states[1] = 1122850;
    charset = "EUC-KR";
    stFactor = 4;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsEUCKRVerifier
 * JD-Core Version:    0.7.0.1
 */