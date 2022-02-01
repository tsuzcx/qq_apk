package com.tencent.mobileqq.vipav;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import aqcu;
import aqwu;

class VipFunCallPreviewActivity$3
  implements Runnable
{
  VipFunCallPreviewActivity$3(VipFunCallPreviewActivity paramVipFunCallPreviewActivity, int paramInt) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = null;
    Bitmap localBitmap = aqcu.decodeFile(aqwu.a(this.this$0.app, this.this$0.eds, 9, null));
    if (localBitmap != null) {
      localBitmapDrawable = new BitmapDrawable(localBitmap);
    }
    if (localBitmapDrawable != null) {
      this.this$0.mUiHandler.sendMessage(Message.obtain(this.this$0.mUiHandler, 51, this.edv, 0, localBitmapDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */