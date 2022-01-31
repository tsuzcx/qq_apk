import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class ciy
  extends ContactBindObserver
{
  public ciy(RebindActivity paramRebindActivity) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.d();
    if (paramBoolean)
    {
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("k_number", this.a.d);
      paramBundle.putExtra("kBindType", RebindActivity.a(this.a));
      this.a.startActivityForResult(paramBundle, 1);
      return;
    }
    this.a.b(2131363394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ciy
 * JD-Core Version:    0.7.0.1
 */