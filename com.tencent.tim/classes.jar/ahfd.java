import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.channel.model.RequestPacket;
import com.tencent.mobileqq.flutter.channel.model.ResponsePacket;
import com.tencent.mobileqq.flutter.channel.sso.SSOChannel.2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class ahfd
  extends aheu
{
  public static final AtomicInteger bn = new AtomicInteger();
  private Map<Integer, MethodChannel.Result> kO = new ConcurrentHashMap();
  
  public ahfd(String paramString, BinaryMessenger paramBinaryMessenger)
  {
    super(paramString, paramBinaryMessenger);
  }
  
  private void a(RequestPacket paramRequestPacket, MethodChannel.Result paramResult)
  {
    if ((paramRequestPacket == null) || (paramResult == null)) {
      QLog.d("QFlutter.SSOChannel", 1, "send request, packet == null or result == null");
    }
    int i;
    do
    {
      return;
      i = bn.incrementAndGet();
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", c().getAccount(), paramRequestPacket.cmd);
      localToServiceMsg.setTimeout(paramRequestPacket.timeout.intValue() * 1000L);
      localToServiceMsg.extraData.putLong("REQUEST_TIME", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("FLUTTER_REQUEST_SEQ", i);
      this.kO.put(Integer.valueOf(i), paramResult);
      localToServiceMsg.putWupBuffer(paramRequestPacket.body);
      paramResult = new NewIntent(c().getApplication(), ahfc.class);
      paramResult.putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
      c().startServlet(paramResult);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.SSOChannel", 2, String.format("send request cmd: %s, request seq: %s", new Object[] { paramRequestPacket.cmd, Integer.valueOf(i) }));
  }
  
  public MethodChannel.MethodCallHandler a()
  {
    return new ahfe(this);
  }
  
  public MethodCodec a()
  {
    return ahff.a;
  }
  
  public void a(String paramString, ResponsePacket paramResponsePacket, MethodChannel.Result paramResult)
  {
    ThreadManager.getUIHandler().post(new SSOChannel.2(this, paramResponsePacket, paramString, paramResult));
  }
  
  public void aL(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      QLog.d("QFlutter.SSOChannel", 1, "onReceive, request is null");
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramToServiceMsg.extraData.getLong("REQUEST_TIME");
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.SSOChannel", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errCode: %s", new Object[] { paramToServiceMsg.getServiceCmd(), Integer.valueOf(paramToServiceMsg.getAppSeq()), Long.valueOf(l1 - l2), Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
    }
    byte[] arrayOfByte = paramFromServiceMsg.getWupBuffer();
    ResponsePacket localResponsePacket = new ResponsePacket();
    localResponsePacket.isSuc = Boolean.valueOf(paramFromServiceMsg.isSuccess());
    localResponsePacket.errCode = Integer.valueOf(paramFromServiceMsg.getResultCode());
    localResponsePacket.body = arrayOfByte;
    int i = paramToServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
    paramFromServiceMsg = (MethodChannel.Result)this.kO.remove(Integer.valueOf(i));
    a(paramToServiceMsg.getServiceCmd(), localResponsePacket, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfd
 * JD-Core Version:    0.7.0.1
 */