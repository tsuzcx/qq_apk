package com.tencent.qqmail.trd.jchardet;

public class nsGB18030Verifier
  extends nsVerifier
{
  static int[] cclass;
  static String charset;
  static int stFactor;
  static int[] states;
  
  public nsGB18030Verifier()
  {
    cclass = new int[32];
    cclass[0] = 286331153;
    cclass[1] = 1118481;
    cclass[2] = 286331153;
    cclass[3] = 286327057;
    cclass[4] = 286331153;
    cclass[5] = 286331153;
    cclass[6] = 858993459;
    cclass[7] = 286331187;
    cclass[8] = 572662306;
    cclass[9] = 572662306;
    cclass[10] = 572662306;
    cclass[11] = 572662306;
    cclass[12] = 572662306;
    cclass[13] = 572662306;
    cclass[14] = 572662306;
    cclass[15] = 1109533218;
    cclass[16] = 1717986917;
    cclass[17] = 1717986918;
    cclass[18] = 1717986918;
    cclass[19] = 1717986918;
    cclass[20] = 1717986918;
    cclass[21] = 1717986918;
    cclass[22] = 1717986918;
    cclass[23] = 1717986918;
    cclass[24] = 1717986918;
    cclass[25] = 1717986918;
    cclass[26] = 1717986918;
    cclass[27] = 1717986918;
    cclass[28] = 1717986918;
    cclass[29] = 1717986918;
    cclass[30] = 1717986918;
    cclass[31] = 107374182;
    states = new int[6];
    states[0] = 318767105;
    states[1] = 571543825;
    states[2] = 17965602;
    states[3] = 286326804;
    states[4] = 303109393;
    states[5] = 17;
    charset = "GB18030";
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
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsGB18030Verifier
 * JD-Core Version:    0.7.0.1
 */