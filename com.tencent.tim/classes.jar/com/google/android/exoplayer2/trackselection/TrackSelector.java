package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroupArray;

public abstract class TrackSelector
{
  private InvalidationListener listener;
  
  public final void init(InvalidationListener paramInvalidationListener)
  {
    this.listener = paramInvalidationListener;
  }
  
  protected final void invalidate()
  {
    if (this.listener != null) {
      this.listener.onTrackSelectionsInvalidated();
    }
  }
  
  public abstract void onSelectionActivated(Object paramObject);
  
  public abstract TrackSelectorResult selectTracks(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray paramTrackGroupArray)
    throws ExoPlaybackException;
  
  public static abstract interface InvalidationListener
  {
    public abstract void onTrackSelectionsInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.TrackSelector
 * JD-Core Version:    0.7.0.1
 */