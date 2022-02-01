package com.tencent.ttpic.filter;

import com.tencent.ttpic.openapi.filter.FilterInfo;
import java.util.HashMap;

public class FilterModel
{
  private float alpha = 1.0F;
  private String assetsLutPath = "";
  private int effectIndex = 0;
  private HashMap<String, Object> filterExtraInfo = new HashMap();
  private int filterId = -1;
  private String sid = "";
  
  public FilterModel(String paramString)
  {
    this.sid = paramString;
  }
  
  public FilterModel(String paramString, FilterInfo paramFilterInfo, float paramFloat)
  {
    this(paramString);
    this.filterId = paramFilterInfo.getFilterId();
    this.effectIndex = paramFilterInfo.getEffectIndex();
    this.alpha = paramFloat;
  }
  
  public FilterModel(String paramString1, String paramString2, float paramFloat)
  {
    this(paramString1);
    this.assetsLutPath = paramString2;
    this.alpha = paramFloat;
  }
  
  public void addFilterParam(String paramString1, String paramString2)
  {
    this.filterExtraInfo.put(paramString1, paramString2);
  }
  
  public float getAlpha()
  {
    return this.alpha;
  }
  
  public String getAssetsLutPath()
  {
    return this.assetsLutPath;
  }
  
  public int getEffectIndex()
  {
    return this.effectIndex;
  }
  
  public HashMap<String, Object> getFilterExtraInfo()
  {
    return this.filterExtraInfo;
  }
  
  public int getFilterId()
  {
    return this.filterId;
  }
  
  public String getSid()
  {
    return this.sid;
  }
  
  public void setAlpha(float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  public void setAssetsLutPath(String paramString)
  {
    this.assetsLutPath = paramString;
  }
  
  public void setEffectIndex(int paramInt)
  {
    this.effectIndex = paramInt;
  }
  
  public void setFilterExtraInfo(HashMap<String, Object> paramHashMap)
  {
    this.filterExtraInfo = paramHashMap;
  }
  
  public void setFilterId(int paramInt)
  {
    this.filterId = paramInt;
  }
  
  public void setSid(String paramString)
  {
    this.sid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FilterModel
 * JD-Core Version:    0.7.0.1
 */