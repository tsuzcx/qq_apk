package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_DRAW_CANVAS = "drawCanvas";
  private static final String EVENT_GET_INAGE_DATA = "canvasGetImageData";
  private static final String EVENT_INSERT_CANVAS = "insertCanvas";
  private static final String EVENT_MEASURE_TEXT = "measureText";
  public static final String EVENT_PUT_IMAGE_DATA = "canvasPutImageData";
  private static final String EVENT_REMOVE_CANVAS = "removeCanvas";
  private static final String EVENT_TO_TEMP_FILE_PATH = "canvasToTempFilePath";
  private static final String EVENT_UPDATE_CANVAS = "updateCanvas";
  public static final String TAG = "[mini] CanvasJsPlugin";
  Set<String> eventMap = new HashSet();
  private ConcurrentHashMap<Integer, WebviewContainer> mappingTableMap = new ConcurrentHashMap();
  
  public CanvasJsPlugin()
  {
    this.eventMap.add("drawCanvas");
    this.eventMap.add("measureText");
    this.eventMap.add("canvasToTempFilePath");
    this.eventMap.add("canvasGetImageData");
    this.eventMap.add("canvasPutImageData");
    this.eventMap.add("insertCanvas");
    this.eventMap.add("updateCanvas");
    this.eventMap.add("removeCanvas");
  }
  
  private void callback(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString1, String paramString2)
  {
    if ((paramJsRuntime != null) && (paramJSONObject != null)) {
      paramJsRuntime.evaluateCallbackJs(paramInt, JSONUtil.append(paramJSONObject, "errMsg", paramString1 + ":" + paramString2).toString());
    }
  }
  
  private void callbackComplete(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "complete");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] CanvasJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("insertCanvas".equals(paramString1)) {}
    for (;;)
    {
      int i;
      Object localObject3;
      Object localObject4;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString2);
        i = localJSONObject1.optInt("canvasId");
        int j = localJSONObject1.optInt("parentId");
        localObject3 = localJSONObject1.optJSONObject("position");
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("containerId", i);
        AppBrandTask.runTaskOnUiThread(new CanvasJsPlugin.1(this, paramJsRuntime, i, localJSONObject1, j, (JSONObject)localObject3, localJSONObject1.optString("data"), paramString1, (JSONObject)localObject4, paramInt));
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
      catch (JSONException localJSONException1)
      {
        QLog.e("[mini] CanvasJsPlugin", 1, paramString1 + " error.", localJSONException1);
        continue;
      }
      boolean bool1;
      if ("updateCanvas".equals(paramString1))
      {
        try
        {
          localObject3 = new JSONObject(paramString2);
          i = ((JSONObject)localObject3).optInt("canvasId");
          JSONObject localJSONObject2 = ((JSONObject)localObject3).optJSONObject("position");
          bool1 = ((JSONObject)localObject3).optBoolean("hide", false);
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("containerId", i);
          AppBrandTask.runTaskOnUiThread(new CanvasJsPlugin.2(this, paramJsRuntime, i, localJSONObject2, bool1, paramString1, (JSONObject)localObject3, paramInt));
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("[mini] CanvasJsPlugin", 1, paramString1 + " error.", localJSONException2);
        }
      }
      else if ("removeCanvas".equals(paramString1))
      {
        try
        {
          AppBrandTask.runTaskOnUiThread(new CanvasJsPlugin.3(this, new JSONObject(paramString2).optInt("canvasId"), paramJsRuntime, paramString1, paramInt));
        }
        catch (JSONException localJSONException3)
        {
          QLog.e("[mini] CanvasJsPlugin", 1, paramString1 + " error.", localJSONException3);
        }
      }
      else
      {
        label553:
        Object localObject2;
        if ("drawCanvas".equals(paramString1)) {
          for (;;)
          {
            try
            {
              Object localObject1 = new JSONObject(paramString2);
              i = ((JSONObject)localObject1).optInt("canvasId");
              bool1 = ((JSONObject)localObject1).optBoolean("reserve", false);
              boolean bool2 = ((JSONObject)localObject1).optBoolean("useHardwareAccelerate");
              localObject3 = ((JSONObject)localObject1).optJSONArray("actions");
              if ((this.mappingTableMap == null) || (!this.mappingTableMap.containsKey(Integer.valueOf(i)))) {
                break label553;
              }
              localObject1 = (WebviewContainer)this.mappingTableMap.get(Integer.valueOf(i));
              if (localObject1 == null) {
                break;
              }
              ((WebviewContainer)localObject1).drawCanvas(i, bool1, bool2, (JSONArray)localObject3, paramString1, paramInt);
              localObject3 = ApiUtil.wrapCallbackOk(paramString1, null);
              if (localObject3 == null) {
                break label574;
              }
              localObject3 = ((JSONObject)localObject3).toString();
              ((WebviewContainer)localObject1).appBrandRuntime.serviceRuntime.evaluateCallbackJs(paramInt, (String)localObject3);
            }
            catch (JSONException localJSONException4)
            {
              localJSONException4.printStackTrace();
            }
            break;
            localObject2 = ((AppBrandRuntime)this.jsPluginEngine.appBrandRuntime).pageContainer.getCurrentWebviewContainer();
            continue;
            label574:
            localObject3 = "";
          }
        }
        if ("measureText".equals(paramString1))
        {
          try
          {
            localObject2 = new JSONObject(paramString2);
            localObject3 = new Paint(1);
            localObject4 = ((JSONObject)localObject2).optString("fontFamily");
            if ("normal".equals(((JSONObject)localObject2).optString("fontStyle"))) {
              ((Paint)localObject3).setTypeface(Typeface.create((String)localObject4, 0));
            }
            localObject4 = ((JSONObject)localObject2).optString("text");
            ((Paint)localObject3).setTextSize(((JSONObject)localObject2).optInt("fontSize"));
            float f = ((Paint)localObject3).measureText((String)localObject4);
            localObject2 = new JSONObject();
            try
            {
              ((JSONObject)localObject2).put("width", f);
              localObject2 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject2);
              callbackComplete(paramJsRuntime, (JSONObject)localObject2, paramInt, paramString1);
              return ((JSONObject)localObject2).toString();
            }
            catch (JSONException localJSONException6)
            {
              for (;;)
              {
                localJSONException6.printStackTrace();
              }
            }
          }
          catch (JSONException localJSONException5)
          {
            localJSONException5.printStackTrace();
          }
        }
        else
        {
          WebviewContainer localWebviewContainer;
          if ("canvasToTempFilePath".equals(paramString1))
          {
            localWebviewContainer = ((AppBrandRuntime)this.jsPluginEngine.appBrandRuntime).pageContainer.getCurrentWebviewContainer();
            if (localWebviewContainer != null) {
              try
              {
                JSONObject localJSONObject3 = new JSONObject(paramString2);
                localWebviewContainer.saveCanvasFile(localJSONObject3.optInt("canvasId"), paramString1, paramInt, localJSONObject3);
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                localWebviewContainer.callbackJsEventFail(paramString1, null, paramInt);
              }
            }
          }
          else if ("canvasGetImageData".equals(paramString1))
          {
            localWebviewContainer = ((AppBrandRuntime)this.jsPluginEngine.appBrandRuntime).pageContainer.getCurrentWebviewContainer();
            if (localWebviewContainer != null) {
              try
              {
                JSONObject localJSONObject4 = new JSONObject(paramString2);
                localWebviewContainer.getImageData(localJSONObject4.optInt("canvasId"), paramString1, paramInt, localJSONObject4);
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
                localWebviewContainer.callbackJsEventFail(paramString1, null, paramInt);
              }
            }
          }
          else if ("canvasPutImageData".equals(paramString1))
          {
            localWebviewContainer = ((AppBrandRuntime)this.jsPluginEngine.appBrandRuntime).pageContainer.getCurrentWebviewContainer();
            if (localWebviewContainer != null) {
              try
              {
                JSONObject localJSONObject5 = new JSONObject(paramString2);
                localWebviewContainer.putImageData(localJSONObject5.optInt("canvasId"), paramString1, paramInt, localJSONObject5);
              }
              catch (Exception localException3)
              {
                localException3.printStackTrace();
                localWebviewContainer.callbackJsEventFail(paramString1, null, paramInt);
              }
            }
          }
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.CanvasJsPlugin
 * JD-Core Version:    0.7.0.1
 */