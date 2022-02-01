package com.tencent.tavkit.component;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Comparator;

class TAVTimeEffectBuilder$1
  implements Comparator<TAVTimeEffect>
{
  TAVTimeEffectBuilder$1(TAVTimeEffectBuilder paramTAVTimeEffectBuilder) {}
  
  public int compare(TAVTimeEffect paramTAVTimeEffect1, TAVTimeEffect paramTAVTimeEffect2)
  {
    if (paramTAVTimeEffect1.getTimeRange().getStart().bigThan(paramTAVTimeEffect2.getTimeRange().getStart())) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVTimeEffectBuilder.1
 * JD-Core Version:    0.7.0.1
 */