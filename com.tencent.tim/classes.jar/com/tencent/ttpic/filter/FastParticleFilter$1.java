package com.tencent.ttpic.filter;

import com.tencent.ttpic.model.ParticleParam;
import java.util.Comparator;

class FastParticleFilter$1
  implements Comparator<ParticleParam>
{
  FastParticleFilter$1(FastParticleFilter paramFastParticleFilter) {}
  
  public int compare(ParticleParam paramParticleParam1, ParticleParam paramParticleParam2)
  {
    return paramParticleParam1.blendFuncSrc - paramParticleParam2.blendFuncSrc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastParticleFilter.1
 * JD-Core Version:    0.7.0.1
 */