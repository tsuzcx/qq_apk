package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class CanvasJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_DRAW_CANVAS = "drawCanvas";
  public static final String EVENT_GET_INAGE_DATA = "canvasGetImageData";
  public static final String EVENT_INSERT_CANVAS = "insertCanvas";
  public static final String EVENT_MEASURE_TEXT = "measureText";
  public static final String EVENT_PUT_IMAGE_DATA = "canvasPutImageData";
  public static final String EVENT_REMOVE_CANVAS = "removeCanvas";
  public static final String EVENT_TO_TEMP_FILE_PATH = "canvasToTempFilePath";
  public static final String EVENT_UPDATE_CANVAS = "updateCanvas";
  
  @JsEvent({"drawCanvas", "canvasToTempFilePath", "canvasPutImageData", "canvasGetImageData", "insertCanvas", "updateCanvas", "removeCanvas"})
  public void doInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 2));
  }
  
  @JsEvent({"measureText"})
  public String measureText(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      Paint localPaint = new Paint(1);
      String str = localJSONObject.optString("fontFamily");
      if ("normal".equals(localJSONObject.optString("fontStyle"))) {
        localPaint.setTypeface(Typeface.create(str, 0));
      }
      str = localJSONObject.optString("text");
      localPaint.setTextSize(localJSONObject.optInt("fontSize"));
      float f = localPaint.measureText(str);
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("width", f);
        localJSONObject = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject);
        if ((paramRequestEvent.jsService != null) && (localJSONObject != null)) {
          paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, JSONUtil.append(localJSONObject, "errMsg", paramRequestEvent.event + ":complete").toString());
        }
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      return "";
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.CanvasJsPlugin
 * JD-Core Version:    0.7.0.1
 */