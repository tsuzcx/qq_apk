package com.tencent.android.tpush;

import android.content.Context;

final class XGPushManager$5
  implements XGIOperateCallback
{
  XGPushManager$5(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    if (this.f != null) {
      this.f.onFail(paramObject, paramInt, paramString);
    }
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    XGPushManager.a(this.a, this.b, this.c, this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.5
 * JD-Core Version:    0.7.0.1
 */