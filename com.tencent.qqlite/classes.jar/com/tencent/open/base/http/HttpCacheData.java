package com.tencent.open.base.http;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.component.cache.database.DbCacheData;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;
import fdd;

public class HttpCacheData
  extends DbCacheData
{
  public static final DbCacheData.DbCreator a;
  public static final String a = "urlKey";
  protected static final String b = "TEXT";
  protected static final String c = "ETag";
  protected static final String d = "TEXT";
  protected static final String e = "lastModify";
  protected static final String f = "INTEGER";
  protected static final String g = "cacheTime";
  protected static final String h = "INTEGER";
  protected static final String i = "response";
  protected static final String j = "BLOB";
  public long a;
  public long b;
  public String k;
  public String l;
  public String m;
  
  static
  {
    jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheData$DbCreator = new fdd();
  }
  
  public HttpCacheData(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    this.k = paramString1;
    this.l = paramString2;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.m = paramString3;
  }
  
  HttpCacheData(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.k = MD5Utils.b(paramString1);
    this.l = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.b = System.currentTimeMillis();
    this.m = paramString3;
  }
  
  public void a(ContentValues paramContentValues)
  {
    paramContentValues.put("urlKey", this.k);
    paramContentValues.put("ETag", this.l);
    paramContentValues.put("lastModify", Long.valueOf(this.jdField_a_of_type_Long));
    paramContentValues.put("cacheTime", Long.valueOf(this.b));
    Parcel localParcel = Parcel.obtain();
    localParcel.writeString(this.m);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("response", arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCacheData
 * JD-Core Version:    0.7.0.1
 */