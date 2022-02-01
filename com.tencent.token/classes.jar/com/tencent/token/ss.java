package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import btmsdkobf.ea;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class ss
{
  public static String g = new String("");
  public static int h = 2101344;
  private static ss k;
  public WtloginHelper a = new WtloginHelper(paramContext, new PrivacyListener()
  {
    public final String getAndroidID(Context paramAnonymousContext)
    {
      return xw.b(paramAnonymousContext);
    }
    
    public final String getBssid(Context paramAnonymousContext)
    {
      return null;
    }
    
    public final String getDeviceModel()
    {
      return xw.a();
    }
    
    public final String getImsi(Context paramAnonymousContext)
    {
      return xw.a(paramAnonymousContext);
    }
    
    public final String getMac(Context paramAnonymousContext)
    {
      return ea.j(paramAnonymousContext);
    }
    
    public final String getSsid(Context paramAnonymousContext)
    {
      return null;
    }
  });
  public Handler b;
  public Timer c;
  public String d;
  public boolean e = false;
  public xt f;
  public WtloginListener i = new WtloginListener()
  {
    private void a(int paramAnonymousInt, ErrMsg arg2, String paramAnonymousString, long paramAnonymousLong)
    {
      if (paramAnonymousInt != 0)
      {
        ss.this.f.a(paramAnonymousInt, ???.getMessage(), ???.getMessage());
        ss.this.f.d = ???;
      }
      else
      {
        ??? = ss.b(ss.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong, 64);
        if ((ss.this.f != null) && (??? != null))
        {
          ss.this.f.d = ???._sig;
          ss.this.f.a = 0;
        }
      }
      ss.c(ss.this);
      synchronized (ss.g)
      {
        ss.g.notifyAll();
        return;
      }
    }
    
    public final void OnCheckPictureAndGetSt(String paramAnonymousString, byte[] arg2, WUserSigInfo paramAnonymousWUserSigInfo, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      int i = ss.d(ss.this);
      ss.e(ss.this);
      synchronized (ss.f(ss.this))
      {
        ss.g(ss.this).cancel();
        if (ss.a(ss.this) == null)
        {
          xv.c("onCheckPictureAndGetSt, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = ss.a(ss.this).obtainMessage(4099);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        if (paramAnonymousInt != 0)
        {
          paramAnonymousString = new Bundle();
          paramAnonymousString.putString("loginerror", paramAnonymousErrMsg.getMessage());
          paramAnonymousWUserSigInfo.setData(paramAnonymousString);
        }
        else
        {
          if (i != 0) {
            paramAnonymousString = ss.b(ss.this).GetLocalTicket(paramAnonymousString, ss.i(ss.this), i);
          } else {
            paramAnonymousString = ss.b(ss.this).GetLocalTicket(paramAnonymousString, ss.i(ss.this), 64);
          }
          if (paramAnonymousString != null)
          {
            paramAnonymousWUserSigInfo.obj = paramAnonymousString._sig;
            paramAnonymousString = new Bundle();
            paramAnonymousString.putLong("appid", ss.i(ss.this));
            paramAnonymousWUserSigInfo.setData(paramAnonymousString);
          }
        }
        ss.a(ss.this).sendMessage(paramAnonymousWUserSigInfo);
        ss.a(ss.this, null);
        return;
      }
    }
    
    public final void OnCloseCode(String arg1, byte[] paramAnonymousArrayOfByte1, long paramAnonymousLong, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt)
    {
      synchronized (ss.f(ss.this))
      {
        ss.g(ss.this).cancel();
        if (ss.a(ss.this) == null)
        {
          xv.c("onCloseCode, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = ss.a(ss.this).obtainMessage(4102);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("appname", paramAnonymousArrayOfByte1);
        localBundle.putLong("scantime", paramAnonymousLong);
        localBundle.putByteArray("scanerror", paramAnonymousArrayOfByte2);
        paramAnonymousWUserSigInfo.setData(localBundle);
        ss.a(ss.this).sendMessage(paramAnonymousWUserSigInfo);
        ss.a(ss.this, null);
        return;
      }
    }
    
    public final void OnException(ErrMsg paramAnonymousErrMsg, int paramAnonymousInt, WUserSigInfo arg3)
    {
      ??? = new StringBuilder("Wtlogin exception ");
      ???.append(paramAnonymousErrMsg.getMessage());
      xv.c(???.toString());
      ss.e(ss.this);
      synchronized (ss.f(ss.this))
      {
        ss.g(ss.this).cancel();
        if (ss.a(ss.this) == null)
        {
          xv.c("onVerifyCode, handler is null");
          return;
        }
        Message localMessage = ss.a(ss.this).obtainMessage(4104);
        localMessage.arg1 = paramAnonymousInt;
        Bundle localBundle = new Bundle();
        localBundle.putString("exception", paramAnonymousErrMsg.getMessage());
        localMessage.setData(localBundle);
        ss.a(ss.this).sendMessage(localMessage);
        ss.a(ss.this, null);
        return;
      }
    }
    
    public final void OnGetStWithPasswd(String paramAnonymousString1, long paramAnonymousLong1, int paramAnonymousInt1, long paramAnonymousLong2, String arg7, WUserSigInfo paramAnonymousWUserSigInfo, int paramAnonymousInt2, ErrMsg paramAnonymousErrMsg)
    {
      paramAnonymousInt1 = ss.d(ss.this);
      ss.e(ss.this);
      synchronized (ss.f(ss.this))
      {
        ss.g(ss.this).cancel();
        if (ss.h(ss.this))
        {
          a(paramAnonymousInt2, paramAnonymousErrMsg, paramAnonymousString1, paramAnonymousLong1);
          return;
        }
        if (ss.a(ss.this) == null)
        {
          xv.c("onGetStWithPasswd, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = new StringBuilder();
        paramAnonymousWUserSigInfo.append(this);
        paramAnonymousWUserSigInfo.append("getMessage----");
        paramAnonymousWUserSigInfo.append(paramAnonymousErrMsg.getMessage());
        paramAnonymousWUserSigInfo.append("\ndwAppid");
        paramAnonymousWUserSigInfo.append(paramAnonymousLong1);
        xv.c(paramAnonymousWUserSigInfo.toString());
        paramAnonymousWUserSigInfo = new StringBuilder();
        paramAnonymousWUserSigInfo.append(this);
        paramAnonymousWUserSigInfo.append("getOtherinfo----");
        paramAnonymousWUserSigInfo.append(paramAnonymousErrMsg.getOtherinfo());
        paramAnonymousWUserSigInfo.append("\ndwAppid");
        paramAnonymousWUserSigInfo.append(paramAnonymousLong1);
        xv.c(paramAnonymousWUserSigInfo.toString());
        paramAnonymousWUserSigInfo = ss.a(ss.this).obtainMessage(4098);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt2;
        if (paramAnonymousInt2 != 0)
        {
          paramAnonymousString1 = new Bundle();
          paramAnonymousString1.putString("loginerror", paramAnonymousErrMsg.getMessage());
          paramAnonymousString1.putString("loginurl", paramAnonymousErrMsg.getOtherinfo());
          paramAnonymousWUserSigInfo.setData(paramAnonymousString1);
        }
        else
        {
          if (paramAnonymousInt1 != 0) {
            paramAnonymousString1 = ss.b(ss.this).GetLocalTicket(paramAnonymousString1, ss.i(ss.this), paramAnonymousInt1);
          } else {
            paramAnonymousString1 = ss.b(ss.this).GetLocalTicket(paramAnonymousString1, ss.i(ss.this), 64);
          }
          if (paramAnonymousString1 != null) {
            paramAnonymousWUserSigInfo.obj = paramAnonymousString1._sig;
          }
        }
        ss.a(ss.this).sendMessage(paramAnonymousWUserSigInfo);
        ss.a(ss.this, null);
        return;
      }
    }
    
    public final void OnGetStWithoutPasswd(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, long paramAnonymousLong3, WUserSigInfo arg9, int paramAnonymousInt2, ErrMsg paramAnonymousErrMsg)
    {
      paramAnonymousInt1 = ss.d(ss.this);
      ss.e(ss.this);
      synchronized (ss.f(ss.this))
      {
        ss.g(ss.this).cancel();
        if (ss.h(ss.this))
        {
          a(paramAnonymousInt2, paramAnonymousErrMsg, paramAnonymousString, paramAnonymousLong1);
          return;
        }
        if (ss.a(ss.this) == null)
        {
          xv.c("onGetStWithoutPasswd, handler is null");
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("getMessage----");
        ((StringBuilder)localObject).append(paramAnonymousErrMsg.getMessage());
        ((StringBuilder)localObject).append("\ndwSrcAppid");
        ((StringBuilder)localObject).append(paramAnonymousLong1);
        xv.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("getOtherinfo----");
        ((StringBuilder)localObject).append(paramAnonymousErrMsg.getOtherinfo());
        ((StringBuilder)localObject).append("\ndwSrcAppid");
        ((StringBuilder)localObject).append(paramAnonymousLong1);
        xv.c(((StringBuilder)localObject).toString());
        localObject = ss.a(ss.this).obtainMessage(4097);
        ((Message)localObject).arg1 = paramAnonymousInt2;
        if (paramAnonymousInt2 != 0)
        {
          paramAnonymousString = new Bundle();
          paramAnonymousString.putString("loginerror", paramAnonymousErrMsg.getMessage());
          paramAnonymousString.putString("loginurl", paramAnonymousErrMsg.getOtherinfo());
          ((Message)localObject).setData(paramAnonymousString);
        }
        else
        {
          if (paramAnonymousInt1 != 0) {
            paramAnonymousString = ss.b(ss.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong1, paramAnonymousInt1);
          } else {
            paramAnonymousString = ss.b(ss.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong1, 64);
          }
          if (paramAnonymousString != null) {
            ((Message)localObject).obj = paramAnonymousString._sig;
          }
        }
        ss.a(ss.this).sendMessage((Message)localObject);
        ss.a(ss.this, null);
        return;
      }
    }
    
    public final void OnInit(int paramAnonymousInt)
    {
      xv.b("Wtlogin init result ".concat(String.valueOf(paramAnonymousInt)));
    }
    
    public final void OnRefreshPictureData(String arg1, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      synchronized (ss.f(ss.this))
      {
        ss.g(ss.this).cancel();
        if (ss.a(ss.this) == null)
        {
          xv.c("onRefreshPictureData, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = ss.a(ss.this).obtainMessage(4100);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        if (paramAnonymousInt != 0)
        {
          paramAnonymousArrayOfByte = new Bundle();
          paramAnonymousArrayOfByte.putString("loginerror", paramAnonymousErrMsg.getMessage());
          paramAnonymousWUserSigInfo.setData(paramAnonymousArrayOfByte);
        }
        ss.a(ss.this).sendMessage(paramAnonymousWUserSigInfo);
        ss.a(ss.this, null);
        return;
      }
    }
    
    public final void OnVerifyCode(String arg1, byte[] paramAnonymousArrayOfByte1, long paramAnonymousLong, List<byte[]> paramAnonymousList, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt)
    {
      synchronized (ss.f(ss.this))
      {
        ss.g(ss.this).cancel();
        if (ss.a(ss.this) == null)
        {
          xv.c("onVerifyCode, handler is null");
          return;
        }
        paramAnonymousList = ss.a(ss.this).obtainMessage(4101);
        paramAnonymousList.arg1 = paramAnonymousInt;
        paramAnonymousWUserSigInfo = new Bundle();
        paramAnonymousWUserSigInfo.putByteArray("appname", paramAnonymousArrayOfByte1);
        paramAnonymousWUserSigInfo.putLong("scantime", paramAnonymousLong);
        paramAnonymousWUserSigInfo.putByteArray("scanerror", paramAnonymousArrayOfByte2);
        paramAnonymousList.setData(paramAnonymousWUserSigInfo);
        ss.a(ss.this).sendMessage(paramAnonymousList);
        ss.a(ss.this, null);
        return;
      }
    }
    
    public final void onQuickLogin(String paramAnonymousString, WtloginHelper.QuickLoginParam paramAnonymousQuickLoginParam, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      for (;;)
      {
        try
        {
          paramAnonymousErrMsg = new StringBuilder("onQuickLogin");
          paramAnonymousErrMsg.append(paramAnonymousInt);
          paramAnonymousErrMsg.append("mUIHandler!=null:");
          if (ss.a(ss.this) != null)
          {
            bool = true;
            paramAnonymousErrMsg.append(bool);
            xv.a(paramAnonymousErrMsg.toString());
            if (paramAnonymousInt != 0)
            {
              if (true == util.shouldKick(paramAnonymousInt)) {
                ss.b(ss.this).ClearUserLoginData(paramAnonymousString, 523005419L);
              }
            }
            else
            {
              paramAnonymousQuickLoginParam = ss.a(paramAnonymousQuickLoginParam.userSigInfo);
              if (ss.a(ss.this) != null)
              {
                paramAnonymousErrMsg = ss.a(ss.this).obtainMessage(4109);
                paramAnonymousErrMsg.arg1 = paramAnonymousInt;
                Bundle localBundle = new Bundle();
                localBundle.putByteArray("sig", paramAnonymousQuickLoginParam);
                localBundle.putString("uin", paramAnonymousString);
                paramAnonymousErrMsg.setData(localBundle);
                ss.a(ss.this).sendMessage(paramAnonymousErrMsg);
                ss.a(ss.this, null);
              }
            }
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          paramAnonymousString.printStackTrace();
          return;
        }
        boolean bool = false;
      }
    }
  };
  private Object j;
  private long l;
  private int m;
  private int n = 1;
  
  private ss(Context paramContext)
  {
    this.a.SetTimeOut(5000);
    util.LOGCAT_OUT = false;
    this.a.SetListener(this.i);
    this.a.SetImgType(4);
    this.c = new Timer();
    this.j = new Object();
    this.f = new xt();
  }
  
  public static ss a(Context paramContext)
  {
    if (k == null) {
      k = new ss(paramContext);
    }
    return k;
  }
  
  private static byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.int16_to_buf(arrayOfByte, 0, paramInt);
    util.int16_to_buf(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] a(WUserSigInfo paramWUserSigInfo)
  {
    return WtloginHelper.GetTicketSig(paramWUserSigInfo, 64);
  }
  
  private static WtloginHelper.QuickLoginParam b()
  {
    WtloginHelper.QuickLoginParam localQuickLoginParam = new WtloginHelper.QuickLoginParam();
    localQuickLoginParam.sigMap = 192;
    localQuickLoginParam.appid = 523005419L;
    return localQuickLoginParam;
  }
  
  public final int a(Activity paramActivity, Handler paramHandler)
  {
    try
    {
      this.a.quickLogin(paramActivity, 523005419L, this.n, aaw.b, b());
      this.b = paramHandler;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return -1;
  }
  
  public final int a(final Activity paramActivity, final Handler paramHandler, final String paramString)
  {
    ace.a(paramActivity, "即将离开QQ安全中心，打开QQ登录网页", new aib.a()
    {
      public final void a(boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          return;
        }
        try
        {
          WtloginHelper.QuickLoginParam localQuickLoginParam = new WtloginHelper.QuickLoginParam();
          localQuickLoginParam.sigMap = 192;
          localQuickLoginParam.appid = this.a;
          localQuickLoginParam.userAccount = paramString;
          localQuickLoginParam.forceWebLogin = true;
          localQuickLoginParam.isUserAccountLocked = true;
          ss.b(ss.this).quickLogin(paramActivity, this.a, ss.j(ss.this), aaw.b, localQuickLoginParam);
          ss.a(ss.this, paramHandler);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
    return -1;
  }
  
  public final int a(String paramString, Handler paramHandler)
  {
    if (this.b == null)
    {
      this.c.cancel();
      this.a.RefreshPictureData(paramString, new WUserSigInfo());
      this.b = paramHandler;
      return 0;
    }
    return -1;
  }
  
  public final int a(String paramString, Handler paramHandler, long paramLong)
  {
    try
    {
      this.l = paramLong;
      Handler localHandler = this.b;
      if (localHandler == null)
      {
        try
        {
          this.c.cancel();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.a.GetStWithoutPasswd(paramString, paramLong, paramLong, this.n, h, new WUserSigInfo());
        this.b = paramHandler;
        this.c = new Timer();
        this.c.schedule(new TimerTask()
        {
          public final void run()
          {
            ss.this.i.OnGetStWithoutPasswd(null, 0L, 0L, 0, 0L, null, 8192, new ErrMsg());
          }
        }, 30000L);
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public final int a(String paramString, Handler paramHandler, long paramLong, int paramInt)
  {
    this.b = null;
    this.m = paramInt;
    return a(paramString, paramHandler, paramLong);
  }
  
  public final int a(String paramString, byte[] paramArrayOfByte, Handler paramHandler)
  {
    if (this.b == null)
    {
      this.c.cancel();
      WtloginHelper localWtloginHelper = this.a;
      WUserSigInfo localWUserSigInfo = new WUserSigInfo();
      localWtloginHelper.VerifyCode(paramString, 523005419L, true, paramArrayOfByte, new int[0], 1, localWUserSigInfo);
      this.b = paramHandler;
      this.c = new Timer();
      try
      {
        this.c.schedule(new TimerTask()
        {
          public final void run()
          {
            ss.this.i.OnVerifyCode(null, null, 0L, null, new WUserSigInfo(), null, 8192);
          }
        }, 30000L);
        return 0;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return 0;
      }
    }
    return -1;
  }
  
  public final int a(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2, Handler paramHandler)
  {
    if (this.b == null)
    {
      this.c.cancel();
      if (paramArrayOfByte2 == null)
      {
        paramArrayOfByte2 = new ArrayList();
        paramArrayOfByte2.add(a(8, paramString2.getBytes()));
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(a(1, paramArrayOfByte2));
        localArrayList.add(a(8, paramString2.getBytes()));
        paramArrayOfByte2 = localArrayList;
      }
      this.a.CloseCode(paramString1, 523005419L, paramArrayOfByte1, 1, paramArrayOfByte2, new WUserSigInfo());
      this.b = paramHandler;
      this.c = new Timer();
      try
      {
        this.c.schedule(new TimerTask()
        {
          public final void run()
          {
            ss.this.i.OnCloseCode(null, null, 0L, new WUserSigInfo(), null, 8192);
          }
        }, 30000L);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return 0;
    }
    return -1;
  }
  
  public final long a()
  {
    String str = this.d;
    if (str != null) {
      return this.a.GetAppidFromUrl(str);
    }
    return 0L;
  }
  
  public final WloginSimpleInfo a(String paramString)
  {
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.a.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    return localWloginSimpleInfo;
  }
  
  public final void a(Intent paramIntent)
  {
    this.a.onQuickLoginActivityResultData(b(), paramIntent);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    return this.a.IsNeedLoginWithPasswd(paramString, paramLong).booleanValue();
  }
  
  public final byte[] a(long paramLong)
  {
    Ticket localTicket = this.a.GetLocalTicket(String.valueOf(paramLong), 523005419L, 64);
    if (localTicket != null) {
      return localTicket._sig;
    }
    return null;
  }
  
  public final boolean b(String paramString)
  {
    return this.a.ClearUserLoginData(paramString, 523005419L).booleanValue();
  }
  
  public final byte[] c(String paramString)
  {
    return this.a.GetPictureData(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ss
 * JD-Core Version:    0.7.0.1
 */