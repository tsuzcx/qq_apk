import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

public class vlp
  implements DialogInterface.OnCancelListener
{
  public vlp(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlp
 * JD-Core Version:    0.7.0.1
 */