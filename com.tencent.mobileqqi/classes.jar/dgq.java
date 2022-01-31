import android.os.Handler;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;

public class dgq
  implements PublicAccountManager.InitDoneObserver
{
  public dgq(PublicAccountChatActivity paramPublicAccountChatActivity) {}
  
  public void a()
  {
    PublicAccountChatActivity.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dgq
 * JD-Core Version:    0.7.0.1
 */