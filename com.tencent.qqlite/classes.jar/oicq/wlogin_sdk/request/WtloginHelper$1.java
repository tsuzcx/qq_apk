package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

class WtloginHelper$1
  extends Thread
{
  WtloginHelper$1(WtloginHelper paramWtloginHelper, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    new RSACrypt(WtloginHelper.access$000(this.this$0)).GenRSAKey();
    util.LOGD("async rsakey Done!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.1
 * JD-Core Version:    0.7.0.1
 */