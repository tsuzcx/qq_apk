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

public final class tt
{
  public static final abo b = new abo("D87898D3A8B8FBB37DD9885F87E8817449FA1EBDBFCF7BDA2FA6DF721E7B99D2AF7A7368637009A6C6675A9180FB0F635400FEF6A64754186CDB72BF0A60B53257336A248A7F7AAF72F160894A60C68528E5FBCDF29D675F262400A656E34FA28C6D3D77357B4BA0B1CD928BFFAB90AA7948B862B167594027AF6DC0B4A16E53", 16);
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  private static tt q = null;
  public byte[] a = null;
  public long g = 0L;
  public long h = 0L;
  public boolean i = true;
  public boolean j = false;
  public ajr k = null;
  public QQUser l = null;
  public long m = 0L;
  public long n = 0L;
  public long o = 0L;
  private abo p = new abo("-1");
  private HashMap<String, a> r = new HashMap();
  
  public static QQUser a(xt paramxt)
  {
    paramxt.a();
    tt localtt = a();
    if (localtt.k.b() == null)
    {
      xv.c("there is no user bind");
      paramxt.a(110, "there is no user bind", null);
      return null;
    }
    Object localObject2 = localtt.f();
    boolean bool = false;
    if (localObject2 != null)
    {
      paramxt.a = 0;
      return localObject2;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localtt.k();
      if (!((xt)localObject1).b())
      {
        localObject2 = new StringBuilder("user login failed:");
        ((StringBuilder)localObject2).append(((xt)localObject1).a);
        ((StringBuilder)localObject2).append(((xt)localObject1).b);
        xv.c(((StringBuilder)localObject2).toString());
        paramxt.a((xt)localObject1);
        return null;
      }
      localObject1 = localtt.f();
      if (localObject1 != null) {
        bool = true;
      }
      xv.a(bool);
    }
    return localObject1;
  }
  
  public static tt a()
  {
    if (q == null) {
      q = new tt();
    }
    return q;
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      long l1 = paramJSONObject.getLong("server_time");
      sv.b();
      sv.a(l1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label16:
      break label16;
    }
    xv.c("correct time error");
  }
  
