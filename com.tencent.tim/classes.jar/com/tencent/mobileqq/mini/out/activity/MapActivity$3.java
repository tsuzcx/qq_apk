package com.tencent.mobileqq.mini.out.activity;

import com.tencent.mobileqq.mini.out.CommonObserver;
import com.tencent.mobileqq.mini.out.MapHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;

class MapActivity$3
  extends CommonObserver
{
  MapActivity$3(MapActivity paramMapActivity) {}
  
  public void onGetPoiList(boolean paramBoolean, LBSShare.LocationResp paramLocationResp)
  {
    this.this$0.isSearching = false;
    if (paramBoolean) {
      MapActivity.access$400(this.this$0, paramLocationResp.poilist.get(), paramLocationResp.next.get());
    }
  }
  
  public void onGetStreetUrl(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.this$0.mapHelper.setStreetViewUrl(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity.3
 * JD-Core Version:    0.7.0.1
 */