package com.tencent.wcdb.database;

import java.util.ArrayList;
import java.util.Locale;

public final class SQLiteDatabaseConfiguration
{
  public static final String MEMORY_DB_PATH = ":memory:";
  public final ArrayList<SQLiteCustomFunction> customFunctions = new ArrayList();
  public boolean customWALHookEnabled;
  public boolean foreignKeyConstraintsEnabled;
  public final String label;
  public Locale locale;
  public int maxSqlCacheSize;
  public int openFlags;
  public final String path;
  public int synchronousMode;
  public boolean updateNotificationEnabled;
  public boolean updateNotificationRowID;
  public String vfsName;
  
  public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration != null)
    {
      this.path = paramSQLiteDatabaseConfiguration.path;
      this.label = paramSQLiteDatabaseConfiguration.label;
      updateParametersFrom(paramSQLiteDatabaseConfiguration);
      return;
    }
    throw new IllegalArgumentException("other must not be null.");
  }
  
  public SQLiteDatabaseConfiguration(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      this.path = paramString;
      this.label = paramString;
      this.openFlags = paramInt;
      this.synchronousMode = 2;
      this.maxSqlCacheSize = 25;
      this.locale = Locale.getDefault();
      if ((paramInt & 0x100) != 0) {
        paramString = "vfslog";
      } else {
        paramString = null;
      }
      this.vfsName = paramString;
      return;
    }
    throw new IllegalArgumentException("path must not be null.");
  }
  
  public boolean isInMemoryDb()
  {
    return this.path.equalsIgnoreCase(":memory:");
  }
  
  public void updateParametersFrom(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration != null)
    {
      if (this.path.equals(paramSQLiteDatabaseConfiguration.path))
      {
        this.openFlags = paramSQLiteDatabaseConfiguration.openFlags;
        this.maxSqlCacheSize = paramSQLiteDatabaseConfiguration.maxSqlCacheSize;
        this.locale = paramSQLiteDatabaseConfiguration.locale;
        this.foreignKeyConstraintsEnabled = paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
        this.customWALHookEnabled = paramSQLiteDatabaseConfiguration.customWALHookEnabled;
        this.updateNotificationEnabled = paramSQLiteDatabaseConfiguration.updateNotificationEnabled;
        this.updateNotificationRowID = paramSQLiteDatabaseConfiguration.updateNotificationRowID;
        this.synchronousMode = paramSQLiteDatabaseConfiguration.synchronousMode;
        this.vfsName = paramSQLiteDatabaseConfiguration.vfsName;
        this.customFunctions.clear();
        this.customFunctions.addAll(paramSQLiteDatabaseConfiguration.customFunctions);
        return;
      }
      throw new IllegalArgumentException("other configuration must refer to the same database.");
    }
    throw new IllegalArgumentException("other must not be null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabaseConfiguration
 * JD-Core Version:    0.7.0.1
 */