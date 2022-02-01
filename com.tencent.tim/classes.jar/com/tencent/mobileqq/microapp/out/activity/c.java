package com.tencent.mobileqq.microapp.out.activity;

import com.tencent.mobileqq.microapp.out.a;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;

final class c
  extends a
{
  c(MapActivity paramMapActivity) {}
  
  public void a(boolean paramBoolean, LBSShare.LocationResp paramLocationResp)
  {
    this.a.u = false;
    if (paramBoolean) {
      MapActivity.a(this.a, paramLocationResp.poilist.get(), paramLocationResp.next.get());
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.k.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.c
 * JD-Core Version:    0.7.0.1
 */