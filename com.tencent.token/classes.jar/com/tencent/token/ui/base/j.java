package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Intent;
import com.tencent.token.at;
import com.tencent.token.av;
import com.tencent.token.core.bean.b;
import com.tencent.token.ui.IndexActivity;

final class j
  implements z
{
  j(DualMsgShowDialog paramDualMsgShowDialog) {}
  
  public final void a()
  {
    this.a.dismiss();
    if (DualMsgShowDialog.a(this.a))
    {
      Intent localIntent = new Intent(DualMsgShowDialog.b(this.a), IndexActivity.class);
      localIntent.putExtra("intent.retcode", DualMsgShowDialog.c(this.a));
      DualMsgShowDialog.b(this.a).startActivity(localIntent);
    }
  }
  
  public final void a(int paramInt)
  {
    if (DualMsgShowDialog.d(this.a) == 0) {}
    for (b localb = av.a().a(DualMsgShowDialog.e(this.a));; localb = at.a().a(DualMsgShowDialog.e(this.a)))
    {
      DualMsgShowDialog.a(this.a, localb, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.j
 * JD-Core Version:    0.7.0.1
 */