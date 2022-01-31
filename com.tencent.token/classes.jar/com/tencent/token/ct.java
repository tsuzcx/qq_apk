package com.tencent.token;

import java.util.TimerTask;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginListener;

class ct
  extends TimerTask
{
  ct(cp paramcp) {}
  
  public void run()
  {
    this.a.e.OnVerifyCode(null, null, 0L, null, new WUserSigInfo(), null, 8192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ct
 * JD-Core Version:    0.7.0.1
 */