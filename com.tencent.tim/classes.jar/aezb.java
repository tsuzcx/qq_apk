import android.os.Handler;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.FeedsManager.2.1;

public class aezb
  implements ThreadExcutor.IThreadListener
{
  public aezb(FeedsManager paramFeedsManager) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    FeedsManager.access$102(this.this$0, true);
    ThreadManagerV2.getUIHandlerV2().post(new FeedsManager.2.1(this));
    if (FeedsManager.access$300(this.this$0))
    {
      FeedsManager.access$302(this.this$0, false);
      this.this$0.updateQzoneFeeds();
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aezb
 * JD-Core Version:    0.7.0.1
 */