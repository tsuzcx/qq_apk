package com.tencent.token.global.taiji;

import btmsdkobf.bx;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import tmsdk.common.module.pgsdk.manager.ITaijiSharkNetwork;
import tmsdk.common.module.pgsdk.manager.shark.ISharkCallBack;
import tmsdk.common.module.pgsdk.manager.shark.ISharkPushListener;

public class ab
  implements ITaijiSharkNetwork
{
  public static ab a()
  {
    return ae.a();
  }
  
  public boolean isSupportPush()
  {
    return true;
  }
  
  public void registerSharkPush(int paramInt1, JceStruct paramJceStruct, int paramInt2, ISharkPushListener paramISharkPushListener)
  {
    bx.ar().a(paramInt1, paramJceStruct, paramInt2, new ac(this, paramISharkPushListener));
  }
  
  public WeakReference sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ISharkCallBack paramISharkCallBack)
  {
    bx.ar().a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, new ad(this, paramISharkCallBack), 0L);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.ab
 * JD-Core Version:    0.7.0.1
 */