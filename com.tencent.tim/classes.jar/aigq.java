import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class aigq
  extends accg
{
  private Map<Integer, CommonCallback> lu = new HashMap();
  private AtomicInteger mSeq = new AtomicInteger(0);
  
  public aigq(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, CommonCallback<Bundle> paramCommonCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.w("NowChannerHandler", 2, "send serviceName = " + paramString1 + " to SSO Service");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceCmd", paramString2);
    acct.ad();
    acct.b(paramString2, new int[] { 145 });
    paramString1 = new ToServiceMsg(paramString1, getCurrentAccountUin(), paramString2);
    paramString1.putWupBuffer(paramArrayOfByte);
    paramString1.setAttributes(localHashMap);
    paramString1.setTimeout(15000L);
    sendPbReq(paramString1);
    int i = this.mSeq.incrementAndGet();
    paramString1.setRequestSsoSeq(i);
    this.lu.put(Integer.valueOf(i), paramCommonCallback);
  }
  
  public void jG(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowChannerHandler", 2, "handleLiveFeedNearbyAnchor req == null || res == null");
      }
      return;
    }
    CommonCallback localCommonCallback = (CommonCallback)this.lu.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("BUFFER", (byte[])paramObject);
    localBundle.putInt("BIZCODE", 0);
    localBundle.putString("ERRMSG", paramFromServiceMsg.getBusinessFailMsg());
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      localBundle.putInt("CHANNELCODE", i);
      localBundle.putString("serviceCmd", (String)paramToServiceMsg.getAttribute("serviceCmd"));
      if (localCommonCallback == null) {
        break;
      }
      localCommonCallback.onResult(localBundle);
      return;
      i = -1;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aigp.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("NowChannerHandler", 2, "onReceive-----serviceName = " + paramToServiceMsg.getServiceName() + ", serviceCmd = " + paramToServiceMsg.getServiceCmd());
    }
    jG(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigq
 * JD-Core Version:    0.7.0.1
 */