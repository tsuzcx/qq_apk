import android.view.View;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Map;

public class doc
  implements ActionSheet.OnButtonClickListener
{
  public doc(TroopAssisSettingActivity paramTroopAssisSettingActivity, int paramInt, TroopInfo paramTroopInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
      if (this.jdField_a_of_type_Int != paramInt)
      {
        if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.a())) {
          break label201;
        }
        TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.b, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_JavaUtilMap);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.e();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.b, "P_CliOper", "Grp_msg", "", "set_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramInt = 1;
      break;
      paramInt = 4;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      label201:
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.a(), 2131562449, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     doc
 * JD-Core Version:    0.7.0.1
 */