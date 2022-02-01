package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import ram;

class TrimTextureVideoView$2
  implements Runnable
{
  TrimTextureVideoView$2(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  @TargetApi(14)
  public void run()
  {
    if (!this.this$0.mAttached)
    {
      ram.b(this.this$0.TAG, "[%d]not attach! not schedule!", Integer.valueOf(this.this$0.mSeq));
      return;
    }
    int i = this.this$0.getCurrentPosition();
    ram.d(this.this$0.TAG, "[%d]mCheckNeedRestart check enter! isPlaying = %b, mEndTime = %d, pos = %d, mPositionNotChangeCount = %d, mPausedPositionChangeCount = %d", new Object[] { Integer.valueOf(this.this$0.mSeq), Boolean.valueOf(this.this$0.isPlaying()), Integer.valueOf(this.this$0.mEndTime), Integer.valueOf(i), Integer.valueOf(this.this$0.bnd), Integer.valueOf(this.this$0.bnc) });
    if ((this.this$0.isPlaying()) && (i == this.this$0.mLastCurrentPosition) && (this.this$0.bnd > 0))
    {
      if (this.this$0.bnd > 1)
      {
        ram.e(this.this$0.TAG, "[%d]Position not change for %d times, restart! 命中异常播放容错逻辑", new Object[] { Integer.valueOf(this.this$0.mSeq), Integer.valueOf(this.this$0.bnd) });
        this.this$0.sJ(true);
        return;
      }
      this.this$0.postDelayed(this, 250L);
      return;
    }
    if ((!this.this$0.isPlaying()) && (i != this.this$0.bnb))
    {
      if (this.this$0.bnc > 1)
      {
        ram.e(this.this$0.TAG, "[%d]Position change for %d times, but is pause, restart! 命中异常播放容错逻辑", new Object[] { Integer.valueOf(this.this$0.mSeq), Integer.valueOf(this.this$0.bnc) });
        this.this$0.sJ(true);
        return;
      }
      this.this$0.postDelayed(this, 250L);
      return;
    }
    ram.d(this.this$0.TAG, "[%d] CheckNeedRestart good for now", Integer.valueOf(this.this$0.mSeq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.2
 * JD-Core Version:    0.7.0.1
 */