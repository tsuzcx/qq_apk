package com.tencent.mobileqq.mini.apkg;

import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.minigame.manager.LocalGameEngine;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
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
    boolean bool = aqiw.isWifiConnected(BaseApplicationImpl.getApplication());
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] gameEngineLib " + localBaseLibInfo2 + ", miniAppEnginLib " + localJSONObject + " isWifi:" + bool);
    if (!LocalGameEngine.g().isWnsConfigModel()) {
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
      localBaseLibInfo2 = GameWnsUtils.getGameBaseLibInfo();
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng]MiniEng QQSpeed gameEngineLib " + localBaseLibInfo2);
      if ((localBaseLibInfo2 != null) && (localBaseLibInfo2.baseLibType == 2)) {
        EngineManager.g().installBaseLib(localBaseLibInfo2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */