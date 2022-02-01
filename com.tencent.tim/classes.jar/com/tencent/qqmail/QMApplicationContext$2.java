package com.tencent.qqmail;

import com.tencent.moai.database.sqlite.SQLiteCursor.OnCursorWindowGrowListener;
import com.tencent.qqmail.utilities.log.QMLog;

class QMApplicationContext$2
  implements SQLiteCursor.OnCursorWindowGrowListener
{
  QMApplicationContext$2(QMApplicationContext paramQMApplicationContext) {}
  
  public void onGrow(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, Throwable paramThrowable)
  {
    QMLog.log(5, "QMApplicationContext", "CursorWindow onGrow, row: " + paramInt1 + ", col: " + paramInt2 + ", times: " + paramInt3 + ", curSize: " + paramInt4 + "kb, defaultSize: " + paramInt5 + "kb\nsql: " + paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMApplicationContext.2
 * JD-Core Version:    0.7.0.1
 */