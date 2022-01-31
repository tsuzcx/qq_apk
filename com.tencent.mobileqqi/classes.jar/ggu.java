import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnRoamResultObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class ggu
  implements Runnable
{
  public ggu(RoamSearchDialog paramRoamSearchDialog, List paramList, int paramInt) {}
  
  public void run()
  {
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.size() < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Ggx.b = true;
      if (QLog.isColorLevel()) {
        QLog.i(RoamSearchDialog.jdField_a_of_type_JavaLangString, 2, "getResultFromLocation, currentCount = " + this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.size() + ", totalCount = " + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label239;
      }
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Ggx.a = false;
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Ggx.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Ggx.b = false;
      break;
      label239:
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ggu
 * JD-Core Version:    0.7.0.1
 */