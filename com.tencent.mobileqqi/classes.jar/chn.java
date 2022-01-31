import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class chn
  extends SOSOMapLBSApiListener
{
  public chn(ChatForEnterpriseActivity paramChatForEnterpriseActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.ChatForEnterpriseActivity", 2, "onLocationUpdate(): BEGIN");
    }
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    if (paramSOSOMapLBSApiResult.Address == null) {}
    for (String str = "";; str = paramSOSOMapLBSApiResult.Address)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.ChatForEnterpriseActivity", 2, "onLocationUpdate(): locResult=" + paramSOSOMapLBSApiResult + ", latitude=" + paramSOSOMapLBSApiResult.Latitude + ", longitude=" + paramSOSOMapLBSApiResult.Longitude + ", address=" + str);
      }
      ((EnterpriseQQHandler)this.a.b.a(20)).a(this.a.a.a, paramSOSOMapLBSApiResult.Latitude, paramSOSOMapLBSApiResult.Longitude, str);
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.ChatForEnterpriseActivity", 2, "onLocationUpdate(): END");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chn
 * JD-Core Version:    0.7.0.1
 */