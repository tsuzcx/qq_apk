package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$38
  implements Observable.OnSubscribe<QMNetworkRequest>
{
  SendMailManager$38(SendMailManager paramSendMailManager, HashMap paramHashMap, String paramString1, StringBuilder paramStringBuilder, List paramList1, List paramList2, ComposeMailUI paramComposeMailUI, String paramString2, int paramInt, String paramString3, QMCallback paramQMCallback) {}
  
  public void call(Subscriber<? super QMNetworkRequest> paramSubscriber)
  {
    Object localObject1 = (String)this.val$paramDict.get("content");
    Log.d(SendMailManager.access$100(), "ori content=" + (String)localObject1);
    List localList = Arrays.asList(this.val$removeFiles.split(","));
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.val$upfilelistHasSended.length() > 0) {
      localStringBuilder.append(this.val$upfilelistHasSended.toString());
    }
    Iterator localIterator = this.val$checkFileJsonObjects.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (JSONObject)localIterator.next();
      JSONObject localJSONObject = SendMailManager.access$1900(this.this$0, (JSONObject)localObject2);
      QMFileEntity localQMFileEntity = (QMFileEntity)((JSONObject)localObject2).getObject("fileEntity", QMFileEntity.class);
      localObject2 = localJSONObject.getString("url");
      localObject2 = SendMailManager.access$2000(this.this$0, (String)localObject1, localQMFileEntity, (String)localObject2, this.val$inlineImgsPathList);
      localObject1 = localObject2;
      if (!localList.contains(localQMFileEntity.getFile().getName()))
      {
        localStringBuilder.append(localJSONObject.getString("fileid")).append("|");
        localObject1 = localObject2;
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    QMLog.log(3, SendMailManager.access$100(), "sendMailSeperateAttach:" + localStringBuilder);
    this.val$paramDict.put("content", localObject1);
    Log.d(SendMailManager.access$100(), "replace content=" + (String)localObject1);
    localObject1 = SendMailHelper.getComposeSendParam(this.val$paramDict, this.val$mail) + this.val$dataString + "&upfilelist=" + localStringBuilder;
    Log.d(SendMailManager.access$100(), "composeDataString : " + (String)localObject1);
    paramSubscriber.onNext(CGIManager.httpPost(this.val$accountId, this.val$sendCGI, (String)localObject1, this.val$wrapCallback));
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.38
 * JD-Core Version:    0.7.0.1
 */