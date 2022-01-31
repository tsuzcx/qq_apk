package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cx;
import com.tencent.token.global.f;

class qu
  extends cb
{
  qu(NetActiveVryOtherListActivity paramNetActiveVryOtherListActivity)
  {
    super(paramNetActiveVryOtherListActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      paramMessage = cx.c();
      paramMessage.i();
      paramMessage.n();
      paramMessage = NetActiveVryOtherListActivity.access$100(this.a).mRealUin + "";
      Intent localIntent = new Intent(this.a, VerifySuccActivity.class);
      localIntent.putExtra("mRealUin", Long.parseLong(paramMessage));
      localIntent.putExtra("mMobile", "");
      localIntent.putExtra("isHaveMobie", false);
      localIntent.putExtra("bindMobileSucc", true);
      if ((NetActiveVryOtherListActivity.access$200(this.a) != null) && (NetActiveVryOtherListActivity.access$200(this.a).c() == 2)) {
        localIntent.putExtra("mSourceId", 1);
      }
      this.a.startActivity(localIntent);
      this.a.finish();
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qu
 * JD-Core Version:    0.7.0.1
 */