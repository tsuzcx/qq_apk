import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class cgm
  implements DialogInterface.OnClickListener
{
  cgm(cgl paramcgl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.app.a(new cgn(this));
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgm
 * JD-Core Version:    0.7.0.1
 */