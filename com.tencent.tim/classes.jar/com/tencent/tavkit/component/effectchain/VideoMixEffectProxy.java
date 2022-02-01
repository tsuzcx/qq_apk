package com.tencent.tavkit.component.effectchain;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import com.tencent.tavkit.report.FilterChainReportSession;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoMixEffectProxy
  implements TAVVideoMixEffect
{
  private boolean autoCheckEffectRemove = true;
  @NonNull
  private CopyOnWriteArrayList<TAVVideoMixEffect> effects = new CopyOnWriteArrayList();
  @NonNull
  private final List<FilterProxy> filterProxies = new ArrayList();
  
  public TAVVideoMixEffect.Filter createFilter()
  {
    FilterProxy localFilterProxy = new FilterProxy(null);
    this.filterProxies.add(localFilterProxy);
    return localFilterProxy;
  }
  
  @NonNull
  public String effectId()
  {
    return "VideoMixEffectProxy" + Integer.toHexString(hashCode());
  }
  
  @NonNull
  public List<TAVVideoMixEffect> getEffects()
  {
    return this.effects;
  }
  
  public boolean isAutoCheckEffectRemove()
  {
    return this.autoCheckEffectRemove;
  }
  
  public void notifyOnEffectRemove()
  {
    Iterator localIterator = this.filterProxies.iterator();
    while (localIterator.hasNext()) {
      ((FilterProxy)localIterator.next()).notifyOnEffectRemove();
    }
  }
  
  public void setAutoCheckEffectRemove(boolean paramBoolean)
  {
    this.autoCheckEffectRemove = paramBoolean;
  }
  
  public void setEffects(@NonNull CopyOnWriteArrayList<TAVVideoMixEffect> paramCopyOnWriteArrayList)
  {
    this.effects = paramCopyOnWriteArrayList;
  }
  
  static class FilterProxy
    implements TAVVideoMixEffect.Filter, IReportable
  {
    @NonNull
    private final HashMap<String, TAVVideoMixEffect.Filter> filterMap = new HashMap();
    private boolean onEffectRemove;
    @NonNull
    private final FilterChainReportSession reportSession = new FilterChainReportSession();
    
    private void checkRuntimeRelease(List<TAVVideoMixEffect> paramList)
    {
      if (!this.onEffectRemove) {}
      for (;;)
      {
        return;
        this.onEffectRemove = false;
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        Object localObject;
        while (paramList.hasNext())
        {
          localObject = (TAVVideoMixEffect)paramList.next();
          if (!TextUtils.isEmpty(((TAVVideoMixEffect)localObject).effectId())) {
            localArrayList.add(((TAVVideoMixEffect)localObject).effectId());
          }
        }
        paramList = new HashSet(this.filterMap.keySet()).iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          if (!localArrayList.contains(localObject))
          {
            ((TAVVideoMixEffect.Filter)this.filterMap.get(localObject)).release();
            this.filterMap.remove(localObject);
          }
        }
      }
    }
    
    @Nullable
    private TAVVideoMixEffect.Filter getCacheFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
    {
      if ((paramTAVVideoMixEffect == null) || (TextUtils.isEmpty(paramTAVVideoMixEffect.effectId()))) {
        return null;
      }
      String str = paramTAVVideoMixEffect.effectId();
      if (this.filterMap.containsKey(str)) {
        return (TAVVideoMixEffect.Filter)this.filterMap.get(str);
      }
      paramTAVVideoMixEffect = paramTAVVideoMixEffect.createFilter();
      this.filterMap.put(str, paramTAVVideoMixEffect);
      return paramTAVVideoMixEffect;
    }
    
    private void notifyOnEffectRemove()
    {
      this.onEffectRemove = true;
    }
    
    public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
    {
      if (!(paramTAVVideoMixEffect instanceof VideoMixEffectProxy)) {
        return null;
      }
      Object localObject = ((VideoMixEffectProxy)paramTAVVideoMixEffect).getEffects();
      if ((((VideoMixEffectProxy)paramTAVVideoMixEffect).isAutoCheckEffectRemove()) || (this.onEffectRemove)) {
        checkRuntimeRelease((List)localObject);
      }
      Iterator localIterator = ((List)localObject).iterator();
      paramTAVVideoMixEffect = null;
      TAVVideoMixEffect.Filter localFilter;
      long l;
      while (localIterator.hasNext())
      {
        localObject = (TAVVideoMixEffect)localIterator.next();
        localFilter = getCacheFilter((TAVVideoMixEffect)localObject);
        if (localFilter != null)
        {
          l = System.nanoTime();
          if (!(localFilter instanceof IReportable)) {
            break label153;
          }
        }
      }
      label153:
      for (paramTAVVideoMixEffect = ((IReportable)localFilter).getReportKey();; paramTAVVideoMixEffect = null)
      {
        localObject = localFilter.apply((TAVVideoMixEffect)localObject, paramImageCollection, paramRenderInfo);
        if (!TextUtils.isEmpty(paramTAVVideoMixEffect)) {
          this.reportSession.tick(paramTAVVideoMixEffect, System.nanoTime() - l);
        }
        paramTAVVideoMixEffect = (TAVVideoMixEffect)localObject;
        break;
        return paramTAVVideoMixEffect;
      }
    }
    
    public String getReportKey()
    {
      return MemoryReportHelper.appendReportKey(this.filterMap.values());
    }
    
    public void release()
    {
      try
      {
        Iterator localIterator = this.filterMap.values().iterator();
        while (localIterator.hasNext()) {
          ((TAVVideoMixEffect.Filter)localIterator.next()).release();
        }
        this.filterMap.clear();
      }
      finally {}
      this.reportSession.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.VideoMixEffectProxy
 * JD-Core Version:    0.7.0.1
 */