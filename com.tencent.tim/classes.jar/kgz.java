import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class kgz
  implements MessageQueue.IdleHandler
{
  public kgz(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!afjy.a().ajq())
    {
      afjy.a().a().doBindService(BaseApplicationImpl.getApplication());
      afjy.a().a(new kha(this));
      return false;
    }
    Bundle localBundle = affz.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    afjy.a().cq(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgz
 * JD-Core Version:    0.7.0.1
 */