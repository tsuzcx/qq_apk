package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import aeay;
import aqju;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class OtherJsPlugin$6
  implements Runnable
{
  OtherJsPlugin$6(OtherJsPlugin paramOtherJsPlugin, aeay paramaeay, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    aqju localaqju = new aqju(this.this$0.jsPluginEngine.getActivityContext(), 2131756467);
    localaqju.setContentView(2131559580);
    localaqju.setMessage("是否将" + this.this$0.jsPluginEngine.getAppInfo().name + "添加到彩签？");
    localaqju.setPositiveButton("确定", new OtherJsPlugin.6.1(this));
    localaqju.setNegativeButton("取消", new OtherJsPlugin.6.2(this));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */