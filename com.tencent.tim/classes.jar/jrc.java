import android.content.Intent;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class jrc
  extends MSFServlet
{
  private String[] bd = { "OnlinePush.ReqPush.GameStatusPush" };
  
  public String[] getPreferSSOCommands()
  {
    return this.bd;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    jrd localjrd = SensorAPIJavaScript.getMsfToWebViewConnector();
    if (localjrd != null) {
      localjrd.g(paramIntent, paramFromServiceMsg);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GamePushServlet", 2, "WebView not connect to msf");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrc
 * JD-Core Version:    0.7.0.1
 */