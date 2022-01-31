import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class gso
  implements ActionSheet.OnButtonClickListener
{
  public gso(TroopBarPublishActivity paramTroopBarPublishActivity, int paramInt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_c_of_type_AndroidWidgetTextView.setText(2131560729);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.getString(2131558493));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b();
      return;
      if (paramInt < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a = ((TroopBarPageEntity.TypeListEntity)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_c_of_type_JavaUtilArrayList.get(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a.name);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_c_of_type_AndroidWidgetTextView.setSelected(true);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.getString(2131558494, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a.name }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gso
 * JD-Core Version:    0.7.0.1
 */