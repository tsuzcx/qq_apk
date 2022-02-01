package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.view.QMGesturePasswordView;
import com.tencent.qqmail.view.fingerprint.FingerPrintDialog.DismissListener;

class SettingGestureActivity$1
  implements FingerPrintDialog.DismissListener
{
  SettingGestureActivity$1(SettingGestureActivity paramSettingGestureActivity) {}
  
  public void onDismiss()
  {
    if ((!GesturePasswordManager.getInstance().isGesturePwdPassed()) && (SettingGestureActivity.access$000(this.this$0) != null)) {
      SettingGestureActivity.access$000(this.this$0).switchState(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureActivity.1
 * JD-Core Version:    0.7.0.1
 */