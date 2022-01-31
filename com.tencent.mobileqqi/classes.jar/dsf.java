import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.activity.SubaccountUgActivity;

class dsf
  implements DialogInterface.OnClickListener
{
  dsf(dsc paramdsc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.a().setTitle("");
    paramDialogInterface = new Intent(this.a.a.a(), SubaccountUgActivity.class);
    this.a.a.startActivity(paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsf
 * JD-Core Version:    0.7.0.1
 */