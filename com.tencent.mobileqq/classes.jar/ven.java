import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ven
  extends vcf
  implements urr<vgr, via>
{
  public static int a = 20;
  private long c;
  
  public vgr a(int paramInt, ArrayList<uvr> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      wxe.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    vgr localvgr = new vgr();
    localvgr.c = paramInt;
    localvgr.a = paramArrayList;
    urp.a().a(localvgr, this);
    this.c = System.currentTimeMillis();
    return localvgr;
  }
  
  public void a(@NonNull vgr paramvgr, @Nullable via paramvia, @NonNull ErrorMessage paramErrorMessage)
  {
    uvq localuvq = (uvq)uwa.a(13);
    if ((paramvia == null) || (paramErrorMessage.isFail()))
    {
      wxe.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramvia = paramvgr.a.iterator();
    }
    while (paramvia.hasNext())
    {
      localuvq.a((uvr)paramvia.next(), false);
      continue;
      localuvq.a(paramvia.a);
      wxe.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramvia.a.size()), Integer.valueOf(paramvgr.a.size()) });
      paramErrorMessage = paramvgr.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        uvr localuvr = (uvr)paramErrorMessage.next();
        if (!paramvia.a.contains(localuvr)) {
          localuvq.a(localuvr, false);
        }
      }
      if (paramvgr.a.size() > paramvia.a.size()) {
        wxj.b("home_page", "batch_watch_video", 0, paramvgr.a.size() - paramvia.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), wxj.a(BaseApplication.getContext()) });
      }
    }
    localuvq.a(paramvgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ven
 * JD-Core Version:    0.7.0.1
 */