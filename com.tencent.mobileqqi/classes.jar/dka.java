import android.content.Intent;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class dka
  implements Runnable
{
  public dka(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if (!this.a.isResume()) {}
    do
    {
      return;
      localObject = this.a.b.getDevLockIntent();
    } while (localObject == null);
    String str1 = ((Intent)localObject).getStringExtra("tipMsg");
    boolean bool = ((Intent)localObject).getBooleanExtra("canCancel", true);
    String str2 = ((Intent)localObject).getStringExtra("title");
    String str3 = ((Intent)localObject).getStringExtra("secondTitle");
    String str4 = ((Intent)localObject).getStringExtra("thirdTitle");
    Object localObject = ((Intent)localObject).getStringArrayListExtra("wordsList");
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "onResume start push and word is not null ~~");
    }
    Intent localIntent = new Intent(this.a, DevlockPushActivity.class);
    localIntent.putExtra("canCancel", bool);
    localIntent.putExtra("tipMsg", str1);
    localIntent.putExtra("title", str2);
    localIntent.putExtra("secondTitle", str3);
    localIntent.putExtra("thirdTitle", str4);
    localIntent.putStringArrayListExtra("wordsList", (ArrayList)localObject);
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dka
 * JD-Core Version:    0.7.0.1
 */