  public static Bitmap b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new akl().a(paramString);
    if (paramString == null) {
      return null;
    }
    return aaz.a(paramString);
  }
  
  private xt b(xt paramxt)
  {
    Object localObject1 = new xt();
    paramxt.a();
    Object localObject3 = a();
    if (!((tt)localObject3).i())
    {
      localObject2 = ((tt)localObject3).m();
      localObject1 = localObject2;
      if (!((xt)localObject2).b()) {
        return localObject2;
      }
    }
    Object localObject2 = ((tt)localObject3).k.b();
    if (localObject2 == null)
    {
      ((xt)localObject1).a(110, null, null);
      return localObject1;
    }
    try
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject3 = new AtomicReference(null);
      rt.a().a(0, aay.k(), new rt.a()
      {
        public final void a(rv paramAnonymousrv)
        {
          this.a.set(paramAnonymousrv);
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
      localObject3 = (rv)((AtomicReference)localObject3).get();
      if (localObject3 == null)
      {
        ((xt)localObject1).a(-798, null, null);
        return localObject1;
      }
      try
      {
        int i1 = ((rv)localObject3).b;
        if (i1 != 0)
        {
          localObject2 = ((rv)localObject3).d;
          ((xt)localObject1).a(i1, (String)localObject2, (String)localObject2);
          paramxt.a(i1, null, null);
          xv.c("server errcode=".concat(String.valueOf(i1)));
        }
        else
        {
          paramxt = ((rv)localObject3).c;
          if (paramxt != null)
          {
            paramxt = new JSONObject(paramxt);
            long l1 = paramxt.getLong("uin");
            if (l1 != ((QQUser)localObject2).mUin)
            {
              paramxt = new StringBuilder("uin not match=");
              paramxt.append(l1);
              paramxt.append(":");
              paramxt.append(((QQUser)localObject2).mUin);
              ((xt)localObject1).a(10000, paramxt.toString(), null);
              return localObject1;
            }
            a().g();
            if (!this.k.a(l1))
            {
              ((xt)localObject1).a(10000, "mUserStorage.setCurrentUserByUin failed", null);
              return localObject1;
            }
            this.l = ((QQUser)localObject2);
            this.m = (System.currentTimeMillis() / 1000L);
            this.n = paramxt.getInt("valid_time");
            ((xt)localObject1).a = 0;
          }
          else
          {
            xv.c("parseJSON error decodeData");
            ((xt)localObject1).a(10022, RqdApplication.n().getString(2131493069), RqdApplication.n().getString(2131493069));
          }
        }
      }
      catch (JSONException paramxt)
      {
        localObject2 = new StringBuilder("parse json failed: ");
        ((StringBuilder)localObject2).append(paramxt.toString());
        xv.c(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject2).append(paramxt.toString());
        ((xt)localObject1).a(10020, ((StringBuilder)localObject2).toString(), null);
      }
      return localObject1;
    }
    finally {}
  }
  
  public static void b()
  {
    q = null;
  }
  
  public static String n()
  {
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("tkn_seq", "0");
      ((JSONObject)localObject1).put("code", null);
      ((JSONObject)localObject1).put("pm", URLEncoder.encode(yd.a));
      ((JSONObject)localObject1).put("pb", URLEncoder.encode(Build.BRAND));
      ((JSONObject)localObject1).put("ps", Build.VERSION.SDK);
      ((JSONObject)localObject1).put("pr", URLEncoder.encode(Build.VERSION.RELEASE));
      ((JSONObject)localObject1).put("net_type", aay.i());
      localObject2 = aay.d(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("router_id", localObject2);
      }
      localObject2 = aay.c(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("mac", localObject2);
      }
      localObject2 = aay.b(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("android_id", localObject2);
      }
      RqdApplication.n();
      localObject2 = aay.l();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("device_id", localObject2);
      }
      int i1 = su.b + 1;
      su.b = i1;
      ((JSONObject)localObject1).put("seq_id", i1);
      ((JSONObject)localObject1).put("turingd_ticket_id", yc.b());
      localObject1 = ((JSONObject)localObject1).toString();
      xv.a("plain:".concat(String.valueOf(localObject1)));
      localObject1 = aay.b(((String)localObject1).getBytes());
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.getMessage());
      xv.c(((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  private void o()
  {
    if (RqdApplication.h) {
      switch (xr.a())
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
  
  public final xt a(String paramString, long paramLong)
  {
    xt localxt = new xt();
    Object localObject1 = a();
    ((tt)localObject1).h();
    localObject1 = ((tt)localObject1).l();
    if (!((xt)localObject1).b()) {
      return localObject1;
    }
    boolean bool2 = true;
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    localObject1 = new AtomicReference(null);
    rt.a().b(Long.parseLong(paramString), paramLong, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        this.a.set(paramAnonymousrv);
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
    localObject1 = (rv)((AtomicReference)localObject1).get();
    if (localObject1 == null)
    {
      localxt.a(-367, null, null);
      return localxt;
    }
    for (;;)
    {
      try
      {
        int i1 = ((rv)localObject1).b;
        if (i1 != 0)
        {
          if (102 == i1)
          {
            long l1 = System.currentTimeMillis() + rt.a().g();
            long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
            localObject1 = new StringBuilder("sleep ");
            ((StringBuilder)localObject1).append(l2);
            ((StringBuilder)localObject1).append("s for dyncode refresh:");
            ((StringBuilder)localObject1).append(l1);
            xv.a(((StringBuilder)localObject1).toString());
            try
            {
              Thread.sleep(l2 * 1000L);
            }
            catch (Exception localException)
            {
              xv.c(localException.getMessage());
            }
            sv.b();
            return a(paramString, paramLong);
          }
          paramString = localException.d;
          localxt.a(i1, paramString, paramString);
          return localxt;
        }
        paramString = new JSONObject(localException.c);
        xv.a(true);
        xv.a("data hex: ".concat(String.valueOf(paramString)));
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
          localxt.a = 0;
          return localxt;
        }
      }
      catch (Exception paramString)
      {
        localObject2 = new StringBuilder("unknown err: ");
        ((StringBuilder)localObject2).append(paramString.toString());
        xv.c(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject2).append(paramString.toString());
        localxt.a(10021, ((StringBuilder)localObject2).toString(), null);
        return localxt;
      }
      catch (JSONException paramString)
      {
        Object localObject2 = new StringBuilder("parse json failed: ");
        ((StringBuilder)localObject2).append(paramString.toString());
        xv.c(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject2).append(paramString.toString());
        localxt.a(10020, ((StringBuilder)localObject2).toString(), null);
        return localxt;
      }
      boolean bool1 = true;
    }
  }
  
  public final xt a(JSONArray paramJSONArray)
  {
    xt localxt = new xt();
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
          xv.a(((StringBuilder)localObject2).toString());
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
        localxt.a(10020, ((StringBuilder)localObject1).toString(), null);
        return localxt;
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
      localxt.a = 0;
      return localxt;
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
    rt.a().c(Long.parseLong(paramString), new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        if (paramAnonymousrv.b == 0) {
          try
          {
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c).getString("photo_url");
            localAtomicReference.set(paramAnonymousrv);
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
            localxt.a = 10020;
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
    if ((paramQQUser != null) && (paramQQUser.mRealUin != 0L)) {
      return this.k.b(paramQQUser);
    }
    return false;
  }
  
  public final QQUser b(int paramInt)
  {
    return this.k.b(paramInt);
  }
  
  public final boolean b(long paramLong)
  {
    return this.k.b(paramLong);
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
    ajr localajr = this.k;
    if (localajr.a != null)
    {
      int i1 = 0;
      while (i1 < localajr.a.size())
      {
        if (((QQUser)localajr.a.get(i1)).mIsRegisterFacePwd) {
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
    ajr localajr = this.k;
    QQUser localQQUser1 = localajr.b();
    if (localQQUser1 != null)
    {
      if (localajr.a == null) {
        return false;
      }
      int i1 = 0;
      while (i1 < localajr.a.size())
      {
        QQUser localQQUser2 = (QQUser)localajr.a.get(i1);
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
      xv.a("not prepare");
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
      xv.a(localStringBuilder.toString());
      if (this.m + this.n > l1) {
        return this.l;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("user not login, login_user=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",current_user=");
    localStringBuilder.append(localQQUser);
    xv.a(localStringBuilder.toString());
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
    o();
    this.i = true;
  }
  
  public final boolean i()
  {
    if (!this.j)
    {
      xv.a("uinlist not queryed");
      return false;
    }
    return true;
  }
  
  public final xt j()
  {
    try
    {
      xv.a("start syncPrepare process");
      o();
      xt localxt = m();
      boolean bool = localxt.b();
      if (!bool) {
        return localxt;
      }
      xv.a(i());
      localxt = new xt((byte)0);
      return localxt;
    }
    finally {}
  }
  
  public final xt k()
  {
    try
    {
      xv.a("start syncLogin process");
      xt localxt2 = new xt();
      Object localObject1 = b(localxt2);
      boolean bool = ((xt)localObject1).b();
      if (bool) {
        return localObject1;
      }
      xt localxt1;
      if (localxt2.a == 102)
      {
        long l1 = System.currentTimeMillis() + rt.a().g();
        long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
        localObject1 = new StringBuilder("sleep ");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("s for dyncode refresh:");
        ((StringBuilder)localObject1).append(l1);
        xv.a(((StringBuilder)localObject1).toString());
        try
        {
          Thread.sleep(l2 * 1000L);
        }
        catch (Exception localException)
        {
          xv.c(localException.getMessage());
        }
        localxt1 = b(localxt2);
      }
      else if (localxt2.a == 104)
      {
        h();
        localxt1 = b(localxt2);
      }
      else if (localxt2.a == 112)
      {
        localxt1 = b(localxt2);
      }
      return localxt1;
    }
    finally {}
  }
  
  public final xt l()
  {
    try
    {
      sp.a.a();
      xt localxt = sp.a();
      return localxt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final xt m()
  {
    try
    {
      xv.a("start syncQueryUinList process");
      new xt();
      xt localxt = sp.a.a().c();
      return localxt;
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
 * Qualified Name:     com.tencent.token.tt
 * JD-Core Version:    0.7.0.1
 */