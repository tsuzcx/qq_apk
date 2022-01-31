import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.ActionSheet;

public class dbz
  implements IphonePickerView.IphonePickListener
{
  public dbz(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a()
  {
    if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.c == 0)
    {
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchFriendActivity.jdField_b_of_type_ArrayOfJavaLangString[paramInt2]);
      this.a.jdField_b_of_type_Int = paramInt2;
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchFriendActivity.jdField_a_of_type_ArrayOfJavaLangString[paramInt2]);
    this.a.jdField_a_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbz
 * JD-Core Version:    0.7.0.1
 */