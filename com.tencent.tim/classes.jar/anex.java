import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

public class anex
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          paramFromServiceMsg = avpf.a(paramFromServiceMsg.getWupBuffer(), new int[1]);
          if (paramFromServiceMsg != null)
          {
            if ((getAppRuntime() != null) && (getAppRuntime().getApplication() != null))
            {
              MobileQQ localMobileQQ = getAppRuntime().getApplication();
              if ((paramFromServiceMsg.map_ext == null) || (!"1".equals(paramFromServiceMsg.map_ext.get("show_feeds")))) {
                break label260;
              }
              bool = true;
              if (paramFromServiceMsg.map_ext == null)
              {
                paramIntent = null;
                avsn.h(localMobileQQ, bool, paramIntent);
              }
            }
            else
            {
              paramIntent = new Bundle();
              paramIntent.putSerializable("data", paramFromServiceMsg);
              notifyObserver(null, 1004, true, paramIntent, akln.class);
              return;
            }
            paramIntent = (String)paramFromServiceMsg.map_ext.get("title_name");
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet isSuccess false");
          }
          notifyObserver(null, 1004, false, new Bundle(), akln.class);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("QzonePublicMsgServlet", 1, paramIntent + "onReceive error");
        notifyObserver(null, 1004, false, new Bundle(), akln.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet resultcode fail.");
      }
      notifyObserver(null, 1004, false, new Bundle(), akln.class);
      if (paramFromServiceMsg != null) {}
      return;
      label260:
      boolean bool = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("key_uin", 0L);
    paramIntent = paramIntent.getStringExtra("has_photo");
    Object localObject = new HashMap();
    ((Map)localObject).put("has_photo", paramIntent);
    avpf localavpf = new avpf(l, (Map)localObject);
    localObject = localavpf.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      QLog.e("NotifyQZoneServer", 1, "onSend request encode result is null.cmd=" + localavpf.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(30000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localavpf.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anex
 * JD-Core Version:    0.7.0.1
 */