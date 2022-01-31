package com.tmsdk;

import btmsdkobf.ai;
import btmsdkobf.aj;
import btmsdkobf.z;

public class ConchPushInfoUtil
{
  public static byte[] getConchParams(z paramz)
  {
    if (paramz == null) {
      return null;
    }
    return paramz.aZ;
  }
  
  public static int getConchSeqno(z paramz)
  {
    if (paramz == null) {
      return 0;
    }
    return paramz.ba;
  }
  
  public static ai getConchTime(z paramz)
  {
    if (paramz == null) {
      return new ai();
    }
    return paramz.bb;
  }
  
  public static aj getConchTips(z paramz)
  {
    if (paramz == null) {
      return new aj();
    }
    return paramz.bc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.ConchPushInfoUtil
 * JD-Core Version:    0.7.0.1
 */