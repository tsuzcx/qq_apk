import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.DenyRunnable.b;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;

public class zra
  implements DenyRunnable.b
{
  public zra(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  public void r(Context paramContext, boolean paramBoolean)
  {
    PhoneLaunchActivity.a(this.this$0).setEnabled(true);
    if ((!paramBoolean) && (paramContext != null))
    {
      Intent localIntent = new Intent(paramContext, GuideBindPhoneActivity.class);
      localIntent.putExtra("fromKeyForContactBind", 2);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zra
 * JD-Core Version:    0.7.0.1
 */