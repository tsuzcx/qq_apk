package com.tencent.android.tpush;

import com.tencent.android.tpush.logging.TLogger;

final class XGPushManager$23
  implements XGIOperateCallback
{
  XGPushManager$23(String paramString) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    TLogger.ee("XGPushManager", "TPNS appendAccount " + this.a + " failed, errCode =  " + paramInt + ", msg = " + paramString);
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    TLogger.ii("XGPushManager", "TPNS appendAccount " + this.a + " success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.23
 * JD-Core Version:    0.7.0.1
 */