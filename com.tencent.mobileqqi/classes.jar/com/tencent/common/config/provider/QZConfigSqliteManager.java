package com.tencent.common.config.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

public class QZConfigSqliteManager
  implements QZoneConfigConst
{
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private QZoneConfigHelper jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigHelper;
  private SQLiteDatabase b;
  
  public QZConfigSqliteManager(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigHelper = new QZoneConfigHelper(paramContext, "config_db", null, 1);
  }
  
  public int a()
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_cookie", null, null);
      a();
    }
    return i;
  }
  
  public int a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_configs", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor a()
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_cookie", new String[] { "cookie" }, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_configs", new String[] { "key", "value" }, paramString1, paramArrayOfString, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_configs", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(jdField_a_of_type_AndroidNetUri, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public void a() {}
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigHelper.getWritableDatabase();
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("configprovider", 2, "provider获取数据库出错", localException);
      }
    }
  }
  
  public int b()
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_check_time", null, null);
      a();
    }
    return i;
  }
  
  public int b(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_isp_config", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor b()
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_check_time", new String[] { "check_time" }, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor b(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_isp_config", new String[] { "key", "value" }, paramString1, paramArrayOfString, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_isp_config", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(e, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigHelper.getReadableDatabase();
      if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("configprovider", 2, "provider获取数据库出错", localException);
      }
    }
  }
  
  public int c()
  {
    int i = 0;
    if (a()) {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_update", null, null);
    }
    return i;
  }
  
  public Cursor c()
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_update", new String[] { "updatelog" }, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_cookie", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(jdField_b_of_type_AndroidNetUri, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null;
  }
  
  public int d()
  {
    return 0 + a() + a(null, null) + c() + b() + b(null, null);
  }
  
  public Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_check_time", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(f, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_update", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(c, l);
      a();
      return paramUri;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZConfigSqliteManager
 * JD-Core Version:    0.7.0.1
 */