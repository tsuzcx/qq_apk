package com.tencent.token;

import android.content.ContentValues;
import com.tencent.kingkong.Cursor;
import com.tencent.kingkong.database.SQLiteDatabase;
import com.tencent.token.core.bean.SafeMsgItem;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public final class gn
  implements go
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
  
  public gn(gm paramgm) {}
  
  public final go a(Cursor paramCursor)
  {
    gn localgn = new gn(this.a);
    localgn.b = paramCursor.getLong(paramCursor.getColumnIndex("fid"));
    localgn.c = paramCursor.getLong(paramCursor.getColumnIndex("fuin"));
    localgn.d = paramCursor.getInt(paramCursor.getColumnIndex("flag"));
    localgn.e = paramCursor.getInt(paramCursor.getColumnIndex("fis_read"));
    localgn.f = paramCursor.getString(paramCursor.getColumnIndex("ftitle"));
    localgn.g = paramCursor.getString(paramCursor.getColumnIndex("fcontent"));
    localgn.h = paramCursor.getLong(paramCursor.getColumnIndex("ftime"));
    localgn.i = paramCursor.getInt(paramCursor.getColumnIndex("ftype"));
    localgn.j = paramCursor.getInt(paramCursor.getColumnIndex("fsub_type"));
    localgn.k = paramCursor.getInt(paramCursor.getColumnIndex("fdetail_type"));
    localgn.l = paramCursor.getString(paramCursor.getColumnIndex("furi"));
    localgn.m = paramCursor.getString(paramCursor.getColumnIndex("faction"));
    localgn.n = paramCursor.getBlob(paramCursor.getColumnIndex("freserved1"));
    return localgn;
  }
  
  public final String a()
  {
    return gm.a(this.a);
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + gm.a(this.a) + " (" + "fid" + " INTEGER PRIMARY KEY autoincrement," + "fuin" + " INTEGER," + "flag" + " INTEGER," + "fis_read" + " INTEGER," + "ftitle" + " TEXT," + "fcontent" + " TEXT," + "ftime" + " INTEGER," + "ftype" + " INTEGER," + "fsub_type" + " INTEGER," + "fdetail_type" + " INTEGER," + "furi" + " TEXT," + "faction" + " TEXT," + "freserved1" + " BLOB" + ");");
  }
  
  public final void a(SafeMsgItem paramSafeMsgItem)
  {
    this.c = paramSafeMsgItem.mUin;
    this.d = paramSafeMsgItem.mFlag;
    int i1;
    if (paramSafeMsgItem.mIsRead) {
      i1 = 1;
    }
    for (;;)
    {
      this.e = i1;
      this.f = paramSafeMsgItem.mTitle;
      this.g = paramSafeMsgItem.mContent;
      this.h = paramSafeMsgItem.mTime;
      this.i = paramSafeMsgItem.mTypea;
      this.j = paramSafeMsgItem.mTypeb;
      this.k = paramSafeMsgItem.mTypec;
      this.l = paramSafeMsgItem.mUri;
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
  
  public final long b(SQLiteDatabase paramSQLiteDatabase)
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
    return paramSQLiteDatabase.insert(gm.a(this.a), null, localContentValues);
  }
  
  public final ContentValues b()
  {
    return null;
  }
  
  public final SafeMsgItem c()
  {
    Object localObject1;
    if (this.n != null)
    {
      localObject1 = new ByteArrayInputStream(this.n);
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
        for (;;)
        {
          localStreamCorruptedException.printStackTrace();
          localSafeMsgItem1 = new SafeMsgItem();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          localSafeMsgItem2 = new SafeMsgItem();
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
          localSafeMsgItem3 = new SafeMsgItem();
        }
      }
      finally
      {
        new SafeMsgItem();
      }
      if (this.e != 0) {
        break label214;
      }
    }
    label214:
    for (boolean bool = false;; bool = true)
    {
      ((SafeMsgItem)localObject1).mIsRead = bool;
      ((SafeMsgItem)localObject1).mUin = this.c;
      ((SafeMsgItem)localObject1).mId = this.b;
      ((SafeMsgItem)localObject1).mFlag = this.d;
      ((SafeMsgItem)localObject1).mTitle = this.f;
      ((SafeMsgItem)localObject1).mTime = this.h;
      ((SafeMsgItem)localObject1).mContent = this.g;
      ((SafeMsgItem)localObject1).mUri = this.l;
      ((SafeMsgItem)localObject1).mTypea = this.i;
      ((SafeMsgItem)localObject1).mTypeb = this.j;
      ((SafeMsgItem)localObject1).mTypec = this.k;
      return localObject1;
      SafeMsgItem localSafeMsgItem1;
      SafeMsgItem localSafeMsgItem2;
      SafeMsgItem localSafeMsgItem3;
      SafeMsgItem localSafeMsgItem4 = new SafeMsgItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gn
 * JD-Core Version:    0.7.0.1
 */