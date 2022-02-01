package com.tencent.qqmini.flutter.core.service;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsStateListener;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

class AppV8JsService$1
  implements JsStatMachine.JsStateListener
{
  AppV8JsService$1(AppV8JsService paramAppV8JsService) {}
  
  public void onJsStateEnd(JsStatMachine.JsState paramJsState)
  {
    paramJsState = paramJsState.getJsPath();
    if ((!TextUtils.isEmpty(paramJsState)) && (paramJsState.contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs finish " + this);
    }
  }
  
  public void onJsStateStart(JsStatMachine.JsState paramJsState)
  {
    paramJsState = paramJsState.getJsPath();
    if ((!TextUtils.isEmpty(paramJsState)) && (paramJsState.contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs start " + this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.service.AppV8JsService.1
 * JD-Core Version:    0.7.0.1
 */