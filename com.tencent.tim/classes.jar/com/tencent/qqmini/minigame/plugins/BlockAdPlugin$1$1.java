package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.model.BlockAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$1$1
  implements AdProxy.IBlockAdListener
{
  BlockAdPlugin$1$1(BlockAdPlugin.1 param1) {}
  
  public void onADClicked()
  {
    QMLog.i("BlockAdPlugin", "onADClicked");
  }
  
  public void onADClosed()
  {
    QMLog.i("BlockAdPlugin", "onADClosed");
  }
  
  public void onADExposure()
  {
    QMLog.i("BlockAdPlugin", "onADExposure");
  }
  
  public void onADReceive(int paramInt1, int paramInt2, int paramInt3)
  {
    QMLog.i("BlockAdPlugin", "onADReceive");
    if (this.this$1.val$adInfo == null) {
      return;
    }
    this.this$1.val$adInfo.setRealWidth(paramInt2);
    this.this$1.val$adInfo.setRealHeight(paramInt3);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "load");
      localJSONObject.put("adUnitId", this.this$1.val$adInfo.getAdUnitId());
      localJSONObject.put("compId", this.this$1.val$adInfo.getCompId());
      localJSONObject.put("realAdNum", paramInt1);
      localJSONObject.put("realWidth", this.this$1.val$adInfo.getRealWidth());
      localJSONObject.put("realHeight", this.this$1.val$adInfo.getRealHeight());
      BlockAdPlugin.access$200(this.this$1.this$0, this.this$1.val$req, localJSONObject, "onBlockAdStateChange");
      localJSONObject = new JSONObject();
      localJSONObject.put("state", "resize");
      localJSONObject.put("compId", this.this$1.val$adInfo.getCompId());
      localJSONObject.put("width", paramInt2);
      localJSONObject.put("height", paramInt3);
      BlockAdPlugin.access$200(this.this$1.this$0, this.this$1.val$req, localJSONObject, "onBlockAdStateChange");
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("BlockAdPlugin", "informJs success", localJSONException);
    }
  }
  
  public void onNoAD(int paramInt, String paramString)
  {
    QMLog.i("BlockAdPlugin", "onNoAD, errCode = " + paramInt + ", errMsg = " + paramString);
    BlockAdPlugin.access$100(this.this$1.this$0, this.this$1.val$req, paramInt, paramString, this.this$1.val$adInfo.getCompId(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */