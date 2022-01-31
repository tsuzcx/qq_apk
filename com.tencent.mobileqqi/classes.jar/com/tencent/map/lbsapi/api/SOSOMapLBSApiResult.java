package com.tencent.map.lbsapi.api;

import java.util.ArrayList;
import java.util.Iterator;

public class SOSOMapLBSApiResult
{
  public double Accuracy = 0.0D;
  public String Address = null;
  public String AdministrativeArea1 = null;
  public String AdministrativeArea2 = null;
  public String AdministrativeArea3 = null;
  public double Altitude = -1.0D;
  public int AreaStat = 0;
  public String City = null;
  public double Dir = 0.0D;
  public String District = null;
  public int ErrorCode = 0;
  public int Info = -1;
  public double Latitude = 0.0D;
  public int LocType = 1;
  public String Locality = null;
  public double Longitude = 0.0D;
  public String Name = null;
  public String Nation = null;
  public ArrayList<SOSOMapLBSApiPOI> POIList = null;
  public String Province = null;
  public String Route = null;
  public double Speed = 0.0D;
  public String Street = null;
  public String StreetNo = null;
  public String Sublocality = null;
  public String Town = null;
  public String Village = null;
  public boolean isMars = false;
  private long mTime = -1L;
  
  public SOSOMapLBSApiResult()
  {
    this.Accuracy = 0.0D;
    this.Altitude = 0.0D;
    this.Longitude = 0.0D;
    this.Latitude = 0.0D;
    this.StreetNo = null;
    this.Street = null;
    this.Village = null;
    this.Town = null;
    this.isMars = false;
    this.mTime = System.currentTimeMillis();
    this.ErrorCode = 0;
    this.Info = -1;
    this.POIList = null;
  }
  
  public SOSOMapLBSApiResult(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    this.LocType = paramSOSOMapLBSApiResult.LocType;
    this.Latitude = paramSOSOMapLBSApiResult.Latitude;
    this.Longitude = paramSOSOMapLBSApiResult.Longitude;
    this.Altitude = paramSOSOMapLBSApiResult.Altitude;
    this.Accuracy = paramSOSOMapLBSApiResult.Accuracy;
    this.isMars = paramSOSOMapLBSApiResult.isMars;
    this.Name = paramSOSOMapLBSApiResult.Name;
    this.Address = paramSOSOMapLBSApiResult.Address;
    this.Nation = paramSOSOMapLBSApiResult.Nation;
    this.AreaStat = 0;
    this.Province = paramSOSOMapLBSApiResult.Province;
    this.City = paramSOSOMapLBSApiResult.City;
    this.District = paramSOSOMapLBSApiResult.District;
    this.Town = paramSOSOMapLBSApiResult.Town;
    this.Village = paramSOSOMapLBSApiResult.Village;
    this.Street = paramSOSOMapLBSApiResult.Street;
    this.StreetNo = paramSOSOMapLBSApiResult.StreetNo;
    this.AdministrativeArea1 = paramSOSOMapLBSApiResult.AdministrativeArea1;
    this.AdministrativeArea2 = paramSOSOMapLBSApiResult.AdministrativeArea2;
    this.AdministrativeArea3 = paramSOSOMapLBSApiResult.AdministrativeArea3;
    this.Locality = paramSOSOMapLBSApiResult.Locality;
    this.Sublocality = paramSOSOMapLBSApiResult.Sublocality;
    this.Route = paramSOSOMapLBSApiResult.Route;
    this.mTime = paramSOSOMapLBSApiResult.getTime();
    this.ErrorCode = paramSOSOMapLBSApiResult.ErrorCode;
    this.Info = paramSOSOMapLBSApiResult.Info;
    this.POIList = null;
    if (paramSOSOMapLBSApiResult.POIList != null)
    {
      this.POIList = new ArrayList();
      paramSOSOMapLBSApiResult = paramSOSOMapLBSApiResult.POIList.iterator();
      while (paramSOSOMapLBSApiResult.hasNext())
      {
        SOSOMapLBSApiPOI localSOSOMapLBSApiPOI = (SOSOMapLBSApiPOI)paramSOSOMapLBSApiResult.next();
        this.POIList.add(localSOSOMapLBSApiPOI);
      }
    }
  }
  
