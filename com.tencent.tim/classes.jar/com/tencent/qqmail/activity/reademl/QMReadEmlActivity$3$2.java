package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.DownloadThumbProgressBar;
import java.io.File;

class QMReadEmlActivity$3$2
  implements Runnable
{
  QMReadEmlActivity$3$2(QMReadEmlActivity.3 param3, long paramLong, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((QMReadEmlActivity.access$1300(this.this$1.this$0) == null) || (QMReadEmlActivity.access$1400(this.this$1.this$0) == null)) {}
    label298:
    for (;;)
    {
      return;
      int j = QMReadEmlActivity.AttachListViewAdapter.access$1500(QMReadEmlActivity.access$1300(this.this$1.this$0));
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label298;
        }
        Object localObject = (Attach)QMReadEmlActivity.access$1300(this.this$1.this$0).getItem(i);
        if ((localObject != null) && (((Attach)localObject).getHashId() == this.val$attachId))
        {
          QMLog.log(4, "QMReadEmlActivity", "download success:" + ((Attach)localObject).getName());
          ((DownloadThumbProgressBar)QMReadEmlActivity.access$1400(this.this$1.this$0).getChildAt(i).findViewById(2131373659)).complete();
          ((Attach)localObject).getPreview().setMyDisk(this.val$storagePath);
          if (!StringExtention.isNullOrEmpty(this.val$copyPath))
          {
            if (!QMReadEmlActivity.access$1600(this.this$1.this$0)) {
              break;
            }
            localObject = new File(this.val$copyPath);
            if (localObject != null)
            {
              localObject = ((File)localObject).getParent();
              Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131690569) + (String)localObject, 0).show();
            }
            QMReadEmlActivity.access$1602(this.this$1.this$0, false);
            return;
          }
          if (QMReadEmlActivity.access$1700(this.this$1.this$0))
          {
            QMReadEmlActivity.access$1800(this.this$1.this$0, i);
            return;
          }
          if (QMReadEmlActivity.access$1900(this.this$1.this$0) != -1) {
            break;
          }
          QMReadEmlActivity.access$1300(this.this$1.this$0).startAttachmentActivityByPos(i, null);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.3.2
 * JD-Core Version:    0.7.0.1
 */