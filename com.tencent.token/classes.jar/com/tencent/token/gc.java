package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class gc
  implements gd
{
  private long b;
  private long c;
  private int d;
  private int e;
  private String f;
  private String g;
  private long h;
  private int i;
  private int j;
  private int k;
  private String l;
  private String m;
  private byte[] n;
  
  public gc(gb paramgb) {}
  
  public SafeMsgItem a()
  {
    Object localObject1;
    if (this.n != null) {
      localObject1 = new ByteArrayInputStream(this.n);
    }
    for (;;)
    {
      boolean bool;
      try
      {
        SafeMsgItem localSafeMsgItem5 = (SafeMsgItem)new ObjectInputStream((InputStream)localObject1).readObject();
        localObject1 = localSafeMsgItem5;
        if (localSafeMsgItem5 == null) {
          localObject1 = new SafeMsgItem();
        }
      }
      catch (StreamCorruptedException localStreamCorruptedException)
      {
        localStreamCorruptedException.printStackTrace();
        if (0 != 0) {
          break label235;
        }
        SafeMsgItem localSafeMsgItem1 = new SafeMsgItem();
        continue;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        if (0 != 0) {
          break label235;
        }
        SafeMsgItem localSafeMsgItem2 = new SafeMsgItem();
        continue;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        if (0 != 0) {
          break label235;
        }
        SafeMsgItem localSafeMsgItem3 = new SafeMsgItem();
        continue;
      }
      finally
      {
        if (0 != 0) {
          continue;
        }
        new SafeMsgItem();
      }
      SafeMsgItem localSafeMsgItem4;
      if (this.e == 0)
      {
        bool = false;
        ((SafeMsgItem)localObject1).mIsRead = bool;
        ((SafeMsgItem)localObject1).mUin = this.c;
        ((SafeMsgItem)localObject1).a(this.b);
        ((SafeMsgItem)localObject1).a(this.d);
        ((SafeMsgItem)localObject1).a(this.f);
        ((SafeMsgItem)localObject1).b(this.h);
        ((SafeMsgItem)localObject1).b(this.g);
        ((SafeMsgItem)localObject1).c(this.l);
        ((SafeMsgItem)localObject1).b(this.i);
        ((SafeMsgItem)localObject1).c(this.j);
        ((SafeMsgItem)localObject1).d(this.k);
        return localObject1;
        localSafeMsgItem4 = new SafeMsgItem();
      }
      else
      {
        bool = true;
        continue;
        label235:
        localSafeMsgItem4 = null;
      }
    }
  }
  
  public gd a(Cursor paramCursor)
  {
    gc localgc = new gc(this.a);
    localgc.b = paramCursor.getLong(paramCursor.getColumnIndex("fid"));
    localgc.c = paramCursor.getLong(paramCursor.getColumnIndex("fuin"));
    localgc.d = paramCursor.getInt(paramCursor.getColumnIndex("flag"));
    localgc.e = paramCursor.getInt(paramCursor.getColumnIndex("fis_read"));
    localgc.f = paramCursor.getString(paramCursor.getColumnIndex("ftitle"));
    localgc.g = paramCursor.getString(paramCursor.getColumnIndex("fcontent"));
    localgc.h = paramCursor.getLong(paramCursor.getColumnIndex("ftime"));
    localgc.i = paramCursor.getInt(paramCursor.getColumnIndex("ftype"));
    localgc.j = paramCursor.getInt(paramCursor.getColumnIndex("fsub_type"));
    localgc.k = paramCursor.getInt(paramCursor.getColumnIndex("fdetail_type"));
    localgc.l = paramCursor.getString(paramCursor.getColumnIndex("furi"));
    localgc.m = paramCursor.getString(paramCursor.getColumnIndex("faction"));
    localgc.n = paramCursor.getBlob(paramCursor.getColumnIndex("freserved1"));
    return localgc;
  }
  
  public void a(SafeMsgItem paramSafeMsgItem)
  {
    this.c = paramSafeMsgItem.mUin;
    this.d = paramSafeMsgItem.b();
    int i1;
    if (paramSafeMsgItem.mIsRead) {
      i1 = 1;
    }
    for (;;)
    {
      this.e = i1;
      this.f = paramSafeMsgItem.c();
      this.g = paramSafeMsgItem.d();
      this.h = paramSafeMsgItem.e();
      this.i = paramSafeMsgItem.f();
      this.j = paramSafeMsgItem.g();
      this.k = paramSafeMsgItem.h();
      this.l = paramSafeMsgItem.j();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        localObjectOutputStream.writeObject(paramSafeMsgItem);
        localObjectOutputStream.flush();
        this.n = localByteArrayOutputStream.toByteArray();
        return;
        i1 = 0;
      }
      catch (IOException paramSafeMsgItem)
      {
        for (;;)
        {
          paramSafeMsgItem.printStackTrace();
        }
      }
    }
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + gb.a(this.a) + " (" + "fid" + " INTEGER PRIMARY KEY autoincrement," + "fuin" + " INTEGER," + "flag" + " INTEGER," + "fis_read" + " INTEGER," + "ftitle" + " TEXT," + "fcontent" + " TEXT," + "ftime" + " INTEGER," + "ftype" + " INTEGER," + "fsub_type" + " INTEGER," + "fdetail_type" + " INTEGER," + "furi" + " TEXT," + "faction" + " TEXT," + "freserved1" + " BLOB);");
  }
  
  public long b(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fuin", Long.valueOf(this.c));
    localContentValues.put("flag", Integer.valueOf(this.d));
    localContentValues.put("fis_read", Integer.valueOf(this.e));
    localContentValues.put("ftitle", this.f);
    localContentValues.put("ftime", Long.valueOf(this.h));
    localContentValues.put("fcontent", this.g);
    localContentValues.put("ftype", Integer.valueOf(this.i));
    localContentValues.put("fsub_type", Integer.valueOf(this.j));
    localContentValues.put("fdetail_type", Integer.valueOf(this.k));
    localContentValues.put("furi", this.l);
    localContentValues.put("faction", this.m);
    localContentValues.put("freserved1", this.n);
    return paramSQLiteDatabase.insert(gb.a(this.a), null, localContentValues);
  }
  
  public String b()
  {
    return gb.a(this.a);
  }
  
  public ContentValues c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gc
 * JD-Core Version:    0.7.0.1
 */