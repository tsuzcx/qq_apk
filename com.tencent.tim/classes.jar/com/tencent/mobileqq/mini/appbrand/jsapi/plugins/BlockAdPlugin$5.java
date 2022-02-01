package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$5
  implements Runnable
{
  BlockAdPlugin$5(BlockAdPlugin paramBlockAdPlugin, int paramInt1, BlockAdInfo paramBlockAdInfo, int paramInt2, int paramInt3, JsRuntime paramJsRuntime) {}
  
  public void run()
  {
    Object localObject = BlockAdManager.getInstance().getBlockAdView(this.val$compId);
    if (localObject != null) {
      ((BlockAdView)localObject).setData(this.val$currentPosInfo);
    }
    boolean bool = ((GameActivity)this.this$0.jsPluginEngine.activityContext).updateBlockAdPosition(this.val$replaceLeft, this.val$replaceTop, this.val$compId);
    if (bool) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("state", "resize");
      ((JSONObject)localObject).put("compId", this.val$currentPosInfo.getCompId());
      ((JSONObject)localObject).put("width", this.val$currentPosInfo.getRealWidth());
      ((JSONObject)localObject).put("height", this.val$currentPosInfo.getRealHeight());
      BlockAdPlugin.access$000(this.this$0, this.val$webview, (JSONObject)localObject, "onBlockAdStateChange");
      QLog.i("[minigame] BlockAdPlugin", 1, "updateBlockAd " + bool + ", replaceLeft = " + this.val$replaceLeft + ", replaceTop = " + this.val$replaceTop);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("[minigame] BlockAdPlugin", 1, "updateBannerAd informJs error", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BlockAdPlugin.5
 * JD-Core Version:    0.7.0.1
 */