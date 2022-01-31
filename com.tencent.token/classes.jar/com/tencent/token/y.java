package com.tencent.token;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.List;
import java.util.Timer;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

final class y
  extends WtloginListener
{
  y(x paramx) {}
  
  private void a(int paramInt, ErrMsg arg2, String paramString, long paramLong)
  {
    if (paramInt != 0) {
      this.a.b.a(paramInt, ???.getMessage(), ???.getMessage());
    }
    for (;;)
    {
      x.b(this.a);
      synchronized (x.c)
      {
        x.c.notifyAll();
        return;
        if (paramLong == 523005425L)
        {
          ??? = x.a(this.a).GetLocalTicket(paramString, paramLong, 2097152);
          if ((this.a.b == null) || (??? == null)) {
            continue;
          }
          this.a.b.d = ???._sig;
          this.a.b.a = 0;
          continue;
        }
        ??? = x.a(this.a).GetLocalTicket(paramString, paramLong, 64);
      }
    }
  }
  
  public final void OnCheckPictureAndGetSt(String paramString, byte[] arg2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    int i = x.c(this.a);
    x.d(this.a);
    label233:
    for (;;)
    {
      synchronized (x.e(this.a))
      {
        x.f(this.a).cancel();
        if (x.h(this.a) == null)
        {
          e.c("onCheckPictureAndGetSt, handler is null");
          return;
        }
        paramWUserSigInfo = x.h(this.a).obtainMessage(4099);
        paramWUserSigInfo.arg1 = paramInt;
        if (paramInt != 0)
        {
          paramString = new Bundle();
          paramString.putString("loginerror", paramErrMsg.getMessage());
          paramWUserSigInfo.setData(paramString);
          x.h(this.a).sendMessage(paramWUserSigInfo);
          x.i(this.a);
          return;
        }
      }
      if (i != 0) {
        paramString = x.a(this.a).GetLocalTicket(paramString, x.j(this.a), i);
      }
      for (;;)
      {
        if (paramString == null) {
          break label233;
        }
        paramWUserSigInfo.obj = paramString._sig;
        break;
        if (x.j(this.a) == 523005425L) {
          paramString = x.a(this.a).GetLocalTicket(paramString, x.j(this.a), 2097152);
        } else {
          paramString = x.a(this.a).GetLocalTicket(paramString, x.j(this.a), 64);
        }
      }
    }
  }
  
  public final void OnCloseCode(String arg1, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    synchronized (x.e(this.a))
    {
      x.f(this.a).cancel();
      if (x.h(this.a) == null)
      {
        e.c("onCloseCode, handler is null");
        return;
      }
      paramWUserSigInfo = x.h(this.a).obtainMessage(4102);
      paramWUserSigInfo.arg1 = paramInt;
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("appname", paramArrayOfByte1);
      localBundle.putLong("scantime", paramLong);
      localBundle.putByteArray("scanerror", paramArrayOfByte2);
      paramWUserSigInfo.setData(localBundle);
      x.h(this.a).sendMessage(paramWUserSigInfo);
      x.i(this.a);
      return;
    }
  }
  
  public final void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo arg3)
  {
    e.c("Wtlogin exception " + paramErrMsg.getMessage());
    x.d(this.a);
    synchronized (x.e(this.a))
    {
      x.f(this.a).cancel();
      if (x.h(this.a) == null)
      {
        e.c("onVerifyCode, handler is null");
        return;
      }
      Message localMessage = x.h(this.a).obtainMessage(4104);
      localMessage.arg1 = paramInt;
      Bundle localBundle = new Bundle();
      localBundle.putString("exception", paramErrMsg.getMessage());
      localMessage.setData(localBundle);
      x.h(this.a).sendMessage(localMessage);
      x.i(this.a);
      return;
    }
  }
  
  public final void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String arg7, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    paramInt1 = x.c(this.a);
    x.d(this.a);
    synchronized (x.e(this.a))
    {
      x.f(this.a).cancel();
      if (x.g(this.a))
      {
        a(paramInt2, paramErrMsg, paramString1, paramLong1);
        return;
      }
      if (x.h(this.a) == null)
      {
        e.c("onGetStWithPasswd, handler is null");
        return;
      }
    }
    paramWUserSigInfo = x.h(this.a).obtainMessage(4098);
    paramWUserSigInfo.arg1 = paramInt2;
    if (paramInt2 != 0)
    {
      paramString1 = new Bundle();
      paramString1.putString("loginerror", paramErrMsg.getMessage());
      paramWUserSigInfo.setData(paramString1);
    }
    label267:
    for (;;)
    {
      x.h(this.a).sendMessage(paramWUserSigInfo);
      x.i(this.a);
      return;
      if (paramInt1 != 0) {
        paramString1 = x.a(this.a).GetLocalTicket(paramString1, x.j(this.a), paramInt1);
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label267;
        }
        paramWUserSigInfo.obj = paramString1._sig;
        break;
        if (x.j(this.a) == 523005425L) {
          paramString1 = x.a(this.a).GetLocalTicket(paramString1, x.j(this.a), 2097152);
        } else {
          paramString1 = x.a(this.a).GetLocalTicket(paramString1, x.j(this.a), 64);
        }
      }
    }
  }
  
  public final void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo arg9, int paramInt2, ErrMsg paramErrMsg)
  {
    paramInt1 = x.c(this.a);
    x.d(this.a);
    synchronized (x.e(this.a))
    {
      x.f(this.a).cancel();
      e.c("onGetStWithoutPasswd: ret=" + paramInt2 + ", errmsg=" + paramErrMsg.getMessage() + ", appid=" + paramLong1 + ", mIsASyn2Syn=" + x.g(this.a));
      if (x.g(this.a))
      {
        a(paramInt2, paramErrMsg, paramString, paramLong1);
        return;
      }
      if (x.h(this.a) == null)
      {
        e.c("onGetStWithoutPasswd, handler is null");
        return;
      }
    }
    Message localMessage = x.h(this.a).obtainMessage(4097);
    localMessage.arg1 = paramInt2;
    if (paramInt2 != 0)
    {
      paramString = new Bundle();
      paramString.putString("loginerror", paramErrMsg.getMessage());
      localMessage.setData(paramString);
    }
    label303:
    for (;;)
    {
      x.h(this.a).sendMessage(localMessage);
      x.i(this.a);
      return;
      if (paramInt1 != 0) {
        paramString = x.a(this.a).GetLocalTicket(paramString, paramLong1, paramInt1);
      }
      for (;;)
      {
        if (paramString == null) {
          break label303;
        }
        localMessage.obj = paramString._sig;
        break;
        if (paramLong1 == 523005425L) {
          paramString = x.a(this.a).GetLocalTicket(paramString, paramLong1, 2097152);
        } else {
          paramString = x.a(this.a).GetLocalTicket(paramString, paramLong1, 64);
        }
      }
    }
  }
  
  public final void OnInit(int paramInt)
  {
    e.b("Wtlogin init result " + paramInt);
  }
  
  public final void OnRefreshPictureData(String arg1, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    synchronized (x.e(this.a))
    {
      x.f(this.a).cancel();
      if (x.h(this.a) == null)
      {
        e.c("onRefreshPictureData, handler is null");
        return;
      }
      paramWUserSigInfo = x.h(this.a).obtainMessage(4100);
      paramWUserSigInfo.arg1 = paramInt;
      if (paramInt != 0)
      {
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("loginerror", paramErrMsg.getMessage());
        paramWUserSigInfo.setData(paramArrayOfByte);
      }
      x.h(this.a).sendMessage(paramWUserSigInfo);
      x.i(this.a);
      return;
    }
  }
  
  public final void OnVerifyCode(String arg1, byte[] paramArrayOfByte1, long paramLong, List paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    synchronized (x.e(this.a))
    {
      x.f(this.a).cancel();
      if (x.h(this.a) == null)
      {
        e.c("onVerifyCode, handler is null");
        return;
      }
      paramList = x.h(this.a).obtainMessage(4101);
      paramList.arg1 = paramInt;
      paramWUserSigInfo = new Bundle();
      paramWUserSigInfo.putByteArray("appname", paramArrayOfByte1);
      paramWUserSigInfo.putLong("scantime", paramLong);
      paramWUserSigInfo.putByteArray("scanerror", paramArrayOfByte2);
      paramList.setData(paramWUserSigInfo);
      x.h(this.a).sendMessage(paramList);
      x.i(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.y
 * JD-Core Version:    0.7.0.1
 */