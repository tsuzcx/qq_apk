package com.tencent.lbssearch.object.result;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class WalkingResultObject
  extends RoutePlanningObject
{
  public Result result;
  
  public static final class Result
  {
    public List<WalkingResultObject.Route> routes;
  }
  
  public static final class Route
  {
    public String direction;
    public float distance;
    public float duration;
    public String mode;
    public List<LatLng> polyline;
    public List<RoutePlanningObject.Step> steps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.WalkingResultObject
 * JD-Core Version:    0.7.0.1
 */