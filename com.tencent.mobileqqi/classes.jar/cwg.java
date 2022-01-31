import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;

public class cwg
  extends Handler
{
  public cwg(ModifyFriendInfoActivity paramModifyFriendInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while ((this.a.c == null) || (this.a.c.length() <= 0));
      this.a.b.setText(this.a.c);
      return;
    }
    this.a.a.setText(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwg
 * JD-Core Version:    0.7.0.1
 */