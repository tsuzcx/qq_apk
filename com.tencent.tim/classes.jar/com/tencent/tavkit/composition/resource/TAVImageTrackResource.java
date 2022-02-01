package com.tencent.tavkit.composition.resource;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;

public class TAVImageTrackResource
  extends TAVResource
{
  private boolean emptyAudioTrack;
  private String path;
  
  public TAVImageTrackResource(String paramString, CMTime paramCMTime)
  {
    this(paramString, paramCMTime, true);
  }
  
  public TAVImageTrackResource(String paramString, CMTime paramCMTime, boolean paramBoolean)
  {
    this.path = paramString;
    this.emptyAudioTrack = paramBoolean;
    this.duration = paramCMTime;
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
  }
  
  public TAVImageTrackResource clone()
  {
    TAVImageTrackResource localTAVImageTrackResource = new TAVImageTrackResource(this.path, this.duration.clone());
    localTAVImageTrackResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVImageTrackResource.scaledDuration = this.scaledDuration.clone();
    return localTAVImageTrackResource;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    return null;
  }
  
  @Nullable
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 1) && (!this.emptyAudioTrack)) {
      return null;
    }
    if (paramInt1 == 1) {
      paramInt1 = 3;
    }
    for (;;)
    {
      CompositionTrackSegment localCompositionTrackSegment = new CompositionTrackSegment(this.path, 0, this.sourceTimeRange, this.sourceTimeRange, paramInt1);
      TrackInfo localTrackInfo = new TrackInfo();
      localTrackInfo.setCompositionTrackSegment(localCompositionTrackSegment);
      localTrackInfo.setSelectedTimeRange(getSourceTimeRange());
      localTrackInfo.setScaleToDuration(getScaledDuration());
      return localTrackInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVImageTrackResource
 * JD-Core Version:    0.7.0.1
 */