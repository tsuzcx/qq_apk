package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.bb;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.fo;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.gm;
import com.tencent.token.o;
import com.tencent.token.ui.base.ProDialog;

final class ol
  extends bo
{
  ol(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity)
  {
    super(paramLoginMsgReportLocationActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
    o localo = o.a();
    if (paramMessage.arg1 == 0)
    {
      int i = LoginMsgReportLocationActivity.access$000(this.a).mContent.indexOf('|');
      if (i == -1) {}
      for (Object localObject2 = LoginMsgReportLocationActivity.access$000(this.a).mContent;; localObject2 = LoginMsgReportLocationActivity.access$000(this.a).mContent.substring(0, i))
      {
        i = ((String)localObject2).indexOf(this.a.getResources().getString(2131362039));
        Object localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
        i = ((String)localObject1).indexOf(this.a.getResources().getString(2131362051));
        localObject2 = localObject1;
        if (i != -1) {
          localObject2 = ((String)localObject1).substring(0, i);
        }
        LoginMsgReportLocationActivity.access$000(this.a).mFlag |= 0x1;
        LoginMsgReportLocationActivity.access$000(this.a).mFlag |= 0x100;
        LoginMsgReportLocationActivity.access$102(this.a, localo.b[localo.e[LoginMsgReportLocationActivity.access$200(this.a)]]);
        if (!LoginMsgReportLocationActivity.access$100(this.a).equals(localo.c[LoginMsgReportLocationActivity.access$200(this.a)])) {
          LoginMsgReportLocationActivity.access$102(this.a, LoginMsgReportLocationActivity.access$100(this.a) + localo.c[LoginMsgReportLocationActivity.access$200(this.a)]);
        }
        LoginMsgReportLocationActivity.access$000(this.a).mContent = ((String)localObject2 + this.a.getResources().getString(2131362051) + "|" + LoginMsgReportLocationActivity.access$100(this.a));
        bb.a().f.a.a(LoginMsgReportLocationActivity.access$000(this.a).mId, LoginMsgReportLocationActivity.access$000(this.a).mFlag, LoginMsgReportLocationActivity.access$000(this.a).mContent);
        if (paramMessage.arg2 != 1) {
          break;
        }
        this.a.setContentView(2130903128);
        ((TextView)this.a.findViewById(2131296797)).setText(this.a.getResources().getString(2131362057) + "\"" + LoginMsgReportLocationActivity.access$100(this.a) + "\"?");
        this.a.mBackArrow.setVisibility(4);
        LoginMsgReportLocationActivity.access$302(this.a, true);
        this.a.findViewById(2131296798).setOnClickListener(new om(this, localo));
        this.a.findViewById(2131296799).setOnClickListener(new on(this, localo));
        return;
      }
      this.a.showOrangeToast(2131362050, 2130837966);
      this.a.finish();
      paramMessage = new Intent(b.e(), LoginMsgActivity.class);
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ol
 * JD-Core Version:    0.7.0.1
 */