import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class awzd
  implements axzv<awyu.c>
{
  awzd(awyw paramawyw) {}
  
  public void a(@Nullable awyu.c paramc)
  {
    Object localObject = awyu.a(paramc);
    paramc = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      awyu.c localc = (awyu.c)((Iterator)localObject).next();
      awyw.c localc1 = new awyw.c(null);
      localc1.mMessage = awyw.e.a(localc);
      paramc.add(localc1);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzd
 * JD-Core Version:    0.7.0.1
 */