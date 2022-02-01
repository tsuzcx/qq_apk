import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import java.util.concurrent.atomic.AtomicBoolean;

final class aiam
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  aiam(int paramInt, AtomicBoolean paramAtomicBoolean, String paramString1, String paramString2, String paramString3, long paramLong, aiak.a parama) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new WeJson();
    LiveStyleRequester.YTLiveStyleReq localYTLiveStyleReq = new LiveStyleRequester.YTLiveStyleReq(-2.0F, String.valueOf(101810106));
    localYTLiveStyleReq.app_id = String.valueOf(101810106);
    localObject = ((WeJson)localObject).toJson(localYTLiveStyleReq);
    this.df.set(true);
    aiak.b(101810106, this.val$key, this.val$method, this.val$uin, this.abg, (String)localObject, this.a);
    QLog.d("FaceLoginHelper", 1, new Object[] { "getLightInfo Failed code=", Integer.valueOf(paramInt), " tips=", paramString1, " howtofix=", paramString2 });
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    paramYTLiveStyleReq.app_id = String.valueOf(this.Ts);
    paramYTLiveStyleReq = new WeJson().toJson(paramYTLiveStyleReq);
    if (this.df.compareAndSet(true, true))
    {
      QLog.d("FaceLoginHelper", 1, "sendPacket isLoading now");
      return;
    }
    aiak.b(this.Ts, this.val$key, this.val$method, this.val$uin, this.abg, paramYTLiveStyleReq, this.a);
    QLog.d("FaceLoginHelper", 1, "getLightInfo success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiam
 * JD-Core Version:    0.7.0.1
 */