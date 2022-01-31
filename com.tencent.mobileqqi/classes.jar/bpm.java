import OnlinePushPack.SvcRespPushMsg;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.game.MSFToWebViewConnector;
import com.tencent.biz.game.MSFToWebViewConnector.IOnMsgReceiveListener;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bpm
  implements MSFToWebViewConnector.IOnMsgReceiveListener
{
  public bpm(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void a(int paramInt, SvcRespPushMsg paramSvcRespPushMsg)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null)
    {
      AppRuntime localAppRuntime = this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getAppRuntime();
      if (localAppRuntime != null)
      {
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", localAppRuntime.getAccount(), "OnlinePush.RespPush");
        localToServiceMsg.setNeedCallback(false);
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        int i = MobileQQService.c;
        MobileQQService.c = i + 1;
        localUniPacket.setRequestId(i);
        localUniPacket.setServantName("OnlinePush");
        localUniPacket.setFuncName("SvcRespPushMsg");
        localUniPacket.setRequestId(paramInt);
        localUniPacket.put("resp", paramSvcRespPushMsg);
        localToServiceMsg.putWupBuffer(localUniPacket.encode());
        paramSvcRespPushMsg = new NewIntent(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), TempServlet.class);
        paramSvcRespPushMsg.putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
        localAppRuntime.startServlet(paramSvcRespPushMsg);
        if (QLog.isColorLevel()) {
          QLog.d("SensorApi", 2, "reply push");
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    String str = SensorAPIJavaScript.jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a(String.valueOf(paramInt));
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "send data to appId=" + paramInt);
      }
      if (this.a.jdField_a_of_type_AndroidOsHandler == null) {
        this.a.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      this.a.jdField_a_of_type_AndroidOsHandler.post(new bpn(this, str, paramString));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SensorApi", 2, "appId=" + paramInt + "'s callback is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpm
 * JD-Core Version:    0.7.0.1
 */