package com.tencent.biz.common.download;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadDao
{
  private DBHelper a;
  
  public DownloadDao(Context paramContext)
  {
    this.a = new DBHelper(paramContext);
  }
  
  public List a(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = this.a.getReadableDatabase().rawQuery("select thread_id, start_pos, end_pos,compelete_size,url from download_info where url=?", new String[] { paramString });
      while (paramString.moveToNext()) {
        localArrayList.add(new DownloadInfo(paramString.getInt(0), paramString.getInt(1), paramString.getInt(2), paramString.getInt(3), paramString.getString(4)));
      }
      paramString.close();
      return localArrayList;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public void a()
  {
    this.a.close();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      this.a.getReadableDatabase().execSQL("update download_info set compelete_size=? where thread_id=? and url=?", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void a(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.getReadableDatabase();
      localSQLiteDatabase.delete("download_info", "url=?", new String[] { paramString });
      localSQLiteDatabase.close();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void a(List paramList)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        localSQLiteDatabase.execSQL("insert into download_info(thread_id,start_pos, end_pos,compelete_size,url) values (?,?,?,?,?)", new Object[] { Integer.valueOf(localDownloadInfo.a()), Integer.valueOf(localDownloadInfo.b()), Integer.valueOf(localDownloadInfo.c()), Integer.valueOf(localDownloadInfo.d()), localDownloadInfo.a() });
      }
      return;
    }
    catch (Throwable paramList) {}
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = this.a.getReadableDatabase().rawQuery("select count(*)  from download_info where url=?", new String[] { paramString });
      paramString.moveToFirst();
      int i = paramString.getInt(0);
      paramString.close();
      if (i == 0) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Throwable paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.download.DownloadDao
 * JD-Core Version:    0.7.0.1
 */