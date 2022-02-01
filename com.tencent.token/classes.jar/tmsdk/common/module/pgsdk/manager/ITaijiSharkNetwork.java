package tmsdk.common.module.pgsdk.manager;

import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import tmsdk.common.module.pgsdk.manager.shark.ISharkCallBack;
import tmsdk.common.module.pgsdk.manager.shark.ISharkPushListener;
import tmsdk.common.module.pgsdk.manager.shark.SharkHandler;

public abstract interface ITaijiSharkNetwork
{
  public abstract boolean isSupportPush();
  
  public abstract void registerSharkPush(int paramInt1, JceStruct paramJceStruct, int paramInt2, ISharkPushListener paramISharkPushListener);
  
  public abstract WeakReference<SharkHandler> sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ISharkCallBack paramISharkCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.ITaijiSharkNetwork
 * JD-Core Version:    0.7.0.1
 */