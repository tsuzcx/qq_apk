package com.tencent.tavkit.component;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.TAVTimeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TAVTimeEffectBuilder
{
  private TAVClip clip;
  private TAVTimeEffect[] timeEffects;
  
  public TAVTimeEffectBuilder() {}
  
  public TAVTimeEffectBuilder(TAVClip paramTAVClip, List<TAVTimeEffect> paramList)
  {
    this.clip = paramTAVClip;
    this.timeEffects = ((TAVTimeEffect[])paramList.toArray());
  }
  
  public TAVTimeEffectBuilder(TAVClip paramTAVClip, TAVTimeEffect... paramVarArgs)
  {
    this.clip = paramTAVClip;
    this.timeEffects = paramVarArgs;
  }
  
  private void addSegmentToChannel(TAVClip paramTAVClip, TAVClipSegment paramTAVClipSegment, List<TAVClip> paramList)
  {
    paramTAVClip = paramTAVClip.clone();
    paramTAVClip.getResource().setSourceTimeRange(paramTAVClipSegment.timeRange);
    paramTAVClip.getResource().setScaledDuration(paramTAVClipSegment.timeRange.getDuration());
    paramList.add(paramTAVClip);
  }
  
  private void addSegmentToChannelWithTimeEffect(TAVClip paramTAVClip, TAVClipSegment paramTAVClipSegment, List<TAVClip> paramList)
  {
    int i = 0;
    if (i < paramTAVClipSegment.timeEffect.getLoopCount())
    {
      Object localObject1;
      Object localObject2;
      if ((paramTAVClip.getResource() instanceof TAVAssetTrackResource))
      {
        localObject1 = ((TAVAssetTrackResource)paramTAVClip.getResource()).getAsset();
        if (paramTAVClipSegment.timeEffect.isFreeze())
        {
          localObject1 = new TAVAssetTrackResource((Asset)localObject1);
          localObject2 = new CMTime(1L, 30);
          if (paramTAVClipSegment.timeEffect.isReverse())
          {
            ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(paramTAVClipSegment.timeRange.getEnd().sub((CMTime)localObject2), (CMTime)localObject2));
            label106:
            if (paramTAVClipSegment.timeEffect.getLoopCount() != 0) {
              break label310;
            }
            ((TAVResource)localObject1).setScaledDuration(paramTAVClipSegment.timeRange.getDuration());
            label128:
            if (paramTAVClipSegment.timeEffect.getScaledDuration().value > 0L)
            {
              if (paramTAVClipSegment.timeEffect.getLoopCount() != 0) {
                break label336;
              }
              ((TAVResource)localObject1).setScaledDuration(paramTAVClipSegment.timeEffect.getScaledDuration());
            }
          }
        }
      }
      for (;;)
      {
        localObject2 = paramTAVClip.clone();
        ((TAVClip)localObject2).setResource((TAVResource)localObject1);
        paramList.add(localObject2);
        i += 1;
        break;
        ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(paramTAVClipSegment.timeRange.getStart(), (CMTime)localObject2));
        break label106;
        if (paramTAVClipSegment.timeEffect.isReverse()) {}
        for (localObject1 = new TAVAssetTrackResource((Asset)localObject1);; localObject1 = new TAVAssetTrackResource((Asset)localObject1))
        {
          ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(paramTAVClipSegment.timeRange.getStart(), paramTAVClipSegment.timeEffect.getTimeRange().getDuration().divide(paramTAVClipSegment.timeEffect.getLoopCount())));
          break;
        }
        localObject1 = paramTAVClip.getResource().clone();
        break label106;
        label310:
        ((TAVResource)localObject1).setScaledDuration(paramTAVClipSegment.timeRange.getDuration().divide(paramTAVClipSegment.timeEffect.getLoopCount()));
        break label128;
        label336:
        ((TAVResource)localObject1).setScaledDuration(paramTAVClipSegment.timeEffect.getScaledDuration().divide(paramTAVClipSegment.timeEffect.getLoopCount()));
      }
    }
  }
  
  @Nullable
  private List<TAVTimeEffect> availableTimeEffectsFromClip(TAVClip paramTAVClip)
  {
    if (this.timeEffects == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramTAVClip = paramTAVClip.getResource();
    TAVTimeEffect[] arrayOfTAVTimeEffect = this.timeEffects;
    int k = arrayOfTAVTimeEffect.length;
    int i = 0;
    TAVTimeEffect localTAVTimeEffect;
    if (i < k)
    {
      localTAVTimeEffect = arrayOfTAVTimeEffect[i];
      CMTimeRange localCMTimeRange1 = TAVTimeUtil.getIntersection(paramTAVClip.getSourceTimeRange(), localTAVTimeEffect.getTimeRange());
      if ((localCMTimeRange1 != null) && (localCMTimeRange1.getDuration().value > 0L))
      {
        Iterator localIterator = localArrayList.iterator();
        CMTimeRange localCMTimeRange2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localCMTimeRange2 = TAVTimeUtil.getIntersection(((TAVTimeEffect)localIterator.next()).getTimeRange(), localCMTimeRange1);
        } while ((localCMTimeRange2 == null) || (localCMTimeRange2.getDuration().value <= 0L));
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(localTAVTimeEffect);
      }
      i += 1;
      break;
      Collections.sort(localArrayList, new TAVTimeEffectBuilder.1(this));
      return localArrayList;
    }
  }
  
  private void initChannelWithClip(TAVClip paramTAVClip, List<TAVClip> paramList)
  {
    Iterator localIterator = segmentsWithClip(paramTAVClip).iterator();
    while (localIterator.hasNext())
    {
      TAVClipSegment localTAVClipSegment = (TAVClipSegment)localIterator.next();
      if (localTAVClipSegment.timeEffect == null) {
        addSegmentToChannel(paramTAVClip, localTAVClipSegment, paramList);
      } else {
        addSegmentToChannelWithTimeEffect(paramTAVClip, localTAVClipSegment, paramList);
      }
    }
  }
  
  private List<TAVClipSegment> segmentsWithClip(TAVClip paramTAVClip)
  {
    Object localObject1 = paramTAVClip.getResource();
    Object localObject2 = ((TAVResource)localObject1).getSourceTimeRange().getStart();
    ArrayList localArrayList = new ArrayList();
    paramTAVClip = traverseTimeEffect(paramTAVClip, (TAVResource)localObject1, localArrayList, (CMTime)localObject2);
    localObject1 = ((TAVResource)localObject1).getSourceTimeRange().getEnd().sub(paramTAVClip);
    if (((CMTime)localObject1).value > 0L)
    {
      localObject2 = new TAVClipSegment(null);
      TAVClipSegment.access$102((TAVClipSegment)localObject2, new CMTimeRange(paramTAVClip, (CMTime)localObject1));
      localArrayList.add(localObject2);
    }
    return localArrayList;
  }
  
  private CMTime traverseTimeEffect(TAVClip paramTAVClip, TAVResource paramTAVResource, List<TAVClipSegment> paramList, CMTime paramCMTime)
  {
    paramTAVClip = availableTimeEffectsFromClip(paramTAVClip);
    if (paramTAVClip == null)
    {
      paramTAVClip = paramCMTime;
      return paramTAVClip;
    }
    Iterator localIterator = paramTAVClip.iterator();
    for (;;)
    {
      paramTAVClip = paramCMTime;
      if (!localIterator.hasNext()) {
        break;
      }
      paramTAVClip = (TAVTimeEffect)localIterator.next();
      CMTime localCMTime = paramTAVClip.getTimeRange().getStart().sub(paramCMTime);
      if (localCMTime.value > 0L)
      {
        TAVClipSegment localTAVClipSegment = new TAVClipSegment(null);
        TAVClipSegment.access$102(localTAVClipSegment, new CMTimeRange(paramCMTime, localCMTime));
        paramList.add(localTAVClipSegment);
      }
      paramCMTime = new TAVClipSegment(null);
      TAVClipSegment.access$102(paramCMTime, new CMTimeRange(paramTAVClip.getTimeRange().getStart().add(paramTAVResource.getSourceTimeRange().getStart()), paramTAVClip.getTimeRange().getDuration()));
      TAVClipSegment.access$002(paramCMTime, paramTAVClip);
      paramList.add(paramCMTime);
      paramCMTime = paramCMTime.timeRange.getEnd();
    }
  }
  
  public List<TAVClip> build()
  {
    ArrayList localArrayList = new ArrayList();
    CMTimeRange localCMTimeRange = this.clip.getResource().getSourceTimeRange();
    if ((localCMTimeRange == null) || (localCMTimeRange.getDuration().value == 0L)) {
      return null;
    }
    initChannelWithClip(this.clip, localArrayList);
    return localArrayList;
  }
  
  public void setClip(TAVClip paramTAVClip)
  {
    this.clip = paramTAVClip;
  }
  
  public void setTimeEffects(TAVTimeEffect[] paramArrayOfTAVTimeEffect)
  {
    this.timeEffects = paramArrayOfTAVTimeEffect;
  }
  
  static class TAVClipSegment
  {
    private TAVTimeEffect timeEffect;
    private CMTimeRange timeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVTimeEffectBuilder
 * JD-Core Version:    0.7.0.1
 */