package com.tencent.qqmail.card;

import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.BatchCards;
import com.tencent.qqmail.protocol.UMA.BatchGetCardsRsp;
import com.tencent.qqmail.protocol.UMA.CardData;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.util.ArrayList;
import java.util.Iterator;

class QMCardManager$2
  extends SimpleOnProtocolListener
{
  QMCardManager$2(QMCardManager paramQMCardManager, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMCardManager", "batch card list: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      if (paramCloudProtocolResult.get_cards_rsp_ != null)
      {
        Object localObject = new ArrayList(paramCloudProtocolResult.get_cards_rsp_.cards);
        if ((localObject != null) && (((ArrayList)localObject).size() == this.val$removeIds.size()))
        {
          paramCloudProtocolResult = ((ArrayList)localObject).iterator();
          while (paramCloudProtocolResult.hasNext())
          {
            localObject = (BatchCards)paramCloudProtocolResult.next();
            int i = ((BatchCards)localObject).type;
            localObject = new ArrayList(((BatchCards)localObject).cards);
            if (localObject != null)
            {
              localObject = ((ArrayList)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                QMCardData localQMCardData = QMCardData.parseFrom((CardData)((Iterator)localObject).next(), null);
                QMCardManager.access$200(this.this$0).insertCardData(QMCardManager.access$200(this.this$0).getWritableDatabase(), localQMCardData, i);
              }
            }
          }
          QMWatcherCenter.triggerBatchLoadCardListSuccess(this.val$cardIds);
          return;
        }
      }
      QMLog.log(6, "QMCardManager", "batch card list empty");
      QMWatcherCenter.triggerBatchLoadCardListError(this.val$cardIds, new QMUMAError(paramCloudProtocolResult.error_code_, "GetGreetingCards"));
      return;
    }
    QMWatcherCenter.triggerBatchLoadCardListError(this.val$cardIds, new QMUMAError(paramCloudProtocolResult.error_code_, "GetGreetingCards"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.2
 * JD-Core Version:    0.7.0.1
 */