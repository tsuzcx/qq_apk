package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class rs
  extends bo
{
  rs(NetActiveVryQQTokenActivity paramNetActiveVryQQTokenActivity)
  {
    super(paramNetActiveVryQQTokenActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i = 1;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3027: 
      if (paramMessage.arg1 == 0)
      {
        if (NetActiveVryQQTokenActivity.access$000(this.a).mHaveMobile == 1) {}
        while (i != 0)
        {
          NetActiveVryQQTokenActivity.access$100(this.a);
          return;
          i = 0;
        }
        this.a.dismissDialog();
        this.a.setContentView(2130903105);
        this.a.findViewById(2131296656).setOnClickListener(NetActiveVryQQTokenActivity.access$200(this.a));
        NetActiveVryQQTokenActivity.access$302(this.a, this.a.findViewById(2131296651));
        NetActiveVryQQTokenActivity.access$300(this.a).setOnClickListener(NetActiveVryQQTokenActivity.access$400(this.a));
        NetActiveVryQQTokenActivity.access$502(this.a, (TextView)this.a.findViewById(2131296652));
        NetActiveVryQQTokenActivity.access$602(this.a, (TextView)this.a.findViewById(2131296654));
        NetActiveVryQQTokenActivity.access$702(this.a, (EditText)this.a.findViewById(2131296655));
        NetActiveVryQQTokenActivity.access$700(this.a).clearFocus();
        return;
      }
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
      return;
    case 3026: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        if (paramMessage.arg2 == 1) {}
        for (;;)
        {
          NetActiveVryQQTokenActivity.access$800(this.a, bool);
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
    paramMessage = (d)paramMessage.obj;
    this.a.showToast(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rs
 * JD-Core Version:    0.7.0.1
 */