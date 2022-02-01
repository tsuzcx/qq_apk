import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider.1;

public class atmn
  extends atgg
{
  public atmn(RecentHistoryFileProvider.1 param1, CloudHistoryInfo paramCloudHistoryInfo) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase)
  {
    if ((paramCloudBase != null) && ((paramCloudBase instanceof CloudFile))) {}
    for (paramCloudBase = (CloudFile)paramCloudBase;; paramCloudBase = null)
    {
      RecentHistoryFileProvider.a(this.a.this$0, this.b, paramCloudBase);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmn
 * JD-Core Version:    0.7.0.1
 */