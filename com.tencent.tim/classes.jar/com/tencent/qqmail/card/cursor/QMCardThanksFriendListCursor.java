package com.tencent.qqmail.card.cursor;

import android.database.Cursor;
import com.tencent.qqmail.card.QMCardSQLiteHelper;
import com.tencent.qqmail.card.model.QMCardFriendInfo;

public class QMCardThanksFriendListCursor
  extends QMCardBaseCursor
{
  private final String cardId;
  
  public QMCardThanksFriendListCursor(QMCardSQLiteHelper paramQMCardSQLiteHelper, String paramString)
  {
    super(paramQMCardSQLiteHelper);
    this.cardId = paramString;
  }
  
  private QMCardFriendInfo getItem(Cursor paramCursor)
  {
    QMCardSQLiteHelper localQMCardSQLiteHelper = this.sqLiteHelper;
    return QMCardSQLiteHelper.fillThanksFriendInfo(paramCursor);
  }
  
  public QMCardFriendInfo getItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItem(localCursor);
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqLiteHelper.queryThanksFriendInfoByCardId(this.sqLiteHelper.getReadableDatabase(), this.cardId);
  }
  
  protected void reload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMCardThanksFriendListCursor
 * JD-Core Version:    0.7.0.1
 */