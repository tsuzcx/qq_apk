import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.mobileqq.utils.VipUtils;

class gga
  implements Runnable
{
  gga(gfz paramgfz, long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  public void run()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Long >= this.b * 1000L) && (this.jdField_a_of_type_Long <= this.c * 1000L))
    {
      this.jdField_a_of_type_Gfz.a.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      if (this.jdField_a_of_type_Gfz.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1) {
        this.jdField_a_of_type_Gfz.a.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      TextView localTextView = this.jdField_a_of_type_Gfz.a.d;
      if (!VipUtils.a(this.jdField_a_of_type_Gfz.a.b)) {
        break label182;
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      label109:
      localTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_Gfz.a.jdField_a_of_type_AndroidWidgetButton;
      if (!VipUtils.a(this.jdField_a_of_type_Gfz.a.b)) {
        break label201;
      }
    }
    label182:
    label201:
    for (int i = 2131562171;; i = 2131562277)
    {
      ((Button)localObject).setText(i);
      return;
      this.jdField_a_of_type_Gfz.a.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.jdField_a_of_type_Gfz.a.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      break;
      localObject = this.jdField_a_of_type_Gfz.a.getResources().getText(2131562017);
      break label109;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gga
 * JD-Core Version:    0.7.0.1
 */