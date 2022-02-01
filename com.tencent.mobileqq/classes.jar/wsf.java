import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wsf
  extends wpx
  implements wfk<wuj, wvs>
{
  public static int a = 20;
  private long c;
  
  public wuj a(int paramInt, ArrayList<wjj> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      ykq.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    wuj localwuj = new wuj();
    localwuj.c = paramInt;
    localwuj.a = paramArrayList;
    wfi.a().a(localwuj, this);
    this.c = System.currentTimeMillis();
    return localwuj;
  }
  
  public void a(@NonNull wuj paramwuj, @Nullable wvs paramwvs, @NonNull ErrorMessage paramErrorMessage)
  {
    wji localwji = (wji)wjs.a(13);
    if ((paramwvs == null) || (paramErrorMessage.isFail()))
    {
      ykq.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramwvs = paramwuj.a.iterator();
    }
    while (paramwvs.hasNext())
    {
      localwji.a((wjj)paramwvs.next(), false);
      continue;
      localwji.a(paramwvs.a);
      ykq.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramwvs.a.size()), Integer.valueOf(paramwuj.a.size()) });
      paramErrorMessage = paramwuj.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        wjj localwjj = (wjj)paramErrorMessage.next();
        if (!paramwvs.a.contains(localwjj)) {
          localwji.a(localwjj, false);
        }
      }
      if (paramwuj.a.size() > paramwvs.a.size()) {
        ykv.b("home_page", "batch_watch_video", 0, paramwuj.a.size() - paramwvs.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), ykv.a(BaseApplication.getContext()) });
      }
    }
    localwji.a(paramwuj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsf
 * JD-Core Version:    0.7.0.1
 */