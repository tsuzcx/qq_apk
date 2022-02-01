package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.DownloadThumbProgressBar;
import java.io.File;

class ReadMailFragment$29$3
  implements Runnable
{
  ReadMailFragment$29$3(ReadMailFragment.29 param29, long paramLong, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((ReadMailFragment.access$2000(this.this$1.this$0) == null) || (ReadMailFragment.access$8400(this.this$1.this$0) == null)) {}
    label289:
    for (;;)
    {
      return;
      int j = ReadMailFragment.AttachListViewAdapter.access$2100(ReadMailFragment.access$2000(this.this$1.this$0));
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label289;
        }
        Object localObject = (Attach)ReadMailFragment.access$2000(this.this$1.this$0).getItem(i);
        if ((localObject != null) && (((Attach)localObject).getHashId() == this.val$attachId))
        {
          QMLog.log(4, "ReadMailFragment", "download success:" + ((Attach)localObject).getName());
          ((DownloadThumbProgressBar)ReadMailFragment.access$8400(this.this$1.this$0).getChildAt(i).findViewById(2131373659)).complete();
          ((Attach)localObject).getPreview().setMyDisk(this.val$storagePath);
          if (!StringExtention.isNullOrEmpty(this.val$copyPath))
          {
            if ((!ReadMailFragment.access$8500(this.this$1.this$0)) && (!ReadMailFragment.access$8600(this.this$1.this$0))) {
              break;
            }
            localObject = new File(this.val$copyPath);
            if (localObject != null)
            {
              ((File)localObject).getParent();
              if (!QMAttachUtils.isSuffixImage(FileUtil.getFileNameSuffix(((File)localObject).getName()))) {}
            }
            ReadMailFragment.access$8502(this.this$1.this$0, false);
            return;
          }
          if (ReadMailFragment.access$8700(this.this$1.this$0))
          {
            ReadMailFragment.access$8800(this.this$1.this$0, i);
            return;
          }
          if (ReadMailFragment.access$8900(this.this$1.this$0) != -1) {
            break;
          }
          ReadMailFragment.access$2000(this.this$1.this$0).startAttachmentActivityByPos(i, null);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.29.3
 * JD-Core Version:    0.7.0.1
 */