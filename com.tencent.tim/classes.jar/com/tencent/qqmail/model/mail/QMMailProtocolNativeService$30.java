package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.TranslationResp;
import com.tencent.qqmail.utilities.QMMailTranslateUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$30
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$30(QMMailProtocolNativeService paramQMMailProtocolNativeService, long paramLong, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    Object localObject2;
    Object localObject1;
    label51:
    int i;
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.translate_resp_ != null))
    {
      localObject2 = paramCloudProtocolResult.translate_resp_.dst_mailcontent;
      localObject1 = paramCloudProtocolResult.translate_resp_.dst_subject;
      if (localObject2 != null)
      {
        paramCloudProtocolResult = ((ByteString)localObject2).toString();
        if (localObject1 == null) {
          break label198;
        }
        localObject1 = ((ByteString)localObject1).toString();
        localObject2 = new MailTranslate();
        ((MailTranslate)localObject2).setMailId(this.val$id);
        ((MailTranslate)localObject2).setTranslateSubj((String)localObject1);
        ((MailTranslate)localObject2).setTranslateContent(QMMailTranslateUtil.addCSSAndJSForTranslate(paramCloudProtocolResult));
        if (paramCloudProtocolResult == null) {
          break label289;
        }
        i = paramCloudProtocolResult.length() / 2;
      }
    }
    label289:
    for (paramCloudProtocolResult = paramCloudProtocolResult.substring(i, Math.min(paramCloudProtocolResult.length(), i + 200));; paramCloudProtocolResult = null)
    {
      QMLog.log(4, "QMMailProtocolNativeService", "translate success, id:" + this.val$id + ", subj:" + (String)localObject1 + ", body:" + paramCloudProtocolResult);
      if (this.val$callback != null)
      {
        this.val$callback.handleSuccess(localObject2, null);
        this.val$callback.handleComplete(null);
      }
      QMWatcherCenter.triggerLoadTranslateMailSuccess(this.val$id);
      return;
      paramCloudProtocolResult = "";
      break;
      label198:
      localObject1 = "";
      break label51;
      QMLog.log(6, "QMMailProtocolNativeService", "translate error code " + paramCloudProtocolResult.error_code_ + ", id:" + this.val$id);
      paramCloudProtocolResult = new QMProtocolError(paramCloudProtocolResult.error_code_);
      if (this.val$callback != null)
      {
        this.val$callback.handleError(paramCloudProtocolResult);
        this.val$callback.handleComplete(null);
      }
      QMWatcherCenter.triggerLoadTranslateMailError(this.val$id, paramCloudProtocolResult);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.30
 * JD-Core Version:    0.7.0.1
 */