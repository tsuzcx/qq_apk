package com.tencent.qqmail.activity.reademl;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.DownloadThumbProgressBar;

class QMReadEmlActivity$3$3
  implements Runnable
{
  QMReadEmlActivity$3$3(QMReadEmlActivity.3 param3, long paramLong, Object paramObject) {}
  
  public void run()
  {
    if ((QMReadEmlActivity.access$1300(this.this$1.this$0) == null) || (QMReadEmlActivity.access$1400(this.this$1.this$0) == null)) {}
    for (;;)
    {
      return;
      int j = QMReadEmlActivity.AttachListViewAdapter.access$1500(QMReadEmlActivity.access$1300(this.this$1.this$0));
      int i = 0;
      while (i < j)
      {
        Object localObject1 = (Attach)QMReadEmlActivity.access$1300(this.this$1.this$0).getItem(i);
        if ((localObject1 != null) && (((Attach)localObject1).getHashId() == this.val$attachId))
        {
          QMLog.log(4, "QMReadEmlActivity", "download onError attach :" + ((Attach)localObject1).getName() + " error:" + this.val$error.toString());
          localObject1 = QMReadEmlActivity.access$1400(this.this$1.this$0).getChildAt(i);
          Object localObject2 = (DownloadThumbProgressBar)((View)localObject1).findViewById(2131373659);
          if ((this.val$error != null) && ((this.val$error instanceof DownloadTaskError)) && (((DownloadTaskError)this.val$error).getErrorCode() == -1000)) {
            ((DownloadThumbProgressBar)localObject2).setState(0);
          }
          for (;;)
          {
            localObject2 = (TextView)((View)localObject1).findViewById(2131378296);
            ((View)localObject1).findViewById(2131379661).setVisibility(8);
            ((TextView)localObject2).setVisibility(0);
            ((TextView)localObject2).setText(2131690540);
            ((TextView)localObject2).setTextColor(this.this$1.this$0.getResources().getColor(2131167539));
            return;
            ((DownloadThumbProgressBar)localObject2).pause(true);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.3.3
 * JD-Core Version:    0.7.0.1
 */