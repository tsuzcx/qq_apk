import MessageSvcPack.RequestPushStatus;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.msf.service.protocol.push.SvcReqSetToken;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class andl
  extends swr
{
  private static final String[] gx = { "Push", "PushService" };
  private aefh c;
  
  private Object ax(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg.getWupBuffer() == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object ay(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespSetToken)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespSetToken", new SvcRespSetToken());
  }
  
  private boolean bk(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SvcReqSetToken localSvcReqSetToken = new SvcReqSetToken();
    String str = paramToServiceMsg.extraData.getString("push_token");
    try
    {
      localSvcReqSetToken.vNewToken = str.getBytes("utf-8");
      localSvcReqSetToken.bEnterVersion = 18;
      localSvcReqSetToken.bPushMsg = 1;
      localSvcReqSetToken.bPushWithoutContent = paramToServiceMsg.extraData.getByte("show_content");
      paramUniPacket.put("SvcReqSetToken", localSvcReqSetToken);
      paramUniPacket.setServantName("PushService");
      paramUniPacket.setFuncName("SvcReqSetToken");
      if (QLog.isColorLevel()) {
        QLog.d("PushService", 2, "handleReqSetPushToken showContent:" + localSvcReqSetToken.bPushWithoutContent);
      }
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equals("MessageSvc.PushNotify")) {
      return ax(paramToServiceMsg, paramFromServiceMsg);
    }
    if (str.equalsIgnoreCase("PushService.SetToken")) {
      return ay(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a(aefh paramaefh)
  {
    this.c = paramaefh;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("PushService.SetToken")) {
      return bk(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public void destroy() {}
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equals("MessageSvc.RequestPushStatus"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatusPush", 2, "decodeRespMsg MessageSvc.RequestPushStatus uin:" + paramFromServiceMsg.getUin() + " at " + System.currentTimeMillis());
      }
      paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramToServiceMsg != null) {}
    }
    do
    {
      do
      {
        return;
        paramFromServiceMsg = new UniPacket();
        paramFromServiceMsg.decode(paramToServiceMsg);
        paramToServiceMsg = (RequestPushStatus)paramFromServiceMsg.getByClass("req_PushStatus", new RequestPushStatus());
        paramFromServiceMsg = BaseApplication.getContext().getSharedPreferences("share", 0);
        if (paramToServiceMsg.cStatus == 1)
        {
          paramFromServiceMsg.edit().putBoolean("is_pc_online" + paramToServiceMsg.lUin, true).commit();
          return;
        }
        paramFromServiceMsg.edit().putBoolean("is_pc_online" + paramToServiceMsg.lUin, false).commit();
        return;
        if (!"CliNotifySvc.register".equals(str)) {
          break;
        }
      } while ((!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.extraData.getLong("pushId") != 128L));
      return;
      if ("baseSdk.Msf.NotifyResp".equals(str))
      {
        paramToServiceMsg = new Intent("tencent.notify.album");
        paramToServiceMsg.putExtra("resp", paramFromServiceMsg);
        BaseApplication.getContext().sendBroadcast(paramToServiceMsg, "com.tencent.tim.msg.permission.pushnotify");
        return;
      }
      if ("PushService.SetToken".equalsIgnoreCase(str))
      {
        ay(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      paramToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    } while (this.c == null);
    this.c.onRecvResp(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public String[] y()
  {
    return gx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andl
 * JD-Core Version:    0.7.0.1
 */