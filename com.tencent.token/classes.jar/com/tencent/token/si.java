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

public final class si
  implements tn
{
  public static int b = new Random().nextInt() >>> 1;
  private static si c;
  public ts a = new ts();
  
  public static si a()
  {
    if (c == null) {
      c = new si();
    }
    return c;
  }
  
  static void a(Handler paramHandler, xh paramxh, int paramInt)
  {
    if (paramHandler != null) {
      Message.obtain(paramHandler, paramInt, paramxh.a, 0, paramxh).sendToTarget();
    }
  }
  
  static void a(ri paramri, Handler paramHandler, int paramInt)
  {
    xh localxh = new xh();
    localxh.a = paramri.b;
    localxh.c = paramri.d;
    localxh.b = paramri.d;
    if (paramri.b == 0) {
      localxh.a = 0;
    }
    a(paramHandler, localxh, paramInt);
  }
  
  public static void a(ri paramri, xh paramxh)
  {
    if (paramri.b == 0) {
      try
      {
        paramxh.e = new sp(paramri.c);
        paramri = th.a().a(new JSONObject(paramri.c).getJSONArray("uinlist"));
        if (paramri.b())
        {
          th.a().j = true;
          if (th.a().o != 0L)
          {
            th.a().b(th.a().o);
            th.a().o = 0L;
          }
          paramxh.a = 0;
          return;
        }
        paramxh.a = paramri.a;
        return;
      }
      catch (JSONException paramri)
      {
        paramri.printStackTrace();
        paramxh.a = 10020;
      }
    }
  }
  
  public static int b()
  {
    return b;
  }
  
  public final int a(byte paramByte, final Handler paramHandler)
  {
    xh localxh = new xh();
    th localth = th.a();
    long l = localth.c();
    if ((localth.k.b() != null) && (l != 0L))
    {
      if (localth.k.b().mIsBinded) {
        l = localth.k.b().mUin;
      }
      rf.a().a(l, paramByte, new rf.a()
      {
        public final void a(ri paramAnonymousri)
        {
          xh localxh = new xh();
          localxh.a = paramAnonymousri.b;
          localxh.c = paramAnonymousri.d;
          localxh.b = paramAnonymousri.d;
          if (paramAnonymousri.b == 0) {
            try
            {
              paramAnonymousri = new JSONObject(paramAnonymousri.c).getJSONArray("msgs");
              if (!tf.a().a(paramAnonymousri, this.a))
              {
                StringBuilder localStringBuilder = new StringBuilder("update conf list failed:");
                localStringBuilder.append(paramAnonymousri.toString());
                localxh.a(10000, localStringBuilder.toString(), null);
              }
              else
              {
                th.a().g();
                localxh.a = 0;
              }
            }
            catch (JSONException paramAnonymousri)
            {
              paramAnonymousri.printStackTrace();
            }
          }
          si.a(paramHandler, localxh, 3069);
        }
      });
      return 0;
    }
    localxh.a(110, null, null);
    a(paramHandler, localxh, 3069);
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
    Object localObject2 = th.a().k.b();
    Object localObject1 = null;
    if (localObject2 == null)
    {
      paramHandler = paramHandler.obtainMessage(3005);
      localObject1 = new xh();
      ((xh)localObject1).a(110, null, null);
      paramHandler.arg1 = ((xh)localObject1).a;
      paramHandler.obj = localObject1;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject2).mUin;
    localObject2 = sg.a(RqdApplication.p());
    int i = 0;
    while (i < th.a().k.a())
    {
      QQUser localQQUser = th.a().a(i);
      if (localQQUser.mUin == paramLong)
      {
        if (localQQUser.mRealUin == 0L) {
          break;
        }
        localObject2 = ((sg)localObject2).a(localQQUser.mRealUin);
        if (localObject2 != null) {
          localObject1 = aao.a((byte[])localObject2);
        }
        break label171;
      }
      i += 1;
    }
    localObject1 = null;
    label171:
    localObject2 = th.a().c(paramLong);
    if ((localObject2 != null) && (((QQUser)localObject2).mUin == ((QQUser)localObject2).mRealUin)) {
      paramLong = aao.f(paramLong);
    }
    long l;
    if (paramInt2 != 1) {
      l = aap.a(1, paramLong);
    } else {
      l = 0L;
    }
    rf.a().a(paramInt1, paramInt2, 1, paramLong, (String)localObject1, l, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        Object localObject2 = new xh();
        ((xh)localObject2).a = paramAnonymousri.b;
        ((xh)localObject2).c = paramAnonymousri.d;
        ((xh)localObject2).b = paramAnonymousri.d;
        Object localObject3 = localObject2;
        Object localObject1;
        if (paramAnonymousri.b == 0)
        {
          localObject3 = tj.a();
          tl.a();
          ((tj)localObject3).a(paramLong);
          localObject1 = localObject2;
        }
        for (;;)
        {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            localObject1 = localObject2;
            long l = paramAnonymousri.getLong("uin");
            localObject1 = localObject2;
            if (l != paramLong)
            {
              localObject1 = localObject2;
              paramAnonymousri = new StringBuilder("uin not match=");
              localObject1 = localObject2;
              paramAnonymousri.append(l);
              localObject1 = localObject2;
              paramAnonymousri.append(":");
              localObject1 = localObject2;
              paramAnonymousri.append(paramLong);
              localObject1 = localObject2;
              ((xh)localObject2).a(10000, paramAnonymousri.toString(), null);
              localObject1 = localObject2;
              if (paramInt3 == null) {
                break label491;
              }
              localObject1 = localObject2;
              si.a(paramInt3, (xh)localObject2, paramInt2);
              return;
            }
            localObject1 = localObject2;
            if (this.d == 1)
            {
              localObject1 = localObject2;
              localObject3 = new AbnormalLoginMsgResult(paramAnonymousri);
              localObject1 = localObject2;
              ((xh)localObject2).a = 0;
              paramAnonymousri = (ri)localObject2;
              localObject2 = localObject3;
            }
            else
            {
              localObject1 = localObject2;
              ((tj)localObject3).b = null;
              localObject1 = localObject2;
              ArrayList localArrayList = new ArrayList();
              localObject1 = localObject2;
              if (paramAnonymousri.has("devs"))
              {
                localObject1 = localObject2;
                OnlineDeviceResult localOnlineDeviceResult = new OnlineDeviceResult(paramAnonymousri.getJSONArray("devs"));
                localObject1 = localObject2;
                if (localOnlineDeviceResult.mDevicesList != null)
                {
                  localObject1 = localObject2;
                  localArrayList.addAll(localOnlineDeviceResult.mDevicesList);
                }
                localObject1 = localObject2;
                ((tj)localObject3).b = new OnlineDeviceResult(paramAnonymousri.getJSONArray("devs"));
              }
              localObject1 = localObject2;
              rp.a.a().a(paramLong, localArrayList);
              localObject1 = localObject2;
              paramAnonymousri = ((tj)localObject3).f.a(paramAnonymousri, l, 1);
              localObject2 = null;
            }
            localObject1 = paramAnonymousri;
            paramAnonymousri.a = 0;
            localObject1 = paramAnonymousri;
            localObject3 = paramAnonymousri;
            if (paramInt3 != null)
            {
              localObject1 = paramAnonymousri;
              localObject3 = paramInt3;
              localObject1 = paramAnonymousri;
              int j = paramInt2;
              localObject1 = paramAnonymousri;
              if (paramAnonymousri.a != 0) {
                break label492;
              }
              i = 0;
              localObject1 = paramAnonymousri;
              Message.obtain((Handler)localObject3, j, i, 0, localObject2).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
            ((xh)localObject1).a(10020, null, null);
            localObject3 = localObject1;
          }
          si.a(paramInt3, (xh)localObject3, paramInt2);
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
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramSafeMsgItem = paramHandler.obtainMessage(3032);
      paramHandler = new xh();
      paramHandler.a(110, null, null);
      paramSafeMsgItem.arg1 = paramHandler.a;
      paramSafeMsgItem.obj = paramHandler;
      paramSafeMsgItem.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().a(paramLong, paramInt1, paramInt2, paramInt3, paramSafeMsgItem.mTypea, paramSafeMsgItem.mTypeb, paramSafeMsgItem.mTypec, SafeMsgItem.a(paramSafeMsgItem.mIP), paramSafeMsgItem.mLoc_country_id, paramSafeMsgItem.mLoc_prov_id, paramSafeMsgItem.mLoc_city_id, paramSafeMsgItem.mTime, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            int i;
            try
            {
              i = paramAnonymousri.getInt("is_priv_ip_user");
            }
            catch (JSONException paramAnonymousri)
            {
              paramAnonymousri.printStackTrace();
              i = -1;
            }
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3032, 0, i, null).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3032);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, final Handler paramHandler)
  {
    rf.a().a(paramLong, paramInt, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 4001);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3054);
      paramHandler = new xh();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().a(paramInt, paramLong, paramString, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {}
        for (;;)
        {
          int i;
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            try
            {
              i = paramAnonymousri.getInt("id");
              paramAnonymousri = paramAnonymousri.getJSONArray("result");
              if (i == 70)
              {
                ti.a().b(paramAnonymousri);
              }
              else if (i == 71)
              {
                ti.a().c(paramAnonymousri);
              }
              else if ((i == 80) && (paramAnonymousri != null) && (paramAnonymousri.length() > 0))
              {
                i = 0;
                if (i < paramAnonymousri.length())
                {
                  JSONObject localJSONObject = paramAnonymousri.getJSONObject(i);
                  if (localJSONObject.getInt("id") == 71)
                  {
                    ti.a().a(localJSONObject);
                    break label217;
                  }
                  localJSONObject.getInt("id");
                  break label217;
                }
              }
              localxh.a = 0;
            }
            catch (JSONException paramAnonymousri)
            {
              localxh.a(201, RqdApplication.p().getString(2131492910), null);
              paramAnonymousri.printStackTrace();
            }
            si.a(paramHandler, localxh, 3054);
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
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
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3013);
      paramString2 = new xh();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().b(paramLong, paramInt, paramString1, paramString2, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c).getString("sms_prefix");
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3013, 0, 0, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3013);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3012);
      paramString2 = new xh();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().a(paramLong, paramString1, paramString2, paramInt, paramString3, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            JSONObject localJSONObject = new JSONObject();
            String str1 = paramAnonymousri.getString("time1");
            String str2 = paramAnonymousri.getString("time2");
            localJSONObject.put("info", paramAnonymousri.optString("extraInfo"));
            localJSONObject.put("time1", str1);
            localJSONObject.put("time2", str2);
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3012, 0, 0, localJSONObject).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
            localxh.a = 0;
          }
        }
        si.a(paramHandler, localxh, 3012);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, boolean paramBoolean, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3004);
      paramHandler = new xh();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().a(paramLong, paramInt, paramBoolean, paramString, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 4002);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, final Handler paramHandler)
  {
    if ((paramLong2 == 0L) && (paramLong1 == 0L))
    {
      Object localObject = th.a().k.b();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3068);
        localObject = new xh();
        ((xh)localObject).a(110, null, null);
        paramHandler.arg1 = ((xh)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong2 = ((QQUser)localObject).mRealUin;
    }
    rf.a().a(paramLong2, paramInt2, paramInt1, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 3068);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, final Handler paramHandler)
  {
    if ((0L == paramLong2) && (paramLong1 == 0L))
    {
      Object localObject = th.a().k.b();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3075);
        localObject = new xh();
        ((xh)localObject).a(110, null, null);
        paramHandler.arg1 = ((xh)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong2 = ((QQUser)localObject).mRealUin;
    }
    rf.a().c(paramLong2, paramInt, aap.i(), new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            int i = new JSONObject(paramAnonymousri.c).getInt("verify_type");
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3075, 0, -1, Integer.valueOf(i)).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3075);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, String paramString, final Handler paramHandler)
  {
    if ((paramLong2 == 0L) && (paramLong1 == 0L))
    {
      QQUser localQQUser = th.a().k.b();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3066);
        paramHandler = new xh();
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong2 = localQQUser.mRealUin;
    }
    rf.a().a(paramLong2, paramInt, paramString, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 3066);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, final Handler paramHandler)
  {
    QQUser localQQUser1;
    if (paramLong2 != 0L) {
      localQQUser1 = th.a().d(paramLong2);
    } else {
      localQQUser1 = null;
    }
    QQUser localQQUser2 = localQQUser1;
    if (localQQUser1 == null) {
      localQQUser2 = th.a().k.b();
    }
    if ((paramLong1 == 0L) && (localQQUser2 == null))
    {
      paramArrayOfByte = paramHandler.obtainMessage(3058);
      paramHandler = new xh();
      paramHandler.a(110, null, null);
      paramArrayOfByte.arg1 = paramHandler.a;
      paramArrayOfByte.obj = paramHandler;
      paramArrayOfByte.sendToTarget();
      return -1;
    }
    if (paramLong2 != 0L) {
      aao.f(paramLong2);
    } else if (localQQUser2 != null) {
      paramLong2 = localQQUser2.mRealUin;
    }
    rf.a().a(paramLong2, paramLong2, paramInt1, aaf.a(paramArrayOfByte), paramInt2, paramInt3, paramInt4, uu.d, uu.e, uu.f, uu.h, FaceDetector.IsSupportNeon(), uu.g, uu.i, uu.j, uu.k, uu.l, uu.m, uu.n, uu.o, wa.d, wa.e, wa.f, aap.i(), new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        int i;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            i = paramAnonymousri.getInt("op_type");
            paramAnonymousri = paramAnonymousri.getJSONArray("no_face_uin_list");
            localxh.a = 0;
            if (paramHandler == null) {
              break label161;
            }
            Message.obtain(paramHandler, 3058, 0, i, paramAnonymousri).sendToTarget();
            return;
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        } else {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            i = paramAnonymousri.getInt("op_type");
            so localso = new so();
            localso.a = i;
            localso.b = paramAnonymousri.optInt("is_realname_qualified");
            localxh.d = localso;
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        label161:
        si.a(paramHandler, localxh, 3058);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, final Handler paramHandler)
  {
    int j = 3067;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = th.a().k.b();
      if (localObject == null)
      {
        paramArrayOfByte1 = paramHandler.obtainMessage(3067);
        paramArrayOfByte2 = new xh();
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
    paramLong1 = aao.f(paramLong2);
    label115:
    final int i = j;
    if (paramInt != 1)
    {
      i = j;
      if (paramInt == 3) {
        i = 3078;
      }
    }
    Object localObject = rf.a();
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = null;
    } else {
      paramArrayOfByte1 = aaf.a(paramArrayOfByte1);
    }
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = null;
    } else {
      paramArrayOfByte2 = aaf.a(paramArrayOfByte2);
    }
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte3 = null;
    } else {
      paramArrayOfByte3 = aaf.a(paramArrayOfByte3);
    }
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte4 = null;
    } else {
      paramArrayOfByte4 = aaf.a(paramArrayOfByte4);
    }
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte5 = null;
    } else {
      paramArrayOfByte5 = aaf.a(paramArrayOfByte5);
    }
    ((rf)localObject).a(paramLong1, paramLong2, paramInt, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, aao.a(RqdApplication.p()), aao.b(RqdApplication.p()), aao.c(RqdApplication.p()), uu.f, uu.h, uu.g, uu.i, uu.j, uu.k, uu.l, uu.m, uu.n, uu.o, wa.d, wa.e, wa.f, yg.f, yg.e, yg.h, yg.g, aao.e(RqdApplication.p()), aao.d(RqdApplication.p()), new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = i;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (i == 0) {
          try
          {
            paramAnonymousri = new RealNameRegResult(new JSONObject(paramAnonymousri.c));
            localxh.a = 0;
            if (paramHandler == null) {
              break label134;
            }
            Message.obtain(paramHandler, i, 0, -1, paramAnonymousri).sendToTarget();
            return;
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        } else {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            wl.i = paramAnonymousri.getString("hint_title");
            wl.j = paramAnonymousri.getString("hint_content");
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        label134:
        si.a(paramHandler, localxh, i);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, String paramString, final Handler paramHandler, boolean paramBoolean)
  {
    if (0L == paramLong2)
    {
      QQUser localQQUser = th.a().k.b();
      if (paramLong1 == 0L)
      {
        if (localQQUser == null)
        {
          paramString = paramHandler.obtainMessage(3080);
          paramHandler = new xh();
          paramHandler.a(110, null, null);
          paramString.arg1 = paramHandler.a;
          paramString.obj = paramHandler;
          paramString.sendToTarget();
          return -1;
        }
        paramLong2 = localQQUser.mRealUin;
      }
    }
    rf.a().a(paramLong2, paramString, paramBoolean, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 3080);
      }
    });
    return 0;
  }
  
  public final int a(final long paramLong, Handler paramHandler)
  {
    Object localObject = th.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3000);
      localObject = new xh();
      ((xh)localObject).a(110, null, null);
      paramHandler.arg1 = ((xh)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rf.a().g(paramLong, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            Object localObject = new JSONObject(paramAnonymousri.c);
            long l = ((JSONObject)localObject).getLong("uin");
            if (l != paramLong)
            {
              paramAnonymousri = new StringBuilder("uin not match=");
              paramAnonymousri.append(l);
              paramAnonymousri.append(":");
              paramAnonymousri.append(paramLong);
              localxh.a(10000, paramAnonymousri.toString(), null);
              return;
            }
            localObject = ((JSONObject)localObject).getJSONArray("result");
            ti localti = ti.a();
            if (!localti.a((JSONArray)localObject))
            {
              paramAnonymousri = new StringBuilder("update conf list failed:");
              paramAnonymousri.append(((JSONArray)localObject).toString());
              localxh.a(10000, paramAnonymousri.toString(), null);
              return;
            }
            localObject = new JSONObject();
            ((JSONObject)localObject).put("uin", l);
            ((JSONObject)localObject).put("data", paramAnonymousri.c);
            ((JSONObject)localObject).put("seq_id", "1234");
            ((JSONObject)localObject).put("err", paramAnonymousri.b);
            xm.a("account_lock", ((JSONObject)localObject).toString());
            localti.b.e = true;
            localti.b.f = false;
            localxh.a = 0;
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
            localxh.a = 10020;
          }
        }
        si.a(this.b, localxh, 3000);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString, int paramInt, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3052);
      paramHandler = new xh();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().c(paramLong, paramString, paramInt, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 3052);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3060);
      paramHandler = new xh();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().b(paramLong, paramString, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new LoginProtectResult(new JSONObject(paramAnonymousri.c));
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3060, 0, -1, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3060);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3055);
      paramString2 = new xh();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().a(paramLong, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramString4, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 3055);
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
    rf.a().a(paramLong, arrayOfInt, paramArrayOfString, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 3028);
      }
    });
    return 0;
  }
  
  public final int a(final long paramLong, byte[] paramArrayOfByte, Handler paramHandler)
  {
    rf localrf = rf.a();
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = aao.a(paramArrayOfByte);
    }
    localrf.a(paramLong, paramArrayOfByte, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            long l = Long.parseLong(paramAnonymousri.getString("uin"));
            paramAnonymousri = paramAnonymousri.getString("uin_mask");
            QQUser localQQUser = th.a().d(paramLong);
            if (localQQUser != null)
            {
              localQQUser.mUin = l;
              localQQUser.mUinMask = paramAnonymousri;
            }
            th.a().e(paramLong);
            localxh.a = 0;
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(this.b, localxh, 3024);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, byte[] paramArrayOfByte, final Handler paramHandler, int paramInt)
  {
    rf.a().a(paramLong, aao.a(paramArrayOfByte), paramInt, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new DeterminVerifyFactorsResult(new JSONObject(paramAnonymousri.c));
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4003, 0, -1, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 4003);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, final int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramArrayOfInt1 = paramHandler.obtainMessage(3061);
      paramArrayOfInt2 = new xh();
      paramArrayOfInt2.a(110, null, null);
      paramArrayOfInt1.arg1 = paramArrayOfInt2.a;
      paramArrayOfInt1.obj = paramArrayOfInt2;
      paramArrayOfInt1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().a(paramLong, paramString, paramArrayOfInt1, paramArrayOfInt2, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            new JSONObject(paramAnonymousri.c).getLong("uin");
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3061, 0, -1, paramArrayOfInt1).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3061);
      }
    });
    return 0;
  }
  
  public final int a(final Handler paramHandler)
  {
    Object localObject1 = RqdApplication.o();
    final vx localvx = new vx();
    localObject1 = ((aar)localObject1).a(localvx);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((aar.a)localObject1).b;
    }
    if ((localObject1 != null) && (((abd)localObject1).a != null)) {
      try
      {
        Object localObject2 = ti.a().h.a("key_value");
        localObject1 = new JSONObject((String)((abd)localObject1).a);
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
    rf.a().c(new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            abd localabd = new abd();
            localabd.a = paramAnonymousri.toString();
            RqdApplication.o().a(localvx, localabd);
            localxh.a = 0;
            paramAnonymousri = paramAnonymousri.getJSONObject("data").toString();
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3023, 0, 0, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3023);
      }
    });
    return 0;
  }
  
  public final int a(final Handler paramHandler, final File paramFile, String paramString)
  {
    QQUser localQQUser = th.a().k.b();
    rf localrf = rf.a();
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
    abu.a();
    localrf.a(paramFile, paramString, l1, l2, abu.e(), new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0)
        {
          paramAnonymousri = new File(paramFile.getAbsolutePath());
          if ((paramAnonymousri.exists()) && (paramAnonymousri.isFile())) {
            aai.a(paramAnonymousri);
          }
          aal.b("debug.file.uploadfiledate").commit();
        }
        si.a(paramHandler, localxh, 3063);
      }
    });
    return 0;
  }
  
  public final int a(Long paramLong, int paramInt, final Handler paramHandler)
  {
    Long localLong = paramLong;
    if (paramLong.longValue() == 0L)
    {
      paramLong = th.a().k.b();
      if (paramLong == null)
      {
        paramLong = paramHandler.obtainMessage(3065);
        paramHandler = new xh();
        paramHandler.a(110, null, null);
        paramLong.arg1 = paramHandler.a;
        paramLong.obj = paramHandler;
        paramLong.sendToTarget();
        return -1;
      }
      localLong = Long.valueOf(paramLong.mRealUin);
    }
    rf.a().c(localLong.longValue(), paramInt, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if ((paramAnonymousri.b == 0) || (paramAnonymousri.b == 124)) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            va.d = paramAnonymousri.getString("sms_port");
            va.e = paramAnonymousri.getString("sms_up_code");
            try
            {
              va.f = paramAnonymousri.getString("mobile_sms_prefix");
            }
            catch (Exception paramAnonymousri)
            {
              paramAnonymousri.printStackTrace();
            }
            si.a(paramHandler, localxh, 3065);
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
      }
    });
    return 0;
  }
  
  public final int a(String paramString)
  {
    ts.b localb = this.a.b;
    localb.a.post(new ts.b.3(localb, paramString));
    return 0;
  }
  
  public final int a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, final Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = th.a().k.b();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3019);
        paramString2 = new xh();
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mRealUin;
    }
    rf.a().a(paramString1, paramString2, paramInt1, paramLong, paramInt2, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            vu.d = paramAnonymousri.getString("sms_port");
            vu.e = paramAnonymousri.getString("sms_up_code");
            localxh.a = 0;
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3019);
      }
    });
    return 0;
  }
  
  public final int a(String paramString, final Handler paramHandler)
  {
    rf.a().a(paramString, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 3022);
      }
    });
    return 0;
  }
  
  public final int a(JSONArray paramJSONArray, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    rf.a().a(l, paramJSONArray, zz.j(RqdApplication.p()), zz.i(RqdApplication.p()), new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          aap.a(System.currentTimeMillis() / 1000L);
        }
        si.a(paramHandler, localxh, 4013);
      }
    });
    return 0;
  }
  
  public final int b(final long paramLong, int paramInt, Handler paramHandler)
  {
    QQUser localQQUser = th.a().c(paramLong);
    if ((localQQUser != null) && (localQQUser.mIsBinded))
    {
      rf.a().a(paramInt, aao.k(), new rf.a()
      {
        public final void a(ri paramAnonymousri)
        {
          xh localxh = new xh();
          localxh.a = paramAnonymousri.b;
          localxh.c = paramAnonymousri.d;
          localxh.b = paramAnonymousri.d;
          if (paramAnonymousri.b == 0) {
            try
            {
              paramAnonymousri = new JSONObject(paramAnonymousri.c);
              long l = paramAnonymousri.getLong("uin");
              if (l != paramLong)
              {
                paramAnonymousri = new StringBuilder("uin not match=");
                paramAnonymousri.append(l);
                paramAnonymousri.append(":");
                paramAnonymousri.append(paramLong);
                localxh.a(10000, paramAnonymousri.toString(), null);
                return;
              }
              th.a().g();
              if (!th.a().k.a(l)) {
                localxh.a(10000, "mUserStorage.setCurrentUserByUin failed", null);
              }
              System.currentTimeMillis();
              l = paramAnonymousri.getInt("valid_time");
              th.a().a(paramLong, l);
              localxh.a = 0;
            }
            catch (JSONException paramAnonymousri)
            {
              paramAnonymousri.printStackTrace();
            }
          } else if ((paramAnonymousri.b != 111) && (paramAnonymousri.b == 270)) {
            try
            {
              Object localObject = new JSONObject(paramAnonymousri.c);
              paramAnonymousri = ((JSONObject)localObject).optString("masked_mobile");
              localObject = ((JSONObject)localObject).optString("mSmsPrefix");
              UpgradeDeterminResult localUpgradeDeterminResult = new UpgradeDeterminResult();
              localUpgradeDeterminResult.mMobileMask = paramAnonymousri;
              localUpgradeDeterminResult.mSmsPrefix = ((String)localObject);
              localxh.d = localUpgradeDeterminResult;
            }
            catch (JSONException paramAnonymousri)
            {
              paramAnonymousri.printStackTrace();
            }
          }
          si.a(this.b, localxh, 10002);
        }
      });
      return 0;
    }
    a(paramHandler, new xh(), 10002);
    return 0;
  }
  
  public final int b(final long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    rf.a().a(paramLong, paramInt, paramString1, paramString2, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            int i = new JSONObject(paramAnonymousri.c).getInt("bind_mobile_succ");
            if (1 != i) {
              try
              {
                localxh.a(localxh.b);
              }
              catch (Exception paramAnonymousri)
              {
                paramAnonymousri.printStackTrace();
              }
            }
            paramAnonymousri = th.a().d(paramLong);
            if (paramAnonymousri != null) {
              th.a().a(paramAnonymousri);
            }
            localxh.a = 0;
            if (this.b != null)
            {
              Message.obtain(this.b, 4004, 0, i, localxh).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(this.b, localxh, 4004);
      }
    });
    return 0;
  }
  
  public final int b(long paramLong, final Handler paramHandler)
  {
    Object localObject = th.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3001);
      localObject = new xh();
      ((xh)localObject).a(110, null, null);
      paramHandler.arg1 = ((xh)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rf.a().d(paramLong, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c).getJSONArray("result");
            ti.a().d(paramAnonymousri);
            localxh.e = paramAnonymousri;
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
            localxh.a = 10020;
          }
        }
        si.a(paramHandler, localxh, 3001);
      }
    });
    return 0;
  }
  
  public final int b(long paramLong, String paramString, int paramInt, final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(4008);
      paramHandler = new xh();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    rf.a().f(paramLong, paramString, paramInt, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            xj.a("freeze result = ".concat(String.valueOf(paramAnonymousri)));
            int i = -1;
            int j;
            try
            {
              j = paramAnonymousri.getInt("sign_status");
              i = j;
              k = paramAnonymousri.getInt("auto_melt_time");
              i = k;
            }
            catch (JSONException paramAnonymousri)
            {
              paramAnonymousri.printStackTrace();
              int k = 0;
              j = i;
              i = k;
            }
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4008, 0, j, Integer.valueOf(i)).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 4008);
      }
    });
    return 0;
  }
  
  public final int b(final Handler paramHandler)
  {
    rf.a().b(new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            wd.a locala = new wd.a();
            locala.a = paramAnonymousri.getInt("is_have_msg");
            if (locala.a == 1)
            {
              locala.b = paramAnonymousri.getString("content");
              locala.c = paramAnonymousri.getLong("uin");
            }
            localxh.a(locala.b);
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3043, 0, -1, locala).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3043);
      }
    });
    return 0;
  }
  
  public final int c()
  {
    rf.a().a(new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        si.a(paramAnonymousri, localxh);
        si.a(this.a, localxh, 3003);
      }
    });
    return 0;
  }
  
  public final int c(final long paramLong, int paramInt, Handler paramHandler)
  {
    rf.a().d(paramLong, paramInt, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0)
        {
          long l = paramLong;
          paramAnonymousri = th.a().d(l);
          if (paramAnonymousri != null) {
            th.a().a(paramAnonymousri);
          }
          localxh.a = 0;
        }
        si.a(this.b, localxh, 3074);
      }
    });
    return 0;
  }
  
  public final int c(final long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    rf.a().c(paramLong, paramInt, paramString1, paramString2, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            int i = new JSONObject(paramAnonymousri.c).getInt("bind_mobile_succ");
            if (1 != i) {
              try
              {
                localxh.a(localxh.b);
              }
              catch (Exception paramAnonymousri)
              {
                paramAnonymousri.printStackTrace();
              }
            }
            paramAnonymousri = th.a().d(paramLong);
            if (paramAnonymousri != null) {
              th.a().a(paramAnonymousri);
            }
            localxh.a = 0;
            if (this.b != null)
            {
              Message.obtain(this.b, 3026, 0, i, localxh).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(this.b, localxh, 3026);
      }
    });
    return 0;
  }
  
  public final int c(long paramLong, final Handler paramHandler)
  {
    Object localObject = th.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3004);
      localObject = new xh();
      ((xh)localObject).a(110, null, null);
      paramHandler.arg1 = ((xh)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rf.a().b(paramLong, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            paramAnonymousri = new EvalAccountResult(paramAnonymousri.getJSONObject("result"), paramAnonymousri);
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3004, 0, 0, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3004);
      }
    });
    return 0;
  }
  
  public final int c(final Handler paramHandler)
  {
    QQUser localQQUser = th.a().k.b();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    rf.a().k(l, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c).optJSONArray("domain_list");
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3062, 0, -1, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3062);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final int paramInt, final Handler paramHandler)
  {
    if (paramLong == -1L)
    {
      localObject = th.a().k.b();
      if (localObject != null) {
        paramLong = ((QQUser)localObject).mRealUin;
      }
    }
    Object localObject = RqdApplication.p().getResources().getDisplayMetrics();
    rf.a().a(paramLong, paramInt, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).densityDpi, aap.y(), aap.z(), new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0)
        {
          StringBuilder localStringBuilder = null;
          try
          {
            JSONObject localJSONObject = new JSONObject(paramAnonymousri.c);
            int j = localJSONObject.getInt("need_live_detect");
            paramAnonymousri = localStringBuilder;
            if (j == 1)
            {
              paramAnonymousri = localStringBuilder;
              if (localJSONObject.getJSONArray("actions") != null)
              {
                paramAnonymousri = localStringBuilder;
                if (localJSONObject.getJSONArray("actions").length() > 0)
                {
                  int k = localJSONObject.getJSONArray("actions").length();
                  paramAnonymousri = new int[k];
                  int i = 0;
                  while (i < k)
                  {
                    paramAnonymousri[i] = localJSONObject.getJSONArray("actions").getInt(i);
                    localStringBuilder = new StringBuilder("mLiveDetectActions");
                    localStringBuilder.append(paramAnonymousri[i]);
                    xj.a(localStringBuilder.toString());
                    i += 1;
                  }
                  if ((paramInt != 2) && (paramInt != 1))
                  {
                    if (k > 0)
                    {
                      wa.f = paramAnonymousri[0];
                      localStringBuilder = new StringBuilder("sVryAction");
                      localStringBuilder.append(wa.f);
                      xj.a(localStringBuilder.toString());
                    }
                  }
                  else if (k >= 2)
                  {
                    wa.d = paramAnonymousri[0];
                    wa.e = paramAnonymousri[1];
                  }
                }
              }
            }
            try
            {
              yj.n = localJSONObject.getInt("displayangle");
              yj.o = localJSONObject.getInt("imageangle");
              localStringBuilder = new StringBuilder("display angle=");
              localStringBuilder.append(yj.n);
              localStringBuilder.append(",angel2=");
              localStringBuilder.append(yj.o);
              xj.a(localStringBuilder.toString());
              aap.a(localJSONObject);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3082, 0, j, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3082);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final int paramInt, String paramString1, String paramString2, final Handler paramHandler)
  {
    rf.a().d(paramLong, paramInt, paramString1, paramString2, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramAnonymousri.c);
            paramAnonymousri = "";
            if (paramInt == 5) {
              paramAnonymousri = localJSONObject.getString("captcha_sig");
            }
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3072, 0, -1, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3072);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final Handler paramHandler)
  {
    Object localObject = th.a().k.b();
    long l = paramLong;
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3010);
        localObject = new xh();
        ((xh)localObject).a(110, null, null);
        paramHandler.arg1 = ((xh)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    rf.a().a(l, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new MbInfoResult(new JSONObject(paramAnonymousri.c).getJSONArray("mb_list"));
            aax.a().a(paramAnonymousri);
            localxh.e = paramAnonymousri;
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3010, 0, 0, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
            localxh.a = 10020;
          }
        }
        si.a(paramHandler, localxh, 3010);
      }
    });
    return 0;
  }
  
  public final int e(final long paramLong, Handler paramHandler)
  {
    rf.a().e(paramLong, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            localxh.a = 0;
            QQUser localQQUser = th.a().c(paramLong);
            if (localQQUser == null)
            {
              localxh.a(10000, null, null);
            }
            else
            {
              localQQUser.mRealUin = paramAnonymousri.getLong("real_uin");
              localQQUser.mMobileMask = paramAnonymousri.getString("mobile");
              localQQUser.verify_sms = paramAnonymousri.optInt("verify_sms");
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(this.b, localxh, 1006);
      }
    });
    return 0;
  }
  
  public final int f(long paramLong, final Handler paramHandler)
  {
    rf.a().i(paramLong, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        si.a(paramAnonymousri, paramHandler, 3036);
      }
    });
    return 0;
  }
  
  public final int g(long paramLong, final Handler paramHandler)
  {
    Object localObject = th.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3064);
      localObject = new xh();
      ((xh)localObject).a(110, null, null);
      paramHandler.arg1 = ((xh)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rf.a().l(paramLong, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new RealNameStatusResult(new JSONObject(paramAnonymousri.c));
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3064, 0, -1, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3064);
      }
    });
    return 0;
  }
  
  public final int h(long paramLong, final Handler paramHandler)
  {
    DisplayMetrics localDisplayMetrics = RqdApplication.p().getResources().getDisplayMetrics();
    rf.a().a(paramLong, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, localDisplayMetrics.densityDpi, aap.y(), aap.z(), new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new RealNameQueryResult(new JSONObject(paramAnonymousri.c));
            StringBuilder localStringBuilder = new StringBuilder("result rebind_type: ");
            localStringBuilder.append(paramAnonymousri.zzb_rebind_type);
            xj.c(localStringBuilder.toString());
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3073, 0, -1, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3073);
      }
    });
    return 0;
  }
  
  public final int i(long paramLong, final Handler paramHandler)
  {
    if (paramLong == -1L)
    {
      localObject = th.a().k.b();
      if (localObject != null) {
        paramLong = ((QQUser)localObject).mRealUin;
      }
    }
    Object localObject = RqdApplication.p().getResources().getDisplayMetrics();
    rf.a().b(paramLong, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).densityDpi, aap.y(), aap.z(), new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            int i = paramAnonymousri.getInt("need_idcard_detect");
            if (i == 1) {
              try
              {
                tw.d = paramAnonymousri.getInt("displayangle");
                tw.e = paramAnonymousri.getInt("imageangle");
                paramAnonymousri = new StringBuilder("plain angle=");
                paramAnonymousri.append(tw.d);
                paramAnonymousri.append(",angel2=");
                paramAnonymousri.append(tw.e);
                xj.a(paramAnonymousri.toString());
              }
              catch (Exception paramAnonymousri)
              {
                paramAnonymousri.printStackTrace();
              }
            }
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3083, 0, i, null).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 3083);
      }
    });
    return 0;
  }
  
  public final int j(long paramLong, final Handler paramHandler)
  {
    Object localObject = th.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(4007);
      localObject = new xh();
      ((xh)localObject).a(110, null, null);
      paramHandler.arg1 = ((xh)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    rf.a().n(paramLong, new rf.a()
    {
      public final void a(ri paramAnonymousri)
      {
        xh localxh = new xh();
        localxh.a = paramAnonymousri.b;
        localxh.c = paramAnonymousri.d;
        localxh.b = paramAnonymousri.d;
        if (paramAnonymousri.b == 0) {
          try
          {
            paramAnonymousri = new JSONObject(paramAnonymousri.c);
            xj.a("freeze result = ".concat(String.valueOf(paramAnonymousri)));
            paramAnonymousri = new FreezeStatusResult(paramAnonymousri);
            localxh.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4007, 0, -1, paramAnonymousri).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousri)
          {
            paramAnonymousri.printStackTrace();
          }
        }
        si.a(paramHandler, localxh, 4007);
      }
    });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.si
 * JD-Core Version:    0.7.0.1
 */