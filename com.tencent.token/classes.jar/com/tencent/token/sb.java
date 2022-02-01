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

public final class sb
  implements tg
{
  public static int b = new Random().nextInt() >>> 1;
  private static sb c;
  public tl a = new tl();
  
  public static sb a()
  {
    if (c == null) {
      c = new sb();
    }
    return c;
  }
  
  static void a(Handler paramHandler, wz paramwz, int paramInt)
  {
    if (paramHandler != null) {
      Message.obtain(paramHandler, paramInt, paramwz.a, 0, paramwz).sendToTarget();
    }
  }
  
  static void a(rb paramrb, Handler paramHandler, int paramInt)
  {
    wz localwz = new wz();
    localwz.a = paramrb.b;
    localwz.c = paramrb.d;
    localwz.b = paramrb.d;
    if (paramrb.b == 0) {
      localwz.a = 0;
    }
    a(paramHandler, localwz, paramInt);
  }
  
  public static void a(rb paramrb, wz paramwz)
  {
    if (paramrb.b == 0) {
      try
      {
        paramwz.e = new si(paramrb.c);
        paramrb = ta.a().a(new JSONObject(paramrb.c).getJSONArray("uinlist"));
        if (paramrb.b())
        {
          ta.a().j = true;
          if (ta.a().o != 0L)
          {
            ta.a().b(ta.a().o);
            ta.a().o = 0L;
          }
          paramwz.a = 0;
          return;
        }
        paramwz.a = paramrb.a;
        return;
      }
      catch (JSONException paramrb)
      {
        paramrb.printStackTrace();
        paramwz.a = 10020;
      }
    }
  }
  
  public static int b()
  {
    return b;
  }
  
  public final int a(byte paramByte, final Handler paramHandler)
  {
    wz localwz = new wz();
    ta localta = ta.a();
    long l = localta.c();
    if ((localta.k.b() != null) && (l != 0L))
    {
      if (localta.k.b().mIsBinded) {
        l = localta.k.b().mUin;
      }
      qz.a().a(l, paramByte, new qz.a()
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
              paramAnonymousrb = new JSONObject(paramAnonymousrb.c).getJSONArray("msgs");
              if (!sy.a().a(paramAnonymousrb, this.a))
              {
                StringBuilder localStringBuilder = new StringBuilder("update conf list failed:");
                localStringBuilder.append(paramAnonymousrb.toString());
                localwz.a(10000, localStringBuilder.toString(), null);
              }
              else
              {
                ta.a().g();
                localwz.a = 0;
              }
            }
            catch (JSONException paramAnonymousrb)
            {
              paramAnonymousrb.printStackTrace();
            }
          }
          sb.a(paramHandler, localwz, 3069);
        }
      });
      return 0;
    }
    localwz.a(110, null, null);
    a(paramHandler, localwz, 3069);
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
  
  public final int a(long paramLong, int paramInt1, int paramInt2, final int paramInt3, final Handler paramHandler)
  {
    Object localObject2 = ta.a().k.b();
    Object localObject1 = null;
    if (localObject2 == null)
    {
      paramHandler = paramHandler.obtainMessage(3005);
      localObject1 = new wz();
      ((wz)localObject1).a(110, null, null);
      paramHandler.arg1 = ((wz)localObject1).a;
      paramHandler.obj = localObject1;
      paramHandler.sendToTarget();
      return -1;
    }
    final long l2 = ((QQUser)localObject2).mUin;
    localObject2 = rz.a(RqdApplication.n());
    int i = 0;
    while (i < ta.a().k.a())
    {
      QQUser localQQUser = ta.a().a(i);
      if (localQQUser.mUin == l2)
      {
        if (localQQUser.mRealUin == 0L) {
          break;
        }
        localObject2 = ((rz)localObject2).a(localQQUser.mRealUin);
        if (localObject2 != null) {
          localObject1 = aad.a((byte[])localObject2);
        }
        break label173;
      }
      i += 1;
    }
    localObject1 = null;
    label173:
    localObject2 = ta.a().c(l2);
    if ((localObject2 != null) && (((QQUser)localObject2).mUin == ((QQUser)localObject2).mRealUin)) {
      paramLong = aad.f(l2);
    } else {
      paramLong = l2;
    }
    long l1;
    if (paramInt2 != 1) {
      l1 = aae.a(1, paramLong);
    } else {
      l1 = 0L;
    }
    qz.a().a(paramInt1, paramInt2, 1, paramLong, (String)localObject1, l1, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        Object localObject2 = new wz();
        ((wz)localObject2).a = paramHandler;
        ((wz)localObject2).c = paramAnonymousrb.d;
        ((wz)localObject2).b = paramAnonymousrb.d;
        Object localObject3 = localObject2;
        Object localObject1;
        if (paramHandler == 0)
        {
          localObject3 = tc.a();
          te.a();
          ((tc)localObject3).a(l2);
          localObject1 = localObject2;
        }
        for (;;)
        {
          try
          {
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            localObject1 = localObject2;
            long l = paramAnonymousrb.getLong("uin");
            localObject1 = localObject2;
            if (l != l2)
            {
              localObject1 = localObject2;
              paramAnonymousrb = new StringBuilder("uin not match=");
              localObject1 = localObject2;
              paramAnonymousrb.append(l);
              localObject1 = localObject2;
              paramAnonymousrb.append(":");
              localObject1 = localObject2;
              paramAnonymousrb.append(l2);
              localObject1 = localObject2;
              ((wz)localObject2).a(10000, paramAnonymousrb.toString(), null);
              return;
            }
            localObject1 = localObject2;
            if (paramHandler == 1)
            {
              localObject1 = localObject2;
              localObject3 = new AbnormalLoginMsgResult(paramAnonymousrb);
              localObject1 = localObject2;
              ((wz)localObject2).a = 0;
              paramAnonymousrb = (rb)localObject2;
              localObject2 = localObject3;
            }
            else
            {
              localObject1 = localObject2;
              ((tc)localObject3).b = null;
              localObject1 = localObject2;
              ArrayList localArrayList = new ArrayList();
              localObject1 = localObject2;
              if (paramAnonymousrb.has("devs"))
              {
                localObject1 = localObject2;
                OnlineDeviceResult localOnlineDeviceResult = new OnlineDeviceResult(paramAnonymousrb.getJSONArray("devs"));
                localObject1 = localObject2;
                if (localOnlineDeviceResult.mDevicesList != null)
                {
                  localObject1 = localObject2;
                  localArrayList.addAll(localOnlineDeviceResult.mDevicesList);
                }
                localObject1 = localObject2;
                ((tc)localObject3).b = new OnlineDeviceResult(paramAnonymousrb.getJSONArray("devs"));
              }
              localObject1 = localObject2;
              ri.a.a().a(l2, localArrayList);
              localObject1 = localObject2;
              paramAnonymousrb = ((tc)localObject3).f.a(paramAnonymousrb, l, 1);
              localObject2 = null;
            }
            localObject1 = paramAnonymousrb;
            paramAnonymousrb.a = 0;
            localObject1 = paramAnonymousrb;
            localObject3 = paramAnonymousrb;
            if (paramInt3 != null)
            {
              localObject1 = paramAnonymousrb;
              localObject3 = paramInt3;
              localObject1 = paramAnonymousrb;
              int j = this.d;
              localObject1 = paramAnonymousrb;
              if (paramAnonymousrb.a != 0) {
                break label463;
              }
              i = 0;
              localObject1 = paramAnonymousrb;
              Message.obtain((Handler)localObject3, j, i, 0, localObject2).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
            ((wz)localObject1).a(10020, null, null);
            localObject3 = localObject1;
          }
          sb.a(paramInt3, (wz)localObject3, this.d);
          return;
          label463:
          int i = -1;
        }
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt1, int paramInt2, int paramInt3, SafeMsgItem paramSafeMsgItem, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramSafeMsgItem = paramHandler.obtainMessage(3032);
      paramHandler = new wz();
      paramHandler.a(110, null, null);
      paramSafeMsgItem.arg1 = paramHandler.a;
      paramSafeMsgItem.obj = paramHandler;
      paramSafeMsgItem.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().a(paramLong, paramInt1, paramInt2, paramInt3, paramSafeMsgItem.mTypea, paramSafeMsgItem.mTypeb, paramSafeMsgItem.mTypec, SafeMsgItem.a(paramSafeMsgItem.mIP), paramSafeMsgItem.mLoc_country_id, paramSafeMsgItem.mLoc_prov_id, paramSafeMsgItem.mLoc_city_id, paramSafeMsgItem.mTime, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            int i;
            try
            {
              i = paramAnonymousrb.getInt("is_priv_ip_user");
            }
            catch (JSONException paramAnonymousrb)
            {
              paramAnonymousrb.printStackTrace();
              i = -1;
            }
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3032, 0, i, null).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3032);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, final Handler paramHandler)
  {
    qz.a().a(paramLong, paramInt, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 4001);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3054);
      paramHandler = new wz();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().a(paramInt, paramLong, paramString, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        if (paramAnonymousrb.b == 0) {}
        for (;;)
        {
          int i;
          try
          {
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            try
            {
              i = paramAnonymousrb.getInt("id");
              paramAnonymousrb = paramAnonymousrb.getJSONArray("result");
              if (i == 70)
              {
                tb.a().b(paramAnonymousrb);
              }
              else if (i == 71)
              {
                tb.a().c(paramAnonymousrb);
              }
              else if ((i == 80) && (paramAnonymousrb != null) && (paramAnonymousrb.length() > 0))
              {
                i = 0;
                if (i < paramAnonymousrb.length())
                {
                  JSONObject localJSONObject = paramAnonymousrb.getJSONObject(i);
                  if (localJSONObject.getInt("id") == 71)
                  {
                    tb.a().a(localJSONObject);
                    break label217;
                  }
                  localJSONObject.getInt("id");
                  break label217;
                }
              }
              localwz.a = 0;
            }
            catch (JSONException paramAnonymousrb)
            {
              localwz.a(201, RqdApplication.n().getString(2131492910), null);
              paramAnonymousrb.printStackTrace();
            }
            sb.a(paramHandler, localwz, 3054);
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
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
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3013);
      paramString2 = new wz();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().b(paramLong, paramInt, paramString1, paramString2, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c).getString("sms_prefix");
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3013, 0, 0, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3013);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3012);
      paramString2 = new wz();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().a(paramLong, paramString1, paramString2, paramInt, paramString3, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            JSONObject localJSONObject = new JSONObject();
            String str1 = paramAnonymousrb.getString("time1");
            String str2 = paramAnonymousrb.getString("time2");
            localJSONObject.put("info", paramAnonymousrb.optString("extraInfo"));
            localJSONObject.put("time1", str1);
            localJSONObject.put("time2", str2);
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3012, 0, 0, localJSONObject).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
            localwz.a = 0;
          }
        }
        sb.a(paramHandler, localwz, 3012);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, boolean paramBoolean, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3004);
      paramHandler = new wz();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().a(paramLong, paramInt, paramBoolean, paramString, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 4002);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, final Handler paramHandler)
  {
    if ((paramLong2 == 0L) && (paramLong1 == 0L))
    {
      Object localObject = ta.a().k.b();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3068);
        localObject = new wz();
        ((wz)localObject).a(110, null, null);
        paramHandler.arg1 = ((wz)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong2 = ((QQUser)localObject).mRealUin;
    }
    qz.a().a(paramLong2, paramInt2, paramInt1, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 3068);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, final Handler paramHandler)
  {
    if ((0L == paramLong2) && (paramLong1 == 0L))
    {
      Object localObject = ta.a().k.b();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3075);
        localObject = new wz();
        ((wz)localObject).a(110, null, null);
        paramHandler.arg1 = ((wz)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong2 = ((QQUser)localObject).mRealUin;
    }
    qz.a().c(paramLong2, paramInt, aae.i(), new qz.a()
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
            int i = new JSONObject(paramAnonymousrb.c).getInt("verify_type");
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3075, 0, -1, Integer.valueOf(i)).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3075);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, String paramString, final Handler paramHandler)
  {
    if ((paramLong2 == 0L) && (paramLong1 == 0L))
    {
      QQUser localQQUser = ta.a().k.b();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3066);
        paramHandler = new wz();
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong2 = localQQUser.mRealUin;
    }
    qz.a().a(paramLong2, paramInt, paramString, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 3066);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, final Handler paramHandler)
  {
    QQUser localQQUser1;
    if (paramLong2 != 0L) {
      localQQUser1 = ta.a().d(paramLong2);
    } else {
      localQQUser1 = null;
    }
    QQUser localQQUser2 = localQQUser1;
    if (localQQUser1 == null) {
      localQQUser2 = ta.a().k.b();
    }
    if ((paramLong1 == 0L) && (localQQUser2 == null))
    {
      paramArrayOfByte = paramHandler.obtainMessage(3058);
      paramHandler = new wz();
      paramHandler.a(110, null, null);
      paramArrayOfByte.arg1 = paramHandler.a;
      paramArrayOfByte.obj = paramHandler;
      paramArrayOfByte.sendToTarget();
      return -1;
    }
    if (paramLong2 != 0L) {
      aad.f(paramLong2);
    } else if (localQQUser2 != null) {
      paramLong2 = localQQUser2.mRealUin;
    }
    qz.a().a(paramLong2, paramLong2, paramInt1, zu.a(paramArrayOfByte), paramInt2, paramInt3, paramInt4, un.d, un.e, un.f, un.h, FaceDetector.IsSupportNeon(), un.g, un.i, un.j, un.k, un.l, un.m, un.n, un.o, vt.d, vt.e, vt.f, aae.i(), new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        int i;
        if (paramAnonymousrb.b == 0) {
          try
          {
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            i = paramAnonymousrb.getInt("op_type");
            paramAnonymousrb = paramAnonymousrb.getJSONArray("no_face_uin_list");
            localwz.a = 0;
            if (paramHandler == null) {
              break label161;
            }
            Message.obtain(paramHandler, 3058, 0, i, paramAnonymousrb).sendToTarget();
            return;
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        } else {
          try
          {
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            i = paramAnonymousrb.getInt("op_type");
            sh localsh = new sh();
            localsh.a = i;
            localsh.b = paramAnonymousrb.optInt("is_realname_qualified");
            localwz.d = localsh;
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        label161:
        sb.a(paramHandler, localwz, 3058);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, final Handler paramHandler)
  {
    int j = 3067;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = ta.a().k.b();
      if (localObject == null)
      {
        paramArrayOfByte1 = paramHandler.obtainMessage(3067);
        paramArrayOfByte2 = new wz();
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
    paramLong1 = aad.f(paramLong2);
    label115:
    final int i = j;
    if (paramInt != 1)
    {
      i = j;
      if (paramInt == 3) {
        i = 3078;
      }
    }
    Object localObject = qz.a();
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = null;
    } else {
      paramArrayOfByte1 = zu.a(paramArrayOfByte1);
    }
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = null;
    } else {
      paramArrayOfByte2 = zu.a(paramArrayOfByte2);
    }
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte3 = null;
    } else {
      paramArrayOfByte3 = zu.a(paramArrayOfByte3);
    }
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte4 = null;
    } else {
      paramArrayOfByte4 = zu.a(paramArrayOfByte4);
    }
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte5 = null;
    } else {
      paramArrayOfByte5 = zu.a(paramArrayOfByte5);
    }
    ((qz)localObject).a(paramLong1, paramLong2, paramInt, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, aad.a(RqdApplication.n()), aad.b(RqdApplication.n()), aad.c(RqdApplication.n()), un.f, un.h, un.g, un.i, un.j, un.k, un.l, un.m, un.n, un.o, vt.d, vt.e, vt.f, xu.f, xu.e, xu.h, xu.g, aad.e(RqdApplication.n()), aad.d(RqdApplication.n()), new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = i;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        if (i == 0) {
          try
          {
            paramAnonymousrb = new RealNameRegResult(new JSONObject(paramAnonymousrb.c));
            localwz.a = 0;
            if (paramHandler == null) {
              break label134;
            }
            Message.obtain(paramHandler, i, 0, -1, paramAnonymousrb).sendToTarget();
            return;
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        } else {
          try
          {
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            we.i = paramAnonymousrb.getString("hint_title");
            we.j = paramAnonymousrb.getString("hint_content");
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        label134:
        sb.a(paramHandler, localwz, i);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, String paramString, final Handler paramHandler, boolean paramBoolean)
  {
    if (0L == paramLong2)
    {
      QQUser localQQUser = ta.a().k.b();
      if (paramLong1 == 0L)
      {
        if (localQQUser == null)
        {
          paramString = paramHandler.obtainMessage(3080);
          paramHandler = new wz();
          paramHandler.a(110, null, null);
          paramString.arg1 = paramHandler.a;
          paramString.obj = paramHandler;
          paramString.sendToTarget();
          return -1;
        }
        paramLong2 = localQQUser.mRealUin;
      }
    }
    qz.a().a(paramLong2, paramString, paramBoolean, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 3080);
      }
    });
    return 0;
  }
  
  public final int a(final long paramLong, Handler paramHandler)
  {
    Object localObject = ta.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3000);
      localObject = new wz();
      ((wz)localObject).a(110, null, null);
      paramHandler.arg1 = ((wz)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qz.a().g(paramLong, new qz.a()
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
            Object localObject = new JSONObject(paramAnonymousrb.c);
            long l = ((JSONObject)localObject).getLong("uin");
            if (l != paramLong)
            {
              paramAnonymousrb = new StringBuilder("uin not match=");
              paramAnonymousrb.append(l);
              paramAnonymousrb.append(":");
              paramAnonymousrb.append(paramLong);
              localwz.a(10000, paramAnonymousrb.toString(), null);
              return;
            }
            localObject = ((JSONObject)localObject).getJSONArray("result");
            tb localtb = tb.a();
            if (!localtb.a((JSONArray)localObject))
            {
              paramAnonymousrb = new StringBuilder("update conf list failed:");
              paramAnonymousrb.append(((JSONArray)localObject).toString());
              localwz.a(10000, paramAnonymousrb.toString(), null);
              return;
            }
            localObject = new JSONObject();
            ((JSONObject)localObject).put("uin", l);
            ((JSONObject)localObject).put("data", paramAnonymousrb.c);
            ((JSONObject)localObject).put("seq_id", "1234");
            ((JSONObject)localObject).put("err", paramAnonymousrb.b);
            xc.a("account_lock", ((JSONObject)localObject).toString());
            localtb.b.e = true;
            localtb.b.f = false;
            localwz.a = 0;
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
            localwz.a = 10020;
          }
        }
        sb.a(this.b, localwz, 3000);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString, int paramInt, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3052);
      paramHandler = new wz();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().c(paramLong, paramString, paramInt, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 3052);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3060);
      paramHandler = new wz();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().b(paramLong, paramString, new qz.a()
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
            paramAnonymousrb = new LoginProtectResult(new JSONObject(paramAnonymousrb.c));
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3060, 0, -1, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3060);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3055);
      paramString2 = new wz();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().a(paramLong, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramString4, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 3055);
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
    qz.a().a(paramLong, arrayOfInt, paramArrayOfString, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 3028);
      }
    });
    return 0;
  }
  
  public final int a(final long paramLong, byte[] paramArrayOfByte, Handler paramHandler)
  {
    qz localqz = qz.a();
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = aad.a(paramArrayOfByte);
    }
    localqz.a(paramLong, paramArrayOfByte, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            long l = Long.parseLong(paramAnonymousrb.getString("uin"));
            paramAnonymousrb = paramAnonymousrb.getString("uin_mask");
            QQUser localQQUser = ta.a().d(paramLong);
            if (localQQUser != null)
            {
              localQQUser.mUin = l;
              localQQUser.mUinMask = paramAnonymousrb;
            }
            ta.a().e(paramLong);
            localwz.a = 0;
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(this.b, localwz, 3024);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, byte[] paramArrayOfByte, final Handler paramHandler, int paramInt)
  {
    qz.a().a(paramLong, aad.a(paramArrayOfByte), paramInt, new qz.a()
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
            paramAnonymousrb = new DeterminVerifyFactorsResult(new JSONObject(paramAnonymousrb.c));
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4003, 0, -1, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 4003);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, final int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramArrayOfInt1 = paramHandler.obtainMessage(3061);
      paramArrayOfInt2 = new wz();
      paramArrayOfInt2.a(110, null, null);
      paramArrayOfInt1.arg1 = paramArrayOfInt2.a;
      paramArrayOfInt1.obj = paramArrayOfInt2;
      paramArrayOfInt1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().a(paramLong, paramString, paramArrayOfInt1, paramArrayOfInt2, new qz.a()
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
            new JSONObject(paramAnonymousrb.c).getLong("uin");
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3061, 0, -1, paramArrayOfInt1).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3061);
      }
    });
    return 0;
  }
  
  public final int a(final Handler paramHandler)
  {
    Object localObject1 = RqdApplication.m();
    final vq localvq = new vq();
    localObject1 = ((aag)localObject1).a(localvq);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((aag.a)localObject1).b;
    }
    if ((localObject1 != null) && (((aas)localObject1).a != null)) {
      try
      {
        Object localObject2 = tb.a().h.a("key_value");
        localObject1 = new JSONObject((String)((aas)localObject1).a);
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
    qz.a().c(new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            aas localaas = new aas();
            localaas.a = paramAnonymousrb.toString();
            RqdApplication.m().a(localvq, localaas);
            localwz.a = 0;
            paramAnonymousrb = paramAnonymousrb.getJSONObject("data").toString();
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3023, 0, 0, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3023);
      }
    });
    return 0;
  }
  
  public final int a(final Handler paramHandler, final File paramFile, String paramString)
  {
    QQUser localQQUser = ta.a().k.b();
    qz localqz = qz.a();
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
    abk.a();
    localqz.a(paramFile, paramString, l1, l2, abk.e(), new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        if (paramAnonymousrb.b == 0)
        {
          paramAnonymousrb = new File(paramFile.getAbsolutePath());
          if ((paramAnonymousrb.exists()) && (paramAnonymousrb.isFile())) {
            zx.a(paramAnonymousrb);
          }
          aaa.b("debug.file.uploadfiledate").commit();
        }
        sb.a(paramHandler, localwz, 3063);
      }
    });
    return 0;
  }
  
  public final int a(Long paramLong, int paramInt, final Handler paramHandler)
  {
    Long localLong = paramLong;
    if (paramLong.longValue() == 0L)
    {
      paramLong = ta.a().k.b();
      if (paramLong == null)
      {
        paramLong = paramHandler.obtainMessage(3065);
        paramHandler = new wz();
        paramHandler.a(110, null, null);
        paramLong.arg1 = paramHandler.a;
        paramLong.obj = paramHandler;
        paramLong.sendToTarget();
        return -1;
      }
      localLong = Long.valueOf(paramLong.mRealUin);
    }
    qz.a().c(localLong.longValue(), paramInt, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        if ((paramAnonymousrb.b == 0) || (paramAnonymousrb.b == 124)) {
          try
          {
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            ut.d = paramAnonymousrb.getString("sms_port");
            ut.e = paramAnonymousrb.getString("sms_up_code");
            try
            {
              ut.f = paramAnonymousrb.getString("mobile_sms_prefix");
            }
            catch (Exception paramAnonymousrb)
            {
              paramAnonymousrb.printStackTrace();
            }
            sb.a(paramHandler, localwz, 3065);
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
      }
    });
    return 0;
  }
  
  public final int a(String paramString)
  {
    tl.b localb = this.a.b;
    localb.a.post(new tl.b.3(localb, paramString));
    return 0;
  }
  
  public final int a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, final Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = ta.a().k.b();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3019);
        paramString2 = new wz();
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mRealUin;
    }
    qz.a().a(paramString1, paramString2, paramInt1, paramLong, paramInt2, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            vn.d = paramAnonymousrb.getString("sms_port");
            vn.e = paramAnonymousrb.getString("sms_up_code");
            localwz.a = 0;
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3019);
      }
    });
    return 0;
  }
  
  public final int a(String paramString, final Handler paramHandler)
  {
    qz.a().a(paramString, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 3022);
      }
    });
    return 0;
  }
  
  public final int a(JSONArray paramJSONArray, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    qz.a().a(l, paramJSONArray, zo.j(RqdApplication.n()), zo.i(RqdApplication.n()), new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        if (paramAnonymousrb.b == 0) {
          aae.a(System.currentTimeMillis() / 1000L);
        }
        sb.a(paramHandler, localwz, 4013);
      }
    });
    return 0;
  }
  
  public final int b(final long paramLong, int paramInt, Handler paramHandler)
  {
    QQUser localQQUser = ta.a().c(paramLong);
    if ((localQQUser != null) && (localQQUser.mIsBinded))
    {
      qz.a().a(paramInt, aad.k(), new qz.a()
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
              paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
              long l = paramAnonymousrb.getLong("uin");
              if (l != paramLong)
              {
                paramAnonymousrb = new StringBuilder("uin not match=");
                paramAnonymousrb.append(l);
                paramAnonymousrb.append(":");
                paramAnonymousrb.append(paramLong);
                localwz.a(10000, paramAnonymousrb.toString(), null);
                return;
              }
              ta.a().g();
              if (!ta.a().k.a(l)) {
                localwz.a(10000, "mUserStorage.setCurrentUserByUin failed", null);
              }
              System.currentTimeMillis();
              l = paramAnonymousrb.getInt("valid_time");
              ta.a().a(paramLong, l);
              localwz.a = 0;
            }
            catch (JSONException paramAnonymousrb)
            {
              paramAnonymousrb.printStackTrace();
            }
          } else if ((paramAnonymousrb.b != 111) && (paramAnonymousrb.b == 270)) {
            try
            {
              Object localObject = new JSONObject(paramAnonymousrb.c);
              paramAnonymousrb = ((JSONObject)localObject).optString("masked_mobile");
              localObject = ((JSONObject)localObject).optString("mSmsPrefix");
              UpgradeDeterminResult localUpgradeDeterminResult = new UpgradeDeterminResult();
              localUpgradeDeterminResult.mMobileMask = paramAnonymousrb;
              localUpgradeDeterminResult.mSmsPrefix = ((String)localObject);
              localwz.d = localUpgradeDeterminResult;
            }
            catch (JSONException paramAnonymousrb)
            {
              paramAnonymousrb.printStackTrace();
            }
          }
          sb.a(this.b, localwz, 10002);
        }
      });
      return 0;
    }
    a(paramHandler, new wz(), 10002);
    return 0;
  }
  
  public final int b(final long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    qz.a().a(paramLong, paramInt, paramString1, paramString2, new qz.a()
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
            int i = new JSONObject(paramAnonymousrb.c).getInt("bind_mobile_succ");
            if (1 != i) {
              try
              {
                localwz.a(localwz.b);
              }
              catch (Exception paramAnonymousrb)
              {
                paramAnonymousrb.printStackTrace();
              }
            }
            paramAnonymousrb = ta.a().d(paramLong);
            if (paramAnonymousrb != null) {
              ta.a().b(paramAnonymousrb);
            }
            localwz.a = 0;
            if (this.b != null)
            {
              Message.obtain(this.b, 4004, 0, i, localwz).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(this.b, localwz, 4004);
      }
    });
    return 0;
  }
  
  public final int b(long paramLong, final Handler paramHandler)
  {
    Object localObject = ta.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3001);
      localObject = new wz();
      ((wz)localObject).a(110, null, null);
      paramHandler.arg1 = ((wz)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qz.a().d(paramLong, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c).getJSONArray("result");
            tb.a().d(paramAnonymousrb);
            localwz.e = paramAnonymousrb;
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
            localwz.a = 10020;
          }
        }
        sb.a(paramHandler, localwz, 3001);
      }
    });
    return 0;
  }
  
  public final int b(long paramLong, String paramString, int paramInt, final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(4008);
      paramHandler = new wz();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qz.a().f(paramLong, paramString, paramInt, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            xb.a("freeze result = ".concat(String.valueOf(paramAnonymousrb)));
            int i = -1;
            int j;
            try
            {
              j = paramAnonymousrb.getInt("sign_status");
              i = j;
              k = paramAnonymousrb.getInt("auto_melt_time");
              i = k;
            }
            catch (JSONException paramAnonymousrb)
            {
              paramAnonymousrb.printStackTrace();
              int k = 0;
              j = i;
              i = k;
            }
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4008, 0, j, Integer.valueOf(i)).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 4008);
      }
    });
    return 0;
  }
  
  public final int b(final Handler paramHandler)
  {
    qz.a().b(new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            vw.a locala = new vw.a();
            locala.a = paramAnonymousrb.getInt("is_have_msg");
            if (locala.a == 1)
            {
              locala.b = paramAnonymousrb.getString("content");
              locala.c = paramAnonymousrb.getLong("uin");
            }
            localwz.a(locala.b);
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3043, 0, -1, locala).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3043);
      }
    });
    return 0;
  }
  
  public final int c()
  {
    qz.a().a(new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        sb.a(paramAnonymousrb, localwz);
        sb.a(this.a, localwz, 3003);
      }
    });
    return 0;
  }
  
  public final int c(final long paramLong, int paramInt, Handler paramHandler)
  {
    qz.a().d(paramLong, paramInt, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        if (paramAnonymousrb.b == 0)
        {
          long l = paramLong;
          paramAnonymousrb = ta.a().d(l);
          if (paramAnonymousrb != null) {
            ta.a().b(paramAnonymousrb);
          }
          localwz.a = 0;
        }
        sb.a(this.b, localwz, 3074);
      }
    });
    return 0;
  }
  
  public final int c(final long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    qz.a().c(paramLong, paramInt, paramString1, paramString2, new qz.a()
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
            int i = new JSONObject(paramAnonymousrb.c).getInt("bind_mobile_succ");
            if (1 != i) {
              try
              {
                localwz.a(localwz.b);
              }
              catch (Exception paramAnonymousrb)
              {
                paramAnonymousrb.printStackTrace();
              }
            }
            paramAnonymousrb = ta.a().d(paramLong);
            if (paramAnonymousrb != null) {
              ta.a().b(paramAnonymousrb);
            }
            localwz.a = 0;
            if (this.b != null)
            {
              Message.obtain(this.b, 3026, 0, i, localwz).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(this.b, localwz, 3026);
      }
    });
    return 0;
  }
  
  public final int c(long paramLong, final Handler paramHandler)
  {
    Object localObject = ta.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3004);
      localObject = new wz();
      ((wz)localObject).a(110, null, null);
      paramHandler.arg1 = ((wz)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qz.a().b(paramLong, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            paramAnonymousrb = new EvalAccountResult(paramAnonymousrb.getJSONObject("result"), paramAnonymousrb);
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3004, 0, 0, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3004);
      }
    });
    return 0;
  }
  
  public final int c(final Handler paramHandler)
  {
    QQUser localQQUser = ta.a().k.b();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    qz.a().k(l, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c).optJSONArray("domain_list");
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3062, 0, -1, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3062);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final int paramInt, final Handler paramHandler)
  {
    if (paramLong == -1L)
    {
      localObject = ta.a().k.b();
      if (localObject != null) {
        paramLong = ((QQUser)localObject).mRealUin;
      }
    }
    Object localObject = RqdApplication.n().getResources().getDisplayMetrics();
    qz.a().a(paramLong, paramInt, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).densityDpi, aae.y(), aae.z(), new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        wz localwz = new wz();
        localwz.a = paramAnonymousrb.b;
        localwz.c = paramAnonymousrb.d;
        localwz.b = paramAnonymousrb.d;
        if (paramAnonymousrb.b == 0)
        {
          StringBuilder localStringBuilder = null;
          try
          {
            JSONObject localJSONObject = new JSONObject(paramAnonymousrb.c);
            int j = localJSONObject.getInt("need_live_detect");
            paramAnonymousrb = localStringBuilder;
            if (j == 1)
            {
              paramAnonymousrb = localStringBuilder;
              if (localJSONObject.getJSONArray("actions") != null)
              {
                paramAnonymousrb = localStringBuilder;
                if (localJSONObject.getJSONArray("actions").length() > 0)
                {
                  int k = localJSONObject.getJSONArray("actions").length();
                  paramAnonymousrb = new int[k];
                  int i = 0;
                  while (i < k)
                  {
                    paramAnonymousrb[i] = localJSONObject.getJSONArray("actions").getInt(i);
                    localStringBuilder = new StringBuilder("mLiveDetectActions");
                    localStringBuilder.append(paramAnonymousrb[i]);
                    xb.a(localStringBuilder.toString());
                    i += 1;
                  }
                  if ((paramInt != 2) && (paramInt != 1))
                  {
                    if (k > 0)
                    {
                      vt.f = paramAnonymousrb[0];
                      localStringBuilder = new StringBuilder("sVryAction");
                      localStringBuilder.append(vt.f);
                      xb.a(localStringBuilder.toString());
                    }
                  }
                  else if (k >= 2)
                  {
                    vt.d = paramAnonymousrb[0];
                    vt.e = paramAnonymousrb[1];
                  }
                }
              }
            }
            try
            {
              xx.n = localJSONObject.getInt("displayangle");
              xx.o = localJSONObject.getInt("imageangle");
              localStringBuilder = new StringBuilder("display angle=");
              localStringBuilder.append(xx.n);
              localStringBuilder.append(",angel2=");
              localStringBuilder.append(xx.o);
              xb.a(localStringBuilder.toString());
              aae.a(localJSONObject);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3082, 0, j, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3082);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final int paramInt, String paramString1, String paramString2, final Handler paramHandler)
  {
    qz.a().d(paramLong, paramInt, paramString1, paramString2, new qz.a()
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
            JSONObject localJSONObject = new JSONObject(paramAnonymousrb.c);
            paramAnonymousrb = "";
            if (paramInt == 5) {
              paramAnonymousrb = localJSONObject.getString("captcha_sig");
            }
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3072, 0, -1, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3072);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final Handler paramHandler)
  {
    Object localObject = ta.a().k.b();
    long l = paramLong;
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3010);
        localObject = new wz();
        ((wz)localObject).a(110, null, null);
        paramHandler.arg1 = ((wz)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    qz.a().a(l, new qz.a()
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
            paramAnonymousrb = new MbInfoResult(new JSONObject(paramAnonymousrb.c).getJSONArray("mb_list"));
            aam.a().a(paramAnonymousrb);
            localwz.e = paramAnonymousrb;
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3010, 0, 0, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
            localwz.a = 10020;
          }
        }
        sb.a(paramHandler, localwz, 3010);
      }
    });
    return 0;
  }
  
  public final int e(final long paramLong, Handler paramHandler)
  {
    qz.a().e(paramLong, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            localwz.a = 0;
            QQUser localQQUser = ta.a().c(paramLong);
            if (localQQUser == null)
            {
              localwz.a(10000, null, null);
            }
            else
            {
              localQQUser.mRealUin = paramAnonymousrb.getLong("real_uin");
              localQQUser.mMobileMask = paramAnonymousrb.getString("mobile");
              localQQUser.verify_sms = paramAnonymousrb.optInt("verify_sms");
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(this.b, localwz, 1006);
      }
    });
    return 0;
  }
  
  public final int f(long paramLong, final Handler paramHandler)
  {
    qz.a().i(paramLong, new qz.a()
    {
      public final void a(rb paramAnonymousrb)
      {
        sb.a(paramAnonymousrb, paramHandler, 3036);
      }
    });
    return 0;
  }
  
  public final int g(long paramLong, final Handler paramHandler)
  {
    Object localObject = ta.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3064);
      localObject = new wz();
      ((wz)localObject).a(110, null, null);
      paramHandler.arg1 = ((wz)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qz.a().l(paramLong, new qz.a()
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
            paramAnonymousrb = new RealNameStatusResult(new JSONObject(paramAnonymousrb.c));
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3064, 0, -1, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3064);
      }
    });
    return 0;
  }
  
  public final int h(long paramLong, final Handler paramHandler)
  {
    DisplayMetrics localDisplayMetrics = RqdApplication.n().getResources().getDisplayMetrics();
    qz.a().a(paramLong, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, localDisplayMetrics.densityDpi, aae.y(), aae.z(), new qz.a()
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
            paramAnonymousrb = new RealNameQueryResult(new JSONObject(paramAnonymousrb.c));
            StringBuilder localStringBuilder = new StringBuilder("result rebind_type: ");
            localStringBuilder.append(paramAnonymousrb.zzb_rebind_type);
            xb.c(localStringBuilder.toString());
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3073, 0, -1, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3073);
      }
    });
    return 0;
  }
  
  public final int i(long paramLong, final Handler paramHandler)
  {
    if (paramLong == -1L)
    {
      localObject = ta.a().k.b();
      if (localObject != null) {
        paramLong = ((QQUser)localObject).mRealUin;
      }
    }
    Object localObject = RqdApplication.n().getResources().getDisplayMetrics();
    qz.a().b(paramLong, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).densityDpi, aae.y(), aae.z(), new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            int i = paramAnonymousrb.getInt("need_idcard_detect");
            if (i == 1) {
              try
              {
                tp.d = paramAnonymousrb.getInt("displayangle");
                tp.e = paramAnonymousrb.getInt("imageangle");
                paramAnonymousrb = new StringBuilder("plain angle=");
                paramAnonymousrb.append(tp.d);
                paramAnonymousrb.append(",angel2=");
                paramAnonymousrb.append(tp.e);
                xb.a(paramAnonymousrb.toString());
              }
              catch (Exception paramAnonymousrb)
              {
                paramAnonymousrb.printStackTrace();
              }
            }
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3083, 0, i, null).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 3083);
      }
    });
    return 0;
  }
  
  public final int j(long paramLong, final Handler paramHandler)
  {
    Object localObject = ta.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(4007);
      localObject = new wz();
      ((wz)localObject).a(110, null, null);
      paramHandler.arg1 = ((wz)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qz.a().n(paramLong, new qz.a()
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
            paramAnonymousrb = new JSONObject(paramAnonymousrb.c);
            xb.a("freeze result = ".concat(String.valueOf(paramAnonymousrb)));
            paramAnonymousrb = new FreezeStatusResult(paramAnonymousrb);
            localwz.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4007, 0, -1, paramAnonymousrb).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousrb)
          {
            paramAnonymousrb.printStackTrace();
          }
        }
        sb.a(paramHandler, localwz, 4007);
      }
    });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sb
 * JD-Core Version:    0.7.0.1
 */