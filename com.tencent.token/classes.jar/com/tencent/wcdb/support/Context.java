package com.tencent.wcdb.support;

import android.content.pm.ApplicationInfo;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;

public final class Context
{
  public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;
  
  static {}
  
  private static File getDataDirFile(android.content.Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getApplicationInfo().dataDir;
      if (paramContext != null) {
        return new File(paramContext);
      }
      return null;
    }
    throw new RuntimeException("Not supported in system context");
  }
  
  private static File getDatabasesDir(android.content.Context paramContext)
  {
    File localFile = new File(getDataDirFile(paramContext), "databases");
    paramContext = localFile;
    if (localFile.getPath().equals("databases")) {
      paramContext = new File("/data/system");
    }
    return paramContext;
  }
  
  private static File makeFilename(File paramFile, String paramString)
  {
    if (paramString.indexOf(File.separatorChar) < 0) {
      return new File(paramFile, paramString);
    }
    paramFile = new StringBuilder();
    paramFile.append("File ");
    paramFile.append(paramString);
    paramFile.append(" contains a path separator");
    throw new IllegalArgumentException(paramFile.toString());
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return openOrCreateDatabase(paramContext, paramString, null, null, paramInt, paramCursorFactory, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramContext, paramString, null, null, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return openOrCreateDatabase(paramContext, paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramInt, paramCursorFactory, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    paramContext = validateFilePath(paramContext, paramString, true);
    int i;
    if ((paramInt & 0x8) != 0) {
      i = 805306368;
    } else {
      i = 268435456;
    }
    paramString = SQLiteDatabase.openDatabase(paramContext.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, i, paramDatabaseErrorHandler, 0);
    setFilePermissionsFromMode(paramContext.getPath(), paramInt, 0);
    return paramString;
  }
  
  private static void setFilePermissionsFromMode(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2 | 0x1B0;
    paramInt2 = i;
    if ((paramInt1 & 0x1) != 0) {
      paramInt2 = i | 0x4;
    }
    i = paramInt2;
    if ((paramInt1 & 0x2) != 0) {
      i = paramInt2 | 0x2;
    }
    FileUtils.setPermissions(paramString, i, -1, -1);
  }
  
  private static File validateFilePath(android.content.Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramString.charAt(0) == File.separatorChar)
    {
      paramContext = new File(paramString.substring(0, paramString.lastIndexOf(File.separatorChar)));
      paramString = new File(paramContext, paramString.substring(paramString.lastIndexOf(File.separatorChar)));
    }
    else
    {
      paramContext = getDatabasesDir(paramContext);
      paramString = makeFilename(paramContext, paramString);
    }
    if ((paramBoolean) && (!paramContext.isDirectory()) && (paramContext.mkdir())) {
      FileUtils.setPermissions(paramContext.getPath(), 505, -1, -1);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.Context
 * JD-Core Version:    0.7.0.1
 */