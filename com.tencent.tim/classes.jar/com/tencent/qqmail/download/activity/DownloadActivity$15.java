package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.download.listener.OnStateClickListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;

class DownloadActivity$15
  implements OnStateClickListener
{
  DownloadActivity$15(DownloadActivity paramDownloadActivity) {}
  
  public boolean onClick(int paramInt, Attach paramAttach, boolean paramBoolean)
  {
    if (DownloadActivity.access$2400(this.this$0))
    {
      DownloadInfo localDownloadInfo = DownloadActivity.access$600(this.this$0).getItem(paramInt);
      if ((localDownloadInfo != null) && (paramAttach != null))
      {
        paramInt = localDownloadInfo.getAttachType();
        if ((paramInt != 0) && (paramInt != 3)) {
          break label76;
        }
        if (!paramBoolean) {
          break label66;
        }
        DownloadActivity.access$2500(this.this$0, paramAttach, localDownloadInfo.getSaveAsPath());
      }
      label66:
      label76:
      do
      {
        return true;
        DownloadActivity.access$700(this.this$0, paramAttach);
        return true;
        if (paramInt == 1)
        {
          if (paramBoolean)
          {
            DownloadActivity.access$2600(this.this$0, (MailBigAttach)paramAttach, localDownloadInfo.getSaveAsPath());
            return true;
          }
          DownloadActivity.access$800(this.this$0, (MailBigAttach)paramAttach);
          return true;
        }
        if (paramInt == 2)
        {
          if (paramBoolean)
          {
            DownloadActivity.access$2700(this.this$0, localDownloadInfo);
            return true;
          }
          DownloadActivity.access$900(this.this$0, localDownloadInfo);
          return true;
        }
      } while (paramInt != 4);
      if (paramBoolean)
      {
        DownloadActivity.access$2800(this.this$0, localDownloadInfo, paramAttach);
        return true;
      }
      DownloadActivity.access$1000(this.this$0, localDownloadInfo);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.15
 * JD-Core Version:    0.7.0.1
 */