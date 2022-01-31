package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class qu
  extends bo
{
  qu(NetActiveSetDirBySeqActivity paramNetActiveSetDirBySeqActivity)
  {
    super(paramNetActiveSetDirBySeqActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
        paramMessage.putExtra("title", this.a.getResources().getString(2131361846));
        paramMessage.putExtra("page_id", 10);
        this.a.startActivity(paramMessage);
        return;
      }
      break;
    case 3026: 
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
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    this.a.showToast(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qu
 * JD-Core Version:    0.7.0.1
 */