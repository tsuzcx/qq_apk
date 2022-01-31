import android.view.View;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.concurrent.ConcurrentHashMap;

public class tsr
  implements ActionSheet.OnButtonClickListener
{
  public tsr(TroopAssisSettingActivity paramTroopAssisSettingActivity, int paramInt, TroopInfo paramTroopInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
      if (this.jdField_a_of_type_Int != paramInt)
      {
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getActivity())) {
          break label218;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.b.clear();
        TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Boolean.valueOf(true));
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.b();
        TroopAssistantManager.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, "P_CliOper", "Grp_msg", "", "set_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
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
      label218:
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getActivity(), 2131434794, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsr
 * JD-Core Version:    0.7.0.1
 */