  public long getTime()
  {
    return this.mTime;
  }
  
  public void setAddressLine(String paramString)
  {
    this.District = "Unknown";
    this.City = "Unknown";
    this.Province = "Unknown";
    this.Nation = "Unknown";
    if (paramString == null) {}
    int i;
    do
    {
      do
      {
        return;
        paramString = paramString.split(",");
      } while (paramString == null);
      i = paramString.length;
      if (i > 0) {
        this.Nation = paramString[0];
      }
      if (i > 1) {
        this.Province = paramString[1];
      }
      if (i == 3) {
        this.City = paramString[1];
      }
      while (i == 3)
      {
        this.District = paramString[2];
        return;
        if (i > 3) {
          this.City = paramString[2];
        }
      }
    } while (i <= 3);
    this.District = paramString[3];
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = localStringBuilder.append(this.Info).append(" ").append(this.ErrorCode).append(" ");
    if (this.isMars)
    {
      localObject1 = "Mars";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" ");
      if (this.LocType != 0) {
        break label444;
      }
    }
    label444:
    for (Object localObject1 = "GPS";; localObject1 = "Network")
    {
      ((StringBuilder)localObject2).append((String)localObject1).append("\n");
      localStringBuilder.append(this.Latitude).append(" ").append(this.Longitude).append("\n");
      localStringBuilder.append(this.Altitude).append(" ").append(this.Accuracy).append("\n");
      localStringBuilder.append(this.Speed).append(" ").append(this.Dir).append("\n");
      if (this.Info == 1) {
        localStringBuilder.append(this.Name).append(" ").append(this.Address).append("\n");
      }
      if ((this.Info == 3) || (this.Info == 4)) {
        localStringBuilder.append(this.Nation).append(" ").append(this.Province).append(" ").append(this.City).append(" ").append(this.District).append(" ").append(this.Town).append(" ").append(this.Village).append(" ").append(this.Street).append(" ").append(this.StreetNo).append("\n");
      }
      if ((this.Info != 4) || (this.POIList == null)) {
        break label450;
      }
      localStringBuilder.append(this.POIList.size()).append("\n");
      localObject1 = this.POIList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SOSOMapLBSApiPOI)((Iterator)localObject1).next();
        localStringBuilder.append(((SOSOMapLBSApiPOI)localObject2).Name).append(",").append(((SOSOMapLBSApiPOI)localObject2).Addr).append(",").append(((SOSOMapLBSApiPOI)localObject2).Catalog).append(",").append(((SOSOMapLBSApiPOI)localObject2).Dist).append(",").append(((SOSOMapLBSApiPOI)localObject2).Latitude).append(",").append(((SOSOMapLBSApiPOI)localObject2).Longitude).append("\n");
      }
      localObject1 = "WGS84";
      break;
    }
    label450:
    if (this.Info == 7)
    {
      if (this.AreaStat != 0) {
        break label569;
      }
      localStringBuilder.append(this.Nation).append(" ").append(this.Province).append(" ").append(this.City).append(" ").append(this.District).append(" ").append(this.Town).append(" ").append(this.Village).append(" ").append(this.Street).append(" ").append(this.StreetNo).append("\n");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label569:
      if (this.AreaStat == 1) {
        localStringBuilder.append(this.Nation).append(" ").append(this.AdministrativeArea1).append(" ").append(this.AdministrativeArea2).append(" ").append(this.AdministrativeArea3).append(" ").append(this.Locality).append(" ").append(this.Sublocality).append(" ").append(this.Route).append("\n");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.map.lbsapi.api.SOSOMapLBSApiResult
 * JD-Core Version:    0.7.0.1
 */