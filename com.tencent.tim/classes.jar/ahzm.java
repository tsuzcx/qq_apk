import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ahzm
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof AppInterface)))
    {
      if (paramIntent.getBooleanExtra("isFrom_EmoSearch", false)) {
        afhd.a((QQAppInterface)localAppRuntime).r(paramIntent, paramFromServiceMsg);
      }
    }
    else {
      return;
    }
    ahzd.a((QQAppInterface)localAppRuntime).r(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      QLog.e("HotPicServlet", 1, "onSend : req is null");
      return;
    }
    paramPacket.setSSOCommand(paramIntent.getStringExtra("key_cmd"));
    paramPacket.putSendData(paramIntent.getByteArrayExtra("key_body"));
    paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 6000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzm
 * JD-Core Version:    0.7.0.1
 */