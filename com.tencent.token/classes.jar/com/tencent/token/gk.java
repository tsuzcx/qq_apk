package com.tencent.token;

import android.content.ContentValues;
import com.tencent.kingkong.Cursor;
import com.tencent.kingkong.database.SQLiteDatabase;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.a;

public final class gk
  implements go
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
  
  public gk(gj paramgj) {}
  
  public final go a(Cursor paramCursor)
  {
    int n = 0;
    gk localgk = new gk(this.m);
    localgk.a = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
    localgk.c = paramCursor.getString(paramCursor.getColumnIndex("email"));
    localgk.d = paramCursor.getString(paramCursor.getColumnIndex("nick_name"));
    localgk.e = paramCursor.getString(paramCursor.getColumnIndex("uin_mask"));
    localgk.g = paramCursor.getBlob(paramCursor.getColumnIndex("head_image"));
    localgk.h = paramCursor.getLong(paramCursor.getColumnIndex("head_image_update_time"));
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("flag"));
    if ((1L & l1) != 0L)
    {
      bool = true;
      localgk.f = bool;
      if ((0x2 & l1) == 0L) {
        break label378;
      }
      bool = true;
      label175:
      localgk.i = bool;
      if ((0x8 & l1) == 0L) {
        break label384;
      }
      bool = true;
      label195:
      localgk.k = bool;
      if ((0x4 & l1) != 0L) {
        break label390;
      }
      bool = true;
      label215:
      localgk.j = bool;
      if ((l1 & 0x10) == 0L) {
        break label396;
      }
    }
    byte[] arrayOfByte;
    label384:
    label390:
    label396:
    for (boolean bool = true;; bool = false)
    {
      localgk.l = bool;
      if (!localgk.j) {
        localgk.a = (-localgk.a);
      }
      if ((localgk.g == null) || (localgk.g.length < 64)) {
        break label421;
      }
      paramCursor = localgk.g;
      if ((paramCursor[0] != a.a[0]) || (paramCursor[1] != a.a[1]) || (paramCursor[2] != a.a[2]) || (paramCursor[3] != a.a[3])) {
        break label421;
      }
      arrayOfByte = new byte[60];
      System.arraycopy(paramCursor, 4, arrayOfByte, 0, 60);
      while ((n < 60) && (arrayOfByte[n] == 0))
      {
        arrayOfByte[n] = 48;
        n += 1;
      }
      bool = false;
      break;
      label378:
      bool = false;
      break label175;
      bool = false;
      break label195;
      bool = false;
      break label215;
    }
    paramCursor = new String(arrayOfByte);
    try
    {
      localgk.b = Long.parseLong(paramCursor);
      label421:
      return localgk;
    }
    catch (Exception paramCursor)
    {
      localgk.b = 0L;
    }
    return localgk;
  }
  
  public final String a()
  {
    return "table_user";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_user(uin INTEGER PRIMARY KEY,email TEXT,nick_name TEXT, uin_mask TEXT, flag INTEGER,head_image BLOB, head_image_update_time INTEGER);");
  }
  
  final boolean a(QQUser paramQQUser)
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
  
  public final long b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!this.j)
    {
      this.g = new byte[64];
      localObject = this.b + "";
      System.arraycopy(a.a, 0, this.g, 0, a.a.length);
      System.arraycopy(((String)localObject).getBytes(), 0, this.g, this.g.length - ((String)localObject).length(), ((String)localObject).length());
    }
    long l1 = c();
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
  
  public final ContentValues b()
  {
    return null;
  }
  
  public final long c()
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
  
  final QQUser d()
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
 * Qualified Name:     com.tencent.token.gk
 * JD-Core Version:    0.7.0.1
 */