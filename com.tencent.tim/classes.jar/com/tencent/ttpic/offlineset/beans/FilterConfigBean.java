package com.tencent.ttpic.offlineset.beans;

import java.util.List;
import java.util.Map;

public class FilterConfigBean
{
  public List<FilterParam> filterConfigList;
  
  public static class FilterParam
  {
    public int disable = 0;
    public String filterID;
    public Map<String, Float> params;
    public float strength;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.FilterConfigBean
 * JD-Core Version:    0.7.0.1
 */