package com.tencent.token;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.base.GameLoginSndConfirmDialog;
import com.tencent.token.utils.l;
import gameloginsdk.CallbackAppidTypeStruct;
import gameloginsdk.CallbackGameConfirmStruct;
import gameloginsdk.CallbackPushStruct;
import gameloginsdk.GameLogin;
import gameloginsdk.GameLoginConst;
import gameloginsdk.IGameLoginCallback;

public class bx
{
  private static bx c;
  private static boolean j = false;
  GameLogin a;
  Handler b = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (bx.a(bx.this) != null) {
        try
        {
          new GameLoginSndConfirmDialog(BaseActivity.sTopActivity, 2131558764).show();
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GameSafeLoginManager: ");
          localStringBuilder.append(paramAnonymousMessage.getMessage());
          g.c(localStringBuilder.toString());
        }
      }
    }
  };
  private boolean d = false;
  private boolean e = false;
  private CallbackPushStruct f;
  private int g;
  private Handler h;
  private long i = 0L;
  
  private bx(Context paramContext, String paramString, int paramInt)
  {
    if (this.a == null) {
      this.a = new GameLogin();
    }
    j = this.a.init(paramContext, 34, paramString, paramInt);
    if (!j) {
      return;
    }
    this.a.setRespLimitTime(60000L);
    this.a.setWaitPushTime(180000L);
    this.a.setNetworkCallback(new IGameLoginCallback()
    {
      public void onPush(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("game login push rsp callback: info=");
        ((StringBuilder)localObject).append(paramAnonymousInt);
        ((StringBuilder)localObject).append(", obj=");
        ((StringBuilder)localObject).append(paramAnonymousObject);
        g.d(((StringBuilder)localObject).toString());
        l.j();
        if (paramAnonymousInt != 0) {
          return;
        }
        if (paramAnonymousObject == null) {
          return;
        }
        paramAnonymousObject = (CallbackPushStruct)paramAnonymousObject;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramAnonymousObject.toString());
        ((StringBuilder)localObject).append(", foreground=");
        ((StringBuilder)localObject).append(BaseActivity.getIsAppForeground());
        g.c(((StringBuilder)localObject).toString());
        bx.a(bx.this, paramAnonymousObject);
        bx.a(bx.this, cd.c().s());
        if (BaseActivity.getIsAppForeground())
        {
          bx.this.b.sendEmptyMessage(0);
          return;
        }
        IndexActivity.s_ShowGameLoginPushInfo = true;
        paramAnonymousObject = new StringBuilder();
        paramAnonymousObject.append("QQ");
        paramAnonymousObject.append(l.a(bx.a(bx.this).uin));
        paramAnonymousObject.append(RqdApplication.n().getResources().getString(2131493226));
        paramAnonymousObject = paramAnonymousObject.toString();
        localObject = new Intent(RqdApplication.n(), IndexActivity.class);
        ((Intent)localObject).putExtra("index_from", 24);
        localObject = PendingIntent.getActivity(RqdApplication.n(), 0, (Intent)localObject, 134217728);
        Context localContext = RqdApplication.n();
        RqdApplication.n();
        ((NotificationManager)localContext.getSystemService("notification")).notify(3, new NotificationCompat.Builder(RqdApplication.n()).setDefaults(1).setAutoCancel(true).setContentTitle(RqdApplication.n().getResources().getString(2131492987)).setSmallIcon(2131099913).setContentIntent((PendingIntent)localObject).addAction(2131099913, RqdApplication.n().getResources().getString(2131492987), (PendingIntent)localObject).setContentText(paramAnonymousObject).build());
      }
      
      public void onRespCallback(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("game login rsp callback: ret=");
        ((StringBuilder)localObject).append(paramAnonymousInt1);
        ((StringBuilder)localObject).append(", respno=");
        ((StringBuilder)localObject).append(paramAnonymousInt2);
        ((StringBuilder)localObject).append(", info=");
        ((StringBuilder)localObject).append(paramAnonymousInt3);
        ((StringBuilder)localObject).append(", obj=");
        ((StringBuilder)localObject).append(paramAnonymousObject);
        g.d(((StringBuilder)localObject).toString());
        switch (paramAnonymousInt3)
        {
        default: 
        case 2: 
          paramAnonymousObject = (CallbackGameConfirmStruct)paramAnonymousObject;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("game login confirm:");
          ((StringBuilder)localObject).append(paramAnonymousObject);
          g.b(((StringBuilder)localObject).toString());
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 != 0)
          {
            paramAnonymousInt1 = GameLoginConst.filterNormalCode(paramAnonymousInt1);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("game login confirm: code=");
            ((StringBuilder)localObject).append(paramAnonymousInt1);
            g.b(((StringBuilder)localObject).toString());
            paramAnonymousInt2 = paramAnonymousInt1;
            switch (paramAnonymousInt1)
            {
            default: 
              paramAnonymousInt2 = paramAnonymousInt1;
            }
          }
          if ((bx.a(bx.this) != null) && (bx.b(bx.this) != null))
          {
            localObject = bx.b(bx.this).obtainMessage(3040);
            ((Message)localObject).arg1 = bx.c(bx.this);
            ((Message)localObject).arg2 = paramAnonymousInt2;
            ((Message)localObject).obj = paramAnonymousObject;
            bx.b(bx.this).sendMessage((Message)localObject);
            return;
          }
          break;
        case 1: 
          if (paramAnonymousInt1 != 0)
          {
            switch (GameLoginConst.filterNormalCode(paramAnonymousInt1))
            {
            }
            l.j();
            return;
          }
          break;
        case 0: 
          paramAnonymousObject = (CallbackAppidTypeStruct)paramAnonymousObject;
          if (paramAnonymousInt1 != 0)
          {
            switch (GameLoginConst.filterNormalCode(paramAnonymousInt1))
            {
            }
            l.j();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("game login getflowtype: appidtype=");
          ((StringBuilder)localObject).append(paramAnonymousObject.appidType);
          g.a(((StringBuilder)localObject).toString());
          bx.a(bx.this, true);
          if (paramAnonymousObject.appidType == 1)
          {
            bx.b(bx.this, true);
            return;
          }
          bx.b(bx.this, false);
        }
      }
    });
  }
  
  public static bx a(Context paramContext)
  {
    if ((c == null) || (!j)) {
      c = new bx(paramContext, l.l(), 1);
    }
    return c;
  }
  
  public void a(long paramLong)
  {
    if (!j) {
      return;
    }
    this.d = false;
    this.e = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("game login get flow type appid=");
    localStringBuilder.append(paramLong);
    g.a(localStringBuilder.toString());
    this.a.sendGetFlowType(paramLong);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, Handler paramHandler)
  {
    if (!j) {
      return;
    }
    this.g = paramInt;
    this.h = paramHandler;
    paramHandler = new StringBuilder();
    paramHandler.append("game login confirm send: ");
    paramHandler.append(paramString);
    paramHandler.append("|");
    paramHandler.append(paramArrayOfByte);
    paramHandler.append("|");
    paramHandler.append(paramInt);
    g.b(paramHandler.toString());
    this.a.sendGameConfirm(paramString, paramArrayOfByte, paramInt);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!j) {
      return;
    }
    if ((this.e) && (this.d))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("game login info uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", guid=");
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append(", qrcode=");
      localStringBuilder.append(paramString2);
      g.c(localStringBuilder.toString());
      this.a.sendGameLoginInfo(paramString1, paramArrayOfByte, paramString2);
    }
  }
  
  public boolean a()
  {
    return (this.e) && (this.d);
  }
  
  public boolean b()
  {
    return (this.f == null) || (this.i <= 0L) || (cd.c().s() - this.i >= this.f.expirtTime * 1000);
  }
  
  public int c()
  {
    if ((this.f != null) && (this.i > 0L)) {
      return (int)((cd.c().s() - this.i) / 1000L);
    }
    return 0;
  }
  
  public CallbackPushStruct d()
  {
    return this.f;
  }
  
  public void e()
  {
    this.f = null;
    this.i = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bx
 * JD-Core Version:    0.7.0.1
 */