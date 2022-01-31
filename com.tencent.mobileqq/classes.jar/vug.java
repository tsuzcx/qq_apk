import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class vug
  implements BusinessObserver
{
  public vug(PublicAccountChatPie paramPublicAccountChatPie, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.w(2131430016);
    }
    for (;;)
    {
      PublicAccountChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie);
      if (PublicAccountChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie) == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.aY();
      }
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "unfollow success");
            }
            PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie, PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie));
            PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
            StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            PublicAccountChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie, false);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.w(2131430016);
          }
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vug
 * JD-Core Version:    0.7.0.1
 */