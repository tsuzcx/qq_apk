package com.tencent.mobileqq.servlet;

import aneg.a;

class LoginVerifyServlet$3$2
  implements Runnable
{
  LoginVerifyServlet$3$2(LoginVerifyServlet.3 param3, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.cEW)
    {
      this.this$0.a.onSuccess(this.cds);
      return;
    }
    this.this$0.a.onFailure(-1, this.cds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.LoginVerifyServlet.3.2
 * JD-Core Version:    0.7.0.1
 */