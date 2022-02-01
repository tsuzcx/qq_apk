package com.tencent.qflutter;

import com.idlefish.flutterboost.FlutterBoostPlugin.EventListener;
import com.tencent.qflutter.utils.FLog;
import java.util.Map;

class QFlutterEngine$1$1
  implements FlutterBoostPlugin.EventListener
{
  QFlutterEngine$1$1(QFlutterEngine.1 param1) {}
  
  public void onEvent(String paramString, Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEvent: name:");
    localStringBuilder.append(paramString);
    FLog.i("QFlutter", localStringBuilder.toString());
    if (this.this$0.val$eventListener != null) {
      this.this$0.val$eventListener.onEvent(paramString, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qflutter.QFlutterEngine.1.1
 * JD-Core Version:    0.7.0.1
 */