package com.tencent.ttpic.offlineset.beans;

import java.util.List;

public class MediaSettingJsonBean
{
  public List<HardDecodeDevice> hardDecode;
  public List<HardEncodeDevice> hardEncode;
  
  public static class HardDecodeDevice
  {
    public String brand;
    public int decodetype;
    public String model;
  }
  
  public static class HardEncodeDevice
  {
    public String brand;
    public int encodetype;
    public String model;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.MediaSettingJsonBean
 * JD-Core Version:    0.7.0.1
 */