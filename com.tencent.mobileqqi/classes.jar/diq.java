import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.utils.ReverseGeocode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class diq
  extends AsyncTask
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GeoPoint jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint;
  
  public diq(QQMapActivity paramQQMapActivity, GeoPoint paramGeoPoint, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramGeoPoint;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
  }
  
  protected String a(GeoPoint... paramVarArgs)
  {
    int i = 0;
    while (i < 3)
    {
      String str = ReverseGeocode.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() / 1000000.0D, 3);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append(i).append(" time: ReverseGeocode.getFromLocation, address: ");
        if (str != null) {
          break label102;
        }
      }
      label102:
      for (paramVarArgs = "";; paramVarArgs = str)
      {
        QLog.i("fetch_address", 2, paramVarArgs);
        if ((str == null) || (str.length() <= 0)) {
          break;
        }
        return str;
      }
      i += 1;
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("fetch_address", 2, "get address finish, onPostExecute, result:" + paramString);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      GeoPoint localGeoPoint = (GeoPoint)this.jdField_a_of_type_AndroidWidgetTextView.getTag();
      if ((localGeoPoint.getLatitudeE6() == this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6()) && (localGeoPoint.getLongitudeE6() == this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6()) && (paramString != null) && (paramString.length() > 0))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.jdField_h_of_type_Boolean) {
          break label147;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.jdField_h_of_type_AndroidViewView.findViewById(2131231872).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.jdField_h_of_type_AndroidViewView.findViewById(2131231873).setVisibility(0);
      }
    }
    return;
    label147:
    this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.j = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     diq
 * JD-Core Version:    0.7.0.1
 */