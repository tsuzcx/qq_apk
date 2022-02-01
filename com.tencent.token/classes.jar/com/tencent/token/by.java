package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.j;
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

public class by
{
  public static String c = new String("");
  public static int d = 2101344;
  private static by j;
  public String a;
  public e b;
  public WtloginListener e = new WtloginListener()
  {
    private void a(int paramAnonymousInt, ErrMsg arg2, String paramAnonymousString, long paramAnonymousLong)
    {
      if (paramAnonymousInt != 0)
      {
        by.this.b.a(paramAnonymousInt, ???.getMessage(), ???.getMessage());
        by.this.b.d = ???;
      }
      for (;;)
      {
        by.a(by.this, false);
        synchronized (by.c)
        {
          by.c.notifyAll();
          return;
          ??? = by.b(by.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong, 64);
          if ((by.this.b == null) || (??? == null)) {
            continue;
          }
          by.this.b.d = ???._sig;
          by.this.b.c();
        }
      }
    }
    
    public void OnCheckPictureAndGetSt(String paramAnonymousString, byte[] arg2, WUserSigInfo paramAnonymousWUserSigInfo, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      int i = by.c(by.this);
      by.a(by.this, 0);
      label223:
      for (;;)
      {
        synchronized (by.d(by.this))
        {
          by.e(by.this).cancel();
          if (by.a(by.this) == null)
          {
            g.c("onCheckPictureAndGetSt, handler is null");
            return;
          }
          paramAnonymousWUserSigInfo = by.a(by.this).obtainMessage(4099);
          paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
          if (paramAnonymousInt != 0)
          {
            paramAnonymousString = new Bundle();
            paramAnonymousString.putString("loginerror", paramAnonymousErrMsg.getMessage());
            paramAnonymousWUserSigInfo.setData(paramAnonymousString);
            by.a(by.this).sendMessage(paramAnonymousWUserSigInfo);
            by.a(by.this, null);
            return;
          }
        }
        if (i != 0) {}
        for (paramAnonymousString = by.b(by.this).GetLocalTicket(paramAnonymousString, by.g(by.this), i);; paramAnonymousString = by.b(by.this).GetLocalTicket(paramAnonymousString, by.g(by.this), 64))
        {
          if (paramAnonymousString == null) {
            break label223;
          }
          paramAnonymousWUserSigInfo.obj = paramAnonymousString._sig;
          paramAnonymousString = new Bundle();
          paramAnonymousString.putLong("appid", by.g(by.this));
          paramAnonymousWUserSigInfo.setData(paramAnonymousString);
          break;
        }
      }
    }
    
    public void OnCloseCode(String arg1, byte[] paramAnonymousArrayOfByte1, long paramAnonymousLong, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt)
    {
      synchronized (by.d(by.this))
      {
        by.e(by.this).cancel();
        if (by.a(by.this) == null)
        {
          g.c("onCloseCode, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = by.a(by.this).obtainMessage(4102);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("appname", paramAnonymousArrayOfByte1);
        localBundle.putLong("scantime", paramAnonymousLong);
        localBundle.putByteArray("scanerror", paramAnonymousArrayOfByte2);
        paramAnonymousWUserSigInfo.setData(localBundle);
        by.a(by.this).sendMessage(paramAnonymousWUserSigInfo);
        by.a(by.this, null);
        return;
      }
    }
    
    public void OnException(ErrMsg paramAnonymousErrMsg, int paramAnonymousInt, WUserSigInfo arg3)
    {
      g.c("Wtlogin exception " + paramAnonymousErrMsg.getMessage());
      by.a(by.this, 0);
      synchronized (by.d(by.this))
      {
        by.e(by.this).cancel();
        if (by.a(by.this) == null)
        {
          g.c("onVerifyCode, handler is null");
          return;
        }
        Message localMessage = by.a(by.this).obtainMessage(4104);
        localMessage.arg1 = paramAnonymousInt;
        Bundle localBundle = new Bundle();
        localBundle.putString("exception", paramAnonymousErrMsg.getMessage());
        localMessage.setData(localBundle);
        by.a(by.this).sendMessage(localMessage);
        by.a(by.this, null);
        return;
      }
    }
    
    public void OnGetStWithPasswd(String paramAnonymousString1, long paramAnonymousLong1, int paramAnonymousInt1, long paramAnonymousLong2, String arg7, WUserSigInfo paramAnonymousWUserSigInfo, int paramAnonymousInt2, ErrMsg paramAnonymousErrMsg)
    {
      paramAnonymousInt1 = by.c(by.this);
      by.a(by.this, 0);
      synchronized (by.d(by.this))
      {
        by.e(by.this).cancel();
        if (by.f(by.this))
        {
          a(paramAnonymousInt2, paramAnonymousErrMsg, paramAnonymousString1, paramAnonymousLong1);
          return;
        }
        if (by.a(by.this) == null)
        {
          g.c("onGetStWithPasswd, handler is null");
          return;
        }
      }
      g.c(this + "getMessage----" + paramAnonymousErrMsg.getMessage() + "\ndwAppid" + paramAnonymousLong1);
      g.c(this + "getOtherinfo----" + paramAnonymousErrMsg.getOtherinfo() + "\ndwAppid" + paramAnonymousLong1);
      paramAnonymousWUserSigInfo = by.a(by.this).obtainMessage(4098);
      paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt2;
      if (paramAnonymousInt2 != 0)
      {
        paramAnonymousString1 = new Bundle();
        paramAnonymousString1.putString("loginerror", paramAnonymousErrMsg.getMessage());
        paramAnonymousString1.putString("loginurl", paramAnonymousErrMsg.getOtherinfo());
        paramAnonymousWUserSigInfo.setData(paramAnonymousString1);
      }
      label320:
      for (;;)
      {
        by.a(by.this).sendMessage(paramAnonymousWUserSigInfo);
        by.a(by.this, null);
        return;
        if (paramAnonymousInt1 != 0) {}
        for (paramAnonymousString1 = by.b(by.this).GetLocalTicket(paramAnonymousString1, by.g(by.this), paramAnonymousInt1);; paramAnonymousString1 = by.b(by.this).GetLocalTicket(paramAnonymousString1, by.g(by.this), 64))
        {
          if (paramAnonymousString1 == null) {
            break label320;
          }
          paramAnonymousWUserSigInfo.obj = paramAnonymousString1._sig;
          break;
        }
      }
    }
    
    public void OnGetStWithoutPasswd(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, long paramAnonymousLong3, WUserSigInfo arg9, int paramAnonymousInt2, ErrMsg paramAnonymousErrMsg)
    {
      paramAnonymousInt1 = by.c(by.this);
      by.a(by.this, 0);
      synchronized (by.d(by.this))
      {
        by.e(by.this).cancel();
        if (by.f(by.this))
        {
          a(paramAnonymousInt2, paramAnonymousErrMsg, paramAnonymousString, paramAnonymousLong1);
          return;
        }
        if (by.a(by.this) == null)
        {
          g.c("onGetStWithoutPasswd, handler is null");
          return;
        }
      }
      g.c(this + "getMessage----" + paramAnonymousErrMsg.getMessage() + "\ndwSrcAppid" + paramAnonymousLong1);
      g.c(this + "getOtherinfo----" + paramAnonymousErrMsg.getOtherinfo() + "\ndwSrcAppid" + paramAnonymousLong1);
      Message localMessage = by.a(by.this).obtainMessage(4097);
      localMessage.arg1 = paramAnonymousInt2;
      if (paramAnonymousInt2 != 0)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("loginerror", paramAnonymousErrMsg.getMessage());
        paramAnonymousString.putString("loginurl", paramAnonymousErrMsg.getOtherinfo());
        localMessage.setData(paramAnonymousString);
      }
      label308:
      for (;;)
      {
        by.a(by.this).sendMessage(localMessage);
        by.a(by.this, null);
        return;
        if (paramAnonymousInt1 != 0) {}
        for (paramAnonymousString = by.b(by.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong1, paramAnonymousInt1);; paramAnonymousString = by.b(by.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong1, 64))
        {
          if (paramAnonymousString == null) {
            break label308;
          }
          localMessage.obj = paramAnonymousString._sig;
          break;
        }
      }
    }
    
    public void OnInit(int paramAnonymousInt)
    {
      g.b("Wtlogin init result " + paramAnonymousInt);
    }
    
    public void OnRefreshPictureData(String arg1, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      synchronized (by.d(by.this))
      {
        by.e(by.this).cancel();
        if (by.a(by.this) == null)
        {
          g.c("onRefreshPictureData, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = by.a(by.this).obtainMessage(4100);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        if (paramAnonymousInt != 0)
        {
          paramAnonymousArrayOfByte = new Bundle();
          paramAnonymousArrayOfByte.putString("loginerror", paramAnonymousErrMsg.getMessage());
          paramAnonymousWUserSigInfo.setData(paramAnonymousArrayOfByte);
        }
        by.a(by.this).sendMessage(paramAnonymousWUserSigInfo);
        by.a(by.this, null);
        return;
      }
    }
    
    public void OnVerifyCode(String arg1, byte[] paramAnonymousArrayOfByte1, long paramAnonymousLong, List<byte[]> paramAnonymousList, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt)
    {
      synchronized (by.d(by.this))
      {
        by.e(by.this).cancel();
        if (by.a(by.this) == null)
        {
          g.c("onVerifyCode, handler is null");
          return;
        }
        paramAnonymousList = by.a(by.this).obtainMessage(4101);
        paramAnonymousList.arg1 = paramAnonymousInt;
        paramAnonymousWUserSigInfo = new Bundle();
        paramAnonymousWUserSigInfo.putByteArray("appname", paramAnonymousArrayOfByte1);
        paramAnonymousWUserSigInfo.putLong("scantime", paramAnonymousLong);
        paramAnonymousWUserSigInfo.putByteArray("scanerror", paramAnonymousArrayOfByte2);
        paramAnonymousList.setData(paramAnonymousWUserSigInfo);
        by.a(by.this).sendMessage(paramAnonymousList);
        by.a(by.this, null);
        return;
      }
    }
    
    public void onQuickLogin(String paramAnonymousString, WtloginHelper.QuickLoginParam paramAnonymousQuickLoginParam, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      for (;;)
      {
        try
        {
          paramAnonymousErrMsg = new StringBuilder().append("onQuickLogin").append(paramAnonymousInt).append("mUIHandler!=null:");
          if (by.a(by.this) == null) {
            break label183;
          }
          bool = true;
          g.a(bool);
          if (paramAnonymousInt != 0)
          {
            if (true == util.shouldKick(paramAnonymousInt)) {
              by.b(by.this).ClearUserLoginData(paramAnonymousString, 523005419L);
            }
          }
          else
          {
            paramAnonymousQuickLoginParam = by.this.a(paramAnonymousQuickLoginParam.userSigInfo);
            if (by.a(by.this) != null)
            {
              paramAnonymousErrMsg = by.a(by.this).obtainMessage(4109);
              paramAnonymousErrMsg.arg1 = paramAnonymousInt;
              Bundle localBundle = new Bundle();
              localBundle.putByteArray("sig", paramAnonymousQuickLoginParam);
              localBundle.putString("uin", paramAnonymousString);
              paramAnonymousErrMsg.setData(localBundle);
              by.a(by.this).sendMessage(paramAnonymousErrMsg);
              by.a(by.this, null);
              return;
            }
          }
        }
        catch (Exception paramAnonymousString)
        {
          paramAnonymousString.printStackTrace();
        }
        return;
        label183:
        boolean bool = false;
      }
    }
  };
  private WtloginHelper f;
  private Handler g;
  private Timer h;
  private Object i;
  private boolean k = false;
  private long l;
  private int m;
  private int n = 1;
  
  private by(Context paramContext)
  {
    this.f = new WtloginHelper(paramContext);
    this.f.SetTimeOut(5000);
    util.LOGCAT_OUT = false;
    this.f.SetListener(this.e);
    this.f.SetImgType(4);
    this.h = new Timer();
    this.i = new Object();
    this.b = new e();
  }
  
  public static by a(Context paramContext)
  {
    if (j == null) {
      j = new by(paramContext);
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
      this.f.quickLogin(paramActivity, paramLong, this.n, j.b, a(paramLong));
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
      this.f.quickLogin(paramActivity, paramLong, this.n, j.b, localQuickLoginParam);
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
          this.h.schedule(new TimerTask()
          {
            public void run()
            {
              by.this.e.OnGetStWithoutPasswd(null, 0L, 0L, 0, 0L, null, 8192, new ErrMsg());
            }
          }, 30000L);
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
      this.h.schedule(new TimerTask()
      {
        public void run()
        {
          by.this.e.OnCheckPictureAndGetSt(null, null, null, 8192, new ErrMsg());
        }
      }, 30000L);
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
        this.h.schedule(new TimerTask()
        {
          public void run()
          {
            by.this.e.OnVerifyCode(null, null, 0L, null, new WUserSigInfo(), null, 8192);
          }
        }, 30000L);
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
          this.h.schedule(new TimerTask()
          {
            public void run()
            {
              by.this.e.OnCloseCode(null, null, 0L, new WUserSigInfo(), null, 8192);
            }
          }, 30000L);
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
 * Qualified Name:     com.tencent.token.by
 * JD-Core Version:    0.7.0.1
 */