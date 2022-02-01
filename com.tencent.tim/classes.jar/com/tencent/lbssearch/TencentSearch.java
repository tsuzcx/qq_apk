package com.tencent.lbssearch;

import android.content.Context;
import com.tencent.lbssearch.object.param.Address2GeoParam;
import com.tencent.lbssearch.object.param.DistrictChildrenParam;
import com.tencent.lbssearch.object.param.DistrictSearchParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.SearchParam;
import com.tencent.lbssearch.object.param.StreetViewParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.param.TranslateParam;
import com.tencent.map.sdk.a.fr;
import com.tencent.map.tools.net.http.HttpResponseListener;

public class TencentSearch
  implements ITencentSearch
{
  private ITencentSearch a;
  
  public TencentSearch(Context paramContext)
  {
    this.a = new fr(paramContext);
  }
  
  public void address2geo(Address2GeoParam paramAddress2GeoParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.address2geo(paramAddress2GeoParam, paramHttpResponseListener);
  }
  
  public void geo2address(Geo2AddressParam paramGeo2AddressParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.geo2address(paramGeo2AddressParam, paramHttpResponseListener);
  }
  
  public void getDistrictChildren(DistrictChildrenParam paramDistrictChildrenParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.getDistrictChildren(paramDistrictChildrenParam, paramHttpResponseListener);
  }
  
  public void getDistrictList(HttpResponseListener paramHttpResponseListener)
  {
    this.a.getDistrictList(paramHttpResponseListener);
  }
  
  public void getDistrictSearch(DistrictSearchParam paramDistrictSearchParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.getDistrictSearch(paramDistrictSearchParam, paramHttpResponseListener);
  }
  
  public void getRoutePlan(RoutePlanningParam paramRoutePlanningParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.getRoutePlan(paramRoutePlanningParam, paramHttpResponseListener);
  }
  
  public void getpano(StreetViewParam paramStreetViewParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.getpano(paramStreetViewParam, paramHttpResponseListener);
  }
  
  public void search(SearchParam paramSearchParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.search(paramSearchParam, paramHttpResponseListener);
  }
  
  public void suggestion(SuggestionParam paramSuggestionParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.suggestion(paramSuggestionParam, paramHttpResponseListener);
  }
  
  public void translate(TranslateParam paramTranslateParam, HttpResponseListener paramHttpResponseListener)
  {
    this.a.translate(paramTranslateParam, paramHttpResponseListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.TencentSearch
 * JD-Core Version:    0.7.0.1
 */