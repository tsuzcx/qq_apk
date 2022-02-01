package com.tencent.qqmail.card;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class QMCardManager$10
  implements QMCallback.ISuccessCallback
{
  QMCardManager$10(QMCardManager paramQMCardManager, ConcurrentHashMap paramConcurrentHashMap, int paramInt1, int paramInt2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    paramQMNetworkRequest = Lists.newArrayList();
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.containsKey("list")))
    {
      paramQMNetworkResponse = (JSONArray)paramQMNetworkResponse.get("list");
      QMLog.log(4, "QMCardManager", "loadQQHotFriend result jsonList:" + paramQMNetworkResponse.size());
      int i = 0;
      if (i < paramQMNetworkResponse.size())
      {
        MailContact localMailContact = new MailContact();
        JSONObject localJSONObject = paramQMNetworkResponse.getJSONObject(i);
        String str = (String)localJSONObject.get("addr");
        if ((this.val$cardSendContactHashMap.get(str) != null) && (System.currentTimeMillis() - ((Long)this.val$cardSendContactHashMap.get(str)).longValue() < 604800000L)) {}
        do
        {
          i += 1;
          break;
          localMailContact.setUin((String)localJSONObject.get("uin"));
          localMailContact.setMark((String)localJSONObject.get("nick"));
          localMailContact.setAddress(str);
          localMailContact.setAccountId(this.val$accountId);
          localMailContact.setType(MailContact.ContactType.QQFriendContact);
          localMailContact.setHashType(0);
          localMailContact.setHash(MailContact.generateHash(localMailContact));
          localMailContact.setId(MailContact.generateId(localMailContact));
          paramQMNetworkRequest.add(localMailContact);
        } while (paramQMNetworkRequest.size() < this.val$num);
      }
      QMLog.log(4, "QMCardManager", "loadQQHotFriend success");
      QMWatcherCenter.triggerLoadQQHotFriendSuccess(this.val$accountId, paramQMNetworkRequest);
      return;
    }
    QMLog.log(4, "QMCardManager", "loadQQHotFriend error");
    QMWatcherCenter.triggerLoadQQHotFriendSuccess(this.val$accountId, paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.10
 * JD-Core Version:    0.7.0.1
 */