package com.tencent.qqmini.miniapp.task;

import android.os.SystemClock;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.State;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;

class ServiceInitTask$1
  implements StateMachine.OnStateChangeListener
{
  long jsServiceInitStartTimestamp;
  
  ServiceInitTask$1(ServiceInitTask paramServiceInitTask, AbsAppBrandService paramAbsAppBrandService, long paramLong) {}
  
  public void onStateChanged()
  {
    if (this.val$appBrandService != null) {}
    for (StateMachine.State localState = this.val$appBrandService.getCurrState();; localState = null)
    {
      if ((localState != null) && (localState == this.val$appBrandService.stateWaJsLoading)) {
        this.jsServiceInitStartTimestamp = SystemClock.uptimeMillis();
      }
      if ((localState != null) && (localState == this.val$appBrandService.stateWaJsLoadSucc)) {
        this.this$0.onServiceInitSucc(this.val$appBrandService, this.val$serviceInitTimeCost, SystemClock.uptimeMillis() - this.jsServiceInitStartTimestamp);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceInitTask.1
 * JD-Core Version:    0.7.0.1
 */