package com.tencent.av;

class VideoController$5
  implements Runnable
{
  VideoController$5(VideoController paramVideoController1, VideoController paramVideoController2, long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.c.a(this.kQ, this.Mu, this.val$reason, this.Pf);
      this.val$runnable.run();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.5
 * JD-Core Version:    0.7.0.1
 */