package com.tencent.ttpic.offlineset.beans;

import java.util.List;

public class PagSettingJsonBean
{
  public int lowDeviceYear = 2015;
  public float lowScale = 0.5F;
  public List<PagDeviceSetting> phoneSetting;
  
  public static class PagDeviceSetting
  {
    public String brand;
    public int encodeBackgroud = 0;
    public String model;
    public int needLowScale = 0;
    public boolean needSoftDecode = false;
    public boolean notRealTime = false;
    public float scale = 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.PagSettingJsonBean
 * JD-Core Version:    0.7.0.1
 */