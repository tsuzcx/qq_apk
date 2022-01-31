import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aih
  implements Runnable
{
  public aih(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void run()
  {
    Object localObject = this.a.app.a();
    localObject = this.a.app.b((String)localObject);
    this.a.runOnUiThread(new aii(this, (Drawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aih
 * JD-Core Version:    0.7.0.1
 */