package com.tencent.qqmail.download.loader;

import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.HashMap;

class TinyImageSeqLoader$2
  implements QMCallback.ISuccessCallback
{
  TinyImageSeqLoader$2(TinyImageSeqLoader paramTinyImageSeqLoader, String paramString1, String paramString2, MediaItemInfo paramMediaItemInfo) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = paramQMNetworkResponse.getResponseString().trim();
    TinyImageSeqLoader.access$000(this.this$0).put(this.val$imageKey, paramQMNetworkRequest);
    TinyImageSeqLoader.access$100(this.this$0, this.val$imageKey, this.val$imageUrl, this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.TinyImageSeqLoader.2
 * JD-Core Version:    0.7.0.1
 */