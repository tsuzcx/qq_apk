import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bkv
  implements Runnable
{
  public bkv(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if (!this.a.isResume()) {}
    do
    {
      return;
      localIntent = this.a.app.a();
      this.a.app.a(null);
    } while (localIntent == null);
    String str = localIntent.getStringExtra("wording");
    int i = localIntent.getIntExtra("timetowait", 360000);
    Intent localIntent = new Intent("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
    localIntent.putExtra("wording", str);
    localIntent.putExtra("timetowait", i);
    SplashActivity.a(this.a, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bkv
 * JD-Core Version:    0.7.0.1
 */