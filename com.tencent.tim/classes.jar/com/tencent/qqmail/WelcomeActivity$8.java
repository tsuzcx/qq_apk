package com.tencent.qqmail;

import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import moai.oss.KvHelper;
import rx.functions.Action1;

class WelcomeActivity$8
  implements Action1<Boolean>
{
  WelcomeActivity$8(WelcomeActivity paramWelcomeActivity) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      SharedPreferenceUtil.setRationalTimes(0);
      PermissionUtils.notifyPermissionChange();
      this.this$0.onAcceptRequiredPermission();
      QMLog.log(4, "WelcomeActivity", "Accept Required Permission");
      KvHelper.eventPermissionAcceptRequiredItems(new double[0]);
    }
    do
    {
      return;
      this.this$0.onDenyRequiredPermission();
      QMLog.log(4, "WelcomeActivity", "Deny Required Permission");
      KvHelper.eventPermissionDenyRequiredItmes(new double[0]);
    } while (PermissionUtils.hasWriteExternalStoragePermission(this.this$0));
    QMLog.log(4, "WelcomeActivity", "Deny Required Permission: WriteExternalStorage");
    KvHelper.eventPermissionDenyRequiredSdcard(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.8
 * JD-Core Version:    0.7.0.1
 */