package com.facebook.stetho.inspector.database;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class DefaultDatabaseFilesProvider
  implements DatabaseFilesProvider
{
  private static final int MAX_DEPTH = 2;
  private final Context mContext;
  
  public DefaultDatabaseFilesProvider(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void listFiles(File paramFile, List<File> paramList, int paramInt)
  {
    paramFile = paramFile.listFiles();
    int i = paramInt + 1;
    int j = paramFile.length;
    paramInt = 0;
    if (paramInt < j)
    {
      File localFile = paramFile[paramInt];
      if (localFile.isDirectory()) {
        if (i < 2) {
          listFiles(localFile, paramList, i);
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        try
        {
          if ((!localFile.getName().contains("-wal")) || (!localFile.getName().contains("-journal")))
          {
            SQLiteDatabase.openDatabase(localFile.getAbsolutePath(), null, 536870913).close();
            paramList.add(localFile);
          }
        }
        catch (SQLiteException localSQLiteException) {}
      }
    }
  }
  
  public List<File> getDatabaseFiles()
  {
    ArrayList localArrayList = new ArrayList();
    listFiles(new File(this.mContext.getApplicationInfo().dataDir + File.separator + "databases"), localArrayList, 0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.database.DefaultDatabaseFilesProvider
 * JD-Core Version:    0.7.0.1
 */