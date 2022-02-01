package com.tencent.ttpic.offlineset.beans;

import java.util.List;

public class FilterSettingJsonBean
{
  public GaussSetting gaussSetting;
  
  public static class GassResizeSet
  {
    public String brand;
    public int maxSize = -1;
    public String model;
    public boolean needResize = true;
    public float scale = -1.0F;
  }
  
  public static class GaussSetting
  {
    public int gaussMidderPhone = 2014;
    public int gaussSuperPhone = 2016;
    public float lowMaxSize = 360.0F;
    public float midMaxSize = 360.0F;
    public List<FilterSettingJsonBean.GassResizeSet> phoneGassSet;
    public float superMaxSize = 720.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.FilterSettingJsonBean
 * JD-Core Version:    0.7.0.1
 */