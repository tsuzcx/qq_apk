package com.tencent.qqmail.model.qmnote.storage;

import android.content.Context;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.validate.ValidateHelper;

public class QMNoteBaseSqlite
  extends QMBaseSQLiteOpenHelper
{
  public static final String CATEGORY_TABLE_CATID = "catId";
  public static final String CATEGORY_TABLE_CATNAME = "catName";
  public static final String CATEGORY_TABLE_CATPOS = "catPos";
  public static final String DATABASE_FILE_NAME = "QMNoteDB";
  public static final String NOTE_CATEGORY_TABLE_NAME = "QMNoteCategory";
  public static final String NOTE_TABLE_ABSTRACT = "abstract";
  public static final String NOTE_TABLE_ATTACH_LIST = "attachList";
  public static final String NOTE_TABLE_ATTACH_TYPE = "attachType";
  public static final String NOTE_TABLE_AUDIO = "audio";
  public static final String NOTE_TABLE_CATID = "catId";
  public static final String NOTE_TABLE_CONTENT = "content";
  public static final String NOTE_TABLE_CREATE_TIME = "createTime";
  public static final String NOTE_TABLE_ID = "id";
  public static final String NOTE_TABLE_NAME = "QMNote";
  public static final String NOTE_TABLE_READ = "read";
  public static final String NOTE_TABLE_SEQUENCE = "sequence";
  public static final String NOTE_TABLE_STARRED = "starred";
  public static final String NOTE_TABLE_STATUS = "status";
  public static final String NOTE_TABLE_SUBJECT = "subject";
  public static final String NOTE_TABLE_THUMB_URL = "thumbUrl";
  public static final String NOTE_TABLE_UPDATE_TIME = "updateTime";
  public static final String NOTE_TASK_TABLE_NAME = "QMNoteTask";
  public static final String UNSEND_NOTE_DATA_TABLE_NAME = "QMUnsendNoteData";
  public static final String UNSEND_NOTE_TABLE_DOMAIN = "domain";
  public static final String UNSEND_NOTE_TABLE_ID = "id";
  private static final SQLiteDatabase.CursorFactory cursorFactory = null;
  static final QMNoteSQLiteUpgradeManager upgradeManager = new QMNoteSQLiteUpgradeManager();
  
  QMNoteBaseSqlite(Context paramContext, String paramString)
  {
    super(paramContext, "QMNoteDB" + paramString, cursorFactory, upgradeManager.getVersion());
    ValidateHelper.notNull(paramContext);
    ValidateHelper.notNullAndNotEmpty(paramString);
  }
  
  public String getTaskTableName()
  {
    return "QMNoteTask";
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    String str = "create table if not exists " + getTaskTableName() + " ( " + "taskId" + " integer primary key, " + "noteId" + " varchar not null, " + "opCode" + " integer not null," + "opParam" + " varchar )";
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMNote (id varchar primary key, subject varchar, abstract varchar, catId varchar, createTime double, updateTime double, starred integer, content varchar, read integer, sequence double, status integer, thumbUrl varchar, audio varchar, attachType varchar, attachList blob)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMNoteCategory (catId varchar primary key, catName varchar, catPos INTEGER DEFAULT 0)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMUnsendNoteData (id varchar primary key, domain blob)");
    paramSQLiteDatabase.execSQL(str);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "QMNoteBaseSqlite", "Try Upgrade: from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QMNote");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QMNoteCategory");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QMUnsendNoteData");
      paramSQLiteDatabase.execSQL("DROP TBALE IF EXISTS " + getTaskTableName());
      onCreate(paramSQLiteDatabase);
      return;
    }
    if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1))
    {
      QMLog.log(4, "QMNoteBaseSqlite", "Upgraded from " + paramInt1 + " to " + paramInt2);
      return;
    }
    QMLog.log(4, "QMNoteBaseSqlite", "No need upgrade from " + paramInt1 + " to " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmnote.storage.QMNoteBaseSqlite
 * JD-Core Version:    0.7.0.1
 */