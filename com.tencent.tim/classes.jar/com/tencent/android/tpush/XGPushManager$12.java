package com.tencent.android.tpush;

import com.tencent.android.tpush.logging.TLogger;

final class XGPushManager$12
  implements XGIOperateCallback
{
  XGPushManager$12(String paramString) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    TLogger.ee("XGPushManager", "TPNS binderAccount " + this.a + " failed, errCode =  " + paramInt + ", msg = " + paramString);
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    TLogger.ii("XGPushManager", "TPNS binderAccount " + this.a + " success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.12
 * JD-Core Version:    0.7.0.1
 */