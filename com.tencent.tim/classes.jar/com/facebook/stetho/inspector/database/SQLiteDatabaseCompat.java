package com.facebook.stetho.inspector.database;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import java.lang.annotation.Annotation;

public abstract class SQLiteDatabaseCompat
{
  public static final int ENABLE_FOREIGN_KEY_CONSTRAINTS = 2;
  public static final int ENABLE_WRITE_AHEAD_LOGGING = 1;
  private static final SQLiteDatabaseCompat sInstance = new NoopImpl(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      sInstance = new JellyBeanAndBeyondImpl(null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      sInstance = new HoneycombImpl(null);
      return;
    }
  }
  
  public static SQLiteDatabaseCompat getInstance()
  {
    return sInstance;
  }
  
  public abstract void enableFeatures(@SQLiteOpenOptions int paramInt, SQLiteDatabase paramSQLiteDatabase);
  
  public abstract int provideOpenFlags(@SQLiteOpenOptions int paramInt);
  
  @TargetApi(11)
  static class HoneycombImpl
    extends SQLiteDatabaseCompat
  {
    public void enableFeatures(@SQLiteDatabaseCompat.SQLiteOpenOptions int paramInt, SQLiteDatabase paramSQLiteDatabase)
    {
      if ((paramInt & 0x1) != 0) {
        paramSQLiteDatabase.enableWriteAheadLogging();
      }
      if ((paramInt & 0x2) != 0) {
        paramSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
      }
    }
    
    public int provideOpenFlags(@SQLiteDatabaseCompat.SQLiteOpenOptions int paramInt)
    {
      return 0;
    }
  }
  
  @TargetApi(16)
  static class JellyBeanAndBeyondImpl
    extends SQLiteDatabaseCompat
  {
    public void enableFeatures(@SQLiteDatabaseCompat.SQLiteOpenOptions int paramInt, SQLiteDatabase paramSQLiteDatabase)
    {
      if ((paramInt & 0x2) != 0) {
        paramSQLiteDatabase.setForeignKeyConstraintsEnabled(true);
      }
    }
    
    public int provideOpenFlags(@SQLiteDatabaseCompat.SQLiteOpenOptions int paramInt)
    {
      int i = 0;
      if ((paramInt & 0x1) != 0) {
        i = 536870912;
      }
      return i;
    }
  }
  
  static class NoopImpl
    extends SQLiteDatabaseCompat
  {
    public void enableFeatures(@SQLiteDatabaseCompat.SQLiteOpenOptions int paramInt, SQLiteDatabase paramSQLiteDatabase) {}
    
    public int provideOpenFlags(@SQLiteDatabaseCompat.SQLiteOpenOptions int paramInt)
    {
      return 0;
    }
  }
  
  public static @interface SQLiteOpenOptions {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
 * JD-Core Version:    0.7.0.1
 */