package com.tencent.biz.common.download;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadDao
{
  private DBHelper jdField_a_of_type_ComTencentBizCommonDownloadDBHelper;
  final String jdField_a_of_type_JavaLangString = "DownloadDao";
  
  public DownloadDao(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizCommonDownloadDBHelper = new DBHelper(paramContext);
  }
  
  public List a(String paramString)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      paramString = this.jdField_a_of_type_ComTencentBizCommonDownloadDBHelper.getReadableDatabase().rawQuery("select thread_id, start_pos, end_pos,compelete_size,url from download_info where url=?", new String[] { paramString });
      while (paramString.moveToNext()) {
        localArrayList.add(new DownloadInfo(paramString.getInt(0), paramString.getInt(1), paramString.getInt(2), paramString.getInt(3), paramString.getString(4)));
      }
      paramString.close();
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloadDao", 2, "getInfos Exception");
      }
      paramString.printStackTrace();
      return null;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizCommonDownloadDBHelper.close();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizCommonDownloadDBHelper.getReadableDatabase().execSQL("update download_info set compelete_size=? where thread_id=? and url=?", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
      return;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloadDao", 2, "updataInfos SQLException");
      }
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloadDao", 2, "updataInfos Exception");
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentBizCommonDownloadDBHelper.getReadableDatabase();
      localSQLiteDatabase.delete("download_info", "url=?", new String[] { paramString });
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloadDao", 2, "delete Exception");
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(List paramList)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentBizCommonDownloadDBHelper.getWritableDatabase();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        localSQLiteDatabase.execSQL("insert into download_info(thread_id,start_pos, end_pos,compelete_size,url) values (?,?,?,?,?)", new Object[] { Integer.valueOf(localDownloadInfo.a()), Integer.valueOf(localDownloadInfo.b()), Integer.valueOf(localDownloadInfo.c()), Integer.valueOf(localDownloadInfo.d()), localDownloadInfo.a() });
      }
      return;
    }
    catch (SQLException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloadDao", 2, "saveInfos SQLException");
      }
      paramList.printStackTrace();
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloadDao", 2, "saveInfos Exception");
      }
      paramList.printStackTrace();
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_ComTencentBizCommonDownloadDBHelper.getReadableDatabase().rawQuery("select count(*)  from download_info where url=?", new String[] { paramString });
        paramString.moveToFirst();
        int i = paramString.getInt(0);
        paramString.close();
        if (i == 0) {
          return bool;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DownloadDao", 2, "isHasInfors Exception");
        }
        paramString.printStackTrace();
        return false;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.common.download.DownloadDao
 * JD-Core Version:    0.7.0.1
 */