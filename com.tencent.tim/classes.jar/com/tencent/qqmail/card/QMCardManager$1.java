package com.tencent.qqmail.card;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.model.QMCardType;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CardData;
import com.tencent.qqmail.protocol.UMA.CardType;
import com.tencent.qqmail.protocol.UMA.GetCardListRsp;
import com.tencent.qqmail.protocol.UMA.SyncCardRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class QMCardManager$1
  extends SimpleOnProtocolListener
{
  QMCardManager$1(QMCardManager paramQMCardManager, ArrayList paramArrayList, int paramInt) {}
  
  private void logList(GetCardListRsp paramGetCardListRsp, int paramInt) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    Log.i("QMCardManager", "result: " + paramCloudProtocolResult.error_code_);
    QMLog.log(4, "QMCardManager", "Sync call list: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      paramCloudProtocolResult = paramCloudProtocolResult.sync_card_rsp_;
      Object localObject2 = new ArrayList(paramCloudProtocolResult.cardtypes);
      SQLiteDatabase localSQLiteDatabase = QMCardManager.access$200(this.this$0).getWritableDatabase();
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        int i;
        try
        {
          localSQLiteDatabase.beginTransactionNonExclusive();
          localObject1 = new ArrayList(((List)localObject2).size());
          if (this.val$typeList.size() != ((List)localObject2).size())
          {
            localObject2 = ((List)localObject2).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              continue;
            }
            ((ArrayList)localObject1).add(QMCardType.parserFrom((CardType)((Iterator)localObject2).next(), null));
            continue;
          }
        }
        catch (Exception paramCloudProtocolResult)
        {
          QMLog.log(5, "QMCardManager", "SyncGreetingCardList error", paramCloudProtocolResult);
          localSQLiteDatabase.endTransaction();
          if (paramCloudProtocolResult != null) {
            break;
          }
          QMWatcherCenter.triggerLoadCardListSuccess(this.val$typeId);
          return;
          localObject3 = this.val$typeList.iterator();
          continue;
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localObject4 = (QMCardType)((Iterator)localObject3).next();
          Object localObject6 = ((List)localObject2).iterator();
          if (!((Iterator)localObject6).hasNext()) {
            continue;
          }
          Object localObject5 = (CardType)((Iterator)localObject6).next();
          if (((QMCardType)localObject4).getTypeId() != ((CardType)localObject5).type) {
            continue;
          }
          localObject6 = QMCardType.parserFrom((CardType)localObject5, (QMCardType)localObject4);
          ((ArrayList)localObject1).add(localObject6);
          ((List)localObject2).remove(localObject5);
          if (((QMCardType)localObject4).equals((QMCardType)localObject6)) {
            continue;
          }
          continue;
          localObject2 = paramCloudProtocolResult.cardlist;
          localObject3 = ((List)localObject2).iterator();
          continue;
          if (!((Iterator)localObject3).hasNext()) {
            break label551;
          }
          localObject4 = (GetCardListRsp)((Iterator)localObject3).next();
          i = ((GetCardListRsp)localObject4).type;
          long l = ((GetCardListRsp)localObject4).maxid;
          if (((GetCardListRsp)localObject4).synkey == null)
          {
            paramCloudProtocolResult = null;
            QMLog.log(4, "QMCardManager", String.format("synccardlist: type[%d], maxid[%d], synkey[%s], remove[%d], add[%d], update[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l), paramCloudProtocolResult, Integer.valueOf(((GetCardListRsp)localObject4).remove_list.size()), Integer.valueOf(((GetCardListRsp)localObject4).add_list.size()), Integer.valueOf(((GetCardListRsp)localObject4).update_list.size()) }));
            paramCloudProtocolResult = ((ArrayList)localObject1).iterator();
            if (!paramCloudProtocolResult.hasNext()) {
              continue;
            }
            localObject5 = (QMCardType)paramCloudProtocolResult.next();
            if (((QMCardType)localObject5).getTypeId() != ((GetCardListRsp)localObject4).type) {
              continue;
            }
            ((QMCardType)localObject5).setMaxId(((GetCardListRsp)localObject4).maxid);
            if (((GetCardListRsp)localObject4).synkey != null) {
              break label539;
            }
            paramCloudProtocolResult = "";
            ((QMCardType)localObject5).setSyncKey(paramCloudProtocolResult);
            continue;
          }
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
        paramCloudProtocolResult = ((GetCardListRsp)localObject4).synkey.toString();
        continue;
        label539:
        paramCloudProtocolResult = ((GetCardListRsp)localObject4).synkey.toString();
        continue;
        label551:
        QMCardManager.access$200(this.this$0).deleteAllCardType(localSQLiteDatabase);
        QMCardManager.access$200(this.this$0).insertCardTypeList(localSQLiteDatabase, (ArrayList)localObject1);
        paramCloudProtocolResult = ((List)localObject2).iterator();
        while (paramCloudProtocolResult.hasNext())
        {
          localObject1 = (GetCardListRsp)paramCloudProtocolResult.next();
          i = ((GetCardListRsp)localObject1).type;
          logList((GetCardListRsp)localObject1, i);
          QMCardManager.access$200(this.this$0).deleteCardDataType(localSQLiteDatabase, i);
          localObject1 = ((GetCardListRsp)localObject1).add_list.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (CardData)((Iterator)localObject1).next();
            localObject2 = QMCardData.parseFrom((CardData)localObject3, null);
            localObject3 = QMCardManager.access$200(this.this$0).queryCardDataByCardId(QMCardManager.access$200(this.this$0).getReadableDatabase(), ((CardData)localObject3).cardid.toString());
            if (localObject3 != null) {
              ((QMCardData)localObject2).setCardParaList(this.this$0.getCardParaListByCardId(((QMCardData)localObject3).getCardId()));
            }
            QMCardManager.access$200(this.this$0).insertCardData(localSQLiteDatabase, (QMCardData)localObject2, i);
          }
        }
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        paramCloudProtocolResult = null;
      }
      QMWatcherCenter.triggerLoadCardListError(this.val$typeId, new QMUMAError(-1, "SyncGreetingCardList: " + paramCloudProtocolResult.getMessage()));
      return;
    }
    QMWatcherCenter.triggerLoadCardListError(this.val$typeId, new QMUMAError(paramCloudProtocolResult.error_code_, "SyncGreetingCardList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.1
 * JD-Core Version:    0.7.0.1
 */