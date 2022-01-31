import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.biz.widgets.SelfLocationOverlay;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.MapController;

public class toz
  extends SosoInterface.OnLocationListener
{
  public toz(QQMapActivity paramQQMapActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.d) {
      SosoInterface.b(this);
    }
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    GeoPoint localGeoPoint;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null))
    {
      str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("get_location", 2, "onLocationFinish errCode=" + paramInt);
      }
      if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label486;
      }
      localGeoPoint = new GeoPoint((int)(paramSosoLbsInfo.a.jdField_a_of_type_Double * 1000000.0D), (int)(paramSosoLbsInfo.a.jdField_b_of_type_Double * 1000000.0D));
      if (this.a.s)
      {
        if (!this.a.k) {
          break label181;
        }
        label129:
        this.a.h();
        this.a.s = false;
      }
      if (this.a.k) {
        break label225;
      }
      this.a.a(localGeoPoint, str);
    }
    for (;;)
    {
      label181:
      label225:
      label486:
      try
      {
        this.a.dismissDialog(0);
        return;
      }
      catch (IllegalArgumentException paramSosoLbsInfo) {}
      str = "";
      break;
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(localGeoPoint);
      this.a.g = str;
      this.a.c.setVisibility(0);
      this.a.c(localGeoPoint);
      break label129;
      this.a.z();
      long l = System.currentTimeMillis();
      if (l - this.a.jdField_a_of_type_Long > 5000L)
      {
        if ((this.a.e != null) && (this.a.jdField_a_of_type_ComTencentBizWidgetsPolyLineOverlay == null))
        {
          double d = QQMapRoutingHelper.a(localGeoPoint.getLongitudeE6() / 1000000.0D, localGeoPoint.getLatitudeE6() / 1000000.0D, this.a.jdField_b_of_type_Double, this.a.jdField_a_of_type_Double);
          this.a.m();
          this.a.e.setText(QQMapRoutingHelper.a(d));
        }
        this.a.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint = localGeoPoint;
        this.a.p = str;
        this.a.q = paramSosoLbsInfo.a.jdField_a_of_type_JavaLangString;
        if (this.a.jdField_a_of_type_ComTencentBizWidgetsSelfLocationOverlay != null)
        {
          this.a.jdField_a_of_type_ComTencentBizWidgetsSelfLocationOverlay.a(this.a.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.invalidateOverLay();
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.invalidate();
        }
        if (QLog.isColorLevel()) {
          QLog.d("get_location", 2, "onLocationFinish, mSelfPoint=" + this.a.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint + ",addr=" + str + ",poiName=" + this.a.q);
        }
        this.a.jdField_a_of_type_Long = l;
        continue;
        this.a.y();
        SosoInterface.b(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     toz
 * JD-Core Version:    0.7.0.1
 */