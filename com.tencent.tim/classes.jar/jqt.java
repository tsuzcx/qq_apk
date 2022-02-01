import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class jqt
  implements BusinessObserver
{
  jqt(Context paramContext, QQAppInterface paramQQAppInterface, arhz paramarhz, SessionInfo paramSessionInfo, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "success:" + String.valueOf(paramBoolean));
    }
    mobileqq_mp.GetEqqAccountDetailInfoResponse localGetEqqAccountDetailInfoResponse;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localGetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      }
    }
    for (;;)
    {
      try
      {
        localGetEqqAccountDetailInfoResponse.mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)localGetEqqAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
        {
          paramBundle = new EqqDetail(localGetEqqAccountDetailInfoResponse);
          jqs.a(this.val$app, paramBundle);
          jqs.b(this.i);
          if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, "<<<end getDetail, ts=" + System.currentTimeMillis());
          }
          jqs.b(this.val$app, this.val$context, this.a, null, paramBundle, this.Uc);
          jqs.b(this.i);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        jqs.K(this.val$context, 2131697432);
        anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
        jqs.b(this.i);
        return;
      }
      jqs.K(this.val$context, 2131697432);
      anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
      continue;
      jqs.K(this.val$context, 2131697432);
      anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
      continue;
      jqs.K(this.val$context, 2131697432);
      anot.a(this.val$app, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqt
 * JD-Core Version:    0.7.0.1
 */