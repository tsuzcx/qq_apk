package com.tencent.mobileqq.troop.jsp;

import apmj;
import org.json.JSONArray;
import org.json.JSONException;

public class TroopNoticeJsHandler$5
  implements Runnable
{
  public TroopNoticeJsHandler$5(apmj paramapmj, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(this.val$jsonData);
      int i = 0;
      int j = localJSONArray.length();
      while (i < j)
      {
        String str = localJSONArray.get(i).toString();
        this.this$0.Tj(str);
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.5
 * JD-Core Version:    0.7.0.1
 */