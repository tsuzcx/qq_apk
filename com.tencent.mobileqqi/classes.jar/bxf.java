import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;

public class bxf
  implements View.OnClickListener
{
  public bxf(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.dismissDialog(230);
    ProfileCardUtil.a(this.a, "", this.a.a.a, this.a.b.getAccount(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxf
 * JD-Core Version:    0.7.0.1
 */