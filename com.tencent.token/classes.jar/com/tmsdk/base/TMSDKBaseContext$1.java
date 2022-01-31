package com.tmsdk.base;

import btmsdkobf.cj;
import btmsdkobf.eg;
import com.qq.taf.jce.JceStruct;

final class TMSDKBaseContext$1
  implements cj
{
  TMSDKBaseContext$1(ISharkCallBackOut paramISharkCallBackOut) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    eg.g("TMSDKBaseContext", "onFinish, cmdId:[" + paramInt2 + "]retCode:[" + paramInt3 + "]dataRetCode:[" + paramInt4 + "]");
    int i = paramInt3;
    if (paramInt3 == 0)
    {
      i = paramInt3;
      if (paramInt4 == 0) {
        i = 0;
      }
    }
    if (i % 20 == -4) {
      paramInt3 = -102;
    }
    for (;;)
    {
      if (this.s != null) {
        this.s.onFinish(paramInt1, paramInt2, paramInt3, paramInt4, paramJceStruct);
      }
      return;
      if (i != 0) {
        paramInt3 = -999;
      } else if (paramInt4 != 0) {
        paramInt3 = -101;
      } else {
        paramInt3 = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.TMSDKBaseContext.1
 * JD-Core Version:    0.7.0.1
 */