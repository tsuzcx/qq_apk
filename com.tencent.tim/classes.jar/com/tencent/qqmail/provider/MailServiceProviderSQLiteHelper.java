package com.tencent.qqmail.provider;

import android.content.Context;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteStatement;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.model.qmdomain.ObjectSerializable;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

public class MailServiceProviderSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  private static final String FIELD_DOMAIN = "domain";
  private static final String FIELD_LOCAL_CONFIG = "is_local_config";
  private static final String FIELD_MAIL_PROVIDER_BLOB = "mail_provider_blob";
  private static String FILENAME = "MailServicePrivider";
  private static int MIN_VERSION = 5250;
  private static final String TABLE_MAIL_SERVICE_PRIVIDER = "MAIL_SERVICE_PRIVIDER";
  private static String TAG = "MailServicePrividerSqlite";
  private static int VERSION = 5250;
  private static final String sqlCreateMailServicePrivider = "CREATE TABLE IF NOT EXISTS MAIL_SERVICE_PRIVIDER(domain varchar, is_local_config integer default 1, mail_provider_blob blob, primary key (domain, is_local_config))";
  private static final String sqlInsertMailServiceProvider = "REPLACE INTO MAIL_SERVICE_PRIVIDER(domain, is_local_config, mail_provider_blob) VALUES (?, ?, ?)";
  private static final String sqlQueryIsLocalDomain = "select domain from MAIL_SERVICE_PRIVIDER where domain=? AND is_local_config=1";
  private static final String sqlQueryMailServiceProvider = "select * from MAIL_SERVICE_PRIVIDER where domain = ? ORDER BY is_local_config";
  
  public MailServiceProviderSQLiteHelper(Context paramContext)
  {
    super(paramContext, FILENAME, null, VERSION);
  }
  
  public SQLiteStatement getInsertStatement(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.compileStatement("REPLACE INTO MAIL_SERVICE_PRIVIDER(domain, is_local_config, mail_provider_blob) VALUES (?, ?, ?)");
  }
  
  public ArrayList<MailServiceProvider> getMailServiceProvider(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from MAIL_SERVICE_PRIVIDER where domain = ? ORDER BY is_local_config", new String[] { paramString });
    if (paramSQLiteDatabase != null)
    {
      while (paramSQLiteDatabase.moveToNext()) {
        try
        {
          paramString = (MailServiceProvider)ObjectSerializable.deserializable(paramSQLiteDatabase.getBlob(paramSQLiteDatabase.getColumnIndex("mail_provider_blob")));
          if (paramString != null) {
            localArrayList.add(paramString);
          }
        }
        catch (Exception paramString)
        {
          QMLog.log(6, TAG, "getMailServicePrivider error " + paramString.getMessage());
        }
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public void insertMailServiceProvider(SQLiteDatabase paramSQLiteDatabase, ArrayList<String> paramArrayList, ArrayList<MailServiceProvider> paramArrayList1, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramArrayList.size();
    int k = 0;
    int i = 0;
    label188:
    while (k < m)
    {
      Object localObject = (MailServiceProvider)paramArrayList1.get(k);
      try
      {
        localObject = ObjectSerializable.serializable(localObject);
        if (localObject == null) {
          break label188;
        }
        localArrayList.add(paramArrayList.get(k));
        localArrayList.add(Integer.valueOf(paramInt));
        localArrayList.add(localObject);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.log(6, TAG, "insertMailServiceProvider " + (String)paramArrayList.get(k) + "error");
        }
        paramSQLiteDatabase.execSQL(localStringBuilder.toString(), localArrayList.toArray());
        localArrayList.clear();
        int j = 0;
        k += 1;
        i = j;
      }
      j = i;
      if (i >= 300)
      {
        localStringBuilder.setLength(0);
        localStringBuilder.append("REPLACE INTO MAIL_SERVICE_PRIVIDER(domain, is_local_config, mail_provider_blob) VALUES (?, ?, ?)");
        while (i > 1)
        {
          localStringBuilder.append(", (?, ?, ?)");
          i -= 1;
        }
      }
    }
    if (i > 0)
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("REPLACE INTO MAIL_SERVICE_PRIVIDER(domain, is_local_config, mail_provider_blob) VALUES (?, ?, ?)");
      while (i > 1)
      {
        localStringBuilder.append(", (?, ?, ?)");
        i -= 1;
      }
      paramSQLiteDatabase.execSQL(localStringBuilder.toString(), localArrayList.toArray());
      localArrayList.clear();
    }
  }
  
  public boolean isLocalDomain(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select domain from MAIL_SERVICE_PRIVIDER where domain=? AND is_local_config=1", new String[] { paramString });
    return (paramSQLiteDatabase != null) && (paramSQLiteDatabase.getCount() > 0);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MAIL_SERVICE_PRIVIDER(domain varchar, is_local_config integer default 1, mail_provider_blob blob, primary key (domain, is_local_config))");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.provider.MailServiceProviderSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */