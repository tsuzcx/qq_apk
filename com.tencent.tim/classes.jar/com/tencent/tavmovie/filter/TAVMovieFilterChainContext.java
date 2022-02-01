package com.tencent.tavmovie.filter;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVMovieFilterChainContext
  implements TAVVideoEffect
{
  protected String reportKey = "TAVMovieFilterChainContext";
  private List<TAVVideoEffect> videoEffects = new ArrayList();
  
  public void addFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    this.videoEffects.add(paramTAVVideoEffect);
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new MyCompositionEffect(this.videoEffects, null);
  }
  
  public String effectId()
  {
    return "TAVMovieFilterChainContext";
  }
  
  public List<TAVVideoEffect> getVideoEffects()
  {
    return this.videoEffects;
  }
  
  public void setReportKey(String paramString)
  {
    this.reportKey = paramString;
  }
  
  class MyCompositionEffect
    implements TAVVideoEffect.Filter, IReportable
  {
    private final List<TAVVideoEffect.Filter> effects = new ArrayList();
    
    private MyCompositionEffect()
    {
      TAVVideoEffect localTAVVideoEffect;
      this$1 = localTAVVideoEffect.iterator();
      while (TAVMovieFilterChainContext.this.hasNext())
      {
        localTAVVideoEffect = (TAVVideoEffect)TAVMovieFilterChainContext.this.next();
        this.effects.add(localTAVVideoEffect.createFilter());
      }
    }
    
    public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
    {
      Iterator localIterator = this.effects.iterator();
      while (localIterator.hasNext()) {
        paramCIImage = ((TAVVideoEffect.Filter)localIterator.next()).apply(paramTAVVideoEffect, paramCIImage, paramRenderInfo);
      }
      return paramCIImage;
    }
    
    public String getReportKey()
    {
      return TAVMovieFilterChainContext.this.reportKey;
    }
    
    public void release()
    {
      Iterator localIterator = this.effects.iterator();
      while (localIterator.hasNext()) {
        ((TAVVideoEffect.Filter)localIterator.next()).release();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVMovieFilterChainContext
 * JD-Core Version:    0.7.0.1
 */