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
import com.tencent.token.global.RqdApplication;
import com.tencent.token.r;
import com.tencent.token.ui.IndexActivity;
import gameloginsdk.CallbackGameConfirmStruct;
import gameloginsdk.CallbackPushStruct;

final class af
  extends Handler
{
  af(GameLoginSndConfirmDialog paramGameLoginSndConfirmDialog) {}
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject1 = r.a(RqdApplication.i()).d();
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    if ((paramMessage.what == 3040) && (localObject1 != null))
    {
      if (GameLoginSndConfirmDialog.a(this.a) != null) {
        GameLoginSndConfirmDialog.a(this.a).dismiss();
      }
      i = paramMessage.arg1;
      j = paramMessage.arg2;
      localObject2 = (CallbackGameConfirmStruct)paramMessage.obj;
      paramMessage = ((CallbackGameConfirmStruct)localObject2).wording;
      localObject3 = GameLoginSndConfirmDialog.b(this.a);
      if (i != 2) {
        break label203;
      }
      ((GameLoginSndConfirmView)localObject3).c();
    }
    while (j != 0)
    {
      localObject1 = ((CallbackGameConfirmStruct)localObject2).errMsg;
      if (localObject1 != null)
      {
        paramMessage = (Message)localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        paramMessage = GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131361951) + "(" + j + ")";
      }
      new AlertDialog.Builder(GameLoginSndConfirmDialog.c(this.a)).setTitle(2131361808).setMessage(paramMessage).setPositiveButton(2131361800, new ag(this)).create().show();
      return;
      label203:
      ((GameLoginSndConfirmView)localObject3).b();
    }
    if (i == 1)
    {
      if ((paramMessage != null) && (paramMessage.length() > 0)) {
        break label477;
      }
      paramMessage = " " + ((CallbackPushStruct)localObject1).expirtTime + GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131362444);
    }
    label477:
    for (;;)
    {
      localObject1 = GameLoginSndConfirmDialog.c(this.a).getLayoutInflater().inflate(2130903218, null);
      localObject2 = new Toast(GameLoginSndConfirmDialog.c(this.a));
      ((Toast)localObject2).setView((View)localObject1);
      ((Toast)localObject2).setDuration(0);
      ((Toast)localObject2).setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
      localObject3 = (TextView)((View)localObject1).findViewById(2131296784);
      ((ImageView)((View)localObject1).findViewById(2131296783)).setBackgroundResource(2130837966);
      ((TextView)localObject3).setText(paramMessage);
      ((Toast)localObject2).show();
      return;
      if (i != 2) {
        break;
      }
      paramMessage = ((CallbackPushStruct)localObject1).gameName + GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131362445);
      new AlertDialog.Builder(GameLoginSndConfirmDialog.c(this.a)).setTitle(paramMessage).setMessage(GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131362446)).setPositiveButton(2131361901, new ai(this)).setNegativeButton(2131361804, new ah(this)).create().show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.af
 * JD-Core Version:    0.7.0.1
 */