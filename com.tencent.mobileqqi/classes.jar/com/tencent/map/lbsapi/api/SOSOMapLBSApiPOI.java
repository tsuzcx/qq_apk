package com.tencent.map.lbsapi.api;

public class SOSOMapLBSApiPOI
{
  public String Addr = null;
  public String Catalog = null;
  public double Dist = 0.0D;
  public double Latitude = 0.0D;
  public double Longitude = 0.0D;
  public String Name = null;
  
  public SOSOMapLBSApiPOI(SOSOMapLBSApiPOI paramSOSOMapLBSApiPOI)
  {
    this.Name = paramSOSOMapLBSApiPOI.Name;
    this.Addr = paramSOSOMapLBSApiPOI.Addr;
    this.Catalog = paramSOSOMapLBSApiPOI.Catalog;
    this.Dist = paramSOSOMapLBSApiPOI.Dist;
    this.Latitude = paramSOSOMapLBSApiPOI.Latitude;
    this.Longitude = paramSOSOMapLBSApiPOI.Longitude;
  }
  
  public SOSOMapLBSApiPOI(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.Name = paramString1;
    this.Addr = paramString2;
    this.Catalog = paramString3;
    this.Dist = paramDouble1;
    this.Latitude = paramDouble2;
    this.Longitude = paramDouble3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.map.lbsapi.api.SOSOMapLBSApiPOI
 * JD-Core Version:    0.7.0.1
 */