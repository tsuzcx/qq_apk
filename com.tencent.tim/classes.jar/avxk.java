import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.plugin.PluginIntent;
import cooperation.qzone.plugin.PluginIntent.a;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class avxk
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && ((paramIntent instanceof PluginIntent)))
    {
      PluginIntent.a locala = ((PluginIntent)paramIntent).a();
      if (locala != null) {
        locala.S(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = null;
    if ((paramIntent instanceof PluginIntent))
    {
      localObject = ((PluginIntent)paramIntent).Fg;
      paramIntent = ((PluginIntent)paramIntent).Fh;
    }
    for (;;)
    {
      avxi localavxi = new avxi(getAppRuntime().getLongAccountUin(), (ArrayList)localObject, paramIntent);
      localObject = localavxi.encode();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localavxi.uniKey());
      paramPacket.putSendData(paramIntent);
      return;
      localavxi = null;
      paramIntent = (Intent)localObject;
      localObject = localavxi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxk
 * JD-Core Version:    0.7.0.1
 */