import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.PrivacyDeclareViewActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;

class dfn
  implements DialogInterface.OnClickListener
{
  dfn(dfm paramdfm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramDialogInterface.dismiss();
      paramDialogInterface = new Intent(this.a.a, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", PrivacyDeclareHelper.a(this.a.a));
    }
    try
    {
      this.a.a.startActivity(paramDialogInterface);
      label76:
      PrivacyDeclareViewActivity.a(this.a.a);
      return;
      paramDialogInterface.dismiss();
      PrivacyDeclareViewActivity.a(this.a.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dfn
 * JD-Core Version:    0.7.0.1
 */