package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

class EngineManager$EngineChannelReceiver$3
  implements AsyncResult
{
  EngineManager$EngineChannelReceiver$3(EngineManager.EngineChannelReceiver paramEngineChannelReceiver, int paramInt, EngineChannel paramEngineChannel) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("EngineManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(this.val$baseLibType)));
      QMLog.i("EngineManager", "[MiniEng] engineLibInfo " + paramJSONObject);
      EngineManager.access$500(this.this$1.this$0, paramJSONObject, this.val$remote);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver.3
 * JD-Core Version:    0.7.0.1
 */