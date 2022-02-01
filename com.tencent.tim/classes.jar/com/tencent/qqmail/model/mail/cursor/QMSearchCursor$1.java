package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class QMSearchCursor$1
  implements Runnable
{
  QMSearchCursor$1(QMSearchCursor paramQMSearchCursor) {}
  
  public void run()
  {
    Threads.removeCallbackInBackground(this);
    long l = System.currentTimeMillis();
    QMLog.log(4, "QMSearchCursor", "asyncSearchRemark:" + QMSearchCursor.access$000(this.this$0) + "," + this.this$0.getSearchRemark());
    if ((!QMSearchCursor.access$100(this.this$0)) && ((QMSearchCursor.access$000(this.this$0).equals(this.this$0.getSearchRemark())) || ((QMSearchCursor.access$200(this.this$0) != null) && (QMSearchCursor.access$200(this.this$0).getKeyword().equals("")))))
    {
      QMSearchCursor.access$400(this.this$0, QMSearchCursor.access$300(this.this$0));
      return;
    }
    if (QMSearchCursor.access$200(this.this$0) != null)
    {
      QMSearchCursor.access$002(this.this$0, this.this$0.getSearchRemark());
      QMSearchCursor.access$502(this.this$0, this.this$0.sqliteHelper.mail.getSearchMailIds(this.this$0.sqliteHelper.getReadableDatabase(), QMSearchCursor.access$200(this.this$0)));
      QMLog.log(4, "QMSearchCursor", "updateSearchResult: " + QMSearchCursor.access$500(this.this$0).length + "," + QMSearchCursor.access$000(this.this$0));
      QMSearchCursor.access$400(this.this$0, QMSearchCursor.access$300(this.this$0));
    }
    QMLog.log(4, "QMSearchCursor", "searchTask performance:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSearchCursor.1
 * JD-Core Version:    0.7.0.1
 */