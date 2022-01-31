import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import com.tencent.mobileqq.maproam.activity.RoamingActivity.GetAddressTaskListener;
import com.tencent.mobileqq.utils.ReverseGeocode;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class gbx
  extends AsyncTask
{
  GeoPoint jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint;
  SoftReference jdField_a_of_type_JavaLangRefSoftReference;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public gbx(GeoPoint paramGeoPoint, TextView paramTextView, RoamingActivity.GetAddressTaskListener paramGetAddressTaskListener)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTextView);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramGetAddressTaskListener);
    if (paramTextView != null) {
      paramTextView.setTag(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
    }
  }
  
  protected String a(Context... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null))
    {
      paramVarArgs = paramVarArgs[0];
      int i = 0;
      while (i < 2)
      {
        String str = ReverseGeocode.a(paramVarArgs, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() / 1000000.0D, 3);
        if ((str != null) && (str.length() > 0)) {
          return str;
        }
        i += 1;
      }
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    RoamingActivity.GetAddressTaskListener localGetAddressTaskListener = (RoamingActivity.GetAddressTaskListener)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if ((localTextView != null) && ((localTextView.getTag() instanceof GeoPoint)))
    {
      GeoPoint localGeoPoint = (GeoPoint)localTextView.getTag();
      if ((localGeoPoint.getLatitudeE6() == this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6()) && (localGeoPoint.getLongitudeE6() == this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6()))
      {
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label103;
        }
        localTextView.setText(paramString);
      }
    }
    for (;;)
    {
      if (localGetAddressTaskListener != null) {
        localGetAddressTaskListener.a(paramString);
      }
      return;
      label103:
      localTextView.setText(String.format("(%.3f,%.3f)", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() / 1000000.0D) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gbx
 * JD-Core Version:    0.7.0.1
 */