package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.view.DownloadThumbProgressBar;

class QMReadEmlActivity$3$1
  implements Runnable
{
  QMReadEmlActivity$3$1(QMReadEmlActivity.3 param3, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if ((QMReadEmlActivity.access$1300(this.this$1.this$0) == null) || (QMReadEmlActivity.access$1400(this.this$1.this$0) == null)) {
      break label26;
    }
    label26:
    label162:
    for (;;)
    {
      return;
      if ((this.val$downloadSize != 0L) && (this.val$totalSize != 0L))
      {
        int j = QMReadEmlActivity.AttachListViewAdapter.access$1500(QMReadEmlActivity.access$1300(this.this$1.this$0));
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label162;
          }
          Object localObject = (Attach)QMReadEmlActivity.access$1300(this.this$1.this$0).getItem(i);
          if ((localObject != null) && (((Attach)localObject).getHashId() == this.val$attachId))
          {
            localObject = (DownloadThumbProgressBar)QMReadEmlActivity.access$1400(this.this$1.this$0).getChildAt(i).findViewById(2131373659);
            ((DownloadThumbProgressBar)localObject).setState(1);
            i = (int)(100L * this.val$downloadSize / this.val$totalSize);
            if (i <= ((DownloadThumbProgressBar)localObject).getCurrentProgress()) {
              break;
            }
            ((DownloadThumbProgressBar)localObject).setCurrentProgress(i);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.3.1
 * JD-Core Version:    0.7.0.1
 */