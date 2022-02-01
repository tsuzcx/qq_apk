import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wxz
  extends wvr
  implements wld<xad, xbm>
{
  public static int a = 20;
  private long c;
  
  public xad a(int paramInt, ArrayList<wpd> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      yqp.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    xad localxad = new xad();
    localxad.c = paramInt;
    localxad.a = paramArrayList;
    wlb.a().a(localxad, this);
    this.c = System.currentTimeMillis();
    return localxad;
  }
  
  public void a(@NonNull xad paramxad, @Nullable xbm paramxbm, @NonNull ErrorMessage paramErrorMessage)
  {
    wpc localwpc = (wpc)wpm.a(13);
    if ((paramxbm == null) || (paramErrorMessage.isFail()))
    {
      yqp.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramxbm = paramxad.a.iterator();
    }
    while (paramxbm.hasNext())
    {
      localwpc.a((wpd)paramxbm.next(), false);
      continue;
      localwpc.a(paramxbm.a);
      yqp.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramxbm.a.size()), Integer.valueOf(paramxad.a.size()) });
      paramErrorMessage = paramxad.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        wpd localwpd = (wpd)paramErrorMessage.next();
        if (!paramxbm.a.contains(localwpd)) {
          localwpc.a(localwpd, false);
        }
      }
      if (paramxad.a.size() > paramxbm.a.size()) {
        yqu.b("home_page", "batch_watch_video", 0, paramxad.a.size() - paramxbm.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), yqu.a(BaseApplication.getContext()) });
      }
    }
    localwpc.a(paramxad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxz
 * JD-Core Version:    0.7.0.1
 */