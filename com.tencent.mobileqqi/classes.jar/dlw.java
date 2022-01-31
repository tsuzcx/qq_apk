import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;

class dlw
  implements DialogInterface.OnClickListener
{
  dlw(dlv paramdlv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterPhoneNumActivity.d(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dlw
 * JD-Core Version:    0.7.0.1
 */