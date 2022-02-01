package com.tencent.mobileqq.richstatus;

import com.tencent.smtt.sdk.WebView;

class StatusJsHandler$2
  implements Runnable
{
  StatusJsHandler$2(StatusJsHandler paramStatusJsHandler, String paramString1, String paramString2, WebView paramWebView) {}
  
  public void run()
  {
    String str = "javascript:" + this.VA + "(" + this.val$param + ")";
    try
    {
      this.d.loadUrl(str);
      if (this.VA.equals(this.this$0.cae))
      {
        this.this$0.cCD = false;
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (!this.VA.equals(this.this$0.cad));
      this.this$0.cCE = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler.2
 * JD-Core Version:    0.7.0.1
 */