package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class Geo2AddressResultObject
  extends BaseObject
{
  public ReverseAddressResult result;
  
  public class ReverseAddressResult
  {
    public AdInfo ad_info;
    public String address;
    public AddressComponent address_component;
    public AddressReference address_reference;
    public FormatterAddress formatted_addresses;
    public int poi_count;
    public List<Poi> pois;
    
    public ReverseAddressResult() {}
    
    public class AddressReference
    {
      public Area crossroad;
      public Area famous_area;
      public Area landmark_l1;
      public Area landmark_l2;
      public Area street;
      public Area street_number;
      public Area water;
      
      public AddressReference() {}
      
      public class Area
      {
        public String _dir_desc;
        public float _distance;
        @SerializedName("location")
        public LatLng latLng;
        public String title;
        
        public Area() {}
      }
    }
    
    public class FormatterAddress
    {
      public String recommend;
      public String rough;
      
      public FormatterAddress() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.Geo2AddressResultObject
 * JD-Core Version:    0.7.0.1
 */