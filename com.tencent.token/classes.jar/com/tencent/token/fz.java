package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.a;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;

public class fz
  implements gd
{
  long a;
  long b;
  String c;
  String d;
  String e;
  boolean f;
  byte[] g;
  long h;
  boolean i;
  boolean j;
  boolean k;
  boolean l;
  
  public fz(fy paramfy) {}
  
  public long a()
  {
    if (this.f) {}
    for (long l2 = 1L;; l2 = 0L)
    {
      long l1 = l2;
      if (this.i) {
        l1 = l2 | 0x2;
      }
      l2 = l1;
      if (!this.j) {
        l2 = l1 | 0x4;
      }
      l1 = l2;
      if (this.k) {
        l1 = l2 | 0x8;
      }
      l2 = l1;
      if (this.l) {
        l2 = l1 | 0x10;
      }
      return l2;
    }
  }
  
  public gd a(Cursor paramCursor)
  {
    int n = 0;
    fz localfz = new fz(this.m);
    localfz.a = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
    localfz.c = paramCursor.getString(paramCursor.getColumnIndex("email"));
    localfz.d = paramCursor.getString(paramCursor.getColumnIndex("nick_name"));
    localfz.e = paramCursor.getString(paramCursor.getColumnIndex("uin_mask"));
    localfz.g = paramCursor.getBlob(paramCursor.getColumnIndex("head_image"));
    localfz.h = paramCursor.getLong(paramCursor.getColumnIndex("head_image_update_time"));
    a(localfz, paramCursor.getLong(paramCursor.getColumnIndex("flag")));
    if (!localfz.j) {
      localfz.a = (-localfz.a);
    }
    if ((localfz.g != null) && (localfz.g.length >= 64))
    {
      paramCursor = localfz.g;
      if ((paramCursor[0] == a.a[0]) && (paramCursor[1] == a.a[1]) && (paramCursor[2] == a.a[2]) && (paramCursor[3] == a.a[3]))
      {
        byte[] arrayOfByte = new byte[60];
        System.arraycopy(paramCursor, 4, arrayOfByte, 0, 60);
        while ((n < 60) && (arrayOfByte[n] == 0))
        {
          arrayOfByte[n] = 48;
          n += 1;
        }
        paramCursor = new String(arrayOfByte);
      }
    }
    try
    {
      localfz.b = Long.parseLong(paramCursor);
      return localfz;
    }
    catch (Exception paramCursor)
    {
      localfz.b = 0L;
    }
    return localfz;
  }
  
  public void a(fz paramfz, long paramLong)
  {
    boolean bool2 = true;
    if ((1L & paramLong) != 0L)
    {
      bool1 = true;
      paramfz.f = bool1;
      if ((0x2 & paramLong) == 0L) {
        break label104;
      }
      bool1 = true;
      label33:
      paramfz.i = bool1;
      if ((0x8 & paramLong) == 0L) {
        break label110;
      }
      bool1 = true;
      label52:
      paramfz.k = bool1;
      if ((0x4 & paramLong) != 0L) {
        break label116;
      }
      bool1 = true;
      label71:
      paramfz.j = bool1;
      if ((0x10 & paramLong) == 0L) {
        break label122;
      }
    }
    label104:
    label110:
    label116:
    label122:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramfz.l = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label33;
      bool1 = false;
      break label52;
      bool1 = false;
      break label71;
    }
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_user(uin INTEGER PRIMARY KEY,email TEXT,nick_name TEXT, uin_mask TEXT, flag INTEGER,head_image BLOB, head_image_update_time INTEGER);");
  }
  
  boolean a(QQUser paramQQUser)
  {
    this.a = paramQQUser.mUin;
    this.c = paramQQUser.mEmail;
    this.d = paramQQUser.mNickName;
    this.h = paramQQUser.mHeadImageUpdateTime;
    this.g = null;
    this.f = paramQQUser.mIsCurrentUser;
    this.e = paramQQUser.mUinMask;
    this.i = paramQQUser.mIsSupperQQ;
    this.k = paramQQUser.mIsRegisterFacePwd;
    this.j = paramQQUser.mIsBinded;
    this.l = paramQQUser.mIsZzb;
    this.b = paramQQUser.mRealUin;
    return true;
  }
  
  public long b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!this.j)
    {
      this.g = new byte[64];
      localObject = this.b + "";
      System.arraycopy(a.a, 0, this.g, 0, a.a.length);
      System.arraycopy(((String)localObject).getBytes(), 0, this.g, this.g.length - ((String)localObject).length(), ((String)localObject).length());
    }
    long l1 = a();
    Object localObject = new ContentValues();
    if (this.j) {
      ((ContentValues)localObject).put("uin", Long.valueOf(this.a));
    }
    for (;;)
    {
      ((ContentValues)localObject).put("email", this.c);
      ((ContentValues)localObject).put("nick_name", this.d);
      ((ContentValues)localObject).put("uin_mask", this.e);
      ((ContentValues)localObject).put("flag", Long.valueOf(l1));
      ((ContentValues)localObject).put("head_image", this.g);
      ((ContentValues)localObject).put("head_image_update_time", Long.valueOf(this.h));
      return paramSQLiteDatabase.insert("table_user", null, (ContentValues)localObject);
      ((ContentValues)localObject).put("uin", Long.valueOf(-this.a));
    }
  }
  
  public String b()
  {
    return "table_user";
  }
  
  public ContentValues c()
  {
    return null;
  }
  
  QQUser d()
  {
    QQUser localQQUser = new QQUser();
    localQQUser.mUin = this.a;
    localQQUser.mEmail = this.c;
    localQQUser.mNickName = this.d;
    localQQUser.mUinMask = this.e;
    localQQUser.mIsCurrentUser = this.f;
    localQQUser.mIsSupperQQ = this.i;
    localQQUser.mIsRegisterFacePwd = this.k;
    localQQUser.mIsBinded = this.j;
    localQQUser.mIsZzb = this.l;
    localQQUser.mRealUin = this.b;
    localQQUser.mHeadImageUpdateTime = this.h;
    return localQQUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fz
 * JD-Core Version:    0.7.0.1
 */