import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class caf
  extends SOSOMapLBSApiListener
{
  public caf(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onLocationUpdate(): BEGIN");
    }
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    if (paramSOSOMapLBSApiResult.Address == null) {}
    for (String str = "";; str = paramSOSOMapLBSApiResult.Address)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "onLocationUpdate(): locResult=" + paramSOSOMapLBSApiResult + ", latitude=" + paramSOSOMapLBSApiResult.Latitude + ", longitude=" + paramSOSOMapLBSApiResult.Longitude + ", address=" + str);
      }
      ((EnterpriseQQHandler)BusinessCmrTmpChatPie.g(this.a).a(18)).a(this.a.a.a, paramSOSOMapLBSApiResult.Latitude, paramSOSOMapLBSApiResult.Longitude, str);
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "onLocationUpdate(): END");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     caf
 * JD-Core Version:    0.7.0.1
 */