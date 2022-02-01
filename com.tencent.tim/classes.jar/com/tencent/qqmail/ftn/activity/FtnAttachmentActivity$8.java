package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Observable;

class FtnAttachmentActivity$8
  extends IObserver
{
  FtnAttachmentActivity$8(FtnAttachmentActivity paramFtnAttachmentActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(5, "FtnAttachmentActivity", "ftn renew file error:" + FtnAttachmentActivity.access$000(this.this$0).getName());
    DataCollector.logException(7, 14, "Event_Error", "续期失败", true);
    Threads.runOnMainThread(new FtnAttachmentActivity.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.8
 * JD-Core Version:    0.7.0.1
 */