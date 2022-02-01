import android.os.Message;
import com.tencent.mobileqq.activity.QQIdentiferLegacy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class vnz
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  public vnz(QQIdentiferLegacy paramQQIdentiferLegacy, boolean paramBoolean) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    String str = new WeJson().toJson(new LiveStyleRequester.YTLiveStyleReq(-2.0F, "10164651"));
    Message localMessage = this.this$0.b.obtainMessage(2);
    localMessage.arg1 = 24;
    localMessage.obj = str;
    if (paramInt == 3) {
      this.this$0.b.sendMessageDelayed(localMessage, 2000L);
    }
    for (;;)
    {
      QLog.d("QQIdentiferLegacy", 1, new Object[] { "getLightInfo Failed code=", Integer.valueOf(paramInt), " tips=", paramString1, " howtofix=", paramString2, " lightRTry=", Integer.valueOf(QQIdentiferLegacy.a(this.this$0).get()) });
      return;
      this.this$0.b.sendMessage(localMessage);
    }
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "getLightInfo success, current is loading : ", Boolean.valueOf(QQIdentiferLegacy.a(this.this$0).get()) });
    paramYTLiveStyleReq.app_id = "10164651";
    paramYTLiveStyleReq = new WeJson().toJson(paramYTLiveStyleReq);
    this.this$0.b.removeMessages(2);
    paramLiveStyleResponse = this.this$0.b.obtainMessage(2);
    paramLiveStyleResponse.arg1 = 23;
    this.this$0.b.sendMessage(paramLiveStyleResponse);
    if (QQIdentiferLegacy.a(this.this$0).compareAndSet(true, true)) {}
    do
    {
      return;
      QQIdentiferLegacy.a(this.this$0, paramYTLiveStyleReq, this.aZt);
    } while (!QLog.isColorLevel());
    QLog.d("QQIdentiferLegacy", 2, "getLightInfo success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnz
 * JD-Core Version:    0.7.0.1
 */