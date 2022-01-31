package com.tencent.token.global.taiji;

import com.qq.taf.jce.JceStruct;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager.IProfileUploadCallback;
import tmsdk.common.module.pgsdk.manager.shark.ISharkCallBack;

class y
  implements ISharkCallBack
{
  y(x paramx, ITaijiKVProfileManager.IProfileUploadCallback paramIProfileUploadCallback) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if ((paramInt3 == 0) && (paramInt4 == 0)) {
      this.a.onUploadSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.y
 * JD-Core Version:    0.7.0.1
 */