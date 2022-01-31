import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class cna
  implements Runnable
{
  public cna(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void run()
  {
    Object localObject = this.a.b.a();
    localObject = this.a.b.b((String)localObject);
    this.a.runOnUiThread(new cnb(this, (Drawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cna
 * JD-Core Version:    0.7.0.1
 */