package com.tencent.qqmini.miniapp.audiorecorder;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;

class LameMp3EncodeThread$1
  implements MediaPlayer.OnPreparedListener
{
  LameMp3EncodeThread$1(LameMp3EncodeThread paramLameMp3EncodeThread) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    LameMp3EncodeThread.access$000(this.this$0).sendEmptyMessage(101);
    LameMp3EncodeThread.access$100(this.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread.1
 * JD-Core Version:    0.7.0.1
 */