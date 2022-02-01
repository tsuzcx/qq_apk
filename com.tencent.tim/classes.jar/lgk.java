import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.1;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class lgk
{
  public static void a(noz paramnoz)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new RIJImageOptMonitor.1(paramnoz), lgj.cE());
  }
  
  public static void aMb()
  {
    Object localObject = noy.a().d();
    if (localObject != null)
    {
      QLog.d("RIJImageOptMonitor", 1, "executing jobs size: " + ((CopyOnWriteArrayList)localObject).size());
      if (((CopyOnWriteArrayList)localObject).size() > 0)
      {
        localObject = ((CopyOnWriteArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("RIJImageOptMonitor", 1, new Object[] { (noz)((Iterator)localObject).next() });
        }
      }
    }
  }
  
  public static void b(noz paramnoz)
  {
    ThreadManager.post(new RIJImageOptMonitor.2(paramnoz), 2, null, true);
  }
  
  public static String[] f(String paramString)
  {
    try
    {
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramString);
      if ((arrayOfInetAddress != null) && (arrayOfInetAddress.length > 0))
      {
        String[] arrayOfString = new String[arrayOfInetAddress.length];
        int i = 0;
        for (;;)
        {
          paramString = arrayOfString;
          if (i >= arrayOfInetAddress.length) {
            break;
          }
          arrayOfString[i] = arrayOfInetAddress[i].getHostAddress();
          i += 1;
        }
        return paramString;
      }
    }
    catch (UnknownHostException paramString)
    {
      QLog.e("RIJImageOptMonitor", 1, paramString.getMessage());
      paramString = null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgk
 * JD-Core Version:    0.7.0.1
 */