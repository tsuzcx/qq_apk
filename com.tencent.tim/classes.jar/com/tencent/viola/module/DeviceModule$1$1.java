package com.tencent.viola.module;

import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

class DeviceModule$1$1
  implements Runnable
{
  DeviceModule$1$1(DeviceModule.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    ViolaBridgeManager.getInstance().callbackJavascript(this.this$1.this$0.getViolaInstance().getInstanceId(), "device", "callback", this.this$1.val$callback, this.val$jsonObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.module.DeviceModule.1.1
 * JD-Core Version:    0.7.0.1
 */