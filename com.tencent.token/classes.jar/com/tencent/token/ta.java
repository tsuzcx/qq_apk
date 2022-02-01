package com.tencent.token;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.UserTask;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ta
{
  public static final aat b = new aat("D87898D3A8B8FBB37DD9885F87E8817449FA1EBDBFCF7BDA2FA6DF721E7B99D2AF7A7368637009A6C6675A9180FB0F635400FEF6A64754186CDB72BF0A60B53257336A248A7F7AAF72F160894A60C68528E5FBCDF29D675F262400A656E34FA28C6D3D77357B4BA0B1CD928BFFAB90AA7948B862B167594027AF6DC0B4A16E53", 16);
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  private static ta q = null;
  public byte[] a = null;
  public long g = 0L;
  public long h = 0L;
  public boolean i = true;
  public boolean j = false;
  public ahh k = null;
  public QQUser l = null;
  public long m = 0L;
  public long n = 0L;
  public long o = 0L;
  private aat p = new aat("-1");
  private HashMap<String, a> r = new HashMap();
  
  public static QQUser a(wz paramwz)
  {
    paramwz.a();
    ta localta = a();
    if (localta.k.b() == null)
    {
      xb.c("there is no user bind");
      paramwz.a(110, "there is no user bind", null);
      return null;
    }
    Object localObject2 = localta.f();
    boolean bool = false;
    if (localObject2 != null)
    {
      paramwz.a = 0;
      return localObject2;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localta.k();
      if (!((wz)localObject1).b())
      {
        localObject2 = new StringBuilder("user login failed:");
        ((StringBuilder)localObject2).append(((wz)localObject1).a);
        ((StringBuilder)localObject2).append(((wz)localObject1).b);
        xb.c(((StringBuilder)localObject2).toString());
        paramwz.a((wz)localObject1);
        return null;
      }
      localObject1 = localta.f();
      if (localObject1 != null) {
        bool = true;
      }
      xb.a(bool);
    }
    return localObject1;
  }
  
  public static ta a()
  {
    if (q == null) {
      q = new ta();
    }
    return q;
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("tkn_seq", String.valueOf(paramLong));
      ((JSONObject)localObject).put("code", paramString);
      ((JSONObject)localObject).put("pm", URLEncoder.encode(Build.MODEL));
      ((JSONObject)localObject).put("pb", URLEncoder.encode(Build.BRAND));
      ((JSONObject)localObject).put("ps", Build.VERSION.SDK);
      ((JSONObject)localObject).put("pr", URLEncoder.encode(Build.VERSION.RELEASE));
      ((JSONObject)localObject).put("net_type", aad.i());
      paramString = aad.d(RqdApplication.n());
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("router_id", paramString);
      }
      paramString = aad.c(RqdApplication.n());
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("mac", paramString);
      }
      paramString = aad.a(RqdApplication.n());
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("android_id", paramString);
      }
      paramString = aad.b(RqdApplication.n());
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("device_id", paramString);
      }
      int i1 = sb.b + 1;
      sb.b = i1;
      ((JSONObject)localObject).put("seq_id", i1);
      ((JSONObject)localObject).put("turingd_ticket_id", xf.b());
      paramString = ((JSONObject)localObject).toString();
      xb.a("plain:".concat(String.valueOf(paramString)));
      paramString = aad.b(paramString.getBytes());
      return paramString;
    }
    catch (JSONException paramString)
    {
      Object localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      xb.c(((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      long l1 = paramJSONObject.getLong("server_time");
      sc.b();
      sc.a(l1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label17:
      break label17;
    }
    xb.c("correct time error");
  }
  
  public static Bitmap b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new ahr().a(paramString);
    if (paramString == null) {
      return null;
    }
    return aae.a(paramString);
  }
  
  private wz b(wz paramwz)
  {
    Object localObject1 = new wz();
    paramwz.a();
    Object localObject3 = a();
    if (!((ta)localObject3).i())
    {
      localObject2 = ((ta)localObject3).m();
      localObject1 = localObject2;
      if (!((wz)localObject2).b()) {
        return localObject2;
      }
    }
    Object localObject2 = ((ta)localObject3).k.b();
    if (localObject2 == null)
    {
      ((wz)localObject1).a(110, null, null);
      return localObject1;
    }
    try
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject3 = new AtomicReference(null);
      qz.a().a(0, aad.k(), new qz.a()
      {
        public final void a(rb paramAnonymousrb)
        {
          this.a.set(paramAnonymousrb);
          localCountDownLatch.countDown();
        }
      });
      try
      {
        localCountDownLatch.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      localObject3 = (rb)((AtomicReference)localObject3).get();
      if (localObject3 == null)
      {
        ((wz)localObject1).a(-798, null, null);
        return localObject1;
      }
      try
      {
        int i1 = ((rb)localObject3).b;
        if (i1 != 0)
        {
          localObject2 = ((rb)localObject3).d;
          ((wz)localObject1).a(i1, (String)localObject2, (String)localObject2);
          paramwz.a(i1, null, null);
          xb.c("server errcode=".concat(String.valueOf(i1)));
        }
        else
        {
          paramwz = ((rb)localObject3).c;
          if (paramwz != null)
          {
            paramwz = new JSONObject(paramwz);
            long l1 = paramwz.getLong("uin");
            if (l1 != ((QQUser)localObject2).mUin)
            {
              paramwz = new StringBuilder("uin not match=");
              paramwz.append(l1);
              paramwz.append(":");
              paramwz.append(((QQUser)localObject2).mUin);
              ((wz)localObject1).a(10000, paramwz.toString(), null);
              return localObject1;
            }
            a().g();
            if (!this.k.a(l1))
            {
              ((wz)localObject1).a(10000, "mUserStorage.setCurrentUserByUin failed", null);
              return localObject1;
            }
            this.l = ((QQUser)localObject2);
            this.m = (System.currentTimeMillis() / 1000L);
            this.n = paramwz.getInt("valid_time");
            ((wz)localObject1).a = 0;
          }
          else
          {
            xb.c("parseJSON error decodeData");
            ((wz)localObject1).a(10022, RqdApplication.n().getString(2131493068), RqdApplication.n().getString(2131493068));
          }
        }
      }
      catch (JSONException paramwz)
      {
        localObject2 = new StringBuilder("parse json failed: ");
        ((StringBuilder)localObject2).append(paramwz.toString());
        xb.c(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject2).append(paramwz.toString());
        ((wz)localObject1).a(10020, ((StringBuilder)localObject2).toString(), null);
      }
      return localObject1;
    }
    finally {}
  }
  
  public static void b()
  {
    q = null;
  }
  
  private void n()
  {
    if (RqdApplication.h) {
      switch (wx.a())
      {
      default: 
        d = null;
        break;
      case 3: 
        f = null;
        break;
      case 2: 
        e = null;
        break;
      case 1: 
        d = null;
        break;
      case 0: 
        c = null;
      }
    }
    this.j = false;
    this.g = 0L;
    this.h = 0L;
    this.l = null;
    this.m = 0L;
    this.n = 0L;
  }
  
  public final int a(final Handler paramHandler)
  {
    new UserTask() {}.a(new String[] { "" });
    return 0;
  }
  
  public final QQUser a(int paramInt)
  {
    return this.k.a(paramInt);
  }
  
  public final wz a(String paramString, long paramLong)
  {
    wz localwz = new wz();
    Object localObject1 = a();
    ((ta)localObject1).h();
    localObject1 = ((ta)localObject1).l();
    if (!((wz)localObject1).b()) {
      return localObject1;
    }
    boolean bool2 = true;
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    localObject1 = new AtomicReference(null);
    qz.a().b(Long.parseLong(paramString), paramLong, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        this.a.set(paramAnonymousrb);
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    localObject1 = (rb)((AtomicReference)localObject1).get();
    if (localObject1 == null)
    {
      localwz.a(-367, null, null);
      return localwz;
    }
    for (;;)
    {
      try
      {
        int i1 = ((rb)localObject1).b;
        if (i1 != 0)
        {
          if (102 == i1)
          {
            long l1 = System.currentTimeMillis() + qz.a().g();
            long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
            localObject1 = new StringBuilder("sleep ");
            ((StringBuilder)localObject1).append(l2);
            ((StringBuilder)localObject1).append("s for dyncode refresh:");
            ((StringBuilder)localObject1).append(l1);
            xb.a(((StringBuilder)localObject1).toString());
            try
            {
              Thread.sleep(l2 * 1000L);
            }
            catch (Exception localException)
            {
              xb.c(localException.getMessage());
            }
            sc.b().d();
            return a(paramString, paramLong);
          }
          paramString = localException.d;
          localwz.a(i1, paramString, paramString);
          return localwz;
        }
        paramString = new JSONObject(localException.c);
        xb.a(true);
        xb.a("data hex: ".concat(String.valueOf(paramString)));
        localObject2 = new a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getLong("uin"));
        ((a)localObject2).a = localStringBuilder.toString();
        ((a)localObject2).b = paramString.getString("sig");
        if (paramString.getInt("is_login_prot_set") == 0)
        {
          bool1 = false;
          ((a)localObject2).c = bool1;
          bool1 = bool2;
          if (paramString.getInt("is_game_prot_set") == 0) {
            bool1 = false;
          }
          ((a)localObject2).d = bool1;
          ((a)localObject2).e = paramString.getInt("is_tkn_set");
          if (((a)localObject2).e == 2) {
            ((a)localObject2).f = paramString.getString("other_tkn_seq");
          }
          this.r.put(((a)localObject2).a, localObject2);
          localwz.a = 0;
          return localwz;
        }
      }
      catch (Exception paramString)
      {
        localObject2 = new StringBuilder("unknown err: ");
        ((StringBuilder)localObject2).append(paramString.toString());
        xb.c(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject2).append(paramString.toString());
        localwz.a(10021, ((StringBuilder)localObject2).toString(), null);
        return localwz;
      }
      catch (JSONException paramString)
      {
        Object localObject2 = new StringBuilder("parse json failed: ");
        ((StringBuilder)localObject2).append(paramString.toString());
        xb.c(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject2).append(paramString.toString());
        localwz.a(10020, ((StringBuilder)localObject2).toString(), null);
        return localwz;
      }
      boolean bool1 = true;
    }
  }
  
  public final wz a(JSONArray paramJSONArray)
  {
    wz localwz = new wz();
    Object localObject1 = new LinkedList();
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < paramJSONArray.length())
        {
          localJSONObject = paramJSONArray.getJSONObject(i1);
          localObject2 = new StringBuilder("user json: ");
          ((StringBuilder)localObject2).append(localJSONObject.toString());
          xb.a(((StringBuilder)localObject2).toString());
          localObject2 = new QQUser();
          ((QQUser)localObject2).mUin = localJSONObject.getLong("uin");
          ((QQUser)localObject2).mUinMask = localJSONObject.getString("uin_mask");
          ((QQUser)localObject2).mNickName = localJSONObject.getString("nick");
          ((QQUser)localObject2).mRealUin = localJSONObject.getLong("real_uin");
          int i2 = localJSONObject.getInt("is_supper_qq");
          bool2 = true;
          if (i2 != 1) {
            break label315;
          }
          bool1 = true;
          ((QQUser)localObject2).mIsSupperQQ = bool1;
          ((QQUser)localObject2).mIsBinded = true;
        }
      }
      catch (JSONException paramJSONArray)
      {
        JSONObject localJSONObject;
        Object localObject2;
        boolean bool2;
        localObject1 = new StringBuilder("updateQueryUinList JSONException:");
        ((StringBuilder)localObject1).append(paramJSONArray.toString());
        localwz.a(10020, ((StringBuilder)localObject1).toString(), null);
        return localwz;
      }
      try
      {
        if (localJSONObject.getInt("have_face_auth") != 1) {
          break label321;
        }
        bool1 = true;
        ((QQUser)localObject2).mIsRegisterFacePwd = bool1;
        if (localJSONObject.getInt("is_zzb") != 1) {
          break label327;
        }
        bool1 = bool2;
        ((QQUser)localObject2).mIsZzb = bool1;
      }
      catch (Exception localException)
      {
        continue;
      }
      ((List)localObject1).add(localObject2);
      i1 += 1;
      continue;
      new StringBuilder("updateUinList, size:").append(((List)localObject1).size());
      this.k.a((List)localObject1);
      localwz.a = 0;
      return localwz;
      label315:
      boolean bool1 = false;
      continue;
      label321:
      bool1 = false;
      continue;
      label327:
      bool1 = false;
    }
  }
  
  public final String a(String paramString)
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final AtomicReference localAtomicReference = new AtomicReference();
    qz.a().c(Long.parseLong(paramString), new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        if (paramAnonymousrb.b == 0) {
          try
          {
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c).getString("photo_url");
            localAtomicReference.set(paramAnonymousrb);
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
            localwz.a = 10020;
          }
        }
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return (String)localAtomicReference.get();
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    QQUser localQQUser = c(paramLong1);
    if (localQQUser != null)
    {
      this.l = localQQUser;
      this.m = (System.currentTimeMillis() / 1000L);
      this.n = paramLong2;
    }
  }
  
  public final boolean a(long paramLong)
  {
    return this.k.a(paramLong);
  }
  
  public final boolean a(QQUser paramQQUser)
  {
    ahh localahh = this.k;
    boolean bool = ahh.c;
    int i1 = localahh.a.size();
    int i2 = 0;
    if (i1 >= 3) {
      return false;
    }
    i1 = i2;
    if (paramQQUser.mUin == 0L)
    {
      paramQQUser.mUin = paramQQUser.mRealUin;
      i1 = i2;
    }
    while (i1 < localahh.a.size())
    {
      if (((QQUser)localahh.a.get(i1)).mRealUin == paramQQUser.mRealUin) {
        return true;
      }
      i1 += 1;
    }
    bool = localahh.b(paramQQUser);
    if (bool) {
      localahh.a.add(paramQQUser);
    }
    return bool;
  }
  
  public final QQUser b(int paramInt)
  {
    return this.k.b(paramInt);
  }
  
  public final boolean b(long paramLong)
  {
    return this.k.b(paramLong);
  }
  
  public final boolean b(QQUser paramQQUser)
  {
    if ((paramQQUser != null) && (paramQQUser.mRealUin != 0L)) {
      return this.k.a(paramQQUser);
    }
    return false;
  }
  
  public final long c()
  {
    return this.k.d();
  }
  
  public final QQUser c(long paramLong)
  {
    return this.k.c(paramLong);
  }
  
  public final a c(String paramString)
  {
    return (a)this.r.get(paramString);
  }
  
  public final boolean c(int paramInt)
  {
    if (104 == paramInt)
    {
      if (!j().b()) {
        return false;
      }
      return k().b();
    }
    if (109 == paramInt) {
      return k().b();
    }
    return false;
  }
  
  public final QQUser d(long paramLong)
  {
    return this.k.d(paramLong);
  }
  
  public final boolean d()
  {
    ahh localahh = this.k;
    if (localahh.a != null)
    {
      int i1 = 0;
      while (i1 < localahh.a.size())
      {
        if (((QQUser)localahh.a.get(i1)).mIsRegisterFacePwd) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public final void e(long paramLong)
  {
    QQUser localQQUser = d(paramLong);
    if (localQQUser != null)
    {
      this.l = localQQUser;
      this.m = this.g;
      this.n = this.h;
    }
  }
  
  public final boolean e()
  {
    ahh localahh = this.k;
    QQUser localQQUser1 = localahh.b();
    if (localQQUser1 != null)
    {
      if (localahh.a == null) {
        return false;
      }
      int i1 = 0;
      while (i1 < localahh.a.size())
      {
        QQUser localQQUser2 = (QQUser)localahh.a.get(i1);
        if ((localQQUser2.mIsRegisterFacePwd) && (localQQUser2.mUin == localQQUser1.mUin)) {
          return true;
        }
        i1 += 1;
      }
      return false;
    }
    return false;
  }
  
  public final QQUser f()
  {
    if (!i())
    {
      xb.a("not prepare");
      return null;
    }
    QQUser localQQUser = this.k.b();
    if ((localQQUser != null) && (this.l == localQQUser))
    {
      long l1 = System.currentTimeMillis() / 1000L;
      localStringBuilder = new StringBuilder("mLoginTime =");
      localStringBuilder.append(this.m);
      localStringBuilder.append(",mLoginValidInterval= ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(",nowTime=");
      localStringBuilder.append(l1);
      xb.a(localStringBuilder.toString());
      if (this.m + this.n > l1) {
        return this.l;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("user not login, login_user=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",current_user=");
    localStringBuilder.append(localQQUser);
    xb.a(localStringBuilder.toString());
    this.l = null;
    this.m = 0L;
    this.n = 0L;
    return null;
  }
  
  public final void f(long paramLong)
  {
    this.j = false;
    com.tencent.token.ui.AccountPageActivity.mNeedRefreshEval = true;
    this.o = paramLong;
  }
  
  public final void g()
  {
    this.g = (System.currentTimeMillis() / 1000L);
  }
  
  public final void h()
  {
    n();
    this.i = true;
  }
  
  public final boolean i()
  {
    if (!this.j)
    {
      xb.a("uinlist not queryed");
      return false;
    }
    return true;
  }
  
  public final wz j()
  {
    try
    {
      xb.a("start syncPrepare process");
      n();
      wz localwz = m();
      boolean bool = localwz.b();
      if (!bool) {
        return localwz;
      }
      xb.a(i());
      localwz = new wz((byte)0);
      return localwz;
    }
    finally {}
  }
  
  public final wz k()
  {
    try
    {
      xb.a("start syncLogin process");
      wz localwz2 = new wz();
      Object localObject1 = b(localwz2);
      boolean bool = ((wz)localObject1).b();
      if (bool) {
        return localObject1;
      }
      wz localwz1;
      if (localwz2.a == 102)
      {
        long l1 = System.currentTimeMillis() + qz.a().g();
        long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
        localObject1 = new StringBuilder("sleep ");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("s for dyncode refresh:");
        ((StringBuilder)localObject1).append(l1);
        xb.a(((StringBuilder)localObject1).toString());
        try
        {
          Thread.sleep(l2 * 1000L);
        }
        catch (Exception localException)
        {
          xb.c(localException.getMessage());
        }
        localwz1 = b(localwz2);
      }
      else if (localwz2.a == 104)
      {
        h();
        localwz1 = b(localwz2);
      }
      else if (localwz2.a == 112)
      {
        localwz1 = b(localwz2);
      }
      return localwz1;
    }
    finally {}
  }
  
  public final wz l()
  {
    try
    {
      rv.a.a();
      wz localwz = rv.a();
      return localwz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final wz m()
  {
    try
    {
      xb.a("start syncQueryUinList process");
      new wz();
      wz localwz = rv.a.a().c();
      return localwz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final class a
  {
    public String a;
    public String b;
    public boolean c;
    public boolean d;
    public int e;
    public String f;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ta
 * JD-Core Version:    0.7.0.1
 */