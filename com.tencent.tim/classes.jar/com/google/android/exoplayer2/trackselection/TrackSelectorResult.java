package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;

public final class TrackSelectorResult
{
  public final TrackGroupArray groups;
  public final Object info;
  public final RendererConfiguration[] rendererConfigurations;
  public final boolean[] renderersEnabled;
  public final TrackSelectionArray selections;
  
  public TrackSelectorResult(TrackGroupArray paramTrackGroupArray, boolean[] paramArrayOfBoolean, TrackSelectionArray paramTrackSelectionArray, Object paramObject, RendererConfiguration[] paramArrayOfRendererConfiguration)
  {
    this.groups = paramTrackGroupArray;
    this.renderersEnabled = paramArrayOfBoolean;
    this.selections = paramTrackSelectionArray;
    this.info = paramObject;
    this.rendererConfigurations = paramArrayOfRendererConfiguration;
  }
  
  public boolean isEquivalent(TrackSelectorResult paramTrackSelectorResult)
  {
    if ((paramTrackSelectorResult == null) || (paramTrackSelectorResult.selections.length != this.selections.length)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.selections.length) {
        break label52;
      }
      if (!isEquivalent(paramTrackSelectorResult, i)) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public boolean isEquivalent(TrackSelectorResult paramTrackSelectorResult, int paramInt)
  {
    if (paramTrackSelectorResult == null) {}
    while ((this.renderersEnabled[paramInt] != paramTrackSelectorResult.renderersEnabled[paramInt]) || (!Util.areEqual(this.selections.get(paramInt), paramTrackSelectorResult.selections.get(paramInt))) || (!Util.areEqual(this.rendererConfigurations[paramInt], paramTrackSelectorResult.rendererConfigurations[paramInt]))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.TrackSelectorResult
 * JD-Core Version:    0.7.0.1
 */