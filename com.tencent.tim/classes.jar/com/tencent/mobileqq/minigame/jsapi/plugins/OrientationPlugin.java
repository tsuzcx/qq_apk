package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class OrientationPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ORIENTATION_CHANGE = "onDeviceOrientationChange";
  private static final String TAG = "[minigame] OrientationPlugin";
  private String lastOrientation;
  private OrientationEventListener mOrientationListener;
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    if (paramBaseJsPluginEngine.getActivityContext() != null)
    {
      this.mOrientationListener = new GameOrientationListener(paramBaseJsPluginEngine.getActivityContext(), 3);
      if (this.mOrientationListener.canDetectOrientation())
      {
        QLog.i("[minigame] OrientationPlugin", 1, "can detect orientation, start listening Orientation change");
        this.mOrientationListener.enable();
      }
    }
    else
    {
      return;
    }
    QLog.i("[minigame] OrientationPlugin", 1, "can not detect orientation");
    this.mOrientationListener.disable();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mOrientationListener != null) {
      this.mOrientationListener.disable();
    }
  }
  
  public Set<String> supportedEvents()
  {
    return Collections.emptySet();
  }
  
  public class GameOrientationListener
    extends OrientationEventListener
  {
    public GameOrientationListener(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public void onOrientationChanged(int paramInt)
    {
      if (paramInt == -1) {}
      for (;;)
      {
        return;
        String str = null;
        label24:
        JSONObject localJSONObject;
        if ((paramInt > 350) || (paramInt < 10))
        {
          str = "portrait";
          if ((str == null) || (str.equals(OrientationPlugin.this.lastOrientation))) {
            continue;
          }
          OrientationPlugin.access$002(OrientationPlugin.this, str);
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("value", str);
          if ((OrientationPlugin.this.jsPluginEngine == null) || (OrientationPlugin.this.jsPluginEngine.getServiceRuntime() == null)) {
            continue;
          }
          OrientationPlugin.this.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onDeviceOrientationChange", localJSONObject.toString(), -1);
          return;
          if ((paramInt > 80) && (paramInt < 100))
          {
            str = "landscapeReverse";
            break label24;
          }
          if ((paramInt > 170) && (paramInt < 190)) {
            break label24;
          }
          if ((paramInt <= 260) || (paramInt >= 280)) {
            continue;
          }
          str = "landscape";
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("[minigame] OrientationPlugin", 1, "OrientationChange call back error:" + localJSONException.toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OrientationPlugin
 * JD-Core Version:    0.7.0.1
 */