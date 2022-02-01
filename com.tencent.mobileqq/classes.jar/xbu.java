import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xbu
  extends wzm
  implements woy<xdy, xfh>
{
  public static int a = 20;
  private long c;
  
  public xdy a(int paramInt, ArrayList<wsy> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      yuk.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    xdy localxdy = new xdy();
    localxdy.c = paramInt;
    localxdy.a = paramArrayList;
    wow.a().a(localxdy, this);
    this.c = System.currentTimeMillis();
    return localxdy;
  }
  
  public void a(@NonNull xdy paramxdy, @Nullable xfh paramxfh, @NonNull ErrorMessage paramErrorMessage)
  {
    wsx localwsx = (wsx)wth.a(13);
    if ((paramxfh == null) || (paramErrorMessage.isFail()))
    {
      yuk.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramxfh = paramxdy.a.iterator();
    }
    while (paramxfh.hasNext())
    {
      localwsx.a((wsy)paramxfh.next(), false);
      continue;
      localwsx.a(paramxfh.a);
      yuk.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramxfh.a.size()), Integer.valueOf(paramxdy.a.size()) });
      paramErrorMessage = paramxdy.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        wsy localwsy = (wsy)paramErrorMessage.next();
        if (!paramxfh.a.contains(localwsy)) {
          localwsx.a(localwsy, false);
        }
      }
      if (paramxdy.a.size() > paramxfh.a.size()) {
        yup.b("home_page", "batch_watch_video", 0, paramxdy.a.size() - paramxfh.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), yup.a(BaseApplication.getContext()) });
      }
    }
    localwsx.a(paramxdy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbu
 * JD-Core Version:    0.7.0.1
 */