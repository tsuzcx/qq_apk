package com.facebook.stetho.inspector.database;

import alld;
import android.content.Context;
import android.database.Cursor;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver.ExecuteResultHandler;
import com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse;
import com.tencent.moai.database.sqlite.SQLiteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ContentProviderDatabaseDriver
  extends Database.DatabaseDriver
{
  private static final String sDatabaseName = "content-providers";
  private final ContentProviderSchema[] mContentProviderSchemas;
  private List<String> mDatabaseNames;
  private List<String> mTableNames;
  
  public ContentProviderDatabaseDriver(Context paramContext, ContentProviderSchema... paramVarArgs)
  {
    super(paramContext);
    this.mContentProviderSchemas = paramVarArgs;
  }
  
  private String fetchTableName(String paramString)
  {
    Iterator localIterator = this.mTableNames.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.contains(str)) {
        return str;
      }
    }
    return "";
  }
  
  public Database.ExecuteSQLResponse executeSQL(String paramString1, String paramString2, Database.DatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse> paramExecuteResultHandler)
    throws SQLiteException
  {
    paramString1 = fetchTableName(paramString2);
    int i = this.mTableNames.indexOf(paramString1);
    paramString1 = this.mContentProviderSchemas[i];
    paramString1 = alld.query(this.mContext.getContentResolver(), paramString1.getUri(), paramString1.getProjection(), null, null, null);
    try
    {
      paramString2 = (Database.ExecuteSQLResponse)paramExecuteResultHandler.handleSelect(paramString1);
      return paramString2;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public List<String> getDatabaseNames()
  {
    if ((this.mDatabaseNames == null) && (this.mContentProviderSchemas != null))
    {
      this.mDatabaseNames = new ArrayList();
      this.mDatabaseNames.add("content-providers");
    }
    return this.mDatabaseNames;
  }
  
  public List<String> getTableNames(String paramString)
  {
    if (this.mTableNames == null)
    {
      this.mTableNames = new ArrayList();
      paramString = this.mContentProviderSchemas;
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        this.mTableNames.add(localObject.getTableName());
        i += 1;
      }
    }
    return this.mTableNames;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.database.ContentProviderDatabaseDriver
 * JD-Core Version:    0.7.0.1
 */