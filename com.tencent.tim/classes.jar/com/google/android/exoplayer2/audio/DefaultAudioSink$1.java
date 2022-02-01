package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.ConditionVariable;

class DefaultAudioSink$1
  extends Thread
{
  DefaultAudioSink$1(DefaultAudioSink paramDefaultAudioSink, AudioTrack paramAudioTrack) {}
  
  public void run()
  {
    try
    {
      this.val$toRelease.flush();
      this.val$toRelease.release();
      return;
    }
    finally
    {
      DefaultAudioSink.access$300(this.this$0).open();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.DefaultAudioSink.1
 * JD-Core Version:    0.7.0.1
 */