package com.tencent.qqmini.miniapp.core.service;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.State;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.StateTransfer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbsAppBrandService
  extends JsStatMachine
  implements IAppBrandService
{
  public static final int EVENT_INIT_SUCC = 3;
  public static final int EVENT_JS_APP_CONFIG_READY = 6;
  public static final int EVENT_JS_APP_READY = 7;
  public static final int EVENT_JS_CONFIG_READY = 4;
  public static final int EVENT_JS_WA_READY = 5;
  private static final String TAG = "AbsAppBrandService";
  protected List<String> mWaitingJsList = new ArrayList();
  protected IMiniAppContext miniAppContext;
  public JsStatMachine.JsState stateAppServiceJsLoading = new JsStatMachine.JsState(this, 9).nextState(this.stateLoadSucc);
  public StateMachine.State stateDefaulConfigJsLoadSucc = new StateMachine.State(this, Integer.valueOf(4));
  public JsStatMachine.JsState stateDefaulConfigJsLoading = new JsStatMachine.JsState(this, 3).nextState(this.stateDefaulConfigJsLoadSucc);
  public StateMachine.State stateGlobalConfigJsLoadSucc = new StateMachine.State(this, Integer.valueOf(8));
  public JsStatMachine.JsState stateGlobalConfigJsLoading = new JsStatMachine.JsState(this, 7).nextState(this.stateGlobalConfigJsLoadSucc);
  public StateMachine.State stateInitFailed = new StateMachine.State(this, Integer.valueOf(-1));
  public StateMachine.State stateInited = new StateMachine.State(this, Integer.valueOf(2));
  public StateMachine.State stateInitial = new StateMachine.State(this, Integer.valueOf(1));
  public StateMachine.State stateLoadSucc = new StateMachine.State(this, Integer.valueOf(10));
  public StateMachine.State stateWaJsLoadSucc = new StateMachine.State(this, Integer.valueOf(6));
  public JsStatMachine.JsState stateWaJsLoading = new JsStatMachine.JsState(this, 5).nextState(this.stateWaJsLoadSucc);
  
  public AbsAppBrandService(IMiniAppContext paramIMiniAppContext)
  {
    this.miniAppContext = paramIMiniAppContext;
    initStateConfig();
  }
  
  protected void addWaitEvaluateJs(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.mWaitingJsList)
      {
        this.mWaitingJsList.add(paramString);
        return;
      }
    }
  }
  
  protected void evaluateWaitJs()
  {
    QMLog.e("AbsAppBrandService", "Evaluate waiting js list!");
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mWaitingJsList)
    {
      localArrayList.addAll(this.mWaitingJsList);
      this.mWaitingJsList.clear();
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        evaluateJs((String)((Iterator)???).next(), null);
      }
    }
  }
  
  public abstract void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent);
  
  protected void initStateConfig()
  {
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInitial).next(this.stateInited).registEvent(Integer.valueOf(3)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInited).next(this.stateDefaulConfigJsLoading).registEvent(Integer.valueOf(4)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateDefaulConfigJsLoadSucc).next(this.stateWaJsLoading).registEvent(Integer.valueOf(5)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateWaJsLoadSucc).next(this.stateGlobalConfigJsLoading).registEvent(Integer.valueOf(6)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateGlobalConfigJsLoadSucc).next(this.stateAppServiceJsLoading).registEvent(Integer.valueOf(7)));
    setCurrState(this.stateInitial);
  }
  
  public boolean isStateSucc()
  {
    return this.stateLoadSucc == getCurrState();
  }
  
  public abstract void setApkgInfo(ApkgInfo paramApkgInfo);
  
  public void setAppServiceJs(String paramString)
  {
    this.stateAppServiceJsLoading.setJsContent(paramString);
    appendEvent(Integer.valueOf(7));
  }
  
  public void setCurrState(StateMachine.State paramState)
  {
    StateMachine.State localState = getCurrState();
    if (localState == this.stateWaJsLoading) {
      MiniReportManager.reportEventType(this.miniAppContext.getMiniAppInfo(), 14, "0");
    }
    for (;;)
    {
      if (this.stateLoadSucc == paramState) {
        evaluateWaitJs();
      }
      super.setCurrState(paramState);
      return;
      if (this.stateWaJsLoadSucc == localState) {
        MiniReportManager.reportEventType(this.miniAppContext.getMiniAppInfo(), 15, "0");
      } else if (localState == this.stateAppServiceJsLoading) {
        MiniReportManager.reportEventType(this.miniAppContext.getMiniAppInfo(), 104, "0");
      } else if (this.stateLoadSucc == localState) {
        MiniReportManager.reportEventType(this.miniAppContext.getMiniAppInfo(), 105, "0");
      }
    }
  }
  
  public void setDefaultConfigJs(String paramString)
  {
    this.stateDefaulConfigJsLoading.setJsContent(paramString);
    appendEvent(Integer.valueOf(4));
  }
  
  public void setGlobalConfigJs(String paramString)
  {
    this.stateGlobalConfigJsLoading.setJsContent(paramString);
    appendEvent(Integer.valueOf(6));
  }
  
  public void setWaServiceJS(String paramString1, String paramString2)
  {
    this.stateWaJsLoading.setJsContent(paramString1, paramString2);
    appendEvent(Integer.valueOf(5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AbsAppBrandService
 * JD-Core Version:    0.7.0.1
 */