import android.content.Intent;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class zko
  extends achq
{
  zko(zju paramzju) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.", 2, "onPushRecommandDevLock.isSuccess=" + paramBoolean1 + " canCancel=" + paramBoolean2 + " words=" + paramString1);
    }
    if (this.this$0.a == null) {}
    while ((!this.this$0.a.isResume()) || (!paramBoolean1)) {
      return;
    }
    Intent localIntent = new Intent(this.this$0.a, DevlockPushActivity.class);
    localIntent.putExtra("canCancel", paramBoolean2);
    localIntent.putExtra("tipMsg", paramString1);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("secondTitle", paramString3);
    localIntent.putExtra("thirdTitle", paramString4);
    localIntent.putStringArrayListExtra("wordsList", paramArrayList);
    this.this$0.a.startActivity(localIntent);
  }
  
  public void c(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver_PCActiveNotice", 2, "onPushPCActiveNotice.isSuccess=" + paramBoolean);
    }
    if (this.this$0.a == null) {}
    Intent localIntent;
    do
    {
      do
      {
        return;
      } while ((!this.this$0.a.isResume()) || (!paramBoolean));
      localIntent = new Intent("mqq.intent.action.PCACTIVE_TIPS");
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("Message", paramString2);
      localIntent.putExtra("lButton", paramString3);
      localIntent.putExtra("rButton", paramString4);
    } while (NotifyPCActiveActivity.a != null);
    this.this$0.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zko
 * JD-Core Version:    0.7.0.1
 */