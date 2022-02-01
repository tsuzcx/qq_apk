package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class StreetViewResultObject
  extends BaseObject
{
  public Details detail;
  
  public class Details
  {
    public String description;
    public int heading;
    public String id;
    @SerializedName("location")
    public LatLng latLng;
    public int pitch;
    public int pov_exp;
    public int zoom;
    
    public Details() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.StreetViewResultObject
 * JD-Core Version:    0.7.0.1
 */