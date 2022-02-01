package com.tencent.tmediacodec.codec;

import android.view.Surface;
import com.tencent.tmediacodec.util.LogUtils;

class ReuseCodecWrapper$2
  implements Runnable
{
  ReuseCodecWrapper$2(ReuseCodecWrapper paramReuseCodecWrapper, Surface paramSurface) {}
  
  public void run()
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d(this.this$0.TAG, "releaseOldSurface " + this.val$surface);
    }
    this.val$surface.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.2
 * JD-Core Version:    0.7.0.1
 */