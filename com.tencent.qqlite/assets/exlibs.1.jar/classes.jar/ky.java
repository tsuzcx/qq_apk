import android.graphics.drawable.Drawable;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;

public class ky
  implements Runnable
{
  public ky(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public void run()
  {
    Drawable localDrawable = this.a.app.b(BmqqProfileCardActivity.a(this.a).a);
    this.a.runOnUiThread(new kz(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ky
 * JD-Core Version:    0.7.0.1
 */