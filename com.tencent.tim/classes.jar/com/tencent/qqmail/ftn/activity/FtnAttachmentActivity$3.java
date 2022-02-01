package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.ftn.util.SharedUrlUtil;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;
import java.util.Observable;

class FtnAttachmentActivity$3
  extends IObserver
{
  FtnAttachmentActivity$3(FtnAttachmentActivity paramFtnAttachmentActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (String)((HashMap)paramObject).get("paramfid");
    FtnAttachmentActivity.access$1300(this.this$0).hide();
    paramObservable = SharedUrlUtil.getUrl(paramObservable);
    QMLog.log(4, "FtnAttachmentActivity", "ftn get share url success:" + paramObservable);
    FtnAttachmentActivity.access$000(this.this$0).getPreview().setDownloadUrl(paramObservable);
    FtnAttachmentActivity.access$800(this.this$0).sendEmptyMessage(25);
    FtnAttachmentActivity.access$1400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.3
 * JD-Core Version:    0.7.0.1
 */