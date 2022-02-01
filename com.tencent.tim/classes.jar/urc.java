import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.mobileqq.activity.CloudFileActivity;

public class urc
  extends CloudFileCallbackCenter
{
  public urc(CloudFileActivity paramCloudFileActivity) {}
  
  public void onRecursiveRefreshFinished(int paramInt)
  {
    CloudFileActivity.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urc
 * JD-Core Version:    0.7.0.1
 */