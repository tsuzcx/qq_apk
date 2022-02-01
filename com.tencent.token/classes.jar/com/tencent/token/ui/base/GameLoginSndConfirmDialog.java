package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.aau;
import com.tencent.token.aay;
import com.tencent.token.aaz;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.rt;
import com.tencent.token.sq;
import com.tencent.token.ss;
import com.tencent.token.sx;
import com.tencent.token.tt;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.VerifyStartScanActivity;
import com.tencent.token.xv;
import gameloginsdk.CallbackGameConfirmStruct;
import gameloginsdk.CallbackPushStruct;
import gameloginsdk.GameLogin;
import oicq.wlogin_sdk.request.WtloginHelper;

public class GameLoginSndConfirmDialog
  extends Dialog
{
  private Activity a;
  private GameLoginSndConfirmView b;
  private boolean c = false;
  private ProDialog d;
  private Handler e = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject2 = sq.a(RqdApplication.n()).d;
      if ((paramAnonymousMessage.what == 3040) && (localObject2 != null))
      {
        if (GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this) != null) {
          GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this).dismiss();
        }
        int i = paramAnonymousMessage.arg1;
        int j = paramAnonymousMessage.arg2;
        paramAnonymousMessage = (CallbackGameConfirmStruct)paramAnonymousMessage.obj;
        Object localObject1 = paramAnonymousMessage.wording;
        Object localObject3 = GameLoginSndConfirmDialog.b(GameLoginSndConfirmDialog.this);
        if (i == 2)
        {
          ((GameLoginSndConfirmView)localObject3).t.post(new GameLoginSndConfirmView.c((GameLoginSndConfirmView)localObject3, (View)localObject3));
        }
        else
        {
          ((GameLoginSndConfirmView)localObject3).t.post(new GameLoginSndConfirmView.b((GameLoginSndConfirmView)localObject3, ((GameLoginSndConfirmView)localObject3).j, ((GameLoginSndConfirmView)localObject3).k, ((GameLoginSndConfirmView)localObject3).l, ((GameLoginSndConfirmView)localObject3).m));
          sx.a(RqdApplication.n()).a();
        }
        if (j != 0)
        {
          localObject1 = paramAnonymousMessage.errMsg;
          if (localObject1 != null)
          {
            paramAnonymousMessage = (Message)localObject1;
            if (((String)localObject1).length() > 0) {}
          }
          else
          {
            paramAnonymousMessage = new StringBuilder();
            paramAnonymousMessage.append(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493108));
            paramAnonymousMessage.append("(");
            paramAnonymousMessage.append(j);
            paramAnonymousMessage.append(")");
            paramAnonymousMessage = paramAnonymousMessage.toString();
          }
          new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131492987).setMessage(paramAnonymousMessage).setPositiveButton(2131493041, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              GameLoginSndConfirmDialog.this.dismiss();
            }
          }).create().show();
          return;
        }
        if (i == 1)
        {
          if (localObject1 != null)
          {
            paramAnonymousMessage = (Message)localObject1;
            if (((String)localObject1).length() > 0) {}
          }
          else
          {
            paramAnonymousMessage = new StringBuilder(" ");
            paramAnonymousMessage.append(((CallbackPushStruct)localObject2).expirtTime);
            paramAnonymousMessage.append(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493221));
            paramAnonymousMessage = paramAnonymousMessage.toString();
          }
          localObject1 = GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getLayoutInflater().inflate(2131296475, null);
          localObject2 = new Toast(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this));
          ((Toast)localObject2).setView((View)localObject1);
          ((Toast)localObject2).setDuration(0);
          ((Toast)localObject2).setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
          localObject3 = (TextView)((View)localObject1).findViewById(2131166168);
          ((ImageView)((View)localObject1).findViewById(2131166166)).setBackgroundResource(2131100176);
          ((TextView)localObject3).setText(paramAnonymousMessage);
          ((Toast)localObject2).show();
          return;
        }
        if (i == 2)
        {
          paramAnonymousMessage = new StringBuilder();
          paramAnonymousMessage.append(((CallbackPushStruct)localObject2).gameName);
          paramAnonymousMessage.append(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493233));
          paramAnonymousMessage = paramAnonymousMessage.toString();
          new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(paramAnonymousMessage).setMessage(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493232)).setPositiveButton(2131493389, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              GameLoginSndConfirmDialog.this.dismiss();
              aay.a(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this));
            }
          }).setNegativeButton(2131493030, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              GameLoginSndConfirmDialog.this.dismiss();
            }
          }).create().show();
        }
      }
    }
  };
  
  public GameLoginSndConfirmDialog(Activity paramActivity)
  {
    super(paramActivity, 2131558764);
    this.a = paramActivity;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new GameLoginSndConfirmView(this.a);
    this.b.setListener(new GameLoginSndConfirmView.e()
    {
      public final void a()
      {
        GameLoginSndConfirmDialog.this.dismiss();
      }
      
      public final void a(int paramAnonymousInt)
      {
        Object localObject1 = sq.a(RqdApplication.n());
        Object localObject2 = ((sq)localObject1).d;
        if (localObject2 != null)
        {
          localObject2 = ((CallbackPushStruct)localObject2).uin;
          byte[] arrayOfByte = ss.a(RqdApplication.n()).a.GetGuid();
          Object localObject3 = GameLoginSndConfirmDialog.d(GameLoginSndConfirmDialog.this);
          if (sq.h)
          {
            ((sq)localObject1).e = paramAnonymousInt;
            ((sq)localObject1).f = ((Handler)localObject3);
            localObject3 = new StringBuilder("game login confirm send: ");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append("|");
            ((StringBuilder)localObject3).append(arrayOfByte);
            ((StringBuilder)localObject3).append("|");
            ((StringBuilder)localObject3).append(paramAnonymousInt);
            xv.b(((StringBuilder)localObject3).toString());
            ((sq)localObject1).a.sendGameConfirm((String)localObject2, arrayOfByte, paramAnonymousInt);
          }
          if (GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this) == null)
          {
            localObject1 = GameLoginSndConfirmDialog.this;
            GameLoginSndConfirmDialog.a((GameLoginSndConfirmDialog)localObject1, new ProDialog(GameLoginSndConfirmDialog.c((GameLoginSndConfirmDialog)localObject1)));
          }
          GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this).show();
        }
      }
      
      public final void b()
      {
        CallbackPushStruct localCallbackPushStruct = sq.a(RqdApplication.n()).d;
        if (localCallbackPushStruct != null) {
          if (localCallbackPushStruct.schemeFlag == 2)
          {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131492987);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localCallbackPushStruct.expirtTime);
            localStringBuilder.append(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493226));
            localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton(2131493227, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                paramAnonymous2DialogInterface.dismiss();
                GameLoginSndConfirmDialog.this.dismiss();
              }
            }).create().show();
          }
          else
          {
            new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131492987).setMessage(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493225)).setPositiveButton(2131493230, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GameLoginSndConfirmDialog.this.dismiss();
                paramAnonymous2DialogInterface = new Intent(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this), VerifyStartScanActivity.class);
                GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).startActivity(paramAnonymous2DialogInterface);
              }
            }).setNegativeButton(2131493030, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                paramAnonymous2DialogInterface.dismiss();
                GameLoginSndConfirmDialog.this.dismiss();
              }
            }).create().show();
          }
        }
        GameLoginSndConfirmDialog.this.dismiss();
      }
    });
    paramBundle = this.b;
    Object localObject1 = this.a;
    int i;
    if ((paramBundle.g != null) && ((paramBundle.g == null) || (!paramBundle.g.isFinishing())))
    {
      paramBundle.h = ((LayoutInflater)((Context)localObject1).getSystemService("layout_inflater"));
      paramBundle.i = paramBundle.h.inflate(2131296326, null);
      paramBundle.i.setVisibility(4);
      paramBundle.j = paramBundle.i.findViewById(2131166315);
      paramBundle.k = paramBundle.i.findViewById(2131166302);
      paramBundle.l = paramBundle.i.findViewById(2131166316);
      paramBundle.m = paramBundle.i.findViewById(2131166303);
      paramBundle.n = aaz.a(paramBundle.g.getResources(), 2131099828);
      paramBundle.o = aaz.a(paramBundle.g.getResources(), 2131099827);
      if (paramBundle.n != null) {
        ((LinearLayout)paramBundle.i.findViewById(2131166296)).setBackgroundDrawable(new BitmapDrawable(paramBundle.n));
      }
      if (paramBundle.o != null)
      {
        ((LinearLayout)paramBundle.i.findViewById(2131166297)).setBackgroundDrawable(new BitmapDrawable(paramBundle.o));
        ((LinearLayout)paramBundle.i.findViewById(2131166298)).setBackgroundDrawable(new BitmapDrawable(paramBundle.o));
      }
      paramBundle.a = ((TextView)paramBundle.i.findViewById(2131165778));
      paramBundle.b = ((TextView)paramBundle.i.findViewById(2131165766));
      paramBundle.f = ((ImageView)paramBundle.i.findViewById(2131165769));
      paramBundle.d = ((Button)paramBundle.i.findViewById(2131165765));
      paramBundle.e = ((Button)paramBundle.i.findViewById(2131165775));
      paramBundle.c = ((TextView)paramBundle.i.findViewById(2131165781));
      paramBundle.d.setOnClickListener(new GameLoginSndConfirmView.2(paramBundle));
      paramBundle.e.setOnClickListener(new GameLoginSndConfirmView.3(paramBundle));
      paramBundle.addView(paramBundle.i, new RelativeLayout.LayoutParams(-1, -1));
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      dismiss();
      xv.a("Dual initView failed!");
      return;
    }
    GameLoginSndConfirmView localGameLoginSndConfirmView = this.b;
    Object localObject2 = sq.a(RqdApplication.n()).d;
    if (localObject2 != null)
    {
      if (localGameLoginSndConfirmView.p == null)
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.token.update_btn_interval_time_action");
        localGameLoginSndConfirmView.g.registerReceiver(localGameLoginSndConfirmView.s, paramBundle);
        paramBundle = new Intent("com.tencent.token.update_btn_interval_time_action");
        localGameLoginSndConfirmView.p = ((AlarmManager)localGameLoginSndConfirmView.g.getSystemService("alarm"));
        localGameLoginSndConfirmView.q = PendingIntent.getBroadcast(localGameLoginSndConfirmView.g, 0, paramBundle, 0);
      }
      int j = ((CallbackPushStruct)localObject2).expirtTime;
      paramBundle = sq.a(RqdApplication.n());
      if ((paramBundle.d != null) && (paramBundle.g > 0L)) {
        i = (int)((rt.a().h() * 1000L - paramBundle.g) / 1000L);
      } else {
        i = 0;
      }
      localGameLoginSndConfirmView.r = (j + 1 - i);
      localGameLoginSndConfirmView.a.setText(2131493234);
      if (((CallbackPushStruct)localObject2).player.length() > 10)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(((CallbackPushStruct)localObject2).player.substring(0, 10));
        paramBundle.append("...");
        paramBundle = new StringBuffer(paramBundle.toString());
      }
      else
      {
        paramBundle = new StringBuffer(((CallbackPushStruct)localObject2).player);
      }
      localObject1 = "";
      if (paramBundle.length() != 0)
      {
        localObject1 = new StringBuilder("(<font color=#df642c>");
        ((StringBuilder)localObject1).append(paramBundle);
        ((StringBuilder)localObject1).append("</font>)");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramBundle = new StringBuilder();
      paramBundle.append(aay.b(((CallbackPushStruct)localObject2).uin));
      paramBundle.append((String)localObject1);
      paramBundle.append(localGameLoginSndConfirmView.g.getResources().getString(2131493222));
      paramBundle.append("<font color=#df642c>");
      paramBundle.append(((CallbackPushStruct)localObject2).gameName);
      paramBundle.append("-");
      paramBundle.append(((CallbackPushStruct)localObject2).world);
      paramBundle.append("</font>");
      paramBundle.append(localGameLoginSndConfirmView.g.getResources().getString(2131493223));
      paramBundle = new StringBuffer(paramBundle.toString());
      if (((CallbackPushStruct)localObject2).schemeFlag == 2) {
        paramBundle.append("。");
      } else {
        paramBundle.append(localGameLoginSndConfirmView.g.getString(2131493224));
      }
      localGameLoginSndConfirmView.b.setText(Html.fromHtml(paramBundle.toString()));
      paramBundle = localGameLoginSndConfirmView.d;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localGameLoginSndConfirmView.getResources().getString(2131493220));
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(localGameLoginSndConfirmView.r);
      ((StringBuilder)localObject1).append(")");
      paramBundle.setText(((StringBuilder)localObject1).toString());
      localGameLoginSndConfirmView.e.setText(localGameLoginSndConfirmView.getResources().getString(2131493231));
      paramBundle = tt.a().d(Long.parseLong(((CallbackPushStruct)localObject2).uin));
      if (paramBundle != null)
      {
        localObject1 = localGameLoginSndConfirmView.f;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramBundle.mRealUin);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramBundle.mUin);
        ((ImageView)localObject1).setImageDrawable(aau.a((String)localObject2, localStringBuilder.toString()));
        localGameLoginSndConfirmView.c.setText(paramBundle.mNickName);
      }
      else
      {
        localGameLoginSndConfirmView.c.setText("");
      }
      localGameLoginSndConfirmView.b();
    }
    setContentView(this.b);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        GameLoginSndConfirmDialog.b(GameLoginSndConfirmDialog.this).a();
        paramAnonymousDialogInterface = sq.a(RqdApplication.n());
        paramAnonymousDialogInterface.d = null;
        paramAnonymousDialogInterface.g = 0L;
        if (GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this) != null) {
          GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this).dismiss();
        }
      }
    });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.c))
    {
      this.c = true;
      GameLoginSndConfirmView localGameLoginSndConfirmView = this.b;
      localGameLoginSndConfirmView.t.post(new GameLoginSndConfirmView.a(localGameLoginSndConfirmView, localGameLoginSndConfirmView.j, localGameLoginSndConfirmView.k, localGameLoginSndConfirmView.l, localGameLoginSndConfirmView.m));
    }
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GameLoginSndConfirmDialog
 * JD-Core Version:    0.7.0.1
 */