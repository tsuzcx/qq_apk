import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vae
  extends uxw
  implements uni<vci, vdr>
{
  public static int a = 20;
  private long c;
  
  public vci a(int paramInt, ArrayList<uri> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      wsv.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    vci localvci = new vci();
    localvci.c = paramInt;
    localvci.a = paramArrayList;
    ung.a().a(localvci, this);
    this.c = System.currentTimeMillis();
    return localvci;
  }
  
  public void a(@NonNull vci paramvci, @Nullable vdr paramvdr, @NonNull ErrorMessage paramErrorMessage)
  {
    urh localurh = (urh)urr.a(13);
    if ((paramvdr == null) || (paramErrorMessage.isFail()))
    {
      wsv.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramvdr = paramvci.a.iterator();
    }
    while (paramvdr.hasNext())
    {
      localurh.a((uri)paramvdr.next(), false);
      continue;
      localurh.a(paramvdr.a);
      wsv.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramvdr.a.size()), Integer.valueOf(paramvci.a.size()) });
      paramErrorMessage = paramvci.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        uri localuri = (uri)paramErrorMessage.next();
        if (!paramvdr.a.contains(localuri)) {
          localurh.a(localuri, false);
        }
      }
      if (paramvci.a.size() > paramvdr.a.size()) {
        wta.b("home_page", "batch_watch_video", 0, paramvci.a.size() - paramvdr.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), wta.a(BaseApplication.getContext()) });
      }
    }
    localurh.a(paramvci);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vae
 * JD-Core Version:    0.7.0.1
 */