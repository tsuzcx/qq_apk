import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.phone.DenyRunnable.b;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.widget.QQToast;

class uzs
  implements DenyRunnable.b
{
  uzs(uzn paramuzn) {}
  
  public void r(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQToast.a(this.a.this$0.getApplicationContext(), 1, acfp.m(2131706596), 0).show();
      return;
    }
    paramContext = new Intent(this.a.this$0, GuideBindPhoneActivity.class);
    paramContext.putExtra("fromKeyForContactBind", 5);
    paramContext.putExtra("key_contact_name", this.a.this$0.a.e.contactName);
    paramContext.putExtra("key_contact_phone", this.a.this$0.a.e.uin);
    this.a.this$0.startActivity(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzs
 * JD-Core Version:    0.7.0.1
 */