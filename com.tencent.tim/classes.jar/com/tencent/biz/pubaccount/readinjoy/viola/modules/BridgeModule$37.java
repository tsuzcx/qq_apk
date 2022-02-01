package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Collections;
import java.util.List;
import mix;
import org.json.JSONArray;
import org.json.JSONObject;

class BridgeModule$37
  implements Runnable
{
  BridgeModule$37(BridgeModule paramBridgeModule, List paramList, int paramInt, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Collections.sort(this.jq);
    JSONArray localJSONArray = mix.d(this.jq);
    ThreadManagerV2.getUIHandlerV2().post(new BridgeModule.37.1(this, localJSONObject, localJSONArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.37
 * JD-Core Version:    0.7.0.1
 */