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

public class bv
{
  private static bv c;
  private static boolean j = false;
  GameLogin a;
  Handler b = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (bv.a(bv.this) != null) {}
      try
      {
        new GameLoginSndConfirmDialog(BaseActivity.sTopActivity, 2131362156).show();
        return;
      }
      catch (Exception paramAnonymousMessage)
      {
        g.c("GameSafeLoginManager: " + paramAnonymousMessage.getMessage());
      }
    }
  };
  private boolean d = false;
  private boolean e = false;
  private CallbackPushStruct f;
  private int g;
  private Handler h;
  private long i = 0L;
  
  private bv(Context paramContext, String paramString, int paramInt)
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
        g.d("game login push rsp callback: info=" + paramAnonymousInt + ", obj=" + paramAnonymousObject);
        l.j();
        switch (paramAnonymousInt)
        {
        }
        do
        {
          return;
        } while (paramAnonymousObject == null);
        paramAnonymousObject = (CallbackPushStruct)paramAnonymousObject;
        g.c(paramAnonymousObject.toString() + ", foreground=" + BaseActivity.getIsAppForeground());
        bv.a(bv.this, paramAnonymousObject);
        bv.a(bv.this, cb.c().s());
        if (BaseActivity.getIsAppForeground())
        {
          bv.this.b.sendEmptyMessage(0);
          return;
        }
        IndexActivity.s_ShowGameLoginPushInfo = true;
        paramAnonymousObject = "QQ" + l.a(bv.a(bv.this).uin) + RqdApplication.l().getResources().getString(2131231083);
        Object localObject = new Intent(RqdApplication.l(), IndexActivity.class);
        ((Intent)localObject).putExtra("index_from", 24);
        localObject = PendingIntent.getActivity(RqdApplication.l(), 0, (Intent)localObject, 134217728);
        Context localContext = RqdApplication.l();
        RqdApplication.l();
        ((NotificationManager)localContext.getSystemService("notification")).notify(3, new NotificationCompat.Builder(RqdApplication.l()).setDefaults(1).setAutoCancel(true).setContentTitle(RqdApplication.l().getResources().getString(2131230844)).setSmallIcon(2130837767).setContentIntent((PendingIntent)localObject).addAction(2130837767, RqdApplication.l().getResources().getString(2131230844), (PendingIntent)localObject).setContentText(paramAnonymousObject).build());
      }
      
      public void onRespCallback(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
      {
        g.d("game login rsp callback: ret=" + paramAnonymousInt1 + ", respno=" + paramAnonymousInt2 + ", info=" + paramAnonymousInt3 + ", obj=" + paramAnonymousObject);
        switch (paramAnonymousInt3)
        {
        }
        do
        {
          do
          {
            return;
            paramAnonymousObject = (CallbackAppidTypeStruct)paramAnonymousObject;
            if (paramAnonymousInt1 != 0)
            {
              switch (GameLoginConst.filterNormalCode(paramAnonymousInt1))
              {
              }
              l.j();
            }
            g.a("game login getflowtype: appidtype=" + paramAnonymousObject.appidType);
            bv.a(bv.this, true);
            if (paramAnonymousObject.appidType == 1)
            {
              bv.b(bv.this, true);
              return;
            }
            bv.b(bv.this, false);
            return;
          } while (paramAnonymousInt1 == 0);
          switch (GameLoginConst.filterNormalCode(paramAnonymousInt1))
          {
          }
          l.j();
          return;
          paramAnonymousObject = (CallbackGameConfirmStruct)paramAnonymousObject;
          g.b("game login confirm:" + paramAnonymousObject);
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 != 0)
          {
            paramAnonymousInt1 = GameLoginConst.filterNormalCode(paramAnonymousInt1);
            g.b("game login confirm: code=" + paramAnonymousInt1);
            paramAnonymousInt2 = paramAnonymousInt1;
            switch (paramAnonymousInt1)
            {
            default: 
              paramAnonymousInt2 = paramAnonymousInt1;
            }
          }
        } while ((bv.a(bv.this) == null) || (bv.b(bv.this) == null));
        Message localMessage = bv.b(bv.this).obtainMessage(3040);
        localMessage.arg1 = bv.c(bv.this);
        localMessage.arg2 = paramAnonymousInt2;
        localMessage.obj = paramAnonymousObject;
        bv.b(bv.this).sendMessage(localMessage);
      }
    });
  }
  
  public static bv a(Context paramContext)
  {
    if ((c == null) || (!j)) {
      c = new bv(paramContext, l.l(), 1);
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
    g.a("game login get flow type appid=" + paramLong);
    this.a.sendGetFlowType(paramLong);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, Handler paramHandler)
  {
    if (!j) {
      return;
    }
    this.g = paramInt;
    this.h = paramHandler;
    g.b("game login confirm send: " + paramString + "|" + paramArrayOfByte + "|" + paramInt);
    this.a.sendGameConfirm(paramString, paramArrayOfByte, paramInt);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!j) {}
    while ((!this.e) || (!this.d)) {
      return;
    }
    g.c("game login info uin=" + paramString1 + ", guid=" + paramArrayOfByte + ", qrcode=" + paramString2);
    this.a.sendGameLoginInfo(paramString1, paramArrayOfByte, paramString2);
  }
  
  public boolean a()
  {
    return (this.e) && (this.d);
  }
  
  public boolean b()
  {
    return (this.f == null) || (this.i <= 0L) || (cb.c().s() - this.i >= this.f.expirtTime * 1000);
  }
  
  public int c()
  {
    if ((this.f != null) && (this.i > 0L)) {
      return (int)((cb.c().s() - this.i) / 1000L);
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
 * Qualified Name:     com.tencent.token.bv
 * JD-Core Version:    0.7.0.1
 */