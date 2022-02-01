import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatActivity;

class bze
  implements Runnable
{
  bze(bzd parambzd) {}
  
  public void run()
  {
    if ((ChatActivity.b(this.a.a.a) != null) && (ChatActivity.b(this.a.a.a).getParent() != null)) {
      ((ViewGroup)ChatActivity.b(this.a.a.a).getParent()).removeView(ChatActivity.b(this.a.a.a));
    }
    ChatActivity.b(this.a.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bze
 * JD-Core Version:    0.7.0.1
 */