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

public final class rv
{
  public static boolean h = false;
  private static rv j;
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
      if (rv.a(rv.this) != null) {
        try
        {
          new GameLoginSndConfirmDialog(BaseActivity.sTopActivity).show();
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          StringBuilder localStringBuilder = new StringBuilder("GameSafeLoginManager: ");
          localStringBuilder.append(paramAnonymousMessage.getMessage());
          xa.c(localStringBuilder.toString());
        }
      }
    }
  };
  
  private rv(Context paramContext, String paramString)
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
        xa.c(((StringBuilder)localObject1).toString());
        aac.h();
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
        xa.c(((StringBuilder)localObject1).toString());
        rv.a(rv.this, paramAnonymousObject);
        rv.a(rv.this, qy.a().h() * 1000L);
        if (BaseActivity.getIsAppForeground())
        {
          rv.this.i.sendEmptyMessage(0);
          return;
        }
        IndexActivity.s_ShowGameLoginPushInfo = true;
        paramAnonymousObject = new StringBuilder("QQ");
        paramAnonymousObject.append(aac.b(rv.a(rv.this).uin));
        paramAnonymousObject.append(RqdApplication.n().getResources().getString(2131493226));
        paramAnonymousObject = paramAnonymousObject.toString();
        localObject1 = new Intent(RqdApplication.n(), IndexActivity.class);
        ((Intent)localObject1).putExtra("index_from", 24);
        localObject1 = PendingIntent.getActivity(RqdApplication.n(), 0, (Intent)localObject1, 134217728);
        Object localObject2 = RqdApplication.n();
        RqdApplication.n();
        localObject2 = (NotificationManager)((Context)localObject2).getSystemService("notification");
        cj.b localb = new cj.b(RqdApplication.n(), (byte)0).c().b().a(RqdApplication.n().getResources().getString(2131492987)).a();
        localb.e = ((PendingIntent)localObject1);
        String str = RqdApplication.n().getResources().getString(2131492987);
        localb.b.add(new cj.a(str, (PendingIntent)localObject1));
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
        xa.c(((StringBuilder)localObject).toString());
        switch (paramAnonymousInt3)
        {
        default: 
        case 2: 
          paramAnonymousObject = (CallbackGameConfirmStruct)paramAnonymousObject;
          xa.b("game login confirm:".concat(String.valueOf(paramAnonymousObject)));
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 != 0)
          {
            paramAnonymousInt2 = GameLoginConst.filterNormalCode(paramAnonymousInt1);
            xa.b("game login confirm: code=".concat(String.valueOf(paramAnonymousInt2)));
          }
          if ((rv.a(rv.this) != null) && (rv.c(rv.this) != null))
          {
            localObject = rv.c(rv.this).obtainMessage(3040);
            ((Message)localObject).arg1 = rv.d(rv.this);
            ((Message)localObject).arg2 = paramAnonymousInt2;
            ((Message)localObject).obj = paramAnonymousObject;
            rv.c(rv.this).sendMessage((Message)localObject);
            return;
          }
          break;
        case 1: 
          if (paramAnonymousInt1 != 0)
          {
            GameLoginConst.filterNormalCode(paramAnonymousInt1);
            aac.h();
            return;
          }
          break;
        case 0: 
          paramAnonymousObject = (CallbackAppidTypeStruct)paramAnonymousObject;
          if (paramAnonymousInt1 != 0)
          {
            GameLoginConst.filterNormalCode(paramAnonymousInt1);
            aac.h();
          }
          localObject = new StringBuilder("game login getflowtype: appidtype=");
          ((StringBuilder)localObject).append(paramAnonymousObject.appidType);
          xa.a(((StringBuilder)localObject).toString());
          rv.b(rv.this);
          if (paramAnonymousObject.appidType == 1)
          {
            rv.a(rv.this, true);
            return;
          }
          rv.a(rv.this, false);
          return;
        }
      }
    });
  }
  
  public static rv a(Context paramContext)
  {
    if ((j == null) || (!h)) {
      j = new rv(paramContext, aac.j());
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rv
 * JD-Core Version:    0.7.0.1
 */