package com.tencent.open.agent;

import android.content.res.Resources;
import android.widget.Button;
import aroy;

public class AuthorityActivity$5
  implements Runnable
{
  AuthorityActivity$5(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    this.this$0.jf();
    this.this$0.hA.setText(2131696659);
    if (this.this$0.ekF == 0)
    {
      String str = this.this$0.getResources().getString(2131696654);
      this.this$0.hA.setTag(str);
    }
    for (;;)
    {
      this.this$0.hA.setEnabled(true);
      this.this$0.e(this.this$0.getResources().getString(2131696664), new aroy(this));
      return;
      this.this$0.hA.setTag(this.this$0.cBp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.5
 * JD-Core Version:    0.7.0.1
 */