package com.facebook.stetho.inspector.database;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver.ExecuteResultHandler;
import com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteException;
import com.tencent.moai.database.sqlite.SQLiteStatement;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class SqliteDatabaseDriver
  extends Database.DatabaseDriver
{
  private static final String[] UNINTERESTING_FILENAME_SUFFIXES = { "-journal", "-shm", "-uid", "-wal" };
  private final DatabaseConnectionProvider mDatabaseConnectionProvider;
  private final DatabaseFilesProvider mDatabaseFilesProvider;
  private List<String> mDatabases;
  
  @Deprecated
  public SqliteDatabaseDriver(Context paramContext)
  {
    this(paramContext, new DefaultDatabaseFilesProvider(paramContext), new DefaultDatabaseConnectionProvider());
  }
  
  public SqliteDatabaseDriver(Context paramContext, DatabaseFilesProvider paramDatabaseFilesProvider, DatabaseConnectionProvider paramDatabaseConnectionProvider)
  {
    super(paramContext);
    this.mDatabaseFilesProvider = paramDatabaseFilesProvider;
    this.mDatabaseConnectionProvider = paramDatabaseConnectionProvider;
  }
  
  private <T> T executeInsert(SQLiteDatabase paramSQLiteDatabase, String paramString, Database.DatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler)
  {
    return paramExecuteResultHandler.handleInsert(paramSQLiteDatabase.compileStatement(paramString).executeInsert());
  }
  
  private <T> T executeRawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Database.DatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler)
  {
    paramSQLiteDatabase.execSQL(paramString);
    return paramExecuteResultHandler.handleRawQuery();
  }
  
  private <T> T executeSelect(SQLiteDatabase paramSQLiteDatabase, String paramString, Database.DatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString, null);
    try
    {
      paramString = paramExecuteResultHandler.handleSelect(paramSQLiteDatabase);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  @TargetApi(11)
  private <T> T executeUpdateDelete(SQLiteDatabase paramSQLiteDatabase, String paramString, Database.DatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler)
  {
    return paramExecuteResultHandler.handleUpdateDelete(paramSQLiteDatabase.compileStatement(paramString).executeUpdateDelete());
  }
  
  private File findDatabaseFile(String paramString)
  {
    Iterator localIterator = this.mDatabaseFilesProvider.getDatabaseFiles().iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      if (localFile.getName().equals(paramString)) {
        return localFile;
      }
    }
    return this.mContext.getDatabasePath(paramString);
  }
  
  private static String getFirstWord(String paramString)
  {
    String str = paramString.trim();
    int i = str.indexOf(' ');
    paramString = str;
    if (i >= 0) {
      paramString = str.substring(0, i);
    }
    return paramString;
  }
  
  private SQLiteDatabase openDatabase(String paramString)
    throws SQLiteException
  {
    Util.throwIfNull(paramString);
    return this.mDatabaseConnectionProvider.openDatabase(findDatabaseFile(paramString));
  }
  
  private static String removeSuffix(String paramString, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        str = paramArrayOfString[i];
        if (paramString.endsWith(str)) {
          str = paramString.substring(0, paramString.length() - str.length());
        }
      }
      else
      {
        return str;
      }
      i += 1;
    }
  }
  
  static List<File> tidyDatabaseList(List<File> paramList)
  {
    HashSet localHashSet = new HashSet(paramList);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = (File)paramList.next();
      String str1 = localFile.getPath();
      String str2 = removeSuffix(str1, UNINTERESTING_FILENAME_SUFFIXES);
      if ((str2.equals(str1)) || (!localHashSet.contains(new File(str2)))) {
        localArrayList.add(localFile);
      }
    }
    return localArrayList;
  }
  
  public Database.ExecuteSQLResponse executeSQL(String paramString1, String paramString2, Database.DatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse> paramExecuteResultHandler)
    throws SQLiteException
  {
    Util.throwIfNull(paramString2);
    Util.throwIfNull(paramExecuteResultHandler);
    paramString1 = openDatabase(paramString1);
    for (;;)
    {
      int i;
      try
      {
        str = getFirstWord(paramString2).toUpperCase();
        i = -1;
        switch (str.hashCode())
        {
        case -1785516855: 
          paramString2 = (Database.ExecuteSQLResponse)executeRawQuery(paramString1, paramString2, paramExecuteResultHandler);
          return paramString2;
        }
      }
      finally
      {
        String str;
        paramString1.close();
      }
      if (str.equals("UPDATE"))
      {
        i = 0;
        break label263;
        if (str.equals("DELETE"))
        {
          i = 1;
          break label263;
          if (str.equals("INSERT"))
          {
            i = 2;
            break label263;
            if (str.equals("SELECT"))
            {
              i = 3;
              break label263;
              if (str.equals("PRAGMA"))
              {
                i = 4;
                break label263;
                if (str.equals("EXPLAIN"))
                {
                  i = 5;
                  break label263;
                  paramString2 = (Database.ExecuteSQLResponse)executeUpdateDelete(paramString1, paramString2, paramExecuteResultHandler);
                  paramString1.close();
                  return paramString2;
                  paramString2 = (Database.ExecuteSQLResponse)executeInsert(paramString1, paramString2, paramExecuteResultHandler);
                  paramString1.close();
                  return paramString2;
                  paramString2 = (Database.ExecuteSQLResponse)executeSelect(paramString1, paramString2, paramExecuteResultHandler);
                  paramString1.close();
                  return paramString2;
                }
              }
            }
          }
        }
      }
      label263:
      switch (i)
      {
      }
    }
  }
  
  public List<String> getDatabaseNames()
  {
    if (this.mDatabases == null)
    {
      this.mDatabases = new ArrayList();
      Object localObject = this.mDatabaseFilesProvider.getDatabaseFiles();
      Collections.sort((List)localObject);
      localObject = tidyDatabaseList((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((File)((Iterator)localObject).next()).getName();
        this.mDatabases.add(str);
      }
    }
    return this.mDatabases;
  }
  
  public List<String> getTableNames(String paramString)
    throws SQLiteException
  {
    paramString = openDatabase(paramString);
    try
    {
      Cursor localCursor = paramString.rawQuery("SELECT name FROM sqlite_master WHERE type IN (?, ?)", new String[] { "table", "view" });
      try
      {
        ArrayList localArrayList = new ArrayList();
        while (localCursor.moveToNext())
        {
          localArrayList.add(localCursor.getString(0));
          continue;
          localObject = finally;
        }
      }
      finally
      {
        localCursor.close();
      }
      localObject.close();
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.database.SqliteDatabaseDriver
 * JD-Core Version:    0.7.0.1
 */