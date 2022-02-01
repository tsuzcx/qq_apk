package com.tencent.qqmini.flutter.core.task;

import android.os.SystemClock;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.State;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;

class V8ServiceInitTask$1
  implements StateMachine.OnStateChangeListener
{
  long jsServiceInitStartTimestamp;
  
  V8ServiceInitTask$1(V8ServiceInitTask paramV8ServiceInitTask, AbsAppBrandService paramAbsAppBrandService, long paramLong) {}
  
  public void onStateChanged()
  {
    if (this.val$v8JsService != null) {}
    for (StateMachine.State localState = this.val$v8JsService.getCurrState();; localState = null)
    {
      if ((localState != null) && (localState == this.val$v8JsService.stateWaJsLoading)) {
        this.jsServiceInitStartTimestamp = SystemClock.uptimeMillis();
      }
      if ((localState != null) && (localState == this.val$v8JsService.stateWaJsLoadSucc)) {
        this.this$0.onServiceInitSucc(this.val$v8JsService, this.val$serviceInitTimeCost, SystemClock.uptimeMillis() - this.jsServiceInitStartTimestamp);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.task.V8ServiceInitTask.1
 * JD-Core Version:    0.7.0.1
 */