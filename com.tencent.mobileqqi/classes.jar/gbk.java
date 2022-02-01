import android.widget.TextView;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.activity.RoamingActivity.GetAddressTaskListener;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;

class gbk
  implements RoamingActivity.GetAddressTaskListener
{
  gbk(gbj paramgbj) {}
  
  public void a(String paramString)
  {
    if (1 == this.a.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a())
    {
      if (this.a.a.b.getVisibility() != 0) {
        this.a.a.i();
      }
      if ((paramString != null) && (paramString.length() > 0)) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gbk
 * JD-Core Version:    0.7.0.1
 */