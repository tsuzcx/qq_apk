import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.ActionSheet;

public class awh
  implements IphonePickerView.IphonePickListener
{
  public awh(NearPeopleFilterActivity paramNearPeopleFilterActivity) {}
  
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
    if (this.a.i == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.a[paramInt2]);
      this.a.c = paramInt2;
      return;
    }
    this.a.b.setRightText(com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.b[paramInt2]);
    this.a.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awh
 * JD-Core Version:    0.7.0.1
 */