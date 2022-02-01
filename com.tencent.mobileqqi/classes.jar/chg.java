import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class chg
  implements CompoundButton.OnCheckedChangeListener
{
  public chg(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, DiscussionInfo paramDiscussionInfo) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramCompoundButton = DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      return;
    }
    label93:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131562883);
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).setContentDescription(paramCompoundButton);
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasCollect)) {
        break label158;
      }
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).e(Long.valueOf(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity)).longValue());
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.b;
      if (!paramBoolean) {
        break label198;
      }
    }
    label158:
    label198:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, paramCompoundButton, "", "", "");
      return;
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131562883);
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).setContentDescription(paramCompoundButton);
      break;
      if ((paramBoolean) || (!this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasCollect)) {
        break label93;
      }
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).f(Long.valueOf(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity)).longValue());
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chg
 * JD-Core Version:    0.7.0.1
 */