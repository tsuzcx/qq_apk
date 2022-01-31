package com.tencent.qqpimsecure.taiji;

import com.qq.taf.jce.JceStruct;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.shark.ISharkPushListener;
import tmsdk.common.module.pgsdk.manager.shark.Triple;

class p
  implements ISharkPushListener
{
  p(o paramo) {}
  
  public Triple onRecvPush(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct)
  {
    cl.b("Taiji", "onRecvPush:" + paramLong + "|" + paramInt2);
    o.a(this.a, paramJceStruct, false, 0);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.p
 * JD-Core Version:    0.7.0.1
 */