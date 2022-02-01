package com.tencent.biz.subscribe;

import aduk;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rzb;

public class SubscribeJsPlugin$2
  implements Runnable
{
  public SubscribeJsPlugin$2(rzb paramrzb, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.val$jsonArray != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < this.val$jsonArray.length()) {
          try
          {
            String str = this.val$jsonArray.getJSONObject(i).getString("uin");
            Bitmap localBitmap = rzb.a(this.this$0).a(str, true, null);
            QLog.i(this.this$0.TAG, 4, "handleGetAvatar  uin: " + str);
            rzb.a(this.this$0, str, localBitmap);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */