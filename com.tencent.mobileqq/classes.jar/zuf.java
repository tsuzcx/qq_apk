import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.ar.ARLBSPOIDialog;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult.POIInfo;

public class zuf
  implements View.OnClickListener
{
  public zuf(ARLBSPOIDialog paramARLBSPOIDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = new Intent(paramView.getContext(), PoiMapActivity.class).putExtra("lat", Double.toString(this.a.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult$POIInfo.a * 1.0D / 1000000.0D)).putExtra("lon", Double.toString(this.a.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult$POIInfo.b * 1.0D / 1000000.0D));
    this.a.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zuf
 * JD-Core Version:    0.7.0.1
 */