import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable.b;

public class zqf
  implements DenyRunnable.b
{
  public zqf(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void r(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = "permission_denied_by_user";; paramContext = "permission_denied")
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("bind_mobile", this.this$0.getPhoneNumber());
      localIntent.putExtra("check_permission_result", paramContext);
      localIntent.putExtra("kSrouce", BindVerifyActivity.a(this.this$0));
      this.this$0.setResult(-1, localIntent);
      this.this$0.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqf
 * JD-Core Version:    0.7.0.1
 */