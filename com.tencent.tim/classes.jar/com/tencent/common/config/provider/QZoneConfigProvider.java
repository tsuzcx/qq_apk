package com.tencent.common.config.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import sxd;
import sxe;

public class QZoneConfigProvider
  extends ContentProvider
  implements sxe
{
  private static final UriMatcher b = ;
  private sxd a;
  
  private int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = this.a.e(paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = this.a.a(paramUri, "table_qz_unread", paramArrayOfContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private static UriMatcher a()
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    localUriMatcher.addURI("com.tencent.tim.common.config.provider.QZoneConfigProvider", "qz_configs", 1);
    localUriMatcher.addURI("com.tencent.tim.common.config.provider.QZoneConfigProvider", "qz_cookie", 2);
    localUriMatcher.addURI("com.tencent.tim.common.config.provider.QZoneConfigProvider", "qz_update", 3);
    localUriMatcher.addURI("com.tencent.tim.common.config.provider.QZoneConfigProvider", "qz_isp_config", 4);
    localUriMatcher.addURI("com.tencent.tim.common.config.provider.QZoneConfigProvider", "qz_delete", 6);
    localUriMatcher.addURI("com.tencent.tim.common.config.provider.QZoneConfigProvider", "qz_check_time", 5);
    localUriMatcher.addURI("com.tencent.tim.common.config.provider.QZoneConfigProvider", "qz_navigator_bar", 8);
    localUriMatcher.addURI("com.tencent.tim.common.config.provider.QZoneConfigProvider", "table_qz_unread", 9);
    return localUriMatcher;
  }
  
  private Cursor a(String[] paramArrayOfString)
  {
    return this.a.a(paramArrayOfString);
  }
  
  private Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.a.a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.a.a(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private int b(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = this.a.a(paramUri, "qz_navigator_bar", paramArrayOfContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private Cursor b(String[] paramArrayOfString)
  {
    return this.a.b(paramArrayOfString);
  }
  
  private Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.a.b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.a.b(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor c(String[] paramArrayOfString)
  {
    return this.a.c(paramArrayOfString);
  }
  
  private Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.a.c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.a.c(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "cookie");
    paramUri = this.a.d(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor e(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.a.d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "check_time");
    paramUri = this.a.e(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "updatelog");
    paramUri = this.a.f(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = this.a.g(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    switch (b.match(paramUri))
    {
    default: 
      QZLog.e("QZoneConfigProvider", 1, new Object[] { "uri:", paramUri, "not used right" });
      return 0;
    case 9: 
      return a(paramUri, paramArrayOfContentValues);
    case 8: 
      return b(paramUri, paramArrayOfContentValues);
    }
    return this.a.a(paramUri, "qz_configs", paramArrayOfContentValues);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (b.match(paramUri))
    {
    case 7: 
    default: 
      return 0;
    case 1: 
      return this.a.b(paramString, paramArrayOfString);
    case 2: 
      return this.a.uC();
    case 3: 
      return this.a.uE();
    case 4: 
      return this.a.c(paramString, paramArrayOfString);
    case 6: 
      return this.a.uF();
    case 5: 
      return this.a.uD();
    case 8: 
      return this.a.d(paramString, paramArrayOfString);
    }
    return a(paramUri, paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return "";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (b.match(paramUri))
    {
    case 6: 
    case 7: 
    default: 
      return null;
    case 1: 
      return a(paramUri, paramContentValues);
    case 2: 
      return d(paramUri, paramContentValues);
    case 3: 
      return f(paramUri, paramContentValues);
    case 4: 
      return c(paramUri, paramContentValues);
    case 5: 
      return e(paramUri, paramContentValues);
    case 8: 
      return b(paramUri, paramContentValues);
    }
    return g(paramUri, paramContentValues);
  }
  
  public boolean onCreate()
  {
    this.a = new sxd(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      switch (b.match(paramUri))
      {
      case 1: 
        return b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      }
    }
    catch (Throwable paramUri)
    {
      if (!QLog.isColorLevel()) {
        break label138;
      }
      QLog.e("QZoneConfigProvider", 2, "query异常", paramUri);
      return null;
    }
    return a(paramArrayOfString1);
    return c(paramArrayOfString1);
    return c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    return b(paramArrayOfString1);
    return a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    paramUri = e(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    return paramUri;
    label138:
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZoneConfigProvider
 * JD-Core Version:    0.7.0.1
 */