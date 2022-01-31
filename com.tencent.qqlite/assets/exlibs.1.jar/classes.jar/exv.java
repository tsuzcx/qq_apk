import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.CustomAlertDialog;
import com.tencent.mobileqq.widget.CustomAlertDialog.OnOptionMenuClick;
import java.util.HashMap;
import java.util.List;

class exv
  implements View.OnClickListener
{
  exv(exu paramexu, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Exu.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.a != null) {
      this.jdField_a_of_type_Exu.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.a.a(((Integer)((HashMap)this.jdField_a_of_type_Exu.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).get("commandId")).intValue());
    }
    this.jdField_a_of_type_Exu.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     exv
 * JD-Core Version:    0.7.0.1
 */