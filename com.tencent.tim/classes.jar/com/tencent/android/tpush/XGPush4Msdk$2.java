package com.tencent.android.tpush;

import com.tencent.android.tpush.logging.TLogger;

final class XGPush4Msdk$2
  implements XGIOperateCallback
{
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    TLogger.e("XGPush4Msdk", "xg register push onFail. token:" + paramObject + ", errCode:" + paramInt + ",msg:" + paramString);
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    TLogger.i("XGPush4Msdk", "xg register push onSuccess. token:" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPush4Msdk.2
 * JD-Core Version:    0.7.0.1
 */