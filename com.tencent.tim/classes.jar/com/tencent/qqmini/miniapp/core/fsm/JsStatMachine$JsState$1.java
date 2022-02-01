package com.tencent.qqmini.miniapp.core.fsm;

import android.webkit.ValueCallback;

class JsStatMachine$JsState$1
  implements ValueCallback
{
  JsStatMachine$JsState$1(JsStatMachine.JsState paramJsState) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if (this.this$1.this$0.mJsStateListener != null) {
      this.this$1.this$0.mJsStateListener.onJsStateStart(this.this$1);
    }
    this.this$1.this$0.sendEvent(JsStatMachine.EVENT_JS_EVALUATE_SUCC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState.1
 * JD-Core Version:    0.7.0.1
 */