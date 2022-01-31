import android.support.annotation.Nullable;
import com.tencent.biz.videostory.capture.AEVideoStoryDashboardPart.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class wsq
  implements bhwg<bgxp>
{
  wsq(wsj paramwsj) {}
  
  public void a(@Nullable bgxp parambgxp)
  {
    Object localObject = bgxl.a(parambgxp);
    parambgxp = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bgxp localbgxp = (bgxp)((Iterator)localObject).next();
      wst localwst = new wst(null);
      localwst.a = localbgxp.toString();
      parambgxp.add(localwst);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, parambgxp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsq
 * JD-Core Version:    0.7.0.1
 */