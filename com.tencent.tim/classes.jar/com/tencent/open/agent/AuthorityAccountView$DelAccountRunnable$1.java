package com.tencent.open.agent;

import aqju;

class AuthorityAccountView$DelAccountRunnable$1
  implements Runnable
{
  AuthorityAccountView$DelAccountRunnable$1(AuthorityAccountView.DelAccountRunnable paramDelAccountRunnable, String paramString) {}
  
  public void run()
  {
    if ((AuthorityAccountView.a(this.a.this$0) instanceof AuthorityActivity)) {
      ((AuthorityActivity)AuthorityAccountView.a(this.a.this$0)).dt(this.cBn, false);
    }
    for (;;)
    {
      if (this.a.this$0.x != null)
      {
        this.a.this$0.x.dismiss();
        this.a.this$0.x = null;
      }
      return;
      if ((AuthorityAccountView.a(this.a.this$0) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)AuthorityAccountView.a(this.a.this$0)).dt(this.cBn, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.DelAccountRunnable.1
 * JD-Core Version:    0.7.0.1
 */