import android.content.Intent;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;

public class urx
  extends akwl
{
  public urx(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  protected void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      int i = ContactSyncJumpActivity.a(this.a).xy();
      if ((i == 1) || (i == 5))
      {
        this.a.startActivity(new Intent(this.a, PhoneFrameActivity.class));
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     urx
 * JD-Core Version:    0.7.0.1
 */