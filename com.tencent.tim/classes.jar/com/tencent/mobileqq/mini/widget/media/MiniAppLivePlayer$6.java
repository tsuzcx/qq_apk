package com.tencent.mobileqq.mini.widget.media;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.ISnapshotOuterListener;

class MiniAppLivePlayer$6
  implements TXLivePlayerJSAdapter.ISnapshotOuterListener
{
  MiniAppLivePlayer$6(MiniAppLivePlayer paramMiniAppLivePlayer, String paramString, int paramInt) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManagerV2.excute(new MiniAppLivePlayer.6.1(this, paramBitmap), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePlayer.6
 * JD-Core Version:    0.7.0.1
 */