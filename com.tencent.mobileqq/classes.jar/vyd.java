import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class vyd
  implements BusinessObserver
{
  public vyd(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "success:" + String.valueOf(paramBoolean));
    }
    int k = 1;
    paramInt = 1;
    int j;
    if (!paramBoolean)
    {
      this.a.w(2131430033);
      j = paramInt;
    }
    for (;;)
    {
      if (j != 0) {
        this.a.aY();
      }
      return;
      j = paramInt;
      if (!paramBoolean) {
        continue;
      }
      int i = k;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        j = paramInt;
        if (paramBundle == null) {
          continue;
        }
        i = k;
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        i = k;
        localFollowResponse.mergeFrom(paramBundle);
        i = k;
        j = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (j == 0)
        {
          i = k;
          PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "", false);
          i = k;
          paramBundle = (PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if (paramBundle != null)
          {
            i = k;
            paramBundle = paramBundle.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
            if (paramBundle != null)
            {
              i = k;
              if (this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null)
              {
                i = k;
                this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
              }
              i = k;
              this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(paramBundle);
              paramInt = 1;
              break label483;
            }
          }
        }
        label483:
        for (;;)
        {
          i = paramInt;
          this.a.O = true;
          i = paramInt;
          this.a.T = true;
          i = paramInt;
          this.a.aZ();
          j = paramInt;
          i = paramInt;
          if (!this.a.ai) {
            break;
          }
          j = paramInt;
          i = paramInt;
          if (PublicAccountChatPie.a(this.a) == null) {
            break;
          }
          i = paramInt;
          PublicAccountChatPie.b(this.a).b();
          j = paramInt;
          break;
          i = k;
          this.a.x();
          paramInt = 0;
          break label483;
          i = k;
          this.a.x();
          paramInt = 0;
          continue;
          if (j == 58)
          {
            i = k;
            this.a.w(2131430041);
            j = paramInt;
            break;
          }
          if (j == 65)
          {
            i = k;
            this.a.w(2131430042);
            j = paramInt;
            break;
          }
          i = k;
          this.a.w(2131430033);
          j = paramInt;
          break;
        }
      }
      catch (Exception paramBundle)
      {
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyd
 * JD-Core Version:    0.7.0.1
 */