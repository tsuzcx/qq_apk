package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class DrivingResultObject
  extends RoutePlanningObject
{
  public static final String EXPERIENCE = "EXPERIENCE";
  public static final String LEAST_DISTANCE = "LEAST_DISTANCE";
  public static final String LEAST_LIGHT = "LEAST_LIGHT";
  public static final String LEAST_TIME = "LEAST_TIME";
  public static final String RECOMMEND = "RECOMMEND";
  public Result result;
  
  public static final class Restriction
  {
    public int status;
  }
  
  public static final class Result
  {
    public List<DrivingResultObject.Route> routes;
  }
  
  public static final class Route
  {
    public String direction;
    public float distance;
    public float duration;
    public String mode;
    public List<LatLng> polyline;
    public DrivingResultObject.Restriction restriction;
    public List<RoutePlanningObject.Step> steps;
    public List<String> tags;
    public DrivingResultObject.TaxiFare taxi_fare;
    public List<DrivingResultObject.WayPoint> waypoints;
  }
  
  public static final class TaxiFare
  {
    public double fare;
  }
  
  public static final class WayPoint
  {
    @SerializedName("location")
    public LatLng latLng;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.DrivingResultObject
 * JD-Core Version:    0.7.0.1
 */