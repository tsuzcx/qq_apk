package com.tencent.mobileqq.minigame.jsapi;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class GameJsPluginEngine$1
  implements ComponentCallbacks2
{
  GameJsPluginEngine$1(GameJsPluginEngine paramGameJsPluginEngine) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    QLog.e("GameJsPluginEngine", 1, new Object[] { "onLowMemory!!!!!! Meminfo:dalvikPss[", Integer.valueOf(arrayOfMemoryInfo[0].dalvikPss), "],nativePss[", Integer.valueOf(arrayOfMemoryInfo[0].nativePss), "],otherPss[", Integer.valueOf(arrayOfMemoryInfo[0].otherPss), "],total[", Integer.valueOf(arrayOfMemoryInfo[0].getTotalPss()), "]" });
  }
  
  public void onTrimMemory(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("level", paramInt);
      if (this.this$0.getGameJsRuntime(1) != null) {
        this.this$0.getGameJsRuntime(1).evaluateSubcribeJS("onMemoryWarning", localJSONObject.toString(), -1);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */