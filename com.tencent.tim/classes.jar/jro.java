import OnlinePushPack.SvcRespPushMsg;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.game.SensorAPIJavaScript.9.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class jro
  implements jrd.b
{
  public jro(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void a(int paramInt, SvcRespPushMsg paramSvcRespPushMsg)
  {
    if (this.this$0.v != null)
    {
      AppInterface localAppInterface = this.this$0.mRuntime.a();
      if (localAppInterface != null)
      {
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", localAppInterface.getAccount(), "OnlinePush.RespPush");
        localToServiceMsg.setNeedCallback(false);
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        int i = amzo.seq;
        amzo.seq = i + 1;
        localUniPacket.setRequestId(i);
        localUniPacket.setServantName("OnlinePush");
        localUniPacket.setFuncName("SvcRespPushMsg");
        localUniPacket.setRequestId(paramInt);
        localUniPacket.put("resp", paramSvcRespPushMsg);
        localToServiceMsg.putWupBuffer(localUniPacket.encode());
        paramSvcRespPushMsg = new NewIntent(this.this$0.v.getApplicationContext(), aefj.class);
        paramSvcRespPushMsg.putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
        localAppInterface.startServlet(paramSvcRespPushMsg);
        if (QLog.isColorLevel()) {
          QLog.d("SensorApi", 2, "reply push");
        }
      }
    }
  }
  
  public void am(int paramInt, String paramString)
  {
    String str = SensorAPIJavaScript.b.dW(String.valueOf(paramInt));
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "send data to appId=" + paramInt);
      }
      if (this.this$0.mHandler == null) {
        this.this$0.mHandler = new Handler(Looper.getMainLooper());
      }
      this.this$0.mHandler.post(new SensorAPIJavaScript.9.1(this, str, paramString));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SensorApi", 2, "appId=" + paramInt + "'s callback is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jro
 * JD-Core Version:    0.7.0.1
 */