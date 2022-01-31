import android.os.Handler;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;

public class dgo
  implements PublicAccountManager.InitDoneObserver
{
  public dgo(PublicAccountChatActivity paramPublicAccountChatActivity) {}
  
  public void a()
  {
    PublicAccountChatActivity.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dgo
 * JD-Core Version:    0.7.0.1
 */