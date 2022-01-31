package com.tencent.mobileqq.troop.activity;

import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;

public class TroopBarPublishActivity$LocListener
  extends SOSOMapLBSApiListener
{
  public TroopBarPublishActivity$LocListener(TroopBarPublishActivity paramTroopBarPublishActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    double d1 = paramSOSOMapLBSApiResult.Latitude;
    double d2 = paramSOSOMapLBSApiResult.Longitude;
    TroopBarPublishLocationSelectActivity.a(this.a, (int)(d1 * 1000000.0D), (int)(d2 * 1000000.0D), 0, true, this.a);
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.LocListener
 * JD-Core Version:    0.7.0.1
 */