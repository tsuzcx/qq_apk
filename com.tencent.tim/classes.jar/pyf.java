import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pyf
  extends pxf
  implements ppv.b<pzu, qba>
{
  public static int PAGE_SIZE = 20;
  private long mStartTime;
  
  public pzu a(int paramInt, ArrayList<psq.a> paramArrayList)
  {
    if (paramArrayList.size() > PAGE_SIZE) {
      ram.w("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    pzu localpzu = new pzu();
    localpzu.mSeq = paramInt;
    localpzu.mS = paramArrayList;
    ppv.a().a(localpzu, this);
    this.mStartTime = System.currentTimeMillis();
    return localpzu;
  }
  
  public void a(@NonNull pzu parampzu, @Nullable qba paramqba, @NonNull ErrorMessage paramErrorMessage)
  {
    psq localpsq = (psq)psx.a(13);
    if ((paramqba == null) || (paramErrorMessage.isFail()))
    {
      ram.w("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramqba = parampzu.mS.iterator();
    }
    while (paramqba.hasNext())
    {
      localpsq.a((psq.a)paramqba.next(), false);
      continue;
      localpsq.P(paramqba.nI);
      ram.w("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramqba.nI.size()), Integer.valueOf(parampzu.mS.size()) });
      paramErrorMessage = parampzu.mS.iterator();
      while (paramErrorMessage.hasNext())
      {
        psq.a locala = (psq.a)paramErrorMessage.next();
        if (!paramqba.nI.contains(locala)) {
          localpsq.a(locala, false);
        }
      }
      if (parampzu.mS.size() > paramqba.nI.size()) {
        rar.b("home_page", "batch_watch_video", 0, parampzu.mS.size() - paramqba.nI.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.mStartTime), rar.getNetworkType(BaseApplication.getContext()) });
      }
    }
    localpsq.a(parampzu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyf
 * JD-Core Version:    0.7.0.1
 */