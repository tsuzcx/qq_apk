package com.tencent.android.tpush;

import com.tencent.android.tpush.logging.TLogger;

final class XGPushManager$27
  implements XGIOperateCallback
{
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    TLogger.ee("XGPushManager", "UnRegisterPush push failed with token = " + paramObject + " , errCode = " + paramInt + " , msg = " + paramString);
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    TLogger.ii("XGPushManager", "UnRegisterPush push succeed with token = " + paramObject + " flag = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.27
 * JD-Core Version:    0.7.0.1
 */