package com.tencent.android.tpush;

import com.tencent.android.tpush.logging.TLogger;

final class XGPushManager$1
  implements XGIOperateCallback
{
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    TLogger.ee("XGPushManager", "TPNS register push failed with token : " + paramObject + ", errCode : " + paramInt + " , msg : " + paramString);
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    TLogger.ii("XGPushManager", "TPNS register push success with token : " + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.1
 * JD-Core Version:    0.7.0.1
 */