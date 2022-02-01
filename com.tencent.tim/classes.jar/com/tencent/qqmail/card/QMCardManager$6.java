package com.tencent.qqmail.card;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.SaveCardReq;
import com.tencent.qqmail.protocol.UMA.SaveCardRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.util.ArrayList;

class QMCardManager$6
  extends SimpleOnProtocolListener
{
  QMCardManager$6(QMCardManager paramQMCardManager, SaveCardReq paramSaveCardReq, String paramString, ArrayList paramArrayList) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMCardManager", "save card: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      Object localObject = paramCloudProtocolResult.save_card_rsp_;
      if ((this.val$saveCardReq != null) && (((SaveCardRsp)localObject).h5url != null) && (((SaveCardRsp)localObject).carid != null))
      {
        paramCloudProtocolResult = ((SaveCardRsp)localObject).h5url.toString();
        localObject = ((SaveCardRsp)localObject).carid.toString();
        QMLog.log(4, "QMCardManager", "save card h5url:" + paramCloudProtocolResult + ", cardId: " + (String)localObject);
        QMWatcherCenter.triggerSaveCardSuccess(paramCloudProtocolResult, (String)localObject, this.this$0.getSaveCardKey(this.val$cardId, this.val$cardParas));
        this.this$0.syncCardList(1);
        return;
      }
      QMWatcherCenter.triggerSaveCardError(new QMUMAError(paramCloudProtocolResult.error_code_, "SaveGreetingCard arg invalid"), this.this$0.getSaveCardKey(this.val$cardId, this.val$cardParas));
      return;
    }
    QMWatcherCenter.triggerSaveCardError(new QMUMAError(paramCloudProtocolResult.error_code_, "SaveGreetingCard"), this.this$0.getSaveCardKey(this.val$cardId, this.val$cardParas));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.6
 * JD-Core Version:    0.7.0.1
 */