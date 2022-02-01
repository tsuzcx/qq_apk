package com.tencent.tavkit.composition.audio;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;

public class TAVAudioConfigurationSegment
{
  @NonNull
  public final TAVAudioConfiguration audioConfiguration;
  @NonNull
  public final CMTimeRange compositionTimeRange;
  
  public TAVAudioConfigurationSegment(@NonNull CMTimeRange paramCMTimeRange, @NonNull TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    this.audioConfiguration = paramTAVAudioConfiguration;
    this.compositionTimeRange = paramCMTimeRange;
  }
  
  public String toString()
  {
    return "TAVAudioConfigurationSegment{compositionTimeRange=" + this.compositionTimeRange.toSimpleString() + ", audioConfiguration=" + this.audioConfiguration + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioConfigurationSegment
 * JD-Core Version:    0.7.0.1
 */