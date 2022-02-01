package com.tencent.android.tpush;

import com.tencent.android.tpush.logging.TLogger;

class XGPushManager$16$1
  implements XGIOperateCallback
{
  XGPushManager$16$1(XGPushManager.16 param16) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    TLogger.d("XGPushManager", "registerRunnable4NewDevice failed, token:" + paramObject + ",errCode:" + paramInt + ",msg:" + paramString + ",delayMillis:" + this.a.a);
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    TLogger.d("XGPushManager", "registerRunnable4NewDevice success, token:" + paramObject + ",delayMillis:" + this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.16.1
 * JD-Core Version:    0.7.0.1
 */