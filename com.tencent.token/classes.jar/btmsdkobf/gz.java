package btmsdkobf;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tmsdk.base.utils.NetworkUtil;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class gz
  implements Runnable
{
  private TreeMap b = new TreeMap();
  
  private gz(da paramda) {}
  
  public Set a()
  {
    synchronized (this.b)
    {
      TreeMap localTreeMap2 = (TreeMap)this.b.clone();
      return localTreeMap2.entrySet();
    }
  }
  
  public void a(Integer paramInteger, da.a parama)
  {
    this.b.put(paramInteger, parama);
  }
  
  public void run()
  {
    boolean bool = NetworkUtil.isNetworkConnected();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!bool)
      {
        eh.f("SharkProcessProxy", da.e(this.a) + " run, 无物理网络");
        this.a.a(Process.myPid(), ((da.a)localEntry.getValue()).kC, 0, ((da.a)localEntry.getValue()).kF, null, -1000002, 0);
        eh.g("SharkProcessProxy", "[ocean]SharkProxyTaskRunnable.run(), no network: cmdId: " + ((da.a)localEntry.getValue()).kF + " retCode: " + -1000002);
        da.g(this.a).i(((da.a)localEntry.getValue()).kF, -1000002);
      }
      else if (((da.a)localEntry.getValue()).bP())
      {
        this.a.a(Process.myPid(), ((da.a)localEntry.getValue()).kC, 0, ((da.a)localEntry.getValue()).kF, null, -1000017, 0);
        eh.g("SharkProcessProxy", "[ocean][time_out]SharkProxyTaskRunnable.run(), send time out, stats by onConnnect(): cmdId: " + ((da.a)localEntry.getValue()).kF + " retCode: " + -1000017);
        da.g(this.a).i(((da.a)localEntry.getValue()).kF, -1000017);
      }
      else
      {
        eh.f("SharkProcessProxy", da.e(this.a) + " onPostToSendingProcess() mPid: " + ((da.a)localEntry.getValue()).km + " mCallerIdent: " + ((da.a)localEntry.getValue()).kG + " mIpcSeqNo: " + ((da.a)localEntry.getValue()).kC + " mPushSeqNo: " + ((da.a)localEntry.getValue()).kD + " mPushId: " + ((da.a)localEntry.getValue()).kE + " mCmdId: " + ((da.a)localEntry.getValue()).kF + " mFlag: " + ((da.a)localEntry.getValue()).kJ + " mTimeout: " + ((da.a)localEntry.getValue()).kL);
        Object localObject = Message.obtain(da.h(this.a), 0, localEntry.getValue());
        da.h(this.a).sendMessageDelayed((Message)localObject, 35000L);
        localObject = cd.a(((da.a)localEntry.getValue()).kH);
        da.g(this.a).a(((da.a)localEntry.getValue()).km, ((da.a)localEntry.getValue()).kG, ((da.a)localEntry.getValue()).kC, ((da.a)localEntry.getValue()).kD, ((da.a)localEntry.getValue()).kE, ((da.a)localEntry.getValue()).kF, (byte[])localObject, ((da.a)localEntry.getValue()).kJ, ((da.a)localEntry.getValue()).kL, ((da.a)localEntry.getValue()).kM, ((da.a)localEntry.getValue()).kN);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gz
 * JD-Core Version:    0.7.0.1
 */