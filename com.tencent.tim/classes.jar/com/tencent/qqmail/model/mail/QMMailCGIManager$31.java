package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.utilities.QMMailTranslateUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$31
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$31(QMMailCGIManager paramQMMailCGIManager, long paramLong, MailManagerDelegate paramMailManagerDelegate, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    String str;
    StringBuilder localStringBuilder;
    int i;
    if (paramQMNetworkRequest != null)
    {
      paramQMNetworkResponse = new MailTranslate();
      paramQMNetworkResponse.setMailId(this.val$id);
      str = paramQMNetworkRequest.getString("subj");
      paramQMNetworkResponse.setTranslateSubj(str);
      paramQMNetworkRequest = paramQMNetworkRequest.getJSONArray("body");
      localStringBuilder = new StringBuilder();
      i = 0;
      while (i < paramQMNetworkRequest.size())
      {
        localStringBuilder.append(paramQMNetworkRequest.get(i));
        i += 1;
      }
      if (localStringBuilder.length() <= 0) {
        break label301;
      }
      i = localStringBuilder.length() / 2;
    }
    label301:
    for (paramQMNetworkRequest = localStringBuilder.substring(i, Math.min(localStringBuilder.length(), i + 200));; paramQMNetworkRequest = null)
    {
      QMLog.log(4, "QMMailCGIManager", "translate success, id:" + this.val$id + ", subj:" + str + ", body:" + paramQMNetworkRequest);
      paramQMNetworkResponse.setTranslateContent(QMMailTranslateUtil.addCSSAndJSForTranslate(localStringBuilder.toString()));
      paramQMNetworkRequest = QMMailCGIManager.access$000(this.this$0).getWritableDatabase();
      QMMailCGIManager.access$000(this.this$0).mail.insertMailTranslateContent(paramQMNetworkRequest, paramQMNetworkResponse);
      QMWatcherCenter.triggerLoadTranslateMailSuccess(this.val$id);
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(this.val$mailId, null);
      }
      do
      {
        return;
        QMLog.log(6, "QMMailCGIManager", "translate error: responseJson is null, id:" + this.val$id);
        paramQMNetworkRequest = new QMNetworkError(3, -10016, "解析翻译邮件失败");
        QMWatcherCenter.triggerLoadTranslateMailError(this.val$id, paramQMNetworkRequest);
      } while (this.val$callback == null);
      this.val$callback.handleError(paramQMNetworkRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.31
 * JD-Core Version:    0.7.0.1
 */