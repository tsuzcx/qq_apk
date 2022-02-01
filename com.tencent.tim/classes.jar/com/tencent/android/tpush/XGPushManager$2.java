package com.tencent.android.tpush;

import android.content.Context;

final class XGPushManager$2
  implements XGIOperateCallback
{
  XGPushManager$2(Context paramContext, String paramString1, int paramInt, String paramString2, XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    if (this.e != null) {
      this.e.onFail(paramObject, paramInt, paramString);
    }
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    XGPushManager.a(this.a, this.b, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.2
 * JD-Core Version:    0.7.0.1
 */