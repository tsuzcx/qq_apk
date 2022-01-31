import android.text.TextUtils;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class ask
  extends FriendListObserver
{
  public ask(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((QZoneManagerImp)this.a.a.getManager(9) == null) {
      return;
    }
    Leba.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ask
 * JD-Core Version:    0.7.0.1
 */