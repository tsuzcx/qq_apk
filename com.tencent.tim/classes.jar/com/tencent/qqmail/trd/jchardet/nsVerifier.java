package com.tencent.qqmail.trd.jchardet;

public abstract class nsVerifier
{
  static final int eBitSft4bits = 2;
  static final byte eError = 1;
  static final byte eItsMe = 2;
  static final int eSftMsk4bits = 7;
  static final byte eStart = 0;
  static final int eUnitMsk4bits = 15;
  static final int eidxSft4bits = 3;
  
  public static byte getNextState(nsVerifier paramnsVerifier, byte paramByte1, byte paramByte2)
  {
    return (byte)(paramnsVerifier.states()[((paramnsVerifier.stFactor() * paramByte2 + (paramnsVerifier.cclass()[((paramByte1 & 0xFF) >> 3)] >> ((paramByte1 & 0x7) << 2) & 0xF) & 0xFF) >> 3)] >> ((paramnsVerifier.stFactor() * paramByte2 + (paramnsVerifier.cclass()[((paramByte1 & 0xFF) >> 3)] >> ((paramByte1 & 0x7) << 2) & 0xF) & 0xFF & 0x7) << 2) & 0xF & 0xFF);
  }
  
  public abstract int[] cclass();
  
  public abstract String charset();
  
  public abstract boolean isUCS2();
  
  public abstract int stFactor();
  
  public abstract int[] states();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsVerifier
 * JD-Core Version:    0.7.0.1
 */