package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class WorkerAction
  implements Action<Integer>
{
  public int ACTION_CREATE_WORKE = 1;
  public int ACTION_GET_WORKER_MODE = 2;
  public int ACTION_POST_MSG_TO_SERVICE = 5;
  public int ACTION_POST_MSG_TO_WORKER = 4;
  public int ACTION_STOP_WORKER = 3;
  private int action = -1;
  private IMiniAppContext mMiniAppContext;
  private String mPostMsg = null;
  private String mWorkerName = null;
  
  public static WorkerAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    WorkerAction localWorkerAction = new WorkerAction();
    localWorkerAction.mMiniAppContext = paramIMiniAppContext;
    return localWorkerAction;
  }
  
  public int createWorker(String paramString)
  {
    this.action = this.ACTION_CREATE_WORKE;
    this.mWorkerName = paramString;
    return ((Integer)this.mMiniAppContext.performAction(this)).intValue();
  }
  
  public int getWorkerMode()
  {
    this.action = this.ACTION_GET_WORKER_MODE;
    return ((Integer)this.mMiniAppContext.performAction(this)).intValue();
  }
  
  public Integer perform(BaseRuntime paramBaseRuntime)
  {
    if (!(paramBaseRuntime instanceof AppBrandRuntime)) {
      return Integer.valueOf(0);
    }
    if (this.action == this.ACTION_CREATE_WORKE) {
      return Integer.valueOf(((AppBrandRuntime)paramBaseRuntime).getMiniAppWorkerManager().createWorker(this.mWorkerName));
    }
    if (this.action == this.ACTION_GET_WORKER_MODE)
    {
      if ((paramBaseRuntime.getJsService() instanceof AppBrandService)) {}
      for (int i = 1;; i = 0) {
        return Integer.valueOf(i);
      }
    }
    if (this.action == this.ACTION_STOP_WORKER) {
      ((AppBrandRuntime)paramBaseRuntime).getMiniAppWorkerManager().stopWorker();
    }
    if (this.action == this.ACTION_POST_MSG_TO_WORKER) {
      ((AppBrandRuntime)paramBaseRuntime).getMiniAppWorkerManager().handlePostMsgToWorker(this.mPostMsg);
    }
    if (this.action == this.ACTION_POST_MSG_TO_SERVICE)
    {
      paramBaseRuntime = paramBaseRuntime.getJsService();
      String str = String.format("WeixinWorker.workerMsgHandler('" + Integer.valueOf(1) + "',%s)", new Object[] { this.mPostMsg });
      QMLog.i("minisdk-worker", "[postMessageToMain] jsScript:" + str);
      paramBaseRuntime.evaluateJs(str, new WorkerAction.1(this));
    }
    return null;
  }
  
  public void postMsgToService(String paramString)
  {
    this.action = this.ACTION_POST_MSG_TO_SERVICE;
    this.mPostMsg = paramString;
    this.mMiniAppContext.performAction(this);
  }
  
  public void postMsgToWorker(String paramString)
  {
    this.action = this.ACTION_POST_MSG_TO_WORKER;
    this.mPostMsg = paramString;
    this.mMiniAppContext.performAction(this);
  }
  
  public void stopWorker()
  {
    this.action = this.ACTION_STOP_WORKER;
    this.mMiniAppContext.performAction(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.WorkerAction
 * JD-Core Version:    0.7.0.1
 */