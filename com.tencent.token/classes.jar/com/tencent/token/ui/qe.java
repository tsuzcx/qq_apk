package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class qe
  extends cb
{
  qe(NetActiveSetDirBySeqActivity paramNetActiveSetDirBySeqActivity)
  {
    super(paramNetActiveSetDirBySeqActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3003: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        paramMessage = new Intent(this.a, UtilsModSetMobileStep1Activity.class);
        paramMessage.putExtra("op_type", 1);
        paramMessage.putExtra("title", this.a.getResources().getString(2131230788));
        paramMessage.putExtra("page_id", 10);
        this.a.startActivity(paramMessage);
        return;
      }
      break;
    case 4004: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        if (paramMessage.arg2 == 1) {}
        for (;;)
        {
          NetActiveSetDirBySeqActivity.access$000(this.a, bool);
          return;
          bool = false;
        }
      }
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showToast(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qe
 * JD-Core Version:    0.7.0.1
 */