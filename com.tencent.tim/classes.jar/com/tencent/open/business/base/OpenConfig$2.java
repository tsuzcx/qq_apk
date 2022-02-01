package com.tencent.open.business.base;

import android.os.Bundle;
import arwt;
import arxs;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.c;
import org.json.JSONObject;

public class OpenConfig$2
  implements Runnable
{
  public OpenConfig$2(arxs paramarxs, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = HttpBaseUtil.D(HttpBaseUtil.a("https://qappcenterv6.3g.qq.com/cgi-bin/mapp/mapp_policy_config", "GET", this.val$params).response);
      arwt.d("OpenConfig", localJSONObject.toString());
      this.this$0.bX(localJSONObject);
      this.this$0.elh = 0;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        arwt.e("OpenConfig", localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.business.base.OpenConfig.2
 * JD-Core Version:    0.7.0.1
 */