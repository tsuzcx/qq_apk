import android.widget.EditText;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.widget.ActionSheet;

public class aym
  implements IphonePickerView.IphonePickListener
{
  public aym(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    NearbyPeopleProfileActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).setTag(Byte.valueOf((byte)(i + 1)));
    NearbyPeopleProfileActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).setText(NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).a(0, i));
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aym
 * JD-Core Version:    0.7.0.1
 */