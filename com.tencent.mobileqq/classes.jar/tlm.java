import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tlm
  extends tje
  implements syq<tnq, toz>
{
  public static int a = 20;
  private long c;
  
  public tnq a(int paramInt, ArrayList<tcq> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      ved.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    tnq localtnq = new tnq();
    localtnq.c = paramInt;
    localtnq.a = paramArrayList;
    syo.a().a(localtnq, this);
    this.c = System.currentTimeMillis();
    return localtnq;
  }
  
  public void a(@NonNull tnq paramtnq, @Nullable toz paramtoz, @NonNull ErrorMessage paramErrorMessage)
  {
    tcp localtcp = (tcp)tcz.a(13);
    if ((paramtoz == null) || (paramErrorMessage.isFail()))
    {
      ved.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramtoz = paramtnq.a.iterator();
    }
    while (paramtoz.hasNext())
    {
      localtcp.a((tcq)paramtoz.next(), false);
      continue;
      localtcp.a(paramtoz.a);
      ved.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramtoz.a.size()), Integer.valueOf(paramtnq.a.size()) });
      paramErrorMessage = paramtnq.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        tcq localtcq = (tcq)paramErrorMessage.next();
        if (!paramtoz.a.contains(localtcq)) {
          localtcp.a(localtcq, false);
        }
      }
      if (paramtnq.a.size() > paramtoz.a.size()) {
        vei.b("home_page", "batch_watch_video", 0, paramtnq.a.size() - paramtoz.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), vei.a(BaseApplication.getContext()) });
      }
    }
    localtcp.a(paramtnq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlm
 * JD-Core Version:    0.7.0.1
 */