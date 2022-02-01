package com.tencent.qqmail.card;

import com.tencent.qqmail.card.model.QMCardFriendInfo;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.FriendInfo;
import com.tencent.qqmail.protocol.UMA.GetThanksListRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class QMCardManager$3
  extends SimpleOnProtocolListener
{
  QMCardManager$3(QMCardManager paramQMCardManager, String paramString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMCardManager", "get thank list: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      Object localObject = paramCloudProtocolResult.get_thank_list_rsp_;
      if ((localObject != null) && (((GetThanksListRsp)localObject).thankslist != null))
      {
        paramCloudProtocolResult = new ArrayList(((GetThanksListRsp)localObject).thankslist.size());
        localObject = ((GetThanksListRsp)localObject).thankslist.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramCloudProtocolResult.add(QMCardFriendInfo.parseFrom((FriendInfo)((Iterator)localObject).next(), null));
        }
        QMCardManager.access$200(this.this$0).insertThanksFriendList(QMCardManager.access$200(this.this$0).getWritableDatabase(), this.val$cardId, paramCloudProtocolResult);
      }
      QMWatcherCenter.triggerLoadThankListSuccess(this.val$cardId);
      return;
    }
    QMWatcherCenter.triggerLoadThankListError(this.val$cardId, new QMUMAError(paramCloudProtocolResult.error_code_, "syncThankList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.3
 * JD-Core Version:    0.7.0.1
 */