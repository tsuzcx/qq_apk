package com.tencent.tavmovie.base;

import com.tencent.tav.coremedia.CMTimeRange;

public class TAVSegmentImageEffect
  extends TAVSegmentEffect
  implements Cloneable
{
  protected String effectID;
  protected String name;
  
  public TAVSegmentImageEffect clone()
  {
    TAVSegmentImageEffect localTAVSegmentImageEffect = new TAVSegmentImageEffect();
    localTAVSegmentImageEffect.timeRange = this.timeRange.clone();
    localTAVSegmentImageEffect.effectID = this.effectID;
    localTAVSegmentImageEffect.name = this.name;
    return localTAVSegmentImageEffect;
  }
  
  public String getEffectID()
  {
    return this.effectID;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setEffectID(String paramString)
  {
    this.effectID = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.base.TAVSegmentImageEffect
 * JD-Core Version:    0.7.0.1
 */