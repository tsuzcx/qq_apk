import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.6;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.6.3.1;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class admy
  implements DialogInterface.OnClickListener
{
  public admy(ArkAppDeviceModule.ObserverMethod.6 param6, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ArkAppCenter.a().post(this.a.b.this$0.mAppName, new ArkAppDeviceModule.ObserverMethod.6.3.1(this));
    if ((this.ak != null) && (this.ak.isShowing())) {}
    try
    {
      this.ak.dismiss();
      label51:
      adnq.c.p(this.a.buD, "ark_authority_api_location", this.a.val$uin, 1);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admy
 * JD-Core Version:    0.7.0.1
 */