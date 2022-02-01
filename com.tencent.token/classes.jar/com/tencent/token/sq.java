package com.tencent.token;

import android.annotation.SuppressLint;
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

public final class sq
{
  public static boolean h = false;
  private static sq j;
  public GameLogin a;
  public boolean b = false;
  public boolean c = false;
  public CallbackPushStruct d;
  public int e;
  public Handler f;
  public long g = 0L;
  @SuppressLint({"HandlerLeak"})
  Handler i = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (sq.a(sq.this) != null) {
        try
        {
          new GameLoginSndConfirmDialog(BaseActivity.sTopActivity).show();
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          StringBuilder localStringBuilder = new StringBuilder("GameSafeLoginManager: ");
          localStringBuilder.append(paramAnonymousMessage.getMessage());
          xv.c(localStringBuilder.toString());
        }
      }
    }
  };
  
  private sq(Context paramContext, String paramString)
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
        xv.c(((StringBuilder)localObject1).toString());
        aay.h();
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
        xv.c(((StringBuilder)localObject1).toString());
        sq.a(sq.this, paramAnonymousObject);
        sq.a(sq.this, rt.a().h() * 1000L);
        if (BaseActivity.getIsAppForeground())
        {
          sq.this.i.sendEmptyMessage(0);
          return;
        }
        IndexActivity.s_ShowGameLoginPushInfo = true;
        paramAnonymousObject = new StringBuilder("QQ");
        paramAnonymousObject.append(aay.b(sq.a(sq.this).uin));
        paramAnonymousObject.append(RqdApplication.n().getResources().getString(2131493228));
        paramAnonymousObject = paramAnonymousObject.toString();
        localObject1 = new Intent(RqdApplication.n(), IndexActivity.class);
        ((Intent)localObject1).putExtra("index_from", 24);
        localObject1 = PendingIntent.getActivity(RqdApplication.n(), 0, (Intent)localObject1, 134217728);
        Object localObject2 = RqdApplication.n();
        RqdApplication.n();
        localObject2 = (NotificationManager)((Context)localObject2).getSystemService("notification");
        db.b localb = new db.b(RqdApplication.n(), (byte)0).c().b().a(RqdApplication.n().getResources().getString(2131492988)).a();
        localb.e = ((PendingIntent)localObject1);
        String str = RqdApplication.n().getResources().getString(2131492988);
        localb.b.add(new db.a(str, (PendingIntent)localObject1));
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
        xv.c(((StringBuilder)localObject).toString());
        switch (paramAnonymousInt3)
        {
        default: 
        case 2: 
          paramAnonymousObject = (CallbackGameConfirmStruct)paramAnonymousObject;
          xv.b("game login confirm:".concat(String.valueOf(paramAnonymousObject)));
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 != 0)
          {
            paramAnonymousInt2 = GameLoginConst.filterNormalCode(paramAnonymousInt1);
            xv.b("game login confirm: code=".concat(String.valueOf(paramAnonymousInt2)));
          }
          if ((sq.a(sq.this) != null) && (sq.c(sq.this) != null))
          {
            localObject = sq.c(sq.this).obtainMessage(3040);
            ((Message)localObject).arg1 = sq.d(sq.this);
            ((Message)localObject).arg2 = paramAnonymousInt2;
            ((Message)localObject).obj = paramAnonymousObject;
            sq.c(sq.this).sendMessage((Message)localObject);
            return;
          }
          break;
        case 1: 
          if (paramAnonymousInt1 != 0)
          {
            GameLoginConst.filterNormalCode(paramAnonymousInt1);
            aay.h();
            return;
          }
          break;
        case 0: 
          paramAnonymousObject = (CallbackAppidTypeStruct)paramAnonymousObject;
          if (paramAnonymousInt1 != 0)
          {
            GameLoginConst.filterNormalCode(paramAnonymousInt1);
            aay.h();
          }
          localObject = new StringBuilder("game login getflowtype: appidtype=");
          ((StringBuilder)localObject).append(paramAnonymousObject.appidType);
          xv.a(((StringBuilder)localObject).toString());
          sq.b(sq.this);
          if (paramAnonymousObject.appidType == 1)
          {
            sq.a(sq.this, true);
            return;
          }
          sq.a(sq.this, false);
          return;
        }
      }
    });
  }
  
  public static sq a(Context paramContext)
  {
    if ((j == null) || (!h)) {
      j = new sq(paramContext, aay.j());
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sq
 * JD-Core Version:    0.7.0.1
 */