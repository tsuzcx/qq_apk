package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.core.bean.JLProtectionInfo;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class kn
  extends bo
{
  kn(FindItemsActivity paramFindItemsActivity)
  {
    super(paramFindItemsActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    e.b("jianling what=" + paramMessage.what + ", arg1=" + paramMessage.arg1);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      FindItemsActivity.access$002(this.a, (JLProtectionInfo)paramMessage.obj);
      paramMessage = new Intent(this.a, JLFindItems.class);
      paramMessage.putExtra("is_xy", FindItemsActivity.access$000(this.a).is_xy);
      paramMessage.putExtra("detail_max", FindItemsActivity.access$000(this.a).detail_max);
      paramMessage.putExtra("detail_min", FindItemsActivity.access$000(this.a).detail_min);
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("get jianling protection failed:" + paramMessage.a + "-" + paramMessage.b);
    if ((111 == paramMessage.a) || (110 == paramMessage.a) || (103 == paramMessage.a))
    {
      this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362193), 2131362297, 2131361804, new ko(this), null);
      return;
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361914, 2131361804, new kp(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kn
 * JD-Core Version:    0.7.0.1
 */