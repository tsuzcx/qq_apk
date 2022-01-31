import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnRoamResultObserver;
import com.tencent.widget.XListView;

public class ggt
  implements Runnable
{
  public ggt(RoamSearchDialog paramRoamSearchDialog, int paramInt, String paramString) {}
  
  public void run()
  {
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ggt
 * JD-Core Version:    0.7.0.1
 */