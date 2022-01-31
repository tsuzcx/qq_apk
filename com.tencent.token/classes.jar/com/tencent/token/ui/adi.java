package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import com.tencent.token.ax;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;

final class adi
  extends bo
{
  adi(UtilsActivity paramUtilsActivity)
  {
    super(paramUtilsActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
      UtilsActivity.access$400(this.a);
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
      UtilsActivity.access$600(this.a)[UtilsActivity.access$700(this.a)] = 0;
      if (paramMessage.arg1 == 0)
      {
        if (ax.a().e() == null)
        {
          this.a.showUserDialog(9);
          return;
        }
        if (UtilsActivity.access$700(this.a) != 8) {
          this.a.dismissDialog();
        }
        UtilsActivity.access$800(this.a, UtilsActivity.access$700(this.a));
        return;
      }
      this.a.dismissDialog();
      paramMessage = (d)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        d.a(this.a.getResources(), paramMessage);
      }
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
      return;
    }
    UtilsActivity.access$600(this.a)[8] = 0;
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
        UtilsActivity.access$900(this.a);
        return;
      }
      UtilsActivity.access$1002(this.a, true);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adi
 * JD-Core Version:    0.7.0.1
 */