package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class DistrictResultObject
  extends BaseObject
{
  public String data_version;
  public List<List<DistrictResult>> result;
  
  public class DistrictResult
  {
    public List<Integer> cidx;
    public String fullname;
    public int id;
    @SerializedName("location")
    public LatLng latLng;
    public String name;
    public List<String> pinyin;
    
    public DistrictResult() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.DistrictResultObject
 * JD-Core Version:    0.7.0.1
 */