package com.google.android.exoplayer2.video;

class VideoRendererEventListener$EventDispatcher$4
  implements Runnable
{
  VideoRendererEventListener$EventDispatcher$4(VideoRendererEventListener.EventDispatcher paramEventDispatcher, int paramInt, long paramLong) {}
  
  public void run()
  {
    VideoRendererEventListener.EventDispatcher.access$000(this.this$0).onDroppedFrames(this.val$droppedFrameCount, this.val$elapsedMs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.4
 * JD-Core Version:    0.7.0.1
 */