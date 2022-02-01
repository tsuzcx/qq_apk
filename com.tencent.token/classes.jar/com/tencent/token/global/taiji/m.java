package com.tencent.token.global.taiji;

import btmsdkobf.bx;
import btmsdkobf.cj;
import btmsdkobf.cm;
import btmsdkobf.dj;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import tmsdk.common.module.pgsdk.manager.ITaijiSharkNetwork;
import tmsdk.common.module.pgsdk.manager.shark.ISharkCallBack;
import tmsdk.common.module.pgsdk.manager.shark.ISharkPushListener;
import tmsdk.common.module.pgsdk.manager.shark.SharkHandler;
import tmsdk.common.module.pgsdk.manager.shark.Triple;

public class m
  implements ITaijiSharkNetwork
{
  public static m a()
  {
    return a.a();
  }
  
  public boolean isSupportPush()
  {
    return true;
  }
  
  public void registerSharkPush(int paramInt1, JceStruct paramJceStruct, int paramInt2, final ISharkPushListener paramISharkPushListener)
  {
    bx.ar().a(paramInt1, paramJceStruct, paramInt2, new cm()
    {
      public dj<Long, Integer, JceStruct> a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, JceStruct paramAnonymousJceStruct)
      {
        paramAnonymousJceStruct = paramISharkPushListener.onRecvPush(paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2, paramAnonymousJceStruct);
        return new dj(paramAnonymousJceStruct.first, paramAnonymousJceStruct.second, paramAnonymousJceStruct.third);
      }
    });
  }
  
  public WeakReference<SharkHandler> sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, final ISharkCallBack paramISharkCallBack)
  {
    bx.ar().a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, new cj()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        paramISharkCallBack.onFinish(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousJceStruct);
      }
    }, 0L);
    return null;
  }
  
  private static final class a
  {
    private static final m a = new m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.m
 * JD-Core Version:    0.7.0.1
 */