package com.tencent.mobileqq.microapp.out.activity;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.microapp.widget.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

final class b
  extends SosoInterface.a
{
  b(MapActivity paramMapActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, boolean paramBoolean5)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapActivity", 2, "onLocationFinish errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a;
      this.b.l = new LatLng(paramSosoLbsInfo.cd, paramSosoLbsInfo.ce);
      if (this.a) {
        this.b.a.setCenter(this.b.l);
      }
      if (this.b.j == 2)
      {
        this.b.q.a();
        MapActivity.a(this.b, (int)(this.b.l.getLatitude() * 1000000.0D));
        MapActivity.b(this.b, (int)(this.b.l.getLongitude() * 1000000.0D));
        MapActivity.a(this.b, MapActivity.a(this.b), MapActivity.b(this.b));
      }
      return;
    }
    this.b.s.a("位置获取失败", "获取位置不成功，请刷新试试", "刷新", "#FF000000", "返回", "#FF000000", true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.b
 * JD-Core Version:    0.7.0.1
 */