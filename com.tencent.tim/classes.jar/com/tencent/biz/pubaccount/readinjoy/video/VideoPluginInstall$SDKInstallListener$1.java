package com.tencent.biz.pubaccount.readinjoy.video;

import kbp;
import msz;
import myj.b;
import org.json.JSONObject;

public class VideoPluginInstall$SDKInstallListener$1
  implements Runnable
{
  public VideoPluginInstall$SDKInstallListener$1(myj.b paramb, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "3.4.4");
      if (!this.val$success) {
        localJSONObject.put("error_code", this.val$errorCode);
      }
      if (this.val$success)
      {
        String str1 = "";
        if (!this.val$success) {
          break label126;
        }
        str3 = "1";
        kbp.a(null, null, "0X8009753", "0X8009753", 0, 0, str3, msz.h(false), str1, localJSONObject.toString(), false);
        if (!this.val$success) {
          kbp.a(null, null, "0X8009752", "0X8009752", 0, 0, str3, msz.h(false), str1, localJSONObject.toString(), false);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        String str2 = String.valueOf(this.val$errorCode);
        continue;
        label126:
        String str3 = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.SDKInstallListener.1
 * JD-Core Version:    0.7.0.1
 */