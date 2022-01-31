import android.widget.ImageView;
import com.tencent.mobileqq.activity.TroopShareTmpActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class dyn
  extends FriendListObserver
{
  public dyn(TroopShareTmpActivity paramTroopShareTmpActivity) {}
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equalsIgnoreCase(TroopShareTmpActivity.a(this.a)))) {
      TroopShareTmpActivity.a(this.a).setImageDrawable(this.a.b.a(TroopShareTmpActivity.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dyn
 * JD-Core Version:    0.7.0.1
 */