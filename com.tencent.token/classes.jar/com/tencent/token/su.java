package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.jni.FaceDetector;
import com.tencent.token.core.bean.AbnormalLoginMsgResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.FreezeStatusResult;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.bean.RealNameRegResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.RqdApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class su
  implements tz
{
  public static int b = new Random().nextInt() >>> 1;
  private static su c;
  public ue a = new ue();
  
  public static su a()
  {
    if (c == null) {
      c = new su();
    }
    return c;
  }
  
  static void a(Handler paramHandler, xt paramxt, int paramInt)
  {
    if (paramHandler != null) {
      Message.obtain(paramHandler, paramInt, paramxt.a, 0, paramxt).sendToTarget();
    }
  }
  
  static void a(rv paramrv, Handler paramHandler, int paramInt)
  {
    xt localxt = new xt();
    localxt.a = paramrv.b;
    localxt.c = paramrv.d;
    localxt.b = paramrv.d;
    if (paramrv.b == 0) {
      localxt.a = 0;
    }
    a(paramHandler, localxt, paramInt);
  }
  
  public static void a(rv paramrv, xt paramxt)
  {
    if (paramrv.b == 0) {
      try
      {
        paramxt.e = new tb(paramrv.c);
        paramrv = tt.a().a(new JSONObject(paramrv.c).getJSONArray("uinlist"));
        if (paramrv.b())
        {
          tt.a().j = true;
          if (tt.a().o != 0L)
          {
            tt.a().b(tt.a().o);
            tt.a().o = 0L;
          }
          paramxt.a = 0;
          return;
        }
        paramxt.a = paramrv.a;
        return;
      }
      catch (JSONException paramrv)
      {
        paramrv.printStackTrace();
        paramxt.a = 10020;
      }
    }
  }
  
  public static int b()
  {
    return b;
  }
  
  public final int a(byte paramByte, final Handler paramHandler)
  {
    xt localxt = new xt();
    tt localtt = tt.a();
    long l = localtt.c();
    if ((localtt.k.b() != null) && (l != 0L))
    {
      if (localtt.k.b().mIsBinded) {
        l = localtt.k.b().mUin;
      }
      rt.a().a(l, paramByte, new rt.a()
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
              paramAnonymousrv = new JSONObject(paramAnonymousrv.c).getJSONArray("msgs");
              if (!tr.a().a(paramAnonymousrv, this.a))
              {
                StringBuilder localStringBuilder = new StringBuilder("update conf list failed:");
                localStringBuilder.append(paramAnonymousrv.toString());
                localxt.a(10000, localStringBuilder.toString(), null);
              }
              else
              {
                tt.a().g();
                localxt.a = 0;
              }
            }
            catch (JSONException paramAnonymousrv)
            {
              paramAnonymousrv.printStackTrace();
            }
          }
          su.a(paramHandler, localxt, 3069);
        }
      });
      return 0;
    }
    localxt.a(110, null, null);
    a(paramHandler, localxt, 3069);
    return 0;
  }
  
  public final int a(int paramInt1, int paramInt2, Handler paramHandler)
  {
    a(0L, paramInt1, paramInt2, 3005, paramHandler);
    return 0;
  }
  
  public final int a(int paramInt, Handler paramHandler)
  {
    a(paramInt, 0, paramHandler);
    return 0;
  }
  
  public final int a(final long paramLong, int paramInt1, final int paramInt2, final int paramInt3, Handler paramHandler)
  {
    Object localObject2 = tt.a().k.b();
    Object localObject1 = null;
    if (localObject2 == null)
    {
      paramHandler = paramHandler.obtainMessage(3005);
      localObject1 = new xt();
      ((xt)localObject1).a(110, null, null);
      paramHandler.arg1 = ((xt)localObject1).a;
      paramHandler.obj = localObject1;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject2).mUin;
    localObject2 = ss.a(RqdApplication.n());
    int i = 0;
    while (i < tt.a().k.a())
    {
      QQUser localQQUser = tt.a().a(i);
      if (localQQUser.mUin == paramLong)
      {
        if (localQQUser.mRealUin == 0L) {
          break;
        }
        localObject2 = ((ss)localObject2).a(localQQUser.mRealUin);
        if (localObject2 != null) {
          localObject1 = aay.a((byte[])localObject2);
        }
        break label171;
      }
      i += 1;
    }
    localObject1 = null;
    label171:
    localObject2 = tt.a().c(paramLong);
    if ((localObject2 != null) && (((QQUser)localObject2).mUin == ((QQUser)localObject2).mRealUin)) {
      paramLong = aay.f(paramLong);
    }
    long l;
    if (paramInt2 != 1) {
      l = aaz.a(1, paramLong);
    } else {
      l = 0L;
    }
    rt.a().a(paramInt1, paramInt2, 1, paramLong, (String)localObject1, l, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        Object localObject2 = new xt();
        ((xt)localObject2).a = paramAnonymousrv.b;
        ((xt)localObject2).c = paramAnonymousrv.d;
        ((xt)localObject2).b = paramAnonymousrv.d;
        Object localObject3 = localObject2;
        Object localObject1;
        if (paramAnonymousrv.b == 0)
        {
          localObject3 = tv.a();
          tx.a();
          ((tv)localObject3).a(paramLong);
          localObject1 = localObject2;
        }
        for (;;)
        {
          try
          {
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            localObject1 = localObject2;
            long l = paramAnonymousrv.getLong("uin");
            localObject1 = localObject2;
            if (l != paramLong)
            {
              localObject1 = localObject2;
              paramAnonymousrv = new StringBuilder("uin not match=");
              localObject1 = localObject2;
              paramAnonymousrv.append(l);
              localObject1 = localObject2;
              paramAnonymousrv.append(":");
              localObject1 = localObject2;
              paramAnonymousrv.append(paramLong);
              localObject1 = localObject2;
              ((xt)localObject2).a(10000, paramAnonymousrv.toString(), null);
              localObject1 = localObject2;
              if (paramInt3 == null) {
                break label491;
              }
              localObject1 = localObject2;
              su.a(paramInt3, (xt)localObject2, paramInt2);
              return;
            }
            localObject1 = localObject2;
            if (this.d == 1)
            {
              localObject1 = localObject2;
              localObject3 = new AbnormalLoginMsgResult(paramAnonymousrv);
              localObject1 = localObject2;
              ((xt)localObject2).a = 0;
              paramAnonymousrv = (rv)localObject2;
              localObject2 = localObject3;
            }
            else
            {
              localObject1 = localObject2;
              ((tv)localObject3).b = null;
              localObject1 = localObject2;
              ArrayList localArrayList = new ArrayList();
              localObject1 = localObject2;
              if (paramAnonymousrv.has("devs"))
              {
                localObject1 = localObject2;
                OnlineDeviceResult localOnlineDeviceResult = new OnlineDeviceResult(paramAnonymousrv.getJSONArray("devs"));
                localObject1 = localObject2;
                if (localOnlineDeviceResult.mDevicesList != null)
                {
                  localObject1 = localObject2;
                  localArrayList.addAll(localOnlineDeviceResult.mDevicesList);
                }
                localObject1 = localObject2;
                ((tv)localObject3).b = new OnlineDeviceResult(paramAnonymousrv.getJSONArray("devs"));
              }
              localObject1 = localObject2;
              sc.a.a().a(paramLong, localArrayList);
              localObject1 = localObject2;
              paramAnonymousrv = ((tv)localObject3).f.a(paramAnonymousrv, l, 1);
              localObject2 = null;
            }
            localObject1 = paramAnonymousrv;
            paramAnonymousrv.a = 0;
            localObject1 = paramAnonymousrv;
            localObject3 = paramAnonymousrv;
            if (paramInt3 != null)
            {
              localObject1 = paramAnonymousrv;
              localObject3 = paramInt3;
              localObject1 = paramAnonymousrv;
              int j = paramInt2;
              localObject1 = paramAnonymousrv;
              if (paramAnonymousrv.a != 0) {
                break label492;
              }
              i = 0;
              localObject1 = paramAnonymousrv;
              Message.obtain((Handler)localObject3, j, i, 0, localObject2).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
            ((xt)localObject1).a(10020, null, null);
            localObject3 = localObject1;
          }
          su.a(paramInt3, (xt)localObject3, paramInt2);
          return;
          label491:
          return;
          label492:
          int i = -1;
        }
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt1, int paramInt2, int paramInt3, SafeMsgItem paramSafeMsgItem, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramSafeMsgItem = paramHandler.obtainMessage(3032);
      paramHandler = new xt();
      paramHandler.a(110, null, null);
      paramSafeMsgItem.arg1 = paramHandler.a;
      paramSafeMsgItem.obj = paramHandler;
      paramSafeMsgItem.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().a(paramLong, paramInt1, paramInt2, paramInt3, paramSafeMsgItem.mTypea, paramSafeMsgItem.mTypeb, paramSafeMsgItem.mTypec, SafeMsgItem.a(paramSafeMsgItem.mIP), paramSafeMsgItem.mLoc_country_id, paramSafeMsgItem.mLoc_prov_id, paramSafeMsgItem.mLoc_city_id, paramSafeMsgItem.mTime, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            int i;
            try
            {
              i = paramAnonymousrv.getInt("is_priv_ip_user");
            }
            catch (JSONException paramAnonymousrv)
            {
              paramAnonymousrv.printStackTrace();
              i = -1;
            }
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3032, 0, i, null).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3032);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, final Handler paramHandler)
  {
    rt.a().a(paramLong, paramInt, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 4001);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3054);
      paramHandler = new xt();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().a(paramInt, paramLong, paramString, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        if (paramAnonymousrv.b == 0) {}
        for (;;)
        {
          int i;
          try
          {
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            try
            {
              i = paramAnonymousrv.getInt("id");
              paramAnonymousrv = paramAnonymousrv.getJSONArray("result");
              if (i == 70)
              {
                tu.a().b(paramAnonymousrv);
              }
              else if (i == 71)
              {
                tu.a().c(paramAnonymousrv);
              }
              else if ((i == 80) && (paramAnonymousrv != null) && (paramAnonymousrv.length() > 0))
              {
                i = 0;
                if (i < paramAnonymousrv.length())
                {
                  JSONObject localJSONObject = paramAnonymousrv.getJSONObject(i);
                  if (localJSONObject.getInt("id") == 71)
                  {
                    tu.a().a(localJSONObject);
                    break label217;
                  }
                  localJSONObject.getInt("id");
                  break label217;
                }
              }
              localxt.a = 0;
            }
            catch (JSONException paramAnonymousrv)
            {
              localxt.a(201, RqdApplication.n().getString(2131492911), null);
              paramAnonymousrv.printStackTrace();
            }
            su.a(paramHandler, localxt, 3054);
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
          return;
          label217:
          i += 1;
        }
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString1, String paramString2, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3013);
      paramString2 = new xt();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().b(paramLong, paramInt, paramString1, paramString2, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c).getString("sms_prefix");
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3013, 0, 0, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3013);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3012);
      paramString2 = new xt();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().a(paramLong, paramString1, paramString2, paramInt, paramString3, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            JSONObject localJSONObject = new JSONObject();
            String str1 = paramAnonymousrv.getString("time1");
            String str2 = paramAnonymousrv.getString("time2");
            localJSONObject.put("info", paramAnonymousrv.optString("extraInfo"));
            localJSONObject.put("time1", str1);
            localJSONObject.put("time2", str2);
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3012, 0, 0, localJSONObject).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
            localxt.a = 0;
          }
        }
        su.a(paramHandler, localxt, 3012);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, boolean paramBoolean, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3004);
      paramHandler = new xt();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().a(paramLong, paramInt, paramBoolean, paramString, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 4002);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, final Handler paramHandler)
  {
    if ((paramLong2 == 0L) && (paramLong1 == 0L))
    {
      Object localObject = tt.a().k.b();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3068);
        localObject = new xt();
        ((xt)localObject).a(110, null, null);
        paramHandler.arg1 = ((xt)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong2 = ((QQUser)localObject).mRealUin;
    }
    rt.a().a(paramLong2, paramInt2, paramInt1, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 3068);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, final Handler paramHandler)
  {
    if ((0L == paramLong2) && (paramLong1 == 0L))
    {
      Object localObject = tt.a().k.b();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3075);
        localObject = new xt();
        ((xt)localObject).a(110, null, null);
        paramHandler.arg1 = ((xt)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong2 = ((QQUser)localObject).mRealUin;
    }
    rt.a().c(paramLong2, paramInt, aaz.i(), new rt.a()
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
            int i = new JSONObject(paramAnonymousrv.c).getInt("verify_type");
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3075, 0, -1, Integer.valueOf(i)).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3075);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, String paramString, final Handler paramHandler)
  {
    if ((paramLong2 == 0L) && (paramLong1 == 0L))
    {
      QQUser localQQUser = tt.a().k.b();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3066);
        paramHandler = new xt();
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong2 = localQQUser.mRealUin;
    }
    rt.a().a(paramLong2, paramInt, paramString, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 3066);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, final Handler paramHandler)
  {
    QQUser localQQUser1;
    if (paramLong2 != 0L) {
      localQQUser1 = tt.a().d(paramLong2);
    } else {
      localQQUser1 = null;
    }
    QQUser localQQUser2 = localQQUser1;
    if (localQQUser1 == null) {
      localQQUser2 = tt.a().k.b();
    }
    if ((paramLong1 == 0L) && (localQQUser2 == null))
    {
      paramArrayOfByte = paramHandler.obtainMessage(3058);
      paramHandler = new xt();
      paramHandler.a(110, null, null);
      paramArrayOfByte.arg1 = paramHandler.a;
      paramArrayOfByte.obj = paramHandler;
      paramArrayOfByte.sendToTarget();
      return -1;
    }
    if (paramLong2 != 0L) {
      aay.f(paramLong2);
    } else if (localQQUser2 != null) {
      paramLong2 = localQQUser2.mRealUin;
    }
    rt.a().a(paramLong2, paramLong2, paramInt1, aap.a(paramArrayOfByte), paramInt2, paramInt3, paramInt4, vg.d, vg.e, vg.f, vg.h, FaceDetector.IsSupportNeon(), vg.g, vg.i, vg.j, vg.k, vg.l, vg.m, vg.n, vg.o, wm.d, wm.e, wm.f, aaz.i(), new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        int i;
        if (paramAnonymousrv.b == 0) {
          try
          {
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            i = paramAnonymousrv.getInt("op_type");
            paramAnonymousrv = paramAnonymousrv.getJSONArray("no_face_uin_list");
            localxt.a = 0;
            if (paramHandler == null) {
              break label161;
            }
            Message.obtain(paramHandler, 3058, 0, i, paramAnonymousrv).sendToTarget();
            return;
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        } else {
          try
          {
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            i = paramAnonymousrv.getInt("op_type");
            ta localta = new ta();
            localta.a = i;
            localta.b = paramAnonymousrv.optInt("is_realname_qualified");
            localxt.d = localta;
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        label161:
        su.a(paramHandler, localxt, 3058);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, final Handler paramHandler)
  {
    int j = 3067;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = tt.a().k.b();
      if (localObject == null)
      {
        paramArrayOfByte1 = paramHandler.obtainMessage(3067);
        paramArrayOfByte2 = new xt();
        paramArrayOfByte2.a(110, null, null);
        paramArrayOfByte1.arg1 = paramArrayOfByte2.a;
        paramArrayOfByte1.obj = paramArrayOfByte2;
        paramArrayOfByte1.sendToTarget();
        return -1;
      }
      if (paramLong2 == ((QQUser)localObject).mRealUin)
      {
        paramLong1 = ((QQUser)localObject).mUin;
        paramLong2 = ((QQUser)localObject).mRealUin;
        break label115;
      }
    }
    paramLong1 = aay.f(paramLong2);
    label115:
    final int i = j;
    if (paramInt != 1)
    {
      i = j;
      if (paramInt == 3) {
        i = 3078;
      }
    }
    Object localObject = rt.a();
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = null;
    } else {
      paramArrayOfByte1 = aap.a(paramArrayOfByte1);
    }
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = null;
    } else {
      paramArrayOfByte2 = aap.a(paramArrayOfByte2);
    }
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte3 = null;
    } else {
      paramArrayOfByte3 = aap.a(paramArrayOfByte3);
    }
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte4 = null;
    } else {
      paramArrayOfByte4 = aap.a(paramArrayOfByte4);
    }
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte5 = null;
    } else {
      paramArrayOfByte5 = aap.a(paramArrayOfByte5);
    }
    String str = aay.b(RqdApplication.n());
    RqdApplication.n();
    ((rt)localObject).a(paramLong1, paramLong2, paramInt, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, str, aay.l(), aay.c(RqdApplication.n()), vg.f, vg.h, vg.g, vg.i, vg.j, vg.k, vg.l, vg.m, vg.n, vg.o, wm.d, wm.e, wm.f, ys.f, ys.e, ys.h, ys.g, aay.e(RqdApplication.n()), aay.d(RqdApplication.n()), new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = i;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        if (i == 0) {
          try
          {
            paramAnonymousrv = new RealNameRegResult(new JSONObject(paramAnonymousrv.c));
            localxt.a = 0;
            if (paramHandler == null) {
              break label134;
            }
            Message.obtain(paramHandler, i, 0, -1, paramAnonymousrv).sendToTarget();
            return;
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        } else {
          try
          {
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            wx.i = paramAnonymousrv.getString("hint_title");
            wx.j = paramAnonymousrv.getString("hint_content");
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        label134:
        su.a(paramHandler, localxt, i);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, String paramString, final Handler paramHandler, boolean paramBoolean)
  {
    if (0L == paramLong2)
    {
      QQUser localQQUser = tt.a().k.b();
      if (paramLong1 == 0L)
      {
        if (localQQUser == null)
        {
          paramString = paramHandler.obtainMessage(3080);
          paramHandler = new xt();
          paramHandler.a(110, null, null);
          paramString.arg1 = paramHandler.a;
          paramString.obj = paramHandler;
          paramString.sendToTarget();
          return -1;
        }
        paramLong2 = localQQUser.mRealUin;
      }
    }
    rt.a().a(paramLong2, paramString, paramBoolean, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 3080);
      }
    });
    return 0;
  }
  
  public final int a(final long paramLong, Handler paramHandler)
  {
    Object localObject = tt.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3000);
      localObject = new xt();
      ((xt)localObject).a(110, null, null);
      paramHandler.arg1 = ((xt)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rt.a().g(paramLong, new rt.a()
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
            Object localObject = new JSONObject(paramAnonymousrv.c);
            long l = ((JSONObject)localObject).getLong("uin");
            if (l != paramLong)
            {
              paramAnonymousrv = new StringBuilder("uin not match=");
              paramAnonymousrv.append(l);
              paramAnonymousrv.append(":");
              paramAnonymousrv.append(paramLong);
              localxt.a(10000, paramAnonymousrv.toString(), null);
              return;
            }
            localObject = ((JSONObject)localObject).getJSONArray("result");
            tu localtu = tu.a();
            if (!localtu.a((JSONArray)localObject))
            {
              paramAnonymousrv = new StringBuilder("update conf list failed:");
              paramAnonymousrv.append(((JSONArray)localObject).toString());
              localxt.a(10000, paramAnonymousrv.toString(), null);
              return;
            }
            localObject = new JSONObject();
            ((JSONObject)localObject).put("uin", l);
            ((JSONObject)localObject).put("data", paramAnonymousrv.c);
            ((JSONObject)localObject).put("seq_id", "1234");
            ((JSONObject)localObject).put("err", paramAnonymousrv.b);
            xy.a("account_lock", ((JSONObject)localObject).toString());
            localtu.b.e = true;
            localtu.b.f = false;
            localxt.a = 0;
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
            localxt.a = 10020;
          }
        }
        su.a(this.b, localxt, 3000);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString, int paramInt, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3052);
      paramHandler = new xt();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().c(paramLong, paramString, paramInt, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 3052);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3060);
      paramHandler = new xt();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().b(paramLong, paramString, new rt.a()
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
            paramAnonymousrv = new LoginProtectResult(new JSONObject(paramAnonymousrv.c));
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3060, 0, -1, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3060);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, List<DeterminVerifyFactorsResult.QuesInfoItem> paramList, String[] paramArrayOfString, final Handler paramHandler)
  {
    int[] arrayOfInt = new int[3];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((DeterminVerifyFactorsResult.QuesInfoItem)paramList.get(i)).mId;
      i += 1;
    }
    rt.a().a(paramLong, arrayOfInt, paramArrayOfString, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 3028);
      }
    });
    return 0;
  }
  
  public final int a(final long paramLong, byte[] paramArrayOfByte, Handler paramHandler)
  {
    rt localrt = rt.a();
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = aay.a(paramArrayOfByte);
    }
    localrt.a(paramLong, paramArrayOfByte, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            long l = Long.parseLong(paramAnonymousrv.getString("uin"));
            paramAnonymousrv = paramAnonymousrv.getString("uin_mask");
            QQUser localQQUser = tt.a().d(paramLong);
            if (localQQUser != null)
            {
              localQQUser.mUin = l;
              localQQUser.mUinMask = paramAnonymousrv;
            }
            tt.a().e(paramLong);
            localxt.a = 0;
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(this.b, localxt, 3024);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, byte[] paramArrayOfByte, final Handler paramHandler, int paramInt)
  {
    rt.a().a(paramLong, aay.a(paramArrayOfByte), paramInt, new rt.a()
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
            paramAnonymousrv = new DeterminVerifyFactorsResult(new JSONObject(paramAnonymousrv.c));
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4003, 0, -1, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 4003);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, final int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramArrayOfInt1 = paramHandler.obtainMessage(3061);
      paramArrayOfInt2 = new xt();
      paramArrayOfInt2.a(110, null, null);
      paramArrayOfInt1.arg1 = paramArrayOfInt2.a;
      paramArrayOfInt1.obj = paramArrayOfInt2;
      paramArrayOfInt1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().a(paramLong, paramString, paramArrayOfInt1, paramArrayOfInt2, new rt.a()
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
            new JSONObject(paramAnonymousrv.c).getLong("uin");
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3061, 0, -1, paramArrayOfInt1).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3061);
      }
    });
    return 0;
  }
  
  public final int a(final Handler paramHandler)
  {
    Object localObject1 = RqdApplication.m();
    final wj localwj = new wj();
    localObject1 = ((abb)localObject1).a(localwj);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((abb.a)localObject1).b;
    }
    if ((localObject1 != null) && (((abn)localObject1).a != null)) {
      try
      {
        Object localObject2 = tu.a().h.a("key_value");
        localObject1 = new JSONObject((String)((abn)localObject1).a);
        if (((JSONObject)localObject1).getInt("key_value_version") >= ((NewConfigureCacheItem)localObject2).mClientVersion)
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("data");
          localObject2 = paramHandler.obtainMessage(3023);
          ((Message)localObject2).arg1 = 0;
          ((Message)localObject2).obj = ((JSONObject)localObject1).toString();
          ((Message)localObject2).sendToTarget();
          return 0;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    rt.a().c(new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            abn localabn = new abn();
            localabn.a = paramAnonymousrv.toString();
            RqdApplication.m().a(localwj, localabn);
            localxt.a = 0;
            paramAnonymousrv = paramAnonymousrv.getJSONObject("data").toString();
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3023, 0, 0, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3023);
      }
    });
    return 0;
  }
  
  public final int a(final Handler paramHandler, final File paramFile, String paramString)
  {
    QQUser localQQUser = tt.a().k.b();
    rt localrt = rt.a();
    long l2 = 0L;
    long l1;
    if (localQQUser == null) {
      l1 = 0L;
    } else {
      l1 = localQQUser.mUin;
    }
    if (localQQUser != null) {
      l2 = localQQUser.mRealUin;
    }
    acb.a();
    localrt.a(paramFile, paramString, l1, l2, acb.e(), new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        if (paramAnonymousrv.b == 0)
        {
          paramAnonymousrv = new File(paramFile.getAbsolutePath());
          if ((paramAnonymousrv.exists()) && (paramAnonymousrv.isFile())) {
            aas.a(paramAnonymousrv);
          }
          aav.b("debug.file.uploadfiledate").commit();
        }
        su.a(paramHandler, localxt, 3063);
      }
    });
    return 0;
  }
  
  public final int a(Long paramLong, int paramInt, final Handler paramHandler)
  {
    Long localLong = paramLong;
    if (paramLong.longValue() == 0L)
    {
      paramLong = tt.a().k.b();
      if (paramLong == null)
      {
        paramLong = paramHandler.obtainMessage(3065);
        paramHandler = new xt();
        paramHandler.a(110, null, null);
        paramLong.arg1 = paramHandler.a;
        paramLong.obj = paramHandler;
        paramLong.sendToTarget();
        return -1;
      }
      localLong = Long.valueOf(paramLong.mRealUin);
    }
    rt.a().c(localLong.longValue(), paramInt, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        if ((paramAnonymousrv.b == 0) || (paramAnonymousrv.b == 124)) {
          try
          {
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            vm.d = paramAnonymousrv.getString("sms_port");
            vm.e = paramAnonymousrv.getString("sms_up_code");
            try
            {
              vm.f = paramAnonymousrv.getString("mobile_sms_prefix");
            }
            catch (Exception paramAnonymousrv)
            {
              paramAnonymousrv.printStackTrace();
            }
            su.a(paramHandler, localxt, 3065);
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
      }
    });
    return 0;
  }
  
  public final int a(String paramString)
  {
    ue.b localb = this.a.b;
    localb.a.post(new ue.b.3(localb, paramString));
    return 0;
  }
  
  public final int a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, final Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = tt.a().k.b();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3019);
        paramString2 = new xt();
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mRealUin;
    }
    rt.a().a(paramString1, paramString2, paramInt1, paramLong, paramInt2, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            wg.d = paramAnonymousrv.getString("sms_port");
            wg.e = paramAnonymousrv.getString("sms_up_code");
            localxt.a = 0;
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3019);
      }
    });
    return 0;
  }
  
  public final int a(String paramString, final Handler paramHandler)
  {
    rt.a().a(paramString, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 3022);
      }
    });
    return 0;
  }
  
  public final int a(JSONArray paramJSONArray, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    rt.a().a(l, paramJSONArray, aaj.j(RqdApplication.n()), aaj.i(RqdApplication.n()), new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        if (paramAnonymousrv.b == 0) {
          aaz.a(System.currentTimeMillis() / 1000L);
        }
        su.a(paramHandler, localxt, 4013);
      }
    });
    return 0;
  }
  
  public final int b(final long paramLong, int paramInt, Handler paramHandler)
  {
    QQUser localQQUser = tt.a().c(paramLong);
    if ((localQQUser != null) && (localQQUser.mIsBinded))
    {
      rt.a().a(paramInt, aay.k(), new rt.a()
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
              paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
              long l = paramAnonymousrv.getLong("uin");
              if (l != paramLong)
              {
                paramAnonymousrv = new StringBuilder("uin not match=");
                paramAnonymousrv.append(l);
                paramAnonymousrv.append(":");
                paramAnonymousrv.append(paramLong);
                localxt.a(10000, paramAnonymousrv.toString(), null);
                return;
              }
              tt.a().g();
              if (!tt.a().k.a(l)) {
                localxt.a(10000, "mUserStorage.setCurrentUserByUin failed", null);
              }
              System.currentTimeMillis();
              l = paramAnonymousrv.getInt("valid_time");
              tt.a().a(paramLong, l);
              localxt.a = 0;
            }
            catch (JSONException paramAnonymousrv)
            {
              paramAnonymousrv.printStackTrace();
            }
          } else if ((paramAnonymousrv.b != 111) && (paramAnonymousrv.b == 270)) {
            try
            {
              Object localObject = new JSONObject(paramAnonymousrv.c);
              paramAnonymousrv = ((JSONObject)localObject).optString("masked_mobile");
              localObject = ((JSONObject)localObject).optString("mSmsPrefix");
              UpgradeDeterminResult localUpgradeDeterminResult = new UpgradeDeterminResult();
              localUpgradeDeterminResult.mMobileMask = paramAnonymousrv;
              localUpgradeDeterminResult.mSmsPrefix = ((String)localObject);
              localxt.d = localUpgradeDeterminResult;
            }
            catch (JSONException paramAnonymousrv)
            {
              paramAnonymousrv.printStackTrace();
            }
          }
          su.a(this.b, localxt, 10002);
        }
      });
      return 0;
    }
    a(paramHandler, new xt(), 10002);
    return 0;
  }
  
  public final int b(final long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    rt.a().a(paramLong, paramInt, paramString1, paramString2, new rt.a()
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
            int i = new JSONObject(paramAnonymousrv.c).getInt("bind_mobile_succ");
            if (1 != i) {
              try
              {
                localxt.a(localxt.b);
              }
              catch (Exception paramAnonymousrv)
              {
                paramAnonymousrv.printStackTrace();
              }
            }
            paramAnonymousrv = tt.a().d(paramLong);
            if (paramAnonymousrv != null) {
              tt.a().a(paramAnonymousrv);
            }
            localxt.a = 0;
            if (this.b != null)
            {
              Message.obtain(this.b, 4004, 0, i, localxt).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(this.b, localxt, 4004);
      }
    });
    return 0;
  }
  
  public final int b(long paramLong, final Handler paramHandler)
  {
    Object localObject = tt.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3001);
      localObject = new xt();
      ((xt)localObject).a(110, null, null);
      paramHandler.arg1 = ((xt)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rt.a().d(paramLong, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c).getJSONArray("result");
            tu.a().d(paramAnonymousrv);
            localxt.e = paramAnonymousrv;
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
            localxt.a = 10020;
          }
        }
        su.a(paramHandler, localxt, 3001);
      }
    });
    return 0;
  }
  
  public final int b(long paramLong, String paramString, int paramInt, final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(4008);
      paramHandler = new xt();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rt.a().f(paramLong, paramString, paramInt, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            xv.a("freeze result = ".concat(String.valueOf(paramAnonymousrv)));
            int i = -1;
            int j;
            try
            {
              j = paramAnonymousrv.getInt("sign_status");
              i = j;
              k = paramAnonymousrv.getInt("auto_melt_time");
              i = k;
            }
            catch (JSONException paramAnonymousrv)
            {
              paramAnonymousrv.printStackTrace();
              int k = 0;
              j = i;
              i = k;
            }
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4008, 0, j, Integer.valueOf(i)).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 4008);
      }
    });
    return 0;
  }
  
  public final int b(final Handler paramHandler)
  {
    rt.a().b(new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            wp.a locala = new wp.a();
            locala.a = paramAnonymousrv.getInt("is_have_msg");
            if (locala.a == 1)
            {
              locala.b = paramAnonymousrv.getString("content");
              locala.c = paramAnonymousrv.getLong("uin");
            }
            localxt.a(locala.b);
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3043, 0, -1, locala).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3043);
      }
    });
    return 0;
  }
  
  public final int c()
  {
    rt.a().a(new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        su.a(paramAnonymousrv, localxt);
        su.a(this.a, localxt, 3003);
      }
    });
    return 0;
  }
  
  public final int c(final long paramLong, int paramInt, Handler paramHandler)
  {
    rt.a().d(paramLong, paramInt, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        if (paramAnonymousrv.b == 0)
        {
          long l = paramLong;
          paramAnonymousrv = tt.a().d(l);
          if (paramAnonymousrv != null) {
            tt.a().a(paramAnonymousrv);
          }
          localxt.a = 0;
        }
        su.a(this.b, localxt, 3074);
      }
    });
    return 0;
  }
  
  public final int c(final long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    rt.a().c(paramLong, paramInt, paramString1, paramString2, new rt.a()
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
            int i = new JSONObject(paramAnonymousrv.c).getInt("bind_mobile_succ");
            if (1 != i) {
              try
              {
                localxt.a(localxt.b);
              }
              catch (Exception paramAnonymousrv)
              {
                paramAnonymousrv.printStackTrace();
              }
            }
            paramAnonymousrv = tt.a().d(paramLong);
            if (paramAnonymousrv != null) {
              tt.a().a(paramAnonymousrv);
            }
            localxt.a = 0;
            if (this.b != null)
            {
              Message.obtain(this.b, 3026, 0, i, localxt).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(this.b, localxt, 3026);
      }
    });
    return 0;
  }
  
  public final int c(long paramLong, final Handler paramHandler)
  {
    Object localObject = tt.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3004);
      localObject = new xt();
      ((xt)localObject).a(110, null, null);
      paramHandler.arg1 = ((xt)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rt.a().b(paramLong, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            paramAnonymousrv = new EvalAccountResult(paramAnonymousrv.getJSONObject("result"), paramAnonymousrv);
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3004, 0, 0, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3004);
      }
    });
    return 0;
  }
  
  public final int c(final Handler paramHandler)
  {
    QQUser localQQUser = tt.a().k.b();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    rt.a().k(l, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c).optJSONArray("domain_list");
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3062, 0, -1, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3062);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final int paramInt, final Handler paramHandler)
  {
    if (paramLong == -1L)
    {
      localObject = tt.a().k.b();
      if (localObject != null) {
        paramLong = ((QQUser)localObject).mRealUin;
      }
    }
    Object localObject = RqdApplication.n().getResources().getDisplayMetrics();
    rt.a().a(paramLong, paramInt, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).densityDpi, aaz.y(), aaz.z(), new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        xt localxt = new xt();
        localxt.a = paramAnonymousrv.b;
        localxt.c = paramAnonymousrv.d;
        localxt.b = paramAnonymousrv.d;
        if (paramAnonymousrv.b == 0)
        {
          StringBuilder localStringBuilder = null;
          try
          {
            JSONObject localJSONObject = new JSONObject(paramAnonymousrv.c);
            int j = localJSONObject.getInt("need_live_detect");
            paramAnonymousrv = localStringBuilder;
            if (j == 1)
            {
              paramAnonymousrv = localStringBuilder;
              if (localJSONObject.getJSONArray("actions") != null)
              {
                paramAnonymousrv = localStringBuilder;
                if (localJSONObject.getJSONArray("actions").length() > 0)
                {
                  int k = localJSONObject.getJSONArray("actions").length();
                  paramAnonymousrv = new int[k];
                  int i = 0;
                  while (i < k)
                  {
                    paramAnonymousrv[i] = localJSONObject.getJSONArray("actions").getInt(i);
                    localStringBuilder = new StringBuilder("mLiveDetectActions");
                    localStringBuilder.append(paramAnonymousrv[i]);
                    xv.a(localStringBuilder.toString());
                    i += 1;
                  }
                  if ((paramInt != 2) && (paramInt != 1))
                  {
                    if (k > 0)
                    {
                      wm.f = paramAnonymousrv[0];
                      localStringBuilder = new StringBuilder("sVryAction");
                      localStringBuilder.append(wm.f);
                      xv.a(localStringBuilder.toString());
                    }
                  }
                  else if (k >= 2)
                  {
                    wm.d = paramAnonymousrv[0];
                    wm.e = paramAnonymousrv[1];
                  }
                }
              }
            }
            try
            {
              yv.n = localJSONObject.getInt("displayangle");
              yv.o = localJSONObject.getInt("imageangle");
              localStringBuilder = new StringBuilder("display angle=");
              localStringBuilder.append(yv.n);
              localStringBuilder.append(",angel2=");
              localStringBuilder.append(yv.o);
              xv.a(localStringBuilder.toString());
              aaz.a(localJSONObject);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3082, 0, j, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3082);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final int paramInt, String paramString1, String paramString2, final Handler paramHandler)
  {
    rt.a().d(paramLong, paramInt, paramString1, paramString2, new rt.a()
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
            JSONObject localJSONObject = new JSONObject(paramAnonymousrv.c);
            paramAnonymousrv = "";
            if (paramInt == 5) {
              paramAnonymousrv = localJSONObject.getString("captcha_sig");
            }
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3072, 0, -1, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3072);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final Handler paramHandler)
  {
    Object localObject = tt.a().k.b();
    long l = paramLong;
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3010);
        localObject = new xt();
        ((xt)localObject).a(110, null, null);
        paramHandler.arg1 = ((xt)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    rt.a().a(l, new rt.a()
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
            paramAnonymousrv = new MbInfoResult(new JSONObject(paramAnonymousrv.c).getJSONArray("mb_list"));
            abh.a().a(paramAnonymousrv);
            localxt.e = paramAnonymousrv;
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3010, 0, 0, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
            localxt.a = 10020;
          }
        }
        su.a(paramHandler, localxt, 3010);
      }
    });
    return 0;
  }
  
  public final int e(final long paramLong, Handler paramHandler)
  {
    rt.a().e(paramLong, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            localxt.a = 0;
            QQUser localQQUser = tt.a().c(paramLong);
            if (localQQUser == null)
            {
              localxt.a(10000, null, null);
            }
            else
            {
              localQQUser.mRealUin = paramAnonymousrv.getLong("real_uin");
              localQQUser.mMobileMask = paramAnonymousrv.getString("mobile");
              localQQUser.verify_sms = paramAnonymousrv.optInt("verify_sms");
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(this.b, localxt, 1006);
      }
    });
    return 0;
  }
  
  public final int f(long paramLong, final Handler paramHandler)
  {
    rt.a().i(paramLong, new rt.a()
    {
      public final void a(rv paramAnonymousrv)
      {
        su.a(paramAnonymousrv, paramHandler, 3036);
      }
    });
    return 0;
  }
  
  public final int g(long paramLong, final Handler paramHandler)
  {
    Object localObject = tt.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3064);
      localObject = new xt();
      ((xt)localObject).a(110, null, null);
      paramHandler.arg1 = ((xt)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rt.a().l(paramLong, new rt.a()
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
            paramAnonymousrv = new RealNameStatusResult(new JSONObject(paramAnonymousrv.c));
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3064, 0, -1, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3064);
      }
    });
    return 0;
  }
  
  public final int h(long paramLong, final Handler paramHandler)
  {
    DisplayMetrics localDisplayMetrics = RqdApplication.n().getResources().getDisplayMetrics();
    rt.a().a(paramLong, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, localDisplayMetrics.densityDpi, aaz.y(), aaz.z(), new rt.a()
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
            paramAnonymousrv = new RealNameQueryResult(new JSONObject(paramAnonymousrv.c));
            StringBuilder localStringBuilder = new StringBuilder("result rebind_type: ");
            localStringBuilder.append(paramAnonymousrv.zzb_rebind_type);
            xv.c(localStringBuilder.toString());
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3073, 0, -1, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3073);
      }
    });
    return 0;
  }
  
  public final int i(long paramLong, final Handler paramHandler)
  {
    if (paramLong == -1L)
    {
      localObject = tt.a().k.b();
      if (localObject != null) {
        paramLong = ((QQUser)localObject).mRealUin;
      }
    }
    Object localObject = RqdApplication.n().getResources().getDisplayMetrics();
    rt.a().b(paramLong, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).densityDpi, aaz.y(), aaz.z(), new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            int i = paramAnonymousrv.getInt("need_idcard_detect");
            if (i == 1) {
              try
              {
                ui.d = paramAnonymousrv.getInt("displayangle");
                ui.e = paramAnonymousrv.getInt("imageangle");
                paramAnonymousrv = new StringBuilder("plain angle=");
                paramAnonymousrv.append(ui.d);
                paramAnonymousrv.append(",angel2=");
                paramAnonymousrv.append(ui.e);
                xv.a(paramAnonymousrv.toString());
              }
              catch (Exception paramAnonymousrv)
              {
                paramAnonymousrv.printStackTrace();
              }
            }
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3083, 0, i, null).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 3083);
      }
    });
    return 0;
  }
  
  public final int j(long paramLong, final Handler paramHandler)
  {
    Object localObject = tt.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(4007);
      localObject = new xt();
      ((xt)localObject).a(110, null, null);
      paramHandler.arg1 = ((xt)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rt.a().n(paramLong, new rt.a()
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
            paramAnonymousrv = new JSONObject(paramAnonymousrv.c);
            xv.a("freeze result = ".concat(String.valueOf(paramAnonymousrv)));
            paramAnonymousrv = new FreezeStatusResult(paramAnonymousrv);
            localxt.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4007, 0, -1, paramAnonymousrv).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrv)
          {
            paramAnonymousrv.printStackTrace();
          }
        }
        su.a(paramHandler, localxt, 4007);
      }
    });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.su
 * JD-Core Version:    0.7.0.1
 */