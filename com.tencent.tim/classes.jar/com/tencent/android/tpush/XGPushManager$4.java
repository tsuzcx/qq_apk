package com.tencent.android.tpush;

import android.content.Context;

final class XGPushManager$4
  implements XGIOperateCallback
{
  XGPushManager$4(Context paramContext, String paramString, int paramInt1, int paramInt2, XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    if (this.e != null) {
      this.e.onFail(paramObject, paramInt, paramString);
    }
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    XGPushManager.a(this.a, this.b, this.c, this.d, null, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.4
 * JD-Core Version:    0.7.0.1
 */