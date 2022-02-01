import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class jqu
  implements BusinessObserver
{
  jqu(Context paramContext, QQAppInterface paramQQAppInterface, arhz paramarhz, EqqDetail paramEqqDetail, SessionInfo paramSessionInfo, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "success:" + String.valueOf(paramBoolean));
    }
    mobileqq_mp.FollowResponse localFollowResponse;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localFollowResponse = new mobileqq_mp.FollowResponse();
      }
    }
    for (;;)
    {
      try
      {
        localFollowResponse.mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType = 1;
          jqs.a(this.val$app, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          paramBundle = (PublicAccountHandler)this.val$app.getBusinessHandler(11);
          if (paramBundle != null) {
            paramBundle.bb(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, "<<<end follow, ts=" + System.currentTimeMillis());
          }
          jqs.c(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Uc);
          afrx.a(this.val$app).i(this.val$app, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, true);
          jqs.b(this.i);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        jqs.K(this.val$context, 2131697432);
        anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        jqs.b(this.i);
        return;
      }
      if (paramInt == 58)
      {
        jqs.K(this.val$context, 2131697429);
        anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "PublicAccount_max_limit_false", 0, 0, "", "", "", "");
      }
      else if (paramInt == 65)
      {
        jqs.K(this.val$context, 2131697402);
      }
      else if (paramInt == 20)
      {
        jqs.K(this.val$context, 2131697403);
      }
      else
      {
        jqs.K(this.val$context, 2131697432);
        anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        continue;
        jqs.K(this.val$context, 2131697432);
        anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        continue;
        jqs.K(this.val$context, 2131697432);
        anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqu
 * JD-Core Version:    0.7.0.1
 */