package com.tencent.qqmini.flutter.core.page.tissue;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class TissuePageContainer$1
  implements MethodChannel.MethodCallHandler
{
  TissuePageContainer$1(TissuePageContainer paramTissuePageContainer) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramResult.success(null);
    QMLog.d("miniapp-start-TISSUE-flutter_method_channel", paramMethodCall.method);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer.1
 * JD-Core Version:    0.7.0.1
 */