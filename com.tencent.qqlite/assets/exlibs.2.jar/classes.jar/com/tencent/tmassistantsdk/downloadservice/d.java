package com.tencent.tmassistantsdk.downloadservice;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.e.a;
import com.tencent.tmassistantsdk.e.b;
import com.tencent.tmassistantsdk.f.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  boolean g;
  public int h;
  public int i;
  public long j;
  public String k;
  protected String l;
  public int m;
  public int n;
  public String o;
  public long p;
  private long q;
  private HashMap r;
  private String s;
  
  public d()
  {
    this.g = false;
  }
  
  public d(String paramString1, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.c = c.a(paramString1);
    this.f = UUID.randomUUID().toString();
    this.m = paramInt;
    this.i = 0;
    this.n = 0;
    this.g = false;
    this.a = paramString2;
    this.o = c.b();
    this.p = 0L;
  }
  
  public static d a(Cursor paramCursor)
  {
    d locald = new d();
    locald.h = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    locald.f = paramCursor.getString(paramCursor.getColumnIndex("uId"));
    locald.c = paramCursor.getString(paramCursor.getColumnIndex("finalUrl"));
    locald.b = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    locald.k = paramCursor.getString(paramCursor.getColumnIndex("fileName"));
    locald.a = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    locald.e = paramCursor.getInt(paramCursor.getColumnIndex("redirectCnt"));
    locald.d = paramCursor.getInt(paramCursor.getColumnIndex("retryCnt"));
    locald.q = paramCursor.getLong(paramCursor.getColumnIndex("totalBytes"));
    locald.i = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    locald.j = paramCursor.getLong(paramCursor.getColumnIndex("receivedBytes"));
    locald.m = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    locald.o = paramCursor.getString(paramCursor.getColumnIndex("netType"));
    locald.n = paramCursor.getInt(paramCursor.getColumnIndex("downloadFailedErrCode"));
    locald.p = paramCursor.getLong(paramCursor.getColumnIndex("downloadFailedTime"));
    locald.s = paramCursor.getString(paramCursor.getColumnIndex("headerParams"));
    return locald;
  }
  
  public static void a(ContentValues paramContentValues, d paramd)
  {
    if ((paramd != null) && (paramContentValues != null))
    {
      paramContentValues.put("taskId", Integer.valueOf(paramd.h));
      paramContentValues.put("uId", paramd.f);
      paramContentValues.put("finalUrl", paramd.c);
      paramContentValues.put("taskUrl", paramd.b);
      paramContentValues.put("fileName", paramd.k);
      paramContentValues.put("contentType", paramd.a);
      paramContentValues.put("redirectCnt", Integer.valueOf(paramd.e));
      paramContentValues.put("retryCnt", Integer.valueOf(paramd.d));
      paramContentValues.put("totalBytes", Long.valueOf(paramd.q));
      paramContentValues.put("status", Integer.valueOf(paramd.i));
      paramContentValues.put("receivedBytes", Long.valueOf(paramd.j));
      paramContentValues.put("priority", Integer.valueOf(paramd.m));
      paramContentValues.put("netType", paramd.o);
      paramContentValues.put("downloadFailedErrCode", Integer.valueOf(paramd.n));
      paramContentValues.put("downloadFailedTime", Long.valueOf(paramd.p));
      paramContentValues.put("headerParams", paramd.s);
    }
  }
  
  public static d b(Cursor paramCursor)
  {
    d locald = new d();
    locald.h = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    locald.f = paramCursor.getString(paramCursor.getColumnIndex("uId"));
    locald.c = paramCursor.getString(paramCursor.getColumnIndex("finalUrl"));
    locald.b = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    locald.k = paramCursor.getString(paramCursor.getColumnIndex("fileName"));
    locald.a = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    locald.e = paramCursor.getInt(paramCursor.getColumnIndex("redirectCnt"));
    locald.d = paramCursor.getInt(paramCursor.getColumnIndex("retryCnt"));
    locald.q = paramCursor.getLong(paramCursor.getColumnIndex("totalBytes"));
    locald.i = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    locald.j = paramCursor.getLong(paramCursor.getColumnIndex("receivedBytes"));
    locald.m = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    locald.o = null;
    locald.n = 0;
    locald.p = 0L;
    locald.s = null;
    return locald;
  }
  
  public final HashMap a()
  {
    return this.r;
  }
  
  public final void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        int i1 = this.i;
        if (i1 > 3)
        {
          i1 = 1;
          if (i1 == 0) {}
        }
        else
        {
          i1 = 0;
          continue;
        }
        this.i = paramInt;
        if (this.i != 6)
        {
          if (this.i == 5) {
            this.p = System.currentTimeMillis();
          }
          a.a();
          a.a(this);
          e.a().a(this.b, this.i, this.n, "");
          continue;
        }
        a.a();
      }
      finally {}
      a.a(this.b);
    }
  }
  
  public final void a(long paramLong)
  {
    if (0L == paramLong) {
      this.j = 0L;
    }
    this.q = paramLong;
    a.a();
    a.a(this);
  }
  
  public final void a(String paramString)
  {
    k.b(paramString, "--------dump DownloadInfo-----------");
    k.b(paramString, "mContentType: " + this.a);
    k.b(paramString, "mURL: " + this.b);
    k.b(paramString, "mRetryCnt: " + this.d);
    k.b(paramString, "mRedirectCnt: " + this.e);
    k.b(paramString, "mTotalBytes: " + this.q);
    k.b(paramString, "mUUID: " + this.f);
    k.b(paramString, "mStatus: " + this.i);
    k.b(paramString, "mReceivedBytes: " + this.j);
    k.b(paramString, "mFileName: " + this.k);
    k.b(paramString, "mDownloadFailedErrCode: " + this.n);
    k.b(paramString, "mNetType:" + this.o);
    k.b(paramString, "mDownloadFailedTime:" + this.p);
    k.b(paramString, "mHeaderParamString:" + this.s);
  }
  
  public final void a(HashMap paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      this.r = paramHashMap;
      this.s = new JSONObject(paramHashMap).toString();
    }
  }
  
  public final long b()
  {
    return this.q;
  }
  
  public final void b(long paramLong)
  {
    this.j += paramLong;
    e.a().a(this.b, this.j, this.q);
  }
  
  final boolean c()
  {
    return (this.q != 0L) && (this.j == this.q);
  }
  
  public final int d()
  {
    k.b("_DownloadInfo", "DownloadInfo::startDownloadIfReady url: " + this.b);
    if ((!TextUtils.isEmpty(this.s)) && ((this.r == null) || (this.r.size() <= 0)))
    {
      HashMap localHashMap = new HashMap();
      try
      {
        JSONObject localJSONObject = new JSONObject(this.s);
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localJSONObject.getString(str));
          continue;
          if (!this.g) {
            break label155;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    for (;;)
    {
      return 5;
      if (localJSONException.size() > 0) {
        this.r = localJSONException;
      }
    }
    label155:
    if (this.k == null) {
      this.k = c.a(this.b, this.a);
    }
    if (this.l == null) {
      this.l = c.a(this.b, this.a);
    }
    if (this.q == 0L) {
      new b(this.l, this.k).a();
    }
    if (this.i == 5) {
      this.c = this.b;
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.k))
    {
      localObject = new b(this.l, this.k);
      long l1 = ((b)localObject).b();
      k.b("_DownloadInfo", "FileLen: " + l1 + " filename: " + this.k);
      if (l1 > this.q)
      {
        ((b)localObject).a();
        this.j = 0L;
        if ((this.q == 0L) || (this.j != this.q)) {
          break label377;
        }
      }
      label377:
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label382;
        }
        ((b)localObject).e();
        a(4);
        return 4;
        this.j = l1;
        break;
      }
    }
    label382:
    if (this.i == 5)
    {
      this.e = 0;
      this.d = 0;
      this.i = 0;
      this.n = 0;
    }
    k.b("_DownloadInfo", "startDownloadIfReady...");
    a("_DownloadInfo");
    if (h.a().a(this.b) == null)
    {
      localObject = new g(this);
      a(1);
      this.h = h.a().a((g)localObject);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.d
 * JD-Core Version:    0.7.0.1
 */