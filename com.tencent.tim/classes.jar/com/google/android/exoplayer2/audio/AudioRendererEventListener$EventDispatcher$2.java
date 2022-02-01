package com.google.android.exoplayer2.audio;

class AudioRendererEventListener$EventDispatcher$2
  implements Runnable
{
  AudioRendererEventListener$EventDispatcher$2(AudioRendererEventListener.EventDispatcher paramEventDispatcher, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    AudioRendererEventListener.EventDispatcher.access$000(this.this$0).onAudioDecoderInitialized(this.val$decoderName, this.val$initializedTimestampMs, this.val$initializationDurationMs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.2
 * JD-Core Version:    0.7.0.1
 */