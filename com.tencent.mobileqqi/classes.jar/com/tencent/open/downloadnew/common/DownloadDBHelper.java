package com.tencent.open.downloadnew.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadDBHelper
  extends SQLiteOpenHelper
{
  public static final int a = 9;
  protected static volatile DownloadDBHelper a;
  protected static final String a;
  protected static final byte[] a;
  public static final String[] a;
  public static final int b = 0;
  public static final String b = "app_plugin_download.db";
  public static final int c = 1;
  protected static final String c = "download_info";
  public static final int d = 2;
  protected static final String d = "appid";
  public static final int e = 3;
  protected static final String e = "download_url";
  public static final int f = 4;
  protected static final String f = "package";
  public static final int g = 5;
  protected static final String g = "push_title";
  public static final int h = 6;
  protected static final String h = "sendtime_col";
  public static final int i = 7;
  protected static final String i = "uin_col";
  public static final int j = 8;
  protected static final String j = "triggertime_col";
  public static final int k = 9;
  protected static final String k = "via_col";
  public static final int l = 10;
  protected static final String l = "patch_url";
  public static final int m = 11;
  protected static final String m = "update_type";
  public static final int n = 12;
  protected static final String n = "myappid_col";
  public static final int o = 13;
  protected static final String o = "apkid_col";
  public static final int p = 14;
  protected static final String p = "version_col";
  public static final int q = 15;
  protected static final String q = "downloadtype_col";
  public static final int r = 16;
  protected static final String r = "filepath_col";
  public static final int s = 17;
  protected static final String s = "source_col";
  protected static final String t = "last_download_size";
  protected static final String u = "is_apk";
  protected long a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadDBHelper.class.getName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "appid", "download_url", "package", "push_title", "sendtime_col", "uin_col", "triggertime_col", "via_col", "patch_url", "update_type", "myappid_col", "apkid_col", "version_col", "downloadtype_col", "filepath_col", "source_col", "last_download_size", "is_apk" };
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected DownloadDBHelper(Context paramContext)
  {
    super(paramContext, "app_plugin_download.db", null, 9);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static DownloadDBHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper = new DownloadDBHelper(CommonDataAdapter.a().a());
      }
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long == 0L)
      {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long = CommonDataAdapter.a().a();
        if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long == 0L) {
          jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long = CommonDataAdapter.a().b();
        }
      }
      DownloadDBHelper localDownloadDBHelper = jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper;
      return localDownloadDBHelper;
    }
    finally {}
  }
  
  protected DownloadInfo a(Cursor paramCursor)
  {
    String str1 = paramCursor.getString(0);
    String str2 = paramCursor.getString(1);
    String str3 = paramCursor.getString(2);
    String str4 = paramCursor.getString(3);
    String str5 = paramCursor.getString(4);
    long l1 = paramCursor.getLong(6);
    String str6 = paramCursor.getString(7);
    String str7 = paramCursor.getString(8);
    int i1 = paramCursor.getInt(9);
    String str8 = paramCursor.getString(10);
    String str9 = paramCursor.getString(11);
    int i2 = paramCursor.getInt(12);
    int i3 = paramCursor.getInt(13);
    String str10 = paramCursor.getString(14);
    int i4 = paramCursor.getInt(15);
    long l2 = paramCursor.getLong(16);
    if (paramCursor.getInt(17) == 1) {}
    for (boolean bool = true;; bool = false) {
      return new DownloadInfo(str1, str2, str3, str4, str5, l1, str6, str7, i1, str8, str9, i2, i3, str10, i4, l2, bool);
    }
  }
  
  public DownloadInfo a(String paramString)
  {
    return a("package = ?", new String[] { paramString });
  }
  
  protected DownloadInfo a(String paramString, String[] paramArrayOfString)
  {
    for (;;)
    {
      Cursor localCursor;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
        localCursor = localSQLiteDatabase.query("download_info", jdField_a_of_type_ArrayOfJavaLangString, paramString, paramArrayOfString, null, null, null);
        try
        {
          if (localCursor.getCount() <= 0) {
            break label131;
          }
          localCursor.moveToFirst();
          paramString = a(localCursor);
          paramArrayOfString = paramString;
          if (localCursor != null)
          {
            localCursor.close();
            paramArrayOfString = paramString;
          }
        }
        catch (Exception paramString)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, "getDownloadInfo", paramString);
          if (localCursor == null) {
            break label126;
          }
          localCursor.close();
          paramArrayOfString = null;
          continue;
        }
        finally
        {
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
        }
        localSQLiteDatabase.close();
        return paramArrayOfString;
      }
      label126:
      paramArrayOfString = null;
      continue;
      label131:
      paramString = null;
    }
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = CommonDataAdapter.a().a();
      if (this.jdField_a_of_type_Long == 0L) {
        LogUtility.e(jdField_a_of_type_JavaLangString, "getUin() is empty!");
      }
    }
    return String.valueOf(this.jdField_a_of_type_Long);
  }
  
  public Map a()
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "getAllDownloadInfos");
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
      localCursor = localSQLiteDatabase.query("download_info", jdField_a_of_type_ArrayOfJavaLangString, null, null, null, null, null);
      try
      {
        if (localCursor.getCount() > 0)
        {
          localCursor.moveToFirst();
          boolean bool;
          do
          {
            String str = localCursor.getString(0);
            LogUtility.c(jdField_a_of_type_JavaLangString, "getAllDownloadInfos appId=" + str);
            DownloadInfo localDownloadInfo = a(localCursor);
            LogUtility.c(jdField_a_of_type_JavaLangString, "getAllDownloadInfos info=" + localDownloadInfo.toString());
            localConcurrentHashMap.put(str, localDownloadInfo);
            bool = localCursor.moveToNext();
          } while (bool);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, "getAllDownloadInfos>>>", localException);
          if (localCursor != null) {
            localCursor.close();
          }
        }
        localObject1 = finally;
        throw localObject1;
      }
      finally
      {
        if (localObject1 == null) {
          break label217;
        }
        localObject1.close();
      }
      localSQLiteDatabase.close();
      return localConcurrentHashMap;
    }
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    int i1 = 1;
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localSQLiteDatabase = getWritableDatabase();
      try
      {
        localSQLiteDatabase.beginTransaction();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("appid", paramDownloadInfo.jdField_b_of_type_JavaLangString);
        localContentValues.put("download_url", paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localContentValues.put("package", paramDownloadInfo.d);
        localContentValues.put("push_title", paramDownloadInfo.e);
        localContentValues.put("sendtime_col", paramDownloadInfo.jdField_f_of_type_JavaLangString);
        localContentValues.put("uin_col", a());
        localContentValues.put("triggertime_col", Long.valueOf(paramDownloadInfo.jdField_a_of_type_Long));
        localContentValues.put("via_col", paramDownloadInfo.jdField_g_of_type_JavaLangString);
        localContentValues.put("patch_url", paramDownloadInfo.jdField_h_of_type_JavaLangString);
        localContentValues.put("update_type", Integer.valueOf(paramDownloadInfo.jdField_f_of_type_Int));
        localContentValues.put("myappid_col", paramDownloadInfo.jdField_i_of_type_JavaLangString);
        localContentValues.put("apkid_col", paramDownloadInfo.j);
        localContentValues.put("version_col", Integer.valueOf(paramDownloadInfo.jdField_g_of_type_Int));
        localContentValues.put("downloadtype_col", Integer.valueOf(paramDownloadInfo.jdField_h_of_type_Int));
        localContentValues.put("filepath_col", paramDownloadInfo.k);
        localContentValues.put("source_col", Integer.valueOf(paramDownloadInfo.jdField_i_of_type_Int));
        localContentValues.put("last_download_size", Long.valueOf(paramDownloadInfo.jdField_b_of_type_Long));
        if (!paramDownloadInfo.jdField_c_of_type_Boolean) {
          break label363;
        }
        localContentValues.put("is_apk", Integer.valueOf(i1));
        i1 = localSQLiteDatabase.update("download_info", localContentValues, "appid = ?", new String[] { paramDownloadInfo.jdField_b_of_type_JavaLangString });
        LogUtility.a(jdField_a_of_type_JavaLangString, "addDownloadInfo>>>update affected rowNum=" + i1);
        if (i1 == 0)
        {
          long l1 = localSQLiteDatabase.insert("download_info", null, localContentValues);
          LogUtility.a(jdField_a_of_type_JavaLangString, "addDownloadInfo>>>insert rowID = " + l1);
        }
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (Exception paramDownloadInfo)
      {
        for (;;)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
          localSQLiteDatabase.endTransaction();
        }
        paramDownloadInfo = finally;
        throw paramDownloadInfo;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      localSQLiteDatabase.close();
      return;
      label363:
      i1 = 0;
    }
  }
  
  public void a(String paramString)
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localSQLiteDatabase = getWritableDatabase();
      try
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "deleteInfoByAppId:appid = ?" + Arrays.toString(new String[] { paramString }));
        localSQLiteDatabase.delete("download_info", "appid = ?", new String[] { paramString });
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, "deleteInfoByAppId>>>", paramString);
          if (localSQLiteDatabase != null) {
            localSQLiteDatabase.close();
          }
        }
        paramString = finally;
        throw paramString;
      }
      finally
      {
        if (localSQLiteDatabase == null) {
          break label112;
        }
        localSQLiteDatabase.close();
      }
      return;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (appid TEXT PRIMARY KEY,download_url TEXT,package TEXT,push_title TEXT,sendtime_col TEXT,uin_col TEXT,triggertime_col INTEGER,via_col TEXT,patch_url TEXT,update_type INTEGER,myappid_col TEXT,apkid_col TEXT,version_col INTEGER,downloadtype_col INTEGER,filepath_col TEXT,source_col INTEGER,last_download_size INTEGER,is_apk INTEGER); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadDBHelper
 * JD-Core Version:    0.7.0.1
 */