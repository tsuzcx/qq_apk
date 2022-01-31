package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;

class mr
  implements DialogInterface.OnClickListener
{
  mr(mq parammq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.curruser != null)
    {
      if (!this.a.a.curruser.mIsBinded)
      {
        IndexActivity.access$600(this.a.a, this.a.a.curruser);
        do.a().n();
        paramDialogInterface = new Intent(this.a.a, IndexActivity.class);
        paramDialogInterface.putExtra("index_from", 16);
        this.a.a.startActivity(paramDialogInterface);
        this.a.a.showUserDialog(0, this.a.a.getString(2131230763) + this.a.a.curruser.mRealUin + this.a.a.getString(2131231511), 2131230897, IndexActivity.access$700(this.a.a), IndexActivity.access$800(this.a.a));
        this.a.a.remsumeMenu();
      }
    }
    else {
      return;
    }
    long l = this.a.a.curruser.mUin;
    cw.a().g(l, IndexActivity.access$100(this.a.a));
    this.a.a.showProDialog(this.a.a, 2131230843, 2131231517, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mr
 * JD-Core Version:    0.7.0.1
 */