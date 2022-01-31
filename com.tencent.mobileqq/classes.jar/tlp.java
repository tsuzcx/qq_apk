import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tlp
  extends tjh
  implements syt<tnt, tpc>
{
  public static int a = 20;
  private long c;
  
  public tnt a(int paramInt, ArrayList<tct> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      veg.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    tnt localtnt = new tnt();
    localtnt.c = paramInt;
    localtnt.a = paramArrayList;
    syr.a().a(localtnt, this);
    this.c = System.currentTimeMillis();
    return localtnt;
  }
  
  public void a(@NonNull tnt paramtnt, @Nullable tpc paramtpc, @NonNull ErrorMessage paramErrorMessage)
  {
    tcs localtcs = (tcs)tdc.a(13);
    if ((paramtpc == null) || (paramErrorMessage.isFail()))
    {
      veg.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramtpc = paramtnt.a.iterator();
    }
    while (paramtpc.hasNext())
    {
      localtcs.a((tct)paramtpc.next(), false);
      continue;
      localtcs.a(paramtpc.a);
      veg.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramtpc.a.size()), Integer.valueOf(paramtnt.a.size()) });
      paramErrorMessage = paramtnt.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        tct localtct = (tct)paramErrorMessage.next();
        if (!paramtpc.a.contains(localtct)) {
          localtcs.a(localtct, false);
        }
      }
      if (paramtnt.a.size() > paramtpc.a.size()) {
        vel.b("home_page", "batch_watch_video", 0, paramtnt.a.size() - paramtpc.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), vel.a(BaseApplication.getContext()) });
      }
    }
    localtcs.a(paramtnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlp
 * JD-Core Version:    0.7.0.1
 */