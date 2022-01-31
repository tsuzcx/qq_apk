import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.widget.QQToast;

public class uiu
  extends CardObserver
{
  public uiu(ActivateFriendActivity paramActivateFriendActivity) {}
  
  protected void k(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      ActivateFriendServlet.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    ActivateFriendActivity.a(this.a, paramBoolean2);
  }
  
  protected void l(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      ActivateFriendServlet.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    if (!this.a.isFinishing())
    {
      if (!paramBoolean1) {
        break label133;
      }
      ActivateFriendActivity.a(this.a, paramBoolean2);
      if (!ActivateFriendActivity.a(this.a)) {
        break label120;
      }
    }
    label120:
    for (String str = this.a.getString(2131437250);; str = this.a.getString(2131437251))
    {
      str = this.a.getString(2131437253, new Object[] { str });
      QQToast.a(this.a, 2, str, 0).b(this.a.getTitleBarHeight());
      return;
    }
    label133:
    QQToast.a(this.a, 1, this.a.getResources().getString(2131436066), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uiu
 * JD-Core Version:    0.7.0.1
 */