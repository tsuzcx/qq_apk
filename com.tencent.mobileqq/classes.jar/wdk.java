import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wdk
  extends wbc
  implements vqp<wfo, wgx>
{
  public static int a = 20;
  private long c;
  
  public wfo a(int paramInt, ArrayList<vuo> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      xvv.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    wfo localwfo = new wfo();
    localwfo.c = paramInt;
    localwfo.a = paramArrayList;
    vqn.a().a(localwfo, this);
    this.c = System.currentTimeMillis();
    return localwfo;
  }
  
  public void a(@NonNull wfo paramwfo, @Nullable wgx paramwgx, @NonNull ErrorMessage paramErrorMessage)
  {
    vun localvun = (vun)vux.a(13);
    if ((paramwgx == null) || (paramErrorMessage.isFail()))
    {
      xvv.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramwgx = paramwfo.a.iterator();
    }
    while (paramwgx.hasNext())
    {
      localvun.a((vuo)paramwgx.next(), false);
      continue;
      localvun.a(paramwgx.a);
      xvv.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramwgx.a.size()), Integer.valueOf(paramwfo.a.size()) });
      paramErrorMessage = paramwfo.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        vuo localvuo = (vuo)paramErrorMessage.next();
        if (!paramwgx.a.contains(localvuo)) {
          localvun.a(localvuo, false);
        }
      }
      if (paramwfo.a.size() > paramwgx.a.size()) {
        xwa.b("home_page", "batch_watch_video", 0, paramwfo.a.size() - paramwgx.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), xwa.a(BaseApplication.getContext()) });
      }
    }
    localvun.a(paramwfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdk
 * JD-Core Version:    0.7.0.1
 */