package com.tencent.qqmail.namelist.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.NameListSQLite;
import java.util.LinkedHashMap;

public class NameListCursor
  extends NameListBaseCursor
{
  public static final String TAG = "NameListBaseCursor";
  
  public NameListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, NameListManager paramNameListManager, int paramInt1, int paramInt2)
  {
    super(paramQMMailSQLiteHelper, paramNameListManager, paramInt1, paramInt2);
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqliteHelper.nameList.getNameListCursor(this.sqliteHelper.getReadableDatabase(), this.mAccountId, this.mType);
  }
  
  protected LinkedHashMap<String, Integer> querySectionMap()
  {
    return this.sqliteHelper.nameList.getSectionMap(this.sqliteHelper.getReadableDatabase(), this.mAccountId, this.mType);
  }
  
  protected void reload()
  {
    this.nameListManager.loadNameList(this.mAccountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.cursor.NameListCursor
 * JD-Core Version:    0.7.0.1
 */