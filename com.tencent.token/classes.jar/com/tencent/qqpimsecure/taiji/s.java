package com.tencent.qqpimsecure.taiji;

import Protocol.MMGRAuth.SCAuthDataRes;
import com.qq.taf.jce.JceStruct;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.shark.ISharkCallBack;

class s
  implements ISharkCallBack
{
  s(o paramo) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    cl.b("Taiji", "Cmd_CSAuthSolutionReport onFinish :" + paramInt3 + "|dataRetCode:" + paramInt4);
    if ((paramJceStruct != null) && ((paramJceStruct instanceof SCAuthDataRes)))
    {
      if (((SCAuthDataRes)paramJceStruct).ret == 0)
      {
        cl.b("Taiji", "Cmd_CSAuthSolutionReport success");
        return;
      }
      cl.b("Taiji", "Cmd_CSAuthSolutionReport success");
      return;
    }
    cl.b("Taiji", "Cmd_CSAuthSolutionReport failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.s
 * JD-Core Version:    0.7.0.1
 */