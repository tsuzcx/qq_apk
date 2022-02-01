import KQQ.PluginInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class anee
  extends MSFServlet
{
  private long receiveTime;
  private long sendTime;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterServlet", 2, "recieve flag from server.");
    }
    paramIntent = (QQAppInterface)getAppRuntime();
    this.receiveTime = System.currentTimeMillis();
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      localObject = anas.c(paramFromServiceMsg.getWupBuffer());
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramFromServiceMsg = (anec)paramIntent.getManager(12);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.at((List)localObject);
          paramFromServiceMsg = new Bundle();
          paramFromServiceMsg.putBoolean("new", ((PluginInfo)((List)localObject).get(0)).Flag);
          paramFromServiceMsg.putInt("gc_notify_type", 2);
          notifyObserver(null, 10000, true, paramFromServiceMsg, aklk.class);
          QLog.e("Q.lebatab.GameCenterServlet", 2, "[red dot] 1");
          if (paramIntent != null)
          {
            paramFromServiceMsg = new HashMap();
            anpc.a(paramIntent.getApp()).collectPerformance(paramIntent.getCurrentAccountUin(), "actPluginUnread", true, this.receiveTime - this.sendTime, 0L, paramFromServiceMsg, "");
          }
        }
      }
      else if (paramIntent != null)
      {
        paramFromServiceMsg = "|wufbuf: " + aqhs.bytes2HexStr(paramFromServiceMsg.getWupBuffer());
        localObject = new HashMap();
        ((HashMap)localObject).put("param_FailCode", String.valueOf(9045));
        ((HashMap)localObject).put("param_errorDesc", paramFromServiceMsg);
        anpc.a(paramIntent.getApp()).collectPerformance(paramIntent.getCurrentAccountUin(), "actPluginUnread", false, this.receiveTime - this.sendTime, 0L, (HashMap)localObject, "");
      }
    }
    for (;;)
    {
      paramIntent = new Bundle();
      paramIntent.putInt("gc_notify_type", 2);
      notifyObserver(null, 10000, false, paramIntent, aklk.class);
      return;
      if (paramIntent != null)
      {
        paramFromServiceMsg = "|resultcode: " + paramFromServiceMsg.getResultCode() + "|reason: " + MessageHandler.b(paramFromServiceMsg);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_FailCode", String.valueOf(9311));
        ((HashMap)localObject).put("param_errorDesc", paramFromServiceMsg);
        anpc.a(paramIntent.getApp()).collectPerformance(paramIntent.getCurrentAccountUin(), "actPluginUnread", false, this.receiveTime - this.sendTime, 0L, (HashMap)localObject, "");
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getAction();
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("gc_pluginid_list");
    if ((str != null) && (str.equals("gc_get_newandunreadmsg"))) {
      anas.a(paramPacket, paramIntent);
    }
    this.sendTime = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterServlet", 2, "send get flag request.");
    }
  }
  
  public void service(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((str != null) && ("gc_refresh_ui".equals(str)))
    {
      int i = paramIntent.getIntExtra("gc_notify_type", 0);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putInt("gc_notify_type", i);
      notifyObserver(null, 10000, true, paramIntent, aklk.class);
      paramIntent = new Intent("com.tencent.redpoint.broadcast.push.av");
      BaseApplication.getContext().sendBroadcast(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterServlet", 2, "[red dot] game center send broadcast");
      }
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anee
 * JD-Core Version:    0.7.0.1
 */