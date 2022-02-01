package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.decoder.DecoderCounters;

class AudioRendererEventListener$EventDispatcher$5
  implements Runnable
{
  AudioRendererEventListener$EventDispatcher$5(AudioRendererEventListener.EventDispatcher paramEventDispatcher, DecoderCounters paramDecoderCounters) {}
  
  public void run()
  {
    this.val$counters.ensureUpdated();
    AudioRendererEventListener.EventDispatcher.access$000(this.this$0).onAudioDisabled(this.val$counters);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.5
 * JD-Core Version:    0.7.0.1
 */