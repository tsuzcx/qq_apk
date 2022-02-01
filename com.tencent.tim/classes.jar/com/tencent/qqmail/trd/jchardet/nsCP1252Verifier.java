package com.tencent.qqmail.trd.jchardet;

public class nsCP1252Verifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsCP1252Verifier()
  {
    cclass = new int[32];
    cclass[0] = 572662305;
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
    cclass[16] = 572662274;
    cclass[17] = 16851234;
    cclass[18] = 572662304;
    cclass[19] = 285286690;
    cclass[20] = 572662306;
    cclass[21] = 572662306;
    cclass[22] = 572662306;
    cclass[23] = 572662306;
    cclass[24] = 286331153;
    cclass[25] = 286331153;
    cclass[26] = 554766609;
    cclass[27] = 286331153;
    cclass[28] = 286331153;
    cclass[29] = 286331153;
    cclass[30] = 554766609;
    cclass[31] = 286331153;
    states = new int[3];
    states[0] = 571543601;
    states[1] = 340853778;
    states[2] = 65;
    charset = "windows-1252";
    stFactor = 3;
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsCP1252Verifier
 * JD-Core Version:    0.7.0.1
 */