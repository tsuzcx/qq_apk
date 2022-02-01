package com.tencent.qqmail.card.cursor;

import android.database.Cursor;
import com.tencent.qqmail.card.QMCardSQLiteHelper;
import com.tencent.qqmail.card.model.QMCardData;

public class QMCardListCursor
  extends QMCardBaseCursor
{
  private static final int TYPE_ID_NONE = -2147483648;
  private int curTypeId = -2147483648;
  private int nextTypeId = -2147483648;
  
  public QMCardListCursor(QMCardSQLiteHelper paramQMCardSQLiteHelper, int paramInt)
  {
    super(paramQMCardSQLiteHelper);
    this.curTypeId = paramInt;
  }
  
  private QMCardData getItem(Cursor paramCursor)
  {
    return QMCardSQLiteHelper.fillCardData(paramCursor, this.cacheColumnIndex);
  }
  
  public QMCardData getItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItem(localCursor);
  }
  
  protected Cursor queryRawCursor()
  {
    if (this.curTypeId == -2147483648) {
      throw new IllegalStateException("cardlistcursor curTypeId: " + this.curTypeId + ", next: " + this.nextTypeId);
    }
    return this.sqLiteHelper.queryCardsByTypeId(this.sqLiteHelper.getReadableDatabase(), this.curTypeId);
  }
  
  protected void reload()
  {
    if (this.nextTypeId != -2147483648)
    {
      this.curTypeId = this.nextTypeId;
      this.nextTypeId = -2147483648;
    }
  }
  
  public void setTypeId(int paramInt)
  {
    this.nextTypeId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMCardListCursor
 * JD-Core Version:    0.7.0.1
 */