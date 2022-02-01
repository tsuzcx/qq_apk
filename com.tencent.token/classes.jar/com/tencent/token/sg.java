package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class sg
{
  public static String g = new String("");
  public static int h = 2101344;
  private static sg k;
  public WtloginHelper a;
  public Handler b;
  public Timer c;
  public String d;
  public boolean e = false;
  public xh f;
  public WtloginListener i = new WtloginListener()
  {
    private void a(int paramAnonymousInt, ErrMsg arg2, String paramAnonymousString, long paramAnonymousLong)
    {
      if (paramAnonymousInt != 0)
      {
        sg.this.f.a(paramAnonymousInt, ???.getMessage(), ???.getMessage());
        sg.this.f.d = ???;
      }
      else
      {
        ??? = sg.b(sg.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong, 64);
        if ((sg.this.f != null) && (??? != null))
        {
          sg.this.f.d = ???._sig;
          sg.this.f.a = 0;
        }
      }
      sg.d(sg.this);
      synchronized (sg.g)
      {
        sg.g.notifyAll();
        return;
      }
    }
    
    public final void OnCheckPictureAndGetSt(String paramAnonymousString, byte[] arg2, WUserSigInfo paramAnonymousWUserSigInfo, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      int i = sg.e(sg.this);
      sg.f(sg.this);
      synchronized (sg.g(sg.this))
      {
        sg.h(sg.this).cancel();
        if (sg.a(sg.this) == null)
        {
          xj.c("onCheckPictureAndGetSt, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = sg.a(sg.this).obtainMessage(4099);
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
            paramAnonymousString = sg.b(sg.this).GetLocalTicket(paramAnonymousString, sg.j(sg.this), i);
          } else {
            paramAnonymousString = sg.b(sg.this).GetLocalTicket(paramAnonymousString, sg.j(sg.this), 64);
          }
          if (paramAnonymousString != null)
          {
            paramAnonymousWUserSigInfo.obj = paramAnonymousString._sig;
            paramAnonymousString = new Bundle();
            paramAnonymousString.putLong("appid", sg.j(sg.this));
            paramAnonymousWUserSigInfo.setData(paramAnonymousString);
          }
        }
        sg.a(sg.this).sendMessage(paramAnonymousWUserSigInfo);
        sg.c(sg.this);
        return;
      }
    }
    
    public final void OnCloseCode(String arg1, byte[] paramAnonymousArrayOfByte1, long paramAnonymousLong, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt)
    {
      synchronized (sg.g(sg.this))
      {
        sg.h(sg.this).cancel();
        if (sg.a(sg.this) == null)
        {
          xj.c("onCloseCode, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = sg.a(sg.this).obtainMessage(4102);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("appname", paramAnonymousArrayOfByte1);
        localBundle.putLong("scantime", paramAnonymousLong);
        localBundle.putByteArray("scanerror", paramAnonymousArrayOfByte2);
        paramAnonymousWUserSigInfo.setData(localBundle);
        sg.a(sg.this).sendMessage(paramAnonymousWUserSigInfo);
        sg.c(sg.this);
        return;
      }
    }
    
    public final void OnException(ErrMsg paramAnonymousErrMsg, int paramAnonymousInt, WUserSigInfo arg3)
    {
      ??? = new StringBuilder("Wtlogin exception ");
      ???.append(paramAnonymousErrMsg.getMessage());
      xj.c(???.toString());
      sg.f(sg.this);
      synchronized (sg.g(sg.this))
      {
        sg.h(sg.this).cancel();
        if (sg.a(sg.this) == null)
        {
          xj.c("onVerifyCode, handler is null");
          return;
        }
        Message localMessage = sg.a(sg.this).obtainMessage(4104);
        localMessage.arg1 = paramAnonymousInt;
        Bundle localBundle = new Bundle();
        localBundle.putString("exception", paramAnonymousErrMsg.getMessage());
        localMessage.setData(localBundle);
        sg.a(sg.this).sendMessage(localMessage);
        sg.c(sg.this);
        return;
      }
    }
    
    public final void OnGetStWithPasswd(String paramAnonymousString1, long paramAnonymousLong1, int paramAnonymousInt1, long paramAnonymousLong2, String arg7, WUserSigInfo paramAnonymousWUserSigInfo, int paramAnonymousInt2, ErrMsg paramAnonymousErrMsg)
    {
      paramAnonymousInt1 = sg.e(sg.this);
      sg.f(sg.this);
      synchronized (sg.g(sg.this))
      {
        sg.h(sg.this).cancel();
        if (sg.i(sg.this))
        {
          a(paramAnonymousInt2, paramAnonymousErrMsg, paramAnonymousString1, paramAnonymousLong1);
          return;
        }
        if (sg.a(sg.this) == null)
        {
          xj.c("onGetStWithPasswd, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = new StringBuilder();
        paramAnonymousWUserSigInfo.append(this);
        paramAnonymousWUserSigInfo.append("getMessage----");
        paramAnonymousWUserSigInfo.append(paramAnonymousErrMsg.getMessage());
        paramAnonymousWUserSigInfo.append("\ndwAppid");
        paramAnonymousWUserSigInfo.append(paramAnonymousLong1);
        xj.c(paramAnonymousWUserSigInfo.toString());
        paramAnonymousWUserSigInfo = new StringBuilder();
        paramAnonymousWUserSigInfo.append(this);
        paramAnonymousWUserSigInfo.append("getOtherinfo----");
        paramAnonymousWUserSigInfo.append(paramAnonymousErrMsg.getOtherinfo());
        paramAnonymousWUserSigInfo.append("\ndwAppid");
        paramAnonymousWUserSigInfo.append(paramAnonymousLong1);
        xj.c(paramAnonymousWUserSigInfo.toString());
        paramAnonymousWUserSigInfo = sg.a(sg.this).obtainMessage(4098);
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
            paramAnonymousString1 = sg.b(sg.this).GetLocalTicket(paramAnonymousString1, sg.j(sg.this), paramAnonymousInt1);
          } else {
            paramAnonymousString1 = sg.b(sg.this).GetLocalTicket(paramAnonymousString1, sg.j(sg.this), 64);
          }
          if (paramAnonymousString1 != null) {
            paramAnonymousWUserSigInfo.obj = paramAnonymousString1._sig;
          }
        }
        sg.a(sg.this).sendMessage(paramAnonymousWUserSigInfo);
        sg.c(sg.this);
        return;
      }
    }
    
    public final void OnGetStWithoutPasswd(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, long paramAnonymousLong3, WUserSigInfo arg9, int paramAnonymousInt2, ErrMsg paramAnonymousErrMsg)
    {
      paramAnonymousInt1 = sg.e(sg.this);
      sg.f(sg.this);
      synchronized (sg.g(sg.this))
      {
        sg.h(sg.this).cancel();
        if (sg.i(sg.this))
        {
          a(paramAnonymousInt2, paramAnonymousErrMsg, paramAnonymousString, paramAnonymousLong1);
          return;
        }
        if (sg.a(sg.this) == null)
        {
          xj.c("onGetStWithoutPasswd, handler is null");
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("getMessage----");
        ((StringBuilder)localObject).append(paramAnonymousErrMsg.getMessage());
        ((StringBuilder)localObject).append("\ndwSrcAppid");
        ((StringBuilder)localObject).append(paramAnonymousLong1);
        xj.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("getOtherinfo----");
        ((StringBuilder)localObject).append(paramAnonymousErrMsg.getOtherinfo());
        ((StringBuilder)localObject).append("\ndwSrcAppid");
        ((StringBuilder)localObject).append(paramAnonymousLong1);
        xj.c(((StringBuilder)localObject).toString());
        localObject = sg.a(sg.this).obtainMessage(4097);
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
            paramAnonymousString = sg.b(sg.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong1, paramAnonymousInt1);
          } else {
            paramAnonymousString = sg.b(sg.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong1, 64);
          }
          if (paramAnonymousString != null) {
            ((Message)localObject).obj = paramAnonymousString._sig;
          }
        }
        sg.a(sg.this).sendMessage((Message)localObject);
        sg.c(sg.this);
        return;
      }
    }
    
    public final void OnInit(int paramAnonymousInt)
    {
      xj.b("Wtlogin init result ".concat(String.valueOf(paramAnonymousInt)));
    }
    
    public final void OnRefreshPictureData(String arg1, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      synchronized (sg.g(sg.this))
      {
        sg.h(sg.this).cancel();
        if (sg.a(sg.this) == null)
        {
          xj.c("onRefreshPictureData, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = sg.a(sg.this).obtainMessage(4100);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        if (paramAnonymousInt != 0)
        {
          paramAnonymousArrayOfByte = new Bundle();
          paramAnonymousArrayOfByte.putString("loginerror", paramAnonymousErrMsg.getMessage());
          paramAnonymousWUserSigInfo.setData(paramAnonymousArrayOfByte);
        }
        sg.a(sg.this).sendMessage(paramAnonymousWUserSigInfo);
        sg.c(sg.this);
        return;
      }
    }
    
    public final void OnVerifyCode(String arg1, byte[] paramAnonymousArrayOfByte1, long paramAnonymousLong, List<byte[]> paramAnonymousList, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt)
    {
      synchronized (sg.g(sg.this))
      {
        sg.h(sg.this).cancel();
        if (sg.a(sg.this) == null)
        {
          xj.c("onVerifyCode, handler is null");
          return;
        }
        paramAnonymousList = sg.a(sg.this).obtainMessage(4101);
        paramAnonymousList.arg1 = paramAnonymousInt;
        paramAnonymousWUserSigInfo = new Bundle();
        paramAnonymousWUserSigInfo.putByteArray("appname", paramAnonymousArrayOfByte1);
        paramAnonymousWUserSigInfo.putLong("scantime", paramAnonymousLong);
        paramAnonymousWUserSigInfo.putByteArray("scanerror", paramAnonymousArrayOfByte2);
        paramAnonymousList.setData(paramAnonymousWUserSigInfo);
        sg.a(sg.this).sendMessage(paramAnonymousList);
        sg.c(sg.this);
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
          if (sg.a(sg.this) != null)
          {
            bool = true;
            paramAnonymousErrMsg.append(bool);
            xj.a(paramAnonymousErrMsg.toString());
            if (paramAnonymousInt != 0)
            {
              if (true == util.shouldKick(paramAnonymousInt)) {
                sg.b(sg.this).ClearUserLoginData(paramAnonymousString, 523005419L);
              }
            }
            else
            {
              paramAnonymousQuickLoginParam = sg.a(paramAnonymousQuickLoginParam.userSigInfo);
              if (sg.a(sg.this) != null)
              {
                paramAnonymousErrMsg = sg.a(sg.this).obtainMessage(4109);
                paramAnonymousErrMsg.arg1 = paramAnonymousInt;
                Bundle localBundle = new Bundle();
                localBundle.putByteArray("sig", paramAnonymousQuickLoginParam);
                localBundle.putString("uin", paramAnonymousString);
                paramAnonymousErrMsg.setData(localBundle);
                sg.a(sg.this).sendMessage(paramAnonymousErrMsg);
                sg.c(sg.this);
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
  
  private sg(Context paramContext)
  {
    this.a = new WtloginHelper(paramContext);
    this.a.SetTimeOut(5000);
    util.LOGCAT_OUT = false;
    this.a.SetListener(this.i);
    this.a.SetImgType(4);
    this.c = new Timer();
    this.j = new Object();
    this.f = new xh();
  }
  
  public static sg a(Context paramContext)
  {
    if (k == null) {
      k = new sg(paramContext);
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
      this.a.quickLogin(paramActivity, 523005419L, this.n, aam.b, b());
      this.b = paramHandler;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return -1;
  }
  
  public final int a(Activity paramActivity, Handler paramHandler, String paramString)
  {
    try
    {
      WtloginHelper.QuickLoginParam localQuickLoginParam = new WtloginHelper.QuickLoginParam();
      localQuickLoginParam.sigMap = 192;
      localQuickLoginParam.appid = 523005419L;
      localQuickLoginParam.userAccount = paramString;
      localQuickLoginParam.forceWebLogin = true;
      localQuickLoginParam.isUserAccountLocked = true;
      this.a.quickLogin(paramActivity, 523005419L, this.n, aam.b, localQuickLoginParam);
      this.b = paramHandler;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
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
            sg.this.i.OnGetStWithoutPasswd(null, 0L, 0L, 0, 0L, null, 8192, new ErrMsg());
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
            sg.this.i.OnVerifyCode(null, null, 0L, null, new WUserSigInfo(), null, 8192);
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
            sg.this.i.OnCloseCode(null, null, 0L, new WUserSigInfo(), null, 8192);
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
 * Qualified Name:     com.tencent.token.sg
 * JD-Core Version:    0.7.0.1
 */