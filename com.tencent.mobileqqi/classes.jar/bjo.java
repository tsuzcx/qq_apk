import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class bjo
  implements BusinessObserver
{
  public bjo(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.a(2131560545);
      }
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
        if (paramBundle != null)
        {
          mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (localGetPublicAccountDetailInfoResponse.seqno.has()) && (localGetPublicAccountDetailInfoResponse.seqno.get() != this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno)))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = localGetPublicAccountDetailInfoResponse;
              paramBundle = new AccountDetail(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
              if ((this.a.c) && (paramBundle.followType == 1))
              {
                AccountDetailActivity.b(this.a, paramBundle);
                AccountDetailActivity.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, PublicAccountChatActivity.class);
                continue;
              }
              AccountDetailActivity.c(this.a, paramBundle);
              continue;
            }
            if ((!this.a.c) || (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
              continue;
            }
            AccountDetailActivity.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, PublicAccountChatActivity.class);
            continue;
          }
          this.a.a(2131560545);
          continue;
        }
        if (this.a.jdField_a_of_type_Boolean) {
          continue;
        }
        this.a.a(2131560545);
      }
      catch (Exception paramBundle) {}
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.a(2131560545);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjo
 * JD-Core Version:    0.7.0.1
 */