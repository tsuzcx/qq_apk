package com.tencent.mobileqq.microapp.out.activity;

import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

final class a
  implements AdapterView.c
{
  a(MapActivity paramMapActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MapActivity", 2, "setOnItemClickListener" + paramInt);
    }
    paramAdapterView = this.a.q.a(paramInt);
    if (paramAdapterView != null)
    {
      this.a.q.b(paramInt);
      this.a.a.animateTo(new LatLng(paramAdapterView.lat.get() / 1000000.0D, paramAdapterView.lng.get() / 1000000.0D));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.a
 * JD-Core Version:    0.7.0.1
 */