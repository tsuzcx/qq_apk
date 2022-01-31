package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;

class abu
  extends cb
{
  abu(UtilsActivity paramUtilsActivity)
  {
    super(paramUtilsActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    Intent localIntent;
    switch (paramMessage.what)
    {
    default: 
      return;
    case -100: 
      UtilsActivity.access$600(this.a);
      return;
    case 3082: 
      localIntent = new Intent(this.a, FaceRecognitionCameraActivity.class);
      localIntent.putExtra("flag", 3);
      if (paramMessage.arg2 == 1) {
        localIntent.putExtra("actions", (int[])paramMessage.obj);
      }
      this.a.startActivityForResult(localIntent, 1);
      return;
    case 3003: 
      UtilsActivity.access$800(this.a)[UtilsActivity.access$900(this.a)][UtilsActivity.access$1000(this.a)] = 0;
      if (paramMessage.arg1 == 0)
      {
        if (do.a().e() == null) {
          this.a.showUserDialog(9);
        }
        for (;;)
        {
          UtilsActivity.access$1300(this.a);
          return;
          if (UtilsActivity.access$1100(this.a) != 7) {
            this.a.dismissDialog();
          }
          UtilsActivity.access$1200(this.a, UtilsActivity.access$1100(this.a), UtilsActivity.access$900(this.a), UtilsActivity.access$1000(this.a));
        }
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        f.a(this.a.getResources(), paramMessage);
      }
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
      return;
    case 3064: 
      UtilsActivity.access$800(this.a)[UtilsActivity.access$900(this.a)][UtilsActivity.access$1000(this.a)] = 0;
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (RealNameStatusResult)paramMessage.obj;
        localIntent = new Intent(this.a, RealNameActivity.class);
        localIntent.putExtra("realname_result", paramMessage);
        this.a.startActivity(localIntent);
        return;
      }
      if (paramMessage.arg1 == 165)
      {
        if (!RqdApplication.b)
        {
          UtilsActivity.access$1400(this.a);
          return;
        }
        UtilsActivity.access$1502(this.a, true);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 4104: 
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showUserDialog(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showUserDialog(this.a.getResources().getString(2131231411));
      return;
    }
    UtilsActivity.access$1600(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abu
 * JD-Core Version:    0.7.0.1
 */