package mqq.app;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MSFServlet
  extends Servlet
{
  public static final AtomicInteger appSeqFactory = new AtomicInteger();
  public static final String tag = "MSFServlet";
  private Map<Integer, Intent> mIntents = new ConcurrentHashMap();
  
  protected <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    return Packet.decodePacket(paramArrayOfByte, paramString, paramT);
  }
  
  public String[] getPreferSSOCommands()
  {
    return null;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  Intent onReceive(FromServiceMsg paramFromServiceMsg)
  {
    Intent localIntent = (Intent)this.mIntents.remove(Integer.valueOf(paramFromServiceMsg.getAppSeq()));
    onReceive(localIntent, paramFromServiceMsg);
    return localIntent;
  }
  
  public abstract void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onSend(Intent paramIntent, Packet paramPacket);
  
  Intent removeRequest(int paramInt)
  {
    return (Intent)this.mIntents.remove(Integer.valueOf(paramInt));
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.setAppSeq(appSeqFactory.incrementAndGet());
    if ((paramToServiceMsg.isNeedCallback()) && (paramIntent != null)) {
      this.mIntents.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramIntent);
    }
    getAppRuntime().getService().sendMessageToMSF(paramToServiceMsg, this);
  }
  
  public void service(Intent paramIntent)
  {
    Object localObject = new Packet(getAppRuntime().getAccount());
    onSend(paramIntent, (Packet)localObject);
    localObject = ((Packet)localObject).toMsg();
    if (localObject != null) {
      sendToMSF(paramIntent, (ToServiceMsg)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.MSFServlet
 * JD-Core Version:    0.7.0.1
 */