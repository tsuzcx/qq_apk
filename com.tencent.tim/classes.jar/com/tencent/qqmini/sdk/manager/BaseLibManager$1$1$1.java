package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

class BaseLibManager$1$1$1
  implements Runnable
{
  BaseLibManager$1$1$1(BaseLibManager.1.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    BaseLibInfo localBaseLibInfo2 = BaseLibInfo.fromJSON(this.val$obj.optJSONObject(BaseLibInfo.getKey(2)));
    JSONObject localJSONObject = this.val$obj.optJSONObject(BaseLibInfo.getKey(3));
    BaseLibInfo localBaseLibInfo1 = BaseLibInfo.fromJSON(localJSONObject);
    QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] gameEngineLib " + localBaseLibInfo2 + ", miniAppEnginLib " + localJSONObject);
    if ((TextUtils.isEmpty(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getSoPath())) || (!"1.16.0.00063".equals(this.this$2.val$baseLibVersion)))
    {
      if (LocalGameEngine.g().isWnsConfigModel()) {
        break label131;
      }
      if (localBaseLibInfo2 != null) {
        EngineManager.g().installBaseLib(localBaseLibInfo2, null);
      }
    }
    for (;;)
    {
      if (localBaseLibInfo1 != null) {
        EngineManager.g().installBaseLib(localBaseLibInfo1, null);
      }
      return;
      label131:
      localBaseLibInfo2 = BaseLibManager.getGameBaseLibInfo();
      QMLog.i("miniapp-process_BaseLibManager", "[MiniEng]MiniEng QQSpeed gameEngineLib " + localBaseLibInfo2);
      if ((localBaseLibInfo2 != null) && (localBaseLibInfo2.baseLibType == 2)) {
        EngineManager.g().installBaseLib(localBaseLibInfo2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */