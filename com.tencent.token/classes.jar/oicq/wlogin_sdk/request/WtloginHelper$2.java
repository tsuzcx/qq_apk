package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.RSACrypt;

class WtloginHelper$2
  extends Thread
{
  WtloginHelper$2(WtloginHelper paramWtloginHelper, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    new RSACrypt(WtloginHelper.access$100(this.this$0)).GenRSAKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.2
 * JD-Core Version:    0.7.0.1
 */