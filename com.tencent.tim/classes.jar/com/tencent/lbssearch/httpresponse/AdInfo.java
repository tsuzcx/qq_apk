package com.tencent.lbssearch.httpresponse;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class AdInfo
{
  public String adcode;
  public String city;
  public String district;
  @SerializedName("location")
  public LatLng latLng;
  public String name;
  public String nation;
  public String province;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.httpresponse.AdInfo
 * JD-Core Version:    0.7.0.1
 */