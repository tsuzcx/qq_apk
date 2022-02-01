package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.LoadMailAbstractCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import java.util.ArrayList;
import java.util.Iterator;

class QMMailProtocolManager$28
  implements LoadMailAbstractCallback
{
  QMMailProtocolManager$28(QMMailProtocolManager paramQMMailProtocolManager, int paramInt1, int paramInt2) {}
  
  public void loadAbstractError(long paramLong, QMProtocolError paramQMProtocolError)
  {
    if ((paramQMProtocolError != null) && (paramQMProtocolError.getCode() == 21)) {
      QMMailProtocolManager.access$000(this.this$0).mail.updateMailAttr(QMMailProtocolManager.access$000(this.this$0).getWritableDatabase(), new long[] { paramLong }, 549755813888L);
    }
  }
  
  public void loadAbstractProcess() {}
  
  public void loadAbstractSuccess(long paramLong1, long paramLong2, String paramString)
  {
    Object localObject1 = QMMailProtocolManager.access$000(this.this$0).getWritableDatabase();
    QMMailProtocolManager.access$000(this.this$0).mail.updatePopInConvMailAbstract((SQLiteDatabase)localObject1, this.val$folderId, paramLong1, paramString);
    QMMailProtocolManager.access$000(this.this$0).mail.updateMailAttr((SQLiteDatabase)localObject1, new long[] { paramLong1 }, 1073741824L);
    QMWatcherCenter.triggerLoadListPopIn(paramLong1, paramString);
    if (paramLong2 == 1L)
    {
      QMMailProtocolManager.access$200(this.this$0).updateAdvertiseEntrance((SQLiteDatabase)localObject1, this.val$accountId);
      Object localObject2 = QMMailProtocolManager.access$000(this.this$0).mail.getPopInAdMailIds((SQLiteDatabase)localObject1);
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          QMWatcherCenter.triggerLoadListPopIn(((Long)((Iterator)localObject2).next()).longValue(), paramString);
        }
      }
    }
    if (paramLong2 == -1L)
    {
      localObject1 = QMMailProtocolManager.access$000(this.this$0).mail.getPopInConvMailParentIds((SQLiteDatabase)localObject1, this.val$folderId, paramLong1);
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          QMWatcherCenter.triggerLoadListPopIn(((Long)((Iterator)localObject1).next()).longValue(), paramString);
        }
      }
    }
    QMMailProtocolManager.access$1500(this.this$0, paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.28
 * JD-Core Version:    0.7.0.1
 */