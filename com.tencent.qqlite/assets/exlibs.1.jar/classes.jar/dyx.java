import android.widget.EditText;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class dyx
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  public dyx(RoamSearchDialog paramRoamSearchDialog) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.b == 0) {}
    while ((this.jdField_a_of_type_Int != this.b) || (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Dze == null) || (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Dze.b != true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(RoamSearchDialog.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged, reach bottom, lastItem = " + this.jdField_a_of_type_Int + ", totalItemCount = " + this.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Dze.a = true;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Dze.notifyDataSetChanged();
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.b;
    RoamSearchDialog localRoamSearchDialog = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog;
    paramInt = localRoamSearchDialog.k + 1;
    localRoamSearchDialog.k = paramInt;
    paramAbsListView.a(str1, str2, 5, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
    this.b = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dyx
 * JD-Core Version:    0.7.0.1
 */