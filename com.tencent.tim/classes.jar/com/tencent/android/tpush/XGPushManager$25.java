package com.tencent.android.tpush;

import com.tencent.android.tpush.logging.TLogger;

final class XGPushManager$25
  implements XGIOperateCallback
{
  XGPushManager$25(String paramString) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    TLogger.ee("XGPushManager", "TPNS deleteAccount " + this.a + " failed, errCode =  " + paramInt + ", msg = " + paramString);
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    TLogger.ii("XGPushManager", "TPNS deleteAccount " + this.a + " success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.25
 * JD-Core Version:    0.7.0.1
 */