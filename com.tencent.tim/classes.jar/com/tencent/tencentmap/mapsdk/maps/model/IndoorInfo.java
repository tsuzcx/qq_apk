package com.tencent.tencentmap.mapsdk.maps.model;

public class IndoorInfo
{
  private String a;
  private String b;
  
  public IndoorInfo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getBuildingId()
  {
    return this.a;
  }
  
  public String getFloorName()
  {
    return this.b;
  }
  
  public String toString()
  {
    return this.a + "_" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo
 * JD-Core Version:    0.7.0.1
 */