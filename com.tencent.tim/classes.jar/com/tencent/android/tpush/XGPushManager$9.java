package com.tencent.android.tpush;

import android.content.Context;

final class XGPushManager$9
  implements XGIOperateCallback
{
  XGPushManager$9(Context paramContext, String paramString1, long paramLong, String paramString2, int paramInt, String paramString3, XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    if (this.g != null) {
      this.g.onFail(paramObject, paramInt, paramString);
    }
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    XGPushManager.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.9
 * JD-Core Version:    0.7.0.1
 */