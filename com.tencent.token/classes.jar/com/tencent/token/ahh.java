package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.QQUser;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ahh
{
  public List<QQUser> a = new ArrayList();
  public boolean b = false;
  private boolean d = false;
  private QQUser e = null;
  
  private QQUser a(List<QQUser> paramList, long paramLong)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQUser localQQUser = (QQUser)paramList.next();
        long l = localQQUser.mUin;
        if (l == paramLong) {
          return localQQUser;
        }
      }
      return null;
    }
    finally {}
  }
  
  private boolean a(QQUser paramQQUser, boolean paramBoolean)
  {
    if ((!c) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    Object localObject = new a();
    ContentValues localContentValues = new ContentValues();
    ((a)localObject).a(paramQQUser);
    long l = ((a)localObject).c();
    localContentValues.put("flag", Long.valueOf(l));
    StringBuilder localStringBuilder = new StringBuilder("set user flag ");
    localStringBuilder.append(paramQQUser.mUinMask);
    localStringBuilder.append(":");
    localStringBuilder.append(l);
    xb.b(localStringBuilder.toString());
    if (ahi.a((ahk)localObject, "table_user", localContentValues, "uin=?", new String[] { String.valueOf(c(paramQQUser)) }) <= 0)
    {
      localObject = new StringBuilder("update uin flag failed, uin=");
      ((StringBuilder)localObject).append(paramQQUser.mUin);
      ((StringBuilder)localObject).append(", flag=");
      ((StringBuilder)localObject).append(l);
      xb.c(((StringBuilder)localObject).toString());
      return false;
    }
    paramQQUser.mIsCurrentUser = paramBoolean;
    return true;
  }
  
  private QQUser b(List<QQUser> paramList, long paramLong)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQUser localQQUser = (QQUser)paramList.next();
        long l = localQQUser.mRealUin;
        if (l == paramLong) {
          return localQQUser;
        }
      }
      return null;
    }
    finally {}
  }
  
  public static long c(QQUser paramQQUser)
  {
    if (!paramQQUser.mIsBinded) {
      return -paramQQUser.mRealUin;
    }
    return paramQQUser.mUin;
  }
  
  private boolean d(QQUser paramQQUser)
  {
    boolean bool;
    if (paramQQUser != null) {
      bool = true;
    } else {
      bool = false;
    }
    xb.a(bool);
    b();
    QQUser localQQUser = this.e;
    if (localQQUser == paramQQUser) {
      return true;
    }
    if (localQQUser != null)
    {
      localQQUser.mIsCurrentUser = false;
      a(localQQUser, false);
    }
    paramQQUser.mIsCurrentUser = true;
    a(paramQQUser, true);
    this.e = paramQQUser;
    return true;
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/token/ahh:d	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: getfield 38	com/tencent/token/ahh:d	Z
    //   13: istore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 36	com/tencent/token/ahh:a	Ljava/util/List;
    //   22: invokeinterface 165 1 0
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 40	com/tencent/token/ahh:e	Lcom/tencent/token/core/bean/QQUser;
    //   32: new 6	com/tencent/token/ahh$a
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 71	com/tencent/token/ahh$a:<init>	(Lcom/tencent/token/ahh;)V
    //   40: astore_2
    //   41: aload_2
    //   42: ldc 122
    //   44: bipush 7
    //   46: anewarray 126	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: ldc 167
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: ldc 169
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: ldc 171
    //   63: aastore
    //   64: dup
    //   65: iconst_3
    //   66: ldc 173
    //   68: aastore
    //   69: dup
    //   70: iconst_4
    //   71: ldc 82
    //   73: aastore
    //   74: dup
    //   75: iconst_5
    //   76: ldc 175
    //   78: aastore
    //   79: dup
    //   80: bipush 6
    //   82: ldc 177
    //   84: aastore
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokestatic 180	com/tencent/token/ahi:a	(Lcom/tencent/token/ahk;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   92: astore_2
    //   93: aload_2
    //   94: invokeinterface 47 1 0
    //   99: astore_3
    //   100: aload_3
    //   101: invokeinterface 52 1 0
    //   106: ifeq +157 -> 263
    //   109: aload_3
    //   110: invokeinterface 56 1 0
    //   115: checkcast 6	com/tencent/token/ahh$a
    //   118: astore 4
    //   120: getstatic 25	com/tencent/token/ahh:c	Z
    //   123: ifne +19 -> 142
    //   126: aload 4
    //   128: ifnull +6 -> 134
    //   131: goto +11 -> 142
    //   134: new 67	java/lang/AssertionError
    //   137: dup
    //   138: invokespecial 68	java/lang/AssertionError:<init>	()V
    //   141: athrow
    //   142: aload 4
    //   144: invokevirtual 182	com/tencent/token/ahh$a:d	()Lcom/tencent/token/core/bean/QQUser;
    //   147: astore 4
    //   149: aload 4
    //   151: getfield 152	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   154: ifeq -54 -> 100
    //   157: aload_0
    //   158: getfield 36	com/tencent/token/ahh:a	Ljava/util/List;
    //   161: aload 4
    //   163: invokeinterface 186 2 0
    //   168: pop
    //   169: new 94	java/lang/StringBuilder
    //   172: dup
    //   173: ldc 188
    //   175: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: aload 5
    //   182: aload 4
    //   184: getfield 62	com/tencent/token/core/bean/QQUser:mUin	J
    //   187: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 5
    //   193: ldc 190
    //   195: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: aload 4
    //   203: getfield 193	com/tencent/token/core/bean/QQUser:mNickName	Ljava/lang/String;
    //   206: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 5
    //   212: ldc 195
    //   214: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 5
    //   220: aload 4
    //   222: getfield 198	com/tencent/token/core/bean/QQUser:mEmail	Ljava/lang/String;
    //   225: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 5
    //   231: ldc 200
    //   233: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 5
    //   239: aload_0
    //   240: getfield 36	com/tencent/token/ahh:a	Ljava/util/List;
    //   243: invokeinterface 204 1 0
    //   248: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 5
    //   254: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 120	com/tencent/token/xb:b	(Ljava/lang/String;)V
    //   260: goto -160 -> 100
    //   263: aload_2
    //   264: invokeinterface 47 1 0
    //   269: astore_2
    //   270: aload_2
    //   271: invokeinterface 52 1 0
    //   276: ifeq +148 -> 424
    //   279: aload_2
    //   280: invokeinterface 56 1 0
    //   285: checkcast 6	com/tencent/token/ahh$a
    //   288: astore_3
    //   289: getstatic 25	com/tencent/token/ahh:c	Z
    //   292: ifne +18 -> 310
    //   295: aload_3
    //   296: ifnull +6 -> 302
    //   299: goto +11 -> 310
    //   302: new 67	java/lang/AssertionError
    //   305: dup
    //   306: invokespecial 68	java/lang/AssertionError:<init>	()V
    //   309: athrow
    //   310: aload_3
    //   311: invokevirtual 182	com/tencent/token/ahh$a:d	()Lcom/tencent/token/core/bean/QQUser;
    //   314: astore_3
    //   315: aload_3
    //   316: getfield 152	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   319: ifne -49 -> 270
    //   322: aload_0
    //   323: getfield 36	com/tencent/token/ahh:a	Ljava/util/List;
    //   326: aload_3
    //   327: invokeinterface 186 2 0
    //   332: pop
    //   333: new 94	java/lang/StringBuilder
    //   336: dup
    //   337: ldc 188
    //   339: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: astore 4
    //   344: aload 4
    //   346: aload_3
    //   347: getfield 62	com/tencent/token/core/bean/QQUser:mUin	J
    //   350: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 4
    //   356: ldc 190
    //   358: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 4
    //   364: aload_3
    //   365: getfield 193	com/tencent/token/core/bean/QQUser:mNickName	Ljava/lang/String;
    //   368: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 4
    //   374: ldc 195
    //   376: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 4
    //   382: aload_3
    //   383: getfield 198	com/tencent/token/core/bean/QQUser:mEmail	Ljava/lang/String;
    //   386: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 4
    //   392: ldc 200
    //   394: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 4
    //   400: aload_0
    //   401: getfield 36	com/tencent/token/ahh:a	Ljava/util/List;
    //   404: invokeinterface 204 1 0
    //   409: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 4
    //   415: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 120	com/tencent/token/xb:b	(Ljava/lang/String;)V
    //   421: goto -151 -> 270
    //   424: aload_0
    //   425: iconst_1
    //   426: putfield 38	com/tencent/token/ahh:d	Z
    //   429: aload_0
    //   430: monitorexit
    //   431: iconst_1
    //   432: ireturn
    //   433: astore_2
    //   434: aload_2
    //   435: invokevirtual 208	java/lang/Exception:toString	()Ljava/lang/String;
    //   438: invokestatic 143	com/tencent/token/xb:c	(Ljava/lang/String;)V
    //   441: aload_0
    //   442: monitorexit
    //   443: iconst_0
    //   444: ireturn
    //   445: astore_2
    //   446: aload_0
    //   447: monitorexit
    //   448: aload_2
    //   449: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	ahh
    //   13	4	1	bool	boolean
    //   40	240	2	localObject1	Object
    //   433	2	2	localException	Exception
    //   445	4	2	localObject2	Object
    //   99	284	3	localObject3	Object
    //   118	296	4	localObject4	Object
    //   178	75	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   41	93	433	java/lang/Exception
    //   2	14	445	finally
    //   18	41	445	finally
    //   41	93	445	finally
    //   93	100	445	finally
    //   100	126	445	finally
    //   134	142	445	finally
    //   142	260	445	finally
    //   263	270	445	finally
    //   270	295	445	finally
    //   302	310	445	finally
    //   310	421	445	finally
    //   424	429	445	finally
    //   434	441	445	finally
  }
  
  private boolean e(QQUser paramQQUser)
  {
    Object localObject = new a();
    try
    {
      ahi.a((ahk)localObject, "table_user", "uin=?", new String[] { String.valueOf(c(paramQQUser)) });
      return true;
    }
    catch (Exception paramQQUser)
    {
      localObject = new StringBuilder("clear user database failed: ");
      ((StringBuilder)localObject).append(paramQQUser.toString());
      xb.c(((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private QQUser f()
  {
    try
    {
      this.e = null;
      Object localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        QQUser localQQUser = (QQUser)((Iterator)localObject1).next();
        if ((!c) && (localQQUser == null)) {
          throw new AssertionError();
        }
        if (localQQUser.mIsCurrentUser) {
          this.e = localQQUser;
        }
      }
      if ((this.e == null) && (this.a.size() > 0))
      {
        this.e = ((QQUser)this.a.get(0));
        localObject1 = new StringBuilder("user uin=");
        ((StringBuilder)localObject1).append(this.e.mUin);
        ((StringBuilder)localObject1).append(",email=");
        ((StringBuilder)localObject1).append(this.e.mEmail);
        ((StringBuilder)localObject1).append(",currentUser=");
        ((StringBuilder)localObject1).append(this.e.mIsCurrentUser);
        xb.a(((StringBuilder)localObject1).toString());
        a(this.e, true);
        if ((!c) && (!this.e.mIsCurrentUser)) {
          throw new AssertionError();
        }
      }
      localObject1 = this.e;
      return localObject1;
    }
    finally {}
  }
  
  public final int a()
  {
    if (!e()) {
      return -1;
    }
    if ((!c) && (this.a == null)) {
      throw new AssertionError();
    }
    return this.a.size();
  }
  
  public final QQUser a(int paramInt)
  {
    int i = a();
    if (paramInt >= i)
    {
      StringBuilder localStringBuilder = new StringBuilder("inval param, index:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",count:");
      localStringBuilder.append(i);
      xb.c(localStringBuilder.toString());
      return null;
    }
    return (QQUser)this.a.get(paramInt);
  }
  
  public final void a(List<QQUser> paramList)
  {
    try
    {
      e();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.a.iterator();
      this.b = false;
      QQUser localQQUser1;
      while (localIterator.hasNext())
      {
        QQUser localQQUser3 = (QQUser)localIterator.next();
        QQUser localQQUser2 = a(paramList, localQQUser3.mUin);
        localQQUser1 = localQQUser2;
        if (localQQUser2 == null) {
          localQQUser1 = b(paramList, localQQUser3.mUin);
        }
        if (localQQUser1 != null)
        {
          e(localQQUser3);
          if (localQQUser3.mIsCurrentUser)
          {
            localQQUser1.mIsCurrentUser = true;
            this.e = localQQUser1;
            localLinkedList.add(localQQUser1);
            b(localQQUser1);
          }
        }
        else
        {
          this.b = true;
          if (!localQQUser3.mIsBinded)
          {
            localLinkedList.add(localQQUser3);
          }
          else
          {
            e(localQQUser3);
            if ((this.e != null) && (localQQUser3.mUin == this.e.mUin)) {
              this.e = null;
            }
          }
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localQQUser1 = (QQUser)paramList.next();
        if (a(localLinkedList, localQQUser1.mUin) == null)
        {
          this.b = true;
          localLinkedList.add(localQQUser1);
          b(localQQUser1);
        }
      }
      this.a.clear();
      paramList = localLinkedList.iterator();
      while (paramList.hasNext())
      {
        localQQUser1 = (QQUser)paramList.next();
        if ((!c) && (localQQUser1 == null)) {
          throw new AssertionError();
        }
        if (localQQUser1.mIsBinded) {
          this.a.add(localQQUser1);
        }
      }
      paramList = localLinkedList.iterator();
      while (paramList.hasNext())
      {
        localQQUser1 = (QQUser)paramList.next();
        if ((!c) && (localQQUser1 == null)) {
          throw new AssertionError();
        }
        if (!localQQUser1.mIsBinded) {
          this.a.add(localQQUser1);
        }
      }
      return;
    }
    finally {}
  }
  
  public final boolean a(long paramLong)
  {
    QQUser localQQUser = c(paramLong);
    if (localQQUser == null)
    {
      xb.c("find user not exist with uin:".concat(String.valueOf(paramLong)));
      return false;
    }
    return d(localQQUser);
  }
  
  public final boolean a(QQUser paramQQUser)
  {
    if ((!c) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    boolean bool = e(paramQQUser);
    if (bool)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (((QQUser)this.a.get(i)).mRealUin == paramQQUser.mRealUin)
        {
          this.a.remove(i);
          if (paramQQUser.mIsCurrentUser) {
            f();
          }
          return bool;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public final QQUser b()
  {
    try
    {
      boolean bool = e();
      if (!bool) {
        return null;
      }
      if (this.e == null)
      {
        localObject1 = this.a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          QQUser localQQUser = (QQUser)((Iterator)localObject1).next();
          if ((!c) && (localQQUser == null)) {
            throw new AssertionError();
          }
          if (localQQUser.mIsCurrentUser) {
            this.e = localQQUser;
          }
        }
        if ((this.e == null) && (this.a.size() > 0))
        {
          this.e = ((QQUser)this.a.get(0));
          localObject1 = new StringBuilder("user uin=");
          ((StringBuilder)localObject1).append(this.e.mUin);
          ((StringBuilder)localObject1).append(",email=");
          ((StringBuilder)localObject1).append(this.e.mEmail);
          ((StringBuilder)localObject1).append(",currentUser=");
          ((StringBuilder)localObject1).append(this.e.mIsCurrentUser);
          xb.a(((StringBuilder)localObject1).toString());
          a(this.e, true);
          if ((!c) && (!this.e.mIsCurrentUser)) {
            throw new AssertionError();
          }
        }
      }
      Object localObject1 = this.e;
      return localObject1;
    }
    finally {}
  }
  
  public final QQUser b(int paramInt)
  {
    try
    {
      boolean bool = e();
      if (!bool) {
        return null;
      }
      Iterator localIterator = this.a.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        QQUser localQQUser = (QQUser)localIterator.next();
        if ((!c) && (localQQUser == null)) {
          throw new AssertionError();
        }
        bool = localQQUser.mIsCurrentUser;
        if (!bool)
        {
          if (i == paramInt) {
            return localQQUser;
          }
          i += 1;
        }
      }
      return null;
    }
    finally {}
  }
  
  public final boolean b(long paramLong)
  {
    QQUser localQQUser = b(this.a, paramLong);
    if (localQQUser == null)
    {
      xb.c("find user not exist with uin:".concat(String.valueOf(paramLong)));
      return false;
    }
    return d(localQQUser);
  }
  
  public final boolean b(QQUser paramQQUser)
  {
    Object localObject = new a();
    ((a)localObject).a(paramQQUser);
    if (ahi.a((ahk)localObject) == -1L)
    {
      localObject = new StringBuilder("SQLiteManager.add user data failed: ");
      ((StringBuilder)localObject).append(paramQQUser.mUin);
      xb.c(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public final QQUser c(long paramLong)
  {
    return a(this.a, paramLong);
  }
  
  public final void c()
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 == null) {
        return;
      }
      int i = 0;
      while (i < this.a.size())
      {
        localObject1 = (QQUser)this.a.get(i);
        if ((localObject1 != null) && (((QQUser)localObject1).mIsBinded))
        {
          e((QQUser)localObject1);
          ((QQUser)localObject1).mIsBinded = false;
          b((QQUser)localObject1);
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public final long d()
  {
    if (this.a == null) {
      return 0L;
    }
    int i = 0;
    while (i < this.a.size())
    {
      if (((QQUser)this.a.get(i)).mIsBinded) {
        return ((QQUser)this.a.get(i)).mUin;
      }
      i += 1;
    }
    return 0L;
  }
  
  public final QQUser d(long paramLong)
  {
    return b(this.a, paramLong);
  }
  
  public final class a
    implements ahk
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
    
    public a() {}
    
    public final ahk a(afx paramafx)
    {
      a locala = new a(ahh.this);
      locala.a = paramafx.getLong(paramafx.getColumnIndex("uin"));
      locala.c = paramafx.getString(paramafx.getColumnIndex("email"));
      locala.d = paramafx.getString(paramafx.getColumnIndex("nick_name"));
      locala.e = paramafx.getString(paramafx.getColumnIndex("uin_mask"));
      locala.g = paramafx.getBlob(paramafx.getColumnIndex("head_image"));
      locala.h = paramafx.getLong(paramafx.getColumnIndex("head_image_update_time"));
      long l1 = paramafx.getLong(paramafx.getColumnIndex("flag"));
      int n = 0;
      boolean bool;
      if ((1L & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      locala.f = bool;
      if ((0x2 & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      locala.i = bool;
      if ((0x8 & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      locala.k = bool;
      if ((0x4 & l1) == 0L) {
        bool = true;
      } else {
        bool = false;
      }
      locala.j = bool;
      if ((l1 & 0x10) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      locala.l = bool;
      if (!locala.j) {
        locala.a = (-locala.a);
      }
      paramafx = locala.g;
      if ((paramafx != null) && (paramafx.length >= 64) && (paramafx[0] == wv.a[0]) && (paramafx[1] == wv.a[1]) && (paramafx[2] == wv.a[2]) && (paramafx[3] == wv.a[3]))
      {
        byte[] arrayOfByte = new byte[60];
        System.arraycopy(paramafx, 4, arrayOfByte, 0, 60);
        while ((n < 60) && (arrayOfByte[n] == 0))
        {
          arrayOfByte[n] = 48;
          n += 1;
        }
        paramafx = new String(arrayOfByte);
      }
      try
      {
        locala.b = Long.parseLong(paramafx);
        return locala;
      }
      catch (Exception paramafx)
      {
        label416:
        break label416;
      }
      locala.b = 0L;
      return locala;
    }
    
    public final String a()
    {
      return "table_user";
    }
    
    public final void a(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.b("CREATE TABLE IF NOT EXISTS table_user(uin INTEGER PRIMARY KEY,email TEXT,nick_name TEXT, uin_mask TEXT, flag INTEGER,head_image BLOB, head_image_update_time INTEGER);");
    }
    
    public final boolean a(QQUser paramQQUser)
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b);
        localObject = ((StringBuilder)localObject).toString();
        System.arraycopy(wv.a, 0, this.g, 0, wv.a.length);
        byte[] arrayOfByte1 = ((String)localObject).getBytes();
        byte[] arrayOfByte2 = this.g;
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, arrayOfByte2.length - ((String)localObject).length(), ((String)localObject).length());
      }
      long l1 = c();
      Object localObject = new ContentValues();
      if (this.j) {
        ((ContentValues)localObject).put("uin", Long.valueOf(this.a));
      } else {
        ((ContentValues)localObject).put("uin", Long.valueOf(-this.a));
      }
      ((ContentValues)localObject).put("email", this.c);
      ((ContentValues)localObject).put("nick_name", this.d);
      ((ContentValues)localObject).put("uin_mask", this.e);
      ((ContentValues)localObject).put("flag", Long.valueOf(l1));
      ((ContentValues)localObject).put("head_image", this.g);
      ((ContentValues)localObject).put("head_image_update_time", Long.valueOf(this.h));
      return paramSQLiteDatabase.a("table_user", (ContentValues)localObject);
    }
    
    public final ContentValues b()
    {
      return null;
    }
    
    public final long c()
    {
      if (this.f) {
        l2 = 1L;
      } else {
        l2 = 0L;
      }
      long l1 = l2;
      if (this.i) {
        l1 = l2 | 0x2;
      }
      long l2 = l1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahh
 * JD-Core Version:    0.7.0.1
 */