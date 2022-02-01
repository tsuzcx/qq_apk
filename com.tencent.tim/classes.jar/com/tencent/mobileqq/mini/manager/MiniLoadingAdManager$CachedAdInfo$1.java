package com.tencent.mobileqq.mini.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MiniLoadingAdManager$CachedAdInfo$1
  implements Downloader.DownloadListener
{
  MiniLoadingAdManager$CachedAdInfo$1(MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult) {}
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.d("MiniLoadingAdManager", 1, "yuki onDownloadSucceed url：" + paramString + " filePath:" + MiniLoadingAdManager.CachedAdInfo.access$500(this.this$0));
    paramDownloadResult = StorageUtil.getPreference().getString(MiniLoadingAdManager.CachedAdInfo.access$700(this.this$0), new JSONObject().toString());
    try
    {
      JSONObject localJSONObject = new JSONObject(paramDownloadResult);
      Object localObject = localJSONObject.optJSONArray("adArray");
      paramDownloadResult = (DownloadResult)localObject;
      if (localObject == null) {
        paramDownloadResult = new JSONArray();
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("aid", MiniLoadingAdManager.CachedAdInfo.access$800(this.this$0));
      ((JSONObject)localObject).put("creativeId", MiniLoadingAdManager.CachedAdInfo.access$900(this.this$0));
      ((JSONObject)localObject).put("url", paramString);
      ((JSONObject)localObject).put("filePath", MiniLoadingAdManager.CachedAdInfo.access$500(this.this$0));
      paramDownloadResult.put(localObject);
      localJSONObject.put("adArray", paramDownloadResult);
      StorageUtil.getPreference().edit().putString(MiniLoadingAdManager.CachedAdInfo.access$700(this.this$0), localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo.1
 * JD-Core Version:    0.7.0.1
 */