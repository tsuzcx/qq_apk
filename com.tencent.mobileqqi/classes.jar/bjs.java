import android.os.Bundle;
import android.widget.Button;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class bjs
  implements BusinessObserver
{
  public bjs(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.a(2131560545);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.jdField_b_of_type_Int -= 1;
      if (this.a.jdField_b_of_type_Int == 0) {
        AccountDetailActivity.a(this.a);
      }
      this.a.jdField_a_of_type_AndroidWidgetButton.postDelayed(new bjt(this), 1000L);
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          if (this.a.d) {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_b_of_type_JavaLangString, "mp_msg_sys_12", "scan_via", 0, 0, "", "", "", this.a.e);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType = 1;
          AccountDetailActivity.b(this.a);
          AccountDetailActivity.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          AccountDetailActivity.c(this.a);
          PublicAccountManager.a().a(this.a.getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_b_of_type_JavaLangString, null, true);
          continue;
        }
        if (paramInt == 58)
        {
          this.a.a(2131560549);
          continue;
        }
        this.a.a(2131560545);
      }
      catch (Exception paramBundle) {}
      this.a.a(2131560545);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjs
 * JD-Core Version:    0.7.0.1
 */