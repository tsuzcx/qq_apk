package com.google.android.exoplayer2.source.ads;

import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.IOException;

public abstract interface AdsLoader
{
  public abstract void attachPlayer(ExoPlayer paramExoPlayer, EventListener paramEventListener, ViewGroup paramViewGroup);
  
  public abstract void detachPlayer();
  
  public abstract void handlePrepareError(int paramInt1, int paramInt2, IOException paramIOException);
  
  public abstract void release();
  
  public abstract void setSupportedContentTypes(int... paramVarArgs);
  
  public static abstract interface EventListener
  {
    public abstract void onAdClicked();
    
    public abstract void onAdLoadError(IOException paramIOException);
    
    public abstract void onAdPlaybackState(AdPlaybackState paramAdPlaybackState);
    
    public abstract void onAdTapped();
    
    public abstract void onInternalAdLoadError(RuntimeException paramRuntimeException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsLoader
 * JD-Core Version:    0.7.0.1
 */