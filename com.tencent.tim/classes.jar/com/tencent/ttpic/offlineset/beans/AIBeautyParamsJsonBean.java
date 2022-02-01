package com.tencent.ttpic.offlineset.beans;

import java.util.List;
import java.util.Map;

public class AIBeautyParamsJsonBean
{
  public List<BeautyConfigSet> aiBeautySets;
  public boolean isNeedBabyFace = true;
  
  public static class BeautyConfigSet
  {
    public int endAge;
    public boolean faceCosmetic;
    public int gender;
    public Map<String, AIBeautyParamsJsonBean.Param> params;
    public int startAge;
    public String tag;
    
    public boolean isCurrent(int paramInt1, int paramInt2)
    {
      return (paramInt1 >= this.startAge) && (paramInt1 <= this.endAge) && (this.gender == paramInt2);
    }
  }
  
  public static class Param
  {
    public float def;
    public float max;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean
 * JD-Core Version:    0.7.0.1
 */