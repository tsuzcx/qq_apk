package com.google.android.exoplayer2.ext.mediaplayer;

class ExoMediaPlayer$1
  implements Runnable
{
  ExoMediaPlayer$1(ExoMediaPlayer paramExoMediaPlayer) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      ExoMediaPlayer.access$600(this.this$0);
      this.this$0.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */