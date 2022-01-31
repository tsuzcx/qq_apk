import android.content.Intent;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class afz
  extends ContactBindObserver
{
  public afz(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      int i = ContactSyncJumpActivity.a(this.a).b();
      if ((i == 1) || (i == 2))
      {
        this.a.startActivity(new Intent(this.a, PhoneFrameActivity.class));
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afz
 * JD-Core Version:    0.7.0.1
 */