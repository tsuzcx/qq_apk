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

public class ca
{
  public static String c = new String("");
  public static int d = 2101344;
  private static ca j;
  public String a;
  public e b;
  public WtloginListener e = new WtloginListener()
  {
    private void a(int paramAnonymousInt, ErrMsg arg2, String paramAnonymousString, long paramAnonymousLong)
    {
      if (paramAnonymousInt != 0)
      {
        ca.this.b.a(paramAnonymousInt, ???.getMessage(), ???.getMessage());
        ca.this.b.d = ???;
      }
      else
      {
        ??? = ca.b(ca.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong, 64);
        if ((ca.this.b != null) && (??? != null))
        {
          ca.this.b.d = ???._sig;
          ca.this.b.c();
        }
      }
      ca.a(ca.this, false);
      synchronized (ca.c)
      {
        ca.c.notifyAll();
        return;
      }
    }
    
    public void OnCheckPictureAndGetSt(String paramAnonymousString, byte[] arg2, WUserSigInfo paramAnonymousWUserSigInfo, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      int i = ca.c(ca.this);
      ca.a(ca.this, 0);
      synchronized (ca.d(ca.this))
      {
        ca.e(ca.this).cancel();
        if (ca.a(ca.this) == null)
        {
          g.c("onCheckPictureAndGetSt, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = ca.a(ca.this).obtainMessage(4099);
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
            paramAnonymousString = ca.b(ca.this).GetLocalTicket(paramAnonymousString, ca.g(ca.this), i);
          } else {
            paramAnonymousString = ca.b(ca.this).GetLocalTicket(paramAnonymousString, ca.g(ca.this), 64);
          }
          if (paramAnonymousString != null)
          {
            paramAnonymousWUserSigInfo.obj = paramAnonymousString._sig;
            paramAnonymousString = new Bundle();
            paramAnonymousString.putLong("appid", ca.g(ca.this));
            paramAnonymousWUserSigInfo.setData(paramAnonymousString);
          }
        }
        ca.a(ca.this).sendMessage(paramAnonymousWUserSigInfo);
        ca.a(ca.this, null);
        return;
      }
    }
    
    public void OnCloseCode(String arg1, byte[] paramAnonymousArrayOfByte1, long paramAnonymousLong, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt)
    {
      synchronized (ca.d(ca.this))
      {
        ca.e(ca.this).cancel();
        if (ca.a(ca.this) == null)
        {
          g.c("onCloseCode, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = ca.a(ca.this).obtainMessage(4102);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("appname", paramAnonymousArrayOfByte1);
        localBundle.putLong("scantime", paramAnonymousLong);
        localBundle.putByteArray("scanerror", paramAnonymousArrayOfByte2);
        paramAnonymousWUserSigInfo.setData(localBundle);
        ca.a(ca.this).sendMessage(paramAnonymousWUserSigInfo);
        ca.a(ca.this, null);
        return;
      }
    }
    
    public void OnException(ErrMsg paramAnonymousErrMsg, int paramAnonymousInt, WUserSigInfo arg3)
    {
      ??? = new StringBuilder();
      ???.append("Wtlogin exception ");
      ???.append(paramAnonymousErrMsg.getMessage());
      g.c(???.toString());
      ca.a(ca.this, 0);
      synchronized (ca.d(ca.this))
      {
        ca.e(ca.this).cancel();
        if (ca.a(ca.this) == null)
        {
          g.c("onVerifyCode, handler is null");
          return;
        }
        Message localMessage = ca.a(ca.this).obtainMessage(4104);
        localMessage.arg1 = paramAnonymousInt;
        Bundle localBundle = new Bundle();
        localBundle.putString("exception", paramAnonymousErrMsg.getMessage());
        localMessage.setData(localBundle);
        ca.a(ca.this).sendMessage(localMessage);
        ca.a(ca.this, null);
        return;
      }
    }
    
    public void OnGetStWithPasswd(String paramAnonymousString1, long paramAnonymousLong1, int paramAnonymousInt1, long paramAnonymousLong2, String arg7, WUserSigInfo paramAnonymousWUserSigInfo, int paramAnonymousInt2, ErrMsg paramAnonymousErrMsg)
    {
      paramAnonymousInt1 = ca.c(ca.this);
      ca.a(ca.this, 0);
      synchronized (ca.d(ca.this))
      {
        ca.e(ca.this).cancel();
        if (ca.f(ca.this))
        {
          a(paramAnonymousInt2, paramAnonymousErrMsg, paramAnonymousString1, paramAnonymousLong1);
          return;
        }
        if (ca.a(ca.this) == null)
        {
          g.c("onGetStWithPasswd, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = new StringBuilder();
        paramAnonymousWUserSigInfo.append(this);
        paramAnonymousWUserSigInfo.append("getMessage----");
        paramAnonymousWUserSigInfo.append(paramAnonymousErrMsg.getMessage());
        paramAnonymousWUserSigInfo.append("\ndwAppid");
        paramAnonymousWUserSigInfo.append(paramAnonymousLong1);
        g.c(paramAnonymousWUserSigInfo.toString());
        paramAnonymousWUserSigInfo = new StringBuilder();
        paramAnonymousWUserSigInfo.append(this);
        paramAnonymousWUserSigInfo.append("getOtherinfo----");
        paramAnonymousWUserSigInfo.append(paramAnonymousErrMsg.getOtherinfo());
        paramAnonymousWUserSigInfo.append("\ndwAppid");
        paramAnonymousWUserSigInfo.append(paramAnonymousLong1);
        g.c(paramAnonymousWUserSigInfo.toString());
        paramAnonymousWUserSigInfo = ca.a(ca.this).obtainMessage(4098);
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
            paramAnonymousString1 = ca.b(ca.this).GetLocalTicket(paramAnonymousString1, ca.g(ca.this), paramAnonymousInt1);
          } else {
            paramAnonymousString1 = ca.b(ca.this).GetLocalTicket(paramAnonymousString1, ca.g(ca.this), 64);
          }
          if (paramAnonymousString1 != null) {
            paramAnonymousWUserSigInfo.obj = paramAnonymousString1._sig;
          }
        }
        ca.a(ca.this).sendMessage(paramAnonymousWUserSigInfo);
        ca.a(ca.this, null);
        return;
      }
    }
    
    public void OnGetStWithoutPasswd(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, long paramAnonymousLong3, WUserSigInfo arg9, int paramAnonymousInt2, ErrMsg paramAnonymousErrMsg)
    {
      paramAnonymousInt1 = ca.c(ca.this);
      ca.a(ca.this, 0);
      synchronized (ca.d(ca.this))
      {
        ca.e(ca.this).cancel();
        if (ca.f(ca.this))
        {
          a(paramAnonymousInt2, paramAnonymousErrMsg, paramAnonymousString, paramAnonymousLong1);
          return;
        }
        if (ca.a(ca.this) == null)
        {
          g.c("onGetStWithoutPasswd, handler is null");
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("getMessage----");
        ((StringBuilder)localObject).append(paramAnonymousErrMsg.getMessage());
        ((StringBuilder)localObject).append("\ndwSrcAppid");
        ((StringBuilder)localObject).append(paramAnonymousLong1);
        g.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("getOtherinfo----");
        ((StringBuilder)localObject).append(paramAnonymousErrMsg.getOtherinfo());
        ((StringBuilder)localObject).append("\ndwSrcAppid");
        ((StringBuilder)localObject).append(paramAnonymousLong1);
        g.c(((StringBuilder)localObject).toString());
        localObject = ca.a(ca.this).obtainMessage(4097);
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
            paramAnonymousString = ca.b(ca.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong1, paramAnonymousInt1);
          } else {
            paramAnonymousString = ca.b(ca.this).GetLocalTicket(paramAnonymousString, paramAnonymousLong1, 64);
          }
          if (paramAnonymousString != null) {
            ((Message)localObject).obj = paramAnonymousString._sig;
          }
        }
        ca.a(ca.this).sendMessage((Message)localObject);
        ca.a(ca.this, null);
        return;
      }
    }
    
    public void OnInit(int paramAnonymousInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Wtlogin init result ");
      localStringBuilder.append(paramAnonymousInt);
      g.b(localStringBuilder.toString());
    }
    
    public void OnRefreshPictureData(String arg1, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      synchronized (ca.d(ca.this))
      {
        ca.e(ca.this).cancel();
        if (ca.a(ca.this) == null)
        {
          g.c("onRefreshPictureData, handler is null");
          return;
        }
        paramAnonymousWUserSigInfo = ca.a(ca.this).obtainMessage(4100);
        paramAnonymousWUserSigInfo.arg1 = paramAnonymousInt;
        if (paramAnonymousInt != 0)
        {
          paramAnonymousArrayOfByte = new Bundle();
          paramAnonymousArrayOfByte.putString("loginerror", paramAnonymousErrMsg.getMessage());
          paramAnonymousWUserSigInfo.setData(paramAnonymousArrayOfByte);
        }
        ca.a(ca.this).sendMessage(paramAnonymousWUserSigInfo);
        ca.a(ca.this, null);
        return;
      }
    }
    
    public void OnVerifyCode(String arg1, byte[] paramAnonymousArrayOfByte1, long paramAnonymousLong, List<byte[]> paramAnonymousList, WUserSigInfo paramAnonymousWUserSigInfo, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt)
    {
      synchronized (ca.d(ca.this))
      {
        ca.e(ca.this).cancel();
        if (ca.a(ca.this) == null)
        {
          g.c("onVerifyCode, handler is null");
          return;
        }
        paramAnonymousList = ca.a(ca.this).obtainMessage(4101);
        paramAnonymousList.arg1 = paramAnonymousInt;
        paramAnonymousWUserSigInfo = new Bundle();
        paramAnonymousWUserSigInfo.putByteArray("appname", paramAnonymousArrayOfByte1);
        paramAnonymousWUserSigInfo.putLong("scantime", paramAnonymousLong);
        paramAnonymousWUserSigInfo.putByteArray("scanerror", paramAnonymousArrayOfByte2);
        paramAnonymousList.setData(paramAnonymousWUserSigInfo);
        ca.a(ca.this).sendMessage(paramAnonymousList);
        ca.a(ca.this, null);
        return;
      }
    }
    
    public void onQuickLogin(String paramAnonymousString, WtloginHelper.QuickLoginParam paramAnonymousQuickLoginParam, int paramAnonymousInt, ErrMsg paramAnonymousErrMsg)
    {
      for (;;)
      {
        try
        {
          paramAnonymousErrMsg = new StringBuilder();
          paramAnonymousErrMsg.append("onQuickLogin");
          paramAnonymousErrMsg.append(paramAnonymousInt);
          paramAnonymousErrMsg.append("mUIHandler!=null:");
          if (ca.a(ca.this) == null) {
            break label198;
          }
          bool = true;
          paramAnonymousErrMsg.append(bool);
          g.a(paramAnonymousErrMsg.toString());
          if (paramAnonymousInt != 0)
          {
            if (true == util.shouldKick(paramAnonymousInt)) {
              ca.b(ca.this).ClearUserLoginData(paramAnonymousString, 523005419L);
            }
          }
          else
          {
            paramAnonymousQuickLoginParam = ca.this.a(paramAnonymousQuickLoginParam.userSigInfo);
            if (ca.a(ca.this) != null)
            {
              paramAnonymousErrMsg = ca.a(ca.this).obtainMessage(4109);
              paramAnonymousErrMsg.arg1 = paramAnonymousInt;
              Bundle localBundle = new Bundle();
              localBundle.putByteArray("sig", paramAnonymousQuickLoginParam);
              localBundle.putString("uin", paramAnonymousString);
              paramAnonymousErrMsg.setData(localBundle);
              ca.a(ca.this).sendMessage(paramAnonymousErrMsg);
              ca.a(ca.this, null);
              return;
            }
          }
        }
        catch (Exception paramAnonymousString)
        {
          paramAnonymousString.printStackTrace();
        }
        return;
        label198:
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
  
  private ca(Context paramContext)
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
  
  public static ca a(Context paramContext)
  {
    if (j == null) {
      j = new ca(paramContext);
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
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return -1;
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
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return -1;
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
      if (localHandler == null)
      {
        try
        {
          this.h.cancel();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.f.GetStWithoutPasswd(paramString, paramLong, paramLong, this.n, d, new WUserSigInfo());
        this.g = paramHandler;
        this.h = new Timer();
        this.h.schedule(new TimerTask()
        {
          public void run()
          {
            ca.this.e.OnGetStWithoutPasswd(null, 0L, 0L, 0, 0L, null, 8192, new ErrMsg());
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
          ca.this.e.OnCheckPictureAndGetSt(null, null, null, 8192, new ErrMsg());
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
            ca.this.e.OnVerifyCode(null, null, 0L, null, new WUserSigInfo(), null, 8192);
          }
        }, 30000L);
        return 0;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return 0;
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
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(a(1, paramArrayOfByte2));
        localArrayList.add(a(8, paramString2.getBytes()));
        paramArrayOfByte2 = localArrayList;
      }
      this.f.CloseCode(paramString1, paramLong, paramArrayOfByte1, 1, paramArrayOfByte2, new WUserSigInfo());
      this.g = paramHandler;
      this.h = new Timer();
      try
      {
        this.h.schedule(new TimerTask()
        {
          public void run()
          {
            ca.this.e.OnCloseCode(null, null, 0L, new WUserSigInfo(), null, 8192);
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
  
  public long a()
  {
    String str = this.a;
    if (str != null) {
      return this.f.GetAppidFromUrl(str);
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
    Object localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    localObject = ((WtloginHelper)localObject).GetLocalTicket(localStringBuilder.toString(), 523005419L, 64);
    if (localObject != null) {
      return ((Ticket)localObject)._sig;
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
 * Qualified Name:     com.tencent.token.ca
 * JD-Core Version:    0.7.0.1
 */