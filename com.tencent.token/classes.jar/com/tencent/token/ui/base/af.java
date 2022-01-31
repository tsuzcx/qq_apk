package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.cj;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.IndexActivity;
import gameloginsdk.CallbackGameConfirmStruct;
import gameloginsdk.CallbackPushStruct;

class af
  extends Handler
{
  af(GameLoginSndConfirmDialog paramGameLoginSndConfirmDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = cj.a(RqdApplication.l()).d();
    int i;
    Object localObject2;
    if ((paramMessage.what == 3040) && (localObject1 != null))
    {
      if (GameLoginSndConfirmDialog.a(this.a) != null) {
        GameLoginSndConfirmDialog.a(this.a).dismiss();
      }
      i = paramMessage.arg1;
      int j = paramMessage.arg2;
      localObject2 = (CallbackGameConfirmStruct)paramMessage.obj;
      paramMessage = ((CallbackGameConfirmStruct)localObject2).wording;
      GameLoginSndConfirmDialog.b(this.a).a(i);
      if (j != 0)
      {
        localObject1 = ((CallbackGameConfirmStruct)localObject2).errMsg;
        if (localObject1 != null)
        {
          paramMessage = (Message)localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          paramMessage = GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131230963) + "(" + j + ")";
        }
        new AlertDialog.Builder(GameLoginSndConfirmDialog.c(this.a)).setTitle(2131230843).setMessage(paramMessage).setPositiveButton(2131230897, new ag(this)).create().show();
      }
    }
    else
    {
      return;
    }
    if (i == 1)
    {
      if ((paramMessage != null) && (paramMessage.length() > 0)) {
        break label461;
      }
      paramMessage = " " + ((CallbackPushStruct)localObject1).expirtTime + GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131231076);
    }
    label461:
    for (;;)
    {
      localObject1 = GameLoginSndConfirmDialog.c(this.a).getLayoutInflater().inflate(2130968780, null);
      localObject2 = new Toast(GameLoginSndConfirmDialog.c(this.a));
      ((Toast)localObject2).setView((View)localObject1);
      ((Toast)localObject2).setDuration(0);
      ((Toast)localObject2).setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131558987);
      ((ImageView)((View)localObject1).findViewById(2131558986)).setBackgroundResource(2130838018);
      localTextView.setText(paramMessage);
      ((Toast)localObject2).show();
      return;
      if (i != 2) {
        break;
      }
      paramMessage = ((CallbackPushStruct)localObject1).gameName + GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131231088);
      new AlertDialog.Builder(GameLoginSndConfirmDialog.c(this.a)).setTitle(paramMessage).setMessage(GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131231087)).setPositiveButton(2131231243, new ai(this)).setNegativeButton(2131230886, new ah(this)).create().show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.af
 * JD-Core Version:    0.7.0.1
 */