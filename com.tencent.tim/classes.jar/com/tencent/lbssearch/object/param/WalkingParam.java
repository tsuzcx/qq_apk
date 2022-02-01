package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.result.WalkingResultObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class WalkingParam
  extends RoutePlanningParam
{
  public WalkingParam() {}
  
  public WalkingParam(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    super(paramLatLng1, paramLatLng2);
  }
  
  public Class<WalkingResultObject> getResultClass()
  {
    return WalkingResultObject.class;
  }
  
  public String getUrl()
  {
    return "https://apis.map.qq.com/ws/direction/v1/walking";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.WalkingParam
 * JD-Core Version:    0.7.0.1
 */