package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class fy
{
  private boolean b = false;
  private List c = new ArrayList();
  private QQUser d = null;
  private boolean e = false;
  
  static
  {
    if (!fy.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  /* Error */
  private QQUser a(List paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface 44 1 0
    //   8: astore 6
    //   10: aload 6
    //   12: invokeinterface 49 1 0
    //   17: ifeq +31 -> 48
    //   20: aload 6
    //   22: invokeinterface 53 1 0
    //   27: checkcast 55	com/tencent/token/core/bean/QQUser
    //   30: astore_1
    //   31: aload_1
    //   32: getfield 59	com/tencent/token/core/bean/QQUser:mUin	J
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
    //   0	58	0	this	fy
    //   0	58	1	paramList	List
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
    fz localfz = new fz(this);
    ContentValues localContentValues = new ContentValues();
    localfz.a(paramQQUser);
    long l = localfz.a();
    localContentValues.put("flag", Long.valueOf(l));
    h.b("set user flag " + paramQQUser.a() + ":" + l);
    if (ga.a(localfz, "table_user", localContentValues, "uin=?", new String[] { String.valueOf(d(paramQQUser)) }) <= 0)
    {
      h.c("update uin flag failed, uin=" + paramQQUser.mUin + ", flag=" + l);
      return false;
    }
    paramQQUser.mIsCurrentUser = paramBoolean;
    return true;
  }
  
  /* Error */
  private QQUser b(List paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface 44 1 0
    //   8: astore 6
    //   10: aload 6
    //   12: invokeinterface 49 1 0
    //   17: ifeq +31 -> 48
    //   20: aload 6
    //   22: invokeinterface 53 1 0
    //   27: checkcast 55	com/tencent/token/core/bean/QQUser
    //   30: astore_1
    //   31: aload_1
    //   32: getfield 143	com/tencent/token/core/bean/QQUser:mRealUin	J
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
    //   0	58	0	this	fy
    //   0	58	1	paramList	List
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
      h.a(bool);
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
    fz localfz = new fz(this);
    try
    {
      ga.a(localfz, "table_user", "uin=?", new String[] { String.valueOf(d(paramQQUser)) });
      return true;
    }
    catch (Exception paramQQUser)
    {
      h.c("clear user database failed: " + paramQQUser.toString());
    }
    return false;
  }
  
  private boolean g(QQUser paramQQUser)
  {
    fz localfz = new fz(this);
    if (!localfz.a(paramQQUser))
    {
      h.c("userData.SaveUser failed");
      return false;
    }
    if (ga.b(localfz) == -1L)
    {
      h.c("SQLiteManager.add user data failed: " + paramQQUser.mUin);
      return false;
    }
    return true;
  }
  
  public QQUser a(int paramInt)
  {
    int i = b();
    if (paramInt >= i)
    {
      h.c("inval param, index:" + paramInt + ",count:" + i);
      return null;
    }
    return (QQUser)this.c.get(paramInt);
  }
  
  public void a(List paramList)
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
        Object localObject1 = new fz(this);
        continue;
      }
      finally
      {
        try
        {
          localObject1 = ga.a((gd)localObject1, "table_user", new String[] { "uin", "email", "nick_name", "uin_mask", "flag", "head_image", "head_image_update_time" }, null, null, null, null, null, null);
          if ((a) || (localObject1 != null)) {
            break label131;
          }
          throw new AssertionError();
        }
        catch (Exception localException)
        {
          h.c(localException.toString());
          bool = false;
        }
        localObject2 = finally;
      }
      label131:
      Object localObject3 = localException.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (fz)((Iterator)localObject3).next();
        if ((!a) && (localObject4 == null)) {
          throw new AssertionError();
        }
        localObject4 = ((fz)localObject4).d();
        if ((!a) && (localObject4 == null)) {
          throw new AssertionError();
        }
        if (((QQUser)localObject4).mIsBinded)
        {
          this.c.add(localObject4);
          h.b("uin=" + ((QQUser)localObject4).mUin + ",nick=" + ((QQUser)localObject4).mNickName + "email=" + ((QQUser)localObject4).mEmail + "list count=" + this.c.size());
        }
      }
      Iterator localIterator = localException.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (fz)localIterator.next();
        if ((!a) && (localObject3 == null)) {
          throw new AssertionError();
        }
        localObject3 = ((fz)localObject3).d();
        if ((!a) && (localObject3 == null)) {
          throw new AssertionError();
        }
        if (!((QQUser)localObject3).mIsBinded)
        {
          this.c.add(localObject3);
          h.b("uin=" + ((QQUser)localObject3).mUin + ",nick=" + ((QQUser)localObject3).mNickName + "email=" + ((QQUser)localObject3).mEmail + "list count=" + this.c.size());
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
      h.c("find user not exist with uin:" + paramLong);
      return false;
    }
    return e(localQQUser);
  }
  
  public boolean a(QQUser paramQQUser)
  {
    if ((!a) && (paramQQUser == null)) {
      throw new AssertionError();
    }
    fz localfz = new fz(this);
    ContentValues localContentValues = new ContentValues();
    localfz.a(paramQQUser);
    long l = localfz.a();
    localContentValues.put("flag", Long.valueOf(l));
    h.b("set user flag " + paramQQUser.a() + ":" + l);
    if (ga.a(localfz, "table_user", localContentValues, "uin=?", new String[] { String.valueOf(d(paramQQUser)) }) <= 0)
    {
      h.c("update uin flag failed, uin=" + paramQQUser.mUin + ", flag=" + l);
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
  
  public void b(List paramList)
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
      h.c("find user not exist with uin:" + paramLong);
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
          h.a("user uin=" + this.d.mUin + ",email=" + this.d.mEmail + ",currentUser=" + this.d.mIsCurrentUser);
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
      h.a("user uin=" + this.d.mUin + ",email=" + this.d.mEmail + ",currentUser=" + this.d.mIsCurrentUser);
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
  
  public long f()
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
  
  public boolean g()
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
  
  public boolean h()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fy
 * JD-Core Version:    0.7.0.1
 */