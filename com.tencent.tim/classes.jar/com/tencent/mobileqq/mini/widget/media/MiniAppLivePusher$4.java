package com.tencent.mobileqq.mini.widget.media;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePushListenerReflect.ITXSnapshotListener;

class MiniAppLivePusher$4
  implements TXLivePushListenerReflect.ITXSnapshotListener
{
  MiniAppLivePusher$4(MiniAppLivePusher paramMiniAppLivePusher, String paramString, int paramInt) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManagerV2.excute(new MiniAppLivePusher.4.1(this, paramBitmap), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePusher.4
 * JD-Core Version:    0.7.0.1
 */