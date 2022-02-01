package com.tencent.biz.pubaccount.readinjoy.video;

import java.net.URL;
import msg;
import org.json.JSONObject;

public class ReadInJoyWebDataManager$3
  implements Runnable
{
  public ReadInJoyWebDataManager$3(msg parammsg, URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = msg.access$200();
    try
    {
      msg.access$302(l);
      if (msg.access$300() > 52428800L) {
        return;
      }
    }
    finally {}
    this.this$0.a(this.h.toString(), this.val$jsonParams, this.val$callback, this.R);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.3
 * JD-Core Version:    0.7.0.1
 */