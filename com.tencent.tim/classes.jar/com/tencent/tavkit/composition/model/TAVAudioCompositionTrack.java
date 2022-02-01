package com.tencent.tavkit.composition.model;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;

public abstract interface TAVAudioCompositionTrack
{
  public abstract CompositionTrack audioCompositionTrackForComposition(MutableComposition paramMutableComposition, int paramInt, boolean paramBoolean);
  
  public abstract int numberOfAudioTracks();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVAudioCompositionTrack
 * JD-Core Version:    0.7.0.1
 */