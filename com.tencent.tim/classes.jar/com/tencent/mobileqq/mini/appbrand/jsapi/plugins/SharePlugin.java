package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import aqhu;
import avqq;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class SharePlugin
  extends BaseJsPlugin
{
  public static final String API_OPEN_QZONE_PUBLISH = "openQzonePublish";
  public static final String FAKE_URL = "https://m.q.qq.com/a/p/{appid}";
  private static final Set<String> S_EVENT_MAP = new SharePlugin.1();
  private static final String TAG = "[minigame] SharePlugin";
  private static final int TIP_PHOTO_AND_VIDEO_COUNT_EXCEED = 32;
  private static final int TIP_SINGLE_PHOTO_EXCEED = 2;
  private static final int TIP_SINGLE_VIDEO_DURATION_EXCEED = 8;
  private static final int TIP_SINGLE_VIDEO_SIZE_EXCEED = 4;
  private static final int TIP_TEXT_EXCEED = 1;
  private static final int TIP_VIDEO_COUNT_EXCEED = 16;
  private static HashMap<Integer, String> mTip = new HashMap();
  
  public SharePlugin()
  {
    String str1 = PublishMoodInfo.getFileSizeDesc(PublishMoodInfo.MOOD_MAX_SINGLE_PHOTO_SIZE);
    String str2 = PublishMoodInfo.getFileSizeDesc(PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_SIZE);
    mTip.put(Integer.valueOf(1), acfp.m(2131714412) + PublishMoodInfo.MOOD_MAX_TEXT_COUNT + acfp.m(2131714415));
    mTip.put(Integer.valueOf(2), acfp.m(2131714406) + str1 + acfp.m(2131714416));
    mTip.put(Integer.valueOf(4), acfp.m(2131714405) + str2 + acfp.m(2131714407));
    mTip.put(Integer.valueOf(8), acfp.m(2131714410) + PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_DURATION / 60000 + acfp.m(2131714411));
    mTip.put(Integer.valueOf(16), acfp.m(2131714409) + PublishMoodInfo.MOOD_MAX_VIDEO_COUNT + acfp.m(2131714413));
    mTip.put(Integer.valueOf(32), acfp.m(2131714414) + PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT + acfp.m(2131714408));
    QLog.i("[minigame] SharePlugin", 2, "textCount = " + PublishMoodInfo.MOOD_MAX_TEXT_COUNT + ", singlePhotoSize = " + PublishMoodInfo.MOOD_MAX_SINGLE_PHOTO_SIZE + ", singleVideoSize = " + PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_SIZE + ", singleVideoDuration = " + PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_DURATION + ", videoCount = " + PublishMoodInfo.MOOD_MAX_VIDEO_COUNT + ", photoAndVideoCount = " + PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT);
  }
  
  public static LocalMediaInfo getPhotoLocalMediaInfoByPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return null;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      aqhu.d(paramString, localOptions);
      localLocalMediaInfo.mediaWidth = localOptions.outWidth;
      localLocalMediaInfo.mediaHeight = localOptions.outHeight;
      localLocalMediaInfo.mMimeType = PhotoUtils.hS(paramString);
      localLocalMediaInfo.fileSize = localFile.length();
      localLocalMediaInfo.modifiedDate = localFile.lastModified();
      return localLocalMediaInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("_photo", 1, localException, new Object[0]);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("_photo", 1, localOutOfMemoryError, new Object[0]);
      }
    }
  }
  
  @TargetApi(10)
  public static LocalMediaInfo getVideoLocalMediaInfoByPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return null;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (!localFile.isFile()) || (Build.VERSION.SDK_INT <= 10));
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      localLocalMediaInfo.path = paramString;
      localLocalMediaInfo.mDuration = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
      localLocalMediaInfo.mMimeType = localMediaMetadataRetriever.extractMetadata(12);
      localLocalMediaInfo.fileSize = localFile.length();
      try
      {
        localMediaMetadataRetriever.release();
        return localLocalMediaInfo;
      }
      catch (RuntimeException paramString)
      {
        for (;;)
        {
          QZLog.e("[minigame] SharePlugin", "retriever.release error" + paramString);
        }
      }
      try
      {
        localMediaMetadataRetriever.release();
        throw paramString;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          QZLog.e("[minigame] SharePlugin", "retriever.release error" + localRuntimeException);
        }
      }
    }
    catch (IllegalArgumentException paramString)
    {
      paramString = paramString;
      QZLog.e("[minigame] SharePlugin", "IllegalArgumentException" + paramString);
      try
      {
        localMediaMetadataRetriever.release();
        return null;
      }
      catch (RuntimeException paramString)
      {
        QZLog.e("[minigame] SharePlugin", "retriever.release error" + paramString);
        return null;
      }
    }
    catch (RuntimeException paramString)
    {
      paramString = paramString;
      QZLog.e("[minigame] SharePlugin", "RuntimeException" + paramString);
      try
      {
        localMediaMetadataRetriever.release();
        return null;
      }
      catch (RuntimeException paramString)
      {
        QZLog.e("[minigame] SharePlugin", "retriever.release error" + paramString);
        return null;
      }
    }
    finally {}
  }
  
  private static boolean isValidPhoto(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_PHOTO_SIZE;
  }
  
  private static boolean isValidVideoDuration(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_DURATION;
  }
  
  private static boolean isValidVideoSize(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_SIZE;
  }
  
  private void publishMood(Activity paramActivity, PublishMoodInfo paramPublishMoodInfo)
  {
    if ((paramActivity == null) || (paramPublishMoodInfo == null))
    {
      QLog.i("[minigame] SharePlugin", 2, "handle moodInfo is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("summary", paramPublishMoodInfo.mText);
    localBundle.putBoolean("key_need_save_draft", false);
    localBundle.putBoolean("from_mini_app", true);
    localBundle.putStringArrayList("images", paramPublishMoodInfo.mAllImageAndVideo);
    localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramPublishMoodInfo.mMediaInfoHashMap);
    localBundle.putString("shareSource", "miniApp");
    String str1;
    String str2;
    label258:
    JSONObject localJSONObject;
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null))
    {
      str1 = this.jsPluginEngine.appBrandRuntime.appId;
      if ((this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config != null))
      {
        str2 = "https://m.q.qq.com/a/p/{appid}".replace("{appid}", str1);
        if (!TextUtils.isEmpty(paramPublishMoodInfo.mPath))
        {
          str2 = str2 + "?s=" + paramPublishMoodInfo.mPath + "&referer=" + 2100;
          if (!TextUtils.isEmpty(paramPublishMoodInfo.mFootnote)) {
            break label476;
          }
          paramPublishMoodInfo = this.jsPluginEngine.activityContext.getResources().getString(2131695924);
          localJSONObject = new JSONObject();
        }
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("icon_url", this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.iconUrl);
        localJSONObject.put("title", this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.name);
        localJSONObject.put("summary", paramPublishMoodInfo);
        localJSONObject.put("jump_url", str2);
        localJSONObject.put("button_txt", this.jsPluginEngine.activityContext.getResources().getString(2131695934));
        localJSONObject.put("recom_bottom_id", 2);
        localJSONObject.put("action_type", 2);
        paramPublishMoodInfo = localJSONObject.toString();
        localBundle.putString("key_mini_app_tail", paramPublishMoodInfo);
        QLog.d("[minigame] SharePlugin", 1, "publishMood， comm_recom_bottom： " + paramPublishMoodInfo);
        paramPublishMoodInfo = str1;
        localBundle.putString("key_mini_appid", paramPublishMoodInfo);
        avqq.a(paramActivity, localBundle, null, -1);
        return;
      }
      catch (Exception paramPublishMoodInfo)
      {
        label476:
        QLog.d("[minigame] SharePlugin", 1, "publishMood exception: " + Log.getStackTraceString(paramPublishMoodInfo));
      }
      str2 = str2 + "?referer=2100";
      break;
      paramPublishMoodInfo = paramPublishMoodInfo.mFootnote;
      break label258;
      paramPublishMoodInfo = str1;
      continue;
      paramPublishMoodInfo = null;
    }
  }
  
  private static void showTip(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    AppBrandTask.runTaskOnUiThread(new SharePlugin.2(paramInt));
  }
  
  public static PublishMoodInfo validMoodInfo(PublishMoodInfo paramPublishMoodInfo)
  {
    int k = 0;
    if (paramPublishMoodInfo == null) {
      return null;
    }
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    localPublishMoodInfo.mTag = paramPublishMoodInfo.mTag;
    localPublishMoodInfo.mPath = paramPublishMoodInfo.mPath;
    localPublishMoodInfo.mFootnote = paramPublishMoodInfo.mFootnote;
    Object localObject1;
    int j;
    int i;
    if ((paramPublishMoodInfo.mText != null) && (!TextUtils.isEmpty(paramPublishMoodInfo.mText)))
    {
      localObject1 = PublishMoodInfo.filterText(paramPublishMoodInfo.mText);
      j = ((String)localObject1).length() - PublishMoodInfo.MOOD_MAX_TEXT_COUNT;
      if (j > 0)
      {
        i = 1;
        paramPublishMoodInfo.mText = paramPublishMoodInfo.mText.substring(0, paramPublishMoodInfo.mText.length() - j);
        QLog.i("[minigame] SharePlugin", 2, "超出" + (((String)localObject1).length() - PublishMoodInfo.MOOD_MAX_TEXT_COUNT) + "个字,截断");
      }
    }
    for (;;)
    {
      localPublishMoodInfo.mText = paramPublishMoodInfo.mText;
      ArrayList localArrayList;
      int m;
      PublishMoodInfo.MediaInfo localMediaInfo;
      Object localObject2;
      if ((paramPublishMoodInfo.mMediaInfo != null) && (paramPublishMoodInfo.mMediaInfo.size() > 0))
      {
        j = i;
        if (paramPublishMoodInfo.mMediaInfo.size() > PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT)
        {
          j = i | 0x20;
          QLog.i("[minigame] SharePlugin", 2, "图片+视频个数超出大小");
        }
        localObject1 = new HashMap();
        localArrayList = new ArrayList();
        paramPublishMoodInfo = paramPublishMoodInfo.mMediaInfo.iterator();
        m = 0;
        i = j;
        j = m;
        for (;;)
        {
          if (paramPublishMoodInfo.hasNext())
          {
            localMediaInfo = (PublishMoodInfo.MediaInfo)paramPublishMoodInfo.next();
            localObject2 = new File(localMediaInfo.mPath);
            if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
              QLog.i("[minigame] SharePlugin", 2, "path is not exist, " + localMediaInfo);
            } else {
              switch (localMediaInfo.mType)
              {
              default: 
                QLog.i("[minigame] SharePlugin", 2, "invalid type" + localMediaInfo);
                label371:
                if (j + k >= PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT)
                {
                  label380:
                  j = i;
                  if (((HashMap)localObject1).size() > 0)
                  {
                    localPublishMoodInfo.mAllImageAndVideo = localArrayList;
                    localPublishMoodInfo.mMediaInfoHashMap = ((HashMap)localObject1);
                  }
                }
                break;
              }
            }
          }
        }
      }
      for (j = i;; j = i)
      {
        showTip(j);
        QLog.i("[minigame] SharePlugin", 2, "tip = " + j);
        return localPublishMoodInfo;
        localObject2 = getPhotoLocalMediaInfoByPath(localMediaInfo.mPath);
        if (localObject2 == null) {
          break label371;
        }
        if (isValidPhoto(((LocalMediaInfo)localObject2).fileSize))
        {
          localArrayList.add(localMediaInfo.mPath);
          ((HashMap)localObject1).put(localMediaInfo.mPath, localObject2);
          j += 1;
        }
        for (;;)
        {
          break;
          i |= 0x2;
          QLog.i("[minigame] SharePlugin", 2, "图片超出大小，" + localMediaInfo);
        }
        if (k >= PublishMoodInfo.MOOD_MAX_VIDEO_COUNT)
        {
          QLog.i("[minigame] SharePlugin", 2, "视频个数超出大小");
          i |= 0x10;
          break;
        }
        localObject2 = getVideoLocalMediaInfoByPath(localMediaInfo.mPath);
        if (localObject2 == null) {
          break label371;
        }
        boolean bool1 = isValidVideoSize(((LocalMediaInfo)localObject2).fileSize);
        boolean bool2 = isValidVideoDuration(((LocalMediaInfo)localObject2).mDuration);
        if ((bool1) && (bool2))
        {
          localArrayList.add(localMediaInfo.mPath);
          ((HashMap)localObject1).put(localMediaInfo.mPath, localObject2);
          k += 1;
        }
        for (;;)
        {
          break;
          m = i;
          if (!bool1) {
            m = i | 0x4;
          }
          i = m;
          if (!bool2) {
            i = m | 0x8;
          }
          QLog.i("[minigame] SharePlugin", 2, "单个视频大小/时长超出, " + localMediaInfo);
        }
        break;
        break label380;
      }
      i = 0;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.i("[minigame] SharePlugin", 2, "handleNativeRequest jsonParams : " + paramString2 + " event:" + paramString1);
    if ((this.jsPluginEngine == null) || (this.jsPluginEngine.appBrandRuntime == null) || (this.jsPluginEngine.appBrandRuntime.activity == null))
    {
      QLog.i("[minigame] SharePlugin", 2, "handle openQzonePublish event, jsPluginEngine == null");
      return "";
    }
    if ("openQzonePublish".equals(paramString1))
    {
      QLog.i("[minigame] SharePlugin", 2, "receive openQzonePublish event");
      PublishMoodInfo localPublishMoodInfo = validMoodInfo(PublishMoodInfo.parseJsonToMoodInfo(paramString2));
      if (localPublishMoodInfo != null) {
        publishMood(this.jsPluginEngine.appBrandRuntime.activity, localPublishMoodInfo);
      }
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SharePlugin
 * JD-Core Version:    0.7.0.1
 */