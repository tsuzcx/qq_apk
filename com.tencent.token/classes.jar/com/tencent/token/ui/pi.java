package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Message;
import android.widget.EditText;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.SecondVerifyDialog;
import com.tencent.token.x;

final class pi
  extends bo
{
  pi(ModifyQQPwdActivity paramModifyQQPwdActivity)
  {
    super(paramModifyQQPwdActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
      this.a.showUserDialog(2131361808, this.a.getResources().getString(2131361930) + (String)localObject, 2131361800, 2131361804, new pj(this, (String)localObject), null);
      return;
      if (1 != paramMessage.arg1) {
        break;
      }
      this.a.dismissDialog();
      paramMessage = new SecondVerifyDialog(this.a, this.a.mHandler, paramMessage.arg1);
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
        paramMessage = ax.a().e();
        if (paramMessage == null) {
          break;
        }
        x.a(RqdApplication.i()).a("" + paramMessage.mRealUin, this.a.mPwdText, 523005419L);
        x.a(RqdApplication.i()).a("" + paramMessage.mRealUin, this.a.mPwdText, 523005425L);
        return;
      }
      localObject = (d)paramMessage.obj;
      d.a(this.a.getResources(), (d)localObject);
      e.c("modqqpwd: " + ((d)localObject).a + ", " + ((d)localObject).c + ", arg=" + paramMessage.arg1);
      if ((111 == ((d)localObject).a) || (110 == ((d)localObject).a) || (103 == ((d)localObject).a))
      {
        this.a.showUserDialog(2131361933, ((d)localObject).c, 2131362297, new pl(this));
        return;
      }
      this.a.showUserDialog(2131361933, ((d)localObject).c, 2131361800, null);
      return;
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        paramMessage = ax.a().e();
        if (paramMessage == null)
        {
          ModifyQQPwdActivity.access$000(this.a, this.a.getResources().getString(2131361945));
          return;
        }
        ModifyQQPwdActivity.access$100(this.a, paramMessage);
        return;
      }
      paramMessage = (d)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        d.a(this.a.getResources(), paramMessage);
      }
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361914, 2131361804, new pm(this), new pn(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pi
 * JD-Core Version:    0.7.0.1
 */