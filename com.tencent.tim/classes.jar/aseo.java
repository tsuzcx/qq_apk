import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aseo
  extends MSFServlet
{
  protected AppRuntime mAppRuntime;
  
  private void bK(byte[] paramArrayOfByte)
  {
    asem.a().bK(paramArrayOfByte);
  }
  
  private void bL(byte[] paramArrayOfByte)
  {
    asem.a().bL(paramArrayOfByte);
  }
  
  private void bM(byte[] paramArrayOfByte)
  {
    asem.a().bM(paramArrayOfByte);
  }
  
  private void bN(byte[] paramArrayOfByte)
  {
    asem.a().bN(paramArrayOfByte);
  }
  
  private void bO(byte[] paramArrayOfByte)
  {
    asem.a().bO(paramArrayOfByte);
  }
  
  private void d(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.mAppRuntime.getAccount(), "SharpSvr.c2s");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void e(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.mAppRuntime.getAccount(), "SharpSvr.s2cack");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void f(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.mAppRuntime.getAccount(), "MultiVideo.c2s");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void g(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.mAppRuntime.getAccount(), "MultiVideo.s2cack");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void gB(String paramString, int paramInt)
  {
    asem.a().gB(paramString, paramInt);
  }
  
  private void h(Intent paramIntent, Bundle paramBundle)
  {
    int i = paramBundle.getInt("app_id");
    paramBundle = MsfMsgUtil.getGatewayIpMsg(null);
    paramBundle.setTimeout(30000L);
    paramBundle.setNeedCallback(true);
    paramBundle.setNeedRemindSlowNetwork(false);
    paramBundle.setAppId(i);
    sendToMSF(paramIntent, paramBundle);
  }
  
  private void i(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.mAppRuntime.getAccount(), "VideoCCSvc.Adaptation");
    localToServiceMsg.putWupBuffer(paramBundle);
    localToServiceMsg.setTimeout(10000L);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void j(Intent paramIntent, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramBundle.getByteArray("wup_buffer");
    paramBundle = new ToServiceMsg(null, String.valueOf(paramBundle.getLong("uin")), "CliLogSvc.UploadReq");
    paramBundle.putWupBuffer(arrayOfByte);
    paramBundle.setNeedCallback(false);
    sendToMSF(paramIntent, paramBundle);
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c" };
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mAppRuntime = getAppRuntime();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    do
    {
      return;
      paramIntent = paramFromServiceMsg.getServiceCmd();
      asev.d("VideoChannelServlet", String.format("onReceive cmd=%s", new Object[] { paramIntent }));
      if ("SharpSvr.s2c".equalsIgnoreCase(paramIntent))
      {
        bK(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("SharpSvr.c2sack".equalsIgnoreCase(paramIntent))
      {
        bL(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("MultiVideo.s2c".equalsIgnoreCase(paramIntent))
      {
        bM(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("MultiVideo.c2sack".equalsIgnoreCase(paramIntent))
      {
        bN(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if (!"cmd_getGatewayIp".equalsIgnoreCase(paramIntent)) {
        break;
      }
      paramIntent = (String)paramFromServiceMsg.getAttribute("cmd_getGatewayIp");
    } while (paramIntent == null);
    asev.d("VideoChannelServlet", String.format(">>> ip=%s", new Object[] { paramIntent }));
    gB(paramIntent, 0);
    return;
    if ("VideoCCSvc.Adaptation".equalsIgnoreCase(paramIntent))
    {
      if (paramFromServiceMsg.isSuccess())
      {
        bO(paramFromServiceMsg.getWupBuffer());
        return;
      }
      asev.e("VideoChannelServlet", String.format("onReceive get config fail, resultCode=%s", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
      return;
    }
    asev.w("VideoChannelServlet", "onReceive handle not process cmd.");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = paramIntent.getExtras();
    if (paramPacket == null) {
      return;
    }
    int i = paramPacket.getInt("req_type", -1);
    asev.d("VideoChannelServlet", String.format("onSend reqType=%s", new Object[] { Integer.valueOf(i) }));
    switch (i)
    {
    default: 
      asev.w("VideoChannelServlet", "onSend handle not define reqType.");
      return;
    case 1: 
      d(paramIntent, paramPacket);
      return;
    case 2: 
      e(paramIntent, paramPacket);
      return;
    case 3: 
      f(paramIntent, paramPacket);
      return;
    case 4: 
      g(paramIntent, paramPacket);
      return;
    case 5: 
      h(paramIntent, paramPacket);
      return;
    case 6: 
      i(paramIntent, paramPacket);
      return;
    }
    j(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aseo
 * JD-Core Version:    0.7.0.1
 */