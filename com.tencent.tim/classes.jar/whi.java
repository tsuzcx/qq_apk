import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.a;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendView;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;

public class whi
  extends acog
{
  public whi(ActivateFriendView paramActivateFriendView) {}
  
  public void bYc()
  {
    if ((ActivateFriendView.a(this.a) == null) || (ActivateFriendView.b(this.a) == null)) {}
    do
    {
      return;
      ActivateFriendView.a(this.a, 0);
      int i = 0;
      if (i < ActivateFriendView.a(this.a).size())
      {
        if (this.a.b.n(((ActivateFriendItem)ActivateFriendView.a(this.a).get(i)).uin, 2))
        {
          ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setChecked(false);
          ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setBirthday(this.a.getResources().getString(2131689658));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.a.b.m(((ActivateFriendItem)ActivateFriendView.a(this.a).get(i)).uin, 2))
          {
            ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setChecked(false);
            ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setBirthday(this.a.getResources().getString(2131689661));
          }
          else
          {
            ActivateFriendView.b(this.a);
            ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setChecked(true);
          }
        }
      }
    } while (ActivateFriendView.a(this.a) == null);
    ActivateFriendView.a(this.a).BW(ActivateFriendView.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whi
 * JD-Core Version:    0.7.0.1
 */