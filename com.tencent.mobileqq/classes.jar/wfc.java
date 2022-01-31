import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import mqq.app.AppRuntime;

class wfc
  implements DialogInterface.OnClickListener
{
  wfc(wfb paramwfb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.getActivity() != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication.getRuntime().getApplication(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://myun.tenpay.com/mqq/auth/index.shtml?_wv=1027&from=36");
      this.a.a.getActivity().startActivity(localIntent);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wfc
 * JD-Core Version:    0.7.0.1
 */