package com.tencent.open.base.http;

import arxh;
import arxh.a;
import java.util.HashMap;
import org.json.JSONObject;

public class HttpCgiAsyncTask$1
  implements Runnable
{
  public HttpCgiAsyncTask$1(arxh paramarxh, HashMap paramHashMap) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      if (((Integer)this.val$result.get("ResultType")).intValue() == 1) {
        this.this$0.b.ai((JSONObject)this.val$result.get("ResultValue"));
      }
    }
    else {
      return;
    }
    this.this$0.b.onException((Exception)this.val$result.get("ResultValue"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCgiAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */