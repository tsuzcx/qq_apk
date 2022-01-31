package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.widget.EditText;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class afg
  extends bo
{
  afg(UtilsModSetMobileStep1Activity paramUtilsModSetMobileStep1Activity)
  {
    super(paramUtilsModSetMobileStep1Activity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a.isFinishing()) || (UtilsModSetMobileStep1Activity.access$000(this.a) == null) || (UtilsModSetMobileStep1Activity.access$000(this.a).getText() == null)) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      UtilsModSetMobileStep1Activity.access$102(this.a, (String)paramMessage.obj);
      paramMessage = new Intent(this.a, UtilsModSetMobileStep2Activity.class);
      paramMessage.putExtra("title", UtilsModSetMobileStep1Activity.access$200(this.a));
      paramMessage.putExtra("op_type", UtilsModSetMobileStep1Activity.access$300(this.a));
      paramMessage.putExtra("mobile", UtilsModSetMobileStep1Activity.access$000(this.a).getText().toString());
      paramMessage.putExtra("area_code", UtilsModSetMobileStep1Activity.access$400(this.a));
      paramMessage.putExtra("sms_prefix", UtilsModSetMobileStep1Activity.access$100(this.a));
      paramMessage.putExtra("page_id", UtilsModSetMobileStep1Activity.access$500(this.a));
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    StringBuilder localStringBuilder = new StringBuilder().append("errcode").append(paramMessage.a).append(", ");
    if (paramMessage.a == 124) {}
    for (boolean bool = true;; bool = false)
    {
      e.c(bool);
      if (paramMessage.a != 124) {
        break;
      }
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, new afh(this));
      return;
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afg
 * JD-Core Version:    0.7.0.1
 */