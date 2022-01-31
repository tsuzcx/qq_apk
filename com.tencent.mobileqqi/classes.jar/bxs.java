import android.os.Handler;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.ChatActivity;

public class bxs
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bxs(ChatActivity paramChatActivity) {}
  
  public void onGlobalLayout()
  {
    if ((ChatActivity.a(this.a)) && (this.a.a != null))
    {
      ChatActivity.a(this.a, false);
      this.a.a.sendEmptyMessageDelayed(23, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxs
 * JD-Core Version:    0.7.0.1
 */