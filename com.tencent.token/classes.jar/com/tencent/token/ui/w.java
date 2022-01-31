package com.tencent.token.ui;

import android.widget.RelativeLayout;
import com.tmsdk.TMSDKContext;

class w
  implements Runnable
{
  w(u paramu, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    AccountPageActivity.access$3500(this.c.a).setVisibility(0);
    AccountPageActivity.access$3500(this.c.a).setOnClickListener(new x(this));
    TMSDKContext.saveActionData(1150114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.w
 * JD-Core Version:    0.7.0.1
 */