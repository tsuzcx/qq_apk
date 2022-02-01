package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.a;
import com.tencent.token.global.g;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class es
{
  private boolean b = false;
  private List<QQUser> c = new ArrayList();
  private QQUser d = null;
  private boolean e = false;
  
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
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    Object localObject = new a();
    ContentValues localContentValues = new ContentValues();
    ((a)localObject).a(paramQQUser);
    long l = ((a)localObject).a();
    localContentValues.put("flag", Long.valueOf(l));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set user flag ");
    localStringBuilder.append(paramQQUser.a());
    localStringBuilder.append(":");
    localStringBuilder.append(l);
    g.b(localStringBuilder.toString());
    if (et.a((ev)localObject, "table_user", localContentValues, "uin=?", new String[] { String.valueOf(d(paramQQUser)) }) <= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update uin flag failed, uin=");
      ((StringBuilder)localObject).append(paramQQUser.mUin);
      ((StringBuilder)localObject).append(", flag=");
      ((StringBuilder)localObject).append(l);
      g.c(((StringBuilder)localObject).toString());
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
  
  private boolean e(QQUser paramQQUser)
  {
    boolean bool;
    if (paramQQUser != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    c();
    QQUser localQQUser = this.d;
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
    this.d = paramQQUser;
    return true;
  }
  
  private boolean f(QQUser paramQQUser)
  {
    Object localObject = new a();
    try
    {
      et.a((ev)localObject, "table_user", "uin=?", new String[] { String.valueOf(d(paramQQUser)) });
      return true;
    }
    catch (Exception paramQQUser)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clear user database failed: ");
      ((StringBuilder)localObject).append(paramQQUser.toString());
      g.c(((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private boolean g(QQUser paramQQUser)
  {
    Object localObject = new a();
    if (!((a)localObject).a(paramQQUser))
    {
      g.c("userData.SaveUser failed");
      return false;
    }
    if (et.b((ev)localObject) == -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SQLiteManager.add user data failed: ");
      ((StringBuilder)localObject).append(paramQQUser.mUin);
      g.c(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public QQUser a(int paramInt)
  {
    int i = b();
    if (paramInt >= i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("inval param, index:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",count:");
      localStringBuilder.append(i);
      g.c(localStringBuilder.toString());
      return null;
    }
    return (QQUser)this.c.get(paramInt);
  }
  
  public void a(List<QQUser> paramList)
  {
    try
    {
      a();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.c.iterator();
      this.e = false;
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
          f(localQQUser3);
          if (localQQUser3.mIsCurrentUser)
          {
            localQQUser1.mIsCurrentUser = true;
            this.d = localQQUser1;
            localLinkedList.add(localQQUser1);
            g(localQQUser1);
          }
        }
        else
        {
          this.e = true;
          if (!localQQUser3.mIsBinded)
          {
            localLinkedList.add(localQQUser3);
          }
          else
          {
            f(localQQUser3);
            if ((this.d != null) && (localQQUser3.mUin == this.d.mUin)) {
              this.d = null;
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
          this.e = true;
          localLinkedList.add(localQQUser1);
          g(localQQUser1);
        }
      }
      this.c.clear();
      paramList = localLinkedList.iterator();
      while (paramList.hasNext())
      {
        localQQUser1 = (QQUser)paramList.next();
        if ((!a) && (localQQUser1 == null)) {
          throw new AssertionError();
        }
        if (localQQUser1.mIsBinded) {
          this.c.add(localQQUser1);
        }
      }
      paramList = localLinkedList.iterator();
      while (paramList.hasNext())
      {
        localQQUser1 = (QQUser)paramList.next();
        if ((!a) && (localQQUser1 == null)) {
          throw new AssertionError();
        }
        if (!localQQUser1.mIsBinded) {
          this.c.add(localQQUser1);
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/token/es:b	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: getfield 38	com/tencent/token/es:b	Z
    //   13: istore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 36	com/tencent/token/es:c	Ljava/util/List;
    //   22: invokeinterface 212 1 0
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 40	com/tencent/token/es:d	Lcom/tencent/token/core/bean/QQUser;
    //   32: new 6	com/tencent/token/es$a
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 71	com/tencent/token/es$a:<init>	(Lcom/tencent/token/es;)V
    //   40: astore_2
    //   41: aload_2
    //   42: ldc 119
    //   44: bipush 7
    //   46: anewarray 123	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: ldc 215
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: ldc 217
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: ldc 219
    //   63: aastore
    //   64: dup
    //   65: iconst_3
    //   66: ldc 221
    //   68: aastore
    //   69: dup
    //   70: iconst_4
    //   71: ldc 82
    //   73: aastore
    //   74: dup
    //   75: iconst_5
    //   76: ldc 223
    //   78: aastore
    //   79: dup
    //   80: bipush 6
    //   82: ldc 225
    //   84: aastore
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: aconst_null
    //   91: invokestatic 228	com/tencent/token/et:a	(Lcom/tencent/token/ev;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   94: astore_2
    //   95: getstatic 25	com/tencent/token/es:a	Z
    //   98: ifne +18 -> 116
    //   101: aload_2
    //   102: ifnull +6 -> 108
    //   105: goto +11 -> 116
    //   108: new 67	java/lang/AssertionError
    //   111: dup
    //   112: invokespecial 68	java/lang/AssertionError:<init>	()V
    //   115: athrow
    //   116: aload_2
    //   117: invokeinterface 47 1 0
    //   122: astore_3
    //   123: aload_3
    //   124: invokeinterface 52 1 0
    //   129: ifeq +185 -> 314
    //   132: aload_3
    //   133: invokeinterface 56 1 0
    //   138: checkcast 6	com/tencent/token/es$a
    //   141: astore 4
    //   143: getstatic 25	com/tencent/token/es:a	Z
    //   146: ifne +19 -> 165
    //   149: aload 4
    //   151: ifnull +6 -> 157
    //   154: goto +11 -> 165
    //   157: new 67	java/lang/AssertionError
    //   160: dup
    //   161: invokespecial 68	java/lang/AssertionError:<init>	()V
    //   164: athrow
    //   165: aload 4
    //   167: invokevirtual 230	com/tencent/token/es$a:d	()Lcom/tencent/token/core/bean/QQUser;
    //   170: astore 4
    //   172: getstatic 25	com/tencent/token/es:a	Z
    //   175: ifne +19 -> 194
    //   178: aload 4
    //   180: ifnull +6 -> 186
    //   183: goto +11 -> 194
    //   186: new 67	java/lang/AssertionError
    //   189: dup
    //   190: invokespecial 68	java/lang/AssertionError:<init>	()V
    //   193: athrow
    //   194: aload 4
    //   196: getfield 209	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   199: ifeq -76 -> 123
    //   202: aload_0
    //   203: getfield 36	com/tencent/token/es:c	Ljava/util/List;
    //   206: aload 4
    //   208: invokeinterface 204 2 0
    //   213: pop
    //   214: new 94	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   221: astore 5
    //   223: aload 5
    //   225: ldc 232
    //   227: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 5
    //   233: aload 4
    //   235: getfield 62	com/tencent/token/core/bean/QQUser:mUin	J
    //   238: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 5
    //   244: ldc 234
    //   246: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 5
    //   252: aload 4
    //   254: getfield 238	com/tencent/token/core/bean/QQUser:mNickName	Ljava/lang/String;
    //   257: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 5
    //   263: ldc 240
    //   265: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 5
    //   271: aload 4
    //   273: getfield 243	com/tencent/token/core/bean/QQUser:mEmail	Ljava/lang/String;
    //   276: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 5
    //   282: ldc 245
    //   284: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 5
    //   290: aload_0
    //   291: getfield 36	com/tencent/token/es:c	Ljava/util/List;
    //   294: invokeinterface 248 1 0
    //   299: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 5
    //   305: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 117	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   311: goto -188 -> 123
    //   314: aload_2
    //   315: invokeinterface 47 1 0
    //   320: astore_2
    //   321: aload_2
    //   322: invokeinterface 52 1 0
    //   327: ifeq +175 -> 502
    //   330: aload_2
    //   331: invokeinterface 56 1 0
    //   336: checkcast 6	com/tencent/token/es$a
    //   339: astore_3
    //   340: getstatic 25	com/tencent/token/es:a	Z
    //   343: ifne +18 -> 361
    //   346: aload_3
    //   347: ifnull +6 -> 353
    //   350: goto +11 -> 361
    //   353: new 67	java/lang/AssertionError
    //   356: dup
    //   357: invokespecial 68	java/lang/AssertionError:<init>	()V
    //   360: athrow
    //   361: aload_3
    //   362: invokevirtual 230	com/tencent/token/es$a:d	()Lcom/tencent/token/core/bean/QQUser;
    //   365: astore_3
    //   366: getstatic 25	com/tencent/token/es:a	Z
    //   369: ifne +18 -> 387
    //   372: aload_3
    //   373: ifnull +6 -> 379
    //   376: goto +11 -> 387
    //   379: new 67	java/lang/AssertionError
    //   382: dup
    //   383: invokespecial 68	java/lang/AssertionError:<init>	()V
    //   386: athrow
    //   387: aload_3
    //   388: getfield 209	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   391: ifne -70 -> 321
    //   394: aload_0
    //   395: getfield 36	com/tencent/token/es:c	Ljava/util/List;
    //   398: aload_3
    //   399: invokeinterface 204 2 0
    //   404: pop
    //   405: new 94	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   412: astore 4
    //   414: aload 4
    //   416: ldc 232
    //   418: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 4
    //   424: aload_3
    //   425: getfield 62	com/tencent/token/core/bean/QQUser:mUin	J
    //   428: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 4
    //   434: ldc 234
    //   436: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload 4
    //   442: aload_3
    //   443: getfield 238	com/tencent/token/core/bean/QQUser:mNickName	Ljava/lang/String;
    //   446: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 4
    //   452: ldc 240
    //   454: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 4
    //   460: aload_3
    //   461: getfield 243	com/tencent/token/core/bean/QQUser:mEmail	Ljava/lang/String;
    //   464: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 4
    //   470: ldc 245
    //   472: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 4
    //   478: aload_0
    //   479: getfield 36	com/tencent/token/es:c	Ljava/util/List;
    //   482: invokeinterface 248 1 0
    //   487: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 4
    //   493: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 117	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   499: goto -178 -> 321
    //   502: aload_0
    //   503: iconst_1
    //   504: putfield 38	com/tencent/token/es:b	Z
    //   507: aload_0
    //   508: monitorexit
    //   509: iconst_1
    //   510: ireturn
    //   511: astore_2
    //   512: aload_2
    //   513: invokevirtual 163	java/lang/Exception:toString	()Ljava/lang/String;
    //   516: invokestatic 140	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   519: aload_0
    //   520: monitorexit
    //   521: iconst_0
    //   522: ireturn
    //   523: astore_2
    //   524: aload_0
    //   525: monitorexit
    //   526: aload_2
    //   527: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	es
    //   13	4	1	bool	boolean
    //   40	291	2	localObject1	Object
    //   511	2	2	localException	Exception
    //   523	4	2	localObject2	Object
    //   122	339	3	localObject3	Object
    //   141	351	4	localObject4	Object
    //   221	83	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   41	95	511	java/lang/Exception
    //   2	14	523	finally
    //   18	41	523	finally
    //   41	95	523	finally
    //   95	101	523	finally
    //   108	116	523	finally
    //   116	123	523	finally
    //   123	149	523	finally
    //   157	165	523	finally
    //   165	178	523	finally
    //   186	194	523	finally
    //   194	311	523	finally
    //   314	321	523	finally
    //   321	346	523	finally
    //   353	361	523	finally
    //   361	372	523	finally
    //   379	387	523	finally
    //   387	499	523	finally
    //   502	507	523	finally
    //   512	519	523	finally
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = c(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("find user not exist with uin:");
      ((StringBuilder)localObject).append(paramLong);
      g.c(((StringBuilder)localObject).toString());
      return false;
    }
    return e((QQUser)localObject);
  }
  
  public boolean a(QQUser paramQQUser)
  {
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    Object localObject = new a();
    ContentValues localContentValues = new ContentValues();
    ((a)localObject).a(paramQQUser);
    long l = ((a)localObject).a();
    localContentValues.put("flag", Long.valueOf(l));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set user flag ");
    localStringBuilder.append(paramQQUser.a());
    localStringBuilder.append(":");
    localStringBuilder.append(l);
    g.b(localStringBuilder.toString());
    if (et.a((ev)localObject, "table_user", localContentValues, "uin=?", new String[] { String.valueOf(d(paramQQUser)) }) <= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update uin flag failed, uin=");
      ((StringBuilder)localObject).append(paramQQUser.mUin);
      ((StringBuilder)localObject).append(", flag=");
      ((StringBuilder)localObject).append(l);
      g.c(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if (!a()) {
      return -1;
    }
    if ((!a) && (this.c == null)) {
      throw new AssertionError();
    }
    return this.c.size();
  }
  
  public QQUser b(int paramInt)
  {
    try
    {
      boolean bool = a();
      if (!bool) {
        return null;
      }
      Iterator localIterator = this.c.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        QQUser localQQUser = (QQUser)localIterator.next();
        if ((!a) && (localQQUser == null)) {
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
  
  public void b(List<QQUser> paramList)
  {
    if (this.c != null)
    {
      if (paramList == null) {
        return;
      }
      int i = 0;
      while (i < this.c.size())
      {
        if (((QQUser)this.c.get(i)).mIsRegisterFacePwd) {
          paramList.add(this.c.get(i));
        }
        i += 1;
      }
      return;
    }
  }
  
  public boolean b(long paramLong)
  {
    Object localObject = b(this.c, paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("find user not exist with uin:");
      ((StringBuilder)localObject).append(paramLong);
      g.c(((StringBuilder)localObject).toString());
      return false;
    }
    return e((QQUser)localObject);
  }
  
  public boolean b(QQUser paramQQUser)
  {
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    int i = this.c.size();
    int j = 0;
    if (i >= 3) {
      return false;
    }
    i = j;
    if (paramQQUser.mUin == 0L)
    {
      paramQQUser.mUin = paramQQUser.mRealUin;
      i = j;
    }
    while (i < this.c.size())
    {
      if (((QQUser)this.c.get(i)).mRealUin == paramQQUser.mRealUin) {
        return true;
      }
      i += 1;
    }
    boolean bool = g(paramQQUser);
    if (bool) {
      this.c.add(paramQQUser);
    }
    return bool;
  }
  
  public QQUser c()
  {
    try
    {
      boolean bool = a();
      if (!bool) {
        return null;
      }
      if (this.d == null)
      {
        localObject1 = this.c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          QQUser localQQUser = (QQUser)((Iterator)localObject1).next();
          if ((!a) && (localQQUser == null)) {
            throw new AssertionError();
          }
          if (localQQUser.mIsCurrentUser) {
            this.d = localQQUser;
          }
        }
        if ((this.d == null) && (this.c.size() > 0))
        {
          this.d = ((QQUser)this.c.get(0));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("user uin=");
          ((StringBuilder)localObject1).append(this.d.mUin);
          ((StringBuilder)localObject1).append(",email=");
          ((StringBuilder)localObject1).append(this.d.mEmail);
          ((StringBuilder)localObject1).append(",currentUser=");
          ((StringBuilder)localObject1).append(this.d.mIsCurrentUser);
          g.a(((StringBuilder)localObject1).toString());
          a(this.d, true);
          if ((!a) && (!this.d.mIsCurrentUser)) {
            throw new AssertionError();
          }
        }
      }
      Object localObject1 = this.d;
      return localObject1;
    }
    finally {}
  }
  
  public QQUser c(long paramLong)
  {
    return a(this.c, paramLong);
  }
  
  public boolean c(QQUser paramQQUser)
  {
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    boolean bool = f(paramQQUser);
    if (bool)
    {
      int i = 0;
      while (i < this.c.size())
      {
        if (((QQUser)this.c.get(i)).mRealUin == paramQQUser.mRealUin)
        {
          this.c.remove(i);
          if (paramQQUser.mIsCurrentUser) {
            d();
          }
          return bool;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public long d(QQUser paramQQUser)
  {
    if (!paramQQUser.mIsBinded) {
      return -paramQQUser.mRealUin;
    }
    return paramQQUser.mUin;
  }
  
  public QQUser d()
  {
    try
    {
      this.d = null;
      Object localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        QQUser localQQUser = (QQUser)((Iterator)localObject1).next();
        if ((!a) && (localQQUser == null)) {
          throw new AssertionError();
        }
        if (localQQUser.mIsCurrentUser) {
          this.d = localQQUser;
        }
      }
      if ((this.d == null) && (this.c.size() > 0))
      {
        this.d = ((QQUser)this.c.get(0));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("user uin=");
        ((StringBuilder)localObject1).append(this.d.mUin);
        ((StringBuilder)localObject1).append(",email=");
        ((StringBuilder)localObject1).append(this.d.mEmail);
        ((StringBuilder)localObject1).append(",currentUser=");
        ((StringBuilder)localObject1).append(this.d.mIsCurrentUser);
        g.a(((StringBuilder)localObject1).toString());
        a(this.d, true);
        if ((!a) && (!this.d.mIsCurrentUser)) {
          throw new AssertionError();
        }
      }
      localObject1 = this.d;
      return localObject1;
    }
    finally {}
  }
  
  public QQUser d(long paramLong)
  {
    return b(this.c, paramLong);
  }
  
  public boolean e()
  {
    boolean bool = this.e;
    if (bool)
    {
      this.e = false;
      return this.e ^ true;
    }
    return bool;
  }
  
  public void f()
  {
    try
    {
      Object localObject1 = this.c;
      if (localObject1 == null) {
        return;
      }
      int i = 0;
      while (i < this.c.size())
      {
        localObject1 = (QQUser)this.c.get(i);
        if ((localObject1 != null) && (((QQUser)localObject1).mIsBinded))
        {
          f((QQUser)localObject1);
          ((QQUser)localObject1).mIsBinded = false;
          g((QQUser)localObject1);
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public long g()
  {
    if (this.c == null) {
      return 0L;
    }
    int i = 0;
    while (i < this.c.size())
    {
      if (((QQUser)this.c.get(i)).mIsBinded) {
        return ((QQUser)this.c.get(i)).mUin;
      }
      i += 1;
    }
    return 0L;
  }
  
  public boolean h()
  {
    if (this.c == null) {
      return false;
    }
    int i = 0;
    while (i < this.c.size())
    {
      if (((QQUser)this.c.get(i)).mIsRegisterFacePwd) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean i()
  {
    QQUser localQQUser1 = c();
    if (localQQUser1 != null)
    {
      if (this.c == null) {
        return false;
      }
      int i = 0;
      while (i < this.c.size())
      {
        QQUser localQQUser2 = (QQUser)this.c.get(i);
        if ((localQQUser2.mIsRegisterFacePwd) && (localQQUser2.mUin == localQQUser1.mUin)) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return false;
  }
  
  public class a
    implements ev
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
    
    public long a()
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
    
    public ev a(Cursor paramCursor)
    {
      a locala = new a(es.this);
      locala.a = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      locala.c = paramCursor.getString(paramCursor.getColumnIndex("email"));
      locala.d = paramCursor.getString(paramCursor.getColumnIndex("nick_name"));
      locala.e = paramCursor.getString(paramCursor.getColumnIndex("uin_mask"));
      locala.g = paramCursor.getBlob(paramCursor.getColumnIndex("head_image"));
      locala.h = paramCursor.getLong(paramCursor.getColumnIndex("head_image_update_time"));
      a(locala, paramCursor.getLong(paramCursor.getColumnIndex("flag")));
      if (!locala.j) {
        locala.a = (-locala.a);
      }
      paramCursor = locala.g;
      if ((paramCursor != null) && (paramCursor.length >= 64))
      {
        int n = 0;
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
        locala.b = Long.parseLong(paramCursor);
        return locala;
      }
      catch (Exception paramCursor)
      {
        label279:
        break label279;
      }
      locala.b = 0L;
      return locala;
    }
    
    public void a(a parama, long paramLong)
    {
      boolean bool2 = true;
      boolean bool1;
      if ((1L & paramLong) != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      parama.f = bool1;
      if ((0x2 & paramLong) != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      parama.i = bool1;
      if ((0x8 & paramLong) != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      parama.k = bool1;
      if ((0x4 & paramLong) == 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      parama.j = bool1;
      if ((paramLong & 0x10) != 0L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      parama.l = bool1;
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        System.arraycopy(a.a, 0, this.g, 0, a.a.length);
        byte[] arrayOfByte1 = ((String)localObject).getBytes();
        byte[] arrayOfByte2 = this.g;
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, arrayOfByte2.length - ((String)localObject).length(), ((String)localObject).length());
      }
      long l1 = a();
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
      return paramSQLiteDatabase.insert("table_user", null, (ContentValues)localObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.es
 * JD-Core Version:    0.7.0.1
 */