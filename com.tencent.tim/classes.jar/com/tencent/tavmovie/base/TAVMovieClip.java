package com.tencent.tavmovie.base;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;

public class TAVMovieClip
  implements Cloneable
{
  private TAVMovieAudioConfiguration audioConfiguration = new TAVMovieAudioConfiguration();
  private TAVMovieResource resource;
  private CMTime startTime = CMTime.CMTimeZero;
  private TAVMovieVideoConfiguration videoConfiguration = new TAVMovieVideoConfiguration();
  
  public TAVMovieClip clone()
  {
    TAVMovieClip localTAVMovieClip = new TAVMovieClip();
    localTAVMovieClip.setResource(this.resource.clone());
    localTAVMovieClip.setVideoConfiguration(this.videoConfiguration.clone());
    localTAVMovieClip.setAudioConfiguration(this.audioConfiguration.clone());
    localTAVMovieClip.setStartTime(this.startTime.clone());
    return localTAVMovieClip;
  }
  
  public TAVClip convertToClip()
  {
    TAVClip localTAVClip = new TAVClip(this.resource.convertToResource());
    if (this.videoConfiguration != null) {
      localTAVClip.setVideoConfiguration(this.videoConfiguration.convertToConfiguration());
    }
    if (this.audioConfiguration != null) {
      localTAVClip.setAudioConfiguration(this.audioConfiguration.convertToConfiguration());
    }
    localTAVClip.setStartTime(this.startTime);
    return localTAVClip;
  }
  
  public TAVMovieClip dataClone()
  {
    TAVMovieClip localTAVMovieClip = new TAVMovieClip();
    localTAVMovieClip.setResource(this.resource.dataClone());
    localTAVMovieClip.setVideoConfiguration(this.videoConfiguration.clone());
    localTAVMovieClip.setAudioConfiguration(this.audioConfiguration.clone());
    localTAVMovieClip.setStartTime(this.startTime.clone());
    return localTAVMovieClip;
  }
  
  public TAVMovieAudioConfiguration getAudioConfiguration()
  {
    return this.audioConfiguration;
  }
  
  public int getPreferRotation()
  {
    return this.videoConfiguration.getPreferRotation();
  }
  
  public TAVMovieResource getResource()
  {
    return this.resource;
  }
  
  public TAVMovieVideoConfiguration getVideoConfiguration()
  {
    return this.videoConfiguration;
  }
  
  public void release()
  {
    if ((this.resource != null) && ((this.resource instanceof TAVMovieImageResource))) {
      ((TAVMovieImageResource)this.resource).release();
    }
  }
  
  public void setAudioConfiguration(TAVMovieAudioConfiguration paramTAVMovieAudioConfiguration)
  {
    this.audioConfiguration = paramTAVMovieAudioConfiguration;
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.videoConfiguration.setPreferRotation(paramInt);
  }
  
  public void setResource(TAVMovieResource paramTAVMovieResource)
  {
    this.resource = paramTAVMovieResource;
  }
  
  public void setStartTime(CMTime paramCMTime)
  {
    this.startTime = paramCMTime;
  }
  
  public void setVideoConfiguration(TAVMovieVideoConfiguration paramTAVMovieVideoConfiguration)
  {
    this.videoConfiguration = paramTAVMovieVideoConfiguration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.base.TAVMovieClip
 * JD-Core Version:    0.7.0.1
 */