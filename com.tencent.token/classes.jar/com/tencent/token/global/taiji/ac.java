package com.tencent.token.global.taiji;

import btmsdkobf.cm;
import btmsdkobf.dj;
import com.qq.taf.jce.JceStruct;
import tmsdk.common.module.pgsdk.manager.shark.ISharkPushListener;
import tmsdk.common.module.pgsdk.manager.shark.Triple;

class ac
  implements cm
{
  ac(ab paramab, ISharkPushListener paramISharkPushListener) {}
  
  public dj a(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct)
  {
    paramJceStruct = this.a.onRecvPush(paramInt1, paramLong, paramInt2, paramJceStruct);
    return new dj(paramJceStruct.first, paramJceStruct.second, paramJceStruct.third);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.ac
 * JD-Core Version:    0.7.0.1
 */