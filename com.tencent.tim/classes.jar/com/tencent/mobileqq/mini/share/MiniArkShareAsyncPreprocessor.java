package com.tencent.mobileqq.mini.share;

import adts;
import adtt;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniArkShareAsyncPreprocessor
  implements adts
{
  private static final String TAG = "MiniArkShareAsyncPrepro [miniappArkShare]";
  private final Bundle bundle;
  
  public MiniArkShareAsyncPreprocessor(Bundle paramBundle)
  {
    this.bundle = paramBundle;
  }
  
  private void handleArkShareNewImageUrl(boolean paramBoolean, Bundle paramBundle, JSONObject paramJSONObject, adtt paramadtt, Object paramObject)
  {
    paramBundle = paramBundle.getString("imageUrl", "").replaceFirst("https*://", "");
    paramBundle = MiniProgramShareUtils.updateImagePathToArkMeta(paramJSONObject.optString("forward_ark_app_meta"), paramBundle);
    try
    {
      paramJSONObject.put("forward_ark_app_meta", paramBundle);
      this.bundle.clear();
      if (paramadtt != null) {
        paramadtt.a(paramBoolean, paramJSONObject, paramObject);
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public boolean needProcess(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (!"intro".equals(paramJSONObject.optString("forward_ark_app_view")));
  }
  
  public void process(JSONObject paramJSONObject, adtt paramadtt, Object paramObject)
  {
    if (paramJSONObject == null) {
      if (paramadtt != null) {
        paramadtt.a(true, paramJSONObject, paramObject);
      }
    }
    String str1;
    do
    {
      return;
      String str2 = this.bundle.getString("sharePicturePath");
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        str1 = str2;
        if ((localObject instanceof QQAppInterface))
        {
          localObject = ((QQAppInterface)localObject).a().createEntityManager();
          str1 = str2;
          if (localObject != null)
          {
            localObject = ((EntityManager)localObject).find(MiniProgramArkShareLocalImageEntity.class, "arkPath = ?", new String[] { MiniProgramShareUtils.getLocalImagePathFromArkMeta(paramJSONObject.optString("forward_ark_app_meta")) });
            str1 = str2;
            if ((localObject instanceof MiniProgramArkShareLocalImageEntity)) {
              str1 = ((MiniProgramArkShareLocalImageEntity)localObject).localPath;
            }
          }
        }
      }
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
    } while (paramadtt == null);
    paramadtt.a(true, paramJSONObject, paramObject);
    return;
    if ((URLUtil.isHttpsUrl(str1)) || (URLUtil.isHttpUrl(str1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      MiniArkShareAsyncManager.performChangeArkShareImageUrl(str1, new MiniArkShareAsyncPreprocessor.1(this, paramJSONObject, paramadtt, paramObject, str1));
      return;
    }
    MiniArkShareAsyncManager.performUploadArkShareImage(str1, new MiniArkShareAsyncPreprocessor.2(this, paramJSONObject, paramadtt, paramObject, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncPreprocessor
 * JD-Core Version:    0.7.0.1
 */