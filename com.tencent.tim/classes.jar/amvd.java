import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.search.searchengine.CloudRecentSearchEngine;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider;
import java.util.ArrayList;
import java.util.List;

public class amvd
  extends CloudFileCallback
{
  public amvd(CloudRecentSearchEngine paramCloudRecentSearchEngine, Object paramObject, List paramList) {}
  
  public void onSearchRecentHistoryCallback(List<CloudHistoryInfo> arg1, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramInt != 0) || (??? == null) || (???.size() <= 0)) {
      synchronized (this.val$object)
      {
        this.val$object.notifyAll();
        return;
      }
    }
    long l = ???.size();
    paramString = new ArrayList();
    new RecentHistoryFileProvider(CloudRecentSearchEngine.a(this.this$0), "0", new amve(this, new long[] { l }, paramString)).nM(???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvd
 * JD-Core Version:    0.7.0.1
 */