import android.view.Window;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.widget.QQToast;

public class bzj
  implements Runnable
{
  public bzj(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    this.a.a(true);
    this.a.getWindow().clearFlags(128);
    QQToast.a(this.a, 2131562737, 1).b(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzj
 * JD-Core Version:    0.7.0.1
 */