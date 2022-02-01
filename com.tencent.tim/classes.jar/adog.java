import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9.3.1;

public class adog
  implements DialogInterface.OnClickListener
{
  public adog(ArkAppModuleReg.ModuleQQ.9 param9, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ArkDispatchTask.getInstance().post(this.a.this$0.mAppName, new ArkAppModuleReg.ModuleQQ.9.3.1(this));
    if ((this.ak != null) && (this.ak.isShowing())) {}
    try
    {
      this.ak.dismiss();
      label48:
      adnq.c.p(this.a.buD, "ark_authority_api_user_info", this.a.val$uin, 1);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adog
 * JD-Core Version:    0.7.0.1
 */