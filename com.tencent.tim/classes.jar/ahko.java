import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;

class ahko
  implements DialogInterface.OnClickListener
{
  ahko(ahki paramahki) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = false;
    paramDialogInterface = new Intent(this.this$0.mActivity, SplashActivity.class);
    paramDialogInterface.putExtra("tab_index", MainFragment.bIk);
    paramDialogInterface.putExtra("fragment_id", 1);
    paramDialogInterface.setFlags(67108864);
    paramDialogInterface.setFlags(268435456);
    this.this$0.mActivity.startActivity(paramDialogInterface);
    this.this$0.mActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahko
 * JD-Core Version:    0.7.0.1
 */