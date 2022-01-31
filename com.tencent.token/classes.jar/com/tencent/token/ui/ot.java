package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Message;
import android.widget.EditText;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SecondVerifyDialog;

class ot
  extends cb
{
  ot(ModifyQQPwdActivity paramModifyQQPwdActivity)
  {
    super(paramModifyQQPwdActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1010: 
    case 1012: 
      if (this.a.mPwdTextView == null) {
        break;
      }
    }
    for (Object localObject = this.a.mPwdTextView.getText().toString(); 1 == paramMessage.arg1; localObject = null)
    {
      this.a.showUserDialog(2131230843, this.a.getResources().getString(2131230941) + (String)localObject, 2131230897, 2131230886, new ou(this, (String)localObject), null);
      return;
      if (1 != paramMessage.arg1) {
        break;
      }
      this.a.dismissDialog();
      paramMessage = new SecondVerifyDialog(this.a, 2131362182, this.a.mHandler, paramMessage.arg1);
      paramMessage.setCancelable(true);
      paramMessage.show();
      return;
      if (1 != paramMessage.arg1) {
        break;
      }
      this.a.dismissDialog();
      return;
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        this.a.showSuccessView();
        return;
      }
      localObject = (f)paramMessage.obj;
      f.a(this.a.getResources(), (f)localObject);
      h.c("modqqpwd: " + ((f)localObject).a + ", " + ((f)localObject).c + ", arg=" + paramMessage.arg1);
      if ((111 == ((f)localObject).a) || (110 == ((f)localObject).a) || (103 == ((f)localObject).a))
      {
        this.a.showUserDialog(2131231464, ((f)localObject).c, 2131230778, new ow(this));
        return;
      }
      this.a.showUserDialog(2131231464, ((f)localObject).c, 2131230897, null);
      return;
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        paramMessage = do.a().e();
        if (paramMessage == null)
        {
          ModifyQQPwdActivity.access$000(this.a, this.a.getResources().getString(2131230962));
          return;
        }
        ModifyQQPwdActivity.access$100(this.a, paramMessage);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        f.a(this.a.getResources(), paramMessage);
      }
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230881, 2131230886, new ox(this), new oy(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ot
 * JD-Core Version:    0.7.0.1
 */