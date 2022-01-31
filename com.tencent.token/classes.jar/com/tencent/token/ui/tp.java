package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.bd;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class tp
  extends bo
{
  tp(OpreateMsgActivity paramOpreateMsgActivity)
  {
    super(paramOpreateMsgActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a.mAdapter == null) || (this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {}
    d locald;
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
      locald = (d)paramMessage.obj;
      d.a(this.a.getResources(), (d)paramMessage.obj);
      e.c("Op msg load failed:" + locald.a + "-" + locald.b);
    } while ((103 != locald.a) && (110 != locald.a));
    this.a.mAdapter.a(locald.c);
    this.a.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tp
 * JD-Core Version:    0.7.0.1
 */