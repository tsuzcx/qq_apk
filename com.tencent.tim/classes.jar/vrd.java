import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.activity.RegisterActivity;

public class vrd
  implements DialogInterface.OnClickListener
{
  public vrd(RegisterActivity paramRegisterActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.aPp));
    this.this$0.startActivity(localIntent);
    paramDialogInterface.dismiss();
    this.this$0.handler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vrd
 * JD-Core Version:    0.7.0.1
 */