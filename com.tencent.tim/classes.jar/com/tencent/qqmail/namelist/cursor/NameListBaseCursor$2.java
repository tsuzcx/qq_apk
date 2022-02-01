package com.tencent.qqmail.namelist.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import java.util.concurrent.Callable;

class NameListBaseCursor$2
  implements Callable<Cursor>
{
  NameListBaseCursor$2(NameListBaseCursor paramNameListBaseCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public Cursor call()
    throws Exception
  {
    Cursor localCursor = this.this$0.queryRawCursor();
    if (localCursor != null) {
      localCursor.getCount();
    }
    NameListBaseCursor.access$100(this.this$0).runOnMainThreadWithContext(new NameListBaseCursor.2.1(this));
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.cursor.NameListBaseCursor.2
 * JD-Core Version:    0.7.0.1
 */