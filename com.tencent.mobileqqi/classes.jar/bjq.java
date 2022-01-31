import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class bjq
  implements BusinessObserver
{
  public bjq(AccountDetailActivity paramAccountDetailActivity) {}
  
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
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
        localUnFollowResponse.mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "unfollow success");
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          AccountDetailActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          paramBundle = new Intent();
          paramBundle.putExtra("isNeedFinish", true);
          this.a.setResult(-1, paramBundle);
          this.a.finish();
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int);
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
 * Qualified Name:     bjq
 * JD-Core Version:    0.7.0.1
 */