package com.tencent.open.agent;

import android.content.res.Resources;
import android.widget.Button;
import arro;
import com.tencent.qphone.base.util.QLog;

public class OpenAuthorityFragment$6
  implements Runnable
{
  OpenAuthorityFragment$6(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void run()
  {
    if (OpenAuthorityFragment.a(this.this$0))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " activity is isInvalid");
      return;
    }
    this.this$0.jf();
    if (OpenAuthorityFragment.c(this.this$0) == 0) {
      OpenAuthorityFragment.a(this.this$0).setTag(this.this$0.getResources().getString(2131696654));
    }
    for (;;)
    {
      OpenAuthorityFragment.a(this.this$0).setEnabled(true);
      this.this$0.e(this.this$0.getResources().getString(2131696664), new arro(this));
      return;
      OpenAuthorityFragment.a(this.this$0).setTag(OpenAuthorityFragment.d(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.6
 * JD-Core Version:    0.7.0.1
 */