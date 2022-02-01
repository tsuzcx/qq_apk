package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.bw;
import com.tencent.token.bz;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.ModifyQQPwdActivity;
import com.tencent.token.ui.VerifyStartScanActivity;
import com.tencent.token.ui.o;
import gameloginsdk.CallbackGameConfirmStruct;
import gameloginsdk.CallbackPushStruct;

public class GameLoginSndConfirmDialog
  extends Dialog
{
  private Activity a;
  private GameLoginSndConfirmView b;
  private boolean c = false;
  private ProDialog d;
  private Handler e = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject1 = bw.a(RqdApplication.l()).d();
      int i;
      Object localObject2;
      if ((paramAnonymousMessage.what == 3040) && (localObject1 != null))
      {
        if (GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this) != null) {
          GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this).dismiss();
        }
        i = paramAnonymousMessage.arg1;
        int j = paramAnonymousMessage.arg2;
        localObject2 = (CallbackGameConfirmStruct)paramAnonymousMessage.obj;
        paramAnonymousMessage = ((CallbackGameConfirmStruct)localObject2).wording;
        GameLoginSndConfirmDialog.b(GameLoginSndConfirmDialog.this).a(i);
        if (j != 0)
        {
          localObject1 = ((CallbackGameConfirmStruct)localObject2).errMsg;
          if (localObject1 != null)
          {
            paramAnonymousMessage = (Message)localObject1;
            if (((String)localObject1).length() > 0) {}
          }
          else
          {
            paramAnonymousMessage = GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131230963) + "(" + j + ")";
          }
          new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131230843).setMessage(paramAnonymousMessage).setPositiveButton(2131230897, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              GameLoginSndConfirmDialog.this.dismiss();
            }
          }).create().show();
        }
      }
      else
      {
        return;
      }
      if (i == 1)
      {
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.length() > 0)) {
          break label461;
        }
        paramAnonymousMessage = " " + ((CallbackPushStruct)localObject1).expirtTime + GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131231076);
      }
      label461:
      for (;;)
      {
        localObject1 = GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getLayoutInflater().inflate(2130968780, null);
        localObject2 = new Toast(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this));
        ((Toast)localObject2).setView((View)localObject1);
        ((Toast)localObject2).setDuration(0);
        ((Toast)localObject2).setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131558988);
        ((ImageView)((View)localObject1).findViewById(2131558987)).setBackgroundResource(2130838018);
        localTextView.setText(paramAnonymousMessage);
        ((Toast)localObject2).show();
        return;
        if (i != 2) {
          break;
        }
        paramAnonymousMessage = ((CallbackPushStruct)localObject1).gameName + GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131231088);
        new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(paramAnonymousMessage).setMessage(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131231087)).setPositiveButton(2131231243, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
            GameLoginSndConfirmDialog.this.dismiss();
            paramAnonymous2DialogInterface = new Intent(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this), ModifyQQPwdActivity.class);
            o.a().a(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this), paramAnonymous2DialogInterface, o.b);
          }
        }).setNegativeButton(2131230886, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
            GameLoginSndConfirmDialog.this.dismiss();
          }
        }).create().show();
        return;
      }
    }
  };
  
  public GameLoginSndConfirmDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new GameLoginSndConfirmView(this.a);
    this.b.setListener(new GameLoginSndConfirmView.e()
    {
      public void a()
      {
        GameLoginSndConfirmDialog.this.dismiss();
      }
      
      public void a(int paramAnonymousInt)
      {
        bw localbw = bw.a(RqdApplication.l());
        CallbackPushStruct localCallbackPushStruct = localbw.d();
        if (localCallbackPushStruct != null)
        {
          localbw.a(localCallbackPushStruct.uin, bz.a(RqdApplication.l()).b(), paramAnonymousInt, GameLoginSndConfirmDialog.d(GameLoginSndConfirmDialog.this));
          if (GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this) == null) {
            GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this, new ProDialog(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this), 2131362182));
          }
          GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this).show();
        }
      }
      
      public void b()
      {
        CallbackPushStruct localCallbackPushStruct = bw.a(RqdApplication.l()).d();
        if (localCallbackPushStruct != null)
        {
          if (localCallbackPushStruct.schemeFlag != 2) {
            break label111;
          }
          new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131230843).setMessage("" + localCallbackPushStruct.expirtTime + GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131231081)).setPositiveButton(2131231082, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              GameLoginSndConfirmDialog.this.dismiss();
            }
          }).create().show();
        }
        for (;;)
        {
          GameLoginSndConfirmDialog.this.dismiss();
          return;
          label111:
          new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131230843).setMessage(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131231080)).setPositiveButton(2131231085, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GameLoginSndConfirmDialog.this.dismiss();
              paramAnonymous2DialogInterface = new Intent(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this), VerifyStartScanActivity.class);
              GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).startActivity(paramAnonymous2DialogInterface);
            }
          }).setNegativeButton(2131230886, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              GameLoginSndConfirmDialog.this.dismiss();
            }
          }).create().show();
        }
      }
    });
    if (!this.b.a(this.a))
    {
      dismiss();
      g.a("Dual initView failed!");
      return;
    }
    this.b.a(bw.a(RqdApplication.l()).d());
    setContentView(this.b);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        GameLoginSndConfirmDialog.b(GameLoginSndConfirmDialog.this).d();
        bw.a(RqdApplication.l()).e();
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
      this.b.a();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GameLoginSndConfirmDialog
 * JD-Core Version:    0.7.0.1
 */