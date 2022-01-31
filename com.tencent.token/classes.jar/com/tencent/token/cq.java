package com.tencent.token;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import java.util.List;
import java.util.Timer;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class cq
  extends WtloginListener
{
  cq(cp paramcp) {}
  
  private void a(int paramInt, ErrMsg arg2, String paramString, long paramLong)
  {
    if (paramInt != 0)
    {
      this.a.b.a(paramInt, ???.getMessage(), ???.getMessage());
      this.a.b.d = ???;
    }
    for (;;)
    {
      cp.a(this.a, false);
      synchronized (cp.c)
      {
        cp.c.notifyAll();
        return;
        ??? = cp.b(this.a).GetLocalTicket(paramString, paramLong, 64);
        if ((this.a.b == null) || (??? == null)) {
          continue;
        }
        this.a.b.d = ???._sig;
        this.a.b.c();
      }
    }
  }
  
  public void OnCheckPictureAndGetSt(String paramString, byte[] arg2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    int i = cp.c(this.a);
    cp.a(this.a, 0);
    label223:
    for (;;)
    {
      synchronized (cp.d(this.a))
      {
        cp.e(this.a).cancel();
        if (cp.a(this.a) == null)
        {
          h.c("onCheckPictureAndGetSt, handler is null");
          return;
        }
        paramWUserSigInfo = cp.a(this.a).obtainMessage(4099);
        paramWUserSigInfo.arg1 = paramInt;
        if (paramInt != 0)
        {
          paramString = new Bundle();
          paramString.putString("loginerror", paramErrMsg.getMessage());
          paramWUserSigInfo.setData(paramString);
          cp.a(this.a).sendMessage(paramWUserSigInfo);
          cp.a(this.a, null);
          return;
        }
      }
      if (i != 0) {}
      for (paramString = cp.b(this.a).GetLocalTicket(paramString, cp.g(this.a), i);; paramString = cp.b(this.a).GetLocalTicket(paramString, cp.g(this.a), 64))
      {
        if (paramString == null) {
          break label223;
        }
        paramWUserSigInfo.obj = paramString._sig;
        paramString = new Bundle();
        paramString.putLong("appid", cp.g(this.a));
        paramWUserSigInfo.setData(paramString);
        break;
      }
    }
  }
  
  public void OnCloseCode(String arg1, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    synchronized (cp.d(this.a))
    {
      cp.e(this.a).cancel();
      if (cp.a(this.a) == null)
      {
        h.c("onCloseCode, handler is null");
        return;
      }
      paramWUserSigInfo = cp.a(this.a).obtainMessage(4102);
      paramWUserSigInfo.arg1 = paramInt;
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("appname", paramArrayOfByte1);
      localBundle.putLong("scantime", paramLong);
      localBundle.putByteArray("scanerror", paramArrayOfByte2);
      paramWUserSigInfo.setData(localBundle);
      cp.a(this.a).sendMessage(paramWUserSigInfo);
      cp.a(this.a, null);
      return;
    }
  }
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo arg3)
  {
    h.c("Wtlogin exception " + paramErrMsg.getMessage());
    cp.a(this.a, 0);
    synchronized (cp.d(this.a))
    {
      cp.e(this.a).cancel();
      if (cp.a(this.a) == null)
      {
        h.c("onVerifyCode, handler is null");
        return;
      }
      Message localMessage = cp.a(this.a).obtainMessage(4104);
      localMessage.arg1 = paramInt;
      Bundle localBundle = new Bundle();
      localBundle.putString("exception", paramErrMsg.getMessage());
      localMessage.setData(localBundle);
      cp.a(this.a).sendMessage(localMessage);
      cp.a(this.a, null);
      return;
    }
  }
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String arg7, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    paramInt1 = cp.c(this.a);
    cp.a(this.a, 0);
    synchronized (cp.d(this.a))
    {
      cp.e(this.a).cancel();
      if (cp.f(this.a))
      {
        a(paramInt2, paramErrMsg, paramString1, paramLong1);
        return;
      }
      if (cp.a(this.a) == null)
      {
        h.c("onGetStWithPasswd, handler is null");
        return;
      }
    }
    h.c(this + "getMessage----" + paramErrMsg.getMessage() + "\ndwAppid" + paramLong1);
    h.c(this + "getOtherinfo----" + paramErrMsg.getOtherinfo() + "\ndwAppid" + paramLong1);
    paramWUserSigInfo = cp.a(this.a).obtainMessage(4098);
    paramWUserSigInfo.arg1 = paramInt2;
    if (paramInt2 != 0)
    {
      paramString1 = new Bundle();
      paramString1.putString("loginerror", paramErrMsg.getMessage());
      paramString1.putString("loginurl", paramErrMsg.getOtherinfo());
      paramWUserSigInfo.setData(paramString1);
    }
    label320:
    for (;;)
    {
      cp.a(this.a).sendMessage(paramWUserSigInfo);
      cp.a(this.a, null);
      return;
      if (paramInt1 != 0) {}
      for (paramString1 = cp.b(this.a).GetLocalTicket(paramString1, cp.g(this.a), paramInt1);; paramString1 = cp.b(this.a).GetLocalTicket(paramString1, cp.g(this.a), 64))
      {
        if (paramString1 == null) {
          break label320;
        }
        paramWUserSigInfo.obj = paramString1._sig;
        break;
      }
    }
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo arg9, int paramInt2, ErrMsg paramErrMsg)
  {
    paramInt1 = cp.c(this.a);
    cp.a(this.a, 0);
    synchronized (cp.d(this.a))
    {
      cp.e(this.a).cancel();
      if (cp.f(this.a))
      {
        a(paramInt2, paramErrMsg, paramString, paramLong1);
        return;
      }
      if (cp.a(this.a) == null)
      {
        h.c("onGetStWithoutPasswd, handler is null");
        return;
      }
    }
    h.c(this + "getMessage----" + paramErrMsg.getMessage() + "\ndwSrcAppid" + paramLong1);
    h.c(this + "getOtherinfo----" + paramErrMsg.getOtherinfo() + "\ndwSrcAppid" + paramLong1);
    Message localMessage = cp.a(this.a).obtainMessage(4097);
    localMessage.arg1 = paramInt2;
    if (paramInt2 != 0)
    {
      paramString = new Bundle();
      paramString.putString("loginerror", paramErrMsg.getMessage());
      paramString.putString("loginurl", paramErrMsg.getOtherinfo());
      localMessage.setData(paramString);
    }
    label308:
    for (;;)
    {
      cp.a(this.a).sendMessage(localMessage);
      cp.a(this.a, null);
      return;
      if (paramInt1 != 0) {}
      for (paramString = cp.b(this.a).GetLocalTicket(paramString, paramLong1, paramInt1);; paramString = cp.b(this.a).GetLocalTicket(paramString, paramLong1, 64))
      {
        if (paramString == null) {
          break label308;
        }
        localMessage.obj = paramString._sig;
        break;
      }
    }
  }
  
  public void OnInit(int paramInt)
  {
    h.b("Wtlogin init result " + paramInt);
  }
  
  public void OnRefreshPictureData(String arg1, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    synchronized (cp.d(this.a))
    {
      cp.e(this.a).cancel();
      if (cp.a(this.a) == null)
      {
        h.c("onRefreshPictureData, handler is null");
        return;
      }
      paramWUserSigInfo = cp.a(this.a).obtainMessage(4100);
      paramWUserSigInfo.arg1 = paramInt;
      if (paramInt != 0)
      {
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("loginerror", paramErrMsg.getMessage());
        paramWUserSigInfo.setData(paramArrayOfByte);
      }
      cp.a(this.a).sendMessage(paramWUserSigInfo);
      cp.a(this.a, null);
      return;
    }
  }
  
  public void OnVerifyCode(String arg1, byte[] paramArrayOfByte1, long paramLong, List paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    synchronized (cp.d(this.a))
    {
      cp.e(this.a).cancel();
      if (cp.a(this.a) == null)
      {
        h.c("onVerifyCode, handler is null");
        return;
      }
      paramList = cp.a(this.a).obtainMessage(4101);
      paramList.arg1 = paramInt;
      paramWUserSigInfo = new Bundle();
      paramWUserSigInfo.putByteArray("appname", paramArrayOfByte1);
      paramWUserSigInfo.putLong("scantime", paramLong);
      paramWUserSigInfo.putByteArray("scanerror", paramArrayOfByte2);
      paramList.setData(paramWUserSigInfo);
      cp.a(this.a).sendMessage(paramList);
      cp.a(this.a, null);
      return;
    }
  }
  
  public void onQuickLogin(String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt, ErrMsg paramErrMsg)
  {
    for (;;)
    {
      try
      {
        paramErrMsg = new StringBuilder().append("onQuickLogin").append(paramInt).append("mUIHandler!=null:");
        if (cp.a(this.a) == null) {
          break label182;
        }
        bool = true;
        h.a(bool);
        if (paramInt != 0)
        {
          if (true == util.shouldKick(paramInt)) {
            cp.b(this.a).ClearUserLoginData(paramString, 523005419L);
          }
        }
        else
        {
          paramQuickLoginParam = this.a.a(paramQuickLoginParam.userSigInfo);
          if (cp.a(this.a) != null)
          {
            paramErrMsg = cp.a(this.a).obtainMessage(4109);
            paramErrMsg.arg1 = paramInt;
            Bundle localBundle = new Bundle();
            localBundle.putByteArray("sig", paramQuickLoginParam);
            localBundle.putString("uin", paramString);
            paramErrMsg.setData(localBundle);
            cp.a(this.a).sendMessage(paramErrMsg);
            cp.a(this.a, null);
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label182:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cq
 * JD-Core Version:    0.7.0.1
 */