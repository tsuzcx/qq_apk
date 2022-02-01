package com.tencent.mobileqq.avatar.dynamicavatar;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;

class SelectCoverActivity$1
  implements Runnable
{
  SelectCoverActivity$1(SelectCoverActivity paramSelectCoverActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = VideoDrawableHandler.createVideoThumbnail(this.this$0.mFilePath);
    if (this.this$0.aNl) {}
    for (;;)
    {
      return;
      if (localBitmap != null) {
        this.this$0.mUiHandler.obtainMessage(4, localBitmap).sendToTarget();
      }
      while ((this.this$0.mSource == 1) || (this.this$0.mSource == 3))
      {
        SelectCoverActivity.a(this.this$0);
        return;
        this.this$0.mUiHandler.sendEmptyMessage(6);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.1
 * JD-Core Version:    0.7.0.1
 */