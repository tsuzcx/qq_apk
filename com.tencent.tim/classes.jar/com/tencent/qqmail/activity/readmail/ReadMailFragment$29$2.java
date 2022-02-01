package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.view.DownloadThumbProgressBar;

class ReadMailFragment$29$2
  implements Runnable
{
  ReadMailFragment$29$2(ReadMailFragment.29 param29, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if ((ReadMailFragment.access$2000(this.this$1.this$0) == null) || (ReadMailFragment.access$8400(this.this$1.this$0) == null)) {
      break label26;
    }
    label26:
    label162:
    for (;;)
    {
      return;
      if ((this.val$downloadSize != 0L) && (this.val$totalSize != 0L))
      {
        int j = ReadMailFragment.AttachListViewAdapter.access$2100(ReadMailFragment.access$2000(this.this$1.this$0));
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label162;
          }
          Object localObject = (Attach)ReadMailFragment.access$2000(this.this$1.this$0).getItem(i);
          if ((localObject != null) && (((Attach)localObject).getHashId() == this.val$attachId))
          {
            localObject = (DownloadThumbProgressBar)ReadMailFragment.access$8400(this.this$1.this$0).getChildAt(i).findViewById(2131373659);
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
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.29.2
 * JD-Core Version:    0.7.0.1
 */