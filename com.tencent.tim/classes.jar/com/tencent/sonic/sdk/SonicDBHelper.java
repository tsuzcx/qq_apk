package com.tencent.sonic.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public class SonicDBHelper
  extends SQLiteOpenHelper
{
  private static final int SONIC_DATABASE_FIRST_VERSION = 1;
  private static final String SONIC_DATABASE_NAME = "sonic.db";
  private static final int SONIC_DATABASE_VERSION = 3;
  private static final String TAG = "SonicSdk_SonicDBHelper";
  private static AtomicBoolean isDBUpgrading = new AtomicBoolean(false);
  private static SonicDBHelper sInstance = null;
  
  private SonicDBHelper(Context paramContext)
  {
    super(paramContext, "sonic.db", null, 3);
  }
  
  static SonicDBHelper createInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new SonicDBHelper(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private void doUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      upgradeToVersion_2(paramSQLiteDatabase);
    }
    upgradeToVersion_3(paramSQLiteDatabase);
  }
  
  public static SonicDBHelper getInstance()
  {
    try
    {
      if (sInstance == null) {
        throw new IllegalStateException("SonicDBHelper::createInstance() needs to be called before SonicDBHelper::getInstance()!");
      }
    }
    finally {}
    SonicDBHelper localSonicDBHelper = sInstance;
    return localSonicDBHelper;
  }
  
  private void upgradeToVersion_2(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ResourceData ( id  integer PRIMARY KEY autoincrement , resourceID text not null , resourceSha1 text not null , resourceSize integer default 0 , resourceUpdateTime integer default 0 , cacheExpiredTime integer default 0 ); ");
  }
  
  private void upgradeToVersion_3(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS SessionChunkData ( id  integer PRIMARY KEY autoincrement , sessionId text not null , eTag text not null , chunkKey text not null , chunkSha1 text not null ); ");
  }
  
  public boolean isUpgrading()
  {
    return isDBUpgrading.get();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS SessionData ( id  integer PRIMARY KEY autoincrement , sessionID text not null , eTag text not null , templateTag text , htmlSha1 text not null , UnavailableTime integer default 0 , htmlSize integer default 0 , templateUpdateTime integer default 0 , cacheExpiredTime integer default 0 , cacheHitCount integer default 0 , isRedPointPreload integer default 0 ); ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS SessionChunkData ( id  integer PRIMARY KEY autoincrement , sessionId text not null , eTag text not null , chunkKey text not null , chunkSha1 text not null ); ");
    onUpgrade(paramSQLiteDatabase, -1, 3);
    doUpgrade(paramSQLiteDatabase, 1, 3);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    long l;
    if (isDBUpgrading.compareAndSet(false, true))
    {
      l = System.currentTimeMillis();
      SonicUtils.log("SonicSdk_SonicDBHelper", 4, "onUpgrade start, from " + paramInt1 + " to " + paramInt2 + ".");
      if (-1 != paramInt1) {
        break label114;
      }
      SonicEngine.getInstance().getRuntime().postTaskToThread(new SonicDBHelper.1(this), 0L);
    }
    for (;;)
    {
      SonicUtils.log("SonicSdk_SonicDBHelper", 4, "onUpgrade finish, cost " + (System.currentTimeMillis() - l) + "ms.");
      return;
      label114:
      doUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
      isDBUpgrading.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicDBHelper
 * JD-Core Version:    0.7.0.1
 */