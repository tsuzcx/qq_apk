package com.tencent.tissue.v8rt.engine;

import android.os.ConditionVariable;

class V8JsContext$6
  extends ValueCallback
{
  V8JsContext$6(V8JsContext paramV8JsContext, Object paramObject, ConditionVariable paramConditionVariable)
  {
    super(paramObject);
  }
  
  public void onFinish(Object paramObject)
  {
    this.value = paramObject;
    this.val$cond.open();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.V8JsContext.6
 * JD-Core Version:    0.7.0.1
 */