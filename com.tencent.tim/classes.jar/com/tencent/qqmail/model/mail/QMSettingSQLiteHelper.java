package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.model.cache.QMSettingCache;
import com.tencent.qqmail.model.cache.SettingItem;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.List;

public class QMSettingSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  private static final String FIELD_SETTING_ACCOUNT_ID = "accountid";
  private static final String FIELD_SETTING_ID = "id";
  private static final String FIELD_SETTING_TYPE = "type";
  private static final String FIELD_SETTING_VALUE = "val";
  private static final String FILENAME = "QMSettingDB";
  private static final String TABLE_SETTING = "QM_SETTING";
  private static final SQLiteDatabase.CursorFactory cursorFactory = null;
  private static final String queryAll = "SELECT * FROM QM_SETTING";
  private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS QM_SETTING(id varchar primary key , val varchar , accountid varchar , type integer)";
  private static final String sqlDrop = "DROP TABLE IF EXISTS QM_SETTING";
  private static final QMSettingSQLiteDatabaseUpgradeManager upgradeManager = new QMSettingSQLiteDatabaseUpgradeManager();
  private final String TAG = "QMSettingSQLite";
  private final QMSettingCache memoryStore = new QMSettingCache();
  
  public QMSettingSQLiteHelper(Context paramContext)
  {
    super(paramContext, "QMSettingDB", cursorFactory, upgradeManager.getVersion());
  }
  
  private void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_SETTING(id varchar primary key , val varchar , accountid varchar , type integer)");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_SETTING");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public List<String> getAllItem(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_SETTING", null);
    if (paramSQLiteDatabase != null)
    {
      int j = paramSQLiteDatabase.getCount();
      int i = 0;
      while (i < j)
      {
        paramSQLiteDatabase.moveToPosition(i);
        String str1 = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("id"));
        String str2 = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("val"));
        localArrayList.add(str1 + "=" + str2);
        i += 1;
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    return super.getReadableDatabase();
  }
  
  public String getValue(String paramString)
  {
    return this.memoryStore.getValue(paramString);
  }
  
  public void initCache(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_SETTING", null);
    if (paramSQLiteDatabase != null)
    {
      int j = paramSQLiteDatabase.getCount();
      int i = 0;
      while (i < j)
      {
        paramSQLiteDatabase.moveToPosition(i);
        String str = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("id"));
        SettingItem localSettingItem = new SettingItem(str, paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("val")), Integer.parseInt(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("accountid"))), Integer.parseInt(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("type"))));
        this.memoryStore.setValue(str, localSettingItem, null);
        i += 1;
      }
      paramSQLiteDatabase.close();
      return;
    }
    QMLog.log(5, "QMSettingSQLite", "init setting cache cursor null.");
  }
  
  public void insertItem(SQLiteDatabase paramSQLiteDatabase, SettingItem paramSettingItem)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", paramSettingItem.key);
    localContentValues.put("val", paramSettingItem.value);
    localContentValues.put("accountid", Integer.valueOf(paramSettingItem.accountId));
    localContentValues.put("type", Integer.valueOf(paramSettingItem.type));
    paramSQLiteDatabase.replace("QM_SETTING", null, localContentValues);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_SETTING(id varchar primary key , val varchar , accountid varchar , type integer)");
    QMLog.log(4, "QMSettingSQLite", "create table");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "SQLiteDatabase", "Try Upgrade: from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      dropTable(paramSQLiteDatabase);
      createTable(paramSQLiteDatabase);
      return;
    }
    if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1))
    {
      QMLog.log(4, "SQLiteDatabase", "Upgraded from " + paramInt1 + " to " + paramInt2);
      return;
    }
    QMLog.log(4, "SQLiteDatabase", "No need upgrade from " + paramInt1 + " to " + paramInt2);
  }
  
  public boolean removeKeys(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length == 0) {
      return false;
    }
    this.memoryStore.remove(paramArrayOfString, new QMSettingSQLiteHelper.3(this, paramSQLiteDatabase, paramArrayOfString));
    return true;
  }
  
  public void removeKeysByAccountId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.memoryStore.removeByAccountId(paramInt);
    paramSQLiteDatabase.delete("QM_SETTING", "accountid=?", new String[] { paramInt + "" });
  }
  
  public boolean setValue(SQLiteDatabase paramSQLiteDatabase, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    paramString2 = new SettingItem(paramString1, paramString2, paramInt1, paramInt2);
    this.memoryStore.setValue(paramString1, paramString2, new QMSettingSQLiteHelper.1(this, paramSQLiteDatabase, paramString2));
    return true;
  }
  
  public boolean setValue(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    paramString2 = new SettingItem(paramString1, paramString2, -1, -1);
    this.memoryStore.setValue(paramString1, paramString2, new QMSettingSQLiteHelper.2(this, paramSQLiteDatabase, paramString2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */