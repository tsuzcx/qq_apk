package com.tencent.moai.database.sqlite;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

public final class SqliteWrapper
{
  private static final String SQLITE_EXCEPTION_DETAIL_MESSAGE = "unable to open database file";
  private static final String TAG = "SqliteWrapper";
  
  public static void checkSQLiteException(Context paramContext, SQLiteException paramSQLiteException)
  {
    if (isLowMemory(paramSQLiteException))
    {
      Toast.makeText(paramContext, "low memory", 0).show();
      return;
    }
    throw paramSQLiteException;
  }
  
  public static int delete(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = paramContentResolver.delete(paramUri, paramString, paramArrayOfString);
      return i;
    }
    catch (SQLiteException paramContentResolver)
    {
      SQLiteDebug.Log.e("SqliteWrapper", "Catch a SQLiteException when delete: ", paramContentResolver);
      checkSQLiteException(paramContext, paramContentResolver);
    }
    return -1;
  }
  
  public static Uri insert(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues)
  {
    try
    {
      paramContentResolver = paramContentResolver.insert(paramUri, paramContentValues);
      return paramContentResolver;
    }
    catch (SQLiteException paramContentResolver)
    {
      SQLiteDebug.Log.e("SqliteWrapper", "Catch a SQLiteException when insert: ", paramContentResolver);
      checkSQLiteException(paramContext, paramContentResolver);
    }
    return null;
  }
  
  private static boolean isLowMemory(SQLiteException paramSQLiteException)
  {
    return paramSQLiteException.getMessage().equals("unable to open database file");
  }
  
  @Deprecated
  public static Cursor query(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    throw new RuntimeException("Unsupported Exception.");
  }
  
  public static boolean requery(Context paramContext, Cursor paramCursor)
  {
    try
    {
      boolean bool = paramCursor.requery();
      return bool;
    }
    catch (SQLiteException paramCursor)
    {
      SQLiteDebug.Log.e("SqliteWrapper", "Catch a SQLiteException when requery: ", paramCursor);
      checkSQLiteException(paramContext, paramCursor);
    }
    return false;
  }
  
  public static int update(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = paramContentResolver.update(paramUri, paramContentValues, paramString, paramArrayOfString);
      return i;
    }
    catch (SQLiteException paramContentResolver)
    {
      SQLiteDebug.Log.e("SqliteWrapper", "Catch a SQLiteException when update: ", paramContentResolver);
      checkSQLiteException(paramContext, paramContentResolver);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SqliteWrapper
 * JD-Core Version:    0.7.0.1
 */