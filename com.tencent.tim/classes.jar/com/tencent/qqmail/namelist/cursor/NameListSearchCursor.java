package com.tencent.qqmail.namelist.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.NameListSQLite;
import java.util.LinkedHashMap;

public class NameListSearchCursor
  extends NameListBaseCursor
{
  private String mSearchKey;
  
  public NameListSearchCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, NameListManager paramNameListManager, int paramInt1, int paramInt2, String paramString)
  {
    super(paramQMMailSQLiteHelper, paramNameListManager, paramInt1, paramInt2);
    this.mSearchKey = paramString;
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqliteHelper.nameList.getNameListSearchCursor(this.sqliteHelper.getReadableDatabase(), this.mAccountId, this.mType, this.mSearchKey);
  }
  
  protected LinkedHashMap<String, Integer> querySectionMap()
  {
    return null;
  }
  
  protected void reload() {}
  
  public void setSearchKey(String paramString)
  {
    this.mSearchKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.cursor.NameListSearchCursor
 * JD-Core Version:    0.7.0.1
 */