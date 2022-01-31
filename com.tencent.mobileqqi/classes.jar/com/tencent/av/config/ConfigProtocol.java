package com.tencent.av.config;

import bhg;

public class ConfigProtocol
{
  public static final byte a = 1;
  public static final short a = 1;
  public static final short b = 2;
  public static final short c = 3;
  public static final short d = 4;
  public static final short e = 5;
  public static final short f = 6;
  public static final short g = 7;
  public static final short h = 8;
  public static final short i = 9;
  public static final short j = 1;
  public static final short k = 2;
  public static final short l = 3;
  public static final short m = 4;
  public static final short n = 5;
  public static final short o = 6;
  public static final short p = 7;
  public static final short q = 8;
  public static final short r = 9;
  public static final short s = 10;
  public static final short t = 11;
  public static final short u = 33;
  public static final short v = 6;
  
  public ConfigProtocol.TLVBase a(short paramShort1, short paramShort2)
  {
    if (paramShort2 <= 0) {
      return null;
    }
    switch (paramShort1)
    {
    default: 
      return null;
    case 1: 
      return new ConfigProtocol.WriteLocalLogTLV(this);
    case 2: 
      return new ConfigProtocol.LocalLogUploadTLV(this, paramShort2);
    case 3: 
      return new ConfigProtocol.RelaySvrUDPCheckTLV(this, paramShort2);
    case 4: 
      return new ConfigProtocol.StunServerAddrTLV(this, paramShort2);
    case 5: 
      return new ConfigProtocol.ConnForbidTypeTLV(this);
    case 6: 
      return new ConfigProtocol.VideoEngineNeedInfoTLV(this, paramShort2);
    case 7: 
      return new ConfigProtocol.AudioEngineNeedInfoTLV(this, paramShort2);
    case 8: 
      return new bhg(this, paramShort2);
    case 9: 
      return new ConfigProtocol.ConnPriorityInfoTLV(this, paramShort2);
    case 10: 
      return new ConfigProtocol.SharpInfoTLV(this, paramShort2);
    }
    return new ConfigProtocol.AVSwitchTypeTLV(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigProtocol
 * JD-Core Version:    0.7.0.1
 */