import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class cgo
  implements Runnable
{
  public cgo(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void run()
  {
    Object localObject = this.a.b.a();
    localObject = this.a.b.b((String)localObject);
    this.a.runOnUiThread(new cgp(this, (Drawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgo
 * JD-Core Version:    0.7.0.1
 */