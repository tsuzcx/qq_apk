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

public final class sa
  implements tf
{
  public static int b = new Random().nextInt() >>> 1;
  private static sa c;
  public tk a = new tk();
  
  public static sa a()
  {
    if (c == null) {
      c = new sa();
    }
    return c;
  }
  
  static void a(Handler paramHandler, wy paramwy, int paramInt)
  {
    if (paramHandler != null) {
      Message.obtain(paramHandler, paramInt, paramwy.a, 0, paramwy).sendToTarget();
    }
  }
  
  static void a(ra paramra, Handler paramHandler, int paramInt)
  {
    wy localwy = new wy();
    localwy.a = paramra.b;
    localwy.c = paramra.d;
    localwy.b = paramra.d;
    if (paramra.b == 0) {
      localwy.a = 0;
    }
    a(paramHandler, localwy, paramInt);
  }
  
  public static void a(ra paramra, wy paramwy)
  {
    if (paramra.b == 0) {
      try
      {
        paramwy.e = new sh(paramra.c);
        paramra = sz.a().a(new JSONObject(paramra.c).getJSONArray("uinlist"));
        if (paramra.b())
        {
          sz.a().j = true;
          if (sz.a().o != 0L)
          {
            sz.a().b(sz.a().o);
            sz.a().o = 0L;
          }
          paramwy.a = 0;
          return;
        }
        paramwy.a = paramra.a;
        return;
      }
      catch (JSONException paramra)
      {
        paramra.printStackTrace();
        paramwy.a = 10020;
      }
    }
  }
  
  public static int b()
  {
    return b;
  }
  
  public final int a(byte paramByte, final Handler paramHandler)
  {
    wy localwy = new wy();
    sz localsz = sz.a();
    long l = localsz.c();
    if ((localsz.k.b() != null) && (l != 0L))
    {
      if (localsz.k.b().mIsBinded) {
        l = localsz.k.b().mUin;
      }
      qy.a().a(l, paramByte, new qy.a()
      {
        public final void a(ra paramAnonymousra)
        {
          wy localwy = new wy();
          localwy.a = paramAnonymousra.b;
          localwy.c = paramAnonymousra.d;
          localwy.b = paramAnonymousra.d;
          if (paramAnonymousra.b == 0) {
            try
            {
              paramAnonymousra = new JSONObject(paramAnonymousra.c).getJSONArray("msgs");
              if (!sx.a().a(paramAnonymousra, this.a))
              {
                StringBuilder localStringBuilder = new StringBuilder("update conf list failed:");
                localStringBuilder.append(paramAnonymousra.toString());
                localwy.a(10000, localStringBuilder.toString(), null);
              }
              else
              {
                sz.a().g();
                localwy.a = 0;
              }
            }
            catch (JSONException paramAnonymousra)
            {
              paramAnonymousra.printStackTrace();
            }
          }
          sa.a(paramHandler, localwy, 3069);
        }
      });
      return 0;
    }
    localwy.a(110, null, null);
    a(paramHandler, localwy, 3069);
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
    Object localObject2 = sz.a().k.b();
    Object localObject1 = null;
    if (localObject2 == null)
    {
      paramHandler = paramHandler.obtainMessage(3005);
      localObject1 = new wy();
      ((wy)localObject1).a(110, null, null);
      paramHandler.arg1 = ((wy)localObject1).a;
      paramHandler.obj = localObject1;
      paramHandler.sendToTarget();
      return -1;
    }
    final long l2 = ((QQUser)localObject2).mUin;
    localObject2 = ry.a(RqdApplication.n());
    int i = 0;
    while (i < sz.a().k.a())
    {
      QQUser localQQUser = sz.a().a(i);
      if (localQQUser.mUin == l2)
      {
        if (localQQUser.mRealUin == 0L) {
          break;
        }
        localObject2 = ((ry)localObject2).a(localQQUser.mRealUin);
        if (localObject2 != null) {
          localObject1 = aac.a((byte[])localObject2);
        }
        break label173;
      }
      i += 1;
    }
    localObject1 = null;
    label173:
    localObject2 = sz.a().c(l2);
    if ((localObject2 != null) && (((QQUser)localObject2).mUin == ((QQUser)localObject2).mRealUin)) {
      paramLong = aac.f(l2);
    } else {
      paramLong = l2;
    }
    long l1;
    if (paramInt2 != 1) {
      l1 = aad.a(1, paramLong);
    } else {
      l1 = 0L;
    }
    qy.a().a(paramInt1, paramInt2, 1, paramLong, (String)localObject1, l1, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        Object localObject2 = new wy();
        ((wy)localObject2).a = paramHandler;
        ((wy)localObject2).c = paramAnonymousra.d;
        ((wy)localObject2).b = paramAnonymousra.d;
        Object localObject3 = localObject2;
        Object localObject1;
        if (paramHandler == 0)
        {
          localObject3 = tb.a();
          td.a();
          ((tb)localObject3).a(l2);
          localObject1 = localObject2;
        }
        for (;;)
        {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            localObject1 = localObject2;
            long l = paramAnonymousra.getLong("uin");
            localObject1 = localObject2;
            if (l != l2)
            {
              localObject1 = localObject2;
              paramAnonymousra = new StringBuilder("uin not match=");
              localObject1 = localObject2;
              paramAnonymousra.append(l);
              localObject1 = localObject2;
              paramAnonymousra.append(":");
              localObject1 = localObject2;
              paramAnonymousra.append(l2);
              localObject1 = localObject2;
              ((wy)localObject2).a(10000, paramAnonymousra.toString(), null);
              return;
            }
            localObject1 = localObject2;
            if (paramHandler == 1)
            {
              localObject1 = localObject2;
              localObject3 = new AbnormalLoginMsgResult(paramAnonymousra);
              localObject1 = localObject2;
              ((wy)localObject2).a = 0;
              paramAnonymousra = (ra)localObject2;
              localObject2 = localObject3;
            }
            else
            {
              localObject1 = localObject2;
              ((tb)localObject3).b = null;
              localObject1 = localObject2;
              ArrayList localArrayList = new ArrayList();
              localObject1 = localObject2;
              if (paramAnonymousra.has("devs"))
              {
                localObject1 = localObject2;
                OnlineDeviceResult localOnlineDeviceResult = new OnlineDeviceResult(paramAnonymousra.getJSONArray("devs"));
                localObject1 = localObject2;
                if (localOnlineDeviceResult.mDevicesList != null)
                {
                  localObject1 = localObject2;
                  localArrayList.addAll(localOnlineDeviceResult.mDevicesList);
                }
                localObject1 = localObject2;
                ((tb)localObject3).b = new OnlineDeviceResult(paramAnonymousra.getJSONArray("devs"));
              }
              localObject1 = localObject2;
              rh.a.a().a(l2, localArrayList);
              localObject1 = localObject2;
              paramAnonymousra = ((tb)localObject3).f.a(paramAnonymousra, l, 1);
              localObject2 = null;
            }
            localObject1 = paramAnonymousra;
            paramAnonymousra.a = 0;
            localObject1 = paramAnonymousra;
            localObject3 = paramAnonymousra;
            if (paramInt3 != null)
            {
              localObject1 = paramAnonymousra;
              localObject3 = paramInt3;
              localObject1 = paramAnonymousra;
              int j = this.d;
              localObject1 = paramAnonymousra;
              if (paramAnonymousra.a != 0) {
                break label463;
              }
              i = 0;
              localObject1 = paramAnonymousra;
              Message.obtain((Handler)localObject3, j, i, 0, localObject2).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
            ((wy)localObject1).a(10020, null, null);
            localObject3 = localObject1;
          }
          sa.a(paramInt3, (wy)localObject3, this.d);
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
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramSafeMsgItem = paramHandler.obtainMessage(3032);
      paramHandler = new wy();
      paramHandler.a(110, null, null);
      paramSafeMsgItem.arg1 = paramHandler.a;
      paramSafeMsgItem.obj = paramHandler;
      paramSafeMsgItem.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().a(paramLong, paramInt1, paramInt2, paramInt3, paramSafeMsgItem.mTypea, paramSafeMsgItem.mTypeb, paramSafeMsgItem.mTypec, SafeMsgItem.a(paramSafeMsgItem.mIP), paramSafeMsgItem.mLoc_country_id, paramSafeMsgItem.mLoc_prov_id, paramSafeMsgItem.mLoc_city_id, paramSafeMsgItem.mTime, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            int i;
            try
            {
              i = paramAnonymousra.getInt("is_priv_ip_user");
            }
            catch (JSONException paramAnonymousra)
            {
              paramAnonymousra.printStackTrace();
              i = -1;
            }
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3032, 0, i, null).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3032);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, final Handler paramHandler)
  {
    qy.a().a(paramLong, paramInt, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 4001);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3054);
      paramHandler = new wy();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().a(paramInt, paramLong, paramString, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {}
        for (;;)
        {
          int i;
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            try
            {
              i = paramAnonymousra.getInt("id");
              paramAnonymousra = paramAnonymousra.getJSONArray("result");
              if (i == 70)
              {
                ta.a().b(paramAnonymousra);
              }
              else if (i == 71)
              {
                ta.a().c(paramAnonymousra);
              }
              else if ((i == 80) && (paramAnonymousra != null) && (paramAnonymousra.length() > 0))
              {
                i = 0;
                if (i < paramAnonymousra.length())
                {
                  JSONObject localJSONObject = paramAnonymousra.getJSONObject(i);
                  if (localJSONObject.getInt("id") == 71)
                  {
                    ta.a().a(localJSONObject);
                    break label217;
                  }
                  localJSONObject.getInt("id");
                  break label217;
                }
              }
              localwy.a = 0;
            }
            catch (JSONException paramAnonymousra)
            {
              localwy.a(201, RqdApplication.n().getString(2131492910), null);
              paramAnonymousra.printStackTrace();
            }
            sa.a(paramHandler, localwy, 3054);
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
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
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3013);
      paramString2 = new wy();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().b(paramLong, paramInt, paramString1, paramString2, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c).getString("sms_prefix");
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3013, 0, 0, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3013);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3012);
      paramString2 = new wy();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().a(paramLong, paramString1, paramString2, paramInt, paramString3, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            JSONObject localJSONObject = new JSONObject();
            String str1 = paramAnonymousra.getString("time1");
            String str2 = paramAnonymousra.getString("time2");
            localJSONObject.put("info", paramAnonymousra.optString("extraInfo"));
            localJSONObject.put("time1", str1);
            localJSONObject.put("time2", str2);
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3012, 0, 0, localJSONObject).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
            localwy.a = 0;
          }
        }
        sa.a(paramHandler, localwy, 3012);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, boolean paramBoolean, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3004);
      paramHandler = new wy();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().a(paramLong, paramInt, paramBoolean, paramString, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 4002);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, final Handler paramHandler)
  {
    if ((paramLong2 == 0L) && (paramLong1 == 0L))
    {
      Object localObject = sz.a().k.b();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3068);
        localObject = new wy();
        ((wy)localObject).a(110, null, null);
        paramHandler.arg1 = ((wy)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong2 = ((QQUser)localObject).mRealUin;
    }
    qy.a().a(paramLong2, paramInt2, paramInt1, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 3068);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, final Handler paramHandler)
  {
    if ((0L == paramLong2) && (paramLong1 == 0L))
    {
      Object localObject = sz.a().k.b();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3075);
        localObject = new wy();
        ((wy)localObject).a(110, null, null);
        paramHandler.arg1 = ((wy)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong2 = ((QQUser)localObject).mRealUin;
    }
    qy.a().c(paramLong2, paramInt, aad.i(), new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            int i = new JSONObject(paramAnonymousra.c).getInt("verify_type");
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3075, 0, -1, Integer.valueOf(i)).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3075);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, String paramString, final Handler paramHandler)
  {
    if ((paramLong2 == 0L) && (paramLong1 == 0L))
    {
      QQUser localQQUser = sz.a().k.b();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3066);
        paramHandler = new wy();
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong2 = localQQUser.mRealUin;
    }
    qy.a().a(paramLong2, paramInt, paramString, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 3066);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, final Handler paramHandler)
  {
    QQUser localQQUser1;
    if (paramLong2 != 0L) {
      localQQUser1 = sz.a().d(paramLong2);
    } else {
      localQQUser1 = null;
    }
    QQUser localQQUser2 = localQQUser1;
    if (localQQUser1 == null) {
      localQQUser2 = sz.a().k.b();
    }
    if ((paramLong1 == 0L) && (localQQUser2 == null))
    {
      paramArrayOfByte = paramHandler.obtainMessage(3058);
      paramHandler = new wy();
      paramHandler.a(110, null, null);
      paramArrayOfByte.arg1 = paramHandler.a;
      paramArrayOfByte.obj = paramHandler;
      paramArrayOfByte.sendToTarget();
      return -1;
    }
    if (paramLong2 != 0L) {
      aac.f(paramLong2);
    } else if (localQQUser2 != null) {
      paramLong2 = localQQUser2.mRealUin;
    }
    qy.a().a(paramLong2, paramLong2, paramInt1, zt.a(paramArrayOfByte), paramInt2, paramInt3, paramInt4, um.d, um.e, um.f, um.h, FaceDetector.IsSupportNeon(), um.g, um.i, um.j, um.k, um.l, um.m, um.n, um.o, vs.d, vs.e, vs.f, aad.i(), new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        int i;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            i = paramAnonymousra.getInt("op_type");
            paramAnonymousra = paramAnonymousra.getJSONArray("no_face_uin_list");
            localwy.a = 0;
            if (paramHandler == null) {
              break label161;
            }
            Message.obtain(paramHandler, 3058, 0, i, paramAnonymousra).sendToTarget();
            return;
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        } else {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            i = paramAnonymousra.getInt("op_type");
            sg localsg = new sg();
            localsg.a = i;
            localsg.b = paramAnonymousra.optInt("is_realname_qualified");
            localwy.d = localsg;
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        label161:
        sa.a(paramHandler, localwy, 3058);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, final Handler paramHandler)
  {
    int j = 3067;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = sz.a().k.b();
      if (localObject == null)
      {
        paramArrayOfByte1 = paramHandler.obtainMessage(3067);
        paramArrayOfByte2 = new wy();
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
    paramLong1 = aac.f(paramLong2);
    label115:
    final int i = j;
    if (paramInt != 1)
    {
      i = j;
      if (paramInt == 3) {
        i = 3078;
      }
    }
    Object localObject = qy.a();
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = null;
    } else {
      paramArrayOfByte1 = zt.a(paramArrayOfByte1);
    }
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = null;
    } else {
      paramArrayOfByte2 = zt.a(paramArrayOfByte2);
    }
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte3 = null;
    } else {
      paramArrayOfByte3 = zt.a(paramArrayOfByte3);
    }
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte4 = null;
    } else {
      paramArrayOfByte4 = zt.a(paramArrayOfByte4);
    }
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte5 = null;
    } else {
      paramArrayOfByte5 = zt.a(paramArrayOfByte5);
    }
    ((qy)localObject).a(paramLong1, paramLong2, paramInt, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, aac.a(RqdApplication.n()), aac.b(RqdApplication.n()), aac.c(RqdApplication.n()), um.f, um.h, um.g, um.i, um.j, um.k, um.l, um.m, um.n, um.o, vs.d, vs.e, vs.f, xt.f, xt.e, xt.h, xt.g, aac.e(RqdApplication.n()), aac.d(RqdApplication.n()), new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = i;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (i == 0) {
          try
          {
            paramAnonymousra = new RealNameRegResult(new JSONObject(paramAnonymousra.c));
            localwy.a = 0;
            if (paramHandler == null) {
              break label134;
            }
            Message.obtain(paramHandler, i, 0, -1, paramAnonymousra).sendToTarget();
            return;
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        } else {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            wd.i = paramAnonymousra.getString("hint_title");
            wd.j = paramAnonymousra.getString("hint_content");
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        label134:
        sa.a(paramHandler, localwy, i);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, String paramString, final Handler paramHandler, boolean paramBoolean)
  {
    if (0L == paramLong2)
    {
      QQUser localQQUser = sz.a().k.b();
      if (paramLong1 == 0L)
      {
        if (localQQUser == null)
        {
          paramString = paramHandler.obtainMessage(3080);
          paramHandler = new wy();
          paramHandler.a(110, null, null);
          paramString.arg1 = paramHandler.a;
          paramString.obj = paramHandler;
          paramString.sendToTarget();
          return -1;
        }
        paramLong2 = localQQUser.mRealUin;
      }
    }
    qy.a().a(paramLong2, paramString, paramBoolean, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 3080);
      }
    });
    return 0;
  }
  
  public final int a(final long paramLong, Handler paramHandler)
  {
    Object localObject = sz.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3000);
      localObject = new wy();
      ((wy)localObject).a(110, null, null);
      paramHandler.arg1 = ((wy)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qy.a().g(paramLong, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            Object localObject = new JSONObject(paramAnonymousra.c);
            long l = ((JSONObject)localObject).getLong("uin");
            if (l != paramLong)
            {
              paramAnonymousra = new StringBuilder("uin not match=");
              paramAnonymousra.append(l);
              paramAnonymousra.append(":");
              paramAnonymousra.append(paramLong);
              localwy.a(10000, paramAnonymousra.toString(), null);
              return;
            }
            localObject = ((JSONObject)localObject).getJSONArray("result");
            ta localta = ta.a();
            if (!localta.a((JSONArray)localObject))
            {
              paramAnonymousra = new StringBuilder("update conf list failed:");
              paramAnonymousra.append(((JSONArray)localObject).toString());
              localwy.a(10000, paramAnonymousra.toString(), null);
              return;
            }
            localObject = new JSONObject();
            ((JSONObject)localObject).put("uin", l);
            ((JSONObject)localObject).put("data", paramAnonymousra.c);
            ((JSONObject)localObject).put("seq_id", "1234");
            ((JSONObject)localObject).put("err", paramAnonymousra.b);
            xb.a("account_lock", ((JSONObject)localObject).toString());
            localta.b.e = true;
            localta.b.f = false;
            localwy.a = 0;
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
            localwy.a = 10020;
          }
        }
        sa.a(this.b, localwy, 3000);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString, int paramInt, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3052);
      paramHandler = new wy();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().c(paramLong, paramString, paramInt, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 3052);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(3060);
      paramHandler = new wy();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().b(paramLong, paramString, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new LoginProtectResult(new JSONObject(paramAnonymousra.c));
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3060, 0, -1, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3060);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramString1 = paramHandler.obtainMessage(3055);
      paramString2 = new wy();
      paramString2.a(110, null, null);
      paramString1.arg1 = paramString2.a;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().a(paramLong, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramString4, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 3055);
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
    qy.a().a(paramLong, arrayOfInt, paramArrayOfString, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 3028);
      }
    });
    return 0;
  }
  
  public final int a(final long paramLong, byte[] paramArrayOfByte, Handler paramHandler)
  {
    qy localqy = qy.a();
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = aac.a(paramArrayOfByte);
    }
    localqy.a(paramLong, paramArrayOfByte, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            long l = Long.parseLong(paramAnonymousra.getString("uin"));
            paramAnonymousra = paramAnonymousra.getString("uin_mask");
            QQUser localQQUser = sz.a().d(paramLong);
            if (localQQUser != null)
            {
              localQQUser.mUin = l;
              localQQUser.mUinMask = paramAnonymousra;
            }
            sz.a().e(paramLong);
            localwy.a = 0;
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(this.b, localwy, 3024);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, byte[] paramArrayOfByte, final Handler paramHandler, int paramInt)
  {
    qy.a().a(paramLong, aac.a(paramArrayOfByte), paramInt, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new DeterminVerifyFactorsResult(new JSONObject(paramAnonymousra.c));
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4003, 0, -1, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 4003);
      }
    });
    return 0;
  }
  
  public final int a(long paramLong, final int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramArrayOfInt1 = paramHandler.obtainMessage(3061);
      paramArrayOfInt2 = new wy();
      paramArrayOfInt2.a(110, null, null);
      paramArrayOfInt1.arg1 = paramArrayOfInt2.a;
      paramArrayOfInt1.obj = paramArrayOfInt2;
      paramArrayOfInt1.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().a(paramLong, paramString, paramArrayOfInt1, paramArrayOfInt2, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            new JSONObject(paramAnonymousra.c).getLong("uin");
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3061, 0, -1, paramArrayOfInt1).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3061);
      }
    });
    return 0;
  }
  
  public final int a(final Handler paramHandler)
  {
    Object localObject1 = RqdApplication.m();
    final vp localvp = new vp();
    localObject1 = ((aaf)localObject1).a(localvp);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((aaf.a)localObject1).b;
    }
    if ((localObject1 != null) && (((aar)localObject1).a != null)) {
      try
      {
        Object localObject2 = ta.a().h.a("key_value");
        localObject1 = new JSONObject((String)((aar)localObject1).a);
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
    qy.a().c(new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            aar localaar = new aar();
            localaar.a = paramAnonymousra.toString();
            RqdApplication.m().a(localvp, localaar);
            localwy.a = 0;
            paramAnonymousra = paramAnonymousra.getJSONObject("data").toString();
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3023, 0, 0, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3023);
      }
    });
    return 0;
  }
  
  public final int a(final Handler paramHandler, final File paramFile, String paramString)
  {
    QQUser localQQUser = sz.a().k.b();
    qy localqy = qy.a();
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
    abj.a();
    localqy.a(paramFile, paramString, l1, l2, abj.e(), new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0)
        {
          paramAnonymousra = new File(paramFile.getAbsolutePath());
          if ((paramAnonymousra.exists()) && (paramAnonymousra.isFile())) {
            zw.a(paramAnonymousra);
          }
          zz.b("debug.file.uploadfiledate").commit();
        }
        sa.a(paramHandler, localwy, 3063);
      }
    });
    return 0;
  }
  
  public final int a(Long paramLong, int paramInt, final Handler paramHandler)
  {
    Long localLong = paramLong;
    if (paramLong.longValue() == 0L)
    {
      paramLong = sz.a().k.b();
      if (paramLong == null)
      {
        paramLong = paramHandler.obtainMessage(3065);
        paramHandler = new wy();
        paramHandler.a(110, null, null);
        paramLong.arg1 = paramHandler.a;
        paramLong.obj = paramHandler;
        paramLong.sendToTarget();
        return -1;
      }
      localLong = Long.valueOf(paramLong.mRealUin);
    }
    qy.a().c(localLong.longValue(), paramInt, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if ((paramAnonymousra.b == 0) || (paramAnonymousra.b == 124)) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            us.d = paramAnonymousra.getString("sms_port");
            us.e = paramAnonymousra.getString("sms_up_code");
            try
            {
              us.f = paramAnonymousra.getString("mobile_sms_prefix");
            }
            catch (Exception paramAnonymousra)
            {
              paramAnonymousra.printStackTrace();
            }
            sa.a(paramHandler, localwy, 3065);
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
      }
    });
    return 0;
  }
  
  public final int a(String paramString)
  {
    tk.b localb = this.a.b;
    localb.a.post(new tk.b.3(localb, paramString));
    return 0;
  }
  
  public final int a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, final Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = sz.a().k.b();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3019);
        paramString2 = new wy();
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mRealUin;
    }
    qy.a().a(paramString1, paramString2, paramInt1, paramLong, paramInt2, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            vm.d = paramAnonymousra.getString("sms_port");
            vm.e = paramAnonymousra.getString("sms_up_code");
            localwy.a = 0;
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3019);
      }
    });
    return 0;
  }
  
  public final int a(String paramString, final Handler paramHandler)
  {
    qy.a().a(paramString, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 3022);
      }
    });
    return 0;
  }
  
  public final int a(JSONArray paramJSONArray, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    qy.a().a(l, paramJSONArray, zn.j(RqdApplication.n()), zn.i(RqdApplication.n()), new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          aad.a(System.currentTimeMillis() / 1000L);
        }
        sa.a(paramHandler, localwy, 4013);
      }
    });
    return 0;
  }
  
  public final int b(final long paramLong, int paramInt, Handler paramHandler)
  {
    QQUser localQQUser = sz.a().c(paramLong);
    if ((localQQUser != null) && (localQQUser.mIsBinded))
    {
      qy.a().a(paramInt, aac.k(), new qy.a()
      {
        public final void a(ra paramAnonymousra)
        {
          wy localwy = new wy();
          localwy.a = paramAnonymousra.b;
          localwy.c = paramAnonymousra.d;
          localwy.b = paramAnonymousra.d;
          if (paramAnonymousra.b == 0) {
            try
            {
              paramAnonymousra = new JSONObject(paramAnonymousra.c);
              long l = paramAnonymousra.getLong("uin");
              if (l != paramLong)
              {
                paramAnonymousra = new StringBuilder("uin not match=");
                paramAnonymousra.append(l);
                paramAnonymousra.append(":");
                paramAnonymousra.append(paramLong);
                localwy.a(10000, paramAnonymousra.toString(), null);
                return;
              }
              sz.a().g();
              if (!sz.a().k.a(l)) {
                localwy.a(10000, "mUserStorage.setCurrentUserByUin failed", null);
              }
              System.currentTimeMillis();
              l = paramAnonymousra.getInt("valid_time");
              sz.a().a(paramLong, l);
              localwy.a = 0;
            }
            catch (JSONException paramAnonymousra)
            {
              paramAnonymousra.printStackTrace();
            }
          } else if ((paramAnonymousra.b != 111) && (paramAnonymousra.b == 270)) {
            try
            {
              Object localObject = new JSONObject(paramAnonymousra.c);
              paramAnonymousra = ((JSONObject)localObject).optString("masked_mobile");
              localObject = ((JSONObject)localObject).optString("mSmsPrefix");
              UpgradeDeterminResult localUpgradeDeterminResult = new UpgradeDeterminResult();
              localUpgradeDeterminResult.mMobileMask = paramAnonymousra;
              localUpgradeDeterminResult.mSmsPrefix = ((String)localObject);
              localwy.d = localUpgradeDeterminResult;
            }
            catch (JSONException paramAnonymousra)
            {
              paramAnonymousra.printStackTrace();
            }
          }
          sa.a(this.b, localwy, 10002);
        }
      });
      return 0;
    }
    a(paramHandler, new wy(), 10002);
    return 0;
  }
  
  public final int b(final long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    qy.a().a(paramLong, paramInt, paramString1, paramString2, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            int i = new JSONObject(paramAnonymousra.c).getInt("bind_mobile_succ");
            if (1 != i) {
              try
              {
                localwy.a(localwy.b);
              }
              catch (Exception paramAnonymousra)
              {
                paramAnonymousra.printStackTrace();
              }
            }
            paramAnonymousra = sz.a().d(paramLong);
            if (paramAnonymousra != null) {
              sz.a().a(paramAnonymousra);
            }
            localwy.a = 0;
            if (this.b != null)
            {
              Message.obtain(this.b, 4004, 0, i, localwy).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(this.b, localwy, 4004);
      }
    });
    return 0;
  }
  
  public final int b(long paramLong, final Handler paramHandler)
  {
    Object localObject = sz.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3001);
      localObject = new wy();
      ((wy)localObject).a(110, null, null);
      paramHandler.arg1 = ((wy)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qy.a().d(paramLong, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c).getJSONArray("result");
            ta.a().d(paramAnonymousra);
            localwy.e = paramAnonymousra;
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
            localwy.a = 10020;
          }
        }
        sa.a(paramHandler, localwy, 3001);
      }
    });
    return 0;
  }
  
  public final int b(long paramLong, String paramString, int paramInt, final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    if (localQQUser == null)
    {
      paramString = paramHandler.obtainMessage(4008);
      paramHandler = new wy();
      paramHandler.a(110, null, null);
      paramString.arg1 = paramHandler.a;
      paramString.obj = paramHandler;
      paramString.sendToTarget();
      return -1;
    }
    paramLong = localQQUser.mUin;
    qy.a().f(paramLong, paramString, paramInt, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            xa.a("freeze result = ".concat(String.valueOf(paramAnonymousra)));
            int i = -1;
            int j;
            try
            {
              j = paramAnonymousra.getInt("sign_status");
              i = j;
              k = paramAnonymousra.getInt("auto_melt_time");
              i = k;
            }
            catch (JSONException paramAnonymousra)
            {
              paramAnonymousra.printStackTrace();
              int k = 0;
              j = i;
              i = k;
            }
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4008, 0, j, Integer.valueOf(i)).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 4008);
      }
    });
    return 0;
  }
  
  public final int b(final Handler paramHandler)
  {
    qy.a().b(new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            vv.a locala = new vv.a();
            locala.a = paramAnonymousra.getInt("is_have_msg");
            if (locala.a == 1)
            {
              locala.b = paramAnonymousra.getString("content");
              locala.c = paramAnonymousra.getLong("uin");
            }
            localwy.a(locala.b);
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3043, 0, -1, locala).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3043);
      }
    });
    return 0;
  }
  
  public final int c()
  {
    qy.a().a(new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        sa.a(paramAnonymousra, localwy);
        sa.a(this.a, localwy, 3003);
      }
    });
    return 0;
  }
  
  public final int c(final long paramLong, int paramInt, Handler paramHandler)
  {
    qy.a().d(paramLong, paramInt, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0)
        {
          long l = paramLong;
          paramAnonymousra = sz.a().d(l);
          if (paramAnonymousra != null) {
            sz.a().a(paramAnonymousra);
          }
          localwy.a = 0;
        }
        sa.a(this.b, localwy, 3074);
      }
    });
    return 0;
  }
  
  public final int c(final long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    qy.a().c(paramLong, paramInt, paramString1, paramString2, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            int i = new JSONObject(paramAnonymousra.c).getInt("bind_mobile_succ");
            if (1 != i) {
              try
              {
                localwy.a(localwy.b);
              }
              catch (Exception paramAnonymousra)
              {
                paramAnonymousra.printStackTrace();
              }
            }
            paramAnonymousra = sz.a().d(paramLong);
            if (paramAnonymousra != null) {
              sz.a().a(paramAnonymousra);
            }
            localwy.a = 0;
            if (this.b != null)
            {
              Message.obtain(this.b, 3026, 0, i, localwy).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(this.b, localwy, 3026);
      }
    });
    return 0;
  }
  
  public final int c(long paramLong, final Handler paramHandler)
  {
    Object localObject = sz.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3004);
      localObject = new wy();
      ((wy)localObject).a(110, null, null);
      paramHandler.arg1 = ((wy)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qy.a().b(paramLong, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            paramAnonymousra = new EvalAccountResult(paramAnonymousra.getJSONObject("result"), paramAnonymousra);
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3004, 0, 0, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3004);
      }
    });
    return 0;
  }
  
  public final int c(final Handler paramHandler)
  {
    QQUser localQQUser = sz.a().k.b();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    qy.a().k(l, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c).optJSONArray("domain_list");
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3062, 0, -1, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3062);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final int paramInt, final Handler paramHandler)
  {
    if (paramLong == -1L)
    {
      localObject = sz.a().k.b();
      if (localObject != null) {
        paramLong = ((QQUser)localObject).mRealUin;
      }
    }
    Object localObject = RqdApplication.n().getResources().getDisplayMetrics();
    qy.a().a(paramLong, paramInt, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).densityDpi, aad.y(), aad.z(), new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0)
        {
          StringBuilder localStringBuilder = null;
          try
          {
            JSONObject localJSONObject = new JSONObject(paramAnonymousra.c);
            int j = localJSONObject.getInt("need_live_detect");
            paramAnonymousra = localStringBuilder;
            if (j == 1)
            {
              paramAnonymousra = localStringBuilder;
              if (localJSONObject.getJSONArray("actions") != null)
              {
                paramAnonymousra = localStringBuilder;
                if (localJSONObject.getJSONArray("actions").length() > 0)
                {
                  int k = localJSONObject.getJSONArray("actions").length();
                  paramAnonymousra = new int[k];
                  int i = 0;
                  while (i < k)
                  {
                    paramAnonymousra[i] = localJSONObject.getJSONArray("actions").getInt(i);
                    localStringBuilder = new StringBuilder("mLiveDetectActions");
                    localStringBuilder.append(paramAnonymousra[i]);
                    xa.a(localStringBuilder.toString());
                    i += 1;
                  }
                  if ((paramInt != 2) && (paramInt != 1))
                  {
                    if (k > 0)
                    {
                      vs.f = paramAnonymousra[0];
                      localStringBuilder = new StringBuilder("sVryAction");
                      localStringBuilder.append(vs.f);
                      xa.a(localStringBuilder.toString());
                    }
                  }
                  else if (k >= 2)
                  {
                    vs.d = paramAnonymousra[0];
                    vs.e = paramAnonymousra[1];
                  }
                }
              }
            }
            try
            {
              xw.n = localJSONObject.getInt("displayangle");
              xw.o = localJSONObject.getInt("imageangle");
              localStringBuilder = new StringBuilder("display angle=");
              localStringBuilder.append(xw.n);
              localStringBuilder.append(",angel2=");
              localStringBuilder.append(xw.o);
              xa.a(localStringBuilder.toString());
              aad.a(localJSONObject);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3082, 0, j, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3082);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final int paramInt, String paramString1, String paramString2, final Handler paramHandler)
  {
    qy.a().d(paramLong, paramInt, paramString1, paramString2, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramAnonymousra.c);
            paramAnonymousra = "";
            if (paramInt == 5) {
              paramAnonymousra = localJSONObject.getString("captcha_sig");
            }
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3072, 0, -1, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3072);
      }
    });
    return 0;
  }
  
  public final int d(long paramLong, final Handler paramHandler)
  {
    Object localObject = sz.a().k.b();
    long l = paramLong;
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3010);
        localObject = new wy();
        ((wy)localObject).a(110, null, null);
        paramHandler.arg1 = ((wy)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    qy.a().a(l, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new MbInfoResult(new JSONObject(paramAnonymousra.c).getJSONArray("mb_list"));
            aal.a().a(paramAnonymousra);
            localwy.e = paramAnonymousra;
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3010, 0, 0, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
            localwy.a = 10020;
          }
        }
        sa.a(paramHandler, localwy, 3010);
      }
    });
    return 0;
  }
  
  public final int e(final long paramLong, Handler paramHandler)
  {
    qy.a().e(paramLong, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            localwy.a = 0;
            QQUser localQQUser = sz.a().c(paramLong);
            if (localQQUser == null)
            {
              localwy.a(10000, null, null);
            }
            else
            {
              localQQUser.mRealUin = paramAnonymousra.getLong("real_uin");
              localQQUser.mMobileMask = paramAnonymousra.getString("mobile");
              localQQUser.verify_sms = paramAnonymousra.optInt("verify_sms");
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(this.b, localwy, 1006);
      }
    });
    return 0;
  }
  
  public final int f(long paramLong, final Handler paramHandler)
  {
    qy.a().i(paramLong, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        sa.a(paramAnonymousra, paramHandler, 3036);
      }
    });
    return 0;
  }
  
  public final int g(long paramLong, final Handler paramHandler)
  {
    Object localObject = sz.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(3064);
      localObject = new wy();
      ((wy)localObject).a(110, null, null);
      paramHandler.arg1 = ((wy)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qy.a().l(paramLong, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new RealNameStatusResult(new JSONObject(paramAnonymousra.c));
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3064, 0, -1, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3064);
      }
    });
    return 0;
  }
  
  public final int h(long paramLong, final Handler paramHandler)
  {
    DisplayMetrics localDisplayMetrics = RqdApplication.n().getResources().getDisplayMetrics();
    qy.a().a(paramLong, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, localDisplayMetrics.densityDpi, aad.y(), aad.z(), new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new RealNameQueryResult(new JSONObject(paramAnonymousra.c));
            StringBuilder localStringBuilder = new StringBuilder("result rebind_type: ");
            localStringBuilder.append(paramAnonymousra.zzb_rebind_type);
            xa.c(localStringBuilder.toString());
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3073, 0, -1, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3073);
      }
    });
    return 0;
  }
  
  public final int i(long paramLong, final Handler paramHandler)
  {
    if (paramLong == -1L)
    {
      localObject = sz.a().k.b();
      if (localObject != null) {
        paramLong = ((QQUser)localObject).mRealUin;
      }
    }
    Object localObject = RqdApplication.n().getResources().getDisplayMetrics();
    qy.a().b(paramLong, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).densityDpi, aad.y(), aad.z(), new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            int i = paramAnonymousra.getInt("need_idcard_detect");
            if (i == 1) {
              try
              {
                to.d = paramAnonymousra.getInt("displayangle");
                to.e = paramAnonymousra.getInt("imageangle");
                paramAnonymousra = new StringBuilder("plain angle=");
                paramAnonymousra.append(to.d);
                paramAnonymousra.append(",angel2=");
                paramAnonymousra.append(to.e);
                xa.a(paramAnonymousra.toString());
              }
              catch (Exception paramAnonymousra)
              {
                paramAnonymousra.printStackTrace();
              }
            }
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 3083, 0, i, null).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 3083);
      }
    });
    return 0;
  }
  
  public final int j(long paramLong, final Handler paramHandler)
  {
    Object localObject = sz.a().k.b();
    if (localObject == null)
    {
      paramHandler = paramHandler.obtainMessage(4007);
      localObject = new wy();
      ((wy)localObject).a(110, null, null);
      paramHandler.arg1 = ((wy)localObject).a;
      paramHandler.obj = localObject;
      paramHandler.sendToTarget();
      return -1;
    }
    paramLong = ((QQUser)localObject).mUin;
    qy.a().n(paramLong, new qy.a()
    {
      public final void a(ra paramAnonymousra)
      {
        wy localwy = new wy();
        localwy.a = paramAnonymousra.b;
        localwy.c = paramAnonymousra.d;
        localwy.b = paramAnonymousra.d;
        if (paramAnonymousra.b == 0) {
          try
          {
            paramAnonymousra = new JSONObject(paramAnonymousra.c);
            xa.a("freeze result = ".concat(String.valueOf(paramAnonymousra)));
            paramAnonymousra = new FreezeStatusResult(paramAnonymousra);
            localwy.a = 0;
            if (paramHandler != null)
            {
              Message.obtain(paramHandler, 4007, 0, -1, paramAnonymousra).sendToTarget();
              return;
            }
          }
          catch (JSONException paramAnonymousra)
          {
            paramAnonymousra.printStackTrace();
          }
        }
        sa.a(paramHandler, localwy, 4007);
      }
    });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sa
 * JD-Core Version:    0.7.0.1
 */