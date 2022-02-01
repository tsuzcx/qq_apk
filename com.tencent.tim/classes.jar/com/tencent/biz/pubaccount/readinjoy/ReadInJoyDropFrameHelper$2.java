package com.tencent.biz.pubaccount.readinjoy;

import kbp;
import kgi;
import kxm;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDropFrameHelper$2
  implements Runnable
{
  public ReadInJoyDropFrameHelper$2(kgi paramkgi, String paramString, double paramDouble) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = kgi.a(this.this$0);
      localJSONObject.put("channelId", this.YZ);
      localJSONObject.put("fluency", this.aO);
      kbp.a(kxm.a(), "", "0X8009EFE", "0X8009EFE", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.2
 * JD-Core Version:    0.7.0.1
 */