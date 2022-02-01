package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(lazyLoad=false)
public class OrientationJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ORIENTATION_CHANGE = "onDeviceOrientationChange";
  private static final String TAG = "OrientationJsPlugin";
  private String lastOrientation;
  private OrientationEventListener mOrientationListener;
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    if (this.mMiniAppContext.getAttachedActivity() != null)
    {
      this.mOrientationListener = new GameOrientationListener(paramIMiniAppContext.getAttachedActivity(), 3);
      if (this.mOrientationListener.canDetectOrientation())
      {
        QMLog.i("OrientationJsPlugin", "can detect orientation, start listening Orientation change");
        this.mOrientationListener.enable();
      }
    }
    else
    {
      return;
    }
    QMLog.i("OrientationJsPlugin", "can not detect orientation");
    this.mOrientationListener.disable();
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
          if ((str == null) || (str.equals(OrientationJsPlugin.this.lastOrientation))) {
            continue;
          }
          OrientationJsPlugin.access$002(OrientationJsPlugin.this, str);
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("value", str);
          OrientationJsPlugin.this.sendSubscribeEvent("onDeviceOrientationChange", localJSONObject.toString());
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
            QMLog.e("OrientationJsPlugin", "OrientationChange call back error:" + localJSONException.toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OrientationJsPlugin
 * JD-Core Version:    0.7.0.1
 */