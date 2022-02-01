package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import java.util.List;

public abstract class RoutePlanningObject
  extends BaseObject
{
  public static final class Step
  {
    public String accessorial_desc;
    public String act_desc;
    public String dir_desc;
    public float distance;
    public String instruction;
    public List<Integer> polyline_idx;
    public String road_name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.RoutePlanningObject
 * JD-Core Version:    0.7.0.1
 */