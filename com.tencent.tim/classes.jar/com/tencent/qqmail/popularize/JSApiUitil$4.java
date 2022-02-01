package com.tencent.qqmail.popularize;

import com.tencent.qqmail.utilities.log.QMLog;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

final class JSApiUitil$4
  implements Runnable
{
  JSApiUitil$4(String paramString1, String paramString2, String paramString3, JSApiUitil.JSAPIConentCallback paramJSAPIConentCallback) {}
  
  public void run()
  {
    Object localObject = "";
    try
    {
      if (this.val$type.equals("1"))
      {
        localObject = this.val$originalUrl;
        if (this.val$callback != null) {
          this.val$callback.onSuccess((String)localObject);
        }
      }
      else if (this.val$type.equals("2"))
      {
        localObject = new InputStreamReader(new URL(this.val$originalUrl).openConnection().getInputStream());
        StringBuilder localStringBuilder = new StringBuilder();
        for (;;)
        {
          int i = ((Reader)localObject).read();
          if (i < 0)
          {
            localObject = localStringBuilder.toString();
            break;
          }
          localStringBuilder.append((char)i);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "JSApiUitil", localException.getMessage());
        if (this.val$callback == null) {
          break;
        }
        this.val$callback.onError(localException.getMessage());
        return;
        if (this.val$type.equals("3")) {
          String str = this.val$content;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.4
 * JD-Core Version:    0.7.0.1
 */