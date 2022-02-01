package com.tencent.qqmail.utilities.patch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;

class QMPatchManagerService$1
  implements Runnable
{
  QMPatchManagerService$1(QMPatchManagerService paramQMPatchManagerService) {}
  
  public void run()
  {
    QMLog.log(4, "QMPatchManagerService", "checkPatchTask");
    Object localObject = SPManager.getSp("qmpatch_info");
    String str1 = ((SharedPreferences)localObject).getString("patchtype", null);
    if (TextUtils.isEmpty(str1))
    {
      QMLog.log(4, "QMPatchManagerService", "no patch task to do");
      QMPatchManagerService.access$000(this.this$0);
      return;
    }
    String str2 = ((SharedPreferences)localObject).getString("baseversion", null);
    String str3 = ((SharedPreferences)localObject).getString("patchversion", null);
    String str4 = ((SharedPreferences)localObject).getString("channel", null);
    String str5 = ((SharedPreferences)localObject).getString("patchurl", null);
    String str6 = ((SharedPreferences)localObject).getString("minapi", null);
    localObject = ((SharedPreferences)localObject).getString("maxapi", null);
    QMPatchManagerService.access$100(this.this$0, str1, str6, (String)localObject, str2, str3, str4, str5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.patch.QMPatchManagerService.1
 * JD-Core Version:    0.7.0.1
 */