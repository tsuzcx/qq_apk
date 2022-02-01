package com.tencent.open.appstore.notice;

import android.content.Context;
import arvv;
import arwk;
import arwt;
import arxn;
import asad;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = arvv.a().e(this.val$url);
    if (localDownloadInfo == null) {
      arwt.i("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((asad.cDS + "." + this.cCH).equals(this.val$action))
      {
        arvv.a().fx(this.val$url);
        return;
      }
      if ((asad.cDR + "." + this.cCH).equals(this.val$action))
      {
        arvv.a().b(localDownloadInfo);
        return;
      }
      if ((asad.cDT + "." + this.cCH).equals(this.val$action))
      {
        arvv.a().b(localDownloadInfo);
        return;
      }
    } while (!(asad.ACTION_DOWNLOAD_COMPLETE + "." + this.cCH).equals(this.val$action));
    arxn.d(this.val$context, arvv.a().qz(localDownloadInfo.ticket), localDownloadInfo.source, localDownloadInfo.qH("big_brother_ref_source_key"));
    localDownloadInfo.cDI = BaseApplicationImpl.getApplication().getQQProcessName();
    arvv.a().a(localDownloadInfo, true);
    arwk.s(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */