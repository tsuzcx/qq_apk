import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;

public class vry
  implements DialogInterface.OnClickListener
{
  public vry(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      RegisterPhoneNumActivity.a(this.this$0, true);
      RegisterPhoneNumActivity.a(this.this$0).bRq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vry
 * JD-Core Version:    0.7.0.1
 */