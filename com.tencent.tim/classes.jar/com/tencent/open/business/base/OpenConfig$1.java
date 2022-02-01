package com.tencent.open.business.base;

import arxs;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenConfig$1
  implements Runnable
{
  public OpenConfig$1(arxs paramarxs) {}
  
  public void run()
  {
    String str = this.this$0.readFile("com.tencent.open.config.json");
    try
    {
      this.this$0.config = new JSONObject(str);
      arxs.a(this.this$0, true);
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.business.base.OpenConfig.1
 * JD-Core Version:    0.7.0.1
 */