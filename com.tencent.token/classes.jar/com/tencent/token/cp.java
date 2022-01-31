package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.token.global.f;
import com.tencent.token.utils.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class cp
{
  public static String c = new String("");
  public static int d = 2101344;
  private static cp j;
  public String a;
  public f b;
  public WtloginListener e = new cq(this);
  private WtloginHelper f;
  private Handler g;
  private Timer h;
  private Object i;
  private boolean k = false;
  private long l;
  private int m;
  private int n = 1;
  
  private cp(Context paramContext)
  {
    this.f = new WtloginHelper(paramContext);
    this.f.SetTimeOut(5000);
    util.LOGCAT_OUT = false;
    this.f.SetListener(this.e);
    this.f.SetImgType(4);
    this.h = new Timer();
    this.i = new Object();
    this.b = new f();
  }
  
  public static cp a(Context paramContext)
  {
    if (j == null) {
      j = new cp(paramContext);
    }
    return j;
  }
  
  public static byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.int16_to_buf(arrayOfByte, 0, paramInt);
    util.int16_to_buf(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public int a(Activity paramActivity, long paramLong, Handler paramHandler)
  {
    try
    {
      this.f.quickLogin(paramActivity, paramLong, this.n, u.b, a(paramLong));
      this.g = paramHandler;
      return -1;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public int a(Activity paramActivity, long paramLong, Handler paramHandler, String paramString)
  {
    try
    {
      WtloginHelper.QuickLoginParam localQuickLoginParam = new WtloginHelper.QuickLoginParam();
      localQuickLoginParam.sigMap = 192;
      localQuickLoginParam.appid = paramLong;
      localQuickLoginParam.userAccount = paramString;
      localQuickLoginParam.forceWebLogin = true;
      localQuickLoginParam.isUserAccountLocked = true;
      this.f.quickLogin(paramActivity, paramLong, this.n, u.b, localQuickLoginParam);
      this.g = paramHandler;
      return -1;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public int a(String paramString, Handler paramHandler)
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
  
  public int a(String paramString, Handler paramHandler, long paramLong)
  {
    try
    {
      this.l = paramLong;
      Handler localHandler = this.g;
      if (localHandler == null) {
        try
        {
          this.h.cancel();
          this.f.GetStWithoutPasswd(paramString, paramLong, paramLong, this.n, d, new WUserSigInfo());
          this.g = paramHandler;
          this.h = new Timer();
          this.h.schedule(new cr(this), 30000L);
          return 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      return -1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int a(String paramString, Handler paramHandler, long paramLong, int paramInt)
  {
    this.g = null;
    this.m = paramInt;
    return a(paramString, paramHandler, paramLong);
  }
  
  public int a(String paramString, byte[] paramArrayOfByte, Handler paramHandler)
  {
    if (this.g == null)
    {
      this.h.cancel();
      this.f.CheckPictureAndGetSt(paramString, paramArrayOfByte, new WUserSigInfo());
      this.g = paramHandler;
      this.h = new Timer();
      this.h.schedule(new cs(this), 30000L);
      return 0;
    }
    return -1;
  }
  
  public int a(String paramString1, byte[] paramArrayOfByte, Handler paramHandler, String paramString2, long paramLong)
  {
    if (this.g == null)
    {
      this.h.cancel();
      paramString2 = this.f;
      WUserSigInfo localWUserSigInfo = new WUserSigInfo();
      paramString2.VerifyCode(paramString1, paramLong, true, paramArrayOfByte, new int[0], 1, localWUserSigInfo);
      this.g = paramHandler;
      this.h = new Timer();
      try
      {
        this.h.schedule(new ct(this), 30000L);
        return 0;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  public int a(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2, Handler paramHandler, long paramLong)
  {
    if (this.g == null)
    {
      this.h.cancel();
      if (paramArrayOfByte2 == null)
      {
        paramArrayOfByte2 = new ArrayList();
        paramArrayOfByte2.add(a(8, paramString2.getBytes()));
      }
      for (;;)
      {
        this.f.CloseCode(paramString1, paramLong, paramArrayOfByte1, 1, paramArrayOfByte2, new WUserSigInfo());
        this.g = paramHandler;
        this.h = new Timer();
        try
        {
          this.h.schedule(new cu(this), 30000L);
          return 0;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(a(1, paramArrayOfByte2));
          localArrayList.add(a(8, paramString2.getBytes()));
          paramArrayOfByte2 = localArrayList;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    return -1;
  }
  
  public long a()
  {
    if (this.a != null) {
      return this.f.GetAppidFromUrl(this.a);
    }
    return 0L;
  }
  
  public WtloginHelper.QuickLoginParam a(long paramLong)
  {
    WtloginHelper.QuickLoginParam localQuickLoginParam = new WtloginHelper.QuickLoginParam();
    localQuickLoginParam.sigMap = 192;
    localQuickLoginParam.appid = paramLong;
    return localQuickLoginParam;
  }
  
  public void a(Intent paramIntent)
  {
    this.f.onQuickLoginActivityResultData(a(523005419L), paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    return this.f.IsWtLoginUrl(paramString);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    return this.f.ClearUserLoginData(paramString, paramLong).booleanValue();
  }
  
  public byte[] a(WUserSigInfo paramWUserSigInfo)
  {
    return WtloginHelper.GetTicketSig(paramWUserSigInfo, 64);
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean b(String paramString, long paramLong)
  {
    return this.f.IsNeedLoginWithPasswd(paramString, paramLong).booleanValue();
  }
  
  public byte[] b()
  {
    return this.f.GetGuid();
  }
  
  public byte[] b(long paramLong)
  {
    Ticket localTicket = this.f.GetLocalTicket("" + paramLong, 523005419L, 64);
    if (localTicket != null) {
      return localTicket._sig;
    }
    return null;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public WloginSimpleInfo c(String paramString)
  {
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.f.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    return localWloginSimpleInfo;
  }
  
  public byte[] d(String paramString)
  {
    return this.f.GetPictureData(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cp
 * JD-Core Version:    0.7.0.1
 */