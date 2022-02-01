import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9.2.1;

public class adof
  implements DialogInterface.OnClickListener
{
  public adof(ArkAppModuleReg.ModuleQQ.9 param9, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ArkDispatchTask.getInstance().post(this.a.this$0.mAppName, new ArkAppModuleReg.ModuleQQ.9.2.1(this));
    if ((this.ak != null) && (this.ak.isShowing())) {}
    try
    {
      this.ak.dismiss();
      label48:
      adnq.c.p(this.a.buD, "ark_authority_api_user_info", this.a.val$uin, 2);
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
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adof
 * JD-Core Version:    0.7.0.1
 */