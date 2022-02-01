package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class FileJsPlugin$8$1
  implements ValueCallback<String>
{
  FileJsPlugin$8$1(FileJsPlugin.8 param8) {}
  
  public void onReceiveValue(String paramString)
  {
    QLog.d("[mini] FileJsPlugin", 1, "openFileReader callback  : " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */