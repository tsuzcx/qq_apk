package com.tencent.sonic.sdk;

import org.json.JSONObject;

class SonicSession$5
  implements Runnable
{
  SonicSession$5(SonicSession paramSonicSession, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.this$0.diffDataCallback != null)
    {
      this.this$0.diffDataCallback.callback(this.val$json.toString());
      this.this$0.statistics.diffDataCallbackTime = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession.5
 * JD-Core Version:    0.7.0.1
 */