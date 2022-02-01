package com.tencent.viola.vinstance;

import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

class VInstanceAction$1
  implements Runnable
{
  VInstanceAction$1(VInstanceAction paramVInstanceAction, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.this$0.violaInstance.renderJSSource(this.this$0.preconditor.getServiceJsCode(), this.val$data.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstanceAction.1
 * JD-Core Version:    0.7.0.1
 */