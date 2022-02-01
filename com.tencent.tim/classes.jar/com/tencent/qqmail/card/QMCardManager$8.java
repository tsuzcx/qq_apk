package com.tencent.qqmail.card;

import com.tencent.qqmail.card.model.QMCardFriendInfo;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.FriendInfo;
import com.tencent.qqmail.protocol.UMA.GetBirthFriendListRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.util.ArrayList;
import java.util.Iterator;

class QMCardManager$8
  extends SimpleOnProtocolListener
{
  QMCardManager$8(QMCardManager paramQMCardManager) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMCardManager", "get birth friend list: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      CardUtil.setSyncBirthdayFriendTime(System.currentTimeMillis());
      paramCloudProtocolResult = paramCloudProtocolResult.get_birthfriend_list_rsp_;
      if ((paramCloudProtocolResult != null) && (paramCloudProtocolResult.friends != null))
      {
        Object localObject = new ArrayList(paramCloudProtocolResult.friends);
        QMCardManager.access$200(this.this$0).deleteAllBirthdayFriend(QMCardManager.access$200(this.this$0).getWritableDatabase());
        QMLog.log(4, "QMCardManager", "get birthday friends:" + ((ArrayList)localObject).size());
        if (((ArrayList)localObject).size() > 0)
        {
          paramCloudProtocolResult = QMCardManager.access$200(this.this$0).querySendBirthdayFriendIds(QMCardManager.access$200(this.this$0).getReadableDatabase());
          ArrayList localArrayList = new ArrayList();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            QMCardFriendInfo localQMCardFriendInfo = QMCardFriendInfo.parseFrom((FriendInfo)((Iterator)localObject).next(), null);
            if ((paramCloudProtocolResult != null) && (paramCloudProtocolResult.indexOf(localQMCardFriendInfo.getId()) != -1)) {
              localQMCardFriendInfo.setIsSend(true);
            }
            localArrayList.add(localQMCardFriendInfo);
          }
          QMCardManager.access$200(this.this$0).insertBirthdayFriendList(QMCardManager.access$200(this.this$0).getWritableDatabase(), localArrayList);
        }
      }
      QMWatcherCenter.triggerLoadBirthdayFriendListSuccess();
      return;
    }
    QMWatcherCenter.triggerLoadBirthdayFriendListError(new QMUMAError(paramCloudProtocolResult.error_code_, "GetBirthFriendList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.8
 * JD-Core Version:    0.7.0.1
 */