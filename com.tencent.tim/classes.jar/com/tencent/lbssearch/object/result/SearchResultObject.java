package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class SearchResultObject
  extends BaseObject
{
  public int count;
  public List<SearchResultData> data;
  
  public class SearchResultData
  {
    public AdInfo ad_info;
    public String address;
    public String category;
    public String id;
    @SerializedName("location")
    public LatLng latLng;
    public Pano pano;
    public String tel;
    public String title;
    public String type;
    
    public SearchResultData() {}
    
    public class Pano
    {
      public int heading;
      public String id;
      public int pitch;
      public int zoom;
      
      public Pano() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.SearchResultObject
 * JD-Core Version:    0.7.0.1
 */