import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class avtb
  implements ThreadPool.Job<Object>
{
  avtb(avsx paramavsx, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = avsx.a(this.b).collect();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (avsw)paramJobContext.next();
        int i = ((avsw)localObject).getCapacity(this.val$externalStorage);
        localObject = ((avsw)localObject).sD();
        this.b.gT((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtb
 * JD-Core Version:    0.7.0.1
 */