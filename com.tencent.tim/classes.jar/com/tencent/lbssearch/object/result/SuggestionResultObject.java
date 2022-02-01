package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class SuggestionResultObject
  extends BaseObject
{
  public int count;
  public List<SuggestionData> data;
  public List<SubPoi> sub_pois;
  
  public class SubPoi
  {
    public String adcode;
    public String address;
    public String city;
    public String id;
    @SerializedName("location")
    public LatLng latLng;
    public String parent_id;
    public String title;
    
    public SubPoi() {}
  }
  
  public class SuggestionData
  {
    public float _distance;
    public String adcode;
    public String address;
    public String city;
    public String district;
    public String id;
    @SerializedName("location")
    public LatLng latLng;
    public String province;
    public String title;
    public int type;
    
    public SuggestionData() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.SuggestionResultObject
 * JD-Core Version:    0.7.0.1
 */