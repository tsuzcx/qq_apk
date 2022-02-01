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
import com.tencent.token.bx;
import com.tencent.token.ca;
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
      Object localObject2 = bx.a(RqdApplication.n()).d();
      if ((paramAnonymousMessage.what == 3040) && (localObject2 != null))
      {
        if (GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this) != null) {
          GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this).dismiss();
        }
        int i = paramAnonymousMessage.arg1;
        int j = paramAnonymousMessage.arg2;
        paramAnonymousMessage = (CallbackGameConfirmStruct)paramAnonymousMessage.obj;
        Object localObject1 = paramAnonymousMessage.wording;
        GameLoginSndConfirmDialog.b(GameLoginSndConfirmDialog.this).a(i);
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
            paramAnonymousMessage.append(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493106));
            paramAnonymousMessage.append("(");
            paramAnonymousMessage.append(j);
            paramAnonymousMessage.append(")");
            paramAnonymousMessage = paramAnonymousMessage.toString();
          }
          new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131492986).setMessage(paramAnonymousMessage).setPositiveButton(2131493040, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
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
            paramAnonymousMessage = new StringBuilder();
            paramAnonymousMessage.append(" ");
            paramAnonymousMessage.append(((CallbackPushStruct)localObject2).expirtTime);
            paramAnonymousMessage.append(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493219));
            paramAnonymousMessage = paramAnonymousMessage.toString();
          }
          localObject1 = GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getLayoutInflater().inflate(2131296461, null);
          localObject2 = new Toast(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this));
          ((Toast)localObject2).setView((View)localObject1);
          ((Toast)localObject2).setDuration(0);
          ((Toast)localObject2).setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
          TextView localTextView = (TextView)((View)localObject1).findViewById(2131166120);
          ((ImageView)((View)localObject1).findViewById(2131166118)).setBackgroundResource(2131100167);
          localTextView.setText(paramAnonymousMessage);
          ((Toast)localObject2).show();
          return;
        }
        if (i == 2)
        {
          paramAnonymousMessage = new StringBuilder();
          paramAnonymousMessage.append(((CallbackPushStruct)localObject2).gameName);
          paramAnonymousMessage.append(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493231));
          paramAnonymousMessage = paramAnonymousMessage.toString();
          new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(paramAnonymousMessage).setMessage(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493230)).setPositiveButton(2131493386, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              GameLoginSndConfirmDialog.this.dismiss();
              paramAnonymous2DialogInterface = new Intent(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this), ModifyQQPwdActivity.class);
              o.a().a(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this), paramAnonymous2DialogInterface, o.b);
            }
          }).setNegativeButton(2131493029, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.dismiss();
              GameLoginSndConfirmDialog.this.dismiss();
            }
          }).create().show();
        }
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
        Object localObject = bx.a(RqdApplication.n());
        CallbackPushStruct localCallbackPushStruct = ((bx)localObject).d();
        if (localCallbackPushStruct != null)
        {
          ((bx)localObject).a(localCallbackPushStruct.uin, ca.a(RqdApplication.n()).b(), paramAnonymousInt, GameLoginSndConfirmDialog.d(GameLoginSndConfirmDialog.this));
          if (GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this) == null)
          {
            localObject = GameLoginSndConfirmDialog.this;
            GameLoginSndConfirmDialog.a((GameLoginSndConfirmDialog)localObject, new ProDialog(GameLoginSndConfirmDialog.c((GameLoginSndConfirmDialog)localObject), 2131558791));
          }
          GameLoginSndConfirmDialog.a(GameLoginSndConfirmDialog.this).show();
        }
      }
      
      public void b()
      {
        CallbackPushStruct localCallbackPushStruct = bx.a(RqdApplication.n()).d();
        if (localCallbackPushStruct != null) {
          if (localCallbackPushStruct.schemeFlag == 2)
          {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131492986);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(localCallbackPushStruct.expirtTime);
            localStringBuilder.append(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493224));
            localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton(2131493225, new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                paramAnonymous2DialogInterface.dismiss();
                GameLoginSndConfirmDialog.this.dismiss();
              }
            }).create().show();
          }
          else
          {
            new AlertDialog.Builder(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this)).setTitle(2131492986).setMessage(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).getResources().getString(2131493223)).setPositiveButton(2131493228, new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GameLoginSndConfirmDialog.this.dismiss();
                paramAnonymous2DialogInterface = new Intent(GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this), VerifyStartScanActivity.class);
                GameLoginSndConfirmDialog.c(GameLoginSndConfirmDialog.this).startActivity(paramAnonymous2DialogInterface);
              }
            }).setNegativeButton(2131493029, new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
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
    if (!this.b.a(this.a))
    {
      dismiss();
      g.a("Dual initView failed!");
      return;
    }
    this.b.a(bx.a(RqdApplication.n()).d());
    setContentView(this.b);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        GameLoginSndConfirmDialog.b(GameLoginSndConfirmDialog.this).d();
        bx.a(RqdApplication.n()).e();
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