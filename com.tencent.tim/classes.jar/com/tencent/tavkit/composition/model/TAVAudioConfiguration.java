package com.tencent.tavkit.composition.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVAudioConfiguration
{
  private VolumeEdge endVolumeEdge;
  @NonNull
  private final List<TAVAudioProcessorNode> nodes;
  private VolumeEdge startVolumeEdge;
  private float volume;
  private List<VolumeEdge> volumeEdges;
  
  public TAVAudioConfiguration()
  {
    this(1.0F);
  }
  
  public TAVAudioConfiguration(float paramFloat)
  {
    this(paramFloat, null, null);
  }
  
  public TAVAudioConfiguration(float paramFloat, List<TAVAudioProcessorNode> paramList)
  {
    this(paramFloat, paramList, null);
  }
  
  public TAVAudioConfiguration(float paramFloat, List<TAVAudioProcessorNode> paramList, List<VolumeEdge> paramList1)
  {
    this.volume = paramFloat;
    this.nodes = new ArrayList();
    if (paramList != null) {
      this.nodes.addAll(paramList);
    }
    this.volumeEdges = new ArrayList();
    if (paramList1 != null) {
      this.volumeEdges.addAll(paramList1);
    }
  }
  
  public TAVAudioConfiguration(List<VolumeEdge> paramList)
  {
    this(1.0F, null, paramList);
  }
  
  public void addAudioProcessorNode(@NonNull TAVAudioProcessorNode paramTAVAudioProcessorNode)
  {
    this.nodes.add(paramTAVAudioProcessorNode);
  }
  
  public void addVolumeEdge(VolumeEdge paramVolumeEdge)
  {
    if (paramVolumeEdge == null) {
      return;
    }
    if (this.volumeEdges == null) {
      this.volumeEdges = new ArrayList();
    }
    this.volumeEdges.add(0, paramVolumeEdge);
  }
  
  public TAVAudioConfiguration clone()
  {
    return new TAVAudioConfiguration(this.volume, this.nodes);
  }
  
  public VolumeEdge getEndVolumeEdge()
  {
    return this.endVolumeEdge;
  }
  
  public List<TAVAudioProcessorNode> getNodes()
  {
    return this.nodes;
  }
  
  public VolumeEdge getStartVolumeEdge()
  {
    return this.startVolumeEdge;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public float getVolume(@NonNull CMTime paramCMTime)
  {
    if ((this.startVolumeEdge != null) && (this.startVolumeEdge.getTimeRange() != null) && (this.startVolumeEdge.getTimeRange().containsTime(paramCMTime))) {
      return this.startVolumeEdge.getVolume(paramCMTime.sub(this.startVolumeEdge.getTimeRange().getStart()));
    }
    if ((this.endVolumeEdge != null) && (this.endVolumeEdge.getTimeRange() != null) && (this.endVolumeEdge.getTimeRange().containsTime(paramCMTime))) {
      return this.endVolumeEdge.getVolume(paramCMTime.sub(this.endVolumeEdge.getTimeRange().getStart()));
    }
    if ((this.volumeEdges != null) && (!this.volumeEdges.isEmpty()))
    {
      Iterator localIterator = this.volumeEdges.iterator();
      while (localIterator.hasNext())
      {
        VolumeEdge localVolumeEdge = (VolumeEdge)localIterator.next();
        if ((localVolumeEdge != null) && (localVolumeEdge.getTimeRange() != null) && (localVolumeEdge.getTimeRange().containsTime(paramCMTime))) {
          return localVolumeEdge.getVolume(paramCMTime.sub(localVolumeEdge.getTimeRange().getStart()));
        }
      }
    }
    return this.volume;
  }
  
  public void setAudioProcessorNodes(@Nullable List<TAVAudioProcessorNode> paramList)
  {
    this.nodes.clear();
    if (paramList != null) {
      this.nodes.addAll(paramList);
    }
  }
  
  public void setEndVolumeEdge(VolumeEdge paramVolumeEdge)
  {
    this.endVolumeEdge = paramVolumeEdge;
  }
  
  public void setStartVolumeEdge(VolumeEdge paramVolumeEdge)
  {
    this.startVolumeEdge = paramVolumeEdge;
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
  
  public String toString()
  {
    return "TAVAudioConfiguration{volume=" + this.volume + ", startVolumeEdge=" + this.startVolumeEdge + ", endVolumeEdge=" + this.endVolumeEdge + ", nodes=" + this.nodes + '}';
  }
  
  public static class VolumeEdge
  {
    private float endVolume;
    private float startVolume;
    private CMTimeRange timeRange;
    
    public VolumeEdge() {}
    
    public VolumeEdge(@NonNull CMTime paramCMTime, float paramFloat1, float paramFloat2)
    {
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
      this.startVolume = paramFloat1;
      this.endVolume = paramFloat2;
    }
    
    public VolumeEdge(CMTimeRange paramCMTimeRange, float paramFloat1, float paramFloat2)
    {
      this.timeRange = paramCMTimeRange;
      this.startVolume = paramFloat1;
      this.endVolume = paramFloat2;
    }
    
    public CMTime getDuration()
    {
      if (this.timeRange != null) {
        return this.timeRange.getDuration();
      }
      return CMTime.CMTimeZero;
    }
    
    public float getEndVolume()
    {
      return this.endVolume;
    }
    
    public float getStartVolume()
    {
      return this.startVolume;
    }
    
    public CMTimeRange getTimeRange()
    {
      return this.timeRange;
    }
    
    public float getVolume(CMTime paramCMTime)
    {
      long l = paramCMTime.getTimeUs();
      float f1 = this.startVolume;
      float f2 = this.endVolume;
      float f3 = this.startVolume;
      return (float)l * 1.0F / (float)getDuration().getTimeUs() * (f2 - f3) + f1;
    }
    
    public void setDuration(@NonNull CMTime paramCMTime)
    {
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
    }
    
    public void setEndVolume(float paramFloat)
    {
      this.endVolume = paramFloat;
    }
    
    public void setStartVolume(float paramFloat)
    {
      this.startVolume = paramFloat;
    }
    
    public void setTimeRange(CMTimeRange paramCMTimeRange)
    {
      this.timeRange = paramCMTimeRange;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVAudioConfiguration
 * JD-Core Version:    0.7.0.1
 */