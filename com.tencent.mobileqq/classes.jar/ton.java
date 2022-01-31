import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.BaseActivity;

public class ton
  implements DialogInterface.OnClickListener
{
  public ton(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b = true;
    SendMultiPictureHelper.b(this.a);
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ton
 * JD-Core Version:    0.7.0.1
 */