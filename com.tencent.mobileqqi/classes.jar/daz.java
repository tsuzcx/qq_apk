import android.os.Handler;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;

public class daz
  implements PublicAccountManager.InitDoneObserver
{
  public daz(PublicAccountChatActivity paramPublicAccountChatActivity) {}
  
  public void a()
  {
    PublicAccountChatActivity.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     daz
 * JD-Core Version:    0.7.0.1
 */