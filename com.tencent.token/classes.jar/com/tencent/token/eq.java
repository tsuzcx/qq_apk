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

public class eq
{
  private boolean b = false;
  private List<QQUser> c = new ArrayList();
  private QQUser d = null;
  private boolean e = false;
  
  static
  {
    if (!eq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  /* Error */
  private QQUser a(List<QQUser> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface 47 1 0
    //   8: astore 6
    //   10: aload 6
    //   12: invokeinterface 52 1 0
    //   17: ifeq +31 -> 48
    //   20: aload 6
    //   22: invokeinterface 56 1 0
    //   27: checkcast 58	com/tencent/token/core/bean/QQUser
    //   30: astore_1
    //   31: aload_1
    //   32: getfield 62	com/tencent/token/core/bean/QQUser:mUin	J
    //   35: lstore 4
    //   37: lload 4
    //   39: lload_2
    //   40: lcmp
    //   41: ifne -31 -> 10
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: aconst_null
    //   49: astore_1
    //   50: goto -6 -> 44
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	eq
    //   0	58	1	paramList	List<QQUser>
    //   0	58	2	paramLong	long
    //   35	3	4	l	long
    //   8	13	6	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	10	53	finally
    //   10	37	53	finally
  }
  
  private boolean a(QQUser paramQQUser, boolean paramBoolean)
  {
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    a locala = new a();
    ContentValues localContentValues = new ContentValues();
    locala.a(paramQQUser);
    long l = locala.a();
    localContentValues.put("flag", Long.valueOf(l));
    g.b("set user flag " + paramQQUser.a() + ":" + l);
    if (er.a(locala, "table_user", localContentValues, "uin=?", new String[] { String.valueOf(d(paramQQUser)) }) <= 0)
    {
      g.c("update uin flag failed, uin=" + paramQQUser.mUin + ", flag=" + l);
      return false;
    }
    paramQQUser.mIsCurrentUser = paramBoolean;
    return true;
  }
  
  /* Error */
  private QQUser b(List<QQUser> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface 47 1 0
    //   8: astore 6
    //   10: aload 6
    //   12: invokeinterface 52 1 0
    //   17: ifeq +31 -> 48
    //   20: aload 6
    //   22: invokeinterface 56 1 0
    //   27: checkcast 58	com/tencent/token/core/bean/QQUser
    //   30: astore_1
    //   31: aload_1
    //   32: getfield 146	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   35: lstore 4
    //   37: lload 4
    //   39: lload_2
    //   40: lcmp
    //   41: ifne -31 -> 10
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: aconst_null
    //   49: astore_1
    //   50: goto -6 -> 44
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	eq
    //   0	58	1	paramList	List<QQUser>
    //   0	58	2	paramLong	long
    //   35	3	4	l	long
    //   8	13	6	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	10	53	finally
    //   10	37	53	finally
  }
  
  private boolean e(QQUser paramQQUser)
  {
    if (paramQQUser != null) {}
    for (boolean bool = true;; bool = false)
    {
      g.a(bool);
      c();
      if (this.d != paramQQUser) {
        break;
      }
      return true;
    }
    if (this.d != null)
    {
      this.d.mIsCurrentUser = false;
      a(this.d, false);
    }
    paramQQUser.mIsCurrentUser = true;
    a(paramQQUser, true);
    this.d = paramQQUser;
    return true;
  }
  
  private boolean f(QQUser paramQQUser)
  {
    a locala = new a();
    try
    {
      er.a(locala, "table_user", "uin=?", new String[] { String.valueOf(d(paramQQUser)) });
      return true;
    }
    catch (Exception paramQQUser)
    {
      g.c("clear user database failed: " + paramQQUser.toString());
    }
    return false;
  }
  
  private boolean g(QQUser paramQQUser)
  {
    a locala = new a();
    if (!locala.a(paramQQUser))
    {
      g.c("userData.SaveUser failed");
      return false;
    }
    if (er.b(locala) == -1L)
    {
      g.c("SQLiteManager.add user data failed: " + paramQQUser.mUin);
      return false;
    }
    return true;
  }
  
  public QQUser a(int paramInt)
  {
    int i = b();
    if (paramInt >= i)
    {
      g.c("inval param, index:" + paramInt + ",count:" + i);
      return null;
    }
    return (QQUser)this.c.get(paramInt);
  }
  
  public void a(List<QQUser> paramList)
  {
    LinkedList localLinkedList;
    QQUser localQQUser1;
    for (;;)
    {
      QQUser localQQUser3;
      try
      {
        a();
        localLinkedList = new LinkedList();
        Iterator localIterator = this.c.iterator();
        this.e = false;
        if (!localIterator.hasNext()) {
          break;
        }
        localQQUser3 = (QQUser)localIterator.next();
        QQUser localQQUser2 = a(paramList, localQQUser3.mUin);
        localQQUser1 = localQQUser2;
        if (localQQUser2 == null) {
          localQQUser1 = b(paramList, localQQUser3.mUin);
        }
        if (localQQUser1 != null)
        {
          f(localQQUser3);
          if (!localQQUser3.mIsCurrentUser) {
            continue;
          }
          localQQUser1.mIsCurrentUser = true;
          this.d = localQQUser1;
          localLinkedList.add(localQQUser1);
          g(localQQUser1);
          continue;
        }
        this.e = true;
      }
      finally {}
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
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        if (this.b)
        {
          bool = this.b;
          return bool;
        }
        this.c.clear();
        this.d = null;
        Object localObject1 = new a();
        continue;
      }
      finally
      {
        try
        {
          localObject1 = er.a((et)localObject1, "table_user", new String[] { "uin", "email", "nick_name", "uin_mask", "flag", "head_image", "head_image_update_time" }, null, null, null, null, null, null);
          if ((a) || (localObject1 != null)) {
            break label131;
          }
          throw new AssertionError();
        }
        catch (Exception localException)
        {
          g.c(localException.toString());
          bool = false;
        }
        localObject2 = finally;
      }
      label131:
      Object localObject3 = localException.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (a)((Iterator)localObject3).next();
        if ((!a) && (localObject4 == null)) {
          throw new AssertionError();
        }
        localObject4 = ((a)localObject4).d();
        if ((!a) && (localObject4 == null)) {
          throw new AssertionError();
        }
        if (((QQUser)localObject4).mIsBinded)
        {
          this.c.add(localObject4);
          g.b("uin=" + ((QQUser)localObject4).mUin + ",nick=" + ((QQUser)localObject4).mNickName + "email=" + ((QQUser)localObject4).mEmail + "list count=" + this.c.size());
        }
      }
      Iterator localIterator = localException.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (a)localIterator.next();
        if ((!a) && (localObject3 == null)) {
          throw new AssertionError();
        }
        localObject3 = ((a)localObject3).d();
        if ((!a) && (localObject3 == null)) {
          throw new AssertionError();
        }
        if (!((QQUser)localObject3).mIsBinded)
        {
          this.c.add(localObject3);
          g.b("uin=" + ((QQUser)localObject3).mUin + ",nick=" + ((QQUser)localObject3).mNickName + "email=" + ((QQUser)localObject3).mEmail + "list count=" + this.c.size());
        }
      }
      this.b = true;
      boolean bool = true;
    }
  }
  
  public boolean a(long paramLong)
  {
    QQUser localQQUser = c(paramLong);
    if (localQQUser == null)
    {
      g.c("find user not exist with uin:" + paramLong);
      return false;
    }
    return e(localQQUser);
  }
  
  public boolean a(QQUser paramQQUser)
  {
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    a locala = new a();
    ContentValues localContentValues = new ContentValues();
    locala.a(paramQQUser);
    long l = locala.a();
    localContentValues.put("flag", Long.valueOf(l));
    g.b("set user flag " + paramQQUser.a() + ":" + l);
    if (er.a(locala, "table_user", localContentValues, "uin=?", new String[] { String.valueOf(d(paramQQUser)) }) <= 0)
    {
      g.c("update uin flag failed, uin=" + paramQQUser.mUin + ", flag=" + l);
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
    for (;;)
    {
      int i;
      try
      {
        bool = a();
        if (!bool)
        {
          localQQUser = null;
          return localQQUser;
        }
        Iterator localIterator = this.c.iterator();
        i = 1;
        if (!localIterator.hasNext()) {
          break label102;
        }
        QQUser localQQUser = (QQUser)localIterator.next();
        if ((!a) && (localQQUser == null)) {
          throw new AssertionError();
        }
      }
      finally {}
      boolean bool = localObject1.mIsCurrentUser;
      if (!bool) {
        if (i != paramInt)
        {
          i += 1;
          continue;
          label102:
          Object localObject2 = null;
        }
      }
    }
  }
  
  public void b(List<QQUser> paramList)
  {
    if ((this.c == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.c.size())
      {
        if (((QQUser)this.c.get(i)).mIsRegisterFacePwd) {
          paramList.add(this.c.get(i));
        }
        i += 1;
      }
    }
  }
  
  public boolean b(long paramLong)
  {
    QQUser localQQUser = b(this.c, paramLong);
    if (localQQUser == null)
    {
      g.c("find user not exist with uin:" + paramLong);
      return false;
    }
    return e(localQQUser);
  }
  
  public boolean b(QQUser paramQQUser)
  {
    boolean bool1 = false;
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    if (this.c.size() >= 3) {}
    boolean bool2;
    do
    {
      return bool1;
      if (paramQQUser.mUin == 0L) {
        paramQQUser.mUin = paramQQUser.mRealUin;
      }
      int i = 0;
      while (i < this.c.size())
      {
        if (((QQUser)this.c.get(i)).mRealUin == paramQQUser.mRealUin) {
          return true;
        }
        i += 1;
      }
      bool2 = g(paramQQUser);
      bool1 = bool2;
    } while (!bool2);
    this.c.add(paramQQUser);
    return bool2;
  }
  
  public QQUser c()
  {
    for (;;)
    {
      QQUser localQQUser2;
      try
      {
        boolean bool = a();
        if (!bool)
        {
          localObject1 = null;
          return localObject1;
        }
        if (this.d != null) {
          break label219;
        }
        Object localObject1 = this.c.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label88;
        }
        localQQUser2 = (QQUser)((Iterator)localObject1).next();
        if ((!a) && (localQQUser2 == null)) {
          throw new AssertionError();
        }
      }
      finally {}
      if (localQQUser2.mIsCurrentUser)
      {
        this.d = localQQUser2;
        label88:
        if ((this.d == null) && (this.c.size() > 0))
        {
          this.d = ((QQUser)this.c.get(0));
          g.a("user uin=" + this.d.mUin + ",email=" + this.d.mEmail + ",currentUser=" + this.d.mIsCurrentUser);
          a(this.d, true);
          if ((!a) && (!this.d.mIsCurrentUser)) {
            throw new AssertionError();
          }
        }
        label219:
        QQUser localQQUser1 = this.d;
      }
    }
  }
  
  public QQUser c(long paramLong)
  {
    return a(this.c, paramLong);
  }
  
  public boolean c(QQUser paramQQUser)
  {
    boolean bool2 = false;
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    boolean bool3 = f(paramQQUser);
    boolean bool1 = bool2;
    int i;
    if (bool3) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.c.size())
      {
        if (((QQUser)this.c.get(i)).mRealUin == paramQQUser.mRealUin)
        {
          this.c.remove(i);
          if (paramQQUser.mIsCurrentUser) {
            d();
          }
          bool1 = bool3;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
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
    for (;;)
    {
      QQUser localQQUser2;
      try
      {
        this.d = null;
        Iterator localIterator = this.c.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localQQUser2 = (QQUser)localIterator.next();
        if ((!a) && (localQQUser2 == null)) {
          throw new AssertionError();
        }
      }
      finally {}
      if (localQQUser2.mIsCurrentUser) {
        this.d = localQQUser2;
      }
    }
    if ((this.d == null) && (this.c.size() > 0))
    {
      this.d = ((QQUser)this.c.get(0));
      g.a("user uin=" + this.d.mUin + ",email=" + this.d.mEmail + ",currentUser=" + this.d.mIsCurrentUser);
      a(this.d, true);
      if ((!a) && (!this.d.mIsCurrentUser)) {
        throw new AssertionError();
      }
    }
    QQUser localQQUser1 = this.d;
    return localQQUser1;
  }
  
  public QQUser d(long paramLong)
  {
    return b(this.c, paramLong);
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (this.e)
    {
      this.e = false;
      if (!this.e) {
        bool = true;
      }
      return bool;
    }
    return this.e;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/token/eq:c	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: aload_0
    //   18: getfield 36	com/tencent/token/eq:c	Ljava/util/List;
    //   21: invokeinterface 248 1 0
    //   26: if_icmpge -15 -> 11
    //   29: aload_0
    //   30: getfield 36	com/tencent/token/eq:c	Ljava/util/List;
    //   33: iload_1
    //   34: invokeinterface 188 2 0
    //   39: checkcast 58	com/tencent/token/core/bean/QQUser
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +27 -> 71
    //   47: aload_2
    //   48: getfield 209	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   51: ifeq +20 -> 71
    //   54: aload_0
    //   55: aload_2
    //   56: invokespecial 200	com/tencent/token/eq:f	(Lcom/tencent/token/core/bean/QQUser;)Z
    //   59: pop
    //   60: aload_2
    //   61: iconst_0
    //   62: putfield 209	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   65: aload_0
    //   66: aload_2
    //   67: invokespecial 206	com/tencent/token/eq:g	(Lcom/tencent/token/core/bean/QQUser;)Z
    //   70: pop
    //   71: iload_1
    //   72: iconst_1
    //   73: iadd
    //   74: istore_1
    //   75: goto -59 -> 16
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	eq
    //   15	60	1	i	int
    //   6	61	2	localObject1	Object
    //   78	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	78	finally
    //   16	43	78	finally
    //   47	71	78	finally
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
    if (this.c == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.c.size())
      {
        if (((QQUser)this.c.get(i)).mIsRegisterFacePwd) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean i()
  {
    QQUser localQQUser1 = c();
    if ((localQQUser1 == null) || (this.c == null)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.c.size())
      {
        QQUser localQQUser2 = (QQUser)this.c.get(i);
        if ((localQQUser2.mIsRegisterFacePwd) && (localQQUser2.mUin == localQQUser1.mUin)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public class a
    implements et
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
    
    public et a(Cursor paramCursor)
    {
      int n = 0;
      a locala = new a(eq.this);
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
      if ((locala.g != null) && (locala.g.length >= 64))
      {
        paramCursor = locala.g;
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
        locala.b = 0L;
      }
      return locala;
    }
    
    public void a(a parama, long paramLong)
    {
      boolean bool2 = true;
      if ((1L & paramLong) != 0L)
      {
        bool1 = true;
        parama.f = bool1;
        if ((0x2 & paramLong) == 0L) {
          break label104;
        }
        bool1 = true;
        label33:
        parama.i = bool1;
        if ((0x8 & paramLong) == 0L) {
          break label110;
        }
        bool1 = true;
        label52:
        parama.k = bool1;
        if ((0x4 & paramLong) != 0L) {
          break label116;
        }
        bool1 = true;
        label71:
        parama.j = bool1;
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
        parama.l = bool1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eq
 * JD-Core Version:    0.7.0.1
 */