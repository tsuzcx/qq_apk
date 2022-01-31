import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class wvc
  extends ContactBindObserver
{
  public wvc(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    PhoneLaunchActivity.a(this.a).setEnabled(true);
    if (this.a.a != null)
    {
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
    }
    this.a.b();
    if (paramBoolean)
    {
      Object localObject = this.a;
      if ((PhoneLaunchActivity.a(this.a)) || (PhoneLaunchActivity.b(this.a)))
      {
        this.a.setResult(-1);
        this.a.finish();
        return;
      }
      localObject = new Intent((Context)localObject, SettingActivity2.class);
      if (PhoneLaunchActivity.c(this.a)) {
        ((Intent)localObject).putExtra("kSrouce", 7);
      }
      this.a.startActivityForResult((Intent)localObject, 2);
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    this.a.b("启用失败，请重新尝试！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvc
 * JD-Core Version:    0.7.0.1
 */