package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$29
  implements Func1<List<JSONObject>, Observable<QMNetworkRequest>>
{
  SendMailManager$29(SendMailManager paramSendMailManager, AtomicInteger paramAtomicInteger, HashMap paramHashMap, String paramString1, StringBuilder paramStringBuilder, List paramList, ComposeMailUI paramComposeMailUI, String paramString2, int paramInt, String paramString3, QMCallback paramQMCallback) {}
  
  public Observable<QMNetworkRequest> call(List<JSONObject> paramList)
  {
    this.val$step.set(7);
    return SendMailManager.access$1500(this.this$0, paramList, this.val$paramDict, this.val$removeFiles, this.val$upfilelistHasSended, this.val$inlineImgsPaths, this.val$mail, this.val$dataString, this.val$accountId, this.val$sendCGI, this.val$wrapCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.29
 * JD-Core Version:    0.7.0.1
 */