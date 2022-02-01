package com.tencent.biz.subscribe;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import rzb;
import rze;

public class SubscribeJsPlugin$3
  implements Runnable
{
  public SubscribeJsPlugin$3(rzb paramrzb, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    if (this.val$bitmap == null) {
      return;
    }
    try
    {
      String str = rze.bitmapToBase64(this.val$bitmap);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", this.val$uin);
      localJSONObject.put("avatarData", str);
      this.this$0.dispatchJsEvent("getAvatarCallback", localJSONObject, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d(this.this$0.TAG, 2, localJSONException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */