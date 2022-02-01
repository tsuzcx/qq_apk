import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.tim.cloudfile.CloudFileSDKWrapper.5;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class atgn
  extends atgg
{
  public atgn(CloudFileSDKWrapper.5 param5) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase)
  {
    if ((paramCloudBase != null) && ((paramCloudBase instanceof CloudFile))) {
      this.a.Ks.add((CloudFile)paramCloudBase);
    }
    this.a.val$latch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgn
 * JD-Core Version:    0.7.0.1
 */