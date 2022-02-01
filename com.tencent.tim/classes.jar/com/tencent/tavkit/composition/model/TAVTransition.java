package com.tencent.tavkit.composition.model;

import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.composition.video.TAVVideoTransition.Filter;

public class TAVTransition
{
  private TAVAudioTransition audioTransition;
  private CMTime duration;
  private TAVVideoTransition videoTransition;
  
  public TAVTransition(CMTime paramCMTime)
  {
    this.duration = paramCMTime;
    this.audioTransition = new EmptyAudioTransition(paramCMTime);
    this.videoTransition = new EmptyVideoTransition(paramCMTime);
  }
  
  public TAVAudioTransition getAudioTransition()
  {
    return this.audioTransition;
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public TAVVideoTransition getVideoTransition()
  {
    return this.videoTransition;
  }
  
  public void setAudioTransition(TAVAudioTransition paramTAVAudioTransition)
  {
    this.audioTransition = paramTAVAudioTransition;
  }
  
  public void setVideoTransition(TAVVideoTransition paramTAVVideoTransition)
  {
    this.videoTransition = paramTAVVideoTransition;
  }
  
  static class EmptyAudioTransition
    implements TAVAudioTransition
  {
    private CMTime duration;
    private String identifier;
    
    EmptyAudioTransition(CMTime paramCMTime)
    {
      this.duration = paramCMTime;
    }
    
    public void applyNextAudioMixInputParameters(MutableAudioMixInputParameters paramMutableAudioMixInputParameters, CMTimeRange paramCMTimeRange) {}
    
    public void applyPreviousAudioMixInputParameters(MutableAudioMixInputParameters paramMutableAudioMixInputParameters, CMTimeRange paramCMTimeRange) {}
    
    public CMTime getDuration()
    {
      return this.duration;
    }
    
    public String getIdentifier()
    {
      return this.identifier;
    }
    
    public void setIdentifier(String paramString)
    {
      this.identifier = paramString;
    }
  }
  
  static class EmptyVideoTransition
    implements TAVVideoTransition
  {
    private CMTime duration;
    
    public EmptyVideoTransition(CMTime paramCMTime)
    {
      this.duration = paramCMTime;
    }
    
    public TAVVideoTransition.Filter createFilter()
    {
      return null;
    }
    
    public String effectId()
    {
      return toString();
    }
    
    public CMTime getDuration()
    {
      return this.duration;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVTransition
 * JD-Core Version:    0.7.0.1
 */