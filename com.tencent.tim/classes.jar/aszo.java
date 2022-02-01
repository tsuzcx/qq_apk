import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class aszo
{
  private static ConcurrentHashMap<String, aszo.a> jH = new ConcurrentHashMap();
  
  public static void a(String paramString, aszo.a parama)
  {
    if ((paramString != null) && (parama != null)) {
      jH.put(paramString, parama);
    }
  }
  
  public static boolean c(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString == null) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface == null) {
      return false;
    }
    paramString = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    localQQAppInterface.sendToService(paramString);
    return true;
  }
  
  public static void lH(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null)
    {
      Object localObject = paramFromServiceMsg.getServiceCmd();
      localObject = (aszo.a)jH.get(localObject);
      if (localObject != null) {
        ((aszo.a)localObject).lG(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void lG(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszo
 * JD-Core Version:    0.7.0.1
 */