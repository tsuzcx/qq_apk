package com.tencent.qqmail.card.cursor;

import android.database.Cursor;
import com.tencent.qqmail.card.QMCardSQLiteHelper;
import com.tencent.qqmail.card.model.QMCardFriendInfo;
import com.tencent.qqmail.card.util.CardUtil;

public class QMBirthdayFriendListCursor
  extends QMCardBaseCursor
{
  public QMBirthdayFriendListCursor(QMCardSQLiteHelper paramQMCardSQLiteHelper)
  {
    super(paramQMCardSQLiteHelper);
  }
  
  private QMCardFriendInfo getItem(Cursor paramCursor)
  {
    QMCardSQLiteHelper localQMCardSQLiteHelper = this.sqLiteHelper;
    return QMCardSQLiteHelper.fillBirthdayFriendInfo(paramCursor);
  }
  
  public QMCardFriendInfo getItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItem(localCursor);
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqLiteHelper.queryBirthdayFriends(this.sqLiteHelper.getReadableDatabase(), CardUtil.getTodayZeroSec());
  }
  
  protected void reload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMBirthdayFriendListCursor
 * JD-Core Version:    0.7.0.1
 */