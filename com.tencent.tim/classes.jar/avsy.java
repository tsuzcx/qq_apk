import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class avsy
  implements ThreadPool.Job<Object>
{
  avsy(avsx paramavsx, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = avsx.a(this.b).collect();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        avsw localavsw = (avsw)paramJobContext.next();
        int j = localavsw.getCapacity(this.val$externalStorage);
        String str = localavsw.sD();
        int i = avsx.a(this.b, str);
        j = avsx.a(this.b, j, i);
        this.b.R(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localavsw + ": remain=" + j);
      }
      if (avsx.tA(avsu.Gw()))
      {
        avsu.WL(false);
        if (avsx.tA(avsu.Gw()))
        {
          avsu.WL(true);
          avsx.a(this.b);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsy
 * JD-Core Version:    0.7.0.1
 */