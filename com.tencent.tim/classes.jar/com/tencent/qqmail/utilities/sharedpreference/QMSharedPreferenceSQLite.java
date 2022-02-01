package com.tencent.qqmail.utilities.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;

public class QMSharedPreferenceSQLite
  extends QMBaseSQLiteOpenHelper
{
  protected static final String DB_NAME = "QMSharedPreferenceDB";
  public static final String FIELD_SETTING_ID = "id";
  public static final String FIELD_SETTING_KEY = "key";
  public static final String FIELD_SETTING_VALUE = "value";
  public static final String FIELD_USERINFO_ID = "id";
  public static final String FIELD_USERINFO_KEY = "key";
  public static final String FIELD_USERINFO_VALUE = "value";
  public static final String TABLE_SP_SETTING = "QM_SP_SETTING";
  public static final String TABLE_SP_USERINFO = "QM_SP_USERINFO";
  private static final String TAG = "QMSharedPreferenceSQLite";
  private static final SQLiteDatabase.CursorFactory cursorFactory = null;
  private static final String sqlCreateSetting = "CREATE TABLE IF NOT EXISTS QM_SP_SETTING(id integer primary key, key varchar, value varchar ) ";
  private static final String sqlCreateUserInfo = "CREATE TABLE IF NOT EXISTS QM_SP_USERINFO(id integer primary key, key varchar, value varchar ) ";
  private static final String sqlDropSetting = "DROP TABLE IF EXISTS QM_SP_SETTING";
  private static final String sqlDropUserInfo = "DROP TABLE IF EXISTS QM_SP_USERINFO";
  private static final String sqlInsertSetting = "REPLACE INTO QM_SP_SETTING ( id,key,value) VALUES (?,?,?)";
  private static final String sqlInsertUserInfo = "REPLACE INTO QM_SP_USERINFO ( id,key,value) VALUES (?,?,?)";
  private static final String sqlQuerySetting = "SELECT value FROM QM_SP_SETTING WHERE key=?";
  private static final String sqlQueryUserInfo = "SELECT value FROM QM_SP_USERINFO WHERE key=?";
  protected static final QMSharedPreferenceSQLiteDatabaseUpgradeManager upgradeManager = new QMSharedPreferenceSQLiteDatabaseUpgradeManager();
  private Context mContext = null;
  
  public QMSharedPreferenceSQLite(Context paramContext)
  {
    super(paramContext, "QMSharedPreferenceDB", cursorFactory, upgradeManager.getVersion());
    this.mContext = paramContext;
  }
  
  private void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_SP_USERINFO(id integer primary key, key varchar, value varchar ) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_SP_SETTING(id integer primary key, key varchar, value varchar ) ");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMSharedPreferenceSQLite", "create table error");
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
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_SP_USERINFO");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_SP_SETTING");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMSharedPreferenceSQLite", "drop table error");
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private void mergeInfoFromSpToDB(SQLiteDatabase paramSQLiteDatabase)
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    long l = localSharedPreferences.getLong("vid", 0L);
    String str = localSharedPreferences.getString("vid_pwd", "");
    if ((l != 0L) && (!"".equals(str)))
    {
      setUserInfo(paramSQLiteDatabase, "vid", String.valueOf(l));
      setUserInfo(paramSQLiteDatabase, "vid_pwd", str);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.remove("vid");
      localEditor.remove("vid_pwd");
      localEditor.commit();
      QMLog.log(4, "QMSharedPreferenceSQLite", "set vid and pwd from sp to db success, vid = " + l + " pwd = " + str);
    }
    for (;;)
    {
      str = localSharedPreferences.getString("deviceid", "");
      if ((str == null) || (str.equals(""))) {
        break;
      }
      setUserInfo(paramSQLiteDatabase, "deviceid", str);
      paramSQLiteDatabase = localSharedPreferences.edit();
      paramSQLiteDatabase.remove("deviceid");
      paramSQLiteDatabase.commit();
      QMLog.log(4, "QMSharedPreferenceSQLite", "set deviceId from sp to db success, deviceId = " + str);
      return;
      QMLog.log(5, "QMSharedPreferenceSQLite", "set vid and pwd from sp to db no vid vid = " + l + " pwd = " + str);
    }
    QMLog.log(5, "QMSharedPreferenceSQLite", "set deviceId from sp to db no deviceId deviceId = " + str);
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    return super.getReadableDatabase();
  }
  
  public String getSetting(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      paramString = paramSQLiteDatabase.rawQuery("SELECT value FROM QM_SP_SETTING WHERE key=?", new String[] { paramString });
      paramSQLiteDatabase = localObject4;
      if (paramString != null)
      {
        paramSQLiteDatabase = localObject3;
        localObject1 = localObject2;
        if (paramString.moveToFirst())
        {
          localObject1 = localObject2;
          paramSQLiteDatabase = paramString.getString(paramString.getColumnIndex("value"));
        }
        localObject1 = paramSQLiteDatabase;
        paramString.close();
      }
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMSharedPreferenceSQLite", paramSQLiteDatabase.getMessage());
    }
    return localObject1;
  }
  
  public String getUserInfo(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      paramString = paramSQLiteDatabase.rawQuery("SELECT value FROM QM_SP_USERINFO WHERE key=?", new String[] { paramString });
      paramSQLiteDatabase = localObject4;
      if (paramString != null)
      {
        paramSQLiteDatabase = localObject3;
        localObject1 = localObject2;
        if (paramString.moveToFirst())
        {
          localObject1 = localObject2;
          paramSQLiteDatabase = paramString.getString(paramString.getColumnIndex("value"));
        }
        localObject1 = paramSQLiteDatabase;
        paramString.close();
      }
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMSharedPreferenceSQLite", paramSQLiteDatabase.getMessage());
    }
    return localObject1;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMSharedPreferenceSQLite", "onCreate table");
    createTable(paramSQLiteDatabase);
    mergeInfoFromSpToDB(paramSQLiteDatabase);
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
  
  public void setSetting(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_SP_SETTING ( id,key,value) VALUES (?,?,?)", new Object[] { Long.valueOf(QMMath.hashLong(paramString1)), paramString1, paramString2 });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMSharedPreferenceSQLite", paramSQLiteDatabase.getMessage());
    }
  }
  
  public void setUserInfo(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_SP_USERINFO ( id,key,value) VALUES (?,?,?)", new Object[] { Long.valueOf(QMMath.hashLong(paramString1)), paramString1, paramString2 });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMSharedPreferenceSQLite", paramSQLiteDatabase.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceSQLite
 * JD-Core Version:    0.7.0.1
 */