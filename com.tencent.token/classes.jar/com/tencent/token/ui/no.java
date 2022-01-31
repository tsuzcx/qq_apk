package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.cg;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.ds;
import com.tencent.token.er;
import com.tencent.token.gb;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.ui.base.ProDialog;

class no
  extends cb
{
  no(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity)
  {
    super(paramLoginMsgReportLocationActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.dismissDialog();
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (this.a.mDialogPro != null)
    {
      this.a.mDialogPro.dismiss();
      this.a.mDialogPro = null;
    }
    cg localcg = cg.a();
    if (paramMessage.arg1 == 0)
    {
      int i = LoginMsgReportLocationActivity.access$000(this.a).mContent.indexOf('|');
      if (i == -1) {}
      for (Object localObject2 = LoginMsgReportLocationActivity.access$000(this.a).mContent;; localObject2 = LoginMsgReportLocationActivity.access$000(this.a).mContent.substring(0, i))
      {
        i = ((String)localObject2).indexOf(this.a.getResources().getString(2131231128));
        Object localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
        i = ((String)localObject1).indexOf(this.a.getResources().getString(2131231177));
        localObject2 = localObject1;
        if (i != -1) {
          localObject2 = ((String)localObject1).substring(0, i);
        }
        LoginMsgReportLocationActivity.access$000(this.a).mFlag |= 0x1;
        LoginMsgReportLocationActivity.access$000(this.a).mFlag |= 0x100;
        LoginMsgReportLocationActivity.access$102(this.a, localcg.b[localcg.e[LoginMsgReportLocationActivity.access$200(this.a)]]);
        if (!LoginMsgReportLocationActivity.access$100(this.a).equals(localcg.c[LoginMsgReportLocationActivity.access$200(this.a)])) {
          LoginMsgReportLocationActivity.access$102(this.a, LoginMsgReportLocationActivity.access$100(this.a) + localcg.c[LoginMsgReportLocationActivity.access$200(this.a)]);
        }
        LoginMsgReportLocationActivity.access$000(this.a).mContent = ((String)localObject2 + this.a.getResources().getString(2131231177) + "|" + LoginMsgReportLocationActivity.access$100(this.a));
        ds.a().f.a.a(LoginMsgReportLocationActivity.access$000(this.a).a(), LoginMsgReportLocationActivity.access$000(this.a).mFlag, LoginMsgReportLocationActivity.access$000(this.a).mContent);
        if (paramMessage.arg2 != 1) {
          break;
        }
        this.a.setContentView(2130968685);
        ((TextView)this.a.findViewById(2131559001)).setText(this.a.getResources().getString(2131231174) + "\"" + LoginMsgReportLocationActivity.access$100(this.a) + "\"?");
        this.a.mBackArrow.setVisibility(4);
        LoginMsgReportLocationActivity.access$302(this.a, true);
        this.a.findViewById(2131559002).setOnClickListener(new np(this, localcg));
        this.a.findViewById(2131559003).setOnClickListener(new nq(this, localcg));
        return;
      }
      this.a.showOrangeToast(2131231181, 2130838018);
      this.a.finish();
      paramMessage = new Intent(c.g(), LoginMsgActivity.class);
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      f.a(this.a.getResources(), paramMessage);
    }
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.no
 * JD-Core Version:    0.7.0.1
 */