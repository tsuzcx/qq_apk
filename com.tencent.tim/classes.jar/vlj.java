import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

class vlj
  implements DialogInterface.OnCancelListener
{
  vlj(vlh paramvlh) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.setResult(4003);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlj
 * JD-Core Version:    0.7.0.1
 */