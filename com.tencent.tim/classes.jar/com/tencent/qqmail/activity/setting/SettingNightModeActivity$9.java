package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.log.QMLog;

class SettingNightModeActivity$9
  implements QMUIDialogAction.ActionListener
{
  SettingNightModeActivity$9(SettingNightModeActivity paramSettingNightModeActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "SettingNightModeActivit", "ensureFloatViewPermission click setting");
    paramQMUIDialog.dismiss();
    if (BrandUtil.isMiuiV8())
    {
      paramQMUIDialog = new Intent("miui.intent.action.APP_PERM_EDITOR");
      paramQMUIDialog.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      paramQMUIDialog.putExtra("extra_pkgname", this.this$0.getPackageName());
      try
      {
        if (SettingNightModeActivity.access$400(this.this$0, paramQMUIDialog))
        {
          this.this$0.startActivityForResult(paramQMUIDialog, 2);
          return;
        }
        SettingNightModeActivity.access$500(this.this$0);
        return;
      }
      catch (Exception paramQMUIDialog)
      {
        SettingNightModeActivity.access$500(this.this$0);
        paramQMUIDialog.printStackTrace();
        return;
      }
    }
    paramQMUIDialog = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    paramQMUIDialog.addCategory("android.intent.category.DEFAULT");
    paramQMUIDialog.putExtra("packageName", this.this$0.getPackageName());
    this.this$0.startActivityForResult(paramQMUIDialog, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNightModeActivity.9
 * JD-Core Version:    0.7.0.1
 */