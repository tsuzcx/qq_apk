import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class xwv
  implements BusinessObserver
{
  xwv(xwq paramxwq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "success:" + String.valueOf(paramBoolean));
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
        paramInt = ((mobileqq_mp.RetInfo)localGetEqqAccountDetailInfoResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          paramBundle = new EqqDetail(localGetEqqAccountDetailInfoResponse);
          jqs.a(this.a.app, paramBundle);
          this.a.b = PublicAccountInfo.createPublicAccount(paramBundle, 0L);
          xwq.a(this.a, paramBundle);
          this.a.bo(this.a.mActivity.getIntent());
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail ret code error: " + paramInt);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle) {}
      if (QLog.isColorLevel())
      {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail data is null");
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail isSuccess is null");
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwv
 * JD-Core Version:    0.7.0.1
 */