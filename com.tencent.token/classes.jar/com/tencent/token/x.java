package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.token.global.d;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.WtloginSigExpireActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public final class x
{
  public static String c = new String("");
  public static int d = 2101344;
  private static x j;
  public String a;
  public d b;
  public WtloginListener e = new y(this);
  private WtloginHelper f;
  private Handler g;
  private Timer h;
  private Object i;
  private boolean k = false;
  private long l;
  private int m;
  private int n = 1;
  
  private x(Context paramContext)
  {
    this.f = new WtloginHelper(paramContext);
    this.f.SetTimeOut(5000);
    util.LOGCAT_OUT = false;
    this.f.SetListener(this.e);
    this.h = new Timer();
    this.i = new Object();
    this.b = new d((byte)0);
  }
  
  public static x a(Context paramContext)
  {
    if (j == null) {
      j = new x(paramContext);
    }
    return j;
  }
  
  public final int a(String paramString, Handler paramHandler)
  {
    this.m = 32;
    return a(paramString, paramHandler, 523005419L);
  }
  
  public final int a(String paramString, Handler paramHandler, long paramLong)
  {
    this.l = paramLong;
    if (this.g == null)
    {
      this.h.cancel();
      this.f.GetStWithoutPasswd(paramString, paramLong, paramLong, this.n, d, new WUserSigInfo());
      this.g = paramHandler;
      this.h = new Timer();
      this.h.schedule(new z(this), 30000L);
      return 0;
    }
    return -1;
  }
  
  public final int a(String paramString1, String paramString2, long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return -1;
    }
    this.f.GetStWithPasswd(paramString1, paramLong, this.n, d, paramString2, new WUserSigInfo());
    return 0;
  }
  
  public final int a(String paramString1, String paramString2, Handler paramHandler, long paramLong)
  {
    this.m = 4096;
    return b(paramString1, paramString2, paramHandler, paramLong);
  }
  
  public final int a(String paramString, byte[] paramArrayOfByte, Handler paramHandler)
  {
    if (this.g == null)
    {
      this.h.cancel();
      this.f.CheckPictureAndGetSt(paramString, paramArrayOfByte, new WUserSigInfo());
      this.g = paramHandler;
      this.h = new Timer();
      this.h.schedule(new ab(this), 30000L);
      return 0;
    }
    return -1;
  }
  
  public final int a(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2, Handler paramHandler)
  {
    if (this.g == null)
    {
      this.h.cancel();
      Object localObject;
      if (paramArrayOfByte2 == null)
      {
        paramArrayOfByte2 = new ArrayList();
        paramString2 = paramString2.getBytes();
        localObject = new byte[paramString2.length + 4];
        util.int16_to_buf((byte[])localObject, 0, 8);
        util.int16_to_buf((byte[])localObject, 2, paramString2.length);
        System.arraycopy(paramString2, 0, localObject, 4, paramString2.length);
        paramArrayOfByte2.add(localObject);
      }
      for (;;)
      {
        this.f.CloseCode(paramString1, 523005419L, paramArrayOfByte1, 1, paramArrayOfByte2, new WUserSigInfo());
        this.g = paramHandler;
        this.h = new Timer();
        this.h.schedule(new ad(this), 30000L);
        return 0;
        localObject = new ArrayList();
        byte[] arrayOfByte = new byte[paramArrayOfByte2.length + 4];
        util.int16_to_buf(arrayOfByte, 0, 1);
        util.int16_to_buf(arrayOfByte, 2, paramArrayOfByte2.length);
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 4, paramArrayOfByte2.length);
        ((List)localObject).add(arrayOfByte);
        paramArrayOfByte2 = paramString2.getBytes();
        paramString2 = new byte[paramArrayOfByte2.length + 4];
        util.int16_to_buf(paramString2, 0, 8);
        util.int16_to_buf(paramString2, 2, paramArrayOfByte2.length);
        System.arraycopy(paramArrayOfByte2, 0, paramString2, 4, paramArrayOfByte2.length);
        ((List)localObject).add(paramString2);
        paramArrayOfByte2 = (byte[])localObject;
      }
    }
    return -1;
  }
  
  public final void a()
  {
    this.k = true;
  }
  
  public final void a(BaseActivity paramBaseActivity, String paramString, Handler paramHandler)
  {
    if (!this.f.IsNeedLoginWithPasswd(paramString, 523005419L).booleanValue())
    {
      this.m = 4096;
      a(paramString, paramHandler, 523005419L);
      return;
    }
    paramBaseActivity.startActivity(new Intent(paramBaseActivity, WtloginSigExpireActivity.class));
    paramBaseActivity.finish();
  }
  
  public final void a(BaseActivity paramBaseActivity, String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (!this.f.IsNeedLoginWithPasswd(paramString, 523005419L).booleanValue())
    {
      this.m = 64;
      a(paramString, paramHandler, 523005419L);
    }
    do
    {
      return;
      if (!paramBoolean)
      {
        paramHandler.sendMessage(paramHandler.obtainMessage(4106));
        return;
      }
      paramBaseActivity.startActivity(new Intent(paramBaseActivity, WtloginSigExpireActivity.class));
    } while (!paramBoolean);
    paramBaseActivity.finish();
  }
  
  public final boolean a(String paramString)
  {
    return this.f.IsWtLoginUrl(paramString);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    return this.f.ClearUserLoginData(paramString, paramLong).booleanValue();
  }
  
  public final byte[] a(long paramLong)
  {
    Ticket localTicket = this.f.GetLocalTicket("" + paramLong, 523005419L, 64);
    if (localTicket != null) {
      return localTicket._sig;
    }
    return null;
  }
  
  public final int b(String paramString, Handler paramHandler)
  {
    if (this.g == null)
    {
      this.h.cancel();
      this.f.RefreshPictureData(paramString, new WUserSigInfo());
      this.g = paramHandler;
      return 0;
    }
    return -1;
  }
  
  public final int b(String paramString1, String paramString2, Handler paramHandler, long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return -1;
      this.l = paramLong;
    } while (this.g != null);
    this.h.cancel();
    this.f.GetStWithPasswd(paramString1, paramLong, this.n, d, paramString2, new WUserSigInfo());
    this.g = paramHandler;
    this.h = new Timer();
    this.h.schedule(new aa(this), 30000L);
    return 0;
  }
  
  public final int b(String paramString, byte[] paramArrayOfByte, Handler paramHandler)
  {
    if (this.g == null)
    {
      this.h.cancel();
      WtloginHelper localWtloginHelper = this.f;
      WUserSigInfo localWUserSigInfo = new WUserSigInfo();
      localWtloginHelper.VerifyCode(paramString, 523005419L, true, paramArrayOfByte, new int[0], 1, localWUserSigInfo);
      this.g = paramHandler;
      this.h = new Timer();
      try
      {
        this.h.schedule(new ac(this), 30000L);
        return 0;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  public final long b()
  {
    if (this.a != null) {
      return this.f.GetAppidFromUrl(this.a);
    }
    return 0L;
  }
  
  public final void b(String paramString)
  {
    this.a = paramString;
  }
  
  public final boolean b(String paramString, long paramLong)
  {
    return this.f.IsNeedLoginWithPasswd(paramString, paramLong).booleanValue();
  }
  
  public final WloginSimpleInfo c(String paramString)
  {
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.f.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    return localWloginSimpleInfo;
  }
  
  public final byte[] c()
  {
    return this.f.GetGuid();
  }
  
  public final String d()
  {
    return this.a;
  }
  
  public final byte[] d(String paramString)
  {
    return this.f.GetPictureData(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.x
 * JD-Core Version:    0.7.0.1
 */