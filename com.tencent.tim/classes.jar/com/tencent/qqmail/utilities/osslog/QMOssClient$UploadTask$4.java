package com.tencent.qqmail.utilities.osslog;

import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class QMOssClient$UploadTask$4
  implements Func1<QMNetworkRequest, Observable<QMNetworkResponse>>
{
  QMOssClient$UploadTask$4(QMOssClient.UploadTask paramUploadTask) {}
  
  public Observable<QMNetworkResponse> call(QMNetworkRequest paramQMNetworkRequest)
  {
    return QMHttpUtil.sendInObservable(paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.QMOssClient.UploadTask.4
 * JD-Core Version:    0.7.0.1
 */