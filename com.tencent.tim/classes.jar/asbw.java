import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.wadl.WadlConfigCenter.1;
import java.util.HashMap;

public class asbw
{
  private static volatile asbw a;
  private static final byte[] lock = new byte[0];
  private HashMap<String, asbu> pT = new HashMap();
  
  private asbw()
  {
    loadConfig();
    GameCenterReceiver.registerReceiver();
  }
  
  public static asbw a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new asbw();
      }
      return a;
    }
  }
  
  public void loadConfig()
  {
    ThreadManagerV2.executeOnFileThread(new WadlConfigCenter.1(this));
  }
  
  public <T> T w(String paramString)
  {
    return this.pT.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbw
 * JD-Core Version:    0.7.0.1
 */