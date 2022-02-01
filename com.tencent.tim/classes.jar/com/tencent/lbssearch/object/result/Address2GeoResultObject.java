package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class Address2GeoResultObject
  extends BaseObject
{
  public Address2GeoResult result;
  
  public static final class Address2GeoResult
  {
    public AdInfo ad_info;
    public AddressComponent address_components;
    public float deviation;
    @SerializedName("location")
    public LatLng latLng;
    public int level;
    public int reliability;
    public float similarity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.Address2GeoResultObject
 * JD-Core Version:    0.7.0.1
 */