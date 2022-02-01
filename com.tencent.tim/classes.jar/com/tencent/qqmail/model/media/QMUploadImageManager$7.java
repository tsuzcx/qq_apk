package com.tencent.qqmail.model.media;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISendDataCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.util.List;

class QMUploadImageManager$7
  implements QMCallback.ISendDataCallback
{
  QMUploadImageManager$7(QMUploadImageManager paramQMUploadImageManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, Long paramLong1, Long paramLong2)
  {
    if ((QMUploadImageManager.access$200(this.this$0)) && (!this.this$0.isUploadImage())) {
      QMUploadImageManager.access$502(this.this$0, (int)(paramLong1.longValue() * 1.0D / paramLong2.longValue() * 80.0D + 10.0D) * QMUploadImageManager.access$800(this.this$0));
    }
    for (;;)
    {
      if (System.currentTimeMillis() - QMUploadImageManager.access$900(this.this$0) > 200L)
      {
        QMUploadImageManager.access$902(this.this$0, System.currentTimeMillis());
        QMUploadImageManager.access$600(this.this$0, QMUploadImageManager.access$500(this.this$0));
      }
      return;
      QMUploadImageManager.access$502(this.this$0, (int)(QMUploadImageManager.access$800(this.this$0) * 80.0D / (QMUploadImageManager.access$000(this.this$0).size() * 2) + 10.0D + 80.0D / (QMUploadImageManager.access$000(this.this$0).size() * 2) * (paramLong1.longValue() * 1.0D / paramLong2.longValue())));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.7
 * JD-Core Version:    0.7.0.1
 */