import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class xkv
  implements DialogInterface.OnClickListener
{
  xkv(QQAppInterface paramQQAppInterface, int paramInt1, Activity paramActivity, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (true == xks.bhd) {
      xks.bhd = false;
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.val$qqApp == null) {
      QLog.d("vaspoke", 4, "dialogInterfaceOnClick mApp is null.");
    }
    while (((2 != this.bTZ) && (4 != this.bTZ)) || (paramInt != 1)) {
      return;
    }
    if (2 == this.bTZ)
    {
      aqrf.a(this.val$qqApp, this.val$activity, "mvip.g.a.poke_" + this.bUa, 3, "1450000515", "LTMCLUB", this.val$qqApp.getApp().getString(2131697263), "");
      VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTipClick", "", 0, 0, 0, "", String.valueOf(this.bUa), "vip", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    aqrf.a(this.val$qqApp, this.val$activity, "mvip.g.a.poke_" + this.bUa, 3, "1450000516", "CJCLUBT", this.val$qqApp.getApp().getString(2131720669), "");
    VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTipClick", "", 0, 0, 0, "", String.valueOf(this.bUa), "svip", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkv
 * JD-Core Version:    0.7.0.1
 */