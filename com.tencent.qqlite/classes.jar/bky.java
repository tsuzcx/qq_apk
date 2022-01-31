import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bky
  implements Runnable
{
  public bky(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    Intent localIntent = new Intent("mqql.intent.action.NOTICE_ON_PCACTIVE");
    localIntent.addFlags(268435456);
    localIntent.putExtra("uin", this.a.app.getAccount());
    BaseApplicationImpl.a().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bky
 * JD-Core Version:    0.7.0.1
 */