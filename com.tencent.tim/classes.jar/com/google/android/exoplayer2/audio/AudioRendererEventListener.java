package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;

public abstract interface AudioRendererEventListener
{
  public abstract boolean isNeedAudioData();
  
  public abstract void onAudioDecoderInitialized(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onAudioDisabled(DecoderCounters paramDecoderCounters);
  
  public abstract void onAudioEnabled(DecoderCounters paramDecoderCounters);
  
  public abstract void onAudioInputFormatChanged(Format paramFormat);
  
  public abstract void onAudioSessionId(int paramInt);
  
  public abstract void onAudioSinkUnderrun(int paramInt, long paramLong1, long paramLong2);
  
  public abstract void onRenderAudioData(byte[] paramArrayOfByte);
  
  public static final class EventDispatcher
  {
    @Nullable
    private final Handler handler;
    @Nullable
    private final AudioRendererEventListener listener;
    
    public EventDispatcher(@Nullable Handler paramHandler, @Nullable AudioRendererEventListener paramAudioRendererEventListener)
    {
      if (paramAudioRendererEventListener != null) {}
      for (paramHandler = (Handler)Assertions.checkNotNull(paramHandler);; paramHandler = null)
      {
        this.handler = paramHandler;
        this.listener = paramAudioRendererEventListener;
        return;
      }
    }
    
    public void audioSessionId(int paramInt)
    {
      if (this.listener != null) {
        this.handler.post(new AudioRendererEventListener.EventDispatcher.6(this, paramInt));
      }
    }
    
    public void audioTrackUnderrun(int paramInt, long paramLong1, long paramLong2)
    {
      if (this.listener != null) {
        this.handler.post(new AudioRendererEventListener.EventDispatcher.4(this, paramInt, paramLong1, paramLong2));
      }
    }
    
    public void decoderInitialized(String paramString, long paramLong1, long paramLong2)
    {
      if (this.listener != null) {
        this.handler.post(new AudioRendererEventListener.EventDispatcher.2(this, paramString, paramLong1, paramLong2));
      }
    }
    
    public void disabled(DecoderCounters paramDecoderCounters)
    {
      if (this.listener != null) {
        this.handler.post(new AudioRendererEventListener.EventDispatcher.5(this, paramDecoderCounters));
      }
    }
    
    public void enabled(DecoderCounters paramDecoderCounters)
    {
      if (this.listener != null) {
        this.handler.post(new AudioRendererEventListener.EventDispatcher.1(this, paramDecoderCounters));
      }
    }
    
    public void inputFormatChanged(Format paramFormat)
    {
      if (this.listener != null) {
        this.handler.post(new AudioRendererEventListener.EventDispatcher.3(this, paramFormat));
      }
    }
    
    public boolean isNeedAudioData()
    {
      if (this.listener != null) {
        return this.listener.isNeedAudioData();
      }
      return false;
    }
    
    public void onRenderAudioData(byte[] paramArrayOfByte)
    {
      if (this.listener != null) {
        this.handler.post(new AudioRendererEventListener.EventDispatcher.7(this, paramArrayOfByte));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioRendererEventListener
 * JD-Core Version:    0.7.0.1
 */