import android.os.Handler;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;

public class daw
  implements PublicAccountManager.InitDoneObserver
{
  public daw(PublicAccountChatActivity paramPublicAccountChatActivity) {}
  
  public void a()
  {
    PublicAccountChatActivity.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     daw
 * JD-Core Version:    0.7.0.1
 */