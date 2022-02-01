import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3.2.1;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class admr
  implements DialogInterface.OnClickListener
{
  public admr(ArkAppDeviceModule.ObserverMethod.3 param3, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ArkAppCenter.a().post(this.a.b.this$0.mAppName, new ArkAppDeviceModule.ObserverMethod.3.2.1(this));
    if ((this.ak != null) && (this.ak.isShowing())) {}
    try
    {
      this.ak.dismiss();
      label51:
      adnq.c.p(this.a.buD, "ark_authority_api_location", this.a.val$uin, 2);
      paramDialogInterface = aqha.a(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getString(2131690483), 2131720227, 2131720227, new aqha.a(), null);
      try
      {
        paramDialogInterface.show();
        return;
      }
      catch (Exception paramDialogInterface) {}
    }
    catch (Exception paramDialogInterface)
    {
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admr
 * JD-Core Version:    0.7.0.1
 */