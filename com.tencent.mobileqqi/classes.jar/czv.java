import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.PrivacyDeclareViewActivity;
import com.tencent.mobileqq.activity.VerifyCreditCardIdentityActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;

class czv
  implements DialogInterface.OnClickListener
{
  czv(czu paramczu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramDialogInterface.dismiss();
      paramDialogInterface = new Intent(this.a.a, VerifyCreditCardIdentityActivity.class);
      paramDialogInterface.putExtra("url", PrivacyDeclareHelper.a(this.a.a));
      try
      {
        this.a.a.startActivityForResult(paramDialogInterface, 2000);
        return;
      }
      catch (Exception paramDialogInterface)
      {
        return;
      }
    }
    paramDialogInterface.dismiss();
    PrivacyDeclareViewActivity.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czv
 * JD-Core Version:    0.7.0.1
 */