import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;

public class bku
  implements View.OnClickListener
{
  public bku(SplashActivity paramSplashActivity) {}
  
  public void onClick(View paramView)
  {
    ((Conversation)SplashActivity.a(this.a, Conversation.class)).a(SplashActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bku
 * JD-Core Version:    0.7.0.1
 */