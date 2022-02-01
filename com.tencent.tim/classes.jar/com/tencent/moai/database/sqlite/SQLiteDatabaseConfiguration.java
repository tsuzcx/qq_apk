package com.tencent.moai.database.sqlite;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SQLiteDatabaseConfiguration
{
  private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
  public static final String MEMORY_DB_PATH = ":memory:";
  public final ArrayList<SQLiteCustomFunction> customFunctions = new ArrayList();
  public boolean foreignKeyConstraintsEnabled;
  public final String label;
  public int maxSqlCacheSize;
  public int openFlags;
  public final String path;
  public SQLiteDatabase.SQLiteProfile profile;
  public final ArrayList<SQLiteDatabase.UpdateHookWrapper> updateHooks = new ArrayList();
  
  public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null) {
      throw new IllegalArgumentException("other must not be null.");
    }
    this.path = paramSQLiteDatabaseConfiguration.path;
    this.label = paramSQLiteDatabaseConfiguration.label;
    updateParametersFrom(paramSQLiteDatabaseConfiguration);
  }
  
  public SQLiteDatabaseConfiguration(String paramString, int paramInt)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("path must not be null.");
    }
    this.path = paramString;
    this.label = stripPathForLogs(paramString);
    this.openFlags = paramInt;
    this.maxSqlCacheSize = 25;
  }
  
  private static String stripPathForLogs(String paramString)
  {
    if (paramString.indexOf('@') == -1) {
      return paramString;
    }
    return EMAIL_IN_DB_PATTERN.matcher(paramString).replaceAll("XX@YY");
  }
  
  public boolean isInMemoryDb()
  {
    return (this.path.equalsIgnoreCase(":memory:")) || (this.path.contains("mode=memory"));
  }
  
  public void updateParametersFrom(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null) {
      throw new IllegalArgumentException("other must not be null.");
    }
    if (!this.path.equals(paramSQLiteDatabaseConfiguration.path)) {
      throw new IllegalArgumentException("other configuration must refer to the same database.");
    }
    this.openFlags = paramSQLiteDatabaseConfiguration.openFlags;
    this.maxSqlCacheSize = paramSQLiteDatabaseConfiguration.maxSqlCacheSize;
    this.foreignKeyConstraintsEnabled = paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
    this.customFunctions.clear();
    this.customFunctions.addAll(paramSQLiteDatabaseConfiguration.customFunctions);
    this.updateHooks.clear();
    this.updateHooks.addAll(paramSQLiteDatabaseConfiguration.updateHooks);
    this.profile = paramSQLiteDatabaseConfiguration.profile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteDatabaseConfiguration
 * JD-Core Version:    0.7.0.1
 */