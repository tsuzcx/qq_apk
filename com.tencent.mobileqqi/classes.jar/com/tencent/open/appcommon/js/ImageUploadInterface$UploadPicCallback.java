package com.tencent.open.appcommon.js;

import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageUploadInterface$UploadPicCallback
  implements HttpCgiAsyncTask.Callback
{
  protected ImageUploadInterface$UploadPicCallback(ImageUploadInterface paramImageUploadInterface) {}
  
  public void a(Exception paramException)
  {
    LogUtility.e(ImageUploadInterface.LOG_TAG, "onException >>> " + paramException.toString());
    this.a.handleUploadPicCallbackException(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogUtility.c(ImageUploadInterface.LOG_TAG, "onResult >>> " + paramJSONObject.toString());
    try
    {
      ImageUploadInterface.mUploading = false;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("guid", this.a.mGuid);
      localJSONObject.put("content", paramJSONObject.toString());
      localJSONObject.put("resultCode", 0);
      ImageUploadInterface.loadJs(this.a.mWebView, "javascript:JsBridge.callback('picUpload'," + localJSONObject.toString() + ");void(0);");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.ImageUploadInterface.UploadPicCallback
 * JD-Core Version:    0.7.0.1
 */