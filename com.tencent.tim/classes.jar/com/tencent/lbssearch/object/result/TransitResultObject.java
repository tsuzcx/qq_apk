package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class TransitResultObject
  extends RoutePlanningObject
{
  public Result result;
  
  public static final class Destination
  {
    public String id;
    public String title;
  }
  
  public static final class Exit
  {
    public String id;
    public String title;
  }
  
  public static final class GetOnOrOff
  {
    public TransitResultObject.Exit exit;
    public String id;
    @SerializedName("location")
    public LatLng latLng;
    public String title;
  }
  
  public static final class LatLngBounds
  {
    public LatLng northeast;
    public LatLng southwest;
  }
  
  public static final class Line
  {
    public TransitResultObject.Destination destination;
    public float distance;
    public float duration;
    public TransitResultObject.GetOnOrOff getoff;
    public TransitResultObject.GetOnOrOff geton;
    public String id;
    public List<LatLng> polyline;
    public double price;
    public int station_count;
    public List<TransitResultObject.Station> stations;
    public String title;
    public String vehicle;
  }
  
  public static final class Result
  {
    public List<TransitResultObject.Route> routes;
  }
  
  public static final class Route
  {
    public TransitResultObject.LatLngBounds bounds;
    public float distance;
    public long duration;
    public long duration_1m;
    public List<TransitResultObject.Segment> steps;
  }
  
  public static abstract class Segment
  {
    public String mode;
  }
  
  public static final class Station
  {
    public String id;
    @SerializedName("location")
    public LatLng latLng;
    public String title;
  }
  
  public static final class Transit
    extends TransitResultObject.Segment
  {
    public List<TransitResultObject.Line> lines;
  }
  
  public static final class Walking
    extends TransitResultObject.Segment
  {
    public String accessorial_desc;
    public String direction;
    public float distance;
    public float duration;
    public List<LatLng> polyline;
    public List<RoutePlanningObject.Step> steps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.TransitResultObject
 * JD-Core Version:    0.7.0.1
 */