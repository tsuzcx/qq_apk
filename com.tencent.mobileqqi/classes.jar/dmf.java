import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class dmf
  implements DialogInterface.OnClickListener
{
  public dmf(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, SubLoginActivity.class);
    this.a.startActivity(paramDialogInterface);
    this.a.f();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmf
 * JD-Core Version:    0.7.0.1
 */