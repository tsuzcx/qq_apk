package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.widget.EditText;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class adv
  extends cb
{
  adv(UtilsModSetMobileStep1Activity paramUtilsModSetMobileStep1Activity)
  {
    super(paramUtilsModSetMobileStep1Activity);
  }
  
  public void handleMessage(Message paramMessage)
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
    paramMessage = (f)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      f.a(this.a.getResources(), paramMessage);
    }
    StringBuilder localStringBuilder = new StringBuilder().append("errcode").append(paramMessage.a).append(", ");
    if (paramMessage.a == 124) {}
    for (boolean bool = true;; bool = false)
    {
      h.c(bool);
      if (paramMessage.a != 124) {
        break;
      }
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, new adw(this));
      return;
    }
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adv
 * JD-Core Version:    0.7.0.1
 */