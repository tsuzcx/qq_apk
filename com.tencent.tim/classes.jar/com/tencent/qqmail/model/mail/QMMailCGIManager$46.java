package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;
import java.util.Iterator;

class QMMailCGIManager$46
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$46(QMMailCGIManager paramQMMailCGIManager, SearchMailQueueHandler.SearchMailCallback paramSearchMailCallback, SearchInfo paramSearchInfo) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    int i = 0;
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    paramQMNetworkRequest = QMMailCGIManager.access$000(this.this$0).getWritableDatabase();
    Object localObject = paramQMNetworkResponse.getJSONArray("idxSt");
    if ((localObject != null) && (((JSONArray)localObject).size() != 0))
    {
      localObject = ((JSONArray)localObject).getJSONObject(0);
      if ((localObject != null) && (((JSONObject)localObject).get("personalcnt") != null))
      {
        int j = ((JSONObject)localObject).getIntValue("personalcnt");
        if (j > 0) {
          this.val$searchCallbacks.handleOnLock(this.val$searchInfo, j);
        }
      }
    }
    paramQMNetworkResponse = QMMailParser.parseMails(this.val$searchInfo.getAccountId(), paramQMNetworkResponse);
    if (paramQMNetworkResponse.size() > 0)
    {
      localObject = paramQMNetworkResponse.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Mail localMail = (Mail)((Iterator)localObject).next();
        if (!QMMailCGIManager.access$000(this.this$0).mail.isSearchMailExist(paramQMNetworkRequest, localMail.getInformation().getId()))
        {
          QMMailCGIManager.access$000(this.this$0).mail.insertRemoteSearchMails(paramQMNetworkRequest, this.val$searchInfo.getAccountId(), localMail, false);
          this.val$searchCallbacks.handleOnProcess(this.val$searchInfo, localMail.getInformation().getId());
        }
        if (!QMMailCGIManager.access$000(this.this$0).mail.isSearchMailInSearchTypeExist(paramQMNetworkRequest, localMail.getInformation().getId(), this.val$searchInfo.getSearchType())) {
          QMMailCGIManager.access$000(this.this$0).mail.insertTmpSearchUtc(paramQMNetworkRequest, localMail.getInformation().getId(), this.val$searchInfo.getSearchType());
        }
      }
    }
    paramQMNetworkRequest = new long[paramQMNetworkResponse.size()];
    while (i < paramQMNetworkResponse.size())
    {
      paramQMNetworkRequest[i] = ((Mail)paramQMNetworkResponse.get(i)).getInformation().getId();
      i += 1;
    }
    if (paramQMNetworkRequest.length > 0) {
      this.val$searchCallbacks.handleOnSuccess(this.val$searchInfo, paramQMNetworkRequest);
    }
    while (paramQMNetworkResponse.size() < 20)
    {
      this.val$searchCallbacks.handleOnComplete(this.val$searchInfo);
      return;
      this.val$searchCallbacks.handleOnEmpty(this.val$searchInfo);
    }
    this.val$searchInfo.setPage(this.val$searchInfo.getPage() + 1);
    this.val$searchCallbacks.handleOnMoveOn(this.val$searchInfo, paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.46
 * JD-Core Version:    0.7.0.1
 */