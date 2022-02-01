package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$10
  implements Runnable
{
  MapViewJsPlugin$10(MapViewJsPlugin paramMapViewJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        int i = new JSONObject(this.val$req.jsonParams).optInt("mapId", 0);
        Object localObject = MapViewJsPlugin.access$200(this.this$0, i);
        if (localObject != null)
        {
          f = ((MapContext)localObject).getScale();
          if (f != 0.0F)
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("scale", f);
            this.val$req.ok((JSONObject)localObject);
            return;
          }
          this.val$req.fail();
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QMLog.isColorLevel()) {
          QMLog.e("MapViewJsPlugin", "", localJSONException);
        }
        this.val$req.fail();
        return;
      }
      float f = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */