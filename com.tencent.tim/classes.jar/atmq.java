import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.tim.cloudfile.recent.RecentWebNativeStorageManager.5;

public class atmq
  extends atgg
{
  public atmq(RecentWebNativeStorageManager.5 param5, CloudHistoryInfo paramCloudHistoryInfo) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase)
  {
    if ((paramCloudBase != null) && ((paramCloudBase instanceof CloudFile))) {}
    for (paramCloudBase = (CloudFile)paramCloudBase;; paramCloudBase = null)
    {
      atmp.a(this.a.this$0, this.b, paramCloudBase);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmq
 * JD-Core Version:    0.7.0.1
 */