package com.tencent.mobileqq.intervideo.huiyin;

import aiei;
import aiel;
import android.util.Log;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class HuiyinJsPlugin$4$1
  implements Runnable
{
  public HuiyinJsPlugin$4$1(aiel paramaiel, int paramInt, String paramString) {}
  
  public void run()
  {
    Log.i("Huiyin", "upload code " + this.val$code + ", msg " + this.val$msg);
    try
    {
      if (this.val$code == 0) {
        aiei.a(this.a.this$0, this.val$code, this.a.abs, this.a.val$callback, null, new JSONObject(this.val$msg));
      }
      for (;;)
      {
        new File(aiei.a(this.a.this$0)).delete();
        aiei.a(this.a.this$0, null);
        return;
        aiei.a(this.a.this$0, this.val$code, this.a.abs, this.a.val$callback, this.val$msg, null);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("Huiyin", localJSONException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.HuiyinJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */