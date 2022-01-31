import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;

public class cdu
  implements View.OnClickListener
{
  public cdu(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    ChatActivity.a(this.a);
    paramView = new Intent();
    paramView.setAction("com.i.qqreader.aioback2reader");
    paramView.putExtra("bookid", ChatActivity.a(this.a));
    this.a.sendBroadcast(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cdu
 * JD-Core Version:    0.7.0.1
 */