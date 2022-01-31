import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatActivity;

class cex
  implements Runnable
{
  cex(cew paramcew) {}
  
  public void run()
  {
    if ((ChatActivity.c(this.a.a.a) != null) && (ChatActivity.c(this.a.a.a).getParent() != null)) {
      ((ViewGroup)ChatActivity.c(this.a.a.a).getParent()).removeView(ChatActivity.c(this.a.a.a));
    }
    ChatActivity.b(this.a.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cex
 * JD-Core Version:    0.7.0.1
 */