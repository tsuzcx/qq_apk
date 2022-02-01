package com.tencent.android.tpush;

import android.content.Context;

final class XGPushManager$7
  implements XGIOperateCallback
{
  XGPushManager$7(Context paramContext, String paramString1, int paramInt, long paramLong, String paramString2, String paramString3, XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    if (this.g != null) {
      this.g.onFail(paramObject, paramInt, paramString);
    }
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    XGPushManager.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.7
 * JD-Core Version:    0.7.0.1
 */