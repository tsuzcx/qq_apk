import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import java.util.Iterator;
import java.util.List;

public class dc
  implements Runnable
{
  public dc(MpfileDataCenter paramMpfileDataCenter) {}
  
  public void run()
  {
    if (MpfileDataCenter.a(this.a) == null) {}
    do
    {
      return;
      localObject1 = MpfileDataCenter.a(this.a).a().a();
    } while (localObject1 == null);
    Object localObject1 = ((MpfileTaskProxy)localObject1).a().iterator();
    label39:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MpfileTaskRecord)((Iterator)localObject1).next();
      localObject2 = this.a.a((MpfileTaskRecord)localObject2);
      if (!this.a.a((MpfileTaskInfo)localObject2)) {
        break label99;
      }
      ((MpfileTaskInfo)localObject2).g = MpfileTaskInfo.c;
    }
    for (;;)
    {
      this.a.a.a((MpfileTaskInfo)localObject2);
      break label39;
      break;
      label99:
      if (this.a.b((MpfileTaskInfo)localObject2)) {
        ((MpfileTaskInfo)localObject2).g = MpfileTaskInfo.d;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dc
 * JD-Core Version:    0.7.0.1
 */