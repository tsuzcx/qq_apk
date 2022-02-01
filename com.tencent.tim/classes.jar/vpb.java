import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.QQMapActivity.8.1;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;

public class vpb
  extends aczc.b
{
  public vpb(QQMapActivity paramQQMapActivity, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    GeoPoint localGeoPoint;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.address != null))
    {
      str = paramSosoLbsInfo.a.address;
      if (QLog.isColorLevel()) {
        QLog.d("get_location", 2, "onLocationFinish errCode=" + paramInt);
      }
      if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label546;
      }
      localGeoPoint = new GeoPoint((int)(paramSosoLbsInfo.a.cd * 1000000.0D), (int)(paramSosoLbsInfo.a.ce * 1000000.0D));
      if (this.a.aZK)
      {
        if (!this.a.aZD) {
          break label181;
        }
        label129:
        this.a.ayr();
        this.a.aZK = false;
      }
      if (this.a.aZD) {
        break label253;
      }
      this.a.a(localGeoPoint, str);
    }
    for (;;)
    {
      label181:
      label253:
      try
      {
        this.a.dismissDialog(0);
        return;
      }
      catch (IllegalArgumentException paramSosoLbsInfo) {}
      str = "";
      break;
      this.a.b.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D)));
      this.a.location = str;
      this.a.pinView.setVisibility(0);
      this.a.c(localGeoPoint);
      break label129;
      this.a.bTx();
      long l = System.currentTimeMillis();
      if (l - this.a.GH > 5000L)
      {
        if ((this.a.EZ != null) && (this.a.a == null))
        {
          double d = swb.getDistance(localGeoPoint.getLongitudeE6() / 1000000.0D, localGeoPoint.getLatitudeE6() / 1000000.0D, this.a.longitude, this.a.latitude);
          this.a.bTo();
          this.a.EZ.setText(swb.c(d));
        }
        this.a.k = localGeoPoint;
        this.a.aOZ = str;
        this.a.mSelfPoiName = paramSosoLbsInfo.a.name;
        if (this.a.f != null)
        {
          this.a.f.setPosition(new LatLng(this.a.k.getLatitudeE6() / 1000000.0D, this.a.k.getLongitudeE6() / 1000000.0D));
          this.a.f.setSnippet("");
          this.a.f.showInfoWindow();
        }
        if (QLog.isColorLevel()) {
          QLog.d("get_location", 2, "onLocationFinish, mSelfPoint=" + this.a.k + ",addr=" + str + ",poiName=" + this.a.mSelfPoiName);
        }
        this.a.GH = l;
        continue;
        label546:
        this.a.bTw();
        new Handler().post(new QQMapActivity.8.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpb
 * JD-Core Version:    0.7.0.1
 */