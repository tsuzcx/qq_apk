package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class QMMailCGIManager$19$2$1
  extends SimpleDeltaCallback
{
  QMMailCGIManager$19$2$1(QMMailCGIManager.19.2 param2, Integer paramInteger, JSONObject paramJSONObject, ArrayList paramArrayList1, QMFolder paramQMFolder, int paramInt, ArrayList paramArrayList2) {}
  
  public int excludeFolder()
  {
    return this.val$folder.getId();
  }
  
  public void onDeltaComplete(boolean paramBoolean, Exception paramException)
  {
    if (paramBoolean)
    {
      if (this.this$2.this$1.val$callback != null) {
        this.this$2.this$1.val$callback.success(QMMailCGIManager.19.2.access$1200(this.this$2), false);
      }
      QMWatcherCenter.triggerLoadListSuccess(this.val$folderId.intValue(), QMMailManager.LoadListType.UPDATE_LIST, QMMailCGIManager.19.2.access$1300(this.this$2)[0], false);
      return;
    }
    paramException = new QMNetworkError(3, 0, "updateList parseMail Error");
    if (this.this$2.this$1.val$callback != null) {
      this.this$2.this$1.val$callback.error(paramException);
    }
    QMWatcherCenter.triggerLoadListError(this.val$folderId.intValue(), paramException);
  }
  
  public void operation(SQLiteDatabase paramSQLiteDatabase)
  {
    QMMailCGIManager.19.2.access$1400(this.this$2, this.val$json, this.val$mailList, this.val$folder, this.val$folderId, this.val$accountId, this.val$incrementalMailIds, paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.19.2.1
 * JD-Core Version:    0.7.0.1
 */