package com.tencent.biz.game;

import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import jqo;
import lg;
import li;

class SensorAPIJavaScript$10
  extends Thread
{
  SensorAPIJavaScript$10(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString1, String paramString2, String paramString3, boolean paramBoolean, WifiManager paramWifiManager, String paramString4) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start connectToWiFi");
    }
    Object localObject = new li(this.val$type, this.Ue, this.val$password, this.abo);
    if (new lg(this.b).a((li)localObject))
    {
      localObject = new Message();
      ((Message)localObject).what = 5;
      ((Message)localObject).obj = this.val$callback;
      this.this$0.mHandler.sendMessage((Message)localObject);
      return;
    }
    this.this$0.abn = false;
    this.this$0.callJs(this.val$callback, new String[] { jqo.toJsString(Integer.toString(1)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.10
 * JD-Core Version:    0.7.0.1
 */