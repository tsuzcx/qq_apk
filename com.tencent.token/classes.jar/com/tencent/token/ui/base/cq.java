package com.tencent.token.ui.base;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.dg;
import com.tencent.token.dw;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.encrypt.c;

class cq
  extends UserTask
{
  cq(cp paramcp) {}
  
  public f a(String... paramVarArgs)
  {
    paramVarArgs = dg.a(c.b(SecondVerifyDialog.b(this.a.a).getText().toString().trim().getBytes()));
    return dw.a().a(paramVarArgs, SecondVerifyDialog.d(this.a.a));
  }
  
  public void a(f paramf)
  {
    SecondVerifyDialog.a(this.a.a, false);
    this.a.a.a.dismiss();
    this.a.a.a = null;
    if (paramf.b())
    {
      h.a("perform2ndVerify success");
      this.a.a.dismiss();
      if (SecondVerifyDialog.e(this.a.a) != null)
      {
        paramf = new Message();
        paramf.what = 1012;
        paramf.arg1 = SecondVerifyDialog.d(this.a.a);
        SecondVerifyDialog.e(this.a.a).sendMessage(paramf);
      }
      return;
    }
    f.a(SecondVerifyDialog.c(this.a.a).getResources(), paramf);
    h.c("perform2ndVerify failed:" + paramf.a + "-" + paramf.b);
    Toast localToast = new Toast(SecondVerifyDialog.c(this.a.a));
    View localView = SecondVerifyDialog.c(this.a.a).getLayoutInflater().inflate(2130968780, null);
    localToast.setView(localView);
    localToast.setDuration(0);
    localToast.setGravity(17, 0, (int)(40.0F * IndexActivity.S_DENSITY));
    ((TextView)localView.findViewById(2131558987)).setText(paramf.c);
    localToast.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cq
 * JD-Core Version:    0.7.0.1
 */