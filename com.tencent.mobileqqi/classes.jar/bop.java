import android.os.Bundle;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class bop
  implements BusinessObserver
{
  public bop(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
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
      paramBundle.jdField_a_of_type_Int -= 1;
      if (this.a.jdField_a_of_type_Int == 0) {
        EnterpriseDetailActivity.b(this.a);
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
          this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          EnterpriseDetailActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.b, 0);
          EnterpriseDetailActivity.a(this.a);
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
 * Qualified Name:     bop
 * JD-Core Version:    0.7.0.1
 */