package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;

class AudioRendererEventListener$EventDispatcher$3
  implements Runnable
{
  AudioRendererEventListener$EventDispatcher$3(AudioRendererEventListener.EventDispatcher paramEventDispatcher, Format paramFormat) {}
  
  public void run()
  {
    AudioRendererEventListener.EventDispatcher.access$000(this.this$0).onAudioInputFormatChanged(this.val$format);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.3
 * JD-Core Version:    0.7.0.1
 */