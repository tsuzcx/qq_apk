package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.du;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class st
  extends cb
{
  st(OpreateMsgActivity paramOpreateMsgActivity)
  {
    super(paramOpreateMsgActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.mAdapter == null) || (this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {}
    f localf;
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      if (paramMessage.arg1 == 0)
      {
        this.a.mAdapter.a(true);
        this.a.mIsRefreshing = false;
        return;
      }
      if (OpreateMsgActivity.access$000(this.a) < 5)
      {
        OpreateMsgActivity.access$008(this.a);
        OpreateMsgActivity.access$100(this.a).a(this.a.mSource, this.a.mHandler);
        return;
      }
      this.a.finishRefresh(true);
      localf = (f)paramMessage.obj;
      f.a(this.a.getResources(), (f)paramMessage.obj);
      h.c("Op msg load failed:" + localf.a + "-" + localf.b);
    } while ((103 != localf.a) && (110 != localf.a));
    this.a.mAdapter.a(localf.c);
    this.a.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.st
 * JD-Core Version:    0.7.0.1
 */