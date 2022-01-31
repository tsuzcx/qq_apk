import android.widget.TextView;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.BaseApplication;

public class uiw
  implements Runnable
{
  public uiw(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void run()
  {
    int i = this.a.app.a().b();
    Object localObject2 = this.a.app.getApp().getString(2131433297);
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject2 = new StringBuilder().append((String)localObject2).append("(");
      if (i <= 99) {
        break label88;
      }
    }
    label88:
    for (localObject1 = "99+";; localObject1 = Integer.valueOf(i))
    {
      localObject1 = localObject1 + ")";
      ActivateFriendActivity.a(this.a).setText((CharSequence)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uiw
 * JD-Core Version:    0.7.0.1
 */