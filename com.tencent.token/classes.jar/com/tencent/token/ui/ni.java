package com.tencent.token.ui;

import com.tencent.token.ui.base.PullToRefreshListView;

class ni
  implements Runnable
{
  ni(LoginMsgActivity paramLoginMsgActivity, int paramInt) {}
  
  public void run()
  {
    try
    {
      LoginMsgActivity.access$1100(this.b).requestFocusFromTouch();
      LoginMsgActivity.access$1100(this.b).setSelection(this.a);
      LoginMsgActivity.access$1100(this.b).requestFocus();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ni
 * JD-Core Version:    0.7.0.1
 */