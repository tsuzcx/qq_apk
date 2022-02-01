package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;

class JsContext$1
  implements ValueCallback<IX5JsValue>
{
  JsContext$1(JsContext paramJsContext, ValueCallback paramValueCallback) {}
  
  public void a(IX5JsValue paramIX5JsValue)
  {
    ValueCallback localValueCallback = this.a;
    if (paramIX5JsValue == null) {}
    for (paramIX5JsValue = null;; paramIX5JsValue = new JsValue(this.b, paramIX5JsValue))
    {
      localValueCallback.onReceiveValue(paramIX5JsValue);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsContext.1
 * JD-Core Version:    0.7.0.1
 */