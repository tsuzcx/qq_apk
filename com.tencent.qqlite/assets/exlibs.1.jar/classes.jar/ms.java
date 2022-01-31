import android.os.Bundle;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import mqq.observer.BusinessObserver;

public class ms
  implements BusinessObserver
{
  public ms(EnterpriseDetailActivity paramEnterpriseDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, int paramInt, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    EnterpriseDetailActivity.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity);
    if (!paramBoolean)
    {
      EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a(2131362451);
      paramBundle = this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity;
      paramBundle.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_Int == 0) {
        EnterpriseDetailActivity.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity);
      }
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.SetFunctionFlagResponse localSetFunctionFlagResponse = new mobileqq_mp.SetFunctionFlagResponse();
          localSetFunctionFlagResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localSetFunctionFlagResponse.ret_info.get()).ret_code.get() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state.set(this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData = this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.toByteArray();
            if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state_id.get() == 5)
            {
              paramBundle = this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqDataEqqDetail;
              if (!this.jdField_a_of_type_Boolean) {
                break label459;
              }
              paramInt = 1;
              paramBundle.mShowMsgFlag = paramInt;
              if (this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mShowMsgFlag == 1)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.b, "mp_msg_ziliao_4", "share_click", 0, 0, "", "", "", "");
                EnterpriseDetailActivity.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
                break;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.b, "mp_msg_ziliao_3", "share_click", 0, 0, "", "", "", "");
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state_id.get() != 3) {
              continue;
            }
            this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mIsAgreeSyncLbs = this.jdField_a_of_type_Boolean;
            this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mIsSyncLbsSelected = true;
            continue;
          }
          EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
          this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a(2131362451);
          break;
        }
        EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
        this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a(2131362451);
      }
      catch (Exception paramBundle) {}
      EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a(2131362451);
      break;
      break;
      label459:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ms
 * JD-Core Version:    0.7.0.1
 */