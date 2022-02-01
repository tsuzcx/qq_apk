package com.tencent.qqmail.activity.compose;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;

class ComposeMailActivity$120
  implements ICallBack
{
  ComposeMailActivity$120(ComposeMailActivity paramComposeMailActivity) {}
  
  public void callback(Object paramObject)
  {
    if (ComposeMailActivity.access$4400(this.this$0) == ComposeMailActivity.SendMailStatus.SENDCLOSED) {}
    do
    {
      return;
      paramObject = (String)paramObject;
      if ("mounted".equals(paramObject))
      {
        paramObject = null;
        if (this.this$0.composeMail != null)
        {
          String str = this.this$0.composeMail.getComposeCacheFilePath();
          if ((str != null) && (!"".equals(str)))
          {
            paramObject = str;
            if (FileUtil.isFileExist(str)) {}
          }
          else
          {
            paramObject = this.this$0.composeMail.createComposeCache();
          }
          QMLog.log(4, "ComposeMailActivity", "sdcardIObserver try to removeInvalidateAttach");
          ComposeMailActivity.access$16900(this.this$0);
          ComposeMailActivity.access$000(this.this$0);
        }
        ComposeMailActivity.access$17002(this.this$0, FileUtil.isFileExist(paramObject));
        QMLog.log(4, "ComposeMailActivity", "EX_STORAGE_STATE_MOUNTED : " + paramObject + "; " + ComposeMailActivity.access$17000(this.this$0));
        Toast.makeText(QMApplicationContext.sharedInstance(), "SD卡已加载！", 0).show();
        return;
      }
    } while ((!"unmounted".equals(paramObject)) || (ComposeMailActivity.access$4400(this.this$0) == ComposeMailActivity.SendMailStatus.SENDCLOSED));
    ComposeMailActivity.access$17002(this.this$0, false);
    QMLog.log(4, "SdcardUtil", "EX_STORAGE_STATE_UNMOUNTED");
    Toast.makeText(QMApplicationContext.sharedInstance(), "编辑过程中，拔出SD卡，将无法处理附件！", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.120
 * JD-Core Version:    0.7.0.1
 */