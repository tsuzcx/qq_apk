package com.tencent.moai.nativepages.view;

class VideoPlayer$1$1
  implements Runnable
{
  VideoPlayer$1$1(VideoPlayer.1 param1, long paramLong) {}
  
  public void run()
  {
    long l = 0L;
    VideoPlayer.VideoStateCallback localVideoStateCallback = VideoPlayer.access$200(this.this$1.this$0);
    if (this.val$position > 0L) {
      l = this.val$position;
    }
    localVideoStateCallback.setPosition(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.VideoPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */