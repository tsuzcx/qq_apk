package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import lci;
import ntp;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyWebRenderEngine$2
  implements Runnable
{
  public void run()
  {
    try
    {
      JSONObject localJSONObject = ntp.M();
      if (localJSONObject != null)
      {
        if (!TextUtils.isEmpty(this.val$data)) {
          localJSONObject.put("param", this.val$data);
        }
        localJSONObject.put("url", this.val$url);
        lci.a(this.this$0, false);
        lci.a(this.this$0).render(this.aet, localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("viola.ReadInJoyWebRenderEngine", 1, "onRender JSONException e" + localJSONException.getMessage() + "ms");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.2
 * JD-Core Version:    0.7.0.1
 */