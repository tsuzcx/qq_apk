package com.tencent.qqmail.model.media;

import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Iterator;
import java.util.List;
import moai.oss.KvHelper;

class QMUploadImageManager$1
  implements QMAlbumManager.QMAlbumCallback
{
  QMUploadImageManager$1(QMUploadImageManager paramQMUploadImageManager) {}
  
  public void handleSelectMedias(List<AttachInfo> paramList)
  {
    QMUploadImageManager.access$002(this.this$0, paramList);
    paramList = QMUploadImageManager.access$000(this.this$0).iterator();
    for (long l = 0L; paramList.hasNext(); l = ((AttachInfo)paramList.next()).getRealSize() + l) {}
    QMLog.log(4, "QMUploadImageManager", "allowSize : " + QMUploadImageManager.access$100(this.this$0) + " realSize " + l);
    if ((QMUploadImageManager.access$200(this.this$0)) && (l > QMUploadImageManager.access$100(this.this$0)))
    {
      KvHelper.eventScanAttachOverlimit(new double[0]);
      Threads.runOnMainThread(new QMUploadImageManager.1.1(this));
      return;
    }
    QMUploadImageManager.access$300(this.this$0);
    QMUploadImageManager.access$400(this.this$0);
    QMUploadImageManager.access$502(this.this$0, 10);
    QMUploadImageManager.access$600(this.this$0, QMUploadImageManager.access$500(this.this$0));
    Threads.runInBackground(new QMUploadImageManager.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.1
 * JD-Core Version:    0.7.0.1
 */