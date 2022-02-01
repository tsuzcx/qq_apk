package com.tencent.qqmail.activity.compose;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.observer.ICallBack;

class ComposeNoteActivity$9
  implements ICallBack
{
  ComposeNoteActivity$9(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void callback(Object paramObject)
  {
    if (ComposeNoteActivity.access$900(this.this$0) == ComposeNoteActivity.SendMailStatus.SENDCLOSED) {}
    do
    {
      return;
      paramObject = (String)paramObject;
      if ("mounted".equals(paramObject))
      {
        paramObject = null;
        if (ComposeNoteActivity.access$1000(this.this$0) != null)
        {
          String str = ComposeNoteActivity.access$1000(this.this$0).getComposeCacheFilePath();
          if (str != null)
          {
            paramObject = str;
            if (!"".equals(str)) {}
          }
          else
          {
            paramObject = ComposeNoteActivity.access$1000(this.this$0).createComposeCache();
          }
          ComposeNoteActivity.access$1100(this.this$0);
        }
        ComposeNoteActivity.access$1202(this.this$0, FileUtil.isFileExist(paramObject));
        Toast.makeText(QMApplicationContext.sharedInstance(), "SD卡已加载！", 0).show();
        return;
      }
    } while ((!"unmounted".equals(paramObject)) || (ComposeNoteActivity.access$900(this.this$0) == ComposeNoteActivity.SendMailStatus.SENDCLOSED));
    ComposeNoteActivity.access$1202(this.this$0, false);
    Toast.makeText(QMApplicationContext.sharedInstance(), "没有SD卡，将无法处理附件！", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.9
 * JD-Core Version:    0.7.0.1
 */