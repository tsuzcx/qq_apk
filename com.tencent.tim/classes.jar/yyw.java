import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class yyw
  extends MqqHandler
{
  public yyw(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    case 1015: 
    case 1017: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (TroopWithCommonFriendsFragment.a(this.a) == null);
      TroopWithCommonFriendsFragment.a(this.a).notifyDataSetChanged();
      return;
    case 1014: 
      paramMessage = this.a.k.getResources().getString(2131720702);
      QQToast.a(this.a.k, 1, paramMessage, 0).show(this.a.getTitleBarHeight());
      return;
    case 1016: 
      QQToast.a(this.a.k, this.a.getString(2131719496), 0).show(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.k, this.a.getString(2131719483), 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyw
 * JD-Core Version:    0.7.0.1
 */