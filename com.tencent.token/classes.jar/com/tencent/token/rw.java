package com.tencent.token;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.base.GameLoginSndConfirmDialog;
import gameloginsdk.CallbackAppidTypeStruct;
import gameloginsdk.CallbackGameConfirmStruct;
import gameloginsdk.CallbackPushStruct;
import gameloginsdk.GameLogin;
import gameloginsdk.GameLoginConst;
import gameloginsdk.IGameLoginCallback;
import java.util.ArrayList;

public final class rw
{
  public static boolean h = false;
  private static rw j;
  public GameLogin a;
  public boolean b = false;
  public boolean c = false;
  public CallbackPushStruct d;
  public int e;
  public Handler f;
  public long g = 0L;
  Handler i = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (rw.a(rw.this) != null) {
        try
        {
          new GameLoginSndConfirmDialog(BaseActivity.sTopActivity).show();
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          StringBuilder localStringBuilder = new StringBuilder("GameSafeLoginManager: ");
          localStringBuilder.append(paramAnonymousMessage.getMessage());
          xb.c(localStringBuilder.toString());
        }
      }
    }
  };
  
  private rw(Context paramContext, String paramString)
  {
    if (this.a == null) {
      this.a = new GameLogin();
    }
    boolean bool = this.a.init(paramContext, 34, paramString, 1);
    h = bool;
    if (!bool) {
      return;
    }
    this.a.setRespLimitTime(60000L);
    this.a.setWaitPushTime(180000L);
    this.a.setNetworkCallback(new IGameLoginCallback()
    {
      public final void onPush(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject1 = new StringBuilder("game login push rsp callback: info=");
        ((StringBuilder)localObject1).append(paramAnonymousInt);
        ((StringBuilder)localObject1).append(", obj=");
        ((StringBuilder)localObject1).append(paramAnonymousObject);
        xb.c(((StringBuilder)localObject1).toString());
        aad.h();
        if (paramAnonymousInt != 0) {
          return;
        }
        if (paramAnonymousObject == null) {
          return;
        }
        paramAnonymousObject = (CallbackPushStruct)paramAnonymousObject;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramAnonymousObject.toString());
        ((StringBuilder)localObject1).append(", foreground=");
        ((StringBuilder)localObject1).append(BaseActivity.getIsAppForeground());
        xb.c(((StringBuilder)localObject1).toString());
        rw.a(rw.this, paramAnonymousObject);
        rw.a(rw.this, qz.a().h() * 1000L);
        if (BaseActivity.getIsAppForeground())
        {
          rw.this.i.sendEmptyMessage(0);
          return;
        }
        IndexActivity.s_ShowGameLoginPushInfo = true;
        paramAnonymousObject = new StringBuilder("QQ");
        paramAnonymousObject.append(aad.b(rw.a(rw.this).uin));
        paramAnonymousObject.append(RqdApplication.n().getResources().getString(2131493226));
        paramAnonymousObject = paramAnonymousObject.toString();
        localObject1 = new Intent(RqdApplication.n(), IndexActivity.class);
        ((Intent)localObject1).putExtra("index_from", 24);
        localObject1 = PendingIntent.getActivity(RqdApplication.n(), 0, (Intent)localObject1, 134217728);
        Object localObject2 = RqdApplication.n();
        RqdApplication.n();
        localObject2 = (NotificationManager)((Context)localObject2).getSystemService("notification");
        ck.b localb = new ck.b(RqdApplication.n(), (byte)0).c().b().a(RqdApplication.n().getResources().getString(2131492987)).a();
        localb.e = ((PendingIntent)localObject1);
        String str = RqdApplication.n().getResources().getString(2131492987);
        localb.b.add(new ck.a(str, (PendingIntent)localObject1));
        ((NotificationManager)localObject2).notify(3, localb.b(paramAnonymousObject).d());
      }
      
      public final void onRespCallback(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
      {
        Object localObject = new StringBuilder("game login rsp callback: ret=");
        ((StringBuilder)localObject).append(paramAnonymousInt1);
        ((StringBuilder)localObject).append(", respno=");
        ((StringBuilder)localObject).append(paramAnonymousInt2);
        ((StringBuilder)localObject).append(", info=");
        ((StringBuilder)localObject).append(paramAnonymousInt3);
        ((StringBuilder)localObject).append(", obj=");
        ((StringBuilder)localObject).append(paramAnonymousObject);
        xb.c(((StringBuilder)localObject).toString());
        switch (paramAnonymousInt3)
        {
        default: 
        case 2: 
          paramAnonymousObject = (CallbackGameConfirmStruct)paramAnonymousObject;
          xb.b("game login confirm:".concat(String.valueOf(paramAnonymousObject)));
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 != 0)
          {
            paramAnonymousInt2 = GameLoginConst.filterNormalCode(paramAnonymousInt1);
            xb.b("game login confirm: code=".concat(String.valueOf(paramAnonymousInt2)));
          }
          if ((rw.a(rw.this) != null) && (rw.c(rw.this) != null))
          {
            localObject = rw.c(rw.this).obtainMessage(3040);
            ((Message)localObject).arg1 = rw.d(rw.this);
            ((Message)localObject).arg2 = paramAnonymousInt2;
            ((Message)localObject).obj = paramAnonymousObject;
            rw.c(rw.this).sendMessage((Message)localObject);
            return;
          }
          break;
        case 1: 
          if (paramAnonymousInt1 != 0)
          {
            GameLoginConst.filterNormalCode(paramAnonymousInt1);
            aad.h();
            return;
          }
          break;
        case 0: 
          paramAnonymousObject = (CallbackAppidTypeStruct)paramAnonymousObject;
          if (paramAnonymousInt1 != 0)
          {
            GameLoginConst.filterNormalCode(paramAnonymousInt1);
            aad.h();
          }
          localObject = new StringBuilder("game login getflowtype: appidtype=");
          ((StringBuilder)localObject).append(paramAnonymousObject.appidType);
          xb.a(((StringBuilder)localObject).toString());
          rw.b(rw.this);
          if (paramAnonymousObject.appidType == 1)
          {
            rw.a(rw.this, true);
            return;
          }
          rw.a(rw.this, false);
          return;
        }
      }
    });
  }
  
  public static rw a(Context paramContext)
  {
    if ((j == null) || (!h)) {
      j = new rw(paramContext, aad.j());
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rw
 * JD-Core Version:    0.7.0.1
 */