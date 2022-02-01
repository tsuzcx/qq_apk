package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import ram;

class TrimTextureVideoView$1
  implements Runnable
{
  TrimTextureVideoView$1(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  @TargetApi(14)
  public void run()
  {
    if (!this.this$0.mAttached)
    {
      ram.b(this.this$0.TAG, "[%d]not attach! not schedule!", Integer.valueOf(this.this$0.mSeq));
      return;
    }
    int i = this.this$0.getCurrentPosition();
    ram.a(this.this$0.TAG, "[%d]mRestartRunnable check enter! isPlaying = %b, mEndTime = %d, pos = %d", Integer.valueOf(this.this$0.mSeq), Boolean.valueOf(this.this$0.isPlaying()), Integer.valueOf(this.this$0.mEndTime), Integer.valueOf(i));
    TrimTextureVideoView localTrimTextureVideoView;
    if (this.this$0.mEndTime != 0)
    {
      if (!this.this$0.isPlaying()) {
        break label216;
      }
      if (i == this.this$0.mLastCurrentPosition)
      {
        localTrimTextureVideoView = this.this$0;
        localTrimTextureVideoView.bnd += 1;
        this.this$0.mLastCurrentPosition = i;
      }
    }
    else
    {
      if ((!this.this$0.isPlaying()) || (this.this$0.mEndTime <= 0) || (i < this.this$0.mEndTime)) {
        break label264;
      }
      this.this$0.sJ(true);
    }
    for (;;)
    {
      ram.d(this.this$0.TAG, "schedule next!");
      this.this$0.postDelayed(this, 200L);
      return;
      this.this$0.bnd = 0;
      break;
      label216:
      if (i == this.this$0.bnb) {}
      for (this.this$0.bnc = 0;; localTrimTextureVideoView.bnc += 1)
      {
        this.this$0.bnb = i;
        break;
        localTrimTextureVideoView = this.this$0;
      }
      label264:
      if (this.this$0.mCurrentState == 5) {
        this.this$0.sJ(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.1
 * JD-Core Version:    0.7.0.1
 */