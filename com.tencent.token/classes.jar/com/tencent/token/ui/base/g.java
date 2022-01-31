package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Intent;
import com.tencent.token.core.bean.a;
import com.tencent.token.dk;
import com.tencent.token.dm;
import com.tencent.token.ui.IndexActivity;

class g
  implements w
{
  g(DualMsgShowDialog paramDualMsgShowDialog) {}
  
  public void a()
  {
    this.a.dismiss();
    if (DualMsgShowDialog.a(this.a))
    {
      Intent localIntent = new Intent(DualMsgShowDialog.b(this.a), IndexActivity.class);
      localIntent.putExtra("intent.retcode", DualMsgShowDialog.c(this.a));
      DualMsgShowDialog.b(this.a).startActivity(localIntent);
    }
  }
  
  public void a(int paramInt)
  {
    if (DualMsgShowDialog.d(this.a) == 0) {}
    for (a locala = dm.a().a(DualMsgShowDialog.e(this.a));; locala = dk.a().a(DualMsgShowDialog.e(this.a)))
    {
      DualMsgShowDialog.a(this.a, locala, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.g
 * JD-Core Version:    0.7.0.1
 */