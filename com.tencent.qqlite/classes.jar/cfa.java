import android.content.Intent;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class cfa
  extends MessageObserver
{
  public cfa(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.", 2, "onPushRecommandDevLock.isSuccess=" + paramBoolean1 + " canCancel=" + paramBoolean2 + " words=" + paramString1);
    }
    if (this.a.a == null) {}
    while ((!this.a.a.isResume()) || (!paramBoolean1)) {
      return;
    }
    Intent localIntent = new Intent(this.a.a, DevlockPushActivity.class);
    localIntent.putExtra("canCancel", paramBoolean2);
    localIntent.putExtra("tipMsg", paramString1);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("secondTitle", paramString3);
    localIntent.putExtra("thirdTitle", paramString4);
    localIntent.putStringArrayListExtra("wordsList", paramArrayList);
    this.a.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cfa
 * JD-Core Version:    0.7.0.1
 */