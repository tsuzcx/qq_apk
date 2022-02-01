import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.SendMsg;
import java.util.concurrent.atomic.AtomicInteger;

public class avhq
{
  private avhs a;
  private QQAppInterface app;
  private AtomicInteger mReqestId;
  
  public avhq(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mReqestId = new AtomicInteger(1);
    this.a = new avhs(paramQQAppInterface);
  }
  
  private int a(String paramString, Bundle paramBundle, Handler paramHandler, long paramLong)
  {
    paramHandler = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      paramHandler.extraData.putAll(paramString);
    }
    int i = this.mReqestId.incrementAndGet();
    paramHandler.setRequestId(i);
    if (paramLong > 0L) {
      paramHandler.setTimeout(paramLong);
    }
    try
    {
      this.a.a(paramHandler);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public boolean C(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean a(long paramLong1, int paramInt, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return true;
  }
  
  public void eAi()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      QLog.e("QlinkServiceManager", 1, "[QLINK] QQ - PluginCommunicationHandler.getInstance failed");
      return;
    }
    localPluginCommunicationHandler.register(new avhr(this, "qlink.notify"));
  }
  
  public int f(String paramString, Bundle paramBundle)
  {
    try
    {
      int i = a(paramString, paramBundle, null, 0L);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public void nD(long paramLong) {}
  
  public void nE(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avhq
 * JD-Core Version:    0.7.0.1
 */